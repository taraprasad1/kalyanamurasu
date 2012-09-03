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

import com.matrimony.model.ProfileTemp;
import com.matrimony.model.ProfileTempModel;
import com.matrimony.model.ProfileTempSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ProfileTemp service. Represents a row in the &quot;matrimony_profile_temp&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.matrimony.model.ProfileTempModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProfileTempImpl}.
 * </p>
 *
 * @author matrimony
 * @see ProfileTempImpl
 * @see com.matrimony.model.ProfileTemp
 * @see com.matrimony.model.ProfileTempModel
 * @generated
 */
@JSON(strict = true)
public class ProfileTempModelImpl extends BaseModelImpl<ProfileTemp>
	implements ProfileTempModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a profile temp model instance should use the {@link com.matrimony.model.ProfileTemp} interface instead.
	 */
	public static final String TABLE_NAME = "matrimony_profile_temp";
	public static final Object[][] TABLE_COLUMNS = {
			{ "profileTempId", Types.BIGINT },
			{ "profileId", Types.BIGINT },
			{ "name", Types.BIGINT },
			{ "address", Types.VARCHAR },
			{ "pinCode", Types.VARCHAR },
			{ "phone", Types.VARCHAR },
			{ "mobile", Types.VARCHAR },
			{ "emailAddress", Types.VARCHAR },
			{ "aboutMe", Types.VARCHAR },
			{ "scheme", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table matrimony_profile_temp (profileTempId LONG not null primary key IDENTITY,profileId LONG,name LONG,address VARCHAR(75) null,pinCode VARCHAR(75) null,phone VARCHAR(75) null,mobile VARCHAR(75) null,emailAddress VARCHAR(75) null,aboutMe VARCHAR(75) null,scheme INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table matrimony_profile_temp";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.matrimony.model.ProfileTemp"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.matrimony.model.ProfileTemp"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ProfileTemp toModel(ProfileTempSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ProfileTemp model = new ProfileTempImpl();

		model.setProfileTempId(soapModel.getProfileTempId());
		model.setProfileId(soapModel.getProfileId());
		model.setName(soapModel.getName());
		model.setAddress(soapModel.getAddress());
		model.setPinCode(soapModel.getPinCode());
		model.setPhone(soapModel.getPhone());
		model.setMobile(soapModel.getMobile());
		model.setEmailAddress(soapModel.getEmailAddress());
		model.setAboutMe(soapModel.getAboutMe());
		model.setScheme(soapModel.getScheme());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ProfileTemp> toModels(ProfileTempSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ProfileTemp> models = new ArrayList<ProfileTemp>(soapModels.length);

		for (ProfileTempSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.matrimony.model.ProfileTemp"));

	public ProfileTempModelImpl() {
	}

	public long getPrimaryKey() {
		return _profileTempId;
	}

	public void setPrimaryKey(long primaryKey) {
		setProfileTempId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_profileTempId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return ProfileTemp.class;
	}

	public String getModelClassName() {
		return ProfileTemp.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("profileTempId", getProfileTempId());
		attributes.put("profileId", getProfileId());
		attributes.put("name", getName());
		attributes.put("address", getAddress());
		attributes.put("pinCode", getPinCode());
		attributes.put("phone", getPhone());
		attributes.put("mobile", getMobile());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("aboutMe", getAboutMe());
		attributes.put("scheme", getScheme());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long profileTempId = (Long)attributes.get("profileTempId");

		if (profileTempId != null) {
			setProfileTempId(profileTempId);
		}

		Long profileId = (Long)attributes.get("profileId");

		if (profileId != null) {
			setProfileId(profileId);
		}

		Long name = (Long)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String pinCode = (String)attributes.get("pinCode");

		if (pinCode != null) {
			setPinCode(pinCode);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String mobile = (String)attributes.get("mobile");

		if (mobile != null) {
			setMobile(mobile);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String aboutMe = (String)attributes.get("aboutMe");

		if (aboutMe != null) {
			setAboutMe(aboutMe);
		}

		Integer scheme = (Integer)attributes.get("scheme");

		if (scheme != null) {
			setScheme(scheme);
		}
	}

	@JSON
	public long getProfileTempId() {
		return _profileTempId;
	}

	public void setProfileTempId(long profileTempId) {
		_profileTempId = profileTempId;
	}

	@JSON
	public long getProfileId() {
		return _profileId;
	}

	public void setProfileId(long profileId) {
		_profileId = profileId;
	}

	@JSON
	public long getName() {
		return _name;
	}

	public void setName(long name) {
		_name = name;
	}

	@JSON
	public String getAddress() {
		if (_address == null) {
			return StringPool.BLANK;
		}
		else {
			return _address;
		}
	}

	public void setAddress(String address) {
		_address = address;
	}

	@JSON
	public String getPinCode() {
		if (_pinCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _pinCode;
		}
	}

	public void setPinCode(String pinCode) {
		_pinCode = pinCode;
	}

	@JSON
	public String getPhone() {
		if (_phone == null) {
			return StringPool.BLANK;
		}
		else {
			return _phone;
		}
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	@JSON
	public String getMobile() {
		if (_mobile == null) {
			return StringPool.BLANK;
		}
		else {
			return _mobile;
		}
	}

	public void setMobile(String mobile) {
		_mobile = mobile;
	}

	@JSON
	public String getEmailAddress() {
		if (_emailAddress == null) {
			return StringPool.BLANK;
		}
		else {
			return _emailAddress;
		}
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	@JSON
	public String getAboutMe() {
		if (_aboutMe == null) {
			return StringPool.BLANK;
		}
		else {
			return _aboutMe;
		}
	}

	public void setAboutMe(String aboutMe) {
		_aboutMe = aboutMe;
	}

	@JSON
	public int getScheme() {
		return _scheme;
	}

	public void setScheme(int scheme) {
		_scheme = scheme;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ProfileTemp.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ProfileTemp toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (ProfileTemp)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		ProfileTempImpl profileTempImpl = new ProfileTempImpl();

		profileTempImpl.setProfileTempId(getProfileTempId());
		profileTempImpl.setProfileId(getProfileId());
		profileTempImpl.setName(getName());
		profileTempImpl.setAddress(getAddress());
		profileTempImpl.setPinCode(getPinCode());
		profileTempImpl.setPhone(getPhone());
		profileTempImpl.setMobile(getMobile());
		profileTempImpl.setEmailAddress(getEmailAddress());
		profileTempImpl.setAboutMe(getAboutMe());
		profileTempImpl.setScheme(getScheme());

		profileTempImpl.resetOriginalValues();

		return profileTempImpl;
	}

	public int compareTo(ProfileTemp profileTemp) {
		long primaryKey = profileTemp.getPrimaryKey();

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

		ProfileTemp profileTemp = null;

		try {
			profileTemp = (ProfileTemp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = profileTemp.getPrimaryKey();

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
	}

	@Override
	public CacheModel<ProfileTemp> toCacheModel() {
		ProfileTempCacheModel profileTempCacheModel = new ProfileTempCacheModel();

		profileTempCacheModel.profileTempId = getProfileTempId();

		profileTempCacheModel.profileId = getProfileId();

		profileTempCacheModel.name = getName();

		profileTempCacheModel.address = getAddress();

		String address = profileTempCacheModel.address;

		if ((address != null) && (address.length() == 0)) {
			profileTempCacheModel.address = null;
		}

		profileTempCacheModel.pinCode = getPinCode();

		String pinCode = profileTempCacheModel.pinCode;

		if ((pinCode != null) && (pinCode.length() == 0)) {
			profileTempCacheModel.pinCode = null;
		}

		profileTempCacheModel.phone = getPhone();

		String phone = profileTempCacheModel.phone;

		if ((phone != null) && (phone.length() == 0)) {
			profileTempCacheModel.phone = null;
		}

		profileTempCacheModel.mobile = getMobile();

		String mobile = profileTempCacheModel.mobile;

		if ((mobile != null) && (mobile.length() == 0)) {
			profileTempCacheModel.mobile = null;
		}

		profileTempCacheModel.emailAddress = getEmailAddress();

		String emailAddress = profileTempCacheModel.emailAddress;

		if ((emailAddress != null) && (emailAddress.length() == 0)) {
			profileTempCacheModel.emailAddress = null;
		}

		profileTempCacheModel.aboutMe = getAboutMe();

		String aboutMe = profileTempCacheModel.aboutMe;

		if ((aboutMe != null) && (aboutMe.length() == 0)) {
			profileTempCacheModel.aboutMe = null;
		}

		profileTempCacheModel.scheme = getScheme();

		return profileTempCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{profileTempId=");
		sb.append(getProfileTempId());
		sb.append(", profileId=");
		sb.append(getProfileId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append(", pinCode=");
		sb.append(getPinCode());
		sb.append(", phone=");
		sb.append(getPhone());
		sb.append(", mobile=");
		sb.append(getMobile());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append(", aboutMe=");
		sb.append(getAboutMe());
		sb.append(", scheme=");
		sb.append(getScheme());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.matrimony.model.ProfileTemp");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>profileTempId</column-name><column-value><![CDATA[");
		sb.append(getProfileTempId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>profileId</column-name><column-value><![CDATA[");
		sb.append(getProfileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pinCode</column-name><column-value><![CDATA[");
		sb.append(getPinCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phone</column-name><column-value><![CDATA[");
		sb.append(getPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mobile</column-name><column-value><![CDATA[");
		sb.append(getMobile());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailAddress</column-name><column-value><![CDATA[");
		sb.append(getEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>aboutMe</column-name><column-value><![CDATA[");
		sb.append(getAboutMe());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scheme</column-name><column-value><![CDATA[");
		sb.append(getScheme());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ProfileTemp.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			ProfileTemp.class
		};
	private long _profileTempId;
	private long _profileId;
	private long _name;
	private String _address;
	private String _pinCode;
	private String _phone;
	private String _mobile;
	private String _emailAddress;
	private String _aboutMe;
	private int _scheme;
	private ProfileTemp _escapedModelProxy;
}