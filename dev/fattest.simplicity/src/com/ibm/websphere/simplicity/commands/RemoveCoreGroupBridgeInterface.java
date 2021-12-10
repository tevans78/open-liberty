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
 * Delete bridge interfaces associated with a specified core group, node and server.
 *   'coreGroupName': Name of the Core group whose core group access points will be deleted.
 *   'nodeName': Name of the node whose bridge interface will be deleted.
 *   'serverName': Name of the server whose core bridge interface will be deleted.
 * The required parameters are found in the constructor.
 */
public class RemoveCoreGroupBridgeInterface extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String coreGroupName;
	private String nodeName;
	private String serverName;

	public RemoveCoreGroupBridgeInterface(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String coreGroupName, String nodeName, String serverName) {
		super("removeCoreGroupBridgeInterface");
		this.__target = commandTarget;
		this.coreGroupName = coreGroupName;
		this.nodeName = nodeName;
		this.serverName = serverName;
	}

	/**
	 * Name of the Core group whose core group access points will be deleted.
	 */
	public String getCoreGroupName() {
		return this.coreGroupName;
	}

	/**
	 * Name of the Core group whose core group access points will be deleted.
	 */
	public void setCoreGroupName(String value) {
		this.coreGroupName = value;
	}

	/**
	 * Name of the node whose bridge interface will be deleted.
	 */
	public String getNodeName() {
		return this.nodeName;
	}

	/**
	 * Name of the node whose bridge interface will be deleted.
	 */
	public void setNodeName(String value) {
		this.nodeName = value;
	}

	/**
	 * Name of the server whose core bridge interface will be deleted.
	 */
	public String getServerName() {
		return this.serverName;
	}

	/**
	 * Name of the server whose core bridge interface will be deleted.
	 */
	public void setServerName(String value) {
		this.serverName = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("coreGroupName", this.coreGroupName);
		ret.put("nodeName", this.nodeName);
		ret.put("serverName", this.serverName);
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
