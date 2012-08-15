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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.matrimony.service.http.ProfileTempServiceSoap}.
 *
 * @author    matrimony
 * @see       com.matrimony.service.http.ProfileTempServiceSoap
 * @generated
 */
public class ProfileTempSoap implements Serializable {
	public static ProfileTempSoap toSoapModel(ProfileTemp model) {
		ProfileTempSoap soapModel = new ProfileTempSoap();

		soapModel.setProfileTempId(model.getProfileTempId());
		soapModel.setProfileId(model.getProfileId());
		soapModel.setName(model.getName());
		soapModel.setAddress(model.getAddress());
		soapModel.setPinCode(model.getPinCode());
		soapModel.setPhone(model.getPhone());
		soapModel.setMobile(model.getMobile());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setAboutMe(model.getAboutMe());
		soapModel.setScheme(model.getScheme());

		return soapModel;
	}

	public static ProfileTempSoap[] toSoapModels(ProfileTemp[] models) {
		ProfileTempSoap[] soapModels = new ProfileTempSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProfileTempSoap[][] toSoapModels(ProfileTemp[][] models) {
		ProfileTempSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProfileTempSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProfileTempSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProfileTempSoap[] toSoapModels(List<ProfileTemp> models) {
		List<ProfileTempSoap> soapModels = new ArrayList<ProfileTempSoap>(models.size());

		for (ProfileTemp model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProfileTempSoap[soapModels.size()]);
	}

	public ProfileTempSoap() {
	}

	public long getPrimaryKey() {
		return _profileTempId;
	}

	public void setPrimaryKey(long pk) {
		setProfileTempId(pk);
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
}