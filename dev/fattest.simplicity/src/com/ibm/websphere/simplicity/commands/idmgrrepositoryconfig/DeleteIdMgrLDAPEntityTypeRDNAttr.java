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
 * Deletes RDN attribute configuration from an LDAP entity type configuration.
 *   'entityTypeName': The name of the LDAP entity type.
 *   'name': The attribute name that is used to build the RDN for this entity type.
 *   'id': The unique identifier of the repository.
 * The required parameters are found in the constructor.
 */
public class DeleteIdMgrLDAPEntityTypeRDNAttr extends Command {

	private String entityTypeName;
	private String name;
	private String id;

	public DeleteIdMgrLDAPEntityTypeRDNAttr(String entityTypeName, String name, String id) {
		super("deleteIdMgrLDAPEntityTypeRDNAttr");
		this.entityTypeName = entityTypeName;
		this.name = name;
		this.id = id;
	}

	/**
	 * The name of the LDAP entity type.
	 */
	public String getEntityTypeName() {
		return this.entityTypeName;
	}

	/**
	 * The name of the LDAP entity type.
	 */
	public void setEntityTypeName(String value) {
		this.entityTypeName = value;
	}

	/**
	 * The attribute name that is used to build the RDN for this entity type.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The attribute name that is used to build the RDN for this entity type.
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

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("entityTypeName", this.entityTypeName);
		ret.put("name", this.name);
		ret.put("id", this.id);
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
