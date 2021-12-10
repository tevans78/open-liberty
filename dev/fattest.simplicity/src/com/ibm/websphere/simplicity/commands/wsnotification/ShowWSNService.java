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
 * Show the properties of a WSNService object in a human readable form.
 *   'bus': Bus
 *   'name': Name
 * The required parameters are found in the constructor.
 */
public class ShowWSNService extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String bus;
	private String name;

	public ShowWSNService(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget) {
		super("showWSNService");
		this.__target = commandTarget;
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
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.bus != null) {
			ret.put("bus", this.bus);
		}
		if (this.name != null) {
			ret.put("name", this.name);
		}
		return ret;
	}

	public Object __getTarget() {
		return this.__target;
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
