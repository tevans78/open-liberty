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
 * List the groups in the default role.
 *   'bus': Bus name
 *   'role': The role name.  Allowable values are ( Sender | Receiver | Browser | Creator | IdentityAdopter )
 *   'showUniqueNames': SHOW_UNIQUE_NAMES_DESCRIPTION
 * The required parameters are found in the constructor.
 */
public class ListGroupsInDefaultRole extends Command {

	private String bus;
	private String role;
	private Boolean showUniqueNames = false;

	public ListGroupsInDefaultRole(String bus, String role) {
		super("listGroupsInDefaultRole");
		this.bus = bus;
		this.role = role;
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
	 * The role name.  Allowable values are ( Sender | Receiver | Browser | Creator | IdentityAdopter )
	 */
	public String getRole() {
		return this.role;
	}

	/**
	 * The role name.  Allowable values are ( Sender | Receiver | Browser | Creator | IdentityAdopter )
	 */
	public void setRole(String value) {
		this.role = value;
	}

	/**
	 * SHOW_UNIQUE_NAMES_DESCRIPTION
	 */
	public Boolean getShowUniqueNames() {
		return this.showUniqueNames;
	}

	/**
	 * SHOW_UNIQUE_NAMES_DESCRIPTION
	 */
	public void setShowUniqueNames(Boolean value) {
		this.showUniqueNames = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("bus", this.bus);
		ret.put("role", this.role);
		if (this.showUniqueNames != null) {
			ret.put("showUniqueNames", this.showUniqueNames);
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
