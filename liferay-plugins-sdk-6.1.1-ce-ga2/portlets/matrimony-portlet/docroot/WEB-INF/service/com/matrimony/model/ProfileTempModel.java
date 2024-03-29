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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the ProfileTemp service. Represents a row in the &quot;matrimony_profile_temp&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.matrimony.model.impl.ProfileTempModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.matrimony.model.impl.ProfileTempImpl}.
 * </p>
 *
 * @author matrimony
 * @see ProfileTemp
 * @see com.matrimony.model.impl.ProfileTempImpl
 * @see com.matrimony.model.impl.ProfileTempModelImpl
 * @generated
 */
public interface ProfileTempModel extends BaseModel<ProfileTemp> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a profile temp model instance should use the {@link ProfileTemp} interface instead.
	 */

	/**
	 * Returns the primary key of this profile temp.
	 *
	 * @return the primary key of this profile temp
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this profile temp.
	 *
	 * @param primaryKey the primary key of this profile temp
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the profile temp ID of this profile temp.
	 *
	 * @return the profile temp ID of this profile temp
	 */
	public long getProfileTempId();

	/**
	 * Sets the profile temp ID of this profile temp.
	 *
	 * @param profileTempId the profile temp ID of this profile temp
	 */
	public void setProfileTempId(long profileTempId);

	/**
	 * Returns the profile ID of this profile temp.
	 *
	 * @return the profile ID of this profile temp
	 */
	public long getProfileId();

	/**
	 * Sets the profile ID of this profile temp.
	 *
	 * @param profileId the profile ID of this profile temp
	 */
	public void setProfileId(long profileId);

	/**
	 * Returns the name of this profile temp.
	 *
	 * @return the name of this profile temp
	 */
	public long getName();

	/**
	 * Sets the name of this profile temp.
	 *
	 * @param name the name of this profile temp
	 */
	public void setName(long name);

	/**
	 * Returns the address of this profile temp.
	 *
	 * @return the address of this profile temp
	 */
	@AutoEscape
	public String getAddress();

	/**
	 * Sets the address of this profile temp.
	 *
	 * @param address the address of this profile temp
	 */
	public void setAddress(String address);

	/**
	 * Returns the pin code of this profile temp.
	 *
	 * @return the pin code of this profile temp
	 */
	@AutoEscape
	public String getPinCode();

	/**
	 * Sets the pin code of this profile temp.
	 *
	 * @param pinCode the pin code of this profile temp
	 */
	public void setPinCode(String pinCode);

	/**
	 * Returns the phone of this profile temp.
	 *
	 * @return the phone of this profile temp
	 */
	@AutoEscape
	public String getPhone();

	/**
	 * Sets the phone of this profile temp.
	 *
	 * @param phone the phone of this profile temp
	 */
	public void setPhone(String phone);

	/**
	 * Returns the mobile of this profile temp.
	 *
	 * @return the mobile of this profile temp
	 */
	@AutoEscape
	public String getMobile();

	/**
	 * Sets the mobile of this profile temp.
	 *
	 * @param mobile the mobile of this profile temp
	 */
	public void setMobile(String mobile);

	/**
	 * Returns the email address of this profile temp.
	 *
	 * @return the email address of this profile temp
	 */
	@AutoEscape
	public String getEmailAddress();

	/**
	 * Sets the email address of this profile temp.
	 *
	 * @param emailAddress the email address of this profile temp
	 */
	public void setEmailAddress(String emailAddress);

	/**
	 * Returns the about me of this profile temp.
	 *
	 * @return the about me of this profile temp
	 */
	@AutoEscape
	public String getAboutMe();

	/**
	 * Sets the about me of this profile temp.
	 *
	 * @param aboutMe the about me of this profile temp
	 */
	public void setAboutMe(String aboutMe);

	/**
	 * Returns the scheme of this profile temp.
	 *
	 * @return the scheme of this profile temp
	 */
	public int getScheme();

	/**
	 * Sets the scheme of this profile temp.
	 *
	 * @param scheme the scheme of this profile temp
	 */
	public void setScheme(int scheme);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(ProfileTemp profileTemp);

	public int hashCode();

	public CacheModel<ProfileTemp> toCacheModel();

	public ProfileTemp toEscapedModel();

	public String toString();

	public String toXmlString();
}