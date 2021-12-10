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

package com.ibm.websphere.simplicity.commands.sibwebservices;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Disconnect an endpoint listener from a service integration bus.
 *   'bus': Name of the service integration bus from which the endpoint listener is to be disconnected.
 * The required parameters are found in the constructor.
 */
public class DisconnectSIBWSEndpointListener extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String bus;

	public DisconnectSIBWSEndpointListener(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String bus) {
		super("disconnectSIBWSEndpointListener");
		this.__target = commandTarget;
		this.bus = bus;
	}

	/**
	 * Name of the service integration bus from which the endpoint listener is to be disconnected.
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * Name of the service integration bus from which the endpoint listener is to be disconnected.
	 */
	public void setBus(String value) {
		this.bus = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("bus", this.bus);
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
