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

import com.matrimony.model.Interaction;

import com.matrimony.service.CasteLocalService;
import com.matrimony.service.CityLocalService;
import com.matrimony.service.InteractionLocalService;
import com.matrimony.service.InteractionService;
import com.matrimony.service.KeyLocalService;
import com.matrimony.service.KeyService;
import com.matrimony.service.KeyValueLocalService;
import com.matrimony.service.KeyValueService;
import com.matrimony.service.PhotoLocalService;
import com.matrimony.service.PhotoService;
import com.matrimony.service.ProfileKeyValueLocalService;
import com.matrimony.service.ProfileLocalService;
import com.matrimony.service.ProfileService;
import com.matrimony.service.ProfileTempLocalService;
import com.matrimony.service.ProfileTempService;
import com.matrimony.service.ReligionLocalService;
import com.matrimony.service.SubCasteLocalService;
import com.matrimony.service.persistence.CastePersistence;
import com.matrimony.service.persistence.CityPersistence;
import com.matrimony.service.persistence.InteractionPersistence;
import com.matrimony.service.persistence.KeyPersistence;
import com.matrimony.service.persistence.KeyValuePersistence;
import com.matrimony.service.persistence.PhotoPersistence;
import com.matrimony.service.persistence.ProfileKeyValuePersistence;
import com.matrimony.service.persistence.ProfilePersistence;
import com.matrimony.service.persistence.ProfileTempPersistence;
import com.matrimony.service.persistence.ReligionPersistence;
import com.matrimony.service.persistence.SubCastePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the interaction local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.matrimony.service.impl.InteractionLocalServiceImpl}.
 * </p>
 *
 * @author matrimony
 * @see com.matrimony.service.impl.InteractionLocalServiceImpl
 * @see com.matrimony.service.InteractionLocalServiceUtil
 * @generated
 */
public abstract class InteractionLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements InteractionLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.matrimony.service.InteractionLocalServiceUtil} to access the interaction local service.
	 */

	/**
	 * Adds the interaction to the database. Also notifies the appropriate model listeners.
	 *
	 * @param interaction the interaction
	 * @return the interaction that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Interaction addInteraction(Interaction interaction)
		throws SystemException {
		interaction.setNew(true);

		return interactionPersistence.update(interaction, false);
	}

	/**
	 * Creates a new interaction with the primary key. Does not add the interaction to the database.
	 *
	 * @param interactionId the primary key for the new interaction
	 * @return the new interaction
	 */
	public Interaction createInteraction(long interactionId) {
		return interactionPersistence.create(interactionId);
	}

	/**
	 * Deletes the interaction with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param interactionId the primary key of the interaction
	 * @return the interaction that was removed
	 * @throws PortalException if a interaction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Interaction deleteInteraction(long interactionId)
		throws PortalException, SystemException {
		return interactionPersistence.remove(interactionId);
	}

	/**
	 * Deletes the interaction from the database. Also notifies the appropriate model listeners.
	 *
	 * @param interaction the interaction
	 * @return the interaction that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Interaction deleteInteraction(Interaction interaction)
		throws SystemException {
		return interactionPersistence.remove(interaction);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Interaction.class,
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
		return interactionPersistence.findWithDynamicQuery(dynamicQuery);
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
		return interactionPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
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
		return interactionPersistence.findWithDynamicQuery(dynamicQuery, start,
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
		return interactionPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public Interaction fetchInteraction(long interactionId)
		throws SystemException {
		return interactionPersistence.fetchByPrimaryKey(interactionId);
	}

	/**
	 * Returns the interaction with the primary key.
	 *
	 * @param interactionId the primary key of the interaction
	 * @return the interaction
	 * @throws PortalException if a interaction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Interaction getInteraction(long interactionId)
		throws PortalException, SystemException {
		return interactionPersistence.findByPrimaryKey(interactionId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return interactionPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the interactions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of interactions
	 * @param end the upper bound of the range of interactions (not inclusive)
	 * @return the range of interactions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Interaction> getInteractions(int start, int end)
		throws SystemException {
		return interactionPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of interactions.
	 *
	 * @return the number of interactions
	 * @throws SystemException if a system exception occurred
	 */
	public int getInteractionsCount() throws SystemException {
		return interactionPersistence.countAll();
	}

	/**
	 * Updates the interaction in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param interaction the interaction
	 * @return the interaction that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Interaction updateInteraction(Interaction interaction)
		throws SystemException {
		return updateInteraction(interaction, true);
	}

	/**
	 * Updates the interaction in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param interaction the interaction
	 * @param merge whether to merge the interaction with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the interaction that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Interaction updateInteraction(Interaction interaction, boolean merge)
		throws SystemException {
		interaction.setNew(false);

		return interactionPersistence.update(interaction, merge);
	}

	/**
	 * Returns the caste local service.
	 *
	 * @return the caste local service
	 */
	public CasteLocalService getCasteLocalService() {
		return casteLocalService;
	}

	/**
	 * Sets the caste local service.
	 *
	 * @param casteLocalService the caste local service
	 */
	public void setCasteLocalService(CasteLocalService casteLocalService) {
		this.casteLocalService = casteLocalService;
	}

	/**
	 * Returns the caste persistence.
	 *
	 * @return the caste persistence
	 */
	public CastePersistence getCastePersistence() {
		return castePersistence;
	}

	/**
	 * Sets the caste persistence.
	 *
	 * @param castePersistence the caste persistence
	 */
	public void setCastePersistence(CastePersistence castePersistence) {
		this.castePersistence = castePersistence;
	}

	/**
	 * Returns the city local service.
	 *
	 * @return the city local service
	 */
	public CityLocalService getCityLocalService() {
		return cityLocalService;
	}

	/**
	 * Sets the city local service.
	 *
	 * @param cityLocalService the city local service
	 */
	public void setCityLocalService(CityLocalService cityLocalService) {
		this.cityLocalService = cityLocalService;
	}

	/**
	 * Returns the city persistence.
	 *
	 * @return the city persistence
	 */
	public CityPersistence getCityPersistence() {
		return cityPersistence;
	}

	/**
	 * Sets the city persistence.
	 *
	 * @param cityPersistence the city persistence
	 */
	public void setCityPersistence(CityPersistence cityPersistence) {
		this.cityPersistence = cityPersistence;
	}

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
	 * Returns the profile key value local service.
	 *
	 * @return the profile key value local service
	 */
	public ProfileKeyValueLocalService getProfileKeyValueLocalService() {
		return profileKeyValueLocalService;
	}

	/**
	 * Sets the profile key value local service.
	 *
	 * @param profileKeyValueLocalService the profile key value local service
	 */
	public void setProfileKeyValueLocalService(
		ProfileKeyValueLocalService profileKeyValueLocalService) {
		this.profileKeyValueLocalService = profileKeyValueLocalService;
	}

	/**
	 * Returns the profile key value persistence.
	 *
	 * @return the profile key value persistence
	 */
	public ProfileKeyValuePersistence getProfileKeyValuePersistence() {
		return profileKeyValuePersistence;
	}

	/**
	 * Sets the profile key value persistence.
	 *
	 * @param profileKeyValuePersistence the profile key value persistence
	 */
	public void setProfileKeyValuePersistence(
		ProfileKeyValuePersistence profileKeyValuePersistence) {
		this.profileKeyValuePersistence = profileKeyValuePersistence;
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
	 * Returns the religion local service.
	 *
	 * @return the religion local service
	 */
	public ReligionLocalService getReligionLocalService() {
		return religionLocalService;
	}

	/**
	 * Sets the religion local service.
	 *
	 * @param religionLocalService the religion local service
	 */
	public void setReligionLocalService(
		ReligionLocalService religionLocalService) {
		this.religionLocalService = religionLocalService;
	}

	/**
	 * Returns the religion persistence.
	 *
	 * @return the religion persistence
	 */
	public ReligionPersistence getReligionPersistence() {
		return religionPersistence;
	}

	/**
	 * Sets the religion persistence.
	 *
	 * @param religionPersistence the religion persistence
	 */
	public void setReligionPersistence(ReligionPersistence religionPersistence) {
		this.religionPersistence = religionPersistence;
	}

	/**
	 * Returns the sub caste local service.
	 *
	 * @return the sub caste local service
	 */
	public SubCasteLocalService getSubCasteLocalService() {
		return subCasteLocalService;
	}

	/**
	 * Sets the sub caste local service.
	 *
	 * @param subCasteLocalService the sub caste local service
	 */
	public void setSubCasteLocalService(
		SubCasteLocalService subCasteLocalService) {
		this.subCasteLocalService = subCasteLocalService;
	}

	/**
	 * Returns the sub caste persistence.
	 *
	 * @return the sub caste persistence
	 */
	public SubCastePersistence getSubCastePersistence() {
		return subCastePersistence;
	}

	/**
	 * Sets the sub caste persistence.
	 *
	 * @param subCastePersistence the sub caste persistence
	 */
	public void setSubCastePersistence(SubCastePersistence subCastePersistence) {
		this.subCastePersistence = subCastePersistence;
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
		PersistedModelLocalServiceRegistryUtil.register("com.matrimony.model.Interaction",
			interactionLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.matrimony.model.Interaction");
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
		return Interaction.class;
	}

	protected String getModelClassName() {
		return Interaction.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = interactionPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = CasteLocalService.class)
	protected CasteLocalService casteLocalService;
	@BeanReference(type = CastePersistence.class)
	protected CastePersistence castePersistence;
	@BeanReference(type = CityLocalService.class)
	protected CityLocalService cityLocalService;
	@BeanReference(type = CityPersistence.class)
	protected CityPersistence cityPersistence;
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
	@BeanReference(type = ProfileKeyValueLocalService.class)
	protected ProfileKeyValueLocalService profileKeyValueLocalService;
	@BeanReference(type = ProfileKeyValuePersistence.class)
	protected ProfileKeyValuePersistence profileKeyValuePersistence;
	@BeanReference(type = ProfileTempLocalService.class)
	protected ProfileTempLocalService profileTempLocalService;
	@BeanReference(type = ProfileTempService.class)
	protected ProfileTempService profileTempService;
	@BeanReference(type = ProfileTempPersistence.class)
	protected ProfileTempPersistence profileTempPersistence;
	@BeanReference(type = ReligionLocalService.class)
	protected ReligionLocalService religionLocalService;
	@BeanReference(type = ReligionPersistence.class)
	protected ReligionPersistence religionPersistence;
	@BeanReference(type = SubCasteLocalService.class)
	protected SubCasteLocalService subCasteLocalService;
	@BeanReference(type = SubCastePersistence.class)
	protected SubCastePersistence subCastePersistence;
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
	private InteractionLocalServiceClpInvoker _clpInvoker = new InteractionLocalServiceClpInvoker();
}