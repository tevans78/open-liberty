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
 * Adds RDN attribute configuration to an LDAP entity type configuration.
 *   'entityTypeName': The name of the LDAP entity type.
 *   'name': The attribute name that is used to build the RDN for this entity type.
 *   'id': The unique identifier of the repository.
 *   'objectClass': The group object class that contains this member attribute. For example, "groupOfNames" or "groupOfUniqueNames". If this property is not defined, this member attribute applies to all group object classes.
 * The required parameters are found in the constructor.
 */
public class AddIdMgrLDAPEntityTypeRDNAttr extends Command {

	private String entityTypeName;
	private String name;
	private String id;
	private String objectClass;

	public AddIdMgrLDAPEntityTypeRDNAttr(String entityTypeName, String name, String id) {
		super("addIdMgrLDAPEntityTypeRDNAttr");
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

	/**
	 * The group object class that contains this member attribute. For example, "groupOfNames" or "groupOfUniqueNames". If this property is not defined, this member attribute applies to all group object classes.
	 */
	public String getObjectClass() {
		return this.objectClass;
	}

	/**
	 * The group object class that contains this member attribute. For example, "groupOfNames" or "groupOfUniqueNames". If this property is not defined, this member attribute applies to all group object classes.
	 */
	public void setObjectClass(String value) {
		this.objectClass = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("entityTypeName", this.entityTypeName);
		ret.put("name", this.name);
		ret.put("id", this.id);
		if (this.objectClass != null) {
			ret.put("objectClass", this.objectClass);
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
