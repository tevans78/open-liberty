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
 * Delete a mediation.
 *   'bus': The name of the bus that owns the mediation.
 *   'mediationName': Name of the mediation to be deleted.
 * The required parameters are found in the constructor.
 */
public class DeleteSIBMediation extends Command {

	private String bus;
	private String mediationName;

	public DeleteSIBMediation(String bus, String mediationName) {
		super("deleteSIBMediation");
		this.bus = bus;
		this.mediationName = mediationName;
	}

	/**
	 * The name of the bus that owns the mediation.
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * The name of the bus that owns the mediation.
	 */
	public void setBus(String value) {
		this.bus = value;
	}

	/**
	 * Name of the mediation to be deleted.
	 */
	public String getMediationName() {
		return this.mediationName;
	}

	/**
	 * Name of the mediation to be deleted.
	 */
	public void setMediationName(String value) {
		this.mediationName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("bus", this.bus);
		ret.put("mediationName", this.mediationName);
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
