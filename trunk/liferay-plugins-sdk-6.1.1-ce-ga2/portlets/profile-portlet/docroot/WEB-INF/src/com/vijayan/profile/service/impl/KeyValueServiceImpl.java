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

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.vijayan.profile.model.KeyValue;
import com.vijayan.profile.service.base.KeyValueServiceBaseImpl;

/**
 * The implementation of the key value remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.vijayan.profile.service.KeyValueService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author ravi
 * @see com.vijayan.profile.service.base.KeyValueServiceBaseImpl
 * @see com.vijayan.profile.service.KeyValueServiceUtil
 */
public class KeyValueServiceImpl extends KeyValueServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.vijayan.profile.service.KeyValueServiceUtil} to access the key value remote service.
	 */
	public List<KeyValue> valueSearch(long keyId) throws SystemException
	{
		return keyValuePersistence.findByKeyId(keyId);
	}
}