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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.matrimony.model.Key;
import com.matrimony.model.KeyModel;
import com.matrimony.model.KeySoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Key service. Represents a row in the &quot;matrimony_key&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.matrimony.model.KeyModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link KeyImpl}.
 * </p>
 *
 * @author matrimony
 * @see KeyImpl
 * @see com.matrimony.model.Key
 * @see com.matrimony.model.KeyModel
 * @generated
 */
@JSON(strict = true)
public class KeyModelImpl extends BaseModelImpl<Key> implements KeyModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a key model instance should use the {@link com.matrimony.model.Key} interface instead.
	 */
	public static final String TABLE_NAME = "matrimony_key";
	public static final Object[][] TABLE_COLUMNS = {
			{ "keyId", Types.BIGINT },
			{ "name", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table matrimony_key (keyId LONG not null primary key IDENTITY,name VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table matrimony_key";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.matrimony.model.Key"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.matrimony.model.Key"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.matrimony.model.Key"),
			true);
	public static long NAME_COLUMN_BITMASK = 1L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Key toModel(KeySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Key model = new KeyImpl();

		model.setKeyId(soapModel.getKeyId());
		model.setName(soapModel.getName());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Key> toModels(KeySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Key> models = new ArrayList<Key>(soapModels.length);

		for (KeySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.matrimony.model.Key"));

	public KeyModelImpl() {
	}

	public long getPrimaryKey() {
		return _keyId;
	}

	public void setPrimaryKey(long primaryKey) {
		setKeyId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_keyId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return Key.class;
	}

	public String getModelClassName() {
		return Key.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("keyId", getKeyId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
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

	@JSON
	public long getKeyId() {
		return _keyId;
	}

	public void setKeyId(long keyId) {
		_keyId = keyId;
	}

	@JSON
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	public void setName(String name) {
		_columnBitmask |= NAME_COLUMN_BITMASK;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Key.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Key toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Key)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		KeyImpl keyImpl = new KeyImpl();

		keyImpl.setKeyId(getKeyId());
		keyImpl.setName(getName());

		keyImpl.resetOriginalValues();

		return keyImpl;
	}

	public int compareTo(Key key) {
		long primaryKey = key.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		Key key = null;

		try {
			key = (Key)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = key.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		KeyModelImpl keyModelImpl = this;

		keyModelImpl._originalName = keyModelImpl._name;

		keyModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Key> toCacheModel() {
		KeyCacheModel keyCacheModel = new KeyCacheModel();

		keyCacheModel.keyId = getKeyId();

		keyCacheModel.name = getName();

		String name = keyCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			keyCacheModel.name = null;
		}

		return keyCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{keyId=");
		sb.append(getKeyId());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.matrimony.model.Key");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>keyId</column-name><column-value><![CDATA[");
		sb.append(getKeyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Key.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Key.class
		};
	private long _keyId;
	private String _name;
	private String _originalName;
	private long _columnBitmask;
	private Key _escapedModelProxy;
}