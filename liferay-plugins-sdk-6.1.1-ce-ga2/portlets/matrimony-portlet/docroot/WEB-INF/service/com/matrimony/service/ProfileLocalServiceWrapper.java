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
 * This class is a wrapper for {@link ProfileLocalService}.
 * </p>
 *
 * @author    matrimony
 * @see       ProfileLocalService
 * @generated
 */
public class ProfileLocalServiceWrapper implements ProfileLocalService,
	ServiceWrapper<ProfileLocalService> {
	public ProfileLocalServiceWrapper(ProfileLocalService profileLocalService) {
		_profileLocalService = profileLocalService;
	}

	/**
	* Adds the profile to the database. Also notifies the appropriate model listeners.
	*
	* @param profile the profile
	* @return the profile that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Profile addProfile(
		com.matrimony.model.Profile profile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _profileLocalService.addProfile(profile);
	}

	/**
	* Creates a new profile with the primary key. Does not add the profile to the database.
	*
	* @param profileId the primary key for the new profile
	* @return the new profile
	*/
	public com.matrimony.model.Profile createProfile(long profileId) {
		return _profileLocalService.createProfile(profileId);
	}

	/**
	* Deletes the profile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param profileId the primary key of the profile
	* @return the profile that was removed
	* @throws PortalException if a profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Profile deleteProfile(long profileId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _profileLocalService.deleteProfile(profileId);
	}

	/**
	* Deletes the profile from the database. Also notifies the appropriate model listeners.
	*
	* @param profile the profile
	* @return the profile that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Profile deleteProfile(
		com.matrimony.model.Profile profile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _profileLocalService.deleteProfile(profile);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _profileLocalService.dynamicQuery();
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
		return _profileLocalService.dynamicQuery(dynamicQuery);
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
		return _profileLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _profileLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _profileLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.matrimony.model.Profile fetchProfile(long profileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _profileLocalService.fetchProfile(profileId);
	}

	/**
	* Returns the profile with the primary key.
	*
	* @param profileId the primary key of the profile
	* @return the profile
	* @throws PortalException if a profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Profile getProfile(long profileId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _profileLocalService.getProfile(profileId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _profileLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.matrimony.model.Profile> getProfiles(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _profileLocalService.getProfiles(start, end);
	}

	/**
	* Returns the number of profiles.
	*
	* @return the number of profiles
	* @throws SystemException if a system exception occurred
	*/
	public int getProfilesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _profileLocalService.getProfilesCount();
	}

	/**
	* Updates the profile in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param profile the profile
	* @return the profile that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Profile updateProfile(
		com.matrimony.model.Profile profile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _profileLocalService.updateProfile(profile);
	}

	/**
	* Updates the profile in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param profile the profile
	* @param merge whether to merge the profile with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the profile that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Profile updateProfile(
		com.matrimony.model.Profile profile, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _profileLocalService.updateProfile(profile, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _profileLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_profileLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _profileLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ProfileLocalService getWrappedProfileLocalService() {
		return _profileLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedProfileLocalService(
		ProfileLocalService profileLocalService) {
		_profileLocalService = profileLocalService;
	}

	public ProfileLocalService getWrappedService() {
		return _profileLocalService;
	}

	public void setWrappedService(ProfileLocalService profileLocalService) {
		_profileLocalService = profileLocalService;
	}

	private ProfileLocalService _profileLocalService;
}