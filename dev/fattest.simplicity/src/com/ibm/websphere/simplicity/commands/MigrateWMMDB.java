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
 * Migrates WMM Database data to virtual member manager Database, includes wmmDB, wmmLookaside, and wmmFederation, if applicable.
 *   'wmmDBAdminId': The administrator id for WMM database
 *   'wmmDBAdminPassword': The administrator password for WMM database
 *   'wmmDBURL': The database URL for WMM
 * The required parameters are found in the constructor.
 */
public class MigrateWMMDB extends Command {

	private String wmmDBAdminId;
	private String wmmDBAdminPassword;
	private String wmmDBURL;

	public MigrateWMMDB(String wmmDBURL) {
		super("migrateWMMDB");
		this.wmmDBURL = wmmDBURL;
	}

	/**
	 * The administrator id for WMM database
	 */
	public String getWmmDBAdminId() {
		return this.wmmDBAdminId;
	}

	/**
	 * The administrator id for WMM database
	 */
	public void setWmmDBAdminId(String value) {
		this.wmmDBAdminId = value;
	}

	/**
	 * The administrator password for WMM database
	 */
	public String getWmmDBAdminPassword() {
		return this.wmmDBAdminPassword;
	}

	/**
	 * The administrator password for WMM database
	 */
	public void setWmmDBAdminPassword(String value) {
		this.wmmDBAdminPassword = value;
	}

	/**
	 * The database URL for WMM
	 */
	public String getWmmDBURL() {
		return this.wmmDBURL;
	}

	/**
	 * The database URL for WMM
	 */
	public void setWmmDBURL(String value) {
		this.wmmDBURL = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.wmmDBAdminId != null) {
			ret.put("wmmDBAdminId", this.wmmDBAdminId);
		}
		if (this.wmmDBAdminPassword != null) {
			ret.put("wmmDBAdminPassword", this.wmmDBAdminPassword);
		}
		ret.put("wmmDBURL", this.wmmDBURL);
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
