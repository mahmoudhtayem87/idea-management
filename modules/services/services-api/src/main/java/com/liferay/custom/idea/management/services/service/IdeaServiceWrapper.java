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
 * Provides a wrapper for {@link IdeaService}.
 *
 * @author Brian Wing Shun Chan
 * @see IdeaService
 * @generated
 */
public class IdeaServiceWrapper
	implements IdeaService, ServiceWrapper<IdeaService> {

	public IdeaServiceWrapper(IdeaService ideaService) {
		_ideaService = ideaService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ideaService.getOSGiServiceIdentifier();
	}

	@Override
	public IdeaService getWrappedService() {
		return _ideaService;
	}

	@Override
	public void setWrappedService(IdeaService ideaService) {
		_ideaService = ideaService;
	}

	private IdeaService _ideaService;

}