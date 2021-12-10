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

package com.ibm.websphere.simplicity.commands.eventservicedb;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * The configEventServiceDB2ZOSDB command creates the Event Service database and data sources for DB2 z/OS on a server or cluster.
 *   'createDB': The command generates the DDL database scripts and creates the database when this parameter is set to true. The command only generates the DDL database scripts when this parameter is set to false. To create the database, the current machine must be already configured to run the database commands. The default value is false if not specified.
 *   'overrideDataSource': When this parameter is set to true, the command removes any existing Event Service data source at the specified scope before creating a new one. When this parameter is set to false, the command does not create an Event Service data source at the specified scope if another Event Service data source is found at the same scope. The default value is false if not specified.
 *   'nodeName': The name of the node that contains the server where the Event Service data source should be created. If this parameter is specified, then the serverName parameter must be set. You must not specify this parameter if the clusterName parameter is specified.
 *   'serverName': The name of the server where the Event Service data source should be created. If this parameters is specified without the nodeName parameter, the command will use the node name of the current WebSphere profile. You must not specify this parameter if the clusterName parameter is specified.
 *   'clusterName': The name of the cluster where the Event Service data source should be created. If this parameter is specified, then the serverName and nodeName parameters must not be set. You must not specify this parameter if the serverName and nodeName parameters are specified.
 *   'jdbcClassPath': The path to the jdbc driver, specify only the directory to the zip or jar file. You must not specify the jar or zip file name in the path. This parameter is required.
 *   'dbHostName': The host name of the machine where the database server is installed. This parameter is required.
 *   'dbPort': DB2 z/OS instance port. The default value is 5027 if not specified.
 *   'dbAliasName': The name of the cataloged database on the DB2 client machine. This parameter is required when the createDB parameter is set to true.
 *   'dbSubSystemName': The DB2 z/OS subsystem name. This parameter is required.
 *   'eventDBName': The event database name to be created. The default value is event if not specified .
 *   'eventCatalogDBName': The event catalog database to be created. The default value is eventcat if not specified .
 *   'dbDiskSizeInMB': Specify the disk size (must be at least 10) in megabyte (MB) for the Event Service database. The default value is 100 MB if not specified.
 *   'dbUser': DB2 user ID that has privileges to create and drop the databases. This parameter is required.
 *   'dbPassword': DB2 password. This parameter is required.
 *   'storageGroup': The storage group for the event and the catalog database. The storage group must already be created and active.
 *   'bufferPool4K': The name of 4K buffer pool. This buffer pool must be active before the database DDL scripts can be run.
 *   'bufferPool8K': The name of 8K buffer pool. This buffer pool must be active before the dabase DDL scripts can be run.
 *   'bufferPool16K': The name of 16K buffer pool. This buffer pool must be active before the database DDL scripts can be run.
 *   'outputScriptDir': Optional database script output directory. When this parameter is specified, the command generates the Event Service database scripts in the specified directory. If the specified directory does not contain a full path, the command creates the specified directory in $profile/bin. The default database script output directory is $profile/databases/event/&lt;node&gt;/&lt;server&gt;/dbscripts/&lt;dbtypes&gt; if this parameter is not specified
 * The required parameters are found in the constructor.
 */
public class ConfigEventServiceDB2ZOSDB extends Command {

	private Boolean createDB = false;
	private Boolean overrideDataSource = false;
	private String nodeName;
	private String serverName;
	private String clusterName;
	private String jdbcClassPath;
	private String dbHostName;
	private Integer dbPort = 5027;
	private String dbAliasName = "event";
	private String dbSubSystemName;
	private String eventDBName = "event";
	private String eventCatalogDBName = "eventcat";
	private Integer dbDiskSizeInMB = 100;
	private String dbUser;
	private String dbPassword;
	private String storageGroup;
	private String bufferPool4K;
	private String bufferPool8K;
	private String bufferPool16K;
	private String outputScriptDir;

	public ConfigEventServiceDB2ZOSDB(String jdbcClassPath, String dbHostName, String dbSubSystemName, String dbUser, String dbPassword, String storageGroup, String bufferPool4K, String bufferPool8K, String bufferPool16K) {
		super("configEventServiceDB2ZOSDB");
		this.jdbcClassPath = jdbcClassPath;
		this.dbHostName = dbHostName;
		this.dbSubSystemName = dbSubSystemName;
		this.dbUser = dbUser;
		this.dbPassword = dbPassword;
		this.storageGroup = storageGroup;
		this.bufferPool4K = bufferPool4K;
		this.bufferPool8K = bufferPool8K;
		this.bufferPool16K = bufferPool16K;
	}

	/**
	 * The command generates the DDL database scripts and creates the database when this parameter is set to true. The command only generates the DDL database scripts when this parameter is set to false. To create the database, the current machine must be already configured to run the database commands. The default value is false if not specified.
	 */
	public Boolean getCreateDB() {
		return this.createDB;
	}

	/**
	 * The command generates the DDL database scripts and creates the database when this parameter is set to true. The command only generates the DDL database scripts when this parameter is set to false. To create the database, the current machine must be already configured to run the database commands. The default value is false if not specified.
	 */
	public void setCreateDB(Boolean value) {
		this.createDB = value;
	}

	/**
	 * When this parameter is set to true, the command removes any existing Event Service data source at the specified scope before creating a new one. When this parameter is set to false, the command does not create an Event Service data source at the specified scope if another Event Service data source is found at the same scope. The default value is false if not specified.
	 */
	public Boolean getOverrideDataSource() {
		return this.overrideDataSource;
	}

	/**
	 * When this parameter is set to true, the command removes any existing Event Service data source at the specified scope before creating a new one. When this parameter is set to false, the command does not create an Event Service data source at the specified scope if another Event Service data source is found at the same scope. The default value is false if not specified.
	 */
	public void setOverrideDataSource(Boolean value) {
		this.overrideDataSource = value;
	}

	/**
	 * The name of the node that contains the server where the Event Service data source should be created. If this parameter is specified, then the serverName parameter must be set. You must not specify this parameter if the clusterName parameter is specified.
	 */
	public String getNodeName() {
		return this.nodeName;
	}

	/**
	 * The name of the node that contains the server where the Event Service data source should be created. If this parameter is specified, then the serverName parameter must be set. You must not specify this parameter if the clusterName parameter is specified.
	 */
	public void setNodeName(String value) {
		this.nodeName = value;
	}

	/**
	 * The name of the server where the Event Service data source should be created. If this parameters is specified without the nodeName parameter, the command will use the node name of the current WebSphere profile. You must not specify this parameter if the clusterName parameter is specified.
	 */
	public String getServerName() {
		return this.serverName;
	}

	/**
	 * The name of the server where the Event Service data source should be created. If this parameters is specified without the nodeName parameter, the command will use the node name of the current WebSphere profile. You must not specify this parameter if the clusterName parameter is specified.
	 */
	public void setServerName(String value) {
		this.serverName = value;
	}

	/**
	 * The name of the cluster where the Event Service data source should be created. If this parameter is specified, then the serverName and nodeName parameters must not be set. You must not specify this parameter if the serverName and nodeName parameters are specified.
	 */
	public String getClusterName() {
		return this.clusterName;
	}

	/**
	 * The name of the cluster where the Event Service data source should be created. If this parameter is specified, then the serverName and nodeName parameters must not be set. You must not specify this parameter if the serverName and nodeName parameters are specified.
	 */
	public void setClusterName(String value) {
		this.clusterName = value;
	}

	/**
	 * The path to the jdbc driver, specify only the directory to the zip or jar file. You must not specify the jar or zip file name in the path. This parameter is required.
	 */
	public String getJdbcClassPath() {
		return this.jdbcClassPath;
	}

	/**
	 * The path to the jdbc driver, specify only the directory to the zip or jar file. You must not specify the jar or zip file name in the path. This parameter is required.
	 */
	public void setJdbcClassPath(String value) {
		this.jdbcClassPath = value;
	}

	/**
	 * The host name of the machine where the database server is installed. This parameter is required.
	 */
	public String getDbHostName() {
		return this.dbHostName;
	}

	/**
	 * The host name of the machine where the database server is installed. This parameter is required.
	 */
	public void setDbHostName(String value) {
		this.dbHostName = value;
	}

	/**
	 * DB2 z/OS instance port. The default value is 5027 if not specified.
	 */
	public Integer getDbPort() {
		return this.dbPort;
	}

	/**
	 * DB2 z/OS instance port. The default value is 5027 if not specified.
	 */
	public void setDbPort(Integer value) {
		this.dbPort = value;
	}

	/**
	 * The name of the cataloged database on the DB2 client machine. This parameter is required when the createDB parameter is set to true.
	 */
	public String getDbAliasName() {
		return this.dbAliasName;
	}

	/**
	 * The name of the cataloged database on the DB2 client machine. This parameter is required when the createDB parameter is set to true.
	 */
	public void setDbAliasName(String value) {
		this.dbAliasName = value;
	}

	/**
	 * The DB2 z/OS subsystem name. This parameter is required.
	 */
	public String getDbSubSystemName() {
		return this.dbSubSystemName;
	}

	/**
	 * The DB2 z/OS subsystem name. This parameter is required.
	 */
	public void setDbSubSystemName(String value) {
		this.dbSubSystemName = value;
	}

	/**
	 * The event database name to be created. The default value is event if not specified .
	 */
	public String getEventDBName() {
		return this.eventDBName;
	}

	/**
	 * The event database name to be created. The default value is event if not specified .
	 */
	public void setEventDBName(String value) {
		this.eventDBName = value;
	}

	/**
	 * The event catalog database to be created. The default value is eventcat if not specified .
	 */
	public String getEventCatalogDBName() {
		return this.eventCatalogDBName;
	}

	/**
	 * The event catalog database to be created. The default value is eventcat if not specified .
	 */
	public void setEventCatalogDBName(String value) {
		this.eventCatalogDBName = value;
	}

	/**
	 * Specify the disk size (must be at least 10) in megabyte (MB) for the Event Service database. The default value is 100 MB if not specified.
	 */
	public Integer getDbDiskSizeInMB() {
		return this.dbDiskSizeInMB;
	}

	/**
	 * Specify the disk size (must be at least 10) in megabyte (MB) for the Event Service database. The default value is 100 MB if not specified.
	 */
	public void setDbDiskSizeInMB(Integer value) {
		this.dbDiskSizeInMB = value;
	}

	/**
	 * DB2 user ID that has privileges to create and drop the databases. This parameter is required.
	 */
	public String getDbUser() {
		return this.dbUser;
	}

	/**
	 * DB2 user ID that has privileges to create and drop the databases. This parameter is required.
	 */
	public void setDbUser(String value) {
		this.dbUser = value;
	}

	/**
	 * DB2 password. This parameter is required.
	 */
	public String getDbPassword() {
		return this.dbPassword;
	}

	/**
	 * DB2 password. This parameter is required.
	 */
	public void setDbPassword(String value) {
		this.dbPassword = value;
	}

	/**
	 * The storage group for the event and the catalog database. The storage group must already be created and active.
	 */
	public String getStorageGroup() {
		return this.storageGroup;
	}

	/**
	 * The storage group for the event and the catalog database. The storage group must already be created and active.
	 */
	public void setStorageGroup(String value) {
		this.storageGroup = value;
	}

	/**
	 * The name of 4K buffer pool. This buffer pool must be active before the database DDL scripts can be run.
	 */
	public String getBufferPool4K() {
		return this.bufferPool4K;
	}

	/**
	 * The name of 4K buffer pool. This buffer pool must be active before the database DDL scripts can be run.
	 */
	public void setBufferPool4K(String value) {
		this.bufferPool4K = value;
	}

	/**
	 * The name of 8K buffer pool. This buffer pool must be active before the dabase DDL scripts can be run.
	 */
	public String getBufferPool8K() {
		return this.bufferPool8K;
	}

	/**
	 * The name of 8K buffer pool. This buffer pool must be active before the dabase DDL scripts can be run.
	 */
	public void setBufferPool8K(String value) {
		this.bufferPool8K = value;
	}

	/**
	 * The name of 16K buffer pool. This buffer pool must be active before the database DDL scripts can be run.
	 */
	public String getBufferPool16K() {
		return this.bufferPool16K;
	}

	/**
	 * The name of 16K buffer pool. This buffer pool must be active before the database DDL scripts can be run.
	 */
	public void setBufferPool16K(String value) {
		this.bufferPool16K = value;
	}

	/**
	 * Optional database script output directory. When this parameter is specified, the command generates the Event Service database scripts in the specified directory. If the specified directory does not contain a full path, the command creates the specified directory in $profile/bin. The default database script output directory is $profile/databases/event/&lt;node&gt;/&lt;server&gt;/dbscripts/&lt;dbtypes&gt; if this parameter is not specified
	 */
	public String getOutputScriptDir() {
		return this.outputScriptDir;
	}

	/**
	 * Optional database script output directory. When this parameter is specified, the command generates the Event Service database scripts in the specified directory. If the specified directory does not contain a full path, the command creates the specified directory in $profile/bin. The default database script output directory is $profile/databases/event/&lt;node&gt;/&lt;server&gt;/dbscripts/&lt;dbtypes&gt; if this parameter is not specified
	 */
	public void setOutputScriptDir(String value) {
		this.outputScriptDir = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.createDB != null) {
			ret.put("createDB", this.createDB);
		}
		if (this.overrideDataSource != null) {
			ret.put("overrideDataSource", this.overrideDataSource);
		}
		if (this.nodeName != null) {
			ret.put("nodeName", this.nodeName);
		}
		if (this.serverName != null) {
			ret.put("serverName", this.serverName);
		}
		if (this.clusterName != null) {
			ret.put("clusterName", this.clusterName);
		}
		ret.put("jdbcClassPath", this.jdbcClassPath);
		ret.put("dbHostName", this.dbHostName);
		if (this.dbPort != null) {
			ret.put("dbPort", this.dbPort);
		}
		if (this.dbAliasName != null) {
			ret.put("dbAliasName", this.dbAliasName);
		}
		ret.put("dbSubSystemName", this.dbSubSystemName);
		if (this.eventDBName != null) {
			ret.put("eventDBName", this.eventDBName);
		}
		if (this.eventCatalogDBName != null) {
			ret.put("eventCatalogDBName", this.eventCatalogDBName);
		}
		if (this.dbDiskSizeInMB != null) {
			ret.put("dbDiskSizeInMB", this.dbDiskSizeInMB);
		}
		ret.put("dbUser", this.dbUser);
		ret.put("dbPassword", this.dbPassword);
		ret.put("storageGroup", this.storageGroup);
		ret.put("bufferPool4K", this.bufferPool4K);
		ret.put("bufferPool8K", this.bufferPool8K);
		ret.put("bufferPool16K", this.bufferPool16K);
		if (this.outputScriptDir != null) {
			ret.put("outputScriptDir", this.outputScriptDir);
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
