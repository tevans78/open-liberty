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

package com.ibm.websphere.simplicity.commands.securityrealminfo;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * List trusted realms trusted by a security realm, resource, or security domain.
 *   'securityDomainName': Security domain name for which the a list of trusted realms will be returned.
 *   'securityRealmName': Realm name for which the a list of trusted realms will be returned.
 *   'resourceName': Resource name for which the a list of trusted realms will be returned.
 *   'includeCurrentRealm': Specify true to include the current realm in the list of realms or specify false to not inlcude the current realm in the list of trusted realms.
 *   'expandRealmList': Specify true to return the list of all realm name when the trustAllRealms property is enabled, and false to just return trustAllRealms.
 *   'communicationType': The type of trusted communication.  Valid values are inbound and outbound.
 * The required parameters are found in the constructor.
 */
public class ListTrustedRealms extends Command {

	private String securityDomainName;
	private String securityRealmName;
	private String resourceName;
	private Boolean includeCurrentRealm = false;
	private Boolean expandRealmList = false;
	private String communicationType;

	public ListTrustedRealms(String communicationType) {
		super("listTrustedRealms");
		this.communicationType = communicationType;
	}

	/**
	 * Security domain name for which the a list of trusted realms will be returned.
	 */
	public String getSecurityDomainName() {
		return this.securityDomainName;
	}

	/**
	 * Security domain name for which the a list of trusted realms will be returned.
	 */
	public void setSecurityDomainName(String value) {
		this.securityDomainName = value;
	}

	/**
	 * Realm name for which the a list of trusted realms will be returned.
	 */
	public String getSecurityRealmName() {
		return this.securityRealmName;
	}

	/**
	 * Realm name for which the a list of trusted realms will be returned.
	 */
	public void setSecurityRealmName(String value) {
		this.securityRealmName = value;
	}

	/**
	 * Resource name for which the a list of trusted realms will be returned.
	 */
	public String getResourceName() {
		return this.resourceName;
	}

	/**
	 * Resource name for which the a list of trusted realms will be returned.
	 */
	public void setResourceName(String value) {
		this.resourceName = value;
	}

	/**
	 * Specify true to include the current realm in the list of realms or specify false to not inlcude the current realm in the list of trusted realms.
	 */
	public Boolean getIncludeCurrentRealm() {
		return this.includeCurrentRealm;
	}

	/**
	 * Specify true to include the current realm in the list of realms or specify false to not inlcude the current realm in the list of trusted realms.
	 */
	public void setIncludeCurrentRealm(Boolean value) {
		this.includeCurrentRealm = value;
	}

	/**
	 * Specify true to return the list of all realm name when the trustAllRealms property is enabled, and false to just return trustAllRealms.
	 */
	public Boolean getExpandRealmList() {
		return this.expandRealmList;
	}

	/**
	 * Specify true to return the list of all realm name when the trustAllRealms property is enabled, and false to just return trustAllRealms.
	 */
	public void setExpandRealmList(Boolean value) {
		this.expandRealmList = value;
	}

	/**
	 * The type of trusted communication.  Valid values are inbound and outbound.
	 */
	public String getCommunicationType() {
		return this.communicationType;
	}

	/**
	 * The type of trusted communication.  Valid values are inbound and outbound.
	 */
	public void setCommunicationType(String value) {
		this.communicationType = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.securityDomainName != null) {
			ret.put("securityDomainName", this.securityDomainName);
		}
		if (this.securityRealmName != null) {
			ret.put("securityRealmName", this.securityRealmName);
		}
		if (this.resourceName != null) {
			ret.put("resourceName", this.resourceName);
		}
		if (this.includeCurrentRealm != null) {
			ret.put("includeCurrentRealm", this.includeCurrentRealm);
		}
		if (this.expandRealmList != null) {
			ret.put("expandRealmList", this.expandRealmList);
		}
		ret.put("communicationType", this.communicationType);
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
