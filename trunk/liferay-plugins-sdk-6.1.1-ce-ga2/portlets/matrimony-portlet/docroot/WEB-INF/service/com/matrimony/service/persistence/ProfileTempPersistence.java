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

import com.matrimony.model.ProfileTemp;

/**
 * The persistence interface for the profile temp service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author matrimony
 * @see ProfileTempPersistenceImpl
 * @see ProfileTempUtil
 * @generated
 */
public interface ProfileTempPersistence extends BasePersistence<ProfileTemp> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProfileTempUtil} to access the profile temp persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the profile temp in the entity cache if it is enabled.
	*
	* @param profileTemp the profile temp
	*/
	public void cacheResult(com.matrimony.model.ProfileTemp profileTemp);

	/**
	* Caches the profile temps in the entity cache if it is enabled.
	*
	* @param profileTemps the profile temps
	*/
	public void cacheResult(
		java.util.List<com.matrimony.model.ProfileTemp> profileTemps);

	/**
	* Creates a new profile temp with the primary key. Does not add the profile temp to the database.
	*
	* @param profileTempId the primary key for the new profile temp
	* @return the new profile temp
	*/
	public com.matrimony.model.ProfileTemp create(long profileTempId);

	/**
	* Removes the profile temp with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param profileTempId the primary key of the profile temp
	* @return the profile temp that was removed
	* @throws com.matrimony.NoSuchProfileTempException if a profile temp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.ProfileTemp remove(long profileTempId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileTempException;

	public com.matrimony.model.ProfileTemp updateImpl(
		com.matrimony.model.ProfileTemp profileTemp, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the profile temp with the primary key or throws a {@link com.matrimony.NoSuchProfileTempException} if it could not be found.
	*
	* @param profileTempId the primary key of the profile temp
	* @return the profile temp
	* @throws com.matrimony.NoSuchProfileTempException if a profile temp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.ProfileTemp findByPrimaryKey(long profileTempId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchProfileTempException;

	/**
	* Returns the profile temp with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param profileTempId the primary key of the profile temp
	* @return the profile temp, or <code>null</code> if a profile temp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.ProfileTemp fetchByPrimaryKey(long profileTempId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the profile temps.
	*
	* @return the profile temps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.ProfileTemp> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the profile temps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of profile temps
	* @param end the upper bound of the range of profile temps (not inclusive)
	* @return the range of profile temps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.ProfileTemp> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the profile temps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of profile temps
	* @param end the upper bound of the range of profile temps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of profile temps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.ProfileTemp> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the profile temps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of profile temps.
	*
	* @return the number of profile temps
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}