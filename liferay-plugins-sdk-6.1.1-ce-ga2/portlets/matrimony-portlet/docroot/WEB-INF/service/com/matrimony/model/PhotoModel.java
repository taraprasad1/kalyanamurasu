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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Photo service. Represents a row in the &quot;matrimony_photo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.matrimony.model.impl.PhotoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.matrimony.model.impl.PhotoImpl}.
 * </p>
 *
 * @author matrimony
 * @see Photo
 * @see com.matrimony.model.impl.PhotoImpl
 * @see com.matrimony.model.impl.PhotoModelImpl
 * @generated
 */
public interface PhotoModel extends BaseModel<Photo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a photo model instance should use the {@link Photo} interface instead.
	 */

	/**
	 * Returns the primary key of this photo.
	 *
	 * @return the primary key of this photo
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this photo.
	 *
	 * @param primaryKey the primary key of this photo
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the photo ID of this photo.
	 *
	 * @return the photo ID of this photo
	 */
	public long getPhotoId();

	/**
	 * Sets the photo ID of this photo.
	 *
	 * @param photoId the photo ID of this photo
	 */
	public void setPhotoId(long photoId);

	/**
	 * Returns the profile ID of this photo.
	 *
	 * @return the profile ID of this photo
	 */
	public long getProfileId();

	/**
	 * Sets the profile ID of this photo.
	 *
	 * @param profileId the profile ID of this photo
	 */
	public void setProfileId(long profileId);

	/**
	 * Returns the content of this photo.
	 *
	 * @return the content of this photo
	 */
	@AutoEscape
	public String getContent();

	/**
	 * Sets the content of this photo.
	 *
	 * @param content the content of this photo
	 */
	public void setContent(String content);

	/**
	 * Returns the name of this photo.
	 *
	 * @return the name of this photo
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this photo.
	 *
	 * @param name the name of this photo
	 */
	public void setName(String name);

	/**
	 * Returns the type of this photo.
	 *
	 * @return the type of this photo
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this photo.
	 *
	 * @param type the type of this photo
	 */
	public void setType(String type);

	/**
	 * Returns the thumbnail of this photo.
	 *
	 * @return the thumbnail of this photo
	 */
	public boolean getThumbnail();

	/**
	 * Returns <code>true</code> if this photo is thumbnail.
	 *
	 * @return <code>true</code> if this photo is thumbnail; <code>false</code> otherwise
	 */
	public boolean isThumbnail();

	/**
	 * Sets whether this photo is thumbnail.
	 *
	 * @param thumbnail the thumbnail of this photo
	 */
	public void setThumbnail(boolean thumbnail);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Photo photo);

	public int hashCode();

	public CacheModel<Photo> toCacheModel();

	public Photo toEscapedModel();

	public String toString();

	public String toXmlString();
}