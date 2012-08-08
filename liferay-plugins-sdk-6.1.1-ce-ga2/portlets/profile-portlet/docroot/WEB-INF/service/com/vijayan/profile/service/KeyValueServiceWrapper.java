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

package com.vijayan.profile.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link KeyValueService}.
 * </p>
 *
 * @author    ravi
 * @see       KeyValueService
 * @generated
 */
public class KeyValueServiceWrapper implements KeyValueService,
	ServiceWrapper<KeyValueService> {
	public KeyValueServiceWrapper(KeyValueService keyValueService) {
		_keyValueService = keyValueService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _keyValueService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_keyValueService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _keyValueService.invokeMethod(name, parameterTypes, arguments);
	}

	public java.util.List<com.vijayan.profile.model.KeyValue> valueSearch(
		long keyId) throws com.liferay.portal.kernel.exception.SystemException {
		return _keyValueService.valueSearch(keyId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public KeyValueService getWrappedKeyValueService() {
		return _keyValueService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedKeyValueService(KeyValueService keyValueService) {
		_keyValueService = keyValueService;
	}

	public KeyValueService getWrappedService() {
		return _keyValueService;
	}

	public void setWrappedService(KeyValueService keyValueService) {
		_keyValueService = keyValueService;
	}

	private KeyValueService _keyValueService;
}