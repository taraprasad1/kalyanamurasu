package com.matrimony;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.image.ImageBag;
import com.liferay.portal.kernel.image.ImageToolUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchException;
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
import com.matrimony.constant.KeyValueConstants;
import com.matrimony.constant.ProfileConstants;
import com.matrimony.model.Photo;
import com.matrimony.model.Profile;
import com.matrimony.model.impl.PhotoImpl;
import com.matrimony.service.PhotoLocalServiceUtil;
import com.matrimony.service.ProfileLocalServiceUtil;
import com.matrimony.util.CommonUtil;

/**
 * Portlet implementation class Profile
 */
public class ProfilePortlet extends MatrimonyController {

	private static final String IMAGE_UPDATED_SUCCESSFULLY = "image-updated-successfully";
	private static final String IMAGE_ADDED_SUCCESSFULLY = "image-updated-successfully";
	private static final String INSIDE_DELETE_PROFILE_METHOD = "Inside Delete Profile Method: ";
	private static final String INSIDE_UPDATE_PROFILE_METHOD = "Inside Update Profile Method: ";
	private static final String INSIDE_UPDATE_PHOTO_METHOD = "Inside Update Photo Method: ";
	private static final String INSIDE_DO_VIEW = "Inside doView Method: : ";

	private static final Log LOGGER = LogFactoryUtil
			.getLog(ProfilePortlet.class);

	public void deleteAccount(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(INSIDE_DELETE_PROFILE_METHOD
					+ ProfilePortlet.class.getName());
		}
		long profileId = ParamUtil.getLong(actionRequest,
				ProfileConstants.PROFILE_ID);
		if (Validator.isNotNull(profileId)) {
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
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(INSIDE_UPDATE_PROFILE_METHOD
					+ ProfilePortlet.class.getName());
		}
		long profileId = ParamUtil.getLong(actionRequest,
				ProfileConstants.PROFILE_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Profile profile = ProfileLocalServiceUtil.createProfileObj();
		if (Validator.isNotNull(profileId)) {
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
		if (Validator.isNotNull(profileId)) {
			try {
				ProfileLocalServiceUtil.updateProfileObj(profile);
			} catch (SearchException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
		} else {
			try {
				ProfileLocalServiceUtil.addProfileObj(profile);
			} catch (SearchException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(INSIDE_DO_VIEW + ProfilePortlet.class.getName());
		}
		String viewAction = ParamUtil.getString(renderRequest,
				KeyValueConstants.ACTION);
		if (Validator.isNotNull(viewAction)) {
			if (viewAction
					.equalsIgnoreCase(ProfileConstants.PROFILE_VIEW_EDIT_PAGE)) {
				String profileId = ParamUtil.getString(renderRequest,
						ProfileConstants.PROFILE_ID);
				if (Validator.isNotNull(profileId)) {
					renderRequest.setAttribute(ProfileConstants.PROFILE_ID,
							profileId);
				}
				setDropDownValues(renderRequest);
				viewTemplate = ProfileConstants.PROFILE_EDIT_PAGE_URL;
			} else {
				viewTemplate = ProfileConstants.PROFILE_LIST_PAGE_URL;
			}
		} else {
			viewTemplate = ProfileConstants.PROFILE_LIST_PAGE_URL;
		}
		super.doView(renderRequest, renderResponse);
	}

	public void updatePhoto(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(INSIDE_UPDATE_PHOTO_METHOD
					+ ProfilePortlet.class.getName());
		}
		UploadPortletRequest uploadPortletRequest = PortalUtil
				.getUploadPortletRequest(actionRequest);
		HttpServletRequest servletRequest = PortalUtil
				.getHttpServletRequest(actionRequest);
		try {
			boolean validate = CommonUtil.validatePhoto(uploadPortletRequest);
			if (validate) {
				Photo photo = null;
				File file = uploadPortletRequest
						.getFile(ProfileConstants.IMAGE_PROFILE_PHOTO);
				long profileId = ParamUtil.getLong(actionRequest,
						ProfileConstants.PROFILE_ID);
				long imageId = ParamUtil.getLong(actionRequest,
						ProfileConstants.IMAGE_ID);
				boolean thumbnail = ParamUtil.getBoolean(actionRequest,
						ProfileConstants.IMAGE_THUMBNAIL);
				byte[] bytes = FileUtil.getBytes(file);
				String name = uploadPortletRequest
						.getFileName(ProfileConstants.IMAGE_PROFILE_PHOTO);
				ImageBag imageBag = ImageToolUtil.read(bytes);
				if (imageId > 0) {
					photo = PhotoLocalServiceUtil.getPhoto(imageId);
					photo.setName(name);
					photo.setContent(Base64.encode(bytes));
					photo.setType(imageBag.getType());
					PhotoLocalServiceUtil.updatePhoto(photo);
					SessionMessages.add(servletRequest,
							IMAGE_UPDATED_SUCCESSFULLY);
				} else {
					photo = new PhotoImpl();
					photo.setName(name);
					photo.setContent(Base64.encode(bytes));
					photo.setProfileId(profileId);
					photo.setThumbnail(thumbnail);
					photo.setType(imageBag.getType());
					PhotoLocalServiceUtil.addPhoto(photo);
					SessionMessages.add(servletRequest,
							IMAGE_ADDED_SUCCESSFULLY);
				}
				actionResponse.setRenderParameter(
						ProfileConstants.OTHER_JSP_PAGE,
						ProfileConstants.PROFILE_LIST_PAGE_URL);
			}

		} catch (Exception exception) {
			if (exception instanceof InvalidImageException
					|| exception instanceof InvalidImageTypeException
					|| exception instanceof ImageSizeExceedsLimitException) {
				SessionErrors.add(actionRequest,
						exception.getClass().getName(), exception);
			}
			actionResponse.setRenderParameter(ProfileConstants.OTHER_JSP_PAGE,
					ProfileConstants.PROFILE_EDIT_PHOTO_URL);
		}
	}
}