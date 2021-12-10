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
 * The configEventServiceOracleDB command creates the Event Service tables and data sources for Oracle on a server or cluster. The command does not create the database; the Oracle SID must already created.
 *   'createDB': The command generates the DDL database scripts and creates the database when this parameter is set to true. The command only generates the DDL database scripts when this parameter is set to false. To create the database, the current machine must be already configured to run the database commands. The default value is false if not specified.
 *   'overrideDataSource': When this parameter is set to true, the command removes any existing Event Service data source at the specified scope before creating a new one. When this parameter is set to false, the command does not create an Event Service data source at the specified scope if another Event Service data source is found at the same scope. The default value is false if not specified.
 *   'nodeName': The name of the node that contains the server where the Event Service data source should be created. If this parameter is specified, then the serverName parameter must be set. You must not specify this parameter if the clusterName parameter is specified.
 *   'serverName': The name of the server where the Event Service data source should be created. If this parameters is specified without the nodeName parameter, the command will use the node name of the current WebSphere profile. You must not specify this parameter if the clusterName parameter is specified.
 *   'clusterName': The name of the cluster where the Event Service data source should be created. If this parameter is specified, then the serverName and nodeName parameters must not be set. You must not specify this parameter if the serverName and nodeName parameters are specified.
 *   'jdbcClassPath': The path to the jdbc driver, specify only the directory to the zip or jar file. You must not specify the jar or zip file name in the path. This parameter is required.
 *   'oracleHome': The directory of the ORACLE_HOME. This parameter must be set when the parameter createDB is set to true.
 *   'dbHostName': The host name of the machine where the Oracle database server is installed. The default value is localhost if not specified.
 *   'dbPort': Oracle instance port. The default value is 1521 if not specified.
 *   'dbName': The Oracle System Identifier (SID), the SID must have been already created and available for the Event Service command to create the tables and populate the tables with data. The default value is orcl if not specified.
 *   'dbUser': The Oracle schema user ID that will own the Event Service Oracle tables. The user ID will be created during the database creation and the WebSphere data source uses this user ID to authenticate the Oracle database connection. The default value is ceiuser if not specified.
 *   'dbPassword': The password of the schema user ID. The password will be created during the database creation, and the WebSphere data source uses this password to authenticate the Oracle database connection. This parameter is required.
 *   'sysUser': Oracle sysUser. sysUser must be a user that has SYSDBA privileges. The default value is sys if not specified.
 *   'sysPassword': The password for the user specified by the sysUser parameter. The default value is empty string if not specified.
 *   'ceiInstancePrefix': The command uses the Event Service instance name to group the database files in a directory with unique names. The default value is ceiinst1 if not specified.
 *   'outputScriptDir': Optional database script output directory. When this parameter is specified, the command generates the Event Service database scripts in the specified directory. If the specified directory does not contain a full path, the command creates the specified directory in $profile/bin. The default database script output directory is $profile/databases/event/&lt;node&gt;/&lt;server&gt;/dbscripts/&lt;dbtypes&gt; if this parameter is not specified
 * The required parameters are found in the constructor.
 */
public class ConfigEventServiceOracleDB extends Command {

	private Boolean createDB = false;
	private Boolean overrideDataSource = false;
	private String nodeName;
	private String serverName;
	private String clusterName;
	private String jdbcClassPath;
	private String oracleHome;
	private String dbHostName = "localhost";
	private Integer dbPort = 1521;
	private String dbName = "orcl";
	private String dbUser = "ceiuser";
	private String dbPassword;
	private String sysUser = "sys";
	private String sysPassword;
	private String ceiInstancePrefix = "ceiinst1";
	private String outputScriptDir;

	public ConfigEventServiceOracleDB(String jdbcClassPath, String dbPassword) {
		super("configEventServiceOracleDB");
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
	 * The directory of the ORACLE_HOME. This parameter must be set when the parameter createDB is set to true.
	 */
	public String getOracleHome() {
		return this.oracleHome;
	}

	/**
	 * The directory of the ORACLE_HOME. This parameter must be set when the parameter createDB is set to true.
	 */
	public void setOracleHome(String value) {
		this.oracleHome = value;
	}

	/**
	 * The host name of the machine where the Oracle database server is installed. The default value is localhost if not specified.
	 */
	public String getDbHostName() {
		return this.dbHostName;
	}

	/**
	 * The host name of the machine where the Oracle database server is installed. The default value is localhost if not specified.
	 */
	public void setDbHostName(String value) {
		this.dbHostName = value;
	}

	/**
	 * Oracle instance port. The default value is 1521 if not specified.
	 */
	public Integer getDbPort() {
		return this.dbPort;
	}

	/**
	 * Oracle instance port. The default value is 1521 if not specified.
	 */
	public void setDbPort(Integer value) {
		this.dbPort = value;
	}

	/**
	 * The Oracle System Identifier (SID), the SID must have been already created and available for the Event Service command to create the tables and populate the tables with data. The default value is orcl if not specified.
	 */
	public String getDbName() {
		return this.dbName;
	}

	/**
	 * The Oracle System Identifier (SID), the SID must have been already created and available for the Event Service command to create the tables and populate the tables with data. The default value is orcl if not specified.
	 */
	public void setDbName(String value) {
		this.dbName = value;
	}

	/**
	 * The Oracle schema user ID that will own the Event Service Oracle tables. The user ID will be created during the database creation and the WebSphere data source uses this user ID to authenticate the Oracle database connection. The default value is ceiuser if not specified.
	 */
	public String getDbUser() {
		return this.dbUser;
	}

	/**
	 * The Oracle schema user ID that will own the Event Service Oracle tables. The user ID will be created during the database creation and the WebSphere data source uses this user ID to authenticate the Oracle database connection. The default value is ceiuser if not specified.
	 */
	public void setDbUser(String value) {
		this.dbUser = value;
	}

	/**
	 * The password of the schema user ID. The password will be created during the database creation, and the WebSphere data source uses this password to authenticate the Oracle database connection. This parameter is required.
	 */
	public String getDbPassword() {
		return this.dbPassword;
	}

	/**
	 * The password of the schema user ID. The password will be created during the database creation, and the WebSphere data source uses this password to authenticate the Oracle database connection. This parameter is required.
	 */
	public void setDbPassword(String value) {
		this.dbPassword = value;
	}

	/**
	 * Oracle sysUser. sysUser must be a user that has SYSDBA privileges. The default value is sys if not specified.
	 */
	public String getSysUser() {
		return this.sysUser;
	}

	/**
	 * Oracle sysUser. sysUser must be a user that has SYSDBA privileges. The default value is sys if not specified.
	 */
	public void setSysUser(String value) {
		this.sysUser = value;
	}

	/**
	 * The password for the user specified by the sysUser parameter. The default value is empty string if not specified.
	 */
	public String getSysPassword() {
		return this.sysPassword;
	}

	/**
	 * The password for the user specified by the sysUser parameter. The default value is empty string if not specified.
	 */
	public void setSysPassword(String value) {
		this.sysPassword = value;
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
		if (this.oracleHome != null) {
			ret.put("oracleHome", this.oracleHome);
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
		if (this.sysUser != null) {
			ret.put("sysUser", this.sysUser);
		}
		if (this.sysPassword != null) {
			ret.put("sysPassword", this.sysPassword);
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
