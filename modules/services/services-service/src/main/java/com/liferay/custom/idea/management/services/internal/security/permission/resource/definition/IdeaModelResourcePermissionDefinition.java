package com.liferay.custom.idea.management.services.internal.security.permission.resource.definition;

import com.liferay.custom.idea.management.services.model.Idea;
import com.liferay.custom.idea.management.services.service.IdeaLocalService;
import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.StagedModelPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.WorkflowedModelPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.definition.ModelResourcePermissionDefinition;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermission;
import com.liferay.sharing.security.permission.resource.SharingModelResourcePermissionConfigurator;
import java.util.function.Consumer;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@Component(immediate = true, service = ModelResourcePermissionDefinition.class)
public class IdeaModelResourcePermissionDefinition implements ModelResourcePermissionDefinition<Idea> {

	@Override
	public Idea getModel(long entryId) throws PortalException {
		return _ideaLocalService.getIdea(entryId);
	}

	@Override
	public Class<Idea> getModelClass() {
		return Idea.class;
	}

	@Override
	public PortletResourcePermission getPortletResourcePermission() {
		return _portletResourcePermission;
	}

	@Override
	public long getPrimaryKey(Idea idea) {
		return idea.getIdeaId();
	}

	@Override
	public void registerModelResourcePermissionLogics(
		ModelResourcePermission<Idea> modelResourcePermission,
		Consumer<ModelResourcePermissionLogic<Idea>>
			modelResourcePermissionLogicConsumer) {

		modelResourcePermissionLogicConsumer.accept(
			new StagedModelPermissionLogic<>(
				_stagingPermission, "Ideas",
				Idea::getIdeaId));
		modelResourcePermissionLogicConsumer.accept(
			new WorkflowedModelPermissionLogic<>(
				_workflowPermission, modelResourcePermission,
				_groupLocalService, Idea::getIdeaId));

		if (_sharingModelResourcePermissionConfigurator != null) {
			_sharingModelResourcePermissionConfigurator.configure(
				modelResourcePermission, modelResourcePermissionLogicConsumer);
		}
	}

	@Reference
	private IdeaLocalService _ideaLocalService;

	@Reference
	private GroupLocalService _groupLocalService;

	@Reference(target = "(resource.name=" + "Idea" + ")")
	private PortletResourcePermission _portletResourcePermission;

	@Reference(
		cardinality = ReferenceCardinality.OPTIONAL,
		policyOption = ReferencePolicyOption.GREEDY
	)
	private volatile SharingModelResourcePermissionConfigurator
		_sharingModelResourcePermissionConfigurator;

	@Reference
	private StagingPermission _stagingPermission;

	@Reference
	private WorkflowPermission _workflowPermission;
}
