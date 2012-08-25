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
import com.liferay.portal.model.CacheModel;

import com.matrimony.model.ProfileKeyValue;

import java.io.Serializable;

/**
 * The cache model class for representing ProfileKeyValue in entity cache.
 *
 * @author matrimony
 * @see ProfileKeyValue
 * @generated
 */
public class ProfileKeyValueCacheModel implements CacheModel<ProfileKeyValue>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{profileId=");
		sb.append(profileId);
		sb.append(", keyId=");
		sb.append(keyId);
		sb.append(", valueId=");
		sb.append(valueId);
		sb.append("}");

		return sb.toString();
	}

	public ProfileKeyValue toEntityModel() {
		ProfileKeyValueImpl profileKeyValueImpl = new ProfileKeyValueImpl();

		profileKeyValueImpl.setProfileId(profileId);
		profileKeyValueImpl.setKeyId(keyId);
		profileKeyValueImpl.setValueId(valueId);

		profileKeyValueImpl.resetOriginalValues();

		return profileKeyValueImpl;
	}

	public long profileId;
	public long keyId;
	public long valueId;
}