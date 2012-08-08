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

import com.liferay.portal.service.persistence.BasePersistence;

import com.vijayan.profile.model.Key;

/**
 * The persistence interface for the key service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ravi
 * @see KeyPersistenceImpl
 * @see KeyUtil
 * @generated
 */
public interface KeyPersistence extends BasePersistence<Key> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link KeyUtil} to access the key persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the key in the entity cache if it is enabled.
	*
	* @param key the key
	*/
	public void cacheResult(com.vijayan.profile.model.Key key);

	/**
	* Caches the keies in the entity cache if it is enabled.
	*
	* @param keies the keies
	*/
	public void cacheResult(java.util.List<com.vijayan.profile.model.Key> keies);

	/**
	* Creates a new key with the primary key. Does not add the key to the database.
	*
	* @param keyId the primary key for the new key
	* @return the new key
	*/
	public com.vijayan.profile.model.Key create(long keyId);

	/**
	* Removes the key with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param keyId the primary key of the key
	* @return the key that was removed
	* @throws com.vijayan.profile.NoSuchKeyException if a key with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vijayan.profile.model.Key remove(long keyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vijayan.profile.NoSuchKeyException;

	public com.vijayan.profile.model.Key updateImpl(
		com.vijayan.profile.model.Key key, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the key with the primary key or throws a {@link com.vijayan.profile.NoSuchKeyException} if it could not be found.
	*
	* @param keyId the primary key of the key
	* @return the key
	* @throws com.vijayan.profile.NoSuchKeyException if a key with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vijayan.profile.model.Key findByPrimaryKey(long keyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vijayan.profile.NoSuchKeyException;

	/**
	* Returns the key with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param keyId the primary key of the key
	* @return the key, or <code>null</code> if a key with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vijayan.profile.model.Key fetchByPrimaryKey(long keyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the key where name = &#63; or throws a {@link com.vijayan.profile.NoSuchKeyException} if it could not be found.
	*
	* @param name the name
	* @return the matching key
	* @throws com.vijayan.profile.NoSuchKeyException if a matching key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vijayan.profile.model.Key findByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vijayan.profile.NoSuchKeyException;

	/**
	* Returns the key where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching key, or <code>null</code> if a matching key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vijayan.profile.model.Key fetchByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the key where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching key, or <code>null</code> if a matching key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vijayan.profile.model.Key fetchByname(java.lang.String name,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the keies.
	*
	* @return the keies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vijayan.profile.model.Key> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vijayan.profile.model.Key> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vijayan.profile.model.Key> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the key where name = &#63; from the database.
	*
	* @param name the name
	* @return the key that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.vijayan.profile.model.Key removeByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vijayan.profile.NoSuchKeyException;

	/**
	* Removes all the keies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of keies where name = &#63;.
	*
	* @param name the name
	* @return the number of matching keies
	* @throws SystemException if a system exception occurred
	*/
	public int countByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of keies.
	*
	* @return the number of keies
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}