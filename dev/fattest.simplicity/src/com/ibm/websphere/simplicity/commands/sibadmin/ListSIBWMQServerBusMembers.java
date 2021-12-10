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

package com.ibm.websphere.simplicity.commands.sibadmin;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * List all WebSphere MQ servers.
 *   'bus': The name of the bus the WebSphere MQ server is a member of.
 * The required parameters are found in the constructor.
 */
public class ListSIBWMQServerBusMembers extends Command {

	private String bus;

	public ListSIBWMQServerBusMembers(String bus) {
		super("listSIBWMQServerBusMembers");
		this.bus = bus;
	}

	/**
	 * The name of the bus the WebSphere MQ server is a member of.
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * The name of the bus the WebSphere MQ server is a member of.
	 */
	public void setBus(String value) {
		this.bus = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("bus", this.bus);
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
