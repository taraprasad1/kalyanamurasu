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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.matrimony.model.City;
import com.matrimony.model.CityModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the City service. Represents a row in the &quot;city&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.matrimony.model.CityModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CityImpl}.
 * </p>
 *
 * @author matrimony
 * @see CityImpl
 * @see com.matrimony.model.City
 * @see com.matrimony.model.CityModel
 * @generated
 */
public class CityModelImpl extends BaseModelImpl<City> implements CityModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a city model instance should use the {@link com.matrimony.model.City} interface instead.
	 */
	public static final String TABLE_NAME = "city";
	public static final Object[][] TABLE_COLUMNS = {
			{ "cityId", Types.BIGINT },
			{ "regionId", Types.BIGINT },
			{ "cityName", Types.VARCHAR },
			{ "status", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table city (cityId LONG not null primary key IDENTITY,regionId LONG,cityName VARCHAR(75) null,status BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table city";
	public static final String ORDER_BY_JPQL = " ORDER BY city.cityName ASC";
	public static final String ORDER_BY_SQL = " ORDER BY city.cityName ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.matrimony.model.City"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.matrimony.model.City"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.matrimony.model.City"),
			true);
	public static long CITYNAME_COLUMN_BITMASK = 1L;
	public static long REGIONID_COLUMN_BITMASK = 2L;
	public static long STATUS_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.matrimony.model.City"));

	public CityModelImpl() {
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

	public Class<?> getModelClass() {
		return City.class;
	}

	public String getModelClassName() {
		return City.class.getName();
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
		_columnBitmask |= REGIONID_COLUMN_BITMASK;

		if (!_setOriginalRegionId) {
			_setOriginalRegionId = true;

			_originalRegionId = _regionId;
		}

		_regionId = regionId;
	}

	public long getOriginalRegionId() {
		return _originalRegionId;
	}

	public String getCityName() {
		if (_cityName == null) {
			return StringPool.BLANK;
		}
		else {
			return _cityName;
		}
	}

	public void setCityName(String cityName) {
		_columnBitmask = -1L;

		if (_originalCityName == null) {
			_originalCityName = _cityName;
		}

		_cityName = cityName;
	}

	public String getOriginalCityName() {
		return GetterUtil.getString(_originalCityName);
	}

	public boolean getStatus() {
		return _status;
	}

	public boolean isStatus() {
		return _status;
	}

	public void setStatus(boolean status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public boolean getOriginalStatus() {
		return _originalStatus;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			City.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public City toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (City)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		CityImpl cityImpl = new CityImpl();

		cityImpl.setCityId(getCityId());
		cityImpl.setRegionId(getRegionId());
		cityImpl.setCityName(getCityName());
		cityImpl.setStatus(getStatus());

		cityImpl.resetOriginalValues();

		return cityImpl;
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

		City city = null;

		try {
			city = (City)obj;
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
	public void resetOriginalValues() {
		CityModelImpl cityModelImpl = this;

		cityModelImpl._originalRegionId = cityModelImpl._regionId;

		cityModelImpl._setOriginalRegionId = false;

		cityModelImpl._originalCityName = cityModelImpl._cityName;

		cityModelImpl._originalStatus = cityModelImpl._status;

		cityModelImpl._setOriginalStatus = false;

		cityModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<City> toCacheModel() {
		CityCacheModel cityCacheModel = new CityCacheModel();

		cityCacheModel.cityId = getCityId();

		cityCacheModel.regionId = getRegionId();

		cityCacheModel.cityName = getCityName();

		String cityName = cityCacheModel.cityName;

		if ((cityName != null) && (cityName.length() == 0)) {
			cityCacheModel.cityName = null;
		}

		cityCacheModel.status = getStatus();

		return cityCacheModel;
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

	private static ClassLoader _classLoader = City.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			City.class
		};
	private long _cityId;
	private long _regionId;
	private long _originalRegionId;
	private boolean _setOriginalRegionId;
	private String _cityName;
	private String _originalCityName;
	private boolean _status;
	private boolean _originalStatus;
	private boolean _setOriginalStatus;
	private long _columnBitmask;
	private City _escapedModelProxy;
}