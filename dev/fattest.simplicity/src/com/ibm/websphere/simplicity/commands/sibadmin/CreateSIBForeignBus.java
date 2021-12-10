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
 * Create a SIB foreign bus.
 *   'bus': Bus name.
 *   'name': Foreign bus name.
 *   'routingType': Routing type name {Direct | Indirect}.
 *   'type': Type name {MQ | SIBus} (only required if routing type is "Direct").
 *   'description': Description.
 *   'sendAllowed': Send allowed {True | False} (default is "True").
 *   'inboundUserid': Inbound user identifier.
 *   'outboundUserid': Outbound user identifier.
 *   'nextHopBus': Next hop bus name.
 * The required parameters are found in the constructor.
 */
public class CreateSIBForeignBus extends Command {

	private List<Command> __steps;
	private String bus;
	private String name;
	private String routingType;
	private String type;
	private String description;
	private Boolean sendAllowed;
	private String inboundUserid;
	private String outboundUserid;
	private String nextHopBus;

	public CreateSIBForeignBus(String bus, String name, String routingType) {
		super("createSIBForeignBus");
		this.bus = bus;
		this.name = name;
		this.routingType = routingType;
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
	 * Foreign bus name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Foreign bus name.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Routing type name {Direct | Indirect}.
	 */
	public String getRoutingType() {
		return this.routingType;
	}

	/**
	 * Routing type name {Direct | Indirect}.
	 */
	public void setRoutingType(String value) {
		this.routingType = value;
	}

	/**
	 * Type name {MQ | SIBus} (only required if routing type is "Direct").
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Type name {MQ | SIBus} (only required if routing type is "Direct").
	 */
	public void setType(String value) {
		this.type = value;
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
	 * Send allowed {True | False} (default is "True").
	 */
	public Boolean getSendAllowed() {
		return this.sendAllowed;
	}

	/**
	 * Send allowed {True | False} (default is "True").
	 */
	public void setSendAllowed(Boolean value) {
		this.sendAllowed = value;
	}

	/**
	 * Inbound user identifier.
	 */
	public String getInboundUserid() {
		return this.inboundUserid;
	}

	/**
	 * Inbound user identifier.
	 */
	public void setInboundUserid(String value) {
		this.inboundUserid = value;
	}

	/**
	 * Outbound user identifier.
	 */
	public String getOutboundUserid() {
		return this.outboundUserid;
	}

	/**
	 * Outbound user identifier.
	 */
	public void setOutboundUserid(String value) {
		this.outboundUserid = value;
	}

	/**
	 * Next hop bus name.
	 */
	public String getNextHopBus() {
		return this.nextHopBus;
	}

	/**
	 * Next hop bus name.
	 */
	public void setNextHopBus(String value) {
		this.nextHopBus = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("bus", this.bus);
		ret.put("name", this.name);
		ret.put("routingType", this.routingType);
		if (this.type != null) {
			ret.put("type", this.type);
		}
		if (this.description != null) {
			ret.put("description", this.description);
		}
		if (this.sendAllowed != null) {
			ret.put("sendAllowed", this.sendAllowed);
		}
		if (this.inboundUserid != null) {
			ret.put("inboundUserid", this.inboundUserid);
		}
		if (this.outboundUserid != null) {
			ret.put("outboundUserid", this.outboundUserid);
		}
		if (this.nextHopBus != null) {
			ret.put("nextHopBus", this.nextHopBus);
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
	public OperationResults<Object> run(Scope scope, DestinationDefaults destinationDefaults, TopicSpaceMappings topicSpaceMappings) throws Exception {
		this.__steps = new ArrayList<Command>();
		if (destinationDefaults != null)
			this.__steps.add(destinationDefaults);
		if (topicSpaceMappings != null)
			this.__steps.add(topicSpaceMappings);
		return super.run(scope);
	}

	/**
	 * Sets the destination defaults on a SIB foreign bus.
	 *   'defaultPriority': Destination defaults: default priority (Number between 0 and 9 inclusive).
	 *   'reliability': Destination defaults: reliability {BEST_EFFORT_NONPERSISTENT | EXPRESS_NONPERSISTENT | RELIABLE_NONPERSISTENT | RELIABLE_PERSISTENT | ASSURED_PERSISTENT}.
	 *   'maxReliability': Destination defaults: maximum reliability {BEST_EFFORT_NONPERSISTENT | EXPRESS_NONPERSISTENT | RELIABLE_NONPERSISTENT | RELIABLE_PERSISTENT | ASSURED_PERSISTENT}.
	 *   'sendAllowed': Send allowed {True | False} (default is "True").
	 *   'overrideOfQOSByProducerAllowed': Destination defaults: enable producers to override the default reliability that is set on the destination {True | False}.
	 *   'mqRfh2Allowed': If selected, messages sent to WebSphere MQ will include an RFH2 header. The RFH2 header stores additional information to that which is stored in the WebSphere  MQ message header.
	 * The required parameters are found in the constructor.
	 */
	public static class DestinationDefaults extends CommandStep {

		private Integer defaultPriority;
		private String reliability;
		private String maxReliability;
		private Boolean sendAllowed;
		private Boolean overrideOfQOSByProducerAllowed;
		private Boolean mqRfh2Allowed;

		public DestinationDefaults() {
			super("destinationDefaults");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			if (this.defaultPriority != null) {
				ret.put("defaultPriority", this.defaultPriority);
			}
			if (this.reliability != null) {
				ret.put("reliability", this.reliability);
			}
			if (this.maxReliability != null) {
				ret.put("maxReliability", this.maxReliability);
			}
			if (this.sendAllowed != null) {
				ret.put("sendAllowed", this.sendAllowed);
			}
			if (this.overrideOfQOSByProducerAllowed != null) {
				ret.put("overrideOfQOSByProducerAllowed", this.overrideOfQOSByProducerAllowed);
			}
			if (this.mqRfh2Allowed != null) {
				ret.put("mqRfh2Allowed", this.mqRfh2Allowed);
			}
			return ret;
		}

		/**
		 * Destination defaults: default priority (Number between 0 and 9 inclusive).
		 */
		public Integer getDefaultPriority() {
			return this.defaultPriority;
		}

		/**
		 * Destination defaults: default priority (Number between 0 and 9 inclusive).
		 */
		public void setDefaultPriority(Integer value) {
			this.defaultPriority = value;
		}

		/**
		 * Destination defaults: reliability {BEST_EFFORT_NONPERSISTENT | EXPRESS_NONPERSISTENT | RELIABLE_NONPERSISTENT | RELIABLE_PERSISTENT | ASSURED_PERSISTENT}.
		 */
		public String getReliability() {
			return this.reliability;
		}

		/**
		 * Destination defaults: reliability {BEST_EFFORT_NONPERSISTENT | EXPRESS_NONPERSISTENT | RELIABLE_NONPERSISTENT | RELIABLE_PERSISTENT | ASSURED_PERSISTENT}.
		 */
		public void setReliability(String value) {
			this.reliability = value;
		}

		/**
		 * Destination defaults: maximum reliability {BEST_EFFORT_NONPERSISTENT | EXPRESS_NONPERSISTENT | RELIABLE_NONPERSISTENT | RELIABLE_PERSISTENT | ASSURED_PERSISTENT}.
		 */
		public String getMaxReliability() {
			return this.maxReliability;
		}

		/**
		 * Destination defaults: maximum reliability {BEST_EFFORT_NONPERSISTENT | EXPRESS_NONPERSISTENT | RELIABLE_NONPERSISTENT | RELIABLE_PERSISTENT | ASSURED_PERSISTENT}.
		 */
		public void setMaxReliability(String value) {
			this.maxReliability = value;
		}

		/**
		 * Send allowed {True | False} (default is "True").
		 */
		public Boolean getSendAllowed() {
			return this.sendAllowed;
		}

		/**
		 * Send allowed {True | False} (default is "True").
		 */
		public void setSendAllowed(Boolean value) {
			this.sendAllowed = value;
		}

		/**
		 * Destination defaults: enable producers to override the default reliability that is set on the destination {True | False}.
		 */
		public Boolean getOverrideOfQOSByProducerAllowed() {
			return this.overrideOfQOSByProducerAllowed;
		}

		/**
		 * Destination defaults: enable producers to override the default reliability that is set on the destination {True | False}.
		 */
		public void setOverrideOfQOSByProducerAllowed(Boolean value) {
			this.overrideOfQOSByProducerAllowed = value;
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

	}
	/**
	 * Sets the topic space mappings on a SIB foreign bus.
	 *   'localTopicSpace': Topic space mapping: local topic space name.
	 *   'remoteTopicSpace': Topic space mapping: remote topic space name.
	 * The required parameters are found in the constructor.
	 */
	public static class TopicSpaceMappings extends CommandStep {

		private String localTopicSpace;
		private String remoteTopicSpace;

		public TopicSpaceMappings() {
			super("topicSpaceMappings");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			if (this.localTopicSpace != null) {
				ret.put("localTopicSpace", this.localTopicSpace);
			}
			if (this.remoteTopicSpace != null) {
				ret.put("remoteTopicSpace", this.remoteTopicSpace);
			}
			return ret;
		}

		/**
		 * Topic space mapping: local topic space name.
		 */
		public String getLocalTopicSpace() {
			return this.localTopicSpace;
		}

		/**
		 * Topic space mapping: local topic space name.
		 */
		public void setLocalTopicSpace(String value) {
			this.localTopicSpace = value;
		}

		/**
		 * Topic space mapping: remote topic space name.
		 */
		public String getRemoteTopicSpace() {
			return this.remoteTopicSpace;
		}

		/**
		 * Topic space mapping: remote topic space name.
		 */
		public void setRemoteTopicSpace(String value) {
			this.remoteTopicSpace = value;
		}

	}
}
