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
 * Unconfigures a JAAS login in an application security domain.  This removes the JAAS login object and all it's entries.
 *   'securityDomainName': Name used to uniquely identify the security domain.
 *   'loginType': Specifies the login module type.  Valid values are: system, application
 * The required parameters are found in the constructor.
 */
public class UnconfigureJAASLogin extends Command {

	private String securityDomainName;
	private String loginType;

	public UnconfigureJAASLogin(String securityDomainName, String loginType) {
		super("unconfigureJAASLogin");
		this.securityDomainName = securityDomainName;
		this.loginType = loginType;
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

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("securityDomainName", this.securityDomainName);
		ret.put("loginType", this.loginType);
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
