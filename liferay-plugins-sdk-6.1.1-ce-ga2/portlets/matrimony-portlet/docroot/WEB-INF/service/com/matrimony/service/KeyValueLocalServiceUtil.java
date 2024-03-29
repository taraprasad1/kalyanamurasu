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
 * The utility for the key value local service. This utility wraps {@link com.matrimony.service.impl.KeyValueLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author matrimony
 * @see KeyValueLocalService
 * @see com.matrimony.service.base.KeyValueLocalServiceBaseImpl
 * @see com.matrimony.service.impl.KeyValueLocalServiceImpl
 * @generated
 */
public class KeyValueLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.matrimony.service.impl.KeyValueLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the key value to the database. Also notifies the appropriate model listeners.
	*
	* @param keyValue the key value
	* @return the key value that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.KeyValue addKeyValue(
		com.matrimony.model.KeyValue keyValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addKeyValue(keyValue);
	}

	/**
	* Creates a new key value with the primary key. Does not add the key value to the database.
	*
	* @param valueId the primary key for the new key value
	* @return the new key value
	*/
	public static com.matrimony.model.KeyValue createKeyValue(long valueId) {
		return getService().createKeyValue(valueId);
	}

	/**
	* Deletes the key value with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param valueId the primary key of the key value
	* @return the key value that was removed
	* @throws PortalException if a key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.KeyValue deleteKeyValue(long valueId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteKeyValue(valueId);
	}

	/**
	* Deletes the key value from the database. Also notifies the appropriate model listeners.
	*
	* @param keyValue the key value
	* @return the key value that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.KeyValue deleteKeyValue(
		com.matrimony.model.KeyValue keyValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteKeyValue(keyValue);
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

	public static com.matrimony.model.KeyValue fetchKeyValue(long valueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchKeyValue(valueId);
	}

	/**
	* Returns the key value with the primary key.
	*
	* @param valueId the primary key of the key value
	* @return the key value
	* @throws PortalException if a key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.KeyValue getKeyValue(long valueId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getKeyValue(valueId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the key values.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of key values
	* @param end the upper bound of the range of key values (not inclusive)
	* @return the range of key values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.KeyValue> getKeyValues(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getKeyValues(start, end);
	}

	/**
	* Returns the number of key values.
	*
	* @return the number of key values
	* @throws SystemException if a system exception occurred
	*/
	public static int getKeyValuesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getKeyValuesCount();
	}

	/**
	* Updates the key value in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param keyValue the key value
	* @return the key value that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.KeyValue updateKeyValue(
		com.matrimony.model.KeyValue keyValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateKeyValue(keyValue);
	}

	/**
	* Updates the key value in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param keyValue the key value
	* @param merge whether to merge the key value with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the key value that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.KeyValue updateKeyValue(
		com.matrimony.model.KeyValue keyValue, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateKeyValue(keyValue, merge);
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

	public static com.matrimony.model.KeyValue valueNameSearch(
		java.lang.String name, long keyId) {
		return getService().valueNameSearch(name, keyId);
	}

	public static java.util.List<com.matrimony.model.KeyValue> valueSearch(
		long keyId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().valueSearch(keyId);
	}

	public static com.matrimony.model.KeyValue addValue(
		java.lang.String keyValue, long keyId) {
		return getService().addValue(keyValue, keyId);
	}

	public static java.util.List<java.lang.String> getKeyValueList(
		java.lang.String keyName) {
		return getService().getKeyValueList(keyName);
	}

	public static void clearService() {
		_service = null;
	}

	public static KeyValueLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					KeyValueLocalService.class.getName());

			if (invokableLocalService instanceof KeyValueLocalService) {
				_service = (KeyValueLocalService)invokableLocalService;
			}
			else {
				_service = new KeyValueLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(KeyValueLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(KeyValueLocalService service) {
	}

	private static KeyValueLocalService _service;
}