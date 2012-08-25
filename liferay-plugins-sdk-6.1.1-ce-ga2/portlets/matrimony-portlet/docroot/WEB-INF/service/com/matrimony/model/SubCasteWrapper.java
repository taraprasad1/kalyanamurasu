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
 * This class is a wrapper for {@link SubCaste}.
 * </p>
 *
 * @author    matrimony
 * @see       SubCaste
 * @generated
 */
public class SubCasteWrapper implements SubCaste, ModelWrapper<SubCaste> {
	public SubCasteWrapper(SubCaste subCaste) {
		_subCaste = subCaste;
	}

	public Class<?> getModelClass() {
		return SubCaste.class;
	}

	public String getModelClassName() {
		return SubCaste.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("subCasteId", getSubCasteId());
		attributes.put("casteId", getCasteId());
		attributes.put("name", getName());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long subCasteId = (Long)attributes.get("subCasteId");

		if (subCasteId != null) {
			setSubCasteId(subCasteId);
		}

		Long casteId = (Long)attributes.get("casteId");

		if (casteId != null) {
			setCasteId(casteId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	* Returns the primary key of this sub caste.
	*
	* @return the primary key of this sub caste
	*/
	public long getPrimaryKey() {
		return _subCaste.getPrimaryKey();
	}

	/**
	* Sets the primary key of this sub caste.
	*
	* @param primaryKey the primary key of this sub caste
	*/
	public void setPrimaryKey(long primaryKey) {
		_subCaste.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sub caste ID of this sub caste.
	*
	* @return the sub caste ID of this sub caste
	*/
	public long getSubCasteId() {
		return _subCaste.getSubCasteId();
	}

	/**
	* Sets the sub caste ID of this sub caste.
	*
	* @param subCasteId the sub caste ID of this sub caste
	*/
	public void setSubCasteId(long subCasteId) {
		_subCaste.setSubCasteId(subCasteId);
	}

	/**
	* Returns the caste ID of this sub caste.
	*
	* @return the caste ID of this sub caste
	*/
	public long getCasteId() {
		return _subCaste.getCasteId();
	}

	/**
	* Sets the caste ID of this sub caste.
	*
	* @param casteId the caste ID of this sub caste
	*/
	public void setCasteId(long casteId) {
		_subCaste.setCasteId(casteId);
	}

	/**
	* Returns the name of this sub caste.
	*
	* @return the name of this sub caste
	*/
	public java.lang.String getName() {
		return _subCaste.getName();
	}

	/**
	* Sets the name of this sub caste.
	*
	* @param name the name of this sub caste
	*/
	public void setName(java.lang.String name) {
		_subCaste.setName(name);
	}

	public boolean isNew() {
		return _subCaste.isNew();
	}

	public void setNew(boolean n) {
		_subCaste.setNew(n);
	}

	public boolean isCachedModel() {
		return _subCaste.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_subCaste.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _subCaste.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _subCaste.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_subCaste.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _subCaste.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_subCaste.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SubCasteWrapper((SubCaste)_subCaste.clone());
	}

	public int compareTo(com.matrimony.model.SubCaste subCaste) {
		return _subCaste.compareTo(subCaste);
	}

	@Override
	public int hashCode() {
		return _subCaste.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.matrimony.model.SubCaste> toCacheModel() {
		return _subCaste.toCacheModel();
	}

	public com.matrimony.model.SubCaste toEscapedModel() {
		return new SubCasteWrapper(_subCaste.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _subCaste.toString();
	}

	public java.lang.String toXmlString() {
		return _subCaste.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_subCaste.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public SubCaste getWrappedSubCaste() {
		return _subCaste;
	}

	public SubCaste getWrappedModel() {
		return _subCaste;
	}

	public void resetOriginalValues() {
		_subCaste.resetOriginalValues();
	}

	private SubCaste _subCaste;
}