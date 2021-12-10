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
 * Adds an LDAP attribute configuration to the LDAP repository configuration.
 *   'name': The name of the LDAP attribute.
 *   'entityTypes': The name of the LDAP entity type.
 *   'defaultAttr': The default attribute name of the LDAP attribute.
 *   'defaultValue': The default value of the LDAP attribute.
 *   'id': The unique identifier of the repository.
 *   'propertyName': The name of the corresponding virtual member manager property mapped to the LDAP attribute.
 *   'syntax': The syntax of the LDAP attribute.
 * The required parameters are found in the constructor.
 */
public class AddIdMgrLDAPAttr extends Command {

	private String name;
	private String entityTypes;
	private String defaultAttr;
	private String defaultValue;
	private String id;
	private String propertyName;
	private String syntax = "string";

	public AddIdMgrLDAPAttr(String name, String id) {
		super("addIdMgrLDAPAttr");
		this.name = name;
		this.id = id;
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
	 * The name of the LDAP entity type.
	 */
	public String getEntityTypes() {
		return this.entityTypes;
	}

	/**
	 * The name of the LDAP entity type.
	 */
	public void setEntityTypes(String value) {
		this.entityTypes = value;
	}

	/**
	 * The default attribute name of the LDAP attribute.
	 */
	public String getDefaultAttr() {
		return this.defaultAttr;
	}

	/**
	 * The default attribute name of the LDAP attribute.
	 */
	public void setDefaultAttr(String value) {
		this.defaultAttr = value;
	}

	/**
	 * The default value of the LDAP attribute.
	 */
	public String getDefaultValue() {
		return this.defaultValue;
	}

	/**
	 * The default value of the LDAP attribute.
	 */
	public void setDefaultValue(String value) {
		this.defaultValue = value;
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
	 * The name of the corresponding virtual member manager property mapped to the LDAP attribute.
	 */
	public String getPropertyName() {
		return this.propertyName;
	}

	/**
	 * The name of the corresponding virtual member manager property mapped to the LDAP attribute.
	 */
	public void setPropertyName(String value) {
		this.propertyName = value;
	}

	/**
	 * The syntax of the LDAP attribute.
	 */
	public String getSyntax() {
		return this.syntax;
	}

	/**
	 * The syntax of the LDAP attribute.
	 */
	public void setSyntax(String value) {
		this.syntax = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("name", this.name);
		if (this.entityTypes != null) {
			ret.put("entityTypes", this.entityTypes);
		}
		if (this.defaultAttr != null) {
			ret.put("defaultAttr", this.defaultAttr);
		}
		if (this.defaultValue != null) {
			ret.put("defaultValue", this.defaultValue);
		}
		ret.put("id", this.id);
		if (this.propertyName != null) {
			ret.put("propertyName", this.propertyName);
		}
		if (this.syntax != null) {
			ret.put("syntax", this.syntax);
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
