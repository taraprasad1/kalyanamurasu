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

package com.matrimony.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.matrimony.model.City;

import java.io.Serializable;

/**
 * The cache model class for representing City in entity cache.
 *
 * @author matrimony
 * @see City
 * @generated
 */
public class CityCacheModel implements CacheModel<City>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{cityId=");
		sb.append(cityId);
		sb.append(", regionId=");
		sb.append(regionId);
		sb.append(", cityName=");
		sb.append(cityName);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	public City toEntityModel() {
		CityImpl cityImpl = new CityImpl();

		cityImpl.setCityId(cityId);
		cityImpl.setRegionId(regionId);

		if (cityName == null) {
			cityImpl.setCityName(StringPool.BLANK);
		}
		else {
			cityImpl.setCityName(cityName);
		}

		cityImpl.setStatus(status);

		cityImpl.resetOriginalValues();

		return cityImpl;
	}

	public long cityId;
	public long regionId;
	public String cityName;
	public boolean status;
}