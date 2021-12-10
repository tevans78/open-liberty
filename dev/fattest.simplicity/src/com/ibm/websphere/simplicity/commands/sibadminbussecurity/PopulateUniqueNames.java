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
 * Attempt to populate any missing unique name entries in the authorization model for the specified bus using its user repository.
 *   'bus': Bus name
 *   'force': Set this option to force all authorization entries to have their unique names populated from the user repository. This may overwrite existing unique names with different values.
 * The required parameters are found in the constructor.
 */
public class PopulateUniqueNames extends Command {

	private String bus;
	private Boolean force = false;

	public PopulateUniqueNames(String bus) {
		super("populateUniqueNames");
		this.bus = bus;
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
	 * Set this option to force all authorization entries to have their unique names populated from the user repository. This may overwrite existing unique names with different values.
	 */
	public Boolean getForce() {
		return this.force;
	}

	/**
	 * Set this option to force all authorization entries to have their unique names populated from the user repository. This may overwrite existing unique names with different values.
	 */
	public void setForce(Boolean value) {
		this.force = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("bus", this.bus);
		if (this.force != null) {
			ret.put("force", this.force);
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
