package com.matrimony.profile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

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
 * Portlet implementation class KeyValue
 */

public class ValuePortlet extends MatrimonyController {
	private static final Log LOGGER = LogFactoryUtil.getLog(ValuePortlet.class);

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		long keyId = ParamUtil.getLong(renderRequest, KeyValueConstants.KEY_ID);
		List<KeyValue> valueList = null;
		if (Validator.isNull(keyId)) {
			List<Key> keyList = new ArrayList<Key>();
			try {
				keyList = KeyLocalServiceUtil.getKeies(-1, -1);
			} catch (SystemException e) {
				LOGGER.error(KeyValueConstants.ERROR_FETCHING_KEY_LIST
						+ e.getMessage());
			}
			if (Validator.isNotNull(keyList) && keyList.size() > 0) {
				Key key = keyList.get(0);
				keyId = key.getKeyId();
			}
		}

		try {
			valueList = KeyValueLocalServiceUtil.valueSearch(keyId);
		} catch (SystemException e) {
			LOGGER.error(KeyValueConstants.ERROR_FETCHING_VALUE_LIST
					+ e.getMessage());
		}
		if (keyId > 0l) {
			renderRequest.setAttribute(KeyValueConstants.KEY_ID, keyId);
			renderRequest.setAttribute(KeyValueConstants.KEY_VALUE_LIST,
					valueList);
		}

		super.doView(renderRequest, renderResponse);
	}

	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws PortletException,
			IOException {

		String action = ParamUtil.getString(resourceRequest,
				KeyValueConstants.ACTION);
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		if (Validator.isNotNull(action)) {
			if (action.equalsIgnoreCase(KeyValueConstants.ADD_KEY_VALUE)) {
				String name = ParamUtil.getString(resourceRequest,
						KeyValueConstants.KEY_VALUE_NAME);
				long keyId = ParamUtil.getLong(resourceRequest,
						KeyValueConstants.KEY_ID);
				if (Validator.isNotNull(name) && Validator.isNotNull(keyId)) {
					KeyValue keyValue = null;
					Key key = null;
					try {
						key = KeyLocalServiceUtil.getKey(keyId);
						if(Validator.isNotNull(key)){
							keyValue = KeyValueLocalServiceUtil.valueNameSearch(
								name, keyId);
						}
					} catch (Exception e) {
						jsonObject.put(KeyValueConstants.VALID_KEY_VALUE, false);
						LOGGER.error(KeyValueConstants.ERROR_FETCHING_KEY_VALUE
								+ e.getMessage());
					}

					// Send Data Back
					if (Validator.isNull(keyValue) && Validator.isNotNull(key)) {
						keyValue = KeyValueLocalServiceUtil.addValue(name,
								keyId);
						jsonObject.put(KeyValueConstants.VALID_KEY_VALUE, true);
						jsonObject.put(KeyValueConstants.KEY_VALUE_NAME,
								keyValue.getName());
						jsonObject.put(KeyValueConstants.KEY_VALUE_ID,
								keyValue.getValueId());
					} else {
						jsonObject
								.put(KeyValueConstants.VALID_KEY_VALUE, false);
					}
				} else {
					jsonObject.put(KeyValueConstants.VALID_KEY_VALUE, false);
				}
			} else if (action
					.equalsIgnoreCase(KeyValueConstants.DELETE_KEY_VALUE)) {
				long keyValueId = ParamUtil.getLong(resourceRequest,
						KeyValueConstants.KEY_VALUE_ID);
				if (Validator.isNotNull(keyValueId)) {
					try {
						KeyValueLocalServiceUtil.deleteKeyValue(keyValueId);
						jsonObject.put(KeyValueConstants.VALID_KEY_VALUE, true);
					} catch (Exception e) {
						jsonObject
								.put(KeyValueConstants.VALID_KEY_VALUE, false);
						LOGGER.error(KeyValueConstants.ERROR_DELETING_KEY_VALUE
								+ e.getMessage());
					}
				} else {
					jsonObject.put(KeyValueConstants.VALID_KEY_VALUE, false);
				}
			}
		}
		resourceResponse.setContentType(KeyValueConstants.APPLICATION_JSON);
		resourceResponse.setCharacterEncoding(KeyValueConstants.UTF_8);
		resourceResponse.getWriter().write(jsonObject.toString());
	}
}