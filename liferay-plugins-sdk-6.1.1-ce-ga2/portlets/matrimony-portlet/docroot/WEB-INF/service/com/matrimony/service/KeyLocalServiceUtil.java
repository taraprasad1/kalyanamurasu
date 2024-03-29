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
 * The utility for the key local service. This utility wraps {@link com.matrimony.service.impl.KeyLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author matrimony
 * @see KeyLocalService
 * @see com.matrimony.service.base.KeyLocalServiceBaseImpl
 * @see com.matrimony.service.impl.KeyLocalServiceImpl
 * @generated
 */
public class KeyLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.matrimony.service.impl.KeyLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the key to the database. Also notifies the appropriate model listeners.
	*
	* @param key the key
	* @return the key that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Key addKey(com.matrimony.model.Key key)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addKey(key);
	}

	/**
	* Creates a new key with the primary key. Does not add the key to the database.
	*
	* @param keyId the primary key for the new key
	* @return the new key
	*/
	public static com.matrimony.model.Key createKey(long keyId) {
		return getService().createKey(keyId);
	}

	/**
	* Deletes the key with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param keyId the primary key of the key
	* @return the key that was removed
	* @throws PortalException if a key with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Key deleteKey(long keyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteKey(keyId);
	}

	/**
	* Deletes the key from the database. Also notifies the appropriate model listeners.
	*
	* @param key the key
	* @return the key that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Key deleteKey(com.matrimony.model.Key key)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteKey(key);
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

	public static com.matrimony.model.Key fetchKey(long keyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchKey(keyId);
	}

	/**
	* Returns the key with the primary key.
	*
	* @param keyId the primary key of the key
	* @return the key
	* @throws PortalException if a key with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Key getKey(long keyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getKey(keyId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the keies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of keies
	* @param end the upper bound of the range of keies (not inclusive)
	* @return the range of keies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.Key> getKeies(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getKeies(start, end);
	}

	/**
	* Returns the number of keies.
	*
	* @return the number of keies
	* @throws SystemException if a system exception occurred
	*/
	public static int getKeiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getKeiesCount();
	}

	/**
	* Updates the key in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param key the key
	* @return the key that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Key updateKey(com.matrimony.model.Key key)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateKey(key);
	}

	/**
	* Updates the key in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param key the key
	* @param merge whether to merge the key with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the key that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Key updateKey(
		com.matrimony.model.Key key, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateKey(key, merge);
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

	public static com.matrimony.model.Key keySearch(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().keySearch(name);
	}

	public static com.matrimony.model.Key keyAdd(java.lang.String name) {
		return getService().keyAdd(name);
	}

	public static void clearService() {
		_service = null;
	}

	public static KeyLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					KeyLocalService.class.getName());

			if (invokableLocalService instanceof KeyLocalService) {
				_service = (KeyLocalService)invokableLocalService;
			}
			else {
				_service = new KeyLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(KeyLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(KeyLocalService service) {
	}

	private static KeyLocalService _service;
}