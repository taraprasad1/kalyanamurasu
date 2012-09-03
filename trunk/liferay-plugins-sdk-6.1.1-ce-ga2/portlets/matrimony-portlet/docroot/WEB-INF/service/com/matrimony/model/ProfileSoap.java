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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.matrimony.service.http.ProfileServiceSoap}.
 *
 * @author    matrimony
 * @see       com.matrimony.service.http.ProfileServiceSoap
 * @generated
 */
public class ProfileSoap implements Serializable {
	public static ProfileSoap toSoapModel(Profile model) {
		ProfileSoap soapModel = new ProfileSoap();

		soapModel.setProfileId(model.getProfileId());
		soapModel.setProfileCode(model.getProfileCode());
		soapModel.setCreatedForMy(model.getCreatedForMy());
		soapModel.setName(model.getName());
		soapModel.setGender(model.getGender());
		soapModel.setBirthDateWithTime(model.getBirthDateWithTime());
		soapModel.setRasi(model.getRasi());
		soapModel.setStar(model.getStar());
		soapModel.setDosam(model.getDosam());
		soapModel.setReligion(model.getReligion());
		soapModel.setCaste(model.getCaste());
		soapModel.setSubCaste(model.getSubCaste());
		soapModel.setHeight(model.getHeight());
		soapModel.setWeight(model.getWeight());
		soapModel.setComplexion(model.getComplexion());
		soapModel.setMotherTongue(model.getMotherTongue());
		soapModel.setMaritalStatus(model.getMaritalStatus());
		soapModel.setChildren(model.getChildren());
		soapModel.setCountry(model.getCountry());
		soapModel.setState(model.getState());
		soapModel.setCity(model.getCity());
		soapModel.setAddress(model.getAddress());
		soapModel.setPinCode(model.getPinCode());
		soapModel.setPhone(model.getPhone());
		soapModel.setMobile(model.getMobile());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setEducation(model.getEducation());
		soapModel.setProfession(model.getProfession());
		soapModel.setCurrency(model.getCurrency());
		soapModel.setAnnualIncome(model.getAnnualIncome());
		soapModel.setAboutMe(model.getAboutMe());
		soapModel.setFamilyValue(model.getFamilyValue());
		soapModel.setFamilyType(model.getFamilyType());
		soapModel.setFamilyStatus(model.getFamilyStatus());
		soapModel.setSecurityCode(model.getSecurityCode());
		soapModel.setPhotoSecurityCode(model.getPhotoSecurityCode());
		soapModel.setLastLoggedIn(model.getLastLoggedIn());
		soapModel.setStatus(model.getStatus());
		soapModel.setScheme(model.getScheme());
		soapModel.setHoroscope(model.getHoroscope());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());

		return soapModel;
	}

	public static ProfileSoap[] toSoapModels(Profile[] models) {
		ProfileSoap[] soapModels = new ProfileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProfileSoap[][] toSoapModels(Profile[][] models) {
		ProfileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProfileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProfileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProfileSoap[] toSoapModels(List<Profile> models) {
		List<ProfileSoap> soapModels = new ArrayList<ProfileSoap>(models.size());

		for (Profile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProfileSoap[soapModels.size()]);
	}

	public ProfileSoap() {
	}

	public long getPrimaryKey() {
		return _profileId;
	}

	public void setPrimaryKey(long pk) {
		setProfileId(pk);
	}

	public long getProfileId() {
		return _profileId;
	}

	public void setProfileId(long profileId) {
		_profileId = profileId;
	}

	public String getProfileCode() {
		return _profileCode;
	}

	public void setProfileCode(String profileCode) {
		_profileCode = profileCode;
	}

	public String getCreatedForMy() {
		return _createdForMy;
	}

	public void setCreatedForMy(String createdForMy) {
		_createdForMy = createdForMy;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public boolean getGender() {
		return _gender;
	}

	public boolean isGender() {
		return _gender;
	}

	public void setGender(boolean gender) {
		_gender = gender;
	}

	public Date getBirthDateWithTime() {
		return _birthDateWithTime;
	}

	public void setBirthDateWithTime(Date birthDateWithTime) {
		_birthDateWithTime = birthDateWithTime;
	}

	public String getRasi() {
		return _rasi;
	}

	public void setRasi(String rasi) {
		_rasi = rasi;
	}

	public String getStar() {
		return _star;
	}

	public void setStar(String star) {
		_star = star;
	}

	public String getDosam() {
		return _dosam;
	}

	public void setDosam(String dosam) {
		_dosam = dosam;
	}

	public long getReligion() {
		return _religion;
	}

	public void setReligion(long religion) {
		_religion = religion;
	}

	public long getCaste() {
		return _caste;
	}

	public void setCaste(long caste) {
		_caste = caste;
	}

	public long getSubCaste() {
		return _subCaste;
	}

	public void setSubCaste(long subCaste) {
		_subCaste = subCaste;
	}

	public String getHeight() {
		return _height;
	}

	public void setHeight(String height) {
		_height = height;
	}

	public String getWeight() {
		return _weight;
	}

	public void setWeight(String weight) {
		_weight = weight;
	}

	public String getComplexion() {
		return _complexion;
	}

	public void setComplexion(String complexion) {
		_complexion = complexion;
	}

	public String getMotherTongue() {
		return _motherTongue;
	}

	public void setMotherTongue(String motherTongue) {
		_motherTongue = motherTongue;
	}

	public String getMaritalStatus() {
		return _maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		_maritalStatus = maritalStatus;
	}

	public int getChildren() {
		return _children;
	}

	public void setChildren(int children) {
		_children = children;
	}

	public long getCountry() {
		return _country;
	}

	public void setCountry(long country) {
		_country = country;
	}

	public long getState() {
		return _state;
	}

	public void setState(long state) {
		_state = state;
	}

	public long getCity() {
		return _city;
	}

	public void setCity(long city) {
		_city = city;
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

	public String getEducation() {
		return _education;
	}

	public void setEducation(String education) {
		_education = education;
	}

	public String getProfession() {
		return _profession;
	}

	public void setProfession(String profession) {
		_profession = profession;
	}

	public String getCurrency() {
		return _currency;
	}

	public void setCurrency(String currency) {
		_currency = currency;
	}

	public String getAnnualIncome() {
		return _annualIncome;
	}

	public void setAnnualIncome(String annualIncome) {
		_annualIncome = annualIncome;
	}

	public String getAboutMe() {
		return _aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		_aboutMe = aboutMe;
	}

	public String getFamilyValue() {
		return _familyValue;
	}

	public void setFamilyValue(String familyValue) {
		_familyValue = familyValue;
	}

	public String getFamilyType() {
		return _familyType;
	}

	public void setFamilyType(String familyType) {
		_familyType = familyType;
	}

	public String getFamilyStatus() {
		return _familyStatus;
	}

	public void setFamilyStatus(String familyStatus) {
		_familyStatus = familyStatus;
	}

	public String getSecurityCode() {
		return _securityCode;
	}

	public void setSecurityCode(String securityCode) {
		_securityCode = securityCode;
	}

	public String getPhotoSecurityCode() {
		return _photoSecurityCode;
	}

	public void setPhotoSecurityCode(String photoSecurityCode) {
		_photoSecurityCode = photoSecurityCode;
	}

	public Date getLastLoggedIn() {
		return _lastLoggedIn;
	}

	public void setLastLoggedIn(Date lastLoggedIn) {
		_lastLoggedIn = lastLoggedIn;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public int getScheme() {
		return _scheme;
	}

	public void setScheme(int scheme) {
		_scheme = scheme;
	}

	public boolean getHoroscope() {
		return _horoscope;
	}

	public boolean isHoroscope() {
		return _horoscope;
	}

	public void setHoroscope(boolean horoscope) {
		_horoscope = horoscope;
	}

	public long getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	public long getModifiedBy() {
		return _modifiedBy;
	}

	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	private long _profileId;
	private String _profileCode;
	private String _createdForMy;
	private String _name;
	private boolean _gender;
	private Date _birthDateWithTime;
	private String _rasi;
	private String _star;
	private String _dosam;
	private long _religion;
	private long _caste;
	private long _subCaste;
	private String _height;
	private String _weight;
	private String _complexion;
	private String _motherTongue;
	private String _maritalStatus;
	private int _children;
	private long _country;
	private long _state;
	private long _city;
	private String _address;
	private String _pinCode;
	private String _phone;
	private String _mobile;
	private String _emailAddress;
	private String _education;
	private String _profession;
	private String _currency;
	private String _annualIncome;
	private String _aboutMe;
	private String _familyValue;
	private String _familyType;
	private String _familyStatus;
	private String _securityCode;
	private String _photoSecurityCode;
	private Date _lastLoggedIn;
	private int _status;
	private int _scheme;
	private boolean _horoscope;
	private long _createdBy;
	private long _modifiedBy;
	private Date _createdDate;
	private Date _modifiedDate;
	private long _companyId;
	private long _groupId;
}