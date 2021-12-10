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
 * Modifies the properties of the WMQ Connection Factory provided to the command.
 *   'maxBatchSize': The maximum number of messages to be taken from a queue in one packet when using asynchronous message delivery.
 *   'brokerCCSubQueue': The name of the queue from which non-durable subscription messages are retrieved for a ConnectionConsumer. This parameter is only valid for topic connection factories.
 *   'brokerCtrlQueue': The broker control queue to use if this connection factory is to subscribe to a topic. This parameter is only valid for topic connection factories.
 *   'brokerQmgr': The name of the queue manager on which the queue manager is running. This parameter is only valid for topic connection factories.
 *   'brokerSubQueue': The queue to use for obtaining subscription messages if this connection factory is to subscribe to a topic. This parameter is only valid for topic connection factories.
 *   'brokerVersion': Determines the level of functionality required for publish/subscribe operations. This parameter is only valid for topic connection factories.
 *   'brokerPubQueue': The queue to send publication messages to when using queue based brokering. This parameter is only valid for topic connection factories.
 *   'ccdtQmgrName': A queue manager name, used to select one or more entries from a client channel definition table.
 *   'ccdtUrl': A URL to a client channel definition table to use, for this connection factory, when contacting WMQ. Connection factories created using this parameter are of "ccdtURL" variety.
 *   'ccsid': The coded-character-set-ID to be used on connections.
 *   'cleanupInterval': The interval between background executions of the publish/subscribe cleanup utility. This parameter is only valid for topic connection factories.
 *   'cleanupLevel': Cleanup Level for BROKER or MIGRATE Subscription Stores. This parameter is only valid for topic connection factories.
 *   'clientId': The client identifier used for connections started using this connection factory.
 *   'clonedSubs': Whether two or more instances of the same durable topic subscriber can run simultaneously. This parameter is only valid for topic connection factories.
 *   'componentAuthAlias': Specifies a component managed authentication alias, from which security credentials are to be used when establishing a connection to WebSphere MQ.
 *   'compressHeaders': Determines if message headers are compressed or not.
 *   'compressPayload': Determines if message payloads are compressed or not.
 *   'containerAuthAlias': Specifies a container managed authentication alias, from which security credentials are to be used when establishing a connection to WebSphere MQ.
 *   'description': An administrative description assigned to the connection factory.
 *   'failIfQuiescing': Determines the behavior of certain calls to the queue manager when the queue manager is put into quiescing state.
 *   'jndiName': The name used to bind this connection factory into WAS JNDI.
 *   'localAddress': This property specifies either or both of the following: a) The local network interface to be used b) The local port, or range of local ports, to be used.
 *   'mappingAlias': Specifies the JAAS mapping alias to use when determining the security related credentials to use when establishing a connection to WebSphere MQ.
 *   'modelQueue': The WebSphere MQ model queue definition to use as a basis when creating JMS temporary destinations. This parameter is only valid for queue connection factories.
 *   'msgRetention': Determines whether or not the connection consumer keeps unwanted messages on the input queue. A value of true means that it does. A value of false means that the messages are disposed of as per their disposition options. This parameter is only valid for queue connection factories.
 *   'msgSelection': Determines where message selection occurs. This parameter is only valid for topic connection factories.
 *   'name': The administrative name to assign to the connection factory.
 *   'pollingInterval': If each message listener within a session has no suitable message on its queue, this is the maximum interval, in milliseconds, that elapses before each message listener tries again to get a message from its queue. If it frequently happens that no suitable message is available for any of the message listeners in a session, consider increasing the value of this property. This is only applicable in the client container.
 *   'providerVersion': Determines the minimum version, and capabilities of the queue manager.
 *   'pubAckInterval': The number of publications to send to a queue based broker before sending a publication which solicits an acknowledgement. This parameter is only valid for topic connection factories.
 *   'qmgrHostname': The hostname which will be used, for this connection factory, when attempting a client mode connection to WMQ.
 *   'qmgrName': The name of the queue manager to use, for this connection factory, when contacting WMQ. Connection factories created using this parameter are of "user defined" variety.
 *   'qmgrPortNumber': The port number to use, for this connection factory, when attempting a client mode connection to WMQ.
 *   'qmgrSvrconnChannel': The SVRCONN channel to use when connecting to WebSphere MQ. Specifying this property signifies that the connection factory is of the "user defined" variety.
 *   'rcvExitInitData': Initialization data to pass to the receive exit.
 *   'rcvExit': A comma separated list of receive exit class names.
 *   'replyWithRFH2': Determines whether, when replying to a message, a RFH version 2 header is included in the reply message. This parameter is only valid for queue connection factories.
 *   'rescanInterval': When a message consumer in the point-to-point domain uses a message selector to select which messages it wants to receive, the WebSphere MQ JMS client searches the WebSphere MQ queue for suitable messages in the sequence determined by the MsgDeliverySequence attribute of the queue. When the client finds a suitable message and delivers it to the consumer, the client resumes the search for the next suitable message from its current position in the queue. The client continues to search the queue in this way until it reaches the end of the queue, or until the interval of time in milliseconds, as determined by the value of this property, has expired. In each case, the client returns to the beginning of the queue to continue its search, and a new time interval commences. This parameter is only valid for queue connection factories.
 *   'secExitInitData': Initialization data to pass to the security exit.
 *   'secExit': A comma separated list of security exit class names.
 *   'sendExitInitData': Initialization data to pass to the send exit.
 *   'sendExit': A comma separate list of send exit class names.
 *   'sparseSubs': Controls the message retrieval policy of a TopicSubscriber object. This parameter is only valid for topic connection factories.
 *   'sslConfiguration': Names a specific SSL configuration to use when using SSL to secure network connections to the queue manager.
 *   'sslCrl': Specifies a list of LDAP servers which may be used to provide certificate revocation information if this connection factory establishes a SSL based connection to WMQ.
 *   'sslPeerName': Used when the connection factory establishes an SSL connection to the queue manager. This value is used to match against the distinguished name present in the peers certificate.
 *   'sslResetCount': Used when the connection factory establishes an SSL connection to the queue manager. This parameter determines how many bytes to transfer before resetting the symmetric encryption key used for the SSL session.
 *   'sslType': Determines the configuration, if any, to use when applying SSL encryption to the network connection to the queue manager.
 *   'stateRefreshInt': The interval, in milliseconds, between refreshes of the long running transaction that detects when a subscriber loses its connection to the queue manager. This property is relevant only if subStore parameter has the value QUEUE. This parameter is only valid for topic connection factories.
 *   'subStore': Where WebSphere MQ JMS should store persistent data relating to active subscriptions. This parameter is only valid for topic connection factories.
 *   'support2PCProtocol': Determines if the connection factory will act as a resource which is capable of participation in distributed two phase commit processing.
 *   'tempQueuePrefix': The prefix to apply to WebSphere MQ temporary queues used to represent JMS temporary queue type destinations. This parameter is only valid for queue connection factories.
 *   'tempTopicPrefix': The prefix to apply to WebSphere MQ temporary topics names that are used to represent JMS temporary topic type destinations. This parameter is only valid for topic connection factories.
 *   'wildcardFormat': Determines which sets of characters are interpreted as topic wildcards. This parameter is only valid for topic connection factories.
 *   'wmqTransportType': Determines the manner in which, for this connection factory, a connection will be established to WMQ. Connection factories created using this parameter are of "user defined" variety. Valid values are "BINDINGS", "BINDINGS_THEN_CLIENT" and "CLIENT".
 *   'xaRecoveryAuthAlias': The authentication alias from which the credentials used to connect to WebSphere MQ for the purposes of XA recovery are taken.
 * The required parameters are found in the constructor.
 */
public class ModifyWMQConnectionFactory extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private List<Command> __steps;
	private Integer maxBatchSize = 10;
	private String brokerCCSubQueue;
	private String brokerCtrlQueue;
	private String brokerQmgr;
	private String brokerSubQueue;
	private String brokerVersion;
	private String brokerPubQueue;
	private String ccdtQmgrName;
	private String ccdtUrl;
	private String ccsid;
	private Long cleanupInterval;
	private String cleanupLevel;
	private String clientId;
	private String clonedSubs;
	private String componentAuthAlias;
	private String compressHeaders;
	private String compressPayload;
	private String containerAuthAlias;
	private String description;
	private Boolean failIfQuiescing;
	private String jndiName;
	private String localAddress;
	private String mappingAlias;
	private String modelQueue;
	private String msgRetention;
	private String msgSelection;
	private String name;
	private Integer pollingInterval;
	private String providerVersion;
	private Integer pubAckInterval;
	private String qmgrHostname;
	private String qmgrName;
	private Integer qmgrPortNumber;
	private String qmgrSvrconnChannel;
	private String rcvExitInitData;
	private String rcvExit;
	private String replyWithRFH2;
	private Integer rescanInterval;
	private String secExitInitData;
	private String secExit;
	private String sendExitInitData;
	private String sendExit;
	private Boolean sparseSubs;
	private String sslConfiguration;
	private String sslCrl;
	private String sslPeerName;
	private Integer sslResetCount;
	private String sslType;
	private Integer stateRefreshInt;
	private String subStore;
	private Boolean support2PCProtocol;
	private String tempQueuePrefix;
	private String tempTopicPrefix;
	private String wildcardFormat;
	private String wmqTransportType;
	private String xaRecoveryAuthAlias;

	public ModifyWMQConnectionFactory(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget) {
		super("modifyWMQConnectionFactory");
		this.__target = commandTarget;
	}

	/**
	 * The maximum number of messages to be taken from a queue in one packet when using asynchronous message delivery.
	 */
	public Integer getMaxBatchSize() {
		return this.maxBatchSize;
	}

	/**
	 * The maximum number of messages to be taken from a queue in one packet when using asynchronous message delivery.
	 */
	public void setMaxBatchSize(Integer value) {
		this.maxBatchSize = value;
	}

	/**
	 * The name of the queue from which non-durable subscription messages are retrieved for a ConnectionConsumer. This parameter is only valid for topic connection factories.
	 */
	public String getBrokerCCSubQueue() {
		return this.brokerCCSubQueue;
	}

	/**
	 * The name of the queue from which non-durable subscription messages are retrieved for a ConnectionConsumer. This parameter is only valid for topic connection factories.
	 */
	public void setBrokerCCSubQueue(String value) {
		this.brokerCCSubQueue = value;
	}

	/**
	 * The broker control queue to use if this connection factory is to subscribe to a topic. This parameter is only valid for topic connection factories.
	 */
	public String getBrokerCtrlQueue() {
		return this.brokerCtrlQueue;
	}

	/**
	 * The broker control queue to use if this connection factory is to subscribe to a topic. This parameter is only valid for topic connection factories.
	 */
	public void setBrokerCtrlQueue(String value) {
		this.brokerCtrlQueue = value;
	}

	/**
	 * The name of the queue manager on which the queue manager is running. This parameter is only valid for topic connection factories.
	 */
	public String getBrokerQmgr() {
		return this.brokerQmgr;
	}

	/**
	 * The name of the queue manager on which the queue manager is running. This parameter is only valid for topic connection factories.
	 */
	public void setBrokerQmgr(String value) {
		this.brokerQmgr = value;
	}

	/**
	 * The queue to use for obtaining subscription messages if this connection factory is to subscribe to a topic. This parameter is only valid for topic connection factories.
	 */
	public String getBrokerSubQueue() {
		return this.brokerSubQueue;
	}

	/**
	 * The queue to use for obtaining subscription messages if this connection factory is to subscribe to a topic. This parameter is only valid for topic connection factories.
	 */
	public void setBrokerSubQueue(String value) {
		this.brokerSubQueue = value;
	}

	/**
	 * Determines the level of functionality required for publish/subscribe operations. This parameter is only valid for topic connection factories.
	 */
	public String getBrokerVersion() {
		return this.brokerVersion;
	}

	/**
	 * Determines the level of functionality required for publish/subscribe operations. This parameter is only valid for topic connection factories.
	 */
	public void setBrokerVersion(String value) {
		this.brokerVersion = value;
	}

	/**
	 * The queue to send publication messages to when using queue based brokering. This parameter is only valid for topic connection factories.
	 */
	public String getBrokerPubQueue() {
		return this.brokerPubQueue;
	}

	/**
	 * The queue to send publication messages to when using queue based brokering. This parameter is only valid for topic connection factories.
	 */
	public void setBrokerPubQueue(String value) {
		this.brokerPubQueue = value;
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
	 * A URL to a client channel definition table to use, for this connection factory, when contacting WMQ. Connection factories created using this parameter are of "ccdtURL" variety.
	 */
	public String getCcdtUrl() {
		return this.ccdtUrl;
	}

	/**
	 * A URL to a client channel definition table to use, for this connection factory, when contacting WMQ. Connection factories created using this parameter are of "ccdtURL" variety.
	 */
	public void setCcdtUrl(String value) {
		this.ccdtUrl = value;
	}

	/**
	 * The coded-character-set-ID to be used on connections.
	 */
	public String getCcsid() {
		return this.ccsid;
	}

	/**
	 * The coded-character-set-ID to be used on connections.
	 */
	public void setCcsid(String value) {
		this.ccsid = value;
	}

	/**
	 * The interval between background executions of the publish/subscribe cleanup utility. This parameter is only valid for topic connection factories.
	 */
	public Long getCleanupInterval() {
		return this.cleanupInterval;
	}

	/**
	 * The interval between background executions of the publish/subscribe cleanup utility. This parameter is only valid for topic connection factories.
	 */
	public void setCleanupInterval(Long value) {
		this.cleanupInterval = value;
	}

	/**
	 * Cleanup Level for BROKER or MIGRATE Subscription Stores. This parameter is only valid for topic connection factories.
	 */
	public String getCleanupLevel() {
		return this.cleanupLevel;
	}

	/**
	 * Cleanup Level for BROKER or MIGRATE Subscription Stores. This parameter is only valid for topic connection factories.
	 */
	public void setCleanupLevel(String value) {
		this.cleanupLevel = value;
	}

	/**
	 * The client identifier used for connections started using this connection factory.
	 */
	public String getClientId() {
		return this.clientId;
	}

	/**
	 * The client identifier used for connections started using this connection factory.
	 */
	public void setClientId(String value) {
		this.clientId = value;
	}

	/**
	 * Whether two or more instances of the same durable topic subscriber can run simultaneously. This parameter is only valid for topic connection factories.
	 */
	public String getClonedSubs() {
		return this.clonedSubs;
	}

	/**
	 * Whether two or more instances of the same durable topic subscriber can run simultaneously. This parameter is only valid for topic connection factories.
	 */
	public void setClonedSubs(String value) {
		this.clonedSubs = value;
	}

	/**
	 * Specifies a component managed authentication alias, from which security credentials are to be used when establishing a connection to WebSphere MQ.
	 */
	public String getComponentAuthAlias() {
		return this.componentAuthAlias;
	}

	/**
	 * Specifies a component managed authentication alias, from which security credentials are to be used when establishing a connection to WebSphere MQ.
	 */
	public void setComponentAuthAlias(String value) {
		this.componentAuthAlias = value;
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
	 * Specifies a container managed authentication alias, from which security credentials are to be used when establishing a connection to WebSphere MQ.
	 */
	public String getContainerAuthAlias() {
		return this.containerAuthAlias;
	}

	/**
	 * Specifies a container managed authentication alias, from which security credentials are to be used when establishing a connection to WebSphere MQ.
	 */
	public void setContainerAuthAlias(String value) {
		this.containerAuthAlias = value;
	}

	/**
	 * An administrative description assigned to the connection factory.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * An administrative description assigned to the connection factory.
	 */
	public void setDescription(String value) {
		this.description = value;
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
	 * The name used to bind this connection factory into WAS JNDI.
	 */
	public String getJndiName() {
		return this.jndiName;
	}

	/**
	 * The name used to bind this connection factory into WAS JNDI.
	 */
	public void setJndiName(String value) {
		this.jndiName = value;
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
	 * Specifies the JAAS mapping alias to use when determining the security related credentials to use when establishing a connection to WebSphere MQ.
	 */
	public String getMappingAlias() {
		return this.mappingAlias;
	}

	/**
	 * Specifies the JAAS mapping alias to use when determining the security related credentials to use when establishing a connection to WebSphere MQ.
	 */
	public void setMappingAlias(String value) {
		this.mappingAlias = value;
	}

	/**
	 * The WebSphere MQ model queue definition to use as a basis when creating JMS temporary destinations. This parameter is only valid for queue connection factories.
	 */
	public String getModelQueue() {
		return this.modelQueue;
	}

	/**
	 * The WebSphere MQ model queue definition to use as a basis when creating JMS temporary destinations. This parameter is only valid for queue connection factories.
	 */
	public void setModelQueue(String value) {
		this.modelQueue = value;
	}

	/**
	 * Determines whether or not the connection consumer keeps unwanted messages on the input queue. A value of true means that it does. A value of false means that the messages are disposed of as per their disposition options. This parameter is only valid for queue connection factories.
	 */
	public String getMsgRetention() {
		return this.msgRetention;
	}

	/**
	 * Determines whether or not the connection consumer keeps unwanted messages on the input queue. A value of true means that it does. A value of false means that the messages are disposed of as per their disposition options. This parameter is only valid for queue connection factories.
	 */
	public void setMsgRetention(String value) {
		this.msgRetention = value;
	}

	/**
	 * Determines where message selection occurs. This parameter is only valid for topic connection factories.
	 */
	public String getMsgSelection() {
		return this.msgSelection;
	}

	/**
	 * Determines where message selection occurs. This parameter is only valid for topic connection factories.
	 */
	public void setMsgSelection(String value) {
		this.msgSelection = value;
	}

	/**
	 * The administrative name to assign to the connection factory.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The administrative name to assign to the connection factory.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * If each message listener within a session has no suitable message on its queue, this is the maximum interval, in milliseconds, that elapses before each message listener tries again to get a message from its queue. If it frequently happens that no suitable message is available for any of the message listeners in a session, consider increasing the value of this property. This is only applicable in the client container.
	 */
	public Integer getPollingInterval() {
		return this.pollingInterval;
	}

	/**
	 * If each message listener within a session has no suitable message on its queue, this is the maximum interval, in milliseconds, that elapses before each message listener tries again to get a message from its queue. If it frequently happens that no suitable message is available for any of the message listeners in a session, consider increasing the value of this property. This is only applicable in the client container.
	 */
	public void setPollingInterval(Integer value) {
		this.pollingInterval = value;
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
	 * The number of publications to send to a queue based broker before sending a publication which solicits an acknowledgement. This parameter is only valid for topic connection factories.
	 */
	public Integer getPubAckInterval() {
		return this.pubAckInterval;
	}

	/**
	 * The number of publications to send to a queue based broker before sending a publication which solicits an acknowledgement. This parameter is only valid for topic connection factories.
	 */
	public void setPubAckInterval(Integer value) {
		this.pubAckInterval = value;
	}

	/**
	 * The hostname which will be used, for this connection factory, when attempting a client mode connection to WMQ.
	 */
	public String getQmgrHostname() {
		return this.qmgrHostname;
	}

	/**
	 * The hostname which will be used, for this connection factory, when attempting a client mode connection to WMQ.
	 */
	public void setQmgrHostname(String value) {
		this.qmgrHostname = value;
	}

	/**
	 * The name of the queue manager to use, for this connection factory, when contacting WMQ. Connection factories created using this parameter are of "user defined" variety.
	 */
	public String getQmgrName() {
		return this.qmgrName;
	}

	/**
	 * The name of the queue manager to use, for this connection factory, when contacting WMQ. Connection factories created using this parameter are of "user defined" variety.
	 */
	public void setQmgrName(String value) {
		this.qmgrName = value;
	}

	/**
	 * The port number to use, for this connection factory, when attempting a client mode connection to WMQ.
	 */
	public Integer getQmgrPortNumber() {
		return this.qmgrPortNumber;
	}

	/**
	 * The port number to use, for this connection factory, when attempting a client mode connection to WMQ.
	 */
	public void setQmgrPortNumber(Integer value) {
		this.qmgrPortNumber = value;
	}

	/**
	 * The SVRCONN channel to use when connecting to WebSphere MQ. Specifying this property signifies that the connection factory is of the "user defined" variety.
	 */
	public String getQmgrSvrconnChannel() {
		return this.qmgrSvrconnChannel;
	}

	/**
	 * The SVRCONN channel to use when connecting to WebSphere MQ. Specifying this property signifies that the connection factory is of the "user defined" variety.
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
	 * Determines whether, when replying to a message, a RFH version 2 header is included in the reply message. This parameter is only valid for queue connection factories.
	 */
	public String getReplyWithRFH2() {
		return this.replyWithRFH2;
	}

	/**
	 * Determines whether, when replying to a message, a RFH version 2 header is included in the reply message. This parameter is only valid for queue connection factories.
	 */
	public void setReplyWithRFH2(String value) {
		this.replyWithRFH2 = value;
	}

	/**
	 * When a message consumer in the point-to-point domain uses a message selector to select which messages it wants to receive, the WebSphere MQ JMS client searches the WebSphere MQ queue for suitable messages in the sequence determined by the MsgDeliverySequence attribute of the queue. When the client finds a suitable message and delivers it to the consumer, the client resumes the search for the next suitable message from its current position in the queue. The client continues to search the queue in this way until it reaches the end of the queue, or until the interval of time in milliseconds, as determined by the value of this property, has expired. In each case, the client returns to the beginning of the queue to continue its search, and a new time interval commences. This parameter is only valid for queue connection factories.
	 */
	public Integer getRescanInterval() {
		return this.rescanInterval;
	}

	/**
	 * When a message consumer in the point-to-point domain uses a message selector to select which messages it wants to receive, the WebSphere MQ JMS client searches the WebSphere MQ queue for suitable messages in the sequence determined by the MsgDeliverySequence attribute of the queue. When the client finds a suitable message and delivers it to the consumer, the client resumes the search for the next suitable message from its current position in the queue. The client continues to search the queue in this way until it reaches the end of the queue, or until the interval of time in milliseconds, as determined by the value of this property, has expired. In each case, the client returns to the beginning of the queue to continue its search, and a new time interval commences. This parameter is only valid for queue connection factories.
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
	 * A comma separated list of security exit class names.
	 */
	public String getSecExit() {
		return this.secExit;
	}

	/**
	 * A comma separated list of security exit class names.
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
	 * Controls the message retrieval policy of a TopicSubscriber object. This parameter is only valid for topic connection factories.
	 */
	public Boolean getSparseSubs() {
		return this.sparseSubs;
	}

	/**
	 * Controls the message retrieval policy of a TopicSubscriber object. This parameter is only valid for topic connection factories.
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
	 * Specifies a list of LDAP servers which may be used to provide certificate revocation information if this connection factory establishes a SSL based connection to WMQ.
	 */
	public String getSslCrl() {
		return this.sslCrl;
	}

	/**
	 * Specifies a list of LDAP servers which may be used to provide certificate revocation information if this connection factory establishes a SSL based connection to WMQ.
	 */
	public void setSslCrl(String value) {
		this.sslCrl = value;
	}

	/**
	 * Used when the connection factory establishes an SSL connection to the queue manager. This value is used to match against the distinguished name present in the peers certificate.
	 */
	public String getSslPeerName() {
		return this.sslPeerName;
	}

	/**
	 * Used when the connection factory establishes an SSL connection to the queue manager. This value is used to match against the distinguished name present in the peers certificate.
	 */
	public void setSslPeerName(String value) {
		this.sslPeerName = value;
	}

	/**
	 * Used when the connection factory establishes an SSL connection to the queue manager. This parameter determines how many bytes to transfer before resetting the symmetric encryption key used for the SSL session.
	 */
	public Integer getSslResetCount() {
		return this.sslResetCount;
	}

	/**
	 * Used when the connection factory establishes an SSL connection to the queue manager. This parameter determines how many bytes to transfer before resetting the symmetric encryption key used for the SSL session.
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
	 * The interval, in milliseconds, between refreshes of the long running transaction that detects when a subscriber loses its connection to the queue manager. This property is relevant only if subStore parameter has the value QUEUE. This parameter is only valid for topic connection factories.
	 */
	public Integer getStateRefreshInt() {
		return this.stateRefreshInt;
	}

	/**
	 * The interval, in milliseconds, between refreshes of the long running transaction that detects when a subscriber loses its connection to the queue manager. This property is relevant only if subStore parameter has the value QUEUE. This parameter is only valid for topic connection factories.
	 */
	public void setStateRefreshInt(Integer value) {
		this.stateRefreshInt = value;
	}

	/**
	 * Where WebSphere MQ JMS should store persistent data relating to active subscriptions. This parameter is only valid for topic connection factories.
	 */
	public String getSubStore() {
		return this.subStore;
	}

	/**
	 * Where WebSphere MQ JMS should store persistent data relating to active subscriptions. This parameter is only valid for topic connection factories.
	 */
	public void setSubStore(String value) {
		this.subStore = value;
	}

	/**
	 * Determines if the connection factory will act as a resource which is capable of participation in distributed two phase commit processing.
	 */
	public Boolean getSupport2PCProtocol() {
		return this.support2PCProtocol;
	}

	/**
	 * Determines if the connection factory will act as a resource which is capable of participation in distributed two phase commit processing.
	 */
	public void setSupport2PCProtocol(Boolean value) {
		this.support2PCProtocol = value;
	}

	/**
	 * The prefix to apply to WebSphere MQ temporary queues used to represent JMS temporary queue type destinations. This parameter is only valid for queue connection factories.
	 */
	public String getTempQueuePrefix() {
		return this.tempQueuePrefix;
	}

	/**
	 * The prefix to apply to WebSphere MQ temporary queues used to represent JMS temporary queue type destinations. This parameter is only valid for queue connection factories.
	 */
	public void setTempQueuePrefix(String value) {
		this.tempQueuePrefix = value;
	}

	/**
	 * The prefix to apply to WebSphere MQ temporary topics names that are used to represent JMS temporary topic type destinations. This parameter is only valid for topic connection factories.
	 */
	public String getTempTopicPrefix() {
		return this.tempTopicPrefix;
	}

	/**
	 * The prefix to apply to WebSphere MQ temporary topics names that are used to represent JMS temporary topic type destinations. This parameter is only valid for topic connection factories.
	 */
	public void setTempTopicPrefix(String value) {
		this.tempTopicPrefix = value;
	}

	/**
	 * Determines which sets of characters are interpreted as topic wildcards. This parameter is only valid for topic connection factories.
	 */
	public String getWildcardFormat() {
		return this.wildcardFormat;
	}

	/**
	 * Determines which sets of characters are interpreted as topic wildcards. This parameter is only valid for topic connection factories.
	 */
	public void setWildcardFormat(String value) {
		this.wildcardFormat = value;
	}

	/**
	 * Determines the manner in which, for this connection factory, a connection will be established to WMQ. Connection factories created using this parameter are of "user defined" variety. Valid values are "BINDINGS", "BINDINGS_THEN_CLIENT" and "CLIENT".
	 */
	public String getWmqTransportType() {
		return this.wmqTransportType;
	}

	/**
	 * Determines the manner in which, for this connection factory, a connection will be established to WMQ. Connection factories created using this parameter are of "user defined" variety. Valid values are "BINDINGS", "BINDINGS_THEN_CLIENT" and "CLIENT".
	 */
	public void setWmqTransportType(String value) {
		this.wmqTransportType = value;
	}

	/**
	 * The authentication alias from which the credentials used to connect to WebSphere MQ for the purposes of XA recovery are taken.
	 */
	public String getXaRecoveryAuthAlias() {
		return this.xaRecoveryAuthAlias;
	}

	/**
	 * The authentication alias from which the credentials used to connect to WebSphere MQ for the purposes of XA recovery are taken.
	 */
	public void setXaRecoveryAuthAlias(String value) {
		this.xaRecoveryAuthAlias = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.maxBatchSize != null) {
			ret.put("maxBatchSize", this.maxBatchSize);
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
		if (this.brokerPubQueue != null) {
			ret.put("brokerPubQueue", this.brokerPubQueue);
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
		if (this.componentAuthAlias != null) {
			ret.put("componentAuthAlias", this.componentAuthAlias);
		}
		if (this.compressHeaders != null) {
			ret.put("compressHeaders", this.compressHeaders);
		}
		if (this.compressPayload != null) {
			ret.put("compressPayload", this.compressPayload);
		}
		if (this.containerAuthAlias != null) {
			ret.put("containerAuthAlias", this.containerAuthAlias);
		}
		if (this.description != null) {
			ret.put("description", this.description);
		}
		if (this.failIfQuiescing != null) {
			ret.put("failIfQuiescing", this.failIfQuiescing);
		}
		if (this.jndiName != null) {
			ret.put("jndiName", this.jndiName);
		}
		if (this.localAddress != null) {
			ret.put("localAddress", this.localAddress);
		}
		if (this.mappingAlias != null) {
			ret.put("mappingAlias", this.mappingAlias);
		}
		if (this.modelQueue != null) {
			ret.put("modelQueue", this.modelQueue);
		}
		if (this.msgRetention != null) {
			ret.put("msgRetention", this.msgRetention);
		}
		if (this.msgSelection != null) {
			ret.put("msgSelection", this.msgSelection);
		}
		if (this.name != null) {
			ret.put("name", this.name);
		}
		if (this.pollingInterval != null) {
			ret.put("pollingInterval", this.pollingInterval);
		}
		if (this.providerVersion != null) {
			ret.put("providerVersion", this.providerVersion);
		}
		if (this.pubAckInterval != null) {
			ret.put("pubAckInterval", this.pubAckInterval);
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
		if (this.replyWithRFH2 != null) {
			ret.put("replyWithRFH2", this.replyWithRFH2);
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
		if (this.stateRefreshInt != null) {
			ret.put("stateRefreshInt", this.stateRefreshInt);
		}
		if (this.subStore != null) {
			ret.put("subStore", this.subStore);
		}
		if (this.support2PCProtocol != null) {
			ret.put("support2PCProtocol", this.support2PCProtocol);
		}
		if (this.tempQueuePrefix != null) {
			ret.put("tempQueuePrefix", this.tempQueuePrefix);
		}
		if (this.tempTopicPrefix != null) {
			ret.put("tempTopicPrefix", this.tempTopicPrefix);
		}
		if (this.wildcardFormat != null) {
			ret.put("wildcardFormat", this.wildcardFormat);
		}
		if (this.wmqTransportType != null) {
			ret.put("wmqTransportType", this.wmqTransportType);
		}
		if (this.xaRecoveryAuthAlias != null) {
			ret.put("xaRecoveryAuthAlias", this.xaRecoveryAuthAlias);
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
