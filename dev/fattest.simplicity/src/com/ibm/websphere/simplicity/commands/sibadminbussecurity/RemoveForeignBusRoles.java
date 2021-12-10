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

package com.ibm.websphere.simplicity.commands.sibadminbussecurity;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Remove all foreign bus roles defined for the specified bus
 *   'bus': Bus name
 *   'foreignBus': Foreign Bus name
 * The required parameters are found in the constructor.
 */
public class RemoveForeignBusRoles extends Command {

	private String bus;
	private String foreignBus;

	public RemoveForeignBusRoles(String bus, String foreignBus) {
		super("removeForeignBusRoles");
		this.bus = bus;
		this.foreignBus = foreignBus;
	}

	/**
	 * Bus name
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * Bus name
	 */
	public void setBus(String value) {
		this.bus = value;
	}

	/**
	 * Foreign Bus name
	 */
	public String getForeignBus() {
		return this.foreignBus;
	}

	/**
	 * Foreign Bus name
	 */
	public void setForeignBus(String value) {
		this.foreignBus = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("bus", this.bus);
		ret.put("foreignBus", this.foreignBus);
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
