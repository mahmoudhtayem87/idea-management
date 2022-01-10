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

import com.liferay.custom.idea.management.services.exception.NoSuchIdeaException;
import com.liferay.custom.idea.management.services.model.Idea;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the idea service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IdeaUtil
 * @generated
 */
@ProviderType
public interface IdeaPersistence extends BasePersistence<Idea> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link IdeaUtil} to access the idea persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the idea in the entity cache if it is enabled.
	 *
	 * @param idea the idea
	 */
	public void cacheResult(Idea idea);

	/**
	 * Caches the ideas in the entity cache if it is enabled.
	 *
	 * @param ideas the ideas
	 */
	public void cacheResult(java.util.List<Idea> ideas);

	/**
	 * Creates a new idea with the primary key. Does not add the idea to the database.
	 *
	 * @param ideaId the primary key for the new idea
	 * @return the new idea
	 */
	public Idea create(long ideaId);

	/**
	 * Removes the idea with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ideaId the primary key of the idea
	 * @return the idea that was removed
	 * @throws NoSuchIdeaException if a idea with the primary key could not be found
	 */
	public Idea remove(long ideaId) throws NoSuchIdeaException;

	public Idea updateImpl(Idea idea);

	/**
	 * Returns the idea with the primary key or throws a <code>NoSuchIdeaException</code> if it could not be found.
	 *
	 * @param ideaId the primary key of the idea
	 * @return the idea
	 * @throws NoSuchIdeaException if a idea with the primary key could not be found
	 */
	public Idea findByPrimaryKey(long ideaId) throws NoSuchIdeaException;

	/**
	 * Returns the idea with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ideaId the primary key of the idea
	 * @return the idea, or <code>null</code> if a idea with the primary key could not be found
	 */
	public Idea fetchByPrimaryKey(long ideaId);

	/**
	 * Returns all the ideas.
	 *
	 * @return the ideas
	 */
	public java.util.List<Idea> findAll();

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
	public java.util.List<Idea> findAll(int start, int end);

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
	public java.util.List<Idea> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Idea>
			orderByComparator);

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
	public java.util.List<Idea> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Idea>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ideas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ideas.
	 *
	 * @return the number of ideas
	 */
	public int countAll();

}