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

package com.ibm.websphere.simplicity.commands.nodeconfig;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Change the host name of a node
 *   'nodeName': The name of the node whose host name will be changed
 *   'hostName': The new host name
 *   'systemName': The name of the system
 *   'regenDefaultCert': Regenerate the default certificates
 * The required parameters are found in the constructor.
 */
public class ChangeHostName extends Command {

	private String nodeName;
	private String hostName;
	private String systemName;
	private String regenDefaultCert;

	public ChangeHostName(String nodeName, String hostName) {
		super("changeHostName");
		this.nodeName = nodeName;
		this.hostName = hostName;
	}

	/**
	 * The name of the node whose host name will be changed
	 */
	public String getNodeName() {
		return this.nodeName;
	}

	/**
	 * The name of the node whose host name will be changed
	 */
	public void setNodeName(String value) {
		this.nodeName = value;
	}

	/**
	 * The new host name
	 */
	public String getHostName() {
		return this.hostName;
	}

	/**
	 * The new host name
	 */
	public void setHostName(String value) {
		this.hostName = value;
	}

	/**
	 * The name of the system
	 */
	public String getSystemName() {
		return this.systemName;
	}

	/**
	 * The name of the system
	 */
	public void setSystemName(String value) {
		this.systemName = value;
	}

	/**
	 * Regenerate the default certificates
	 */
	public String getRegenDefaultCert() {
		return this.regenDefaultCert;
	}

	/**
	 * Regenerate the default certificates
	 */
	public void setRegenDefaultCert(String value) {
		this.regenDefaultCert = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("nodeName", this.nodeName);
		ret.put("hostName", this.hostName);
		if (this.systemName != null) {
			ret.put("systemName", this.systemName);
		}
		if (this.regenDefaultCert != null) {
			ret.put("regenDefaultCert", this.regenDefaultCert);
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
