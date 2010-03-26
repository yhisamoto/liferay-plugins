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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="KaleoTaskInstanceAssignmentSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * {@link com.liferay.portal.workflow.kaleo.service.http.KaleoTaskInstanceAssignmentServiceSoap}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       com.liferay.portal.workflow.kaleo.service.http.KaleoTaskInstanceAssignmentServiceSoap
 * @generated
 */
public class KaleoTaskInstanceAssignmentSoap implements Serializable {
	public static KaleoTaskInstanceAssignmentSoap toSoapModel(
		KaleoTaskInstanceAssignment model) {
		KaleoTaskInstanceAssignmentSoap soapModel = new KaleoTaskInstanceAssignmentSoap();

		soapModel.setKaleoTaskInstanceAssignmentId(model.getKaleoTaskInstanceAssignmentId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setKaleoTaskInstanceTokenId(model.getKaleoTaskInstanceTokenId());
		soapModel.setKaleoTaskId(model.getKaleoTaskId());
		soapModel.setAssigneeClassName(model.getAssigneeClassName());
		soapModel.setAssigneeClassPK(model.getAssigneeClassPK());
		soapModel.setCompletionDate(model.getCompletionDate());
		soapModel.setContext(model.getContext());

		return soapModel;
	}

	public static KaleoTaskInstanceAssignmentSoap[] toSoapModels(
		KaleoTaskInstanceAssignment[] models) {
		KaleoTaskInstanceAssignmentSoap[] soapModels = new KaleoTaskInstanceAssignmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static KaleoTaskInstanceAssignmentSoap[][] toSoapModels(
		KaleoTaskInstanceAssignment[][] models) {
		KaleoTaskInstanceAssignmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new KaleoTaskInstanceAssignmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new KaleoTaskInstanceAssignmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static KaleoTaskInstanceAssignmentSoap[] toSoapModels(
		List<KaleoTaskInstanceAssignment> models) {
		List<KaleoTaskInstanceAssignmentSoap> soapModels = new ArrayList<KaleoTaskInstanceAssignmentSoap>(models.size());

		for (KaleoTaskInstanceAssignment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new KaleoTaskInstanceAssignmentSoap[soapModels.size()]);
	}

	public KaleoTaskInstanceAssignmentSoap() {
	}

	public long getPrimaryKey() {
		return _kaleoTaskInstanceAssignmentId;
	}

	public void setPrimaryKey(long pk) {
		setKaleoTaskInstanceAssignmentId(pk);
	}

	public long getKaleoTaskInstanceAssignmentId() {
		return _kaleoTaskInstanceAssignmentId;
	}

	public void setKaleoTaskInstanceAssignmentId(
		long kaleoTaskInstanceAssignmentId) {
		_kaleoTaskInstanceAssignmentId = kaleoTaskInstanceAssignmentId;
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

	public long getKaleoTaskInstanceTokenId() {
		return _kaleoTaskInstanceTokenId;
	}

	public void setKaleoTaskInstanceTokenId(long kaleoTaskInstanceTokenId) {
		_kaleoTaskInstanceTokenId = kaleoTaskInstanceTokenId;
	}

	public long getKaleoTaskId() {
		return _kaleoTaskId;
	}

	public void setKaleoTaskId(long kaleoTaskId) {
		_kaleoTaskId = kaleoTaskId;
	}

	public String getAssigneeClassName() {
		return _assigneeClassName;
	}

	public void setAssigneeClassName(String assigneeClassName) {
		_assigneeClassName = assigneeClassName;
	}

	public long getAssigneeClassPK() {
		return _assigneeClassPK;
	}

	public void setAssigneeClassPK(long assigneeClassPK) {
		_assigneeClassPK = assigneeClassPK;
	}

	public Date getCompletionDate() {
		return _completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		_completionDate = completionDate;
	}

	public String getContext() {
		return _context;
	}

	public void setContext(String context) {
		_context = context;
	}

	private long _kaleoTaskInstanceAssignmentId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _kaleoTaskInstanceTokenId;
	private long _kaleoTaskId;
	private String _assigneeClassName;
	private long _assigneeClassPK;
	private Date _completionDate;
	private String _context;
}