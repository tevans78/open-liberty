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
 * Deletes the configuration for an LDAP attribute used as an external ID.
 *   'id': The unique identifier of the repository.
 *   'name': The name of the LDAP attribute.
 *   'entityTypes': The name of the LDAP entity type or a semicolon separated list of LDAP entity types.
 * The required parameters are found in the constructor.
 */
public class DeleteIdMgrLDAPExternalIdAttr extends Command {

	private String id;
	private String name;
	private String entityTypes;

	public DeleteIdMgrLDAPExternalIdAttr(String id, String name) {
		super("deleteIdMgrLDAPExternalIdAttr");
		this.id = id;
		this.name = name;
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
	 * The name of the LDAP attribute.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The name of the LDAP attribute.
	 */
	public void setName(String value) {
		this.name = value;
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
		ret.put("name", this.name);
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
