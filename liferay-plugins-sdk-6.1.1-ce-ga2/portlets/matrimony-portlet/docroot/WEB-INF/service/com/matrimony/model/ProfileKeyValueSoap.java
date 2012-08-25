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

import com.matrimony.service.persistence.ProfileKeyValuePK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    matrimony
 * @generated
 */
public class ProfileKeyValueSoap implements Serializable {
	public static ProfileKeyValueSoap toSoapModel(ProfileKeyValue model) {
		ProfileKeyValueSoap soapModel = new ProfileKeyValueSoap();

		soapModel.setProfileId(model.getProfileId());
		soapModel.setKeyId(model.getKeyId());
		soapModel.setValueId(model.getValueId());

		return soapModel;
	}

	public static ProfileKeyValueSoap[] toSoapModels(ProfileKeyValue[] models) {
		ProfileKeyValueSoap[] soapModels = new ProfileKeyValueSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProfileKeyValueSoap[][] toSoapModels(
		ProfileKeyValue[][] models) {
		ProfileKeyValueSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProfileKeyValueSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProfileKeyValueSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProfileKeyValueSoap[] toSoapModels(
		List<ProfileKeyValue> models) {
		List<ProfileKeyValueSoap> soapModels = new ArrayList<ProfileKeyValueSoap>(models.size());

		for (ProfileKeyValue model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProfileKeyValueSoap[soapModels.size()]);
	}

	public ProfileKeyValueSoap() {
	}

	public ProfileKeyValuePK getPrimaryKey() {
		return new ProfileKeyValuePK(_profileId, _keyId, _valueId);
	}

	public void setPrimaryKey(ProfileKeyValuePK pk) {
		setProfileId(pk.profileId);
		setKeyId(pk.keyId);
		setValueId(pk.valueId);
	}

	public long getProfileId() {
		return _profileId;
	}

	public void setProfileId(long profileId) {
		_profileId = profileId;
	}

	public long getKeyId() {
		return _keyId;
	}

	public void setKeyId(long keyId) {
		_keyId = keyId;
	}

	public long getValueId() {
		return _valueId;
	}

	public void setValueId(long valueId) {
		_valueId = valueId;
	}

	private long _profileId;
	private long _keyId;
	private long _valueId;
}