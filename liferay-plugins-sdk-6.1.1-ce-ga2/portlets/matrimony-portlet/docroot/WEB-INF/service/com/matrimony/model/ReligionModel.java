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
 * The base model interface for the Religion service. Represents a row in the &quot;matrimony_religion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.matrimony.model.impl.ReligionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.matrimony.model.impl.ReligionImpl}.
 * </p>
 *
 * @author matrimony
 * @see Religion
 * @see com.matrimony.model.impl.ReligionImpl
 * @see com.matrimony.model.impl.ReligionModelImpl
 * @generated
 */
public interface ReligionModel extends BaseModel<Religion> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a religion model instance should use the {@link Religion} interface instead.
	 */

	/**
	 * Returns the primary key of this religion.
	 *
	 * @return the primary key of this religion
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this religion.
	 *
	 * @param primaryKey the primary key of this religion
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the religion ID of this religion.
	 *
	 * @return the religion ID of this religion
	 */
	public long getReligionId();

	/**
	 * Sets the religion ID of this religion.
	 *
	 * @param religionId the religion ID of this religion
	 */
	public void setReligionId(long religionId);

	/**
	 * Returns the name of this religion.
	 *
	 * @return the name of this religion
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this religion.
	 *
	 * @param name the name of this religion
	 */
	public void setName(String name);

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

	public int compareTo(Religion religion);

	public int hashCode();

	public CacheModel<Religion> toCacheModel();

	public Religion toEscapedModel();

	public String toString();

	public String toXmlString();
}