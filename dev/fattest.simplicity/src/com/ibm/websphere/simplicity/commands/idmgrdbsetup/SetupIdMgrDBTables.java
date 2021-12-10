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
 * Creates and populates tables for database in virtual member manager.
 *   'databaseType': The type of database. Virtual member manager supports "db2", "oracle", "informix", "derby", "sqlserver", "db2zos", and "db2iseries".
 *   'dbAdminId': The database administrator ID for direct access mode. Example: db2admin
 *   'dbAdminPassword': The database administrator password for direct access mode.
 *   'dbDriver': The name of the database driver. Example: COM.ibm.db2.jdbc.app.DB2Driver
 *   'dbURL': The database URL for direct access mode. Example: jdbc:db2:wim
 *   'file': The full path to a file containing the input parameters. Each input parameter must exactly match a corresponding parameter as would be typed on the command line, and be placed in a Key=Value pair. Each pair must be on a separate line.
 *   'dbPropXML': The location of database repository property definition xml file.
 *   'derbySystemHome': The home location of the derby system if setting up a derby database.
 *   'dn': Specifies the organization name used as the DN, for example, o=ibm.com.  If you do not specify a value, the default value used is o=Default Organization.
 *   'encryptionKey': The password encryption key. If not set, the default encryptionKey will be used.
 *   'reportSqlError': Specifies whether to report sql errors while setting up databases.
 *   'saltLength': The salt length of the randomly generated salt for password hashing. Default value is 12.
 *   'schemaLocation': The location of &lt;vmm_install&gt;/setup directory.
 *   'wasAdminId': The WebSphere Application Server admin user/ server id. For example: wasadmin. After creation, the uniqueName will be "uid=wasadmin, &lt;defaultOrg&gt;".
 *   'wasAdminPassword': The WebSphere Application Server admin user/ server id password. If was_admin_id is set, this parameter is mandatory.
 * The required parameters are found in the constructor.
 */
public class SetupIdMgrDBTables extends Command {

	private String databaseType;
	private String dbAdminId;
	private String dbAdminPassword;
	private String dbDriver;
	private String dbURL;
	private String file;
	private String dbPropXML;
	private String derbySystemHome;
	private String dn;
	private String encryptionKey;
	private String reportSqlError;
	private String saltLength;
	private String schemaLocation;
	private String wasAdminId;
	private String wasAdminPassword;

	public SetupIdMgrDBTables() {
		super("setupIdMgrDBTables");
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
	 * The location of database repository property definition xml file.
	 */
	public String getDbPropXML() {
		return this.dbPropXML;
	}

	/**
	 * The location of database repository property definition xml file.
	 */
	public void setDbPropXML(String value) {
		this.dbPropXML = value;
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
	 * Specifies the organization name used as the DN, for example, o=ibm.com.  If you do not specify a value, the default value used is o=Default Organization.
	 */
	public String getDn() {
		return this.dn;
	}

	/**
	 * Specifies the organization name used as the DN, for example, o=ibm.com.  If you do not specify a value, the default value used is o=Default Organization.
	 */
	public void setDn(String value) {
		this.dn = value;
	}

	/**
	 * The password encryption key. If not set, the default encryptionKey will be used.
	 */
	public String getEncryptionKey() {
		return this.encryptionKey;
	}

	/**
	 * The password encryption key. If not set, the default encryptionKey will be used.
	 */
	public void setEncryptionKey(String value) {
		this.encryptionKey = value;
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
	 * The salt length of the randomly generated salt for password hashing. Default value is 12.
	 */
	public String getSaltLength() {
		return this.saltLength;
	}

	/**
	 * The salt length of the randomly generated salt for password hashing. Default value is 12.
	 */
	public void setSaltLength(String value) {
		this.saltLength = value;
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

	/**
	 * The WebSphere Application Server admin user/ server id. For example: wasadmin. After creation, the uniqueName will be "uid=wasadmin, &lt;defaultOrg&gt;".
	 */
	public String getWasAdminId() {
		return this.wasAdminId;
	}

	/**
	 * The WebSphere Application Server admin user/ server id. For example: wasadmin. After creation, the uniqueName will be "uid=wasadmin, &lt;defaultOrg&gt;".
	 */
	public void setWasAdminId(String value) {
		this.wasAdminId = value;
	}

	/**
	 * The WebSphere Application Server admin user/ server id password. If was_admin_id is set, this parameter is mandatory.
	 */
	public String getWasAdminPassword() {
		return this.wasAdminPassword;
	}

	/**
	 * The WebSphere Application Server admin user/ server id password. If was_admin_id is set, this parameter is mandatory.
	 */
	public void setWasAdminPassword(String value) {
		this.wasAdminPassword = value;
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
		if (this.dbPropXML != null) {
			ret.put("dbPropXML", this.dbPropXML);
		}
		if (this.derbySystemHome != null) {
			ret.put("derbySystemHome", this.derbySystemHome);
		}
		if (this.dn != null) {
			ret.put("dn", this.dn);
		}
		if (this.encryptionKey != null) {
			ret.put("encryptionKey", this.encryptionKey);
		}
		if (this.reportSqlError != null) {
			ret.put("reportSqlError", this.reportSqlError);
		}
		if (this.saltLength != null) {
			ret.put("saltLength", this.saltLength);
		}
		if (this.schemaLocation != null) {
			ret.put("schemaLocation", this.schemaLocation);
		}
		if (this.wasAdminId != null) {
			ret.put("wasAdminId", this.wasAdminId);
		}
		if (this.wasAdminPassword != null) {
			ret.put("wasAdminPassword", this.wasAdminPassword);
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
