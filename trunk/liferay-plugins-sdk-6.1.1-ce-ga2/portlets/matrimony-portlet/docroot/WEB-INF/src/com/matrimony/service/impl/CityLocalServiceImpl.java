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

package com.matrimony.service.impl;

import com.matrimony.service.base.CityLocalServiceBaseImpl;

import java.util.List;
import com.liferay.portal.kernel.exception.SystemException;
import com.matrimony.model.City;

/**
 * The implementation of the city local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.matrimony.service.CityLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author matrimony
 * @see com.matrimony.service.base.CityLocalServiceBaseImpl
 * @see com.matrimony.service.CityLocalServiceUtil
 */
public class CityLocalServiceImpl extends CityLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.matrimony.service.CityLocalServiceUtil} to access the city local service.
	 */
	public City getCityByRegionId_CityName(long regionId, String cityName)
	throws SystemException {
		return cityPersistence.fetchByRegionId_City(regionId, cityName);
	}

	public List<City> getRegion_Cities(long regionId) throws SystemException {
		return cityPersistence.findByRegionId(regionId);
	}	
}