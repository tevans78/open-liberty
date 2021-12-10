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
 * configureDVIPA.desc
 *   'serverName': dvipa.serverName.desc
 *   'nodeName': dvipa.nodeDesc.desc
 *   'hostName': dvipa.hostname.desc
 * The required parameters are found in the constructor.
 */
public class ConfigureDVIPA extends Command {

	private String serverName;
	private String nodeName;
	private String hostName;

	public ConfigureDVIPA(String serverName, String nodeName, String hostName) {
		super("configureDVIPA");
		this.serverName = serverName;
		this.nodeName = nodeName;
		this.hostName = hostName;
	}

	/**
	 * dvipa.serverName.desc
	 */
	public String getServerName() {
		return this.serverName;
	}

	/**
	 * dvipa.serverName.desc
	 */
	public void setServerName(String value) {
		this.serverName = value;
	}

	/**
	 * dvipa.nodeDesc.desc
	 */
	public String getNodeName() {
		return this.nodeName;
	}

	/**
	 * dvipa.nodeDesc.desc
	 */
	public void setNodeName(String value) {
		this.nodeName = value;
	}

	/**
	 * dvipa.hostname.desc
	 */
	public String getHostName() {
		return this.hostName;
	}

	/**
	 * dvipa.hostname.desc
	 */
	public void setHostName(String value) {
		this.hostName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("serverName", this.serverName);
		ret.put("nodeName", this.nodeName);
		ret.put("hostName", this.hostName);
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
