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

import com.matrimony.model.Religion;

import java.util.List;

/**
 * The persistence utility for the religion service. This utility wraps {@link ReligionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author matrimony
 * @see ReligionPersistence
 * @see ReligionPersistenceImpl
 * @generated
 */
public class ReligionUtil {
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
	public static void clearCache(Religion religion) {
		getPersistence().clearCache(religion);
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
	public static List<Religion> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Religion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Religion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Religion update(Religion religion, boolean merge)
		throws SystemException {
		return getPersistence().update(religion, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Religion update(Religion religion, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(religion, merge, serviceContext);
	}

	/**
	* Caches the religion in the entity cache if it is enabled.
	*
	* @param religion the religion
	*/
	public static void cacheResult(com.matrimony.model.Religion religion) {
		getPersistence().cacheResult(religion);
	}

	/**
	* Caches the religions in the entity cache if it is enabled.
	*
	* @param religions the religions
	*/
	public static void cacheResult(
		java.util.List<com.matrimony.model.Religion> religions) {
		getPersistence().cacheResult(religions);
	}

	/**
	* Creates a new religion with the primary key. Does not add the religion to the database.
	*
	* @param religionId the primary key for the new religion
	* @return the new religion
	*/
	public static com.matrimony.model.Religion create(long religionId) {
		return getPersistence().create(religionId);
	}

	/**
	* Removes the religion with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param religionId the primary key of the religion
	* @return the religion that was removed
	* @throws com.matrimony.NoSuchReligionException if a religion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Religion remove(long religionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchReligionException {
		return getPersistence().remove(religionId);
	}

	public static com.matrimony.model.Religion updateImpl(
		com.matrimony.model.Religion religion, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(religion, merge);
	}

	/**
	* Returns the religion with the primary key or throws a {@link com.matrimony.NoSuchReligionException} if it could not be found.
	*
	* @param religionId the primary key of the religion
	* @return the religion
	* @throws com.matrimony.NoSuchReligionException if a religion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Religion findByPrimaryKey(long religionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchReligionException {
		return getPersistence().findByPrimaryKey(religionId);
	}

	/**
	* Returns the religion with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param religionId the primary key of the religion
	* @return the religion, or <code>null</code> if a religion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Religion fetchByPrimaryKey(
		long religionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(religionId);
	}

	/**
	* Returns all the religions.
	*
	* @return the religions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.Religion> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the religions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of religions
	* @param end the upper bound of the range of religions (not inclusive)
	* @return the range of religions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.Religion> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the religions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of religions
	* @param end the upper bound of the range of religions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of religions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.Religion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the religions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of religions.
	*
	* @return the number of religions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ReligionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ReligionPersistence)PortletBeanLocatorUtil.locate(com.matrimony.service.ClpSerializer.getServletContextName(),
					ReligionPersistence.class.getName());

			ReferenceRegistry.registerReference(ReligionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ReligionPersistence persistence) {
	}

	private static ReligionPersistence _persistence;
}