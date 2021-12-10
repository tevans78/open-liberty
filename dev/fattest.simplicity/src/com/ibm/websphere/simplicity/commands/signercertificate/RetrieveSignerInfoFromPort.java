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

package com.ibm.websphere.simplicity.commands.signercertificate;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Retrieve signer information from a port.
 *   'sslConfigName': Specifies the SSL configuration used to connect to the host.
 *   'host': Specifies the name of the host where the signer certificate will be retrieved.
 *   'port': Specifies the port on the host where the signer certificate will be retrieved.
 *   'sslConfigScopeName': Specifies the scope name of the SSL configuration.
 * The required parameters are found in the constructor.
 */
public class RetrieveSignerInfoFromPort extends Command {

	private String sslConfigName;
	private String host;
	private Integer port;
	private String sslConfigScopeName;

	public RetrieveSignerInfoFromPort(String host, Integer port) {
		super("retrieveSignerInfoFromPort");
		this.host = host;
		this.port = port;
	}

	/**
	 * Specifies the SSL configuration used to connect to the host.
	 */
	public String getSslConfigName() {
		return this.sslConfigName;
	}

	/**
	 * Specifies the SSL configuration used to connect to the host.
	 */
	public void setSslConfigName(String value) {
		this.sslConfigName = value;
	}

	/**
	 * Specifies the name of the host where the signer certificate will be retrieved.
	 */
	public String getHost() {
		return this.host;
	}

	/**
	 * Specifies the name of the host where the signer certificate will be retrieved.
	 */
	public void setHost(String value) {
		this.host = value;
	}

	/**
	 * Specifies the port on the host where the signer certificate will be retrieved.
	 */
	public Integer getPort() {
		return this.port;
	}

	/**
	 * Specifies the port on the host where the signer certificate will be retrieved.
	 */
	public void setPort(Integer value) {
		this.port = value;
	}

	/**
	 * Specifies the scope name of the SSL configuration.
	 */
	public String getSslConfigScopeName() {
		return this.sslConfigScopeName;
	}

	/**
	 * Specifies the scope name of the SSL configuration.
	 */
	public void setSslConfigScopeName(String value) {
		this.sslConfigScopeName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.sslConfigName != null) {
			ret.put("sslConfigName", this.sslConfigName);
		}
		ret.put("host", this.host);
		ret.put("port", this.port);
		if (this.sslConfigScopeName != null) {
			ret.put("sslConfigScopeName", this.sslConfigScopeName);
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
