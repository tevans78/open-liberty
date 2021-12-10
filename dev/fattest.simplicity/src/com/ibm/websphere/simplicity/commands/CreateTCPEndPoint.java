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
 * Create a new NamedEndPoint that can be associated with a TCPInboundChannel
 *   'host': Host for the new NamedEndPoint
 *   'name': Name for the new NamedEndPoint
 *   'port': Port for the new NamedEndPoint
 * The required parameters are found in the constructor.
 */
public class CreateTCPEndPoint extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private java.lang.String host;
	private java.lang.String name;
	private java.lang.Integer port;

	public CreateTCPEndPoint(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, java.lang.String host, java.lang.String name, java.lang.Integer port) {
		super("createTCPEndPoint");
		this.__target = commandTarget;
		this.host = host;
		this.name = name;
		this.port = port;
	}

	/**
	 * Host for the new NamedEndPoint
	 */
	public java.lang.String getHost() {
		return this.host;
	}

	/**
	 * Host for the new NamedEndPoint
	 */
	public void setHost(java.lang.String value) {
		this.host = value;
	}

	/**
	 * Name for the new NamedEndPoint
	 */
	public java.lang.String getName() {
		return this.name;
	}

	/**
	 * Name for the new NamedEndPoint
	 */
	public void setName(java.lang.String value) {
		this.name = value;
	}

	/**
	 * Port for the new NamedEndPoint
	 */
	public java.lang.Integer getPort() {
		return this.port;
	}

	/**
	 * Port for the new NamedEndPoint
	 */
	public void setPort(java.lang.Integer value) {
		this.port = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("host", this.host);
		ret.put("name", this.name);
		ret.put("port", this.port);
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
