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

package com.ibm.websphere.simplicity.commands.securityconfiguration;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Configures a local OS user registry in the administrative security configuration.
 *   'autoGenerateServerId': Automatically generate the server identity used for internal process communication.
 *   'verifyRegistry': Check that the user registry is configured correctly to perform user registry lookups.
 *   'serverId': Server identity used for internal process communications
 *   'customProperties': Add, modify, or remove custom properties on the security object.
 *   'ignoreCase': Specifies that a case-insensitive authorization check be performed: true/false.
 *   'primaryAdminId': Specifies the name of the user with administrative privileges that is defined in the registry.
 *   'serverIdPassword': Specifies the password that is used for the server identity.
 * The required parameters are found in the constructor.
 */
public class ConfigureAdminLocalOSUserRegistry extends Command {

	private Boolean autoGenerateServerId;
	private Boolean verifyRegistry = true;
	private String serverId;
	private String customProperties;
	private Boolean ignoreCase;
	private String primaryAdminId;
	private String serverIdPassword;

	public ConfigureAdminLocalOSUserRegistry() {
		super("configureAdminLocalOSUserRegistry");
	}

	/**
	 * Automatically generate the server identity used for internal process communication.
	 */
	public Boolean getAutoGenerateServerId() {
		return this.autoGenerateServerId;
	}

	/**
	 * Automatically generate the server identity used for internal process communication.
	 */
	public void setAutoGenerateServerId(Boolean value) {
		this.autoGenerateServerId = value;
	}

	/**
	 * Check that the user registry is configured correctly to perform user registry lookups.
	 */
	public Boolean getVerifyRegistry() {
		return this.verifyRegistry;
	}

	/**
	 * Check that the user registry is configured correctly to perform user registry lookups.
	 */
	public void setVerifyRegistry(Boolean value) {
		this.verifyRegistry = value;
	}

	/**
	 * Server identity used for internal process communications
	 */
	public String getServerId() {
		return this.serverId;
	}

	/**
	 * Server identity used for internal process communications
	 */
	public void setServerId(String value) {
		this.serverId = value;
	}

	/**
	 * Add, modify, or remove custom properties on the security object.
	 */
	public String getCustomProperties() {
		return this.customProperties;
	}

	/**
	 * Add, modify, or remove custom properties on the security object.
	 */
	public void setCustomProperties(String value) {
		this.customProperties = value;
	}

	/**
	 * Specifies that a case-insensitive authorization check be performed: true/false.
	 */
	public Boolean getIgnoreCase() {
		return this.ignoreCase;
	}

	/**
	 * Specifies that a case-insensitive authorization check be performed: true/false.
	 */
	public void setIgnoreCase(Boolean value) {
		this.ignoreCase = value;
	}

	/**
	 * Specifies the name of the user with administrative privileges that is defined in the registry.
	 */
	public String getPrimaryAdminId() {
		return this.primaryAdminId;
	}

	/**
	 * Specifies the name of the user with administrative privileges that is defined in the registry.
	 */
	public void setPrimaryAdminId(String value) {
		this.primaryAdminId = value;
	}

	/**
	 * Specifies the password that is used for the server identity.
	 */
	public String getServerIdPassword() {
		return this.serverIdPassword;
	}

	/**
	 * Specifies the password that is used for the server identity.
	 */
	public void setServerIdPassword(String value) {
		this.serverIdPassword = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.autoGenerateServerId != null) {
			ret.put("autoGenerateServerId", this.autoGenerateServerId);
		}
		if (this.verifyRegistry != null) {
			ret.put("verifyRegistry", this.verifyRegistry);
		}
		if (this.serverId != null) {
			ret.put("serverId", this.serverId);
		}
		if (this.customProperties != null) {
			ret.put("customProperties", this.customProperties);
		}
		if (this.ignoreCase != null) {
			ret.put("ignoreCase", this.ignoreCase);
		}
		if (this.primaryAdminId != null) {
			ret.put("primaryAdminId", this.primaryAdminId);
		}
		if (this.serverIdPassword != null) {
			ret.put("serverIdPassword", this.serverIdPassword);
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
