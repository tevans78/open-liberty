/*******************************************************************************
 * Copyright (c) 2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.websphere.simplicity.commands.idmgrrepositoryconfig;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Updates the configuration of the specified repository. To add multiple values to a multivalued parameter, call this command repeatedly.
 *   'EntityTypesNotAllowCreate': Name of the entity type that cannot be created in this repository. To add to the parameter, specify a list. To reset all the values of this parameter, specify an empty list.
 *   'EntityTypesNotAllowDelete': Name of the entity type that cannot be deleted from this repository. To add to the parameter, specify a list. To reset all the values of this parameter, specify an empty list.
 *   'EntityTypesNotAllowRead': Name of the entity type that cannot be read from this repository. To add to the parameter, specify a list. To reset all the values of this parameter, specify an empty list.
 *   'EntityTypesNotAllowUpdate': Name of the entity type that cannot be updated in this repository. To add to the parameter, specify a list. To reset all the values of this parameter, specify an empty list.
 *   'adapterClassName': The implementation class name for the repository adapter.
 *   'id': The unique identifier of the repository.
 *   'isExtIdUnique': A boolean representing if the external ID for entities in the repository is unique
 *   'loginProperties': A semicolon separated list of virtual member manager properties that can be used for login. To add to the parameter, specify a list. To reset all the values of this parameter, specify an empty list.
 *   'readOnly': Is this a read only repository?
 *   'repositoriesForGroups': Repository ID where group data is stored.
 *   'supportAsyncMode': A boolean representing if the adapter supports asynchronous mode
 *   'supportExternalName': A boolean representing if the repository supports external names
 *   'supportPaging': A boolean representing if the repository supports paging
 *   'supportSorting': A boolean representing if the repository supports sorting
 *   'supportTransactions': A boolean representing if the repository supports transactions
 * The required parameters are found in the constructor.
 */
public class UpdateIdMgrRepository extends Command {

	private String EntityTypesNotAllowCreate;
	private String EntityTypesNotAllowDelete;
	private String EntityTypesNotAllowRead;
	private String EntityTypesNotAllowUpdate;
	private String adapterClassName;
	private String id;
	private Boolean isExtIdUnique;
	private String loginProperties;
	private Boolean readOnly;
	private String repositoriesForGroups;
	private Boolean supportAsyncMode;
	private Boolean supportExternalName;
	private Boolean supportPaging;
	private Boolean supportSorting;
	private Boolean supportTransactions;

	public UpdateIdMgrRepository(String id) {
		super("updateIdMgrRepository");
		this.id = id;
	}

	/**
	 * Name of the entity type that cannot be created in this repository. To add to the parameter, specify a list. To reset all the values of this parameter, specify an empty list.
	 */
	public String getEntityTypesNotAllowCreate() {
		return this.EntityTypesNotAllowCreate;
	}

	/**
	 * Name of the entity type that cannot be created in this repository. To add to the parameter, specify a list. To reset all the values of this parameter, specify an empty list.
	 */
	public void setEntityTypesNotAllowCreate(String value) {
		this.EntityTypesNotAllowCreate = value;
	}

	/**
	 * Name of the entity type that cannot be deleted from this repository. To add to the parameter, specify a list. To reset all the values of this parameter, specify an empty list.
	 */
	public String getEntityTypesNotAllowDelete() {
		return this.EntityTypesNotAllowDelete;
	}

	/**
	 * Name of the entity type that cannot be deleted from this repository. To add to the parameter, specify a list. To reset all the values of this parameter, specify an empty list.
	 */
	public void setEntityTypesNotAllowDelete(String value) {
		this.EntityTypesNotAllowDelete = value;
	}

	/**
	 * Name of the entity type that cannot be read from this repository. To add to the parameter, specify a list. To reset all the values of this parameter, specify an empty list.
	 */
	public String getEntityTypesNotAllowRead() {
		return this.EntityTypesNotAllowRead;
	}

	/**
	 * Name of the entity type that cannot be read from this repository. To add to the parameter, specify a list. To reset all the values of this parameter, specify an empty list.
	 */
	public void setEntityTypesNotAllowRead(String value) {
		this.EntityTypesNotAllowRead = value;
	}

	/**
	 * Name of the entity type that cannot be updated in this repository. To add to the parameter, specify a list. To reset all the values of this parameter, specify an empty list.
	 */
	public String getEntityTypesNotAllowUpdate() {
		return this.EntityTypesNotAllowUpdate;
	}

	/**
	 * Name of the entity type that cannot be updated in this repository. To add to the parameter, specify a list. To reset all the values of this parameter, specify an empty list.
	 */
	public void setEntityTypesNotAllowUpdate(String value) {
		this.EntityTypesNotAllowUpdate = value;
	}

	/**
	 * The implementation class name for the repository adapter.
	 */
	public String getAdapterClassName() {
		return this.adapterClassName;
	}

	/**
	 * The implementation class name for the repository adapter.
	 */
	public void setAdapterClassName(String value) {
		this.adapterClassName = value;
	}

	/**
	 * The unique identifier of the repository.
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * The unique identifier of the repository.
	 */
	public void setId(String value) {
		this.id = value;
	}

	/**
	 * A boolean representing if the external ID for entities in the repository is unique
	 */
	public Boolean getIsExtIdUnique() {
		return this.isExtIdUnique;
	}

	/**
	 * A boolean representing if the external ID for entities in the repository is unique
	 */
	public void setIsExtIdUnique(Boolean value) {
		this.isExtIdUnique = value;
	}

	/**
	 * A semicolon separated list of virtual member manager properties that can be used for login. To add to the parameter, specify a list. To reset all the values of this parameter, specify an empty list.
	 */
	public String getLoginProperties() {
		return this.loginProperties;
	}

	/**
	 * A semicolon separated list of virtual member manager properties that can be used for login. To add to the parameter, specify a list. To reset all the values of this parameter, specify an empty list.
	 */
	public void setLoginProperties(String value) {
		this.loginProperties = value;
	}

	/**
	 * Is this a read only repository?
	 */
	public Boolean getReadOnly() {
		return this.readOnly;
	}

	/**
	 * Is this a read only repository?
	 */
	public void setReadOnly(Boolean value) {
		this.readOnly = value;
	}

	/**
	 * Repository ID where group data is stored.
	 */
	public String getRepositoriesForGroups() {
		return this.repositoriesForGroups;
	}

	/**
	 * Repository ID where group data is stored.
	 */
	public void setRepositoriesForGroups(String value) {
		this.repositoriesForGroups = value;
	}

	/**
	 * A boolean representing if the adapter supports asynchronous mode
	 */
	public Boolean getSupportAsyncMode() {
		return this.supportAsyncMode;
	}

	/**
	 * A boolean representing if the adapter supports asynchronous mode
	 */
	public void setSupportAsyncMode(Boolean value) {
		this.supportAsyncMode = value;
	}

	/**
	 * A boolean representing if the repository supports external names
	 */
	public Boolean getSupportExternalName() {
		return this.supportExternalName;
	}

	/**
	 * A boolean representing if the repository supports external names
	 */
	public void setSupportExternalName(Boolean value) {
		this.supportExternalName = value;
	}

	/**
	 * A boolean representing if the repository supports paging
	 */
	public Boolean getSupportPaging() {
		return this.supportPaging;
	}

	/**
	 * A boolean representing if the repository supports paging
	 */
	public void setSupportPaging(Boolean value) {
		this.supportPaging = value;
	}

	/**
	 * A boolean representing if the repository supports sorting
	 */
	public Boolean getSupportSorting() {
		return this.supportSorting;
	}

	/**
	 * A boolean representing if the repository supports sorting
	 */
	public void setSupportSorting(Boolean value) {
		this.supportSorting = value;
	}

	/**
	 * A boolean representing if the repository supports transactions
	 */
	public Boolean getSupportTransactions() {
		return this.supportTransactions;
	}

	/**
	 * A boolean representing if the repository supports transactions
	 */
	public void setSupportTransactions(Boolean value) {
		this.supportTransactions = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.EntityTypesNotAllowCreate != null) {
			ret.put("EntityTypesNotAllowCreate", this.EntityTypesNotAllowCreate);
		}
		if (this.EntityTypesNotAllowDelete != null) {
			ret.put("EntityTypesNotAllowDelete", this.EntityTypesNotAllowDelete);
		}
		if (this.EntityTypesNotAllowRead != null) {
			ret.put("EntityTypesNotAllowRead", this.EntityTypesNotAllowRead);
		}
		if (this.EntityTypesNotAllowUpdate != null) {
			ret.put("EntityTypesNotAllowUpdate", this.EntityTypesNotAllowUpdate);
		}
		if (this.adapterClassName != null) {
			ret.put("adapterClassName", this.adapterClassName);
		}
		ret.put("id", this.id);
		if (this.isExtIdUnique != null) {
			ret.put("isExtIdUnique", this.isExtIdUnique);
		}
		if (this.loginProperties != null) {
			ret.put("loginProperties", this.loginProperties);
		}
		if (this.readOnly != null) {
			ret.put("readOnly", this.readOnly);
		}
		if (this.repositoriesForGroups != null) {
			ret.put("repositoriesForGroups", this.repositoriesForGroups);
		}
		if (this.supportAsyncMode != null) {
			ret.put("supportAsyncMode", this.supportAsyncMode);
		}
		if (this.supportExternalName != null) {
			ret.put("supportExternalName", this.supportExternalName);
		}
		if (this.supportPaging != null) {
			ret.put("supportPaging", this.supportPaging);
		}
		if (this.supportSorting != null) {
			ret.put("supportSorting", this.supportSorting);
		}
		if (this.supportTransactions != null) {
			ret.put("supportTransactions", this.supportTransactions);
		}
		return ret;
	}

	public Object __getTarget() {
		return null;
	}

	public List<Command> __getSteps() {
		return null;
	}

	/**
	 * Executes the command against the specified scope.
	 */
	public OperationResults<Object> run(Scope scope) throws Exception {
		return super.run(scope);
	}

}
