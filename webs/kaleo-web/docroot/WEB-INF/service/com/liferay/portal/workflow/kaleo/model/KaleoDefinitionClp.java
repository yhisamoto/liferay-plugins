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

package com.liferay.portal.workflow.kaleo.model;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.liferay.util.LocalizationUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * <a href="KaleoDefinitionClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 */
public class KaleoDefinitionClp extends BaseModelImpl<KaleoDefinition>
	implements KaleoDefinition {
	public KaleoDefinitionClp() {
	}

	public long getPrimaryKey() {
		return _kaleoDefinitionId;
	}

	public void setPrimaryKey(long pk) {
		setKaleoDefinitionId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_kaleoDefinitionId);
	}

	public long getKaleoDefinitionId() {
		return _kaleoDefinitionId;
	}

	public void setKaleoDefinitionId(long kaleoDefinitionId) {
		_kaleoDefinitionId = kaleoDefinitionId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getTitle() {
		return _title;
	}

	public String getTitle(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getTitle(languageId);
	}

	public String getTitle(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getTitle(languageId, useDefault);
	}

	public String getTitle(String languageId) {
		String value = LocalizationUtil.getLocalization(getTitle(), languageId);

		if (isEscapedModel()) {
			return HtmlUtil.escape(value);
		}
		else {
			return value;
		}
	}

	public String getTitle(String languageId, boolean useDefault) {
		String value = LocalizationUtil.getLocalization(getTitle(), languageId,
				useDefault);

		if (isEscapedModel()) {
			return HtmlUtil.escape(value);
		}
		else {
			return value;
		}
	}

	public Map<Locale, String> getTitleMap() {
		return LocalizationUtil.getLocalizationMap(getTitle());
	}

	public void setTitle(String title) {
		_title = title;
	}

	public void setTitle(Locale locale, String title) {
		String languageId = LocaleUtil.toLanguageId(locale);

		if (Validator.isNotNull(title)) {
			setTitle(LocalizationUtil.updateLocalization(getTitle(), "Title",
					title, languageId));
		}
		else {
			setTitle(LocalizationUtil.removeLocalization(getTitle(), "Title",
					languageId));
		}
	}

	public void setTitleMap(Map<Locale, String> titleMap) {
		if (titleMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			Locale[] locales = LanguageUtil.getAvailableLocales();

			for (Locale locale : locales) {
				String title = titleMap.get(locale);

				setTitle(locale, title);
			}
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getVersion() {
		return _version;
	}

	public void setVersion(int version) {
		_version = version;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public long getStartKaleoNodeId() {
		return _startKaleoNodeId;
	}

	public void setStartKaleoNodeId(long startKaleoNodeId) {
		_startKaleoNodeId = startKaleoNodeId;
	}

	public com.liferay.portal.workflow.kaleo.model.KaleoNode getKaleoStartNode() {
		throw new UnsupportedOperationException();
	}

	public KaleoDefinition toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			KaleoDefinition model = new KaleoDefinitionClp();

			model.setEscapedModel(true);

			model.setKaleoDefinitionId(getKaleoDefinitionId());
			model.setCompanyId(getCompanyId());
			model.setUserId(getUserId());
			model.setUserName(HtmlUtil.escape(getUserName()));
			model.setCreateDate(getCreateDate());
			model.setModifiedDate(getModifiedDate());
			model.setName(HtmlUtil.escape(getName()));
			model.setTitle(HtmlUtil.escape(getTitle()));
			model.setDescription(HtmlUtil.escape(getDescription()));
			model.setVersion(getVersion());
			model.setActive(getActive());
			model.setStartKaleoNodeId(getStartKaleoNodeId());

			model = (KaleoDefinition)Proxy.newProxyInstance(KaleoDefinition.class.getClassLoader(),
					new Class[] { KaleoDefinition.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		KaleoDefinitionClp clone = new KaleoDefinitionClp();

		clone.setKaleoDefinitionId(getKaleoDefinitionId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setName(getName());
		clone.setTitle(getTitle());
		clone.setDescription(getDescription());
		clone.setVersion(getVersion());
		clone.setActive(getActive());
		clone.setStartKaleoNodeId(getStartKaleoNodeId());

		return clone;
	}

	public int compareTo(KaleoDefinition kaleoDefinition) {
		int value = 0;

		if (getVersion() < kaleoDefinition.getVersion()) {
			value = -1;
		}
		else if (getVersion() > kaleoDefinition.getVersion()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		KaleoDefinitionClp kaleoDefinition = null;

		try {
			kaleoDefinition = (KaleoDefinitionClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = kaleoDefinition.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{kaleoDefinitionId=");
		sb.append(getKaleoDefinitionId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append(", active=");
		sb.append(getActive());
		sb.append(", startKaleoNodeId=");
		sb.append(getStartKaleoNodeId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.workflow.kaleo.model.KaleoDefinition");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>kaleoDefinitionId</column-name><column-value><![CDATA[");
		sb.append(getKaleoDefinitionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startKaleoNodeId</column-name><column-value><![CDATA[");
		sb.append(getStartKaleoNodeId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _kaleoDefinitionId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _title;
	private String _description;
	private int _version;
	private boolean _active;
	private long _startKaleoNodeId;
}