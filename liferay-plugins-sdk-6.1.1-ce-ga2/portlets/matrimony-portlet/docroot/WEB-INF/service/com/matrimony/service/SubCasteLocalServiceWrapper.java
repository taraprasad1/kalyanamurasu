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
 * This class is a wrapper for {@link SubCasteLocalService}.
 * </p>
 *
 * @author    matrimony
 * @see       SubCasteLocalService
 * @generated
 */
public class SubCasteLocalServiceWrapper implements SubCasteLocalService,
	ServiceWrapper<SubCasteLocalService> {
	public SubCasteLocalServiceWrapper(
		SubCasteLocalService subCasteLocalService) {
		_subCasteLocalService = subCasteLocalService;
	}

	/**
	* Adds the sub caste to the database. Also notifies the appropriate model listeners.
	*
	* @param subCaste the sub caste
	* @return the sub caste that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.SubCaste addSubCaste(
		com.matrimony.model.SubCaste subCaste)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subCasteLocalService.addSubCaste(subCaste);
	}

	/**
	* Creates a new sub caste with the primary key. Does not add the sub caste to the database.
	*
	* @param subCasteId the primary key for the new sub caste
	* @return the new sub caste
	*/
	public com.matrimony.model.SubCaste createSubCaste(long subCasteId) {
		return _subCasteLocalService.createSubCaste(subCasteId);
	}

	/**
	* Deletes the sub caste with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param subCasteId the primary key of the sub caste
	* @return the sub caste that was removed
	* @throws PortalException if a sub caste with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.SubCaste deleteSubCaste(long subCasteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _subCasteLocalService.deleteSubCaste(subCasteId);
	}

	/**
	* Deletes the sub caste from the database. Also notifies the appropriate model listeners.
	*
	* @param subCaste the sub caste
	* @return the sub caste that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.SubCaste deleteSubCaste(
		com.matrimony.model.SubCaste subCaste)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subCasteLocalService.deleteSubCaste(subCaste);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _subCasteLocalService.dynamicQuery();
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
		return _subCasteLocalService.dynamicQuery(dynamicQuery);
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
		return _subCasteLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _subCasteLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _subCasteLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.matrimony.model.SubCaste fetchSubCaste(long subCasteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subCasteLocalService.fetchSubCaste(subCasteId);
	}

	/**
	* Returns the sub caste with the primary key.
	*
	* @param subCasteId the primary key of the sub caste
	* @return the sub caste
	* @throws PortalException if a sub caste with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.SubCaste getSubCaste(long subCasteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _subCasteLocalService.getSubCaste(subCasteId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _subCasteLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.matrimony.model.SubCaste> getSubCastes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subCasteLocalService.getSubCastes(start, end);
	}

	/**
	* Returns the number of sub castes.
	*
	* @return the number of sub castes
	* @throws SystemException if a system exception occurred
	*/
	public int getSubCastesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subCasteLocalService.getSubCastesCount();
	}

	/**
	* Updates the sub caste in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param subCaste the sub caste
	* @return the sub caste that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.SubCaste updateSubCaste(
		com.matrimony.model.SubCaste subCaste)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subCasteLocalService.updateSubCaste(subCaste);
	}

	/**
	* Updates the sub caste in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param subCaste the sub caste
	* @param merge whether to merge the sub caste with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the sub caste that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.SubCaste updateSubCaste(
		com.matrimony.model.SubCaste subCaste, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subCasteLocalService.updateSubCaste(subCaste, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _subCasteLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_subCasteLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _subCasteLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public java.util.List<com.matrimony.model.SubCaste> getSubCasteListByCasteId(
		long casteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subCasteLocalService.getSubCasteListByCasteId(casteId);
	}

	public com.matrimony.model.SubCaste getSubCasteByCasteIdAndName(
		long casteId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchSubCasteException {
		return _subCasteLocalService.getSubCasteByCasteIdAndName(casteId, name);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public SubCasteLocalService getWrappedSubCasteLocalService() {
		return _subCasteLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedSubCasteLocalService(
		SubCasteLocalService subCasteLocalService) {
		_subCasteLocalService = subCasteLocalService;
	}

	public SubCasteLocalService getWrappedService() {
		return _subCasteLocalService;
	}

	public void setWrappedService(SubCasteLocalService subCasteLocalService) {
		_subCasteLocalService = subCasteLocalService;
	}

	private SubCasteLocalService _subCasteLocalService;
}