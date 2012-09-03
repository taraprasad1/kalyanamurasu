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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Profile}.
 * </p>
 *
 * @author    matrimony
 * @see       Profile
 * @generated
 */
public class ProfileWrapper implements Profile, ModelWrapper<Profile> {
	public ProfileWrapper(Profile profile) {
		_profile = profile;
	}

	public Class<?> getModelClass() {
		return Profile.class;
	}

	public String getModelClassName() {
		return Profile.class.getName();
	}

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

	/**
	* Returns the primary key of this profile.
	*
	* @return the primary key of this profile
	*/
	public long getPrimaryKey() {
		return _profile.getPrimaryKey();
	}

	/**
	* Sets the primary key of this profile.
	*
	* @param primaryKey the primary key of this profile
	*/
	public void setPrimaryKey(long primaryKey) {
		_profile.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the profile ID of this profile.
	*
	* @return the profile ID of this profile
	*/
	public long getProfileId() {
		return _profile.getProfileId();
	}

	/**
	* Sets the profile ID of this profile.
	*
	* @param profileId the profile ID of this profile
	*/
	public void setProfileId(long profileId) {
		_profile.setProfileId(profileId);
	}

	/**
	* Returns the profile code of this profile.
	*
	* @return the profile code of this profile
	*/
	public java.lang.String getProfileCode() {
		return _profile.getProfileCode();
	}

	/**
	* Sets the profile code of this profile.
	*
	* @param profileCode the profile code of this profile
	*/
	public void setProfileCode(java.lang.String profileCode) {
		_profile.setProfileCode(profileCode);
	}

	/**
	* Returns the created for my of this profile.
	*
	* @return the created for my of this profile
	*/
	public java.lang.String getCreatedForMy() {
		return _profile.getCreatedForMy();
	}

	/**
	* Sets the created for my of this profile.
	*
	* @param createdForMy the created for my of this profile
	*/
	public void setCreatedForMy(java.lang.String createdForMy) {
		_profile.setCreatedForMy(createdForMy);
	}

	/**
	* Returns the name of this profile.
	*
	* @return the name of this profile
	*/
	public java.lang.String getName() {
		return _profile.getName();
	}

	/**
	* Sets the name of this profile.
	*
	* @param name the name of this profile
	*/
	public void setName(java.lang.String name) {
		_profile.setName(name);
	}

	/**
	* Returns the gender of this profile.
	*
	* @return the gender of this profile
	*/
	public boolean getGender() {
		return _profile.getGender();
	}

	/**
	* Returns <code>true</code> if this profile is gender.
	*
	* @return <code>true</code> if this profile is gender; <code>false</code> otherwise
	*/
	public boolean isGender() {
		return _profile.isGender();
	}

	/**
	* Sets whether this profile is gender.
	*
	* @param gender the gender of this profile
	*/
	public void setGender(boolean gender) {
		_profile.setGender(gender);
	}

	/**
	* Returns the birth date with time of this profile.
	*
	* @return the birth date with time of this profile
	*/
	public java.util.Date getBirthDateWithTime() {
		return _profile.getBirthDateWithTime();
	}

	/**
	* Sets the birth date with time of this profile.
	*
	* @param birthDateWithTime the birth date with time of this profile
	*/
	public void setBirthDateWithTime(java.util.Date birthDateWithTime) {
		_profile.setBirthDateWithTime(birthDateWithTime);
	}

	/**
	* Returns the rasi of this profile.
	*
	* @return the rasi of this profile
	*/
	public java.lang.String getRasi() {
		return _profile.getRasi();
	}

	/**
	* Sets the rasi of this profile.
	*
	* @param rasi the rasi of this profile
	*/
	public void setRasi(java.lang.String rasi) {
		_profile.setRasi(rasi);
	}

	/**
	* Returns the star of this profile.
	*
	* @return the star of this profile
	*/
	public java.lang.String getStar() {
		return _profile.getStar();
	}

	/**
	* Sets the star of this profile.
	*
	* @param star the star of this profile
	*/
	public void setStar(java.lang.String star) {
		_profile.setStar(star);
	}

	/**
	* Returns the dosam of this profile.
	*
	* @return the dosam of this profile
	*/
	public java.lang.String getDosam() {
		return _profile.getDosam();
	}

	/**
	* Sets the dosam of this profile.
	*
	* @param dosam the dosam of this profile
	*/
	public void setDosam(java.lang.String dosam) {
		_profile.setDosam(dosam);
	}

	/**
	* Returns the religion of this profile.
	*
	* @return the religion of this profile
	*/
	public long getReligion() {
		return _profile.getReligion();
	}

	/**
	* Sets the religion of this profile.
	*
	* @param religion the religion of this profile
	*/
	public void setReligion(long religion) {
		_profile.setReligion(religion);
	}

	/**
	* Returns the caste of this profile.
	*
	* @return the caste of this profile
	*/
	public long getCaste() {
		return _profile.getCaste();
	}

	/**
	* Sets the caste of this profile.
	*
	* @param caste the caste of this profile
	*/
	public void setCaste(long caste) {
		_profile.setCaste(caste);
	}

	/**
	* Returns the sub caste of this profile.
	*
	* @return the sub caste of this profile
	*/
	public long getSubCaste() {
		return _profile.getSubCaste();
	}

	/**
	* Sets the sub caste of this profile.
	*
	* @param subCaste the sub caste of this profile
	*/
	public void setSubCaste(long subCaste) {
		_profile.setSubCaste(subCaste);
	}

	/**
	* Returns the height of this profile.
	*
	* @return the height of this profile
	*/
	public java.lang.String getHeight() {
		return _profile.getHeight();
	}

	/**
	* Sets the height of this profile.
	*
	* @param height the height of this profile
	*/
	public void setHeight(java.lang.String height) {
		_profile.setHeight(height);
	}

	/**
	* Returns the weight of this profile.
	*
	* @return the weight of this profile
	*/
	public java.lang.String getWeight() {
		return _profile.getWeight();
	}

	/**
	* Sets the weight of this profile.
	*
	* @param weight the weight of this profile
	*/
	public void setWeight(java.lang.String weight) {
		_profile.setWeight(weight);
	}

	/**
	* Returns the complexion of this profile.
	*
	* @return the complexion of this profile
	*/
	public java.lang.String getComplexion() {
		return _profile.getComplexion();
	}

	/**
	* Sets the complexion of this profile.
	*
	* @param complexion the complexion of this profile
	*/
	public void setComplexion(java.lang.String complexion) {
		_profile.setComplexion(complexion);
	}

	/**
	* Returns the mother tongue of this profile.
	*
	* @return the mother tongue of this profile
	*/
	public java.lang.String getMotherTongue() {
		return _profile.getMotherTongue();
	}

	/**
	* Sets the mother tongue of this profile.
	*
	* @param motherTongue the mother tongue of this profile
	*/
	public void setMotherTongue(java.lang.String motherTongue) {
		_profile.setMotherTongue(motherTongue);
	}

	/**
	* Returns the marital status of this profile.
	*
	* @return the marital status of this profile
	*/
	public java.lang.String getMaritalStatus() {
		return _profile.getMaritalStatus();
	}

	/**
	* Sets the marital status of this profile.
	*
	* @param maritalStatus the marital status of this profile
	*/
	public void setMaritalStatus(java.lang.String maritalStatus) {
		_profile.setMaritalStatus(maritalStatus);
	}

	/**
	* Returns the children of this profile.
	*
	* @return the children of this profile
	*/
	public int getChildren() {
		return _profile.getChildren();
	}

	/**
	* Sets the children of this profile.
	*
	* @param children the children of this profile
	*/
	public void setChildren(int children) {
		_profile.setChildren(children);
	}

	/**
	* Returns the country of this profile.
	*
	* @return the country of this profile
	*/
	public long getCountry() {
		return _profile.getCountry();
	}

	/**
	* Sets the country of this profile.
	*
	* @param country the country of this profile
	*/
	public void setCountry(long country) {
		_profile.setCountry(country);
	}

	/**
	* Returns the state of this profile.
	*
	* @return the state of this profile
	*/
	public long getState() {
		return _profile.getState();
	}

	/**
	* Sets the state of this profile.
	*
	* @param state the state of this profile
	*/
	public void setState(long state) {
		_profile.setState(state);
	}

	/**
	* Returns the city of this profile.
	*
	* @return the city of this profile
	*/
	public long getCity() {
		return _profile.getCity();
	}

	/**
	* Sets the city of this profile.
	*
	* @param city the city of this profile
	*/
	public void setCity(long city) {
		_profile.setCity(city);
	}

	/**
	* Returns the address of this profile.
	*
	* @return the address of this profile
	*/
	public java.lang.String getAddress() {
		return _profile.getAddress();
	}

	/**
	* Sets the address of this profile.
	*
	* @param address the address of this profile
	*/
	public void setAddress(java.lang.String address) {
		_profile.setAddress(address);
	}

	/**
	* Returns the pin code of this profile.
	*
	* @return the pin code of this profile
	*/
	public java.lang.String getPinCode() {
		return _profile.getPinCode();
	}

	/**
	* Sets the pin code of this profile.
	*
	* @param pinCode the pin code of this profile
	*/
	public void setPinCode(java.lang.String pinCode) {
		_profile.setPinCode(pinCode);
	}

	/**
	* Returns the phone of this profile.
	*
	* @return the phone of this profile
	*/
	public java.lang.String getPhone() {
		return _profile.getPhone();
	}

	/**
	* Sets the phone of this profile.
	*
	* @param phone the phone of this profile
	*/
	public void setPhone(java.lang.String phone) {
		_profile.setPhone(phone);
	}

	/**
	* Returns the mobile of this profile.
	*
	* @return the mobile of this profile
	*/
	public java.lang.String getMobile() {
		return _profile.getMobile();
	}

	/**
	* Sets the mobile of this profile.
	*
	* @param mobile the mobile of this profile
	*/
	public void setMobile(java.lang.String mobile) {
		_profile.setMobile(mobile);
	}

	/**
	* Returns the email address of this profile.
	*
	* @return the email address of this profile
	*/
	public java.lang.String getEmailAddress() {
		return _profile.getEmailAddress();
	}

	/**
	* Sets the email address of this profile.
	*
	* @param emailAddress the email address of this profile
	*/
	public void setEmailAddress(java.lang.String emailAddress) {
		_profile.setEmailAddress(emailAddress);
	}

	/**
	* Returns the education of this profile.
	*
	* @return the education of this profile
	*/
	public java.lang.String getEducation() {
		return _profile.getEducation();
	}

	/**
	* Sets the education of this profile.
	*
	* @param education the education of this profile
	*/
	public void setEducation(java.lang.String education) {
		_profile.setEducation(education);
	}

	/**
	* Returns the profession of this profile.
	*
	* @return the profession of this profile
	*/
	public java.lang.String getProfession() {
		return _profile.getProfession();
	}

	/**
	* Sets the profession of this profile.
	*
	* @param profession the profession of this profile
	*/
	public void setProfession(java.lang.String profession) {
		_profile.setProfession(profession);
	}

	/**
	* Returns the currency of this profile.
	*
	* @return the currency of this profile
	*/
	public java.lang.String getCurrency() {
		return _profile.getCurrency();
	}

	/**
	* Sets the currency of this profile.
	*
	* @param currency the currency of this profile
	*/
	public void setCurrency(java.lang.String currency) {
		_profile.setCurrency(currency);
	}

	/**
	* Returns the annual income of this profile.
	*
	* @return the annual income of this profile
	*/
	public java.lang.String getAnnualIncome() {
		return _profile.getAnnualIncome();
	}

	/**
	* Sets the annual income of this profile.
	*
	* @param annualIncome the annual income of this profile
	*/
	public void setAnnualIncome(java.lang.String annualIncome) {
		_profile.setAnnualIncome(annualIncome);
	}

	/**
	* Returns the about me of this profile.
	*
	* @return the about me of this profile
	*/
	public java.lang.String getAboutMe() {
		return _profile.getAboutMe();
	}

	/**
	* Sets the about me of this profile.
	*
	* @param aboutMe the about me of this profile
	*/
	public void setAboutMe(java.lang.String aboutMe) {
		_profile.setAboutMe(aboutMe);
	}

	/**
	* Returns the family value of this profile.
	*
	* @return the family value of this profile
	*/
	public java.lang.String getFamilyValue() {
		return _profile.getFamilyValue();
	}

	/**
	* Sets the family value of this profile.
	*
	* @param familyValue the family value of this profile
	*/
	public void setFamilyValue(java.lang.String familyValue) {
		_profile.setFamilyValue(familyValue);
	}

	/**
	* Returns the family type of this profile.
	*
	* @return the family type of this profile
	*/
	public java.lang.String getFamilyType() {
		return _profile.getFamilyType();
	}

	/**
	* Sets the family type of this profile.
	*
	* @param familyType the family type of this profile
	*/
	public void setFamilyType(java.lang.String familyType) {
		_profile.setFamilyType(familyType);
	}

	/**
	* Returns the family status of this profile.
	*
	* @return the family status of this profile
	*/
	public java.lang.String getFamilyStatus() {
		return _profile.getFamilyStatus();
	}

	/**
	* Sets the family status of this profile.
	*
	* @param familyStatus the family status of this profile
	*/
	public void setFamilyStatus(java.lang.String familyStatus) {
		_profile.setFamilyStatus(familyStatus);
	}

	/**
	* Returns the security code of this profile.
	*
	* @return the security code of this profile
	*/
	public java.lang.String getSecurityCode() {
		return _profile.getSecurityCode();
	}

	/**
	* Sets the security code of this profile.
	*
	* @param securityCode the security code of this profile
	*/
	public void setSecurityCode(java.lang.String securityCode) {
		_profile.setSecurityCode(securityCode);
	}

	/**
	* Returns the photo security code of this profile.
	*
	* @return the photo security code of this profile
	*/
	public java.lang.String getPhotoSecurityCode() {
		return _profile.getPhotoSecurityCode();
	}

	/**
	* Sets the photo security code of this profile.
	*
	* @param photoSecurityCode the photo security code of this profile
	*/
	public void setPhotoSecurityCode(java.lang.String photoSecurityCode) {
		_profile.setPhotoSecurityCode(photoSecurityCode);
	}

	/**
	* Returns the last logged in of this profile.
	*
	* @return the last logged in of this profile
	*/
	public java.util.Date getLastLoggedIn() {
		return _profile.getLastLoggedIn();
	}

	/**
	* Sets the last logged in of this profile.
	*
	* @param lastLoggedIn the last logged in of this profile
	*/
	public void setLastLoggedIn(java.util.Date lastLoggedIn) {
		_profile.setLastLoggedIn(lastLoggedIn);
	}

	/**
	* Returns the status of this profile.
	*
	* @return the status of this profile
	*/
	public int getStatus() {
		return _profile.getStatus();
	}

	/**
	* Sets the status of this profile.
	*
	* @param status the status of this profile
	*/
	public void setStatus(int status) {
		_profile.setStatus(status);
	}

	/**
	* Returns the scheme of this profile.
	*
	* @return the scheme of this profile
	*/
	public int getScheme() {
		return _profile.getScheme();
	}

	/**
	* Sets the scheme of this profile.
	*
	* @param scheme the scheme of this profile
	*/
	public void setScheme(int scheme) {
		_profile.setScheme(scheme);
	}

	/**
	* Returns the horoscope of this profile.
	*
	* @return the horoscope of this profile
	*/
	public boolean getHoroscope() {
		return _profile.getHoroscope();
	}

	/**
	* Returns <code>true</code> if this profile is horoscope.
	*
	* @return <code>true</code> if this profile is horoscope; <code>false</code> otherwise
	*/
	public boolean isHoroscope() {
		return _profile.isHoroscope();
	}

	/**
	* Sets whether this profile is horoscope.
	*
	* @param horoscope the horoscope of this profile
	*/
	public void setHoroscope(boolean horoscope) {
		_profile.setHoroscope(horoscope);
	}

	/**
	* Returns the created by of this profile.
	*
	* @return the created by of this profile
	*/
	public long getCreatedBy() {
		return _profile.getCreatedBy();
	}

	/**
	* Sets the created by of this profile.
	*
	* @param createdBy the created by of this profile
	*/
	public void setCreatedBy(long createdBy) {
		_profile.setCreatedBy(createdBy);
	}

	/**
	* Returns the modified by of this profile.
	*
	* @return the modified by of this profile
	*/
	public long getModifiedBy() {
		return _profile.getModifiedBy();
	}

	/**
	* Sets the modified by of this profile.
	*
	* @param modifiedBy the modified by of this profile
	*/
	public void setModifiedBy(long modifiedBy) {
		_profile.setModifiedBy(modifiedBy);
	}

	/**
	* Returns the created date of this profile.
	*
	* @return the created date of this profile
	*/
	public java.util.Date getCreatedDate() {
		return _profile.getCreatedDate();
	}

	/**
	* Sets the created date of this profile.
	*
	* @param createdDate the created date of this profile
	*/
	public void setCreatedDate(java.util.Date createdDate) {
		_profile.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this profile.
	*
	* @return the modified date of this profile
	*/
	public java.util.Date getModifiedDate() {
		return _profile.getModifiedDate();
	}

	/**
	* Sets the modified date of this profile.
	*
	* @param modifiedDate the modified date of this profile
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_profile.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the company ID of this profile.
	*
	* @return the company ID of this profile
	*/
	public long getCompanyId() {
		return _profile.getCompanyId();
	}

	/**
	* Sets the company ID of this profile.
	*
	* @param companyId the company ID of this profile
	*/
	public void setCompanyId(long companyId) {
		_profile.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this profile.
	*
	* @return the group ID of this profile
	*/
	public long getGroupId() {
		return _profile.getGroupId();
	}

	/**
	* Sets the group ID of this profile.
	*
	* @param groupId the group ID of this profile
	*/
	public void setGroupId(long groupId) {
		_profile.setGroupId(groupId);
	}

	public boolean isNew() {
		return _profile.isNew();
	}

	public void setNew(boolean n) {
		_profile.setNew(n);
	}

	public boolean isCachedModel() {
		return _profile.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_profile.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _profile.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _profile.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_profile.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _profile.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_profile.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProfileWrapper((Profile)_profile.clone());
	}

	public int compareTo(com.matrimony.model.Profile profile) {
		return _profile.compareTo(profile);
	}

	@Override
	public int hashCode() {
		return _profile.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.matrimony.model.Profile> toCacheModel() {
		return _profile.toCacheModel();
	}

	public com.matrimony.model.Profile toEscapedModel() {
		return new ProfileWrapper(_profile.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _profile.toString();
	}

	public java.lang.String toXmlString() {
		return _profile.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_profile.persist();
	}

	public java.lang.String getHobbies() {
		return _profile.getHobbies();
	}

	public void setHobbies(java.lang.String hobbies) {
		_profile.setHobbies(hobbies);
	}

	public java.lang.String getLanguageKnown() {
		return _profile.getLanguageKnown();
	}

	public void setLanguageKnown(java.lang.String languageKnown) {
		_profile.setLanguageKnown(languageKnown);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Profile getWrappedProfile() {
		return _profile;
	}

	public Profile getWrappedModel() {
		return _profile;
	}

	public void resetOriginalValues() {
		_profile.resetOriginalValues();
	}

	private Profile _profile;
}