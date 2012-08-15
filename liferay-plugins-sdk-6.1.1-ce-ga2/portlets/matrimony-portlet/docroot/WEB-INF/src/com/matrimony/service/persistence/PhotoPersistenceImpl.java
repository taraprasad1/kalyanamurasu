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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.matrimony.NoSuchPhotoException;

import com.matrimony.model.Photo;
import com.matrimony.model.impl.PhotoImpl;
import com.matrimony.model.impl.PhotoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the photo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author matrimony
 * @see PhotoPersistence
 * @see PhotoUtil
 * @generated
 */
public class PhotoPersistenceImpl extends BasePersistenceImpl<Photo>
	implements PhotoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PhotoUtil} to access the photo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PhotoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, PhotoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, PhotoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the photo in the entity cache if it is enabled.
	 *
	 * @param photo the photo
	 */
	public void cacheResult(Photo photo) {
		EntityCacheUtil.putResult(PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoImpl.class, photo.getPrimaryKey(), photo);

		photo.resetOriginalValues();
	}

	/**
	 * Caches the photos in the entity cache if it is enabled.
	 *
	 * @param photos the photos
	 */
	public void cacheResult(List<Photo> photos) {
		for (Photo photo : photos) {
			if (EntityCacheUtil.getResult(PhotoModelImpl.ENTITY_CACHE_ENABLED,
						PhotoImpl.class, photo.getPrimaryKey()) == null) {
				cacheResult(photo);
			}
			else {
				photo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all photos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PhotoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PhotoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the photo.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Photo photo) {
		EntityCacheUtil.removeResult(PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoImpl.class, photo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Photo> photos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Photo photo : photos) {
			EntityCacheUtil.removeResult(PhotoModelImpl.ENTITY_CACHE_ENABLED,
				PhotoImpl.class, photo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new photo with the primary key. Does not add the photo to the database.
	 *
	 * @param photoId the primary key for the new photo
	 * @return the new photo
	 */
	public Photo create(long photoId) {
		Photo photo = new PhotoImpl();

		photo.setNew(true);
		photo.setPrimaryKey(photoId);

		return photo;
	}

	/**
	 * Removes the photo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param photoId the primary key of the photo
	 * @return the photo that was removed
	 * @throws com.matrimony.NoSuchPhotoException if a photo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Photo remove(long photoId)
		throws NoSuchPhotoException, SystemException {
		return remove(Long.valueOf(photoId));
	}

	/**
	 * Removes the photo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the photo
	 * @return the photo that was removed
	 * @throws com.matrimony.NoSuchPhotoException if a photo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Photo remove(Serializable primaryKey)
		throws NoSuchPhotoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Photo photo = (Photo)session.get(PhotoImpl.class, primaryKey);

			if (photo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPhotoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(photo);
		}
		catch (NoSuchPhotoException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Photo removeImpl(Photo photo) throws SystemException {
		photo = toUnwrappedModel(photo);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, photo);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(photo);

		return photo;
	}

	@Override
	public Photo updateImpl(com.matrimony.model.Photo photo, boolean merge)
		throws SystemException {
		photo = toUnwrappedModel(photo);

		boolean isNew = photo.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, photo, merge);

			photo.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoImpl.class, photo.getPrimaryKey(), photo);

		return photo;
	}

	protected Photo toUnwrappedModel(Photo photo) {
		if (photo instanceof PhotoImpl) {
			return photo;
		}

		PhotoImpl photoImpl = new PhotoImpl();

		photoImpl.setNew(photo.isNew());
		photoImpl.setPrimaryKey(photo.getPrimaryKey());

		photoImpl.setPhotoId(photo.getPhotoId());
		photoImpl.setProfileId(photo.getProfileId());
		photoImpl.setContent(photo.getContent());
		photoImpl.setName(photo.getName());
		photoImpl.setType(photo.getType());
		photoImpl.setThumbnail(photo.isThumbnail());

		return photoImpl;
	}

	/**
	 * Returns the photo with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the photo
	 * @return the photo
	 * @throws com.liferay.portal.NoSuchModelException if a photo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Photo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the photo with the primary key or throws a {@link com.matrimony.NoSuchPhotoException} if it could not be found.
	 *
	 * @param photoId the primary key of the photo
	 * @return the photo
	 * @throws com.matrimony.NoSuchPhotoException if a photo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Photo findByPrimaryKey(long photoId)
		throws NoSuchPhotoException, SystemException {
		Photo photo = fetchByPrimaryKey(photoId);

		if (photo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + photoId);
			}

			throw new NoSuchPhotoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				photoId);
		}

		return photo;
	}

	/**
	 * Returns the photo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the photo
	 * @return the photo, or <code>null</code> if a photo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Photo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the photo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param photoId the primary key of the photo
	 * @return the photo, or <code>null</code> if a photo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Photo fetchByPrimaryKey(long photoId) throws SystemException {
		Photo photo = (Photo)EntityCacheUtil.getResult(PhotoModelImpl.ENTITY_CACHE_ENABLED,
				PhotoImpl.class, photoId);

		if (photo == _nullPhoto) {
			return null;
		}

		if (photo == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				photo = (Photo)session.get(PhotoImpl.class,
						Long.valueOf(photoId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (photo != null) {
					cacheResult(photo);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(PhotoModelImpl.ENTITY_CACHE_ENABLED,
						PhotoImpl.class, photoId, _nullPhoto);
				}

				closeSession(session);
			}
		}

		return photo;
	}

	/**
	 * Returns all the photos.
	 *
	 * @return the photos
	 * @throws SystemException if a system exception occurred
	 */
	public List<Photo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Photo> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	public List<Photo> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Photo> list = (List<Photo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PHOTO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PHOTO;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Photo>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Photo>)QueryUtil.list(q, getDialect(), start,
							end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the photos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Photo photo : findAll()) {
			remove(photo);
		}
	}

	/**
	 * Returns the number of photos.
	 *
	 * @return the number of photos
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PHOTO);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the photo persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.matrimony.model.Photo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Photo>> listenersList = new ArrayList<ModelListener<Photo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Photo>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(PhotoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = InteractionPersistence.class)
	protected InteractionPersistence interactionPersistence;
	@BeanReference(type = KeyPersistence.class)
	protected KeyPersistence keyPersistence;
	@BeanReference(type = KeyValuePersistence.class)
	protected KeyValuePersistence keyValuePersistence;
	@BeanReference(type = PhotoPersistence.class)
	protected PhotoPersistence photoPersistence;
	@BeanReference(type = ProfilePersistence.class)
	protected ProfilePersistence profilePersistence;
	@BeanReference(type = ProfileTempPersistence.class)
	protected ProfileTempPersistence profileTempPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_PHOTO = "SELECT photo FROM Photo photo";
	private static final String _SQL_COUNT_PHOTO = "SELECT COUNT(photo) FROM Photo photo";
	private static final String _ORDER_BY_ENTITY_ALIAS = "photo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Photo exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PhotoPersistenceImpl.class);
	private static Photo _nullPhoto = new PhotoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Photo> toCacheModel() {
				return _nullPhotoCacheModel;
			}
		};

	private static CacheModel<Photo> _nullPhotoCacheModel = new CacheModel<Photo>() {
			public Photo toEntityModel() {
				return _nullPhoto;
			}
		};
}