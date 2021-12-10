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

package com.ibm.websphere.simplicity.commands.port;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Modifies the host or port of the named endpoint that is used by the specified server.
 *   'nodeName': The name of the server node. This parameter is required only if the server name is not unique in the cell.
 *   'endPointName': The name of the end point to modify.
 *   'host': The new value for the host name of the end point.
 *   'port': The new value for the port number of the end point.
 *   'modifyShared': If specified, modification of the port is permitted, even if the port is shared between multiple transport chains.  If not specified, modification of the port is not permitted if the port is used in more than one transport channel chain.
 * The required parameters are found in the constructor.
 */
public class ModifyServerPort extends Command {

	private java.lang.String __target;
	private java.lang.String nodeName;
	private java.lang.String endPointName;
	private java.lang.String host;
	private java.lang.Integer port;
	private java.lang.Boolean modifyShared;

	public ModifyServerPort(java.lang.String commandTarget, java.lang.String endPointName) {
		super("modifyServerPort");
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
	 * The name of the end point to modify.
	 */
	public java.lang.String getEndPointName() {
		return this.endPointName;
	}

	/**
	 * The name of the end point to modify.
	 */
	public void setEndPointName(java.lang.String value) {
		this.endPointName = value;
	}

	/**
	 * The new value for the host name of the end point.
	 */
	public java.lang.String getHost() {
		return this.host;
	}

	/**
	 * The new value for the host name of the end point.
	 */
	public void setHost(java.lang.String value) {
		this.host = value;
	}

	/**
	 * The new value for the port number of the end point.
	 */
	public java.lang.Integer getPort() {
		return this.port;
	}

	/**
	 * The new value for the port number of the end point.
	 */
	public void setPort(java.lang.Integer value) {
		this.port = value;
	}

	/**
	 * If specified, modification of the port is permitted, even if the port is shared between multiple transport chains.  If not specified, modification of the port is not permitted if the port is used in more than one transport channel chain.
	 */
	public java.lang.Boolean getModifyShared() {
		return this.modifyShared;
	}

	/**
	 * If specified, modification of the port is permitted, even if the port is shared between multiple transport chains.  If not specified, modification of the port is not permitted if the port is used in more than one transport channel chain.
	 */
	public void setModifyShared(java.lang.Boolean value) {
		this.modifyShared = value;
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
		if (this.host != null) {
			ret.put("host", this.host);
		}
		if (this.port != null) {
			ret.put("port", this.port);
		}
		if (this.modifyShared != null) {
			ret.put("modifyShared", this.modifyShared);
		}
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
