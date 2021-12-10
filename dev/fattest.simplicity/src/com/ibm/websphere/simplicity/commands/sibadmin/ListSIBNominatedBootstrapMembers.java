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
 * Lists all the servers or clusters that have been nominated for bootstrap into the specified bus.
 *   'bus': Name of the bus to list the servers or clusters that have been configured as bootstrap members.
 * The required parameters are found in the constructor.
 */
public class ListSIBNominatedBootstrapMembers extends Command {

	private String bus;

	public ListSIBNominatedBootstrapMembers(String bus) {
		super("listSIBNominatedBootstrapMembers");
		this.bus = bus;
	}

	/**
	 * Name of the bus to list the servers or clusters that have been configured as bootstrap members.
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * Name of the bus to list the servers or clusters that have been configured as bootstrap members.
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
