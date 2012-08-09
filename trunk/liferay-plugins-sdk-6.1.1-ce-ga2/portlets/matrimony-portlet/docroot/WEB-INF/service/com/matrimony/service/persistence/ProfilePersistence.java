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

import com.matrimony.model.Profile;

/**
 * The persistence interface for the profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author matrimony
 * @see ProfilePersistenceImpl
 * @see ProfileUtil
 * @generated
 */
public interface ProfilePersistence extends BasePersistence<Profile> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProfileUtil} to access the profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the profile in the entity cache if it is enabled.
	*
	* @param profile the profile
	*/
	public void cacheResult(com.matrimony.model.Profile profile);

	/**
	* Caches the profiles in the entity cache if it is enabled.
	*
	* @param profiles the profiles
	*/
	public void cacheResult(
		java.util.List<com.matrimony.model.Profile> profiles);

	/**
	* Creates a new profile with the primary key. Does not add the profile to the database.
	*
	* @param profileId the primary key for the new profile
	* @return the new profile
	*/
	public com.matrimony.model.Profile create(long profileId);

	/**
	* Removes the profile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param profileId the primary key of the profile
	* @return the profile that was removed
	* @throws com.matrimony.NoSuchProfileException if a profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Profile remove(long profileId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileException;

	public com.matrimony.model.Profile updateImpl(
		com.matrimony.model.Profile profile, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the profile with the primary key or throws a {@link com.matrimony.NoSuchProfileException} if it could not be found.
	*
	* @param profileId the primary key of the profile
	* @return the profile
	* @throws com.matrimony.NoSuchProfileException if a profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Profile findByPrimaryKey(long profileId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileException;

	/**
	* Returns the profile with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param profileId the primary key of the profile
	* @return the profile, or <code>null</code> if a profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Profile fetchByPrimaryKey(long profileId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the profiles where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @return the matching profiles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.Profile> findByUserId(
		long createdBy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the profiles where createdBy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param createdBy the created by
	* @param start the lower bound of the range of profiles
	* @param end the upper bound of the range of profiles (not inclusive)
	* @return the range of matching profiles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.Profile> findByUserId(
		long createdBy, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the profiles where createdBy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param createdBy the created by
	* @param start the lower bound of the range of profiles
	* @param end the upper bound of the range of profiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching profiles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.Profile> findByUserId(
		long createdBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first profile in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching profile
	* @throws com.matrimony.NoSuchProfileException if a matching profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Profile findByUserId_First(long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileException;

	/**
	* Returns the first profile in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching profile, or <code>null</code> if a matching profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Profile fetchByUserId_First(long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last profile in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching profile
	* @throws com.matrimony.NoSuchProfileException if a matching profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Profile findByUserId_Last(long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileException;

	/**
	* Returns the last profile in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching profile, or <code>null</code> if a matching profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Profile fetchByUserId_Last(long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the profiles before and after the current profile in the ordered set where createdBy = &#63;.
	*
	* @param profileId the primary key of the current profile
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next profile
	* @throws com.matrimony.NoSuchProfileException if a profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Profile[] findByUserId_PrevAndNext(
		long profileId, long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileException;

	/**
	* Returns all the profiles where status = &#63;.
	*
	* @param status the status
	* @return the matching profiles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.Profile> findByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the profiles where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of profiles
	* @param end the upper bound of the range of profiles (not inclusive)
	* @return the range of matching profiles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.Profile> findByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the profiles where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of profiles
	* @param end the upper bound of the range of profiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching profiles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.Profile> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first profile in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching profile
	* @throws com.matrimony.NoSuchProfileException if a matching profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Profile findByStatus_First(int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileException;

	/**
	* Returns the first profile in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching profile, or <code>null</code> if a matching profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Profile fetchByStatus_First(int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last profile in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching profile
	* @throws com.matrimony.NoSuchProfileException if a matching profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Profile findByStatus_Last(int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileException;

	/**
	* Returns the last profile in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching profile, or <code>null</code> if a matching profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Profile fetchByStatus_Last(int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the profiles before and after the current profile in the ordered set where status = &#63;.
	*
	* @param profileId the primary key of the current profile
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next profile
	* @throws com.matrimony.NoSuchProfileException if a profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Profile[] findByStatus_PrevAndNext(
		long profileId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileException;

	/**
	* Returns all the profiles.
	*
	* @return the profiles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.Profile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the profiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of profiles
	* @param end the upper bound of the range of profiles (not inclusive)
	* @return the range of profiles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.Profile> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the profiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of profiles
	* @param end the upper bound of the range of profiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of profiles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.Profile> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the profiles where createdBy = &#63; from the database.
	*
	* @param createdBy the created by
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long createdBy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the profiles where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the profiles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of profiles where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @return the number of matching profiles
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long createdBy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of profiles where status = &#63;.
	*
	* @param status the status
	* @return the number of matching profiles
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of profiles.
	*
	* @return the number of profiles
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}