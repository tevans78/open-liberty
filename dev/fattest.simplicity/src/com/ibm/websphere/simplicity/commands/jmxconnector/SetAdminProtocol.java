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

package com.ibm.websphere.simplicity.commands.jmxconnector;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Allows the user to set Administrative Protocol for a server or cell
 *   'conntype': The JMX Connector type you want to set for the server
 *   'mode': The JMX Connector Mode you want this server to use (either remote or local)
 * The required parameters are found in the constructor.
 */
public class SetAdminProtocol extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String conntype;
	private String mode;

	public SetAdminProtocol(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String conntype, String mode) {
		super("setAdminProtocol");
		this.__target = commandTarget;
		this.conntype = conntype;
		this.mode = mode;
	}

	/**
	 * The JMX Connector type you want to set for the server
	 */
	public String getConntype() {
		return this.conntype;
	}

	/**
	 * The JMX Connector type you want to set for the server
	 */
	public void setConntype(String value) {
		this.conntype = value;
	}

	/**
	 * The JMX Connector Mode you want this server to use (either remote or local)
	 */
	public String getMode() {
		return this.mode;
	}

	/**
	 * The JMX Connector Mode you want this server to use (either remote or local)
	 */
	public void setMode(String value) {
		this.mode = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("conntype", this.conntype);
		ret.put("mode", this.mode);
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
