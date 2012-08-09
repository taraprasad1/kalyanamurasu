package com.matrimony.profile;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.matrimony.profile.constant.KeyValueConstants;
import com.matrimony.profile.model.Key;
import com.matrimony.profile.model.KeyValue;
import com.matrimony.profile.service.KeyLocalServiceUtil;
import com.matrimony.profile.service.KeyValueLocalServiceUtil;

/**
 * Portlet implementation class Key
 */
public class KeyPortlet extends MatrimonyController {
	private static final Log LOGGER = LogFactoryUtil.getLog(KeyPortlet.class);

	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws PortletException,
			IOException {

		String action = ParamUtil.getString(resourceRequest,
				KeyValueConstants.ACTION);
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		if (Validator.isNotNull(action)) {
			if (action.equalsIgnoreCase(KeyValueConstants.ADD_KEY)) {
				String name = resourceRequest
						.getParameter(KeyValueConstants.KEY_NAME);
				Key key = null;
				try {
					key = KeyLocalServiceUtil.keySearch(name);
				} catch (Exception e) {
					LOGGER.error(KeyValueConstants.ERROR_FETCHING_KEY
							+ e.getMessage());
				}

				// Send Data Back
				if (Validator.isNull(key)) {
					key = KeyLocalServiceUtil.keyAdd(name);
					jsonObject.put(KeyValueConstants.VALID_KEY, true);
					jsonObject.put(KeyValueConstants.KEY_NAME, key.getName());
					jsonObject.put(KeyValueConstants.KEY_ID, key.getKeyId());
				} else {
					jsonObject.put(KeyValueConstants.VALID_KEY, false);
				}
			} else if (action.equalsIgnoreCase(KeyValueConstants.DELETE_KEY)) {
				long keyId = ParamUtil.getLong(resourceRequest,
						KeyValueConstants.KEY_ID);
				if (Validator.isNotNull(keyId)) {
					try {
						List<KeyValue> keyList = KeyValueLocalServiceUtil
								.valueSearch(keyId);
						if (Validator.isNull(keyList) || keyList.size() == 0) {
							jsonObject.put(KeyValueConstants.VALID_KEY, true);
							KeyLocalServiceUtil.deleteKey(keyId);
						} else {
							jsonObject.put(KeyValueConstants.VALID_KEY, false);
						}
					} catch (SystemException e) {
						LOGGER.error(KeyValueConstants.ERROR_FETCHING_VALUE_LIST
								+ e.getMessage());
					} catch (PortalException e) {
						LOGGER.error(KeyValueConstants.ERROR_FETCHING_VALUE_LIST
								+ e.getMessage());
					}
				}
			}
		}

		resourceResponse.setContentType(KeyValueConstants.APPLICATION_JSON);
		resourceResponse.setCharacterEncoding(KeyValueConstants.UTF_8);
		resourceResponse.getWriter().write(jsonObject.toString());

	}
}