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

package com.ibm.websphere.simplicity.commands.sslconfig;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * List of ciphers.
 *   'sslConfigAliasName': Specifies alias that uniquely identifies a SSL configuration.
 *   'scopeName': Specifies the scope name of the SSL configuration.
 *   'securityLevel': Specifies the security level of the SSL configuration, HIGH, MEDIUM, LOW, or CUSTOM.
 * The required parameters are found in the constructor.
 */
public class ListSSLCiphers extends Command {

	private String sslConfigAliasName;
	private String scopeName;
	private String securityLevel;

	public ListSSLCiphers(String securityLevel) {
		super("listSSLCiphers");
		this.securityLevel = securityLevel;
	}

	/**
	 * Specifies alias that uniquely identifies a SSL configuration.
	 */
	public String getSslConfigAliasName() {
		return this.sslConfigAliasName;
	}

	/**
	 * Specifies alias that uniquely identifies a SSL configuration.
	 */
	public void setSslConfigAliasName(String value) {
		this.sslConfigAliasName = value;
	}

	/**
	 * Specifies the scope name of the SSL configuration.
	 */
	public String getScopeName() {
		return this.scopeName;
	}

	/**
	 * Specifies the scope name of the SSL configuration.
	 */
	public void setScopeName(String value) {
		this.scopeName = value;
	}

	/**
	 * Specifies the security level of the SSL configuration, HIGH, MEDIUM, LOW, or CUSTOM.
	 */
	public String getSecurityLevel() {
		return this.securityLevel;
	}

	/**
	 * Specifies the security level of the SSL configuration, HIGH, MEDIUM, LOW, or CUSTOM.
	 */
	public void setSecurityLevel(String value) {
		this.securityLevel = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.sslConfigAliasName != null) {
			ret.put("sslConfigAliasName", this.sslConfigAliasName);
		}
		if (this.scopeName != null) {
			ret.put("scopeName", this.scopeName);
		}
		ret.put("securityLevel", this.securityLevel);
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
