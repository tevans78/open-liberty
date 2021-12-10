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
 * Configures a JAAS login module entry in the administrative security configuration or in an application security domain.
 *   'authStrategies': A comma separated list of authentication strategies, must have one for each login module.
 *   'loginModules': A comma separated list of login module class file names
 *   'securityDomainName': Name used to uniquely identify the security domain.
 *   'loginType': Specifies the login module type.  Valid values are: system, application
 *   'loginEntryAlias': The alias name that identifies the login module entry.
 * The required parameters are found in the constructor.
 */
public class ConfigureJAASLoginEntry extends Command {

	private String authStrategies;
	private String loginModules;
	private String securityDomainName;
	private String loginType;
	private String loginEntryAlias;

	public ConfigureJAASLoginEntry(String loginType, String loginEntryAlias) {
		super("configureJAASLoginEntry");
		this.loginType = loginType;
		this.loginEntryAlias = loginEntryAlias;
	}

	/**
	 * A comma separated list of authentication strategies, must have one for each login module.
	 */
	public String getAuthStrategies() {
		return this.authStrategies;
	}

	/**
	 * A comma separated list of authentication strategies, must have one for each login module.
	 */
	public void setAuthStrategies(String value) {
		this.authStrategies = value;
	}

	/**
	 * A comma separated list of login module class file names
	 */
	public String getLoginModules() {
		return this.loginModules;
	}

	/**
	 * A comma separated list of login module class file names
	 */
	public void setLoginModules(String value) {
		this.loginModules = value;
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
	 * Specifies the login module type.  Valid values are: system, application
	 */
	public String getLoginType() {
		return this.loginType;
	}

	/**
	 * Specifies the login module type.  Valid values are: system, application
	 */
	public void setLoginType(String value) {
		this.loginType = value;
	}

	/**
	 * The alias name that identifies the login module entry.
	 */
	public String getLoginEntryAlias() {
		return this.loginEntryAlias;
	}

	/**
	 * The alias name that identifies the login module entry.
	 */
	public void setLoginEntryAlias(String value) {
		this.loginEntryAlias = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.authStrategies != null) {
			ret.put("authStrategies", this.authStrategies);
		}
		if (this.loginModules != null) {
			ret.put("loginModules", this.loginModules);
		}
		if (this.securityDomainName != null) {
			ret.put("securityDomainName", this.securityDomainName);
		}
		ret.put("loginType", this.loginType);
		ret.put("loginEntryAlias", this.loginEntryAlias);
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
