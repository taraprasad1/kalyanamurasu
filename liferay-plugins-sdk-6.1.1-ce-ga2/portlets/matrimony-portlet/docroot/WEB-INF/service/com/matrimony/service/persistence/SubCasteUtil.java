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

import com.matrimony.model.SubCaste;

import java.util.List;

/**
 * The persistence utility for the sub caste service. This utility wraps {@link SubCastePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author matrimony
 * @see SubCastePersistence
 * @see SubCastePersistenceImpl
 * @generated
 */
public class SubCasteUtil {
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
	public static void clearCache(SubCaste subCaste) {
		getPersistence().clearCache(subCaste);
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
	public static List<SubCaste> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SubCaste> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SubCaste> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static SubCaste update(SubCaste subCaste, boolean merge)
		throws SystemException {
		return getPersistence().update(subCaste, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static SubCaste update(SubCaste subCaste, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(subCaste, merge, serviceContext);
	}

	/**
	* Caches the sub caste in the entity cache if it is enabled.
	*
	* @param subCaste the sub caste
	*/
	public static void cacheResult(com.matrimony.model.SubCaste subCaste) {
		getPersistence().cacheResult(subCaste);
	}

	/**
	* Caches the sub castes in the entity cache if it is enabled.
	*
	* @param subCastes the sub castes
	*/
	public static void cacheResult(
		java.util.List<com.matrimony.model.SubCaste> subCastes) {
		getPersistence().cacheResult(subCastes);
	}

	/**
	* Creates a new sub caste with the primary key. Does not add the sub caste to the database.
	*
	* @param subCasteId the primary key for the new sub caste
	* @return the new sub caste
	*/
	public static com.matrimony.model.SubCaste create(long subCasteId) {
		return getPersistence().create(subCasteId);
	}

	/**
	* Removes the sub caste with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param subCasteId the primary key of the sub caste
	* @return the sub caste that was removed
	* @throws com.matrimony.NoSuchSubCasteException if a sub caste with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.SubCaste remove(long subCasteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchSubCasteException {
		return getPersistence().remove(subCasteId);
	}

	public static com.matrimony.model.SubCaste updateImpl(
		com.matrimony.model.SubCaste subCaste, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(subCaste, merge);
	}

	/**
	* Returns the sub caste with the primary key or throws a {@link com.matrimony.NoSuchSubCasteException} if it could not be found.
	*
	* @param subCasteId the primary key of the sub caste
	* @return the sub caste
	* @throws com.matrimony.NoSuchSubCasteException if a sub caste with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.SubCaste findByPrimaryKey(long subCasteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchSubCasteException {
		return getPersistence().findByPrimaryKey(subCasteId);
	}

	/**
	* Returns the sub caste with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param subCasteId the primary key of the sub caste
	* @return the sub caste, or <code>null</code> if a sub caste with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.SubCaste fetchByPrimaryKey(
		long subCasteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(subCasteId);
	}

	/**
	* Returns all the sub castes where casteId = &#63;.
	*
	* @param casteId the caste ID
	* @return the matching sub castes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.SubCaste> findByCasteId(
		long casteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCasteId(casteId);
	}

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
	public static java.util.List<com.matrimony.model.SubCaste> findByCasteId(
		long casteId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCasteId(casteId, start, end);
	}

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
	public static java.util.List<com.matrimony.model.SubCaste> findByCasteId(
		long casteId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCasteId(casteId, start, end, orderByComparator);
	}

	/**
	* Returns the first sub caste in the ordered set where casteId = &#63;.
	*
	* @param casteId the caste ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sub caste
	* @throws com.matrimony.NoSuchSubCasteException if a matching sub caste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.SubCaste findByCasteId_First(
		long casteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchSubCasteException {
		return getPersistence().findByCasteId_First(casteId, orderByComparator);
	}

	/**
	* Returns the first sub caste in the ordered set where casteId = &#63;.
	*
	* @param casteId the caste ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sub caste, or <code>null</code> if a matching sub caste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.SubCaste fetchByCasteId_First(
		long casteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCasteId_First(casteId, orderByComparator);
	}

	/**
	* Returns the last sub caste in the ordered set where casteId = &#63;.
	*
	* @param casteId the caste ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sub caste
	* @throws com.matrimony.NoSuchSubCasteException if a matching sub caste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.SubCaste findByCasteId_Last(
		long casteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchSubCasteException {
		return getPersistence().findByCasteId_Last(casteId, orderByComparator);
	}

	/**
	* Returns the last sub caste in the ordered set where casteId = &#63;.
	*
	* @param casteId the caste ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sub caste, or <code>null</code> if a matching sub caste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.SubCaste fetchByCasteId_Last(
		long casteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCasteId_Last(casteId, orderByComparator);
	}

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
	public static com.matrimony.model.SubCaste[] findByCasteId_PrevAndNext(
		long subCasteId, long casteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchSubCasteException {
		return getPersistence()
				   .findByCasteId_PrevAndNext(subCasteId, casteId,
			orderByComparator);
	}

	/**
	* Returns all the sub castes.
	*
	* @return the sub castes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.SubCaste> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.matrimony.model.SubCaste> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.matrimony.model.SubCaste> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the sub castes where casteId = &#63; from the database.
	*
	* @param casteId the caste ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCasteId(long casteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCasteId(casteId);
	}

	/**
	* Removes all the sub castes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of sub castes where casteId = &#63;.
	*
	* @param casteId the caste ID
	* @return the number of matching sub castes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCasteId(long casteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCasteId(casteId);
	}

	/**
	* Returns the number of sub castes.
	*
	* @return the number of sub castes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SubCastePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SubCastePersistence)PortletBeanLocatorUtil.locate(com.matrimony.service.ClpSerializer.getServletContextName(),
					SubCastePersistence.class.getName());

			ReferenceRegistry.registerReference(SubCasteUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(SubCastePersistence persistence) {
	}

	private static SubCastePersistence _persistence;
}