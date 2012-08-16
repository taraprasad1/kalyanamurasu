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
 * This class is a wrapper for {@link ProfileTemp}.
 * </p>
 *
 * @author    matrimony
 * @see       ProfileTemp
 * @generated
 */
public class ProfileTempWrapper implements ProfileTemp,
	ModelWrapper<ProfileTemp> {
	public ProfileTempWrapper(ProfileTemp profileTemp) {
		_profileTemp = profileTemp;
	}

	public Class<?> getModelClass() {
		return ProfileTemp.class;
	}

	public String getModelClassName() {
		return ProfileTemp.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("profileTempId", getProfileTempId());
		attributes.put("profileId", getProfileId());
		attributes.put("name", getName());
		attributes.put("address", getAddress());
		attributes.put("pinCode", getPinCode());
		attributes.put("phone", getPhone());
		attributes.put("mobile", getMobile());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("aboutMe", getAboutMe());
		attributes.put("scheme", getScheme());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long profileTempId = (Long)attributes.get("profileTempId");

		if (profileTempId != null) {
			setProfileTempId(profileTempId);
		}

		Long profileId = (Long)attributes.get("profileId");

		if (profileId != null) {
			setProfileId(profileId);
		}

		Long name = (Long)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String pinCode = (String)attributes.get("pinCode");

		if (pinCode != null) {
			setPinCode(pinCode);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String mobile = (String)attributes.get("mobile");

		if (mobile != null) {
			setMobile(mobile);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String aboutMe = (String)attributes.get("aboutMe");

		if (aboutMe != null) {
			setAboutMe(aboutMe);
		}

		Integer scheme = (Integer)attributes.get("scheme");

		if (scheme != null) {
			setScheme(scheme);
		}
	}

	/**
	* Returns the primary key of this profile temp.
	*
	* @return the primary key of this profile temp
	*/
	public long getPrimaryKey() {
		return _profileTemp.getPrimaryKey();
	}

	/**
	* Sets the primary key of this profile temp.
	*
	* @param primaryKey the primary key of this profile temp
	*/
	public void setPrimaryKey(long primaryKey) {
		_profileTemp.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the profile temp ID of this profile temp.
	*
	* @return the profile temp ID of this profile temp
	*/
	public long getProfileTempId() {
		return _profileTemp.getProfileTempId();
	}

	/**
	* Sets the profile temp ID of this profile temp.
	*
	* @param profileTempId the profile temp ID of this profile temp
	*/
	public void setProfileTempId(long profileTempId) {
		_profileTemp.setProfileTempId(profileTempId);
	}

	/**
	* Returns the profile ID of this profile temp.
	*
	* @return the profile ID of this profile temp
	*/
	public long getProfileId() {
		return _profileTemp.getProfileId();
	}

	/**
	* Sets the profile ID of this profile temp.
	*
	* @param profileId the profile ID of this profile temp
	*/
	public void setProfileId(long profileId) {
		_profileTemp.setProfileId(profileId);
	}

	/**
	* Returns the name of this profile temp.
	*
	* @return the name of this profile temp
	*/
	public long getName() {
		return _profileTemp.getName();
	}

	/**
	* Sets the name of this profile temp.
	*
	* @param name the name of this profile temp
	*/
	public void setName(long name) {
		_profileTemp.setName(name);
	}

	/**
	* Returns the address of this profile temp.
	*
	* @return the address of this profile temp
	*/
	public java.lang.String getAddress() {
		return _profileTemp.getAddress();
	}

	/**
	* Sets the address of this profile temp.
	*
	* @param address the address of this profile temp
	*/
	public void setAddress(java.lang.String address) {
		_profileTemp.setAddress(address);
	}

	/**
	* Returns the pin code of this profile temp.
	*
	* @return the pin code of this profile temp
	*/
	public java.lang.String getPinCode() {
		return _profileTemp.getPinCode();
	}

	/**
	* Sets the pin code of this profile temp.
	*
	* @param pinCode the pin code of this profile temp
	*/
	public void setPinCode(java.lang.String pinCode) {
		_profileTemp.setPinCode(pinCode);
	}

	/**
	* Returns the phone of this profile temp.
	*
	* @return the phone of this profile temp
	*/
	public java.lang.String getPhone() {
		return _profileTemp.getPhone();
	}

	/**
	* Sets the phone of this profile temp.
	*
	* @param phone the phone of this profile temp
	*/
	public void setPhone(java.lang.String phone) {
		_profileTemp.setPhone(phone);
	}

	/**
	* Returns the mobile of this profile temp.
	*
	* @return the mobile of this profile temp
	*/
	public java.lang.String getMobile() {
		return _profileTemp.getMobile();
	}

	/**
	* Sets the mobile of this profile temp.
	*
	* @param mobile the mobile of this profile temp
	*/
	public void setMobile(java.lang.String mobile) {
		_profileTemp.setMobile(mobile);
	}

	/**
	* Returns the email address of this profile temp.
	*
	* @return the email address of this profile temp
	*/
	public java.lang.String getEmailAddress() {
		return _profileTemp.getEmailAddress();
	}

	/**
	* Sets the email address of this profile temp.
	*
	* @param emailAddress the email address of this profile temp
	*/
	public void setEmailAddress(java.lang.String emailAddress) {
		_profileTemp.setEmailAddress(emailAddress);
	}

	/**
	* Returns the about me of this profile temp.
	*
	* @return the about me of this profile temp
	*/
	public java.lang.String getAboutMe() {
		return _profileTemp.getAboutMe();
	}

	/**
	* Sets the about me of this profile temp.
	*
	* @param aboutMe the about me of this profile temp
	*/
	public void setAboutMe(java.lang.String aboutMe) {
		_profileTemp.setAboutMe(aboutMe);
	}

	/**
	* Returns the scheme of this profile temp.
	*
	* @return the scheme of this profile temp
	*/
	public int getScheme() {
		return _profileTemp.getScheme();
	}

	/**
	* Sets the scheme of this profile temp.
	*
	* @param scheme the scheme of this profile temp
	*/
	public void setScheme(int scheme) {
		_profileTemp.setScheme(scheme);
	}

	public boolean isNew() {
		return _profileTemp.isNew();
	}

	public void setNew(boolean n) {
		_profileTemp.setNew(n);
	}

	public boolean isCachedModel() {
		return _profileTemp.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_profileTemp.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _profileTemp.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _profileTemp.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_profileTemp.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _profileTemp.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_profileTemp.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProfileTempWrapper((ProfileTemp)_profileTemp.clone());
	}

	public int compareTo(com.matrimony.model.ProfileTemp profileTemp) {
		return _profileTemp.compareTo(profileTemp);
	}

	@Override
	public int hashCode() {
		return _profileTemp.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.matrimony.model.ProfileTemp> toCacheModel() {
		return _profileTemp.toCacheModel();
	}

	public com.matrimony.model.ProfileTemp toEscapedModel() {
		return new ProfileTempWrapper(_profileTemp.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _profileTemp.toString();
	}

	public java.lang.String toXmlString() {
		return _profileTemp.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_profileTemp.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ProfileTemp getWrappedProfileTemp() {
		return _profileTemp;
	}

	public ProfileTemp getWrappedModel() {
		return _profileTemp;
	}

	public void resetOriginalValues() {
		_profileTemp.resetOriginalValues();
	}

	private ProfileTemp _profileTemp;
}