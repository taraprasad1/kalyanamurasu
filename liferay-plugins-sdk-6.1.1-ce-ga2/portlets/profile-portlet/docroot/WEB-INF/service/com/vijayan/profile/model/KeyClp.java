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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.vijayan.profile.service.KeyLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author vijayan
 */
public class KeyClp extends BaseModelImpl<Key> implements Key {
	public KeyClp() {
	}

	public Class<?> getModelClass() {
		return Key.class;
	}

	public String getModelClassName() {
		return Key.class.getName();
	}

	public long getPrimaryKey() {
		return _keyId;
	}

	public void setPrimaryKey(long primaryKey) {
		setKeyId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_keyId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("keyId", getKeyId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long keyId = (Long)attributes.get("keyId");

		if (keyId != null) {
			setKeyId(keyId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
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

	public BaseModel<?> getKeyRemoteModel() {
		return _keyRemoteModel;
	}

	public void setKeyRemoteModel(BaseModel<?> keyRemoteModel) {
		_keyRemoteModel = keyRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			KeyLocalServiceUtil.addKey(this);
		}
		else {
			KeyLocalServiceUtil.updateKey(this);
		}
	}

	@Override
	public Key toEscapedModel() {
		return (Key)Proxy.newProxyInstance(Key.class.getClassLoader(),
			new Class[] { Key.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		KeyClp clone = new KeyClp();

		clone.setKeyId(getKeyId());
		clone.setName(getName());

		return clone;
	}

	public int compareTo(Key key) {
		long primaryKey = key.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		KeyClp key = null;

		try {
			key = (KeyClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = key.getPrimaryKey();

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
		StringBundler sb = new StringBundler(5);

		sb.append("{keyId=");
		sb.append(getKeyId());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.vijayan.profile.model.Key");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>keyId</column-name><column-value><![CDATA[");
		sb.append(getKeyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _keyId;
	private String _name;
	private BaseModel<?> _keyRemoteModel;
}