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

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Photo}.
 * </p>
 *
 * @author    matrimony
 * @see       Photo
 * @generated
 */
public class PhotoWrapper implements Photo, ModelWrapper<Photo> {
	public PhotoWrapper(Photo photo) {
		_photo = photo;
	}

	public Class<?> getModelClass() {
		return Photo.class;
	}

	public String getModelClassName() {
		return Photo.class.getName();
	}

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

	/**
	* Returns the primary key of this photo.
	*
	* @return the primary key of this photo
	*/
	public long getPrimaryKey() {
		return _photo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this photo.
	*
	* @param primaryKey the primary key of this photo
	*/
	public void setPrimaryKey(long primaryKey) {
		_photo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the photo ID of this photo.
	*
	* @return the photo ID of this photo
	*/
	public long getPhotoId() {
		return _photo.getPhotoId();
	}

	/**
	* Sets the photo ID of this photo.
	*
	* @param photoId the photo ID of this photo
	*/
	public void setPhotoId(long photoId) {
		_photo.setPhotoId(photoId);
	}

	/**
	* Returns the profile ID of this photo.
	*
	* @return the profile ID of this photo
	*/
	public long getProfileId() {
		return _photo.getProfileId();
	}

	/**
	* Sets the profile ID of this photo.
	*
	* @param profileId the profile ID of this photo
	*/
	public void setProfileId(long profileId) {
		_photo.setProfileId(profileId);
	}

	/**
	* Returns the content of this photo.
	*
	* @return the content of this photo
	*/
	public java.lang.String getContent() {
		return _photo.getContent();
	}

	/**
	* Sets the content of this photo.
	*
	* @param content the content of this photo
	*/
	public void setContent(java.lang.String content) {
		_photo.setContent(content);
	}

	/**
	* Returns the name of this photo.
	*
	* @return the name of this photo
	*/
	public java.lang.String getName() {
		return _photo.getName();
	}

	/**
	* Sets the name of this photo.
	*
	* @param name the name of this photo
	*/
	public void setName(java.lang.String name) {
		_photo.setName(name);
	}

	/**
	* Returns the type of this photo.
	*
	* @return the type of this photo
	*/
	public java.lang.String getType() {
		return _photo.getType();
	}

	/**
	* Sets the type of this photo.
	*
	* @param type the type of this photo
	*/
	public void setType(java.lang.String type) {
		_photo.setType(type);
	}

	/**
	* Returns the thumbnail of this photo.
	*
	* @return the thumbnail of this photo
	*/
	public boolean getThumbnail() {
		return _photo.getThumbnail();
	}

	/**
	* Returns <code>true</code> if this photo is thumbnail.
	*
	* @return <code>true</code> if this photo is thumbnail; <code>false</code> otherwise
	*/
	public boolean isThumbnail() {
		return _photo.isThumbnail();
	}

	/**
	* Sets whether this photo is thumbnail.
	*
	* @param thumbnail the thumbnail of this photo
	*/
	public void setThumbnail(boolean thumbnail) {
		_photo.setThumbnail(thumbnail);
	}

	public boolean isNew() {
		return _photo.isNew();
	}

	public void setNew(boolean n) {
		_photo.setNew(n);
	}

	public boolean isCachedModel() {
		return _photo.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_photo.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _photo.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _photo.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_photo.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _photo.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_photo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PhotoWrapper((Photo)_photo.clone());
	}

	public int compareTo(com.matrimony.model.Photo photo) {
		return _photo.compareTo(photo);
	}

	@Override
	public int hashCode() {
		return _photo.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.matrimony.model.Photo> toCacheModel() {
		return _photo.toCacheModel();
	}

	public com.matrimony.model.Photo toEscapedModel() {
		return new PhotoWrapper(_photo.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _photo.toString();
	}

	public java.lang.String toXmlString() {
		return _photo.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_photo.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Photo getWrappedPhoto() {
		return _photo;
	}

	public Photo getWrappedModel() {
		return _photo;
	}

	public void resetOriginalValues() {
		_photo.resetOriginalValues();
	}

	private Photo _photo;
}