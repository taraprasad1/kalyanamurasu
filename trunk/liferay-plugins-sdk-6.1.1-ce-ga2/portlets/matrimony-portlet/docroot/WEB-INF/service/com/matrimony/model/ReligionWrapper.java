/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.matrimony.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Religion}.
 * </p>
 *
 * @author    matrimony
 * @see       Religion
 * @generated
 */
public class ReligionWrapper implements Religion, ModelWrapper<Religion> {
	public ReligionWrapper(Religion religion) {
		_religion = religion;
	}

	public Class<?> getModelClass() {
		return Religion.class;
	}

	public String getModelClassName() {
		return Religion.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("religionId", getReligionId());
		attributes.put("name", getName());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long religionId = (Long)attributes.get("religionId");

		if (religionId != null) {
			setReligionId(religionId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	* Returns the primary key of this religion.
	*
	* @return the primary key of this religion
	*/
	public long getPrimaryKey() {
		return _religion.getPrimaryKey();
	}

	/**
	* Sets the primary key of this religion.
	*
	* @param primaryKey the primary key of this religion
	*/
	public void setPrimaryKey(long primaryKey) {
		_religion.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the religion ID of this religion.
	*
	* @return the religion ID of this religion
	*/
	public long getReligionId() {
		return _religion.getReligionId();
	}

	/**
	* Sets the religion ID of this religion.
	*
	* @param religionId the religion ID of this religion
	*/
	public void setReligionId(long religionId) {
		_religion.setReligionId(religionId);
	}

	/**
	* Returns the name of this religion.
	*
	* @return the name of this religion
	*/
	public java.lang.String getName() {
		return _religion.getName();
	}

	/**
	* Sets the name of this religion.
	*
	* @param name the name of this religion
	*/
	public void setName(java.lang.String name) {
		_religion.setName(name);
	}

	public boolean isNew() {
		return _religion.isNew();
	}

	public void setNew(boolean n) {
		_religion.setNew(n);
	}

	public boolean isCachedModel() {
		return _religion.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_religion.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _religion.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _religion.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_religion.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _religion.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_religion.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ReligionWrapper((Religion)_religion.clone());
	}

	public int compareTo(com.matrimony.model.Religion religion) {
		return _religion.compareTo(religion);
	}

	@Override
	public int hashCode() {
		return _religion.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.matrimony.model.Religion> toCacheModel() {
		return _religion.toCacheModel();
	}

	public com.matrimony.model.Religion toEscapedModel() {
		return new ReligionWrapper(_religion.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _religion.toString();
	}

	public java.lang.String toXmlString() {
		return _religion.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_religion.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Religion getWrappedReligion() {
		return _religion;
	}

	public Religion getWrappedModel() {
		return _religion;
	}

	public void resetOriginalValues() {
		_religion.resetOriginalValues();
	}

	private Religion _religion;
}