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
 * This class is used by SOAP remote services, specifically {@link com.matrimony.service.http.PhotoServiceSoap}.
 *
 * @author    matrimony
 * @see       com.matrimony.service.http.PhotoServiceSoap
 * @generated
 */
public class PhotoSoap implements Serializable {
	public static PhotoSoap toSoapModel(Photo model) {
		PhotoSoap soapModel = new PhotoSoap();

		soapModel.setPhotoId(model.getPhotoId());
		soapModel.setProfileId(model.getProfileId());
		soapModel.setContent(model.getContent());
		soapModel.setName(model.getName());
		soapModel.setType(model.getType());
		soapModel.setThumbnail(model.getThumbnail());

		return soapModel;
	}

	public static PhotoSoap[] toSoapModels(Photo[] models) {
		PhotoSoap[] soapModels = new PhotoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PhotoSoap[][] toSoapModels(Photo[][] models) {
		PhotoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PhotoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PhotoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PhotoSoap[] toSoapModels(List<Photo> models) {
		List<PhotoSoap> soapModels = new ArrayList<PhotoSoap>(models.size());

		for (Photo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PhotoSoap[soapModels.size()]);
	}

	public PhotoSoap() {
	}

	public long getPrimaryKey() {
		return _photoId;
	}

	public void setPrimaryKey(long pk) {
		setPhotoId(pk);
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

	private long _photoId;
	private long _profileId;
	private String _content;
	private String _name;
	private String _type;
	private boolean _thumbnail;
}