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

package com.ibm.websphere.simplicity.commands.unmanagednode;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Use this command to create an unmanaged node in a cell.
 *   'nodeName': Name of unmanaged node to be created in the cell.
 *   'hostName': hostname of unmanaged node.
 *   'nodeOperatingSystem': Unmanaged node's platform type must be one of:  os400, aix, hpux, linux, solaris, windows, os390
 * The required parameters are found in the constructor.
 */
public class CreateUnmanagedNode extends Command {

	private String __target;
	private String nodeName;
	private String hostName;
	private String nodeOperatingSystem;

	public CreateUnmanagedNode(String commandTarget, String nodeName, String hostName, String nodeOperatingSystem) {
		super("createUnmanagedNode");
		this.__target = commandTarget;
		this.nodeName = nodeName;
		this.hostName = hostName;
		this.nodeOperatingSystem = nodeOperatingSystem;
	}

	/**
	 * Name of unmanaged node to be created in the cell.
	 */
	public String getNodeName() {
		return this.nodeName;
	}

	/**
	 * Name of unmanaged node to be created in the cell.
	 */
	public void setNodeName(String value) {
		this.nodeName = value;
	}

	/**
	 * hostname of unmanaged node.
	 */
	public String getHostName() {
		return this.hostName;
	}

	/**
	 * hostname of unmanaged node.
	 */
	public void setHostName(String value) {
		this.hostName = value;
	}

	/**
	 * Unmanaged node's platform type must be one of:  os400, aix, hpux, linux, solaris, windows, os390
	 */
	public String getNodeOperatingSystem() {
		return this.nodeOperatingSystem;
	}

	/**
	 * Unmanaged node's platform type must be one of:  os400, aix, hpux, linux, solaris, windows, os390
	 */
	public void setNodeOperatingSystem(String value) {
		this.nodeOperatingSystem = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(String value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("nodeName", this.nodeName);
		ret.put("hostName", this.hostName);
		ret.put("nodeOperatingSystem", this.nodeOperatingSystem);
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
