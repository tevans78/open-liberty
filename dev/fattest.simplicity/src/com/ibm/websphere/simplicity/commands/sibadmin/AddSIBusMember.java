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
 * Add a member to a bus.
 *   'bus': Name of bus to add member to.
 *   'node': To specify a server bus member, supply node and server name, but not cluster name or WebSphere MQ server name.
 *   'server': To specify a server bus member, supply node and server name, but not cluster name or WebSphere MQ server name.
 *   'cluster': To specify a cluster bus member, supply cluster name, but not node name, server name or WebSphere MQ server name.
 *   'wmqServer': To specify a WebSphere MQ server bus member, supply a WebSphere MQ server name, but not node name, server name or cluster name.
 *   'enableAssistance': Select this option to enable messaging engine policy assistance. A policy name must also be supplied.
 *   'policyName': The name of the policy that the messaging engine policy assistance should apply. Messaging engine policy assistance must be enabled.
 *   'host': This is the override host name of the host to which a connection will be established in order to communicate with a WebSphere MQ queue manager or a WebSphere MQ queue sharing group, supply with a WebSphere MQ server name, but not node name, server name or cluster name.
 *   'port': This is the override port number monitored by a WebSphere MQ queue manager or WebSphere MQ queue sharing group listener, which is listening for connections, supply with a WebSphere MQ server name, but not node name, server name or cluster name.
 *   'channel': This is the override name of the WebSphere MQ server connection channel that will be used to establish a connection to the WebSphere MQ queue manager or WebSphere MQ queue sharing group, supply with a WebSphere MQ server name, but not node name, server name or cluster name.
 *   'securityAuthAlias': The authentication alias that will be supplied when connecting to the WebSphere MQ server, supply with a WebSphere MQ server name, but not node name, server name or cluster name.
 *   'transportChain': Overridden value for the WebSphere MQ server bus member "transportChain" attribute.  Refer to the createSIBWMQServer command for a description of this parameter.
 *   'trustUserIds': Overridden value for the WebSphere MQ server bus member "trustUserIds" attribute.  Refer to the createSIBWMQServer command for a description of this parameter
 *   'fileStore': Indicates that a file store is to be created. No value is needed.
 *   'dataStore': Indicates that a data store is to be created. No value is needed.
 *   'logSize': The size, in megabytes, of the log file.
 *   'minPermanentStoreSize': The minimum size, in megabytes, of the permanent store file.
 *   'maxPermanentStoreSize': The maximum size, in megabytes, of the permanent store file.
 *   'unlimitedPermanentStoreSize': True if the permanent file store size has no limit, false otherwise.
 *   'permanentStoreDirectory': The name of the store files directory for permanent data.
 *   'minTemporaryStoreSize': The minimum size, in megabytes, of the temporary store file.
 *   'maxTemporaryStoreSize': The maximum size, in megabytes, of the temporary store file.
 *   'unlimitedTemporaryStoreSize': True if the temporary file store size has no limit, false otherwise.
 *   'temporaryStoreDirectory': The name of the store files directory for temporary data.
 *   'logDirectory': The name of the log files directory.
 *   'createDefaultDatasource': When adding a server to a bus, set this to true if a default datasource is required. When adding a cluster to a bus, this parameter must not be supplied.
 *   'datasourceJndiName': The JNDI name of the datasource to be referenced from the datastore created when the member is added to the bus.
 *   'authAlias': The name of the authentication alias used to authenticate the messaging engine to the data source.
 *   'createTables': Select this option if the messaging engine creates the database tables for the data store. Otherwise, the database administrator must create the database tables.
 *   'schemaName': The name of the database schema used to contain the tables for the data store.
 *   'failover': Indicates that the messaging engine created can failover to other servers. This option can be used when messaging engine policy assistance is enabled and the "CUSTOM" policy is selected.
 *   'failback': Indicates that the messaging engine created can fail back to a preferred server. This option can be used when messaging engine policy assistance is enabled and the "CUSTOM" policy is selected.
 *   'initialHeapSize': The initial JVM heap size in MB of the server, or of each server in the cluster, will be set to this value.
 *   'maxHeapSize': The maximum JVM heap size in MB of the server, or of each server in the cluster, will be set to this value.
 *   'preferredServersOnly': Indicates that the messaging engine created can failover to other servers. This option can be used when messaging engine policy assistance is enabled and the "CUSTOM" policy is selected.
 *   'virtualQueueManagerName': The virtual queue manager name of the SIBus that the WebSphere MQ queue manager sees.
 * The required parameters are found in the constructor.
 */
public class AddSIBusMember extends Command {

	private List<Command> __steps;
	private String bus;
	private String node;
	private String server;
	private String cluster;
	private String wmqServer;
	private Boolean enableAssistance;
	private String policyName;
	private String host;
	private Integer port;
	private String channel;
	private String securityAuthAlias;
	private String transportChain;
	private Boolean trustUserIds;
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
	private Integer initialHeapSize;
	private Integer maxHeapSize;
	private Boolean preferredServersOnly;
	private String virtualQueueManagerName;

	public AddSIBusMember(String bus) {
		super("addSIBusMember");
		this.bus = bus;
	}

	/**
	 * Name of bus to add member to.
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * Name of bus to add member to.
	 */
	public void setBus(String value) {
		this.bus = value;
	}

	/**
	 * To specify a server bus member, supply node and server name, but not cluster name or WebSphere MQ server name.
	 */
	public String getNode() {
		return this.node;
	}

	/**
	 * To specify a server bus member, supply node and server name, but not cluster name or WebSphere MQ server name.
	 */
	public void setNode(String value) {
		this.node = value;
	}

	/**
	 * To specify a server bus member, supply node and server name, but not cluster name or WebSphere MQ server name.
	 */
	public String getServer() {
		return this.server;
	}

	/**
	 * To specify a server bus member, supply node and server name, but not cluster name or WebSphere MQ server name.
	 */
	public void setServer(String value) {
		this.server = value;
	}

	/**
	 * To specify a cluster bus member, supply cluster name, but not node name, server name or WebSphere MQ server name.
	 */
	public String getCluster() {
		return this.cluster;
	}

	/**
	 * To specify a cluster bus member, supply cluster name, but not node name, server name or WebSphere MQ server name.
	 */
	public void setCluster(String value) {
		this.cluster = value;
	}

	/**
	 * To specify a WebSphere MQ server bus member, supply a WebSphere MQ server name, but not node name, server name or cluster name.
	 */
	public String getWmqServer() {
		return this.wmqServer;
	}

	/**
	 * To specify a WebSphere MQ server bus member, supply a WebSphere MQ server name, but not node name, server name or cluster name.
	 */
	public void setWmqServer(String value) {
		this.wmqServer = value;
	}

	/**
	 * Select this option to enable messaging engine policy assistance. A policy name must also be supplied.
	 */
	public Boolean getEnableAssistance() {
		return this.enableAssistance;
	}

	/**
	 * Select this option to enable messaging engine policy assistance. A policy name must also be supplied.
	 */
	public void setEnableAssistance(Boolean value) {
		this.enableAssistance = value;
	}

	/**
	 * The name of the policy that the messaging engine policy assistance should apply. Messaging engine policy assistance must be enabled.
	 */
	public String getPolicyName() {
		return this.policyName;
	}

	/**
	 * The name of the policy that the messaging engine policy assistance should apply. Messaging engine policy assistance must be enabled.
	 */
	public void setPolicyName(String value) {
		this.policyName = value;
	}

	/**
	 * This is the override host name of the host to which a connection will be established in order to communicate with a WebSphere MQ queue manager or a WebSphere MQ queue sharing group, supply with a WebSphere MQ server name, but not node name, server name or cluster name.
	 */
	public String getHost() {
		return this.host;
	}

	/**
	 * This is the override host name of the host to which a connection will be established in order to communicate with a WebSphere MQ queue manager or a WebSphere MQ queue sharing group, supply with a WebSphere MQ server name, but not node name, server name or cluster name.
	 */
	public void setHost(String value) {
		this.host = value;
	}

	/**
	 * This is the override port number monitored by a WebSphere MQ queue manager or WebSphere MQ queue sharing group listener, which is listening for connections, supply with a WebSphere MQ server name, but not node name, server name or cluster name.
	 */
	public Integer getPort() {
		return this.port;
	}

	/**
	 * This is the override port number monitored by a WebSphere MQ queue manager or WebSphere MQ queue sharing group listener, which is listening for connections, supply with a WebSphere MQ server name, but not node name, server name or cluster name.
	 */
	public void setPort(Integer value) {
		this.port = value;
	}

	/**
	 * This is the override name of the WebSphere MQ server connection channel that will be used to establish a connection to the WebSphere MQ queue manager or WebSphere MQ queue sharing group, supply with a WebSphere MQ server name, but not node name, server name or cluster name.
	 */
	public String getChannel() {
		return this.channel;
	}

	/**
	 * This is the override name of the WebSphere MQ server connection channel that will be used to establish a connection to the WebSphere MQ queue manager or WebSphere MQ queue sharing group, supply with a WebSphere MQ server name, but not node name, server name or cluster name.
	 */
	public void setChannel(String value) {
		this.channel = value;
	}

	/**
	 * The authentication alias that will be supplied when connecting to the WebSphere MQ server, supply with a WebSphere MQ server name, but not node name, server name or cluster name.
	 */
	public String getSecurityAuthAlias() {
		return this.securityAuthAlias;
	}

	/**
	 * The authentication alias that will be supplied when connecting to the WebSphere MQ server, supply with a WebSphere MQ server name, but not node name, server name or cluster name.
	 */
	public void setSecurityAuthAlias(String value) {
		this.securityAuthAlias = value;
	}

	/**
	 * Overridden value for the WebSphere MQ server bus member "transportChain" attribute.  Refer to the createSIBWMQServer command for a description of this parameter.
	 */
	public String getTransportChain() {
		return this.transportChain;
	}

	/**
	 * Overridden value for the WebSphere MQ server bus member "transportChain" attribute.  Refer to the createSIBWMQServer command for a description of this parameter.
	 */
	public void setTransportChain(String value) {
		this.transportChain = value;
	}

	/**
	 * Overridden value for the WebSphere MQ server bus member "trustUserIds" attribute.  Refer to the createSIBWMQServer command for a description of this parameter
	 */
	public Boolean getTrustUserIds() {
		return this.trustUserIds;
	}

	/**
	 * Overridden value for the WebSphere MQ server bus member "trustUserIds" attribute.  Refer to the createSIBWMQServer command for a description of this parameter
	 */
	public void setTrustUserIds(Boolean value) {
		this.trustUserIds = value;
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
	 * The minimum size, in megabytes, of the permanent store file.
	 */
	public java.lang.Long getMinPermanentStoreSize() {
		return this.minPermanentStoreSize;
	}

	/**
	 * The minimum size, in megabytes, of the permanent store file.
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
	 * The name of the store files directory for permanent data.
	 */
	public String getPermanentStoreDirectory() {
		return this.permanentStoreDirectory;
	}

	/**
	 * The name of the store files directory for permanent data.
	 */
	public void setPermanentStoreDirectory(String value) {
		this.permanentStoreDirectory = value;
	}

	/**
	 * The minimum size, in megabytes, of the temporary store file.
	 */
	public java.lang.Long getMinTemporaryStoreSize() {
		return this.minTemporaryStoreSize;
	}

	/**
	 * The minimum size, in megabytes, of the temporary store file.
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
	 * The name of the store files directory for temporary data.
	 */
	public String getTemporaryStoreDirectory() {
		return this.temporaryStoreDirectory;
	}

	/**
	 * The name of the store files directory for temporary data.
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
	 * The initial JVM heap size in MB of the server, or of each server in the cluster, will be set to this value.
	 */
	public Integer getInitialHeapSize() {
		return this.initialHeapSize;
	}

	/**
	 * The initial JVM heap size in MB of the server, or of each server in the cluster, will be set to this value.
	 */
	public void setInitialHeapSize(Integer value) {
		this.initialHeapSize = value;
	}

	/**
	 * The maximum JVM heap size in MB of the server, or of each server in the cluster, will be set to this value.
	 */
	public Integer getMaxHeapSize() {
		return this.maxHeapSize;
	}

	/**
	 * The maximum JVM heap size in MB of the server, or of each server in the cluster, will be set to this value.
	 */
	public void setMaxHeapSize(Integer value) {
		this.maxHeapSize = value;
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

	/**
	 * The virtual queue manager name of the SIBus that the WebSphere MQ queue manager sees.
	 */
	public String getVirtualQueueManagerName() {
		return this.virtualQueueManagerName;
	}

	/**
	 * The virtual queue manager name of the SIBus that the WebSphere MQ queue manager sees.
	 */
	public void setVirtualQueueManagerName(String value) {
		this.virtualQueueManagerName = value;
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
		if (this.wmqServer != null) {
			ret.put("wmqServer", this.wmqServer);
		}
		if (this.enableAssistance != null) {
			ret.put("enableAssistance", this.enableAssistance);
		}
		if (this.policyName != null) {
			ret.put("policyName", this.policyName);
		}
		if (this.host != null) {
			ret.put("host", this.host);
		}
		if (this.port != null) {
			ret.put("port", this.port);
		}
		if (this.channel != null) {
			ret.put("channel", this.channel);
		}
		if (this.securityAuthAlias != null) {
			ret.put("securityAuthAlias", this.securityAuthAlias);
		}
		if (this.transportChain != null) {
			ret.put("transportChain", this.transportChain);
		}
		if (this.trustUserIds != null) {
			ret.put("trustUserIds", this.trustUserIds);
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
		if (this.initialHeapSize != null) {
			ret.put("initialHeapSize", this.initialHeapSize);
		}
		if (this.maxHeapSize != null) {
			ret.put("maxHeapSize", this.maxHeapSize);
		}
		if (this.preferredServersOnly != null) {
			ret.put("preferredServersOnly", this.preferredServersOnly);
		}
		if (this.virtualQueueManagerName != null) {
			ret.put("virtualQueueManagerName", this.virtualQueueManagerName);
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
	public OperationResults<Object> run(Scope scope, PreferredServerList preferredServerList) throws Exception {
		this.__steps = new ArrayList<Command>();
		if (preferredServerList != null)
			this.__steps.add(preferredServerList);
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
}
