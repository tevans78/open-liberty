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
 * List destinations belonging to a bus.
 *   'bus': Bus name.
 *   'type': The type of destination to list. (Queue | TopicSpace | WebService | Port).
 * The required parameters are found in the constructor.
 */
public class ListSIBDestinations extends Command {

	private String bus;
	private String type;

	public ListSIBDestinations(String bus) {
		super("listSIBDestinations");
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
	 * The type of destination to list. (Queue | TopicSpace | WebService | Port).
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * The type of destination to list. (Queue | TopicSpace | WebService | Port).
	 */
	public void setType(String value) {
		this.type = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("bus", this.bus);
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
