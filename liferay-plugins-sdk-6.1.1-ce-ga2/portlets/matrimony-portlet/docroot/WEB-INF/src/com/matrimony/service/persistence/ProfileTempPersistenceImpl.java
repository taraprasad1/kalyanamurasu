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

import com.matrimony.NoSuchProfileTempException;

import com.matrimony.model.ProfileTemp;
import com.matrimony.model.impl.ProfileTempImpl;
import com.matrimony.model.impl.ProfileTempModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the profile temp service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author matrimony
 * @see ProfileTempPersistence
 * @see ProfileTempUtil
 * @generated
 */
public class ProfileTempPersistenceImpl extends BasePersistenceImpl<ProfileTemp>
	implements ProfileTempPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProfileTempUtil} to access the profile temp persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProfileTempImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProfileTempModelImpl.ENTITY_CACHE_ENABLED,
			ProfileTempModelImpl.FINDER_CACHE_ENABLED, ProfileTempImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProfileTempModelImpl.ENTITY_CACHE_ENABLED,
			ProfileTempModelImpl.FINDER_CACHE_ENABLED, ProfileTempImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProfileTempModelImpl.ENTITY_CACHE_ENABLED,
			ProfileTempModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the profile temp in the entity cache if it is enabled.
	 *
	 * @param profileTemp the profile temp
	 */
	public void cacheResult(ProfileTemp profileTemp) {
		EntityCacheUtil.putResult(ProfileTempModelImpl.ENTITY_CACHE_ENABLED,
			ProfileTempImpl.class, profileTemp.getPrimaryKey(), profileTemp);

		profileTemp.resetOriginalValues();
	}

	/**
	 * Caches the profile temps in the entity cache if it is enabled.
	 *
	 * @param profileTemps the profile temps
	 */
	public void cacheResult(List<ProfileTemp> profileTemps) {
		for (ProfileTemp profileTemp : profileTemps) {
			if (EntityCacheUtil.getResult(
						ProfileTempModelImpl.ENTITY_CACHE_ENABLED,
						ProfileTempImpl.class, profileTemp.getPrimaryKey()) == null) {
				cacheResult(profileTemp);
			}
			else {
				profileTemp.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all profile temps.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ProfileTempImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ProfileTempImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the profile temp.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProfileTemp profileTemp) {
		EntityCacheUtil.removeResult(ProfileTempModelImpl.ENTITY_CACHE_ENABLED,
			ProfileTempImpl.class, profileTemp.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ProfileTemp> profileTemps) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProfileTemp profileTemp : profileTemps) {
			EntityCacheUtil.removeResult(ProfileTempModelImpl.ENTITY_CACHE_ENABLED,
				ProfileTempImpl.class, profileTemp.getPrimaryKey());
		}
	}

	/**
	 * Creates a new profile temp with the primary key. Does not add the profile temp to the database.
	 *
	 * @param profileTempId the primary key for the new profile temp
	 * @return the new profile temp
	 */
	public ProfileTemp create(long profileTempId) {
		ProfileTemp profileTemp = new ProfileTempImpl();

		profileTemp.setNew(true);
		profileTemp.setPrimaryKey(profileTempId);

		return profileTemp;
	}

	/**
	 * Removes the profile temp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileTempId the primary key of the profile temp
	 * @return the profile temp that was removed
	 * @throws com.matrimony.NoSuchProfileTempException if a profile temp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProfileTemp remove(long profileTempId)
		throws NoSuchProfileTempException, SystemException {
		return remove(Long.valueOf(profileTempId));
	}

	/**
	 * Removes the profile temp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the profile temp
	 * @return the profile temp that was removed
	 * @throws com.matrimony.NoSuchProfileTempException if a profile temp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProfileTemp remove(Serializable primaryKey)
		throws NoSuchProfileTempException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProfileTemp profileTemp = (ProfileTemp)session.get(ProfileTempImpl.class,
					primaryKey);

			if (profileTemp == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProfileTempException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(profileTemp);
		}
		catch (NoSuchProfileTempException nsee) {
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
	protected ProfileTemp removeImpl(ProfileTemp profileTemp)
		throws SystemException {
		profileTemp = toUnwrappedModel(profileTemp);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, profileTemp);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(profileTemp);

		return profileTemp;
	}

	@Override
	public ProfileTemp updateImpl(com.matrimony.model.ProfileTemp profileTemp,
		boolean merge) throws SystemException {
		profileTemp = toUnwrappedModel(profileTemp);

		boolean isNew = profileTemp.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, profileTemp, merge);

			profileTemp.setNew(false);
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

		EntityCacheUtil.putResult(ProfileTempModelImpl.ENTITY_CACHE_ENABLED,
			ProfileTempImpl.class, profileTemp.getPrimaryKey(), profileTemp);

		return profileTemp;
	}

	protected ProfileTemp toUnwrappedModel(ProfileTemp profileTemp) {
		if (profileTemp instanceof ProfileTempImpl) {
			return profileTemp;
		}

		ProfileTempImpl profileTempImpl = new ProfileTempImpl();

		profileTempImpl.setNew(profileTemp.isNew());
		profileTempImpl.setPrimaryKey(profileTemp.getPrimaryKey());

		profileTempImpl.setProfileTempId(profileTemp.getProfileTempId());
		profileTempImpl.setProfileId(profileTemp.getProfileId());
		profileTempImpl.setName(profileTemp.getName());
		profileTempImpl.setAddress(profileTemp.getAddress());
		profileTempImpl.setPinCode(profileTemp.getPinCode());
		profileTempImpl.setPhone(profileTemp.getPhone());
		profileTempImpl.setMobile(profileTemp.getMobile());
		profileTempImpl.setEmailAddress(profileTemp.getEmailAddress());
		profileTempImpl.setAboutMe(profileTemp.getAboutMe());
		profileTempImpl.setScheme(profileTemp.getScheme());

		return profileTempImpl;
	}

	/**
	 * Returns the profile temp with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the profile temp
	 * @return the profile temp
	 * @throws com.liferay.portal.NoSuchModelException if a profile temp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProfileTemp findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the profile temp with the primary key or throws a {@link com.matrimony.NoSuchProfileTempException} if it could not be found.
	 *
	 * @param profileTempId the primary key of the profile temp
	 * @return the profile temp
	 * @throws com.matrimony.NoSuchProfileTempException if a profile temp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProfileTemp findByPrimaryKey(long profileTempId)
		throws NoSuchProfileTempException, SystemException {
		ProfileTemp profileTemp = fetchByPrimaryKey(profileTempId);

		if (profileTemp == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + profileTempId);
			}

			throw new NoSuchProfileTempException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				profileTempId);
		}

		return profileTemp;
	}

	/**
	 * Returns the profile temp with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the profile temp
	 * @return the profile temp, or <code>null</code> if a profile temp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProfileTemp fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the profile temp with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param profileTempId the primary key of the profile temp
	 * @return the profile temp, or <code>null</code> if a profile temp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProfileTemp fetchByPrimaryKey(long profileTempId)
		throws SystemException {
		ProfileTemp profileTemp = (ProfileTemp)EntityCacheUtil.getResult(ProfileTempModelImpl.ENTITY_CACHE_ENABLED,
				ProfileTempImpl.class, profileTempId);

		if (profileTemp == _nullProfileTemp) {
			return null;
		}

		if (profileTemp == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				profileTemp = (ProfileTemp)session.get(ProfileTempImpl.class,
						Long.valueOf(profileTempId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (profileTemp != null) {
					cacheResult(profileTemp);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ProfileTempModelImpl.ENTITY_CACHE_ENABLED,
						ProfileTempImpl.class, profileTempId, _nullProfileTemp);
				}

				closeSession(session);
			}
		}

		return profileTemp;
	}

	/**
	 * Returns all the profile temps.
	 *
	 * @return the profile temps
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProfileTemp> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the profile temps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile temps
	 * @param end the upper bound of the range of profile temps (not inclusive)
	 * @return the range of profile temps
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProfileTemp> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the profile temps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile temps
	 * @param end the upper bound of the range of profile temps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of profile temps
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProfileTemp> findAll(int start, int end,
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

		List<ProfileTemp> list = (List<ProfileTemp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROFILETEMP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROFILETEMP;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ProfileTemp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProfileTemp>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the profile temps from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ProfileTemp profileTemp : findAll()) {
			remove(profileTemp);
		}
	}

	/**
	 * Returns the number of profile temps.
	 *
	 * @return the number of profile temps
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROFILETEMP);

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
	 * Initializes the profile temp persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.matrimony.model.ProfileTemp")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProfileTemp>> listenersList = new ArrayList<ModelListener<ProfileTemp>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProfileTemp>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ProfileTempImpl.class.getName());
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
	private static final String _SQL_SELECT_PROFILETEMP = "SELECT profileTemp FROM ProfileTemp profileTemp";
	private static final String _SQL_COUNT_PROFILETEMP = "SELECT COUNT(profileTemp) FROM ProfileTemp profileTemp";
	private static final String _ORDER_BY_ENTITY_ALIAS = "profileTemp.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProfileTemp exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ProfileTempPersistenceImpl.class);
	private static ProfileTemp _nullProfileTemp = new ProfileTempImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ProfileTemp> toCacheModel() {
				return _nullProfileTempCacheModel;
			}
		};

	private static CacheModel<ProfileTemp> _nullProfileTempCacheModel = new CacheModel<ProfileTemp>() {
			public ProfileTemp toEntityModel() {
				return _nullProfileTemp;
			}
		};
}