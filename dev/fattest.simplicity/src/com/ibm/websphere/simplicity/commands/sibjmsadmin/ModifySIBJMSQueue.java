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
 * Modify the attributes of the supplied SIB JMS queue using the supplied attribute values.
 *   'name': The SIB JMS queue's name.
 *   'jndiName': The SIB JMS queue's JNDI name.
 *   'description': A description of the SIB JMS queue.
 *   'queueName': The name of the underlying SIB queue to which the queue points.
 *   'deliveryMode': The delivery mode for messages. Legal values are "Application", "NonPersistent" and "Persistent".
 *   'timeToLive': The time in milliseconds to be used for message expiration.
 *   'priority': The priority for messages. Whole number in the range 0 to 9.
 *   'readAhead': Read-ahead value. Legal values are "AsConnection", "AlwaysOn" and "AlwaysOff".
 *   'busName': The name of the bus on which the queue resides.
 *   'scopeToLocalQP': Indicates if the underlying SIB queue destination should be scoped to a local queue point when addressed using this JMS queue
 *   'producerBind': Indicates how JMS producers should bind to queue points of the clustered queue. TRUE indicates that a queue point should be chosen when the session is opened and should never change, FALSE indicates that a queue point should be chosen every time a message is sent.
 *   'producerPreferLocal': Indicates whether queue points local to the producer should be used
 *   'gatherMessages': Indicates whether JMS consumers and browsers should be given messages from any queue points, rather than the single queue point that they are attached to.
 * The required parameters are found in the constructor.
 */
public class ModifySIBJMSQueue extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String name;
	private String jndiName;
	private String description;
	private String queueName;
	private String deliveryMode;
	private Long timeToLive;
	private Integer priority;
	private String readAhead;
	private String busName;
	private Boolean scopeToLocalQP;
	private Boolean producerBind;
	private Boolean producerPreferLocal;
	private Boolean gatherMessages;

	public ModifySIBJMSQueue(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget) {
		super("modifySIBJMSQueue");
		this.__target = commandTarget;
	}

	/**
	 * The SIB JMS queue's name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The SIB JMS queue's name.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * The SIB JMS queue's JNDI name.
	 */
	public String getJndiName() {
		return this.jndiName;
	}

	/**
	 * The SIB JMS queue's JNDI name.
	 */
	public void setJndiName(String value) {
		this.jndiName = value;
	}

	/**
	 * A description of the SIB JMS queue.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * A description of the SIB JMS queue.
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * The name of the underlying SIB queue to which the queue points.
	 */
	public String getQueueName() {
		return this.queueName;
	}

	/**
	 * The name of the underlying SIB queue to which the queue points.
	 */
	public void setQueueName(String value) {
		this.queueName = value;
	}

	/**
	 * The delivery mode for messages. Legal values are "Application", "NonPersistent" and "Persistent".
	 */
	public String getDeliveryMode() {
		return this.deliveryMode;
	}

	/**
	 * The delivery mode for messages. Legal values are "Application", "NonPersistent" and "Persistent".
	 */
	public void setDeliveryMode(String value) {
		this.deliveryMode = value;
	}

	/**
	 * The time in milliseconds to be used for message expiration.
	 */
	public Long getTimeToLive() {
		return this.timeToLive;
	}

	/**
	 * The time in milliseconds to be used for message expiration.
	 */
	public void setTimeToLive(Long value) {
		this.timeToLive = value;
	}

	/**
	 * The priority for messages. Whole number in the range 0 to 9.
	 */
	public Integer getPriority() {
		return this.priority;
	}

	/**
	 * The priority for messages. Whole number in the range 0 to 9.
	 */
	public void setPriority(Integer value) {
		this.priority = value;
	}

	/**
	 * Read-ahead value. Legal values are "AsConnection", "AlwaysOn" and "AlwaysOff".
	 */
	public String getReadAhead() {
		return this.readAhead;
	}

	/**
	 * Read-ahead value. Legal values are "AsConnection", "AlwaysOn" and "AlwaysOff".
	 */
	public void setReadAhead(String value) {
		this.readAhead = value;
	}

	/**
	 * The name of the bus on which the queue resides.
	 */
	public String getBusName() {
		return this.busName;
	}

	/**
	 * The name of the bus on which the queue resides.
	 */
	public void setBusName(String value) {
		this.busName = value;
	}

	/**
	 * Indicates if the underlying SIB queue destination should be scoped to a local queue point when addressed using this JMS queue
	 */
	public Boolean getScopeToLocalQP() {
		return this.scopeToLocalQP;
	}

	/**
	 * Indicates if the underlying SIB queue destination should be scoped to a local queue point when addressed using this JMS queue
	 */
	public void setScopeToLocalQP(Boolean value) {
		this.scopeToLocalQP = value;
	}

	/**
	 * Indicates how JMS producers should bind to queue points of the clustered queue. TRUE indicates that a queue point should be chosen when the session is opened and should never change, FALSE indicates that a queue point should be chosen every time a message is sent.
	 */
	public Boolean getProducerBind() {
		return this.producerBind;
	}

	/**
	 * Indicates how JMS producers should bind to queue points of the clustered queue. TRUE indicates that a queue point should be chosen when the session is opened and should never change, FALSE indicates that a queue point should be chosen every time a message is sent.
	 */
	public void setProducerBind(Boolean value) {
		this.producerBind = value;
	}

	/**
	 * Indicates whether queue points local to the producer should be used
	 */
	public Boolean getProducerPreferLocal() {
		return this.producerPreferLocal;
	}

	/**
	 * Indicates whether queue points local to the producer should be used
	 */
	public void setProducerPreferLocal(Boolean value) {
		this.producerPreferLocal = value;
	}

	/**
	 * Indicates whether JMS consumers and browsers should be given messages from any queue points, rather than the single queue point that they are attached to.
	 */
	public Boolean getGatherMessages() {
		return this.gatherMessages;
	}

	/**
	 * Indicates whether JMS consumers and browsers should be given messages from any queue points, rather than the single queue point that they are attached to.
	 */
	public void setGatherMessages(Boolean value) {
		this.gatherMessages = value;
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
		if (this.description != null) {
			ret.put("description", this.description);
		}
		if (this.queueName != null) {
			ret.put("queueName", this.queueName);
		}
		if (this.deliveryMode != null) {
			ret.put("deliveryMode", this.deliveryMode);
		}
		if (this.timeToLive != null) {
			ret.put("timeToLive", this.timeToLive);
		}
		if (this.priority != null) {
			ret.put("priority", this.priority);
		}
		if (this.readAhead != null) {
			ret.put("readAhead", this.readAhead);
		}
		if (this.busName != null) {
			ret.put("busName", this.busName);
		}
		if (this.scopeToLocalQP != null) {
			ret.put("scopeToLocalQP", this.scopeToLocalQP);
		}
		if (this.producerBind != null) {
			ret.put("producerBind", this.producerBind);
		}
		if (this.producerPreferLocal != null) {
			ret.put("producerPreferLocal", this.producerPreferLocal);
		}
		if (this.gatherMessages != null) {
			ret.put("gatherMessages", this.gatherMessages);
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
