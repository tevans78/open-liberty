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
 * Creates a database repository configuration.
 *   'JDBCDriverClass': The name of the database driver for direct access mode. Example: COM.ibm.db2.jdbc.app.DB2Driver
 *   'adapterClassName': The implementation class name for the repository adapter.
 *   'dataSourceName': The datasource JNDI name.
 *   'databaseType': The type of database. Virtual member manager supports "db2", "oracle", "informix", "derby", "sqlserver", "db2zos", and "db2iseries".
 *   'dbAdminId': The database administrator ID for direct access mode. Example: db2admin
 *   'dbAdminPassword': The database administrator password for direct access mode.
 *   'dbURL': The database URL for direct access mode.
 *   'encryptionKey': The password encryption key. If not set, the default encryptionKey will be used.
 *   'entityRetrievalLimit': The maximum number of results to retrieve for one SQL call.
 *   'id': The unique identifier of the repository.
 *   'isExtIdUnique': A boolean representing if the external ID for entities in the repository is unique
 *   'readOnly': Is this a read only repository?
 *   'saltLength': The salt length of the randomly generated salt for password hashing. Default value is 12.
 *   'supportAsyncMode': A boolean representing if the adapter supports asynchronous mode
 *   'supportExternalName': A boolean representing if the repository supports external names
 *   'supportSorting': A boolean representing if the repository supports sorting
 *   'supportTransactions': A boolean representing if the repository supports transactions
 * The required parameters are found in the constructor.
 */
public class CreateIdMgrDBRepository extends Command {

	private String JDBCDriverClass;
	private String adapterClassName = "com.ibm.ws.wim.adapter.db.DBAdapter";
	private String dataSourceName;
	private String databaseType;
	private String dbAdminId;
	private String dbAdminPassword;
	private String dbURL;
	private String encryptionKey;
	private Integer entityRetrievalLimit = 50;
	private String id;
	private Boolean isExtIdUnique = true;
	private Boolean readOnly;
	private Integer saltLength = 12;
	private Boolean supportAsyncMode;
	private Boolean supportExternalName = false;
	private Boolean supportSorting = false;
	private Boolean supportTransactions = false;

	public CreateIdMgrDBRepository(String dataSourceName, String databaseType, String dbURL, String id) {
		super("createIdMgrDBRepository");
		this.dataSourceName = dataSourceName;
		this.databaseType = databaseType;
		this.dbURL = dbURL;
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
	 * The implementation class name for the repository adapter.
	 */
	public String getAdapterClassName() {
		return this.adapterClassName;
	}

	/**
	 * The implementation class name for the repository adapter.
	 */
	public void setAdapterClassName(String value) {
		this.adapterClassName = value;
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
	 * A boolean representing if the external ID for entities in the repository is unique
	 */
	public Boolean getIsExtIdUnique() {
		return this.isExtIdUnique;
	}

	/**
	 * A boolean representing if the external ID for entities in the repository is unique
	 */
	public void setIsExtIdUnique(Boolean value) {
		this.isExtIdUnique = value;
	}

	/**
	 * Is this a read only repository?
	 */
	public Boolean getReadOnly() {
		return this.readOnly;
	}

	/**
	 * Is this a read only repository?
	 */
	public void setReadOnly(Boolean value) {
		this.readOnly = value;
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

	/**
	 * A boolean representing if the adapter supports asynchronous mode
	 */
	public Boolean getSupportAsyncMode() {
		return this.supportAsyncMode;
	}

	/**
	 * A boolean representing if the adapter supports asynchronous mode
	 */
	public void setSupportAsyncMode(Boolean value) {
		this.supportAsyncMode = value;
	}

	/**
	 * A boolean representing if the repository supports external names
	 */
	public Boolean getSupportExternalName() {
		return this.supportExternalName;
	}

	/**
	 * A boolean representing if the repository supports external names
	 */
	public void setSupportExternalName(Boolean value) {
		this.supportExternalName = value;
	}

	/**
	 * A boolean representing if the repository supports sorting
	 */
	public Boolean getSupportSorting() {
		return this.supportSorting;
	}

	/**
	 * A boolean representing if the repository supports sorting
	 */
	public void setSupportSorting(Boolean value) {
		this.supportSorting = value;
	}

	/**
	 * A boolean representing if the repository supports transactions
	 */
	public Boolean getSupportTransactions() {
		return this.supportTransactions;
	}

	/**
	 * A boolean representing if the repository supports transactions
	 */
	public void setSupportTransactions(Boolean value) {
		this.supportTransactions = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.JDBCDriverClass != null) {
			ret.put("JDBCDriverClass", this.JDBCDriverClass);
		}
		if (this.adapterClassName != null) {
			ret.put("adapterClassName", this.adapterClassName);
		}
		ret.put("dataSourceName", this.dataSourceName);
		ret.put("databaseType", this.databaseType);
		if (this.dbAdminId != null) {
			ret.put("dbAdminId", this.dbAdminId);
		}
		if (this.dbAdminPassword != null) {
			ret.put("dbAdminPassword", this.dbAdminPassword);
		}
		ret.put("dbURL", this.dbURL);
		if (this.encryptionKey != null) {
			ret.put("encryptionKey", this.encryptionKey);
		}
		if (this.entityRetrievalLimit != null) {
			ret.put("entityRetrievalLimit", this.entityRetrievalLimit);
		}
		ret.put("id", this.id);
		if (this.isExtIdUnique != null) {
			ret.put("isExtIdUnique", this.isExtIdUnique);
		}
		if (this.readOnly != null) {
			ret.put("readOnly", this.readOnly);
		}
		if (this.saltLength != null) {
			ret.put("saltLength", this.saltLength);
		}
		if (this.supportAsyncMode != null) {
			ret.put("supportAsyncMode", this.supportAsyncMode);
		}
		if (this.supportExternalName != null) {
			ret.put("supportExternalName", this.supportExternalName);
		}
		if (this.supportSorting != null) {
			ret.put("supportSorting", this.supportSorting);
		}
		if (this.supportTransactions != null) {
			ret.put("supportTransactions", this.supportTransactions);
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
