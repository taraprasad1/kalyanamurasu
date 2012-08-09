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
 * This class is used by SOAP remote services, specifically {@link com.matrimony.service.http.KeyServiceSoap}.
 *
 * @author    matrimony
 * @see       com.matrimony.service.http.KeyServiceSoap
 * @generated
 */
public class KeySoap implements Serializable {
	public static KeySoap toSoapModel(Key model) {
		KeySoap soapModel = new KeySoap();

		soapModel.setKeyId(model.getKeyId());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static KeySoap[] toSoapModels(Key[] models) {
		KeySoap[] soapModels = new KeySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static KeySoap[][] toSoapModels(Key[][] models) {
		KeySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new KeySoap[models.length][models[0].length];
		}
		else {
			soapModels = new KeySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static KeySoap[] toSoapModels(List<Key> models) {
		List<KeySoap> soapModels = new ArrayList<KeySoap>(models.size());

		for (Key model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new KeySoap[soapModels.size()]);
	}

	public KeySoap() {
	}

	public long getPrimaryKey() {
		return _keyId;
	}

	public void setPrimaryKey(long pk) {
		setKeyId(pk);
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

	private long _keyId;
	private String _name;
}