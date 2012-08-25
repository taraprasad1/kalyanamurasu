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

import com.matrimony.model.ProfileKeyValue;

/**
 * The persistence interface for the profile key value service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author matrimony
 * @see ProfileKeyValuePersistenceImpl
 * @see ProfileKeyValueUtil
 * @generated
 */
public interface ProfileKeyValuePersistence extends BasePersistence<ProfileKeyValue> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProfileKeyValueUtil} to access the profile key value persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the profile key value in the entity cache if it is enabled.
	*
	* @param profileKeyValue the profile key value
	*/
	public void cacheResult(com.matrimony.model.ProfileKeyValue profileKeyValue);

	/**
	* Caches the profile key values in the entity cache if it is enabled.
	*
	* @param profileKeyValues the profile key values
	*/
	public void cacheResult(
		java.util.List<com.matrimony.model.ProfileKeyValue> profileKeyValues);

	/**
	* Creates a new profile key value with the primary key. Does not add the profile key value to the database.
	*
	* @param profileKeyValuePK the primary key for the new profile key value
	* @return the new profile key value
	*/
	public com.matrimony.model.ProfileKeyValue create(
		com.matrimony.service.persistence.ProfileKeyValuePK profileKeyValuePK);

	/**
	* Removes the profile key value with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param profileKeyValuePK the primary key of the profile key value
	* @return the profile key value that was removed
	* @throws com.matrimony.NoSuchProfileKeyValueException if a profile key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.ProfileKeyValue remove(
		com.matrimony.service.persistence.ProfileKeyValuePK profileKeyValuePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileKeyValueException;

	public com.matrimony.model.ProfileKeyValue updateImpl(
		com.matrimony.model.ProfileKeyValue profileKeyValue, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the profile key value with the primary key or throws a {@link com.matrimony.NoSuchProfileKeyValueException} if it could not be found.
	*
	* @param profileKeyValuePK the primary key of the profile key value
	* @return the profile key value
	* @throws com.matrimony.NoSuchProfileKeyValueException if a profile key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.ProfileKeyValue findByPrimaryKey(
		com.matrimony.service.persistence.ProfileKeyValuePK profileKeyValuePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileKeyValueException;

	/**
	* Returns the profile key value with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param profileKeyValuePK the primary key of the profile key value
	* @return the profile key value, or <code>null</code> if a profile key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.ProfileKeyValue fetchByPrimaryKey(
		com.matrimony.service.persistence.ProfileKeyValuePK profileKeyValuePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the profile key values where keyId = &#63; and profileId = &#63;.
	*
	* @param keyId the key ID
	* @param profileId the profile ID
	* @return the matching profile key values
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.ProfileKeyValue> findByProfileAndKeyId(
		long keyId, long profileId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.matrimony.model.ProfileKeyValue> findByProfileAndKeyId(
		long keyId, long profileId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.matrimony.model.ProfileKeyValue> findByProfileAndKeyId(
		long keyId, long profileId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.matrimony.model.ProfileKeyValue findByProfileAndKeyId_First(
		long keyId, long profileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileKeyValueException;

	/**
	* Returns the first profile key value in the ordered set where keyId = &#63; and profileId = &#63;.
	*
	* @param keyId the key ID
	* @param profileId the profile ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching profile key value, or <code>null</code> if a matching profile key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.ProfileKeyValue fetchByProfileAndKeyId_First(
		long keyId, long profileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.matrimony.model.ProfileKeyValue findByProfileAndKeyId_Last(
		long keyId, long profileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileKeyValueException;

	/**
	* Returns the last profile key value in the ordered set where keyId = &#63; and profileId = &#63;.
	*
	* @param keyId the key ID
	* @param profileId the profile ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching profile key value, or <code>null</code> if a matching profile key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.ProfileKeyValue fetchByProfileAndKeyId_Last(
		long keyId, long profileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.matrimony.model.ProfileKeyValue[] findByProfileAndKeyId_PrevAndNext(
		com.matrimony.service.persistence.ProfileKeyValuePK profileKeyValuePK,
		long keyId, long profileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileKeyValueException;

	/**
	* Returns all the profile key values where keyId = &#63; and valueId = &#63;.
	*
	* @param keyId the key ID
	* @param valueId the value ID
	* @return the matching profile key values
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.ProfileKeyValue> findByKeyandValueId(
		long keyId, long valueId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.matrimony.model.ProfileKeyValue> findByKeyandValueId(
		long keyId, long valueId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.matrimony.model.ProfileKeyValue> findByKeyandValueId(
		long keyId, long valueId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.matrimony.model.ProfileKeyValue findByKeyandValueId_First(
		long keyId, long valueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileKeyValueException;

	/**
	* Returns the first profile key value in the ordered set where keyId = &#63; and valueId = &#63;.
	*
	* @param keyId the key ID
	* @param valueId the value ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching profile key value, or <code>null</code> if a matching profile key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.ProfileKeyValue fetchByKeyandValueId_First(
		long keyId, long valueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.matrimony.model.ProfileKeyValue findByKeyandValueId_Last(
		long keyId, long valueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileKeyValueException;

	/**
	* Returns the last profile key value in the ordered set where keyId = &#63; and valueId = &#63;.
	*
	* @param keyId the key ID
	* @param valueId the value ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching profile key value, or <code>null</code> if a matching profile key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.ProfileKeyValue fetchByKeyandValueId_Last(
		long keyId, long valueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.matrimony.model.ProfileKeyValue[] findByKeyandValueId_PrevAndNext(
		com.matrimony.service.persistence.ProfileKeyValuePK profileKeyValuePK,
		long keyId, long valueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileKeyValueException;

	/**
	* Returns all the profile key values.
	*
	* @return the profile key values
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.ProfileKeyValue> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.matrimony.model.ProfileKeyValue> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.matrimony.model.ProfileKeyValue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the profile key values where keyId = &#63; and profileId = &#63; from the database.
	*
	* @param keyId the key ID
	* @param profileId the profile ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByProfileAndKeyId(long keyId, long profileId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the profile key values where keyId = &#63; and valueId = &#63; from the database.
	*
	* @param keyId the key ID
	* @param valueId the value ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByKeyandValueId(long keyId, long valueId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the profile key values from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of profile key values where keyId = &#63; and profileId = &#63;.
	*
	* @param keyId the key ID
	* @param profileId the profile ID
	* @return the number of matching profile key values
	* @throws SystemException if a system exception occurred
	*/
	public int countByProfileAndKeyId(long keyId, long profileId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of profile key values where keyId = &#63; and valueId = &#63;.
	*
	* @param keyId the key ID
	* @param valueId the value ID
	* @return the number of matching profile key values
	* @throws SystemException if a system exception occurred
	*/
	public int countByKeyandValueId(long keyId, long valueId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of profile key values.
	*
	* @return the number of profile key values
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}