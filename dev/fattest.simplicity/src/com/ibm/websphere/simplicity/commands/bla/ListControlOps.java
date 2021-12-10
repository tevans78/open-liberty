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

package com.ibm.websphere.simplicity.commands.bla;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Lists control operations defined for a business-level application and its composition units.
 *   'blaID': The ID of a business-level application for which to list control operations.  (See output from the listBLAs command for the format of a fully-qualified of a business-level application ID.)
 *   'cuID': The ID of the specific composition unit for which to list control operations.  (See output from the listCompUnits command for the format of a fully-qualified composition unit ID.)  If no composition unit ID is specified, control operations for the specified business-level application are listed.
 *   'opName': The specific operation to list.  If no operation is specified, all control operations are listed.
 *   'long': The "long" option is used to generate a listing with additional control operation details.  The details are of interest mainly to developers of business-level application content providers which must provide start and stop operation handlers for assets they configure.  Specify a value of "true" to list the additional details.  The default value for this option is "false".
 * The required parameters are found in the constructor.
 */
public class ListControlOps extends Command {

	private String blaID;
	private String cuID;
	private String opName;
	private String _long;

	public ListControlOps(String blaID) {
		super("listControlOps");
		this.blaID = blaID;
	}

	/**
	 * The ID of a business-level application for which to list control operations.  (See output from the listBLAs command for the format of a fully-qualified of a business-level application ID.)
	 */
	public String getBlaID() {
		return this.blaID;
	}

	/**
	 * The ID of a business-level application for which to list control operations.  (See output from the listBLAs command for the format of a fully-qualified of a business-level application ID.)
	 */
	public void setBlaID(String value) {
		this.blaID = value;
	}

	/**
	 * The ID of the specific composition unit for which to list control operations.  (See output from the listCompUnits command for the format of a fully-qualified composition unit ID.)  If no composition unit ID is specified, control operations for the specified business-level application are listed.
	 */
	public String getCuID() {
		return this.cuID;
	}

	/**
	 * The ID of the specific composition unit for which to list control operations.  (See output from the listCompUnits command for the format of a fully-qualified composition unit ID.)  If no composition unit ID is specified, control operations for the specified business-level application are listed.
	 */
	public void setCuID(String value) {
		this.cuID = value;
	}

	/**
	 * The specific operation to list.  If no operation is specified, all control operations are listed.
	 */
	public String getOpName() {
		return this.opName;
	}

	/**
	 * The specific operation to list.  If no operation is specified, all control operations are listed.
	 */
	public void setOpName(String value) {
		this.opName = value;
	}

	/**
	 * The "long" option is used to generate a listing with additional control operation details.  The details are of interest mainly to developers of business-level application content providers which must provide start and stop operation handlers for assets they configure.  Specify a value of "true" to list the additional details.  The default value for this option is "false".
	 */
	public String getLong() {
		return this._long;
	}

	/**
	 * The "long" option is used to generate a listing with additional control operation details.  The details are of interest mainly to developers of business-level application content providers which must provide start and stop operation handlers for assets they configure.  Specify a value of "true" to list the additional details.  The default value for this option is "false".
	 */
	public void setLong(String value) {
		this._long = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("blaID", this.blaID);
		if (this.cuID != null) {
			ret.put("cuID", this.cuID);
		}
		if (this.opName != null) {
			ret.put("opName", this.opName);
		}
		if (this._long != null) {
			ret.put("long", this._long);
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
