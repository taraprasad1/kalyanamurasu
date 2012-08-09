/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.matrimony.profile.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.matrimony.profile.constant.KeyValueConstants;
import com.matrimony.profile.model.impl.KeyValueImpl;
import com.matrimony.profile.service.base.KeyValueLocalServiceBaseImpl;
import com.matrimony.profile.NoSuchKeyValueException;
import com.matrimony.profile.model.KeyValue;
import com.matrimony.profile.service.KeyValueLocalServiceUtil;

/**
 * The implementation of the key value local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.matrimony.profile.service.KeyValueLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author ravi
 * @see com.matrimony.profile.service.base.KeyValueLocalServiceBaseImpl
 * @see com.matrimony.profile.service.KeyValueLocalServiceUtil
 */
public class KeyValueLocalServiceImpl extends KeyValueLocalServiceBaseImpl {
	private static final Log LOGGER = LogFactoryUtil
			.getLog(KeyValueLocalServiceImpl.class);

	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.matrimony.profile.service.KeyValueLocalServiceUtil} to access the key
	 * value local service.
	 */

	public KeyValue valueNameSearch(String name, long keyId) {
		KeyValue value = null;
		try {
			value = keyValuePersistence.findByvalueName(name, keyId);
		} catch (NoSuchKeyValueException e) {
			LOGGER.error(KeyValueConstants.ERROR_FETCHING_KEY_VALUE
					+ e.getMessage());
		} catch (SystemException e) {
			LOGGER.error(KeyValueConstants.ERROR_FETCHING_KEY_VALUE
					+ e.getMessage());
		}
		return value;
	}

	public List<KeyValue> valueSearch(long keyId) throws SystemException {
		return keyValuePersistence.findByKeyId(keyId);
	}

	public KeyValue addValue(String keyValue, long keyId) {

		KeyValue value = new KeyValueImpl();
		value.setName(keyValue);
		value.setKeyId(keyId);
		try {
			value = KeyValueLocalServiceUtil.addKeyValue(value);
		} catch (SystemException e) {
			LOGGER.error(KeyValueConstants.ERROR_ADDING_KEY_VALUE
					+ e.getMessage());
		}
		return value;
	}
}