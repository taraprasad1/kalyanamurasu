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

package com.matrimony.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ProfileTempService}.
 * </p>
 *
 * @author    matrimony
 * @see       ProfileTempService
 * @generated
 */
public class ProfileTempServiceWrapper implements ProfileTempService,
	ServiceWrapper<ProfileTempService> {
	public ProfileTempServiceWrapper(ProfileTempService profileTempService) {
		_profileTempService = profileTempService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _profileTempService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_profileTempService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _profileTempService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ProfileTempService getWrappedProfileTempService() {
		return _profileTempService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedProfileTempService(
		ProfileTempService profileTempService) {
		_profileTempService = profileTempService;
	}

	public ProfileTempService getWrappedService() {
		return _profileTempService;
	}

	public void setWrappedService(ProfileTempService profileTempService) {
		_profileTempService = profileTempService;
	}

	private ProfileTempService _profileTempService;
}