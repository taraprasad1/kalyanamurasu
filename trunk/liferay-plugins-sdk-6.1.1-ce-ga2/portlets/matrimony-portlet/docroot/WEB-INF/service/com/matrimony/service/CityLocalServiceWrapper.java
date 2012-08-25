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

package com.matrimony.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link CityLocalService}.
 * </p>
 *
 * @author    matrimony
 * @see       CityLocalService
 * @generated
 */
public class CityLocalServiceWrapper implements CityLocalService,
	ServiceWrapper<CityLocalService> {
	public CityLocalServiceWrapper(CityLocalService cityLocalService) {
		_cityLocalService = cityLocalService;
	}

	/**
	* Adds the city to the database. Also notifies the appropriate model listeners.
	*
	* @param city the city
	* @return the city that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.City addCity(com.matrimony.model.City city)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityLocalService.addCity(city);
	}

	/**
	* Creates a new city with the primary key. Does not add the city to the database.
	*
	* @param cityId the primary key for the new city
	* @return the new city
	*/
	public com.matrimony.model.City createCity(long cityId) {
		return _cityLocalService.createCity(cityId);
	}

	/**
	* Deletes the city with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cityId the primary key of the city
	* @return the city that was removed
	* @throws PortalException if a city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.City deleteCity(long cityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cityLocalService.deleteCity(cityId);
	}

	/**
	* Deletes the city from the database. Also notifies the appropriate model listeners.
	*
	* @param city the city
	* @return the city that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.City deleteCity(com.matrimony.model.City city)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityLocalService.deleteCity(city);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cityLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _cityLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.matrimony.model.City fetchCity(long cityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityLocalService.fetchCity(cityId);
	}

	/**
	* Returns the city with the primary key.
	*
	* @param cityId the primary key of the city
	* @return the city
	* @throws PortalException if a city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.City getCity(long cityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cityLocalService.getCity(cityId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cityLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.matrimony.model.City> getCities(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityLocalService.getCities(start, end);
	}

	/**
	* Returns the number of cities.
	*
	* @return the number of cities
	* @throws SystemException if a system exception occurred
	*/
	public int getCitiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityLocalService.getCitiesCount();
	}

	/**
	* Updates the city in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param city the city
	* @return the city that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.City updateCity(com.matrimony.model.City city)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityLocalService.updateCity(city);
	}

	/**
	* Updates the city in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param city the city
	* @param merge whether to merge the city with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the city that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.City updateCity(com.matrimony.model.City city,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityLocalService.updateCity(city, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _cityLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_cityLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _cityLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	public com.matrimony.model.City getCityByRegionId_CityName(long regionId,
		java.lang.String cityName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityLocalService.getCityByRegionId_CityName(regionId, cityName);
	}

	public java.util.List<com.matrimony.model.City> getRegion_Cities(
		long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityLocalService.getRegion_Cities(regionId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CityLocalService getWrappedCityLocalService() {
		return _cityLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCityLocalService(CityLocalService cityLocalService) {
		_cityLocalService = cityLocalService;
	}

	public CityLocalService getWrappedService() {
		return _cityLocalService;
	}

	public void setWrappedService(CityLocalService cityLocalService) {
		_cityLocalService = cityLocalService;
	}

	private CityLocalService _cityLocalService;
}