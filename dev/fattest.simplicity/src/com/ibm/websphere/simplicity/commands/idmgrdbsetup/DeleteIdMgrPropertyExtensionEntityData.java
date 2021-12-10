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

package com.ibm.websphere.simplicity.commands.idmgrdbsetup;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Deletes the property data from the property extension repository. It also deletes any entity IDs with which there is no property data associated, from the property extension repository in virtual member manager.
 *   'name': Name of the property. A valid namespace prefix can be used for a property name, to refer to the property definition in a specific existing namespace.
 *   'entityTypeNames': Names of one or more existing entity types. Use ';' as delimiter while specifying multiple entity types. A valid namespace prefix can be used to refer to entity type names in a specific namespace.
 *   'dbAdminId': The database administrator ID for direct access mode. Example: db2admin
 *   'dbAdminPassword': The database administrator password for direct access mode.
 * The required parameters are found in the constructor.
 */
public class DeleteIdMgrPropertyExtensionEntityData extends Command {

	private String name;
	private String entityTypeNames;
	private String dbAdminId;
	private String dbAdminPassword;

	public DeleteIdMgrPropertyExtensionEntityData(String name) {
		super("deleteIdMgrPropertyExtensionEntityData");
		this.name = name;
	}

	/**
	 * Name of the property. A valid namespace prefix can be used for a property name, to refer to the property definition in a specific existing namespace.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Name of the property. A valid namespace prefix can be used for a property name, to refer to the property definition in a specific existing namespace.
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
	 * The database administrator ID for direct access mode. Example: db2admin
	 */
	public String getDbAdminId() {
		return this.dbAdminId;
	}

	/**
	 * The database administrator ID for direct access mode. Example: db2admin
	 */
	public void setDbAdminId(String value) {
		this.dbAdminId = value;
	}

	/**
	 * The database administrator password for direct access mode.
	 */
	public String getDbAdminPassword() {
		return this.dbAdminPassword;
	}

	/**
	 * The database administrator password for direct access mode.
	 */
	public void setDbAdminPassword(String value) {
		this.dbAdminPassword = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("name", this.name);
		if (this.entityTypeNames != null) {
			ret.put("entityTypeNames", this.entityTypeNames);
		}
		if (this.dbAdminId != null) {
			ret.put("dbAdminId", this.dbAdminId);
		}
		if (this.dbAdminPassword != null) {
			ret.put("dbAdminPassword", this.dbAdminPassword);
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
