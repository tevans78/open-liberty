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
 * Updates an existing LDAP entity type definition to an LDAP repository configuration. This command can be used to add more values to multivalued parameters.
 *   'name': The name of the LDAP entity type.
 *   'id': The unique identifier of the repository.
 *   'objectClasses': One or more object classes for the entity type. To add to the parameter, specify a list. To reset all the values of this parameter, specify an empty list.
 *   'objectClassesForCreate': Object class to use during creation of an entity type object. If it is the same as the objectClass, you do not need to specify this.
 *   'searchBases': Search bases to use while searching the entity type. To add to the parameter, specify a list. To reset all the values of this parameter, specify an empty list.
 *   'searchFilter': Search filter to use to search this entity type.
 * The required parameters are found in the constructor.
 */
public class UpdateIdMgrLDAPEntityType extends Command {

	private String name;
	private String id;
	private String objectClasses;
	private String objectClassesForCreate;
	private String searchBases;
	private String searchFilter;

	public UpdateIdMgrLDAPEntityType(String name, String id) {
		super("updateIdMgrLDAPEntityType");
		this.name = name;
		this.id = id;
	}

	/**
	 * The name of the LDAP entity type.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The name of the LDAP entity type.
	 */
	public void setName(String value) {
		this.name = value;
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
	 * One or more object classes for the entity type. To add to the parameter, specify a list. To reset all the values of this parameter, specify an empty list.
	 */
	public String getObjectClasses() {
		return this.objectClasses;
	}

	/**
	 * One or more object classes for the entity type. To add to the parameter, specify a list. To reset all the values of this parameter, specify an empty list.
	 */
	public void setObjectClasses(String value) {
		this.objectClasses = value;
	}

	/**
	 * Object class to use during creation of an entity type object. If it is the same as the objectClass, you do not need to specify this.
	 */
	public String getObjectClassesForCreate() {
		return this.objectClassesForCreate;
	}

	/**
	 * Object class to use during creation of an entity type object. If it is the same as the objectClass, you do not need to specify this.
	 */
	public void setObjectClassesForCreate(String value) {
		this.objectClassesForCreate = value;
	}

	/**
	 * Search bases to use while searching the entity type. To add to the parameter, specify a list. To reset all the values of this parameter, specify an empty list.
	 */
	public String getSearchBases() {
		return this.searchBases;
	}

	/**
	 * Search bases to use while searching the entity type. To add to the parameter, specify a list. To reset all the values of this parameter, specify an empty list.
	 */
	public void setSearchBases(String value) {
		this.searchBases = value;
	}

	/**
	 * Search filter to use to search this entity type.
	 */
	public String getSearchFilter() {
		return this.searchFilter;
	}

	/**
	 * Search filter to use to search this entity type.
	 */
	public void setSearchFilter(String value) {
		this.searchFilter = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("name", this.name);
		ret.put("id", this.id);
		if (this.objectClasses != null) {
			ret.put("objectClasses", this.objectClasses);
		}
		if (this.objectClassesForCreate != null) {
			ret.put("objectClassesForCreate", this.objectClassesForCreate);
		}
		if (this.searchBases != null) {
			ret.put("searchBases", this.searchBases);
		}
		if (this.searchFilter != null) {
			ret.put("searchFilter", this.searchFilter);
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
