package com.matrimony;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.image.ImageBag;
import com.liferay.portal.kernel.image.ImageToolUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.matrimony.constant.ProfileConstants;
import com.matrimony.model.Photo;
import com.matrimony.model.Profile;
import com.matrimony.model.impl.PhotoImpl;
import com.matrimony.service.PhotoLocalServiceUtil;
import com.matrimony.service.ProfileLocalServiceUtil;
import com.matrimony.util.CommonUtil;
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
				e.printStackTrace();
			} catch (SystemException e) {
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
	public void updatePhoto(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		UploadPortletRequest uploadPortletRequest =
			PortalUtil.getUploadPortletRequest(actionRequest);
		HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(actionRequest);
		try {
			boolean validate =  CommonUtil.validatePhoto(uploadPortletRequest);
			if (validate) {
				Photo photo = null;
				File file = uploadPortletRequest.getFile("profilePhoto");
				long profileId = ParamUtil.getLong(actionRequest, "profileId");
				long imageId = ParamUtil.getLong(actionRequest, "imageId");
				boolean thumbnail = ParamUtil.getBoolean(actionRequest, "thumbnail");
				byte[] bytes = FileUtil.getBytes(file);
				String name = uploadPortletRequest.getFileName("profilePhoto");
				ImageBag imageBag = ImageToolUtil.read(bytes);
				if (imageId > 0){
					photo = PhotoLocalServiceUtil.getPhoto(imageId);			
					photo.setName(name);
					photo.setContent(Base64.encode(bytes));
					photo.setType(imageBag.getType());
					PhotoLocalServiceUtil.updatePhoto(photo);
					SessionMessages.add(servletRequest, "image-updated-successfully");
				} else {
					photo = new PhotoImpl();
					photo.setName(name);
					photo.setContent(Base64.encode(bytes));
					photo.setProfileId(profileId);
					photo.setThumbnail(thumbnail);
					photo.setType(imageBag.getType());
					PhotoLocalServiceUtil.addPhoto(photo);
					SessionMessages.add(servletRequest, "image-added-successfully");
				}
				actionResponse.setRenderParameter("jspPage", "/html/matrimony/profile/list_profile.jsp");
			}
			
		} catch(Exception exception){
			if (exception instanceof InvalidImageException ||
					exception instanceof InvalidImageTypeException ||
					exception instanceof ImageSizeExceedsLimitException) {
				SessionErrors.add(actionRequest, exception.getClass().getName(), exception);	
			}
			actionResponse.setRenderParameter("jspPage",
					"/html/matrimony/profile/upload_photo.jsp");
		}
	}
}