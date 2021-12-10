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

package com.ibm.websphere.simplicity.commands.idmgrrepositoryconfig;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Updates a database repository configuration.
 *   'JDBCDriverClass': The name of the database driver for direct access mode. Example: COM.ibm.db2.jdbc.app.DB2Driver
 *   'dataSourceName': The datasource JNDI name.
 *   'databaseType': The type of database. Virtual member manager supports "db2", "oracle", "informix", "derby", "sqlserver", "db2zos", and "db2iseries".
 *   'dbAdminId': The database administrator ID for direct access mode. Example: db2admin
 *   'dbAdminPassword': The database administrator password for direct access mode.
 *   'dbURL': The database URL for direct access mode.
 *   'encryptionKey': The password encryption key. If not set, the default encryptionKey will be used.
 *   'entityRetrievalLimit': The maximum number of results to retrieve for one SQL call.
 *   'id': The unique identifier of the repository.
 *   'saltLength': The salt length of the randomly generated salt for password hashing. Default value is 12.
 * The required parameters are found in the constructor.
 */
public class UpdateIdMgrDBRepository extends Command {

	private String JDBCDriverClass;
	private String dataSourceName;
	private String databaseType;
	private String dbAdminId;
	private String dbAdminPassword;
	private String dbURL;
	private String encryptionKey;
	private Integer entityRetrievalLimit;
	private String id;
	private Integer saltLength;

	public UpdateIdMgrDBRepository(String id) {
		super("updateIdMgrDBRepository");
		this.id = id;
	}

	/**
	 * The name of the database driver for direct access mode. Example: COM.ibm.db2.jdbc.app.DB2Driver
	 */
	public String getJDBCDriverClass() {
		return this.JDBCDriverClass;
	}

	/**
	 * The name of the database driver for direct access mode. Example: COM.ibm.db2.jdbc.app.DB2Driver
	 */
	public void setJDBCDriverClass(String value) {
		this.JDBCDriverClass = value;
	}

	/**
	 * The datasource JNDI name.
	 */
	public String getDataSourceName() {
		return this.dataSourceName;
	}

	/**
	 * The datasource JNDI name.
	 */
	public void setDataSourceName(String value) {
		this.dataSourceName = value;
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
	 * The database URL for direct access mode.
	 */
	public String getDbURL() {
		return this.dbURL;
	}

	/**
	 * The database URL for direct access mode.
	 */
	public void setDbURL(String value) {
		this.dbURL = value;
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
	 * The maximum number of results to retrieve for one SQL call.
	 */
	public Integer getEntityRetrievalLimit() {
		return this.entityRetrievalLimit;
	}

	/**
	 * The maximum number of results to retrieve for one SQL call.
	 */
	public void setEntityRetrievalLimit(Integer value) {
		this.entityRetrievalLimit = value;
	}

	/**
	 * The unique identifier of the repository.
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * The unique identifier of the repository.
	 */
	public void setId(String value) {
		this.id = value;
	}

	/**
	 * The salt length of the randomly generated salt for password hashing. Default value is 12.
	 */
	public Integer getSaltLength() {
		return this.saltLength;
	}

	/**
	 * The salt length of the randomly generated salt for password hashing. Default value is 12.
	 */
	public void setSaltLength(Integer value) {
		this.saltLength = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.JDBCDriverClass != null) {
			ret.put("JDBCDriverClass", this.JDBCDriverClass);
		}
		if (this.dataSourceName != null) {
			ret.put("dataSourceName", this.dataSourceName);
		}
		if (this.databaseType != null) {
			ret.put("databaseType", this.databaseType);
		}
		if (this.dbAdminId != null) {
			ret.put("dbAdminId", this.dbAdminId);
		}
		if (this.dbAdminPassword != null) {
			ret.put("dbAdminPassword", this.dbAdminPassword);
		}
		if (this.dbURL != null) {
			ret.put("dbURL", this.dbURL);
		}
		if (this.encryptionKey != null) {
			ret.put("encryptionKey", this.encryptionKey);
		}
		if (this.entityRetrievalLimit != null) {
			ret.put("entityRetrievalLimit", this.entityRetrievalLimit);
		}
		ret.put("id", this.id);
		if (this.saltLength != null) {
			ret.put("saltLength", this.saltLength);
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
