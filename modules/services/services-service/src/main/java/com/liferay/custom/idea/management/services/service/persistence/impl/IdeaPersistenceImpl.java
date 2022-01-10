/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.custom.idea.management.services.service.persistence.impl;

import com.liferay.custom.idea.management.services.exception.NoSuchIdeaException;
import com.liferay.custom.idea.management.services.model.Idea;
import com.liferay.custom.idea.management.services.model.IdeaTable;
import com.liferay.custom.idea.management.services.model.impl.IdeaImpl;
import com.liferay.custom.idea.management.services.model.impl.IdeaModelImpl;
import com.liferay.custom.idea.management.services.service.persistence.IdeaPersistence;
import com.liferay.custom.idea.management.services.service.persistence.IdeaUtil;
import com.liferay.custom.idea.management.services.service.persistence.impl.constants.IdeaManagementPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the idea service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {IdeaPersistence.class, BasePersistence.class})
public class IdeaPersistenceImpl
	extends BasePersistenceImpl<Idea> implements IdeaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>IdeaUtil</code> to access the idea persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		IdeaImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public IdeaPersistenceImpl() {
		setModelClass(Idea.class);

		setModelImplClass(IdeaImpl.class);
		setModelPKClass(long.class);

		setTable(IdeaTable.INSTANCE);
	}

	/**
	 * Caches the idea in the entity cache if it is enabled.
	 *
	 * @param idea the idea
	 */
	@Override
	public void cacheResult(Idea idea) {
		entityCache.putResult(IdeaImpl.class, idea.getPrimaryKey(), idea);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the ideas in the entity cache if it is enabled.
	 *
	 * @param ideas the ideas
	 */
	@Override
	public void cacheResult(List<Idea> ideas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (ideas.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Idea idea : ideas) {
			if (entityCache.getResult(IdeaImpl.class, idea.getPrimaryKey()) ==
					null) {

				cacheResult(idea);
			}
		}
	}

	/**
	 * Clears the cache for all ideas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(IdeaImpl.class);

		finderCache.clearCache(IdeaImpl.class);
	}

	/**
	 * Clears the cache for the idea.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Idea idea) {
		entityCache.removeResult(IdeaImpl.class, idea);
	}

	@Override
	public void clearCache(List<Idea> ideas) {
		for (Idea idea : ideas) {
			entityCache.removeResult(IdeaImpl.class, idea);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(IdeaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(IdeaImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new idea with the primary key. Does not add the idea to the database.
	 *
	 * @param ideaId the primary key for the new idea
	 * @return the new idea
	 */
	@Override
	public Idea create(long ideaId) {
		Idea idea = new IdeaImpl();

		idea.setNew(true);
		idea.setPrimaryKey(ideaId);

		idea.setCompanyId(CompanyThreadLocal.getCompanyId());

		return idea;
	}

	/**
	 * Removes the idea with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ideaId the primary key of the idea
	 * @return the idea that was removed
	 * @throws NoSuchIdeaException if a idea with the primary key could not be found
	 */
	@Override
	public Idea remove(long ideaId) throws NoSuchIdeaException {
		return remove((Serializable)ideaId);
	}

	/**
	 * Removes the idea with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the idea
	 * @return the idea that was removed
	 * @throws NoSuchIdeaException if a idea with the primary key could not be found
	 */
	@Override
	public Idea remove(Serializable primaryKey) throws NoSuchIdeaException {
		Session session = null;

		try {
			session = openSession();

			Idea idea = (Idea)session.get(IdeaImpl.class, primaryKey);

			if (idea == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchIdeaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(idea);
		}
		catch (NoSuchIdeaException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Idea removeImpl(Idea idea) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(idea)) {
				idea = (Idea)session.get(
					IdeaImpl.class, idea.getPrimaryKeyObj());
			}

			if (idea != null) {
				session.delete(idea);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (idea != null) {
			clearCache(idea);
		}

		return idea;
	}

	@Override
	public Idea updateImpl(Idea idea) {
		boolean isNew = idea.isNew();

		if (!(idea instanceof IdeaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(idea.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(idea);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in idea proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Idea implementation " +
					idea.getClass());
		}

		IdeaModelImpl ideaModelImpl = (IdeaModelImpl)idea;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (idea.getCreateDate() == null)) {
			if (serviceContext == null) {
				idea.setCreateDate(date);
			}
			else {
				idea.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!ideaModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				idea.setModifiedDate(date);
			}
			else {
				idea.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(idea);
			}
			else {
				idea = (Idea)session.merge(idea);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(IdeaImpl.class, idea, false, true);

		if (isNew) {
			idea.setNew(false);
		}

		idea.resetOriginalValues();

		return idea;
	}

	/**
	 * Returns the idea with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the idea
	 * @return the idea
	 * @throws NoSuchIdeaException if a idea with the primary key could not be found
	 */
	@Override
	public Idea findByPrimaryKey(Serializable primaryKey)
		throws NoSuchIdeaException {

		Idea idea = fetchByPrimaryKey(primaryKey);

		if (idea == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchIdeaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return idea;
	}

	/**
	 * Returns the idea with the primary key or throws a <code>NoSuchIdeaException</code> if it could not be found.
	 *
	 * @param ideaId the primary key of the idea
	 * @return the idea
	 * @throws NoSuchIdeaException if a idea with the primary key could not be found
	 */
	@Override
	public Idea findByPrimaryKey(long ideaId) throws NoSuchIdeaException {
		return findByPrimaryKey((Serializable)ideaId);
	}

	/**
	 * Returns the idea with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ideaId the primary key of the idea
	 * @return the idea, or <code>null</code> if a idea with the primary key could not be found
	 */
	@Override
	public Idea fetchByPrimaryKey(long ideaId) {
		return fetchByPrimaryKey((Serializable)ideaId);
	}

	/**
	 * Returns all the ideas.
	 *
	 * @return the ideas
	 */
	@Override
	public List<Idea> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ideas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IdeaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ideas
	 * @param end the upper bound of the range of ideas (not inclusive)
	 * @return the range of ideas
	 */
	@Override
	public List<Idea> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ideas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IdeaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ideas
	 * @param end the upper bound of the range of ideas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ideas
	 */
	@Override
	public List<Idea> findAll(
		int start, int end, OrderByComparator<Idea> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ideas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IdeaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ideas
	 * @param end the upper bound of the range of ideas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ideas
	 */
	@Override
	public List<Idea> findAll(
		int start, int end, OrderByComparator<Idea> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Idea> list = null;

		if (useFinderCache) {
			list = (List<Idea>)finderCache.getResult(finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_IDEA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_IDEA;

				sql = sql.concat(IdeaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Idea>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the ideas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Idea idea : findAll()) {
			remove(idea);
		}
	}

	/**
	 * Returns the number of ideas.
	 *
	 * @return the number of ideas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_IDEA);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "ideaId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_IDEA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return IdeaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the idea persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_setIdeaUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setIdeaUtilPersistence(null);

		entityCache.removeCache(IdeaImpl.class.getName());
	}

	private void _setIdeaUtilPersistence(IdeaPersistence ideaPersistence) {
		try {
			Field field = IdeaUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, ideaPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = IdeaManagementPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = IdeaManagementPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = IdeaManagementPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_IDEA = "SELECT idea FROM Idea idea";

	private static final String _SQL_COUNT_IDEA =
		"SELECT COUNT(idea) FROM Idea idea";

	private static final String _ORDER_BY_ENTITY_ALIAS = "idea.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Idea exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		IdeaPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private IdeaModelArgumentsResolver _ideaModelArgumentsResolver;

}