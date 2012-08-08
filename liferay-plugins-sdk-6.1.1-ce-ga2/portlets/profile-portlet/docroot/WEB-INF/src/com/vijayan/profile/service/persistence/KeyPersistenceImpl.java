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

package com.vijayan.profile.service.persistence;

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

import com.vijayan.profile.NoSuchKeyException;
import com.vijayan.profile.model.Key;
import com.vijayan.profile.model.impl.KeyImpl;
import com.vijayan.profile.model.impl.KeyModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the key service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ravi
 * @see KeyPersistence
 * @see KeyUtil
 * @generated
 */
public class KeyPersistenceImpl extends BasePersistenceImpl<Key>
	implements KeyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link KeyUtil} to access the key persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = KeyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(KeyModelImpl.ENTITY_CACHE_ENABLED,
			KeyModelImpl.FINDER_CACHE_ENABLED, KeyImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByname",
			new String[] { String.class.getName() },
			KeyModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(KeyModelImpl.ENTITY_CACHE_ENABLED,
			KeyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByname",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(KeyModelImpl.ENTITY_CACHE_ENABLED,
			KeyModelImpl.FINDER_CACHE_ENABLED, KeyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(KeyModelImpl.ENTITY_CACHE_ENABLED,
			KeyModelImpl.FINDER_CACHE_ENABLED, KeyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(KeyModelImpl.ENTITY_CACHE_ENABLED,
			KeyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the key in the entity cache if it is enabled.
	 *
	 * @param key the key
	 */
	public void cacheResult(Key key) {
		EntityCacheUtil.putResult(KeyModelImpl.ENTITY_CACHE_ENABLED,
			KeyImpl.class, key.getPrimaryKey(), key);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { key.getName() }, key);

		key.resetOriginalValues();
	}

	/**
	 * Caches the keies in the entity cache if it is enabled.
	 *
	 * @param keies the keies
	 */
	public void cacheResult(List<Key> keies) {
		for (Key key : keies) {
			if (EntityCacheUtil.getResult(KeyModelImpl.ENTITY_CACHE_ENABLED,
						KeyImpl.class, key.getPrimaryKey()) == null) {
				cacheResult(key);
			}
			else {
				key.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all keies.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(KeyImpl.class.getName());
		}

		EntityCacheUtil.clearCache(KeyImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the key.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Key key) {
		EntityCacheUtil.removeResult(KeyModelImpl.ENTITY_CACHE_ENABLED,
			KeyImpl.class, key.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(key);
	}

	@Override
	public void clearCache(List<Key> keies) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Key key : keies) {
			EntityCacheUtil.removeResult(KeyModelImpl.ENTITY_CACHE_ENABLED,
				KeyImpl.class, key.getPrimaryKey());

			clearUniqueFindersCache(key);
		}
	}

	protected void clearUniqueFindersCache(Key key) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { key.getName() });
	}

	/**
	 * Creates a new key with the primary key. Does not add the key to the database.
	 *
	 * @param keyId the primary key for the new key
	 * @return the new key
	 */
	public Key create(long keyId) {
		Key key = new KeyImpl();

		key.setNew(true);
		key.setPrimaryKey(keyId);

		return key;
	}

	/**
	 * Removes the key with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param keyId the primary key of the key
	 * @return the key that was removed
	 * @throws com.vijayan.profile.NoSuchKeyException if a key with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Key remove(long keyId) throws NoSuchKeyException, SystemException {
		return remove(Long.valueOf(keyId));
	}

	/**
	 * Removes the key with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the key
	 * @return the key that was removed
	 * @throws com.vijayan.profile.NoSuchKeyException if a key with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Key remove(Serializable primaryKey)
		throws NoSuchKeyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Key key = (Key)session.get(KeyImpl.class, primaryKey);

			if (key == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchKeyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(key);
		}
		catch (NoSuchKeyException nsee) {
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
	protected Key removeImpl(Key key) throws SystemException {
		key = toUnwrappedModel(key);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, key);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(key);

		return key;
	}

	@Override
	public Key updateImpl(com.vijayan.profile.model.Key key, boolean merge)
		throws SystemException {
		key = toUnwrappedModel(key);

		boolean isNew = key.isNew();

		KeyModelImpl keyModelImpl = (KeyModelImpl)key;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, key, merge);

			key.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !KeyModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(KeyModelImpl.ENTITY_CACHE_ENABLED,
			KeyImpl.class, key.getPrimaryKey(), key);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
				new Object[] { key.getName() }, key);
		}
		else {
			if ((keyModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { keyModelImpl.getOriginalName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
					new Object[] { key.getName() }, key);
			}
		}

		return key;
	}

	protected Key toUnwrappedModel(Key key) {
		if (key instanceof KeyImpl) {
			return key;
		}

		KeyImpl keyImpl = new KeyImpl();

		keyImpl.setNew(key.isNew());
		keyImpl.setPrimaryKey(key.getPrimaryKey());

		keyImpl.setKeyId(key.getKeyId());
		keyImpl.setName(key.getName());

		return keyImpl;
	}

	/**
	 * Returns the key with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the key
	 * @return the key
	 * @throws com.liferay.portal.NoSuchModelException if a key with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Key findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the key with the primary key or throws a {@link com.vijayan.profile.NoSuchKeyException} if it could not be found.
	 *
	 * @param keyId the primary key of the key
	 * @return the key
	 * @throws com.vijayan.profile.NoSuchKeyException if a key with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Key findByPrimaryKey(long keyId)
		throws NoSuchKeyException, SystemException {
		Key key = fetchByPrimaryKey(keyId);

		if (key == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + keyId);
			}

			throw new NoSuchKeyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				keyId);
		}

		return key;
	}

	/**
	 * Returns the key with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the key
	 * @return the key, or <code>null</code> if a key with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Key fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the key with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param keyId the primary key of the key
	 * @return the key, or <code>null</code> if a key with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Key fetchByPrimaryKey(long keyId) throws SystemException {
		Key key = (Key)EntityCacheUtil.getResult(KeyModelImpl.ENTITY_CACHE_ENABLED,
				KeyImpl.class, keyId);

		if (key == _nullKey) {
			return null;
		}

		if (key == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				key = (Key)session.get(KeyImpl.class, Long.valueOf(keyId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (key != null) {
					cacheResult(key);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(KeyModelImpl.ENTITY_CACHE_ENABLED,
						KeyImpl.class, keyId, _nullKey);
				}

				closeSession(session);
			}
		}

		return key;
	}

	/**
	 * Returns the key where name = &#63; or throws a {@link com.vijayan.profile.NoSuchKeyException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching key
	 * @throws com.vijayan.profile.NoSuchKeyException if a matching key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Key findByname(String name)
		throws NoSuchKeyException, SystemException {
		Key key = fetchByname(name);

		if (key == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchKeyException(msg.toString());
		}

		return key;
	}

	/**
	 * Returns the key where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching key, or <code>null</code> if a matching key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Key fetchByname(String name) throws SystemException {
		return fetchByname(name, true);
	}

	/**
	 * Returns the key where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching key, or <code>null</code> if a matching key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Key fetchByname(String name, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result instanceof Key) {
			Key key = (Key)result;

			if (!Validator.equals(name, key.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_SELECT_KEY_WHERE);

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

				List<Key> list = q.list();

				result = list;

				Key key = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					key = list.get(0);

					cacheResult(key);

					if ((key.getName() == null) || !key.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, key);
					}
				}

				return key;
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
				return (Key)result;
			}
		}
	}

	/**
	 * Returns all the keies.
	 *
	 * @return the keies
	 * @throws SystemException if a system exception occurred
	 */
	public List<Key> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the keies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of keies
	 * @param end the upper bound of the range of keies (not inclusive)
	 * @return the range of keies
	 * @throws SystemException if a system exception occurred
	 */
	public List<Key> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the keies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of keies
	 * @param end the upper bound of the range of keies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of keies
	 * @throws SystemException if a system exception occurred
	 */
	public List<Key> findAll(int start, int end,
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

		List<Key> list = (List<Key>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_KEY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_KEY;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Key>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Key>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Removes the key where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the key that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public Key removeByname(String name)
		throws NoSuchKeyException, SystemException {
		Key key = findByname(name);

		return remove(key);
	}

	/**
	 * Removes all the keies from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Key key : findAll()) {
			remove(key);
		}
	}

	/**
	 * Returns the number of keies where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching keies
	 * @throws SystemException if a system exception occurred
	 */
	public int countByname(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_KEY_WHERE);

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
	 * Returns the number of keies.
	 *
	 * @return the number of keies
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_KEY);

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
	 * Initializes the key persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vijayan.profile.model.Key")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Key>> listenersList = new ArrayList<ModelListener<Key>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Key>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(KeyImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = KeyPersistence.class)
	protected KeyPersistence keyPersistence;
	@BeanReference(type = KeyValuePersistence.class)
	protected KeyValuePersistence keyValuePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_KEY = "SELECT key FROM Key key";
	private static final String _SQL_SELECT_KEY_WHERE = "SELECT key FROM Key key WHERE ";
	private static final String _SQL_COUNT_KEY = "SELECT COUNT(key) FROM Key key";
	private static final String _SQL_COUNT_KEY_WHERE = "SELECT COUNT(key) FROM Key key WHERE ";
	private static final String _FINDER_COLUMN_NAME_NAME_1 = "key.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "key.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(key.name IS NULL OR key.name = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "key.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Key exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Key exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(KeyPersistenceImpl.class);
	private static Key _nullKey = new KeyImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Key> toCacheModel() {
				return _nullKeyCacheModel;
			}
		};

	private static CacheModel<Key> _nullKeyCacheModel = new CacheModel<Key>() {
			public Key toEntityModel() {
				return _nullKey;
			}
		};
}