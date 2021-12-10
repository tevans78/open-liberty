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

package com.ibm.websphere.simplicity.commands;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Change the name of the cell.  This command can only run in local mode i.e. with wsadmin conntype NONE.
 *   'newCellName': New Cell Name
 *   'regenCerts': SSL certificates
 *   'updateJaccContextID': Context ID of applications used by JACC provider
 * The required parameters are found in the constructor.
 */
public class RenameCell extends Command {

	private String newCellName;
	private Boolean regenCerts;
	private Boolean updateJaccContextID = true;

	public RenameCell(String newCellName) {
		super("renameCell");
		this.newCellName = newCellName;
	}

	/**
	 * New Cell Name
	 */
	public String getNewCellName() {
		return this.newCellName;
	}

	/**
	 * New Cell Name
	 */
	public void setNewCellName(String value) {
		this.newCellName = value;
	}

	/**
	 * SSL certificates
	 */
	public Boolean getRegenCerts() {
		return this.regenCerts;
	}

	/**
	 * SSL certificates
	 */
	public void setRegenCerts(Boolean value) {
		this.regenCerts = value;
	}

	/**
	 * Context ID of applications used by JACC provider
	 */
	public Boolean getUpdateJaccContextID() {
		return this.updateJaccContextID;
	}

	/**
	 * Context ID of applications used by JACC provider
	 */
	public void setUpdateJaccContextID(Boolean value) {
		this.updateJaccContextID = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("newCellName", this.newCellName);
		if (this.regenCerts != null) {
			ret.put("regenCerts", this.regenCerts);
		}
		if (this.updateJaccContextID != null) {
			ret.put("updateJaccContextID", this.updateJaccContextID);
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
