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
 * This class is a wrapper for {@link ProfileKeyValueLocalService}.
 * </p>
 *
 * @author    matrimony
 * @see       ProfileKeyValueLocalService
 * @generated
 */
public class ProfileKeyValueLocalServiceWrapper
	implements ProfileKeyValueLocalService,
		ServiceWrapper<ProfileKeyValueLocalService> {
	public ProfileKeyValueLocalServiceWrapper(
		ProfileKeyValueLocalService profileKeyValueLocalService) {
		_profileKeyValueLocalService = profileKeyValueLocalService;
	}

	/**
	* Adds the profile key value to the database. Also notifies the appropriate model listeners.
	*
	* @param profileKeyValue the profile key value
	* @return the profile key value that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.ProfileKeyValue addProfileKeyValue(
		com.matrimony.model.ProfileKeyValue profileKeyValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _profileKeyValueLocalService.addProfileKeyValue(profileKeyValue);
	}

	/**
	* Creates a new profile key value with the primary key. Does not add the profile key value to the database.
	*
	* @param profileKeyValuePK the primary key for the new profile key value
	* @return the new profile key value
	*/
	public com.matrimony.model.ProfileKeyValue createProfileKeyValue(
		com.matrimony.service.persistence.ProfileKeyValuePK profileKeyValuePK) {
		return _profileKeyValueLocalService.createProfileKeyValue(profileKeyValuePK);
	}

	/**
	* Deletes the profile key value with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param profileKeyValuePK the primary key of the profile key value
	* @return the profile key value that was removed
	* @throws PortalException if a profile key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.ProfileKeyValue deleteProfileKeyValue(
		com.matrimony.service.persistence.ProfileKeyValuePK profileKeyValuePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _profileKeyValueLocalService.deleteProfileKeyValue(profileKeyValuePK);
	}

	/**
	* Deletes the profile key value from the database. Also notifies the appropriate model listeners.
	*
	* @param profileKeyValue the profile key value
	* @return the profile key value that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.ProfileKeyValue deleteProfileKeyValue(
		com.matrimony.model.ProfileKeyValue profileKeyValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _profileKeyValueLocalService.deleteProfileKeyValue(profileKeyValue);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _profileKeyValueLocalService.dynamicQuery();
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
		return _profileKeyValueLocalService.dynamicQuery(dynamicQuery);
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
		return _profileKeyValueLocalService.dynamicQuery(dynamicQuery, start,
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _profileKeyValueLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _profileKeyValueLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.matrimony.model.ProfileKeyValue fetchProfileKeyValue(
		com.matrimony.service.persistence.ProfileKeyValuePK profileKeyValuePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _profileKeyValueLocalService.fetchProfileKeyValue(profileKeyValuePK);
	}

	/**
	* Returns the profile key value with the primary key.
	*
	* @param profileKeyValuePK the primary key of the profile key value
	* @return the profile key value
	* @throws PortalException if a profile key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.ProfileKeyValue getProfileKeyValue(
		com.matrimony.service.persistence.ProfileKeyValuePK profileKeyValuePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _profileKeyValueLocalService.getProfileKeyValue(profileKeyValuePK);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _profileKeyValueLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the profile key values.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of profile key values
	* @param end the upper bound of the range of profile key values (not inclusive)
	* @return the range of profile key values
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.ProfileKeyValue> getProfileKeyValues(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _profileKeyValueLocalService.getProfileKeyValues(start, end);
	}

	/**
	* Returns the number of profile key values.
	*
	* @return the number of profile key values
	* @throws SystemException if a system exception occurred
	*/
	public int getProfileKeyValuesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _profileKeyValueLocalService.getProfileKeyValuesCount();
	}

	/**
	* Updates the profile key value in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param profileKeyValue the profile key value
	* @return the profile key value that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.ProfileKeyValue updateProfileKeyValue(
		com.matrimony.model.ProfileKeyValue profileKeyValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _profileKeyValueLocalService.updateProfileKeyValue(profileKeyValue);
	}

	/**
	* Updates the profile key value in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param profileKeyValue the profile key value
	* @param merge whether to merge the profile key value with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the profile key value that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.ProfileKeyValue updateProfileKeyValue(
		com.matrimony.model.ProfileKeyValue profileKeyValue, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _profileKeyValueLocalService.updateProfileKeyValue(profileKeyValue,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _profileKeyValueLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_profileKeyValueLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _profileKeyValueLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public void addValues(long profileId,
		java.util.Map<java.lang.String, java.lang.String> keyValues)
		throws com.liferay.portal.kernel.exception.SystemException {
		_profileKeyValueLocalService.addValues(profileId, keyValues);
	}

	public void updateValues(long profileId,
		java.util.Map<java.lang.String, java.lang.String> keyValues)
		throws com.liferay.portal.kernel.exception.SystemException {
		_profileKeyValueLocalService.updateValues(profileId, keyValues);
	}

	public java.lang.String getValues(long profileId, java.lang.String keyName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _profileKeyValueLocalService.getValues(profileId, keyName);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ProfileKeyValueLocalService getWrappedProfileKeyValueLocalService() {
		return _profileKeyValueLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedProfileKeyValueLocalService(
		ProfileKeyValueLocalService profileKeyValueLocalService) {
		_profileKeyValueLocalService = profileKeyValueLocalService;
	}

	public ProfileKeyValueLocalService getWrappedService() {
		return _profileKeyValueLocalService;
	}

	public void setWrappedService(
		ProfileKeyValueLocalService profileKeyValueLocalService) {
		_profileKeyValueLocalService = profileKeyValueLocalService;
	}

	private ProfileKeyValueLocalService _profileKeyValueLocalService;
}