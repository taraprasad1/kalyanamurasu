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

package com.vijayan.profile.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.vijayan.profile.NoSuchKeyException;
import com.vijayan.profile.constant.KeyValueConstants;
import com.vijayan.profile.model.Key;
import com.vijayan.profile.model.impl.KeyImpl;
import com.vijayan.profile.service.KeyLocalServiceUtil;
import com.vijayan.profile.service.base.KeyLocalServiceBaseImpl;

/**
 * The implementation of the key local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.vijayan.profile.service.KeyLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author ravi
 * @see com.vijayan.profile.service.base.KeyLocalServiceBaseImpl
 * @see com.vijayan.profile.service.KeyLocalServiceUtil
 */
public class KeyLocalServiceImpl extends KeyLocalServiceBaseImpl {
	private static final Log LOGGER = LogFactoryUtil
			.getLog(KeyLocalServiceImpl.class);

	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.vijayan.profile.service.KeyLocalServiceUtil} to access the key local
	 * service.
	 */
	public Key keySearch(String name) throws SystemException {
		Key key = null;
		try {
			key = keyPersistence.findByname(name);
		} catch (NoSuchKeyException e) {
			LOGGER.error(KeyValueConstants.ERROR_FETCHING_KEY + e.getMessage());
		}
		return key;
	}

	public Key keyAdd(String name) {
		Key key = new KeyImpl();
		key.setName(name);
		try {
			key = KeyLocalServiceUtil.addKey(key);
		} catch (SystemException e) {
			LOGGER.error(KeyValueConstants.ERROR_ADDING_KEY + e.getMessage());
		}
		return key;
	}
}