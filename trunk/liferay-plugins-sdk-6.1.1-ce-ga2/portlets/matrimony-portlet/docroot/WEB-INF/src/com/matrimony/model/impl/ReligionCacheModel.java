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

import com.matrimony.model.Religion;

import java.io.Serializable;

/**
 * The cache model class for representing Religion in entity cache.
 *
 * @author matrimony
 * @see Religion
 * @generated
 */
public class ReligionCacheModel implements CacheModel<Religion>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{religionId=");
		sb.append(religionId);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	public Religion toEntityModel() {
		ReligionImpl religionImpl = new ReligionImpl();

		religionImpl.setReligionId(religionId);

		if (name == null) {
			religionImpl.setName(StringPool.BLANK);
		}
		else {
			religionImpl.setName(name);
		}

		religionImpl.resetOriginalValues();

		return religionImpl;
	}

	public long religionId;
	public String name;
}