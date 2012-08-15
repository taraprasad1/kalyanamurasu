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

package com.matrimony.service.base;

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

import com.matrimony.model.Photo;

import com.matrimony.service.InteractionLocalService;
import com.matrimony.service.InteractionService;
import com.matrimony.service.KeyLocalService;
import com.matrimony.service.KeyService;
import com.matrimony.service.KeyValueLocalService;
import com.matrimony.service.KeyValueService;
import com.matrimony.service.PhotoLocalService;
import com.matrimony.service.PhotoService;
import com.matrimony.service.ProfileLocalService;
import com.matrimony.service.ProfileService;
import com.matrimony.service.ProfileTempLocalService;
import com.matrimony.service.ProfileTempService;
import com.matrimony.service.persistence.InteractionPersistence;
import com.matrimony.service.persistence.KeyPersistence;
import com.matrimony.service.persistence.KeyValuePersistence;
import com.matrimony.service.persistence.PhotoPersistence;
import com.matrimony.service.persistence.ProfilePersistence;
import com.matrimony.service.persistence.ProfileTempPersistence;

import javax.sql.DataSource;

/**
 * The base implementation of the photo remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.matrimony.service.impl.PhotoServiceImpl}.
 * </p>
 *
 * @author matrimony
 * @see com.matrimony.service.impl.PhotoServiceImpl
 * @see com.matrimony.service.PhotoServiceUtil
 * @generated
 */
public abstract class PhotoServiceBaseImpl extends BaseServiceImpl
	implements PhotoService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.matrimony.service.PhotoServiceUtil} to access the photo remote service.
	 */

	/**
	 * Returns the interaction local service.
	 *
	 * @return the interaction local service
	 */
	public InteractionLocalService getInteractionLocalService() {
		return interactionLocalService;
	}

	/**
	 * Sets the interaction local service.
	 *
	 * @param interactionLocalService the interaction local service
	 */
	public void setInteractionLocalService(
		InteractionLocalService interactionLocalService) {
		this.interactionLocalService = interactionLocalService;
	}

	/**
	 * Returns the interaction remote service.
	 *
	 * @return the interaction remote service
	 */
	public InteractionService getInteractionService() {
		return interactionService;
	}

	/**
	 * Sets the interaction remote service.
	 *
	 * @param interactionService the interaction remote service
	 */
	public void setInteractionService(InteractionService interactionService) {
		this.interactionService = interactionService;
	}

	/**
	 * Returns the interaction persistence.
	 *
	 * @return the interaction persistence
	 */
	public InteractionPersistence getInteractionPersistence() {
		return interactionPersistence;
	}

	/**
	 * Sets the interaction persistence.
	 *
	 * @param interactionPersistence the interaction persistence
	 */
	public void setInteractionPersistence(
		InteractionPersistence interactionPersistence) {
		this.interactionPersistence = interactionPersistence;
	}

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
	 * Returns the photo local service.
	 *
	 * @return the photo local service
	 */
	public PhotoLocalService getPhotoLocalService() {
		return photoLocalService;
	}

	/**
	 * Sets the photo local service.
	 *
	 * @param photoLocalService the photo local service
	 */
	public void setPhotoLocalService(PhotoLocalService photoLocalService) {
		this.photoLocalService = photoLocalService;
	}

	/**
	 * Returns the photo remote service.
	 *
	 * @return the photo remote service
	 */
	public PhotoService getPhotoService() {
		return photoService;
	}

	/**
	 * Sets the photo remote service.
	 *
	 * @param photoService the photo remote service
	 */
	public void setPhotoService(PhotoService photoService) {
		this.photoService = photoService;
	}

	/**
	 * Returns the photo persistence.
	 *
	 * @return the photo persistence
	 */
	public PhotoPersistence getPhotoPersistence() {
		return photoPersistence;
	}

	/**
	 * Sets the photo persistence.
	 *
	 * @param photoPersistence the photo persistence
	 */
	public void setPhotoPersistence(PhotoPersistence photoPersistence) {
		this.photoPersistence = photoPersistence;
	}

	/**
	 * Returns the profile local service.
	 *
	 * @return the profile local service
	 */
	public ProfileLocalService getProfileLocalService() {
		return profileLocalService;
	}

	/**
	 * Sets the profile local service.
	 *
	 * @param profileLocalService the profile local service
	 */
	public void setProfileLocalService(ProfileLocalService profileLocalService) {
		this.profileLocalService = profileLocalService;
	}

	/**
	 * Returns the profile remote service.
	 *
	 * @return the profile remote service
	 */
	public ProfileService getProfileService() {
		return profileService;
	}

	/**
	 * Sets the profile remote service.
	 *
	 * @param profileService the profile remote service
	 */
	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	/**
	 * Returns the profile persistence.
	 *
	 * @return the profile persistence
	 */
	public ProfilePersistence getProfilePersistence() {
		return profilePersistence;
	}

	/**
	 * Sets the profile persistence.
	 *
	 * @param profilePersistence the profile persistence
	 */
	public void setProfilePersistence(ProfilePersistence profilePersistence) {
		this.profilePersistence = profilePersistence;
	}

	/**
	 * Returns the profile temp local service.
	 *
	 * @return the profile temp local service
	 */
	public ProfileTempLocalService getProfileTempLocalService() {
		return profileTempLocalService;
	}

	/**
	 * Sets the profile temp local service.
	 *
	 * @param profileTempLocalService the profile temp local service
	 */
	public void setProfileTempLocalService(
		ProfileTempLocalService profileTempLocalService) {
		this.profileTempLocalService = profileTempLocalService;
	}

	/**
	 * Returns the profile temp remote service.
	 *
	 * @return the profile temp remote service
	 */
	public ProfileTempService getProfileTempService() {
		return profileTempService;
	}

	/**
	 * Sets the profile temp remote service.
	 *
	 * @param profileTempService the profile temp remote service
	 */
	public void setProfileTempService(ProfileTempService profileTempService) {
		this.profileTempService = profileTempService;
	}

	/**
	 * Returns the profile temp persistence.
	 *
	 * @return the profile temp persistence
	 */
	public ProfileTempPersistence getProfileTempPersistence() {
		return profileTempPersistence;
	}

	/**
	 * Sets the profile temp persistence.
	 *
	 * @param profileTempPersistence the profile temp persistence
	 */
	public void setProfileTempPersistence(
		ProfileTempPersistence profileTempPersistence) {
		this.profileTempPersistence = profileTempPersistence;
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
		return Photo.class;
	}

	protected String getModelClassName() {
		return Photo.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = photoPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = InteractionLocalService.class)
	protected InteractionLocalService interactionLocalService;
	@BeanReference(type = InteractionService.class)
	protected InteractionService interactionService;
	@BeanReference(type = InteractionPersistence.class)
	protected InteractionPersistence interactionPersistence;
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
	@BeanReference(type = PhotoLocalService.class)
	protected PhotoLocalService photoLocalService;
	@BeanReference(type = PhotoService.class)
	protected PhotoService photoService;
	@BeanReference(type = PhotoPersistence.class)
	protected PhotoPersistence photoPersistence;
	@BeanReference(type = ProfileLocalService.class)
	protected ProfileLocalService profileLocalService;
	@BeanReference(type = ProfileService.class)
	protected ProfileService profileService;
	@BeanReference(type = ProfilePersistence.class)
	protected ProfilePersistence profilePersistence;
	@BeanReference(type = ProfileTempLocalService.class)
	protected ProfileTempLocalService profileTempLocalService;
	@BeanReference(type = ProfileTempService.class)
	protected ProfileTempService profileTempService;
	@BeanReference(type = ProfileTempPersistence.class)
	protected ProfileTempPersistence profileTempPersistence;
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
	private PhotoServiceClpInvoker _clpInvoker = new PhotoServiceClpInvoker();
}