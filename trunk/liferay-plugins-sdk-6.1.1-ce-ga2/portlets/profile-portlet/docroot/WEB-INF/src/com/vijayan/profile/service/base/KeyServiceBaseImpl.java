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

package com.vijayan.profile.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import com.vijayan.profile.model.Key;
import com.vijayan.profile.service.KeyLocalService;
import com.vijayan.profile.service.KeyService;
import com.vijayan.profile.service.KeyValueLocalService;
import com.vijayan.profile.service.KeyValueService;
import com.vijayan.profile.service.persistence.KeyPersistence;
import com.vijayan.profile.service.persistence.KeyValuePersistence;

import javax.sql.DataSource;

/**
 * The base implementation of the key remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.vijayan.profile.service.impl.KeyServiceImpl}.
 * </p>
 *
 * @author ravi
 * @see com.vijayan.profile.service.impl.KeyServiceImpl
 * @see com.vijayan.profile.service.KeyServiceUtil
 * @generated
 */
public abstract class KeyServiceBaseImpl extends BaseServiceImpl
	implements KeyService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.vijayan.profile.service.KeyServiceUtil} to access the key remote service.
	 */

	/**
	 * Returns the key local service.
	 *
	 * @return the key local service
	 */
	public KeyLocalService getKeyLocalService() {
		return keyLocalService;
	}

	/**
	 * Sets the key local service.
	 *
	 * @param keyLocalService the key local service
	 */
	public void setKeyLocalService(KeyLocalService keyLocalService) {
		this.keyLocalService = keyLocalService;
	}

	/**
	 * Returns the key remote service.
	 *
	 * @return the key remote service
	 */
	public KeyService getKeyService() {
		return keyService;
	}

	/**
	 * Sets the key remote service.
	 *
	 * @param keyService the key remote service
	 */
	public void setKeyService(KeyService keyService) {
		this.keyService = keyService;
	}

	/**
	 * Returns the key persistence.
	 *
	 * @return the key persistence
	 */
	public KeyPersistence getKeyPersistence() {
		return keyPersistence;
	}

	/**
	 * Sets the key persistence.
	 *
	 * @param keyPersistence the key persistence
	 */
	public void setKeyPersistence(KeyPersistence keyPersistence) {
		this.keyPersistence = keyPersistence;
	}

	/**
	 * Returns the key value local service.
	 *
	 * @return the key value local service
	 */
	public KeyValueLocalService getKeyValueLocalService() {
		return keyValueLocalService;
	}

	/**
	 * Sets the key value local service.
	 *
	 * @param keyValueLocalService the key value local service
	 */
	public void setKeyValueLocalService(
		KeyValueLocalService keyValueLocalService) {
		this.keyValueLocalService = keyValueLocalService;
	}

	/**
	 * Returns the key value remote service.
	 *
	 * @return the key value remote service
	 */
	public KeyValueService getKeyValueService() {
		return keyValueService;
	}

	/**
	 * Sets the key value remote service.
	 *
	 * @param keyValueService the key value remote service
	 */
	public void setKeyValueService(KeyValueService keyValueService) {
		this.keyValueService = keyValueService;
	}

	/**
	 * Returns the key value persistence.
	 *
	 * @return the key value persistence
	 */
	public KeyValuePersistence getKeyValuePersistence() {
		return keyValuePersistence;
	}

	/**
	 * Sets the key value persistence.
	 *
	 * @param keyValuePersistence the key value persistence
	 */
	public void setKeyValuePersistence(KeyValuePersistence keyValuePersistence) {
		this.keyValuePersistence = keyValuePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
	}

	protected Class<?> getModelClass() {
		return Key.class;
	}

	protected String getModelClassName() {
		return Key.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = keyPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = KeyLocalService.class)
	protected KeyLocalService keyLocalService;
	@BeanReference(type = KeyService.class)
	protected KeyService keyService;
	@BeanReference(type = KeyPersistence.class)
	protected KeyPersistence keyPersistence;
	@BeanReference(type = KeyValueLocalService.class)
	protected KeyValueLocalService keyValueLocalService;
	@BeanReference(type = KeyValueService.class)
	protected KeyValueService keyValueService;
	@BeanReference(type = KeyValuePersistence.class)
	protected KeyValuePersistence keyValuePersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private KeyServiceClpInvoker _clpInvoker = new KeyServiceClpInvoker();
}