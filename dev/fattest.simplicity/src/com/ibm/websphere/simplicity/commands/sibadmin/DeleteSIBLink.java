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
 * Delete a SIB link.
 *   'bus': The name of the bus.
 *   'messagingEngine': The name of the messaging engine.
 *   'sibLink': The name of the SIB link.
 * The required parameters are found in the constructor.
 */
public class DeleteSIBLink extends Command {

	private String bus;
	private String messagingEngine;
	private String sibLink;

	public DeleteSIBLink(String bus, String messagingEngine, String sibLink) {
		super("deleteSIBLink");
		this.bus = bus;
		this.messagingEngine = messagingEngine;
		this.sibLink = sibLink;
	}

	/**
	 * The name of the bus.
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * The name of the bus.
	 */
	public void setBus(String value) {
		this.bus = value;
	}

	/**
	 * The name of the messaging engine.
	 */
	public String getMessagingEngine() {
		return this.messagingEngine;
	}

	/**
	 * The name of the messaging engine.
	 */
	public void setMessagingEngine(String value) {
		this.messagingEngine = value;
	}

	/**
	 * The name of the SIB link.
	 */
	public String getSibLink() {
		return this.sibLink;
	}

	/**
	 * The name of the SIB link.
	 */
	public void setSibLink(String value) {
		this.sibLink = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("bus", this.bus);
		ret.put("messagingEngine", this.messagingEngine);
		ret.put("sibLink", this.sibLink);
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
