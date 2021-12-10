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
 * The configEventServiceInformixDB command creates the Event Service database and data sources for Informix on a server or cluster.
 *   'createDB': The command generates the DDL database scripts and creates the database when this parameter is set to true. The command only generates the DDL database scripts when this parameter is set to false. To create the database, the current machine must be already configured to run the database commands. The default value is false if not specified.
 *   'overrideDataSource': When this parameter is set to true, the command removes any existing Event Service data source at the specified scope before creating a new one. When this parameter is set to false, the command does not create an Event Service data source at the specified scope if another Event Service data source is found at the same scope. The default value is false if not specified.
 *   'nodeName': The name of the node that contains the server where the Event Service data source should be created. If this parameter is specified, then the serverName parameter must be set. You must not specify this parameter if the clusterName parameter is specified.
 *   'serverName': The name of the server where the Event Service data source should be created. If this parameters is specified without the nodeName parameter, the command will use the node name of the current WebSphere profile. You must not specify this parameter if the clusterName parameter is specified.
 *   'clusterName': The name of the cluster where the Event Service data source should be created. If this parameter is specified, then the serverName and nodeName parameters must not be set. You must not specify this parameter if the serverName and nodeName parameters are specified.
 *   'jdbcClassPath': The path to the jdbc driver, specify only the directory to the zip or jar file. You must not specify the jar or zip file name in the path. This parameter is required.
 *   'dbInformixDir': The directory where the Informix database is installed. This parameter must be specified when the parameter createDB is set to true. This parameter is required.
 *   'dbHostName': The host name of the machine where the database server is installed. This parameter is required.
 *   'dbServerName': Informix server instance name (for example, ol_servername). This parameter is required.
 *   'dbPort': Informix instance port. The default value is 1526 if not specified.
 *   'dbName': The database name to be created. The default value is event if not specified.
 *   'dbUser': The Informix database schema user ID that will own the Event Service database tables. The WebSphere data source uses this user ID to authenticate the Informix database connection. This parameter is required.
 *   'dbPassword': The password of the schema user ID that owns the Event Service Informix tables. The WebSphere data source uses this password to authenticate the Informix database connection. This parameter is required.
 *   'ceiInstancePrefix': The command uses the Event Service instance name to group the database files in a directory with unique names. The default value is ceiinst1 if not specified.
 *   'outputScriptDir': Optional database script output directory. When this parameter is specified, the command generates the Event Service database scripts in the specified directory. If the specified directory does not contain a full path, the command creates the specified directory in $profile/bin. The default database script output directory is $profile/databases/event/&lt;node&gt;/&lt;server&gt;/dbscripts/&lt;dbtypes&gt; if this parameter is not specified
 * The required parameters are found in the constructor.
 */
public class ConfigEventServiceInformixDB extends Command {

	private Boolean createDB = false;
	private Boolean overrideDataSource = false;
	private String nodeName;
	private String serverName;
	private String clusterName;
	private String jdbcClassPath;
	private String dbInformixDir;
	private String dbHostName;
	private String dbServerName;
	private Integer dbPort = 1526;
	private String dbName = "event";
	private String dbUser = "informix";
	private String dbPassword;
	private String ceiInstancePrefix = "ceiinst1";
	private String outputScriptDir;

	public ConfigEventServiceInformixDB(String jdbcClassPath, String dbHostName, String dbServerName, String dbPassword) {
		super("configEventServiceInformixDB");
		this.jdbcClassPath = jdbcClassPath;
		this.dbHostName = dbHostName;
		this.dbServerName = dbServerName;
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
	 * The directory where the Informix database is installed. This parameter must be specified when the parameter createDB is set to true. This parameter is required.
	 */
	public String getDbInformixDir() {
		return this.dbInformixDir;
	}

	/**
	 * The directory where the Informix database is installed. This parameter must be specified when the parameter createDB is set to true. This parameter is required.
	 */
	public void setDbInformixDir(String value) {
		this.dbInformixDir = value;
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
	 * Informix server instance name (for example, ol_servername). This parameter is required.
	 */
	public String getDbServerName() {
		return this.dbServerName;
	}

	/**
	 * Informix server instance name (for example, ol_servername). This parameter is required.
	 */
	public void setDbServerName(String value) {
		this.dbServerName = value;
	}

	/**
	 * Informix instance port. The default value is 1526 if not specified.
	 */
	public Integer getDbPort() {
		return this.dbPort;
	}

	/**
	 * Informix instance port. The default value is 1526 if not specified.
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
	 * The Informix database schema user ID that will own the Event Service database tables. The WebSphere data source uses this user ID to authenticate the Informix database connection. This parameter is required.
	 */
	public String getDbUser() {
		return this.dbUser;
	}

	/**
	 * The Informix database schema user ID that will own the Event Service database tables. The WebSphere data source uses this user ID to authenticate the Informix database connection. This parameter is required.
	 */
	public void setDbUser(String value) {
		this.dbUser = value;
	}

	/**
	 * The password of the schema user ID that owns the Event Service Informix tables. The WebSphere data source uses this password to authenticate the Informix database connection. This parameter is required.
	 */
	public String getDbPassword() {
		return this.dbPassword;
	}

	/**
	 * The password of the schema user ID that owns the Event Service Informix tables. The WebSphere data source uses this password to authenticate the Informix database connection. This parameter is required.
	 */
	public void setDbPassword(String value) {
		this.dbPassword = value;
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
		if (this.dbInformixDir != null) {
			ret.put("dbInformixDir", this.dbInformixDir);
		}
		ret.put("dbHostName", this.dbHostName);
		ret.put("dbServerName", this.dbServerName);
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
