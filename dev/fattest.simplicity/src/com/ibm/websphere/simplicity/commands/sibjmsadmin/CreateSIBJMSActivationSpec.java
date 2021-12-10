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
 * Create an activation specification in the SIB JMS resource adapter.
 *   'name': Name of new activation specification.
 *   'jndiName': JNDI name of the activation specification.
 *   'destinationJndiName': JNDI name of a destination.
 *   'description': A JMS activation specification is used by the default messaging provider to validate the activation-configuration properties for a JMS message-driven bean (MDB).
 *   'acknowledgeMode': How the session acknowledges any messages it receives.
 *   'authenticationAlias': Authentication alias.
 *   'busName': Name of the bus to connect to.
 *   'clientId': Client identifier. Required for durable topic subscriptions.
 *   'destinationType': Whether the message-driven bean uses a queue or topic destination.
 *   'durableSubscriptionHome': Name of the durable subscription home. This identifies the messaging engine where all durable subscriptions accessed through this activation specification are managed.
 *   'maxBatchSize': The maximum number of messages received from the messaging engine in a single batch.
 *   'maxConcurrency': The maximum number of endpoints to which messages are delivered concurrently.
 *   'messageSelector': The JMS message selector used to determine which messages the message-driven bean (MDB) receives.
 *   'password': Password.
 *   'subscriptionDurability': Whether a JMS topic subscription is durable or nondurable.
 *   'subscriptionName': The subscription name needed for durable topic subscriptions.
 *   'shareDurableSubscriptions': Used to control how durable subscriptions are shared.
 *   'userName': User name.
 *   'readAhead': Read-ahead value. Legal values are "Default", "AlwaysOn" and "AlwaysOff".
 *   'target': The SIB JMS activation specification new target value.
 *   'targetType': The SIB JMS activation specification new target type value. Legal values are "BusMember", "Custom" and "ME".
 *   'targetSignificance': This property specifies the significance of the target group.
 *   'targetTransportChain': The name of the protocol that should be used to connect to a remote messaging engine.
 *   'providerEndPoints': A comma-separated list of endpoint triplets of the form "host:port:chain".
 *   'shareDataSourceWithCMP': Used to control how data sources are shared.
 *   'consumerDoesNotModifyPayloadAfterGet': When enabled, Object Messages received through this activation spec will only have their message data serialized by the system when absolutely necessary. The data obtained from those messages must be treated as readOnly by applications. Legal values are "true" and "false" (default).
 *   'forwarderDoesNotModifyPayloadAfterSet': When enabled, Object/Bytes Messages forwarded through this activation spec that have their payload modified will not have the data copied when is is set into the message and the system will only serialize the message data when absolutely necessary. Applications sending such messages must not modify the data once it has been set into the message. Legal values are "true" and "false" (default).
 *   'alwaysActivateAllMDBs': MDB server-selection rule.  Determines which servers can drive MDBs deployed to them.  This parameter has two possible values: TRUE, FALSE.  The default is FALSE.  Specify TRUE to always activate MDBs in all servers.  Otherwise, only servers with a running messaging engine are used.
 *   'retryInterval': The delay (in seconds) between attempts to connect to a messaging engine, both for the initial connection, and any subsequent attempts to establish a better connection.  The default is 30.  Must be greater than zero.
 *   'autoStopSequentialMessageFailure': The endpoint will be stopped when the number of sequentially failing messages reaches the configured limit. Due to processing dependencies in the MDB the actual number of messages processed may exceed this value.
 *   'failingMessageDelay': Any message that fails to be processed by the MDB but has not reached its maximum failed delivery limit will only be retried after this period of time has passed. Other messages may be tried during this period, unless the sequential failure threshold and the maximum concurrency is set to 1 millisecond.
 * The required parameters are found in the constructor.
 */
public class CreateSIBJMSActivationSpec extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String name;
	private String jndiName;
	private String destinationJndiName;
	private String description;
	private String acknowledgeMode;
	private String authenticationAlias;
	private String busName;
	private String clientId;
	private String destinationType = "javax.jms.Queue";
	private String durableSubscriptionHome;
	private Integer maxBatchSize;
	private Integer maxConcurrency;
	private String messageSelector;
	private String password;
	private String subscriptionDurability;
	private String subscriptionName;
	private String shareDurableSubscriptions = "InCluster";
	private String userName;
	private String readAhead;
	private String target;
	private String targetType;
	private String targetSignificance;
	private String targetTransportChain;
	private String providerEndPoints;
	private Boolean shareDataSourceWithCMP;
	private String consumerDoesNotModifyPayloadAfterGet = "false";
	private String forwarderDoesNotModifyPayloadAfterSet = "false";
	private Boolean alwaysActivateAllMDBs = false;
	private Integer retryInterval;
	private Integer autoStopSequentialMessageFailure = 0;
	private Long failingMessageDelay = 0L;

	public CreateSIBJMSActivationSpec(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String name, String jndiName, String destinationJndiName) {
		super("createSIBJMSActivationSpec");
		this.__target = commandTarget;
		this.name = name;
		this.jndiName = jndiName;
		this.destinationJndiName = destinationJndiName;
	}

	/**
	 * Name of new activation specification.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Name of new activation specification.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * JNDI name of the activation specification.
	 */
	public String getJndiName() {
		return this.jndiName;
	}

	/**
	 * JNDI name of the activation specification.
	 */
	public void setJndiName(String value) {
		this.jndiName = value;
	}

	/**
	 * JNDI name of a destination.
	 */
	public String getDestinationJndiName() {
		return this.destinationJndiName;
	}

	/**
	 * JNDI name of a destination.
	 */
	public void setDestinationJndiName(String value) {
		this.destinationJndiName = value;
	}

	/**
	 * A JMS activation specification is used by the default messaging provider to validate the activation-configuration properties for a JMS message-driven bean (MDB).
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * A JMS activation specification is used by the default messaging provider to validate the activation-configuration properties for a JMS message-driven bean (MDB).
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * How the session acknowledges any messages it receives.
	 */
	public String getAcknowledgeMode() {
		return this.acknowledgeMode;
	}

	/**
	 * How the session acknowledges any messages it receives.
	 */
	public void setAcknowledgeMode(String value) {
		this.acknowledgeMode = value;
	}

	/**
	 * Authentication alias.
	 */
	public String getAuthenticationAlias() {
		return this.authenticationAlias;
	}

	/**
	 * Authentication alias.
	 */
	public void setAuthenticationAlias(String value) {
		this.authenticationAlias = value;
	}

	/**
	 * Name of the bus to connect to.
	 */
	public String getBusName() {
		return this.busName;
	}

	/**
	 * Name of the bus to connect to.
	 */
	public void setBusName(String value) {
		this.busName = value;
	}

	/**
	 * Client identifier. Required for durable topic subscriptions.
	 */
	public String getClientId() {
		return this.clientId;
	}

	/**
	 * Client identifier. Required for durable topic subscriptions.
	 */
	public void setClientId(String value) {
		this.clientId = value;
	}

	/**
	 * Whether the message-driven bean uses a queue or topic destination.
	 */
	public String getDestinationType() {
		return this.destinationType;
	}

	/**
	 * Whether the message-driven bean uses a queue or topic destination.
	 */
	public void setDestinationType(String value) {
		this.destinationType = value;
	}

	/**
	 * Name of the durable subscription home. This identifies the messaging engine where all durable subscriptions accessed through this activation specification are managed.
	 */
	public String getDurableSubscriptionHome() {
		return this.durableSubscriptionHome;
	}

	/**
	 * Name of the durable subscription home. This identifies the messaging engine where all durable subscriptions accessed through this activation specification are managed.
	 */
	public void setDurableSubscriptionHome(String value) {
		this.durableSubscriptionHome = value;
	}

	/**
	 * The maximum number of messages received from the messaging engine in a single batch.
	 */
	public Integer getMaxBatchSize() {
		return this.maxBatchSize;
	}

	/**
	 * The maximum number of messages received from the messaging engine in a single batch.
	 */
	public void setMaxBatchSize(Integer value) {
		this.maxBatchSize = value;
	}

	/**
	 * The maximum number of endpoints to which messages are delivered concurrently.
	 */
	public Integer getMaxConcurrency() {
		return this.maxConcurrency;
	}

	/**
	 * The maximum number of endpoints to which messages are delivered concurrently.
	 */
	public void setMaxConcurrency(Integer value) {
		this.maxConcurrency = value;
	}

	/**
	 * The JMS message selector used to determine which messages the message-driven bean (MDB) receives.
	 */
	public String getMessageSelector() {
		return this.messageSelector;
	}

	/**
	 * The JMS message selector used to determine which messages the message-driven bean (MDB) receives.
	 */
	public void setMessageSelector(String value) {
		this.messageSelector = value;
	}

	/**
	 * Password.
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Password.
	 */
	public void setPassword(String value) {
		this.password = value;
	}

	/**
	 * Whether a JMS topic subscription is durable or nondurable.
	 */
	public String getSubscriptionDurability() {
		return this.subscriptionDurability;
	}

	/**
	 * Whether a JMS topic subscription is durable or nondurable.
	 */
	public void setSubscriptionDurability(String value) {
		this.subscriptionDurability = value;
	}

	/**
	 * The subscription name needed for durable topic subscriptions.
	 */
	public String getSubscriptionName() {
		return this.subscriptionName;
	}

	/**
	 * The subscription name needed for durable topic subscriptions.
	 */
	public void setSubscriptionName(String value) {
		this.subscriptionName = value;
	}

	/**
	 * Used to control how durable subscriptions are shared.
	 */
	public String getShareDurableSubscriptions() {
		return this.shareDurableSubscriptions;
	}

	/**
	 * Used to control how durable subscriptions are shared.
	 */
	public void setShareDurableSubscriptions(String value) {
		this.shareDurableSubscriptions = value;
	}

	/**
	 * User name.
	 */
	public String getUserName() {
		return this.userName;
	}

	/**
	 * User name.
	 */
	public void setUserName(String value) {
		this.userName = value;
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
	 * The SIB JMS activation specification new target value.
	 */
	public String getTarget() {
		return this.target;
	}

	/**
	 * The SIB JMS activation specification new target value.
	 */
	public void setTarget(String value) {
		this.target = value;
	}

	/**
	 * The SIB JMS activation specification new target type value. Legal values are "BusMember", "Custom" and "ME".
	 */
	public String getTargetType() {
		return this.targetType;
	}

	/**
	 * The SIB JMS activation specification new target type value. Legal values are "BusMember", "Custom" and "ME".
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
	 * When enabled, Object Messages received through this activation spec will only have their message data serialized by the system when absolutely necessary. The data obtained from those messages must be treated as readOnly by applications. Legal values are "true" and "false" (default).
	 */
	public String getConsumerDoesNotModifyPayloadAfterGet() {
		return this.consumerDoesNotModifyPayloadAfterGet;
	}

	/**
	 * When enabled, Object Messages received through this activation spec will only have their message data serialized by the system when absolutely necessary. The data obtained from those messages must be treated as readOnly by applications. Legal values are "true" and "false" (default).
	 */
	public void setConsumerDoesNotModifyPayloadAfterGet(String value) {
		this.consumerDoesNotModifyPayloadAfterGet = value;
	}

	/**
	 * When enabled, Object/Bytes Messages forwarded through this activation spec that have their payload modified will not have the data copied when is is set into the message and the system will only serialize the message data when absolutely necessary. Applications sending such messages must not modify the data once it has been set into the message. Legal values are "true" and "false" (default).
	 */
	public String getForwarderDoesNotModifyPayloadAfterSet() {
		return this.forwarderDoesNotModifyPayloadAfterSet;
	}

	/**
	 * When enabled, Object/Bytes Messages forwarded through this activation spec that have their payload modified will not have the data copied when is is set into the message and the system will only serialize the message data when absolutely necessary. Applications sending such messages must not modify the data once it has been set into the message. Legal values are "true" and "false" (default).
	 */
	public void setForwarderDoesNotModifyPayloadAfterSet(String value) {
		this.forwarderDoesNotModifyPayloadAfterSet = value;
	}

	/**
	 * MDB server-selection rule.  Determines which servers can drive MDBs deployed to them.  This parameter has two possible values: TRUE, FALSE.  The default is FALSE.  Specify TRUE to always activate MDBs in all servers.  Otherwise, only servers with a running messaging engine are used.
	 */
	public Boolean getAlwaysActivateAllMDBs() {
		return this.alwaysActivateAllMDBs;
	}

	/**
	 * MDB server-selection rule.  Determines which servers can drive MDBs deployed to them.  This parameter has two possible values: TRUE, FALSE.  The default is FALSE.  Specify TRUE to always activate MDBs in all servers.  Otherwise, only servers with a running messaging engine are used.
	 */
	public void setAlwaysActivateAllMDBs(Boolean value) {
		this.alwaysActivateAllMDBs = value;
	}

	/**
	 * The delay (in seconds) between attempts to connect to a messaging engine, both for the initial connection, and any subsequent attempts to establish a better connection.  The default is 30.  Must be greater than zero.
	 */
	public Integer getRetryInterval() {
		return this.retryInterval;
	}

	/**
	 * The delay (in seconds) between attempts to connect to a messaging engine, both for the initial connection, and any subsequent attempts to establish a better connection.  The default is 30.  Must be greater than zero.
	 */
	public void setRetryInterval(Integer value) {
		this.retryInterval = value;
	}

	/**
	 * The endpoint will be stopped when the number of sequentially failing messages reaches the configured limit. Due to processing dependencies in the MDB the actual number of messages processed may exceed this value.
	 */
	public Integer getAutoStopSequentialMessageFailure() {
		return this.autoStopSequentialMessageFailure;
	}

	/**
	 * The endpoint will be stopped when the number of sequentially failing messages reaches the configured limit. Due to processing dependencies in the MDB the actual number of messages processed may exceed this value.
	 */
	public void setAutoStopSequentialMessageFailure(Integer value) {
		this.autoStopSequentialMessageFailure = value;
	}

	/**
	 * Any message that fails to be processed by the MDB but has not reached its maximum failed delivery limit will only be retried after this period of time has passed. Other messages may be tried during this period, unless the sequential failure threshold and the maximum concurrency is set to 1 millisecond.
	 */
	public Long getFailingMessageDelay() {
		return this.failingMessageDelay;
	}

	/**
	 * Any message that fails to be processed by the MDB but has not reached its maximum failed delivery limit will only be retried after this period of time has passed. Other messages may be tried during this period, unless the sequential failure threshold and the maximum concurrency is set to 1 millisecond.
	 */
	public void setFailingMessageDelay(Long value) {
		this.failingMessageDelay = value;
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
		ret.put("destinationJndiName", this.destinationJndiName);
		if (this.description != null) {
			ret.put("description", this.description);
		}
		if (this.acknowledgeMode != null) {
			ret.put("acknowledgeMode", this.acknowledgeMode);
		}
		if (this.authenticationAlias != null) {
			ret.put("authenticationAlias", this.authenticationAlias);
		}
		if (this.busName != null) {
			ret.put("busName", this.busName);
		}
		if (this.clientId != null) {
			ret.put("clientId", this.clientId);
		}
		if (this.destinationType != null) {
			ret.put("destinationType", this.destinationType);
		}
		if (this.durableSubscriptionHome != null) {
			ret.put("durableSubscriptionHome", this.durableSubscriptionHome);
		}
		if (this.maxBatchSize != null) {
			ret.put("maxBatchSize", this.maxBatchSize);
		}
		if (this.maxConcurrency != null) {
			ret.put("maxConcurrency", this.maxConcurrency);
		}
		if (this.messageSelector != null) {
			ret.put("messageSelector", this.messageSelector);
		}
		if (this.password != null) {
			ret.put("password", this.password);
		}
		if (this.subscriptionDurability != null) {
			ret.put("subscriptionDurability", this.subscriptionDurability);
		}
		if (this.subscriptionName != null) {
			ret.put("subscriptionName", this.subscriptionName);
		}
		if (this.shareDurableSubscriptions != null) {
			ret.put("shareDurableSubscriptions", this.shareDurableSubscriptions);
		}
		if (this.userName != null) {
			ret.put("userName", this.userName);
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
		if (this.shareDataSourceWithCMP != null) {
			ret.put("shareDataSourceWithCMP", this.shareDataSourceWithCMP);
		}
		if (this.consumerDoesNotModifyPayloadAfterGet != null) {
			ret.put("consumerDoesNotModifyPayloadAfterGet", this.consumerDoesNotModifyPayloadAfterGet);
		}
		if (this.forwarderDoesNotModifyPayloadAfterSet != null) {
			ret.put("forwarderDoesNotModifyPayloadAfterSet", this.forwarderDoesNotModifyPayloadAfterSet);
		}
		if (this.alwaysActivateAllMDBs != null) {
			ret.put("alwaysActivateAllMDBs", this.alwaysActivateAllMDBs);
		}
		if (this.retryInterval != null) {
			ret.put("retryInterval", this.retryInterval);
		}
		if (this.autoStopSequentialMessageFailure != null) {
			ret.put("autoStopSequentialMessageFailure", this.autoStopSequentialMessageFailure);
		}
		if (this.failingMessageDelay != null) {
			ret.put("failingMessageDelay", this.failingMessageDelay);
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
