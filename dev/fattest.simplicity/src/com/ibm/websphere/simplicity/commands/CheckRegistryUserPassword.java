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

package com.ibm.websphere.simplicity.commands;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Check if the provided user and password authenticate in the registry.
 *   'resourceName': Specifies the name of the resource to check the user password in.
 *   'securityDomainName': Specifies the name of the security domain to check the user password in.
 *   'realmName': Specifies the name of the security realm to check the user password in.
 *   'username': userNameCheckDesc
 *   'password': Specifies the password to be check in the realm.
 * The required parameters are found in the constructor.
 */
public class CheckRegistryUserPassword extends Command {

	private String resourceName;
	private String securityDomainName;
	private String realmName;
	private String username;
	private String password;

	public CheckRegistryUserPassword(String username, String password) {
		super("checkRegistryUserPassword");
		this.username = username;
		this.password = password;
	}

	/**
	 * Specifies the name of the resource to check the user password in.
	 */
	public String getResourceName() {
		return this.resourceName;
	}

	/**
	 * Specifies the name of the resource to check the user password in.
	 */
	public void setResourceName(String value) {
		this.resourceName = value;
	}

	/**
	 * Specifies the name of the security domain to check the user password in.
	 */
	public String getSecurityDomainName() {
		return this.securityDomainName;
	}

	/**
	 * Specifies the name of the security domain to check the user password in.
	 */
	public void setSecurityDomainName(String value) {
		this.securityDomainName = value;
	}

	/**
	 * Specifies the name of the security realm to check the user password in.
	 */
	public String getRealmName() {
		return this.realmName;
	}

	/**
	 * Specifies the name of the security realm to check the user password in.
	 */
	public void setRealmName(String value) {
		this.realmName = value;
	}

	/**
	 * userNameCheckDesc
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * userNameCheckDesc
	 */
	public void setUsername(String value) {
		this.username = value;
	}

	/**
	 * Specifies the password to be check in the realm.
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Specifies the password to be check in the realm.
	 */
	public void setPassword(String value) {
		this.password = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.resourceName != null) {
			ret.put("resourceName", this.resourceName);
		}
		if (this.securityDomainName != null) {
			ret.put("securityDomainName", this.securityDomainName);
		}
		if (this.realmName != null) {
			ret.put("realmName", this.realmName);
		}
		ret.put("username", this.username);
		ret.put("password", this.password);
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
