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
 * Delete bus destination.
 *   'bus': Bus name.
 *   'name': Destination name.
 *   'aliasBus': If the destination to be deleted is an alias destination, then the aliasBus parameter must be supplied if the alias bus for the destination is not the local bus.
 *   'foreignBus': If the destination to be deleted is a foreign destination then name of the foreign bus must be supplied.
 * The required parameters are found in the constructor.
 */
public class DeleteSIBDestination extends Command {

	private String bus;
	private String name;
	private String aliasBus;
	private String foreignBus;

	public DeleteSIBDestination(String bus, String name) {
		super("deleteSIBDestination");
		this.bus = bus;
		this.name = name;
	}

	/**
	 * Bus name.
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * Bus name.
	 */
	public void setBus(String value) {
		this.bus = value;
	}

	/**
	 * Destination name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Destination name.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * If the destination to be deleted is an alias destination, then the aliasBus parameter must be supplied if the alias bus for the destination is not the local bus.
	 */
	public String getAliasBus() {
		return this.aliasBus;
	}

	/**
	 * If the destination to be deleted is an alias destination, then the aliasBus parameter must be supplied if the alias bus for the destination is not the local bus.
	 */
	public void setAliasBus(String value) {
		this.aliasBus = value;
	}

	/**
	 * If the destination to be deleted is a foreign destination then name of the foreign bus must be supplied.
	 */
	public String getForeignBus() {
		return this.foreignBus;
	}

	/**
	 * If the destination to be deleted is a foreign destination then name of the foreign bus must be supplied.
	 */
	public void setForeignBus(String value) {
		this.foreignBus = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("bus", this.bus);
		ret.put("name", this.name);
		if (this.aliasBus != null) {
			ret.put("aliasBus", this.aliasBus);
		}
		if (this.foreignBus != null) {
			ret.put("foreignBus", this.foreignBus);
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
