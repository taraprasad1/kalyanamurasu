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

import com.matrimony.NoSuchSubCasteException;

import com.matrimony.model.SubCaste;
import com.matrimony.model.impl.SubCasteImpl;
import com.matrimony.model.impl.SubCasteModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the sub caste service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author matrimony
 * @see SubCastePersistence
 * @see SubCasteUtil
 * @generated
 */
public class SubCastePersistenceImpl extends BasePersistenceImpl<SubCaste>
	implements SubCastePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SubCasteUtil} to access the sub caste persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SubCasteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CASTEID = new FinderPath(SubCasteModelImpl.ENTITY_CACHE_ENABLED,
			SubCasteModelImpl.FINDER_CACHE_ENABLED, SubCasteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCasteId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CASTEID =
		new FinderPath(SubCasteModelImpl.ENTITY_CACHE_ENABLED,
			SubCasteModelImpl.FINDER_CACHE_ENABLED, SubCasteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCasteId",
			new String[] { Long.class.getName() },
			SubCasteModelImpl.CASTEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CASTEID = new FinderPath(SubCasteModelImpl.ENTITY_CACHE_ENABLED,
			SubCasteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCasteId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SubCasteModelImpl.ENTITY_CACHE_ENABLED,
			SubCasteModelImpl.FINDER_CACHE_ENABLED, SubCasteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SubCasteModelImpl.ENTITY_CACHE_ENABLED,
			SubCasteModelImpl.FINDER_CACHE_ENABLED, SubCasteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SubCasteModelImpl.ENTITY_CACHE_ENABLED,
			SubCasteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the sub caste in the entity cache if it is enabled.
	 *
	 * @param subCaste the sub caste
	 */
	public void cacheResult(SubCaste subCaste) {
		EntityCacheUtil.putResult(SubCasteModelImpl.ENTITY_CACHE_ENABLED,
			SubCasteImpl.class, subCaste.getPrimaryKey(), subCaste);

		subCaste.resetOriginalValues();
	}

	/**
	 * Caches the sub castes in the entity cache if it is enabled.
	 *
	 * @param subCastes the sub castes
	 */
	public void cacheResult(List<SubCaste> subCastes) {
		for (SubCaste subCaste : subCastes) {
			if (EntityCacheUtil.getResult(
						SubCasteModelImpl.ENTITY_CACHE_ENABLED,
						SubCasteImpl.class, subCaste.getPrimaryKey()) == null) {
				cacheResult(subCaste);
			}
			else {
				subCaste.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all sub castes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SubCasteImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SubCasteImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sub caste.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SubCaste subCaste) {
		EntityCacheUtil.removeResult(SubCasteModelImpl.ENTITY_CACHE_ENABLED,
			SubCasteImpl.class, subCaste.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SubCaste> subCastes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SubCaste subCaste : subCastes) {
			EntityCacheUtil.removeResult(SubCasteModelImpl.ENTITY_CACHE_ENABLED,
				SubCasteImpl.class, subCaste.getPrimaryKey());
		}
	}

	/**
	 * Creates a new sub caste with the primary key. Does not add the sub caste to the database.
	 *
	 * @param subCasteId the primary key for the new sub caste
	 * @return the new sub caste
	 */
	public SubCaste create(long subCasteId) {
		SubCaste subCaste = new SubCasteImpl();

		subCaste.setNew(true);
		subCaste.setPrimaryKey(subCasteId);

		return subCaste;
	}

	/**
	 * Removes the sub caste with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subCasteId the primary key of the sub caste
	 * @return the sub caste that was removed
	 * @throws com.matrimony.NoSuchSubCasteException if a sub caste with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SubCaste remove(long subCasteId)
		throws NoSuchSubCasteException, SystemException {
		return remove(Long.valueOf(subCasteId));
	}

	/**
	 * Removes the sub caste with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sub caste
	 * @return the sub caste that was removed
	 * @throws com.matrimony.NoSuchSubCasteException if a sub caste with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubCaste remove(Serializable primaryKey)
		throws NoSuchSubCasteException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SubCaste subCaste = (SubCaste)session.get(SubCasteImpl.class,
					primaryKey);

			if (subCaste == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSubCasteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(subCaste);
		}
		catch (NoSuchSubCasteException nsee) {
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
	protected SubCaste removeImpl(SubCaste subCaste) throws SystemException {
		subCaste = toUnwrappedModel(subCaste);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, subCaste);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(subCaste);

		return subCaste;
	}

	@Override
	public SubCaste updateImpl(com.matrimony.model.SubCaste subCaste,
		boolean merge) throws SystemException {
		subCaste = toUnwrappedModel(subCaste);

		boolean isNew = subCaste.isNew();

		SubCasteModelImpl subCasteModelImpl = (SubCasteModelImpl)subCaste;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, subCaste, merge);

			subCaste.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SubCasteModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((subCasteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CASTEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(subCasteModelImpl.getOriginalCasteId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CASTEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CASTEID,
					args);

				args = new Object[] { Long.valueOf(subCasteModelImpl.getCasteId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CASTEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CASTEID,
					args);
			}
		}

		EntityCacheUtil.putResult(SubCasteModelImpl.ENTITY_CACHE_ENABLED,
			SubCasteImpl.class, subCaste.getPrimaryKey(), subCaste);

		return subCaste;
	}

	protected SubCaste toUnwrappedModel(SubCaste subCaste) {
		if (subCaste instanceof SubCasteImpl) {
			return subCaste;
		}

		SubCasteImpl subCasteImpl = new SubCasteImpl();

		subCasteImpl.setNew(subCaste.isNew());
		subCasteImpl.setPrimaryKey(subCaste.getPrimaryKey());

		subCasteImpl.setSubCasteId(subCaste.getSubCasteId());
		subCasteImpl.setCasteId(subCaste.getCasteId());
		subCasteImpl.setName(subCaste.getName());

		return subCasteImpl;
	}

	/**
	 * Returns the sub caste with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the sub caste
	 * @return the sub caste
	 * @throws com.liferay.portal.NoSuchModelException if a sub caste with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubCaste findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the sub caste with the primary key or throws a {@link com.matrimony.NoSuchSubCasteException} if it could not be found.
	 *
	 * @param subCasteId the primary key of the sub caste
	 * @return the sub caste
	 * @throws com.matrimony.NoSuchSubCasteException if a sub caste with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SubCaste findByPrimaryKey(long subCasteId)
		throws NoSuchSubCasteException, SystemException {
		SubCaste subCaste = fetchByPrimaryKey(subCasteId);

		if (subCaste == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + subCasteId);
			}

			throw new NoSuchSubCasteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				subCasteId);
		}

		return subCaste;
	}

	/**
	 * Returns the sub caste with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sub caste
	 * @return the sub caste, or <code>null</code> if a sub caste with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubCaste fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the sub caste with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subCasteId the primary key of the sub caste
	 * @return the sub caste, or <code>null</code> if a sub caste with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SubCaste fetchByPrimaryKey(long subCasteId)
		throws SystemException {
		SubCaste subCaste = (SubCaste)EntityCacheUtil.getResult(SubCasteModelImpl.ENTITY_CACHE_ENABLED,
				SubCasteImpl.class, subCasteId);

		if (subCaste == _nullSubCaste) {
			return null;
		}

		if (subCaste == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				subCaste = (SubCaste)session.get(SubCasteImpl.class,
						Long.valueOf(subCasteId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (subCaste != null) {
					cacheResult(subCaste);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(SubCasteModelImpl.ENTITY_CACHE_ENABLED,
						SubCasteImpl.class, subCasteId, _nullSubCaste);
				}

				closeSession(session);
			}
		}

		return subCaste;
	}

	/**
	 * Returns all the sub castes where casteId = &#63;.
	 *
	 * @param casteId the caste ID
	 * @return the matching sub castes
	 * @throws SystemException if a system exception occurred
	 */
	public List<SubCaste> findByCasteId(long casteId) throws SystemException {
		return findByCasteId(casteId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sub castes where casteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param casteId the caste ID
	 * @param start the lower bound of the range of sub castes
	 * @param end the upper bound of the range of sub castes (not inclusive)
	 * @return the range of matching sub castes
	 * @throws SystemException if a system exception occurred
	 */
	public List<SubCaste> findByCasteId(long casteId, int start, int end)
		throws SystemException {
		return findByCasteId(casteId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sub castes where casteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param casteId the caste ID
	 * @param start the lower bound of the range of sub castes
	 * @param end the upper bound of the range of sub castes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sub castes
	 * @throws SystemException if a system exception occurred
	 */
	public List<SubCaste> findByCasteId(long casteId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CASTEID;
			finderArgs = new Object[] { casteId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CASTEID;
			finderArgs = new Object[] { casteId, start, end, orderByComparator };
		}

		List<SubCaste> list = (List<SubCaste>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SubCaste subCaste : list) {
				if ((casteId != subCaste.getCasteId())) {
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

			query.append(_SQL_SELECT_SUBCASTE_WHERE);

			query.append(_FINDER_COLUMN_CASTEID_CASTEID_2);

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

				qPos.add(casteId);

				list = (List<SubCaste>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first sub caste in the ordered set where casteId = &#63;.
	 *
	 * @param casteId the caste ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub caste
	 * @throws com.matrimony.NoSuchSubCasteException if a matching sub caste could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SubCaste findByCasteId_First(long casteId,
		OrderByComparator orderByComparator)
		throws NoSuchSubCasteException, SystemException {
		SubCaste subCaste = fetchByCasteId_First(casteId, orderByComparator);

		if (subCaste != null) {
			return subCaste;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("casteId=");
		msg.append(casteId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubCasteException(msg.toString());
	}

	/**
	 * Returns the first sub caste in the ordered set where casteId = &#63;.
	 *
	 * @param casteId the caste ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub caste, or <code>null</code> if a matching sub caste could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SubCaste fetchByCasteId_First(long casteId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SubCaste> list = findByCasteId(casteId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sub caste in the ordered set where casteId = &#63;.
	 *
	 * @param casteId the caste ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub caste
	 * @throws com.matrimony.NoSuchSubCasteException if a matching sub caste could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SubCaste findByCasteId_Last(long casteId,
		OrderByComparator orderByComparator)
		throws NoSuchSubCasteException, SystemException {
		SubCaste subCaste = fetchByCasteId_Last(casteId, orderByComparator);

		if (subCaste != null) {
			return subCaste;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("casteId=");
		msg.append(casteId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubCasteException(msg.toString());
	}

	/**
	 * Returns the last sub caste in the ordered set where casteId = &#63;.
	 *
	 * @param casteId the caste ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub caste, or <code>null</code> if a matching sub caste could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SubCaste fetchByCasteId_Last(long casteId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCasteId(casteId);

		List<SubCaste> list = findByCasteId(casteId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sub castes before and after the current sub caste in the ordered set where casteId = &#63;.
	 *
	 * @param subCasteId the primary key of the current sub caste
	 * @param casteId the caste ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sub caste
	 * @throws com.matrimony.NoSuchSubCasteException if a sub caste with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SubCaste[] findByCasteId_PrevAndNext(long subCasteId, long casteId,
		OrderByComparator orderByComparator)
		throws NoSuchSubCasteException, SystemException {
		SubCaste subCaste = findByPrimaryKey(subCasteId);

		Session session = null;

		try {
			session = openSession();

			SubCaste[] array = new SubCasteImpl[3];

			array[0] = getByCasteId_PrevAndNext(session, subCaste, casteId,
					orderByComparator, true);

			array[1] = subCaste;

			array[2] = getByCasteId_PrevAndNext(session, subCaste, casteId,
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

	protected SubCaste getByCasteId_PrevAndNext(Session session,
		SubCaste subCaste, long casteId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBCASTE_WHERE);

		query.append(_FINDER_COLUMN_CASTEID_CASTEID_2);

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

		qPos.add(casteId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(subCaste);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SubCaste> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the sub castes.
	 *
	 * @return the sub castes
	 * @throws SystemException if a system exception occurred
	 */
	public List<SubCaste> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sub castes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of sub castes
	 * @param end the upper bound of the range of sub castes (not inclusive)
	 * @return the range of sub castes
	 * @throws SystemException if a system exception occurred
	 */
	public List<SubCaste> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sub castes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of sub castes
	 * @param end the upper bound of the range of sub castes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sub castes
	 * @throws SystemException if a system exception occurred
	 */
	public List<SubCaste> findAll(int start, int end,
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

		List<SubCaste> list = (List<SubCaste>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SUBCASTE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SUBCASTE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<SubCaste>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<SubCaste>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the sub castes where casteId = &#63; from the database.
	 *
	 * @param casteId the caste ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCasteId(long casteId) throws SystemException {
		for (SubCaste subCaste : findByCasteId(casteId)) {
			remove(subCaste);
		}
	}

	/**
	 * Removes all the sub castes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (SubCaste subCaste : findAll()) {
			remove(subCaste);
		}
	}

	/**
	 * Returns the number of sub castes where casteId = &#63;.
	 *
	 * @param casteId the caste ID
	 * @return the number of matching sub castes
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCasteId(long casteId) throws SystemException {
		Object[] finderArgs = new Object[] { casteId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CASTEID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUBCASTE_WHERE);

			query.append(_FINDER_COLUMN_CASTEID_CASTEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(casteId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CASTEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of sub castes.
	 *
	 * @return the number of sub castes
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SUBCASTE);

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
	 * Initializes the sub caste persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.matrimony.model.SubCaste")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SubCaste>> listenersList = new ArrayList<ModelListener<SubCaste>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SubCaste>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SubCasteImpl.class.getName());
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
	private static final String _SQL_SELECT_SUBCASTE = "SELECT subCaste FROM SubCaste subCaste";
	private static final String _SQL_SELECT_SUBCASTE_WHERE = "SELECT subCaste FROM SubCaste subCaste WHERE ";
	private static final String _SQL_COUNT_SUBCASTE = "SELECT COUNT(subCaste) FROM SubCaste subCaste";
	private static final String _SQL_COUNT_SUBCASTE_WHERE = "SELECT COUNT(subCaste) FROM SubCaste subCaste WHERE ";
	private static final String _FINDER_COLUMN_CASTEID_CASTEID_2 = "subCaste.casteId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "subCaste.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SubCaste exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SubCaste exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SubCastePersistenceImpl.class);
	private static SubCaste _nullSubCaste = new SubCasteImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SubCaste> toCacheModel() {
				return _nullSubCasteCacheModel;
			}
		};

	private static CacheModel<SubCaste> _nullSubCasteCacheModel = new CacheModel<SubCaste>() {
			public SubCaste toEntityModel() {
				return _nullSubCaste;
			}
		};
}