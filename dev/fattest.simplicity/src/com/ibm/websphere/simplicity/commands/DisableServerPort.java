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
 * Disable all the transport chains associated with an endpoint on a server. Returns a list of all the disabled transport chains on successful execution of the command.
 *   'nodeName': The name of the server node. This parameter is required only if the server name is not unique in the cell.
 *   'endPointName': The name of the end point.
 * The required parameters are found in the constructor.
 */
public class DisableServerPort extends Command {

	private java.lang.String __target;
	private java.lang.String nodeName;
	private java.lang.String endPointName;

	public DisableServerPort(java.lang.String commandTarget, java.lang.String endPointName) {
		super("disableServerPort");
		this.__target = commandTarget;
		this.endPointName = endPointName;
	}

	/**
	 * The name of the server node. This parameter is required only if the server name is not unique in the cell.
	 */
	public java.lang.String getNodeName() {
		return this.nodeName;
	}

	/**
	 * The name of the server node. This parameter is required only if the server name is not unique in the cell.
	 */
	public void setNodeName(java.lang.String value) {
		this.nodeName = value;
	}

	/**
	 * The name of the end point.
	 */
	public java.lang.String getEndPointName() {
		return this.endPointName;
	}

	/**
	 * The name of the end point.
	 */
	public void setEndPointName(java.lang.String value) {
		this.endPointName = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(java.lang.String value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.nodeName != null) {
			ret.put("nodeName", this.nodeName);
		}
		ret.put("endPointName", this.endPointName);
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
