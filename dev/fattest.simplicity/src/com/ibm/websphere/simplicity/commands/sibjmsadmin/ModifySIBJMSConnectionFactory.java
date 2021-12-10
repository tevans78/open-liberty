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
 * Modify the attributes of the supplied SIB JMS connection factory using the supplied attribute values.
 *   'name': The name of the SIB JMS connection factory.
 *   'jndiName': The JNDI name of the SIB JMS connection factory.
 *   'authDataAlias': Specifies a user ID and password to be used to authenticate connections to the JMS provider for application-managed authentication.
 *   'containerAuthAlias': Specifies a container managed authentication alias, from which security credentials are to be used when establishing a connection to the JMS provider.
 *   'mappingAlias': Specifies the JAAS mapping alias to use when determining the security related credentials to use when establishing a connection to the JMS provider.
 *   'category': Classifies or groups the connection factory.
 *   'description': The SIB JMS connection factory's new description.
 *   'logMissingTransactionContext': Whether or not the container logs that there is a missing transaction context when a connection is obtained.
 *   'manageCachedHandles': Whether cached handles (handles held in instance variables in a bean) should be tracked by the container.
 *   'xaRecoveryAuthAlias': The authentication alias used during XA recovery processing.
 *   'busName': The SIB JMS connection factory's new bus name value.
 *   'clientID': The SIB JMS connection factory's new client ID value.
 *   'userName': The SIB JMS connection factory's new user name value.
 *   'password': The SIB JMS connection factory's new password value.
 *   'nonPersistentMapping': The SIB JMS connection factory's new non-persistent mapping value. Legal values are "BestEffortNonPersistent", "ExpressNonPersistent", "ReliableNonPersistent", "ReliablePersistent", "AssuredPersistent", "AsSIBDestination" and "None".
 *   'persistentMapping': The SIB JMS connection factory's new persistent mapping value. Legal values are "BestEffortNonPersistent", "ExpressNonPersistent", "ReliableNonPersistent", "ReliablePersistent", "AssuredPersistent", "AsSIBDestination" and "None".
 *   'durableSubscriptionHome': The SIB JMS connection factory's new durable subscription home value.
 *   'readAhead': The SIB JMS connection factory's new read-ahead value. Legal values are "Default", "AlwaysOn" and "AlwaysOff".
 *   'target': The SIB JMS connection factory's new target value.
 *   'targetType': The SIB JMS connection factory's new target type value. Legal values are "BusMember", "Custom" and "ME".
 *   'targetSignificance': This property specifies the significance of the target group.
 *   'targetTransportChain': The SIB JMS connection factory's new remote protocol value.
 *   'providerEndPoints': The SIB JMS connection factory's new provider endpoints value.
 *   'connectionProximity': The SIB JMS connection factory's new connection proximity value. Legal values are "Bus", "Host", "Cluster" and "Server".
 *   'tempQueueNamePrefix': The SIB JMS connection factory's new temporary queue name prefix value.
 *   'tempTopicNamePrefix': The SIB JMS connection factory's new temporary topic name prefix value.
 *   'shareDataSourceWithCMP': Used to control how data sources are shared.
 *   'shareDurableSubscriptions': Used to control how durable subscriptions are shared. Legal values are "InCluster", "AlwaysShared" and "NeverShared".
 *   'consumerDoesNotModifyPayloadAfterGet': When enabled, Object/Bytes Messages received by a message consuming application that has connected to the bus using this connection factory will only have their message data serialized by the system when absolutely necessary. The data obtained from those messages must be treated as readOnly by applications. Legal values are "true" and "false" (default).
 *   'producerDoesNotModifyPayloadAfterSet': When enabled, Object/Bytes Messages sent by a message producing application that has connected to the bus using this connection factory will not have their data copied when set and the system will only serialize the message data when absolutely necessary. Applications sending such messages must not modify the data once it has been set into the message. Legal values are "true" and "false" (default).
 * The required parameters are found in the constructor.
 */
public class ModifySIBJMSConnectionFactory extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String name;
	private String jndiName;
	private String authDataAlias;
	private String containerAuthAlias;
	private String mappingAlias = "DefaultPrincipalMapping";
	private String category;
	private String description;
	private Boolean logMissingTransactionContext;
	private Boolean manageCachedHandles;
	private String xaRecoveryAuthAlias;
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
	private String shareDurableSubscriptions;
	private String consumerDoesNotModifyPayloadAfterGet;
	private String producerDoesNotModifyPayloadAfterSet;

	public ModifySIBJMSConnectionFactory(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget) {
		super("modifySIBJMSConnectionFactory");
		this.__target = commandTarget;
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
	 * The SIB JMS connection factory's new description.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * The SIB JMS connection factory's new description.
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
	 * The SIB JMS connection factory's new bus name value.
	 */
	public String getBusName() {
		return this.busName;
	}

	/**
	 * The SIB JMS connection factory's new bus name value.
	 */
	public void setBusName(String value) {
		this.busName = value;
	}

	/**
	 * The SIB JMS connection factory's new client ID value.
	 */
	public String getClientID() {
		return this.clientID;
	}

	/**
	 * The SIB JMS connection factory's new client ID value.
	 */
	public void setClientID(String value) {
		this.clientID = value;
	}

	/**
	 * The SIB JMS connection factory's new user name value.
	 */
	public String getUserName() {
		return this.userName;
	}

	/**
	 * The SIB JMS connection factory's new user name value.
	 */
	public void setUserName(String value) {
		this.userName = value;
	}

	/**
	 * The SIB JMS connection factory's new password value.
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * The SIB JMS connection factory's new password value.
	 */
	public void setPassword(String value) {
		this.password = value;
	}

	/**
	 * The SIB JMS connection factory's new non-persistent mapping value. Legal values are "BestEffortNonPersistent", "ExpressNonPersistent", "ReliableNonPersistent", "ReliablePersistent", "AssuredPersistent", "AsSIBDestination" and "None".
	 */
	public String getNonPersistentMapping() {
		return this.nonPersistentMapping;
	}

	/**
	 * The SIB JMS connection factory's new non-persistent mapping value. Legal values are "BestEffortNonPersistent", "ExpressNonPersistent", "ReliableNonPersistent", "ReliablePersistent", "AssuredPersistent", "AsSIBDestination" and "None".
	 */
	public void setNonPersistentMapping(String value) {
		this.nonPersistentMapping = value;
	}

	/**
	 * The SIB JMS connection factory's new persistent mapping value. Legal values are "BestEffortNonPersistent", "ExpressNonPersistent", "ReliableNonPersistent", "ReliablePersistent", "AssuredPersistent", "AsSIBDestination" and "None".
	 */
	public String getPersistentMapping() {
		return this.persistentMapping;
	}

	/**
	 * The SIB JMS connection factory's new persistent mapping value. Legal values are "BestEffortNonPersistent", "ExpressNonPersistent", "ReliableNonPersistent", "ReliablePersistent", "AssuredPersistent", "AsSIBDestination" and "None".
	 */
	public void setPersistentMapping(String value) {
		this.persistentMapping = value;
	}

	/**
	 * The SIB JMS connection factory's new durable subscription home value.
	 */
	public String getDurableSubscriptionHome() {
		return this.durableSubscriptionHome;
	}

	/**
	 * The SIB JMS connection factory's new durable subscription home value.
	 */
	public void setDurableSubscriptionHome(String value) {
		this.durableSubscriptionHome = value;
	}

	/**
	 * The SIB JMS connection factory's new read-ahead value. Legal values are "Default", "AlwaysOn" and "AlwaysOff".
	 */
	public String getReadAhead() {
		return this.readAhead;
	}

	/**
	 * The SIB JMS connection factory's new read-ahead value. Legal values are "Default", "AlwaysOn" and "AlwaysOff".
	 */
	public void setReadAhead(String value) {
		this.readAhead = value;
	}

	/**
	 * The SIB JMS connection factory's new target value.
	 */
	public String getTarget() {
		return this.target;
	}

	/**
	 * The SIB JMS connection factory's new target value.
	 */
	public void setTarget(String value) {
		this.target = value;
	}

	/**
	 * The SIB JMS connection factory's new target type value. Legal values are "BusMember", "Custom" and "ME".
	 */
	public String getTargetType() {
		return this.targetType;
	}

	/**
	 * The SIB JMS connection factory's new target type value. Legal values are "BusMember", "Custom" and "ME".
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
	 * The SIB JMS connection factory's new remote protocol value.
	 */
	public String getTargetTransportChain() {
		return this.targetTransportChain;
	}

	/**
	 * The SIB JMS connection factory's new remote protocol value.
	 */
	public void setTargetTransportChain(String value) {
		this.targetTransportChain = value;
	}

	/**
	 * The SIB JMS connection factory's new provider endpoints value.
	 */
	public String getProviderEndPoints() {
		return this.providerEndPoints;
	}

	/**
	 * The SIB JMS connection factory's new provider endpoints value.
	 */
	public void setProviderEndPoints(String value) {
		this.providerEndPoints = value;
	}

	/**
	 * The SIB JMS connection factory's new connection proximity value. Legal values are "Bus", "Host", "Cluster" and "Server".
	 */
	public String getConnectionProximity() {
		return this.connectionProximity;
	}

	/**
	 * The SIB JMS connection factory's new connection proximity value. Legal values are "Bus", "Host", "Cluster" and "Server".
	 */
	public void setConnectionProximity(String value) {
		this.connectionProximity = value;
	}

	/**
	 * The SIB JMS connection factory's new temporary queue name prefix value.
	 */
	public String getTempQueueNamePrefix() {
		return this.tempQueueNamePrefix;
	}

	/**
	 * The SIB JMS connection factory's new temporary queue name prefix value.
	 */
	public void setTempQueueNamePrefix(String value) {
		this.tempQueueNamePrefix = value;
	}

	/**
	 * The SIB JMS connection factory's new temporary topic name prefix value.
	 */
	public String getTempTopicNamePrefix() {
		return this.tempTopicNamePrefix;
	}

	/**
	 * The SIB JMS connection factory's new temporary topic name prefix value.
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
		if (this.name != null) {
			ret.put("name", this.name);
		}
		if (this.jndiName != null) {
			ret.put("jndiName", this.jndiName);
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
		if (this.xaRecoveryAuthAlias != null) {
			ret.put("xaRecoveryAuthAlias", this.xaRecoveryAuthAlias);
		}
		if (this.busName != null) {
			ret.put("busName", this.busName);
		}
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
