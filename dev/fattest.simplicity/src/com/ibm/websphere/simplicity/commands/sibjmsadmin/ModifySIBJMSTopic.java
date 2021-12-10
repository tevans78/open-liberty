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
 * Modify the attributes of the supplied SIB JMS topic using the supplied attribute values.
 *   'name': The SIB JMS topic's new name.
 *   'jndiName': The SIB JMS topic's new JNDI name.
 *   'description': The SIB JMS topic's new description.
 *   'topicSpace': The name of the underlying SIB topic space to which the topic points.
 *   'topicName': The topic to be used inside the topic space (for example, stock/IBM).
 *   'deliveryMode': The delivery mode for messages. Legal values are "Application", "NonPersistent" and "Persistent".
 *   'timeToLive': The time in milliseconds to be used for message expiration.
 *   'priority': The priority for messages. Whole number in the range 0 to 9.
 *   'readAhead': Read-ahead value. Legal values are "AsConnection", "AlwaysOn" and "AlwaysOff".
 *   'busName': The name of the bus on which the topic resides.
 * The required parameters are found in the constructor.
 */
public class ModifySIBJMSTopic extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String name;
	private String jndiName;
	private String description;
	private String topicSpace;
	private String topicName;
	private String deliveryMode;
	private Long timeToLive;
	private Integer priority;
	private String readAhead;
	private String busName;

	public ModifySIBJMSTopic(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget) {
		super("modifySIBJMSTopic");
		this.__target = commandTarget;
	}

	/**
	 * The SIB JMS topic's new name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The SIB JMS topic's new name.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * The SIB JMS topic's new JNDI name.
	 */
	public String getJndiName() {
		return this.jndiName;
	}

	/**
	 * The SIB JMS topic's new JNDI name.
	 */
	public void setJndiName(String value) {
		this.jndiName = value;
	}

	/**
	 * The SIB JMS topic's new description.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * The SIB JMS topic's new description.
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * The name of the underlying SIB topic space to which the topic points.
	 */
	public String getTopicSpace() {
		return this.topicSpace;
	}

	/**
	 * The name of the underlying SIB topic space to which the topic points.
	 */
	public void setTopicSpace(String value) {
		this.topicSpace = value;
	}

	/**
	 * The topic to be used inside the topic space (for example, stock/IBM).
	 */
	public String getTopicName() {
		return this.topicName;
	}

	/**
	 * The topic to be used inside the topic space (for example, stock/IBM).
	 */
	public void setTopicName(String value) {
		this.topicName = value;
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
	 * The name of the bus on which the topic resides.
	 */
	public String getBusName() {
		return this.busName;
	}

	/**
	 * The name of the bus on which the topic resides.
	 */
	public void setBusName(String value) {
		this.busName = value;
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
		if (this.topicSpace != null) {
			ret.put("topicSpace", this.topicSpace);
		}
		if (this.topicName != null) {
			ret.put("topicName", this.topicName);
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
