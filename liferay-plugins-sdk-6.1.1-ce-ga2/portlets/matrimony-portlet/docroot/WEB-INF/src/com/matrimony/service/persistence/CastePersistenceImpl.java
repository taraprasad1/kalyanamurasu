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

import com.matrimony.NoSuchCasteException;

import com.matrimony.model.Caste;
import com.matrimony.model.impl.CasteImpl;
import com.matrimony.model.impl.CasteModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the caste service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author matrimony
 * @see CastePersistence
 * @see CasteUtil
 * @generated
 */
public class CastePersistenceImpl extends BasePersistenceImpl<Caste>
	implements CastePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CasteUtil} to access the caste persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CasteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RELIGIONID =
		new FinderPath(CasteModelImpl.ENTITY_CACHE_ENABLED,
			CasteModelImpl.FINDER_CACHE_ENABLED, CasteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByReligionId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RELIGIONID =
		new FinderPath(CasteModelImpl.ENTITY_CACHE_ENABLED,
			CasteModelImpl.FINDER_CACHE_ENABLED, CasteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByReligionId",
			new String[] { Long.class.getName() },
			CasteModelImpl.RELIGIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RELIGIONID = new FinderPath(CasteModelImpl.ENTITY_CACHE_ENABLED,
			CasteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByReligionId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CasteModelImpl.ENTITY_CACHE_ENABLED,
			CasteModelImpl.FINDER_CACHE_ENABLED, CasteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CasteModelImpl.ENTITY_CACHE_ENABLED,
			CasteModelImpl.FINDER_CACHE_ENABLED, CasteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CasteModelImpl.ENTITY_CACHE_ENABLED,
			CasteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the caste in the entity cache if it is enabled.
	 *
	 * @param caste the caste
	 */
	public void cacheResult(Caste caste) {
		EntityCacheUtil.putResult(CasteModelImpl.ENTITY_CACHE_ENABLED,
			CasteImpl.class, caste.getPrimaryKey(), caste);

		caste.resetOriginalValues();
	}

	/**
	 * Caches the castes in the entity cache if it is enabled.
	 *
	 * @param castes the castes
	 */
	public void cacheResult(List<Caste> castes) {
		for (Caste caste : castes) {
			if (EntityCacheUtil.getResult(CasteModelImpl.ENTITY_CACHE_ENABLED,
						CasteImpl.class, caste.getPrimaryKey()) == null) {
				cacheResult(caste);
			}
			else {
				caste.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all castes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CasteImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CasteImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the caste.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Caste caste) {
		EntityCacheUtil.removeResult(CasteModelImpl.ENTITY_CACHE_ENABLED,
			CasteImpl.class, caste.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Caste> castes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Caste caste : castes) {
			EntityCacheUtil.removeResult(CasteModelImpl.ENTITY_CACHE_ENABLED,
				CasteImpl.class, caste.getPrimaryKey());
		}
	}

	/**
	 * Creates a new caste with the primary key. Does not add the caste to the database.
	 *
	 * @param casteId the primary key for the new caste
	 * @return the new caste
	 */
	public Caste create(long casteId) {
		Caste caste = new CasteImpl();

		caste.setNew(true);
		caste.setPrimaryKey(casteId);

		return caste;
	}

	/**
	 * Removes the caste with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param casteId the primary key of the caste
	 * @return the caste that was removed
	 * @throws com.matrimony.NoSuchCasteException if a caste with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Caste remove(long casteId)
		throws NoSuchCasteException, SystemException {
		return remove(Long.valueOf(casteId));
	}

	/**
	 * Removes the caste with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the caste
	 * @return the caste that was removed
	 * @throws com.matrimony.NoSuchCasteException if a caste with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Caste remove(Serializable primaryKey)
		throws NoSuchCasteException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Caste caste = (Caste)session.get(CasteImpl.class, primaryKey);

			if (caste == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCasteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(caste);
		}
		catch (NoSuchCasteException nsee) {
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
	protected Caste removeImpl(Caste caste) throws SystemException {
		caste = toUnwrappedModel(caste);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, caste);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(caste);

		return caste;
	}

	@Override
	public Caste updateImpl(com.matrimony.model.Caste caste, boolean merge)
		throws SystemException {
		caste = toUnwrappedModel(caste);

		boolean isNew = caste.isNew();

		CasteModelImpl casteModelImpl = (CasteModelImpl)caste;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, caste, merge);

			caste.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CasteModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((casteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RELIGIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(casteModelImpl.getOriginalReligionId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RELIGIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RELIGIONID,
					args);

				args = new Object[] { Long.valueOf(casteModelImpl.getReligionId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RELIGIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RELIGIONID,
					args);
			}
		}

		EntityCacheUtil.putResult(CasteModelImpl.ENTITY_CACHE_ENABLED,
			CasteImpl.class, caste.getPrimaryKey(), caste);

		return caste;
	}

	protected Caste toUnwrappedModel(Caste caste) {
		if (caste instanceof CasteImpl) {
			return caste;
		}

		CasteImpl casteImpl = new CasteImpl();

		casteImpl.setNew(caste.isNew());
		casteImpl.setPrimaryKey(caste.getPrimaryKey());

		casteImpl.setCasteId(caste.getCasteId());
		casteImpl.setReligionId(caste.getReligionId());
		casteImpl.setName(caste.getName());

		return casteImpl;
	}

	/**
	 * Returns the caste with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the caste
	 * @return the caste
	 * @throws com.liferay.portal.NoSuchModelException if a caste with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Caste findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the caste with the primary key or throws a {@link com.matrimony.NoSuchCasteException} if it could not be found.
	 *
	 * @param casteId the primary key of the caste
	 * @return the caste
	 * @throws com.matrimony.NoSuchCasteException if a caste with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Caste findByPrimaryKey(long casteId)
		throws NoSuchCasteException, SystemException {
		Caste caste = fetchByPrimaryKey(casteId);

		if (caste == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + casteId);
			}

			throw new NoSuchCasteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				casteId);
		}

		return caste;
	}

	/**
	 * Returns the caste with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the caste
	 * @return the caste, or <code>null</code> if a caste with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Caste fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the caste with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param casteId the primary key of the caste
	 * @return the caste, or <code>null</code> if a caste with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Caste fetchByPrimaryKey(long casteId) throws SystemException {
		Caste caste = (Caste)EntityCacheUtil.getResult(CasteModelImpl.ENTITY_CACHE_ENABLED,
				CasteImpl.class, casteId);

		if (caste == _nullCaste) {
			return null;
		}

		if (caste == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				caste = (Caste)session.get(CasteImpl.class,
						Long.valueOf(casteId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (caste != null) {
					cacheResult(caste);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CasteModelImpl.ENTITY_CACHE_ENABLED,
						CasteImpl.class, casteId, _nullCaste);
				}

				closeSession(session);
			}
		}

		return caste;
	}

	/**
	 * Returns all the castes where religionId = &#63;.
	 *
	 * @param religionId the religion ID
	 * @return the matching castes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Caste> findByReligionId(long religionId)
		throws SystemException {
		return findByReligionId(religionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the castes where religionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param religionId the religion ID
	 * @param start the lower bound of the range of castes
	 * @param end the upper bound of the range of castes (not inclusive)
	 * @return the range of matching castes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Caste> findByReligionId(long religionId, int start, int end)
		throws SystemException {
		return findByReligionId(religionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the castes where religionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param religionId the religion ID
	 * @param start the lower bound of the range of castes
	 * @param end the upper bound of the range of castes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching castes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Caste> findByReligionId(long religionId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RELIGIONID;
			finderArgs = new Object[] { religionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RELIGIONID;
			finderArgs = new Object[] { religionId, start, end, orderByComparator };
		}

		List<Caste> list = (List<Caste>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Caste caste : list) {
				if ((religionId != caste.getReligionId())) {
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

			query.append(_SQL_SELECT_CASTE_WHERE);

			query.append(_FINDER_COLUMN_RELIGIONID_RELIGIONID_2);

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

				qPos.add(religionId);

				list = (List<Caste>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first caste in the ordered set where religionId = &#63;.
	 *
	 * @param religionId the religion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching caste
	 * @throws com.matrimony.NoSuchCasteException if a matching caste could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Caste findByReligionId_First(long religionId,
		OrderByComparator orderByComparator)
		throws NoSuchCasteException, SystemException {
		Caste caste = fetchByReligionId_First(religionId, orderByComparator);

		if (caste != null) {
			return caste;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("religionId=");
		msg.append(religionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCasteException(msg.toString());
	}

	/**
	 * Returns the first caste in the ordered set where religionId = &#63;.
	 *
	 * @param religionId the religion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching caste, or <code>null</code> if a matching caste could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Caste fetchByReligionId_First(long religionId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Caste> list = findByReligionId(religionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last caste in the ordered set where religionId = &#63;.
	 *
	 * @param religionId the religion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching caste
	 * @throws com.matrimony.NoSuchCasteException if a matching caste could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Caste findByReligionId_Last(long religionId,
		OrderByComparator orderByComparator)
		throws NoSuchCasteException, SystemException {
		Caste caste = fetchByReligionId_Last(religionId, orderByComparator);

		if (caste != null) {
			return caste;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("religionId=");
		msg.append(religionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCasteException(msg.toString());
	}

	/**
	 * Returns the last caste in the ordered set where religionId = &#63;.
	 *
	 * @param religionId the religion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching caste, or <code>null</code> if a matching caste could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Caste fetchByReligionId_Last(long religionId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByReligionId(religionId);

		List<Caste> list = findByReligionId(religionId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the castes before and after the current caste in the ordered set where religionId = &#63;.
	 *
	 * @param casteId the primary key of the current caste
	 * @param religionId the religion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next caste
	 * @throws com.matrimony.NoSuchCasteException if a caste with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Caste[] findByReligionId_PrevAndNext(long casteId, long religionId,
		OrderByComparator orderByComparator)
		throws NoSuchCasteException, SystemException {
		Caste caste = findByPrimaryKey(casteId);

		Session session = null;

		try {
			session = openSession();

			Caste[] array = new CasteImpl[3];

			array[0] = getByReligionId_PrevAndNext(session, caste, religionId,
					orderByComparator, true);

			array[1] = caste;

			array[2] = getByReligionId_PrevAndNext(session, caste, religionId,
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

	protected Caste getByReligionId_PrevAndNext(Session session, Caste caste,
		long religionId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CASTE_WHERE);

		query.append(_FINDER_COLUMN_RELIGIONID_RELIGIONID_2);

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

		qPos.add(religionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(caste);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Caste> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the castes.
	 *
	 * @return the castes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Caste> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the castes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of castes
	 * @param end the upper bound of the range of castes (not inclusive)
	 * @return the range of castes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Caste> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the castes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of castes
	 * @param end the upper bound of the range of castes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of castes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Caste> findAll(int start, int end,
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

		List<Caste> list = (List<Caste>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CASTE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CASTE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Caste>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Caste>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the castes where religionId = &#63; from the database.
	 *
	 * @param religionId the religion ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByReligionId(long religionId) throws SystemException {
		for (Caste caste : findByReligionId(religionId)) {
			remove(caste);
		}
	}

	/**
	 * Removes all the castes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Caste caste : findAll()) {
			remove(caste);
		}
	}

	/**
	 * Returns the number of castes where religionId = &#63;.
	 *
	 * @param religionId the religion ID
	 * @return the number of matching castes
	 * @throws SystemException if a system exception occurred
	 */
	public int countByReligionId(long religionId) throws SystemException {
		Object[] finderArgs = new Object[] { religionId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_RELIGIONID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CASTE_WHERE);

			query.append(_FINDER_COLUMN_RELIGIONID_RELIGIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(religionId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RELIGIONID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of castes.
	 *
	 * @return the number of castes
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CASTE);

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
	 * Initializes the caste persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.matrimony.model.Caste")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Caste>> listenersList = new ArrayList<ModelListener<Caste>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Caste>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CasteImpl.class.getName());
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
	private static final String _SQL_SELECT_CASTE = "SELECT caste FROM Caste caste";
	private static final String _SQL_SELECT_CASTE_WHERE = "SELECT caste FROM Caste caste WHERE ";
	private static final String _SQL_COUNT_CASTE = "SELECT COUNT(caste) FROM Caste caste";
	private static final String _SQL_COUNT_CASTE_WHERE = "SELECT COUNT(caste) FROM Caste caste WHERE ";
	private static final String _FINDER_COLUMN_RELIGIONID_RELIGIONID_2 = "caste.religionId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "caste.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Caste exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Caste exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CastePersistenceImpl.class);
	private static Caste _nullCaste = new CasteImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Caste> toCacheModel() {
				return _nullCasteCacheModel;
			}
		};

	private static CacheModel<Caste> _nullCasteCacheModel = new CacheModel<Caste>() {
			public Caste toEntityModel() {
				return _nullCaste;
			}
		};
}