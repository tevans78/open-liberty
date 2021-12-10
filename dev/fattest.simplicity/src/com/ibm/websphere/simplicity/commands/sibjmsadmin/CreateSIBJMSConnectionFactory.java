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

package com.ibm.websphere.simplicity.commands.sibjmsadmin;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Create a SIB JMS connection factory at the scope identified by the target object.
 *   'name': The name of the SIB JMS connection factory.
 *   'jndiName': The JNDI name of the SIB JMS connection factory.
 *   'type': Type of connection factory to create. To create a queue connection factory, set to "Queue". To create a topic connection factory, set to "Topic". Leave unset to create a generic connection factory.
 *   'authDataAlias': Specifies a user ID and password to be used to authenticate connections to the JMS provider for application-managed authentication.
 *   'containerAuthAlias': Specifies a container managed authentication alias, from which security credentials are to be used when establishing a connection to the JMS provider.
 *   'mappingAlias': Specifies the JAAS mapping alias to use when determining the security related credentials to use when establishing a connection to the JMS provider.
 *   'xaRecoveryAuthAlias': The authentication alias used during XA recovery processing.
 *   'category': Classifies or groups the connection factory.
 *   'description': Description of the connection factory.
 *   'logMissingTransactionContext': Whether or not the container logs that there is a missing transaction context when a connection is obtained.
 *   'manageCachedHandles': Whether cached handles (handles held in instance variables in a bean) should be tracked by the container.
 *   'busName': The bus name.
 *   'clientID': User-defined string, only required for durable subscriptions.
 *   'userName': The user name that is used to create connections from the connection factory.
 *   'password': The password that is used to create connections from the connection factory.
 *   'nonPersistentMapping': Non-persistent mapping value. Legal values are "BestEffortNonPersistent", "ExpressNonPersistent", "ReliableNonPersistent", "ReliablePersistent", "AssuredPersistent", "AsSIBDestination" and "None".
 *   'persistentMapping': Persistent mapping value. Legal values are "BestEffortNonPersistent", "ExpressNonPersistent", "ReliableNonPersistent", "ReliablePersistent", "AssuredPersistent", "AsSIBDestination" and "None".
 *   'durableSubscriptionHome': Durable subscription home value.
 *   'readAhead': Read-ahead value. Legal values are "Default", "AlwaysOn" and "AlwaysOff".
 *   'target': The name of a target that resolves to a group of messaging engines.
 *   'targetType': Specifies the type of the name in the target parameter. Legal values are "BusMember", "Custom" and "ME".
 *   'targetSignificance': This property specifies the significance of the target group.
 *   'targetTransportChain': The name of the protocol that should be used to connect to a remote messaging engine.
 *   'providerEndPoints': A comma-separated list of endpoint triplets of the form "host:port:chain".
 *   'connectionProximity': The proximity of acceptable messaging engines. Legal values are "Bus", "Host", "Cluster" and "Server".
 *   'tempQueueNamePrefix': Temporary queue name prefix.
 *   'tempTopicNamePrefix': Temporary topic name prefix.
 *   'shareDataSourceWithCMP': Used to control how data sources are shared.
 *   'shareDurableSubscriptions': Used to control how durable subscriptions are shared. Legal values are "InCluster", "AlwaysShared" and "NeverShared".
 *   'consumerDoesNotModifyPayloadAfterGet': When enabled, Object/Bytes Messages received by a message consuming application that has connected to the bus using this connection factory will only have their message data serialized by the system when absolutely necessary. The data obtained from those messages must be treated as readOnly by applications. Legal values are "true" and "false" (default).
 *   'producerDoesNotModifyPayloadAfterSet': When enabled, Object/Bytes Messages sent by a message producing application that has connected to the bus using this connection factory will not have their data copied when set and the system will only serialize the message data when absolutely necessary. Applications sending such messages must not modify the data once it has been set into the message. Legal values are "true" and "false" (default).
 * The required parameters are found in the constructor.
 */
public class CreateSIBJMSConnectionFactory extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String name;
	private String jndiName;
	private String type;
	private String authDataAlias;
	private String containerAuthAlias;
	private String mappingAlias = "DefaultPrincipalMapping";
	private String xaRecoveryAuthAlias;
	private String category;
	private String description;
	private Boolean logMissingTransactionContext = false;
	private Boolean manageCachedHandles = false;
	private String busName;
	private String clientID;
	private String userName;
	private String password;
	private String nonPersistentMapping;
	private String persistentMapping;
	private String durableSubscriptionHome;
	private String readAhead;
	private String target;
	private String targetType;
	private String targetSignificance;
	private String targetTransportChain;
	private String providerEndPoints;
	private String connectionProximity;
	private String tempQueueNamePrefix;
	private String tempTopicNamePrefix;
	private Boolean shareDataSourceWithCMP;
	private String shareDurableSubscriptions = "InCluster";
	private String consumerDoesNotModifyPayloadAfterGet = "false";
	private String producerDoesNotModifyPayloadAfterSet = "false";

	public CreateSIBJMSConnectionFactory(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String name, String jndiName, String busName) {
		super("createSIBJMSConnectionFactory");
		this.__target = commandTarget;
		this.name = name;
		this.jndiName = jndiName;
		this.busName = busName;
	}

	/**
	 * The name of the SIB JMS connection factory.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The name of the SIB JMS connection factory.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * The JNDI name of the SIB JMS connection factory.
	 */
	public String getJndiName() {
		return this.jndiName;
	}

	/**
	 * The JNDI name of the SIB JMS connection factory.
	 */
	public void setJndiName(String value) {
		this.jndiName = value;
	}

	/**
	 * Type of connection factory to create. To create a queue connection factory, set to "Queue". To create a topic connection factory, set to "Topic". Leave unset to create a generic connection factory.
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Type of connection factory to create. To create a queue connection factory, set to "Queue". To create a topic connection factory, set to "Topic". Leave unset to create a generic connection factory.
	 */
	public void setType(String value) {
		this.type = value;
	}

	/**
	 * Specifies a user ID and password to be used to authenticate connections to the JMS provider for application-managed authentication.
	 */
	public String getAuthDataAlias() {
		return this.authDataAlias;
	}

	/**
	 * Specifies a user ID and password to be used to authenticate connections to the JMS provider for application-managed authentication.
	 */
	public void setAuthDataAlias(String value) {
		this.authDataAlias = value;
	}

	/**
	 * Specifies a container managed authentication alias, from which security credentials are to be used when establishing a connection to the JMS provider.
	 */
	public String getContainerAuthAlias() {
		return this.containerAuthAlias;
	}

	/**
	 * Specifies a container managed authentication alias, from which security credentials are to be used when establishing a connection to the JMS provider.
	 */
	public void setContainerAuthAlias(String value) {
		this.containerAuthAlias = value;
	}

	/**
	 * Specifies the JAAS mapping alias to use when determining the security related credentials to use when establishing a connection to the JMS provider.
	 */
	public String getMappingAlias() {
		return this.mappingAlias;
	}

	/**
	 * Specifies the JAAS mapping alias to use when determining the security related credentials to use when establishing a connection to the JMS provider.
	 */
	public void setMappingAlias(String value) {
		this.mappingAlias = value;
	}

	/**
	 * The authentication alias used during XA recovery processing.
	 */
	public String getXaRecoveryAuthAlias() {
		return this.xaRecoveryAuthAlias;
	}

	/**
	 * The authentication alias used during XA recovery processing.
	 */
	public void setXaRecoveryAuthAlias(String value) {
		this.xaRecoveryAuthAlias = value;
	}

	/**
	 * Classifies or groups the connection factory.
	 */
	public String getCategory() {
		return this.category;
	}

	/**
	 * Classifies or groups the connection factory.
	 */
	public void setCategory(String value) {
		this.category = value;
	}

	/**
	 * Description of the connection factory.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Description of the connection factory.
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Whether or not the container logs that there is a missing transaction context when a connection is obtained.
	 */
	public Boolean getLogMissingTransactionContext() {
		return this.logMissingTransactionContext;
	}

	/**
	 * Whether or not the container logs that there is a missing transaction context when a connection is obtained.
	 */
	public void setLogMissingTransactionContext(Boolean value) {
		this.logMissingTransactionContext = value;
	}

	/**
	 * Whether cached handles (handles held in instance variables in a bean) should be tracked by the container.
	 */
	public Boolean getManageCachedHandles() {
		return this.manageCachedHandles;
	}

	/**
	 * Whether cached handles (handles held in instance variables in a bean) should be tracked by the container.
	 */
	public void setManageCachedHandles(Boolean value) {
		this.manageCachedHandles = value;
	}

	/**
	 * The bus name.
	 */
	public String getBusName() {
		return this.busName;
	}

	/**
	 * The bus name.
	 */
	public void setBusName(String value) {
		this.busName = value;
	}

	/**
	 * User-defined string, only required for durable subscriptions.
	 */
	public String getClientID() {
		return this.clientID;
	}

	/**
	 * User-defined string, only required for durable subscriptions.
	 */
	public void setClientID(String value) {
		this.clientID = value;
	}

	/**
	 * The user name that is used to create connections from the connection factory.
	 */
	public String getUserName() {
		return this.userName;
	}

	/**
	 * The user name that is used to create connections from the connection factory.
	 */
	public void setUserName(String value) {
		this.userName = value;
	}

	/**
	 * The password that is used to create connections from the connection factory.
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * The password that is used to create connections from the connection factory.
	 */
	public void setPassword(String value) {
		this.password = value;
	}

	/**
	 * Non-persistent mapping value. Legal values are "BestEffortNonPersistent", "ExpressNonPersistent", "ReliableNonPersistent", "ReliablePersistent", "AssuredPersistent", "AsSIBDestination" and "None".
	 */
	public String getNonPersistentMapping() {
		return this.nonPersistentMapping;
	}

	/**
	 * Non-persistent mapping value. Legal values are "BestEffortNonPersistent", "ExpressNonPersistent", "ReliableNonPersistent", "ReliablePersistent", "AssuredPersistent", "AsSIBDestination" and "None".
	 */
	public void setNonPersistentMapping(String value) {
		this.nonPersistentMapping = value;
	}

	/**
	 * Persistent mapping value. Legal values are "BestEffortNonPersistent", "ExpressNonPersistent", "ReliableNonPersistent", "ReliablePersistent", "AssuredPersistent", "AsSIBDestination" and "None".
	 */
	public String getPersistentMapping() {
		return this.persistentMapping;
	}

	/**
	 * Persistent mapping value. Legal values are "BestEffortNonPersistent", "ExpressNonPersistent", "ReliableNonPersistent", "ReliablePersistent", "AssuredPersistent", "AsSIBDestination" and "None".
	 */
	public void setPersistentMapping(String value) {
		this.persistentMapping = value;
	}

	/**
	 * Durable subscription home value.
	 */
	public String getDurableSubscriptionHome() {
		return this.durableSubscriptionHome;
	}

	/**
	 * Durable subscription home value.
	 */
	public void setDurableSubscriptionHome(String value) {
		this.durableSubscriptionHome = value;
	}

	/**
	 * Read-ahead value. Legal values are "Default", "AlwaysOn" and "AlwaysOff".
	 */
	public String getReadAhead() {
		return this.readAhead;
	}

	/**
	 * Read-ahead value. Legal values are "Default", "AlwaysOn" and "AlwaysOff".
	 */
	public void setReadAhead(String value) {
		this.readAhead = value;
	}

	/**
	 * The name of a target that resolves to a group of messaging engines.
	 */
	public String getTarget() {
		return this.target;
	}

	/**
	 * The name of a target that resolves to a group of messaging engines.
	 */
	public void setTarget(String value) {
		this.target = value;
	}

	/**
	 * Specifies the type of the name in the target parameter. Legal values are "BusMember", "Custom" and "ME".
	 */
	public String getTargetType() {
		return this.targetType;
	}

	/**
	 * Specifies the type of the name in the target parameter. Legal values are "BusMember", "Custom" and "ME".
	 */
	public void setTargetType(String value) {
		this.targetType = value;
	}

	/**
	 * This property specifies the significance of the target group.
	 */
	public String getTargetSignificance() {
		return this.targetSignificance;
	}

	/**
	 * This property specifies the significance of the target group.
	 */
	public void setTargetSignificance(String value) {
		this.targetSignificance = value;
	}

	/**
	 * The name of the protocol that should be used to connect to a remote messaging engine.
	 */
	public String getTargetTransportChain() {
		return this.targetTransportChain;
	}

	/**
	 * The name of the protocol that should be used to connect to a remote messaging engine.
	 */
	public void setTargetTransportChain(String value) {
		this.targetTransportChain = value;
	}

	/**
	 * A comma-separated list of endpoint triplets of the form "host:port:chain".
	 */
	public String getProviderEndPoints() {
		return this.providerEndPoints;
	}

	/**
	 * A comma-separated list of endpoint triplets of the form "host:port:chain".
	 */
	public void setProviderEndPoints(String value) {
		this.providerEndPoints = value;
	}

	/**
	 * The proximity of acceptable messaging engines. Legal values are "Bus", "Host", "Cluster" and "Server".
	 */
	public String getConnectionProximity() {
		return this.connectionProximity;
	}

	/**
	 * The proximity of acceptable messaging engines. Legal values are "Bus", "Host", "Cluster" and "Server".
	 */
	public void setConnectionProximity(String value) {
		this.connectionProximity = value;
	}

	/**
	 * Temporary queue name prefix.
	 */
	public String getTempQueueNamePrefix() {
		return this.tempQueueNamePrefix;
	}

	/**
	 * Temporary queue name prefix.
	 */
	public void setTempQueueNamePrefix(String value) {
		this.tempQueueNamePrefix = value;
	}

	/**
	 * Temporary topic name prefix.
	 */
	public String getTempTopicNamePrefix() {
		return this.tempTopicNamePrefix;
	}

	/**
	 * Temporary topic name prefix.
	 */
	public void setTempTopicNamePrefix(String value) {
		this.tempTopicNamePrefix = value;
	}

	/**
	 * Used to control how data sources are shared.
	 */
	public Boolean getShareDataSourceWithCMP() {
		return this.shareDataSourceWithCMP;
	}

	/**
	 * Used to control how data sources are shared.
	 */
	public void setShareDataSourceWithCMP(Boolean value) {
		this.shareDataSourceWithCMP = value;
	}

	/**
	 * Used to control how durable subscriptions are shared. Legal values are "InCluster", "AlwaysShared" and "NeverShared".
	 */
	public String getShareDurableSubscriptions() {
		return this.shareDurableSubscriptions;
	}

	/**
	 * Used to control how durable subscriptions are shared. Legal values are "InCluster", "AlwaysShared" and "NeverShared".
	 */
	public void setShareDurableSubscriptions(String value) {
		this.shareDurableSubscriptions = value;
	}

	/**
	 * When enabled, Object/Bytes Messages received by a message consuming application that has connected to the bus using this connection factory will only have their message data serialized by the system when absolutely necessary. The data obtained from those messages must be treated as readOnly by applications. Legal values are "true" and "false" (default).
	 */
	public String getConsumerDoesNotModifyPayloadAfterGet() {
		return this.consumerDoesNotModifyPayloadAfterGet;
	}

	/**
	 * When enabled, Object/Bytes Messages received by a message consuming application that has connected to the bus using this connection factory will only have their message data serialized by the system when absolutely necessary. The data obtained from those messages must be treated as readOnly by applications. Legal values are "true" and "false" (default).
	 */
	public void setConsumerDoesNotModifyPayloadAfterGet(String value) {
		this.consumerDoesNotModifyPayloadAfterGet = value;
	}

	/**
	 * When enabled, Object/Bytes Messages sent by a message producing application that has connected to the bus using this connection factory will not have their data copied when set and the system will only serialize the message data when absolutely necessary. Applications sending such messages must not modify the data once it has been set into the message. Legal values are "true" and "false" (default).
	 */
	public String getProducerDoesNotModifyPayloadAfterSet() {
		return this.producerDoesNotModifyPayloadAfterSet;
	}

	/**
	 * When enabled, Object/Bytes Messages sent by a message producing application that has connected to the bus using this connection factory will not have their data copied when set and the system will only serialize the message data when absolutely necessary. Applications sending such messages must not modify the data once it has been set into the message. Legal values are "true" and "false" (default).
	 */
	public void setProducerDoesNotModifyPayloadAfterSet(String value) {
		this.producerDoesNotModifyPayloadAfterSet = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("name", this.name);
		ret.put("jndiName", this.jndiName);
		if (this.type != null) {
			ret.put("type", this.type);
		}
		if (this.authDataAlias != null) {
			ret.put("authDataAlias", this.authDataAlias);
		}
		if (this.containerAuthAlias != null) {
			ret.put("containerAuthAlias", this.containerAuthAlias);
		}
		if (this.mappingAlias != null) {
			ret.put("mappingAlias", this.mappingAlias);
		}
		if (this.xaRecoveryAuthAlias != null) {
			ret.put("xaRecoveryAuthAlias", this.xaRecoveryAuthAlias);
		}
		if (this.category != null) {
			ret.put("category", this.category);
		}
		if (this.description != null) {
			ret.put("description", this.description);
		}
		if (this.logMissingTransactionContext != null) {
			ret.put("logMissingTransactionContext", this.logMissingTransactionContext);
		}
		if (this.manageCachedHandles != null) {
			ret.put("manageCachedHandles", this.manageCachedHandles);
		}
		ret.put("busName", this.busName);
		if (this.clientID != null) {
			ret.put("clientID", this.clientID);
		}
		if (this.userName != null) {
			ret.put("userName", this.userName);
		}
		if (this.password != null) {
			ret.put("password", this.password);
		}
		if (this.nonPersistentMapping != null) {
			ret.put("nonPersistentMapping", this.nonPersistentMapping);
		}
		if (this.persistentMapping != null) {
			ret.put("persistentMapping", this.persistentMapping);
		}
		if (this.durableSubscriptionHome != null) {
			ret.put("durableSubscriptionHome", this.durableSubscriptionHome);
		}
		if (this.readAhead != null) {
			ret.put("readAhead", this.readAhead);
		}
		if (this.target != null) {
			ret.put("target", this.target);
		}
		if (this.targetType != null) {
			ret.put("targetType", this.targetType);
		}
		if (this.targetSignificance != null) {
			ret.put("targetSignificance", this.targetSignificance);
		}
		if (this.targetTransportChain != null) {
			ret.put("targetTransportChain", this.targetTransportChain);
		}
		if (this.providerEndPoints != null) {
			ret.put("providerEndPoints", this.providerEndPoints);
		}
		if (this.connectionProximity != null) {
			ret.put("connectionProximity", this.connectionProximity);
		}
		if (this.tempQueueNamePrefix != null) {
			ret.put("tempQueueNamePrefix", this.tempQueueNamePrefix);
		}
		if (this.tempTopicNamePrefix != null) {
			ret.put("tempTopicNamePrefix", this.tempTopicNamePrefix);
		}
		if (this.shareDataSourceWithCMP != null) {
			ret.put("shareDataSourceWithCMP", this.shareDataSourceWithCMP);
		}
		if (this.shareDurableSubscriptions != null) {
			ret.put("shareDurableSubscriptions", this.shareDurableSubscriptions);
		}
		if (this.consumerDoesNotModifyPayloadAfterGet != null) {
			ret.put("consumerDoesNotModifyPayloadAfterGet", this.consumerDoesNotModifyPayloadAfterGet);
		}
		if (this.producerDoesNotModifyPayloadAfterSet != null) {
			ret.put("producerDoesNotModifyPayloadAfterSet", this.producerDoesNotModifyPayloadAfterSet);
		}
		return ret;
	}

	public Object __getTarget() {
		return this.__target;
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
