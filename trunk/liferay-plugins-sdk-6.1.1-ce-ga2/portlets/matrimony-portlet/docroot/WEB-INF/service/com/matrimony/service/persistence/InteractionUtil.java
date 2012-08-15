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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.matrimony.model.Interaction;

import java.util.List;

/**
 * The persistence utility for the interaction service. This utility wraps {@link InteractionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author matrimony
 * @see InteractionPersistence
 * @see InteractionPersistenceImpl
 * @generated
 */
public class InteractionUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Interaction interaction) {
		getPersistence().clearCache(interaction);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Interaction> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Interaction> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Interaction> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Interaction update(Interaction interaction, boolean merge)
		throws SystemException {
		return getPersistence().update(interaction, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Interaction update(Interaction interaction, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(interaction, merge, serviceContext);
	}

	/**
	* Caches the interaction in the entity cache if it is enabled.
	*
	* @param interaction the interaction
	*/
	public static void cacheResult(com.matrimony.model.Interaction interaction) {
		getPersistence().cacheResult(interaction);
	}

	/**
	* Caches the interactions in the entity cache if it is enabled.
	*
	* @param interactions the interactions
	*/
	public static void cacheResult(
		java.util.List<com.matrimony.model.Interaction> interactions) {
		getPersistence().cacheResult(interactions);
	}

	/**
	* Creates a new interaction with the primary key. Does not add the interaction to the database.
	*
	* @param interactionId the primary key for the new interaction
	* @return the new interaction
	*/
	public static com.matrimony.model.Interaction create(long interactionId) {
		return getPersistence().create(interactionId);
	}

	/**
	* Removes the interaction with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param interactionId the primary key of the interaction
	* @return the interaction that was removed
	* @throws com.matrimony.NoSuchInteractionException if a interaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Interaction remove(long interactionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchInteractionException {
		return getPersistence().remove(interactionId);
	}

	public static com.matrimony.model.Interaction updateImpl(
		com.matrimony.model.Interaction interaction, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(interaction, merge);
	}

	/**
	* Returns the interaction with the primary key or throws a {@link com.matrimony.NoSuchInteractionException} if it could not be found.
	*
	* @param interactionId the primary key of the interaction
	* @return the interaction
	* @throws com.matrimony.NoSuchInteractionException if a interaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Interaction findByPrimaryKey(
		long interactionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchInteractionException {
		return getPersistence().findByPrimaryKey(interactionId);
	}

	/**
	* Returns the interaction with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param interactionId the primary key of the interaction
	* @return the interaction, or <code>null</code> if a interaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Interaction fetchByPrimaryKey(
		long interactionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(interactionId);
	}

	/**
	* Returns all the interactions.
	*
	* @return the interactions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.Interaction> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.matrimony.model.Interaction> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.matrimony.model.Interaction> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the interactions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of interactions.
	*
	* @return the number of interactions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static InteractionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (InteractionPersistence)PortletBeanLocatorUtil.locate(com.matrimony.service.ClpSerializer.getServletContextName(),
					InteractionPersistence.class.getName());

			ReferenceRegistry.registerReference(InteractionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(InteractionPersistence persistence) {
	}

	private static InteractionPersistence _persistence;
}