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

import com.matrimony.service.CasteLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author matrimony
 */
public class CasteClp extends BaseModelImpl<Caste> implements Caste {
	public CasteClp() {
	}

	public Class<?> getModelClass() {
		return Caste.class;
	}

	public String getModelClassName() {
		return Caste.class.getName();
	}

	public long getPrimaryKey() {
		return _casteId;
	}

	public void setPrimaryKey(long primaryKey) {
		setCasteId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_casteId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("casteId", getCasteId());
		attributes.put("religionId", getReligionId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long casteId = (Long)attributes.get("casteId");

		if (casteId != null) {
			setCasteId(casteId);
		}

		Long religionId = (Long)attributes.get("religionId");

		if (religionId != null) {
			setReligionId(religionId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	public long getCasteId() {
		return _casteId;
	}

	public void setCasteId(long casteId) {
		_casteId = casteId;
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

	public BaseModel<?> getCasteRemoteModel() {
		return _casteRemoteModel;
	}

	public void setCasteRemoteModel(BaseModel<?> casteRemoteModel) {
		_casteRemoteModel = casteRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CasteLocalServiceUtil.addCaste(this);
		}
		else {
			CasteLocalServiceUtil.updateCaste(this);
		}
	}

	@Override
	public Caste toEscapedModel() {
		return (Caste)Proxy.newProxyInstance(Caste.class.getClassLoader(),
			new Class[] { Caste.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CasteClp clone = new CasteClp();

		clone.setCasteId(getCasteId());
		clone.setReligionId(getReligionId());
		clone.setName(getName());

		return clone;
	}

	public int compareTo(Caste caste) {
		long primaryKey = caste.getPrimaryKey();

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

		CasteClp caste = null;

		try {
			caste = (CasteClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = caste.getPrimaryKey();

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

		sb.append("{casteId=");
		sb.append(getCasteId());
		sb.append(", religionId=");
		sb.append(getReligionId());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.matrimony.model.Caste");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>casteId</column-name><column-value><![CDATA[");
		sb.append(getCasteId());
		sb.append("]]></column-value></column>");
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

	private long _casteId;
	private long _religionId;
	private String _name;
	private BaseModel<?> _casteRemoteModel;
}