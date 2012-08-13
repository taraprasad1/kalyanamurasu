package com.matrimony;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.matrimony.model.Profile;
import com.matrimony.service.ProfileLocalServiceUtil;

/**
 * Portlet implementation class Profile
 */
public class ProfilePortlet extends MVCPortlet {

	public void deleteAccount(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		
		long profileId  = ParamUtil.getLong(actionRequest, "profileId");
		if(Validator.isNotNull(profileId)) {			
			try {
				ProfileLocalServiceUtil.deleteProfile(profileId);
			} catch (PortalException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateAccount(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		System.out.println("update begin------->");
		long profileId = ParamUtil.getLong(actionRequest, "profileId");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Profile profile = ProfileLocalServiceUtil.createProfileObj();
		if(Validator.isNotNull(profileId)){
			try {
				profile = ProfileLocalServiceUtil.getProfile(profileId);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			profile.setCreatedDate(new Date());
			profile.setCreatedBy(themeDisplay.getUserId());
			profile.setCompanyId(themeDisplay.getCompanyId());
			profile.setGroupId(themeDisplay.getScopeGroupId());
		}
		profile.setModifiedBy(themeDisplay.getUserId());
		profile.setModifiedDate(new Date());
		profile = getAssetFromForm(profile, actionRequest);
		if(Validator.isNotNull(profileId)){
			 try {
				ProfileLocalServiceUtil.updateProfile(profile);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				ProfileLocalServiceUtil.addProfile(profile);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("update end --------->");
	}
	
	public Profile getAssetFromForm(Profile profile, ActionRequest actionRequest) {
		
		profile.setCreatedForMy(ParamUtil.getString(actionRequest, "createdForMy"));
		profile.setName(ParamUtil.getString(actionRequest, "name"));
		profile.setGender(ParamUtil.getBoolean(actionRequest, "gender"));
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