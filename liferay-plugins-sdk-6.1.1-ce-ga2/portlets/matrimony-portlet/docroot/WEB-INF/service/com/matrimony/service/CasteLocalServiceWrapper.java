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
 * This class is a wrapper for {@link CasteLocalService}.
 * </p>
 *
 * @author    matrimony
 * @see       CasteLocalService
 * @generated
 */
public class CasteLocalServiceWrapper implements CasteLocalService,
	ServiceWrapper<CasteLocalService> {
	public CasteLocalServiceWrapper(CasteLocalService casteLocalService) {
		_casteLocalService = casteLocalService;
	}

	/**
	* Adds the caste to the database. Also notifies the appropriate model listeners.
	*
	* @param caste the caste
	* @return the caste that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Caste addCaste(com.matrimony.model.Caste caste)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _casteLocalService.addCaste(caste);
	}

	/**
	* Creates a new caste with the primary key. Does not add the caste to the database.
	*
	* @param casteId the primary key for the new caste
	* @return the new caste
	*/
	public com.matrimony.model.Caste createCaste(long casteId) {
		return _casteLocalService.createCaste(casteId);
	}

	/**
	* Deletes the caste with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param casteId the primary key of the caste
	* @return the caste that was removed
	* @throws PortalException if a caste with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Caste deleteCaste(long casteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _casteLocalService.deleteCaste(casteId);
	}

	/**
	* Deletes the caste from the database. Also notifies the appropriate model listeners.
	*
	* @param caste the caste
	* @return the caste that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Caste deleteCaste(
		com.matrimony.model.Caste caste)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _casteLocalService.deleteCaste(caste);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _casteLocalService.dynamicQuery();
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
		return _casteLocalService.dynamicQuery(dynamicQuery);
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
		return _casteLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _casteLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _casteLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.matrimony.model.Caste fetchCaste(long casteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _casteLocalService.fetchCaste(casteId);
	}

	/**
	* Returns the caste with the primary key.
	*
	* @param casteId the primary key of the caste
	* @return the caste
	* @throws PortalException if a caste with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Caste getCaste(long casteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _casteLocalService.getCaste(casteId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _casteLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.matrimony.model.Caste> getCastes(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _casteLocalService.getCastes(start, end);
	}

	/**
	* Returns the number of castes.
	*
	* @return the number of castes
	* @throws SystemException if a system exception occurred
	*/
	public int getCastesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _casteLocalService.getCastesCount();
	}

	/**
	* Updates the caste in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param caste the caste
	* @return the caste that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Caste updateCaste(
		com.matrimony.model.Caste caste)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _casteLocalService.updateCaste(caste);
	}

	/**
	* Updates the caste in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param caste the caste
	* @param merge whether to merge the caste with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the caste that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Caste updateCaste(
		com.matrimony.model.Caste caste, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _casteLocalService.updateCaste(caste, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _casteLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_casteLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _casteLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	public java.util.List<com.matrimony.model.Caste> getCasteListByReligionId(
		long religionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _casteLocalService.getCasteListByReligionId(religionId);
	}

	public com.matrimony.model.Caste getCasteByReligionIdAndName(
		long religionId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchCasteException {
		return _casteLocalService.getCasteByReligionIdAndName(religionId, name);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CasteLocalService getWrappedCasteLocalService() {
		return _casteLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCasteLocalService(CasteLocalService casteLocalService) {
		_casteLocalService = casteLocalService;
	}

	public CasteLocalService getWrappedService() {
		return _casteLocalService;
	}

	public void setWrappedService(CasteLocalService casteLocalService) {
		_casteLocalService = casteLocalService;
	}

	private CasteLocalService _casteLocalService;
}