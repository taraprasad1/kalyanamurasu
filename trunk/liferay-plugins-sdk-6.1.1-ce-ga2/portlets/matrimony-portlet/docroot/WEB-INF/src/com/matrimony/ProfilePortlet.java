package com.matrimony;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.matrimony.constant.ProfileConstants;
import com.matrimony.model.Profile;
import com.matrimony.service.ProfileLocalServiceUtil;
import com.matrimony.util.ProfileUtil;

/**
 * Portlet implementation class Profile
 */
public class ProfilePortlet extends MatrimonyController {
	private static final Log LOGGER = LogFactoryUtil.getLog(ProfilePortlet.class);
	public void deleteAccount(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		
		long profileId  = ParamUtil.getLong(actionRequest, ProfileConstants.PROFILE_ID);
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
				e.printStackTrace();
			}
		} else {
			try {
				profile.setProfileCode(ProfileUtil.getProfileCode(profile));
				ProfileLocalServiceUtil.addProfile(profile);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
	}
}