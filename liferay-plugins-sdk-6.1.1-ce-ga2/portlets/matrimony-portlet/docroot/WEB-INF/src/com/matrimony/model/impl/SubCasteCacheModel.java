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

import com.matrimony.model.SubCaste;

import java.io.Serializable;

/**
 * The cache model class for representing SubCaste in entity cache.
 *
 * @author matrimony
 * @see SubCaste
 * @generated
 */
public class SubCasteCacheModel implements CacheModel<SubCaste>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{subCasteId=");
		sb.append(subCasteId);
		sb.append(", casteId=");
		sb.append(casteId);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	public SubCaste toEntityModel() {
		SubCasteImpl subCasteImpl = new SubCasteImpl();

		subCasteImpl.setSubCasteId(subCasteId);
		subCasteImpl.setCasteId(casteId);

		if (name == null) {
			subCasteImpl.setName(StringPool.BLANK);
		}
		else {
			subCasteImpl.setName(name);
		}

		subCasteImpl.resetOriginalValues();

		return subCasteImpl;
	}

	public long subCasteId;
	public long casteId;
	public String name;
}