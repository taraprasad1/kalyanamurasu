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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Interaction}.
 * </p>
 *
 * @author    matrimony
 * @see       Interaction
 * @generated
 */
public class InteractionWrapper implements Interaction,
	ModelWrapper<Interaction> {
	public InteractionWrapper(Interaction interaction) {
		_interaction = interaction;
	}

	public Class<?> getModelClass() {
		return Interaction.class;
	}

	public String getModelClassName() {
		return Interaction.class.getName();
	}

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

	/**
	* Returns the primary key of this interaction.
	*
	* @return the primary key of this interaction
	*/
	public long getPrimaryKey() {
		return _interaction.getPrimaryKey();
	}

	/**
	* Sets the primary key of this interaction.
	*
	* @param primaryKey the primary key of this interaction
	*/
	public void setPrimaryKey(long primaryKey) {
		_interaction.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the interaction ID of this interaction.
	*
	* @return the interaction ID of this interaction
	*/
	public long getInteractionId() {
		return _interaction.getInteractionId();
	}

	/**
	* Sets the interaction ID of this interaction.
	*
	* @param interactionId the interaction ID of this interaction
	*/
	public void setInteractionId(long interactionId) {
		_interaction.setInteractionId(interactionId);
	}

	/**
	* Returns the male ID of this interaction.
	*
	* @return the male ID of this interaction
	*/
	public long getMaleId() {
		return _interaction.getMaleId();
	}

	/**
	* Sets the male ID of this interaction.
	*
	* @param maleId the male ID of this interaction
	*/
	public void setMaleId(long maleId) {
		_interaction.setMaleId(maleId);
	}

	/**
	* Returns the female ID of this interaction.
	*
	* @return the female ID of this interaction
	*/
	public long getFemaleId() {
		return _interaction.getFemaleId();
	}

	/**
	* Sets the female ID of this interaction.
	*
	* @param femaleId the female ID of this interaction
	*/
	public void setFemaleId(long femaleId) {
		_interaction.setFemaleId(femaleId);
	}

	/**
	* Returns the male last viewed female of this interaction.
	*
	* @return the male last viewed female of this interaction
	*/
	public java.util.Date getMaleLastViewedFemale() {
		return _interaction.getMaleLastViewedFemale();
	}

	/**
	* Sets the male last viewed female of this interaction.
	*
	* @param maleLastViewedFemale the male last viewed female of this interaction
	*/
	public void setMaleLastViewedFemale(java.util.Date maleLastViewedFemale) {
		_interaction.setMaleLastViewedFemale(maleLastViewedFemale);
	}

	/**
	* Returns the male viewed count of this interaction.
	*
	* @return the male viewed count of this interaction
	*/
	public int getMaleViewedCount() {
		return _interaction.getMaleViewedCount();
	}

	/**
	* Sets the male viewed count of this interaction.
	*
	* @param maleViewedCount the male viewed count of this interaction
	*/
	public void setMaleViewedCount(int maleViewedCount) {
		_interaction.setMaleViewedCount(maleViewedCount);
	}

	/**
	* Returns the female last viewed male of this interaction.
	*
	* @return the female last viewed male of this interaction
	*/
	public java.util.Date getFemaleLastViewedMale() {
		return _interaction.getFemaleLastViewedMale();
	}

	/**
	* Sets the female last viewed male of this interaction.
	*
	* @param femaleLastViewedMale the female last viewed male of this interaction
	*/
	public void setFemaleLastViewedMale(java.util.Date femaleLastViewedMale) {
		_interaction.setFemaleLastViewedMale(femaleLastViewedMale);
	}

	/**
	* Returns the female viewed count of this interaction.
	*
	* @return the female viewed count of this interaction
	*/
	public int getFemaleViewedCount() {
		return _interaction.getFemaleViewedCount();
	}

	/**
	* Sets the female viewed count of this interaction.
	*
	* @param femaleViewedCount the female viewed count of this interaction
	*/
	public void setFemaleViewedCount(int femaleViewedCount) {
		_interaction.setFemaleViewedCount(femaleViewedCount);
	}

	/**
	* Returns the can view male photo of this interaction.
	*
	* @return the can view male photo of this interaction
	*/
	public boolean getCanViewMalePhoto() {
		return _interaction.getCanViewMalePhoto();
	}

	/**
	* Returns <code>true</code> if this interaction is can view male photo.
	*
	* @return <code>true</code> if this interaction is can view male photo; <code>false</code> otherwise
	*/
	public boolean isCanViewMalePhoto() {
		return _interaction.isCanViewMalePhoto();
	}

	/**
	* Sets whether this interaction is can view male photo.
	*
	* @param canViewMalePhoto the can view male photo of this interaction
	*/
	public void setCanViewMalePhoto(boolean canViewMalePhoto) {
		_interaction.setCanViewMalePhoto(canViewMalePhoto);
	}

	/**
	* Returns the can view female photo of this interaction.
	*
	* @return the can view female photo of this interaction
	*/
	public boolean getCanViewFemalePhoto() {
		return _interaction.getCanViewFemalePhoto();
	}

	/**
	* Returns <code>true</code> if this interaction is can view female photo.
	*
	* @return <code>true</code> if this interaction is can view female photo; <code>false</code> otherwise
	*/
	public boolean isCanViewFemalePhoto() {
		return _interaction.isCanViewFemalePhoto();
	}

	/**
	* Sets whether this interaction is can view female photo.
	*
	* @param canViewFemalePhoto the can view female photo of this interaction
	*/
	public void setCanViewFemalePhoto(boolean canViewFemalePhoto) {
		_interaction.setCanViewFemalePhoto(canViewFemalePhoto);
	}

	/**
	* Returns the can view male contact of this interaction.
	*
	* @return the can view male contact of this interaction
	*/
	public boolean getCanViewMaleContact() {
		return _interaction.getCanViewMaleContact();
	}

	/**
	* Returns <code>true</code> if this interaction is can view male contact.
	*
	* @return <code>true</code> if this interaction is can view male contact; <code>false</code> otherwise
	*/
	public boolean isCanViewMaleContact() {
		return _interaction.isCanViewMaleContact();
	}

	/**
	* Sets whether this interaction is can view male contact.
	*
	* @param canViewMaleContact the can view male contact of this interaction
	*/
	public void setCanViewMaleContact(boolean canViewMaleContact) {
		_interaction.setCanViewMaleContact(canViewMaleContact);
	}

	/**
	* Returns the can view female contact of this interaction.
	*
	* @return the can view female contact of this interaction
	*/
	public boolean getCanViewFemaleContact() {
		return _interaction.getCanViewFemaleContact();
	}

	/**
	* Returns <code>true</code> if this interaction is can view female contact.
	*
	* @return <code>true</code> if this interaction is can view female contact; <code>false</code> otherwise
	*/
	public boolean isCanViewFemaleContact() {
		return _interaction.isCanViewFemaleContact();
	}

	/**
	* Sets whether this interaction is can view female contact.
	*
	* @param canViewFemaleContact the can view female contact of this interaction
	*/
	public void setCanViewFemaleContact(boolean canViewFemaleContact) {
		_interaction.setCanViewFemaleContact(canViewFemaleContact);
	}

	/**
	* Returns the proposed on of this interaction.
	*
	* @return the proposed on of this interaction
	*/
	public java.util.Date getProposedOn() {
		return _interaction.getProposedOn();
	}

	/**
	* Sets the proposed on of this interaction.
	*
	* @param proposedOn the proposed on of this interaction
	*/
	public void setProposedOn(java.util.Date proposedOn) {
		_interaction.setProposedOn(proposedOn);
	}

	/**
	* Returns the proposed by male of this interaction.
	*
	* @return the proposed by male of this interaction
	*/
	public boolean getProposedByMale() {
		return _interaction.getProposedByMale();
	}

	/**
	* Returns <code>true</code> if this interaction is proposed by male.
	*
	* @return <code>true</code> if this interaction is proposed by male; <code>false</code> otherwise
	*/
	public boolean isProposedByMale() {
		return _interaction.isProposedByMale();
	}

	/**
	* Sets whether this interaction is proposed by male.
	*
	* @param proposedByMale the proposed by male of this interaction
	*/
	public void setProposedByMale(boolean proposedByMale) {
		_interaction.setProposedByMale(proposedByMale);
	}

	/**
	* Returns the proposal not seen of this interaction.
	*
	* @return the proposal not seen of this interaction
	*/
	public boolean getProposalNotSeen() {
		return _interaction.getProposalNotSeen();
	}

	/**
	* Returns <code>true</code> if this interaction is proposal not seen.
	*
	* @return <code>true</code> if this interaction is proposal not seen; <code>false</code> otherwise
	*/
	public boolean isProposalNotSeen() {
		return _interaction.isProposalNotSeen();
	}

	/**
	* Sets whether this interaction is proposal not seen.
	*
	* @param proposalNotSeen the proposal not seen of this interaction
	*/
	public void setProposalNotSeen(boolean proposalNotSeen) {
		_interaction.setProposalNotSeen(proposalNotSeen);
	}

	/**
	* Returns the responded on of this interaction.
	*
	* @return the responded on of this interaction
	*/
	public java.util.Date getRespondedOn() {
		return _interaction.getRespondedOn();
	}

	/**
	* Sets the responded on of this interaction.
	*
	* @param respondedOn the responded on of this interaction
	*/
	public void setRespondedOn(java.util.Date respondedOn) {
		_interaction.setRespondedOn(respondedOn);
	}

	/**
	* Returns the response type of this interaction.
	*
	* @return the response type of this interaction
	*/
	public int getResponseType() {
		return _interaction.getResponseType();
	}

	/**
	* Sets the response type of this interaction.
	*
	* @param responseType the response type of this interaction
	*/
	public void setResponseType(int responseType) {
		_interaction.setResponseType(responseType);
	}

	/**
	* Returns the response not seen of this interaction.
	*
	* @return the response not seen of this interaction
	*/
	public boolean getResponseNotSeen() {
		return _interaction.getResponseNotSeen();
	}

	/**
	* Returns <code>true</code> if this interaction is response not seen.
	*
	* @return <code>true</code> if this interaction is response not seen; <code>false</code> otherwise
	*/
	public boolean isResponseNotSeen() {
		return _interaction.isResponseNotSeen();
	}

	/**
	* Sets whether this interaction is response not seen.
	*
	* @param responseNotSeen the response not seen of this interaction
	*/
	public void setResponseNotSeen(boolean responseNotSeen) {
		_interaction.setResponseNotSeen(responseNotSeen);
	}

	/**
	* Returns the shortlisted by male of this interaction.
	*
	* @return the shortlisted by male of this interaction
	*/
	public java.util.Date getShortlistedByMale() {
		return _interaction.getShortlistedByMale();
	}

	/**
	* Sets the shortlisted by male of this interaction.
	*
	* @param shortlistedByMale the shortlisted by male of this interaction
	*/
	public void setShortlistedByMale(java.util.Date shortlistedByMale) {
		_interaction.setShortlistedByMale(shortlistedByMale);
	}

	/**
	* Returns the shortlisted by female of this interaction.
	*
	* @return the shortlisted by female of this interaction
	*/
	public java.util.Date getShortlistedByFemale() {
		return _interaction.getShortlistedByFemale();
	}

	/**
	* Sets the shortlisted by female of this interaction.
	*
	* @param shortlistedByFemale the shortlisted by female of this interaction
	*/
	public void setShortlistedByFemale(java.util.Date shortlistedByFemale) {
		_interaction.setShortlistedByFemale(shortlistedByFemale);
	}

	/**
	* Returns the blocked by male of this interaction.
	*
	* @return the blocked by male of this interaction
	*/
	public java.util.Date getBlockedByMale() {
		return _interaction.getBlockedByMale();
	}

	/**
	* Sets the blocked by male of this interaction.
	*
	* @param blockedByMale the blocked by male of this interaction
	*/
	public void setBlockedByMale(java.util.Date blockedByMale) {
		_interaction.setBlockedByMale(blockedByMale);
	}

	/**
	* Returns the blocked by female of this interaction.
	*
	* @return the blocked by female of this interaction
	*/
	public java.util.Date getBlockedByFemale() {
		return _interaction.getBlockedByFemale();
	}

	/**
	* Sets the blocked by female of this interaction.
	*
	* @param blockedByFemale the blocked by female of this interaction
	*/
	public void setBlockedByFemale(java.util.Date blockedByFemale) {
		_interaction.setBlockedByFemale(blockedByFemale);
	}

	/**
	* Returns the captured in male report of this interaction.
	*
	* @return the captured in male report of this interaction
	*/
	public int getCapturedInMaleReport() {
		return _interaction.getCapturedInMaleReport();
	}

	/**
	* Sets the captured in male report of this interaction.
	*
	* @param capturedInMaleReport the captured in male report of this interaction
	*/
	public void setCapturedInMaleReport(int capturedInMaleReport) {
		_interaction.setCapturedInMaleReport(capturedInMaleReport);
	}

	/**
	* Returns the captured in female report of this interaction.
	*
	* @return the captured in female report of this interaction
	*/
	public int getCapturedInFemaleReport() {
		return _interaction.getCapturedInFemaleReport();
	}

	/**
	* Sets the captured in female report of this interaction.
	*
	* @param capturedInFemaleReport the captured in female report of this interaction
	*/
	public void setCapturedInFemaleReport(int capturedInFemaleReport) {
		_interaction.setCapturedInFemaleReport(capturedInFemaleReport);
	}

	public boolean isNew() {
		return _interaction.isNew();
	}

	public void setNew(boolean n) {
		_interaction.setNew(n);
	}

	public boolean isCachedModel() {
		return _interaction.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_interaction.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _interaction.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _interaction.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_interaction.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _interaction.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_interaction.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new InteractionWrapper((Interaction)_interaction.clone());
	}

	public int compareTo(Interaction interaction) {
		return _interaction.compareTo(interaction);
	}

	@Override
	public int hashCode() {
		return _interaction.hashCode();
	}

	public com.liferay.portal.model.CacheModel<Interaction> toCacheModel() {
		return _interaction.toCacheModel();
	}

	public Interaction toEscapedModel() {
		return new InteractionWrapper(_interaction.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _interaction.toString();
	}

	public java.lang.String toXmlString() {
		return _interaction.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_interaction.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Interaction getWrappedInteraction() {
		return _interaction;
	}

	public Interaction getWrappedModel() {
		return _interaction;
	}

	public void resetOriginalValues() {
		_interaction.resetOriginalValues();
	}

	private Interaction _interaction;
}