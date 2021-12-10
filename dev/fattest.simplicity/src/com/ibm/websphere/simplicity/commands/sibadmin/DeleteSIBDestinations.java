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
import java.util.ArrayList;
import com.ibm.websphere.simplicity.commands.CommandStep;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Delete bus destinations.
 *   'bus': Bus name.
 *   'aliasBus': If the destination to be deleted is an alias destination, then the aliasBus parameter must be supplied if the alias bus for the destination is not the local bus.
 *   'foreignBus': If the destination to be deleted is a foreign destination then name of the foreign bus must be supplied.
 * The required parameters are found in the constructor.
 */
public class DeleteSIBDestinations extends Command {

	private List<Command> __steps;
	private String bus;
	private String aliasBus;
	private String foreignBus;

	public DeleteSIBDestinations(String bus) {
		super("deleteSIBDestinations");
		this.bus = bus;
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
		return this.__steps;
	}

	/**
	 * Executes the command against the specified scope.
	 * Steps are required by this command, and they appear after the scope parameter.
	 * Classes for these steps are statically available through this admin command class.
	 */
	public OperationResults<Object> run(Scope scope, NameList nameList) throws Exception {
		this.__steps = new ArrayList<Command>();
		if (nameList != null)
			this.__steps.add(nameList);
		return super.run(scope);
	}

	/**
	 * Destination name list.
	 *   'name': Destination name.
	 * The required parameters are found in the constructor.
	 */
	public static class NameList extends CommandStep {

		private String name;

		public NameList(String name) {
			super("nameList");
			this.name = name;
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			ret.put("name", this.name);
			return ret;
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

	}
}
