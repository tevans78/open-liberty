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

package com.ibm.websphere.simplicity.commands.wizard;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Applies current Security Wizard settings from the workspace.
 *   'secureLocalResources': Set Java 2 Security: true/false.
 *   'secureApps': Set application-level security: true/false.
 *   'ignoreCase': Specifies that a case-insensitive authorization check be performed: true/false.
 *   'ldapServerType': Supply a valid LDAP Server type.  Valid values are: IBM_DIRECTORY_SERVER, IPLANET, NETSCAPE, NDS, DOMINO502, SECUREWAY, ACTIVE_DIRECTORY, CUSTOM
 *   'ldapBaseDN': Supply a valid LDAP base distinguished name.
 *   'ldapBindDN': Supply a valid LDAP bind distinguished name.
 *   'ldapBindPassword': Supply a valid LDAP bind password.
 *   'ldapHostName': Supply a valid LDAP host name for the LDAP server.
 *   'ldapPort': Supply a valid port number for the LDAP server.
 *   'userRegistryType': Supply a valid user registry type.  Valid types are: LDAPUserRegistry, CustomUserRegistry, WIMUserRegistry, and LocalOSUserRegistry.
 *   'adminName': Supply an administrative user name.
 *   'adminPassword': Supply an administrative user password.
 *   'customProps': Supply any custom user registry properties.
 *   'customRegistryClass': Supply the class name of the custom user registry.
 * The required parameters are found in the constructor.
 */
public class ApplyWizardSettings extends Command {

	private Boolean secureLocalResources;
	private Boolean secureApps;
	private Boolean ignoreCase;
	private String ldapServerType;
	private String ldapBaseDN;
	private String ldapBindDN;
	private String ldapBindPassword;
	private String ldapHostName;
	private String ldapPort;
	private String userRegistryType;
	private String adminName;
	private String adminPassword;
	private String customProps;
	private String customRegistryClass;

	public ApplyWizardSettings(Boolean secureLocalResources, Boolean secureApps, String userRegistryType, String adminName) {
		super("applyWizardSettings");
		this.secureLocalResources = secureLocalResources;
		this.secureApps = secureApps;
		this.userRegistryType = userRegistryType;
		this.adminName = adminName;
	}

	/**
	 * Set Java 2 Security: true/false.
	 */
	public Boolean getSecureLocalResources() {
		return this.secureLocalResources;
	}

	/**
	 * Set Java 2 Security: true/false.
	 */
	public void setSecureLocalResources(Boolean value) {
		this.secureLocalResources = value;
	}

	/**
	 * Set application-level security: true/false.
	 */
	public Boolean getSecureApps() {
		return this.secureApps;
	}

	/**
	 * Set application-level security: true/false.
	 */
	public void setSecureApps(Boolean value) {
		this.secureApps = value;
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
	 * Supply a valid LDAP Server type.  Valid values are: IBM_DIRECTORY_SERVER, IPLANET, NETSCAPE, NDS, DOMINO502, SECUREWAY, ACTIVE_DIRECTORY, CUSTOM
	 */
	public String getLdapServerType() {
		return this.ldapServerType;
	}

	/**
	 * Supply a valid LDAP Server type.  Valid values are: IBM_DIRECTORY_SERVER, IPLANET, NETSCAPE, NDS, DOMINO502, SECUREWAY, ACTIVE_DIRECTORY, CUSTOM
	 */
	public void setLdapServerType(String value) {
		this.ldapServerType = value;
	}

	/**
	 * Supply a valid LDAP base distinguished name.
	 */
	public String getLdapBaseDN() {
		return this.ldapBaseDN;
	}

	/**
	 * Supply a valid LDAP base distinguished name.
	 */
	public void setLdapBaseDN(String value) {
		this.ldapBaseDN = value;
	}

	/**
	 * Supply a valid LDAP bind distinguished name.
	 */
	public String getLdapBindDN() {
		return this.ldapBindDN;
	}

	/**
	 * Supply a valid LDAP bind distinguished name.
	 */
	public void setLdapBindDN(String value) {
		this.ldapBindDN = value;
	}

	/**
	 * Supply a valid LDAP bind password.
	 */
	public String getLdapBindPassword() {
		return this.ldapBindPassword;
	}

	/**
	 * Supply a valid LDAP bind password.
	 */
	public void setLdapBindPassword(String value) {
		this.ldapBindPassword = value;
	}

	/**
	 * Supply a valid LDAP host name for the LDAP server.
	 */
	public String getLdapHostName() {
		return this.ldapHostName;
	}

	/**
	 * Supply a valid LDAP host name for the LDAP server.
	 */
	public void setLdapHostName(String value) {
		this.ldapHostName = value;
	}

	/**
	 * Supply a valid port number for the LDAP server.
	 */
	public String getLdapPort() {
		return this.ldapPort;
	}

	/**
	 * Supply a valid port number for the LDAP server.
	 */
	public void setLdapPort(String value) {
		this.ldapPort = value;
	}

	/**
	 * Supply a valid user registry type.  Valid types are: LDAPUserRegistry, CustomUserRegistry, WIMUserRegistry, and LocalOSUserRegistry.
	 */
	public String getUserRegistryType() {
		return this.userRegistryType;
	}

	/**
	 * Supply a valid user registry type.  Valid types are: LDAPUserRegistry, CustomUserRegistry, WIMUserRegistry, and LocalOSUserRegistry.
	 */
	public void setUserRegistryType(String value) {
		this.userRegistryType = value;
	}

	/**
	 * Supply an administrative user name.
	 */
	public String getAdminName() {
		return this.adminName;
	}

	/**
	 * Supply an administrative user name.
	 */
	public void setAdminName(String value) {
		this.adminName = value;
	}

	/**
	 * Supply an administrative user password.
	 */
	public String getAdminPassword() {
		return this.adminPassword;
	}

	/**
	 * Supply an administrative user password.
	 */
	public void setAdminPassword(String value) {
		this.adminPassword = value;
	}

	/**
	 * Supply any custom user registry properties.
	 */
	public String getCustomProps() {
		return this.customProps;
	}

	/**
	 * Supply any custom user registry properties.
	 */
	public void setCustomProps(String value) {
		this.customProps = value;
	}

	/**
	 * Supply the class name of the custom user registry.
	 */
	public String getCustomRegistryClass() {
		return this.customRegistryClass;
	}

	/**
	 * Supply the class name of the custom user registry.
	 */
	public void setCustomRegistryClass(String value) {
		this.customRegistryClass = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("secureLocalResources", this.secureLocalResources);
		ret.put("secureApps", this.secureApps);
		if (this.ignoreCase != null) {
			ret.put("ignoreCase", this.ignoreCase);
		}
		if (this.ldapServerType != null) {
			ret.put("ldapServerType", this.ldapServerType);
		}
		if (this.ldapBaseDN != null) {
			ret.put("ldapBaseDN", this.ldapBaseDN);
		}
		if (this.ldapBindDN != null) {
			ret.put("ldapBindDN", this.ldapBindDN);
		}
		if (this.ldapBindPassword != null) {
			ret.put("ldapBindPassword", this.ldapBindPassword);
		}
		if (this.ldapHostName != null) {
			ret.put("ldapHostName", this.ldapHostName);
		}
		if (this.ldapPort != null) {
			ret.put("ldapPort", this.ldapPort);
		}
		ret.put("userRegistryType", this.userRegistryType);
		ret.put("adminName", this.adminName);
		if (this.adminPassword != null) {
			ret.put("adminPassword", this.adminPassword);
		}
		if (this.customProps != null) {
			ret.put("customProps", this.customProps);
		}
		if (this.customRegistryClass != null) {
			ret.put("customRegistryClass", this.customRegistryClass);
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
