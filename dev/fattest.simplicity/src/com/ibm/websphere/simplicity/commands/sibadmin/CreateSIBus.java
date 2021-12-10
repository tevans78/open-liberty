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
 * Create a bus.
 *   'bus': Name of bus to create, which must be unique in the cell.
 *   'description': Descriptive information about the bus.
 *   'secure': Enable or disable bus security.  Deprecated.  Use busSecurity parameter instead.
 *   'interEngineAuthAlias': Name of the authentication alias used to authorize communication between messaging engines on the bus.
 *   'mediationsAuthAlias': Name of the authentication alias used to authorize mediations to access the bus.
 *   'securityGroupCacheTimeout': The length of time, in minutes, that a security group will be cached for.
 *   'protocol': The protocol used to send and receive messages between messaging engines, and between API clients and messaging engines.
 *   'discardOnDelete': Indicate whether or not any messages left in a queue's data store should be discarded when the queue is deleted.
 *   'highMessageThreshold': The maximum number of messages that any queue on the bus can hold.
 *   'configurationReloadEnabled': Indicate whether configuration files should be dynamically reloaded for this bus.
 *   'busSecurity': Enables or disables bus security.
 *   'scriptCompatibility': Set script compatibility to 6 to maintain version 6 command behavior.  Default value is 6.1.
 *   'bootstrapPolicy': The bootstrap policy value can be set to one of the following SIBSERVICE_ENABLED, MEMBERS_AND_NOMINATED or MEMBERS_ONLY.
 *   'useServerIdForMediations': Configure the bus to use the server identity for calling mediations rather than the mediationsAuthAlias.
 *   'auditAllowed': Used to allow or prevent the bus from auditing when the application server auditing support is enabled.
 * The required parameters are found in the constructor.
 */
public class CreateSIBus extends Command {

	private String bus;
	private String description;
	private Boolean secure;
	private String interEngineAuthAlias;
	private String mediationsAuthAlias;
	private Long securityGroupCacheTimeout;
	private String protocol;
	private Boolean discardOnDelete = false;
	private Long highMessageThreshold;
	private Boolean configurationReloadEnabled = true;
	private Boolean busSecurity;
	private String scriptCompatibility;
	private String bootstrapPolicy;
	private Boolean useServerIdForMediations;
	private Boolean auditAllowed;

	public CreateSIBus(String bus) {
		super("createSIBus");
		this.bus = bus;
	}

	/**
	 * Name of bus to create, which must be unique in the cell.
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * Name of bus to create, which must be unique in the cell.
	 */
	public void setBus(String value) {
		this.bus = value;
	}

	/**
	 * Descriptive information about the bus.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Descriptive information about the bus.
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Enable or disable bus security.  Deprecated.  Use busSecurity parameter instead.
	 */
	public Boolean getSecure() {
		return this.secure;
	}

	/**
	 * Enable or disable bus security.  Deprecated.  Use busSecurity parameter instead.
	 */
	public void setSecure(Boolean value) {
		this.secure = value;
	}

	/**
	 * Name of the authentication alias used to authorize communication between messaging engines on the bus.
	 */
	public String getInterEngineAuthAlias() {
		return this.interEngineAuthAlias;
	}

	/**
	 * Name of the authentication alias used to authorize communication between messaging engines on the bus.
	 */
	public void setInterEngineAuthAlias(String value) {
		this.interEngineAuthAlias = value;
	}

	/**
	 * Name of the authentication alias used to authorize mediations to access the bus.
	 */
	public String getMediationsAuthAlias() {
		return this.mediationsAuthAlias;
	}

	/**
	 * Name of the authentication alias used to authorize mediations to access the bus.
	 */
	public void setMediationsAuthAlias(String value) {
		this.mediationsAuthAlias = value;
	}

	/**
	 * The length of time, in minutes, that a security group will be cached for.
	 */
	public Long getSecurityGroupCacheTimeout() {
		return this.securityGroupCacheTimeout;
	}

	/**
	 * The length of time, in minutes, that a security group will be cached for.
	 */
	public void setSecurityGroupCacheTimeout(Long value) {
		this.securityGroupCacheTimeout = value;
	}

	/**
	 * The protocol used to send and receive messages between messaging engines, and between API clients and messaging engines.
	 */
	public String getProtocol() {
		return this.protocol;
	}

	/**
	 * The protocol used to send and receive messages between messaging engines, and between API clients and messaging engines.
	 */
	public void setProtocol(String value) {
		this.protocol = value;
	}

	/**
	 * Indicate whether or not any messages left in a queue's data store should be discarded when the queue is deleted.
	 */
	public Boolean getDiscardOnDelete() {
		return this.discardOnDelete;
	}

	/**
	 * Indicate whether or not any messages left in a queue's data store should be discarded when the queue is deleted.
	 */
	public void setDiscardOnDelete(Boolean value) {
		this.discardOnDelete = value;
	}

	/**
	 * The maximum number of messages that any queue on the bus can hold.
	 */
	public Long getHighMessageThreshold() {
		return this.highMessageThreshold;
	}

	/**
	 * The maximum number of messages that any queue on the bus can hold.
	 */
	public void setHighMessageThreshold(Long value) {
		this.highMessageThreshold = value;
	}

	/**
	 * Indicate whether configuration files should be dynamically reloaded for this bus.
	 */
	public Boolean getConfigurationReloadEnabled() {
		return this.configurationReloadEnabled;
	}

	/**
	 * Indicate whether configuration files should be dynamically reloaded for this bus.
	 */
	public void setConfigurationReloadEnabled(Boolean value) {
		this.configurationReloadEnabled = value;
	}

	/**
	 * Enables or disables bus security.
	 */
	public Boolean getBusSecurity() {
		return this.busSecurity;
	}

	/**
	 * Enables or disables bus security.
	 */
	public void setBusSecurity(Boolean value) {
		this.busSecurity = value;
	}

	/**
	 * Set script compatibility to 6 to maintain version 6 command behavior.  Default value is 6.1.
	 */
	public String getScriptCompatibility() {
		return this.scriptCompatibility;
	}

	/**
	 * Set script compatibility to 6 to maintain version 6 command behavior.  Default value is 6.1.
	 */
	public void setScriptCompatibility(String value) {
		this.scriptCompatibility = value;
	}

	/**
	 * The bootstrap policy value can be set to one of the following SIBSERVICE_ENABLED, MEMBERS_AND_NOMINATED or MEMBERS_ONLY.
	 */
	public String getBootstrapPolicy() {
		return this.bootstrapPolicy;
	}

	/**
	 * The bootstrap policy value can be set to one of the following SIBSERVICE_ENABLED, MEMBERS_AND_NOMINATED or MEMBERS_ONLY.
	 */
	public void setBootstrapPolicy(String value) {
		this.bootstrapPolicy = value;
	}

	/**
	 * Configure the bus to use the server identity for calling mediations rather than the mediationsAuthAlias.
	 */
	public Boolean getUseServerIdForMediations() {
		return this.useServerIdForMediations;
	}

	/**
	 * Configure the bus to use the server identity for calling mediations rather than the mediationsAuthAlias.
	 */
	public void setUseServerIdForMediations(Boolean value) {
		this.useServerIdForMediations = value;
	}

	/**
	 * Used to allow or prevent the bus from auditing when the application server auditing support is enabled.
	 */
	public Boolean getAuditAllowed() {
		return this.auditAllowed;
	}

	/**
	 * Used to allow or prevent the bus from auditing when the application server auditing support is enabled.
	 */
	public void setAuditAllowed(Boolean value) {
		this.auditAllowed = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("bus", this.bus);
		if (this.description != null) {
			ret.put("description", this.description);
		}
		if (this.secure != null) {
			ret.put("secure", this.secure);
		}
		if (this.interEngineAuthAlias != null) {
			ret.put("interEngineAuthAlias", this.interEngineAuthAlias);
		}
		if (this.mediationsAuthAlias != null) {
			ret.put("mediationsAuthAlias", this.mediationsAuthAlias);
		}
		if (this.securityGroupCacheTimeout != null) {
			ret.put("securityGroupCacheTimeout", this.securityGroupCacheTimeout);
		}
		if (this.protocol != null) {
			ret.put("protocol", this.protocol);
		}
		if (this.discardOnDelete != null) {
			ret.put("discardOnDelete", this.discardOnDelete);
		}
		if (this.highMessageThreshold != null) {
			ret.put("highMessageThreshold", this.highMessageThreshold);
		}
		if (this.configurationReloadEnabled != null) {
			ret.put("configurationReloadEnabled", this.configurationReloadEnabled);
		}
		if (this.busSecurity != null) {
			ret.put("busSecurity", this.busSecurity);
		}
		if (this.scriptCompatibility != null) {
			ret.put("scriptCompatibility", this.scriptCompatibility);
		}
		if (this.bootstrapPolicy != null) {
			ret.put("bootstrapPolicy", this.bootstrapPolicy);
		}
		if (this.useServerIdForMediations != null) {
			ret.put("useServerIdForMediations", this.useServerIdForMediations);
		}
		if (this.auditAllowed != null) {
			ret.put("auditAllowed", this.auditAllowed);
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
