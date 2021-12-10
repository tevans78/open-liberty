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
 * List the SIB foreign buses.
 *   'bus': Bus name.
 *   'type': Type name {MQ | SIBus} (only required if routing type is "Direct").
 *   'routingType': Routing type name {Direct | Indirect}.
 *   'javaFormat': The output from the command is a format suitable for java program clients.
 * The required parameters are found in the constructor.
 */
public class ListSIBForeignBuses extends Command {

	private String bus;
	private String type;
	private String routingType;
	private Boolean javaFormat = true;

	public ListSIBForeignBuses(String bus) {
		super("listSIBForeignBuses");
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
	 * Type name {MQ | SIBus} (only required if routing type is "Direct").
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Type name {MQ | SIBus} (only required if routing type is "Direct").
	 */
	public void setType(String value) {
		this.type = value;
	}

	/**
	 * Routing type name {Direct | Indirect}.
	 */
	public String getRoutingType() {
		return this.routingType;
	}

	/**
	 * Routing type name {Direct | Indirect}.
	 */
	public void setRoutingType(String value) {
		this.routingType = value;
	}

	/**
	 * The output from the command is a format suitable for java program clients.
	 */
	public Boolean getJavaFormat() {
		return this.javaFormat;
	}

	/**
	 * The output from the command is a format suitable for java program clients.
	 */
	public void setJavaFormat(Boolean value) {
		this.javaFormat = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("bus", this.bus);
		if (this.type != null) {
			ret.put("type", this.type);
		}
		if (this.routingType != null) {
			ret.put("routingType", this.routingType);
		}
		if (this.javaFormat != null) {
			ret.put("javaFormat", this.javaFormat);
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
