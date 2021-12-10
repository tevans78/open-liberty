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
 * Modify bus destination.
 *   'bus': Bus name.
 *   'name': Destination name.
 *   'description': Description.
 *   'reliability': The quality of service for message flows through this destination, from BEST_EFFORT_NON-PERSISTENT to ASSURED_PERSISTENT, in order of increasing reliability. Higher levels of reliability have higher impacts on the performance.
 *   'maxReliability': The maximum reliability quality of service that is accepted for values specified by producers.
 *   'overrideOfQOSByProducerAllowed': Controls the quality of service for message flows between producers and the destination. Select this option to use the quality of service specified by producers instead of the quality defined for the destination.
 *   'defaultPriority': The default priority for message flows through this destination, in the range 0 (lowest) through 9 (highest). This default priority is used for messages that do not contain a priority value.
 *   'maxFailedDeliveries': The maximum number of times that service tries to deliver a message to the destination before forwarding it to the exception destination.
 *   'exceptionDestination': The name of another destination to which the system sends a message that cannot be delivered to this destination within the specified maximum number of failed deliveries.
 *   'sendAllowed': Clear this option (setting it to false) to stop producers from being able to send messages to this destination.
 *   'receiveAllowed': Clear this option (setting it to false) to prevent consumers from being able to receive messages from this destination.
 *   'receiveExclusive': Select this option (setting it to true) to allow only one consumer to attach to a destination.
 *   'maintainStrictMessageOrder': Select this option (setting it to true) to enforce message order for this destination.
 *   'topicAccessCheckRequired': Topic access check required.
 *   'replyDestination': The name of the destination for reply messages.
 *   'replyDestinationBus': The name of the bus on which the reply destination is configured.
 *   'delegateAuthorizationCheckToTarget': Indicates whether the authorization check should be delegated to the alias or target destination.
 *   'auditAllowed': Used to allow or prevent the bus from auditing topic level authorization checks when the bus and application server have auditing enabled.
 *   'blockedRetryTimeout': Override the blocked destination retry interval configured on the messaging engine owning the destination.
 *   'useAllQueuePoints': Clear this option (Setting it to false) to deliver to a selected list of queue points in the alias destination
 *   'useAllMediationPoints': Clear this option (Setting it to false) to deliver to a selected list of queue points in the alias destination
 *   'mqRfh2Allowed': If selected, messages sent to WebSphere MQ will include an RFH2 header. The RFH2 header stores additional information to that which is stored in the WebSphere  MQ message header.
 * The required parameters are found in the constructor.
 */
public class ModifySIBDestination extends Command {

	private List<Command> __steps;
	private String bus;
	private String name;
	private String description;
	private String reliability;
	private String maxReliability;
	private String overrideOfQOSByProducerAllowed;
	private Integer defaultPriority;
	private Integer maxFailedDeliveries;
	private String exceptionDestination;
	private String sendAllowed;
	private String receiveAllowed;
	private Boolean receiveExclusive;
	private Boolean maintainStrictMessageOrder;
	private Boolean topicAccessCheckRequired;
	private String replyDestination;
	private String replyDestinationBus;
	private Boolean delegateAuthorizationCheckToTarget;
	private Boolean auditAllowed;
	private java.lang.Long blockedRetryTimeout;
	private Boolean useAllQueuePoints;
	private Boolean useAllMediationPoints;
	private Boolean mqRfh2Allowed;

	public ModifySIBDestination(String bus, String name) {
		super("modifySIBDestination");
		this.bus = bus;
		this.name = name;
	}

	/**
	 * Bus name.
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * Bus name.
	 */
	public void setBus(String value) {
		this.bus = value;
	}

	/**
	 * Destination name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Destination name.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Description.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Description.
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * The quality of service for message flows through this destination, from BEST_EFFORT_NON-PERSISTENT to ASSURED_PERSISTENT, in order of increasing reliability. Higher levels of reliability have higher impacts on the performance.
	 */
	public String getReliability() {
		return this.reliability;
	}

	/**
	 * The quality of service for message flows through this destination, from BEST_EFFORT_NON-PERSISTENT to ASSURED_PERSISTENT, in order of increasing reliability. Higher levels of reliability have higher impacts on the performance.
	 */
	public void setReliability(String value) {
		this.reliability = value;
	}

	/**
	 * The maximum reliability quality of service that is accepted for values specified by producers.
	 */
	public String getMaxReliability() {
		return this.maxReliability;
	}

	/**
	 * The maximum reliability quality of service that is accepted for values specified by producers.
	 */
	public void setMaxReliability(String value) {
		this.maxReliability = value;
	}

	/**
	 * Controls the quality of service for message flows between producers and the destination. Select this option to use the quality of service specified by producers instead of the quality defined for the destination.
	 */
	public String getOverrideOfQOSByProducerAllowed() {
		return this.overrideOfQOSByProducerAllowed;
	}

	/**
	 * Controls the quality of service for message flows between producers and the destination. Select this option to use the quality of service specified by producers instead of the quality defined for the destination.
	 */
	public void setOverrideOfQOSByProducerAllowed(String value) {
		this.overrideOfQOSByProducerAllowed = value;
	}

	/**
	 * The default priority for message flows through this destination, in the range 0 (lowest) through 9 (highest). This default priority is used for messages that do not contain a priority value.
	 */
	public Integer getDefaultPriority() {
		return this.defaultPriority;
	}

	/**
	 * The default priority for message flows through this destination, in the range 0 (lowest) through 9 (highest). This default priority is used for messages that do not contain a priority value.
	 */
	public void setDefaultPriority(Integer value) {
		this.defaultPriority = value;
	}

	/**
	 * The maximum number of times that service tries to deliver a message to the destination before forwarding it to the exception destination.
	 */
	public Integer getMaxFailedDeliveries() {
		return this.maxFailedDeliveries;
	}

	/**
	 * The maximum number of times that service tries to deliver a message to the destination before forwarding it to the exception destination.
	 */
	public void setMaxFailedDeliveries(Integer value) {
		this.maxFailedDeliveries = value;
	}

	/**
	 * The name of another destination to which the system sends a message that cannot be delivered to this destination within the specified maximum number of failed deliveries.
	 */
	public String getExceptionDestination() {
		return this.exceptionDestination;
	}

	/**
	 * The name of another destination to which the system sends a message that cannot be delivered to this destination within the specified maximum number of failed deliveries.
	 */
	public void setExceptionDestination(String value) {
		this.exceptionDestination = value;
	}

	/**
	 * Clear this option (setting it to false) to stop producers from being able to send messages to this destination.
	 */
	public String getSendAllowed() {
		return this.sendAllowed;
	}

	/**
	 * Clear this option (setting it to false) to stop producers from being able to send messages to this destination.
	 */
	public void setSendAllowed(String value) {
		this.sendAllowed = value;
	}

	/**
	 * Clear this option (setting it to false) to prevent consumers from being able to receive messages from this destination.
	 */
	public String getReceiveAllowed() {
		return this.receiveAllowed;
	}

	/**
	 * Clear this option (setting it to false) to prevent consumers from being able to receive messages from this destination.
	 */
	public void setReceiveAllowed(String value) {
		this.receiveAllowed = value;
	}

	/**
	 * Select this option (setting it to true) to allow only one consumer to attach to a destination.
	 */
	public Boolean getReceiveExclusive() {
		return this.receiveExclusive;
	}

	/**
	 * Select this option (setting it to true) to allow only one consumer to attach to a destination.
	 */
	public void setReceiveExclusive(Boolean value) {
		this.receiveExclusive = value;
	}

	/**
	 * Select this option (setting it to true) to enforce message order for this destination.
	 */
	public Boolean getMaintainStrictMessageOrder() {
		return this.maintainStrictMessageOrder;
	}

	/**
	 * Select this option (setting it to true) to enforce message order for this destination.
	 */
	public void setMaintainStrictMessageOrder(Boolean value) {
		this.maintainStrictMessageOrder = value;
	}

	/**
	 * Topic access check required.
	 */
	public Boolean getTopicAccessCheckRequired() {
		return this.topicAccessCheckRequired;
	}

	/**
	 * Topic access check required.
	 */
	public void setTopicAccessCheckRequired(Boolean value) {
		this.topicAccessCheckRequired = value;
	}

	/**
	 * The name of the destination for reply messages.
	 */
	public String getReplyDestination() {
		return this.replyDestination;
	}

	/**
	 * The name of the destination for reply messages.
	 */
	public void setReplyDestination(String value) {
		this.replyDestination = value;
	}

	/**
	 * The name of the bus on which the reply destination is configured.
	 */
	public String getReplyDestinationBus() {
		return this.replyDestinationBus;
	}

	/**
	 * The name of the bus on which the reply destination is configured.
	 */
	public void setReplyDestinationBus(String value) {
		this.replyDestinationBus = value;
	}

	/**
	 * Indicates whether the authorization check should be delegated to the alias or target destination.
	 */
	public Boolean getDelegateAuthorizationCheckToTarget() {
		return this.delegateAuthorizationCheckToTarget;
	}

	/**
	 * Indicates whether the authorization check should be delegated to the alias or target destination.
	 */
	public void setDelegateAuthorizationCheckToTarget(Boolean value) {
		this.delegateAuthorizationCheckToTarget = value;
	}

	/**
	 * Used to allow or prevent the bus from auditing topic level authorization checks when the bus and application server have auditing enabled.
	 */
	public Boolean getAuditAllowed() {
		return this.auditAllowed;
	}

	/**
	 * Used to allow or prevent the bus from auditing topic level authorization checks when the bus and application server have auditing enabled.
	 */
	public void setAuditAllowed(Boolean value) {
		this.auditAllowed = value;
	}

	/**
	 * Override the blocked destination retry interval configured on the messaging engine owning the destination.
	 */
	public java.lang.Long getBlockedRetryTimeout() {
		return this.blockedRetryTimeout;
	}

	/**
	 * Override the blocked destination retry interval configured on the messaging engine owning the destination.
	 */
	public void setBlockedRetryTimeout(java.lang.Long value) {
		this.blockedRetryTimeout = value;
	}

	/**
	 * Clear this option (Setting it to false) to deliver to a selected list of queue points in the alias destination
	 */
	public Boolean getUseAllQueuePoints() {
		return this.useAllQueuePoints;
	}

	/**
	 * Clear this option (Setting it to false) to deliver to a selected list of queue points in the alias destination
	 */
	public void setUseAllQueuePoints(Boolean value) {
		this.useAllQueuePoints = value;
	}

	/**
	 * Clear this option (Setting it to false) to deliver to a selected list of queue points in the alias destination
	 */
	public Boolean getUseAllMediationPoints() {
		return this.useAllMediationPoints;
	}

	/**
	 * Clear this option (Setting it to false) to deliver to a selected list of queue points in the alias destination
	 */
	public void setUseAllMediationPoints(Boolean value) {
		this.useAllMediationPoints = value;
	}

	/**
	 * If selected, messages sent to WebSphere MQ will include an RFH2 header. The RFH2 header stores additional information to that which is stored in the WebSphere  MQ message header.
	 */
	public Boolean getMqRfh2Allowed() {
		return this.mqRfh2Allowed;
	}

	/**
	 * If selected, messages sent to WebSphere MQ will include an RFH2 header. The RFH2 header stores additional information to that which is stored in the WebSphere  MQ message header.
	 */
	public void setMqRfh2Allowed(Boolean value) {
		this.mqRfh2Allowed = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("bus", this.bus);
		ret.put("name", this.name);
		if (this.description != null) {
			ret.put("description", this.description);
		}
		if (this.reliability != null) {
			ret.put("reliability", this.reliability);
		}
		if (this.maxReliability != null) {
			ret.put("maxReliability", this.maxReliability);
		}
		if (this.overrideOfQOSByProducerAllowed != null) {
			ret.put("overrideOfQOSByProducerAllowed", this.overrideOfQOSByProducerAllowed);
		}
		if (this.defaultPriority != null) {
			ret.put("defaultPriority", this.defaultPriority);
		}
		if (this.maxFailedDeliveries != null) {
			ret.put("maxFailedDeliveries", this.maxFailedDeliveries);
		}
		if (this.exceptionDestination != null) {
			ret.put("exceptionDestination", this.exceptionDestination);
		}
		if (this.sendAllowed != null) {
			ret.put("sendAllowed", this.sendAllowed);
		}
		if (this.receiveAllowed != null) {
			ret.put("receiveAllowed", this.receiveAllowed);
		}
		if (this.receiveExclusive != null) {
			ret.put("receiveExclusive", this.receiveExclusive);
		}
		if (this.maintainStrictMessageOrder != null) {
			ret.put("maintainStrictMessageOrder", this.maintainStrictMessageOrder);
		}
		if (this.topicAccessCheckRequired != null) {
			ret.put("topicAccessCheckRequired", this.topicAccessCheckRequired);
		}
		if (this.replyDestination != null) {
			ret.put("replyDestination", this.replyDestination);
		}
		if (this.replyDestinationBus != null) {
			ret.put("replyDestinationBus", this.replyDestinationBus);
		}
		if (this.delegateAuthorizationCheckToTarget != null) {
			ret.put("delegateAuthorizationCheckToTarget", this.delegateAuthorizationCheckToTarget);
		}
		if (this.auditAllowed != null) {
			ret.put("auditAllowed", this.auditAllowed);
		}
		if (this.blockedRetryTimeout != null) {
			ret.put("blockedRetryTimeout", this.blockedRetryTimeout);
		}
		if (this.useAllQueuePoints != null) {
			ret.put("useAllQueuePoints", this.useAllQueuePoints);
		}
		if (this.useAllMediationPoints != null) {
			ret.put("useAllMediationPoints", this.useAllMediationPoints);
		}
		if (this.mqRfh2Allowed != null) {
			ret.put("mqRfh2Allowed", this.mqRfh2Allowed);
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
	public OperationResults<Object> run(Scope scope, DefaultForwardRoutingPath defaultForwardRoutingPath, QueuePoints queuePoints, MediationPoints mediationPoints) throws Exception {
		this.__steps = new ArrayList<Command>();
		if (defaultForwardRoutingPath != null)
			this.__steps.add(defaultForwardRoutingPath);
		if (queuePoints != null)
			this.__steps.add(queuePoints);
		if (mediationPoints != null)
			this.__steps.add(mediationPoints);
		return super.run(scope);
	}

	/**
	 * Default forward routing path.
	 *   'bus': Bus name.
	 *   'destination': Destination name.
	 * The required parameters are found in the constructor.
	 */
	public static class DefaultForwardRoutingPath extends CommandStep {

		private String bus;
		private String destination;

		public DefaultForwardRoutingPath(String destination) {
			super("defaultForwardRoutingPath");
			this.destination = destination;
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			if (this.bus != null) {
				ret.put("bus", this.bus);
			}
			ret.put("destination", this.destination);
			return ret;
		}

		/**
		 * Bus name.
		 */
		public String getBus() {
			return this.bus;
		}

		/**
		 * Bus name.
		 */
		public void setBus(String value) {
			this.bus = value;
		}

		/**
		 * Destination name.
		 */
		public String getDestination() {
			return this.destination;
		}

		/**
		 * Destination name.
		 */
		public void setDestination(String value) {
			this.destination = value;
		}

	}
	/**
	 * A list of the queue points that will be used by users of the alias destination
	 *   'identifier': The queue point identifier
	 * The required parameters are found in the constructor.
	 */
	public static class QueuePoints extends CommandStep {

		private String identifier;

		public QueuePoints(String identifier) {
			super("queuePoints");
			this.identifier = identifier;
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			ret.put("identifier", this.identifier);
			return ret;
		}

		/**
		 * The queue point identifier
		 */
		public String getIdentifier() {
			return this.identifier;
		}

		/**
		 * The queue point identifier
		 */
		public void setIdentifier(String value) {
			this.identifier = value;
		}

	}
	/**
	 * A list of the mediation points that will be used by users of the alias destination
	 *   'identifier': MODIFY_SIB_DEST_CMD_MEDIATION_POINTS_ID_PARAM_DESCRIPTION
	 * The required parameters are found in the constructor.
	 */
	public static class MediationPoints extends CommandStep {

		private String identifier;

		public MediationPoints(String identifier) {
			super("mediationPoints");
			this.identifier = identifier;
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			ret.put("identifier", this.identifier);
			return ret;
		}

		/**
		 * MODIFY_SIB_DEST_CMD_MEDIATION_POINTS_ID_PARAM_DESCRIPTION
		 */
		public String getIdentifier() {
			return this.identifier;
		}

		/**
		 * MODIFY_SIB_DEST_CMD_MEDIATION_POINTS_ID_PARAM_DESCRIPTION
		 */
		public void setIdentifier(String value) {
			this.identifier = value;
		}

	}
}
