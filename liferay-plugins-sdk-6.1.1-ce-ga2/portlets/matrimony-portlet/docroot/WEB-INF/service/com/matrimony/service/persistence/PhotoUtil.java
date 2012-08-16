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

package com.matrimony.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.matrimony.model.Photo;

import java.util.List;

/**
 * The persistence utility for the photo service. This utility wraps {@link PhotoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author matrimony
 * @see PhotoPersistence
 * @see PhotoPersistenceImpl
 * @generated
 */
public class PhotoUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Photo photo) {
		getPersistence().clearCache(photo);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Photo> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Photo> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Photo> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Photo update(Photo photo, boolean merge)
		throws SystemException {
		return getPersistence().update(photo, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Photo update(Photo photo, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(photo, merge, serviceContext);
	}

	/**
	* Caches the photo in the entity cache if it is enabled.
	*
	* @param photo the photo
	*/
	public static void cacheResult(com.matrimony.model.Photo photo) {
		getPersistence().cacheResult(photo);
	}

	/**
	* Caches the photos in the entity cache if it is enabled.
	*
	* @param photos the photos
	*/
	public static void cacheResult(
		java.util.List<com.matrimony.model.Photo> photos) {
		getPersistence().cacheResult(photos);
	}

	/**
	* Creates a new photo with the primary key. Does not add the photo to the database.
	*
	* @param photoId the primary key for the new photo
	* @return the new photo
	*/
	public static com.matrimony.model.Photo create(long photoId) {
		return getPersistence().create(photoId);
	}

	/**
	* Removes the photo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param photoId the primary key of the photo
	* @return the photo that was removed
	* @throws com.matrimony.NoSuchPhotoException if a photo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Photo remove(long photoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchPhotoException {
		return getPersistence().remove(photoId);
	}

	public static com.matrimony.model.Photo updateImpl(
		com.matrimony.model.Photo photo, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(photo, merge);
	}

	/**
	* Returns the photo with the primary key or throws a {@link com.matrimony.NoSuchPhotoException} if it could not be found.
	*
	* @param photoId the primary key of the photo
	* @return the photo
	* @throws com.matrimony.NoSuchPhotoException if a photo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Photo findByPrimaryKey(long photoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchPhotoException {
		return getPersistence().findByPrimaryKey(photoId);
	}

	/**
	* Returns the photo with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param photoId the primary key of the photo
	* @return the photo, or <code>null</code> if a photo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Photo fetchByPrimaryKey(long photoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(photoId);
	}

	/**
	* Returns all the photos where profileId = &#63;.
	*
	* @param profileId the profile ID
	* @return the matching photos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.Photo> findByProfileId(
		long profileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProfileId(profileId);
	}

	/**
	* Returns a range of all the photos where profileId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param profileId the profile ID
	* @param start the lower bound of the range of photos
	* @param end the upper bound of the range of photos (not inclusive)
	* @return the range of matching photos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.Photo> findByProfileId(
		long profileId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProfileId(profileId, start, end);
	}

	/**
	* Returns an ordered range of all the photos where profileId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param profileId the profile ID
	* @param start the lower bound of the range of photos
	* @param end the upper bound of the range of photos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching photos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.Photo> findByProfileId(
		long profileId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProfileId(profileId, start, end, orderByComparator);
	}

	/**
	* Returns the first photo in the ordered set where profileId = &#63;.
	*
	* @param profileId the profile ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching photo
	* @throws com.matrimony.NoSuchPhotoException if a matching photo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Photo findByProfileId_First(
		long profileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchPhotoException {
		return getPersistence()
				   .findByProfileId_First(profileId, orderByComparator);
	}

	/**
	* Returns the first photo in the ordered set where profileId = &#63;.
	*
	* @param profileId the profile ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching photo, or <code>null</code> if a matching photo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Photo fetchByProfileId_First(
		long profileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProfileId_First(profileId, orderByComparator);
	}

	/**
	* Returns the last photo in the ordered set where profileId = &#63;.
	*
	* @param profileId the profile ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching photo
	* @throws com.matrimony.NoSuchPhotoException if a matching photo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Photo findByProfileId_Last(
		long profileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchPhotoException {
		return getPersistence()
				   .findByProfileId_Last(profileId, orderByComparator);
	}

	/**
	* Returns the last photo in the ordered set where profileId = &#63;.
	*
	* @param profileId the profile ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching photo, or <code>null</code> if a matching photo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Photo fetchByProfileId_Last(
		long profileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProfileId_Last(profileId, orderByComparator);
	}

	/**
	* Returns the photos before and after the current photo in the ordered set where profileId = &#63;.
	*
	* @param photoId the primary key of the current photo
	* @param profileId the profile ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next photo
	* @throws com.matrimony.NoSuchPhotoException if a photo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.matrimony.model.Photo[] findByProfileId_PrevAndNext(
		long photoId, long profileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.matrimony.NoSuchPhotoException {
		return getPersistence()
				   .findByProfileId_PrevAndNext(photoId, profileId,
			orderByComparator);
	}

	/**
	* Returns all the photos.
	*
	* @return the photos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.Photo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.matrimony.model.Photo> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the photos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of photos
	* @param end the upper bound of the range of photos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of photos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.matrimony.model.Photo> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the photos where profileId = &#63; from the database.
	*
	* @param profileId the profile ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByProfileId(long profileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByProfileId(profileId);
	}

	/**
	* Removes all the photos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of photos where profileId = &#63;.
	*
	* @param profileId the profile ID
	* @return the number of matching photos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProfileId(long profileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByProfileId(profileId);
	}

	/**
	* Returns the number of photos.
	*
	* @return the number of photos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PhotoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PhotoPersistence)PortletBeanLocatorUtil.locate(com.matrimony.service.ClpSerializer.getServletContextName(),
					PhotoPersistence.class.getName());

			ReferenceRegistry.registerReference(PhotoUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(PhotoPersistence persistence) {
	}

	private static PhotoPersistence _persistence;
}