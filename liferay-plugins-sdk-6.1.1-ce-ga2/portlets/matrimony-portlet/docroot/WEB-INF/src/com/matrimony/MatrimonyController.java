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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.Region;
import com.liferay.portal.service.CountryServiceUtil;
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
import com.matrimony.service.PhotoLocalServiceUtil;
import com.matrimony.service.ReligionLocalServiceUtil;
import com.matrimony.service.SubCasteLocalServiceUtil;
import com.matrimony.util.MatrimonyPropsValues;
import com.matrimony.util.ProfileUtil;

public class MatrimonyController extends MVCPortlet {
	private static final Log LOGGER = LogFactoryUtil
			.getLog(MatrimonyController.class);

	public Profile getAssetFromForm(Profile profile, ActionRequest actionRequest) {
		profile.setCreatedForMy(ParamUtil.getString(actionRequest,
				"createdForMy"));
		profile.setName(ParamUtil.getString(actionRequest, "name"));
		String gender = ParamUtil.getString(actionRequest, "gender");
		if (gender.equalsIgnoreCase("male")) {
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
		profile.setMotherTongue(ParamUtil.getString(actionRequest,
				"motherTongue"));
		profile.setLanguageKnown(ParamUtil.getString(actionRequest,
				"languageKnown"));
		profile.setMaritalStatus(ParamUtil.getString(actionRequest,
				"maritalStatus"));
		profile.setChildren(ParamUtil.getInteger(actionRequest, "children"));
		profile.setCountry(ParamUtil.getString(actionRequest, "country"));
		profile.setState(ParamUtil.getString(actionRequest, "state"));
		profile.setCity(ParamUtil.getString(actionRequest, "city"));
		profile.setAddress(ParamUtil.getString(actionRequest, "address"));
		profile.setPinCode(ParamUtil.getString(actionRequest, "pinCode"));
		profile.setPhone(ParamUtil.getString(actionRequest, "phone"));
		profile.setMobile(ParamUtil.getString(actionRequest, "mobile"));
		profile.setEmailAddress(ParamUtil.getString(actionRequest,
				"emailAddress"));
		profile.setEducation(ParamUtil.getString(actionRequest, "education"));
		profile.setProfession(ParamUtil.getString(actionRequest, "profession"));
		profile.setCurrency(ParamUtil.getString(actionRequest, "currency"));
		profile.setAnnualIncome(ParamUtil.getString(actionRequest,
				"annualIncome"));
		profile.setHobbies(ParamUtil.getString(actionRequest, "hobbies"));
		profile.setAboutMe(ParamUtil.getString(actionRequest, "aboutMe"));
		profile.setFamilyValue(ParamUtil
				.getString(actionRequest, "familyValue"));
		profile.setFamilyType(ParamUtil.getString(actionRequest, "familyType"));
		profile.setFamilyStatus(ParamUtil.getString(actionRequest,
				"familyStatus"));
		profile.setSecurityCode(ParamUtil.getString(actionRequest,
				"securityCode"));
		profile.setPhotoSecurityCode(ParamUtil.getString(actionRequest,
				"photoSecurityCode"));
		profile.setStatus(ParamUtil.getInteger(actionRequest, "setStatus"));
		profile.setScheme(ParamUtil.getInteger(actionRequest, "scheme"));
		profile.setHoroscope(ParamUtil.getBoolean(actionRequest, "horoscope"));
		profile.setBirthDateWithTime(getBirthDate(actionRequest));

		return profile;
	}

	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		System.out.println("Inside Serve Resource Method:");
		String action = resourceRequest.getParameter("action");
		if (Validator.isNotNull(action)) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			JSONArray values = JSONFactoryUtil.getJSONFactory().createJSONArray();
			boolean isValid = Boolean.FALSE;
			if(action.equalsIgnoreCase("populateState")){
				long countryId = ParamUtil.getLong(resourceRequest, "countryId");
				if(Validator.isNotNull(countryId)){
					try {
						List<Region> regions = RegionServiceUtil.getRegions(countryId);
						if(Validator.isNotNull(regions)){
							for(Region region: regions){
								values.put(region.getName() + ":" + region.getRegionId());
							}
						}
					} catch (SystemException e) {
						System.out.println("Error fetching RegionList Using CountryId" + countryId);
					}
				} else {
					System.out.println("CountryId is Empty");
				}
			} else if(action.equalsIgnoreCase("populateCity")){
				long regionId = ParamUtil.getLong(resourceRequest, "regionId");
				if(Validator.isNotNull(regionId)){
					try {
						List<City> cities = CityLocalServiceUtil.getRegion_Cities(regionId);
						if(Validator.isNotNull(cities)){
							for(City city: cities){
								values.put(city.getCityName());
							}
						}
					} catch (SystemException e) {
						System.out.println("Error fetching CityList Using RegionId" + regionId);
					}
				} else {
					System.out.println("RegionId is Empty");
				}
			} else if(action.equalsIgnoreCase("populateCaste")){
				long religionId = ParamUtil.getLong(resourceRequest, "religionId");
				if(Validator.isNotNull(religionId)){
					try {
						List<Caste> casteList = CasteLocalServiceUtil.getCasteListByReligionId(religionId);
						if(Validator.isNotNull(casteList)){
							for(Caste caste: casteList){
								values.put(caste.getName() + ":" + caste.getCasteId());
							}
						}
						System.out.println("casteList===========>>" + casteList.size());
					} catch (SystemException e) {
						System.out.println("Error fetching CasteList Using ReligionId" + religionId);
					}
				} else {
					System.out.println("ReligionId is Empty");
				}
			} else if(action.equalsIgnoreCase("populateSubCaste")){
				long casteId = ParamUtil.getLong(resourceRequest, "casteId");
				if(Validator.isNotNull(casteId)){
					try {
						List<SubCaste> subCasteList = SubCasteLocalServiceUtil.getSubCasteListByCasteId(casteId);
						if(Validator.isNotNull(subCasteList)){
							for(SubCaste subCaste: subCasteList){
								values.put(subCaste.getName());
							}
						}
						System.out.println("subCasteList===========>>" + subCasteList.size());
					} catch (SystemException e) {
						System.out.println("Error fetching SubCasteList Using CasteId" + casteId);
					}
				} else {
					System.out.println("CasteId is Empty");
				}
			}
			if(Validator.isNotNull(values)){
				if(values.length() > 0){
					jsonObject.put("arrayList", values);
					isValid = Boolean.TRUE;
				} else if(action.equalsIgnoreCase("populateSubCaste") || action.equalsIgnoreCase("populateCaste")) {
					jsonObject.put("arrayList", values);
					isValid = Boolean.TRUE;
				}
			} else if(action.equalsIgnoreCase("populateSubCaste") || action.equalsIgnoreCase("populateCaste")) {
				jsonObject.put("arrayList", values);
				isValid = Boolean.TRUE;
			}
			jsonObject.put("isValid", isValid);
			resourceResponse.setContentType(KeyValueConstants.APPLICATION_JSON);
			resourceResponse.setCharacterEncoding(KeyValueConstants.UTF_8);
			resourceResponse.getWriter().write(jsonObject.toString());
		} else {
			System.out.println("Inside norma server");
			HttpServletRequest servletRequest = PortalUtil
					.getHttpServletRequest(resourceRequest);
			HttpServletResponse servletResponse = PortalUtil
					.getHttpServletResponse(resourceResponse);
			long imageId = ParamUtil.getLong(resourceRequest, "imageId");
			boolean thumbnail = ParamUtil.getBoolean(resourceRequest,
					"thumbnail");
			int width = ParamUtil.getInteger(resourceRequest, "width");
			int height = ParamUtil.getInteger(resourceRequest, "height");
			boolean download = ParamUtil
					.getBoolean(resourceRequest, "download");

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
				} catch (SystemException e) {
				}
			}
		}
		super.serveResource(resourceRequest, resourceResponse);
	}

	public Date getBirthDate(ActionRequest actionRequest) {
		Calendar birthCal = Calendar.getInstance();
		int year = ParamUtil.getInteger(actionRequest, "birthDateWithTimeYear");
		int month = ParamUtil.getInteger(actionRequest,
				"birthDateWithTimeMonth");
		int date = ParamUtil.getInteger(actionRequest, "birthDateWithTimeDay");
		int minute = ParamUtil.getInteger(actionRequest,
				"birthDateWithTimeMinute");
		int hourOfDay = ParamUtil.getInteger(actionRequest,
				"birthDateWithTimeHour");
		birthCal.set(year, month, date, hourOfDay, minute);
		return birthCal.getTime();
	}

	public void setDropDownValues(RenderRequest renderRequest) {
		renderRequest
				.setAttribute(
						ProfileConstants.PROFILE_ANNUAL_INCOME,
						ProfileUtil
								.getKeyValueList(ProfileConstants.PROFILE_ANNUAL_INCOME));
		renderRequest.setAttribute(ProfileConstants.PROFILE_CHILDREN,
				ProfileUtil.getKeyValueList(ProfileConstants.PROFILE_CHILDREN));
		renderRequest.setAttribute(ProfileConstants.PROFILE_CURRENCY,
				ProfileUtil.getKeyValueList(ProfileConstants.PROFILE_CURRENCY));
		renderRequest.setAttribute(ProfileConstants.PROFILE_COMPLEXION,
				ProfileUtil
						.getKeyValueList(ProfileConstants.PROFILE_COMPLEXION));
		renderRequest
				.setAttribute(
						ProfileConstants.PROFILE_CREATED_FOR_MY,
						ProfileUtil
								.getKeyValueList(ProfileConstants.PROFILE_CREATED_FOR_MY));
		renderRequest.setAttribute(ProfileConstants.PROFILE_DOSAM,
				ProfileUtil.getKeyValueList(ProfileConstants.PROFILE_DOSAM));
		renderRequest
				.setAttribute(ProfileConstants.PROFILE_EDUCATION, ProfileUtil
						.getKeyValueList(ProfileConstants.PROFILE_EDUCATION));
		renderRequest
				.setAttribute(
						ProfileConstants.PROFILE_FAMILY_STATUS,
						ProfileUtil
								.getKeyValueList(ProfileConstants.PROFILE_FAMILY_STATUS));
		renderRequest.setAttribute(ProfileConstants.PROFILE_FAMILY_TYPE,
				ProfileUtil
						.getKeyValueList(ProfileConstants.PROFILE_FAMILY_TYPE));
		renderRequest
				.setAttribute(
						ProfileConstants.PROFILE_FAMILY_VALUE,
						ProfileUtil
								.getKeyValueList(ProfileConstants.PROFILE_FAMILY_VALUE));
		renderRequest.setAttribute(ProfileConstants.PROFILE_HEIGHT,
				ProfileUtil.getKeyValueList(ProfileConstants.PROFILE_HEIGHT));
		renderRequest.setAttribute(ProfileConstants.PROFILE_HOBBIES,
				ProfileUtil.getKeyValueList(ProfileConstants.PROFILE_HOBBIES));
		renderRequest.setAttribute(ProfileConstants.PROFILE_LANGUAGE,
				ProfileUtil.getKeyValueList(ProfileConstants.PROFILE_LANGUAGE));
		renderRequest
				.setAttribute(
						ProfileConstants.PROFILE_MARITAL_STATUS,
						ProfileUtil
								.getKeyValueList(ProfileConstants.PROFILE_MARITAL_STATUS));
		renderRequest.setAttribute(ProfileConstants.PROFILE_PROFESSION,
				ProfileUtil
						.getKeyValueList(ProfileConstants.PROFILE_PROFESSION));
		renderRequest.setAttribute(ProfileConstants.PROFILE_RASI,
				ProfileUtil.getKeyValueList(ProfileConstants.PROFILE_RASI));
		renderRequest.setAttribute(ProfileConstants.PROFILE_STAR,
				ProfileUtil.getKeyValueList(ProfileConstants.PROFILE_STAR));
		renderRequest.setAttribute(ProfileConstants.PROFILE_WEIGHT,
				ProfileUtil.getKeyValueList(ProfileConstants.PROFILE_WEIGHT));
	}
}