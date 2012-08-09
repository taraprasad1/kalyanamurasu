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

import com.matrimony.NoSuchProfileException;

import com.matrimony.model.Profile;
import com.matrimony.model.impl.ProfileImpl;
import com.matrimony.model.impl.ProfileModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author matrimony
 * @see ProfilePersistence
 * @see ProfileUtil
 * @generated
 */
public class ProfilePersistenceImpl extends BasePersistenceImpl<Profile>
	implements ProfilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProfileUtil} to access the profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProfileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(ProfileModelImpl.ENTITY_CACHE_ENABLED,
			ProfileModelImpl.FINDER_CACHE_ENABLED, ProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(ProfileModelImpl.ENTITY_CACHE_ENABLED,
			ProfileModelImpl.FINDER_CACHE_ENABLED, ProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			ProfileModelImpl.CREATEDBY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(ProfileModelImpl.ENTITY_CACHE_ENABLED,
			ProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(ProfileModelImpl.ENTITY_CACHE_ENABLED,
			ProfileModelImpl.FINDER_CACHE_ENABLED, ProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(ProfileModelImpl.ENTITY_CACHE_ENABLED,
			ProfileModelImpl.FINDER_CACHE_ENABLED, ProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] { Integer.class.getName() },
			ProfileModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(ProfileModelImpl.ENTITY_CACHE_ENABLED,
			ProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProfileModelImpl.ENTITY_CACHE_ENABLED,
			ProfileModelImpl.FINDER_CACHE_ENABLED, ProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProfileModelImpl.ENTITY_CACHE_ENABLED,
			ProfileModelImpl.FINDER_CACHE_ENABLED, ProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProfileModelImpl.ENTITY_CACHE_ENABLED,
			ProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the profile in the entity cache if it is enabled.
	 *
	 * @param profile the profile
	 */
	public void cacheResult(Profile profile) {
		EntityCacheUtil.putResult(ProfileModelImpl.ENTITY_CACHE_ENABLED,
			ProfileImpl.class, profile.getPrimaryKey(), profile);

		profile.resetOriginalValues();
	}

	/**
	 * Caches the profiles in the entity cache if it is enabled.
	 *
	 * @param profiles the profiles
	 */
	public void cacheResult(List<Profile> profiles) {
		for (Profile profile : profiles) {
			if (EntityCacheUtil.getResult(
						ProfileModelImpl.ENTITY_CACHE_ENABLED,
						ProfileImpl.class, profile.getPrimaryKey()) == null) {
				cacheResult(profile);
			}
			else {
				profile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all profiles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ProfileImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ProfileImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the profile.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Profile profile) {
		EntityCacheUtil.removeResult(ProfileModelImpl.ENTITY_CACHE_ENABLED,
			ProfileImpl.class, profile.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Profile> profiles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Profile profile : profiles) {
			EntityCacheUtil.removeResult(ProfileModelImpl.ENTITY_CACHE_ENABLED,
				ProfileImpl.class, profile.getPrimaryKey());
		}
	}

	/**
	 * Creates a new profile with the primary key. Does not add the profile to the database.
	 *
	 * @param profileId the primary key for the new profile
	 * @return the new profile
	 */
	public Profile create(long profileId) {
		Profile profile = new ProfileImpl();

		profile.setNew(true);
		profile.setPrimaryKey(profileId);

		return profile;
	}

	/**
	 * Removes the profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileId the primary key of the profile
	 * @return the profile that was removed
	 * @throws com.matrimony.NoSuchProfileException if a profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Profile remove(long profileId)
		throws NoSuchProfileException, SystemException {
		return remove(Long.valueOf(profileId));
	}

	/**
	 * Removes the profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the profile
	 * @return the profile that was removed
	 * @throws com.matrimony.NoSuchProfileException if a profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Profile remove(Serializable primaryKey)
		throws NoSuchProfileException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Profile profile = (Profile)session.get(ProfileImpl.class, primaryKey);

			if (profile == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProfileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(profile);
		}
		catch (NoSuchProfileException nsee) {
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
	protected Profile removeImpl(Profile profile) throws SystemException {
		profile = toUnwrappedModel(profile);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, profile);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(profile);

		return profile;
	}

	@Override
	public Profile updateImpl(com.matrimony.model.Profile profile, boolean merge)
		throws SystemException {
		profile = toUnwrappedModel(profile);

		boolean isNew = profile.isNew();

		ProfileModelImpl profileModelImpl = (ProfileModelImpl)profile;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, profile, merge);

			profile.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ProfileModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((profileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(profileModelImpl.getOriginalCreatedBy())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] {
						Long.valueOf(profileModelImpl.getCreatedBy())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((profileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(profileModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] {
						Integer.valueOf(profileModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(ProfileModelImpl.ENTITY_CACHE_ENABLED,
			ProfileImpl.class, profile.getPrimaryKey(), profile);

		return profile;
	}

	protected Profile toUnwrappedModel(Profile profile) {
		if (profile instanceof ProfileImpl) {
			return profile;
		}

		ProfileImpl profileImpl = new ProfileImpl();

		profileImpl.setNew(profile.isNew());
		profileImpl.setPrimaryKey(profile.getPrimaryKey());

		profileImpl.setProfileId(profile.getProfileId());
		profileImpl.setProfileCode(profile.getProfileCode());
		profileImpl.setCreatedForMy(profile.getCreatedForMy());
		profileImpl.setName(profile.getName());
		profileImpl.setGender(profile.isGender());
		profileImpl.setBirthDateWithTime(profile.getBirthDateWithTime());
		profileImpl.setRasi(profile.getRasi());
		profileImpl.setStar(profile.getStar());
		profileImpl.setDosam(profile.getDosam());
		profileImpl.setReligion(profile.getReligion());
		profileImpl.setCaste(profile.getCaste());
		profileImpl.setSubCaste(profile.getSubCaste());
		profileImpl.setHeight(profile.getHeight());
		profileImpl.setWeight(profile.getWeight());
		profileImpl.setComplexion(profile.getComplexion());
		profileImpl.setMotherTongue(profile.getMotherTongue());
		profileImpl.setLanguageKnown(profile.getLanguageKnown());
		profileImpl.setMaritalStatus(profile.getMaritalStatus());
		profileImpl.setChildren(profile.getChildren());
		profileImpl.setCountry(profile.getCountry());
		profileImpl.setState(profile.getState());
		profileImpl.setCity(profile.getCity());
		profileImpl.setAddress(profile.getAddress());
		profileImpl.setPinCode(profile.getPinCode());
		profileImpl.setPhone(profile.getPhone());
		profileImpl.setMobile(profile.getMobile());
		profileImpl.setEmailAddress(profile.getEmailAddress());
		profileImpl.setEducation(profile.getEducation());
		profileImpl.setProfession(profile.getProfession());
		profileImpl.setCurrency(profile.getCurrency());
		profileImpl.setAnnualIncome(profile.getAnnualIncome());
		profileImpl.setHobbies(profile.getHobbies());
		profileImpl.setAboutMe(profile.getAboutMe());
		profileImpl.setFamilyValue(profile.getFamilyValue());
		profileImpl.setFamilyType(profile.getFamilyType());
		profileImpl.setFamilyStatus(profile.getFamilyStatus());
		profileImpl.setSecurityCode(profile.getSecurityCode());
		profileImpl.setPhotoSecurityCode(profile.getPhotoSecurityCode());
		profileImpl.setLastLoggedIn(profile.getLastLoggedIn());
		profileImpl.setStatus(profile.getStatus());
		profileImpl.setScheme(profile.getScheme());
		profileImpl.setHoroscope(profile.isHoroscope());
		profileImpl.setCreatedBy(profile.getCreatedBy());
		profileImpl.setModifiedBy(profile.getModifiedBy());
		profileImpl.setCreatedDate(profile.getCreatedDate());
		profileImpl.setModifiedDate(profile.getModifiedDate());
		profileImpl.setCompanyId(profile.getCompanyId());
		profileImpl.setGroupId(profile.getGroupId());

		return profileImpl;
	}

	/**
	 * Returns the profile with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the profile
	 * @return the profile
	 * @throws com.liferay.portal.NoSuchModelException if a profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Profile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the profile with the primary key or throws a {@link com.matrimony.NoSuchProfileException} if it could not be found.
	 *
	 * @param profileId the primary key of the profile
	 * @return the profile
	 * @throws com.matrimony.NoSuchProfileException if a profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Profile findByPrimaryKey(long profileId)
		throws NoSuchProfileException, SystemException {
		Profile profile = fetchByPrimaryKey(profileId);

		if (profile == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + profileId);
			}

			throw new NoSuchProfileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				profileId);
		}

		return profile;
	}

	/**
	 * Returns the profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the profile
	 * @return the profile, or <code>null</code> if a profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Profile fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param profileId the primary key of the profile
	 * @return the profile, or <code>null</code> if a profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Profile fetchByPrimaryKey(long profileId) throws SystemException {
		Profile profile = (Profile)EntityCacheUtil.getResult(ProfileModelImpl.ENTITY_CACHE_ENABLED,
				ProfileImpl.class, profileId);

		if (profile == _nullProfile) {
			return null;
		}

		if (profile == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				profile = (Profile)session.get(ProfileImpl.class,
						Long.valueOf(profileId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (profile != null) {
					cacheResult(profile);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ProfileModelImpl.ENTITY_CACHE_ENABLED,
						ProfileImpl.class, profileId, _nullProfile);
				}

				closeSession(session);
			}
		}

		return profile;
	}

	/**
	 * Returns all the profiles where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @return the matching profiles
	 * @throws SystemException if a system exception occurred
	 */
	public List<Profile> findByUserId(long createdBy) throws SystemException {
		return findByUserId(createdBy, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the profiles where createdBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param createdBy the created by
	 * @param start the lower bound of the range of profiles
	 * @param end the upper bound of the range of profiles (not inclusive)
	 * @return the range of matching profiles
	 * @throws SystemException if a system exception occurred
	 */
	public List<Profile> findByUserId(long createdBy, int start, int end)
		throws SystemException {
		return findByUserId(createdBy, start, end, null);
	}

	/**
	 * Returns an ordered range of all the profiles where createdBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param createdBy the created by
	 * @param start the lower bound of the range of profiles
	 * @param end the upper bound of the range of profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching profiles
	 * @throws SystemException if a system exception occurred
	 */
	public List<Profile> findByUserId(long createdBy, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { createdBy };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { createdBy, start, end, orderByComparator };
		}

		List<Profile> list = (List<Profile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Profile profile : list) {
				if ((createdBy != profile.getCreatedBy())) {
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
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PROFILE_WHERE);

			query.append(_FINDER_COLUMN_USERID_CREATEDBY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ProfileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(createdBy);

				list = (List<Profile>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first profile in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile
	 * @throws com.matrimony.NoSuchProfileException if a matching profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Profile findByUserId_First(long createdBy,
		OrderByComparator orderByComparator)
		throws NoSuchProfileException, SystemException {
		Profile profile = fetchByUserId_First(createdBy, orderByComparator);

		if (profile != null) {
			return profile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createdBy=");
		msg.append(createdBy);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProfileException(msg.toString());
	}

	/**
	 * Returns the first profile in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile, or <code>null</code> if a matching profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Profile fetchByUserId_First(long createdBy,
		OrderByComparator orderByComparator) throws SystemException {
		List<Profile> list = findByUserId(createdBy, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last profile in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile
	 * @throws com.matrimony.NoSuchProfileException if a matching profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Profile findByUserId_Last(long createdBy,
		OrderByComparator orderByComparator)
		throws NoSuchProfileException, SystemException {
		Profile profile = fetchByUserId_Last(createdBy, orderByComparator);

		if (profile != null) {
			return profile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createdBy=");
		msg.append(createdBy);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProfileException(msg.toString());
	}

	/**
	 * Returns the last profile in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile, or <code>null</code> if a matching profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Profile fetchByUserId_Last(long createdBy,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(createdBy);

		List<Profile> list = findByUserId(createdBy, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the profiles before and after the current profile in the ordered set where createdBy = &#63;.
	 *
	 * @param profileId the primary key of the current profile
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile
	 * @throws com.matrimony.NoSuchProfileException if a profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Profile[] findByUserId_PrevAndNext(long profileId, long createdBy,
		OrderByComparator orderByComparator)
		throws NoSuchProfileException, SystemException {
		Profile profile = findByPrimaryKey(profileId);

		Session session = null;

		try {
			session = openSession();

			Profile[] array = new ProfileImpl[3];

			array[0] = getByUserId_PrevAndNext(session, profile, createdBy,
					orderByComparator, true);

			array[1] = profile;

			array[2] = getByUserId_PrevAndNext(session, profile, createdBy,
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

	protected Profile getByUserId_PrevAndNext(Session session, Profile profile,
		long createdBy, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROFILE_WHERE);

		query.append(_FINDER_COLUMN_USERID_CREATEDBY_2);

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

		else {
			query.append(ProfileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(createdBy);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(profile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Profile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the profiles where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching profiles
	 * @throws SystemException if a system exception occurred
	 */
	public List<Profile> findByStatus(int status) throws SystemException {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the profiles where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of profiles
	 * @param end the upper bound of the range of profiles (not inclusive)
	 * @return the range of matching profiles
	 * @throws SystemException if a system exception occurred
	 */
	public List<Profile> findByStatus(int status, int start, int end)
		throws SystemException {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the profiles where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of profiles
	 * @param end the upper bound of the range of profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching profiles
	 * @throws SystemException if a system exception occurred
	 */
	public List<Profile> findByStatus(int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<Profile> list = (List<Profile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Profile profile : list) {
				if ((status != profile.getStatus())) {
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
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PROFILE_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ProfileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				list = (List<Profile>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first profile in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile
	 * @throws com.matrimony.NoSuchProfileException if a matching profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Profile findByStatus_First(int status,
		OrderByComparator orderByComparator)
		throws NoSuchProfileException, SystemException {
		Profile profile = fetchByStatus_First(status, orderByComparator);

		if (profile != null) {
			return profile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProfileException(msg.toString());
	}

	/**
	 * Returns the first profile in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile, or <code>null</code> if a matching profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Profile fetchByStatus_First(int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<Profile> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last profile in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile
	 * @throws com.matrimony.NoSuchProfileException if a matching profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Profile findByStatus_Last(int status,
		OrderByComparator orderByComparator)
		throws NoSuchProfileException, SystemException {
		Profile profile = fetchByStatus_Last(status, orderByComparator);

		if (profile != null) {
			return profile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProfileException(msg.toString());
	}

	/**
	 * Returns the last profile in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile, or <code>null</code> if a matching profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Profile fetchByStatus_Last(int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatus(status);

		List<Profile> list = findByStatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the profiles before and after the current profile in the ordered set where status = &#63;.
	 *
	 * @param profileId the primary key of the current profile
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile
	 * @throws com.matrimony.NoSuchProfileException if a profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Profile[] findByStatus_PrevAndNext(long profileId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchProfileException, SystemException {
		Profile profile = findByPrimaryKey(profileId);

		Session session = null;

		try {
			session = openSession();

			Profile[] array = new ProfileImpl[3];

			array[0] = getByStatus_PrevAndNext(session, profile, status,
					orderByComparator, true);

			array[1] = profile;

			array[2] = getByStatus_PrevAndNext(session, profile, status,
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

	protected Profile getByStatus_PrevAndNext(Session session, Profile profile,
		int status, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROFILE_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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

		else {
			query.append(ProfileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(profile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Profile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the profiles.
	 *
	 * @return the profiles
	 * @throws SystemException if a system exception occurred
	 */
	public List<Profile> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of profiles
	 * @param end the upper bound of the range of profiles (not inclusive)
	 * @return the range of profiles
	 * @throws SystemException if a system exception occurred
	 */
	public List<Profile> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of profiles
	 * @param end the upper bound of the range of profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of profiles
	 * @throws SystemException if a system exception occurred
	 */
	public List<Profile> findAll(int start, int end,
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

		List<Profile> list = (List<Profile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROFILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROFILE.concat(ProfileModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Profile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Profile>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the profiles where createdBy = &#63; from the database.
	 *
	 * @param createdBy the created by
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId(long createdBy) throws SystemException {
		for (Profile profile : findByUserId(createdBy)) {
			remove(profile);
		}
	}

	/**
	 * Removes all the profiles where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStatus(int status) throws SystemException {
		for (Profile profile : findByStatus(status)) {
			remove(profile);
		}
	}

	/**
	 * Removes all the profiles from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Profile profile : findAll()) {
			remove(profile);
		}
	}

	/**
	 * Returns the number of profiles where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @return the number of matching profiles
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long createdBy) throws SystemException {
		Object[] finderArgs = new Object[] { createdBy };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROFILE_WHERE);

			query.append(_FINDER_COLUMN_USERID_CREATEDBY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(createdBy);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of profiles where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching profiles
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStatus(int status) throws SystemException {
		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROFILE_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of profiles.
	 *
	 * @return the number of profiles
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROFILE);

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
	 * Initializes the profile persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.matrimony.model.Profile")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Profile>> listenersList = new ArrayList<ModelListener<Profile>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Profile>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ProfileImpl.class.getName());
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
	private static final String _SQL_SELECT_PROFILE = "SELECT profile FROM Profile profile";
	private static final String _SQL_SELECT_PROFILE_WHERE = "SELECT profile FROM Profile profile WHERE ";
	private static final String _SQL_COUNT_PROFILE = "SELECT COUNT(profile) FROM Profile profile";
	private static final String _SQL_COUNT_PROFILE_WHERE = "SELECT COUNT(profile) FROM Profile profile WHERE ";
	private static final String _FINDER_COLUMN_USERID_CREATEDBY_2 = "profile.createdBy = ?";
	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "profile.status = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "profile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Profile exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Profile exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ProfilePersistenceImpl.class);
	private static Profile _nullProfile = new ProfileImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Profile> toCacheModel() {
				return _nullProfileCacheModel;
			}
		};

	private static CacheModel<Profile> _nullProfileCacheModel = new CacheModel<Profile>() {
			public Profile toEntityModel() {
				return _nullProfile;
			}
		};
}