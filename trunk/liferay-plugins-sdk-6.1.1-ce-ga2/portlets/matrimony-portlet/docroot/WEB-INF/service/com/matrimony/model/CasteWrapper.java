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
 * This class is a wrapper for {@link Caste}.
 * </p>
 *
 * @author    matrimony
 * @see       Caste
 * @generated
 */
public class CasteWrapper implements Caste, ModelWrapper<Caste> {
	public CasteWrapper(Caste caste) {
		_caste = caste;
	}

	public Class<?> getModelClass() {
		return Caste.class;
	}

	public String getModelClassName() {
		return Caste.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("casteId", getCasteId());
		attributes.put("religionId", getReligionId());
		attributes.put("name", getName());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long casteId = (Long)attributes.get("casteId");

		if (casteId != null) {
			setCasteId(casteId);
		}

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
	* Returns the primary key of this caste.
	*
	* @return the primary key of this caste
	*/
	public long getPrimaryKey() {
		return _caste.getPrimaryKey();
	}

	/**
	* Sets the primary key of this caste.
	*
	* @param primaryKey the primary key of this caste
	*/
	public void setPrimaryKey(long primaryKey) {
		_caste.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the caste ID of this caste.
	*
	* @return the caste ID of this caste
	*/
	public long getCasteId() {
		return _caste.getCasteId();
	}

	/**
	* Sets the caste ID of this caste.
	*
	* @param casteId the caste ID of this caste
	*/
	public void setCasteId(long casteId) {
		_caste.setCasteId(casteId);
	}

	/**
	* Returns the religion ID of this caste.
	*
	* @return the religion ID of this caste
	*/
	public long getReligionId() {
		return _caste.getReligionId();
	}

	/**
	* Sets the religion ID of this caste.
	*
	* @param religionId the religion ID of this caste
	*/
	public void setReligionId(long religionId) {
		_caste.setReligionId(religionId);
	}

	/**
	* Returns the name of this caste.
	*
	* @return the name of this caste
	*/
	public java.lang.String getName() {
		return _caste.getName();
	}

	/**
	* Sets the name of this caste.
	*
	* @param name the name of this caste
	*/
	public void setName(java.lang.String name) {
		_caste.setName(name);
	}

	public boolean isNew() {
		return _caste.isNew();
	}

	public void setNew(boolean n) {
		_caste.setNew(n);
	}

	public boolean isCachedModel() {
		return _caste.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_caste.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _caste.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _caste.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_caste.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _caste.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_caste.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CasteWrapper((Caste)_caste.clone());
	}

	public int compareTo(com.matrimony.model.Caste caste) {
		return _caste.compareTo(caste);
	}

	@Override
	public int hashCode() {
		return _caste.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.matrimony.model.Caste> toCacheModel() {
		return _caste.toCacheModel();
	}

	public com.matrimony.model.Caste toEscapedModel() {
		return new CasteWrapper(_caste.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _caste.toString();
	}

	public java.lang.String toXmlString() {
		return _caste.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_caste.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Caste getWrappedCaste() {
		return _caste;
	}

	public Caste getWrappedModel() {
		return _caste;
	}

	public void resetOriginalValues() {
		_caste.resetOriginalValues();
	}

	private Caste _caste;
}