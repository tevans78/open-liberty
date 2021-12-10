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

package com.ibm.websphere.simplicity.commands.idmgrdatamodel;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Adds a property to one or more entity types either into repositories or into the property extension repository.
 *   'name': Name of the new property being added to one or more existing entity types.
 *   'entityTypeNames': Names of one or more existing entity types. Use ';' as delimiter while specifying multiple entity types. A valid namespace prefix can be used to refer to entity type names in a specific namespace.
 *   'dataType': Data type of the property.
 *   'nsURI': Namespace to which this new property must be added. If nothing is specified then it is added to the default namespace.
 *   'nsPrefix': The prefix that must be added to the namespace URI.
 *   'isMultiValued': A boolean that indicates whether the new property can accept more than one value.
 *   'repositoryIds': Identifiers of the repositories for which the new property should be added. If not specified, the new property will be added for all the repositories. Use repository ID 'LA' for property extension repository. Use ';' as delimiter while specifying multiple repository IDs.
 *   'requiredEntityTypeNames': Required entity type for which a property is required. Use ';' as delimiter while specifying multiple entity types.
 *   'applicationId': Indicates the ID of the application that extends the property.
 * The required parameters are found in the constructor.
 */
public class AddIdMgrPropertyToEntityTypes extends Command {

	private String name;
	private String entityTypeNames;
	private String dataType;
	private String nsURI;
	private String nsPrefix;
	private Boolean isMultiValued = false;
	private String repositoryIds;
	private String requiredEntityTypeNames;
	private String applicationId;

	public AddIdMgrPropertyToEntityTypes(String name, String entityTypeNames, String dataType) {
		super("addIdMgrPropertyToEntityTypes");
		this.name = name;
		this.entityTypeNames = entityTypeNames;
		this.dataType = dataType;
	}

	/**
	 * Name of the new property being added to one or more existing entity types.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Name of the new property being added to one or more existing entity types.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Names of one or more existing entity types. Use ';' as delimiter while specifying multiple entity types. A valid namespace prefix can be used to refer to entity type names in a specific namespace.
	 */
	public String getEntityTypeNames() {
		return this.entityTypeNames;
	}

	/**
	 * Names of one or more existing entity types. Use ';' as delimiter while specifying multiple entity types. A valid namespace prefix can be used to refer to entity type names in a specific namespace.
	 */
	public void setEntityTypeNames(String value) {
		this.entityTypeNames = value;
	}

	/**
	 * Data type of the property.
	 */
	public String getDataType() {
		return this.dataType;
	}

	/**
	 * Data type of the property.
	 */
	public void setDataType(String value) {
		this.dataType = value;
	}

	/**
	 * Namespace to which this new property must be added. If nothing is specified then it is added to the default namespace.
	 */
	public String getNsURI() {
		return this.nsURI;
	}

	/**
	 * Namespace to which this new property must be added. If nothing is specified then it is added to the default namespace.
	 */
	public void setNsURI(String value) {
		this.nsURI = value;
	}

	/**
	 * The prefix that must be added to the namespace URI.
	 */
	public String getNsPrefix() {
		return this.nsPrefix;
	}

	/**
	 * The prefix that must be added to the namespace URI.
	 */
	public void setNsPrefix(String value) {
		this.nsPrefix = value;
	}

	/**
	 * A boolean that indicates whether the new property can accept more than one value.
	 */
	public Boolean getIsMultiValued() {
		return this.isMultiValued;
	}

	/**
	 * A boolean that indicates whether the new property can accept more than one value.
	 */
	public void setIsMultiValued(Boolean value) {
		this.isMultiValued = value;
	}

	/**
	 * Identifiers of the repositories for which the new property should be added. If not specified, the new property will be added for all the repositories. Use repository ID 'LA' for property extension repository. Use ';' as delimiter while specifying multiple repository IDs.
	 */
	public String getRepositoryIds() {
		return this.repositoryIds;
	}

	/**
	 * Identifiers of the repositories for which the new property should be added. If not specified, the new property will be added for all the repositories. Use repository ID 'LA' for property extension repository. Use ';' as delimiter while specifying multiple repository IDs.
	 */
	public void setRepositoryIds(String value) {
		this.repositoryIds = value;
	}

	/**
	 * Required entity type for which a property is required. Use ';' as delimiter while specifying multiple entity types.
	 */
	public String getRequiredEntityTypeNames() {
		return this.requiredEntityTypeNames;
	}

	/**
	 * Required entity type for which a property is required. Use ';' as delimiter while specifying multiple entity types.
	 */
	public void setRequiredEntityTypeNames(String value) {
		this.requiredEntityTypeNames = value;
	}

	/**
	 * Indicates the ID of the application that extends the property.
	 */
	public String getApplicationId() {
		return this.applicationId;
	}

	/**
	 * Indicates the ID of the application that extends the property.
	 */
	public void setApplicationId(String value) {
		this.applicationId = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("name", this.name);
		ret.put("entityTypeNames", this.entityTypeNames);
		ret.put("dataType", this.dataType);
		if (this.nsURI != null) {
			ret.put("nsURI", this.nsURI);
		}
		if (this.nsPrefix != null) {
			ret.put("nsPrefix", this.nsPrefix);
		}
		if (this.isMultiValued != null) {
			ret.put("isMultiValued", this.isMultiValued);
		}
		if (this.repositoryIds != null) {
			ret.put("repositoryIds", this.repositoryIds);
		}
		if (this.requiredEntityTypeNames != null) {
			ret.put("requiredEntityTypeNames", this.requiredEntityTypeNames);
		}
		if (this.applicationId != null) {
			ret.put("applicationId", this.applicationId);
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
