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
 * This class is a wrapper for {@link PhotoLocalService}.
 * </p>
 *
 * @author    matrimony
 * @see       PhotoLocalService
 * @generated
 */
public class PhotoLocalServiceWrapper implements PhotoLocalService,
	ServiceWrapper<PhotoLocalService> {
	public PhotoLocalServiceWrapper(PhotoLocalService photoLocalService) {
		_photoLocalService = photoLocalService;
	}

	/**
	* Adds the photo to the database. Also notifies the appropriate model listeners.
	*
	* @param photo the photo
	* @return the photo that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Photo addPhoto(com.matrimony.model.Photo photo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _photoLocalService.addPhoto(photo);
	}

	/**
	* Creates a new photo with the primary key. Does not add the photo to the database.
	*
	* @param photoId the primary key for the new photo
	* @return the new photo
	*/
	public com.matrimony.model.Photo createPhoto(long photoId) {
		return _photoLocalService.createPhoto(photoId);
	}

	/**
	* Deletes the photo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param photoId the primary key of the photo
	* @return the photo that was removed
	* @throws PortalException if a photo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Photo deletePhoto(long photoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _photoLocalService.deletePhoto(photoId);
	}

	/**
	* Deletes the photo from the database. Also notifies the appropriate model listeners.
	*
	* @param photo the photo
	* @return the photo that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Photo deletePhoto(
		com.matrimony.model.Photo photo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _photoLocalService.deletePhoto(photo);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _photoLocalService.dynamicQuery();
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
		return _photoLocalService.dynamicQuery(dynamicQuery);
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
		return _photoLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _photoLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _photoLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.matrimony.model.Photo fetchPhoto(long photoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _photoLocalService.fetchPhoto(photoId);
	}

	/**
	* Returns the photo with the primary key.
	*
	* @param photoId the primary key of the photo
	* @return the photo
	* @throws PortalException if a photo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Photo getPhoto(long photoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _photoLocalService.getPhoto(photoId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _photoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the photos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of photos
	* @param end the upper bound of the range of photos (not inclusive)
	* @return the range of photos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.matrimony.model.Photo> getPhotos(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _photoLocalService.getPhotos(start, end);
	}

	/**
	* Returns the number of photos.
	*
	* @return the number of photos
	* @throws SystemException if a system exception occurred
	*/
	public int getPhotosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _photoLocalService.getPhotosCount();
	}

	/**
	* Updates the photo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param photo the photo
	* @return the photo that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Photo updatePhoto(
		com.matrimony.model.Photo photo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _photoLocalService.updatePhoto(photo);
	}

	/**
	* Updates the photo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param photo the photo
	* @param merge whether to merge the photo with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the photo that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.matrimony.model.Photo updatePhoto(
		com.matrimony.model.Photo photo, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _photoLocalService.updatePhoto(photo, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _photoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_photoLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _photoLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	public java.util.List<com.matrimony.model.Photo> getPhotoList(
		long profileId) throws java.lang.Exception {
		return _photoLocalService.getPhotoList(profileId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public PhotoLocalService getWrappedPhotoLocalService() {
		return _photoLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedPhotoLocalService(PhotoLocalService photoLocalService) {
		_photoLocalService = photoLocalService;
	}

	public PhotoLocalService getWrappedService() {
		return _photoLocalService;
	}

	public void setWrappedService(PhotoLocalService photoLocalService) {
		_photoLocalService = photoLocalService;
	}

	private PhotoLocalService _photoLocalService;
}