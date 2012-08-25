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

import com.matrimony.model.Caste;

import java.util.List;

/**
 * The persistence utility for the caste service. This utility wraps {@link CastePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author matrimony
 * @see CastePersistence
 * @see CastePersistenceImpl
 * @generated
 */
public class CasteUtil {
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
	public static void clearCache(Caste caste) {
		getPersistence().clearCache(caste);
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
	public static List<Caste> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Caste> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Caste> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Caste update(Caste caste, boolean merge)
		throws SystemException {
		return getPersistence().update(caste, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Caste update(Caste caste, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(caste, merge, serviceContext);
	}

	/**
	* Caches the caste in the entity cache if it is enabled.
	*
	* @param caste the caste
	*/
	public static void cacheResult(com.matrimony.model.Caste caste) {
		getPersistence().cacheResult(caste);
	}

	/**
	* Caches the castes in the entity cache if it is enabled.
	*
	* @param castes the castes
	*/
	public static void cacheResult(
		java.util.List<com.matrimony.model.Caste> castes) {
		getPersistence().cacheResult(castes);
	}

	/**
	* Creates a new caste with the primary key. Does not add the caste to the database.
	*
	* @param casteId the primary key for the new caste
	* @return the new caste
	*/
	public static com.matrimony.model.Caste create(long casteId) {
		return getPersistence().create(casteId);
	}

	/**
	* Removes the caste with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param casteId the primary key of the caste
	* @return the caste that was removed
	* @throws com.matrimony.NoSuchCasteException if a caste with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Caste remove(long casteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchCasteException {
		return getPersistence().remove(casteId);
	}

	public static com.matrimony.model.Caste updateImpl(
		com.matrimony.model.Caste caste, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(caste, merge);
	}

	/**
	* Returns the caste with the primary key or throws a {@link com.matrimony.NoSuchCasteException} if it could not be found.
	*
	* @param casteId the primary key of the caste
	* @return the caste
	* @throws com.matrimony.NoSuchCasteException if a caste with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Caste findByPrimaryKey(long casteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchCasteException {
		return getPersistence().findByPrimaryKey(casteId);
	}

	/**
	* Returns the caste with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param casteId the primary key of the caste
	* @return the caste, or <code>null</code> if a caste with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Caste fetchByPrimaryKey(long casteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(casteId);
	}

	/**
	* Returns all the castes where religionId = &#63;.
	*
	* @param religionId the religion ID
	* @return the matching castes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.Caste> findByReligionId(
		long religionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByReligionId(religionId);
	}

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
	public static java.util.List<com.matrimony.model.Caste> findByReligionId(
		long religionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByReligionId(religionId, start, end);
	}

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
	public static java.util.List<com.matrimony.model.Caste> findByReligionId(
		long religionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReligionId(religionId, start, end, orderByComparator);
	}

	/**
	* Returns the first caste in the ordered set where religionId = &#63;.
	*
	* @param religionId the religion ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching caste
	* @throws com.matrimony.NoSuchCasteException if a matching caste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Caste findByReligionId_First(
		long religionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchCasteException {
		return getPersistence()
				   .findByReligionId_First(religionId, orderByComparator);
	}

	/**
	* Returns the first caste in the ordered set where religionId = &#63;.
	*
	* @param religionId the religion ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching caste, or <code>null</code> if a matching caste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Caste fetchByReligionId_First(
		long religionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByReligionId_First(religionId, orderByComparator);
	}

	/**
	* Returns the last caste in the ordered set where religionId = &#63;.
	*
	* @param religionId the religion ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching caste
	* @throws com.matrimony.NoSuchCasteException if a matching caste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Caste findByReligionId_Last(
		long religionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchCasteException {
		return getPersistence()
				   .findByReligionId_Last(religionId, orderByComparator);
	}

	/**
	* Returns the last caste in the ordered set where religionId = &#63;.
	*
	* @param religionId the religion ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching caste, or <code>null</code> if a matching caste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Caste fetchByReligionId_Last(
		long religionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByReligionId_Last(religionId, orderByComparator);
	}

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
	public static com.matrimony.model.Caste[] findByReligionId_PrevAndNext(
		long casteId, long religionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchCasteException {
		return getPersistence()
				   .findByReligionId_PrevAndNext(casteId, religionId,
			orderByComparator);
	}

	/**
	* Returns all the castes.
	*
	* @return the castes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.Caste> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.matrimony.model.Caste> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.matrimony.model.Caste> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the castes where religionId = &#63; from the database.
	*
	* @param religionId the religion ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByReligionId(long religionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByReligionId(religionId);
	}

	/**
	* Removes all the castes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of castes where religionId = &#63;.
	*
	* @param religionId the religion ID
	* @return the number of matching castes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByReligionId(long religionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByReligionId(religionId);
	}

	/**
	* Returns the number of castes.
	*
	* @return the number of castes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CastePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CastePersistence)PortletBeanLocatorUtil.locate(com.matrimony.service.ClpSerializer.getServletContextName(),
					CastePersistence.class.getName());

			ReferenceRegistry.registerReference(CasteUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(CastePersistence persistence) {
	}

	private static CastePersistence _persistence;
}