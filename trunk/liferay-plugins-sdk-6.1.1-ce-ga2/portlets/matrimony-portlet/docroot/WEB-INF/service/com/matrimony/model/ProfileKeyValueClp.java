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

import com.matrimony.service.ProfileKeyValueLocalServiceUtil;
import com.matrimony.service.persistence.ProfileKeyValuePK;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author matrimony
 */
public class ProfileKeyValueClp extends BaseModelImpl<ProfileKeyValue>
	implements ProfileKeyValue {
	public ProfileKeyValueClp() {
	}

	public Class<?> getModelClass() {
		return ProfileKeyValue.class;
	}

	public String getModelClassName() {
		return ProfileKeyValue.class.getName();
	}

	public ProfileKeyValuePK getPrimaryKey() {
		return new ProfileKeyValuePK(_profileId, _keyId, _valueId);
	}

	public void setPrimaryKey(ProfileKeyValuePK primaryKey) {
		setProfileId(primaryKey.profileId);
		setKeyId(primaryKey.keyId);
		setValueId(primaryKey.valueId);
	}

	public Serializable getPrimaryKeyObj() {
		return new ProfileKeyValuePK(_profileId, _keyId, _valueId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ProfileKeyValuePK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("profileId", getProfileId());
		attributes.put("keyId", getKeyId());
		attributes.put("valueId", getValueId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long profileId = (Long)attributes.get("profileId");

		if (profileId != null) {
			setProfileId(profileId);
		}

		Long keyId = (Long)attributes.get("keyId");

		if (keyId != null) {
			setKeyId(keyId);
		}

		Long valueId = (Long)attributes.get("valueId");

		if (valueId != null) {
			setValueId(valueId);
		}
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

	public BaseModel<?> getProfileKeyValueRemoteModel() {
		return _profileKeyValueRemoteModel;
	}

	public void setProfileKeyValueRemoteModel(
		BaseModel<?> profileKeyValueRemoteModel) {
		_profileKeyValueRemoteModel = profileKeyValueRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ProfileKeyValueLocalServiceUtil.addProfileKeyValue(this);
		}
		else {
			ProfileKeyValueLocalServiceUtil.updateProfileKeyValue(this);
		}
	}

	@Override
	public ProfileKeyValue toEscapedModel() {
		return (ProfileKeyValue)Proxy.newProxyInstance(ProfileKeyValue.class.getClassLoader(),
			new Class[] { ProfileKeyValue.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProfileKeyValueClp clone = new ProfileKeyValueClp();

		clone.setProfileId(getProfileId());
		clone.setKeyId(getKeyId());
		clone.setValueId(getValueId());

		return clone;
	}

	public int compareTo(ProfileKeyValue profileKeyValue) {
		ProfileKeyValuePK primaryKey = profileKeyValue.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ProfileKeyValueClp profileKeyValue = null;

		try {
			profileKeyValue = (ProfileKeyValueClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		ProfileKeyValuePK primaryKey = profileKeyValue.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{profileId=");
		sb.append(getProfileId());
		sb.append(", keyId=");
		sb.append(getKeyId());
		sb.append(", valueId=");
		sb.append(getValueId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.matrimony.model.ProfileKeyValue");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>profileId</column-name><column-value><![CDATA[");
		sb.append(getProfileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>keyId</column-name><column-value><![CDATA[");
		sb.append(getKeyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>valueId</column-name><column-value><![CDATA[");
		sb.append(getValueId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _profileId;
	private long _keyId;
	private long _valueId;
	private BaseModel<?> _profileKeyValueRemoteModel;
}