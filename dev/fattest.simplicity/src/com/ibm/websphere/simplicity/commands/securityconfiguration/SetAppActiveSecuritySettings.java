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
 * Sets the application level security active settings.
 *   'securityDomainName': Name used to uniquely identify the security domain.
 *   'customProperties': Add, modify, or remove custom properties on the security object.
 *   'activeUserRegistry': Specifies the server active user registry.
 *   'issuePermissionWarning': Specify true for a warning to be issued during application installation if the application requires Java2 security permissions and false for no warning.
 *   'enforceJava2Security': Specify true to enable Java 2 security permissions checking and false to disable Java 2 security.
 *   'appSecurityEnabled': Specify true to enable application-level security and false to disable application-level security.
 *   'enforceFineGrainedJCASecurity': Specify true to restrict application access to sensitive Java Connector Architecture (JCA) mapping authentication data.
 *   'useDomainQualifiedUserNames': Specify true to use domain qualified user names and false to use the short name.
 *   'cacheTimeout': The period of time in seconds after which the authentication data will not be valid.
 * The required parameters are found in the constructor.
 */
public class SetAppActiveSecuritySettings extends Command {

	private String securityDomainName;
	private String customProperties;
	private String activeUserRegistry;
	private Boolean issuePermissionWarning;
	private Boolean enforceJava2Security;
	private Boolean appSecurityEnabled;
	private Boolean enforceFineGrainedJCASecurity;
	private Boolean useDomainQualifiedUserNames;
	private Integer cacheTimeout;

	public SetAppActiveSecuritySettings(String securityDomainName) {
		super("setAppActiveSecuritySettings");
		this.securityDomainName = securityDomainName;
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
	 * Specifies the server active user registry.
	 */
	public String getActiveUserRegistry() {
		return this.activeUserRegistry;
	}

	/**
	 * Specifies the server active user registry.
	 */
	public void setActiveUserRegistry(String value) {
		this.activeUserRegistry = value;
	}

	/**
	 * Specify true for a warning to be issued during application installation if the application requires Java2 security permissions and false for no warning.
	 */
	public Boolean getIssuePermissionWarning() {
		return this.issuePermissionWarning;
	}

	/**
	 * Specify true for a warning to be issued during application installation if the application requires Java2 security permissions and false for no warning.
	 */
	public void setIssuePermissionWarning(Boolean value) {
		this.issuePermissionWarning = value;
	}

	/**
	 * Specify true to enable Java 2 security permissions checking and false to disable Java 2 security.
	 */
	public Boolean getEnforceJava2Security() {
		return this.enforceJava2Security;
	}

	/**
	 * Specify true to enable Java 2 security permissions checking and false to disable Java 2 security.
	 */
	public void setEnforceJava2Security(Boolean value) {
		this.enforceJava2Security = value;
	}

	/**
	 * Specify true to enable application-level security and false to disable application-level security.
	 */
	public Boolean getAppSecurityEnabled() {
		return this.appSecurityEnabled;
	}

	/**
	 * Specify true to enable application-level security and false to disable application-level security.
	 */
	public void setAppSecurityEnabled(Boolean value) {
		this.appSecurityEnabled = value;
	}

	/**
	 * Specify true to restrict application access to sensitive Java Connector Architecture (JCA) mapping authentication data.
	 */
	public Boolean getEnforceFineGrainedJCASecurity() {
		return this.enforceFineGrainedJCASecurity;
	}

	/**
	 * Specify true to restrict application access to sensitive Java Connector Architecture (JCA) mapping authentication data.
	 */
	public void setEnforceFineGrainedJCASecurity(Boolean value) {
		this.enforceFineGrainedJCASecurity = value;
	}

	/**
	 * Specify true to use domain qualified user names and false to use the short name.
	 */
	public Boolean getUseDomainQualifiedUserNames() {
		return this.useDomainQualifiedUserNames;
	}

	/**
	 * Specify true to use domain qualified user names and false to use the short name.
	 */
	public void setUseDomainQualifiedUserNames(Boolean value) {
		this.useDomainQualifiedUserNames = value;
	}

	/**
	 * The period of time in seconds after which the authentication data will not be valid.
	 */
	public Integer getCacheTimeout() {
		return this.cacheTimeout;
	}

	/**
	 * The period of time in seconds after which the authentication data will not be valid.
	 */
	public void setCacheTimeout(Integer value) {
		this.cacheTimeout = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("securityDomainName", this.securityDomainName);
		if (this.customProperties != null) {
			ret.put("customProperties", this.customProperties);
		}
		if (this.activeUserRegistry != null) {
			ret.put("activeUserRegistry", this.activeUserRegistry);
		}
		if (this.issuePermissionWarning != null) {
			ret.put("issuePermissionWarning", this.issuePermissionWarning);
		}
		if (this.enforceJava2Security != null) {
			ret.put("enforceJava2Security", this.enforceJava2Security);
		}
		if (this.appSecurityEnabled != null) {
			ret.put("appSecurityEnabled", this.appSecurityEnabled);
		}
		if (this.enforceFineGrainedJCASecurity != null) {
			ret.put("enforceFineGrainedJCASecurity", this.enforceFineGrainedJCASecurity);
		}
		if (this.useDomainQualifiedUserNames != null) {
			ret.put("useDomainQualifiedUserNames", this.useDomainQualifiedUserNames);
		}
		if (this.cacheTimeout != null) {
			ret.put("cacheTimeout", this.cacheTimeout);
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
