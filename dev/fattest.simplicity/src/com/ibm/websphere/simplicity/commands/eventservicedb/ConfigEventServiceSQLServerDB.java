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
 * The configEventServiceSQLServerDB command creates the Event Service database and data sources for SQL Server on a server or cluster.
 *   'createDB': The command generates the DDL database scripts and creates the database when this parameter is set to true. The command only generates the DDL database scripts when this parameter is set to false. To create the database, the current machine must be already configured to run the database commands. The default value is false if not specified.
 *   'overrideDataSource': When this parameter is set to true, the command removes any existing Event Service data source at the specified scope before creating a new one. When this parameter is set to false, the command does not create an Event Service data source at the specified scope if another Event Service data source is found at the same scope. The default value is false if not specified.
 *   'nodeName': The name of the node that contains the server where the Event Service data source should be created. If this parameter is specified, then the serverName parameter must be set. You must not specify this parameter if the clusterName parameter is specified.
 *   'serverName': The name of the server where the Event Service data source should be created. If this parameters is specified without the nodeName parameter, the command will use the node name of the current WebSphere profile. You must not specify this parameter if the clusterName parameter is specified.
 *   'clusterName': The name of the cluster where the Event Service data source should be created. If this parameter is specified, then the serverName and nodeName parameters must not be set. You must not specify this parameter if the serverName and nodeName parameters are specified.
 *   'jdbcClassPath': The path to the jdbc driver, specify only the directory to the zip or jar file. You must not specify the jar or zip file name in the path. This parameter is required.
 *   'dbServerName': The server name of the SQL Server database. This parameter must be set when the parameter createDB is set to true.
 *   'dbHostName': The host name of the machine where the SQL Server database is running.
 *   'dbPort': SQL Server instance port. The default value is 1433 if not specified.
 *   'dbName': The database name to be created. The default value is event if not specified.
 *   'dbUser': The SQL Server user ID that will own the Event Service tables. The default value is ceiuser if not specified.
 *   'dbPassword': The password of the SQL Server user ID specified by the dbUser parameter. This parameter is required.
 *   'saUser': User ID that has privileges to create, drop the databases and users. This parameter is required when the createDB parameter is set to true. The default value is sa if not specified.
 *   'saPassword': The sa password. You must not specify this parameter if the sa user ID does not have a password.
 *   'ceiInstancePrefix': The command uses the Event Service instance name to group the database files in a directory with unique names. The default value is ceiinst1 if not specified.
 *   'outputScriptDir': Optional database script output directory. When this parameter is specified, the command generates the Event Service database scripts in the specified directory. If the specified directory does not contain a full path, the command creates the specified directory in $profile/bin. The default database script output directory is $profile/databases/event/&lt;node&gt;/&lt;server&gt;/dbscripts/&lt;dbtypes&gt; if this parameter is not specified
 * The required parameters are found in the constructor.
 */
public class ConfigEventServiceSQLServerDB extends Command {

	private Boolean createDB = false;
	private Boolean overrideDataSource = false;
	private String nodeName;
	private String serverName;
	private String clusterName;
	private String jdbcClassPath;
	private String dbServerName;
	private String dbHostName = "localhost";
	private Integer dbPort = 1433;
	private String dbName = "event";
	private String dbUser = "ceiuser";
	private String dbPassword;
	private String saUser = "sa";
	private String saPassword;
	private String ceiInstancePrefix = "ceiinst1";
	private String outputScriptDir;

	public ConfigEventServiceSQLServerDB(String jdbcClassPath, String dbPassword) {
		super("configEventServiceSQLServerDB");
		this.jdbcClassPath = jdbcClassPath;
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
	 * The server name of the SQL Server database. This parameter must be set when the parameter createDB is set to true.
	 */
	public String getDbServerName() {
		return this.dbServerName;
	}

	/**
	 * The server name of the SQL Server database. This parameter must be set when the parameter createDB is set to true.
	 */
	public void setDbServerName(String value) {
		this.dbServerName = value;
	}

	/**
	 * The host name of the machine where the SQL Server database is running.
	 */
	public String getDbHostName() {
		return this.dbHostName;
	}

	/**
	 * The host name of the machine where the SQL Server database is running.
	 */
	public void setDbHostName(String value) {
		this.dbHostName = value;
	}

	/**
	 * SQL Server instance port. The default value is 1433 if not specified.
	 */
	public Integer getDbPort() {
		return this.dbPort;
	}

	/**
	 * SQL Server instance port. The default value is 1433 if not specified.
	 */
	public void setDbPort(Integer value) {
		this.dbPort = value;
	}

	/**
	 * The database name to be created. The default value is event if not specified.
	 */
	public String getDbName() {
		return this.dbName;
	}

	/**
	 * The database name to be created. The default value is event if not specified.
	 */
	public void setDbName(String value) {
		this.dbName = value;
	}

	/**
	 * The SQL Server user ID that will own the Event Service tables. The default value is ceiuser if not specified.
	 */
	public String getDbUser() {
		return this.dbUser;
	}

	/**
	 * The SQL Server user ID that will own the Event Service tables. The default value is ceiuser if not specified.
	 */
	public void setDbUser(String value) {
		this.dbUser = value;
	}

	/**
	 * The password of the SQL Server user ID specified by the dbUser parameter. This parameter is required.
	 */
	public String getDbPassword() {
		return this.dbPassword;
	}

	/**
	 * The password of the SQL Server user ID specified by the dbUser parameter. This parameter is required.
	 */
	public void setDbPassword(String value) {
		this.dbPassword = value;
	}

	/**
	 * User ID that has privileges to create, drop the databases and users. This parameter is required when the createDB parameter is set to true. The default value is sa if not specified.
	 */
	public String getSaUser() {
		return this.saUser;
	}

	/**
	 * User ID that has privileges to create, drop the databases and users. This parameter is required when the createDB parameter is set to true. The default value is sa if not specified.
	 */
	public void setSaUser(String value) {
		this.saUser = value;
	}

	/**
	 * The sa password. You must not specify this parameter if the sa user ID does not have a password.
	 */
	public String getSaPassword() {
		return this.saPassword;
	}

	/**
	 * The sa password. You must not specify this parameter if the sa user ID does not have a password.
	 */
	public void setSaPassword(String value) {
		this.saPassword = value;
	}

	/**
	 * The command uses the Event Service instance name to group the database files in a directory with unique names. The default value is ceiinst1 if not specified.
	 */
	public String getCeiInstancePrefix() {
		return this.ceiInstancePrefix;
	}

	/**
	 * The command uses the Event Service instance name to group the database files in a directory with unique names. The default value is ceiinst1 if not specified.
	 */
	public void setCeiInstancePrefix(String value) {
		this.ceiInstancePrefix = value;
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
		if (this.dbServerName != null) {
			ret.put("dbServerName", this.dbServerName);
		}
		if (this.dbHostName != null) {
			ret.put("dbHostName", this.dbHostName);
		}
		if (this.dbPort != null) {
			ret.put("dbPort", this.dbPort);
		}
		if (this.dbName != null) {
			ret.put("dbName", this.dbName);
		}
		if (this.dbUser != null) {
			ret.put("dbUser", this.dbUser);
		}
		ret.put("dbPassword", this.dbPassword);
		if (this.saUser != null) {
			ret.put("saUser", this.saUser);
		}
		if (this.saPassword != null) {
			ret.put("saPassword", this.saPassword);
		}
		if (this.ceiInstancePrefix != null) {
			ret.put("ceiInstancePrefix", this.ceiInstancePrefix);
		}
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
