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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.matrimony.service.InteractionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author matrimony
 */
public class InteractionClp extends BaseModelImpl<Interaction>
	implements Interaction {
	public InteractionClp() {
	}

	public Class<?> getModelClass() {
		return Interaction.class;
	}

	public String getModelClassName() {
		return Interaction.class.getName();
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

	public long getInteractionId() {
		return _interactionId;
	}

	public void setInteractionId(long interactionId) {
		_interactionId = interactionId;
	}

	public long getMaleId() {
		return _maleId;
	}

	public void setMaleId(long maleId) {
		_maleId = maleId;
	}

	public long getFemaleId() {
		return _femaleId;
	}

	public void setFemaleId(long femaleId) {
		_femaleId = femaleId;
	}

	public Date getMaleLastViewedFemale() {
		return _maleLastViewedFemale;
	}

	public void setMaleLastViewedFemale(Date maleLastViewedFemale) {
		_maleLastViewedFemale = maleLastViewedFemale;
	}

	public int getMaleViewedCount() {
		return _maleViewedCount;
	}

	public void setMaleViewedCount(int maleViewedCount) {
		_maleViewedCount = maleViewedCount;
	}

	public Date getFemaleLastViewedMale() {
		return _femaleLastViewedMale;
	}

	public void setFemaleLastViewedMale(Date femaleLastViewedMale) {
		_femaleLastViewedMale = femaleLastViewedMale;
	}

	public int getFemaleViewedCount() {
		return _femaleViewedCount;
	}

	public void setFemaleViewedCount(int femaleViewedCount) {
		_femaleViewedCount = femaleViewedCount;
	}

	public boolean getCanViewMalePhoto() {
		return _canViewMalePhoto;
	}

	public boolean isCanViewMalePhoto() {
		return _canViewMalePhoto;
	}

	public void setCanViewMalePhoto(boolean canViewMalePhoto) {
		_canViewMalePhoto = canViewMalePhoto;
	}

	public boolean getCanViewFemalePhoto() {
		return _canViewFemalePhoto;
	}

	public boolean isCanViewFemalePhoto() {
		return _canViewFemalePhoto;
	}

	public void setCanViewFemalePhoto(boolean canViewFemalePhoto) {
		_canViewFemalePhoto = canViewFemalePhoto;
	}

	public boolean getCanViewMaleContact() {
		return _canViewMaleContact;
	}

	public boolean isCanViewMaleContact() {
		return _canViewMaleContact;
	}

	public void setCanViewMaleContact(boolean canViewMaleContact) {
		_canViewMaleContact = canViewMaleContact;
	}

	public boolean getCanViewFemaleContact() {
		return _canViewFemaleContact;
	}

	public boolean isCanViewFemaleContact() {
		return _canViewFemaleContact;
	}

	public void setCanViewFemaleContact(boolean canViewFemaleContact) {
		_canViewFemaleContact = canViewFemaleContact;
	}

	public Date getProposedOn() {
		return _proposedOn;
	}

	public void setProposedOn(Date proposedOn) {
		_proposedOn = proposedOn;
	}

	public boolean getProposedByMale() {
		return _proposedByMale;
	}

	public boolean isProposedByMale() {
		return _proposedByMale;
	}

	public void setProposedByMale(boolean proposedByMale) {
		_proposedByMale = proposedByMale;
	}

	public boolean getProposalNotSeen() {
		return _proposalNotSeen;
	}

	public boolean isProposalNotSeen() {
		return _proposalNotSeen;
	}

	public void setProposalNotSeen(boolean proposalNotSeen) {
		_proposalNotSeen = proposalNotSeen;
	}

	public Date getRespondedOn() {
		return _respondedOn;
	}

	public void setRespondedOn(Date respondedOn) {
		_respondedOn = respondedOn;
	}

	public int getResponseType() {
		return _responseType;
	}

	public void setResponseType(int responseType) {
		_responseType = responseType;
	}

	public boolean getResponseNotSeen() {
		return _responseNotSeen;
	}

	public boolean isResponseNotSeen() {
		return _responseNotSeen;
	}

	public void setResponseNotSeen(boolean responseNotSeen) {
		_responseNotSeen = responseNotSeen;
	}

	public Date getShortlistedByMale() {
		return _shortlistedByMale;
	}

	public void setShortlistedByMale(Date shortlistedByMale) {
		_shortlistedByMale = shortlistedByMale;
	}

	public Date getShortlistedByFemale() {
		return _shortlistedByFemale;
	}

	public void setShortlistedByFemale(Date shortlistedByFemale) {
		_shortlistedByFemale = shortlistedByFemale;
	}

	public Date getBlockedByMale() {
		return _blockedByMale;
	}

	public void setBlockedByMale(Date blockedByMale) {
		_blockedByMale = blockedByMale;
	}

	public Date getBlockedByFemale() {
		return _blockedByFemale;
	}

	public void setBlockedByFemale(Date blockedByFemale) {
		_blockedByFemale = blockedByFemale;
	}

	public int getCapturedInMaleReport() {
		return _capturedInMaleReport;
	}

	public void setCapturedInMaleReport(int capturedInMaleReport) {
		_capturedInMaleReport = capturedInMaleReport;
	}

	public int getCapturedInFemaleReport() {
		return _capturedInFemaleReport;
	}

	public void setCapturedInFemaleReport(int capturedInFemaleReport) {
		_capturedInFemaleReport = capturedInFemaleReport;
	}

	public BaseModel<?> getInteractionRemoteModel() {
		return _interactionRemoteModel;
	}

	public void setInteractionRemoteModel(BaseModel<?> interactionRemoteModel) {
		_interactionRemoteModel = interactionRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			InteractionLocalServiceUtil.addInteraction(this);
		}
		else {
			InteractionLocalServiceUtil.updateInteraction(this);
		}
	}

	@Override
	public Interaction toEscapedModel() {
		return (Interaction)Proxy.newProxyInstance(Interaction.class.getClassLoader(),
			new Class[] { Interaction.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		InteractionClp clone = new InteractionClp();

		clone.setInteractionId(getInteractionId());
		clone.setMaleId(getMaleId());
		clone.setFemaleId(getFemaleId());
		clone.setMaleLastViewedFemale(getMaleLastViewedFemale());
		clone.setMaleViewedCount(getMaleViewedCount());
		clone.setFemaleLastViewedMale(getFemaleLastViewedMale());
		clone.setFemaleViewedCount(getFemaleViewedCount());
		clone.setCanViewMalePhoto(getCanViewMalePhoto());
		clone.setCanViewFemalePhoto(getCanViewFemalePhoto());
		clone.setCanViewMaleContact(getCanViewMaleContact());
		clone.setCanViewFemaleContact(getCanViewFemaleContact());
		clone.setProposedOn(getProposedOn());
		clone.setProposedByMale(getProposedByMale());
		clone.setProposalNotSeen(getProposalNotSeen());
		clone.setRespondedOn(getRespondedOn());
		clone.setResponseType(getResponseType());
		clone.setResponseNotSeen(getResponseNotSeen());
		clone.setShortlistedByMale(getShortlistedByMale());
		clone.setShortlistedByFemale(getShortlistedByFemale());
		clone.setBlockedByMale(getBlockedByMale());
		clone.setBlockedByFemale(getBlockedByFemale());
		clone.setCapturedInMaleReport(getCapturedInMaleReport());
		clone.setCapturedInFemaleReport(getCapturedInFemaleReport());

		return clone;
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

		InteractionClp interaction = null;

		try {
			interaction = (InteractionClp)obj;
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
	private BaseModel<?> _interactionRemoteModel;
}