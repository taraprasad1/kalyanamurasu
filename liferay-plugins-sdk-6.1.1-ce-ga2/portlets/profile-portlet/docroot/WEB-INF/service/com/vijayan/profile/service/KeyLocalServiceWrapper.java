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

package com.vijayan.profile.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link KeyLocalService}.
 * </p>
 *
 * @author    ravi
 * @see       KeyLocalService
 * @generated
 */
public class KeyLocalServiceWrapper implements KeyLocalService,
	ServiceWrapper<KeyLocalService> {
	public KeyLocalServiceWrapper(KeyLocalService keyLocalService) {
		_keyLocalService = keyLocalService;
	}

	/**
	* Adds the key to the database. Also notifies the appropriate model listeners.
	*
	* @param key the key
	* @return the key that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.vijayan.profile.model.Key addKey(
		com.vijayan.profile.model.Key key)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _keyLocalService.addKey(key);
	}

	/**
	* Creates a new key with the primary key. Does not add the key to the database.
	*
	* @param keyId the primary key for the new key
	* @return the new key
	*/
	public com.vijayan.profile.model.Key createKey(long keyId) {
		return _keyLocalService.createKey(keyId);
	}

	/**
	* Deletes the key with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param keyId the primary key of the key
	* @return the key that was removed
	* @throws PortalException if a key with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vijayan.profile.model.Key deleteKey(long keyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _keyLocalService.deleteKey(keyId);
	}

	/**
	* Deletes the key from the database. Also notifies the appropriate model listeners.
	*
	* @param key the key
	* @return the key that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.vijayan.profile.model.Key deleteKey(
		com.vijayan.profile.model.Key key)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _keyLocalService.deleteKey(key);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _keyLocalService.dynamicQuery();
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
		return _keyLocalService.dynamicQuery(dynamicQuery);
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
		return _keyLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _keyLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _keyLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.vijayan.profile.model.Key fetchKey(long keyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _keyLocalService.fetchKey(keyId);
	}

	/**
	* Returns the key with the primary key.
	*
	* @param keyId the primary key of the key
	* @return the key
	* @throws PortalException if a key with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vijayan.profile.model.Key getKey(long keyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _keyLocalService.getKey(keyId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _keyLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.vijayan.profile.model.Key> getKeies(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _keyLocalService.getKeies(start, end);
	}

	/**
	* Returns the number of keies.
	*
	* @return the number of keies
	* @throws SystemException if a system exception occurred
	*/
	public int getKeiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _keyLocalService.getKeiesCount();
	}

	/**
	* Updates the key in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param key the key
	* @return the key that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vijayan.profile.model.Key updateKey(
		com.vijayan.profile.model.Key key)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _keyLocalService.updateKey(key);
	}

	/**
	* Updates the key in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param key the key
	* @param merge whether to merge the key with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the key that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vijayan.profile.model.Key updateKey(
		com.vijayan.profile.model.Key key, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _keyLocalService.updateKey(key, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _keyLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_keyLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _keyLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	public com.vijayan.profile.model.Key keySearch(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _keyLocalService.keySearch(name);
	}

	public com.vijayan.profile.model.Key keyAdd(java.lang.String name) {
		return _keyLocalService.keyAdd(name);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public KeyLocalService getWrappedKeyLocalService() {
		return _keyLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedKeyLocalService(KeyLocalService keyLocalService) {
		_keyLocalService = keyLocalService;
	}

	public KeyLocalService getWrappedService() {
		return _keyLocalService;
	}

	public void setWrappedService(KeyLocalService keyLocalService) {
		_keyLocalService = keyLocalService;
	}

	private KeyLocalService _keyLocalService;
}