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

package com.ibm.websphere.simplicity.commands.wmqadmin;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;
import java.util.ArrayList;
import com.ibm.websphere.simplicity.commands.CommandStep;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Creates a WMQ Activation Specification at the scope provided to the command.
 *   'authAlias': The authentication alias used to obtain the credentials specified when this activation specification needs to establish a connection to WebSphere MQ.
 *   'brokerCCDurSubQueue': The name of the queue from which a connection consumer receives durable subscription messages.
 *   'brokerCCSubQueue': The name of the queue from which non-durable subscription messages are retrieved for a ConnectionConsumer.
 *   'brokerCtrlQueue': The broker control queue to use if this activation specification is to subscribe to a topic.
 *   'brokerQmgr': The name of the queue manager on which the broker is running.
 *   'brokerSubQueue': The queue to use for obtaining subscription messages if this activation specification is to subscribe to a topic.
 *   'brokerVersion': Determines the level of functionality required for publish/subscribe operations.
 *   'ccdtQmgrName': A queue manager name, used to select one or more entries from a client channel definition table.
 *   'ccdtUrl': A URL to a client channel definition table to use, for this activation specification, when contacting WMQ. Activation specifications created using this parameter are of "ccdtURL" variety.
 *   'ccsid': The coded-character-set-ID to be used on connections.
 *   'cleanupInterval': The interval between background executions of the publish/subscribe cleanup utility.
 *   'cleanupLevel': Cleanup Level for BROKER or MIGRATE Subscription Stores.
 *   'clientId': The client identifier used for connections started using this activation specification.
 *   'clonedSubs': Whether two or more instances of the same durable topic subscriber can run simultaneously.
 *   'compressHeaders': Determines if message headers are compressed or not.
 *   'compressPayload': Determines if message payloads are compressed or not.
 *   'description': An administrative description assigned to the activation specification.
 *   'destinationJndiName': The JNDI name of a WMQ JMS RA queue or topic type destination. When an MDB is deployed with this activation specification, it is this destination that messages for the MDB will be consumed from.
 *   'destinationType': The type of the destination specified using the destinationJndiName parameter.
 *   'failIfQuiescing': Determines the behavior of certain calls to the queue manager when the queue manager is put into quiescing state.
 *   'failureDeliveryCount': The number of sequential delivery failures that are allowed before the endpoint is suspended.
 *   'jndiName': The name and location used to bind this object into WAS JNDI.
 *   'maxPoolSize': The maximum number of server sessions in the server session pool used by the connection consumer.
 *   'messageSelector': A message selector expression specifying which messages are to be delivered.
 *   'msgRetention': Determines whether or not the connection consumer keeps unwanted messages on the input queue. A value of true means that it does. A value of false means that the messages are disposed of as per their disposition options.
 *   'msgSelection': Determines where message selection occurs.
 *   'name': The administrative name assigned to the activation specification.
 *   'poolTimeout': The period of time, in milliseconds, that an unused server session is held open in the server session pool before being closed due to inactivity.
 *   'providerVersion': Determines the minimum version, and capabilities of the queue manager.
 *   'qmgrHostname': The hostname which will be used, for this activation specification, when attempting a client mode connection to WMQ.
 *   'qmgrName': The name of the queue manager to use, for this activation specification, when contacting WMQ. Activation specifications created using this parameter are of "user defined" variety.
 *   'qmgrPortNumber': The port number to use, for this activation specification, when attempting a client mode connection to WMQ.
 *   'qmgrSvrconnChannel': The SVRCONN channel to use when connecting to WebSphere MQ. Specifying this property signifies that the activation specification is of the "user defined" variety.
 *   'rcvExitInitData': Initialization data to pass to the receive exit.
 *   'rcvExit': A comma separated list of receive exit class names.
 *   'rescanInterval': When a message consumer in the point-to-point domain uses a message selector to select which messages it wants to receive, the WebSphere MQ JMS client searches the WebSphere MQ queue for suitable messages in the sequence determined by the MsgDeliverySequence attribute of the queue. When the client finds a suitable message and delivers it to the consumer, the client resumes the search for the next suitable message from its current position in the queue. The client continues to search the queue in this way until it reaches the end of the queue, or until the interval of time in milliseconds, as determined by the value of this property, has expired. In each case, the client returns to the beginning of the queue to continue its search, and a new time interval commences.
 *   'secExitInitData': Initialization data to pass to the security exit.
 *   'secExit': A security exit class name.
 *   'sendExitInitData': Initialization data to pass to the send exit.
 *   'sendExit': A comma separate list of send exit class names.
 *   'sparseSubs': Controls the message retrieval policy of a TopicSubscriber object.
 *   'sslConfiguration': Names a specific SSL configuration to use when using SSL to secure network connections to the queue manager.
 *   'sslCrl': Specifies a list of LDAP servers which may be used to provide certificate revocation information if this activation specification establishes a SSL based connection to WMQ.
 *   'sslPeerName': Used when the activation specification establishes an SSL connection to the queue manager. This value is used to match against the distinguished name present in the peers certificate.
 *   'sslResetCount': Used when the activation specification establishes an SSL connection to the queue manager. This parameter determines how many bytes to transfer before resetting the symmetric encryption key used for the SSL session.
 *   'sslType': Determines the configuration, if any, to use when applying SSL encryption to the network connection to the queue manager.
 *   'startTimeout': The period of time, in milliseconds, within which delivery of a message to an MDB must start after the work to deliver the message has been scheduled. If this period of time elapses, the message is rolled back onto the queue.
 *   'stateRefreshInt': The interval, in milliseconds, between refreshes of the long running transaction that detects when a subscriber loses its connection to the queue manager. This property is relevant only if subStore parameter has the value QUEUE.
 *   'stopEndpointIfDeliveryFails': Indicates whether the endpoint should be stopped if message delivery fails the number of times specified by the failureDeliveryCount property.
 *   'subscriptionDurability': Whether a durable or nondurable subscription is used to deliver messages to an MDB subscribing to the topic.
 *   'subscriptionName': The name of the durable subscription.
 *   'subStore': Where WebSphere MQ JMS should store persistent data relating to active subscriptions.
 *   'wildcardFormat': Determines which sets of characters are interpreted as topic wildcards.
 *   'wmqTransportType': Determines the manner in which, for this activation specification, a connection will be established to WMQ. Activation specifications created using this parameter are of "user defined" variety. Valid values are "BINDINGS", "BINDINGS_THEN_CLIENT" and "CLIENT".
 *   'localAddress': This property specifies either or both of the following: a) The local network interface to be used b) The local port, or range of local ports, to be used.
 * The required parameters are found in the constructor.
 */
public class CreateWMQActivationSpec extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private List<Command> __steps;
	private String authAlias;
	private String brokerCCDurSubQueue = "SYSTEM.JMS.D.CC.SUBSCRIBER.QUEUE";
	private String brokerCCSubQueue = "SYSTEM.JMS.ND.CC.SUBSCRIBER.QUEUE";
	private String brokerCtrlQueue = "SYSTEM.BROKER.CONTROL.QUEUE";
	private String brokerQmgr;
	private String brokerSubQueue = "SYSTEM.JMS.ND.SUBSCRIBER.QUEUE";
	private String brokerVersion = "1";
	private String ccdtQmgrName;
	private String ccdtUrl;
	private Integer ccsid = 819;
	private Long cleanupInterval = 3600000L;
	private String cleanupLevel = "SAFE";
	private String clientId;
	private String clonedSubs = "DISABLED";
	private String compressHeaders = "NONE";
	private String compressPayload = "NONE";
	private String description;
	private String destinationJndiName;
	private String destinationType;
	private Boolean failIfQuiescing = true;
	private Integer failureDeliveryCount = 0;
	private String jndiName;
	private Integer maxPoolSize = 10;
	private String messageSelector;
	private String msgRetention;
	private String msgSelection = "CLIENT";
	private String name;
	private Integer poolTimeout = 300000;
	private String providerVersion;
	private String qmgrHostname;
	private String qmgrName;
	private Integer qmgrPortNumber;
	private String qmgrSvrconnChannel;
	private String rcvExitInitData;
	private String rcvExit;
	private Integer rescanInterval = 5000;
	private String secExitInitData;
	private String secExit;
	private String sendExitInitData;
	private String sendExit;
	private Boolean sparseSubs = false;
	private String sslConfiguration;
	private String sslCrl;
	private String sslPeerName;
	private Integer sslResetCount = 0;
	private String sslType = "NONE";
	private Integer startTimeout = 10000;
	private Integer stateRefreshInt = 60000;
	private Boolean stopEndpointIfDeliveryFails = true;
	private String subscriptionDurability = "Nondurable";
	private String subscriptionName;
	private String subStore = "MIGRATE";
	private String wildcardFormat;
	private String wmqTransportType;
	private String localAddress;

	public CreateWMQActivationSpec(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String destinationJndiName, String destinationType, String jndiName, String name) {
		super("createWMQActivationSpec");
		this.__target = commandTarget;
		this.destinationJndiName = destinationJndiName;
		this.destinationType = destinationType;
		this.jndiName = jndiName;
		this.name = name;
	}

	/**
	 * The authentication alias used to obtain the credentials specified when this activation specification needs to establish a connection to WebSphere MQ.
	 */
	public String getAuthAlias() {
		return this.authAlias;
	}

	/**
	 * The authentication alias used to obtain the credentials specified when this activation specification needs to establish a connection to WebSphere MQ.
	 */
	public void setAuthAlias(String value) {
		this.authAlias = value;
	}

	/**
	 * The name of the queue from which a connection consumer receives durable subscription messages.
	 */
	public String getBrokerCCDurSubQueue() {
		return this.brokerCCDurSubQueue;
	}

	/**
	 * The name of the queue from which a connection consumer receives durable subscription messages.
	 */
	public void setBrokerCCDurSubQueue(String value) {
		this.brokerCCDurSubQueue = value;
	}

	/**
	 * The name of the queue from which non-durable subscription messages are retrieved for a ConnectionConsumer.
	 */
	public String getBrokerCCSubQueue() {
		return this.brokerCCSubQueue;
	}

	/**
	 * The name of the queue from which non-durable subscription messages are retrieved for a ConnectionConsumer.
	 */
	public void setBrokerCCSubQueue(String value) {
		this.brokerCCSubQueue = value;
	}

	/**
	 * The broker control queue to use if this activation specification is to subscribe to a topic.
	 */
	public String getBrokerCtrlQueue() {
		return this.brokerCtrlQueue;
	}

	/**
	 * The broker control queue to use if this activation specification is to subscribe to a topic.
	 */
	public void setBrokerCtrlQueue(String value) {
		this.brokerCtrlQueue = value;
	}

	/**
	 * The name of the queue manager on which the broker is running.
	 */
	public String getBrokerQmgr() {
		return this.brokerQmgr;
	}

	/**
	 * The name of the queue manager on which the broker is running.
	 */
	public void setBrokerQmgr(String value) {
		this.brokerQmgr = value;
	}

	/**
	 * The queue to use for obtaining subscription messages if this activation specification is to subscribe to a topic.
	 */
	public String getBrokerSubQueue() {
		return this.brokerSubQueue;
	}

	/**
	 * The queue to use for obtaining subscription messages if this activation specification is to subscribe to a topic.
	 */
	public void setBrokerSubQueue(String value) {
		this.brokerSubQueue = value;
	}

	/**
	 * Determines the level of functionality required for publish/subscribe operations.
	 */
	public String getBrokerVersion() {
		return this.brokerVersion;
	}

	/**
	 * Determines the level of functionality required for publish/subscribe operations.
	 */
	public void setBrokerVersion(String value) {
		this.brokerVersion = value;
	}

	/**
	 * A queue manager name, used to select one or more entries from a client channel definition table.
	 */
	public String getCcdtQmgrName() {
		return this.ccdtQmgrName;
	}

	/**
	 * A queue manager name, used to select one or more entries from a client channel definition table.
	 */
	public void setCcdtQmgrName(String value) {
		this.ccdtQmgrName = value;
	}

	/**
	 * A URL to a client channel definition table to use, for this activation specification, when contacting WMQ. Activation specifications created using this parameter are of "ccdtURL" variety.
	 */
	public String getCcdtUrl() {
		return this.ccdtUrl;
	}

	/**
	 * A URL to a client channel definition table to use, for this activation specification, when contacting WMQ. Activation specifications created using this parameter are of "ccdtURL" variety.
	 */
	public void setCcdtUrl(String value) {
		this.ccdtUrl = value;
	}

	/**
	 * The coded-character-set-ID to be used on connections.
	 */
	public Integer getCcsid() {
		return this.ccsid;
	}

	/**
	 * The coded-character-set-ID to be used on connections.
	 */
	public void setCcsid(Integer value) {
		this.ccsid = value;
	}

	/**
	 * The interval between background executions of the publish/subscribe cleanup utility.
	 */
	public Long getCleanupInterval() {
		return this.cleanupInterval;
	}

	/**
	 * The interval between background executions of the publish/subscribe cleanup utility.
	 */
	public void setCleanupInterval(Long value) {
		this.cleanupInterval = value;
	}

	/**
	 * Cleanup Level for BROKER or MIGRATE Subscription Stores.
	 */
	public String getCleanupLevel() {
		return this.cleanupLevel;
	}

	/**
	 * Cleanup Level for BROKER or MIGRATE Subscription Stores.
	 */
	public void setCleanupLevel(String value) {
		this.cleanupLevel = value;
	}

	/**
	 * The client identifier used for connections started using this activation specification.
	 */
	public String getClientId() {
		return this.clientId;
	}

	/**
	 * The client identifier used for connections started using this activation specification.
	 */
	public void setClientId(String value) {
		this.clientId = value;
	}

	/**
	 * Whether two or more instances of the same durable topic subscriber can run simultaneously.
	 */
	public String getClonedSubs() {
		return this.clonedSubs;
	}

	/**
	 * Whether two or more instances of the same durable topic subscriber can run simultaneously.
	 */
	public void setClonedSubs(String value) {
		this.clonedSubs = value;
	}

	/**
	 * Determines if message headers are compressed or not.
	 */
	public String getCompressHeaders() {
		return this.compressHeaders;
	}

	/**
	 * Determines if message headers are compressed or not.
	 */
	public void setCompressHeaders(String value) {
		this.compressHeaders = value;
	}

	/**
	 * Determines if message payloads are compressed or not.
	 */
	public String getCompressPayload() {
		return this.compressPayload;
	}

	/**
	 * Determines if message payloads are compressed or not.
	 */
	public void setCompressPayload(String value) {
		this.compressPayload = value;
	}

	/**
	 * An administrative description assigned to the activation specification.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * An administrative description assigned to the activation specification.
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * The JNDI name of a WMQ JMS RA queue or topic type destination. When an MDB is deployed with this activation specification, it is this destination that messages for the MDB will be consumed from.
	 */
	public String getDestinationJndiName() {
		return this.destinationJndiName;
	}

	/**
	 * The JNDI name of a WMQ JMS RA queue or topic type destination. When an MDB is deployed with this activation specification, it is this destination that messages for the MDB will be consumed from.
	 */
	public void setDestinationJndiName(String value) {
		this.destinationJndiName = value;
	}

	/**
	 * The type of the destination specified using the destinationJndiName parameter.
	 */
	public String getDestinationType() {
		return this.destinationType;
	}

	/**
	 * The type of the destination specified using the destinationJndiName parameter.
	 */
	public void setDestinationType(String value) {
		this.destinationType = value;
	}

	/**
	 * Determines the behavior of certain calls to the queue manager when the queue manager is put into quiescing state.
	 */
	public Boolean getFailIfQuiescing() {
		return this.failIfQuiescing;
	}

	/**
	 * Determines the behavior of certain calls to the queue manager when the queue manager is put into quiescing state.
	 */
	public void setFailIfQuiescing(Boolean value) {
		this.failIfQuiescing = value;
	}

	/**
	 * The number of sequential delivery failures that are allowed before the endpoint is suspended.
	 */
	public Integer getFailureDeliveryCount() {
		return this.failureDeliveryCount;
	}

	/**
	 * The number of sequential delivery failures that are allowed before the endpoint is suspended.
	 */
	public void setFailureDeliveryCount(Integer value) {
		this.failureDeliveryCount = value;
	}

	/**
	 * The name and location used to bind this object into WAS JNDI.
	 */
	public String getJndiName() {
		return this.jndiName;
	}

	/**
	 * The name and location used to bind this object into WAS JNDI.
	 */
	public void setJndiName(String value) {
		this.jndiName = value;
	}

	/**
	 * The maximum number of server sessions in the server session pool used by the connection consumer.
	 */
	public Integer getMaxPoolSize() {
		return this.maxPoolSize;
	}

	/**
	 * The maximum number of server sessions in the server session pool used by the connection consumer.
	 */
	public void setMaxPoolSize(Integer value) {
		this.maxPoolSize = value;
	}

	/**
	 * A message selector expression specifying which messages are to be delivered.
	 */
	public String getMessageSelector() {
		return this.messageSelector;
	}

	/**
	 * A message selector expression specifying which messages are to be delivered.
	 */
	public void setMessageSelector(String value) {
		this.messageSelector = value;
	}

	/**
	 * Determines whether or not the connection consumer keeps unwanted messages on the input queue. A value of true means that it does. A value of false means that the messages are disposed of as per their disposition options.
	 */
	public String getMsgRetention() {
		return this.msgRetention;
	}

	/**
	 * Determines whether or not the connection consumer keeps unwanted messages on the input queue. A value of true means that it does. A value of false means that the messages are disposed of as per their disposition options.
	 */
	public void setMsgRetention(String value) {
		this.msgRetention = value;
	}

	/**
	 * Determines where message selection occurs.
	 */
	public String getMsgSelection() {
		return this.msgSelection;
	}

	/**
	 * Determines where message selection occurs.
	 */
	public void setMsgSelection(String value) {
		this.msgSelection = value;
	}

	/**
	 * The administrative name assigned to the activation specification.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The administrative name assigned to the activation specification.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * The period of time, in milliseconds, that an unused server session is held open in the server session pool before being closed due to inactivity.
	 */
	public Integer getPoolTimeout() {
		return this.poolTimeout;
	}

	/**
	 * The period of time, in milliseconds, that an unused server session is held open in the server session pool before being closed due to inactivity.
	 */
	public void setPoolTimeout(Integer value) {
		this.poolTimeout = value;
	}

	/**
	 * Determines the minimum version, and capabilities of the queue manager.
	 */
	public String getProviderVersion() {
		return this.providerVersion;
	}

	/**
	 * Determines the minimum version, and capabilities of the queue manager.
	 */
	public void setProviderVersion(String value) {
		this.providerVersion = value;
	}

	/**
	 * The hostname which will be used, for this activation specification, when attempting a client mode connection to WMQ.
	 */
	public String getQmgrHostname() {
		return this.qmgrHostname;
	}

	/**
	 * The hostname which will be used, for this activation specification, when attempting a client mode connection to WMQ.
	 */
	public void setQmgrHostname(String value) {
		this.qmgrHostname = value;
	}

	/**
	 * The name of the queue manager to use, for this activation specification, when contacting WMQ. Activation specifications created using this parameter are of "user defined" variety.
	 */
	public String getQmgrName() {
		return this.qmgrName;
	}

	/**
	 * The name of the queue manager to use, for this activation specification, when contacting WMQ. Activation specifications created using this parameter are of "user defined" variety.
	 */
	public void setQmgrName(String value) {
		this.qmgrName = value;
	}

	/**
	 * The port number to use, for this activation specification, when attempting a client mode connection to WMQ.
	 */
	public Integer getQmgrPortNumber() {
		return this.qmgrPortNumber;
	}

	/**
	 * The port number to use, for this activation specification, when attempting a client mode connection to WMQ.
	 */
	public void setQmgrPortNumber(Integer value) {
		this.qmgrPortNumber = value;
	}

	/**
	 * The SVRCONN channel to use when connecting to WebSphere MQ. Specifying this property signifies that the activation specification is of the "user defined" variety.
	 */
	public String getQmgrSvrconnChannel() {
		return this.qmgrSvrconnChannel;
	}

	/**
	 * The SVRCONN channel to use when connecting to WebSphere MQ. Specifying this property signifies that the activation specification is of the "user defined" variety.
	 */
	public void setQmgrSvrconnChannel(String value) {
		this.qmgrSvrconnChannel = value;
	}

	/**
	 * Initialization data to pass to the receive exit.
	 */
	public String getRcvExitInitData() {
		return this.rcvExitInitData;
	}

	/**
	 * Initialization data to pass to the receive exit.
	 */
	public void setRcvExitInitData(String value) {
		this.rcvExitInitData = value;
	}

	/**
	 * A comma separated list of receive exit class names.
	 */
	public String getRcvExit() {
		return this.rcvExit;
	}

	/**
	 * A comma separated list of receive exit class names.
	 */
	public void setRcvExit(String value) {
		this.rcvExit = value;
	}

	/**
	 * When a message consumer in the point-to-point domain uses a message selector to select which messages it wants to receive, the WebSphere MQ JMS client searches the WebSphere MQ queue for suitable messages in the sequence determined by the MsgDeliverySequence attribute of the queue. When the client finds a suitable message and delivers it to the consumer, the client resumes the search for the next suitable message from its current position in the queue. The client continues to search the queue in this way until it reaches the end of the queue, or until the interval of time in milliseconds, as determined by the value of this property, has expired. In each case, the client returns to the beginning of the queue to continue its search, and a new time interval commences.
	 */
	public Integer getRescanInterval() {
		return this.rescanInterval;
	}

	/**
	 * When a message consumer in the point-to-point domain uses a message selector to select which messages it wants to receive, the WebSphere MQ JMS client searches the WebSphere MQ queue for suitable messages in the sequence determined by the MsgDeliverySequence attribute of the queue. When the client finds a suitable message and delivers it to the consumer, the client resumes the search for the next suitable message from its current position in the queue. The client continues to search the queue in this way until it reaches the end of the queue, or until the interval of time in milliseconds, as determined by the value of this property, has expired. In each case, the client returns to the beginning of the queue to continue its search, and a new time interval commences.
	 */
	public void setRescanInterval(Integer value) {
		this.rescanInterval = value;
	}

	/**
	 * Initialization data to pass to the security exit.
	 */
	public String getSecExitInitData() {
		return this.secExitInitData;
	}

	/**
	 * Initialization data to pass to the security exit.
	 */
	public void setSecExitInitData(String value) {
		this.secExitInitData = value;
	}

	/**
	 * A security exit class name.
	 */
	public String getSecExit() {
		return this.secExit;
	}

	/**
	 * A security exit class name.
	 */
	public void setSecExit(String value) {
		this.secExit = value;
	}

	/**
	 * Initialization data to pass to the send exit.
	 */
	public String getSendExitInitData() {
		return this.sendExitInitData;
	}

	/**
	 * Initialization data to pass to the send exit.
	 */
	public void setSendExitInitData(String value) {
		this.sendExitInitData = value;
	}

	/**
	 * A comma separate list of send exit class names.
	 */
	public String getSendExit() {
		return this.sendExit;
	}

	/**
	 * A comma separate list of send exit class names.
	 */
	public void setSendExit(String value) {
		this.sendExit = value;
	}

	/**
	 * Controls the message retrieval policy of a TopicSubscriber object.
	 */
	public Boolean getSparseSubs() {
		return this.sparseSubs;
	}

	/**
	 * Controls the message retrieval policy of a TopicSubscriber object.
	 */
	public void setSparseSubs(Boolean value) {
		this.sparseSubs = value;
	}

	/**
	 * Names a specific SSL configuration to use when using SSL to secure network connections to the queue manager.
	 */
	public String getSslConfiguration() {
		return this.sslConfiguration;
	}

	/**
	 * Names a specific SSL configuration to use when using SSL to secure network connections to the queue manager.
	 */
	public void setSslConfiguration(String value) {
		this.sslConfiguration = value;
	}

	/**
	 * Specifies a list of LDAP servers which may be used to provide certificate revocation information if this activation specification establishes a SSL based connection to WMQ.
	 */
	public String getSslCrl() {
		return this.sslCrl;
	}

	/**
	 * Specifies a list of LDAP servers which may be used to provide certificate revocation information if this activation specification establishes a SSL based connection to WMQ.
	 */
	public void setSslCrl(String value) {
		this.sslCrl = value;
	}

	/**
	 * Used when the activation specification establishes an SSL connection to the queue manager. This value is used to match against the distinguished name present in the peers certificate.
	 */
	public String getSslPeerName() {
		return this.sslPeerName;
	}

	/**
	 * Used when the activation specification establishes an SSL connection to the queue manager. This value is used to match against the distinguished name present in the peers certificate.
	 */
	public void setSslPeerName(String value) {
		this.sslPeerName = value;
	}

	/**
	 * Used when the activation specification establishes an SSL connection to the queue manager. This parameter determines how many bytes to transfer before resetting the symmetric encryption key used for the SSL session.
	 */
	public Integer getSslResetCount() {
		return this.sslResetCount;
	}

	/**
	 * Used when the activation specification establishes an SSL connection to the queue manager. This parameter determines how many bytes to transfer before resetting the symmetric encryption key used for the SSL session.
	 */
	public void setSslResetCount(Integer value) {
		this.sslResetCount = value;
	}

	/**
	 * Determines the configuration, if any, to use when applying SSL encryption to the network connection to the queue manager.
	 */
	public String getSslType() {
		return this.sslType;
	}

	/**
	 * Determines the configuration, if any, to use when applying SSL encryption to the network connection to the queue manager.
	 */
	public void setSslType(String value) {
		this.sslType = value;
	}

	/**
	 * The period of time, in milliseconds, within which delivery of a message to an MDB must start after the work to deliver the message has been scheduled. If this period of time elapses, the message is rolled back onto the queue.
	 */
	public Integer getStartTimeout() {
		return this.startTimeout;
	}

	/**
	 * The period of time, in milliseconds, within which delivery of a message to an MDB must start after the work to deliver the message has been scheduled. If this period of time elapses, the message is rolled back onto the queue.
	 */
	public void setStartTimeout(Integer value) {
		this.startTimeout = value;
	}

	/**
	 * The interval, in milliseconds, between refreshes of the long running transaction that detects when a subscriber loses its connection to the queue manager. This property is relevant only if subStore parameter has the value QUEUE.
	 */
	public Integer getStateRefreshInt() {
		return this.stateRefreshInt;
	}

	/**
	 * The interval, in milliseconds, between refreshes of the long running transaction that detects when a subscriber loses its connection to the queue manager. This property is relevant only if subStore parameter has the value QUEUE.
	 */
	public void setStateRefreshInt(Integer value) {
		this.stateRefreshInt = value;
	}

	/**
	 * Indicates whether the endpoint should be stopped if message delivery fails the number of times specified by the failureDeliveryCount property.
	 */
	public Boolean getStopEndpointIfDeliveryFails() {
		return this.stopEndpointIfDeliveryFails;
	}

	/**
	 * Indicates whether the endpoint should be stopped if message delivery fails the number of times specified by the failureDeliveryCount property.
	 */
	public void setStopEndpointIfDeliveryFails(Boolean value) {
		this.stopEndpointIfDeliveryFails = value;
	}

	/**
	 * Whether a durable or nondurable subscription is used to deliver messages to an MDB subscribing to the topic.
	 */
	public String getSubscriptionDurability() {
		return this.subscriptionDurability;
	}

	/**
	 * Whether a durable or nondurable subscription is used to deliver messages to an MDB subscribing to the topic.
	 */
	public void setSubscriptionDurability(String value) {
		this.subscriptionDurability = value;
	}

	/**
	 * The name of the durable subscription.
	 */
	public String getSubscriptionName() {
		return this.subscriptionName;
	}

	/**
	 * The name of the durable subscription.
	 */
	public void setSubscriptionName(String value) {
		this.subscriptionName = value;
	}

	/**
	 * Where WebSphere MQ JMS should store persistent data relating to active subscriptions.
	 */
	public String getSubStore() {
		return this.subStore;
	}

	/**
	 * Where WebSphere MQ JMS should store persistent data relating to active subscriptions.
	 */
	public void setSubStore(String value) {
		this.subStore = value;
	}

	/**
	 * Determines which sets of characters are interpreted as topic wildcards.
	 */
	public String getWildcardFormat() {
		return this.wildcardFormat;
	}

	/**
	 * Determines which sets of characters are interpreted as topic wildcards.
	 */
	public void setWildcardFormat(String value) {
		this.wildcardFormat = value;
	}

	/**
	 * Determines the manner in which, for this activation specification, a connection will be established to WMQ. Activation specifications created using this parameter are of "user defined" variety. Valid values are "BINDINGS", "BINDINGS_THEN_CLIENT" and "CLIENT".
	 */
	public String getWmqTransportType() {
		return this.wmqTransportType;
	}

	/**
	 * Determines the manner in which, for this activation specification, a connection will be established to WMQ. Activation specifications created using this parameter are of "user defined" variety. Valid values are "BINDINGS", "BINDINGS_THEN_CLIENT" and "CLIENT".
	 */
	public void setWmqTransportType(String value) {
		this.wmqTransportType = value;
	}

	/**
	 * This property specifies either or both of the following: a) The local network interface to be used b) The local port, or range of local ports, to be used.
	 */
	public String getLocalAddress() {
		return this.localAddress;
	}

	/**
	 * This property specifies either or both of the following: a) The local network interface to be used b) The local port, or range of local ports, to be used.
	 */
	public void setLocalAddress(String value) {
		this.localAddress = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.authAlias != null) {
			ret.put("authAlias", this.authAlias);
		}
		if (this.brokerCCDurSubQueue != null) {
			ret.put("brokerCCDurSubQueue", this.brokerCCDurSubQueue);
		}
		if (this.brokerCCSubQueue != null) {
			ret.put("brokerCCSubQueue", this.brokerCCSubQueue);
		}
		if (this.brokerCtrlQueue != null) {
			ret.put("brokerCtrlQueue", this.brokerCtrlQueue);
		}
		if (this.brokerQmgr != null) {
			ret.put("brokerQmgr", this.brokerQmgr);
		}
		if (this.brokerSubQueue != null) {
			ret.put("brokerSubQueue", this.brokerSubQueue);
		}
		if (this.brokerVersion != null) {
			ret.put("brokerVersion", this.brokerVersion);
		}
		if (this.ccdtQmgrName != null) {
			ret.put("ccdtQmgrName", this.ccdtQmgrName);
		}
		if (this.ccdtUrl != null) {
			ret.put("ccdtUrl", this.ccdtUrl);
		}
		if (this.ccsid != null) {
			ret.put("ccsid", this.ccsid);
		}
		if (this.cleanupInterval != null) {
			ret.put("cleanupInterval", this.cleanupInterval);
		}
		if (this.cleanupLevel != null) {
			ret.put("cleanupLevel", this.cleanupLevel);
		}
		if (this.clientId != null) {
			ret.put("clientId", this.clientId);
		}
		if (this.clonedSubs != null) {
			ret.put("clonedSubs", this.clonedSubs);
		}
		if (this.compressHeaders != null) {
			ret.put("compressHeaders", this.compressHeaders);
		}
		if (this.compressPayload != null) {
			ret.put("compressPayload", this.compressPayload);
		}
		if (this.description != null) {
			ret.put("description", this.description);
		}
		ret.put("destinationJndiName", this.destinationJndiName);
		ret.put("destinationType", this.destinationType);
		if (this.failIfQuiescing != null) {
			ret.put("failIfQuiescing", this.failIfQuiescing);
		}
		if (this.failureDeliveryCount != null) {
			ret.put("failureDeliveryCount", this.failureDeliveryCount);
		}
		ret.put("jndiName", this.jndiName);
		if (this.maxPoolSize != null) {
			ret.put("maxPoolSize", this.maxPoolSize);
		}
		if (this.messageSelector != null) {
			ret.put("messageSelector", this.messageSelector);
		}
		if (this.msgRetention != null) {
			ret.put("msgRetention", this.msgRetention);
		}
		if (this.msgSelection != null) {
			ret.put("msgSelection", this.msgSelection);
		}
		ret.put("name", this.name);
		if (this.poolTimeout != null) {
			ret.put("poolTimeout", this.poolTimeout);
		}
		if (this.providerVersion != null) {
			ret.put("providerVersion", this.providerVersion);
		}
		if (this.qmgrHostname != null) {
			ret.put("qmgrHostname", this.qmgrHostname);
		}
		if (this.qmgrName != null) {
			ret.put("qmgrName", this.qmgrName);
		}
		if (this.qmgrPortNumber != null) {
			ret.put("qmgrPortNumber", this.qmgrPortNumber);
		}
		if (this.qmgrSvrconnChannel != null) {
			ret.put("qmgrSvrconnChannel", this.qmgrSvrconnChannel);
		}
		if (this.rcvExitInitData != null) {
			ret.put("rcvExitInitData", this.rcvExitInitData);
		}
		if (this.rcvExit != null) {
			ret.put("rcvExit", this.rcvExit);
		}
		if (this.rescanInterval != null) {
			ret.put("rescanInterval", this.rescanInterval);
		}
		if (this.secExitInitData != null) {
			ret.put("secExitInitData", this.secExitInitData);
		}
		if (this.secExit != null) {
			ret.put("secExit", this.secExit);
		}
		if (this.sendExitInitData != null) {
			ret.put("sendExitInitData", this.sendExitInitData);
		}
		if (this.sendExit != null) {
			ret.put("sendExit", this.sendExit);
		}
		if (this.sparseSubs != null) {
			ret.put("sparseSubs", this.sparseSubs);
		}
		if (this.sslConfiguration != null) {
			ret.put("sslConfiguration", this.sslConfiguration);
		}
		if (this.sslCrl != null) {
			ret.put("sslCrl", this.sslCrl);
		}
		if (this.sslPeerName != null) {
			ret.put("sslPeerName", this.sslPeerName);
		}
		if (this.sslResetCount != null) {
			ret.put("sslResetCount", this.sslResetCount);
		}
		if (this.sslType != null) {
			ret.put("sslType", this.sslType);
		}
		if (this.startTimeout != null) {
			ret.put("startTimeout", this.startTimeout);
		}
		if (this.stateRefreshInt != null) {
			ret.put("stateRefreshInt", this.stateRefreshInt);
		}
		if (this.stopEndpointIfDeliveryFails != null) {
			ret.put("stopEndpointIfDeliveryFails", this.stopEndpointIfDeliveryFails);
		}
		if (this.subscriptionDurability != null) {
			ret.put("subscriptionDurability", this.subscriptionDurability);
		}
		if (this.subscriptionName != null) {
			ret.put("subscriptionName", this.subscriptionName);
		}
		if (this.subStore != null) {
			ret.put("subStore", this.subStore);
		}
		if (this.wildcardFormat != null) {
			ret.put("wildcardFormat", this.wildcardFormat);
		}
		if (this.wmqTransportType != null) {
			ret.put("wmqTransportType", this.wmqTransportType);
		}
		if (this.localAddress != null) {
			ret.put("localAddress", this.localAddress);
		}
		return ret;
	}

	public Object __getTarget() {
		return this.__target;
	}

	public List<Command> __getSteps() {
		return this.__steps;
	}

	/**
	 * Executes the command against the specified scope.
	 * Steps are required by this command, and they appear after the scope parameter.
	 * Classes for these steps are statically available through this admin command class.
	 */
	public OperationResults<Object> run(Scope scope, CustomProperties customProperties) throws Exception {
		this.__steps = new ArrayList<Command>();
		if (customProperties != null)
			this.__steps.add(customProperties);
		return super.run(scope);
	}

	/**
	 * Used to set custom properties.
	 *   'name': The name of the custom property.
	 *   'value': The value of the custom property.
	 * The required parameters are found in the constructor.
	 */
	public static class CustomProperties extends CommandStep {

		private String name;
		private String value;

		public CustomProperties() {
			super("customProperties");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			if (this.name != null) {
				ret.put("name", this.name);
			}
			if (this.value != null) {
				ret.put("value", this.value);
			}
			return ret;
		}

		/**
		 * The name of the custom property.
		 */
		public String getName() {
			return this.name;
		}

		/**
		 * The name of the custom property.
		 */
		public void setName(String value) {
			this.name = value;
		}

		/**
		 * The value of the custom property.
		 */
		public String getValue() {
			return this.value;
		}

		/**
		 * The value of the custom property.
		 */
		public void setValue(String value) {
			this.value = value;
		}

	}
}
