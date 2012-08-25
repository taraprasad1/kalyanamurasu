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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.matrimony.NoSuchProfileKeyValueException;

import com.matrimony.model.ProfileKeyValue;
import com.matrimony.model.impl.ProfileKeyValueImpl;
import com.matrimony.model.impl.ProfileKeyValueModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the profile key value service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author matrimony
 * @see ProfileKeyValuePersistence
 * @see ProfileKeyValueUtil
 * @generated
 */
public class ProfileKeyValuePersistenceImpl extends BasePersistenceImpl<ProfileKeyValue>
	implements ProfileKeyValuePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProfileKeyValueUtil} to access the profile key value persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProfileKeyValueImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROFILEANDKEYID =
		new FinderPath(ProfileKeyValueModelImpl.ENTITY_CACHE_ENABLED,
			ProfileKeyValueModelImpl.FINDER_CACHE_ENABLED,
			ProfileKeyValueImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByProfileAndKeyId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROFILEANDKEYID =
		new FinderPath(ProfileKeyValueModelImpl.ENTITY_CACHE_ENABLED,
			ProfileKeyValueModelImpl.FINDER_CACHE_ENABLED,
			ProfileKeyValueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProfileAndKeyId",
			new String[] { Long.class.getName(), Long.class.getName() },
			ProfileKeyValueModelImpl.KEYID_COLUMN_BITMASK |
			ProfileKeyValueModelImpl.PROFILEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROFILEANDKEYID = new FinderPath(ProfileKeyValueModelImpl.ENTITY_CACHE_ENABLED,
			ProfileKeyValueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProfileAndKeyId",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_KEYANDVALUEID =
		new FinderPath(ProfileKeyValueModelImpl.ENTITY_CACHE_ENABLED,
			ProfileKeyValueModelImpl.FINDER_CACHE_ENABLED,
			ProfileKeyValueImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByKeyandValueId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_KEYANDVALUEID =
		new FinderPath(ProfileKeyValueModelImpl.ENTITY_CACHE_ENABLED,
			ProfileKeyValueModelImpl.FINDER_CACHE_ENABLED,
			ProfileKeyValueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByKeyandValueId",
			new String[] { Long.class.getName(), Long.class.getName() },
			ProfileKeyValueModelImpl.KEYID_COLUMN_BITMASK |
			ProfileKeyValueModelImpl.VALUEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_KEYANDVALUEID = new FinderPath(ProfileKeyValueModelImpl.ENTITY_CACHE_ENABLED,
			ProfileKeyValueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByKeyandValueId",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProfileKeyValueModelImpl.ENTITY_CACHE_ENABLED,
			ProfileKeyValueModelImpl.FINDER_CACHE_ENABLED,
			ProfileKeyValueImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProfileKeyValueModelImpl.ENTITY_CACHE_ENABLED,
			ProfileKeyValueModelImpl.FINDER_CACHE_ENABLED,
			ProfileKeyValueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProfileKeyValueModelImpl.ENTITY_CACHE_ENABLED,
			ProfileKeyValueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the profile key value in the entity cache if it is enabled.
	 *
	 * @param profileKeyValue the profile key value
	 */
	public void cacheResult(ProfileKeyValue profileKeyValue) {
		EntityCacheUtil.putResult(ProfileKeyValueModelImpl.ENTITY_CACHE_ENABLED,
			ProfileKeyValueImpl.class, profileKeyValue.getPrimaryKey(),
			profileKeyValue);

		profileKeyValue.resetOriginalValues();
	}

	/**
	 * Caches the profile key values in the entity cache if it is enabled.
	 *
	 * @param profileKeyValues the profile key values
	 */
	public void cacheResult(List<ProfileKeyValue> profileKeyValues) {
		for (ProfileKeyValue profileKeyValue : profileKeyValues) {
			if (EntityCacheUtil.getResult(
						ProfileKeyValueModelImpl.ENTITY_CACHE_ENABLED,
						ProfileKeyValueImpl.class,
						profileKeyValue.getPrimaryKey()) == null) {
				cacheResult(profileKeyValue);
			}
			else {
				profileKeyValue.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all profile key values.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ProfileKeyValueImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ProfileKeyValueImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the profile key value.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProfileKeyValue profileKeyValue) {
		EntityCacheUtil.removeResult(ProfileKeyValueModelImpl.ENTITY_CACHE_ENABLED,
			ProfileKeyValueImpl.class, profileKeyValue.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ProfileKeyValue> profileKeyValues) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProfileKeyValue profileKeyValue : profileKeyValues) {
			EntityCacheUtil.removeResult(ProfileKeyValueModelImpl.ENTITY_CACHE_ENABLED,
				ProfileKeyValueImpl.class, profileKeyValue.getPrimaryKey());
		}
	}

	/**
	 * Creates a new profile key value with the primary key. Does not add the profile key value to the database.
	 *
	 * @param profileKeyValuePK the primary key for the new profile key value
	 * @return the new profile key value
	 */
	public ProfileKeyValue create(ProfileKeyValuePK profileKeyValuePK) {
		ProfileKeyValue profileKeyValue = new ProfileKeyValueImpl();

		profileKeyValue.setNew(true);
		profileKeyValue.setPrimaryKey(profileKeyValuePK);

		return profileKeyValue;
	}

	/**
	 * Removes the profile key value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileKeyValuePK the primary key of the profile key value
	 * @return the profile key value that was removed
	 * @throws com.matrimony.NoSuchProfileKeyValueException if a profile key value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProfileKeyValue remove(ProfileKeyValuePK profileKeyValuePK)
		throws NoSuchProfileKeyValueException, SystemException {
		return remove((Serializable)profileKeyValuePK);
	}

	/**
	 * Removes the profile key value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the profile key value
	 * @return the profile key value that was removed
	 * @throws com.matrimony.NoSuchProfileKeyValueException if a profile key value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProfileKeyValue remove(Serializable primaryKey)
		throws NoSuchProfileKeyValueException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProfileKeyValue profileKeyValue = (ProfileKeyValue)session.get(ProfileKeyValueImpl.class,
					primaryKey);

			if (profileKeyValue == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProfileKeyValueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(profileKeyValue);
		}
		catch (NoSuchProfileKeyValueException nsee) {
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
	protected ProfileKeyValue removeImpl(ProfileKeyValue profileKeyValue)
		throws SystemException {
		profileKeyValue = toUnwrappedModel(profileKeyValue);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, profileKeyValue);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(profileKeyValue);

		return profileKeyValue;
	}

	@Override
	public ProfileKeyValue updateImpl(
		com.matrimony.model.ProfileKeyValue profileKeyValue, boolean merge)
		throws SystemException {
		profileKeyValue = toUnwrappedModel(profileKeyValue);

		boolean isNew = profileKeyValue.isNew();

		ProfileKeyValueModelImpl profileKeyValueModelImpl = (ProfileKeyValueModelImpl)profileKeyValue;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, profileKeyValue, merge);

			profileKeyValue.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ProfileKeyValueModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((profileKeyValueModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROFILEANDKEYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(profileKeyValueModelImpl.getOriginalKeyId()),
						Long.valueOf(profileKeyValueModelImpl.getOriginalProfileId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROFILEANDKEYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROFILEANDKEYID,
					args);

				args = new Object[] {
						Long.valueOf(profileKeyValueModelImpl.getKeyId()),
						Long.valueOf(profileKeyValueModelImpl.getProfileId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROFILEANDKEYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROFILEANDKEYID,
					args);
			}

			if ((profileKeyValueModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_KEYANDVALUEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(profileKeyValueModelImpl.getOriginalKeyId()),
						Long.valueOf(profileKeyValueModelImpl.getOriginalValueId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KEYANDVALUEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_KEYANDVALUEID,
					args);

				args = new Object[] {
						Long.valueOf(profileKeyValueModelImpl.getKeyId()),
						Long.valueOf(profileKeyValueModelImpl.getValueId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KEYANDVALUEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_KEYANDVALUEID,
					args);
			}
		}

		EntityCacheUtil.putResult(ProfileKeyValueModelImpl.ENTITY_CACHE_ENABLED,
			ProfileKeyValueImpl.class, profileKeyValue.getPrimaryKey(),
			profileKeyValue);

		return profileKeyValue;
	}

	protected ProfileKeyValue toUnwrappedModel(ProfileKeyValue profileKeyValue) {
		if (profileKeyValue instanceof ProfileKeyValueImpl) {
			return profileKeyValue;
		}

		ProfileKeyValueImpl profileKeyValueImpl = new ProfileKeyValueImpl();

		profileKeyValueImpl.setNew(profileKeyValue.isNew());
		profileKeyValueImpl.setPrimaryKey(profileKeyValue.getPrimaryKey());

		profileKeyValueImpl.setProfileId(profileKeyValue.getProfileId());
		profileKeyValueImpl.setKeyId(profileKeyValue.getKeyId());
		profileKeyValueImpl.setValueId(profileKeyValue.getValueId());

		return profileKeyValueImpl;
	}

	/**
	 * Returns the profile key value with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the profile key value
	 * @return the profile key value
	 * @throws com.liferay.portal.NoSuchModelException if a profile key value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProfileKeyValue findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((ProfileKeyValuePK)primaryKey);
	}

	/**
	 * Returns the profile key value with the primary key or throws a {@link com.matrimony.NoSuchProfileKeyValueException} if it could not be found.
	 *
	 * @param profileKeyValuePK the primary key of the profile key value
	 * @return the profile key value
	 * @throws com.matrimony.NoSuchProfileKeyValueException if a profile key value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProfileKeyValue findByPrimaryKey(ProfileKeyValuePK profileKeyValuePK)
		throws NoSuchProfileKeyValueException, SystemException {
		ProfileKeyValue profileKeyValue = fetchByPrimaryKey(profileKeyValuePK);

		if (profileKeyValue == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + profileKeyValuePK);
			}

			throw new NoSuchProfileKeyValueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				profileKeyValuePK);
		}

		return profileKeyValue;
	}

	/**
	 * Returns the profile key value with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the profile key value
	 * @return the profile key value, or <code>null</code> if a profile key value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProfileKeyValue fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((ProfileKeyValuePK)primaryKey);
	}

	/**
	 * Returns the profile key value with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param profileKeyValuePK the primary key of the profile key value
	 * @return the profile key value, or <code>null</code> if a profile key value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProfileKeyValue fetchByPrimaryKey(
		ProfileKeyValuePK profileKeyValuePK) throws SystemException {
		ProfileKeyValue profileKeyValue = (ProfileKeyValue)EntityCacheUtil.getResult(ProfileKeyValueModelImpl.ENTITY_CACHE_ENABLED,
				ProfileKeyValueImpl.class, profileKeyValuePK);

		if (profileKeyValue == _nullProfileKeyValue) {
			return null;
		}

		if (profileKeyValue == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				profileKeyValue = (ProfileKeyValue)session.get(ProfileKeyValueImpl.class,
						profileKeyValuePK);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (profileKeyValue != null) {
					cacheResult(profileKeyValue);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ProfileKeyValueModelImpl.ENTITY_CACHE_ENABLED,
						ProfileKeyValueImpl.class, profileKeyValuePK,
						_nullProfileKeyValue);
				}

				closeSession(session);
			}
		}

		return profileKeyValue;
	}

	/**
	 * Returns all the profile key values where keyId = &#63; and profileId = &#63;.
	 *
	 * @param keyId the key ID
	 * @param profileId the profile ID
	 * @return the matching profile key values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProfileKeyValue> findByProfileAndKeyId(long keyId,
		long profileId) throws SystemException {
		return findByProfileAndKeyId(keyId, profileId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the profile key values where keyId = &#63; and profileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param keyId the key ID
	 * @param profileId the profile ID
	 * @param start the lower bound of the range of profile key values
	 * @param end the upper bound of the range of profile key values (not inclusive)
	 * @return the range of matching profile key values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProfileKeyValue> findByProfileAndKeyId(long keyId,
		long profileId, int start, int end) throws SystemException {
		return findByProfileAndKeyId(keyId, profileId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the profile key values where keyId = &#63; and profileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param keyId the key ID
	 * @param profileId the profile ID
	 * @param start the lower bound of the range of profile key values
	 * @param end the upper bound of the range of profile key values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching profile key values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProfileKeyValue> findByProfileAndKeyId(long keyId,
		long profileId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROFILEANDKEYID;
			finderArgs = new Object[] { keyId, profileId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROFILEANDKEYID;
			finderArgs = new Object[] {
					keyId, profileId,
					
					start, end, orderByComparator
				};
		}

		List<ProfileKeyValue> list = (List<ProfileKeyValue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ProfileKeyValue profileKeyValue : list) {
				if ((keyId != profileKeyValue.getKeyId()) ||
						(profileId != profileKeyValue.getProfileId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PROFILEKEYVALUE_WHERE);

			query.append(_FINDER_COLUMN_PROFILEANDKEYID_KEYID_2);

			query.append(_FINDER_COLUMN_PROFILEANDKEYID_PROFILEID_2);

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

				qPos.add(profileId);

				list = (List<ProfileKeyValue>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first profile key value in the ordered set where keyId = &#63; and profileId = &#63;.
	 *
	 * @param keyId the key ID
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile key value
	 * @throws com.matrimony.NoSuchProfileKeyValueException if a matching profile key value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProfileKeyValue findByProfileAndKeyId_First(long keyId,
		long profileId, OrderByComparator orderByComparator)
		throws NoSuchProfileKeyValueException, SystemException {
		ProfileKeyValue profileKeyValue = fetchByProfileAndKeyId_First(keyId,
				profileId, orderByComparator);

		if (profileKeyValue != null) {
			return profileKeyValue;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("keyId=");
		msg.append(keyId);

		msg.append(", profileId=");
		msg.append(profileId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProfileKeyValueException(msg.toString());
	}

	/**
	 * Returns the first profile key value in the ordered set where keyId = &#63; and profileId = &#63;.
	 *
	 * @param keyId the key ID
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile key value, or <code>null</code> if a matching profile key value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProfileKeyValue fetchByProfileAndKeyId_First(long keyId,
		long profileId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ProfileKeyValue> list = findByProfileAndKeyId(keyId, profileId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last profile key value in the ordered set where keyId = &#63; and profileId = &#63;.
	 *
	 * @param keyId the key ID
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile key value
	 * @throws com.matrimony.NoSuchProfileKeyValueException if a matching profile key value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProfileKeyValue findByProfileAndKeyId_Last(long keyId,
		long profileId, OrderByComparator orderByComparator)
		throws NoSuchProfileKeyValueException, SystemException {
		ProfileKeyValue profileKeyValue = fetchByProfileAndKeyId_Last(keyId,
				profileId, orderByComparator);

		if (profileKeyValue != null) {
			return profileKeyValue;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("keyId=");
		msg.append(keyId);

		msg.append(", profileId=");
		msg.append(profileId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProfileKeyValueException(msg.toString());
	}

	/**
	 * Returns the last profile key value in the ordered set where keyId = &#63; and profileId = &#63;.
	 *
	 * @param keyId the key ID
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile key value, or <code>null</code> if a matching profile key value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProfileKeyValue fetchByProfileAndKeyId_Last(long keyId,
		long profileId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByProfileAndKeyId(keyId, profileId);

		List<ProfileKeyValue> list = findByProfileAndKeyId(keyId, profileId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the profile key values before and after the current profile key value in the ordered set where keyId = &#63; and profileId = &#63;.
	 *
	 * @param profileKeyValuePK the primary key of the current profile key value
	 * @param keyId the key ID
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile key value
	 * @throws com.matrimony.NoSuchProfileKeyValueException if a profile key value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProfileKeyValue[] findByProfileAndKeyId_PrevAndNext(
		ProfileKeyValuePK profileKeyValuePK, long keyId, long profileId,
		OrderByComparator orderByComparator)
		throws NoSuchProfileKeyValueException, SystemException {
		ProfileKeyValue profileKeyValue = findByPrimaryKey(profileKeyValuePK);

		Session session = null;

		try {
			session = openSession();

			ProfileKeyValue[] array = new ProfileKeyValueImpl[3];

			array[0] = getByProfileAndKeyId_PrevAndNext(session,
					profileKeyValue, keyId, profileId, orderByComparator, true);

			array[1] = profileKeyValue;

			array[2] = getByProfileAndKeyId_PrevAndNext(session,
					profileKeyValue, keyId, profileId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProfileKeyValue getByProfileAndKeyId_PrevAndNext(
		Session session, ProfileKeyValue profileKeyValue, long keyId,
		long profileId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROFILEKEYVALUE_WHERE);

		query.append(_FINDER_COLUMN_PROFILEANDKEYID_KEYID_2);

		query.append(_FINDER_COLUMN_PROFILEANDKEYID_PROFILEID_2);

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

		qPos.add(profileId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(profileKeyValue);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProfileKeyValue> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the profile key values where keyId = &#63; and valueId = &#63;.
	 *
	 * @param keyId the key ID
	 * @param valueId the value ID
	 * @return the matching profile key values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProfileKeyValue> findByKeyandValueId(long keyId, long valueId)
		throws SystemException {
		return findByKeyandValueId(keyId, valueId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the profile key values where keyId = &#63; and valueId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param keyId the key ID
	 * @param valueId the value ID
	 * @param start the lower bound of the range of profile key values
	 * @param end the upper bound of the range of profile key values (not inclusive)
	 * @return the range of matching profile key values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProfileKeyValue> findByKeyandValueId(long keyId, long valueId,
		int start, int end) throws SystemException {
		return findByKeyandValueId(keyId, valueId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the profile key values where keyId = &#63; and valueId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param keyId the key ID
	 * @param valueId the value ID
	 * @param start the lower bound of the range of profile key values
	 * @param end the upper bound of the range of profile key values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching profile key values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProfileKeyValue> findByKeyandValueId(long keyId, long valueId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_KEYANDVALUEID;
			finderArgs = new Object[] { keyId, valueId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_KEYANDVALUEID;
			finderArgs = new Object[] {
					keyId, valueId,
					
					start, end, orderByComparator
				};
		}

		List<ProfileKeyValue> list = (List<ProfileKeyValue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ProfileKeyValue profileKeyValue : list) {
				if ((keyId != profileKeyValue.getKeyId()) ||
						(valueId != profileKeyValue.getValueId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PROFILEKEYVALUE_WHERE);

			query.append(_FINDER_COLUMN_KEYANDVALUEID_KEYID_2);

			query.append(_FINDER_COLUMN_KEYANDVALUEID_VALUEID_2);

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

				qPos.add(valueId);

				list = (List<ProfileKeyValue>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first profile key value in the ordered set where keyId = &#63; and valueId = &#63;.
	 *
	 * @param keyId the key ID
	 * @param valueId the value ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile key value
	 * @throws com.matrimony.NoSuchProfileKeyValueException if a matching profile key value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProfileKeyValue findByKeyandValueId_First(long keyId, long valueId,
		OrderByComparator orderByComparator)
		throws NoSuchProfileKeyValueException, SystemException {
		ProfileKeyValue profileKeyValue = fetchByKeyandValueId_First(keyId,
				valueId, orderByComparator);

		if (profileKeyValue != null) {
			return profileKeyValue;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("keyId=");
		msg.append(keyId);

		msg.append(", valueId=");
		msg.append(valueId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProfileKeyValueException(msg.toString());
	}

	/**
	 * Returns the first profile key value in the ordered set where keyId = &#63; and valueId = &#63;.
	 *
	 * @param keyId the key ID
	 * @param valueId the value ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile key value, or <code>null</code> if a matching profile key value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProfileKeyValue fetchByKeyandValueId_First(long keyId, long valueId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ProfileKeyValue> list = findByKeyandValueId(keyId, valueId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last profile key value in the ordered set where keyId = &#63; and valueId = &#63;.
	 *
	 * @param keyId the key ID
	 * @param valueId the value ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile key value
	 * @throws com.matrimony.NoSuchProfileKeyValueException if a matching profile key value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProfileKeyValue findByKeyandValueId_Last(long keyId, long valueId,
		OrderByComparator orderByComparator)
		throws NoSuchProfileKeyValueException, SystemException {
		ProfileKeyValue profileKeyValue = fetchByKeyandValueId_Last(keyId,
				valueId, orderByComparator);

		if (profileKeyValue != null) {
			return profileKeyValue;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("keyId=");
		msg.append(keyId);

		msg.append(", valueId=");
		msg.append(valueId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProfileKeyValueException(msg.toString());
	}

	/**
	 * Returns the last profile key value in the ordered set where keyId = &#63; and valueId = &#63;.
	 *
	 * @param keyId the key ID
	 * @param valueId the value ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile key value, or <code>null</code> if a matching profile key value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProfileKeyValue fetchByKeyandValueId_Last(long keyId, long valueId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByKeyandValueId(keyId, valueId);

		List<ProfileKeyValue> list = findByKeyandValueId(keyId, valueId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the profile key values before and after the current profile key value in the ordered set where keyId = &#63; and valueId = &#63;.
	 *
	 * @param profileKeyValuePK the primary key of the current profile key value
	 * @param keyId the key ID
	 * @param valueId the value ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile key value
	 * @throws com.matrimony.NoSuchProfileKeyValueException if a profile key value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProfileKeyValue[] findByKeyandValueId_PrevAndNext(
		ProfileKeyValuePK profileKeyValuePK, long keyId, long valueId,
		OrderByComparator orderByComparator)
		throws NoSuchProfileKeyValueException, SystemException {
		ProfileKeyValue profileKeyValue = findByPrimaryKey(profileKeyValuePK);

		Session session = null;

		try {
			session = openSession();

			ProfileKeyValue[] array = new ProfileKeyValueImpl[3];

			array[0] = getByKeyandValueId_PrevAndNext(session, profileKeyValue,
					keyId, valueId, orderByComparator, true);

			array[1] = profileKeyValue;

			array[2] = getByKeyandValueId_PrevAndNext(session, profileKeyValue,
					keyId, valueId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProfileKeyValue getByKeyandValueId_PrevAndNext(Session session,
		ProfileKeyValue profileKeyValue, long keyId, long valueId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROFILEKEYVALUE_WHERE);

		query.append(_FINDER_COLUMN_KEYANDVALUEID_KEYID_2);

		query.append(_FINDER_COLUMN_KEYANDVALUEID_VALUEID_2);

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

		qPos.add(valueId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(profileKeyValue);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProfileKeyValue> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the profile key values.
	 *
	 * @return the profile key values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProfileKeyValue> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<ProfileKeyValue> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the profile key values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile key values
	 * @param end the upper bound of the range of profile key values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of profile key values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProfileKeyValue> findAll(int start, int end,
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

		List<ProfileKeyValue> list = (List<ProfileKeyValue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROFILEKEYVALUE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROFILEKEYVALUE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ProfileKeyValue>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProfileKeyValue>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the profile key values where keyId = &#63; and profileId = &#63; from the database.
	 *
	 * @param keyId the key ID
	 * @param profileId the profile ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByProfileAndKeyId(long keyId, long profileId)
		throws SystemException {
		for (ProfileKeyValue profileKeyValue : findByProfileAndKeyId(keyId,
				profileId)) {
			remove(profileKeyValue);
		}
	}

	/**
	 * Removes all the profile key values where keyId = &#63; and valueId = &#63; from the database.
	 *
	 * @param keyId the key ID
	 * @param valueId the value ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByKeyandValueId(long keyId, long valueId)
		throws SystemException {
		for (ProfileKeyValue profileKeyValue : findByKeyandValueId(keyId,
				valueId)) {
			remove(profileKeyValue);
		}
	}

	/**
	 * Removes all the profile key values from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ProfileKeyValue profileKeyValue : findAll()) {
			remove(profileKeyValue);
		}
	}

	/**
	 * Returns the number of profile key values where keyId = &#63; and profileId = &#63;.
	 *
	 * @param keyId the key ID
	 * @param profileId the profile ID
	 * @return the number of matching profile key values
	 * @throws SystemException if a system exception occurred
	 */
	public int countByProfileAndKeyId(long keyId, long profileId)
		throws SystemException {
		Object[] finderArgs = new Object[] { keyId, profileId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PROFILEANDKEYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROFILEKEYVALUE_WHERE);

			query.append(_FINDER_COLUMN_PROFILEANDKEYID_KEYID_2);

			query.append(_FINDER_COLUMN_PROFILEANDKEYID_PROFILEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(keyId);

				qPos.add(profileId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROFILEANDKEYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of profile key values where keyId = &#63; and valueId = &#63;.
	 *
	 * @param keyId the key ID
	 * @param valueId the value ID
	 * @return the number of matching profile key values
	 * @throws SystemException if a system exception occurred
	 */
	public int countByKeyandValueId(long keyId, long valueId)
		throws SystemException {
		Object[] finderArgs = new Object[] { keyId, valueId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_KEYANDVALUEID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROFILEKEYVALUE_WHERE);

			query.append(_FINDER_COLUMN_KEYANDVALUEID_KEYID_2);

			query.append(_FINDER_COLUMN_KEYANDVALUEID_VALUEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(keyId);

				qPos.add(valueId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KEYANDVALUEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of profile key values.
	 *
	 * @return the number of profile key values
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROFILEKEYVALUE);

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
	 * Initializes the profile key value persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.matrimony.model.ProfileKeyValue")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProfileKeyValue>> listenersList = new ArrayList<ModelListener<ProfileKeyValue>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProfileKeyValue>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ProfileKeyValueImpl.class.getName());
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
	private static final String _SQL_SELECT_PROFILEKEYVALUE = "SELECT profileKeyValue FROM ProfileKeyValue profileKeyValue";
	private static final String _SQL_SELECT_PROFILEKEYVALUE_WHERE = "SELECT profileKeyValue FROM ProfileKeyValue profileKeyValue WHERE ";
	private static final String _SQL_COUNT_PROFILEKEYVALUE = "SELECT COUNT(profileKeyValue) FROM ProfileKeyValue profileKeyValue";
	private static final String _SQL_COUNT_PROFILEKEYVALUE_WHERE = "SELECT COUNT(profileKeyValue) FROM ProfileKeyValue profileKeyValue WHERE ";
	private static final String _FINDER_COLUMN_PROFILEANDKEYID_KEYID_2 = "profileKeyValue.id.keyId = ? AND ";
	private static final String _FINDER_COLUMN_PROFILEANDKEYID_PROFILEID_2 = "profileKeyValue.id.profileId = ?";
	private static final String _FINDER_COLUMN_KEYANDVALUEID_KEYID_2 = "profileKeyValue.id.keyId = ? AND ";
	private static final String _FINDER_COLUMN_KEYANDVALUEID_VALUEID_2 = "profileKeyValue.id.valueId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "profileKeyValue.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProfileKeyValue exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ProfileKeyValue exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ProfileKeyValuePersistenceImpl.class);
	private static ProfileKeyValue _nullProfileKeyValue = new ProfileKeyValueImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ProfileKeyValue> toCacheModel() {
				return _nullProfileKeyValueCacheModel;
			}
		};

	private static CacheModel<ProfileKeyValue> _nullProfileKeyValueCacheModel = new CacheModel<ProfileKeyValue>() {
			public ProfileKeyValue toEntityModel() {
				return _nullProfileKeyValue;
			}
		};
}