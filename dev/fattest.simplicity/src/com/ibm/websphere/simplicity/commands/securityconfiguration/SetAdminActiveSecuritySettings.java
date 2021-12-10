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
 * Sets the security attributes on the global administrative security configuration.
 *   'customProperties': Specifies a comma separated list of attribute=value custom property pairs to be added to the security object.
 *   'activeUserRegistry': Specifies the administrative security active user registry.
 *   'activeAuthMechanism': Specify the active authentication mechanism. Valid values are LTPA, KRB5.
 *   'adminPreferredAuthMech': Specify the administrative preferred active authentication mechanism
 *   'issuePermissionWarning': Specify true for a warning to be issued during application installation if the application requires Java2 security permissions and false for no warning.
 *   'enforceJava2Security': Specify true to enable Java 2 security permissions checking and false to disable Java 2 security.
 *   'enableGlobalSecurity': Specify true to enable administrative security and false to disable administrative security.
 *   'appSecurityEnabled': Specify true to enable application-level security and false to disable application-level security.
 *   'dynUpdateSSLConfig': Specify true to read SSL configuration changes dynamically and false to have SSL configuration changes read on server startup.
 *   'enforceFineGrainedJCASecurity': Specify true to restrict application access to sensitive Java Connector Architecture (JCA) mapping authentication data.
 *   'useDomainQualifiedUserNames': Specify true to use domain qualified user names and false to use the short name.
 *   'cacheTimeout': The period of time in seconds after which the authentication data will not be valid.
 * The required parameters are found in the constructor.
 */
public class SetAdminActiveSecuritySettings extends Command {

	private String customProperties;
	private String activeUserRegistry;
	private String activeAuthMechanism;
	private String adminPreferredAuthMech;
	private Boolean issuePermissionWarning;
	private Boolean enforceJava2Security;
	private Boolean enableGlobalSecurity;
	private Boolean appSecurityEnabled;
	private Boolean dynUpdateSSLConfig;
	private Boolean enforceFineGrainedJCASecurity;
	private Boolean useDomainQualifiedUserNames;
	private Integer cacheTimeout;

	public SetAdminActiveSecuritySettings() {
		super("setAdminActiveSecuritySettings");
	}

	/**
	 * Specifies a comma separated list of attribute=value custom property pairs to be added to the security object.
	 */
	public String getCustomProperties() {
		return this.customProperties;
	}

	/**
	 * Specifies a comma separated list of attribute=value custom property pairs to be added to the security object.
	 */
	public void setCustomProperties(String value) {
		this.customProperties = value;
	}

	/**
	 * Specifies the administrative security active user registry.
	 */
	public String getActiveUserRegistry() {
		return this.activeUserRegistry;
	}

	/**
	 * Specifies the administrative security active user registry.
	 */
	public void setActiveUserRegistry(String value) {
		this.activeUserRegistry = value;
	}

	/**
	 * Specify the active authentication mechanism. Valid values are LTPA, KRB5.
	 */
	public String getActiveAuthMechanism() {
		return this.activeAuthMechanism;
	}

	/**
	 * Specify the active authentication mechanism. Valid values are LTPA, KRB5.
	 */
	public void setActiveAuthMechanism(String value) {
		this.activeAuthMechanism = value;
	}

	/**
	 * Specify the administrative preferred active authentication mechanism
	 */
	public String getAdminPreferredAuthMech() {
		return this.adminPreferredAuthMech;
	}

	/**
	 * Specify the administrative preferred active authentication mechanism
	 */
	public void setAdminPreferredAuthMech(String value) {
		this.adminPreferredAuthMech = value;
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
	 * Specify true to enable administrative security and false to disable administrative security.
	 */
	public Boolean getEnableGlobalSecurity() {
		return this.enableGlobalSecurity;
	}

	/**
	 * Specify true to enable administrative security and false to disable administrative security.
	 */
	public void setEnableGlobalSecurity(Boolean value) {
		this.enableGlobalSecurity = value;
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
	 * Specify true to read SSL configuration changes dynamically and false to have SSL configuration changes read on server startup.
	 */
	public Boolean getDynUpdateSSLConfig() {
		return this.dynUpdateSSLConfig;
	}

	/**
	 * Specify true to read SSL configuration changes dynamically and false to have SSL configuration changes read on server startup.
	 */
	public void setDynUpdateSSLConfig(Boolean value) {
		this.dynUpdateSSLConfig = value;
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
		if (this.customProperties != null) {
			ret.put("customProperties", this.customProperties);
		}
		if (this.activeUserRegistry != null) {
			ret.put("activeUserRegistry", this.activeUserRegistry);
		}
		if (this.activeAuthMechanism != null) {
			ret.put("activeAuthMechanism", this.activeAuthMechanism);
		}
		if (this.adminPreferredAuthMech != null) {
			ret.put("adminPreferredAuthMech", this.adminPreferredAuthMech);
		}
		if (this.issuePermissionWarning != null) {
			ret.put("issuePermissionWarning", this.issuePermissionWarning);
		}
		if (this.enforceJava2Security != null) {
			ret.put("enforceJava2Security", this.enforceJava2Security);
		}
		if (this.enableGlobalSecurity != null) {
			ret.put("enableGlobalSecurity", this.enableGlobalSecurity);
		}
		if (this.appSecurityEnabled != null) {
			ret.put("appSecurityEnabled", this.appSecurityEnabled);
		}
		if (this.dynUpdateSSLConfig != null) {
			ret.put("dynUpdateSSLConfig", this.dynUpdateSSLConfig);
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
