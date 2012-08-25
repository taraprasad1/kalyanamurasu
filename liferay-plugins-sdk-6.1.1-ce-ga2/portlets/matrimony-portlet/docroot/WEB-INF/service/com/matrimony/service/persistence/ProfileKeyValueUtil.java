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

import com.matrimony.model.ProfileKeyValue;

import java.util.List;

/**
 * The persistence utility for the profile key value service. This utility wraps {@link ProfileKeyValuePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author matrimony
 * @see ProfileKeyValuePersistence
 * @see ProfileKeyValuePersistenceImpl
 * @generated
 */
public class ProfileKeyValueUtil {
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
	public static void clearCache(ProfileKeyValue profileKeyValue) {
		getPersistence().clearCache(profileKeyValue);
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
	public static List<ProfileKeyValue> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProfileKeyValue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProfileKeyValue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ProfileKeyValue update(ProfileKeyValue profileKeyValue,
		boolean merge) throws SystemException {
		return getPersistence().update(profileKeyValue, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ProfileKeyValue update(ProfileKeyValue profileKeyValue,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(profileKeyValue, merge, serviceContext);
	}

	/**
	* Caches the profile key value in the entity cache if it is enabled.
	*
	* @param profileKeyValue the profile key value
	*/
	public static void cacheResult(
		com.matrimony.model.ProfileKeyValue profileKeyValue) {
		getPersistence().cacheResult(profileKeyValue);
	}

	/**
	* Caches the profile key values in the entity cache if it is enabled.
	*
	* @param profileKeyValues the profile key values
	*/
	public static void cacheResult(
		java.util.List<com.matrimony.model.ProfileKeyValue> profileKeyValues) {
		getPersistence().cacheResult(profileKeyValues);
	}

	/**
	* Creates a new profile key value with the primary key. Does not add the profile key value to the database.
	*
	* @param profileKeyValuePK the primary key for the new profile key value
	* @return the new profile key value
	*/
	public static com.matrimony.model.ProfileKeyValue create(
		com.matrimony.service.persistence.ProfileKeyValuePK profileKeyValuePK) {
		return getPersistence().create(profileKeyValuePK);
	}

	/**
	* Removes the profile key value with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param profileKeyValuePK the primary key of the profile key value
	* @return the profile key value that was removed
	* @throws com.matrimony.NoSuchProfileKeyValueException if a profile key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.ProfileKeyValue remove(
		com.matrimony.service.persistence.ProfileKeyValuePK profileKeyValuePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileKeyValueException {
		return getPersistence().remove(profileKeyValuePK);
	}

	public static com.matrimony.model.ProfileKeyValue updateImpl(
		com.matrimony.model.ProfileKeyValue profileKeyValue, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(profileKeyValue, merge);
	}

	/**
	* Returns the profile key value with the primary key or throws a {@link com.matrimony.NoSuchProfileKeyValueException} if it could not be found.
	*
	* @param profileKeyValuePK the primary key of the profile key value
	* @return the profile key value
	* @throws com.matrimony.NoSuchProfileKeyValueException if a profile key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.ProfileKeyValue findByPrimaryKey(
		com.matrimony.service.persistence.ProfileKeyValuePK profileKeyValuePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileKeyValueException {
		return getPersistence().findByPrimaryKey(profileKeyValuePK);
	}

	/**
	* Returns the profile key value with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param profileKeyValuePK the primary key of the profile key value
	* @return the profile key value, or <code>null</code> if a profile key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.ProfileKeyValue fetchByPrimaryKey(
		com.matrimony.service.persistence.ProfileKeyValuePK profileKeyValuePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(profileKeyValuePK);
	}

	/**
	* Returns all the profile key values where keyId = &#63; and profileId = &#63;.
	*
	* @param keyId the key ID
	* @param profileId the profile ID
	* @return the matching profile key values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.ProfileKeyValue> findByProfileAndKeyId(
		long keyId, long profileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProfileAndKeyId(keyId, profileId);
	}

	/**
	* Returns a range of all the profile key values where keyId = &#63; and profileId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param keyId the key ID
	* @param profileId the profile ID
	* @param start the lower bound of the range of profile key values
	* @param end the upper bound of the range of profile key values (not inclusive)
	* @return the range of matching profile key values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.ProfileKeyValue> findByProfileAndKeyId(
		long keyId, long profileId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProfileAndKeyId(keyId, profileId, start, end);
	}

	/**
	* Returns an ordered range of all the profile key values where keyId = &#63; and profileId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param keyId the key ID
	* @param profileId the profile ID
	* @param start the lower bound of the range of profile key values
	* @param end the upper bound of the range of profile key values (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching profile key values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.ProfileKeyValue> findByProfileAndKeyId(
		long keyId, long profileId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProfileAndKeyId(keyId, profileId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first profile key value in the ordered set where keyId = &#63; and profileId = &#63;.
	*
	* @param keyId the key ID
	* @param profileId the profile ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching profile key value
	* @throws com.matrimony.NoSuchProfileKeyValueException if a matching profile key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.ProfileKeyValue findByProfileAndKeyId_First(
		long keyId, long profileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileKeyValueException {
		return getPersistence()
				   .findByProfileAndKeyId_First(keyId, profileId,
			orderByComparator);
	}

	/**
	* Returns the first profile key value in the ordered set where keyId = &#63; and profileId = &#63;.
	*
	* @param keyId the key ID
	* @param profileId the profile ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching profile key value, or <code>null</code> if a matching profile key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.ProfileKeyValue fetchByProfileAndKeyId_First(
		long keyId, long profileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProfileAndKeyId_First(keyId, profileId,
			orderByComparator);
	}

	/**
	* Returns the last profile key value in the ordered set where keyId = &#63; and profileId = &#63;.
	*
	* @param keyId the key ID
	* @param profileId the profile ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching profile key value
	* @throws com.matrimony.NoSuchProfileKeyValueException if a matching profile key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.ProfileKeyValue findByProfileAndKeyId_Last(
		long keyId, long profileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileKeyValueException {
		return getPersistence()
				   .findByProfileAndKeyId_Last(keyId, profileId,
			orderByComparator);
	}

	/**
	* Returns the last profile key value in the ordered set where keyId = &#63; and profileId = &#63;.
	*
	* @param keyId the key ID
	* @param profileId the profile ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching profile key value, or <code>null</code> if a matching profile key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.ProfileKeyValue fetchByProfileAndKeyId_Last(
		long keyId, long profileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProfileAndKeyId_Last(keyId, profileId,
			orderByComparator);
	}

	/**
	* Returns the profile key values before and after the current profile key value in the ordered set where keyId = &#63; and profileId = &#63;.
	*
	* @param profileKeyValuePK the primary key of the current profile key value
	* @param keyId the key ID
	* @param profileId the profile ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next profile key value
	* @throws com.matrimony.NoSuchProfileKeyValueException if a profile key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.ProfileKeyValue[] findByProfileAndKeyId_PrevAndNext(
		com.matrimony.service.persistence.ProfileKeyValuePK profileKeyValuePK,
		long keyId, long profileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileKeyValueException {
		return getPersistence()
				   .findByProfileAndKeyId_PrevAndNext(profileKeyValuePK, keyId,
			profileId, orderByComparator);
	}

	/**
	* Returns all the profile key values where keyId = &#63; and valueId = &#63;.
	*
	* @param keyId the key ID
	* @param valueId the value ID
	* @return the matching profile key values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.ProfileKeyValue> findByKeyandValueId(
		long keyId, long valueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByKeyandValueId(keyId, valueId);
	}

	/**
	* Returns a range of all the profile key values where keyId = &#63; and valueId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param keyId the key ID
	* @param valueId the value ID
	* @param start the lower bound of the range of profile key values
	* @param end the upper bound of the range of profile key values (not inclusive)
	* @return the range of matching profile key values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.ProfileKeyValue> findByKeyandValueId(
		long keyId, long valueId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByKeyandValueId(keyId, valueId, start, end);
	}

	/**
	* Returns an ordered range of all the profile key values where keyId = &#63; and valueId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param keyId the key ID
	* @param valueId the value ID
	* @param start the lower bound of the range of profile key values
	* @param end the upper bound of the range of profile key values (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching profile key values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.ProfileKeyValue> findByKeyandValueId(
		long keyId, long valueId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByKeyandValueId(keyId, valueId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first profile key value in the ordered set where keyId = &#63; and valueId = &#63;.
	*
	* @param keyId the key ID
	* @param valueId the value ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching profile key value
	* @throws com.matrimony.NoSuchProfileKeyValueException if a matching profile key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.ProfileKeyValue findByKeyandValueId_First(
		long keyId, long valueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileKeyValueException {
		return getPersistence()
				   .findByKeyandValueId_First(keyId, valueId, orderByComparator);
	}

	/**
	* Returns the first profile key value in the ordered set where keyId = &#63; and valueId = &#63;.
	*
	* @param keyId the key ID
	* @param valueId the value ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching profile key value, or <code>null</code> if a matching profile key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.ProfileKeyValue fetchByKeyandValueId_First(
		long keyId, long valueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByKeyandValueId_First(keyId, valueId, orderByComparator);
	}

	/**
	* Returns the last profile key value in the ordered set where keyId = &#63; and valueId = &#63;.
	*
	* @param keyId the key ID
	* @param valueId the value ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching profile key value
	* @throws com.matrimony.NoSuchProfileKeyValueException if a matching profile key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.ProfileKeyValue findByKeyandValueId_Last(
		long keyId, long valueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileKeyValueException {
		return getPersistence()
				   .findByKeyandValueId_Last(keyId, valueId, orderByComparator);
	}

	/**
	* Returns the last profile key value in the ordered set where keyId = &#63; and valueId = &#63;.
	*
	* @param keyId the key ID
	* @param valueId the value ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching profile key value, or <code>null</code> if a matching profile key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.ProfileKeyValue fetchByKeyandValueId_Last(
		long keyId, long valueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByKeyandValueId_Last(keyId, valueId, orderByComparator);
	}

	/**
	* Returns the profile key values before and after the current profile key value in the ordered set where keyId = &#63; and valueId = &#63;.
	*
	* @param profileKeyValuePK the primary key of the current profile key value
	* @param keyId the key ID
	* @param valueId the value ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next profile key value
	* @throws com.matrimony.NoSuchProfileKeyValueException if a profile key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.ProfileKeyValue[] findByKeyandValueId_PrevAndNext(
		com.matrimony.service.persistence.ProfileKeyValuePK profileKeyValuePK,
		long keyId, long valueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileKeyValueException {
		return getPersistence()
				   .findByKeyandValueId_PrevAndNext(profileKeyValuePK, keyId,
			valueId, orderByComparator);
	}

	/**
	* Returns all the profile key values.
	*
	* @return the profile key values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.ProfileKeyValue> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the profile key values.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of profile key values
	* @param end the upper bound of the range of profile key values (not inclusive)
	* @return the range of profile key values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.ProfileKeyValue> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the profile key values.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of profile key values
	* @param end the upper bound of the range of profile key values (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of profile key values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.ProfileKeyValue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the profile key values where keyId = &#63; and profileId = &#63; from the database.
	*
	* @param keyId the key ID
	* @param profileId the profile ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByProfileAndKeyId(long keyId, long profileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByProfileAndKeyId(keyId, profileId);
	}

	/**
	* Removes all the profile key values where keyId = &#63; and valueId = &#63; from the database.
	*
	* @param keyId the key ID
	* @param valueId the value ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByKeyandValueId(long keyId, long valueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByKeyandValueId(keyId, valueId);
	}

	/**
	* Removes all the profile key values from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of profile key values where keyId = &#63; and profileId = &#63;.
	*
	* @param keyId the key ID
	* @param profileId the profile ID
	* @return the number of matching profile key values
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProfileAndKeyId(long keyId, long profileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByProfileAndKeyId(keyId, profileId);
	}

	/**
	* Returns the number of profile key values where keyId = &#63; and valueId = &#63;.
	*
	* @param keyId the key ID
	* @param valueId the value ID
	* @return the number of matching profile key values
	* @throws SystemException if a system exception occurred
	*/
	public static int countByKeyandValueId(long keyId, long valueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByKeyandValueId(keyId, valueId);
	}

	/**
	* Returns the number of profile key values.
	*
	* @return the number of profile key values
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ProfileKeyValuePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ProfileKeyValuePersistence)PortletBeanLocatorUtil.locate(com.matrimony.service.ClpSerializer.getServletContextName(),
					ProfileKeyValuePersistence.class.getName());

			ReferenceRegistry.registerReference(ProfileKeyValueUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ProfileKeyValuePersistence persistence) {
	}

	private static ProfileKeyValuePersistence _persistence;
}