/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.knowledgebase.admin.messaging;

import com.liferay.knowledgebase.model.Article;
import com.liferay.knowledgebase.service.ArticleLocalServiceUtil;
import com.liferay.knowledgebase.service.permission.ArticlePermission;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Subscription;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.SubscriptionLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.mail.internet.InternetAddress;

/**
 * <a href="AdminMessageListener.java.html"><b><i>View Source</i></b></a>
 *
 * @author Peter Shin
 * @author Brian Wing Shun Chan
 */
public class AdminMessageListener implements MessageListener {

	public void receive(Message message) {
		try {
			doReceive(message);
		}
		catch (Exception e) {
			_log.error("Unable to process message " + message, e);
		}
	}

	public void doReceive(Message message) throws Exception {
		long companyId = message.getLong("companyId");
		long groupId = message.getLong("groupId");
		long userId = message.getLong("userId");
		long resourcePrimKey = message.getLong("resourcePrimKey");
		String fromName = message.getString("fromName");
		String fromAddress = message.getString("fromAddress");
		String subject = message.getString("subject");
		String body = message.getString("body");
		String replyToAddress = message.getString("replyToAddress");
		String mailId = message.getString("mailId");
		boolean htmlFormat = message.getBoolean("htmlFormat");

		Set<Long> sent = new HashSet<Long>();

		if (_log.isInfoEnabled()) {
			_log.info(
				"Sending notifications for {mailId=" + mailId +
					", resourcePrimKey=" + resourcePrimKey + "}");
		}

		// Article

		List<Subscription> subscriptions =
			SubscriptionLocalServiceUtil.getSubscriptions(
				companyId, Article.class.getName(), resourcePrimKey);

		sendEmail(
			userId, resourcePrimKey, fromName, fromAddress, subject, body,
			subscriptions, sent, replyToAddress, mailId, htmlFormat);

		Article article = ArticleLocalServiceUtil.getLatestArticle(
			resourcePrimKey);

		while (article.getParentResourcePrimKey() > 0) {
			article = ArticleLocalServiceUtil.getLatestArticle(
				article.getParentResourcePrimKey());

			subscriptions = SubscriptionLocalServiceUtil.getSubscriptions(
				companyId, Article.class.getName(),
				article.getResourcePrimKey());

			sendEmail(
				userId, resourcePrimKey, fromName, fromAddress, subject, body,
				subscriptions, sent, replyToAddress, mailId, htmlFormat);
		}

		// Articles

		subscriptions = SubscriptionLocalServiceUtil.getSubscriptions(
			companyId, Article.class.getName(), groupId);

		sendEmail(
			userId, resourcePrimKey, fromName, fromAddress, subject, body,
			subscriptions, sent, replyToAddress, mailId, htmlFormat);

		if (_log.isInfoEnabled()) {
			_log.info("Finished sending notifications");
		}
	}

	protected void sendEmail(
			long userId, long resourcePrimKey, String fromName,
			String fromAddress, String subject, String body,
			List<Subscription> subscriptions, Set<Long> sent,
			String replyToAddress, String mailId, boolean htmlFormat)
		throws Exception {

		for (Subscription subscription : subscriptions) {
			long subscribedUserId = subscription.getUserId();

			if (sent.contains(subscribedUserId)) {
				if (_log.isDebugEnabled()) {
					_log.debug(
						"Do not send a duplicate email to user " +
							subscribedUserId);
				}

				continue;
			}
			else {
				if (_log.isDebugEnabled()) {
					_log.debug(
						"Add user " + subscribedUserId +
							" to the list of users who have received an email");
				}

				sent.add(subscribedUserId);
			}

			User user = null;

			try {
				user = UserLocalServiceUtil.getUserById(
					subscription.getUserId());
			}
			catch (NoSuchUserException nsue) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Subscription " + subscription.getSubscriptionId() +
							" is stale and will be deleted");
				}

				SubscriptionLocalServiceUtil.deleteSubscription(
					subscription.getSubscriptionId());

				continue;
			}

			if (!user.isActive()) {
				continue;
			}

			PrincipalThreadLocal.setName(user.getUserId());

			PermissionChecker permissionChecker =
				PermissionCheckerFactoryUtil.create(user, true);

			PermissionThreadLocal.setPermissionChecker(permissionChecker);

			try {
				if (!ArticlePermission.contains(
						permissionChecker, resourcePrimKey, ActionKeys.VIEW)) {

					if (_log.isInfoEnabled()) {
						_log.info(
							"User " + user.getUserId() +
								" does not have view permission");
					}

					continue;
				}
			}
			finally {
				PrincipalThreadLocal.setName(null);
				PermissionThreadLocal.setPermissionChecker(null);
			}

			try {
				InternetAddress from = new InternetAddress(
					fromAddress, fromName);

				InternetAddress to = new InternetAddress(
					user.getEmailAddress(), user.getFullName());

				InternetAddress replyTo = new InternetAddress(
					replyToAddress, replyToAddress);

				String curSubject = StringUtil.replace(
					subject,
					new String[] {
						"[$TO_ADDRESS$]",
						"[$TO_NAME$]"
					},
					new String[] {
						user.getEmailAddress(),
						user.getFullName()
					});

				String curBody = StringUtil.replace(
					body,
					new String[] {
						"[$TO_ADDRESS$]",
						"[$TO_NAME$]"
					},
					new String[] {
						user.getEmailAddress(),
						user.getFullName()
					});

				MailMessage message = new MailMessage(
					from, to, curSubject, curBody, htmlFormat);

				message.setReplyTo(new InternetAddress[] {replyTo});
				message.setMessageId(mailId);

				MailServiceUtil.sendEmail(message);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	private static Log _log = LogFactoryUtil.getLog(AdminMessageListener.class);

}