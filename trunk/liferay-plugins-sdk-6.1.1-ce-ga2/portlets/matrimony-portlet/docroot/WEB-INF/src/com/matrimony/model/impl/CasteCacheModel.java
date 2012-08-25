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

import com.matrimony.model.Caste;

import java.io.Serializable;

/**
 * The cache model class for representing Caste in entity cache.
 *
 * @author matrimony
 * @see Caste
 * @generated
 */
public class CasteCacheModel implements CacheModel<Caste>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{casteId=");
		sb.append(casteId);
		sb.append(", religionId=");
		sb.append(religionId);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	public Caste toEntityModel() {
		CasteImpl casteImpl = new CasteImpl();

		casteImpl.setCasteId(casteId);
		casteImpl.setReligionId(religionId);

		if (name == null) {
			casteImpl.setName(StringPool.BLANK);
		}
		else {
			casteImpl.setName(name);
		}

		casteImpl.resetOriginalValues();

		return casteImpl;
	}

	public long casteId;
	public long religionId;
	public String name;
}