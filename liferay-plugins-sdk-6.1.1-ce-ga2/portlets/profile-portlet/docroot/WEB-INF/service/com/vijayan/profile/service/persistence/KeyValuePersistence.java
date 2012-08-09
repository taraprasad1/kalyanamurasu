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

import com.vijayan.profile.model.KeyValue;

/**
 * The persistence interface for the key value service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author vijayan
 * @see KeyValuePersistenceImpl
 * @see KeyValueUtil
 * @generated
 */
public interface KeyValuePersistence extends BasePersistence<KeyValue> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link KeyValueUtil} to access the key value persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the key value in the entity cache if it is enabled.
	*
	* @param keyValue the key value
	*/
	public void cacheResult(com.vijayan.profile.model.KeyValue keyValue);

	/**
	* Caches the key values in the entity cache if it is enabled.
	*
	* @param keyValues the key values
	*/
	public void cacheResult(
		java.util.List<com.vijayan.profile.model.KeyValue> keyValues);

	/**
	* Creates a new key value with the primary key. Does not add the key value to the database.
	*
	* @param valueId the primary key for the new key value
	* @return the new key value
	*/
	public com.vijayan.profile.model.KeyValue create(long valueId);

	/**
	* Removes the key value with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param valueId the primary key of the key value
	* @return the key value that was removed
	* @throws com.vijayan.profile.NoSuchKeyValueException if a key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vijayan.profile.model.KeyValue remove(long valueId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vijayan.profile.NoSuchKeyValueException;

	public com.vijayan.profile.model.KeyValue updateImpl(
		com.vijayan.profile.model.KeyValue keyValue, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the key value with the primary key or throws a {@link com.vijayan.profile.NoSuchKeyValueException} if it could not be found.
	*
	* @param valueId the primary key of the key value
	* @return the key value
	* @throws com.vijayan.profile.NoSuchKeyValueException if a key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vijayan.profile.model.KeyValue findByPrimaryKey(long valueId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vijayan.profile.NoSuchKeyValueException;

	/**
	* Returns the key value with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param valueId the primary key of the key value
	* @return the key value, or <code>null</code> if a key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vijayan.profile.model.KeyValue fetchByPrimaryKey(long valueId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the key values where keyId = &#63;.
	*
	* @param keyId the key ID
	* @return the matching key values
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vijayan.profile.model.KeyValue> findByKeyId(
		long keyId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the key values where keyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param keyId the key ID
	* @param start the lower bound of the range of key values
	* @param end the upper bound of the range of key values (not inclusive)
	* @return the range of matching key values
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vijayan.profile.model.KeyValue> findByKeyId(
		long keyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the key values where keyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param keyId the key ID
	* @param start the lower bound of the range of key values
	* @param end the upper bound of the range of key values (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching key values
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vijayan.profile.model.KeyValue> findByKeyId(
		long keyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first key value in the ordered set where keyId = &#63;.
	*
	* @param keyId the key ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching key value
	* @throws com.vijayan.profile.NoSuchKeyValueException if a matching key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vijayan.profile.model.KeyValue findByKeyId_First(long keyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vijayan.profile.NoSuchKeyValueException;

	/**
	* Returns the first key value in the ordered set where keyId = &#63;.
	*
	* @param keyId the key ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching key value, or <code>null</code> if a matching key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vijayan.profile.model.KeyValue fetchByKeyId_First(long keyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last key value in the ordered set where keyId = &#63;.
	*
	* @param keyId the key ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching key value
	* @throws com.vijayan.profile.NoSuchKeyValueException if a matching key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vijayan.profile.model.KeyValue findByKeyId_Last(long keyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vijayan.profile.NoSuchKeyValueException;

	/**
	* Returns the last key value in the ordered set where keyId = &#63;.
	*
	* @param keyId the key ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching key value, or <code>null</code> if a matching key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vijayan.profile.model.KeyValue fetchByKeyId_Last(long keyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the key values before and after the current key value in the ordered set where keyId = &#63;.
	*
	* @param valueId the primary key of the current key value
	* @param keyId the key ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next key value
	* @throws com.vijayan.profile.NoSuchKeyValueException if a key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vijayan.profile.model.KeyValue[] findByKeyId_PrevAndNext(
		long valueId, long keyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vijayan.profile.NoSuchKeyValueException;

	/**
	* Returns the key value where name = &#63; and keyId = &#63; or throws a {@link com.vijayan.profile.NoSuchKeyValueException} if it could not be found.
	*
	* @param name the name
	* @param keyId the key ID
	* @return the matching key value
	* @throws com.vijayan.profile.NoSuchKeyValueException if a matching key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vijayan.profile.model.KeyValue findByvalueName(
		java.lang.String name, long keyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vijayan.profile.NoSuchKeyValueException;

	/**
	* Returns the key value where name = &#63; and keyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @param keyId the key ID
	* @return the matching key value, or <code>null</code> if a matching key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vijayan.profile.model.KeyValue fetchByvalueName(
		java.lang.String name, long keyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the key value where name = &#63; and keyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param keyId the key ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching key value, or <code>null</code> if a matching key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vijayan.profile.model.KeyValue fetchByvalueName(
		java.lang.String name, long keyId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the key values.
	*
	* @return the key values
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vijayan.profile.model.KeyValue> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the key values.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of key values
	* @param end the upper bound of the range of key values (not inclusive)
	* @return the range of key values
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vijayan.profile.model.KeyValue> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the key values.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of key values
	* @param end the upper bound of the range of key values (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of key values
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vijayan.profile.model.KeyValue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the key values where keyId = &#63; from the database.
	*
	* @param keyId the key ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByKeyId(long keyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the key value where name = &#63; and keyId = &#63; from the database.
	*
	* @param name the name
	* @param keyId the key ID
	* @return the key value that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.vijayan.profile.model.KeyValue removeByvalueName(
		java.lang.String name, long keyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vijayan.profile.NoSuchKeyValueException;

	/**
	* Removes all the key values from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of key values where keyId = &#63;.
	*
	* @param keyId the key ID
	* @return the number of matching key values
	* @throws SystemException if a system exception occurred
	*/
	public int countByKeyId(long keyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of key values where name = &#63; and keyId = &#63;.
	*
	* @param name the name
	* @param keyId the key ID
	* @return the number of matching key values
	* @throws SystemException if a system exception occurred
	*/
	public int countByvalueName(java.lang.String name, long keyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of key values.
	*
	* @return the number of key values
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}