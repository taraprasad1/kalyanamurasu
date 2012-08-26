package com.matrimony;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.image.ImageBag;
import com.liferay.portal.kernel.image.ImageToolUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Region;
import com.liferay.portal.service.RegionServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.matrimony.constant.KeyValueConstants;
import com.matrimony.constant.ProfileConstants;
import com.matrimony.model.Caste;
import com.matrimony.model.City;
import com.matrimony.model.Photo;
import com.matrimony.model.Profile;
import com.matrimony.model.SubCaste;
import com.matrimony.service.CasteLocalServiceUtil;
import com.matrimony.service.CityLocalServiceUtil;
import com.matrimony.service.KeyValueLocalServiceUtil;
import com.matrimony.service.PhotoLocalServiceUtil;
import com.matrimony.service.SubCasteLocalServiceUtil;
import com.matrimony.util.MatrimonyPropsValues;

public class MatrimonyController extends MVCPortlet {

	private static final String RELIGION_ID_EMPTY = "ReligionId Empty: ";

	private static final String REGION_ID_EMPTY = "RegionId Empty: ";
	private static final String COMPANY_ID_EMPTY = "CompanyId Empty: ";
	private static final String ERROE_FETCHING_REGION_LIST = "Error While Fetching RegionList Using CountryId: ";
	private static final String ERROE_FETCHING_CITY_LIST = "Error While Fetching CityList Using RegionId: ";
	private static final String ERROE_FETCHING_CASTE_LIST = "Error While Fetching CasteList Using ReligionId: ";
	private static final String ERROE_FETCHING_SUBCASTE_LIST = "Error While Fetching SubCasteList Using CasteId: ";
	private static final String INSIDE_SERVE_RESOURCE_METHOD = "Inside ServeResource Method: ";
	private static final String ERROR_PROCESSING_IMAGE = "Error while Processing Image For ImageId: ";

	private static final Log LOGGER = LogFactoryUtil
			.getLog(MatrimonyController.class);

	public Profile getAssetFromForm(Profile profile, ActionRequest actionRequest) {

		profile.setCreatedForMy(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_CREATED_FOR_MY));
		profile.setName(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_NAME));
		String gender = ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_GENDER);
		if (gender.equalsIgnoreCase(ProfileConstants.PROFILE_MALE)) {
			profile.setGender(Boolean.TRUE);
		} else {
			profile.setGender(Boolean.FALSE);
		}
		profile.setRasi(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_RASI));
		profile.setStar(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_STAR));
		profile.setDosam(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_DOSAM));
		profile.setReligion(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_RELIGION));
		profile.setCaste(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_CASTE));
		profile.setSubCaste(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_SUB_CASTE));
		profile.setHeight(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_HEIGHT));
		profile.setWeight(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_WEIGHT));
		profile.setComplexion(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_COMPLEXION));
		profile.setMotherTongue(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_MOTHER_TONGUE));
		profile.setLanguageKnown(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_LANGUAGE_KNOWN));
		profile.setMaritalStatus(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_MARITAL_STATUS));
		profile.setChildren(ParamUtil.getInteger(actionRequest,
				ProfileConstants.PROFILE_CHILDREN));
		profile.setCountry(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_COUNTRY));
		profile.setState(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_STATE));
		profile.setCity(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_CITY));
		profile.setAddress(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_ADDRESS));
		profile.setPinCode(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_PIN_CODE));
		profile.setPhone(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_PHONE));
		profile.setMobile(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_MOBILE));
		profile.setEmailAddress(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_EMAIL_ADDRESS));
		profile.setEducation(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_EDUCATION));
		profile.setProfession(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_PROFESSION));
		profile.setCurrency(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_CURRENCY));
		profile.setAnnualIncome(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_ANNUAL_INCOME));
		profile.setHobbies(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_HOBBIES));
		profile.setAboutMe(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_ABOUT_ME));
		profile.setFamilyValue(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_FAMILY_VALUE));
		profile.setFamilyType(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_FAMILY_TYPE));
		profile.setFamilyStatus(ParamUtil.getString(actionRequest,
				ProfileConstants.PROFILE_FAMILY_STATUS));
		profile.setBirthDateWithTime(getBirthDate(actionRequest));

		return profile;
	}

	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(INSIDE_SERVE_RESOURCE_METHOD
					+ MatrimonyController.class.getName());
		}
		String action = resourceRequest.getParameter(KeyValueConstants.ACTION);
		if (Validator.isNotNull(action)) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			JSONArray values = JSONFactoryUtil.getJSONFactory()
					.createJSONArray();
			boolean isValid = Boolean.FALSE;
			if (action.equalsIgnoreCase(ProfileConstants.ACTION_POPULATE_STATE)) {
				long countryId = ParamUtil.getLong(resourceRequest,
						ProfileConstants.PROFILE_COUNTRY_ID);
				if (Validator.isNotNull(countryId)) {
					try {
						List<Region> regions = RegionServiceUtil
								.getRegions(countryId);
						if (Validator.isNotNull(regions)) {
							for (Region region : regions) {
								values.put(region.getName() + StringPool.COLON
										+ region.getRegionId());
							}
						}
					} catch (SystemException e) {
						LOGGER.error(ERROE_FETCHING_REGION_LIST + countryId
								+ StringPool.COMMA_AND_SPACE + e.getMessage(),
								e);
					}
				} else {
					if (LOGGER.isDebugEnabled()) {
						LOGGER.debug(INSIDE_SERVE_RESOURCE_METHOD
								+ COMPANY_ID_EMPTY
								+ MatrimonyController.class.getName());
					}
				}
			} else if (action
					.equalsIgnoreCase(ProfileConstants.ACTION_POPULATE_CITY)) {
				long regionId = ParamUtil.getLong(resourceRequest,
						ProfileConstants.PROFILE_REGION_ID);
				if (Validator.isNotNull(regionId)) {
					try {
						List<City> cities = CityLocalServiceUtil
								.getRegion_Cities(regionId);
						if (Validator.isNotNull(cities)) {
							for (City city : cities) {
								values.put(city.getCityName());
							}
						}
					} catch (SystemException e) {
						LOGGER.error(ERROE_FETCHING_CITY_LIST + regionId
								+ StringPool.COMMA_AND_SPACE + e.getMessage(),
								e);
					}
				} else {
					if (LOGGER.isDebugEnabled()) {
						LOGGER.debug(INSIDE_SERVE_RESOURCE_METHOD
								+ REGION_ID_EMPTY
								+ MatrimonyController.class.getName());
					}
				}
			} else if (action
					.equalsIgnoreCase(ProfileConstants.ACTION_POPULATE_CASTE)) {
				long religionId = ParamUtil.getLong(resourceRequest,
						ProfileConstants.PROFILE_RELIGION_ID);
				if (Validator.isNotNull(religionId)) {
					try {
						List<Caste> casteList = CasteLocalServiceUtil
								.getCasteListByReligionId(religionId);
						if (Validator.isNotNull(casteList)) {
							for (Caste caste : casteList) {
								values.put(caste.getName() + StringPool.COLON
										+ caste.getCasteId());
							}
						}
					} catch (SystemException e) {
						LOGGER.error(ERROE_FETCHING_CASTE_LIST + religionId
								+ StringPool.COMMA_AND_SPACE + e.getMessage(),
								e);
					}
				} else {
					if (LOGGER.isDebugEnabled()) {
						LOGGER.debug(INSIDE_SERVE_RESOURCE_METHOD
								+ RELIGION_ID_EMPTY
								+ MatrimonyController.class.getName());
					}
				}
			} else if (action
					.equalsIgnoreCase(ProfileConstants.ACTION_POPULATE_SUB_CASTE)) {
				long casteId = ParamUtil.getLong(resourceRequest,
						ProfileConstants.PROFILE_CASTE_ID);
				if (Validator.isNotNull(casteId)) {
					try {
						List<SubCaste> subCasteList = SubCasteLocalServiceUtil
								.getSubCasteListByCasteId(casteId);
						if (Validator.isNotNull(subCasteList)) {
							for (SubCaste subCaste : subCasteList) {
								values.put(subCaste.getName());
							}
						}
					} catch (SystemException e) {
						LOGGER.error(ERROE_FETCHING_SUBCASTE_LIST + casteId
								+ StringPool.COMMA_AND_SPACE + e.getMessage(),
								e);
					}
				} else {
					if (LOGGER.isDebugEnabled()) {
						LOGGER.debug(INSIDE_SERVE_RESOURCE_METHOD
								+ "CasteId Empty: "
								+ MatrimonyController.class.getName());
					}
				}
			}
			if (Validator.isNotNull(values)) {
				if (values.length() > 0) {
					jsonObject.put(ProfileConstants.OTHER_ARRAY_LIST, values);
					isValid = Boolean.TRUE;
				} else if (action
						.equalsIgnoreCase(ProfileConstants.ACTION_POPULATE_SUB_CASTE)
						|| action
								.equalsIgnoreCase(ProfileConstants.ACTION_POPULATE_CASTE)) {
					jsonObject.put(ProfileConstants.OTHER_ARRAY_LIST, values);
					isValid = Boolean.TRUE;
				}
			} else if (action
					.equalsIgnoreCase(ProfileConstants.ACTION_POPULATE_SUB_CASTE)
					|| action
							.equalsIgnoreCase(ProfileConstants.ACTION_POPULATE_CASTE)) {
				jsonObject.put(ProfileConstants.OTHER_ARRAY_LIST, values);
				isValid = Boolean.TRUE;
			}
			jsonObject.put(ProfileConstants.OTHER_IS_VALID, isValid);
			resourceResponse.setContentType(KeyValueConstants.APPLICATION_JSON);
			resourceResponse.setCharacterEncoding(KeyValueConstants.UTF_8);
			resourceResponse.getWriter().write(jsonObject.toString());
		} else {
			HttpServletRequest servletRequest = PortalUtil
					.getHttpServletRequest(resourceRequest);
			HttpServletResponse servletResponse = PortalUtil
					.getHttpServletResponse(resourceResponse);
			long imageId = ParamUtil.getLong(resourceRequest,
					ProfileConstants.IMAGE_ID);
			boolean thumbnail = ParamUtil.getBoolean(resourceRequest,
					ProfileConstants.IMAGE_THUMBNAIL);
			int width = ParamUtil.getInteger(resourceRequest,
					ProfileConstants.IMAGE_WIDTH);
			int height = ParamUtil.getInteger(resourceRequest,
					ProfileConstants.IMAGE_HEIGHT);
			boolean download = ParamUtil.getBoolean(resourceRequest,
					ProfileConstants.IMAGE_DOWNLOAD);

			if (Validator.isNull(thumbnail)) {
				thumbnail = false;
			}
			if (width == 0 && height == 0) {
				width = MatrimonyPropsValues.IMAGE_WIDTH;
				height = MatrimonyPropsValues.IMAGE_HEIGHT;
			}
			if (Validator.isNotNull(imageId)) {
				try {
					Photo image = PhotoLocalServiceUtil.getPhoto(imageId);

					byte[] bytes = (byte[]) Base64.decode(image.getContent());
					if (thumbnail) {
						ImageBag imageBag = ImageToolUtil.read(bytes);
						RenderedImage thumbnailImage = imageBag
								.getRenderedImage();
						thumbnailImage = ImageToolUtil.scale(thumbnailImage,
								height, width);
						bytes = ImageToolUtil.getBytes(thumbnailImage,
								imageBag.getType());
					}
					if (download) {
						ServletResponseUtil.sendFile(servletRequest,
								servletResponse, image.getName(), bytes);
					} else {
						ServletResponseUtil.write(servletResponse, bytes);
					}
				} catch (PortalException e) {
					LOGGER.error(ERROR_PROCESSING_IMAGE + imageId
							+ StringPool.COMMA_AND_SPACE + e.getMessage(), e);
				} catch (SystemException e) {
					LOGGER.error(ERROR_PROCESSING_IMAGE + imageId
							+ StringPool.COMMA_AND_SPACE + e.getMessage(), e);
				}
			}
		}
		super.serveResource(resourceRequest, resourceResponse);
	}

	public Date getBirthDate(ActionRequest actionRequest) {
		Calendar birthCal = Calendar.getInstance();
		int year = ParamUtil.getInteger(actionRequest,
				ProfileConstants.PROFILE_DATE_YEAR);
		int month = ParamUtil.getInteger(actionRequest,
				ProfileConstants.PROFILE_DATE_MONTH);
		int date = ParamUtil.getInteger(actionRequest,
				ProfileConstants.PROFILE_DATE_DAY);
		int minute = ParamUtil.getInteger(actionRequest,
				ProfileConstants.PROFILE_DATE_MINUTE);
		int hourOfDay = ParamUtil.getInteger(actionRequest,
				ProfileConstants.PROFILE_DATE_HOUR);
		birthCal.set(year, month, date, hourOfDay, minute);
		return birthCal.getTime();
	}

	public void setDropDownValues(RenderRequest renderRequest) {
		renderRequest
				.setAttribute(
						ProfileConstants.PROFILE_ANNUAL_INCOME,
						KeyValueLocalServiceUtil
								.getKeyValueList(ProfileConstants.PROFILE_ANNUAL_INCOME));
		renderRequest.setAttribute(ProfileConstants.PROFILE_CHILDREN,
				KeyValueLocalServiceUtil
						.getKeyValueList(ProfileConstants.PROFILE_CHILDREN));
		renderRequest.setAttribute(ProfileConstants.PROFILE_CURRENCY,
				KeyValueLocalServiceUtil
						.getKeyValueList(ProfileConstants.PROFILE_CURRENCY));
		renderRequest.setAttribute(ProfileConstants.PROFILE_COMPLEXION,
				KeyValueLocalServiceUtil
						.getKeyValueList(ProfileConstants.PROFILE_COMPLEXION));
		renderRequest
				.setAttribute(
						ProfileConstants.PROFILE_CREATED_FOR_MY,
						KeyValueLocalServiceUtil
								.getKeyValueList(ProfileConstants.PROFILE_CREATED_FOR_MY));
		renderRequest.setAttribute(ProfileConstants.PROFILE_DOSAM,
				KeyValueLocalServiceUtil
						.getKeyValueList(ProfileConstants.PROFILE_DOSAM));
		renderRequest.setAttribute(ProfileConstants.PROFILE_EDUCATION,
				KeyValueLocalServiceUtil
						.getKeyValueList(ProfileConstants.PROFILE_EDUCATION));
		renderRequest
				.setAttribute(
						ProfileConstants.PROFILE_FAMILY_STATUS,
						KeyValueLocalServiceUtil
								.getKeyValueList(ProfileConstants.PROFILE_FAMILY_STATUS));
		renderRequest.setAttribute(ProfileConstants.PROFILE_FAMILY_TYPE,
				KeyValueLocalServiceUtil
						.getKeyValueList(ProfileConstants.PROFILE_FAMILY_TYPE));
		renderRequest
				.setAttribute(
						ProfileConstants.PROFILE_FAMILY_VALUE,
						KeyValueLocalServiceUtil
								.getKeyValueList(ProfileConstants.PROFILE_FAMILY_VALUE));
		renderRequest.setAttribute(ProfileConstants.PROFILE_HEIGHT,
				KeyValueLocalServiceUtil
						.getKeyValueList(ProfileConstants.PROFILE_HEIGHT));
		renderRequest.setAttribute(ProfileConstants.PROFILE_HOBBIES,
				KeyValueLocalServiceUtil
						.getKeyValueList(ProfileConstants.PROFILE_HOBBIES));
		renderRequest.setAttribute(ProfileConstants.PROFILE_LANGUAGE,
				KeyValueLocalServiceUtil
						.getKeyValueList(ProfileConstants.PROFILE_LANGUAGE));
		renderRequest
				.setAttribute(
						ProfileConstants.PROFILE_MARITAL_STATUS,
						KeyValueLocalServiceUtil
								.getKeyValueList(ProfileConstants.PROFILE_MARITAL_STATUS));
		renderRequest.setAttribute(ProfileConstants.PROFILE_PROFESSION,
				KeyValueLocalServiceUtil
						.getKeyValueList(ProfileConstants.PROFILE_PROFESSION));
		renderRequest.setAttribute(ProfileConstants.PROFILE_RASI,
				KeyValueLocalServiceUtil
						.getKeyValueList(ProfileConstants.PROFILE_RASI));
		renderRequest.setAttribute(ProfileConstants.PROFILE_STAR,
				KeyValueLocalServiceUtil
						.getKeyValueList(ProfileConstants.PROFILE_STAR));
		renderRequest.setAttribute(ProfileConstants.PROFILE_WEIGHT,
				KeyValueLocalServiceUtil
						.getKeyValueList(ProfileConstants.PROFILE_WEIGHT));
	}
}