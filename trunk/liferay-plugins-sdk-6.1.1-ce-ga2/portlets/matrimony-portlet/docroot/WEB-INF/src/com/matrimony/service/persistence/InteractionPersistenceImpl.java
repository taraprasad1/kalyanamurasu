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

import com.matrimony.NoSuchInteractionException;

import com.matrimony.model.Interaction;
import com.matrimony.model.impl.InteractionImpl;
import com.matrimony.model.impl.InteractionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the interaction service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author matrimony
 * @see InteractionPersistence
 * @see InteractionUtil
 * @generated
 */
public class InteractionPersistenceImpl extends BasePersistenceImpl<Interaction>
	implements InteractionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link InteractionUtil} to access the interaction persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = InteractionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(InteractionModelImpl.ENTITY_CACHE_ENABLED,
			InteractionModelImpl.FINDER_CACHE_ENABLED, InteractionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(InteractionModelImpl.ENTITY_CACHE_ENABLED,
			InteractionModelImpl.FINDER_CACHE_ENABLED, InteractionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(InteractionModelImpl.ENTITY_CACHE_ENABLED,
			InteractionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the interaction in the entity cache if it is enabled.
	 *
	 * @param interaction the interaction
	 */
	public void cacheResult(Interaction interaction) {
		EntityCacheUtil.putResult(InteractionModelImpl.ENTITY_CACHE_ENABLED,
			InteractionImpl.class, interaction.getPrimaryKey(), interaction);

		interaction.resetOriginalValues();
	}

	/**
	 * Caches the interactions in the entity cache if it is enabled.
	 *
	 * @param interactions the interactions
	 */
	public void cacheResult(List<Interaction> interactions) {
		for (Interaction interaction : interactions) {
			if (EntityCacheUtil.getResult(
						InteractionModelImpl.ENTITY_CACHE_ENABLED,
						InteractionImpl.class, interaction.getPrimaryKey()) == null) {
				cacheResult(interaction);
			}
			else {
				interaction.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all interactions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(InteractionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(InteractionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the interaction.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Interaction interaction) {
		EntityCacheUtil.removeResult(InteractionModelImpl.ENTITY_CACHE_ENABLED,
			InteractionImpl.class, interaction.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Interaction> interactions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Interaction interaction : interactions) {
			EntityCacheUtil.removeResult(InteractionModelImpl.ENTITY_CACHE_ENABLED,
				InteractionImpl.class, interaction.getPrimaryKey());
		}
	}

	/**
	 * Creates a new interaction with the primary key. Does not add the interaction to the database.
	 *
	 * @param interactionId the primary key for the new interaction
	 * @return the new interaction
	 */
	public Interaction create(long interactionId) {
		Interaction interaction = new InteractionImpl();

		interaction.setNew(true);
		interaction.setPrimaryKey(interactionId);

		return interaction;
	}

	/**
	 * Removes the interaction with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param interactionId the primary key of the interaction
	 * @return the interaction that was removed
	 * @throws com.matrimony.NoSuchInteractionException if a interaction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Interaction remove(long interactionId)
		throws NoSuchInteractionException, SystemException {
		return remove(Long.valueOf(interactionId));
	}

	/**
	 * Removes the interaction with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the interaction
	 * @return the interaction that was removed
	 * @throws com.matrimony.NoSuchInteractionException if a interaction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Interaction remove(Serializable primaryKey)
		throws NoSuchInteractionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Interaction interaction = (Interaction)session.get(InteractionImpl.class,
					primaryKey);

			if (interaction == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInteractionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(interaction);
		}
		catch (NoSuchInteractionException nsee) {
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
	protected Interaction removeImpl(Interaction interaction)
		throws SystemException {
		interaction = toUnwrappedModel(interaction);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, interaction);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(interaction);

		return interaction;
	}

	@Override
	public Interaction updateImpl(com.matrimony.model.Interaction interaction,
		boolean merge) throws SystemException {
		interaction = toUnwrappedModel(interaction);

		boolean isNew = interaction.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, interaction, merge);

			interaction.setNew(false);
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

		EntityCacheUtil.putResult(InteractionModelImpl.ENTITY_CACHE_ENABLED,
			InteractionImpl.class, interaction.getPrimaryKey(), interaction);

		return interaction;
	}

	protected Interaction toUnwrappedModel(Interaction interaction) {
		if (interaction instanceof InteractionImpl) {
			return interaction;
		}

		InteractionImpl interactionImpl = new InteractionImpl();

		interactionImpl.setNew(interaction.isNew());
		interactionImpl.setPrimaryKey(interaction.getPrimaryKey());

		interactionImpl.setInteractionId(interaction.getInteractionId());
		interactionImpl.setMaleId(interaction.getMaleId());
		interactionImpl.setFemaleId(interaction.getFemaleId());
		interactionImpl.setMaleLastViewedFemale(interaction.getMaleLastViewedFemale());
		interactionImpl.setMaleViewedCount(interaction.getMaleViewedCount());
		interactionImpl.setFemaleLastViewedMale(interaction.getFemaleLastViewedMale());
		interactionImpl.setFemaleViewedCount(interaction.getFemaleViewedCount());
		interactionImpl.setCanViewMalePhoto(interaction.isCanViewMalePhoto());
		interactionImpl.setCanViewFemalePhoto(interaction.isCanViewFemalePhoto());
		interactionImpl.setCanViewMaleContact(interaction.isCanViewMaleContact());
		interactionImpl.setCanViewFemaleContact(interaction.isCanViewFemaleContact());
		interactionImpl.setProposedOn(interaction.getProposedOn());
		interactionImpl.setProposedByMale(interaction.isProposedByMale());
		interactionImpl.setProposalNotSeen(interaction.isProposalNotSeen());
		interactionImpl.setRespondedOn(interaction.getRespondedOn());
		interactionImpl.setResponseType(interaction.getResponseType());
		interactionImpl.setResponseNotSeen(interaction.isResponseNotSeen());
		interactionImpl.setShortlistedByMale(interaction.getShortlistedByMale());
		interactionImpl.setShortlistedByFemale(interaction.getShortlistedByFemale());
		interactionImpl.setBlockedByMale(interaction.getBlockedByMale());
		interactionImpl.setBlockedByFemale(interaction.getBlockedByFemale());
		interactionImpl.setCapturedInMaleReport(interaction.getCapturedInMaleReport());
		interactionImpl.setCapturedInFemaleReport(interaction.getCapturedInFemaleReport());

		return interactionImpl;
	}

	/**
	 * Returns the interaction with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the interaction
	 * @return the interaction
	 * @throws com.liferay.portal.NoSuchModelException if a interaction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Interaction findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the interaction with the primary key or throws a {@link com.matrimony.NoSuchInteractionException} if it could not be found.
	 *
	 * @param interactionId the primary key of the interaction
	 * @return the interaction
	 * @throws com.matrimony.NoSuchInteractionException if a interaction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Interaction findByPrimaryKey(long interactionId)
		throws NoSuchInteractionException, SystemException {
		Interaction interaction = fetchByPrimaryKey(interactionId);

		if (interaction == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + interactionId);
			}

			throw new NoSuchInteractionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				interactionId);
		}

		return interaction;
	}

	/**
	 * Returns the interaction with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the interaction
	 * @return the interaction, or <code>null</code> if a interaction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Interaction fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the interaction with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param interactionId the primary key of the interaction
	 * @return the interaction, or <code>null</code> if a interaction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Interaction fetchByPrimaryKey(long interactionId)
		throws SystemException {
		Interaction interaction = (Interaction)EntityCacheUtil.getResult(InteractionModelImpl.ENTITY_CACHE_ENABLED,
				InteractionImpl.class, interactionId);

		if (interaction == _nullInteraction) {
			return null;
		}

		if (interaction == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				interaction = (Interaction)session.get(InteractionImpl.class,
						Long.valueOf(interactionId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (interaction != null) {
					cacheResult(interaction);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(InteractionModelImpl.ENTITY_CACHE_ENABLED,
						InteractionImpl.class, interactionId, _nullInteraction);
				}

				closeSession(session);
			}
		}

		return interaction;
	}

	/**
	 * Returns all the interactions.
	 *
	 * @return the interactions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Interaction> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the interactions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of interactions
	 * @param end the upper bound of the range of interactions (not inclusive)
	 * @return the range of interactions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Interaction> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the interactions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of interactions
	 * @param end the upper bound of the range of interactions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of interactions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Interaction> findAll(int start, int end,
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

		List<Interaction> list = (List<Interaction>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_INTERACTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_INTERACTION;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Interaction>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Interaction>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the interactions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Interaction interaction : findAll()) {
			remove(interaction);
		}
	}

	/**
	 * Returns the number of interactions.
	 *
	 * @return the number of interactions
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_INTERACTION);

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
	 * Initializes the interaction persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.matrimony.model.Interaction")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Interaction>> listenersList = new ArrayList<ModelListener<Interaction>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Interaction>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(InteractionImpl.class.getName());
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
	private static final String _SQL_SELECT_INTERACTION = "SELECT interaction FROM Interaction interaction";
	private static final String _SQL_COUNT_INTERACTION = "SELECT COUNT(interaction) FROM Interaction interaction";
	private static final String _ORDER_BY_ENTITY_ALIAS = "interaction.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Interaction exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(InteractionPersistenceImpl.class);
	private static Interaction _nullInteraction = new InteractionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Interaction> toCacheModel() {
				return _nullInteractionCacheModel;
			}
		};

	private static CacheModel<Interaction> _nullInteractionCacheModel = new CacheModel<Interaction>() {
			public Interaction toEntityModel() {
				return _nullInteraction;
			}
		};
}