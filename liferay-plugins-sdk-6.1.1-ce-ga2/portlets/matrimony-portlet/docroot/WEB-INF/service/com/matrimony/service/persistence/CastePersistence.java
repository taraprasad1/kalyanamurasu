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

import com.matrimony.model.Caste;

/**
 * The persistence interface for the caste service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author matrimony
 * @see CastePersistenceImpl
 * @see CasteUtil
 * @generated
 */
public interface CastePersistence extends BasePersistence<Caste> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CasteUtil} to access the caste persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the caste in the entity cache if it is enabled.
	*
	* @param caste the caste
	*/
	public void cacheResult(com.matrimony.model.Caste caste);

	/**
	* Caches the castes in the entity cache if it is enabled.
	*
	* @param castes the castes
	*/
	public void cacheResult(java.util.List<com.matrimony.model.Caste> castes);

	/**
	* Creates a new caste with the primary key. Does not add the caste to the database.
	*
	* @param casteId the primary key for the new caste
	* @return the new caste
	*/
	public com.matrimony.model.Caste create(long casteId);

	/**
	* Removes the caste with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param casteId the primary key of the caste
	* @return the caste that was removed
	* @throws com.matrimony.NoSuchCasteException if a caste with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Caste remove(long casteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchCasteException;

	public com.matrimony.model.Caste updateImpl(
		com.matrimony.model.Caste caste, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the caste with the primary key or throws a {@link com.matrimony.NoSuchCasteException} if it could not be found.
	*
	* @param casteId the primary key of the caste
	* @return the caste
	* @throws com.matrimony.NoSuchCasteException if a caste with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Caste findByPrimaryKey(long casteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchCasteException;

	/**
	* Returns the caste with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param casteId the primary key of the caste
	* @return the caste, or <code>null</code> if a caste with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Caste fetchByPrimaryKey(long casteId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the castes where religionId = &#63;.
	*
	* @param religionId the religion ID
	* @return the matching castes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.Caste> findByReligionId(
		long religionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the castes where religionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param religionId the religion ID
	* @param start the lower bound of the range of castes
	* @param end the upper bound of the range of castes (not inclusive)
	* @return the range of matching castes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.Caste> findByReligionId(
		long religionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the castes where religionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param religionId the religion ID
	* @param start the lower bound of the range of castes
	* @param end the upper bound of the range of castes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching castes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.Caste> findByReligionId(
		long religionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first caste in the ordered set where religionId = &#63;.
	*
	* @param religionId the religion ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching caste
	* @throws com.matrimony.NoSuchCasteException if a matching caste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Caste findByReligionId_First(long religionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchCasteException;

	/**
	* Returns the first caste in the ordered set where religionId = &#63;.
	*
	* @param religionId the religion ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching caste, or <code>null</code> if a matching caste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Caste fetchByReligionId_First(long religionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last caste in the ordered set where religionId = &#63;.
	*
	* @param religionId the religion ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching caste
	* @throws com.matrimony.NoSuchCasteException if a matching caste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Caste findByReligionId_Last(long religionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchCasteException;

	/**
	* Returns the last caste in the ordered set where religionId = &#63;.
	*
	* @param religionId the religion ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching caste, or <code>null</code> if a matching caste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Caste fetchByReligionId_Last(long religionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the castes before and after the current caste in the ordered set where religionId = &#63;.
	*
	* @param casteId the primary key of the current caste
	* @param religionId the religion ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next caste
	* @throws com.matrimony.NoSuchCasteException if a caste with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Caste[] findByReligionId_PrevAndNext(
		long casteId, long religionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchCasteException;

	/**
	* Returns the caste where religionId = &#63; and name = &#63; or throws a {@link com.matrimony.NoSuchCasteException} if it could not be found.
	*
	* @param religionId the religion ID
	* @param name the name
	* @return the matching caste
	* @throws com.matrimony.NoSuchCasteException if a matching caste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Caste findByReligionIdAndName(long religionId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchCasteException;

	/**
	* Returns the caste where religionId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param religionId the religion ID
	* @param name the name
	* @return the matching caste, or <code>null</code> if a matching caste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Caste fetchByReligionIdAndName(long religionId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the caste where religionId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param religionId the religion ID
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching caste, or <code>null</code> if a matching caste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Caste fetchByReligionIdAndName(long religionId,
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the castes.
	*
	* @return the castes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.Caste> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the castes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of castes
	* @param end the upper bound of the range of castes (not inclusive)
	* @return the range of castes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.Caste> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the castes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of castes
	* @param end the upper bound of the range of castes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of castes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.Caste> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the castes where religionId = &#63; from the database.
	*
	* @param religionId the religion ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByReligionId(long religionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the caste where religionId = &#63; and name = &#63; from the database.
	*
	* @param religionId the religion ID
	* @param name the name
	* @return the caste that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Caste removeByReligionIdAndName(
		long religionId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchCasteException;

	/**
	* Removes all the castes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of castes where religionId = &#63;.
	*
	* @param religionId the religion ID
	* @return the number of matching castes
	* @throws SystemException if a system exception occurred
	*/
	public int countByReligionId(long religionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of castes where religionId = &#63; and name = &#63;.
	*
	* @param religionId the religion ID
	* @param name the name
	* @return the number of matching castes
	* @throws SystemException if a system exception occurred
	*/
	public int countByReligionIdAndName(long religionId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of castes.
	*
	* @return the number of castes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}