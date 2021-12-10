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
 * Modify a named WebSphere MQ server's attributes.
 *   'name': The name of the WebSphere MQ server. This is for administrative purposes only and can be decided by the administrator. The name is only meaningful inside WebSphere Application server administration, and must be unique at cell level.
 *   'serverName': The name of the WebSphere MQ queue manager or WebSphere MQ queue sharing group represented by this WebSphere MQ server.
 *   'description': A description of the WebSphere MQ server.
 *   'bindingsMode': This indicates whether there exists a preference to use bindings mode when connecting to the WebSphere MQ queue manager.
 *   'host': This is the name of the host to which a connection will be established in order to communicate with a WebSphere MQ queue manager or a WebSphere MQ queue sharing group.
 *   'port': The port monitored by a WebSphere MQ queue manager listener or WebSphere MQ queue sharing group listener, which is listening for connections.
 *   'channel': This is the name of the server connection channel that will be used to establish a connection to the queue manager or queue sharing group.
 *   'securityAuthAlias': The authentication alias that will be supplied when connecting to the WebSphere MQ server.
 *   'transportChain': The name of the transport chain to use when communicating with MQ.
 *   'trustUserIds': Determines if user identifiers received in messages from WebSphere MQ are propagated into the WebSphere default messaging message or not.
 *   'allowDiscovery': Whether automated discovery of WebSphere MQ resources should be enabled.  This parameter has two possible values: TRUE, FALSE.  The default is TRUE.
 *   'discoveryAuthAlias': The authentication alias to use when performing resource discovery.
 *   'replyToQueue': The WebSphere MQ reply-to queue used when performing resource discovery.
 * The required parameters are found in the constructor.
 */
public class ModifySIBWMQServer extends Command {

	private String name;
	private String serverName;
	private String description;
	private Boolean bindingsMode;
	private String host;
	private Integer port;
	private String channel;
	private String securityAuthAlias;
	private String transportChain;
	private Boolean trustUserIds;
	private Boolean allowDiscovery;
	private String discoveryAuthAlias;
	private String replyToQueue;

	public ModifySIBWMQServer(String name) {
		super("modifySIBWMQServer");
		this.name = name;
	}

	/**
	 * The name of the WebSphere MQ server. This is for administrative purposes only and can be decided by the administrator. The name is only meaningful inside WebSphere Application server administration, and must be unique at cell level.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The name of the WebSphere MQ server. This is for administrative purposes only and can be decided by the administrator. The name is only meaningful inside WebSphere Application server administration, and must be unique at cell level.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * The name of the WebSphere MQ queue manager or WebSphere MQ queue sharing group represented by this WebSphere MQ server.
	 */
	public String getServerName() {
		return this.serverName;
	}

	/**
	 * The name of the WebSphere MQ queue manager or WebSphere MQ queue sharing group represented by this WebSphere MQ server.
	 */
	public void setServerName(String value) {
		this.serverName = value;
	}

	/**
	 * A description of the WebSphere MQ server.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * A description of the WebSphere MQ server.
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * This indicates whether there exists a preference to use bindings mode when connecting to the WebSphere MQ queue manager.
	 */
	public Boolean getBindingsMode() {
		return this.bindingsMode;
	}

	/**
	 * This indicates whether there exists a preference to use bindings mode when connecting to the WebSphere MQ queue manager.
	 */
	public void setBindingsMode(Boolean value) {
		this.bindingsMode = value;
	}

	/**
	 * This is the name of the host to which a connection will be established in order to communicate with a WebSphere MQ queue manager or a WebSphere MQ queue sharing group.
	 */
	public String getHost() {
		return this.host;
	}

	/**
	 * This is the name of the host to which a connection will be established in order to communicate with a WebSphere MQ queue manager or a WebSphere MQ queue sharing group.
	 */
	public void setHost(String value) {
		this.host = value;
	}

	/**
	 * The port monitored by a WebSphere MQ queue manager listener or WebSphere MQ queue sharing group listener, which is listening for connections.
	 */
	public Integer getPort() {
		return this.port;
	}

	/**
	 * The port monitored by a WebSphere MQ queue manager listener or WebSphere MQ queue sharing group listener, which is listening for connections.
	 */
	public void setPort(Integer value) {
		this.port = value;
	}

	/**
	 * This is the name of the server connection channel that will be used to establish a connection to the queue manager or queue sharing group.
	 */
	public String getChannel() {
		return this.channel;
	}

	/**
	 * This is the name of the server connection channel that will be used to establish a connection to the queue manager or queue sharing group.
	 */
	public void setChannel(String value) {
		this.channel = value;
	}

	/**
	 * The authentication alias that will be supplied when connecting to the WebSphere MQ server.
	 */
	public String getSecurityAuthAlias() {
		return this.securityAuthAlias;
	}

	/**
	 * The authentication alias that will be supplied when connecting to the WebSphere MQ server.
	 */
	public void setSecurityAuthAlias(String value) {
		this.securityAuthAlias = value;
	}

	/**
	 * The name of the transport chain to use when communicating with MQ.
	 */
	public String getTransportChain() {
		return this.transportChain;
	}

	/**
	 * The name of the transport chain to use when communicating with MQ.
	 */
	public void setTransportChain(String value) {
		this.transportChain = value;
	}

	/**
	 * Determines if user identifiers received in messages from WebSphere MQ are propagated into the WebSphere default messaging message or not.
	 */
	public Boolean getTrustUserIds() {
		return this.trustUserIds;
	}

	/**
	 * Determines if user identifiers received in messages from WebSphere MQ are propagated into the WebSphere default messaging message or not.
	 */
	public void setTrustUserIds(Boolean value) {
		this.trustUserIds = value;
	}

	/**
	 * Whether automated discovery of WebSphere MQ resources should be enabled.  This parameter has two possible values: TRUE, FALSE.  The default is TRUE.
	 */
	public Boolean getAllowDiscovery() {
		return this.allowDiscovery;
	}

	/**
	 * Whether automated discovery of WebSphere MQ resources should be enabled.  This parameter has two possible values: TRUE, FALSE.  The default is TRUE.
	 */
	public void setAllowDiscovery(Boolean value) {
		this.allowDiscovery = value;
	}

	/**
	 * The authentication alias to use when performing resource discovery.
	 */
	public String getDiscoveryAuthAlias() {
		return this.discoveryAuthAlias;
	}

	/**
	 * The authentication alias to use when performing resource discovery.
	 */
	public void setDiscoveryAuthAlias(String value) {
		this.discoveryAuthAlias = value;
	}

	/**
	 * The WebSphere MQ reply-to queue used when performing resource discovery.
	 */
	public String getReplyToQueue() {
		return this.replyToQueue;
	}

	/**
	 * The WebSphere MQ reply-to queue used when performing resource discovery.
	 */
	public void setReplyToQueue(String value) {
		this.replyToQueue = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("name", this.name);
		if (this.serverName != null) {
			ret.put("serverName", this.serverName);
		}
		if (this.description != null) {
			ret.put("description", this.description);
		}
		if (this.bindingsMode != null) {
			ret.put("bindingsMode", this.bindingsMode);
		}
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
		if (this.allowDiscovery != null) {
			ret.put("allowDiscovery", this.allowDiscovery);
		}
		if (this.discoveryAuthAlias != null) {
			ret.put("discoveryAuthAlias", this.discoveryAuthAlias);
		}
		if (this.replyToQueue != null) {
			ret.put("replyToQueue", this.replyToQueue);
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
