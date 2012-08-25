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

import com.matrimony.model.Religion;

/**
 * The persistence interface for the religion service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author matrimony
 * @see ReligionPersistenceImpl
 * @see ReligionUtil
 * @generated
 */
public interface ReligionPersistence extends BasePersistence<Religion> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ReligionUtil} to access the religion persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the religion in the entity cache if it is enabled.
	*
	* @param religion the religion
	*/
	public void cacheResult(com.matrimony.model.Religion religion);

	/**
	* Caches the religions in the entity cache if it is enabled.
	*
	* @param religions the religions
	*/
	public void cacheResult(
		java.util.List<com.matrimony.model.Religion> religions);

	/**
	* Creates a new religion with the primary key. Does not add the religion to the database.
	*
	* @param religionId the primary key for the new religion
	* @return the new religion
	*/
	public com.matrimony.model.Religion create(long religionId);

	/**
	* Removes the religion with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param religionId the primary key of the religion
	* @return the religion that was removed
	* @throws com.matrimony.NoSuchReligionException if a religion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Religion remove(long religionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchReligionException;

	public com.matrimony.model.Religion updateImpl(
		com.matrimony.model.Religion religion, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the religion with the primary key or throws a {@link com.matrimony.NoSuchReligionException} if it could not be found.
	*
	* @param religionId the primary key of the religion
	* @return the religion
	* @throws com.matrimony.NoSuchReligionException if a religion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Religion findByPrimaryKey(long religionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchReligionException;

	/**
	* Returns the religion with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param religionId the primary key of the religion
	* @return the religion, or <code>null</code> if a religion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Religion fetchByPrimaryKey(long religionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the religions.
	*
	* @return the religions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.Religion> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the religions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of religions
	* @param end the upper bound of the range of religions (not inclusive)
	* @return the range of religions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.Religion> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the religions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of religions
	* @param end the upper bound of the range of religions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of religions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.Religion> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the religions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of religions.
	*
	* @return the number of religions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}