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
public class ReligionSoap implements Serializable {
	public static ReligionSoap toSoapModel(Religion model) {
		ReligionSoap soapModel = new ReligionSoap();

		soapModel.setReligionId(model.getReligionId());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static ReligionSoap[] toSoapModels(Religion[] models) {
		ReligionSoap[] soapModels = new ReligionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ReligionSoap[][] toSoapModels(Religion[][] models) {
		ReligionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ReligionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ReligionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ReligionSoap[] toSoapModels(List<Religion> models) {
		List<ReligionSoap> soapModels = new ArrayList<ReligionSoap>(models.size());

		for (Religion model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ReligionSoap[soapModels.size()]);
	}

	public ReligionSoap() {
	}

	public long getPrimaryKey() {
		return _religionId;
	}

	public void setPrimaryKey(long pk) {
		setReligionId(pk);
	}

	public long getReligionId() {
		return _religionId;
	}

	public void setReligionId(long religionId) {
		_religionId = religionId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _religionId;
	private String _name;
}