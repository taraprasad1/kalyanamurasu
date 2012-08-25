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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    matrimony
 * @generated
 */
public class CitySoap implements Serializable {
	public static CitySoap toSoapModel(City model) {
		CitySoap soapModel = new CitySoap();

		soapModel.setCityId(model.getCityId());
		soapModel.setRegionId(model.getRegionId());
		soapModel.setCityName(model.getCityName());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static CitySoap[] toSoapModels(City[] models) {
		CitySoap[] soapModels = new CitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CitySoap[][] toSoapModels(City[][] models) {
		CitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CitySoap[] toSoapModels(List<City> models) {
		List<CitySoap> soapModels = new ArrayList<CitySoap>(models.size());

		for (City model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CitySoap[soapModels.size()]);
	}

	public CitySoap() {
	}

	public long getPrimaryKey() {
		return _cityId;
	}

	public void setPrimaryKey(long pk) {
		setCityId(pk);
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

	private long _cityId;
	private long _regionId;
	private String _cityName;
	private boolean _status;
}