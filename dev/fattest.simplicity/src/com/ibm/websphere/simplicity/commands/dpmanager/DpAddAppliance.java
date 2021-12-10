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

package com.ibm.websphere.simplicity.commands.dpmanager;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Use the dpAddAppliance command to add an appliance to the DataPower appliance manager.
 *   'hostname': Specifies the host name or Internet Protocol (IP) address of the appliance.
 *   'hlmPort': Specifies the port number that the DataPower appliance manager uses to communicate to the appliance.  The default value is 5550.
 *   'name': Specifies the unique name of the appliance in the DataPower appliance manager.
 *   'userId': Specifies the user ID that the DataPower appliance manager uses to access the appliance.
 *   'password': Specifies the Base64 encoded password that the DataPower appliance manager uses to access the appliance.
 * The required parameters are found in the constructor.
 */
public class DpAddAppliance extends Command {

	private String hostname;
	private Integer hlmPort = 5550;
	private String name;
	private String userId;
	private String password;

	public DpAddAppliance(String hostname, Integer hlmPort, String name, String userId, String password) {
		super("dpAddAppliance");
		this.hostname = hostname;
		this.hlmPort = hlmPort;
		this.name = name;
		this.userId = userId;
		this.password = password;
	}

	/**
	 * Specifies the host name or Internet Protocol (IP) address of the appliance.
	 */
	public String getHostname() {
		return this.hostname;
	}

	/**
	 * Specifies the host name or Internet Protocol (IP) address of the appliance.
	 */
	public void setHostname(String value) {
		this.hostname = value;
	}

	/**
	 * Specifies the port number that the DataPower appliance manager uses to communicate to the appliance.  The default value is 5550.
	 */
	public Integer getHlmPort() {
		return this.hlmPort;
	}

	/**
	 * Specifies the port number that the DataPower appliance manager uses to communicate to the appliance.  The default value is 5550.
	 */
	public void setHlmPort(Integer value) {
		this.hlmPort = value;
	}

	/**
	 * Specifies the unique name of the appliance in the DataPower appliance manager.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Specifies the unique name of the appliance in the DataPower appliance manager.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Specifies the user ID that the DataPower appliance manager uses to access the appliance.
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * Specifies the user ID that the DataPower appliance manager uses to access the appliance.
	 */
	public void setUserId(String value) {
		this.userId = value;
	}

	/**
	 * Specifies the Base64 encoded password that the DataPower appliance manager uses to access the appliance.
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Specifies the Base64 encoded password that the DataPower appliance manager uses to access the appliance.
	 */
	public void setPassword(String value) {
		this.password = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("hostname", this.hostname);
		ret.put("hlmPort", this.hlmPort);
		ret.put("name", this.name);
		ret.put("userId", this.userId);
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
