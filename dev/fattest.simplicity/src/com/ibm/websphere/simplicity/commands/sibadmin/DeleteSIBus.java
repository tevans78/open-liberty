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
 * Delete a named bus, including everything on it.
 *   'bus': Name of bus to be deleted from the current cell.
 * The required parameters are found in the constructor.
 */
public class DeleteSIBus extends Command {

	private List<Command> __steps;
	private String bus;

	public DeleteSIBus(String bus) {
		super("deleteSIBus");
		this.bus = bus;
	}

	/**
	 * Name of bus to be deleted from the current cell.
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * Name of bus to be deleted from the current cell.
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
		return this.__steps;
	}

	/**
	 * Executes the command against the specified scope.
	 * Steps are required by this command, and they appear after the scope parameter.
	 * Classes for these steps are statically available through this admin command class.
	 */
	public OperationResults<Object> run(Scope scope, SIBWSDeleteSIBus sIBWSDeleteSIBus) throws Exception {
		this.__steps = new ArrayList<Command>();
		if (sIBWSDeleteSIBus != null)
			this.__steps.add(sIBWSDeleteSIBus);
		return super.run(scope);
	}

	/**
	 * 
	 * The required parameters are found in the constructor.
	 */
	public static class SIBWSDeleteSIBus extends CommandStep {

		public SIBWSDeleteSIBus() {
			super("SIBWSDeleteSIBus");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			return ret;
		}

	}
}
