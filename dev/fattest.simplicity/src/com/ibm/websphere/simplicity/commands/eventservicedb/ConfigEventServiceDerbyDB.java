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
 * The configEventServiceDerbyDB command creates the Event Service database and data sources for Derby on a server or cluster.
 *   'createDB': The command generates the DDL database scripts and creates the database when this parameter is set to true. The command only generates the DDL database scripts when this parameter is set to false. To create the database, the current machine must be already configured to run the database commands. The default value is false if not specified.
 *   'overrideDataSource': When this parameter is set to true, the command removes any existing Event Service data source at the specified scope before creating a new one. When this parameter is set to false, the command does not create an Event Service data source at the specified scope if another Event Service data source is found at the same scope. The default value is false if not specified.
 *   'nodeName': The name of the node that contains the server where the Event Service data source should be created. If this parameter is specified, then the serverName parameter must be set. You must not specify this parameter if the clusterName parameter is specified.
 *   'serverName': The name of the server where the Event Service data source should be created. If this parameters is specified without the nodeName parameter, the command will use the node name of the current WebSphere profile. You must not specify this parameter if the clusterName parameter is specified.
 *   'clusterName': The name of the cluster where the Event Service data source should be created. If this parameter is specified, then the serverName and nodeName parameters must not be set. You must not specify this parameter if the serverName and nodeName parameters are specified.
 *   'dbHostName': The host name of the network Derby database. To create the Derby network data source, specify this parameter and the dbPort parameter. To create the Derby local data source, do not specify this parameter and the dbPort parameter.
 *   'dbPort': The port number of the network Derby database. To create the Derby network data source, specify this parameter and the dbHostName parameter. To create the Derby local data source, do not specify this parameter and the dbHostName parameter.
 *   'dbName': The database name to be created. The default value is event if not specified.
 *   'dbUser': The user ID used by the data source for the Derby database authentication. This parameter is optional when the WebSphere domain security is disabled. If you specify this parameter, you also must specify the dbPassword parameter. This parameter is required when the WebSphere domain security is enabled.
 *   'dbPassword': The password used by the data source for the Derby database authentication. This parameter is optional when the WebSphere domain security is disabled. If you specify this parameter, you also must specify the dbUser parameter. This parameter is required when the WebSphere domain security is enabled.
 *   'dbPath': The directory where the existing database is located.
 *   'outputScriptDir': Optional database script output directory. When this parameter is specified, the command generates the Event Service database scripts in the specified directory. If the specified directory does not contain a full path, the command creates the specified directory in $profile/bin. The default database script output directory is $profile/databases/event/&lt;node&gt;/&lt;server&gt;/dbscripts/&lt;dbtypes&gt; if this parameter is not specified
 * The required parameters are found in the constructor.
 */
public class ConfigEventServiceDerbyDB extends Command {

	private Boolean createDB = false;
	private Boolean overrideDataSource = false;
	private String nodeName;
	private String serverName;
	private String clusterName;
	private String dbHostName;
	private Integer dbPort;
	private String dbName = "event";
	private String dbUser;
	private String dbPassword;
	private String dbPath;
	private String outputScriptDir;

	public ConfigEventServiceDerbyDB() {
		super("configEventServiceDerbyDB");
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
	 * The host name of the network Derby database. To create the Derby network data source, specify this parameter and the dbPort parameter. To create the Derby local data source, do not specify this parameter and the dbPort parameter.
	 */
	public String getDbHostName() {
		return this.dbHostName;
	}

	/**
	 * The host name of the network Derby database. To create the Derby network data source, specify this parameter and the dbPort parameter. To create the Derby local data source, do not specify this parameter and the dbPort parameter.
	 */
	public void setDbHostName(String value) {
		this.dbHostName = value;
	}

	/**
	 * The port number of the network Derby database. To create the Derby network data source, specify this parameter and the dbHostName parameter. To create the Derby local data source, do not specify this parameter and the dbHostName parameter.
	 */
	public Integer getDbPort() {
		return this.dbPort;
	}

	/**
	 * The port number of the network Derby database. To create the Derby network data source, specify this parameter and the dbHostName parameter. To create the Derby local data source, do not specify this parameter and the dbHostName parameter.
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
	 * The user ID used by the data source for the Derby database authentication. This parameter is optional when the WebSphere domain security is disabled. If you specify this parameter, you also must specify the dbPassword parameter. This parameter is required when the WebSphere domain security is enabled.
	 */
	public String getDbUser() {
		return this.dbUser;
	}

	/**
	 * The user ID used by the data source for the Derby database authentication. This parameter is optional when the WebSphere domain security is disabled. If you specify this parameter, you also must specify the dbPassword parameter. This parameter is required when the WebSphere domain security is enabled.
	 */
	public void setDbUser(String value) {
		this.dbUser = value;
	}

	/**
	 * The password used by the data source for the Derby database authentication. This parameter is optional when the WebSphere domain security is disabled. If you specify this parameter, you also must specify the dbUser parameter. This parameter is required when the WebSphere domain security is enabled.
	 */
	public String getDbPassword() {
		return this.dbPassword;
	}

	/**
	 * The password used by the data source for the Derby database authentication. This parameter is optional when the WebSphere domain security is disabled. If you specify this parameter, you also must specify the dbUser parameter. This parameter is required when the WebSphere domain security is enabled.
	 */
	public void setDbPassword(String value) {
		this.dbPassword = value;
	}

	/**
	 * The directory where the existing database is located.
	 */
	public String getDbPath() {
		return this.dbPath;
	}

	/**
	 * The directory where the existing database is located.
	 */
	public void setDbPath(String value) {
		this.dbPath = value;
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
		if (this.dbPassword != null) {
			ret.put("dbPassword", this.dbPassword);
		}
		if (this.dbPath != null) {
			ret.put("dbPath", this.dbPath);
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
