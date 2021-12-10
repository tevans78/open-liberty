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

package com.ibm.websphere.simplicity.commands.sibadmin;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;
import java.util.ArrayList;
import com.ibm.websphere.simplicity.commands.CommandStep;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Create a messaging engine.
 *   'bus': The name of the bus to which the messaging engine is to belong.
 *   'node': To create a messaging engine on a server, supply node and server name, but not cluster name.
 *   'server': To create a messaging engine on a server, supply node and server name, but not cluster name.
 *   'cluster': To create a messaging engine on a cluster, supply cluster name, but not node and server name.
 *   'description': Description of the messaging engine.
 *   'initialState': Whether the messaging engine is started or stopped when the associated application server is first started. Until started, the messaging engine is unavailable. (Stopped | Started).
 *   'highMessageThreshold': The maximum total number of messages that the messaging engine can place on its message points.
 *   'defaultBlockedRetryTimeout': The default blocked retry interval for destinations owned by this messaging engine.
 *   'fileStore': Indicates that a file store is to be created. No value is needed.
 *   'dataStore': Indicates that a data store is to be created. No value is needed.
 *   'logSize': The size, in megabytes, of the log file.
 *   'minPermanentStoreSize': The minimum size in megabytes of the permanent store file.
 *   'maxPermanentStoreSize': The maximum size, in megabytes, of the permanent store file.
 *   'unlimitedPermanentStoreSize': True if the permanent file store size has no limit, false otherwise.
 *   'permanentStoreDirectory': The name of the permanent store files directory.
 *   'minTemporaryStoreSize': The minimum size in megabytes of the temporary store file.
 *   'maxTemporaryStoreSize': The maximum size, in megabytes, of the temporary store file.
 *   'unlimitedTemporaryStoreSize': True if the temporary file store size has no limit, false otherwise.
 *   'temporaryStoreDirectory': The name of the temporary store files directory.
 *   'logDirectory': The name of the log files directory.
 *   'createDefaultDatasource': When adding a server to a bus, set this to true if a default datasource is required. When adding a cluster to a bus, this parameter must not be supplied.
 *   'datasourceJndiName': The JNDI name of the datasource to be referenced from the datastore created when the member is added to the bus.
 *   'authAlias': The name of the authentication alias used to authenticate the messaging engine to the data source.
 *   'createTables': Select this option if the messaging engine creates the database tables for the data store. Otherwise, the database administrator must create the database tables.
 *   'schemaName': The name of the database schema used to contain the tables for the data store.
 *   'failover': Indicates that the messaging engine created can failover to other servers. This option can be used when messaging engine policy assistance is enabled and the "CUSTOM" policy is selected.
 *   'failback': Indicates that the messaging engine created can fail back to a preferred server. This option can be used when messaging engine policy assistance is enabled and the "CUSTOM" policy is selected.
 *   'preferredServersOnly': Indicates that the messaging engine created can failover to other servers. This option can be used when messaging engine policy assistance is enabled and the "CUSTOM" policy is selected.
 * The required parameters are found in the constructor.
 */
public class CreateSIBEngine extends Command {

	private List<Command> __steps;
	private String bus;
	private String node;
	private String server;
	private String cluster;
	private String description;
	private String initialState;
	private java.lang.Long highMessageThreshold;
	private java.lang.Long defaultBlockedRetryTimeout;
	private String fileStore;
	private String dataStore;
	private java.lang.Long logSize;
	private java.lang.Long minPermanentStoreSize;
	private java.lang.Long maxPermanentStoreSize;
	private Boolean unlimitedPermanentStoreSize;
	private String permanentStoreDirectory;
	private java.lang.Long minTemporaryStoreSize;
	private java.lang.Long maxTemporaryStoreSize;
	private Boolean unlimitedTemporaryStoreSize;
	private String temporaryStoreDirectory;
	private String logDirectory;
	private Boolean createDefaultDatasource;
	private String datasourceJndiName;
	private String authAlias;
	private Boolean createTables;
	private String schemaName;
	private Boolean failover;
	private Boolean failback;
	private Boolean preferredServersOnly;

	public CreateSIBEngine(String bus) {
		super("createSIBEngine");
		this.bus = bus;
	}

	/**
	 * The name of the bus to which the messaging engine is to belong.
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * The name of the bus to which the messaging engine is to belong.
	 */
	public void setBus(String value) {
		this.bus = value;
	}

	/**
	 * To create a messaging engine on a server, supply node and server name, but not cluster name.
	 */
	public String getNode() {
		return this.node;
	}

	/**
	 * To create a messaging engine on a server, supply node and server name, but not cluster name.
	 */
	public void setNode(String value) {
		this.node = value;
	}

	/**
	 * To create a messaging engine on a server, supply node and server name, but not cluster name.
	 */
	public String getServer() {
		return this.server;
	}

	/**
	 * To create a messaging engine on a server, supply node and server name, but not cluster name.
	 */
	public void setServer(String value) {
		this.server = value;
	}

	/**
	 * To create a messaging engine on a cluster, supply cluster name, but not node and server name.
	 */
	public String getCluster() {
		return this.cluster;
	}

	/**
	 * To create a messaging engine on a cluster, supply cluster name, but not node and server name.
	 */
	public void setCluster(String value) {
		this.cluster = value;
	}

	/**
	 * Description of the messaging engine.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Description of the messaging engine.
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Whether the messaging engine is started or stopped when the associated application server is first started. Until started, the messaging engine is unavailable. (Stopped | Started).
	 */
	public String getInitialState() {
		return this.initialState;
	}

	/**
	 * Whether the messaging engine is started or stopped when the associated application server is first started. Until started, the messaging engine is unavailable. (Stopped | Started).
	 */
	public void setInitialState(String value) {
		this.initialState = value;
	}

	/**
	 * The maximum total number of messages that the messaging engine can place on its message points.
	 */
	public java.lang.Long getHighMessageThreshold() {
		return this.highMessageThreshold;
	}

	/**
	 * The maximum total number of messages that the messaging engine can place on its message points.
	 */
	public void setHighMessageThreshold(java.lang.Long value) {
		this.highMessageThreshold = value;
	}

	/**
	 * The default blocked retry interval for destinations owned by this messaging engine.
	 */
	public java.lang.Long getDefaultBlockedRetryTimeout() {
		return this.defaultBlockedRetryTimeout;
	}

	/**
	 * The default blocked retry interval for destinations owned by this messaging engine.
	 */
	public void setDefaultBlockedRetryTimeout(java.lang.Long value) {
		this.defaultBlockedRetryTimeout = value;
	}

	/**
	 * Indicates that a file store is to be created. No value is needed.
	 */
	public String getFileStore() {
		return this.fileStore;
	}

	/**
	 * Indicates that a file store is to be created. No value is needed.
	 */
	public void setFileStore(String value) {
		this.fileStore = value;
	}

	/**
	 * Indicates that a data store is to be created. No value is needed.
	 */
	public String getDataStore() {
		return this.dataStore;
	}

	/**
	 * Indicates that a data store is to be created. No value is needed.
	 */
	public void setDataStore(String value) {
		this.dataStore = value;
	}

	/**
	 * The size, in megabytes, of the log file.
	 */
	public java.lang.Long getLogSize() {
		return this.logSize;
	}

	/**
	 * The size, in megabytes, of the log file.
	 */
	public void setLogSize(java.lang.Long value) {
		this.logSize = value;
	}

	/**
	 * The minimum size in megabytes of the permanent store file.
	 */
	public java.lang.Long getMinPermanentStoreSize() {
		return this.minPermanentStoreSize;
	}

	/**
	 * The minimum size in megabytes of the permanent store file.
	 */
	public void setMinPermanentStoreSize(java.lang.Long value) {
		this.minPermanentStoreSize = value;
	}

	/**
	 * The maximum size, in megabytes, of the permanent store file.
	 */
	public java.lang.Long getMaxPermanentStoreSize() {
		return this.maxPermanentStoreSize;
	}

	/**
	 * The maximum size, in megabytes, of the permanent store file.
	 */
	public void setMaxPermanentStoreSize(java.lang.Long value) {
		this.maxPermanentStoreSize = value;
	}

	/**
	 * True if the permanent file store size has no limit, false otherwise.
	 */
	public Boolean getUnlimitedPermanentStoreSize() {
		return this.unlimitedPermanentStoreSize;
	}

	/**
	 * True if the permanent file store size has no limit, false otherwise.
	 */
	public void setUnlimitedPermanentStoreSize(Boolean value) {
		this.unlimitedPermanentStoreSize = value;
	}

	/**
	 * The name of the permanent store files directory.
	 */
	public String getPermanentStoreDirectory() {
		return this.permanentStoreDirectory;
	}

	/**
	 * The name of the permanent store files directory.
	 */
	public void setPermanentStoreDirectory(String value) {
		this.permanentStoreDirectory = value;
	}

	/**
	 * The minimum size in megabytes of the temporary store file.
	 */
	public java.lang.Long getMinTemporaryStoreSize() {
		return this.minTemporaryStoreSize;
	}

	/**
	 * The minimum size in megabytes of the temporary store file.
	 */
	public void setMinTemporaryStoreSize(java.lang.Long value) {
		this.minTemporaryStoreSize = value;
	}

	/**
	 * The maximum size, in megabytes, of the temporary store file.
	 */
	public java.lang.Long getMaxTemporaryStoreSize() {
		return this.maxTemporaryStoreSize;
	}

	/**
	 * The maximum size, in megabytes, of the temporary store file.
	 */
	public void setMaxTemporaryStoreSize(java.lang.Long value) {
		this.maxTemporaryStoreSize = value;
	}

	/**
	 * True if the temporary file store size has no limit, false otherwise.
	 */
	public Boolean getUnlimitedTemporaryStoreSize() {
		return this.unlimitedTemporaryStoreSize;
	}

	/**
	 * True if the temporary file store size has no limit, false otherwise.
	 */
	public void setUnlimitedTemporaryStoreSize(Boolean value) {
		this.unlimitedTemporaryStoreSize = value;
	}

	/**
	 * The name of the temporary store files directory.
	 */
	public String getTemporaryStoreDirectory() {
		return this.temporaryStoreDirectory;
	}

	/**
	 * The name of the temporary store files directory.
	 */
	public void setTemporaryStoreDirectory(String value) {
		this.temporaryStoreDirectory = value;
	}

	/**
	 * The name of the log files directory.
	 */
	public String getLogDirectory() {
		return this.logDirectory;
	}

	/**
	 * The name of the log files directory.
	 */
	public void setLogDirectory(String value) {
		this.logDirectory = value;
	}

	/**
	 * When adding a server to a bus, set this to true if a default datasource is required. When adding a cluster to a bus, this parameter must not be supplied.
	 */
	public Boolean getCreateDefaultDatasource() {
		return this.createDefaultDatasource;
	}

	/**
	 * When adding a server to a bus, set this to true if a default datasource is required. When adding a cluster to a bus, this parameter must not be supplied.
	 */
	public void setCreateDefaultDatasource(Boolean value) {
		this.createDefaultDatasource = value;
	}

	/**
	 * The JNDI name of the datasource to be referenced from the datastore created when the member is added to the bus.
	 */
	public String getDatasourceJndiName() {
		return this.datasourceJndiName;
	}

	/**
	 * The JNDI name of the datasource to be referenced from the datastore created when the member is added to the bus.
	 */
	public void setDatasourceJndiName(String value) {
		this.datasourceJndiName = value;
	}

	/**
	 * The name of the authentication alias used to authenticate the messaging engine to the data source.
	 */
	public String getAuthAlias() {
		return this.authAlias;
	}

	/**
	 * The name of the authentication alias used to authenticate the messaging engine to the data source.
	 */
	public void setAuthAlias(String value) {
		this.authAlias = value;
	}

	/**
	 * Select this option if the messaging engine creates the database tables for the data store. Otherwise, the database administrator must create the database tables.
	 */
	public Boolean getCreateTables() {
		return this.createTables;
	}

	/**
	 * Select this option if the messaging engine creates the database tables for the data store. Otherwise, the database administrator must create the database tables.
	 */
	public void setCreateTables(Boolean value) {
		this.createTables = value;
	}

	/**
	 * The name of the database schema used to contain the tables for the data store.
	 */
	public String getSchemaName() {
		return this.schemaName;
	}

	/**
	 * The name of the database schema used to contain the tables for the data store.
	 */
	public void setSchemaName(String value) {
		this.schemaName = value;
	}

	/**
	 * Indicates that the messaging engine created can failover to other servers. This option can be used when messaging engine policy assistance is enabled and the "CUSTOM" policy is selected.
	 */
	public Boolean getFailover() {
		return this.failover;
	}

	/**
	 * Indicates that the messaging engine created can failover to other servers. This option can be used when messaging engine policy assistance is enabled and the "CUSTOM" policy is selected.
	 */
	public void setFailover(Boolean value) {
		this.failover = value;
	}

	/**
	 * Indicates that the messaging engine created can fail back to a preferred server. This option can be used when messaging engine policy assistance is enabled and the "CUSTOM" policy is selected.
	 */
	public Boolean getFailback() {
		return this.failback;
	}

	/**
	 * Indicates that the messaging engine created can fail back to a preferred server. This option can be used when messaging engine policy assistance is enabled and the "CUSTOM" policy is selected.
	 */
	public void setFailback(Boolean value) {
		this.failback = value;
	}

	/**
	 * Indicates that the messaging engine created can failover to other servers. This option can be used when messaging engine policy assistance is enabled and the "CUSTOM" policy is selected.
	 */
	public Boolean getPreferredServersOnly() {
		return this.preferredServersOnly;
	}

	/**
	 * Indicates that the messaging engine created can failover to other servers. This option can be used when messaging engine policy assistance is enabled and the "CUSTOM" policy is selected.
	 */
	public void setPreferredServersOnly(Boolean value) {
		this.preferredServersOnly = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("bus", this.bus);
		if (this.node != null) {
			ret.put("node", this.node);
		}
		if (this.server != null) {
			ret.put("server", this.server);
		}
		if (this.cluster != null) {
			ret.put("cluster", this.cluster);
		}
		if (this.description != null) {
			ret.put("description", this.description);
		}
		if (this.initialState != null) {
			ret.put("initialState", this.initialState);
		}
		if (this.highMessageThreshold != null) {
			ret.put("highMessageThreshold", this.highMessageThreshold);
		}
		if (this.defaultBlockedRetryTimeout != null) {
			ret.put("defaultBlockedRetryTimeout", this.defaultBlockedRetryTimeout);
		}
		if (this.fileStore != null) {
			ret.put("fileStore", this.fileStore);
		}
		if (this.dataStore != null) {
			ret.put("dataStore", this.dataStore);
		}
		if (this.logSize != null) {
			ret.put("logSize", this.logSize);
		}
		if (this.minPermanentStoreSize != null) {
			ret.put("minPermanentStoreSize", this.minPermanentStoreSize);
		}
		if (this.maxPermanentStoreSize != null) {
			ret.put("maxPermanentStoreSize", this.maxPermanentStoreSize);
		}
		if (this.unlimitedPermanentStoreSize != null) {
			ret.put("unlimitedPermanentStoreSize", this.unlimitedPermanentStoreSize);
		}
		if (this.permanentStoreDirectory != null) {
			ret.put("permanentStoreDirectory", this.permanentStoreDirectory);
		}
		if (this.minTemporaryStoreSize != null) {
			ret.put("minTemporaryStoreSize", this.minTemporaryStoreSize);
		}
		if (this.maxTemporaryStoreSize != null) {
			ret.put("maxTemporaryStoreSize", this.maxTemporaryStoreSize);
		}
		if (this.unlimitedTemporaryStoreSize != null) {
			ret.put("unlimitedTemporaryStoreSize", this.unlimitedTemporaryStoreSize);
		}
		if (this.temporaryStoreDirectory != null) {
			ret.put("temporaryStoreDirectory", this.temporaryStoreDirectory);
		}
		if (this.logDirectory != null) {
			ret.put("logDirectory", this.logDirectory);
		}
		if (this.createDefaultDatasource != null) {
			ret.put("createDefaultDatasource", this.createDefaultDatasource);
		}
		if (this.datasourceJndiName != null) {
			ret.put("datasourceJndiName", this.datasourceJndiName);
		}
		if (this.authAlias != null) {
			ret.put("authAlias", this.authAlias);
		}
		if (this.createTables != null) {
			ret.put("createTables", this.createTables);
		}
		if (this.schemaName != null) {
			ret.put("schemaName", this.schemaName);
		}
		if (this.failover != null) {
			ret.put("failover", this.failover);
		}
		if (this.failback != null) {
			ret.put("failback", this.failback);
		}
		if (this.preferredServersOnly != null) {
			ret.put("preferredServersOnly", this.preferredServersOnly);
		}
		return ret;
	}

	public Object __getTarget() {
		return null;
	}

	public List<Command> __getSteps() {
		return this.__steps;
	}

	/**
	 * Executes the command against the specified scope.
	 * Steps are required by this command, and they appear after the scope parameter.
	 * Classes for these steps are statically available through this admin command class.
	 */
	public OperationResults<Object> run(Scope scope, PreferredServerList preferredServerList, TargetGroups targetGroups) throws Exception {
		this.__steps = new ArrayList<Command>();
		if (preferredServerList != null)
			this.__steps.add(preferredServerList);
		if (targetGroups != null)
			this.__steps.add(targetGroups);
		return super.run(scope);
	}

	/**
	 * The list of preferred servers for the messaging engine created.  This option can be used when messaging engine policy assistance is enabled and the "CUSTOM" policy is selected.
	 *   'node': The name of the node on which the server is configured
	 *   'server': The name of the server to add to the preferred server list
	 * The required parameters are found in the constructor.
	 */
	public static class PreferredServerList extends CommandStep {

		private String node;
		private String server;

		public PreferredServerList(String node, String server) {
			super("preferredServerList");
			this.node = node;
			this.server = server;
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			ret.put("node", this.node);
			ret.put("server", this.server);
			return ret;
		}

		/**
		 * The name of the node on which the server is configured
		 */
		public String getNode() {
			return this.node;
		}

		/**
		 * The name of the node on which the server is configured
		 */
		public void setNode(String value) {
			this.node = value;
		}

		/**
		 * The name of the server to add to the preferred server list
		 */
		public String getServer() {
			return this.server;
		}

		/**
		 * The name of the server to add to the preferred server list
		 */
		public void setServer(String value) {
			this.server = value;
		}

	}
	/**
	 * The target groups for this messaging engine.
	 *   'group': The name of a target group.
	 * The required parameters are found in the constructor.
	 */
	public static class TargetGroups extends CommandStep {

		private String group;

		public TargetGroups(String group) {
			super("targetGroups");
			this.group = group;
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			ret.put("group", this.group);
			return ret;
		}

		/**
		 * The name of a target group.
		 */
		public String getGroup() {
			return this.group;
		}

		/**
		 * The name of a target group.
		 */
		public void setGroup(String value) {
			this.group = value;
		}

	}
}
