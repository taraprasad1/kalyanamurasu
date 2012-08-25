package com.matrimony.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Region;
import com.liferay.portal.service.RegionServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.matrimony.model.City;
import com.matrimony.service.CityLocalServiceUtil;

/**
 * @author Arun
 *
 */
public class JsonUtil {
	
	/**
	 * @param resourceRequest
	 * @param resourceResponse
	 */
	public static void getRegions(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		JSONObject jsonObj;
		String countryId = ParamUtil.getString(resourceRequest, "countryId");
		try {
			if (countryId != null && !(countryId.equals("")))
				for (Region region : RegionServiceUtil.getService().getRegions(Long.valueOf(countryId))) {
					jsonObj = JSONFactoryUtil.createJSONObject();
					jsonObj.put("id", region.getRegionId());
					jsonObj.put("name", region.getName());
					jsonArray.put(jsonObj);
				}
		} catch (SystemException e) {
			e.printStackTrace();
		}

		returnJSONArray(resourceResponse, jsonArray);
	}
	
	/**
	 * @param resourceRequest
	 * @param resourceResponse
	 */
	public static void getCities(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		JSONObject jsonObj;
		String regionId = ParamUtil.getString(resourceRequest, "regionId");
		try {
			if (regionId != null && !(regionId.equals("")))
				for (City city : CityLocalServiceUtil.getService().getRegion_Cities(Long.valueOf(regionId))) {
					jsonObj = JSONFactoryUtil.createJSONObject();
					jsonObj.put("id", city.getCityId());
					jsonObj.put("name", city.getCityName());
					jsonArray.put(jsonObj);
				}
		} catch (SystemException e) {
			e.printStackTrace();
		}

		returnJSONArray(resourceResponse, jsonArray);
	}
	
	/**
	 * @param response
	 * @param jsonArray
	 */
	private static void returnJSONArray(ResourceResponse response,
			JSONArray jsonArray) {
		HttpServletResponse servletResponse = PortalUtil.getHttpServletResponse(response);
		PrintWriter pw;
		try {
			pw = servletResponse.getWriter();
			pw.write(jsonArray.toString());
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
