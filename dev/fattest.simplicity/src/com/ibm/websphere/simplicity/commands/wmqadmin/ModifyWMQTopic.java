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
 * Modifies the properties of the WMQ Topic provided to the command.
 *   'brokerCCDurSubQueue': The name of the queue from which a connection consumer receives durable subscription messages
 *   'brokerDurSubQueue': The name of the queue from which a connection consumer receives non-durable subscription messages.
 *   'brokerPubQmgr': The name of the queue manager on which the broker is running.
 *   'brokerPubQueue': The name of the queue to which publication messages should be sent.
 *   'brokerVersion': Determines the level of functionality required for publish/subscribe operations.
 *   'ccsid': The coded character set identifier.
 *   'decimalEncoding': The decimal encoding setting for this topic. Legal values are "Normal" and "Reversed".
 *   'description': An administrative description to associate with this WMQ JMS topic type destination.
 *   'expiry': The amount of time after which messages, sent to this destination, expire and are dealt with as per their disposition options. Legal values are "APP", "UNLIM" or any positive integer.
 *   'floatingPointEncoding': The floating point encoding setting for this topic. Legal values are "IEEENormal", "IEEEReversed" and "z/OS".
 *   'integerEncoding': The integer encoding setting for this topic. Legal values are "Normal" and "Reversed".
 *   'jndiName': The name used to bind this WMQ JMS topic type destination into WAS JNDI.
 *   'name': The administrative name to assign to the WMQ JMS topic type destination.
 *   'persistence': Determines the level of persistence used to store messages sent to this destination. Legal values are "APP", "TDEF", "PERS", "NON" or "HIGH".
 *   'priority': The priority level to assign to messages sent to this destination. Legal values are "APP", "TDEF", "0", "1", "2", "3", "4", "5", "6", "7", "8", or "9".
 *   'readAheadClose': This property determines the behaviour that occurs when closing a message consumer that is receiving messages asynchronously using a message listener from a destination that has the "readAhead" parameter set to true. When a value of "DELIVERALL" is specified the close method invocation will wait until all "read-ahead" messages are delivered to the consumer before closing it.  When a value of "DELIVERCURRENT" is specified then the close() method will only wait for any in-progress delivery to end before closing the consumer. Legal values are "DELIVERALL" and "DELIVERCURRENT".
 *   'readAhead': Determines if messages, for non-persistent consumers, can be read ahead and cached. Legal values are "YES", "NO" or "TDEF".
 *   'sendAsync': Determines if messages can be sent to this destination without requiring that the queue manager acknowledges they have arrived. Legal values are "YES", "NO" or "TDEF".
 *   'topicName': The name of the WebSphere MQ topic where publications will be received from, or sent to when this destination definition is used.
 *   'useRFH2': Determines whether a RFH version 2 header is appended to messages sent to this destination. Legal values are "true" or "false".
 *   'useNativeEncoding': Use the native encoding settings on this topic.
 *   'wildcardFormat': Determines which sets of characters are interpreted as topic wildcards.
 * The required parameters are found in the constructor.
 */
public class ModifyWMQTopic extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private List<Command> __steps;
	private String brokerCCDurSubQueue;
	private String brokerDurSubQueue;
	private String brokerPubQmgr;
	private String brokerPubQueue;
	private String brokerVersion;
	private Integer ccsid;
	private String decimalEncoding;
	private String description;
	private String expiry;
	private String floatingPointEncoding;
	private String integerEncoding;
	private String jndiName;
	private String name;
	private String persistence;
	private String priority;
	private String readAheadClose;
	private String readAhead;
	private String sendAsync;
	private String topicName;
	private Boolean useRFH2;
	private Boolean useNativeEncoding;
	private String wildcardFormat;

	public ModifyWMQTopic(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget) {
		super("modifyWMQTopic");
		this.__target = commandTarget;
	}

	/**
	 * The name of the queue from which a connection consumer receives durable subscription messages
	 */
	public String getBrokerCCDurSubQueue() {
		return this.brokerCCDurSubQueue;
	}

	/**
	 * The name of the queue from which a connection consumer receives durable subscription messages
	 */
	public void setBrokerCCDurSubQueue(String value) {
		this.brokerCCDurSubQueue = value;
	}

	/**
	 * The name of the queue from which a connection consumer receives non-durable subscription messages.
	 */
	public String getBrokerDurSubQueue() {
		return this.brokerDurSubQueue;
	}

	/**
	 * The name of the queue from which a connection consumer receives non-durable subscription messages.
	 */
	public void setBrokerDurSubQueue(String value) {
		this.brokerDurSubQueue = value;
	}

	/**
	 * The name of the queue manager on which the broker is running.
	 */
	public String getBrokerPubQmgr() {
		return this.brokerPubQmgr;
	}

	/**
	 * The name of the queue manager on which the broker is running.
	 */
	public void setBrokerPubQmgr(String value) {
		this.brokerPubQmgr = value;
	}

	/**
	 * The name of the queue to which publication messages should be sent.
	 */
	public String getBrokerPubQueue() {
		return this.brokerPubQueue;
	}

	/**
	 * The name of the queue to which publication messages should be sent.
	 */
	public void setBrokerPubQueue(String value) {
		this.brokerPubQueue = value;
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
	 * The coded character set identifier.
	 */
	public Integer getCcsid() {
		return this.ccsid;
	}

	/**
	 * The coded character set identifier.
	 */
	public void setCcsid(Integer value) {
		this.ccsid = value;
	}

	/**
	 * The decimal encoding setting for this topic. Legal values are "Normal" and "Reversed".
	 */
	public String getDecimalEncoding() {
		return this.decimalEncoding;
	}

	/**
	 * The decimal encoding setting for this topic. Legal values are "Normal" and "Reversed".
	 */
	public void setDecimalEncoding(String value) {
		this.decimalEncoding = value;
	}

	/**
	 * An administrative description to associate with this WMQ JMS topic type destination.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * An administrative description to associate with this WMQ JMS topic type destination.
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * The amount of time after which messages, sent to this destination, expire and are dealt with as per their disposition options. Legal values are "APP", "UNLIM" or any positive integer.
	 */
	public String getExpiry() {
		return this.expiry;
	}

	/**
	 * The amount of time after which messages, sent to this destination, expire and are dealt with as per their disposition options. Legal values are "APP", "UNLIM" or any positive integer.
	 */
	public void setExpiry(String value) {
		this.expiry = value;
	}

	/**
	 * The floating point encoding setting for this topic. Legal values are "IEEENormal", "IEEEReversed" and "z/OS".
	 */
	public String getFloatingPointEncoding() {
		return this.floatingPointEncoding;
	}

	/**
	 * The floating point encoding setting for this topic. Legal values are "IEEENormal", "IEEEReversed" and "z/OS".
	 */
	public void setFloatingPointEncoding(String value) {
		this.floatingPointEncoding = value;
	}

	/**
	 * The integer encoding setting for this topic. Legal values are "Normal" and "Reversed".
	 */
	public String getIntegerEncoding() {
		return this.integerEncoding;
	}

	/**
	 * The integer encoding setting for this topic. Legal values are "Normal" and "Reversed".
	 */
	public void setIntegerEncoding(String value) {
		this.integerEncoding = value;
	}

	/**
	 * The name used to bind this WMQ JMS topic type destination into WAS JNDI.
	 */
	public String getJndiName() {
		return this.jndiName;
	}

	/**
	 * The name used to bind this WMQ JMS topic type destination into WAS JNDI.
	 */
	public void setJndiName(String value) {
		this.jndiName = value;
	}

	/**
	 * The administrative name to assign to the WMQ JMS topic type destination.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The administrative name to assign to the WMQ JMS topic type destination.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Determines the level of persistence used to store messages sent to this destination. Legal values are "APP", "TDEF", "PERS", "NON" or "HIGH".
	 */
	public String getPersistence() {
		return this.persistence;
	}

	/**
	 * Determines the level of persistence used to store messages sent to this destination. Legal values are "APP", "TDEF", "PERS", "NON" or "HIGH".
	 */
	public void setPersistence(String value) {
		this.persistence = value;
	}

	/**
	 * The priority level to assign to messages sent to this destination. Legal values are "APP", "TDEF", "0", "1", "2", "3", "4", "5", "6", "7", "8", or "9".
	 */
	public String getPriority() {
		return this.priority;
	}

	/**
	 * The priority level to assign to messages sent to this destination. Legal values are "APP", "TDEF", "0", "1", "2", "3", "4", "5", "6", "7", "8", or "9".
	 */
	public void setPriority(String value) {
		this.priority = value;
	}

	/**
	 * This property determines the behaviour that occurs when closing a message consumer that is receiving messages asynchronously using a message listener from a destination that has the "readAhead" parameter set to true. When a value of "DELIVERALL" is specified the close method invocation will wait until all "read-ahead" messages are delivered to the consumer before closing it.  When a value of "DELIVERCURRENT" is specified then the close() method will only wait for any in-progress delivery to end before closing the consumer. Legal values are "DELIVERALL" and "DELIVERCURRENT".
	 */
	public String getReadAheadClose() {
		return this.readAheadClose;
	}

	/**
	 * This property determines the behaviour that occurs when closing a message consumer that is receiving messages asynchronously using a message listener from a destination that has the "readAhead" parameter set to true. When a value of "DELIVERALL" is specified the close method invocation will wait until all "read-ahead" messages are delivered to the consumer before closing it.  When a value of "DELIVERCURRENT" is specified then the close() method will only wait for any in-progress delivery to end before closing the consumer. Legal values are "DELIVERALL" and "DELIVERCURRENT".
	 */
	public void setReadAheadClose(String value) {
		this.readAheadClose = value;
	}

	/**
	 * Determines if messages, for non-persistent consumers, can be read ahead and cached. Legal values are "YES", "NO" or "TDEF".
	 */
	public String getReadAhead() {
		return this.readAhead;
	}

	/**
	 * Determines if messages, for non-persistent consumers, can be read ahead and cached. Legal values are "YES", "NO" or "TDEF".
	 */
	public void setReadAhead(String value) {
		this.readAhead = value;
	}

	/**
	 * Determines if messages can be sent to this destination without requiring that the queue manager acknowledges they have arrived. Legal values are "YES", "NO" or "TDEF".
	 */
	public String getSendAsync() {
		return this.sendAsync;
	}

	/**
	 * Determines if messages can be sent to this destination without requiring that the queue manager acknowledges they have arrived. Legal values are "YES", "NO" or "TDEF".
	 */
	public void setSendAsync(String value) {
		this.sendAsync = value;
	}

	/**
	 * The name of the WebSphere MQ topic where publications will be received from, or sent to when this destination definition is used.
	 */
	public String getTopicName() {
		return this.topicName;
	}

	/**
	 * The name of the WebSphere MQ topic where publications will be received from, or sent to when this destination definition is used.
	 */
	public void setTopicName(String value) {
		this.topicName = value;
	}

	/**
	 * Determines whether a RFH version 2 header is appended to messages sent to this destination. Legal values are "true" or "false".
	 */
	public Boolean getUseRFH2() {
		return this.useRFH2;
	}

	/**
	 * Determines whether a RFH version 2 header is appended to messages sent to this destination. Legal values are "true" or "false".
	 */
	public void setUseRFH2(Boolean value) {
		this.useRFH2 = value;
	}

	/**
	 * Use the native encoding settings on this topic.
	 */
	public Boolean getUseNativeEncoding() {
		return this.useNativeEncoding;
	}

	/**
	 * Use the native encoding settings on this topic.
	 */
	public void setUseNativeEncoding(Boolean value) {
		this.useNativeEncoding = value;
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
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.brokerCCDurSubQueue != null) {
			ret.put("brokerCCDurSubQueue", this.brokerCCDurSubQueue);
		}
		if (this.brokerDurSubQueue != null) {
			ret.put("brokerDurSubQueue", this.brokerDurSubQueue);
		}
		if (this.brokerPubQmgr != null) {
			ret.put("brokerPubQmgr", this.brokerPubQmgr);
		}
		if (this.brokerPubQueue != null) {
			ret.put("brokerPubQueue", this.brokerPubQueue);
		}
		if (this.brokerVersion != null) {
			ret.put("brokerVersion", this.brokerVersion);
		}
		if (this.ccsid != null) {
			ret.put("ccsid", this.ccsid);
		}
		if (this.decimalEncoding != null) {
			ret.put("decimalEncoding", this.decimalEncoding);
		}
		if (this.description != null) {
			ret.put("description", this.description);
		}
		if (this.expiry != null) {
			ret.put("expiry", this.expiry);
		}
		if (this.floatingPointEncoding != null) {
			ret.put("floatingPointEncoding", this.floatingPointEncoding);
		}
		if (this.integerEncoding != null) {
			ret.put("integerEncoding", this.integerEncoding);
		}
		if (this.jndiName != null) {
			ret.put("jndiName", this.jndiName);
		}
		if (this.name != null) {
			ret.put("name", this.name);
		}
		if (this.persistence != null) {
			ret.put("persistence", this.persistence);
		}
		if (this.priority != null) {
			ret.put("priority", this.priority);
		}
		if (this.readAheadClose != null) {
			ret.put("readAheadClose", this.readAheadClose);
		}
		if (this.readAhead != null) {
			ret.put("readAhead", this.readAhead);
		}
		if (this.sendAsync != null) {
			ret.put("sendAsync", this.sendAsync);
		}
		if (this.topicName != null) {
			ret.put("topicName", this.topicName);
		}
		if (this.useRFH2 != null) {
			ret.put("useRFH2", this.useRFH2);
		}
		if (this.useNativeEncoding != null) {
			ret.put("useNativeEncoding", this.useNativeEncoding);
		}
		if (this.wildcardFormat != null) {
			ret.put("wildcardFormat", this.wildcardFormat);
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
