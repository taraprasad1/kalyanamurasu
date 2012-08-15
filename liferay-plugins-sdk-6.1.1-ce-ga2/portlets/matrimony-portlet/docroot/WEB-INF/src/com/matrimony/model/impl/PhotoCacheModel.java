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

package com.matrimony.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.matrimony.model.Photo;

import java.io.Serializable;

/**
 * The cache model class for representing Photo in entity cache.
 *
 * @author matrimony
 * @see Photo
 * @generated
 */
public class PhotoCacheModel implements CacheModel<Photo>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{photoId=");
		sb.append(photoId);
		sb.append(", profileId=");
		sb.append(profileId);
		sb.append(", content=");
		sb.append(content);
		sb.append(", name=");
		sb.append(name);
		sb.append(", type=");
		sb.append(type);
		sb.append(", thumbnail=");
		sb.append(thumbnail);
		sb.append("}");

		return sb.toString();
	}

	public Photo toEntityModel() {
		PhotoImpl photoImpl = new PhotoImpl();

		photoImpl.setPhotoId(photoId);
		photoImpl.setProfileId(profileId);

		if (content == null) {
			photoImpl.setContent(StringPool.BLANK);
		}
		else {
			photoImpl.setContent(content);
		}

		if (name == null) {
			photoImpl.setName(StringPool.BLANK);
		}
		else {
			photoImpl.setName(name);
		}

		if (type == null) {
			photoImpl.setType(StringPool.BLANK);
		}
		else {
			photoImpl.setType(type);
		}

		photoImpl.setThumbnail(thumbnail);

		photoImpl.resetOriginalValues();

		return photoImpl;
	}

	public long photoId;
	public long profileId;
	public String content;
	public String name;
	public String type;
	public boolean thumbnail;
}