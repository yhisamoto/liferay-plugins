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

package com.liferay.portal.workflow.kaleo.service.base;

import com.liferay.counter.service.CounterLocalService;
import com.liferay.counter.service.CounterService;

import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.workflow.kaleo.model.KaleoNode;
import com.liferay.portal.workflow.kaleo.service.KaleoActionLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoDefinitionLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoInstanceLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoInstanceTokenLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoLogLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoNodeLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoNotificationLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoNotificationRecipientLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoTaskAssignmentLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoTaskInstanceAssignmentLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoTaskInstanceTokenLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoTaskLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoTransitionLocalService;
import com.liferay.portal.workflow.kaleo.service.persistence.KaleoActionPersistence;
import com.liferay.portal.workflow.kaleo.service.persistence.KaleoDefinitionPersistence;
import com.liferay.portal.workflow.kaleo.service.persistence.KaleoInstancePersistence;
import com.liferay.portal.workflow.kaleo.service.persistence.KaleoInstanceTokenPersistence;
import com.liferay.portal.workflow.kaleo.service.persistence.KaleoLogPersistence;
import com.liferay.portal.workflow.kaleo.service.persistence.KaleoNodePersistence;
import com.liferay.portal.workflow.kaleo.service.persistence.KaleoNotificationPersistence;
import com.liferay.portal.workflow.kaleo.service.persistence.KaleoNotificationRecipientPersistence;
import com.liferay.portal.workflow.kaleo.service.persistence.KaleoTaskAssignmentPersistence;
import com.liferay.portal.workflow.kaleo.service.persistence.KaleoTaskInstanceAssignmentPersistence;
import com.liferay.portal.workflow.kaleo.service.persistence.KaleoTaskInstanceTokenPersistence;
import com.liferay.portal.workflow.kaleo.service.persistence.KaleoTaskPersistence;
import com.liferay.portal.workflow.kaleo.service.persistence.KaleoTransitionPersistence;

import java.util.List;

/**
 * <a href="KaleoNodeLocalServiceBaseImpl.java.html"><b><i>View Source</i></b>
 * </a>
 *
 * @author Brian Wing Shun Chan
 */
public abstract class KaleoNodeLocalServiceBaseImpl
	implements KaleoNodeLocalService {
	public KaleoNode addKaleoNode(KaleoNode kaleoNode)
		throws SystemException {
		kaleoNode.setNew(true);

		return kaleoNodePersistence.update(kaleoNode, false);
	}

	public KaleoNode createKaleoNode(long kaleoNodeId) {
		return kaleoNodePersistence.create(kaleoNodeId);
	}

	public void deleteKaleoNode(long kaleoNodeId)
		throws PortalException, SystemException {
		kaleoNodePersistence.remove(kaleoNodeId);
	}

	public void deleteKaleoNode(KaleoNode kaleoNode) throws SystemException {
		kaleoNodePersistence.remove(kaleoNode);
	}

	public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return kaleoNodePersistence.findWithDynamicQuery(dynamicQuery);
	}

	public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) throws SystemException {
		return kaleoNodePersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		return kaleoNodePersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	public int dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return kaleoNodePersistence.countWithDynamicQuery(dynamicQuery);
	}

	public KaleoNode getKaleoNode(long kaleoNodeId)
		throws PortalException, SystemException {
		return kaleoNodePersistence.findByPrimaryKey(kaleoNodeId);
	}

	public List<KaleoNode> getKaleoNodes(int start, int end)
		throws SystemException {
		return kaleoNodePersistence.findAll(start, end);
	}

	public int getKaleoNodesCount() throws SystemException {
		return kaleoNodePersistence.countAll();
	}

	public KaleoNode updateKaleoNode(KaleoNode kaleoNode)
		throws SystemException {
		kaleoNode.setNew(false);

		return kaleoNodePersistence.update(kaleoNode, true);
	}

	public KaleoNode updateKaleoNode(KaleoNode kaleoNode, boolean merge)
		throws SystemException {
		kaleoNode.setNew(false);

		return kaleoNodePersistence.update(kaleoNode, merge);
	}

	public KaleoActionLocalService getKaleoActionLocalService() {
		return kaleoActionLocalService;
	}

	public void setKaleoActionLocalService(
		KaleoActionLocalService kaleoActionLocalService) {
		this.kaleoActionLocalService = kaleoActionLocalService;
	}

	public KaleoActionPersistence getKaleoActionPersistence() {
		return kaleoActionPersistence;
	}

	public void setKaleoActionPersistence(
		KaleoActionPersistence kaleoActionPersistence) {
		this.kaleoActionPersistence = kaleoActionPersistence;
	}

	public KaleoDefinitionLocalService getKaleoDefinitionLocalService() {
		return kaleoDefinitionLocalService;
	}

	public void setKaleoDefinitionLocalService(
		KaleoDefinitionLocalService kaleoDefinitionLocalService) {
		this.kaleoDefinitionLocalService = kaleoDefinitionLocalService;
	}

	public KaleoDefinitionPersistence getKaleoDefinitionPersistence() {
		return kaleoDefinitionPersistence;
	}

	public void setKaleoDefinitionPersistence(
		KaleoDefinitionPersistence kaleoDefinitionPersistence) {
		this.kaleoDefinitionPersistence = kaleoDefinitionPersistence;
	}

	public KaleoInstanceLocalService getKaleoInstanceLocalService() {
		return kaleoInstanceLocalService;
	}

	public void setKaleoInstanceLocalService(
		KaleoInstanceLocalService kaleoInstanceLocalService) {
		this.kaleoInstanceLocalService = kaleoInstanceLocalService;
	}

	public KaleoInstancePersistence getKaleoInstancePersistence() {
		return kaleoInstancePersistence;
	}

	public void setKaleoInstancePersistence(
		KaleoInstancePersistence kaleoInstancePersistence) {
		this.kaleoInstancePersistence = kaleoInstancePersistence;
	}

	public KaleoInstanceTokenLocalService getKaleoInstanceTokenLocalService() {
		return kaleoInstanceTokenLocalService;
	}

	public void setKaleoInstanceTokenLocalService(
		KaleoInstanceTokenLocalService kaleoInstanceTokenLocalService) {
		this.kaleoInstanceTokenLocalService = kaleoInstanceTokenLocalService;
	}

	public KaleoInstanceTokenPersistence getKaleoInstanceTokenPersistence() {
		return kaleoInstanceTokenPersistence;
	}

	public void setKaleoInstanceTokenPersistence(
		KaleoInstanceTokenPersistence kaleoInstanceTokenPersistence) {
		this.kaleoInstanceTokenPersistence = kaleoInstanceTokenPersistence;
	}

	public KaleoLogLocalService getKaleoLogLocalService() {
		return kaleoLogLocalService;
	}

	public void setKaleoLogLocalService(
		KaleoLogLocalService kaleoLogLocalService) {
		this.kaleoLogLocalService = kaleoLogLocalService;
	}

	public KaleoLogPersistence getKaleoLogPersistence() {
		return kaleoLogPersistence;
	}

	public void setKaleoLogPersistence(KaleoLogPersistence kaleoLogPersistence) {
		this.kaleoLogPersistence = kaleoLogPersistence;
	}

	public KaleoNodeLocalService getKaleoNodeLocalService() {
		return kaleoNodeLocalService;
	}

	public void setKaleoNodeLocalService(
		KaleoNodeLocalService kaleoNodeLocalService) {
		this.kaleoNodeLocalService = kaleoNodeLocalService;
	}

	public KaleoNodePersistence getKaleoNodePersistence() {
		return kaleoNodePersistence;
	}

	public void setKaleoNodePersistence(
		KaleoNodePersistence kaleoNodePersistence) {
		this.kaleoNodePersistence = kaleoNodePersistence;
	}

	public KaleoNotificationLocalService getKaleoNotificationLocalService() {
		return kaleoNotificationLocalService;
	}

	public void setKaleoNotificationLocalService(
		KaleoNotificationLocalService kaleoNotificationLocalService) {
		this.kaleoNotificationLocalService = kaleoNotificationLocalService;
	}

	public KaleoNotificationPersistence getKaleoNotificationPersistence() {
		return kaleoNotificationPersistence;
	}

	public void setKaleoNotificationPersistence(
		KaleoNotificationPersistence kaleoNotificationPersistence) {
		this.kaleoNotificationPersistence = kaleoNotificationPersistence;
	}

	public KaleoNotificationRecipientLocalService getKaleoNotificationRecipientLocalService() {
		return kaleoNotificationRecipientLocalService;
	}

	public void setKaleoNotificationRecipientLocalService(
		KaleoNotificationRecipientLocalService kaleoNotificationRecipientLocalService) {
		this.kaleoNotificationRecipientLocalService = kaleoNotificationRecipientLocalService;
	}

	public KaleoNotificationRecipientPersistence getKaleoNotificationRecipientPersistence() {
		return kaleoNotificationRecipientPersistence;
	}

	public void setKaleoNotificationRecipientPersistence(
		KaleoNotificationRecipientPersistence kaleoNotificationRecipientPersistence) {
		this.kaleoNotificationRecipientPersistence = kaleoNotificationRecipientPersistence;
	}

	public KaleoTaskLocalService getKaleoTaskLocalService() {
		return kaleoTaskLocalService;
	}

	public void setKaleoTaskLocalService(
		KaleoTaskLocalService kaleoTaskLocalService) {
		this.kaleoTaskLocalService = kaleoTaskLocalService;
	}

	public KaleoTaskPersistence getKaleoTaskPersistence() {
		return kaleoTaskPersistence;
	}

	public void setKaleoTaskPersistence(
		KaleoTaskPersistence kaleoTaskPersistence) {
		this.kaleoTaskPersistence = kaleoTaskPersistence;
	}

	public KaleoTaskAssignmentLocalService getKaleoTaskAssignmentLocalService() {
		return kaleoTaskAssignmentLocalService;
	}

	public void setKaleoTaskAssignmentLocalService(
		KaleoTaskAssignmentLocalService kaleoTaskAssignmentLocalService) {
		this.kaleoTaskAssignmentLocalService = kaleoTaskAssignmentLocalService;
	}

	public KaleoTaskAssignmentPersistence getKaleoTaskAssignmentPersistence() {
		return kaleoTaskAssignmentPersistence;
	}

	public void setKaleoTaskAssignmentPersistence(
		KaleoTaskAssignmentPersistence kaleoTaskAssignmentPersistence) {
		this.kaleoTaskAssignmentPersistence = kaleoTaskAssignmentPersistence;
	}

	public KaleoTaskInstanceAssignmentLocalService getKaleoTaskInstanceAssignmentLocalService() {
		return kaleoTaskInstanceAssignmentLocalService;
	}

	public void setKaleoTaskInstanceAssignmentLocalService(
		KaleoTaskInstanceAssignmentLocalService kaleoTaskInstanceAssignmentLocalService) {
		this.kaleoTaskInstanceAssignmentLocalService = kaleoTaskInstanceAssignmentLocalService;
	}

	public KaleoTaskInstanceAssignmentPersistence getKaleoTaskInstanceAssignmentPersistence() {
		return kaleoTaskInstanceAssignmentPersistence;
	}

	public void setKaleoTaskInstanceAssignmentPersistence(
		KaleoTaskInstanceAssignmentPersistence kaleoTaskInstanceAssignmentPersistence) {
		this.kaleoTaskInstanceAssignmentPersistence = kaleoTaskInstanceAssignmentPersistence;
	}

	public KaleoTaskInstanceTokenLocalService getKaleoTaskInstanceTokenLocalService() {
		return kaleoTaskInstanceTokenLocalService;
	}

	public void setKaleoTaskInstanceTokenLocalService(
		KaleoTaskInstanceTokenLocalService kaleoTaskInstanceTokenLocalService) {
		this.kaleoTaskInstanceTokenLocalService = kaleoTaskInstanceTokenLocalService;
	}

	public KaleoTaskInstanceTokenPersistence getKaleoTaskInstanceTokenPersistence() {
		return kaleoTaskInstanceTokenPersistence;
	}

	public void setKaleoTaskInstanceTokenPersistence(
		KaleoTaskInstanceTokenPersistence kaleoTaskInstanceTokenPersistence) {
		this.kaleoTaskInstanceTokenPersistence = kaleoTaskInstanceTokenPersistence;
	}

	public KaleoTransitionLocalService getKaleoTransitionLocalService() {
		return kaleoTransitionLocalService;
	}

	public void setKaleoTransitionLocalService(
		KaleoTransitionLocalService kaleoTransitionLocalService) {
		this.kaleoTransitionLocalService = kaleoTransitionLocalService;
	}

	public KaleoTransitionPersistence getKaleoTransitionPersistence() {
		return kaleoTransitionPersistence;
	}

	public void setKaleoTransitionPersistence(
		KaleoTransitionPersistence kaleoTransitionPersistence) {
		this.kaleoTransitionPersistence = kaleoTransitionPersistence;
	}

	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	public CounterService getCounterService() {
		return counterService;
	}

	public void setCounterService(CounterService counterService) {
		this.counterService = counterService;
	}

	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	public ResourceService getResourceService() {
		return resourceService;
	}

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	protected void runSQL(String sql) throws SystemException {
		try {
			DB db = DBFactoryUtil.getDB();

			db.runSQL(sql);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = KaleoActionLocalService.class)
	protected KaleoActionLocalService kaleoActionLocalService;
	@BeanReference(type = KaleoActionPersistence.class)
	protected KaleoActionPersistence kaleoActionPersistence;
	@BeanReference(type = KaleoDefinitionLocalService.class)
	protected KaleoDefinitionLocalService kaleoDefinitionLocalService;
	@BeanReference(type = KaleoDefinitionPersistence.class)
	protected KaleoDefinitionPersistence kaleoDefinitionPersistence;
	@BeanReference(type = KaleoInstanceLocalService.class)
	protected KaleoInstanceLocalService kaleoInstanceLocalService;
	@BeanReference(type = KaleoInstancePersistence.class)
	protected KaleoInstancePersistence kaleoInstancePersistence;
	@BeanReference(type = KaleoInstanceTokenLocalService.class)
	protected KaleoInstanceTokenLocalService kaleoInstanceTokenLocalService;
	@BeanReference(type = KaleoInstanceTokenPersistence.class)
	protected KaleoInstanceTokenPersistence kaleoInstanceTokenPersistence;
	@BeanReference(type = KaleoLogLocalService.class)
	protected KaleoLogLocalService kaleoLogLocalService;
	@BeanReference(type = KaleoLogPersistence.class)
	protected KaleoLogPersistence kaleoLogPersistence;
	@BeanReference(type = KaleoNodeLocalService.class)
	protected KaleoNodeLocalService kaleoNodeLocalService;
	@BeanReference(type = KaleoNodePersistence.class)
	protected KaleoNodePersistence kaleoNodePersistence;
	@BeanReference(type = KaleoNotificationLocalService.class)
	protected KaleoNotificationLocalService kaleoNotificationLocalService;
	@BeanReference(type = KaleoNotificationPersistence.class)
	protected KaleoNotificationPersistence kaleoNotificationPersistence;
	@BeanReference(type = KaleoNotificationRecipientLocalService.class)
	protected KaleoNotificationRecipientLocalService kaleoNotificationRecipientLocalService;
	@BeanReference(type = KaleoNotificationRecipientPersistence.class)
	protected KaleoNotificationRecipientPersistence kaleoNotificationRecipientPersistence;
	@BeanReference(type = KaleoTaskLocalService.class)
	protected KaleoTaskLocalService kaleoTaskLocalService;
	@BeanReference(type = KaleoTaskPersistence.class)
	protected KaleoTaskPersistence kaleoTaskPersistence;
	@BeanReference(type = KaleoTaskAssignmentLocalService.class)
	protected KaleoTaskAssignmentLocalService kaleoTaskAssignmentLocalService;
	@BeanReference(type = KaleoTaskAssignmentPersistence.class)
	protected KaleoTaskAssignmentPersistence kaleoTaskAssignmentPersistence;
	@BeanReference(type = KaleoTaskInstanceAssignmentLocalService.class)
	protected KaleoTaskInstanceAssignmentLocalService kaleoTaskInstanceAssignmentLocalService;
	@BeanReference(type = KaleoTaskInstanceAssignmentPersistence.class)
	protected KaleoTaskInstanceAssignmentPersistence kaleoTaskInstanceAssignmentPersistence;
	@BeanReference(type = KaleoTaskInstanceTokenLocalService.class)
	protected KaleoTaskInstanceTokenLocalService kaleoTaskInstanceTokenLocalService;
	@BeanReference(type = KaleoTaskInstanceTokenPersistence.class)
	protected KaleoTaskInstanceTokenPersistence kaleoTaskInstanceTokenPersistence;
	@BeanReference(type = KaleoTransitionLocalService.class)
	protected KaleoTransitionLocalService kaleoTransitionLocalService;
	@BeanReference(type = KaleoTransitionPersistence.class)
	protected KaleoTransitionPersistence kaleoTransitionPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = CounterService.class)
	protected CounterService counterService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}