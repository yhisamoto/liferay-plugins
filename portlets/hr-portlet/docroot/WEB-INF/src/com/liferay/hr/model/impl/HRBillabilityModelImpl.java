/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.liferay.hr.model.impl;

import com.liferay.hr.model.HRBillability;
import com.liferay.hr.model.HRBillabilityModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.Date;

/**
 * The base model implementation for the HRBillability service. Represents a row in the &quot;HRBillability&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.hr.model.HRBillabilityModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link HRBillabilityImpl}.
 * </p>
 *
 * @author Wesley Gong
 * @see HRBillabilityImpl
 * @see com.liferay.hr.model.HRBillability
 * @see com.liferay.hr.model.HRBillabilityModel
 * @generated
 */
public class HRBillabilityModelImpl extends BaseModelImpl<HRBillability>
	implements HRBillabilityModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a h r billability model instance should use the {@link com.liferay.hr.model.HRBillability} interface instead.
	 */
	public static final String TABLE_NAME = "HRBillability";
	public static final Object[][] TABLE_COLUMNS = {
			{ "hrBillabilityId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "code_", Types.VARCHAR },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table HRBillability (hrBillabilityId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,code_ VARCHAR(75) null,name VARCHAR(75) null,description VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table HRBillability";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.hr.model.HRBillability"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.hr.model.HRBillability"),
			true);

	public Class<?> getModelClass() {
		return HRBillability.class;
	}

	public String getModelClassName() {
		return HRBillability.class.getName();
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.hr.model.HRBillability"));

	public HRBillabilityModelImpl() {
	}

	public long getPrimaryKey() {
		return _hrBillabilityId;
	}

	public void setPrimaryKey(long primaryKey) {
		setHrBillabilityId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_hrBillabilityId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getHrBillabilityId() {
		return _hrBillabilityId;
	}

	public void setHrBillabilityId(long hrBillabilityId) {
		_hrBillabilityId = hrBillabilityId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
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
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
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

	public String getCode() {
		if (_code == null) {
			return StringPool.BLANK;
		}
		else {
			return _code;
		}
	}

	public void setCode(String code) {
		if (_originalCode == null) {
			_originalCode = _code;
		}

		_code = code;
	}

	public String getOriginalCode() {
		return GetterUtil.getString(_originalCode);
	}

	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public HRBillability toEscapedModel() {
		if (isEscapedModel()) {
			return (HRBillability)this;
		}
		else {
			if (_escapedModelProxy == null) {
				_escapedModelProxy = (HRBillability)Proxy.newProxyInstance(_classLoader,
						_escapedModelProxyInterfaces,
						new AutoEscapeBeanHandler(this));
			}

			return _escapedModelProxy;
		}
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					HRBillability.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		HRBillabilityImpl hrBillabilityImpl = new HRBillabilityImpl();

		hrBillabilityImpl.setHrBillabilityId(getHrBillabilityId());
		hrBillabilityImpl.setGroupId(getGroupId());
		hrBillabilityImpl.setCompanyId(getCompanyId());
		hrBillabilityImpl.setUserId(getUserId());
		hrBillabilityImpl.setUserName(getUserName());
		hrBillabilityImpl.setCreateDate(getCreateDate());
		hrBillabilityImpl.setModifiedDate(getModifiedDate());
		hrBillabilityImpl.setCode(getCode());
		hrBillabilityImpl.setName(getName());
		hrBillabilityImpl.setDescription(getDescription());

		hrBillabilityImpl.resetOriginalValues();

		return hrBillabilityImpl;
	}

	public int compareTo(HRBillability hrBillability) {
		long primaryKey = hrBillability.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		HRBillability hrBillability = null;

		try {
			hrBillability = (HRBillability)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = hrBillability.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		HRBillabilityModelImpl hrBillabilityModelImpl = this;

		hrBillabilityModelImpl._originalGroupId = hrBillabilityModelImpl._groupId;

		hrBillabilityModelImpl._setOriginalGroupId = false;

		hrBillabilityModelImpl._originalCode = hrBillabilityModelImpl._code;
	}

	@Override
	public CacheModel<HRBillability> toCacheModel() {
		HRBillabilityCacheModel hrBillabilityCacheModel = new HRBillabilityCacheModel();

		hrBillabilityCacheModel.hrBillabilityId = getHrBillabilityId();

		hrBillabilityCacheModel.groupId = getGroupId();

		hrBillabilityCacheModel.companyId = getCompanyId();

		hrBillabilityCacheModel.userId = getUserId();

		hrBillabilityCacheModel.userName = getUserName();

		String userName = hrBillabilityCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			hrBillabilityCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			hrBillabilityCacheModel.createDate = createDate.getTime();
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			hrBillabilityCacheModel.modifiedDate = modifiedDate.getTime();
		}

		hrBillabilityCacheModel.code = getCode();

		String code = hrBillabilityCacheModel.code;

		if ((code != null) && (code.length() == 0)) {
			hrBillabilityCacheModel.code = null;
		}

		hrBillabilityCacheModel.name = getName();

		String name = hrBillabilityCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			hrBillabilityCacheModel.name = null;
		}

		hrBillabilityCacheModel.description = getDescription();

		String description = hrBillabilityCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			hrBillabilityCacheModel.description = null;
		}

		return hrBillabilityCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{hrBillabilityId=");
		sb.append(getHrBillabilityId());
		sb.append(", groupId=");
		sb.append(getGroupId());
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
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.liferay.hr.model.HRBillability");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>hrBillabilityId</column-name><column-value><![CDATA[");
		sb.append(getHrBillabilityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
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
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = HRBillability.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			HRBillability.class
		};
	private long _hrBillabilityId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _code;
	private String _originalCode;
	private String _name;
	private String _description;
	private transient ExpandoBridge _expandoBridge;
	private HRBillability _escapedModelProxy;
}