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
 * Adds the specified chain to the list of permitted chains for the specified bus.
 *   'bus': The name of the bus to add the permitted chain to.
 *   'chain': The name of the permitted transport chain to add.
 * The required parameters are found in the constructor.
 */
public class AddSIBPermittedChain extends Command {

	private String bus;
	private String chain;

	public AddSIBPermittedChain(String bus, String chain) {
		super("addSIBPermittedChain");
		this.bus = bus;
		this.chain = chain;
	}

	/**
	 * The name of the bus to add the permitted chain to.
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * The name of the bus to add the permitted chain to.
	 */
	public void setBus(String value) {
		this.bus = value;
	}

	/**
	 * The name of the permitted transport chain to add.
	 */
	public String getChain() {
		return this.chain;
	}

	/**
	 * The name of the permitted transport chain to add.
	 */
	public void setChain(String value) {
		this.chain = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("bus", this.bus);
		ret.put("chain", this.chain);
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
