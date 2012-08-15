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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.matrimony.model.Interaction;
import com.matrimony.model.InteractionModel;
import com.matrimony.model.InteractionSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Interaction service. Represents a row in the &quot;matrimony_profile_interaction&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.matrimony.model.InteractionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link InteractionImpl}.
 * </p>
 *
 * @author matrimony
 * @see InteractionImpl
 * @see com.matrimony.model.Interaction
 * @see com.matrimony.model.InteractionModel
 * @generated
 */
@JSON(strict = true)
public class InteractionModelImpl extends BaseModelImpl<Interaction>
	implements InteractionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a interaction model instance should use the {@link com.matrimony.model.Interaction} interface instead.
	 */
	public static final String TABLE_NAME = "matrimony_profile_interaction";
	public static final Object[][] TABLE_COLUMNS = {
			{ "interactionId", Types.BIGINT },
			{ "maleId", Types.BIGINT },
			{ "femaleId", Types.BIGINT },
			{ "maleLastViewedFemale", Types.TIMESTAMP },
			{ "maleViewedCount", Types.INTEGER },
			{ "femaleLastViewedMale", Types.TIMESTAMP },
			{ "femaleViewedCount", Types.INTEGER },
			{ "canViewMalePhoto", Types.BOOLEAN },
			{ "canViewFemalePhoto", Types.BOOLEAN },
			{ "canViewMaleContact", Types.BOOLEAN },
			{ "canViewFemaleContact", Types.BOOLEAN },
			{ "proposedOn", Types.TIMESTAMP },
			{ "proposedByMale", Types.BOOLEAN },
			{ "proposalNotSeen", Types.BOOLEAN },
			{ "respondedOn", Types.TIMESTAMP },
			{ "responseType", Types.INTEGER },
			{ "responseNotSeen", Types.BOOLEAN },
			{ "shortlistedByMale", Types.TIMESTAMP },
			{ "shortlistedByFemale", Types.TIMESTAMP },
			{ "blockedByMale", Types.TIMESTAMP },
			{ "blockedByFemale", Types.TIMESTAMP },
			{ "capturedInMaleReport", Types.INTEGER },
			{ "capturedInFemaleReport", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table matrimony_profile_interaction (interactionId LONG not null primary key IDENTITY,maleId LONG,femaleId LONG,maleLastViewedFemale DATE null,maleViewedCount INTEGER,femaleLastViewedMale DATE null,femaleViewedCount INTEGER,canViewMalePhoto BOOLEAN,canViewFemalePhoto BOOLEAN,canViewMaleContact BOOLEAN,canViewFemaleContact BOOLEAN,proposedOn DATE null,proposedByMale BOOLEAN,proposalNotSeen BOOLEAN,respondedOn DATE null,responseType INTEGER,responseNotSeen BOOLEAN,shortlistedByMale DATE null,shortlistedByFemale DATE null,blockedByMale DATE null,blockedByFemale DATE null,capturedInMaleReport INTEGER,capturedInFemaleReport INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table matrimony_profile_interaction";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.matrimony.model.Interaction"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.matrimony.model.Interaction"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Interaction toModel(InteractionSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Interaction model = new InteractionImpl();

		model.setInteractionId(soapModel.getInteractionId());
		model.setMaleId(soapModel.getMaleId());
		model.setFemaleId(soapModel.getFemaleId());
		model.setMaleLastViewedFemale(soapModel.getMaleLastViewedFemale());
		model.setMaleViewedCount(soapModel.getMaleViewedCount());
		model.setFemaleLastViewedMale(soapModel.getFemaleLastViewedMale());
		model.setFemaleViewedCount(soapModel.getFemaleViewedCount());
		model.setCanViewMalePhoto(soapModel.getCanViewMalePhoto());
		model.setCanViewFemalePhoto(soapModel.getCanViewFemalePhoto());
		model.setCanViewMaleContact(soapModel.getCanViewMaleContact());
		model.setCanViewFemaleContact(soapModel.getCanViewFemaleContact());
		model.setProposedOn(soapModel.getProposedOn());
		model.setProposedByMale(soapModel.getProposedByMale());
		model.setProposalNotSeen(soapModel.getProposalNotSeen());
		model.setRespondedOn(soapModel.getRespondedOn());
		model.setResponseType(soapModel.getResponseType());
		model.setResponseNotSeen(soapModel.getResponseNotSeen());
		model.setShortlistedByMale(soapModel.getShortlistedByMale());
		model.setShortlistedByFemale(soapModel.getShortlistedByFemale());
		model.setBlockedByMale(soapModel.getBlockedByMale());
		model.setBlockedByFemale(soapModel.getBlockedByFemale());
		model.setCapturedInMaleReport(soapModel.getCapturedInMaleReport());
		model.setCapturedInFemaleReport(soapModel.getCapturedInFemaleReport());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Interaction> toModels(InteractionSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Interaction> models = new ArrayList<Interaction>(soapModels.length);

		for (InteractionSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.matrimony.model.Interaction"));

	public InteractionModelImpl() {
	}

	public long getPrimaryKey() {
		return _interactionId;
	}

	public void setPrimaryKey(long primaryKey) {
		setInteractionId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_interactionId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return Interaction.class;
	}

	public String getModelClassName() {
		return Interaction.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("interactionId", getInteractionId());
		attributes.put("maleId", getMaleId());
		attributes.put("femaleId", getFemaleId());
		attributes.put("maleLastViewedFemale", getMaleLastViewedFemale());
		attributes.put("maleViewedCount", getMaleViewedCount());
		attributes.put("femaleLastViewedMale", getFemaleLastViewedMale());
		attributes.put("femaleViewedCount", getFemaleViewedCount());
		attributes.put("canViewMalePhoto", getCanViewMalePhoto());
		attributes.put("canViewFemalePhoto", getCanViewFemalePhoto());
		attributes.put("canViewMaleContact", getCanViewMaleContact());
		attributes.put("canViewFemaleContact", getCanViewFemaleContact());
		attributes.put("proposedOn", getProposedOn());
		attributes.put("proposedByMale", getProposedByMale());
		attributes.put("proposalNotSeen", getProposalNotSeen());
		attributes.put("respondedOn", getRespondedOn());
		attributes.put("responseType", getResponseType());
		attributes.put("responseNotSeen", getResponseNotSeen());
		attributes.put("shortlistedByMale", getShortlistedByMale());
		attributes.put("shortlistedByFemale", getShortlistedByFemale());
		attributes.put("blockedByMale", getBlockedByMale());
		attributes.put("blockedByFemale", getBlockedByFemale());
		attributes.put("capturedInMaleReport", getCapturedInMaleReport());
		attributes.put("capturedInFemaleReport", getCapturedInFemaleReport());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long interactionId = (Long)attributes.get("interactionId");

		if (interactionId != null) {
			setInteractionId(interactionId);
		}

		Long maleId = (Long)attributes.get("maleId");

		if (maleId != null) {
			setMaleId(maleId);
		}

		Long femaleId = (Long)attributes.get("femaleId");

		if (femaleId != null) {
			setFemaleId(femaleId);
		}

		Date maleLastViewedFemale = (Date)attributes.get("maleLastViewedFemale");

		if (maleLastViewedFemale != null) {
			setMaleLastViewedFemale(maleLastViewedFemale);
		}

		Integer maleViewedCount = (Integer)attributes.get("maleViewedCount");

		if (maleViewedCount != null) {
			setMaleViewedCount(maleViewedCount);
		}

		Date femaleLastViewedMale = (Date)attributes.get("femaleLastViewedMale");

		if (femaleLastViewedMale != null) {
			setFemaleLastViewedMale(femaleLastViewedMale);
		}

		Integer femaleViewedCount = (Integer)attributes.get("femaleViewedCount");

		if (femaleViewedCount != null) {
			setFemaleViewedCount(femaleViewedCount);
		}

		Boolean canViewMalePhoto = (Boolean)attributes.get("canViewMalePhoto");

		if (canViewMalePhoto != null) {
			setCanViewMalePhoto(canViewMalePhoto);
		}

		Boolean canViewFemalePhoto = (Boolean)attributes.get(
				"canViewFemalePhoto");

		if (canViewFemalePhoto != null) {
			setCanViewFemalePhoto(canViewFemalePhoto);
		}

		Boolean canViewMaleContact = (Boolean)attributes.get(
				"canViewMaleContact");

		if (canViewMaleContact != null) {
			setCanViewMaleContact(canViewMaleContact);
		}

		Boolean canViewFemaleContact = (Boolean)attributes.get(
				"canViewFemaleContact");

		if (canViewFemaleContact != null) {
			setCanViewFemaleContact(canViewFemaleContact);
		}

		Date proposedOn = (Date)attributes.get("proposedOn");

		if (proposedOn != null) {
			setProposedOn(proposedOn);
		}

		Boolean proposedByMale = (Boolean)attributes.get("proposedByMale");

		if (proposedByMale != null) {
			setProposedByMale(proposedByMale);
		}

		Boolean proposalNotSeen = (Boolean)attributes.get("proposalNotSeen");

		if (proposalNotSeen != null) {
			setProposalNotSeen(proposalNotSeen);
		}

		Date respondedOn = (Date)attributes.get("respondedOn");

		if (respondedOn != null) {
			setRespondedOn(respondedOn);
		}

		Integer responseType = (Integer)attributes.get("responseType");

		if (responseType != null) {
			setResponseType(responseType);
		}

		Boolean responseNotSeen = (Boolean)attributes.get("responseNotSeen");

		if (responseNotSeen != null) {
			setResponseNotSeen(responseNotSeen);
		}

		Date shortlistedByMale = (Date)attributes.get("shortlistedByMale");

		if (shortlistedByMale != null) {
			setShortlistedByMale(shortlistedByMale);
		}

		Date shortlistedByFemale = (Date)attributes.get("shortlistedByFemale");

		if (shortlistedByFemale != null) {
			setShortlistedByFemale(shortlistedByFemale);
		}

		Date blockedByMale = (Date)attributes.get("blockedByMale");

		if (blockedByMale != null) {
			setBlockedByMale(blockedByMale);
		}

		Date blockedByFemale = (Date)attributes.get("blockedByFemale");

		if (blockedByFemale != null) {
			setBlockedByFemale(blockedByFemale);
		}

		Integer capturedInMaleReport = (Integer)attributes.get(
				"capturedInMaleReport");

		if (capturedInMaleReport != null) {
			setCapturedInMaleReport(capturedInMaleReport);
		}

		Integer capturedInFemaleReport = (Integer)attributes.get(
				"capturedInFemaleReport");

		if (capturedInFemaleReport != null) {
			setCapturedInFemaleReport(capturedInFemaleReport);
		}
	}

	@JSON
	public long getInteractionId() {
		return _interactionId;
	}

	public void setInteractionId(long interactionId) {
		_interactionId = interactionId;
	}

	@JSON
	public long getMaleId() {
		return _maleId;
	}

	public void setMaleId(long maleId) {
		_maleId = maleId;
	}

	@JSON
	public long getFemaleId() {
		return _femaleId;
	}

	public void setFemaleId(long femaleId) {
		_femaleId = femaleId;
	}

	@JSON
	public Date getMaleLastViewedFemale() {
		return _maleLastViewedFemale;
	}

	public void setMaleLastViewedFemale(Date maleLastViewedFemale) {
		_maleLastViewedFemale = maleLastViewedFemale;
	}

	@JSON
	public int getMaleViewedCount() {
		return _maleViewedCount;
	}

	public void setMaleViewedCount(int maleViewedCount) {
		_maleViewedCount = maleViewedCount;
	}

	@JSON
	public Date getFemaleLastViewedMale() {
		return _femaleLastViewedMale;
	}

	public void setFemaleLastViewedMale(Date femaleLastViewedMale) {
		_femaleLastViewedMale = femaleLastViewedMale;
	}

	@JSON
	public int getFemaleViewedCount() {
		return _femaleViewedCount;
	}

	public void setFemaleViewedCount(int femaleViewedCount) {
		_femaleViewedCount = femaleViewedCount;
	}

	@JSON
	public boolean getCanViewMalePhoto() {
		return _canViewMalePhoto;
	}

	public boolean isCanViewMalePhoto() {
		return _canViewMalePhoto;
	}

	public void setCanViewMalePhoto(boolean canViewMalePhoto) {
		_canViewMalePhoto = canViewMalePhoto;
	}

	@JSON
	public boolean getCanViewFemalePhoto() {
		return _canViewFemalePhoto;
	}

	public boolean isCanViewFemalePhoto() {
		return _canViewFemalePhoto;
	}

	public void setCanViewFemalePhoto(boolean canViewFemalePhoto) {
		_canViewFemalePhoto = canViewFemalePhoto;
	}

	@JSON
	public boolean getCanViewMaleContact() {
		return _canViewMaleContact;
	}

	public boolean isCanViewMaleContact() {
		return _canViewMaleContact;
	}

	public void setCanViewMaleContact(boolean canViewMaleContact) {
		_canViewMaleContact = canViewMaleContact;
	}

	@JSON
	public boolean getCanViewFemaleContact() {
		return _canViewFemaleContact;
	}

	public boolean isCanViewFemaleContact() {
		return _canViewFemaleContact;
	}

	public void setCanViewFemaleContact(boolean canViewFemaleContact) {
		_canViewFemaleContact = canViewFemaleContact;
	}

	@JSON
	public Date getProposedOn() {
		return _proposedOn;
	}

	public void setProposedOn(Date proposedOn) {
		_proposedOn = proposedOn;
	}

	@JSON
	public boolean getProposedByMale() {
		return _proposedByMale;
	}

	public boolean isProposedByMale() {
		return _proposedByMale;
	}

	public void setProposedByMale(boolean proposedByMale) {
		_proposedByMale = proposedByMale;
	}

	@JSON
	public boolean getProposalNotSeen() {
		return _proposalNotSeen;
	}

	public boolean isProposalNotSeen() {
		return _proposalNotSeen;
	}

	public void setProposalNotSeen(boolean proposalNotSeen) {
		_proposalNotSeen = proposalNotSeen;
	}

	@JSON
	public Date getRespondedOn() {
		return _respondedOn;
	}

	public void setRespondedOn(Date respondedOn) {
		_respondedOn = respondedOn;
	}

	@JSON
	public int getResponseType() {
		return _responseType;
	}

	public void setResponseType(int responseType) {
		_responseType = responseType;
	}

	@JSON
	public boolean getResponseNotSeen() {
		return _responseNotSeen;
	}

	public boolean isResponseNotSeen() {
		return _responseNotSeen;
	}

	public void setResponseNotSeen(boolean responseNotSeen) {
		_responseNotSeen = responseNotSeen;
	}

	@JSON
	public Date getShortlistedByMale() {
		return _shortlistedByMale;
	}

	public void setShortlistedByMale(Date shortlistedByMale) {
		_shortlistedByMale = shortlistedByMale;
	}

	@JSON
	public Date getShortlistedByFemale() {
		return _shortlistedByFemale;
	}

	public void setShortlistedByFemale(Date shortlistedByFemale) {
		_shortlistedByFemale = shortlistedByFemale;
	}

	@JSON
	public Date getBlockedByMale() {
		return _blockedByMale;
	}

	public void setBlockedByMale(Date blockedByMale) {
		_blockedByMale = blockedByMale;
	}

	@JSON
	public Date getBlockedByFemale() {
		return _blockedByFemale;
	}

	public void setBlockedByFemale(Date blockedByFemale) {
		_blockedByFemale = blockedByFemale;
	}

	@JSON
	public int getCapturedInMaleReport() {
		return _capturedInMaleReport;
	}

	public void setCapturedInMaleReport(int capturedInMaleReport) {
		_capturedInMaleReport = capturedInMaleReport;
	}

	@JSON
	public int getCapturedInFemaleReport() {
		return _capturedInFemaleReport;
	}

	public void setCapturedInFemaleReport(int capturedInFemaleReport) {
		_capturedInFemaleReport = capturedInFemaleReport;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Interaction.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Interaction toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Interaction)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		InteractionImpl interactionImpl = new InteractionImpl();

		interactionImpl.setInteractionId(getInteractionId());
		interactionImpl.setMaleId(getMaleId());
		interactionImpl.setFemaleId(getFemaleId());
		interactionImpl.setMaleLastViewedFemale(getMaleLastViewedFemale());
		interactionImpl.setMaleViewedCount(getMaleViewedCount());
		interactionImpl.setFemaleLastViewedMale(getFemaleLastViewedMale());
		interactionImpl.setFemaleViewedCount(getFemaleViewedCount());
		interactionImpl.setCanViewMalePhoto(getCanViewMalePhoto());
		interactionImpl.setCanViewFemalePhoto(getCanViewFemalePhoto());
		interactionImpl.setCanViewMaleContact(getCanViewMaleContact());
		interactionImpl.setCanViewFemaleContact(getCanViewFemaleContact());
		interactionImpl.setProposedOn(getProposedOn());
		interactionImpl.setProposedByMale(getProposedByMale());
		interactionImpl.setProposalNotSeen(getProposalNotSeen());
		interactionImpl.setRespondedOn(getRespondedOn());
		interactionImpl.setResponseType(getResponseType());
		interactionImpl.setResponseNotSeen(getResponseNotSeen());
		interactionImpl.setShortlistedByMale(getShortlistedByMale());
		interactionImpl.setShortlistedByFemale(getShortlistedByFemale());
		interactionImpl.setBlockedByMale(getBlockedByMale());
		interactionImpl.setBlockedByFemale(getBlockedByFemale());
		interactionImpl.setCapturedInMaleReport(getCapturedInMaleReport());
		interactionImpl.setCapturedInFemaleReport(getCapturedInFemaleReport());

		interactionImpl.resetOriginalValues();

		return interactionImpl;
	}

	public int compareTo(Interaction interaction) {
		long primaryKey = interaction.getPrimaryKey();

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

		Interaction interaction = null;

		try {
			interaction = (Interaction)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = interaction.getPrimaryKey();

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
	public CacheModel<Interaction> toCacheModel() {
		InteractionCacheModel interactionCacheModel = new InteractionCacheModel();

		interactionCacheModel.interactionId = getInteractionId();

		interactionCacheModel.maleId = getMaleId();

		interactionCacheModel.femaleId = getFemaleId();

		Date maleLastViewedFemale = getMaleLastViewedFemale();

		if (maleLastViewedFemale != null) {
			interactionCacheModel.maleLastViewedFemale = maleLastViewedFemale.getTime();
		}
		else {
			interactionCacheModel.maleLastViewedFemale = Long.MIN_VALUE;
		}

		interactionCacheModel.maleViewedCount = getMaleViewedCount();

		Date femaleLastViewedMale = getFemaleLastViewedMale();

		if (femaleLastViewedMale != null) {
			interactionCacheModel.femaleLastViewedMale = femaleLastViewedMale.getTime();
		}
		else {
			interactionCacheModel.femaleLastViewedMale = Long.MIN_VALUE;
		}

		interactionCacheModel.femaleViewedCount = getFemaleViewedCount();

		interactionCacheModel.canViewMalePhoto = getCanViewMalePhoto();

		interactionCacheModel.canViewFemalePhoto = getCanViewFemalePhoto();

		interactionCacheModel.canViewMaleContact = getCanViewMaleContact();

		interactionCacheModel.canViewFemaleContact = getCanViewFemaleContact();

		Date proposedOn = getProposedOn();

		if (proposedOn != null) {
			interactionCacheModel.proposedOn = proposedOn.getTime();
		}
		else {
			interactionCacheModel.proposedOn = Long.MIN_VALUE;
		}

		interactionCacheModel.proposedByMale = getProposedByMale();

		interactionCacheModel.proposalNotSeen = getProposalNotSeen();

		Date respondedOn = getRespondedOn();

		if (respondedOn != null) {
			interactionCacheModel.respondedOn = respondedOn.getTime();
		}
		else {
			interactionCacheModel.respondedOn = Long.MIN_VALUE;
		}

		interactionCacheModel.responseType = getResponseType();

		interactionCacheModel.responseNotSeen = getResponseNotSeen();

		Date shortlistedByMale = getShortlistedByMale();

		if (shortlistedByMale != null) {
			interactionCacheModel.shortlistedByMale = shortlistedByMale.getTime();
		}
		else {
			interactionCacheModel.shortlistedByMale = Long.MIN_VALUE;
		}

		Date shortlistedByFemale = getShortlistedByFemale();

		if (shortlistedByFemale != null) {
			interactionCacheModel.shortlistedByFemale = shortlistedByFemale.getTime();
		}
		else {
			interactionCacheModel.shortlistedByFemale = Long.MIN_VALUE;
		}

		Date blockedByMale = getBlockedByMale();

		if (blockedByMale != null) {
			interactionCacheModel.blockedByMale = blockedByMale.getTime();
		}
		else {
			interactionCacheModel.blockedByMale = Long.MIN_VALUE;
		}

		Date blockedByFemale = getBlockedByFemale();

		if (blockedByFemale != null) {
			interactionCacheModel.blockedByFemale = blockedByFemale.getTime();
		}
		else {
			interactionCacheModel.blockedByFemale = Long.MIN_VALUE;
		}

		interactionCacheModel.capturedInMaleReport = getCapturedInMaleReport();

		interactionCacheModel.capturedInFemaleReport = getCapturedInFemaleReport();

		return interactionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{interactionId=");
		sb.append(getInteractionId());
		sb.append(", maleId=");
		sb.append(getMaleId());
		sb.append(", femaleId=");
		sb.append(getFemaleId());
		sb.append(", maleLastViewedFemale=");
		sb.append(getMaleLastViewedFemale());
		sb.append(", maleViewedCount=");
		sb.append(getMaleViewedCount());
		sb.append(", femaleLastViewedMale=");
		sb.append(getFemaleLastViewedMale());
		sb.append(", femaleViewedCount=");
		sb.append(getFemaleViewedCount());
		sb.append(", canViewMalePhoto=");
		sb.append(getCanViewMalePhoto());
		sb.append(", canViewFemalePhoto=");
		sb.append(getCanViewFemalePhoto());
		sb.append(", canViewMaleContact=");
		sb.append(getCanViewMaleContact());
		sb.append(", canViewFemaleContact=");
		sb.append(getCanViewFemaleContact());
		sb.append(", proposedOn=");
		sb.append(getProposedOn());
		sb.append(", proposedByMale=");
		sb.append(getProposedByMale());
		sb.append(", proposalNotSeen=");
		sb.append(getProposalNotSeen());
		sb.append(", respondedOn=");
		sb.append(getRespondedOn());
		sb.append(", responseType=");
		sb.append(getResponseType());
		sb.append(", responseNotSeen=");
		sb.append(getResponseNotSeen());
		sb.append(", shortlistedByMale=");
		sb.append(getShortlistedByMale());
		sb.append(", shortlistedByFemale=");
		sb.append(getShortlistedByFemale());
		sb.append(", blockedByMale=");
		sb.append(getBlockedByMale());
		sb.append(", blockedByFemale=");
		sb.append(getBlockedByFemale());
		sb.append(", capturedInMaleReport=");
		sb.append(getCapturedInMaleReport());
		sb.append(", capturedInFemaleReport=");
		sb.append(getCapturedInFemaleReport());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(73);

		sb.append("<model><model-name>");
		sb.append("com.matrimony.model.Interaction");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>interactionId</column-name><column-value><![CDATA[");
		sb.append(getInteractionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maleId</column-name><column-value><![CDATA[");
		sb.append(getMaleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>femaleId</column-name><column-value><![CDATA[");
		sb.append(getFemaleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maleLastViewedFemale</column-name><column-value><![CDATA[");
		sb.append(getMaleLastViewedFemale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maleViewedCount</column-name><column-value><![CDATA[");
		sb.append(getMaleViewedCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>femaleLastViewedMale</column-name><column-value><![CDATA[");
		sb.append(getFemaleLastViewedMale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>femaleViewedCount</column-name><column-value><![CDATA[");
		sb.append(getFemaleViewedCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>canViewMalePhoto</column-name><column-value><![CDATA[");
		sb.append(getCanViewMalePhoto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>canViewFemalePhoto</column-name><column-value><![CDATA[");
		sb.append(getCanViewFemalePhoto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>canViewMaleContact</column-name><column-value><![CDATA[");
		sb.append(getCanViewMaleContact());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>canViewFemaleContact</column-name><column-value><![CDATA[");
		sb.append(getCanViewFemaleContact());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>proposedOn</column-name><column-value><![CDATA[");
		sb.append(getProposedOn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>proposedByMale</column-name><column-value><![CDATA[");
		sb.append(getProposedByMale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>proposalNotSeen</column-name><column-value><![CDATA[");
		sb.append(getProposalNotSeen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>respondedOn</column-name><column-value><![CDATA[");
		sb.append(getRespondedOn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>responseType</column-name><column-value><![CDATA[");
		sb.append(getResponseType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>responseNotSeen</column-name><column-value><![CDATA[");
		sb.append(getResponseNotSeen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shortlistedByMale</column-name><column-value><![CDATA[");
		sb.append(getShortlistedByMale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shortlistedByFemale</column-name><column-value><![CDATA[");
		sb.append(getShortlistedByFemale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>blockedByMale</column-name><column-value><![CDATA[");
		sb.append(getBlockedByMale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>blockedByFemale</column-name><column-value><![CDATA[");
		sb.append(getBlockedByFemale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>capturedInMaleReport</column-name><column-value><![CDATA[");
		sb.append(getCapturedInMaleReport());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>capturedInFemaleReport</column-name><column-value><![CDATA[");
		sb.append(getCapturedInFemaleReport());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Interaction.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Interaction.class
		};
	private long _interactionId;
	private long _maleId;
	private long _femaleId;
	private Date _maleLastViewedFemale;
	private int _maleViewedCount;
	private Date _femaleLastViewedMale;
	private int _femaleViewedCount;
	private boolean _canViewMalePhoto;
	private boolean _canViewFemalePhoto;
	private boolean _canViewMaleContact;
	private boolean _canViewFemaleContact;
	private Date _proposedOn;
	private boolean _proposedByMale;
	private boolean _proposalNotSeen;
	private Date _respondedOn;
	private int _responseType;
	private boolean _responseNotSeen;
	private Date _shortlistedByMale;
	private Date _shortlistedByFemale;
	private Date _blockedByMale;
	private Date _blockedByFemale;
	private int _capturedInMaleReport;
	private int _capturedInFemaleReport;
	private Interaction _escapedModelProxy;
}