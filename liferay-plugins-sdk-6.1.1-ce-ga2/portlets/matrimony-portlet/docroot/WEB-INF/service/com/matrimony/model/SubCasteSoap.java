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
public class SubCasteSoap implements Serializable {
	public static SubCasteSoap toSoapModel(SubCaste model) {
		SubCasteSoap soapModel = new SubCasteSoap();

		soapModel.setSubCasteId(model.getSubCasteId());
		soapModel.setCasteId(model.getCasteId());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static SubCasteSoap[] toSoapModels(SubCaste[] models) {
		SubCasteSoap[] soapModels = new SubCasteSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SubCasteSoap[][] toSoapModels(SubCaste[][] models) {
		SubCasteSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SubCasteSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SubCasteSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SubCasteSoap[] toSoapModels(List<SubCaste> models) {
		List<SubCasteSoap> soapModels = new ArrayList<SubCasteSoap>(models.size());

		for (SubCaste model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SubCasteSoap[soapModels.size()]);
	}

	public SubCasteSoap() {
	}

	public long getPrimaryKey() {
		return _subCasteId;
	}

	public void setPrimaryKey(long pk) {
		setSubCasteId(pk);
	}

	public long getSubCasteId() {
		return _subCasteId;
	}

	public void setSubCasteId(long subCasteId) {
		_subCasteId = subCasteId;
	}

	public long getCasteId() {
		return _casteId;
	}

	public void setCasteId(long casteId) {
		_casteId = casteId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _subCasteId;
	private long _casteId;
	private String _name;
}