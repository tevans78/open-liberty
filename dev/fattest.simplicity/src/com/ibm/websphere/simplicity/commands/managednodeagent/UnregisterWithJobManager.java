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

package com.ibm.websphere.simplicity.commands.managednodeagent;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Unregister a managed node from a JobManager
 *   'host': JobManager's hostname
 *   'port': JobManager administrative port number
 *   'user': Login username
 *   'password': JobManager login password
 *   'managedNodeName': Name of the managed node to be unregistered
 * The required parameters are found in the constructor.
 */
public class UnregisterWithJobManager extends Command {

	private String host = "localhost";
	private String port = "9943";
	private String user;
	private String password;
	private String managedNodeName;

	public UnregisterWithJobManager(String managedNodeName) {
		super("unregisterWithJobManager");
		this.managedNodeName = managedNodeName;
	}

	/**
	 * JobManager's hostname
	 */
	public String getHost() {
		return this.host;
	}

	/**
	 * JobManager's hostname
	 */
	public void setHost(String value) {
		this.host = value;
	}

	/**
	 * JobManager administrative port number
	 */
	public String getPort() {
		return this.port;
	}

	/**
	 * JobManager administrative port number
	 */
	public void setPort(String value) {
		this.port = value;
	}

	/**
	 * Login username
	 */
	public String getUser() {
		return this.user;
	}

	/**
	 * Login username
	 */
	public void setUser(String value) {
		this.user = value;
	}

	/**
	 * JobManager login password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * JobManager login password
	 */
	public void setPassword(String value) {
		this.password = value;
	}

	/**
	 * Name of the managed node to be unregistered
	 */
	public String getManagedNodeName() {
		return this.managedNodeName;
	}

	/**
	 * Name of the managed node to be unregistered
	 */
	public void setManagedNodeName(String value) {
		this.managedNodeName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.host != null) {
			ret.put("host", this.host);
		}
		if (this.port != null) {
			ret.put("port", this.port);
		}
		if (this.user != null) {
			ret.put("user", this.user);
		}
		if (this.password != null) {
			ret.put("password", this.password);
		}
		ret.put("managedNodeName", this.managedNodeName);
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
