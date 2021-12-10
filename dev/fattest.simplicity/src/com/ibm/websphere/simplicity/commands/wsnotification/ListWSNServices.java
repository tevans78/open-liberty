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

package com.ibm.websphere.simplicity.commands.wsnotification;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Lists all the WSNService objects in the configuration that match the specified input parameters.
 *   'bus': Bus
 *   'name': Name
 *   'type': Used to filter the results depending on the type of the service. Valid values are V6.1 and V7.0.
 * The required parameters are found in the constructor.
 */
public class ListWSNServices extends Command {

	private String bus;
	private String name;
	private String type;

	public ListWSNServices() {
		super("listWSNServices");
	}

	/**
	 * Bus
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * Bus
	 */
	public void setBus(String value) {
		this.bus = value;
	}

	/**
	 * Name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Name
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Used to filter the results depending on the type of the service. Valid values are V6.1 and V7.0.
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Used to filter the results depending on the type of the service. Valid values are V6.1 and V7.0.
	 */
	public void setType(String value) {
		this.type = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.bus != null) {
			ret.put("bus", this.bus);
		}
		if (this.name != null) {
			ret.put("name", this.name);
		}
		if (this.type != null) {
			ret.put("type", this.type);
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
