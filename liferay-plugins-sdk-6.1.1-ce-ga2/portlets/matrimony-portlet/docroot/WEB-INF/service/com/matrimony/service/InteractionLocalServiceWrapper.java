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

package com.matrimony.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link InteractionLocalService}.
 * </p>
 *
 * @author    matrimony
 * @see       InteractionLocalService
 * @generated
 */
public class InteractionLocalServiceWrapper implements InteractionLocalService,
	ServiceWrapper<InteractionLocalService> {
	public InteractionLocalServiceWrapper(
		InteractionLocalService interactionLocalService) {
		_interactionLocalService = interactionLocalService;
	}

	/**
	* Adds the interaction to the database. Also notifies the appropriate model listeners.
	*
	* @param interaction the interaction
	* @return the interaction that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Interaction addInteraction(
		com.matrimony.model.Interaction interaction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _interactionLocalService.addInteraction(interaction);
	}

	/**
	* Creates a new interaction with the primary key. Does not add the interaction to the database.
	*
	* @param interactionId the primary key for the new interaction
	* @return the new interaction
	*/
	public com.matrimony.model.Interaction createInteraction(long interactionId) {
		return _interactionLocalService.createInteraction(interactionId);
	}

	/**
	* Deletes the interaction with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param interactionId the primary key of the interaction
	* @return the interaction that was removed
	* @throws PortalException if a interaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Interaction deleteInteraction(long interactionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _interactionLocalService.deleteInteraction(interactionId);
	}

	/**
	* Deletes the interaction from the database. Also notifies the appropriate model listeners.
	*
	* @param interaction the interaction
	* @return the interaction that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Interaction deleteInteraction(
		com.matrimony.model.Interaction interaction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _interactionLocalService.deleteInteraction(interaction);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _interactionLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _interactionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _interactionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _interactionLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _interactionLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.matrimony.model.Interaction fetchInteraction(long interactionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _interactionLocalService.fetchInteraction(interactionId);
	}

	/**
	* Returns the interaction with the primary key.
	*
	* @param interactionId the primary key of the interaction
	* @return the interaction
	* @throws PortalException if a interaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Interaction getInteraction(long interactionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _interactionLocalService.getInteraction(interactionId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _interactionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the interactions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of interactions
	* @param end the upper bound of the range of interactions (not inclusive)
	* @return the range of interactions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.Interaction> getInteractions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _interactionLocalService.getInteractions(start, end);
	}

	/**
	* Returns the number of interactions.
	*
	* @return the number of interactions
	* @throws SystemException if a system exception occurred
	*/
	public int getInteractionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _interactionLocalService.getInteractionsCount();
	}

	/**
	* Updates the interaction in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param interaction the interaction
	* @return the interaction that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Interaction updateInteraction(
		com.matrimony.model.Interaction interaction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _interactionLocalService.updateInteraction(interaction);
	}

	/**
	* Updates the interaction in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param interaction the interaction
	* @param merge whether to merge the interaction with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the interaction that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Interaction updateInteraction(
		com.matrimony.model.Interaction interaction, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _interactionLocalService.updateInteraction(interaction, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _interactionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_interactionLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _interactionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public InteractionLocalService getWrappedInteractionLocalService() {
		return _interactionLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedInteractionLocalService(
		InteractionLocalService interactionLocalService) {
		_interactionLocalService = interactionLocalService;
	}

	public InteractionLocalService getWrappedService() {
		return _interactionLocalService;
	}

	public void setWrappedService(
		InteractionLocalService interactionLocalService) {
		_interactionLocalService = interactionLocalService;
	}

	private InteractionLocalService _interactionLocalService;
}