package com.matrimony;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.matrimony.model.Profile;

public class MatrimonyController extends MVCPortlet{
	private static final Log LOGGER = LogFactoryUtil.getLog(MatrimonyController.class);
	public Profile getAssetFromForm(Profile profile, ActionRequest actionRequest) {
		profile.setCreatedForMy(ParamUtil.getString(actionRequest, "createdForMy"));
		profile.setName(ParamUtil.getString(actionRequest, "name"));
		String gender = ParamUtil.getString(actionRequest, "gender");
		if(gender.equalsIgnoreCase("male")){
			profile.setGender(true);
		} else {
			profile.setGender(false);
		}
		profile.setRasi(ParamUtil.getString(actionRequest, "rasi"));
		profile.setStar(ParamUtil.getString(actionRequest, "star"));
		profile.setDosam(ParamUtil.getString(actionRequest, "dosam"));
		profile.setReligion(ParamUtil.getString(actionRequest, "religion"));
		profile.setCaste(ParamUtil.getString(actionRequest, "caste"));
		profile.setSubCaste(ParamUtil.getString(actionRequest, "subCaste"));
		profile.setHeight(ParamUtil.getString(actionRequest, "height"));
		profile.setWeight(ParamUtil.getString(actionRequest, "weight"));
		profile.setComplexion(ParamUtil.getString(actionRequest, "complexion"));
		profile.setMotherTongue(ParamUtil.getString(actionRequest, "motherTongue"));
		profile.setLanguageKnown(ParamUtil.getString(actionRequest, "languageKnown"));
		profile.setMaritalStatus(ParamUtil.getString(actionRequest, "maritalStatus"));
		profile.setChildren(ParamUtil.getInteger(actionRequest, "children"));
		profile.setCountry(ParamUtil.getString(actionRequest, "country"));
		profile.setState(ParamUtil.getString(actionRequest, "state"));
		profile.setCity(ParamUtil.getString(actionRequest, "city"));
		profile.setAddress(ParamUtil.getString(actionRequest, "address"));
		profile.setPinCode(ParamUtil.getString(actionRequest, "pinCode"));
		profile.setPhone(ParamUtil.getString(actionRequest, "phone"));
		profile.setMobile(ParamUtil.getString(actionRequest, "mobile"));
		profile.setEmailAddress(ParamUtil.getString(actionRequest, "emailAddress"));
		profile.setEducation(ParamUtil.getString(actionRequest, "education"));
		profile.setProfession(ParamUtil.getString(actionRequest, "profession"));
		profile.setCurrency(ParamUtil.getString(actionRequest, "currency"));
		profile.setAnnualIncome(ParamUtil.getString(actionRequest, "annualIncome"));
		profile.setHobbies(ParamUtil.getString(actionRequest, "hobbies"));
		profile.setAboutMe(ParamUtil.getString(actionRequest, "aboutMe"));
		profile.setFamilyValue(ParamUtil.getString(actionRequest, "familyValue"));
		profile.setFamilyType(ParamUtil.getString(actionRequest, "familyType"));
		profile.setFamilyStatus(ParamUtil.getString(actionRequest, "familyStatus"));
		profile.setSecurityCode(ParamUtil.getString(actionRequest, "securityCode"));
		profile.setPhotoSecurityCode(ParamUtil.getString(actionRequest, "photoSecurityCode"));
		profile.setStatus(ParamUtil.getInteger(actionRequest, "setStatus"));
		profile.setScheme(ParamUtil.getInteger(actionRequest, "scheme"));
		profile.setHoroscope(ParamUtil.getBoolean(actionRequest, "horoscope"));
		
		return profile;
	}
}
