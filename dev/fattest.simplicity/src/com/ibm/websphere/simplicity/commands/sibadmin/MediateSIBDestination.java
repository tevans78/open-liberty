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
 * Mediate a destination.
 *   'bus': The name of the bus where the destination is to be mediated.
 *   'destinationName': The name of the destination to be mediated.
 *   'mediationName': The name to be given to the mediation.
 *   'node': If mediating a destination to a server, specify the node and server name, but not the cluster name.  If the destination being mediated is localized in WebSphere MQ then if node is specified this becomes the mediation execution point.
 *   'server': If mediating a destination to a server, specify the node and server name, but not the cluster name.   If the destination being mediated is localized in WebSphere MQ then if server is specified this becomes the mediation execution point.
 *   'cluster': If mediating a destination to a cluster, specify the cluster name, but not the node or server name.   If the destination being mediated is localized in WebSphere MQ then a cluster is specified the cluster becomes the mediation execution point.
 *   'wmqServer': To assign the destination from which a mediation should read message to process from a queue localized on a WebSphere MQ server, supply a WebSphere MQ server name.
 *   'nonPersistentReliability': The quality of service used for inbound messages which WebSphere MQ regards as being non-persistent.  Allowable values are { BEST_EFFORT | EXPRESS | RELIABLE }.
 *   'persistentReliability': The quality of service used for inbound messages which WebSphere MQ regards as being persistent.  Allowable values are { RELIABLE | ASSURED }.
 *   'useRFH2': Determines if messages sent to the WebSphere MQ destination have an RFH2 header or not.  This can only be specified with the WebSphere MQ server name.
 *   'wmqQueueName': The name of the WebSphere MQ queue for messages.  This must be specified when the WebSphere MQ server name parameter is specified.
 *   'externallyMediated': If the destination is assigned to WebSphere MQ then an external application can mediate the WebSphere MQ queue.
 * The required parameters are found in the constructor.
 */
public class MediateSIBDestination extends Command {

	private String bus;
	private String destinationName;
	private String mediationName;
	private String node;
	private String server;
	private String cluster;
	private String wmqServer;
	private String nonPersistentReliability;
	private String persistentReliability;
	private Boolean useRFH2;
	private String wmqQueueName;
	private Boolean externallyMediated = false;

	public MediateSIBDestination(String bus, String destinationName) {
		super("mediateSIBDestination");
		this.bus = bus;
		this.destinationName = destinationName;
	}

	/**
	 * The name of the bus where the destination is to be mediated.
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * The name of the bus where the destination is to be mediated.
	 */
	public void setBus(String value) {
		this.bus = value;
	}

	/**
	 * The name of the destination to be mediated.
	 */
	public String getDestinationName() {
		return this.destinationName;
	}

	/**
	 * The name of the destination to be mediated.
	 */
	public void setDestinationName(String value) {
		this.destinationName = value;
	}

	/**
	 * The name to be given to the mediation.
	 */
	public String getMediationName() {
		return this.mediationName;
	}

	/**
	 * The name to be given to the mediation.
	 */
	public void setMediationName(String value) {
		this.mediationName = value;
	}

	/**
	 * If mediating a destination to a server, specify the node and server name, but not the cluster name.  If the destination being mediated is localized in WebSphere MQ then if node is specified this becomes the mediation execution point.
	 */
	public String getNode() {
		return this.node;
	}

	/**
	 * If mediating a destination to a server, specify the node and server name, but not the cluster name.  If the destination being mediated is localized in WebSphere MQ then if node is specified this becomes the mediation execution point.
	 */
	public void setNode(String value) {
		this.node = value;
	}

	/**
	 * If mediating a destination to a server, specify the node and server name, but not the cluster name.   If the destination being mediated is localized in WebSphere MQ then if server is specified this becomes the mediation execution point.
	 */
	public String getServer() {
		return this.server;
	}

	/**
	 * If mediating a destination to a server, specify the node and server name, but not the cluster name.   If the destination being mediated is localized in WebSphere MQ then if server is specified this becomes the mediation execution point.
	 */
	public void setServer(String value) {
		this.server = value;
	}

	/**
	 * If mediating a destination to a cluster, specify the cluster name, but not the node or server name.   If the destination being mediated is localized in WebSphere MQ then a cluster is specified the cluster becomes the mediation execution point.
	 */
	public String getCluster() {
		return this.cluster;
	}

	/**
	 * If mediating a destination to a cluster, specify the cluster name, but not the node or server name.   If the destination being mediated is localized in WebSphere MQ then a cluster is specified the cluster becomes the mediation execution point.
	 */
	public void setCluster(String value) {
		this.cluster = value;
	}

	/**
	 * To assign the destination from which a mediation should read message to process from a queue localized on a WebSphere MQ server, supply a WebSphere MQ server name.
	 */
	public String getWmqServer() {
		return this.wmqServer;
	}

	/**
	 * To assign the destination from which a mediation should read message to process from a queue localized on a WebSphere MQ server, supply a WebSphere MQ server name.
	 */
	public void setWmqServer(String value) {
		this.wmqServer = value;
	}

	/**
	 * The quality of service used for inbound messages which WebSphere MQ regards as being non-persistent.  Allowable values are { BEST_EFFORT | EXPRESS | RELIABLE }.
	 */
	public String getNonPersistentReliability() {
		return this.nonPersistentReliability;
	}

	/**
	 * The quality of service used for inbound messages which WebSphere MQ regards as being non-persistent.  Allowable values are { BEST_EFFORT | EXPRESS | RELIABLE }.
	 */
	public void setNonPersistentReliability(String value) {
		this.nonPersistentReliability = value;
	}

	/**
	 * The quality of service used for inbound messages which WebSphere MQ regards as being persistent.  Allowable values are { RELIABLE | ASSURED }.
	 */
	public String getPersistentReliability() {
		return this.persistentReliability;
	}

	/**
	 * The quality of service used for inbound messages which WebSphere MQ regards as being persistent.  Allowable values are { RELIABLE | ASSURED }.
	 */
	public void setPersistentReliability(String value) {
		this.persistentReliability = value;
	}

	/**
	 * Determines if messages sent to the WebSphere MQ destination have an RFH2 header or not.  This can only be specified with the WebSphere MQ server name.
	 */
	public Boolean getUseRFH2() {
		return this.useRFH2;
	}

	/**
	 * Determines if messages sent to the WebSphere MQ destination have an RFH2 header or not.  This can only be specified with the WebSphere MQ server name.
	 */
	public void setUseRFH2(Boolean value) {
		this.useRFH2 = value;
	}

	/**
	 * The name of the WebSphere MQ queue for messages.  This must be specified when the WebSphere MQ server name parameter is specified.
	 */
	public String getWmqQueueName() {
		return this.wmqQueueName;
	}

	/**
	 * The name of the WebSphere MQ queue for messages.  This must be specified when the WebSphere MQ server name parameter is specified.
	 */
	public void setWmqQueueName(String value) {
		this.wmqQueueName = value;
	}

	/**
	 * If the destination is assigned to WebSphere MQ then an external application can mediate the WebSphere MQ queue.
	 */
	public Boolean getExternallyMediated() {
		return this.externallyMediated;
	}

	/**
	 * If the destination is assigned to WebSphere MQ then an external application can mediate the WebSphere MQ queue.
	 */
	public void setExternallyMediated(Boolean value) {
		this.externallyMediated = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("bus", this.bus);
		ret.put("destinationName", this.destinationName);
		if (this.mediationName != null) {
			ret.put("mediationName", this.mediationName);
		}
		if (this.node != null) {
			ret.put("node", this.node);
		}
		if (this.server != null) {
			ret.put("server", this.server);
		}
		if (this.cluster != null) {
			ret.put("cluster", this.cluster);
		}
		if (this.wmqServer != null) {
			ret.put("wmqServer", this.wmqServer);
		}
		if (this.nonPersistentReliability != null) {
			ret.put("nonPersistentReliability", this.nonPersistentReliability);
		}
		if (this.persistentReliability != null) {
			ret.put("persistentReliability", this.persistentReliability);
		}
		if (this.useRFH2 != null) {
			ret.put("useRFH2", this.useRFH2);
		}
		if (this.wmqQueueName != null) {
			ret.put("wmqQueueName", this.wmqQueueName);
		}
		if (this.externallyMediated != null) {
			ret.put("externallyMediated", this.externallyMediated);
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
