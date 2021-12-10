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
 * Modify an existing SIB link.
 *   'bus': The name of the bus.
 *   'messagingEngine': The name of the messaging engine.
 *   'name': The name of the SIB link.
 *   'bootstrapEndpoints': The name of the bootstrap endpoints.
 *   'remoteMessagingEngineName': The name of the remote messaging engine.
 *   'description': The description of the SIB link.
 *   'protocolName': The name of the protocol.
 *   'authAlias': The name of the authentication alias.
 *   'initialState': The initial state of the SIB link {Started | Stopped} (default is "Started").
 *   'exceptionDestination': The exception destination for the SIB link {destination name | $DEFAULT_EXCEPTION_DESTINATION} (default is "$DEFAULT_EXCEPTION_DESTINATION").
 *   'preferLocal': Prefer queue points local to this link's messaging engine
 * The required parameters are found in the constructor.
 */
public class ModifySIBLink extends Command {

	private String bus;
	private String messagingEngine;
	private String name;
	private String bootstrapEndpoints;
	private String remoteMessagingEngineName;
	private String description;
	private String protocolName;
	private String authAlias;
	private String initialState;
	private String exceptionDestination;
	private Boolean preferLocal;

	public ModifySIBLink(String bus, String messagingEngine, String name) {
		super("modifySIBLink");
		this.bus = bus;
		this.messagingEngine = messagingEngine;
		this.name = name;
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
	 * The name of the SIB link.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The name of the SIB link.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * The name of the bootstrap endpoints.
	 */
	public String getBootstrapEndpoints() {
		return this.bootstrapEndpoints;
	}

	/**
	 * The name of the bootstrap endpoints.
	 */
	public void setBootstrapEndpoints(String value) {
		this.bootstrapEndpoints = value;
	}

	/**
	 * The name of the remote messaging engine.
	 */
	public String getRemoteMessagingEngineName() {
		return this.remoteMessagingEngineName;
	}

	/**
	 * The name of the remote messaging engine.
	 */
	public void setRemoteMessagingEngineName(String value) {
		this.remoteMessagingEngineName = value;
	}

	/**
	 * The description of the SIB link.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * The description of the SIB link.
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * The name of the protocol.
	 */
	public String getProtocolName() {
		return this.protocolName;
	}

	/**
	 * The name of the protocol.
	 */
	public void setProtocolName(String value) {
		this.protocolName = value;
	}

	/**
	 * The name of the authentication alias.
	 */
	public String getAuthAlias() {
		return this.authAlias;
	}

	/**
	 * The name of the authentication alias.
	 */
	public void setAuthAlias(String value) {
		this.authAlias = value;
	}

	/**
	 * The initial state of the SIB link {Started | Stopped} (default is "Started").
	 */
	public String getInitialState() {
		return this.initialState;
	}

	/**
	 * The initial state of the SIB link {Started | Stopped} (default is "Started").
	 */
	public void setInitialState(String value) {
		this.initialState = value;
	}

	/**
	 * The exception destination for the SIB link {destination name | $DEFAULT_EXCEPTION_DESTINATION} (default is "$DEFAULT_EXCEPTION_DESTINATION").
	 */
	public String getExceptionDestination() {
		return this.exceptionDestination;
	}

	/**
	 * The exception destination for the SIB link {destination name | $DEFAULT_EXCEPTION_DESTINATION} (default is "$DEFAULT_EXCEPTION_DESTINATION").
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
		if (this.bootstrapEndpoints != null) {
			ret.put("bootstrapEndpoints", this.bootstrapEndpoints);
		}
		if (this.remoteMessagingEngineName != null) {
			ret.put("remoteMessagingEngineName", this.remoteMessagingEngineName);
		}
		if (this.description != null) {
			ret.put("description", this.description);
		}
		if (this.protocolName != null) {
			ret.put("protocolName", this.protocolName);
		}
		if (this.authAlias != null) {
			ret.put("authAlias", this.authAlias);
		}
		if (this.initialState != null) {
			ret.put("initialState", this.initialState);
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
