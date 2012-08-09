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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import com.vijayan.profile.model.Profile;
import com.vijayan.profile.service.KeyLocalService;
import com.vijayan.profile.service.KeyService;
import com.vijayan.profile.service.KeyValueLocalService;
import com.vijayan.profile.service.KeyValueService;
import com.vijayan.profile.service.ProfileLocalService;
import com.vijayan.profile.service.ProfileService;
import com.vijayan.profile.service.persistence.KeyPersistence;
import com.vijayan.profile.service.persistence.KeyValuePersistence;
import com.vijayan.profile.service.persistence.ProfilePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the profile local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.vijayan.profile.service.impl.ProfileLocalServiceImpl}.
 * </p>
 *
 * @author vijayan
 * @see com.vijayan.profile.service.impl.ProfileLocalServiceImpl
 * @see com.vijayan.profile.service.ProfileLocalServiceUtil
 * @generated
 */
public abstract class ProfileLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements ProfileLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.vijayan.profile.service.ProfileLocalServiceUtil} to access the profile local service.
	 */

	/**
	 * Adds the profile to the database. Also notifies the appropriate model listeners.
	 *
	 * @param profile the profile
	 * @return the profile that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Profile addProfile(Profile profile) throws SystemException {
		profile.setNew(true);

		return profilePersistence.update(profile, false);
	}

	/**
	 * Creates a new profile with the primary key. Does not add the profile to the database.
	 *
	 * @param profileId the primary key for the new profile
	 * @return the new profile
	 */
	public Profile createProfile(long profileId) {
		return profilePersistence.create(profileId);
	}

	/**
	 * Deletes the profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileId the primary key of the profile
	 * @return the profile that was removed
	 * @throws PortalException if a profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Profile deleteProfile(long profileId)
		throws PortalException, SystemException {
		return profilePersistence.remove(profileId);
	}

	/**
	 * Deletes the profile from the database. Also notifies the appropriate model listeners.
	 *
	 * @param profile the profile
	 * @return the profile that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Profile deleteProfile(Profile profile) throws SystemException {
		return profilePersistence.remove(profile);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Profile.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return profilePersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return profilePersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return profilePersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return profilePersistence.countWithDynamicQuery(dynamicQuery);
	}

	public Profile fetchProfile(long profileId) throws SystemException {
		return profilePersistence.fetchByPrimaryKey(profileId);
	}

	/**
	 * Returns the profile with the primary key.
	 *
	 * @param profileId the primary key of the profile
	 * @return the profile
	 * @throws PortalException if a profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Profile getProfile(long profileId)
		throws PortalException, SystemException {
		return profilePersistence.findByPrimaryKey(profileId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return profilePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of profiles
	 * @param end the upper bound of the range of profiles (not inclusive)
	 * @return the range of profiles
	 * @throws SystemException if a system exception occurred
	 */
	public List<Profile> getProfiles(int start, int end)
		throws SystemException {
		return profilePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of profiles.
	 *
	 * @return the number of profiles
	 * @throws SystemException if a system exception occurred
	 */
	public int getProfilesCount() throws SystemException {
		return profilePersistence.countAll();
	}

	/**
	 * Updates the profile in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param profile the profile
	 * @return the profile that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Profile updateProfile(Profile profile) throws SystemException {
		return updateProfile(profile, true);
	}

	/**
	 * Updates the profile in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param profile the profile
	 * @param merge whether to merge the profile with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the profile that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Profile updateProfile(Profile profile, boolean merge)
		throws SystemException {
		profile.setNew(false);

		return profilePersistence.update(profile, merge);
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
		PersistedModelLocalServiceRegistryUtil.register("com.vijayan.profile.model.Profile",
			profileLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.vijayan.profile.model.Profile");
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
		return Profile.class;
	}

	protected String getModelClassName() {
		return Profile.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = profilePersistence.getDataSource();

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
	@BeanReference(type = ProfileLocalService.class)
	protected ProfileLocalService profileLocalService;
	@BeanReference(type = ProfileService.class)
	protected ProfileService profileService;
	@BeanReference(type = ProfilePersistence.class)
	protected ProfilePersistence profilePersistence;
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
	private ProfileLocalServiceClpInvoker _clpInvoker = new ProfileLocalServiceClpInvoker();
}