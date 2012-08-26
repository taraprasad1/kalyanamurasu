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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the sub caste local service. This utility wraps {@link com.matrimony.service.impl.SubCasteLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author matrimony
 * @see SubCasteLocalService
 * @see com.matrimony.service.base.SubCasteLocalServiceBaseImpl
 * @see com.matrimony.service.impl.SubCasteLocalServiceImpl
 * @generated
 */
public class SubCasteLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.matrimony.service.impl.SubCasteLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the sub caste to the database. Also notifies the appropriate model listeners.
	*
	* @param subCaste the sub caste
	* @return the sub caste that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.SubCaste addSubCaste(
		com.matrimony.model.SubCaste subCaste)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSubCaste(subCaste);
	}

	/**
	* Creates a new sub caste with the primary key. Does not add the sub caste to the database.
	*
	* @param subCasteId the primary key for the new sub caste
	* @return the new sub caste
	*/
	public static com.matrimony.model.SubCaste createSubCaste(long subCasteId) {
		return getService().createSubCaste(subCasteId);
	}

	/**
	* Deletes the sub caste with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param subCasteId the primary key of the sub caste
	* @return the sub caste that was removed
	* @throws PortalException if a sub caste with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.SubCaste deleteSubCaste(long subCasteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSubCaste(subCasteId);
	}

	/**
	* Deletes the sub caste from the database. Also notifies the appropriate model listeners.
	*
	* @param subCaste the sub caste
	* @return the sub caste that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.SubCaste deleteSubCaste(
		com.matrimony.model.SubCaste subCaste)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSubCaste(subCaste);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.matrimony.model.SubCaste fetchSubCaste(long subCasteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSubCaste(subCasteId);
	}

	/**
	* Returns the sub caste with the primary key.
	*
	* @param subCasteId the primary key of the sub caste
	* @return the sub caste
	* @throws PortalException if a sub caste with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.SubCaste getSubCaste(long subCasteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSubCaste(subCasteId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.matrimony.model.SubCaste> getSubCastes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSubCastes(start, end);
	}

	/**
	* Returns the number of sub castes.
	*
	* @return the number of sub castes
	* @throws SystemException if a system exception occurred
	*/
	public static int getSubCastesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSubCastesCount();
	}

	/**
	* Updates the sub caste in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param subCaste the sub caste
	* @return the sub caste that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.SubCaste updateSubCaste(
		com.matrimony.model.SubCaste subCaste)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSubCaste(subCaste);
	}

	/**
	* Updates the sub caste in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param subCaste the sub caste
	* @param merge whether to merge the sub caste with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the sub caste that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.SubCaste updateSubCaste(
		com.matrimony.model.SubCaste subCaste, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSubCaste(subCaste, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.matrimony.model.SubCaste> getSubCasteListByCasteId(
		long casteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSubCasteListByCasteId(casteId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SubCasteLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SubCasteLocalService.class.getName());

			if (invokableLocalService instanceof SubCasteLocalService) {
				_service = (SubCasteLocalService)invokableLocalService;
			}
			else {
				_service = new SubCasteLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SubCasteLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(SubCasteLocalService service) {
	}

	private static SubCasteLocalService _service;
}