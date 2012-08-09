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

import com.matrimony.model.KeyValue;

import java.io.Serializable;

/**
 * The cache model class for representing KeyValue in entity cache.
 *
 * @author matrimony
 * @see KeyValue
 * @generated
 */
public class KeyValueCacheModel implements CacheModel<KeyValue>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{valueId=");
		sb.append(valueId);
		sb.append(", keyId=");
		sb.append(keyId);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	public KeyValue toEntityModel() {
		KeyValueImpl keyValueImpl = new KeyValueImpl();

		keyValueImpl.setValueId(valueId);
		keyValueImpl.setKeyId(keyId);

		if (name == null) {
			keyValueImpl.setName(StringPool.BLANK);
		}
		else {
			keyValueImpl.setName(name);
		}

		keyValueImpl.resetOriginalValues();

		return keyValueImpl;
	}

	public long valueId;
	public long keyId;
	public String name;
}