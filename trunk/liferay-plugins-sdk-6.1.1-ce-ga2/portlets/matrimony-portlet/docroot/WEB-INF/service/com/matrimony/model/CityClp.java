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

package com.matrimony.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.matrimony.service.CityLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author matrimony
 */
public class CityClp extends BaseModelImpl<City> implements City {
	public CityClp() {
	}

	public Class<?> getModelClass() {
		return City.class;
	}

	public String getModelClassName() {
		return City.class.getName();
	}

	public long getPrimaryKey() {
		return _cityId;
	}

	public void setPrimaryKey(long primaryKey) {
		setCityId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_cityId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cityId", getCityId());
		attributes.put("regionId", getRegionId());
		attributes.put("cityName", getCityName());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cityId = (Long)attributes.get("cityId");

		if (cityId != null) {
			setCityId(cityId);
		}

		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		String cityName = (String)attributes.get("cityName");

		if (cityName != null) {
			setCityName(cityName);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	public long getCityId() {
		return _cityId;
	}

	public void setCityId(long cityId) {
		_cityId = cityId;
	}

	public long getRegionId() {
		return _regionId;
	}

	public void setRegionId(long regionId) {
		_regionId = regionId;
	}

	public String getCityName() {
		return _cityName;
	}

	public void setCityName(String cityName) {
		_cityName = cityName;
	}

	public boolean getStatus() {
		return _status;
	}

	public boolean isStatus() {
		return _status;
	}

	public void setStatus(boolean status) {
		_status = status;
	}

	public BaseModel<?> getCityRemoteModel() {
		return _cityRemoteModel;
	}

	public void setCityRemoteModel(BaseModel<?> cityRemoteModel) {
		_cityRemoteModel = cityRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CityLocalServiceUtil.addCity(this);
		}
		else {
			CityLocalServiceUtil.updateCity(this);
		}
	}

	@Override
	public City toEscapedModel() {
		return (City)Proxy.newProxyInstance(City.class.getClassLoader(),
			new Class[] { City.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CityClp clone = new CityClp();

		clone.setCityId(getCityId());
		clone.setRegionId(getRegionId());
		clone.setCityName(getCityName());
		clone.setStatus(getStatus());

		return clone;
	}

	public int compareTo(City city) {
		int value = 0;

		value = getCityName().compareTo(city.getCityName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CityClp city = null;

		try {
			city = (CityClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = city.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{cityId=");
		sb.append(getCityId());
		sb.append(", regionId=");
		sb.append(getRegionId());
		sb.append(", cityName=");
		sb.append(getCityName());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.matrimony.model.City");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>cityId</column-name><column-value><![CDATA[");
		sb.append(getCityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionId</column-name><column-value><![CDATA[");
		sb.append(getRegionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cityName</column-name><column-value><![CDATA[");
		sb.append(getCityName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _cityId;
	private long _regionId;
	private String _cityName;
	private boolean _status;
	private BaseModel<?> _cityRemoteModel;
}