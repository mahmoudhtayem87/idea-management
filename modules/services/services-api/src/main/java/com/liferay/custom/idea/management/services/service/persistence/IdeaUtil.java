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

package com.liferay.custom.idea.management.services.service.persistence;

import com.liferay.custom.idea.management.services.model.Idea;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the idea service. This utility wraps <code>com.liferay.custom.idea.management.services.service.persistence.impl.IdeaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IdeaPersistence
 * @generated
 */
public class IdeaUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Idea idea) {
		getPersistence().clearCache(idea);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Idea> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Idea> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Idea> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Idea> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Idea> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Idea update(Idea idea) {
		return getPersistence().update(idea);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Idea update(Idea idea, ServiceContext serviceContext) {
		return getPersistence().update(idea, serviceContext);
	}

	/**
	 * Caches the idea in the entity cache if it is enabled.
	 *
	 * @param idea the idea
	 */
	public static void cacheResult(Idea idea) {
		getPersistence().cacheResult(idea);
	}

	/**
	 * Caches the ideas in the entity cache if it is enabled.
	 *
	 * @param ideas the ideas
	 */
	public static void cacheResult(List<Idea> ideas) {
		getPersistence().cacheResult(ideas);
	}

	/**
	 * Creates a new idea with the primary key. Does not add the idea to the database.
	 *
	 * @param ideaId the primary key for the new idea
	 * @return the new idea
	 */
	public static Idea create(long ideaId) {
		return getPersistence().create(ideaId);
	}

	/**
	 * Removes the idea with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ideaId the primary key of the idea
	 * @return the idea that was removed
	 * @throws NoSuchIdeaException if a idea with the primary key could not be found
	 */
	public static Idea remove(long ideaId)
		throws com.liferay.custom.idea.management.services.exception.
			NoSuchIdeaException {

		return getPersistence().remove(ideaId);
	}

	public static Idea updateImpl(Idea idea) {
		return getPersistence().updateImpl(idea);
	}

	/**
	 * Returns the idea with the primary key or throws a <code>NoSuchIdeaException</code> if it could not be found.
	 *
	 * @param ideaId the primary key of the idea
	 * @return the idea
	 * @throws NoSuchIdeaException if a idea with the primary key could not be found
	 */
	public static Idea findByPrimaryKey(long ideaId)
		throws com.liferay.custom.idea.management.services.exception.
			NoSuchIdeaException {

		return getPersistence().findByPrimaryKey(ideaId);
	}

	/**
	 * Returns the idea with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ideaId the primary key of the idea
	 * @return the idea, or <code>null</code> if a idea with the primary key could not be found
	 */
	public static Idea fetchByPrimaryKey(long ideaId) {
		return getPersistence().fetchByPrimaryKey(ideaId);
	}

	/**
	 * Returns all the ideas.
	 *
	 * @return the ideas
	 */
	public static List<Idea> findAll() {
		return getPersistence().findAll();
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
	public static List<Idea> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Idea> findAll(
		int start, int end, OrderByComparator<Idea> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Idea> findAll(
		int start, int end, OrderByComparator<Idea> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ideas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ideas.
	 *
	 * @return the number of ideas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static IdeaPersistence getPersistence() {
		return _persistence;
	}

	private static volatile IdeaPersistence _persistence;

}