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
 * The command will return "true" if the destination specified inherits the default security permissions.
 *   'type': The destination type.  Allowable values are ( Queue | Port | Webservice | TopicSpace | ForeignDestination | Alias )
 *   'bus': Bus name
 *   'destination': Destination name
 * The required parameters are found in the constructor.
 */
public class IsInheritDefaultsForDestination extends Command {

	private String type;
	private String bus;
	private String destination;

	public IsInheritDefaultsForDestination(String type, String bus, String destination) {
		super("isInheritDefaultsForDestination");
		this.type = type;
		this.bus = bus;
		this.destination = destination;
	}

	/**
	 * The destination type.  Allowable values are ( Queue | Port | Webservice | TopicSpace | ForeignDestination | Alias )
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * The destination type.  Allowable values are ( Queue | Port | Webservice | TopicSpace | ForeignDestination | Alias )
	 */
	public void setType(String value) {
		this.type = value;
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
	 * Destination name
	 */
	public String getDestination() {
		return this.destination;
	}

	/**
	 * Destination name
	 */
	public void setDestination(String value) {
		this.destination = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("type", this.type);
		ret.put("bus", this.bus);
		ret.put("destination", this.destination);
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
