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
 * This class is a wrapper for {@link ReligionLocalService}.
 * </p>
 *
 * @author    matrimony
 * @see       ReligionLocalService
 * @generated
 */
public class ReligionLocalServiceWrapper implements ReligionLocalService,
	ServiceWrapper<ReligionLocalService> {
	public ReligionLocalServiceWrapper(
		ReligionLocalService religionLocalService) {
		_religionLocalService = religionLocalService;
	}

	/**
	* Adds the religion to the database. Also notifies the appropriate model listeners.
	*
	* @param religion the religion
	* @return the religion that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Religion addReligion(
		com.matrimony.model.Religion religion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _religionLocalService.addReligion(religion);
	}

	/**
	* Creates a new religion with the primary key. Does not add the religion to the database.
	*
	* @param religionId the primary key for the new religion
	* @return the new religion
	*/
	public com.matrimony.model.Religion createReligion(long religionId) {
		return _religionLocalService.createReligion(religionId);
	}

	/**
	* Deletes the religion with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param religionId the primary key of the religion
	* @return the religion that was removed
	* @throws PortalException if a religion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Religion deleteReligion(long religionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _religionLocalService.deleteReligion(religionId);
	}

	/**
	* Deletes the religion from the database. Also notifies the appropriate model listeners.
	*
	* @param religion the religion
	* @return the religion that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Religion deleteReligion(
		com.matrimony.model.Religion religion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _religionLocalService.deleteReligion(religion);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _religionLocalService.dynamicQuery();
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
		return _religionLocalService.dynamicQuery(dynamicQuery);
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
		return _religionLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _religionLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _religionLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.matrimony.model.Religion fetchReligion(long religionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _religionLocalService.fetchReligion(religionId);
	}

	/**
	* Returns the religion with the primary key.
	*
	* @param religionId the primary key of the religion
	* @return the religion
	* @throws PortalException if a religion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Religion getReligion(long religionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _religionLocalService.getReligion(religionId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _religionLocalService.getPersistedModel(primaryKeyObj);
	}

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
	public java.util.List<com.matrimony.model.Religion> getReligions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _religionLocalService.getReligions(start, end);
	}

	/**
	* Returns the number of religions.
	*
	* @return the number of religions
	* @throws SystemException if a system exception occurred
	*/
	public int getReligionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _religionLocalService.getReligionsCount();
	}

	/**
	* Updates the religion in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param religion the religion
	* @return the religion that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Religion updateReligion(
		com.matrimony.model.Religion religion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _religionLocalService.updateReligion(religion);
	}

	/**
	* Updates the religion in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param religion the religion
	* @param merge whether to merge the religion with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the religion that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Religion updateReligion(
		com.matrimony.model.Religion religion, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _religionLocalService.updateReligion(religion, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _religionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_religionLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _religionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ReligionLocalService getWrappedReligionLocalService() {
		return _religionLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedReligionLocalService(
		ReligionLocalService religionLocalService) {
		_religionLocalService = religionLocalService;
	}

	public ReligionLocalService getWrappedService() {
		return _religionLocalService;
	}

	public void setWrappedService(ReligionLocalService religionLocalService) {
		_religionLocalService = religionLocalService;
	}

	private ReligionLocalService _religionLocalService;
}