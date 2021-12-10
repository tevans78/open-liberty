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
 * The configEventServiceSybaseDB command creates the Event Service database and data sources for Sybase on a server or cluster.
 *   'createDB': The command generates the DDL database scripts and creates the database when this parameter is set to true. The command only generates the DDL database scripts when this parameter is set to false. To create the database, the current machine must be already configured to run the database commands. The default value is false if not specified.
 *   'overrideDataSource': When this parameter is set to true, the command removes any existing Event Service data source at the specified scope before creating a new one. When this parameter is set to false, the command does not create an Event Service data source at the specified scope if another Event Service data source is found at the same scope. The default value is false if not specified.
 *   'nodeName': The name of the node that contains the server where the Event Service data source should be created. If this parameter is specified, then the serverName parameter must be set. You must not specify this parameter if the clusterName parameter is specified.
 *   'serverName': The name of the server where the Event Service data source should be created. If this parameters is specified without the nodeName parameter, the command will use the node name of the current WebSphere profile. You must not specify this parameter if the clusterName parameter is specified.
 *   'clusterName': The name of the cluster where the Event Service data source should be created. If this parameter is specified, then the serverName and nodeName parameters must not be set. You must not specify this parameter if the serverName and nodeName parameters are specified.
 *   'jdbcClassPath': The path to the jdbc driver, specify only the directory to the zip or jar file. You must not specify the jar or zip file name in the path. This parameter is required.
 *   'dbInstallDir': The directory where Sybase database is installed. This parameter must be set when the parameter createDB is set to true.
 *   'dbServerName': The name of the Sybase server instance. The server is defined in the Sybase configuration. This parameter is required.
 *   'dbHostName': The host name of the machine where Sybase is running. This parameter is required.
 *   'dbPort': Sybase instance port. The default value is 5000 if not specified.
 *   'dbName': The database name to be created. The default value is event if not specified.
 *   'firstDeviceNumber': The event database creates six devices. This parameter identifies the value of the first device number that should be assigned to the new devices. This parameter must be set when the parameter createDB is set to true. The default value is 10 if not specified.
 *   'dbCacheSizeInMB': The memory cache size will be used for transaction logs. This parameter must be set when the parameter createDB is set to true. . The lowest value can be set is 10. The default value is 10 MB if not specified.
 *   'dbDiskSizeInMB': The database size in MB to be created for the Event Service. This parameter must be set when the parameter createDB is set to true. The lowest value can be set is 100. The default value is 100 MB if not specified.
 *   'dbUser': The user ID that will own the Event Service Sybase tables. The WebSphere data source uses this user ID to authenticate the Sybase database connection. The default value is ceiuser if not specified.
 *   'dbPassword': The password of the user ID that owns the Event Service Sybase tables. The WebSphere data source uses this password to authenticate the Sybase database connection. This parameter is required.
 *   'createLogin': The configEventServiceSybaseDB command creates the login user ID that will own the Event Service Sybase tables when this parameter is set to true. The command does not create the user ID when the parameter is set to false. The default value is true if not specified.
 *   'saUser': The Sybase sa userid that has privileges to create tables and users. The default value is sa if not specified.
 *   'saPassword': The password of the Sybase sa user ID. You must not specify this parameter if the sa user ID does not have a password.
 *   'ceiInstancePrefix': The command uses the Event Service instance name to group the database files in a directory with unique names. The default value is ceiinst1 if not specified.
 *   'outputScriptDir': Optional database script output directory. When this parameter is specified, the command generates the Event Service database scripts in the specified directory. If the specified directory does not contain a full path, the command creates the specified directory in $profile/bin. The default database script output directory is $profile/databases/event/&lt;node&gt;/&lt;server&gt;/dbscripts/&lt;dbtypes&gt; if this parameter is not specified
 * The required parameters are found in the constructor.
 */
public class ConfigEventServiceSybaseDB extends Command {

	private Boolean createDB = false;
	private Boolean overrideDataSource = false;
	private String nodeName;
	private String serverName;
	private String clusterName;
	private String jdbcClassPath;
	private String dbInstallDir;
	private String dbServerName;
	private String dbHostName;
	private Integer dbPort = 5000;
	private String dbName = "event";
	private Integer firstDeviceNumber = 10;
	private Integer dbCacheSizeInMB = 10;
	private Integer dbDiskSizeInMB = 100;
	private String dbUser = "ceiuser";
	private String dbPassword;
	private Boolean createLogin = true;
	private String saUser = "sa";
	private String saPassword;
	private String ceiInstancePrefix = "ceiinst1";
	private String outputScriptDir;

	public ConfigEventServiceSybaseDB(String jdbcClassPath, String dbInstallDir, String dbServerName, String dbHostName, String dbPassword) {
		super("configEventServiceSybaseDB");
		this.jdbcClassPath = jdbcClassPath;
		this.dbInstallDir = dbInstallDir;
		this.dbServerName = dbServerName;
		this.dbHostName = dbHostName;
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
	 * The directory where Sybase database is installed. This parameter must be set when the parameter createDB is set to true.
	 */
	public String getDbInstallDir() {
		return this.dbInstallDir;
	}

	/**
	 * The directory where Sybase database is installed. This parameter must be set when the parameter createDB is set to true.
	 */
	public void setDbInstallDir(String value) {
		this.dbInstallDir = value;
	}

	/**
	 * The name of the Sybase server instance. The server is defined in the Sybase configuration. This parameter is required.
	 */
	public String getDbServerName() {
		return this.dbServerName;
	}

	/**
	 * The name of the Sybase server instance. The server is defined in the Sybase configuration. This parameter is required.
	 */
	public void setDbServerName(String value) {
		this.dbServerName = value;
	}

	/**
	 * The host name of the machine where Sybase is running. This parameter is required.
	 */
	public String getDbHostName() {
		return this.dbHostName;
	}

	/**
	 * The host name of the machine where Sybase is running. This parameter is required.
	 */
	public void setDbHostName(String value) {
		this.dbHostName = value;
	}

	/**
	 * Sybase instance port. The default value is 5000 if not specified.
	 */
	public Integer getDbPort() {
		return this.dbPort;
	}

	/**
	 * Sybase instance port. The default value is 5000 if not specified.
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
	 * The event database creates six devices. This parameter identifies the value of the first device number that should be assigned to the new devices. This parameter must be set when the parameter createDB is set to true. The default value is 10 if not specified.
	 */
	public Integer getFirstDeviceNumber() {
		return this.firstDeviceNumber;
	}

	/**
	 * The event database creates six devices. This parameter identifies the value of the first device number that should be assigned to the new devices. This parameter must be set when the parameter createDB is set to true. The default value is 10 if not specified.
	 */
	public void setFirstDeviceNumber(Integer value) {
		this.firstDeviceNumber = value;
	}

	/**
	 * The memory cache size will be used for transaction logs. This parameter must be set when the parameter createDB is set to true. . The lowest value can be set is 10. The default value is 10 MB if not specified.
	 */
	public Integer getDbCacheSizeInMB() {
		return this.dbCacheSizeInMB;
	}

	/**
	 * The memory cache size will be used for transaction logs. This parameter must be set when the parameter createDB is set to true. . The lowest value can be set is 10. The default value is 10 MB if not specified.
	 */
	public void setDbCacheSizeInMB(Integer value) {
		this.dbCacheSizeInMB = value;
	}

	/**
	 * The database size in MB to be created for the Event Service. This parameter must be set when the parameter createDB is set to true. The lowest value can be set is 100. The default value is 100 MB if not specified.
	 */
	public Integer getDbDiskSizeInMB() {
		return this.dbDiskSizeInMB;
	}

	/**
	 * The database size in MB to be created for the Event Service. This parameter must be set when the parameter createDB is set to true. The lowest value can be set is 100. The default value is 100 MB if not specified.
	 */
	public void setDbDiskSizeInMB(Integer value) {
		this.dbDiskSizeInMB = value;
	}

	/**
	 * The user ID that will own the Event Service Sybase tables. The WebSphere data source uses this user ID to authenticate the Sybase database connection. The default value is ceiuser if not specified.
	 */
	public String getDbUser() {
		return this.dbUser;
	}

	/**
	 * The user ID that will own the Event Service Sybase tables. The WebSphere data source uses this user ID to authenticate the Sybase database connection. The default value is ceiuser if not specified.
	 */
	public void setDbUser(String value) {
		this.dbUser = value;
	}

	/**
	 * The password of the user ID that owns the Event Service Sybase tables. The WebSphere data source uses this password to authenticate the Sybase database connection. This parameter is required.
	 */
	public String getDbPassword() {
		return this.dbPassword;
	}

	/**
	 * The password of the user ID that owns the Event Service Sybase tables. The WebSphere data source uses this password to authenticate the Sybase database connection. This parameter is required.
	 */
	public void setDbPassword(String value) {
		this.dbPassword = value;
	}

	/**
	 * The configEventServiceSybaseDB command creates the login user ID that will own the Event Service Sybase tables when this parameter is set to true. The command does not create the user ID when the parameter is set to false. The default value is true if not specified.
	 */
	public Boolean getCreateLogin() {
		return this.createLogin;
	}

	/**
	 * The configEventServiceSybaseDB command creates the login user ID that will own the Event Service Sybase tables when this parameter is set to true. The command does not create the user ID when the parameter is set to false. The default value is true if not specified.
	 */
	public void setCreateLogin(Boolean value) {
		this.createLogin = value;
	}

	/**
	 * The Sybase sa userid that has privileges to create tables and users. The default value is sa if not specified.
	 */
	public String getSaUser() {
		return this.saUser;
	}

	/**
	 * The Sybase sa userid that has privileges to create tables and users. The default value is sa if not specified.
	 */
	public void setSaUser(String value) {
		this.saUser = value;
	}

	/**
	 * The password of the Sybase sa user ID. You must not specify this parameter if the sa user ID does not have a password.
	 */
	public String getSaPassword() {
		return this.saPassword;
	}

	/**
	 * The password of the Sybase sa user ID. You must not specify this parameter if the sa user ID does not have a password.
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
		ret.put("dbInstallDir", this.dbInstallDir);
		ret.put("dbServerName", this.dbServerName);
		ret.put("dbHostName", this.dbHostName);
		if (this.dbPort != null) {
			ret.put("dbPort", this.dbPort);
		}
		if (this.dbName != null) {
			ret.put("dbName", this.dbName);
		}
		if (this.firstDeviceNumber != null) {
			ret.put("firstDeviceNumber", this.firstDeviceNumber);
		}
		if (this.dbCacheSizeInMB != null) {
			ret.put("dbCacheSizeInMB", this.dbCacheSizeInMB);
		}
		if (this.dbDiskSizeInMB != null) {
			ret.put("dbDiskSizeInMB", this.dbDiskSizeInMB);
		}
		if (this.dbUser != null) {
			ret.put("dbUser", this.dbUser);
		}
		ret.put("dbPassword", this.dbPassword);
		if (this.createLogin != null) {
			ret.put("createLogin", this.createLogin);
		}
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
