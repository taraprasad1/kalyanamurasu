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
import com.liferay.portal.model.CacheModel;

import com.matrimony.model.Interaction;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Interaction in entity cache.
 *
 * @author matrimony
 * @see Interaction
 * @generated
 */
public class InteractionCacheModel implements CacheModel<Interaction>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{interactionId=");
		sb.append(interactionId);
		sb.append(", maleId=");
		sb.append(maleId);
		sb.append(", femaleId=");
		sb.append(femaleId);
		sb.append(", maleLastViewedFemale=");
		sb.append(maleLastViewedFemale);
		sb.append(", maleViewedCount=");
		sb.append(maleViewedCount);
		sb.append(", femaleLastViewedMale=");
		sb.append(femaleLastViewedMale);
		sb.append(", femaleViewedCount=");
		sb.append(femaleViewedCount);
		sb.append(", canViewMalePhoto=");
		sb.append(canViewMalePhoto);
		sb.append(", canViewFemalePhoto=");
		sb.append(canViewFemalePhoto);
		sb.append(", canViewMaleContact=");
		sb.append(canViewMaleContact);
		sb.append(", canViewFemaleContact=");
		sb.append(canViewFemaleContact);
		sb.append(", proposedOn=");
		sb.append(proposedOn);
		sb.append(", proposedByMale=");
		sb.append(proposedByMale);
		sb.append(", proposalNotSeen=");
		sb.append(proposalNotSeen);
		sb.append(", respondedOn=");
		sb.append(respondedOn);
		sb.append(", responseType=");
		sb.append(responseType);
		sb.append(", responseNotSeen=");
		sb.append(responseNotSeen);
		sb.append(", shortlistedByMale=");
		sb.append(shortlistedByMale);
		sb.append(", shortlistedByFemale=");
		sb.append(shortlistedByFemale);
		sb.append(", blockedByMale=");
		sb.append(blockedByMale);
		sb.append(", blockedByFemale=");
		sb.append(blockedByFemale);
		sb.append(", capturedInMaleReport=");
		sb.append(capturedInMaleReport);
		sb.append(", capturedInFemaleReport=");
		sb.append(capturedInFemaleReport);
		sb.append("}");

		return sb.toString();
	}

	public Interaction toEntityModel() {
		InteractionImpl interactionImpl = new InteractionImpl();

		interactionImpl.setInteractionId(interactionId);
		interactionImpl.setMaleId(maleId);
		interactionImpl.setFemaleId(femaleId);

		if (maleLastViewedFemale == Long.MIN_VALUE) {
			interactionImpl.setMaleLastViewedFemale(null);
		}
		else {
			interactionImpl.setMaleLastViewedFemale(new Date(
					maleLastViewedFemale));
		}

		interactionImpl.setMaleViewedCount(maleViewedCount);

		if (femaleLastViewedMale == Long.MIN_VALUE) {
			interactionImpl.setFemaleLastViewedMale(null);
		}
		else {
			interactionImpl.setFemaleLastViewedMale(new Date(
					femaleLastViewedMale));
		}

		interactionImpl.setFemaleViewedCount(femaleViewedCount);
		interactionImpl.setCanViewMalePhoto(canViewMalePhoto);
		interactionImpl.setCanViewFemalePhoto(canViewFemalePhoto);
		interactionImpl.setCanViewMaleContact(canViewMaleContact);
		interactionImpl.setCanViewFemaleContact(canViewFemaleContact);

		if (proposedOn == Long.MIN_VALUE) {
			interactionImpl.setProposedOn(null);
		}
		else {
			interactionImpl.setProposedOn(new Date(proposedOn));
		}

		interactionImpl.setProposedByMale(proposedByMale);
		interactionImpl.setProposalNotSeen(proposalNotSeen);

		if (respondedOn == Long.MIN_VALUE) {
			interactionImpl.setRespondedOn(null);
		}
		else {
			interactionImpl.setRespondedOn(new Date(respondedOn));
		}

		interactionImpl.setResponseType(responseType);
		interactionImpl.setResponseNotSeen(responseNotSeen);

		if (shortlistedByMale == Long.MIN_VALUE) {
			interactionImpl.setShortlistedByMale(null);
		}
		else {
			interactionImpl.setShortlistedByMale(new Date(shortlistedByMale));
		}

		if (shortlistedByFemale == Long.MIN_VALUE) {
			interactionImpl.setShortlistedByFemale(null);
		}
		else {
			interactionImpl.setShortlistedByFemale(new Date(shortlistedByFemale));
		}

		if (blockedByMale == Long.MIN_VALUE) {
			interactionImpl.setBlockedByMale(null);
		}
		else {
			interactionImpl.setBlockedByMale(new Date(blockedByMale));
		}

		if (blockedByFemale == Long.MIN_VALUE) {
			interactionImpl.setBlockedByFemale(null);
		}
		else {
			interactionImpl.setBlockedByFemale(new Date(blockedByFemale));
		}

		interactionImpl.setCapturedInMaleReport(capturedInMaleReport);
		interactionImpl.setCapturedInFemaleReport(capturedInFemaleReport);

		interactionImpl.resetOriginalValues();

		return interactionImpl;
	}

	public long interactionId;
	public long maleId;
	public long femaleId;
	public long maleLastViewedFemale;
	public int maleViewedCount;
	public long femaleLastViewedMale;
	public int femaleViewedCount;
	public boolean canViewMalePhoto;
	public boolean canViewFemalePhoto;
	public boolean canViewMaleContact;
	public boolean canViewFemaleContact;
	public long proposedOn;
	public boolean proposedByMale;
	public boolean proposalNotSeen;
	public long respondedOn;
	public int responseType;
	public boolean responseNotSeen;
	public long shortlistedByMale;
	public long shortlistedByFemale;
	public long blockedByMale;
	public long blockedByFemale;
	public int capturedInMaleReport;
	public int capturedInFemaleReport;
}