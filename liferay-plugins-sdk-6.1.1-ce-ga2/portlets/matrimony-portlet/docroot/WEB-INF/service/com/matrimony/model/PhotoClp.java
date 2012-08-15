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

import com.matrimony.service.PhotoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author matrimony
 */
public class PhotoClp extends BaseModelImpl<Photo> implements Photo {
	public PhotoClp() {
	}

	public Class<?> getModelClass() {
		return Photo.class;
	}

	public String getModelClassName() {
		return Photo.class.getName();
	}

	public long getPrimaryKey() {
		return _photoId;
	}

	public void setPrimaryKey(long primaryKey) {
		setPhotoId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_photoId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("photoId", getPhotoId());
		attributes.put("profileId", getProfileId());
		attributes.put("content", getContent());
		attributes.put("name", getName());
		attributes.put("type", getType());
		attributes.put("thumbnail", getThumbnail());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long photoId = (Long)attributes.get("photoId");

		if (photoId != null) {
			setPhotoId(photoId);
		}

		Long profileId = (Long)attributes.get("profileId");

		if (profileId != null) {
			setProfileId(profileId);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Boolean thumbnail = (Boolean)attributes.get("thumbnail");

		if (thumbnail != null) {
			setThumbnail(thumbnail);
		}
	}

	public long getPhotoId() {
		return _photoId;
	}

	public void setPhotoId(long photoId) {
		_photoId = photoId;
	}

	public long getProfileId() {
		return _profileId;
	}

	public void setProfileId(long profileId) {
		_profileId = profileId;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public boolean getThumbnail() {
		return _thumbnail;
	}

	public boolean isThumbnail() {
		return _thumbnail;
	}

	public void setThumbnail(boolean thumbnail) {
		_thumbnail = thumbnail;
	}

	public BaseModel<?> getPhotoRemoteModel() {
		return _photoRemoteModel;
	}

	public void setPhotoRemoteModel(BaseModel<?> photoRemoteModel) {
		_photoRemoteModel = photoRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			PhotoLocalServiceUtil.addPhoto(this);
		}
		else {
			PhotoLocalServiceUtil.updatePhoto(this);
		}
	}

	@Override
	public Photo toEscapedModel() {
		return (Photo)Proxy.newProxyInstance(Photo.class.getClassLoader(),
			new Class[] { Photo.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PhotoClp clone = new PhotoClp();

		clone.setPhotoId(getPhotoId());
		clone.setProfileId(getProfileId());
		clone.setContent(getContent());
		clone.setName(getName());
		clone.setType(getType());
		clone.setThumbnail(getThumbnail());

		return clone;
	}

	public int compareTo(Photo photo) {
		long primaryKey = photo.getPrimaryKey();

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

		PhotoClp photo = null;

		try {
			photo = (PhotoClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = photo.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{photoId=");
		sb.append(getPhotoId());
		sb.append(", profileId=");
		sb.append(getProfileId());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", thumbnail=");
		sb.append(getThumbnail());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.matrimony.model.Photo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>photoId</column-name><column-value><![CDATA[");
		sb.append(getPhotoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>profileId</column-name><column-value><![CDATA[");
		sb.append(getProfileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thumbnail</column-name><column-value><![CDATA[");
		sb.append(getThumbnail());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _photoId;
	private long _profileId;
	private String _content;
	private String _name;
	private String _type;
	private boolean _thumbnail;
	private BaseModel<?> _photoRemoteModel;
}