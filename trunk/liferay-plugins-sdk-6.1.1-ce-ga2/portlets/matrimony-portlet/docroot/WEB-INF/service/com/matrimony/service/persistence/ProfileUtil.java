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

import com.matrimony.model.Profile;

import java.util.List;

/**
 * The persistence utility for the profile service. This utility wraps {@link ProfilePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author matrimony
 * @see ProfilePersistence
 * @see ProfilePersistenceImpl
 * @generated
 */
public class ProfileUtil {
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
	public static void clearCache(Profile profile) {
		getPersistence().clearCache(profile);
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
	public static List<Profile> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Profile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Profile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Profile update(Profile profile, boolean merge)
		throws SystemException {
		return getPersistence().update(profile, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Profile update(Profile profile, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(profile, merge, serviceContext);
	}

	/**
	* Caches the profile in the entity cache if it is enabled.
	*
	* @param profile the profile
	*/
	public static void cacheResult(com.matrimony.model.Profile profile) {
		getPersistence().cacheResult(profile);
	}

	/**
	* Caches the profiles in the entity cache if it is enabled.
	*
	* @param profiles the profiles
	*/
	public static void cacheResult(
		java.util.List<com.matrimony.model.Profile> profiles) {
		getPersistence().cacheResult(profiles);
	}

	/**
	* Creates a new profile with the primary key. Does not add the profile to the database.
	*
	* @param profileId the primary key for the new profile
	* @return the new profile
	*/
	public static com.matrimony.model.Profile create(long profileId) {
		return getPersistence().create(profileId);
	}

	/**
	* Removes the profile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param profileId the primary key of the profile
	* @return the profile that was removed
	* @throws com.matrimony.NoSuchProfileException if a profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Profile remove(long profileId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileException {
		return getPersistence().remove(profileId);
	}

	public static com.matrimony.model.Profile updateImpl(
		com.matrimony.model.Profile profile, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(profile, merge);
	}

	/**
	* Returns the profile with the primary key or throws a {@link com.matrimony.NoSuchProfileException} if it could not be found.
	*
	* @param profileId the primary key of the profile
	* @return the profile
	* @throws com.matrimony.NoSuchProfileException if a profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Profile findByPrimaryKey(long profileId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileException {
		return getPersistence().findByPrimaryKey(profileId);
	}

	/**
	* Returns the profile with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param profileId the primary key of the profile
	* @return the profile, or <code>null</code> if a profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Profile fetchByPrimaryKey(long profileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(profileId);
	}

	/**
	* Returns all the profiles where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @return the matching profiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.Profile> findByUserId(
		long createdBy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(createdBy);
	}

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
	public static java.util.List<com.matrimony.model.Profile> findByUserId(
		long createdBy, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(createdBy, start, end);
	}

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
	public static java.util.List<com.matrimony.model.Profile> findByUserId(
		long createdBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(createdBy, start, end, orderByComparator);
	}

	/**
	* Returns the first profile in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching profile
	* @throws com.matrimony.NoSuchProfileException if a matching profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Profile findByUserId_First(
		long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileException {
		return getPersistence().findByUserId_First(createdBy, orderByComparator);
	}

	/**
	* Returns the first profile in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching profile, or <code>null</code> if a matching profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Profile fetchByUserId_First(
		long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_First(createdBy, orderByComparator);
	}

	/**
	* Returns the last profile in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching profile
	* @throws com.matrimony.NoSuchProfileException if a matching profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Profile findByUserId_Last(
		long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileException {
		return getPersistence().findByUserId_Last(createdBy, orderByComparator);
	}

	/**
	* Returns the last profile in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching profile, or <code>null</code> if a matching profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Profile fetchByUserId_Last(
		long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_Last(createdBy, orderByComparator);
	}

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
	public static com.matrimony.model.Profile[] findByUserId_PrevAndNext(
		long profileId, long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileException {
		return getPersistence()
				   .findByUserId_PrevAndNext(profileId, createdBy,
			orderByComparator);
	}

	/**
	* Returns all the profiles where status = &#63;.
	*
	* @param status the status
	* @return the matching profiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.Profile> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status);
	}

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
	public static java.util.List<com.matrimony.model.Profile> findByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status, start, end);
	}

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
	public static java.util.List<com.matrimony.model.Profile> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the first profile in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching profile
	* @throws com.matrimony.NoSuchProfileException if a matching profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Profile findByStatus_First(int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileException {
		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the first profile in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching profile, or <code>null</code> if a matching profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Profile fetchByStatus_First(int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the last profile in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching profile
	* @throws com.matrimony.NoSuchProfileException if a matching profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Profile findByStatus_Last(int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileException {
		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last profile in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching profile, or <code>null</code> if a matching profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Profile fetchByStatus_Last(int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

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
	public static com.matrimony.model.Profile[] findByStatus_PrevAndNext(
		long profileId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileException {
		return getPersistence()
				   .findByStatus_PrevAndNext(profileId, status,
			orderByComparator);
	}

	/**
	* Returns all the profiles.
	*
	* @return the profiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.Profile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.matrimony.model.Profile> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.matrimony.model.Profile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the profiles where createdBy = &#63; from the database.
	*
	* @param createdBy the created by
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long createdBy)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(createdBy);
	}

	/**
	* Removes all the profiles where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatus(status);
	}

	/**
	* Removes all the profiles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of profiles where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @return the number of matching profiles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long createdBy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(createdBy);
	}

	/**
	* Returns the number of profiles where status = &#63;.
	*
	* @param status the status
	* @return the number of matching profiles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(status);
	}

	/**
	* Returns the number of profiles.
	*
	* @return the number of profiles
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ProfilePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ProfilePersistence)PortletBeanLocatorUtil.locate(com.matrimony.service.ClpSerializer.getServletContextName(),
					ProfilePersistence.class.getName());

			ReferenceRegistry.registerReference(ProfileUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ProfilePersistence persistence) {
	}

	private static ProfilePersistence _persistence;
}