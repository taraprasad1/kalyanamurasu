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

import com.matrimony.model.Profile;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Profile in entity cache.
 *
 * @author matrimony
 * @see Profile
 * @generated
 */
public class ProfileCacheModel implements CacheModel<Profile>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(97);

		sb.append("{profileId=");
		sb.append(profileId);
		sb.append(", profileCode=");
		sb.append(profileCode);
		sb.append(", createdForMy=");
		sb.append(createdForMy);
		sb.append(", name=");
		sb.append(name);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", birthDateWithTime=");
		sb.append(birthDateWithTime);
		sb.append(", rasi=");
		sb.append(rasi);
		sb.append(", star=");
		sb.append(star);
		sb.append(", dosam=");
		sb.append(dosam);
		sb.append(", religion=");
		sb.append(religion);
		sb.append(", caste=");
		sb.append(caste);
		sb.append(", subCaste=");
		sb.append(subCaste);
		sb.append(", height=");
		sb.append(height);
		sb.append(", weight=");
		sb.append(weight);
		sb.append(", complexion=");
		sb.append(complexion);
		sb.append(", motherTongue=");
		sb.append(motherTongue);
		sb.append(", languageKnown=");
		sb.append(languageKnown);
		sb.append(", maritalStatus=");
		sb.append(maritalStatus);
		sb.append(", children=");
		sb.append(children);
		sb.append(", country=");
		sb.append(country);
		sb.append(", state=");
		sb.append(state);
		sb.append(", city=");
		sb.append(city);
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
		sb.append(", education=");
		sb.append(education);
		sb.append(", profession=");
		sb.append(profession);
		sb.append(", currency=");
		sb.append(currency);
		sb.append(", annualIncome=");
		sb.append(annualIncome);
		sb.append(", hobbies=");
		sb.append(hobbies);
		sb.append(", aboutMe=");
		sb.append(aboutMe);
		sb.append(", familyValue=");
		sb.append(familyValue);
		sb.append(", familyType=");
		sb.append(familyType);
		sb.append(", familyStatus=");
		sb.append(familyStatus);
		sb.append(", securityCode=");
		sb.append(securityCode);
		sb.append(", photoSecurityCode=");
		sb.append(photoSecurityCode);
		sb.append(", lastLoggedIn=");
		sb.append(lastLoggedIn);
		sb.append(", status=");
		sb.append(status);
		sb.append(", scheme=");
		sb.append(scheme);
		sb.append(", horoscope=");
		sb.append(horoscope);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append("}");

		return sb.toString();
	}

	public Profile toEntityModel() {
		ProfileImpl profileImpl = new ProfileImpl();

		profileImpl.setProfileId(profileId);

		if (profileCode == null) {
			profileImpl.setProfileCode(StringPool.BLANK);
		}
		else {
			profileImpl.setProfileCode(profileCode);
		}

		if (createdForMy == null) {
			profileImpl.setCreatedForMy(StringPool.BLANK);
		}
		else {
			profileImpl.setCreatedForMy(createdForMy);
		}

		if (name == null) {
			profileImpl.setName(StringPool.BLANK);
		}
		else {
			profileImpl.setName(name);
		}

		profileImpl.setGender(gender);

		if (birthDateWithTime == Long.MIN_VALUE) {
			profileImpl.setBirthDateWithTime(null);
		}
		else {
			profileImpl.setBirthDateWithTime(new Date(birthDateWithTime));
		}

		if (rasi == null) {
			profileImpl.setRasi(StringPool.BLANK);
		}
		else {
			profileImpl.setRasi(rasi);
		}

		if (star == null) {
			profileImpl.setStar(StringPool.BLANK);
		}
		else {
			profileImpl.setStar(star);
		}

		if (dosam == null) {
			profileImpl.setDosam(StringPool.BLANK);
		}
		else {
			profileImpl.setDosam(dosam);
		}

		if (religion == null) {
			profileImpl.setReligion(StringPool.BLANK);
		}
		else {
			profileImpl.setReligion(religion);
		}

		if (caste == null) {
			profileImpl.setCaste(StringPool.BLANK);
		}
		else {
			profileImpl.setCaste(caste);
		}

		if (subCaste == null) {
			profileImpl.setSubCaste(StringPool.BLANK);
		}
		else {
			profileImpl.setSubCaste(subCaste);
		}

		if (height == null) {
			profileImpl.setHeight(StringPool.BLANK);
		}
		else {
			profileImpl.setHeight(height);
		}

		if (weight == null) {
			profileImpl.setWeight(StringPool.BLANK);
		}
		else {
			profileImpl.setWeight(weight);
		}

		if (complexion == null) {
			profileImpl.setComplexion(StringPool.BLANK);
		}
		else {
			profileImpl.setComplexion(complexion);
		}

		if (motherTongue == null) {
			profileImpl.setMotherTongue(StringPool.BLANK);
		}
		else {
			profileImpl.setMotherTongue(motherTongue);
		}

		if (languageKnown == null) {
			profileImpl.setLanguageKnown(StringPool.BLANK);
		}
		else {
			profileImpl.setLanguageKnown(languageKnown);
		}

		if (maritalStatus == null) {
			profileImpl.setMaritalStatus(StringPool.BLANK);
		}
		else {
			profileImpl.setMaritalStatus(maritalStatus);
		}

		profileImpl.setChildren(children);

		if (country == null) {
			profileImpl.setCountry(StringPool.BLANK);
		}
		else {
			profileImpl.setCountry(country);
		}

		if (state == null) {
			profileImpl.setState(StringPool.BLANK);
		}
		else {
			profileImpl.setState(state);
		}

		if (city == null) {
			profileImpl.setCity(StringPool.BLANK);
		}
		else {
			profileImpl.setCity(city);
		}

		if (address == null) {
			profileImpl.setAddress(StringPool.BLANK);
		}
		else {
			profileImpl.setAddress(address);
		}

		if (pinCode == null) {
			profileImpl.setPinCode(StringPool.BLANK);
		}
		else {
			profileImpl.setPinCode(pinCode);
		}

		if (phone == null) {
			profileImpl.setPhone(StringPool.BLANK);
		}
		else {
			profileImpl.setPhone(phone);
		}

		if (mobile == null) {
			profileImpl.setMobile(StringPool.BLANK);
		}
		else {
			profileImpl.setMobile(mobile);
		}

		if (emailAddress == null) {
			profileImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			profileImpl.setEmailAddress(emailAddress);
		}

		if (education == null) {
			profileImpl.setEducation(StringPool.BLANK);
		}
		else {
			profileImpl.setEducation(education);
		}

		if (profession == null) {
			profileImpl.setProfession(StringPool.BLANK);
		}
		else {
			profileImpl.setProfession(profession);
		}

		if (currency == null) {
			profileImpl.setCurrency(StringPool.BLANK);
		}
		else {
			profileImpl.setCurrency(currency);
		}

		if (annualIncome == null) {
			profileImpl.setAnnualIncome(StringPool.BLANK);
		}
		else {
			profileImpl.setAnnualIncome(annualIncome);
		}

		if (hobbies == null) {
			profileImpl.setHobbies(StringPool.BLANK);
		}
		else {
			profileImpl.setHobbies(hobbies);
		}

		if (aboutMe == null) {
			profileImpl.setAboutMe(StringPool.BLANK);
		}
		else {
			profileImpl.setAboutMe(aboutMe);
		}

		if (familyValue == null) {
			profileImpl.setFamilyValue(StringPool.BLANK);
		}
		else {
			profileImpl.setFamilyValue(familyValue);
		}

		if (familyType == null) {
			profileImpl.setFamilyType(StringPool.BLANK);
		}
		else {
			profileImpl.setFamilyType(familyType);
		}

		if (familyStatus == null) {
			profileImpl.setFamilyStatus(StringPool.BLANK);
		}
		else {
			profileImpl.setFamilyStatus(familyStatus);
		}

		if (securityCode == null) {
			profileImpl.setSecurityCode(StringPool.BLANK);
		}
		else {
			profileImpl.setSecurityCode(securityCode);
		}

		if (photoSecurityCode == null) {
			profileImpl.setPhotoSecurityCode(StringPool.BLANK);
		}
		else {
			profileImpl.setPhotoSecurityCode(photoSecurityCode);
		}

		if (lastLoggedIn == Long.MIN_VALUE) {
			profileImpl.setLastLoggedIn(null);
		}
		else {
			profileImpl.setLastLoggedIn(new Date(lastLoggedIn));
		}

		profileImpl.setStatus(status);
		profileImpl.setScheme(scheme);
		profileImpl.setHoroscope(horoscope);
		profileImpl.setCreatedBy(createdBy);
		profileImpl.setModifiedBy(modifiedBy);

		if (createdDate == Long.MIN_VALUE) {
			profileImpl.setCreatedDate(null);
		}
		else {
			profileImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			profileImpl.setModifiedDate(null);
		}
		else {
			profileImpl.setModifiedDate(new Date(modifiedDate));
		}

		profileImpl.setCompanyId(companyId);
		profileImpl.setGroupId(groupId);

		profileImpl.resetOriginalValues();

		return profileImpl;
	}

	public long profileId;
	public String profileCode;
	public String createdForMy;
	public String name;
	public boolean gender;
	public long birthDateWithTime;
	public String rasi;
	public String star;
	public String dosam;
	public String religion;
	public String caste;
	public String subCaste;
	public String height;
	public String weight;
	public String complexion;
	public String motherTongue;
	public String languageKnown;
	public String maritalStatus;
	public int children;
	public String country;
	public String state;
	public String city;
	public String address;
	public String pinCode;
	public String phone;
	public String mobile;
	public String emailAddress;
	public String education;
	public String profession;
	public String currency;
	public String annualIncome;
	public String hobbies;
	public String aboutMe;
	public String familyValue;
	public String familyType;
	public String familyStatus;
	public String securityCode;
	public String photoSecurityCode;
	public long lastLoggedIn;
	public int status;
	public int scheme;
	public boolean horoscope;
	public long createdBy;
	public long modifiedBy;
	public long createdDate;
	public long modifiedDate;
	public long companyId;
	public long groupId;
}