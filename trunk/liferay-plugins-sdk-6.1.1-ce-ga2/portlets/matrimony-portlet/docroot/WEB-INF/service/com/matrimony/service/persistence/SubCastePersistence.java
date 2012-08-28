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

import com.matrimony.model.SubCaste;

/**
 * The persistence interface for the sub caste service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author matrimony
 * @see SubCastePersistenceImpl
 * @see SubCasteUtil
 * @generated
 */
public interface SubCastePersistence extends BasePersistence<SubCaste> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SubCasteUtil} to access the sub caste persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the sub caste in the entity cache if it is enabled.
	*
	* @param subCaste the sub caste
	*/
	public void cacheResult(com.matrimony.model.SubCaste subCaste);

	/**
	* Caches the sub castes in the entity cache if it is enabled.
	*
	* @param subCastes the sub castes
	*/
	public void cacheResult(
		java.util.List<com.matrimony.model.SubCaste> subCastes);

	/**
	* Creates a new sub caste with the primary key. Does not add the sub caste to the database.
	*
	* @param subCasteId the primary key for the new sub caste
	* @return the new sub caste
	*/
	public com.matrimony.model.SubCaste create(long subCasteId);

	/**
	* Removes the sub caste with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param subCasteId the primary key of the sub caste
	* @return the sub caste that was removed
	* @throws com.matrimony.NoSuchSubCasteException if a sub caste with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.SubCaste remove(long subCasteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchSubCasteException;

	public com.matrimony.model.SubCaste updateImpl(
		com.matrimony.model.SubCaste subCaste, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sub caste with the primary key or throws a {@link com.matrimony.NoSuchSubCasteException} if it could not be found.
	*
	* @param subCasteId the primary key of the sub caste
	* @return the sub caste
	* @throws com.matrimony.NoSuchSubCasteException if a sub caste with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.SubCaste findByPrimaryKey(long subCasteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchSubCasteException;

	/**
	* Returns the sub caste with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param subCasteId the primary key of the sub caste
	* @return the sub caste, or <code>null</code> if a sub caste with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.SubCaste fetchByPrimaryKey(long subCasteId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the sub castes where casteId = &#63;.
	*
	* @param casteId the caste ID
	* @return the matching sub castes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.SubCaste> findByCasteId(
		long casteId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the sub castes where casteId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param casteId the caste ID
	* @param start the lower bound of the range of sub castes
	* @param end the upper bound of the range of sub castes (not inclusive)
	* @return the range of matching sub castes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.SubCaste> findByCasteId(
		long casteId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the sub castes where casteId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param casteId the caste ID
	* @param start the lower bound of the range of sub castes
	* @param end the upper bound of the range of sub castes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sub castes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.SubCaste> findByCasteId(
		long casteId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first sub caste in the ordered set where casteId = &#63;.
	*
	* @param casteId the caste ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sub caste
	* @throws com.matrimony.NoSuchSubCasteException if a matching sub caste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.SubCaste findByCasteId_First(long casteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchSubCasteException;

	/**
	* Returns the first sub caste in the ordered set where casteId = &#63;.
	*
	* @param casteId the caste ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sub caste, or <code>null</code> if a matching sub caste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.SubCaste fetchByCasteId_First(long casteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last sub caste in the ordered set where casteId = &#63;.
	*
	* @param casteId the caste ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sub caste
	* @throws com.matrimony.NoSuchSubCasteException if a matching sub caste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.SubCaste findByCasteId_Last(long casteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchSubCasteException;

	/**
	* Returns the last sub caste in the ordered set where casteId = &#63;.
	*
	* @param casteId the caste ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sub caste, or <code>null</code> if a matching sub caste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.SubCaste fetchByCasteId_Last(long casteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sub castes before and after the current sub caste in the ordered set where casteId = &#63;.
	*
	* @param subCasteId the primary key of the current sub caste
	* @param casteId the caste ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sub caste
	* @throws com.matrimony.NoSuchSubCasteException if a sub caste with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.SubCaste[] findByCasteId_PrevAndNext(
		long subCasteId, long casteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchSubCasteException;

	/**
	* Returns the sub caste where casteId = &#63; and name = &#63; or throws a {@link com.matrimony.NoSuchSubCasteException} if it could not be found.
	*
	* @param casteId the caste ID
	* @param name the name
	* @return the matching sub caste
	* @throws com.matrimony.NoSuchSubCasteException if a matching sub caste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.SubCaste findByCasteIdAndName(long casteId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchSubCasteException;

	/**
	* Returns the sub caste where casteId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param casteId the caste ID
	* @param name the name
	* @return the matching sub caste, or <code>null</code> if a matching sub caste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.SubCaste fetchByCasteIdAndName(long casteId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sub caste where casteId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param casteId the caste ID
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching sub caste, or <code>null</code> if a matching sub caste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.SubCaste fetchByCasteIdAndName(long casteId,
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the sub castes.
	*
	* @return the sub castes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.SubCaste> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the sub castes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of sub castes
	* @param end the upper bound of the range of sub castes (not inclusive)
	* @return the range of sub castes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.SubCaste> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the sub castes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of sub castes
	* @param end the upper bound of the range of sub castes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of sub castes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.SubCaste> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the sub castes where casteId = &#63; from the database.
	*
	* @param casteId the caste ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCasteId(long casteId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the sub caste where casteId = &#63; and name = &#63; from the database.
	*
	* @param casteId the caste ID
	* @param name the name
	* @return the sub caste that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.SubCaste removeByCasteIdAndName(long casteId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchSubCasteException;

	/**
	* Removes all the sub castes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of sub castes where casteId = &#63;.
	*
	* @param casteId the caste ID
	* @return the number of matching sub castes
	* @throws SystemException if a system exception occurred
	*/
	public int countByCasteId(long casteId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of sub castes where casteId = &#63; and name = &#63;.
	*
	* @param casteId the caste ID
	* @param name the name
	* @return the number of matching sub castes
	* @throws SystemException if a system exception occurred
	*/
	public int countByCasteIdAndName(long casteId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of sub castes.
	*
	* @return the number of sub castes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}