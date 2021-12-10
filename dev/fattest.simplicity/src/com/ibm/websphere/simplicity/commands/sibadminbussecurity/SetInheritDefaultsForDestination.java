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
 * Allows the override for inheritance for an individual destination.  Setting the "inherit" value to true will allow the destination to inherit from the default values.
 *   'type': The destination type.  Allowable values are ( Queue | Port | Webservice | TopicSpace | ForeignDestination | Alias )
 *   'bus': Bus name
 *   'destination': Destination name
 *   'inherit': Inherit destination defaults (True by default)
 * The required parameters are found in the constructor.
 */
public class SetInheritDefaultsForDestination extends Command {

	private String type;
	private String bus;
	private String destination;
	private Boolean inherit = true;

	public SetInheritDefaultsForDestination(String type, String bus, String destination, Boolean inherit) {
		super("setInheritDefaultsForDestination");
		this.type = type;
		this.bus = bus;
		this.destination = destination;
		this.inherit = inherit;
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

	/**
	 * Inherit destination defaults (True by default)
	 */
	public Boolean getInherit() {
		return this.inherit;
	}

	/**
	 * Inherit destination defaults (True by default)
	 */
	public void setInherit(Boolean value) {
		this.inherit = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("type", this.type);
		ret.put("bus", this.bus);
		ret.put("destination", this.destination);
		ret.put("inherit", this.inherit);
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
