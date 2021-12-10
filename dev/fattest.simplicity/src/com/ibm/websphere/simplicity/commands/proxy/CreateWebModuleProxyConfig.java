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

package com.ibm.websphere.simplicity.commands.proxy;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Create a proxy configuration for a Web module
 *   'deployedObjectProxyConfigName': Name of the Web module
 *   'enableProxy': Boolean value that indicates whether the proxy server is enabled for this Web module.
 *   'transportProtocol': Protocol (HTTP, HTTPS, or ClientProtocol) the proxy will use when communicating with the web module.
 * The required parameters are found in the constructor.
 */
public class CreateWebModuleProxyConfig extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String deployedObjectProxyConfigName;
	private String enableProxy;
	private String transportProtocol;

	public CreateWebModuleProxyConfig(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String deployedObjectProxyConfigName) {
		super("createWebModuleProxyConfig");
		this.__target = commandTarget;
		this.deployedObjectProxyConfigName = deployedObjectProxyConfigName;
	}

	/**
	 * Name of the Web module
	 */
	public String getDeployedObjectProxyConfigName() {
		return this.deployedObjectProxyConfigName;
	}

	/**
	 * Name of the Web module
	 */
	public void setDeployedObjectProxyConfigName(String value) {
		this.deployedObjectProxyConfigName = value;
	}

	/**
	 * Boolean value that indicates whether the proxy server is enabled for this Web module.
	 */
	public String getEnableProxy() {
		return this.enableProxy;
	}

	/**
	 * Boolean value that indicates whether the proxy server is enabled for this Web module.
	 */
	public void setEnableProxy(String value) {
		this.enableProxy = value;
	}

	/**
	 * Protocol (HTTP, HTTPS, or ClientProtocol) the proxy will use when communicating with the web module.
	 */
	public String getTransportProtocol() {
		return this.transportProtocol;
	}

	/**
	 * Protocol (HTTP, HTTPS, or ClientProtocol) the proxy will use when communicating with the web module.
	 */
	public void setTransportProtocol(String value) {
		this.transportProtocol = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("deployedObjectProxyConfigName", this.deployedObjectProxyConfigName);
		if (this.enableProxy != null) {
			ret.put("enableProxy", this.enableProxy);
		}
		if (this.transportProtocol != null) {
			ret.put("transportProtocol", this.transportProtocol);
		}
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
