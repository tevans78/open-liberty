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
 * Unsets active security settings on a security domain.  The attribute is removed from the security domain configuration.
 *   'securityDomainName': Name used to uniquely identify the security domain.
 *   'unsetActiveUserRegistry': Unset the active user registry value on the security domain.
 *   'unsetAppSecurityEnabled': Unset the application security enabled value on the security domain.
 *   'unsetCacheTimeout': Unset the cache timeout value on the security domain.
 *   'unsetEnforceFineGrainedJCASecurity': Unset the enforce fine grain security value
 *   'unsetEnforceJava2Security': Unset the enforce java 2 security value on the security domain.
 *   'unsetIssuePermissionWarning': Unset the issue permission warning value on the security domain.
 *   'unsetUseDomainQualifiedUserNames': Unset the use domain qualified user name value on the security domain.
 * The required parameters are found in the constructor.
 */
public class UnsetAppActiveSecuritySettings extends Command {

	private String securityDomainName;
	private Boolean unsetActiveUserRegistry = false;
	private Boolean unsetAppSecurityEnabled = false;
	private Boolean unsetCacheTimeout = false;
	private Boolean unsetEnforceFineGrainedJCASecurity = false;
	private Boolean unsetEnforceJava2Security = false;
	private Boolean unsetIssuePermissionWarning = false;
	private Boolean unsetUseDomainQualifiedUserNames = false;

	public UnsetAppActiveSecuritySettings(String securityDomainName) {
		super("unsetAppActiveSecuritySettings");
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
	 * Unset the active user registry value on the security domain.
	 */
	public Boolean getUnsetActiveUserRegistry() {
		return this.unsetActiveUserRegistry;
	}

	/**
	 * Unset the active user registry value on the security domain.
	 */
	public void setUnsetActiveUserRegistry(Boolean value) {
		this.unsetActiveUserRegistry = value;
	}

	/**
	 * Unset the application security enabled value on the security domain.
	 */
	public Boolean getUnsetAppSecurityEnabled() {
		return this.unsetAppSecurityEnabled;
	}

	/**
	 * Unset the application security enabled value on the security domain.
	 */
	public void setUnsetAppSecurityEnabled(Boolean value) {
		this.unsetAppSecurityEnabled = value;
	}

	/**
	 * Unset the cache timeout value on the security domain.
	 */
	public Boolean getUnsetCacheTimeout() {
		return this.unsetCacheTimeout;
	}

	/**
	 * Unset the cache timeout value on the security domain.
	 */
	public void setUnsetCacheTimeout(Boolean value) {
		this.unsetCacheTimeout = value;
	}

	/**
	 * Unset the enforce fine grain security value
	 */
	public Boolean getUnsetEnforceFineGrainedJCASecurity() {
		return this.unsetEnforceFineGrainedJCASecurity;
	}

	/**
	 * Unset the enforce fine grain security value
	 */
	public void setUnsetEnforceFineGrainedJCASecurity(Boolean value) {
		this.unsetEnforceFineGrainedJCASecurity = value;
	}

	/**
	 * Unset the enforce java 2 security value on the security domain.
	 */
	public Boolean getUnsetEnforceJava2Security() {
		return this.unsetEnforceJava2Security;
	}

	/**
	 * Unset the enforce java 2 security value on the security domain.
	 */
	public void setUnsetEnforceJava2Security(Boolean value) {
		this.unsetEnforceJava2Security = value;
	}

	/**
	 * Unset the issue permission warning value on the security domain.
	 */
	public Boolean getUnsetIssuePermissionWarning() {
		return this.unsetIssuePermissionWarning;
	}

	/**
	 * Unset the issue permission warning value on the security domain.
	 */
	public void setUnsetIssuePermissionWarning(Boolean value) {
		this.unsetIssuePermissionWarning = value;
	}

	/**
	 * Unset the use domain qualified user name value on the security domain.
	 */
	public Boolean getUnsetUseDomainQualifiedUserNames() {
		return this.unsetUseDomainQualifiedUserNames;
	}

	/**
	 * Unset the use domain qualified user name value on the security domain.
	 */
	public void setUnsetUseDomainQualifiedUserNames(Boolean value) {
		this.unsetUseDomainQualifiedUserNames = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("securityDomainName", this.securityDomainName);
		if (this.unsetActiveUserRegistry != null) {
			ret.put("unsetActiveUserRegistry", this.unsetActiveUserRegistry);
		}
		if (this.unsetAppSecurityEnabled != null) {
			ret.put("unsetAppSecurityEnabled", this.unsetAppSecurityEnabled);
		}
		if (this.unsetCacheTimeout != null) {
			ret.put("unsetCacheTimeout", this.unsetCacheTimeout);
		}
		if (this.unsetEnforceFineGrainedJCASecurity != null) {
			ret.put("unsetEnforceFineGrainedJCASecurity", this.unsetEnforceFineGrainedJCASecurity);
		}
		if (this.unsetEnforceJava2Security != null) {
			ret.put("unsetEnforceJava2Security", this.unsetEnforceJava2Security);
		}
		if (this.unsetIssuePermissionWarning != null) {
			ret.put("unsetIssuePermissionWarning", this.unsetIssuePermissionWarning);
		}
		if (this.unsetUseDomainQualifiedUserNames != null) {
			ret.put("unsetUseDomainQualifiedUserNames", this.unsetUseDomainQualifiedUserNames);
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
