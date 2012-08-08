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

import com.vijayan.profile.service.KeyValueLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ravi
 */
public class KeyValueClp extends BaseModelImpl<KeyValue> implements KeyValue {
	public KeyValueClp() {
	}

	public Class<?> getModelClass() {
		return KeyValue.class;
	}

	public String getModelClassName() {
		return KeyValue.class.getName();
	}

	public long getPrimaryKey() {
		return _valueId;
	}

	public void setPrimaryKey(long primaryKey) {
		setValueId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_valueId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("valueId", getValueId());
		attributes.put("keyId", getKeyId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long valueId = (Long)attributes.get("valueId");

		if (valueId != null) {
			setValueId(valueId);
		}

		Long keyId = (Long)attributes.get("keyId");

		if (keyId != null) {
			setKeyId(keyId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
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

	public BaseModel<?> getKeyValueRemoteModel() {
		return _keyValueRemoteModel;
	}

	public void setKeyValueRemoteModel(BaseModel<?> keyValueRemoteModel) {
		_keyValueRemoteModel = keyValueRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			KeyValueLocalServiceUtil.addKeyValue(this);
		}
		else {
			KeyValueLocalServiceUtil.updateKeyValue(this);
		}
	}

	@Override
	public KeyValue toEscapedModel() {
		return (KeyValue)Proxy.newProxyInstance(KeyValue.class.getClassLoader(),
			new Class[] { KeyValue.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		KeyValueClp clone = new KeyValueClp();

		clone.setValueId(getValueId());
		clone.setKeyId(getKeyId());
		clone.setName(getName());

		return clone;
	}

	public int compareTo(KeyValue keyValue) {
		long primaryKey = keyValue.getPrimaryKey();

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

		KeyValueClp keyValue = null;

		try {
			keyValue = (KeyValueClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = keyValue.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{valueId=");
		sb.append(getValueId());
		sb.append(", keyId=");
		sb.append(getKeyId());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.vijayan.profile.model.KeyValue");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>valueId</column-name><column-value><![CDATA[");
		sb.append(getValueId());
		sb.append("]]></column-value></column>");
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

	private long _valueId;
	private long _keyId;
	private String _name;
	private BaseModel<?> _keyValueRemoteModel;
}