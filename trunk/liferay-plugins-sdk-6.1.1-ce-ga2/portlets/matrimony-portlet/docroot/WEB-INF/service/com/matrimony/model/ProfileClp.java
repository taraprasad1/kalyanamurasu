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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.matrimony.service.ProfileLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author matrimony
 */
public class ProfileClp extends BaseModelImpl<Profile> implements Profile {
	public ProfileClp() {
	}

	public Class<?> getModelClass() {
		return Profile.class;
	}

	public String getModelClassName() {
		return Profile.class.getName();
	}

	public long getPrimaryKey() {
		return _profileId;
	}

	public void setPrimaryKey(long primaryKey) {
		setProfileId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_profileId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("profileId", getProfileId());
		attributes.put("profileCode", getProfileCode());
		attributes.put("createdForMy", getCreatedForMy());
		attributes.put("name", getName());
		attributes.put("gender", getGender());
		attributes.put("birthDateWithTime", getBirthDateWithTime());
		attributes.put("rasi", getRasi());
		attributes.put("star", getStar());
		attributes.put("dosam", getDosam());
		attributes.put("religion", getReligion());
		attributes.put("caste", getCaste());
		attributes.put("subCaste", getSubCaste());
		attributes.put("height", getHeight());
		attributes.put("weight", getWeight());
		attributes.put("complexion", getComplexion());
		attributes.put("motherTongue", getMotherTongue());
		attributes.put("maritalStatus", getMaritalStatus());
		attributes.put("children", getChildren());
		attributes.put("country", getCountry());
		attributes.put("state", getState());
		attributes.put("city", getCity());
		attributes.put("address", getAddress());
		attributes.put("pinCode", getPinCode());
		attributes.put("phone", getPhone());
		attributes.put("mobile", getMobile());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("education", getEducation());
		attributes.put("profession", getProfession());
		attributes.put("currency", getCurrency());
		attributes.put("annualIncome", getAnnualIncome());
		attributes.put("aboutMe", getAboutMe());
		attributes.put("familyValue", getFamilyValue());
		attributes.put("familyType", getFamilyType());
		attributes.put("familyStatus", getFamilyStatus());
		attributes.put("securityCode", getSecurityCode());
		attributes.put("photoSecurityCode", getPhotoSecurityCode());
		attributes.put("lastLoggedIn", getLastLoggedIn());
		attributes.put("status", getStatus());
		attributes.put("scheme", getScheme());
		attributes.put("horoscope", getHoroscope());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long profileId = (Long)attributes.get("profileId");

		if (profileId != null) {
			setProfileId(profileId);
		}

		String profileCode = (String)attributes.get("profileCode");

		if (profileCode != null) {
			setProfileCode(profileCode);
		}

		String createdForMy = (String)attributes.get("createdForMy");

		if (createdForMy != null) {
			setCreatedForMy(createdForMy);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Boolean gender = (Boolean)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		Date birthDateWithTime = (Date)attributes.get("birthDateWithTime");

		if (birthDateWithTime != null) {
			setBirthDateWithTime(birthDateWithTime);
		}

		String rasi = (String)attributes.get("rasi");

		if (rasi != null) {
			setRasi(rasi);
		}

		String star = (String)attributes.get("star");

		if (star != null) {
			setStar(star);
		}

		String dosam = (String)attributes.get("dosam");

		if (dosam != null) {
			setDosam(dosam);
		}

		Long religion = (Long)attributes.get("religion");

		if (religion != null) {
			setReligion(religion);
		}

		Long caste = (Long)attributes.get("caste");

		if (caste != null) {
			setCaste(caste);
		}

		Long subCaste = (Long)attributes.get("subCaste");

		if (subCaste != null) {
			setSubCaste(subCaste);
		}

		String height = (String)attributes.get("height");

		if (height != null) {
			setHeight(height);
		}

		String weight = (String)attributes.get("weight");

		if (weight != null) {
			setWeight(weight);
		}

		String complexion = (String)attributes.get("complexion");

		if (complexion != null) {
			setComplexion(complexion);
		}

		String motherTongue = (String)attributes.get("motherTongue");

		if (motherTongue != null) {
			setMotherTongue(motherTongue);
		}

		String maritalStatus = (String)attributes.get("maritalStatus");

		if (maritalStatus != null) {
			setMaritalStatus(maritalStatus);
		}

		Integer children = (Integer)attributes.get("children");

		if (children != null) {
			setChildren(children);
		}

		Long country = (Long)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		Long state = (Long)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		Long city = (Long)attributes.get("city");

		if (city != null) {
			setCity(city);
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

		String education = (String)attributes.get("education");

		if (education != null) {
			setEducation(education);
		}

		String profession = (String)attributes.get("profession");

		if (profession != null) {
			setProfession(profession);
		}

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		String annualIncome = (String)attributes.get("annualIncome");

		if (annualIncome != null) {
			setAnnualIncome(annualIncome);
		}

		String aboutMe = (String)attributes.get("aboutMe");

		if (aboutMe != null) {
			setAboutMe(aboutMe);
		}

		String familyValue = (String)attributes.get("familyValue");

		if (familyValue != null) {
			setFamilyValue(familyValue);
		}

		String familyType = (String)attributes.get("familyType");

		if (familyType != null) {
			setFamilyType(familyType);
		}

		String familyStatus = (String)attributes.get("familyStatus");

		if (familyStatus != null) {
			setFamilyStatus(familyStatus);
		}

		String securityCode = (String)attributes.get("securityCode");

		if (securityCode != null) {
			setSecurityCode(securityCode);
		}

		String photoSecurityCode = (String)attributes.get("photoSecurityCode");

		if (photoSecurityCode != null) {
			setPhotoSecurityCode(photoSecurityCode);
		}

		Date lastLoggedIn = (Date)attributes.get("lastLoggedIn");

		if (lastLoggedIn != null) {
			setLastLoggedIn(lastLoggedIn);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Integer scheme = (Integer)attributes.get("scheme");

		if (scheme != null) {
			setScheme(scheme);
		}

		Boolean horoscope = (Boolean)attributes.get("horoscope");

		if (horoscope != null) {
			setHoroscope(horoscope);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
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

	public void setLanguageKnown(java.lang.String languageKnown) {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getLanguageKnown() {
		throw new UnsupportedOperationException();
	}

	public void setHobbies(java.lang.String hobbies) {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getHobbies() {
		throw new UnsupportedOperationException();
	}

	public BaseModel<?> getProfileRemoteModel() {
		return _profileRemoteModel;
	}

	public void setProfileRemoteModel(BaseModel<?> profileRemoteModel) {
		_profileRemoteModel = profileRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ProfileLocalServiceUtil.addProfile(this);
		}
		else {
			ProfileLocalServiceUtil.updateProfile(this);
		}
	}

	@Override
	public Profile toEscapedModel() {
		return (Profile)Proxy.newProxyInstance(Profile.class.getClassLoader(),
			new Class[] { Profile.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProfileClp clone = new ProfileClp();

		clone.setProfileId(getProfileId());
		clone.setProfileCode(getProfileCode());
		clone.setCreatedForMy(getCreatedForMy());
		clone.setName(getName());
		clone.setGender(getGender());
		clone.setBirthDateWithTime(getBirthDateWithTime());
		clone.setRasi(getRasi());
		clone.setStar(getStar());
		clone.setDosam(getDosam());
		clone.setReligion(getReligion());
		clone.setCaste(getCaste());
		clone.setSubCaste(getSubCaste());
		clone.setHeight(getHeight());
		clone.setWeight(getWeight());
		clone.setComplexion(getComplexion());
		clone.setMotherTongue(getMotherTongue());
		clone.setMaritalStatus(getMaritalStatus());
		clone.setChildren(getChildren());
		clone.setCountry(getCountry());
		clone.setState(getState());
		clone.setCity(getCity());
		clone.setAddress(getAddress());
		clone.setPinCode(getPinCode());
		clone.setPhone(getPhone());
		clone.setMobile(getMobile());
		clone.setEmailAddress(getEmailAddress());
		clone.setEducation(getEducation());
		clone.setProfession(getProfession());
		clone.setCurrency(getCurrency());
		clone.setAnnualIncome(getAnnualIncome());
		clone.setAboutMe(getAboutMe());
		clone.setFamilyValue(getFamilyValue());
		clone.setFamilyType(getFamilyType());
		clone.setFamilyStatus(getFamilyStatus());
		clone.setSecurityCode(getSecurityCode());
		clone.setPhotoSecurityCode(getPhotoSecurityCode());
		clone.setLastLoggedIn(getLastLoggedIn());
		clone.setStatus(getStatus());
		clone.setScheme(getScheme());
		clone.setHoroscope(getHoroscope());
		clone.setCreatedBy(getCreatedBy());
		clone.setModifiedBy(getModifiedBy());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());

		return clone;
	}

	public int compareTo(Profile profile) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(), profile.getModifiedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ProfileClp profile = null;

		try {
			profile = (ProfileClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = profile.getPrimaryKey();

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
		StringBundler sb = new StringBundler(93);

		sb.append("{profileId=");
		sb.append(getProfileId());
		sb.append(", profileCode=");
		sb.append(getProfileCode());
		sb.append(", createdForMy=");
		sb.append(getCreatedForMy());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", gender=");
		sb.append(getGender());
		sb.append(", birthDateWithTime=");
		sb.append(getBirthDateWithTime());
		sb.append(", rasi=");
		sb.append(getRasi());
		sb.append(", star=");
		sb.append(getStar());
		sb.append(", dosam=");
		sb.append(getDosam());
		sb.append(", religion=");
		sb.append(getReligion());
		sb.append(", caste=");
		sb.append(getCaste());
		sb.append(", subCaste=");
		sb.append(getSubCaste());
		sb.append(", height=");
		sb.append(getHeight());
		sb.append(", weight=");
		sb.append(getWeight());
		sb.append(", complexion=");
		sb.append(getComplexion());
		sb.append(", motherTongue=");
		sb.append(getMotherTongue());
		sb.append(", maritalStatus=");
		sb.append(getMaritalStatus());
		sb.append(", children=");
		sb.append(getChildren());
		sb.append(", country=");
		sb.append(getCountry());
		sb.append(", state=");
		sb.append(getState());
		sb.append(", city=");
		sb.append(getCity());
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
		sb.append(", education=");
		sb.append(getEducation());
		sb.append(", profession=");
		sb.append(getProfession());
		sb.append(", currency=");
		sb.append(getCurrency());
		sb.append(", annualIncome=");
		sb.append(getAnnualIncome());
		sb.append(", aboutMe=");
		sb.append(getAboutMe());
		sb.append(", familyValue=");
		sb.append(getFamilyValue());
		sb.append(", familyType=");
		sb.append(getFamilyType());
		sb.append(", familyStatus=");
		sb.append(getFamilyStatus());
		sb.append(", securityCode=");
		sb.append(getSecurityCode());
		sb.append(", photoSecurityCode=");
		sb.append(getPhotoSecurityCode());
		sb.append(", lastLoggedIn=");
		sb.append(getLastLoggedIn());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", scheme=");
		sb.append(getScheme());
		sb.append(", horoscope=");
		sb.append(getHoroscope());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", modifiedBy=");
		sb.append(getModifiedBy());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(142);

		sb.append("<model><model-name>");
		sb.append("com.matrimony.model.Profile");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>profileId</column-name><column-value><![CDATA[");
		sb.append(getProfileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>profileCode</column-name><column-value><![CDATA[");
		sb.append(getProfileCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdForMy</column-name><column-value><![CDATA[");
		sb.append(getCreatedForMy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gender</column-name><column-value><![CDATA[");
		sb.append(getGender());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>birthDateWithTime</column-name><column-value><![CDATA[");
		sb.append(getBirthDateWithTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rasi</column-name><column-value><![CDATA[");
		sb.append(getRasi());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>star</column-name><column-value><![CDATA[");
		sb.append(getStar());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dosam</column-name><column-value><![CDATA[");
		sb.append(getDosam());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>religion</column-name><column-value><![CDATA[");
		sb.append(getReligion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>caste</column-name><column-value><![CDATA[");
		sb.append(getCaste());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subCaste</column-name><column-value><![CDATA[");
		sb.append(getSubCaste());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>height</column-name><column-value><![CDATA[");
		sb.append(getHeight());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>weight</column-name><column-value><![CDATA[");
		sb.append(getWeight());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>complexion</column-name><column-value><![CDATA[");
		sb.append(getComplexion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>motherTongue</column-name><column-value><![CDATA[");
		sb.append(getMotherTongue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maritalStatus</column-name><column-value><![CDATA[");
		sb.append(getMaritalStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>children</column-name><column-value><![CDATA[");
		sb.append(getChildren());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>country</column-name><column-value><![CDATA[");
		sb.append(getCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>state</column-name><column-value><![CDATA[");
		sb.append(getState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
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
			"<column><column-name>education</column-name><column-value><![CDATA[");
		sb.append(getEducation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>profession</column-name><column-value><![CDATA[");
		sb.append(getProfession());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currency</column-name><column-value><![CDATA[");
		sb.append(getCurrency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>annualIncome</column-name><column-value><![CDATA[");
		sb.append(getAnnualIncome());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>aboutMe</column-name><column-value><![CDATA[");
		sb.append(getAboutMe());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>familyValue</column-name><column-value><![CDATA[");
		sb.append(getFamilyValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>familyType</column-name><column-value><![CDATA[");
		sb.append(getFamilyType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>familyStatus</column-name><column-value><![CDATA[");
		sb.append(getFamilyStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>securityCode</column-name><column-value><![CDATA[");
		sb.append(getSecurityCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>photoSecurityCode</column-name><column-value><![CDATA[");
		sb.append(getPhotoSecurityCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastLoggedIn</column-name><column-value><![CDATA[");
		sb.append(getLastLoggedIn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scheme</column-name><column-value><![CDATA[");
		sb.append(getScheme());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>horoscope</column-name><column-value><![CDATA[");
		sb.append(getHoroscope());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedBy</column-name><column-value><![CDATA[");
		sb.append(getModifiedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _profileRemoteModel;
}