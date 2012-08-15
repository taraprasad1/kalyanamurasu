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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.matrimony.service.ProfileTempLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author matrimony
 */
public class ProfileTempClp extends BaseModelImpl<ProfileTemp>
	implements ProfileTemp {
	public ProfileTempClp() {
	}

	public Class<?> getModelClass() {
		return ProfileTemp.class;
	}

	public String getModelClassName() {
		return ProfileTemp.class.getName();
	}

	public long getPrimaryKey() {
		return _profileTempId;
	}

	public void setPrimaryKey(long primaryKey) {
		setProfileTempId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_profileTempId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public long getProfileTempId() {
		return _profileTempId;
	}

	public void setProfileTempId(long profileTempId) {
		_profileTempId = profileTempId;
	}

	public long getProfileId() {
		return _profileId;
	}

	public void setProfileId(long profileId) {
		_profileId = profileId;
	}

	public long getName() {
		return _name;
	}

	public void setName(long name) {
		_name = name;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getPinCode() {
		return _pinCode;
	}

	public void setPinCode(String pinCode) {
		_pinCode = pinCode;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	public String getMobile() {
		return _mobile;
	}

	public void setMobile(String mobile) {
		_mobile = mobile;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public String getAboutMe() {
		return _aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		_aboutMe = aboutMe;
	}

	public int getScheme() {
		return _scheme;
	}

	public void setScheme(int scheme) {
		_scheme = scheme;
	}

	public BaseModel<?> getProfileTempRemoteModel() {
		return _profileTempRemoteModel;
	}

	public void setProfileTempRemoteModel(BaseModel<?> profileTempRemoteModel) {
		_profileTempRemoteModel = profileTempRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ProfileTempLocalServiceUtil.addProfileTemp(this);
		}
		else {
			ProfileTempLocalServiceUtil.updateProfileTemp(this);
		}
	}

	@Override
	public ProfileTemp toEscapedModel() {
		return (ProfileTemp)Proxy.newProxyInstance(ProfileTemp.class.getClassLoader(),
			new Class[] { ProfileTemp.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProfileTempClp clone = new ProfileTempClp();

		clone.setProfileTempId(getProfileTempId());
		clone.setProfileId(getProfileId());
		clone.setName(getName());
		clone.setAddress(getAddress());
		clone.setPinCode(getPinCode());
		clone.setPhone(getPhone());
		clone.setMobile(getMobile());
		clone.setEmailAddress(getEmailAddress());
		clone.setAboutMe(getAboutMe());
		clone.setScheme(getScheme());

		return clone;
	}

	public int compareTo(ProfileTemp profileTemp) {
		long primaryKey = profileTemp.getPrimaryKey();

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

		ProfileTempClp profileTemp = null;

		try {
			profileTemp = (ProfileTempClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = profileTemp.getPrimaryKey();

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
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{profileTempId=");
		sb.append(getProfileTempId());
		sb.append(", profileId=");
		sb.append(getProfileId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append(", pinCode=");
		sb.append(getPinCode());
		sb.append(", phone=");
		sb.append(getPhone());
		sb.append(", mobile=");
		sb.append(getMobile());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append(", aboutMe=");
		sb.append(getAboutMe());
		sb.append(", scheme=");
		sb.append(getScheme());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.matrimony.model.ProfileTemp");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>profileTempId</column-name><column-value><![CDATA[");
		sb.append(getProfileTempId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>profileId</column-name><column-value><![CDATA[");
		sb.append(getProfileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pinCode</column-name><column-value><![CDATA[");
		sb.append(getPinCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phone</column-name><column-value><![CDATA[");
		sb.append(getPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mobile</column-name><column-value><![CDATA[");
		sb.append(getMobile());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailAddress</column-name><column-value><![CDATA[");
		sb.append(getEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>aboutMe</column-name><column-value><![CDATA[");
		sb.append(getAboutMe());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scheme</column-name><column-value><![CDATA[");
		sb.append(getScheme());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _profileTempId;
	private long _profileId;
	private long _name;
	private String _address;
	private String _pinCode;
	private String _phone;
	private String _mobile;
	private String _emailAddress;
	private String _aboutMe;
	private int _scheme;
	private BaseModel<?> _profileTempRemoteModel;
}