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

import com.matrimony.model.City;

import java.util.List;

/**
 * The persistence utility for the city service. This utility wraps {@link CityPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author matrimony
 * @see CityPersistence
 * @see CityPersistenceImpl
 * @generated
 */
public class CityUtil {
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
	public static void clearCache(City city) {
		getPersistence().clearCache(city);
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
	public static List<City> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<City> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<City> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static City update(City city, boolean merge)
		throws SystemException {
		return getPersistence().update(city, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static City update(City city, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(city, merge, serviceContext);
	}

	/**
	* Caches the city in the entity cache if it is enabled.
	*
	* @param city the city
	*/
	public static void cacheResult(com.matrimony.model.City city) {
		getPersistence().cacheResult(city);
	}

	/**
	* Caches the cities in the entity cache if it is enabled.
	*
	* @param cities the cities
	*/
	public static void cacheResult(
		java.util.List<com.matrimony.model.City> cities) {
		getPersistence().cacheResult(cities);
	}

	/**
	* Creates a new city with the primary key. Does not add the city to the database.
	*
	* @param cityId the primary key for the new city
	* @return the new city
	*/
	public static com.matrimony.model.City create(long cityId) {
		return getPersistence().create(cityId);
	}

	/**
	* Removes the city with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cityId the primary key of the city
	* @return the city that was removed
	* @throws com.matrimony.NoSuchCityException if a city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.City remove(long cityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchCityException {
		return getPersistence().remove(cityId);
	}

	public static com.matrimony.model.City updateImpl(
		com.matrimony.model.City city, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(city, merge);
	}

	/**
	* Returns the city with the primary key or throws a {@link com.matrimony.NoSuchCityException} if it could not be found.
	*
	* @param cityId the primary key of the city
	* @return the city
	* @throws com.matrimony.NoSuchCityException if a city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.City findByPrimaryKey(long cityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchCityException {
		return getPersistence().findByPrimaryKey(cityId);
	}

	/**
	* Returns the city with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cityId the primary key of the city
	* @return the city, or <code>null</code> if a city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.City fetchByPrimaryKey(long cityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(cityId);
	}

	/**
	* Returns all the cities where regionId = &#63;.
	*
	* @param regionId the region ID
	* @return the matching cities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.City> findByRegionId(
		long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRegionId(regionId);
	}

	/**
	* Returns a range of all the cities where regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param regionId the region ID
	* @param start the lower bound of the range of cities
	* @param end the upper bound of the range of cities (not inclusive)
	* @return the range of matching cities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.City> findByRegionId(
		long regionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRegionId(regionId, start, end);
	}

	/**
	* Returns an ordered range of all the cities where regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param regionId the region ID
	* @param start the lower bound of the range of cities
	* @param end the upper bound of the range of cities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.City> findByRegionId(
		long regionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRegionId(regionId, start, end, orderByComparator);
	}

	/**
	* Returns the first city in the ordered set where regionId = &#63;.
	*
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching city
	* @throws com.matrimony.NoSuchCityException if a matching city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.City findByRegionId_First(long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchCityException {
		return getPersistence().findByRegionId_First(regionId, orderByComparator);
	}

	/**
	* Returns the first city in the ordered set where regionId = &#63;.
	*
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching city, or <code>null</code> if a matching city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.City fetchByRegionId_First(
		long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRegionId_First(regionId, orderByComparator);
	}

	/**
	* Returns the last city in the ordered set where regionId = &#63;.
	*
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching city
	* @throws com.matrimony.NoSuchCityException if a matching city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.City findByRegionId_Last(long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchCityException {
		return getPersistence().findByRegionId_Last(regionId, orderByComparator);
	}

	/**
	* Returns the last city in the ordered set where regionId = &#63;.
	*
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching city, or <code>null</code> if a matching city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.City fetchByRegionId_Last(long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByRegionId_Last(regionId, orderByComparator);
	}

	/**
	* Returns the cities before and after the current city in the ordered set where regionId = &#63;.
	*
	* @param cityId the primary key of the current city
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next city
	* @throws com.matrimony.NoSuchCityException if a city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.City[] findByRegionId_PrevAndNext(
		long cityId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchCityException {
		return getPersistence()
				   .findByRegionId_PrevAndNext(cityId, regionId,
			orderByComparator);
	}

	/**
	* Returns the city where regionId = &#63; and cityName = &#63; or throws a {@link com.matrimony.NoSuchCityException} if it could not be found.
	*
	* @param regionId the region ID
	* @param cityName the city name
	* @return the matching city
	* @throws com.matrimony.NoSuchCityException if a matching city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.City findByRegionId_City(long regionId,
		java.lang.String cityName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchCityException {
		return getPersistence().findByRegionId_City(regionId, cityName);
	}

	/**
	* Returns the city where regionId = &#63; and cityName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param regionId the region ID
	* @param cityName the city name
	* @return the matching city, or <code>null</code> if a matching city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.City fetchByRegionId_City(long regionId,
		java.lang.String cityName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByRegionId_City(regionId, cityName);
	}

	/**
	* Returns the city where regionId = &#63; and cityName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param regionId the region ID
	* @param cityName the city name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching city, or <code>null</code> if a matching city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.City fetchByRegionId_City(long regionId,
		java.lang.String cityName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRegionId_City(regionId, cityName, retrieveFromCache);
	}

	/**
	* Returns all the cities where status = &#63;.
	*
	* @param status the status
	* @return the matching cities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.City> findByStatus(
		boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status);
	}

	/**
	* Returns a range of all the cities where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of cities
	* @param end the upper bound of the range of cities (not inclusive)
	* @return the range of matching cities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.City> findByStatus(
		boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the cities where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of cities
	* @param end the upper bound of the range of cities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.City> findByStatus(
		boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the first city in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching city
	* @throws com.matrimony.NoSuchCityException if a matching city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.City findByStatus_First(boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchCityException {
		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the first city in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching city, or <code>null</code> if a matching city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.City fetchByStatus_First(boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the last city in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching city
	* @throws com.matrimony.NoSuchCityException if a matching city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.City findByStatus_Last(boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchCityException {
		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last city in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching city, or <code>null</code> if a matching city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.City fetchByStatus_Last(boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the cities before and after the current city in the ordered set where status = &#63;.
	*
	* @param cityId the primary key of the current city
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next city
	* @throws com.matrimony.NoSuchCityException if a city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.City[] findByStatus_PrevAndNext(
		long cityId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchCityException {
		return getPersistence()
				   .findByStatus_PrevAndNext(cityId, status, orderByComparator);
	}

	/**
	* Returns all the cities.
	*
	* @return the cities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.City> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the cities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cities
	* @param end the upper bound of the range of cities (not inclusive)
	* @return the range of cities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.City> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the cities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cities
	* @param end the upper bound of the range of cities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.City> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the cities where regionId = &#63; from the database.
	*
	* @param regionId the region ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByRegionId(long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByRegionId(regionId);
	}

	/**
	* Removes the city where regionId = &#63; and cityName = &#63; from the database.
	*
	* @param regionId the region ID
	* @param cityName the city name
	* @return the city that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.City removeByRegionId_City(
		long regionId, java.lang.String cityName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchCityException {
		return getPersistence().removeByRegionId_City(regionId, cityName);
	}

	/**
	* Removes all the cities where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatus(status);
	}

	/**
	* Removes all the cities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cities where regionId = &#63;.
	*
	* @param regionId the region ID
	* @return the number of matching cities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRegionId(long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRegionId(regionId);
	}

	/**
	* Returns the number of cities where regionId = &#63; and cityName = &#63;.
	*
	* @param regionId the region ID
	* @param cityName the city name
	* @return the number of matching cities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRegionId_City(long regionId,
		java.lang.String cityName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRegionId_City(regionId, cityName);
	}

	/**
	* Returns the number of cities where status = &#63;.
	*
	* @param status the status
	* @return the number of matching cities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(status);
	}

	/**
	* Returns the number of cities.
	*
	* @return the number of cities
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CityPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CityPersistence)PortletBeanLocatorUtil.locate(com.matrimony.service.ClpSerializer.getServletContextName(),
					CityPersistence.class.getName());

			ReferenceRegistry.registerReference(CityUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(CityPersistence persistence) {
	}

	private static CityPersistence _persistence;
}