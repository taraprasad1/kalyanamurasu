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

import com.matrimony.model.KeyValue;

import java.util.List;

/**
 * The persistence utility for the key value service. This utility wraps {@link KeyValuePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author matrimony
 * @see KeyValuePersistence
 * @see KeyValuePersistenceImpl
 * @generated
 */
public class KeyValueUtil {
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
	public static void clearCache(KeyValue keyValue) {
		getPersistence().clearCache(keyValue);
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
	public static List<KeyValue> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<KeyValue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<KeyValue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static KeyValue update(KeyValue keyValue, boolean merge)
		throws SystemException {
		return getPersistence().update(keyValue, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static KeyValue update(KeyValue keyValue, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(keyValue, merge, serviceContext);
	}

	/**
	* Caches the key value in the entity cache if it is enabled.
	*
	* @param keyValue the key value
	*/
	public static void cacheResult(com.matrimony.model.KeyValue keyValue) {
		getPersistence().cacheResult(keyValue);
	}

	/**
	* Caches the key values in the entity cache if it is enabled.
	*
	* @param keyValues the key values
	*/
	public static void cacheResult(
		java.util.List<com.matrimony.model.KeyValue> keyValues) {
		getPersistence().cacheResult(keyValues);
	}

	/**
	* Creates a new key value with the primary key. Does not add the key value to the database.
	*
	* @param valueId the primary key for the new key value
	* @return the new key value
	*/
	public static com.matrimony.model.KeyValue create(long valueId) {
		return getPersistence().create(valueId);
	}

	/**
	* Removes the key value with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param valueId the primary key of the key value
	* @return the key value that was removed
	* @throws com.matrimony.NoSuchKeyValueException if a key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.KeyValue remove(long valueId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchKeyValueException {
		return getPersistence().remove(valueId);
	}

	public static com.matrimony.model.KeyValue updateImpl(
		com.matrimony.model.KeyValue keyValue, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(keyValue, merge);
	}

	/**
	* Returns the key value with the primary key or throws a {@link com.matrimony.NoSuchKeyValueException} if it could not be found.
	*
	* @param valueId the primary key of the key value
	* @return the key value
	* @throws com.matrimony.NoSuchKeyValueException if a key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.KeyValue findByPrimaryKey(long valueId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchKeyValueException {
		return getPersistence().findByPrimaryKey(valueId);
	}

	/**
	* Returns the key value with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param valueId the primary key of the key value
	* @return the key value, or <code>null</code> if a key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.KeyValue fetchByPrimaryKey(long valueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(valueId);
	}

	/**
	* Returns all the key values where keyId = &#63;.
	*
	* @param keyId the key ID
	* @return the matching key values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.KeyValue> findByKeyId(
		long keyId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByKeyId(keyId);
	}

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
	public static java.util.List<com.matrimony.model.KeyValue> findByKeyId(
		long keyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByKeyId(keyId, start, end);
	}

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
	public static java.util.List<com.matrimony.model.KeyValue> findByKeyId(
		long keyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByKeyId(keyId, start, end, orderByComparator);
	}

	/**
	* Returns the first key value in the ordered set where keyId = &#63;.
	*
	* @param keyId the key ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching key value
	* @throws com.matrimony.NoSuchKeyValueException if a matching key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.KeyValue findByKeyId_First(long keyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchKeyValueException {
		return getPersistence().findByKeyId_First(keyId, orderByComparator);
	}

	/**
	* Returns the first key value in the ordered set where keyId = &#63;.
	*
	* @param keyId the key ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching key value, or <code>null</code> if a matching key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.KeyValue fetchByKeyId_First(long keyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByKeyId_First(keyId, orderByComparator);
	}

	/**
	* Returns the last key value in the ordered set where keyId = &#63;.
	*
	* @param keyId the key ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching key value
	* @throws com.matrimony.NoSuchKeyValueException if a matching key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.KeyValue findByKeyId_Last(long keyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchKeyValueException {
		return getPersistence().findByKeyId_Last(keyId, orderByComparator);
	}

	/**
	* Returns the last key value in the ordered set where keyId = &#63;.
	*
	* @param keyId the key ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching key value, or <code>null</code> if a matching key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.KeyValue fetchByKeyId_Last(long keyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByKeyId_Last(keyId, orderByComparator);
	}

	/**
	* Returns the key values before and after the current key value in the ordered set where keyId = &#63;.
	*
	* @param valueId the primary key of the current key value
	* @param keyId the key ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next key value
	* @throws com.matrimony.NoSuchKeyValueException if a key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.KeyValue[] findByKeyId_PrevAndNext(
		long valueId, long keyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchKeyValueException {
		return getPersistence()
				   .findByKeyId_PrevAndNext(valueId, keyId, orderByComparator);
	}

	/**
	* Returns the key value where name = &#63; and keyId = &#63; or throws a {@link com.matrimony.NoSuchKeyValueException} if it could not be found.
	*
	* @param name the name
	* @param keyId the key ID
	* @return the matching key value
	* @throws com.matrimony.NoSuchKeyValueException if a matching key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.KeyValue findByvalueName(
		java.lang.String name, long keyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchKeyValueException {
		return getPersistence().findByvalueName(name, keyId);
	}

	/**
	* Returns the key value where name = &#63; and keyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @param keyId the key ID
	* @return the matching key value, or <code>null</code> if a matching key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.KeyValue fetchByvalueName(
		java.lang.String name, long keyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByvalueName(name, keyId);
	}

	/**
	* Returns the key value where name = &#63; and keyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param keyId the key ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching key value, or <code>null</code> if a matching key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.KeyValue fetchByvalueName(
		java.lang.String name, long keyId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByvalueName(name, keyId, retrieveFromCache);
	}

	/**
	* Returns all the key values.
	*
	* @return the key values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.KeyValue> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.matrimony.model.KeyValue> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.matrimony.model.KeyValue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the key values where keyId = &#63; from the database.
	*
	* @param keyId the key ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByKeyId(long keyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByKeyId(keyId);
	}

	/**
	* Removes the key value where name = &#63; and keyId = &#63; from the database.
	*
	* @param name the name
	* @param keyId the key ID
	* @return the key value that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.KeyValue removeByvalueName(
		java.lang.String name, long keyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchKeyValueException {
		return getPersistence().removeByvalueName(name, keyId);
	}

	/**
	* Removes all the key values from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of key values where keyId = &#63;.
	*
	* @param keyId the key ID
	* @return the number of matching key values
	* @throws SystemException if a system exception occurred
	*/
	public static int countByKeyId(long keyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByKeyId(keyId);
	}

	/**
	* Returns the number of key values where name = &#63; and keyId = &#63;.
	*
	* @param name the name
	* @param keyId the key ID
	* @return the number of matching key values
	* @throws SystemException if a system exception occurred
	*/
	public static int countByvalueName(java.lang.String name, long keyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByvalueName(name, keyId);
	}

	/**
	* Returns the number of key values.
	*
	* @return the number of key values
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static KeyValuePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (KeyValuePersistence)PortletBeanLocatorUtil.locate(com.matrimony.service.ClpSerializer.getServletContextName(),
					KeyValuePersistence.class.getName());

			ReferenceRegistry.registerReference(KeyValueUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(KeyValuePersistence persistence) {
	}

	private static KeyValuePersistence _persistence;
}