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

import com.matrimony.service.ReligionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author matrimony
 */
public class ReligionClp extends BaseModelImpl<Religion> implements Religion {
	public ReligionClp() {
	}

	public Class<?> getModelClass() {
		return Religion.class;
	}

	public String getModelClassName() {
		return Religion.class.getName();
	}

	public long getPrimaryKey() {
		return _religionId;
	}

	public void setPrimaryKey(long primaryKey) {
		setReligionId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_religionId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("religionId", getReligionId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long religionId = (Long)attributes.get("religionId");

		if (religionId != null) {
			setReligionId(religionId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
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

	public BaseModel<?> getReligionRemoteModel() {
		return _religionRemoteModel;
	}

	public void setReligionRemoteModel(BaseModel<?> religionRemoteModel) {
		_religionRemoteModel = religionRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ReligionLocalServiceUtil.addReligion(this);
		}
		else {
			ReligionLocalServiceUtil.updateReligion(this);
		}
	}

	@Override
	public Religion toEscapedModel() {
		return (Religion)Proxy.newProxyInstance(Religion.class.getClassLoader(),
			new Class[] { Religion.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ReligionClp clone = new ReligionClp();

		clone.setReligionId(getReligionId());
		clone.setName(getName());

		return clone;
	}

	public int compareTo(Religion religion) {
		long primaryKey = religion.getPrimaryKey();

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

		ReligionClp religion = null;

		try {
			religion = (ReligionClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = religion.getPrimaryKey();

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

		sb.append("{religionId=");
		sb.append(getReligionId());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.matrimony.model.Religion");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>religionId</column-name><column-value><![CDATA[");
		sb.append(getReligionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _religionId;
	private String _name;
	private BaseModel<?> _religionRemoteModel;
}