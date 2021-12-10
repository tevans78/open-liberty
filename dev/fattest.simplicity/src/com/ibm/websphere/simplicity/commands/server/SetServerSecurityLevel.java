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

package com.ibm.websphere.simplicity.commands.server;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Configure the security level for a secure proxy or management server.
 *   'proxySecurityLevel': Specifies the level of security to apply to the proxy server.
 * The required parameters are found in the constructor.
 */
public class SetServerSecurityLevel extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private java.lang.String proxySecurityLevel;

	public SetServerSecurityLevel(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, java.lang.String proxySecurityLevel) {
		super("setServerSecurityLevel");
		this.__target = commandTarget;
		this.proxySecurityLevel = proxySecurityLevel;
	}

	/**
	 * Specifies the level of security to apply to the proxy server.
	 */
	public java.lang.String getProxySecurityLevel() {
		return this.proxySecurityLevel;
	}

	/**
	 * Specifies the level of security to apply to the proxy server.
	 */
	public void setProxySecurityLevel(java.lang.String value) {
		this.proxySecurityLevel = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("proxySecurityLevel", this.proxySecurityLevel);
		return ret;
	}

	public Object __getTarget() {
		return this.__target;
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
