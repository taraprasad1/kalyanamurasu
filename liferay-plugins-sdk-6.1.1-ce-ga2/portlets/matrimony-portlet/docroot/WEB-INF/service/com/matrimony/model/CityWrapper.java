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

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link City}.
 * </p>
 *
 * @author    matrimony
 * @see       City
 * @generated
 */
public class CityWrapper implements City, ModelWrapper<City> {
	public CityWrapper(City city) {
		_city = city;
	}

	public Class<?> getModelClass() {
		return City.class;
	}

	public String getModelClassName() {
		return City.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cityId", getCityId());
		attributes.put("regionId", getRegionId());
		attributes.put("cityName", getCityName());
		attributes.put("status", getStatus());

		return attributes;
	}

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

	/**
	* Returns the primary key of this city.
	*
	* @return the primary key of this city
	*/
	public long getPrimaryKey() {
		return _city.getPrimaryKey();
	}

	/**
	* Sets the primary key of this city.
	*
	* @param primaryKey the primary key of this city
	*/
	public void setPrimaryKey(long primaryKey) {
		_city.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the city ID of this city.
	*
	* @return the city ID of this city
	*/
	public long getCityId() {
		return _city.getCityId();
	}

	/**
	* Sets the city ID of this city.
	*
	* @param cityId the city ID of this city
	*/
	public void setCityId(long cityId) {
		_city.setCityId(cityId);
	}

	/**
	* Returns the region ID of this city.
	*
	* @return the region ID of this city
	*/
	public long getRegionId() {
		return _city.getRegionId();
	}

	/**
	* Sets the region ID of this city.
	*
	* @param regionId the region ID of this city
	*/
	public void setRegionId(long regionId) {
		_city.setRegionId(regionId);
	}

	/**
	* Returns the city name of this city.
	*
	* @return the city name of this city
	*/
	public java.lang.String getCityName() {
		return _city.getCityName();
	}

	/**
	* Sets the city name of this city.
	*
	* @param cityName the city name of this city
	*/
	public void setCityName(java.lang.String cityName) {
		_city.setCityName(cityName);
	}

	/**
	* Returns the status of this city.
	*
	* @return the status of this city
	*/
	public boolean getStatus() {
		return _city.getStatus();
	}

	/**
	* Returns <code>true</code> if this city is status.
	*
	* @return <code>true</code> if this city is status; <code>false</code> otherwise
	*/
	public boolean isStatus() {
		return _city.isStatus();
	}

	/**
	* Sets whether this city is status.
	*
	* @param status the status of this city
	*/
	public void setStatus(boolean status) {
		_city.setStatus(status);
	}

	public boolean isNew() {
		return _city.isNew();
	}

	public void setNew(boolean n) {
		_city.setNew(n);
	}

	public boolean isCachedModel() {
		return _city.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_city.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _city.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _city.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_city.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _city.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_city.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CityWrapper((City)_city.clone());
	}

	public int compareTo(com.matrimony.model.City city) {
		return _city.compareTo(city);
	}

	@Override
	public int hashCode() {
		return _city.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.matrimony.model.City> toCacheModel() {
		return _city.toCacheModel();
	}

	public com.matrimony.model.City toEscapedModel() {
		return new CityWrapper(_city.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _city.toString();
	}

	public java.lang.String toXmlString() {
		return _city.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_city.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public City getWrappedCity() {
		return _city;
	}

	public City getWrappedModel() {
		return _city;
	}

	public void resetOriginalValues() {
		_city.resetOriginalValues();
	}

	private City _city;
}