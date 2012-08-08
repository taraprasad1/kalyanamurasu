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

package com.vijayan.profile.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.vijayan.profile.model.Key;

import java.util.List;

/**
 * The persistence utility for the key service. This utility wraps {@link KeyPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ravi
 * @see KeyPersistence
 * @see KeyPersistenceImpl
 * @generated
 */
public class KeyUtil {
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
	public static void clearCache(Key key) {
		getPersistence().clearCache(key);
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
	public static List<Key> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Key> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Key> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Key update(Key key, boolean merge) throws SystemException {
		return getPersistence().update(key, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Key update(Key key, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(key, merge, serviceContext);
	}

	/**
	* Caches the key in the entity cache if it is enabled.
	*
	* @param key the key
	*/
	public static void cacheResult(com.vijayan.profile.model.Key key) {
		getPersistence().cacheResult(key);
	}

	/**
	* Caches the keies in the entity cache if it is enabled.
	*
	* @param keies the keies
	*/
	public static void cacheResult(
		java.util.List<com.vijayan.profile.model.Key> keies) {
		getPersistence().cacheResult(keies);
	}

	/**
	* Creates a new key with the primary key. Does not add the key to the database.
	*
	* @param keyId the primary key for the new key
	* @return the new key
	*/
	public static com.vijayan.profile.model.Key create(long keyId) {
		return getPersistence().create(keyId);
	}

	/**
	* Removes the key with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param keyId the primary key of the key
	* @return the key that was removed
	* @throws com.vijayan.profile.NoSuchKeyException if a key with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vijayan.profile.model.Key remove(long keyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vijayan.profile.NoSuchKeyException {
		return getPersistence().remove(keyId);
	}

	public static com.vijayan.profile.model.Key updateImpl(
		com.vijayan.profile.model.Key key, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(key, merge);
	}

	/**
	* Returns the key with the primary key or throws a {@link com.vijayan.profile.NoSuchKeyException} if it could not be found.
	*
	* @param keyId the primary key of the key
	* @return the key
	* @throws com.vijayan.profile.NoSuchKeyException if a key with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vijayan.profile.model.Key findByPrimaryKey(long keyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vijayan.profile.NoSuchKeyException {
		return getPersistence().findByPrimaryKey(keyId);
	}

	/**
	* Returns the key with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param keyId the primary key of the key
	* @return the key, or <code>null</code> if a key with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vijayan.profile.model.Key fetchByPrimaryKey(long keyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(keyId);
	}

	/**
	* Returns the key where name = &#63; or throws a {@link com.vijayan.profile.NoSuchKeyException} if it could not be found.
	*
	* @param name the name
	* @return the matching key
	* @throws com.vijayan.profile.NoSuchKeyException if a matching key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vijayan.profile.model.Key findByname(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vijayan.profile.NoSuchKeyException {
		return getPersistence().findByname(name);
	}

	/**
	* Returns the key where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching key, or <code>null</code> if a matching key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vijayan.profile.model.Key fetchByname(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByname(name);
	}

	/**
	* Returns the key where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching key, or <code>null</code> if a matching key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vijayan.profile.model.Key fetchByname(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByname(name, retrieveFromCache);
	}

	/**
	* Returns all the keies.
	*
	* @return the keies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vijayan.profile.model.Key> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the keies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of keies
	* @param end the upper bound of the range of keies (not inclusive)
	* @return the range of keies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vijayan.profile.model.Key> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the keies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of keies
	* @param end the upper bound of the range of keies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of keies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vijayan.profile.model.Key> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the key where name = &#63; from the database.
	*
	* @param name the name
	* @return the key that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.vijayan.profile.model.Key removeByname(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vijayan.profile.NoSuchKeyException {
		return getPersistence().removeByname(name);
	}

	/**
	* Removes all the keies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of keies where name = &#63;.
	*
	* @param name the name
	* @return the number of matching keies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByname(name);
	}

	/**
	* Returns the number of keies.
	*
	* @return the number of keies
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static KeyPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (KeyPersistence)PortletBeanLocatorUtil.locate(com.vijayan.profile.service.ClpSerializer.getServletContextName(),
					KeyPersistence.class.getName());

			ReferenceRegistry.registerReference(KeyUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(KeyPersistence persistence) {
	}

	private static KeyPersistence _persistence;
}