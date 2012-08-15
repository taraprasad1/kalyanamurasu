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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.matrimony.service.http.InteractionServiceSoap}.
 *
 * @author    matrimony
 * @see       com.matrimony.service.http.InteractionServiceSoap
 * @generated
 */
public class InteractionSoap implements Serializable {
	public static InteractionSoap toSoapModel(Interaction model) {
		InteractionSoap soapModel = new InteractionSoap();

		soapModel.setInteractionId(model.getInteractionId());
		soapModel.setMaleId(model.getMaleId());
		soapModel.setFemaleId(model.getFemaleId());
		soapModel.setMaleLastViewedFemale(model.getMaleLastViewedFemale());
		soapModel.setMaleViewedCount(model.getMaleViewedCount());
		soapModel.setFemaleLastViewedMale(model.getFemaleLastViewedMale());
		soapModel.setFemaleViewedCount(model.getFemaleViewedCount());
		soapModel.setCanViewMalePhoto(model.getCanViewMalePhoto());
		soapModel.setCanViewFemalePhoto(model.getCanViewFemalePhoto());
		soapModel.setCanViewMaleContact(model.getCanViewMaleContact());
		soapModel.setCanViewFemaleContact(model.getCanViewFemaleContact());
		soapModel.setProposedOn(model.getProposedOn());
		soapModel.setProposedByMale(model.getProposedByMale());
		soapModel.setProposalNotSeen(model.getProposalNotSeen());
		soapModel.setRespondedOn(model.getRespondedOn());
		soapModel.setResponseType(model.getResponseType());
		soapModel.setResponseNotSeen(model.getResponseNotSeen());
		soapModel.setShortlistedByMale(model.getShortlistedByMale());
		soapModel.setShortlistedByFemale(model.getShortlistedByFemale());
		soapModel.setBlockedByMale(model.getBlockedByMale());
		soapModel.setBlockedByFemale(model.getBlockedByFemale());
		soapModel.setCapturedInMaleReport(model.getCapturedInMaleReport());
		soapModel.setCapturedInFemaleReport(model.getCapturedInFemaleReport());

		return soapModel;
	}

	public static InteractionSoap[] toSoapModels(Interaction[] models) {
		InteractionSoap[] soapModels = new InteractionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static InteractionSoap[][] toSoapModels(Interaction[][] models) {
		InteractionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new InteractionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new InteractionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static InteractionSoap[] toSoapModels(List<Interaction> models) {
		List<InteractionSoap> soapModels = new ArrayList<InteractionSoap>(models.size());

		for (Interaction model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new InteractionSoap[soapModels.size()]);
	}

	public InteractionSoap() {
	}

	public long getPrimaryKey() {
		return _interactionId;
	}

	public void setPrimaryKey(long pk) {
		setInteractionId(pk);
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
}