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

package com.matrimony.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.matrimony.model.Interaction;

/**
 * The persistence interface for the interaction service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author matrimony
 * @see InteractionPersistenceImpl
 * @see InteractionUtil
 * @generated
 */
public interface InteractionPersistence extends BasePersistence<Interaction> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link InteractionUtil} to access the interaction persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the interaction in the entity cache if it is enabled.
	*
	* @param interaction the interaction
	*/
	public void cacheResult(com.matrimony.model.Interaction interaction);

	/**
	* Caches the interactions in the entity cache if it is enabled.
	*
	* @param interactions the interactions
	*/
	public void cacheResult(
		java.util.List<com.matrimony.model.Interaction> interactions);

	/**
	* Creates a new interaction with the primary key. Does not add the interaction to the database.
	*
	* @param interactionId the primary key for the new interaction
	* @return the new interaction
	*/
	public com.matrimony.model.Interaction create(long interactionId);

	/**
	* Removes the interaction with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param interactionId the primary key of the interaction
	* @return the interaction that was removed
	* @throws com.matrimony.NoSuchInteractionException if a interaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Interaction remove(long interactionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchInteractionException;

	public com.matrimony.model.Interaction updateImpl(
		com.matrimony.model.Interaction interaction, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the interaction with the primary key or throws a {@link com.matrimony.NoSuchInteractionException} if it could not be found.
	*
	* @param interactionId the primary key of the interaction
	* @return the interaction
	* @throws com.matrimony.NoSuchInteractionException if a interaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Interaction findByPrimaryKey(long interactionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchInteractionException;

	/**
	* Returns the interaction with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param interactionId the primary key of the interaction
	* @return the interaction, or <code>null</code> if a interaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Interaction fetchByPrimaryKey(long interactionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the interactions.
	*
	* @return the interactions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.Interaction> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.matrimony.model.Interaction> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the interactions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of interactions
	* @param end the upper bound of the range of interactions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of interactions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.Interaction> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the interactions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of interactions.
	*
	* @return the number of interactions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}