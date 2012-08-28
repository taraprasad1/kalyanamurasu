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
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.matrimony.NoSuchReligionException;

import com.matrimony.model.Religion;
import com.matrimony.model.impl.ReligionImpl;
import com.matrimony.model.impl.ReligionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the religion service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author matrimony
 * @see ReligionPersistence
 * @see ReligionUtil
 * @generated
 */
public class ReligionPersistenceImpl extends BasePersistenceImpl<Religion>
	implements ReligionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ReligionUtil} to access the religion persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ReligionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(ReligionModelImpl.ENTITY_CACHE_ENABLED,
			ReligionModelImpl.FINDER_CACHE_ENABLED, ReligionImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] { String.class.getName() },
			ReligionModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(ReligionModelImpl.ENTITY_CACHE_ENABLED,
			ReligionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ReligionModelImpl.ENTITY_CACHE_ENABLED,
			ReligionModelImpl.FINDER_CACHE_ENABLED, ReligionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ReligionModelImpl.ENTITY_CACHE_ENABLED,
			ReligionModelImpl.FINDER_CACHE_ENABLED, ReligionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ReligionModelImpl.ENTITY_CACHE_ENABLED,
			ReligionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the religion in the entity cache if it is enabled.
	 *
	 * @param religion the religion
	 */
	public void cacheResult(Religion religion) {
		EntityCacheUtil.putResult(ReligionModelImpl.ENTITY_CACHE_ENABLED,
			ReligionImpl.class, religion.getPrimaryKey(), religion);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { religion.getName() }, religion);

		religion.resetOriginalValues();
	}

	/**
	 * Caches the religions in the entity cache if it is enabled.
	 *
	 * @param religions the religions
	 */
	public void cacheResult(List<Religion> religions) {
		for (Religion religion : religions) {
			if (EntityCacheUtil.getResult(
						ReligionModelImpl.ENTITY_CACHE_ENABLED,
						ReligionImpl.class, religion.getPrimaryKey()) == null) {
				cacheResult(religion);
			}
			else {
				religion.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all religions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ReligionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ReligionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the religion.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Religion religion) {
		EntityCacheUtil.removeResult(ReligionModelImpl.ENTITY_CACHE_ENABLED,
			ReligionImpl.class, religion.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(religion);
	}

	@Override
	public void clearCache(List<Religion> religions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Religion religion : religions) {
			EntityCacheUtil.removeResult(ReligionModelImpl.ENTITY_CACHE_ENABLED,
				ReligionImpl.class, religion.getPrimaryKey());

			clearUniqueFindersCache(religion);
		}
	}

	protected void clearUniqueFindersCache(Religion religion) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { religion.getName() });
	}

	/**
	 * Creates a new religion with the primary key. Does not add the religion to the database.
	 *
	 * @param religionId the primary key for the new religion
	 * @return the new religion
	 */
	public Religion create(long religionId) {
		Religion religion = new ReligionImpl();

		religion.setNew(true);
		religion.setPrimaryKey(religionId);

		return religion;
	}

	/**
	 * Removes the religion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param religionId the primary key of the religion
	 * @return the religion that was removed
	 * @throws com.matrimony.NoSuchReligionException if a religion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Religion remove(long religionId)
		throws NoSuchReligionException, SystemException {
		return remove(Long.valueOf(religionId));
	}

	/**
	 * Removes the religion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the religion
	 * @return the religion that was removed
	 * @throws com.matrimony.NoSuchReligionException if a religion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Religion remove(Serializable primaryKey)
		throws NoSuchReligionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Religion religion = (Religion)session.get(ReligionImpl.class,
					primaryKey);

			if (religion == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchReligionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(religion);
		}
		catch (NoSuchReligionException nsee) {
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
	protected Religion removeImpl(Religion religion) throws SystemException {
		religion = toUnwrappedModel(religion);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, religion);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(religion);

		return religion;
	}

	@Override
	public Religion updateImpl(com.matrimony.model.Religion religion,
		boolean merge) throws SystemException {
		religion = toUnwrappedModel(religion);

		boolean isNew = religion.isNew();

		ReligionModelImpl religionModelImpl = (ReligionModelImpl)religion;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, religion, merge);

			religion.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ReligionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(ReligionModelImpl.ENTITY_CACHE_ENABLED,
			ReligionImpl.class, religion.getPrimaryKey(), religion);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
				new Object[] { religion.getName() }, religion);
		}
		else {
			if ((religionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { religionModelImpl.getOriginalName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
					new Object[] { religion.getName() }, religion);
			}
		}

		return religion;
	}

	protected Religion toUnwrappedModel(Religion religion) {
		if (religion instanceof ReligionImpl) {
			return religion;
		}

		ReligionImpl religionImpl = new ReligionImpl();

		religionImpl.setNew(religion.isNew());
		religionImpl.setPrimaryKey(religion.getPrimaryKey());

		religionImpl.setReligionId(religion.getReligionId());
		religionImpl.setName(religion.getName());

		return religionImpl;
	}

	/**
	 * Returns the religion with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the religion
	 * @return the religion
	 * @throws com.liferay.portal.NoSuchModelException if a religion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Religion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the religion with the primary key or throws a {@link com.matrimony.NoSuchReligionException} if it could not be found.
	 *
	 * @param religionId the primary key of the religion
	 * @return the religion
	 * @throws com.matrimony.NoSuchReligionException if a religion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Religion findByPrimaryKey(long religionId)
		throws NoSuchReligionException, SystemException {
		Religion religion = fetchByPrimaryKey(religionId);

		if (religion == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + religionId);
			}

			throw new NoSuchReligionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				religionId);
		}

		return religion;
	}

	/**
	 * Returns the religion with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the religion
	 * @return the religion, or <code>null</code> if a religion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Religion fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the religion with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param religionId the primary key of the religion
	 * @return the religion, or <code>null</code> if a religion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Religion fetchByPrimaryKey(long religionId)
		throws SystemException {
		Religion religion = (Religion)EntityCacheUtil.getResult(ReligionModelImpl.ENTITY_CACHE_ENABLED,
				ReligionImpl.class, religionId);

		if (religion == _nullReligion) {
			return null;
		}

		if (religion == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				religion = (Religion)session.get(ReligionImpl.class,
						Long.valueOf(religionId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (religion != null) {
					cacheResult(religion);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ReligionModelImpl.ENTITY_CACHE_ENABLED,
						ReligionImpl.class, religionId, _nullReligion);
				}

				closeSession(session);
			}
		}

		return religion;
	}

	/**
	 * Returns the religion where name = &#63; or throws a {@link com.matrimony.NoSuchReligionException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching religion
	 * @throws com.matrimony.NoSuchReligionException if a matching religion could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Religion findByName(String name)
		throws NoSuchReligionException, SystemException {
		Religion religion = fetchByName(name);

		if (religion == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchReligionException(msg.toString());
		}

		return religion;
	}

	/**
	 * Returns the religion where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching religion, or <code>null</code> if a matching religion could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Religion fetchByName(String name) throws SystemException {
		return fetchByName(name, true);
	}

	/**
	 * Returns the religion where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching religion, or <code>null</code> if a matching religion could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Religion fetchByName(String name, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result instanceof Religion) {
			Religion religion = (Religion)result;

			if (!Validator.equals(name, religion.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_SELECT_RELIGION_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAME_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAME_NAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				List<Religion> list = q.list();

				result = list;

				Religion religion = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					religion = list.get(0);

					cacheResult(religion);

					if ((religion.getName() == null) ||
							!religion.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, religion);
					}
				}

				return religion;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (Religion)result;
			}
		}
	}

	/**
	 * Returns all the religions.
	 *
	 * @return the religions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Religion> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the religions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of religions
	 * @param end the upper bound of the range of religions (not inclusive)
	 * @return the range of religions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Religion> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the religions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of religions
	 * @param end the upper bound of the range of religions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of religions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Religion> findAll(int start, int end,
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

		List<Religion> list = (List<Religion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RELIGION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RELIGION;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Religion>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Religion>)QueryUtil.list(q, getDialect(),
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
	 * Removes the religion where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the religion that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public Religion removeByName(String name)
		throws NoSuchReligionException, SystemException {
		Religion religion = findByName(name);

		return remove(religion);
	}

	/**
	 * Removes all the religions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Religion religion : findAll()) {
			remove(religion);
		}
	}

	/**
	 * Returns the number of religions where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching religions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByName(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RELIGION_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAME_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAME_NAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of religions.
	 *
	 * @return the number of religions
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RELIGION);

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
	 * Initializes the religion persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.matrimony.model.Religion")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Religion>> listenersList = new ArrayList<ModelListener<Religion>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Religion>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ReligionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CastePersistence.class)
	protected CastePersistence castePersistence;
	@BeanReference(type = CityPersistence.class)
	protected CityPersistence cityPersistence;
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
	@BeanReference(type = ProfileKeyValuePersistence.class)
	protected ProfileKeyValuePersistence profileKeyValuePersistence;
	@BeanReference(type = ProfileTempPersistence.class)
	protected ProfileTempPersistence profileTempPersistence;
	@BeanReference(type = ReligionPersistence.class)
	protected ReligionPersistence religionPersistence;
	@BeanReference(type = SubCastePersistence.class)
	protected SubCastePersistence subCastePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_RELIGION = "SELECT religion FROM Religion religion";
	private static final String _SQL_SELECT_RELIGION_WHERE = "SELECT religion FROM Religion religion WHERE ";
	private static final String _SQL_COUNT_RELIGION = "SELECT COUNT(religion) FROM Religion religion";
	private static final String _SQL_COUNT_RELIGION_WHERE = "SELECT COUNT(religion) FROM Religion religion WHERE ";
	private static final String _FINDER_COLUMN_NAME_NAME_1 = "religion.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "religion.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(religion.name IS NULL OR religion.name = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "religion.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Religion exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Religion exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ReligionPersistenceImpl.class);
	private static Religion _nullReligion = new ReligionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Religion> toCacheModel() {
				return _nullReligionCacheModel;
			}
		};

	private static CacheModel<Religion> _nullReligionCacheModel = new CacheModel<Religion>() {
			public Religion toEntityModel() {
				return _nullReligion;
			}
		};
}