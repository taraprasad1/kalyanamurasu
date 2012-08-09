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

import com.matrimony.NoSuchKeyValueException;

import com.matrimony.model.KeyValue;
import com.matrimony.model.impl.KeyValueImpl;
import com.matrimony.model.impl.KeyValueModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the key value service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author matrimony
 * @see KeyValuePersistence
 * @see KeyValueUtil
 * @generated
 */
public class KeyValuePersistenceImpl extends BasePersistenceImpl<KeyValue>
	implements KeyValuePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link KeyValueUtil} to access the key value persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = KeyValueImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_KEYID = new FinderPath(KeyValueModelImpl.ENTITY_CACHE_ENABLED,
			KeyValueModelImpl.FINDER_CACHE_ENABLED, KeyValueImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByKeyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_KEYID = new FinderPath(KeyValueModelImpl.ENTITY_CACHE_ENABLED,
			KeyValueModelImpl.FINDER_CACHE_ENABLED, KeyValueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByKeyId",
			new String[] { Long.class.getName() },
			KeyValueModelImpl.KEYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_KEYID = new FinderPath(KeyValueModelImpl.ENTITY_CACHE_ENABLED,
			KeyValueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByKeyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_VALUENAME = new FinderPath(KeyValueModelImpl.ENTITY_CACHE_ENABLED,
			KeyValueModelImpl.FINDER_CACHE_ENABLED, KeyValueImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByvalueName",
			new String[] { String.class.getName(), Long.class.getName() },
			KeyValueModelImpl.NAME_COLUMN_BITMASK |
			KeyValueModelImpl.KEYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VALUENAME = new FinderPath(KeyValueModelImpl.ENTITY_CACHE_ENABLED,
			KeyValueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByvalueName",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(KeyValueModelImpl.ENTITY_CACHE_ENABLED,
			KeyValueModelImpl.FINDER_CACHE_ENABLED, KeyValueImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(KeyValueModelImpl.ENTITY_CACHE_ENABLED,
			KeyValueModelImpl.FINDER_CACHE_ENABLED, KeyValueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(KeyValueModelImpl.ENTITY_CACHE_ENABLED,
			KeyValueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the key value in the entity cache if it is enabled.
	 *
	 * @param keyValue the key value
	 */
	public void cacheResult(KeyValue keyValue) {
		EntityCacheUtil.putResult(KeyValueModelImpl.ENTITY_CACHE_ENABLED,
			KeyValueImpl.class, keyValue.getPrimaryKey(), keyValue);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VALUENAME,
			new Object[] { keyValue.getName(), Long.valueOf(keyValue.getKeyId()) },
			keyValue);

		keyValue.resetOriginalValues();
	}

	/**
	 * Caches the key values in the entity cache if it is enabled.
	 *
	 * @param keyValues the key values
	 */
	public void cacheResult(List<KeyValue> keyValues) {
		for (KeyValue keyValue : keyValues) {
			if (EntityCacheUtil.getResult(
						KeyValueModelImpl.ENTITY_CACHE_ENABLED,
						KeyValueImpl.class, keyValue.getPrimaryKey()) == null) {
				cacheResult(keyValue);
			}
			else {
				keyValue.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all key values.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(KeyValueImpl.class.getName());
		}

		EntityCacheUtil.clearCache(KeyValueImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the key value.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(KeyValue keyValue) {
		EntityCacheUtil.removeResult(KeyValueModelImpl.ENTITY_CACHE_ENABLED,
			KeyValueImpl.class, keyValue.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(keyValue);
	}

	@Override
	public void clearCache(List<KeyValue> keyValues) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (KeyValue keyValue : keyValues) {
			EntityCacheUtil.removeResult(KeyValueModelImpl.ENTITY_CACHE_ENABLED,
				KeyValueImpl.class, keyValue.getPrimaryKey());

			clearUniqueFindersCache(keyValue);
		}
	}

	protected void clearUniqueFindersCache(KeyValue keyValue) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VALUENAME,
			new Object[] { keyValue.getName(), Long.valueOf(keyValue.getKeyId()) });
	}

	/**
	 * Creates a new key value with the primary key. Does not add the key value to the database.
	 *
	 * @param valueId the primary key for the new key value
	 * @return the new key value
	 */
	public KeyValue create(long valueId) {
		KeyValue keyValue = new KeyValueImpl();

		keyValue.setNew(true);
		keyValue.setPrimaryKey(valueId);

		return keyValue;
	}

	/**
	 * Removes the key value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param valueId the primary key of the key value
	 * @return the key value that was removed
	 * @throws com.matrimony.NoSuchKeyValueException if a key value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public KeyValue remove(long valueId)
		throws NoSuchKeyValueException, SystemException {
		return remove(Long.valueOf(valueId));
	}

	/**
	 * Removes the key value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the key value
	 * @return the key value that was removed
	 * @throws com.matrimony.NoSuchKeyValueException if a key value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KeyValue remove(Serializable primaryKey)
		throws NoSuchKeyValueException, SystemException {
		Session session = null;

		try {
			session = openSession();

			KeyValue keyValue = (KeyValue)session.get(KeyValueImpl.class,
					primaryKey);

			if (keyValue == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchKeyValueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(keyValue);
		}
		catch (NoSuchKeyValueException nsee) {
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
	protected KeyValue removeImpl(KeyValue keyValue) throws SystemException {
		keyValue = toUnwrappedModel(keyValue);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, keyValue);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(keyValue);

		return keyValue;
	}

	@Override
	public KeyValue updateImpl(com.matrimony.model.KeyValue keyValue,
		boolean merge) throws SystemException {
		keyValue = toUnwrappedModel(keyValue);

		boolean isNew = keyValue.isNew();

		KeyValueModelImpl keyValueModelImpl = (KeyValueModelImpl)keyValue;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, keyValue, merge);

			keyValue.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !KeyValueModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((keyValueModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_KEYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(keyValueModelImpl.getOriginalKeyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KEYID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_KEYID,
					args);

				args = new Object[] { Long.valueOf(keyValueModelImpl.getKeyId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KEYID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_KEYID,
					args);
			}
		}

		EntityCacheUtil.putResult(KeyValueModelImpl.ENTITY_CACHE_ENABLED,
			KeyValueImpl.class, keyValue.getPrimaryKey(), keyValue);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VALUENAME,
				new Object[] {
					keyValue.getName(), Long.valueOf(keyValue.getKeyId())
				}, keyValue);
		}
		else {
			if ((keyValueModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_VALUENAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						keyValueModelImpl.getOriginalName(),
						Long.valueOf(keyValueModelImpl.getOriginalKeyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VALUENAME,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VALUENAME,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VALUENAME,
					new Object[] {
						keyValue.getName(), Long.valueOf(keyValue.getKeyId())
					}, keyValue);
			}
		}

		return keyValue;
	}

	protected KeyValue toUnwrappedModel(KeyValue keyValue) {
		if (keyValue instanceof KeyValueImpl) {
			return keyValue;
		}

		KeyValueImpl keyValueImpl = new KeyValueImpl();

		keyValueImpl.setNew(keyValue.isNew());
		keyValueImpl.setPrimaryKey(keyValue.getPrimaryKey());

		keyValueImpl.setValueId(keyValue.getValueId());
		keyValueImpl.setKeyId(keyValue.getKeyId());
		keyValueImpl.setName(keyValue.getName());

		return keyValueImpl;
	}

	/**
	 * Returns the key value with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the key value
	 * @return the key value
	 * @throws com.liferay.portal.NoSuchModelException if a key value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KeyValue findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the key value with the primary key or throws a {@link com.matrimony.NoSuchKeyValueException} if it could not be found.
	 *
	 * @param valueId the primary key of the key value
	 * @return the key value
	 * @throws com.matrimony.NoSuchKeyValueException if a key value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public KeyValue findByPrimaryKey(long valueId)
		throws NoSuchKeyValueException, SystemException {
		KeyValue keyValue = fetchByPrimaryKey(valueId);

		if (keyValue == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + valueId);
			}

			throw new NoSuchKeyValueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				valueId);
		}

		return keyValue;
	}

	/**
	 * Returns the key value with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the key value
	 * @return the key value, or <code>null</code> if a key value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KeyValue fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the key value with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param valueId the primary key of the key value
	 * @return the key value, or <code>null</code> if a key value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public KeyValue fetchByPrimaryKey(long valueId) throws SystemException {
		KeyValue keyValue = (KeyValue)EntityCacheUtil.getResult(KeyValueModelImpl.ENTITY_CACHE_ENABLED,
				KeyValueImpl.class, valueId);

		if (keyValue == _nullKeyValue) {
			return null;
		}

		if (keyValue == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				keyValue = (KeyValue)session.get(KeyValueImpl.class,
						Long.valueOf(valueId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (keyValue != null) {
					cacheResult(keyValue);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(KeyValueModelImpl.ENTITY_CACHE_ENABLED,
						KeyValueImpl.class, valueId, _nullKeyValue);
				}

				closeSession(session);
			}
		}

		return keyValue;
	}

	/**
	 * Returns all the key values where keyId = &#63;.
	 *
	 * @param keyId the key ID
	 * @return the matching key values
	 * @throws SystemException if a system exception occurred
	 */
	public List<KeyValue> findByKeyId(long keyId) throws SystemException {
		return findByKeyId(keyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the key values where keyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param keyId the key ID
	 * @param start the lower bound of the range of key values
	 * @param end the upper bound of the range of key values (not inclusive)
	 * @return the range of matching key values
	 * @throws SystemException if a system exception occurred
	 */
	public List<KeyValue> findByKeyId(long keyId, int start, int end)
		throws SystemException {
		return findByKeyId(keyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the key values where keyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param keyId the key ID
	 * @param start the lower bound of the range of key values
	 * @param end the upper bound of the range of key values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching key values
	 * @throws SystemException if a system exception occurred
	 */
	public List<KeyValue> findByKeyId(long keyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_KEYID;
			finderArgs = new Object[] { keyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_KEYID;
			finderArgs = new Object[] { keyId, start, end, orderByComparator };
		}

		List<KeyValue> list = (List<KeyValue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (KeyValue keyValue : list) {
				if ((keyId != keyValue.getKeyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_KEYVALUE_WHERE);

			query.append(_FINDER_COLUMN_KEYID_KEYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(keyId);

				list = (List<KeyValue>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first key value in the ordered set where keyId = &#63;.
	 *
	 * @param keyId the key ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching key value
	 * @throws com.matrimony.NoSuchKeyValueException if a matching key value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public KeyValue findByKeyId_First(long keyId,
		OrderByComparator orderByComparator)
		throws NoSuchKeyValueException, SystemException {
		KeyValue keyValue = fetchByKeyId_First(keyId, orderByComparator);

		if (keyValue != null) {
			return keyValue;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("keyId=");
		msg.append(keyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchKeyValueException(msg.toString());
	}

	/**
	 * Returns the first key value in the ordered set where keyId = &#63;.
	 *
	 * @param keyId the key ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching key value, or <code>null</code> if a matching key value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public KeyValue fetchByKeyId_First(long keyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<KeyValue> list = findByKeyId(keyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last key value in the ordered set where keyId = &#63;.
	 *
	 * @param keyId the key ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching key value
	 * @throws com.matrimony.NoSuchKeyValueException if a matching key value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public KeyValue findByKeyId_Last(long keyId,
		OrderByComparator orderByComparator)
		throws NoSuchKeyValueException, SystemException {
		KeyValue keyValue = fetchByKeyId_Last(keyId, orderByComparator);

		if (keyValue != null) {
			return keyValue;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("keyId=");
		msg.append(keyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchKeyValueException(msg.toString());
	}

	/**
	 * Returns the last key value in the ordered set where keyId = &#63;.
	 *
	 * @param keyId the key ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching key value, or <code>null</code> if a matching key value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public KeyValue fetchByKeyId_Last(long keyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByKeyId(keyId);

		List<KeyValue> list = findByKeyId(keyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the key values before and after the current key value in the ordered set where keyId = &#63;.
	 *
	 * @param valueId the primary key of the current key value
	 * @param keyId the key ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next key value
	 * @throws com.matrimony.NoSuchKeyValueException if a key value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public KeyValue[] findByKeyId_PrevAndNext(long valueId, long keyId,
		OrderByComparator orderByComparator)
		throws NoSuchKeyValueException, SystemException {
		KeyValue keyValue = findByPrimaryKey(valueId);

		Session session = null;

		try {
			session = openSession();

			KeyValue[] array = new KeyValueImpl[3];

			array[0] = getByKeyId_PrevAndNext(session, keyValue, keyId,
					orderByComparator, true);

			array[1] = keyValue;

			array[2] = getByKeyId_PrevAndNext(session, keyValue, keyId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected KeyValue getByKeyId_PrevAndNext(Session session,
		KeyValue keyValue, long keyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_KEYVALUE_WHERE);

		query.append(_FINDER_COLUMN_KEYID_KEYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(keyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(keyValue);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<KeyValue> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the key value where name = &#63; and keyId = &#63; or throws a {@link com.matrimony.NoSuchKeyValueException} if it could not be found.
	 *
	 * @param name the name
	 * @param keyId the key ID
	 * @return the matching key value
	 * @throws com.matrimony.NoSuchKeyValueException if a matching key value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public KeyValue findByvalueName(String name, long keyId)
		throws NoSuchKeyValueException, SystemException {
		KeyValue keyValue = fetchByvalueName(name, keyId);

		if (keyValue == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(", keyId=");
			msg.append(keyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchKeyValueException(msg.toString());
		}

		return keyValue;
	}

	/**
	 * Returns the key value where name = &#63; and keyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @param keyId the key ID
	 * @return the matching key value, or <code>null</code> if a matching key value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public KeyValue fetchByvalueName(String name, long keyId)
		throws SystemException {
		return fetchByvalueName(name, keyId, true);
	}

	/**
	 * Returns the key value where name = &#63; and keyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param keyId the key ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching key value, or <code>null</code> if a matching key value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public KeyValue fetchByvalueName(String name, long keyId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { name, keyId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_VALUENAME,
					finderArgs, this);
		}

		if (result instanceof KeyValue) {
			KeyValue keyValue = (KeyValue)result;

			if (!Validator.equals(name, keyValue.getName()) ||
					(keyId != keyValue.getKeyId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_KEYVALUE_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_VALUENAME_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_VALUENAME_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_VALUENAME_NAME_2);
				}
			}

			query.append(_FINDER_COLUMN_VALUENAME_KEYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				qPos.add(keyId);

				List<KeyValue> list = q.list();

				result = list;

				KeyValue keyValue = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VALUENAME,
						finderArgs, list);
				}
				else {
					keyValue = list.get(0);

					cacheResult(keyValue);

					if ((keyValue.getName() == null) ||
							!keyValue.getName().equals(name) ||
							(keyValue.getKeyId() != keyId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VALUENAME,
							finderArgs, keyValue);
					}
				}

				return keyValue;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VALUENAME,
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
				return (KeyValue)result;
			}
		}
	}

	/**
	 * Returns all the key values.
	 *
	 * @return the key values
	 * @throws SystemException if a system exception occurred
	 */
	public List<KeyValue> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the key values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of key values
	 * @param end the upper bound of the range of key values (not inclusive)
	 * @return the range of key values
	 * @throws SystemException if a system exception occurred
	 */
	public List<KeyValue> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the key values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of key values
	 * @param end the upper bound of the range of key values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of key values
	 * @throws SystemException if a system exception occurred
	 */
	public List<KeyValue> findAll(int start, int end,
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

		List<KeyValue> list = (List<KeyValue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_KEYVALUE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_KEYVALUE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<KeyValue>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<KeyValue>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the key values where keyId = &#63; from the database.
	 *
	 * @param keyId the key ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByKeyId(long keyId) throws SystemException {
		for (KeyValue keyValue : findByKeyId(keyId)) {
			remove(keyValue);
		}
	}

	/**
	 * Removes the key value where name = &#63; and keyId = &#63; from the database.
	 *
	 * @param name the name
	 * @param keyId the key ID
	 * @return the key value that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public KeyValue removeByvalueName(String name, long keyId)
		throws NoSuchKeyValueException, SystemException {
		KeyValue keyValue = findByvalueName(name, keyId);

		return remove(keyValue);
	}

	/**
	 * Removes all the key values from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (KeyValue keyValue : findAll()) {
			remove(keyValue);
		}
	}

	/**
	 * Returns the number of key values where keyId = &#63;.
	 *
	 * @param keyId the key ID
	 * @return the number of matching key values
	 * @throws SystemException if a system exception occurred
	 */
	public int countByKeyId(long keyId) throws SystemException {
		Object[] finderArgs = new Object[] { keyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_KEYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_KEYVALUE_WHERE);

			query.append(_FINDER_COLUMN_KEYID_KEYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(keyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KEYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of key values where name = &#63; and keyId = &#63;.
	 *
	 * @param name the name
	 * @param keyId the key ID
	 * @return the number of matching key values
	 * @throws SystemException if a system exception occurred
	 */
	public int countByvalueName(String name, long keyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { name, keyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_VALUENAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_KEYVALUE_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_VALUENAME_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_VALUENAME_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_VALUENAME_NAME_2);
				}
			}

			query.append(_FINDER_COLUMN_VALUENAME_KEYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				qPos.add(keyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_VALUENAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of key values.
	 *
	 * @return the number of key values
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_KEYVALUE);

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
	 * Initializes the key value persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.matrimony.model.KeyValue")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<KeyValue>> listenersList = new ArrayList<ModelListener<KeyValue>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<KeyValue>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(KeyValueImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = KeyPersistence.class)
	protected KeyPersistence keyPersistence;
	@BeanReference(type = KeyValuePersistence.class)
	protected KeyValuePersistence keyValuePersistence;
	@BeanReference(type = ProfilePersistence.class)
	protected ProfilePersistence profilePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_KEYVALUE = "SELECT keyValue FROM KeyValue keyValue";
	private static final String _SQL_SELECT_KEYVALUE_WHERE = "SELECT keyValue FROM KeyValue keyValue WHERE ";
	private static final String _SQL_COUNT_KEYVALUE = "SELECT COUNT(keyValue) FROM KeyValue keyValue";
	private static final String _SQL_COUNT_KEYVALUE_WHERE = "SELECT COUNT(keyValue) FROM KeyValue keyValue WHERE ";
	private static final String _FINDER_COLUMN_KEYID_KEYID_2 = "keyValue.keyId = ?";
	private static final String _FINDER_COLUMN_VALUENAME_NAME_1 = "keyValue.name IS NULL AND ";
	private static final String _FINDER_COLUMN_VALUENAME_NAME_2 = "keyValue.name = ? AND ";
	private static final String _FINDER_COLUMN_VALUENAME_NAME_3 = "(keyValue.name IS NULL OR keyValue.name = ?) AND ";
	private static final String _FINDER_COLUMN_VALUENAME_KEYID_2 = "keyValue.keyId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "keyValue.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No KeyValue exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No KeyValue exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(KeyValuePersistenceImpl.class);
	private static KeyValue _nullKeyValue = new KeyValueImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<KeyValue> toCacheModel() {
				return _nullKeyValueCacheModel;
			}
		};

	private static CacheModel<KeyValue> _nullKeyValueCacheModel = new CacheModel<KeyValue>() {
			public KeyValue toEntityModel() {
				return _nullKeyValue;
			}
		};
}