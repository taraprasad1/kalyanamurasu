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

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link KeyValue}.
 * </p>
 *
 * @author    matrimony
 * @see       KeyValue
 * @generated
 */
public class KeyValueWrapper implements KeyValue, ModelWrapper<KeyValue> {
	public KeyValueWrapper(KeyValue keyValue) {
		_keyValue = keyValue;
	}

	public Class<?> getModelClass() {
		return KeyValue.class;
	}

	public String getModelClassName() {
		return KeyValue.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("valueId", getValueId());
		attributes.put("keyId", getKeyId());
		attributes.put("name", getName());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long valueId = (Long)attributes.get("valueId");

		if (valueId != null) {
			setValueId(valueId);
		}

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
	* Returns the primary key of this key value.
	*
	* @return the primary key of this key value
	*/
	public long getPrimaryKey() {
		return _keyValue.getPrimaryKey();
	}

	/**
	* Sets the primary key of this key value.
	*
	* @param primaryKey the primary key of this key value
	*/
	public void setPrimaryKey(long primaryKey) {
		_keyValue.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the value ID of this key value.
	*
	* @return the value ID of this key value
	*/
	public long getValueId() {
		return _keyValue.getValueId();
	}

	/**
	* Sets the value ID of this key value.
	*
	* @param valueId the value ID of this key value
	*/
	public void setValueId(long valueId) {
		_keyValue.setValueId(valueId);
	}

	/**
	* Returns the key ID of this key value.
	*
	* @return the key ID of this key value
	*/
	public long getKeyId() {
		return _keyValue.getKeyId();
	}

	/**
	* Sets the key ID of this key value.
	*
	* @param keyId the key ID of this key value
	*/
	public void setKeyId(long keyId) {
		_keyValue.setKeyId(keyId);
	}

	/**
	* Returns the name of this key value.
	*
	* @return the name of this key value
	*/
	public java.lang.String getName() {
		return _keyValue.getName();
	}

	/**
	* Sets the name of this key value.
	*
	* @param name the name of this key value
	*/
	public void setName(java.lang.String name) {
		_keyValue.setName(name);
	}

	public boolean isNew() {
		return _keyValue.isNew();
	}

	public void setNew(boolean n) {
		_keyValue.setNew(n);
	}

	public boolean isCachedModel() {
		return _keyValue.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_keyValue.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _keyValue.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _keyValue.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_keyValue.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _keyValue.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_keyValue.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new KeyValueWrapper((KeyValue)_keyValue.clone());
	}

	public int compareTo(com.matrimony.model.KeyValue keyValue) {
		return _keyValue.compareTo(keyValue);
	}

	@Override
	public int hashCode() {
		return _keyValue.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.matrimony.model.KeyValue> toCacheModel() {
		return _keyValue.toCacheModel();
	}

	public com.matrimony.model.KeyValue toEscapedModel() {
		return new KeyValueWrapper(_keyValue.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _keyValue.toString();
	}

	public java.lang.String toXmlString() {
		return _keyValue.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_keyValue.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public KeyValue getWrappedKeyValue() {
		return _keyValue;
	}

	public KeyValue getWrappedModel() {
		return _keyValue;
	}

	public void resetOriginalValues() {
		_keyValue.resetOriginalValues();
	}

	private KeyValue _keyValue;
}