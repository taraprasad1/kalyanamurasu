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
 * This class is a wrapper for {@link ProfileKeyValue}.
 * </p>
 *
 * @author    matrimony
 * @see       ProfileKeyValue
 * @generated
 */
public class ProfileKeyValueWrapper implements ProfileKeyValue,
	ModelWrapper<ProfileKeyValue> {
	public ProfileKeyValueWrapper(ProfileKeyValue profileKeyValue) {
		_profileKeyValue = profileKeyValue;
	}

	public Class<?> getModelClass() {
		return ProfileKeyValue.class;
	}

	public String getModelClassName() {
		return ProfileKeyValue.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("profileId", getProfileId());
		attributes.put("keyId", getKeyId());
		attributes.put("valueId", getValueId());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long profileId = (Long)attributes.get("profileId");

		if (profileId != null) {
			setProfileId(profileId);
		}

		Long keyId = (Long)attributes.get("keyId");

		if (keyId != null) {
			setKeyId(keyId);
		}

		Long valueId = (Long)attributes.get("valueId");

		if (valueId != null) {
			setValueId(valueId);
		}
	}

	/**
	* Returns the primary key of this profile key value.
	*
	* @return the primary key of this profile key value
	*/
	public com.matrimony.service.persistence.ProfileKeyValuePK getPrimaryKey() {
		return _profileKeyValue.getPrimaryKey();
	}

	/**
	* Sets the primary key of this profile key value.
	*
	* @param primaryKey the primary key of this profile key value
	*/
	public void setPrimaryKey(
		com.matrimony.service.persistence.ProfileKeyValuePK primaryKey) {
		_profileKeyValue.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the profile ID of this profile key value.
	*
	* @return the profile ID of this profile key value
	*/
	public long getProfileId() {
		return _profileKeyValue.getProfileId();
	}

	/**
	* Sets the profile ID of this profile key value.
	*
	* @param profileId the profile ID of this profile key value
	*/
	public void setProfileId(long profileId) {
		_profileKeyValue.setProfileId(profileId);
	}

	/**
	* Returns the key ID of this profile key value.
	*
	* @return the key ID of this profile key value
	*/
	public long getKeyId() {
		return _profileKeyValue.getKeyId();
	}

	/**
	* Sets the key ID of this profile key value.
	*
	* @param keyId the key ID of this profile key value
	*/
	public void setKeyId(long keyId) {
		_profileKeyValue.setKeyId(keyId);
	}

	/**
	* Returns the value ID of this profile key value.
	*
	* @return the value ID of this profile key value
	*/
	public long getValueId() {
		return _profileKeyValue.getValueId();
	}

	/**
	* Sets the value ID of this profile key value.
	*
	* @param valueId the value ID of this profile key value
	*/
	public void setValueId(long valueId) {
		_profileKeyValue.setValueId(valueId);
	}

	public boolean isNew() {
		return _profileKeyValue.isNew();
	}

	public void setNew(boolean n) {
		_profileKeyValue.setNew(n);
	}

	public boolean isCachedModel() {
		return _profileKeyValue.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_profileKeyValue.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _profileKeyValue.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _profileKeyValue.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_profileKeyValue.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _profileKeyValue.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_profileKeyValue.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProfileKeyValueWrapper((ProfileKeyValue)_profileKeyValue.clone());
	}

	public int compareTo(com.matrimony.model.ProfileKeyValue profileKeyValue) {
		return _profileKeyValue.compareTo(profileKeyValue);
	}

	@Override
	public int hashCode() {
		return _profileKeyValue.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.matrimony.model.ProfileKeyValue> toCacheModel() {
		return _profileKeyValue.toCacheModel();
	}

	public com.matrimony.model.ProfileKeyValue toEscapedModel() {
		return new ProfileKeyValueWrapper(_profileKeyValue.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _profileKeyValue.toString();
	}

	public java.lang.String toXmlString() {
		return _profileKeyValue.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_profileKeyValue.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ProfileKeyValue getWrappedProfileKeyValue() {
		return _profileKeyValue;
	}

	public ProfileKeyValue getWrappedModel() {
		return _profileKeyValue;
	}

	public void resetOriginalValues() {
		_profileKeyValue.resetOriginalValues();
	}

	private ProfileKeyValue _profileKeyValue;
}