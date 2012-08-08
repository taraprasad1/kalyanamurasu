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

package com.vijayan.profile.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.vijayan.profile.service.http.KeyValueServiceSoap}.
 *
 * @author    ravi
 * @see       com.vijayan.profile.service.http.KeyValueServiceSoap
 * @generated
 */
public class KeyValueSoap implements Serializable {
	public static KeyValueSoap toSoapModel(KeyValue model) {
		KeyValueSoap soapModel = new KeyValueSoap();

		soapModel.setValueId(model.getValueId());
		soapModel.setKeyId(model.getKeyId());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static KeyValueSoap[] toSoapModels(KeyValue[] models) {
		KeyValueSoap[] soapModels = new KeyValueSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static KeyValueSoap[][] toSoapModels(KeyValue[][] models) {
		KeyValueSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new KeyValueSoap[models.length][models[0].length];
		}
		else {
			soapModels = new KeyValueSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static KeyValueSoap[] toSoapModels(List<KeyValue> models) {
		List<KeyValueSoap> soapModels = new ArrayList<KeyValueSoap>(models.size());

		for (KeyValue model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new KeyValueSoap[soapModels.size()]);
	}

	public KeyValueSoap() {
	}

	public long getPrimaryKey() {
		return _valueId;
	}

	public void setPrimaryKey(long pk) {
		setValueId(pk);
	}

	public long getValueId() {
		return _valueId;
	}

	public void setValueId(long valueId) {
		_valueId = valueId;
	}

	public long getKeyId() {
		return _keyId;
	}

	public void setKeyId(long keyId) {
		_keyId = keyId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _valueId;
	private long _keyId;
	private String _name;
}