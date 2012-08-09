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

package com.vijayan.profile.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Key}.
 * </p>
 *
 * @author    vijayan
 * @see       Key
 * @generated
 */
public class KeyWrapper implements Key, ModelWrapper<Key> {
	public KeyWrapper(Key key) {
		_key = key;
	}

	public Class<?> getModelClass() {
		return Key.class;
	}

	public String getModelClassName() {
		return Key.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("keyId", getKeyId());
		attributes.put("name", getName());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long keyId = (Long)attributes.get("keyId");

		if (keyId != null) {
			setKeyId(keyId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	* Returns the primary key of this key.
	*
	* @return the primary key of this key
	*/
	public long getPrimaryKey() {
		return _key.getPrimaryKey();
	}

	/**
	* Sets the primary key of this key.
	*
	* @param primaryKey the primary key of this key
	*/
	public void setPrimaryKey(long primaryKey) {
		_key.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the key ID of this key.
	*
	* @return the key ID of this key
	*/
	public long getKeyId() {
		return _key.getKeyId();
	}

	/**
	* Sets the key ID of this key.
	*
	* @param keyId the key ID of this key
	*/
	public void setKeyId(long keyId) {
		_key.setKeyId(keyId);
	}

	/**
	* Returns the name of this key.
	*
	* @return the name of this key
	*/
	public java.lang.String getName() {
		return _key.getName();
	}

	/**
	* Sets the name of this key.
	*
	* @param name the name of this key
	*/
	public void setName(java.lang.String name) {
		_key.setName(name);
	}

	public boolean isNew() {
		return _key.isNew();
	}

	public void setNew(boolean n) {
		_key.setNew(n);
	}

	public boolean isCachedModel() {
		return _key.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_key.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _key.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _key.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_key.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _key.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_key.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new KeyWrapper((Key)_key.clone());
	}

	public int compareTo(com.vijayan.profile.model.Key key) {
		return _key.compareTo(key);
	}

	@Override
	public int hashCode() {
		return _key.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vijayan.profile.model.Key> toCacheModel() {
		return _key.toCacheModel();
	}

	public com.vijayan.profile.model.Key toEscapedModel() {
		return new KeyWrapper(_key.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _key.toString();
	}

	public java.lang.String toXmlString() {
		return _key.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_key.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Key getWrappedKey() {
		return _key;
	}

	public Key getWrappedModel() {
		return _key;
	}

	public void resetOriginalValues() {
		_key.resetOriginalValues();
	}

	private Key _key;
}