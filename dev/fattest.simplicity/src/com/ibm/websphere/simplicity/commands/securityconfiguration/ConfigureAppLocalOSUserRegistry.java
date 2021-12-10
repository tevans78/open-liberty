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
 * Configures a local OS user registry in an application security domain.
 *   'verifyRegistry': Check that the user registry is configured correctly to perform user registry lookups.
 *   'realmName': Name of the realm.
 *   'securityDomainName': Name used to uniquely identify the security domain.
 *   'customProperties': Add, modify, or remove custom properties on the security object.
 *   'ignoreCase': Specifies that a case-insensitive authorization check be performed: true/false.
 * The required parameters are found in the constructor.
 */
public class ConfigureAppLocalOSUserRegistry extends Command {

	private Boolean verifyRegistry = true;
	private String realmName;
	private String securityDomainName;
	private String customProperties;
	private Boolean ignoreCase;

	public ConfigureAppLocalOSUserRegistry(String securityDomainName) {
		super("configureAppLocalOSUserRegistry");
		this.securityDomainName = securityDomainName;
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
	 * Name of the realm.
	 */
	public String getRealmName() {
		return this.realmName;
	}

	/**
	 * Name of the realm.
	 */
	public void setRealmName(String value) {
		this.realmName = value;
	}

	/**
	 * Name used to uniquely identify the security domain.
	 */
	public String getSecurityDomainName() {
		return this.securityDomainName;
	}

	/**
	 * Name used to uniquely identify the security domain.
	 */
	public void setSecurityDomainName(String value) {
		this.securityDomainName = value;
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

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.verifyRegistry != null) {
			ret.put("verifyRegistry", this.verifyRegistry);
		}
		if (this.realmName != null) {
			ret.put("realmName", this.realmName);
		}
		ret.put("securityDomainName", this.securityDomainName);
		if (this.customProperties != null) {
			ret.put("customProperties", this.customProperties);
		}
		if (this.ignoreCase != null) {
			ret.put("ignoreCase", this.ignoreCase);
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
