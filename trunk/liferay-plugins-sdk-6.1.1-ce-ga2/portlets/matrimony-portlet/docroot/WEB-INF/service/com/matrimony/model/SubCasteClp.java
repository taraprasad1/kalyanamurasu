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

import com.matrimony.service.SubCasteLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author matrimony
 */
public class SubCasteClp extends BaseModelImpl<SubCaste> implements SubCaste {
	public SubCasteClp() {
	}

	public Class<?> getModelClass() {
		return SubCaste.class;
	}

	public String getModelClassName() {
		return SubCaste.class.getName();
	}

	public long getPrimaryKey() {
		return _subCasteId;
	}

	public void setPrimaryKey(long primaryKey) {
		setSubCasteId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_subCasteId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("subCasteId", getSubCasteId());
		attributes.put("casteId", getCasteId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long subCasteId = (Long)attributes.get("subCasteId");

		if (subCasteId != null) {
			setSubCasteId(subCasteId);
		}

		Long casteId = (Long)attributes.get("casteId");

		if (casteId != null) {
			setCasteId(casteId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
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

	public BaseModel<?> getSubCasteRemoteModel() {
		return _subCasteRemoteModel;
	}

	public void setSubCasteRemoteModel(BaseModel<?> subCasteRemoteModel) {
		_subCasteRemoteModel = subCasteRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			SubCasteLocalServiceUtil.addSubCaste(this);
		}
		else {
			SubCasteLocalServiceUtil.updateSubCaste(this);
		}
	}

	@Override
	public SubCaste toEscapedModel() {
		return (SubCaste)Proxy.newProxyInstance(SubCaste.class.getClassLoader(),
			new Class[] { SubCaste.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SubCasteClp clone = new SubCasteClp();

		clone.setSubCasteId(getSubCasteId());
		clone.setCasteId(getCasteId());
		clone.setName(getName());

		return clone;
	}

	public int compareTo(SubCaste subCaste) {
		long primaryKey = subCaste.getPrimaryKey();

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

		SubCasteClp subCaste = null;

		try {
			subCaste = (SubCasteClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = subCaste.getPrimaryKey();

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

		sb.append("{subCasteId=");
		sb.append(getSubCasteId());
		sb.append(", casteId=");
		sb.append(getCasteId());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.matrimony.model.SubCaste");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>subCasteId</column-name><column-value><![CDATA[");
		sb.append(getSubCasteId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>casteId</column-name><column-value><![CDATA[");
		sb.append(getCasteId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _subCasteId;
	private long _casteId;
	private String _name;
	private BaseModel<?> _subCasteRemoteModel;
}