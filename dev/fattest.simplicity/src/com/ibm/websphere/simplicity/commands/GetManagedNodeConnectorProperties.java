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
 * Get connector properties for the managed node
 *   'connType': Connector type, such as SOAP, RMI, JSR160RMI or IPC
 *   'managedNodeName': ManagedNode name
 * The required parameters are found in the constructor.
 */
public class GetManagedNodeConnectorProperties extends Command {

	private String connType;
	private String managedNodeName;

	public GetManagedNodeConnectorProperties(String connType) {
		super("getManagedNodeConnectorProperties");
		this.connType = connType;
	}

	/**
	 * Connector type, such as SOAP, RMI, JSR160RMI or IPC
	 */
	public String getConnType() {
		return this.connType;
	}

	/**
	 * Connector type, such as SOAP, RMI, JSR160RMI or IPC
	 */
	public void setConnType(String value) {
		this.connType = value;
	}

	/**
	 * ManagedNode name
	 */
	public String getManagedNodeName() {
		return this.managedNodeName;
	}

	/**
	 * ManagedNode name
	 */
	public void setManagedNodeName(String value) {
		this.managedNodeName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("connType", this.connType);
		if (this.managedNodeName != null) {
			ret.put("managedNodeName", this.managedNodeName);
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
