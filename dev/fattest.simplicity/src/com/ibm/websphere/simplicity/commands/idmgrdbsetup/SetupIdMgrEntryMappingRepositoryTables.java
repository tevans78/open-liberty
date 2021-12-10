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

package com.ibm.websphere.simplicity.commands.idmgrdbsetup;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Creates and populates tables for entry mapping database in virtual member manager.
 *   'databaseType': The type of database. Virtual member manager supports "db2", "oracle", "informix", "derby", "sqlserver", "db2zos", and "db2iseries".
 *   'dbAdminId': The database administrator ID for direct access mode. Example: db2admin
 *   'dbAdminPassword': The database administrator password for direct access mode.
 *   'dbDriver': The name of the database driver. Example: COM.ibm.db2.jdbc.app.DB2Driver
 *   'dbURL': The database URL for direct access mode. Example: jdbc:db2:wim
 *   'file': The full path to a file containing the input parameters. Each input parameter must exactly match a corresponding parameter as would be typed on the command line, and be placed in a Key=Value pair. Each pair must be on a separate line.
 *   'derbySystemHome': The home location of the derby system if setting up a derby database.
 *   'reportSqlError': Specifies whether to report sql errors while setting up databases.
 *   'schemaLocation': The location of &lt;vmm_install&gt;/setup directory.
 * The required parameters are found in the constructor.
 */
public class SetupIdMgrEntryMappingRepositoryTables extends Command {

	private String databaseType;
	private String dbAdminId;
	private String dbAdminPassword;
	private String dbDriver;
	private String dbURL;
	private String file;
	private String derbySystemHome;
	private String reportSqlError;
	private String schemaLocation;

	public SetupIdMgrEntryMappingRepositoryTables() {
		super("setupIdMgrEntryMappingRepositoryTables");
	}

	/**
	 * The type of database. Virtual member manager supports "db2", "oracle", "informix", "derby", "sqlserver", "db2zos", and "db2iseries".
	 */
	public String getDatabaseType() {
		return this.databaseType;
	}

	/**
	 * The type of database. Virtual member manager supports "db2", "oracle", "informix", "derby", "sqlserver", "db2zos", and "db2iseries".
	 */
	public void setDatabaseType(String value) {
		this.databaseType = value;
	}

	/**
	 * The database administrator ID for direct access mode. Example: db2admin
	 */
	public String getDbAdminId() {
		return this.dbAdminId;
	}

	/**
	 * The database administrator ID for direct access mode. Example: db2admin
	 */
	public void setDbAdminId(String value) {
		this.dbAdminId = value;
	}

	/**
	 * The database administrator password for direct access mode.
	 */
	public String getDbAdminPassword() {
		return this.dbAdminPassword;
	}

	/**
	 * The database administrator password for direct access mode.
	 */
	public void setDbAdminPassword(String value) {
		this.dbAdminPassword = value;
	}

	/**
	 * The name of the database driver. Example: COM.ibm.db2.jdbc.app.DB2Driver
	 */
	public String getDbDriver() {
		return this.dbDriver;
	}

	/**
	 * The name of the database driver. Example: COM.ibm.db2.jdbc.app.DB2Driver
	 */
	public void setDbDriver(String value) {
		this.dbDriver = value;
	}

	/**
	 * The database URL for direct access mode. Example: jdbc:db2:wim
	 */
	public String getDbURL() {
		return this.dbURL;
	}

	/**
	 * The database URL for direct access mode. Example: jdbc:db2:wim
	 */
	public void setDbURL(String value) {
		this.dbURL = value;
	}

	/**
	 * The full path to a file containing the input parameters. Each input parameter must exactly match a corresponding parameter as would be typed on the command line, and be placed in a Key=Value pair. Each pair must be on a separate line.
	 */
	public String getFile() {
		return this.file;
	}

	/**
	 * The full path to a file containing the input parameters. Each input parameter must exactly match a corresponding parameter as would be typed on the command line, and be placed in a Key=Value pair. Each pair must be on a separate line.
	 */
	public void setFile(String value) {
		this.file = value;
	}

	/**
	 * The home location of the derby system if setting up a derby database.
	 */
	public String getDerbySystemHome() {
		return this.derbySystemHome;
	}

	/**
	 * The home location of the derby system if setting up a derby database.
	 */
	public void setDerbySystemHome(String value) {
		this.derbySystemHome = value;
	}

	/**
	 * Specifies whether to report sql errors while setting up databases.
	 */
	public String getReportSqlError() {
		return this.reportSqlError;
	}

	/**
	 * Specifies whether to report sql errors while setting up databases.
	 */
	public void setReportSqlError(String value) {
		this.reportSqlError = value;
	}

	/**
	 * The location of &lt;vmm_install&gt;/setup directory.
	 */
	public String getSchemaLocation() {
		return this.schemaLocation;
	}

	/**
	 * The location of &lt;vmm_install&gt;/setup directory.
	 */
	public void setSchemaLocation(String value) {
		this.schemaLocation = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.databaseType != null) {
			ret.put("databaseType", this.databaseType);
		}
		if (this.dbAdminId != null) {
			ret.put("dbAdminId", this.dbAdminId);
		}
		if (this.dbAdminPassword != null) {
			ret.put("dbAdminPassword", this.dbAdminPassword);
		}
		if (this.dbDriver != null) {
			ret.put("dbDriver", this.dbDriver);
		}
		if (this.dbURL != null) {
			ret.put("dbURL", this.dbURL);
		}
		if (this.file != null) {
			ret.put("file", this.file);
		}
		if (this.derbySystemHome != null) {
			ret.put("derbySystemHome", this.derbySystemHome);
		}
		if (this.reportSqlError != null) {
			ret.put("reportSqlError", this.reportSqlError);
		}
		if (this.schemaLocation != null) {
			ret.put("schemaLocation", this.schemaLocation);
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
