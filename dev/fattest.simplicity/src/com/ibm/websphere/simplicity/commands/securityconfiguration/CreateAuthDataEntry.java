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

package com.ibm.websphere.simplicity.commands.securityconfiguration;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Create an authentication data entry in the administrative security configuration or a in a security domain.
 *   'alias': The alias of the auth data.
 *   'description': The description of the auth data.
 *   'securityDomainName': Name used to uniquely identify the security domain.
 *   'password': The password of the auth data.
 *   'user': The username of the auth data.
 * The required parameters are found in the constructor.
 */
public class CreateAuthDataEntry extends Command {

	private String alias;
	private String description;
	private String securityDomainName;
	private String password;
	private String user;

	public CreateAuthDataEntry(String alias, String password, String user) {
		super("createAuthDataEntry");
		this.alias = alias;
		this.password = password;
		this.user = user;
	}

	/**
	 * The alias of the auth data.
	 */
	public String getAlias() {
		return this.alias;
	}

	/**
	 * The alias of the auth data.
	 */
	public void setAlias(String value) {
		this.alias = value;
	}

	/**
	 * The description of the auth data.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * The description of the auth data.
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Name used to uniquely identify the security domain.
	 */
	public String getSecurityDomainName() {
		return this.securityDomainName;
	}

	/**
	 * Name used to uniquely identify the security domain.
	 */
	public void setSecurityDomainName(String value) {
		this.securityDomainName = value;
	}

	/**
	 * The password of the auth data.
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * The password of the auth data.
	 */
	public void setPassword(String value) {
		this.password = value;
	}

	/**
	 * The username of the auth data.
	 */
	public String getUser() {
		return this.user;
	}

	/**
	 * The username of the auth data.
	 */
	public void setUser(String value) {
		this.user = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("alias", this.alias);
		if (this.description != null) {
			ret.put("description", this.description);
		}
		if (this.securityDomainName != null) {
			ret.put("securityDomainName", this.securityDomainName);
		}
		ret.put("password", this.password);
		ret.put("user", this.user);
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
