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
 * Deletes the configuration for a virtual member manager property not supported by a specific LDAP repository.
 *   'id': The unique identifier of the repository.
 *   'propertyName': The name of a virtual member manager property not supported by LDAP repository.
 *   'entityTypes': The name of the LDAP entity type or a semicolon separated list of LDAP entity types.
 * The required parameters are found in the constructor.
 */
public class DeleteIdMgrLDAPAttrNotSupported extends Command {

	private String id;
	private String propertyName;
	private String entityTypes;

	public DeleteIdMgrLDAPAttrNotSupported(String id, String propertyName) {
		super("deleteIdMgrLDAPAttrNotSupported");
		this.id = id;
		this.propertyName = propertyName;
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
	 * The name of a virtual member manager property not supported by LDAP repository.
	 */
	public String getPropertyName() {
		return this.propertyName;
	}

	/**
	 * The name of a virtual member manager property not supported by LDAP repository.
	 */
	public void setPropertyName(String value) {
		this.propertyName = value;
	}

	/**
	 * The name of the LDAP entity type or a semicolon separated list of LDAP entity types.
	 */
	public String getEntityTypes() {
		return this.entityTypes;
	}

	/**
	 * The name of the LDAP entity type or a semicolon separated list of LDAP entity types.
	 */
	public void setEntityTypes(String value) {
		this.entityTypes = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("id", this.id);
		ret.put("propertyName", this.propertyName);
		if (this.entityTypes != null) {
			ret.put("entityTypes", this.entityTypes);
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
