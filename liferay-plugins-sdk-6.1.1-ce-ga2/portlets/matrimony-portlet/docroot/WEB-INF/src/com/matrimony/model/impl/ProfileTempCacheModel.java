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

package com.matrimony.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.matrimony.model.ProfileTemp;

import java.io.Serializable;

/**
 * The cache model class for representing ProfileTemp in entity cache.
 *
 * @author matrimony
 * @see ProfileTemp
 * @generated
 */
public class ProfileTempCacheModel implements CacheModel<ProfileTemp>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{profileTempId=");
		sb.append(profileTempId);
		sb.append(", profileId=");
		sb.append(profileId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", address=");
		sb.append(address);
		sb.append(", pinCode=");
		sb.append(pinCode);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", mobile=");
		sb.append(mobile);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", aboutMe=");
		sb.append(aboutMe);
		sb.append(", scheme=");
		sb.append(scheme);
		sb.append("}");

		return sb.toString();
	}

	public ProfileTemp toEntityModel() {
		ProfileTempImpl profileTempImpl = new ProfileTempImpl();

		profileTempImpl.setProfileTempId(profileTempId);
		profileTempImpl.setProfileId(profileId);
		profileTempImpl.setName(name);

		if (address == null) {
			profileTempImpl.setAddress(StringPool.BLANK);
		}
		else {
			profileTempImpl.setAddress(address);
		}

		if (pinCode == null) {
			profileTempImpl.setPinCode(StringPool.BLANK);
		}
		else {
			profileTempImpl.setPinCode(pinCode);
		}

		if (phone == null) {
			profileTempImpl.setPhone(StringPool.BLANK);
		}
		else {
			profileTempImpl.setPhone(phone);
		}

		if (mobile == null) {
			profileTempImpl.setMobile(StringPool.BLANK);
		}
		else {
			profileTempImpl.setMobile(mobile);
		}

		if (emailAddress == null) {
			profileTempImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			profileTempImpl.setEmailAddress(emailAddress);
		}

		if (aboutMe == null) {
			profileTempImpl.setAboutMe(StringPool.BLANK);
		}
		else {
			profileTempImpl.setAboutMe(aboutMe);
		}

		profileTempImpl.setScheme(scheme);

		profileTempImpl.resetOriginalValues();

		return profileTempImpl;
	}

	public long profileTempId;
	public long profileId;
	public long name;
	public String address;
	public String pinCode;
	public String phone;
	public String mobile;
	public String emailAddress;
	public String aboutMe;
	public int scheme;
}