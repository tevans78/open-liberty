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

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Create a new WebSphere MQ link.
 *   'bus': The name of the bus.
 *   'messagingEngine': The name of the messaging engine.
 *   'name': The name of the WebSphere MQ link.
 *   'foreignBusName': The name of the foreign bus.
 *   'queueManagerName': The name of the queue manager.
 *   'senderChannelTransportChain': The name of the sender channel transport chain {OutboundBasicMQLink | OutboundSecureMQLink}.
 *   'description': The description of the SIB WebSphere MQ link.
 *   'batchSize': Batch size {1 - 9,999} (default is "50").
 *   'maxMsgSize': The maximum message size for the WebSphere MQ link {0 - 4,194,304} (default is "4,194,304").
 *   'heartBeat': Heartbeat {0 - 999,999} (default is "300").
 *   'sequenceWrap': The sequence wrap value {100 - 999,999,999} (default is "999,999,999").
 *   'nonPersistentMessageSpeed': Non-persistent message speed {Fast | Normal} (default is "Fast").
 *   'adoptable': Adoptable {True | False} (default is "True").
 *   'initialState': The initial state of the WebSphere MQ link {Started | Stopped} (default is "Started").
 *   'senderChannelName': The name of the sender channel.
 *   'hostName': Host name.
 *   'port': Port number {0 - 2,147,483,647} (default is "1414").
 *   'discInterval': Disconnect interval {0 - 999,999} (default is "900").
 *   'shortRetryCount': Short retry count {0 - 999,999,999} (default is "10").
 *   'shortRetryInterval': Short retry interval {0 - 999,999,999} (default is "60").
 *   'longRetryCount': Long retry count {0 - 999,999,999} (default is "999,999,999").
 *   'longRetryInterval': Long retry interval {0 - 999,999,999} (default is "1200").
 *   'senderChannelInitialState': The initial state of the sender channel {Started | Stopped} (default is "Started").
 *   'receiverChannelName': The name of the receiver channel.
 *   'inboundNonPersistentReliability': Inbound Non-persistent reliability {BEST_EFFORT | EXPRESS | RELIABLE} (default is "Reliable").
 *   'inboundPersistentReliability': Inbound persistent reliability {Reliable | Assured} (default is "Assured").
 *   'receiverChannelInitialState': The initial state of the receiver channel {Started | Stopped} (default is "Started").
 *   'exceptionDestination': The exception destination for the WebSphere MQ link {destination name | $DEFAULT_EXCEPTION_DESTINATION} (default is "$DEFAULT_EXCEPTION_DESTINATION").
 *   'preferLocal': Prefer queue points local to this link's messaging engine
 * The required parameters are found in the constructor.
 */
public class CreateSIBMQLink extends Command {

	private String bus;
	private String messagingEngine;
	private String name;
	private String foreignBusName;
	private String queueManagerName;
	private String senderChannelTransportChain;
	private String description;
	private Integer batchSize;
	private Integer maxMsgSize;
	private Integer heartBeat;
	private Long sequenceWrap;
	private String nonPersistentMessageSpeed;
	private Boolean adoptable = false;
	private String initialState;
	private String senderChannelName;
	private String hostName;
	private Integer port;
	private Integer discInterval;
	private Integer shortRetryCount;
	private Integer shortRetryInterval;
	private Long longRetryCount;
	private Long longRetryInterval;
	private String senderChannelInitialState;
	private String receiverChannelName;
	private String inboundNonPersistentReliability;
	private String inboundPersistentReliability;
	private String receiverChannelInitialState;
	private String exceptionDestination;
	private Boolean preferLocal = true;

	public CreateSIBMQLink(String bus, String messagingEngine, String name, String foreignBusName, String queueManagerName, String senderChannelTransportChain) {
		super("createSIBMQLink");
		this.bus = bus;
		this.messagingEngine = messagingEngine;
		this.name = name;
		this.foreignBusName = foreignBusName;
		this.queueManagerName = queueManagerName;
		this.senderChannelTransportChain = senderChannelTransportChain;
	}

	/**
	 * The name of the bus.
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * The name of the bus.
	 */
	public void setBus(String value) {
		this.bus = value;
	}

	/**
	 * The name of the messaging engine.
	 */
	public String getMessagingEngine() {
		return this.messagingEngine;
	}

	/**
	 * The name of the messaging engine.
	 */
	public void setMessagingEngine(String value) {
		this.messagingEngine = value;
	}

	/**
	 * The name of the WebSphere MQ link.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The name of the WebSphere MQ link.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * The name of the foreign bus.
	 */
	public String getForeignBusName() {
		return this.foreignBusName;
	}

	/**
	 * The name of the foreign bus.
	 */
	public void setForeignBusName(String value) {
		this.foreignBusName = value;
	}

	/**
	 * The name of the queue manager.
	 */
	public String getQueueManagerName() {
		return this.queueManagerName;
	}

	/**
	 * The name of the queue manager.
	 */
	public void setQueueManagerName(String value) {
		this.queueManagerName = value;
	}

	/**
	 * The name of the sender channel transport chain {OutboundBasicMQLink | OutboundSecureMQLink}.
	 */
	public String getSenderChannelTransportChain() {
		return this.senderChannelTransportChain;
	}

	/**
	 * The name of the sender channel transport chain {OutboundBasicMQLink | OutboundSecureMQLink}.
	 */
	public void setSenderChannelTransportChain(String value) {
		this.senderChannelTransportChain = value;
	}

	/**
	 * The description of the SIB WebSphere MQ link.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * The description of the SIB WebSphere MQ link.
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Batch size {1 - 9,999} (default is "50").
	 */
	public Integer getBatchSize() {
		return this.batchSize;
	}

	/**
	 * Batch size {1 - 9,999} (default is "50").
	 */
	public void setBatchSize(Integer value) {
		this.batchSize = value;
	}

	/**
	 * The maximum message size for the WebSphere MQ link {0 - 4,194,304} (default is "4,194,304").
	 */
	public Integer getMaxMsgSize() {
		return this.maxMsgSize;
	}

	/**
	 * The maximum message size for the WebSphere MQ link {0 - 4,194,304} (default is "4,194,304").
	 */
	public void setMaxMsgSize(Integer value) {
		this.maxMsgSize = value;
	}

	/**
	 * Heartbeat {0 - 999,999} (default is "300").
	 */
	public Integer getHeartBeat() {
		return this.heartBeat;
	}

	/**
	 * Heartbeat {0 - 999,999} (default is "300").
	 */
	public void setHeartBeat(Integer value) {
		this.heartBeat = value;
	}

	/**
	 * The sequence wrap value {100 - 999,999,999} (default is "999,999,999").
	 */
	public Long getSequenceWrap() {
		return this.sequenceWrap;
	}

	/**
	 * The sequence wrap value {100 - 999,999,999} (default is "999,999,999").
	 */
	public void setSequenceWrap(Long value) {
		this.sequenceWrap = value;
	}

	/**
	 * Non-persistent message speed {Fast | Normal} (default is "Fast").
	 */
	public String getNonPersistentMessageSpeed() {
		return this.nonPersistentMessageSpeed;
	}

	/**
	 * Non-persistent message speed {Fast | Normal} (default is "Fast").
	 */
	public void setNonPersistentMessageSpeed(String value) {
		this.nonPersistentMessageSpeed = value;
	}

	/**
	 * Adoptable {True | False} (default is "True").
	 */
	public Boolean getAdoptable() {
		return this.adoptable;
	}

	/**
	 * Adoptable {True | False} (default is "True").
	 */
	public void setAdoptable(Boolean value) {
		this.adoptable = value;
	}

	/**
	 * The initial state of the WebSphere MQ link {Started | Stopped} (default is "Started").
	 */
	public String getInitialState() {
		return this.initialState;
	}

	/**
	 * The initial state of the WebSphere MQ link {Started | Stopped} (default is "Started").
	 */
	public void setInitialState(String value) {
		this.initialState = value;
	}

	/**
	 * The name of the sender channel.
	 */
	public String getSenderChannelName() {
		return this.senderChannelName;
	}

	/**
	 * The name of the sender channel.
	 */
	public void setSenderChannelName(String value) {
		this.senderChannelName = value;
	}

	/**
	 * Host name.
	 */
	public String getHostName() {
		return this.hostName;
	}

	/**
	 * Host name.
	 */
	public void setHostName(String value) {
		this.hostName = value;
	}

	/**
	 * Port number {0 - 2,147,483,647} (default is "1414").
	 */
	public Integer getPort() {
		return this.port;
	}

	/**
	 * Port number {0 - 2,147,483,647} (default is "1414").
	 */
	public void setPort(Integer value) {
		this.port = value;
	}

	/**
	 * Disconnect interval {0 - 999,999} (default is "900").
	 */
	public Integer getDiscInterval() {
		return this.discInterval;
	}

	/**
	 * Disconnect interval {0 - 999,999} (default is "900").
	 */
	public void setDiscInterval(Integer value) {
		this.discInterval = value;
	}

	/**
	 * Short retry count {0 - 999,999,999} (default is "10").
	 */
	public Integer getShortRetryCount() {
		return this.shortRetryCount;
	}

	/**
	 * Short retry count {0 - 999,999,999} (default is "10").
	 */
	public void setShortRetryCount(Integer value) {
		this.shortRetryCount = value;
	}

	/**
	 * Short retry interval {0 - 999,999,999} (default is "60").
	 */
	public Integer getShortRetryInterval() {
		return this.shortRetryInterval;
	}

	/**
	 * Short retry interval {0 - 999,999,999} (default is "60").
	 */
	public void setShortRetryInterval(Integer value) {
		this.shortRetryInterval = value;
	}

	/**
	 * Long retry count {0 - 999,999,999} (default is "999,999,999").
	 */
	public Long getLongRetryCount() {
		return this.longRetryCount;
	}

	/**
	 * Long retry count {0 - 999,999,999} (default is "999,999,999").
	 */
	public void setLongRetryCount(Long value) {
		this.longRetryCount = value;
	}

	/**
	 * Long retry interval {0 - 999,999,999} (default is "1200").
	 */
	public Long getLongRetryInterval() {
		return this.longRetryInterval;
	}

	/**
	 * Long retry interval {0 - 999,999,999} (default is "1200").
	 */
	public void setLongRetryInterval(Long value) {
		this.longRetryInterval = value;
	}

	/**
	 * The initial state of the sender channel {Started | Stopped} (default is "Started").
	 */
	public String getSenderChannelInitialState() {
		return this.senderChannelInitialState;
	}

	/**
	 * The initial state of the sender channel {Started | Stopped} (default is "Started").
	 */
	public void setSenderChannelInitialState(String value) {
		this.senderChannelInitialState = value;
	}

	/**
	 * The name of the receiver channel.
	 */
	public String getReceiverChannelName() {
		return this.receiverChannelName;
	}

	/**
	 * The name of the receiver channel.
	 */
	public void setReceiverChannelName(String value) {
		this.receiverChannelName = value;
	}

	/**
	 * Inbound Non-persistent reliability {BEST_EFFORT | EXPRESS | RELIABLE} (default is "Reliable").
	 */
	public String getInboundNonPersistentReliability() {
		return this.inboundNonPersistentReliability;
	}

	/**
	 * Inbound Non-persistent reliability {BEST_EFFORT | EXPRESS | RELIABLE} (default is "Reliable").
	 */
	public void setInboundNonPersistentReliability(String value) {
		this.inboundNonPersistentReliability = value;
	}

	/**
	 * Inbound persistent reliability {Reliable | Assured} (default is "Assured").
	 */
	public String getInboundPersistentReliability() {
		return this.inboundPersistentReliability;
	}

	/**
	 * Inbound persistent reliability {Reliable | Assured} (default is "Assured").
	 */
	public void setInboundPersistentReliability(String value) {
		this.inboundPersistentReliability = value;
	}

	/**
	 * The initial state of the receiver channel {Started | Stopped} (default is "Started").
	 */
	public String getReceiverChannelInitialState() {
		return this.receiverChannelInitialState;
	}

	/**
	 * The initial state of the receiver channel {Started | Stopped} (default is "Started").
	 */
	public void setReceiverChannelInitialState(String value) {
		this.receiverChannelInitialState = value;
	}

	/**
	 * The exception destination for the WebSphere MQ link {destination name | $DEFAULT_EXCEPTION_DESTINATION} (default is "$DEFAULT_EXCEPTION_DESTINATION").
	 */
	public String getExceptionDestination() {
		return this.exceptionDestination;
	}

	/**
	 * The exception destination for the WebSphere MQ link {destination name | $DEFAULT_EXCEPTION_DESTINATION} (default is "$DEFAULT_EXCEPTION_DESTINATION").
	 */
	public void setExceptionDestination(String value) {
		this.exceptionDestination = value;
	}

	/**
	 * Prefer queue points local to this link's messaging engine
	 */
	public Boolean getPreferLocal() {
		return this.preferLocal;
	}

	/**
	 * Prefer queue points local to this link's messaging engine
	 */
	public void setPreferLocal(Boolean value) {
		this.preferLocal = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("bus", this.bus);
		ret.put("messagingEngine", this.messagingEngine);
		ret.put("name", this.name);
		ret.put("foreignBusName", this.foreignBusName);
		ret.put("queueManagerName", this.queueManagerName);
		ret.put("senderChannelTransportChain", this.senderChannelTransportChain);
		if (this.description != null) {
			ret.put("description", this.description);
		}
		if (this.batchSize != null) {
			ret.put("batchSize", this.batchSize);
		}
		if (this.maxMsgSize != null) {
			ret.put("maxMsgSize", this.maxMsgSize);
		}
		if (this.heartBeat != null) {
			ret.put("heartBeat", this.heartBeat);
		}
		if (this.sequenceWrap != null) {
			ret.put("sequenceWrap", this.sequenceWrap);
		}
		if (this.nonPersistentMessageSpeed != null) {
			ret.put("nonPersistentMessageSpeed", this.nonPersistentMessageSpeed);
		}
		if (this.adoptable != null) {
			ret.put("adoptable", this.adoptable);
		}
		if (this.initialState != null) {
			ret.put("initialState", this.initialState);
		}
		if (this.senderChannelName != null) {
			ret.put("senderChannelName", this.senderChannelName);
		}
		if (this.hostName != null) {
			ret.put("hostName", this.hostName);
		}
		if (this.port != null) {
			ret.put("port", this.port);
		}
		if (this.discInterval != null) {
			ret.put("discInterval", this.discInterval);
		}
		if (this.shortRetryCount != null) {
			ret.put("shortRetryCount", this.shortRetryCount);
		}
		if (this.shortRetryInterval != null) {
			ret.put("shortRetryInterval", this.shortRetryInterval);
		}
		if (this.longRetryCount != null) {
			ret.put("longRetryCount", this.longRetryCount);
		}
		if (this.longRetryInterval != null) {
			ret.put("longRetryInterval", this.longRetryInterval);
		}
		if (this.senderChannelInitialState != null) {
			ret.put("senderChannelInitialState", this.senderChannelInitialState);
		}
		if (this.receiverChannelName != null) {
			ret.put("receiverChannelName", this.receiverChannelName);
		}
		if (this.inboundNonPersistentReliability != null) {
			ret.put("inboundNonPersistentReliability", this.inboundNonPersistentReliability);
		}
		if (this.inboundPersistentReliability != null) {
			ret.put("inboundPersistentReliability", this.inboundPersistentReliability);
		}
		if (this.receiverChannelInitialState != null) {
			ret.put("receiverChannelInitialState", this.receiverChannelInitialState);
		}
		if (this.exceptionDestination != null) {
			ret.put("exceptionDestination", this.exceptionDestination);
		}
		if (this.preferLocal != null) {
			ret.put("preferLocal", this.preferLocal);
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
