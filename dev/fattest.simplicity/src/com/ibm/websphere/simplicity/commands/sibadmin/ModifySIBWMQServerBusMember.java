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
 * Modify a named WebSphere MQ server bus member.
 *   'name': The name of the WebSphere MQ server bus member.
 *   'bus': The name of the bus the WebSphere MQ server is a member of.
 *   'host': New value for the overridden WebSphere MQ server "host" attribute.
 *   'port': New value for the overridden WebSphere MQ server "port" attribute.
 *   'channel': New value for the overridden WebSphere MQ server "channel" attribute.
 *   'securityAuthAlias': New value for the overridden WebSphere MQ server "securityAuthAlias" attribute.
 *   'transportChain': New value for the overridden WebSphere MQ server "transportChain" attribute.
 *   'trustUserIds': New value for the overridden WebSphere MQ server "trustUserIds" attribute.
 *   'virtualQueueManagerName': The virtual queue manager name of the SIBus that the WebSphere MQ queue manager sees.
 * The required parameters are found in the constructor.
 */
public class ModifySIBWMQServerBusMember extends Command {

	private String name;
	private String bus;
	private String host;
	private Integer port;
	private String channel;
	private String securityAuthAlias;
	private String transportChain;
	private Boolean trustUserIds;
	private String virtualQueueManagerName;

	public ModifySIBWMQServerBusMember(String name, String bus) {
		super("modifySIBWMQServerBusMember");
		this.name = name;
		this.bus = bus;
	}

	/**
	 * The name of the WebSphere MQ server bus member.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The name of the WebSphere MQ server bus member.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * The name of the bus the WebSphere MQ server is a member of.
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * The name of the bus the WebSphere MQ server is a member of.
	 */
	public void setBus(String value) {
		this.bus = value;
	}

	/**
	 * New value for the overridden WebSphere MQ server "host" attribute.
	 */
	public String getHost() {
		return this.host;
	}

	/**
	 * New value for the overridden WebSphere MQ server "host" attribute.
	 */
	public void setHost(String value) {
		this.host = value;
	}

	/**
	 * New value for the overridden WebSphere MQ server "port" attribute.
	 */
	public Integer getPort() {
		return this.port;
	}

	/**
	 * New value for the overridden WebSphere MQ server "port" attribute.
	 */
	public void setPort(Integer value) {
		this.port = value;
	}

	/**
	 * New value for the overridden WebSphere MQ server "channel" attribute.
	 */
	public String getChannel() {
		return this.channel;
	}

	/**
	 * New value for the overridden WebSphere MQ server "channel" attribute.
	 */
	public void setChannel(String value) {
		this.channel = value;
	}

	/**
	 * New value for the overridden WebSphere MQ server "securityAuthAlias" attribute.
	 */
	public String getSecurityAuthAlias() {
		return this.securityAuthAlias;
	}

	/**
	 * New value for the overridden WebSphere MQ server "securityAuthAlias" attribute.
	 */
	public void setSecurityAuthAlias(String value) {
		this.securityAuthAlias = value;
	}

	/**
	 * New value for the overridden WebSphere MQ server "transportChain" attribute.
	 */
	public String getTransportChain() {
		return this.transportChain;
	}

	/**
	 * New value for the overridden WebSphere MQ server "transportChain" attribute.
	 */
	public void setTransportChain(String value) {
		this.transportChain = value;
	}

	/**
	 * New value for the overridden WebSphere MQ server "trustUserIds" attribute.
	 */
	public Boolean getTrustUserIds() {
		return this.trustUserIds;
	}

	/**
	 * New value for the overridden WebSphere MQ server "trustUserIds" attribute.
	 */
	public void setTrustUserIds(Boolean value) {
		this.trustUserIds = value;
	}

	/**
	 * The virtual queue manager name of the SIBus that the WebSphere MQ queue manager sees.
	 */
	public String getVirtualQueueManagerName() {
		return this.virtualQueueManagerName;
	}

	/**
	 * The virtual queue manager name of the SIBus that the WebSphere MQ queue manager sees.
	 */
	public void setVirtualQueueManagerName(String value) {
		this.virtualQueueManagerName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("name", this.name);
		ret.put("bus", this.bus);
		if (this.host != null) {
			ret.put("host", this.host);
		}
		if (this.port != null) {
			ret.put("port", this.port);
		}
		if (this.channel != null) {
			ret.put("channel", this.channel);
		}
		if (this.securityAuthAlias != null) {
			ret.put("securityAuthAlias", this.securityAuthAlias);
		}
		if (this.transportChain != null) {
			ret.put("transportChain", this.transportChain);
		}
		if (this.trustUserIds != null) {
			ret.put("trustUserIds", this.trustUserIds);
		}
		if (this.virtualQueueManagerName != null) {
			ret.put("virtualQueueManagerName", this.virtualQueueManagerName);
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
