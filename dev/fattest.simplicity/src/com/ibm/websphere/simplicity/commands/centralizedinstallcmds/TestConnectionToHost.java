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

package com.ibm.websphere.simplicity.commands.centralizedinstallcmds;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Tests if a connection could be established using ID and password with the remote host for the purpose of centralized install.
 *   'hostName': Specifies the domain-qualified host name of the remote host.
 *   'platformType': The platform type of the remote host.  Must be one of: "Windows", "AIX", "HP-UX", "Linux", "OS400" or "Solaris". This parameter is not case-sensitive.
 *   'adminName': The login ID of an administrator of the remote host.
 *   'adminPassword': The login password of an administrator of the remote host.
 * The required parameters are found in the constructor.
 */
public class TestConnectionToHost extends Command {

	private String hostName;
	private String platformType;
	private String adminName;
	private String adminPassword;

	public TestConnectionToHost(String hostName, String platformType, String adminName, String adminPassword) {
		super("testConnectionToHost");
		this.hostName = hostName;
		this.platformType = platformType;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}

	/**
	 * Specifies the domain-qualified host name of the remote host.
	 */
	public String getHostName() {
		return this.hostName;
	}

	/**
	 * Specifies the domain-qualified host name of the remote host.
	 */
	public void setHostName(String value) {
		this.hostName = value;
	}

	/**
	 * The platform type of the remote host.  Must be one of: "Windows", "AIX", "HP-UX", "Linux", "OS400" or "Solaris". This parameter is not case-sensitive.
	 */
	public String getPlatformType() {
		return this.platformType;
	}

	/**
	 * The platform type of the remote host.  Must be one of: "Windows", "AIX", "HP-UX", "Linux", "OS400" or "Solaris". This parameter is not case-sensitive.
	 */
	public void setPlatformType(String value) {
		this.platformType = value;
	}

	/**
	 * The login ID of an administrator of the remote host.
	 */
	public String getAdminName() {
		return this.adminName;
	}

	/**
	 * The login ID of an administrator of the remote host.
	 */
	public void setAdminName(String value) {
		this.adminName = value;
	}

	/**
	 * The login password of an administrator of the remote host.
	 */
	public String getAdminPassword() {
		return this.adminPassword;
	}

	/**
	 * The login password of an administrator of the remote host.
	 */
	public void setAdminPassword(String value) {
		this.adminPassword = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("hostName", this.hostName);
		ret.put("platformType", this.platformType);
		ret.put("adminName", this.adminName);
		ret.put("adminPassword", this.adminPassword);
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
