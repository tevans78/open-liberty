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
 * The configEventServiceDB2iSeriesDB command generates the DDL database scripts, creates the Event Service database for DB2 iSeries on the native platform and creates data sources on a server or cluster.
 *   'createDB': The command generates the DDL database scripts and creates the database when this parameter is set to true. The command only generates the DDL database scripts when this parameter is set to false. To create the database, the current machine must be already configured to run the database commands. The default value is false if not specified.
 *   'overrideDataSource': When this parameter is set to true, the command removes any existing Event Service data source at the specified scope before creating a new one. When this parameter is set to false, the command does not create an Event Service data source at the specified scope if another Event Service data source is found at the same scope. The default value is false if not specified.
 *   'nodeName': The name of the node that contains the server where the Event Service data source should be created. If this parameter is specified, then the serverName parameter must be set. You must not specify this parameter if the clusterName parameter is specified.
 *   'serverName': The name of the server where the Event Service data source should be created. If this parameters is specified without the nodeName parameter, the command will use the node name of the current WebSphere profile. You must not specify this parameter if the clusterName parameter is specified.
 *   'clusterName': The name of the cluster where the Event Service data source should be created. If this parameter is specified, then the serverName and nodeName parameters must not be set. You must not specify this parameter if the serverName and nodeName parameters are specified.
 *   'toolboxJdbcClassPath': The path to the DB2 OS400 Toolbox jdbc driver. Specify only the directory to the zip or jar file. You must not specify the jt400.jar in the path. You must choose either the toolbox JDBC driver or the native JDBC driver.
 *   'nativeJdbcClassPath': The path to the DB2iSeries native jdbc driver. Specify only the directory to the zip or jar file. You must not specify the db2_classes.jar in the path. You must choose either the toolbox JDBC driver or the native JDBC driver.
 *   'dbHostName': The host name of the machine where the DB2 for iSeries database server is installed. This parameter is required when the toolboxJdbcClassPath parameter is set.
 *   'dbName': The DB2 iSeries database name. The default value is *LOCAL if not specified.
 *   'collection': DB2 iSeries library SQL collection. The maximum length for the collection name is 10 characters. The default value is event if not specified.
 *   'dbUser': DB2 user ID that has privileges to create and drop the databases. This parameter is required.
 *   'dbPassword': Password of the database user ID.
 *   'outputScriptDir': Optional database script output directory. When this parameter is specified, the command generates the Event Service database scripts in the specified directory. If the specified directory does not contain a full path, the command creates the specified directory in $profile/bin. The default database script output directory is $profile/databases/event/&lt;node&gt;/&lt;server&gt;/dbscripts/&lt;dbtypes&gt; if this parameter is not specified
 * The required parameters are found in the constructor.
 */
public class ConfigEventServiceDB2iSeriesDB extends Command {

	private Boolean createDB = false;
	private Boolean overrideDataSource = false;
	private String nodeName;
	private String serverName;
	private String clusterName;
	private String toolboxJdbcClassPath;
	private String nativeJdbcClassPath;
	private String dbHostName;
	private String dbName = "*LOCAL";
	private String collection = "event";
	private String dbUser;
	private String dbPassword;
	private String outputScriptDir;

	public ConfigEventServiceDB2iSeriesDB(String dbUser, String dbPassword) {
		super("configEventServiceDB2iSeriesDB");
		this.dbUser = dbUser;
		this.dbPassword = dbPassword;
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
	 * The path to the DB2 OS400 Toolbox jdbc driver. Specify only the directory to the zip or jar file. You must not specify the jt400.jar in the path. You must choose either the toolbox JDBC driver or the native JDBC driver.
	 */
	public String getToolboxJdbcClassPath() {
		return this.toolboxJdbcClassPath;
	}

	/**
	 * The path to the DB2 OS400 Toolbox jdbc driver. Specify only the directory to the zip or jar file. You must not specify the jt400.jar in the path. You must choose either the toolbox JDBC driver or the native JDBC driver.
	 */
	public void setToolboxJdbcClassPath(String value) {
		this.toolboxJdbcClassPath = value;
	}

	/**
	 * The path to the DB2iSeries native jdbc driver. Specify only the directory to the zip or jar file. You must not specify the db2_classes.jar in the path. You must choose either the toolbox JDBC driver or the native JDBC driver.
	 */
	public String getNativeJdbcClassPath() {
		return this.nativeJdbcClassPath;
	}

	/**
	 * The path to the DB2iSeries native jdbc driver. Specify only the directory to the zip or jar file. You must not specify the db2_classes.jar in the path. You must choose either the toolbox JDBC driver or the native JDBC driver.
	 */
	public void setNativeJdbcClassPath(String value) {
		this.nativeJdbcClassPath = value;
	}

	/**
	 * The host name of the machine where the DB2 for iSeries database server is installed. This parameter is required when the toolboxJdbcClassPath parameter is set.
	 */
	public String getDbHostName() {
		return this.dbHostName;
	}

	/**
	 * The host name of the machine where the DB2 for iSeries database server is installed. This parameter is required when the toolboxJdbcClassPath parameter is set.
	 */
	public void setDbHostName(String value) {
		this.dbHostName = value;
	}

	/**
	 * The DB2 iSeries database name. The default value is *LOCAL if not specified.
	 */
	public String getDbName() {
		return this.dbName;
	}

	/**
	 * The DB2 iSeries database name. The default value is *LOCAL if not specified.
	 */
	public void setDbName(String value) {
		this.dbName = value;
	}

	/**
	 * DB2 iSeries library SQL collection. The maximum length for the collection name is 10 characters. The default value is event if not specified.
	 */
	public String getCollection() {
		return this.collection;
	}

	/**
	 * DB2 iSeries library SQL collection. The maximum length for the collection name is 10 characters. The default value is event if not specified.
	 */
	public void setCollection(String value) {
		this.collection = value;
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
	 * Password of the database user ID.
	 */
	public String getDbPassword() {
		return this.dbPassword;
	}

	/**
	 * Password of the database user ID.
	 */
	public void setDbPassword(String value) {
		this.dbPassword = value;
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
		if (this.toolboxJdbcClassPath != null) {
			ret.put("toolboxJdbcClassPath", this.toolboxJdbcClassPath);
		}
		if (this.nativeJdbcClassPath != null) {
			ret.put("nativeJdbcClassPath", this.nativeJdbcClassPath);
		}
		if (this.dbHostName != null) {
			ret.put("dbHostName", this.dbHostName);
		}
		if (this.dbName != null) {
			ret.put("dbName", this.dbName);
		}
		if (this.collection != null) {
			ret.put("collection", this.collection);
		}
		ret.put("dbUser", this.dbUser);
		ret.put("dbPassword", this.dbPassword);
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
