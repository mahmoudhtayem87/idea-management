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

package com.liferay.custom.idea.management.services.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link IdeaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see IdeaLocalService
 * @generated
 */
public class IdeaLocalServiceWrapper
	implements IdeaLocalService, ServiceWrapper<IdeaLocalService> {

	public IdeaLocalServiceWrapper(IdeaLocalService ideaLocalService) {
		_ideaLocalService = ideaLocalService;
	}

	/**
	 * Adds the idea to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IdeaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param idea the idea
	 * @return the idea that was added
	 */
	@Override
	public com.liferay.custom.idea.management.services.model.Idea addIdea(
		com.liferay.custom.idea.management.services.model.Idea idea) {

		return _ideaLocalService.addIdea(idea);
	}

	/**
	 * Creates a new idea with the primary key. Does not add the idea to the database.
	 *
	 * @param ideaId the primary key for the new idea
	 * @return the new idea
	 */
	@Override
	public com.liferay.custom.idea.management.services.model.Idea createIdea(
		long ideaId) {

		return _ideaLocalService.createIdea(ideaId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ideaLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the idea from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IdeaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param idea the idea
	 * @return the idea that was removed
	 */
	@Override
	public com.liferay.custom.idea.management.services.model.Idea deleteIdea(
		com.liferay.custom.idea.management.services.model.Idea idea) {

		return _ideaLocalService.deleteIdea(idea);
	}

	/**
	 * Deletes the idea with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IdeaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ideaId the primary key of the idea
	 * @return the idea that was removed
	 * @throws PortalException if a idea with the primary key could not be found
	 */
	@Override
	public com.liferay.custom.idea.management.services.model.Idea deleteIdea(
			long ideaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ideaLocalService.deleteIdea(ideaId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ideaLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _ideaLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _ideaLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ideaLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _ideaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.custom.idea.management.services.model.impl.IdeaModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _ideaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.custom.idea.management.services.model.impl.IdeaModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _ideaLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _ideaLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _ideaLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.custom.idea.management.services.model.Idea fetchIdea(
		long ideaId) {

		return _ideaLocalService.fetchIdea(ideaId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ideaLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the idea with the primary key.
	 *
	 * @param ideaId the primary key of the idea
	 * @return the idea
	 * @throws PortalException if a idea with the primary key could not be found
	 */
	@Override
	public com.liferay.custom.idea.management.services.model.Idea getIdea(
			long ideaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ideaLocalService.getIdea(ideaId);
	}

	@Override
	public com.liferay.custom.idea.management.services.model.Idea getIdeaEntry(
			long ideaId)
		throws com.liferay.custom.idea.management.services.exception.
			NoSuchIdeaException {

		return _ideaLocalService.getIdeaEntry(ideaId);
	}

	/**
	 * Returns a range of all the ideas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.custom.idea.management.services.model.impl.IdeaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ideas
	 * @param end the upper bound of the range of ideas (not inclusive)
	 * @return the range of ideas
	 */
	@Override
	public java.util.List
		<com.liferay.custom.idea.management.services.model.Idea> getIdeas(
			int start, int end) {

		return _ideaLocalService.getIdeas(start, end);
	}

	/**
	 * Returns the number of ideas.
	 *
	 * @return the number of ideas
	 */
	@Override
	public int getIdeasCount() {
		return _ideaLocalService.getIdeasCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ideaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ideaLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ideaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the idea in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IdeaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param idea the idea
	 * @return the idea that was updated
	 */
	@Override
	public com.liferay.custom.idea.management.services.model.Idea updateIdea(
		com.liferay.custom.idea.management.services.model.Idea idea) {

		return _ideaLocalService.updateIdea(idea);
	}

	@Override
	public IdeaLocalService getWrappedService() {
		return _ideaLocalService;
	}

	@Override
	public void setWrappedService(IdeaLocalService ideaLocalService) {
		_ideaLocalService = ideaLocalService;
	}

	private IdeaLocalService _ideaLocalService;

}