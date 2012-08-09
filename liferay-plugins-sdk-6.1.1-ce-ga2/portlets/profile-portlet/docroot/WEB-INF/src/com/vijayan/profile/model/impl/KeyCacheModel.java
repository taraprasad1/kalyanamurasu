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

package com.vijayan.profile.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.vijayan.profile.model.Key;

import java.io.Serializable;

/**
 * The cache model class for representing Key in entity cache.
 *
 * @author vijayan
 * @see Key
 * @generated
 */
public class KeyCacheModel implements CacheModel<Key>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{keyId=");
		sb.append(keyId);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	public Key toEntityModel() {
		KeyImpl keyImpl = new KeyImpl();

		keyImpl.setKeyId(keyId);

		if (name == null) {
			keyImpl.setName(StringPool.BLANK);
		}
		else {
			keyImpl.setName(name);
		}

		keyImpl.resetOriginalValues();

		return keyImpl;
	}

	public long keyId;
	public String name;
}