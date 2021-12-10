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
 * Removes a user from the specified destination role for the specified destination.
 *   'type': The destination type.  Allowable values are ( Queue | Port | Webservice | TopicSpace | ForeignDestination | Alias )
 *   'bus': Bus name
 *   'foreignBus': Foreign Bus name
 *   'destination': Destination name
 *   'role': The role name.  Allowable values are: for Queues/Ports/WebServices ( Sender | Receiver | Browser | Creator | IdentityAdopter ), for TopicSpaces ( Sender | Receiver | IdentityAdopter ), for Aliases ( Sender | Receiver | Browser | IdentityAdopter ), for Foreign ( Sender | IdentityAdopter )
 *   'user': User name
 * The required parameters are found in the constructor.
 */
public class RemoveUserFromDestinationRole extends Command {

	private String type;
	private String bus;
	private String foreignBus;
	private String destination;
	private String role;
	private String user;

	public RemoveUserFromDestinationRole(String type, String bus, String destination, String role, String user) {
		super("removeUserFromDestinationRole");
		this.type = type;
		this.bus = bus;
		this.destination = destination;
		this.role = role;
		this.user = user;
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
	 * The role name.  Allowable values are: for Queues/Ports/WebServices ( Sender | Receiver | Browser | Creator | IdentityAdopter ), for TopicSpaces ( Sender | Receiver | IdentityAdopter ), for Aliases ( Sender | Receiver | Browser | IdentityAdopter ), for Foreign ( Sender | IdentityAdopter )
	 */
	public String getRole() {
		return this.role;
	}

	/**
	 * The role name.  Allowable values are: for Queues/Ports/WebServices ( Sender | Receiver | Browser | Creator | IdentityAdopter ), for TopicSpaces ( Sender | Receiver | IdentityAdopter ), for Aliases ( Sender | Receiver | Browser | IdentityAdopter ), for Foreign ( Sender | IdentityAdopter )
	 */
	public void setRole(String value) {
		this.role = value;
	}

	/**
	 * User name
	 */
	public String getUser() {
		return this.user;
	}

	/**
	 * User name
	 */
	public void setUser(String value) {
		this.user = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("type", this.type);
		ret.put("bus", this.bus);
		if (this.foreignBus != null) {
			ret.put("foreignBus", this.foreignBus);
		}
		ret.put("destination", this.destination);
		ret.put("role", this.role);
		ret.put("user", this.user);
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
