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
 * Configures an inbound or outbound trusted realms.
 *   'realmList': A pipe separated list of realm names to add the trusted realm list.
 *   'securityDomainName': Name used to uniquely identify the security domain.
 *   'trustAllRealms': Trust all realms (true/false)
 *   'communicationType': The type of trusted communication.  Valid values are inbound and outbound.
 * The required parameters are found in the constructor.
 */
public class ConfigureTrustedRealms extends Command {

	private String realmList;
	private String securityDomainName;
	private Boolean trustAllRealms;
	private String communicationType;

	public ConfigureTrustedRealms(String communicationType) {
		super("configureTrustedRealms");
		this.communicationType = communicationType;
	}

	/**
	 * A pipe separated list of realm names to add the trusted realm list.
	 */
	public String getRealmList() {
		return this.realmList;
	}

	/**
	 * A pipe separated list of realm names to add the trusted realm list.
	 */
	public void setRealmList(String value) {
		this.realmList = value;
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
	 * Trust all realms (true/false)
	 */
	public Boolean getTrustAllRealms() {
		return this.trustAllRealms;
	}

	/**
	 * Trust all realms (true/false)
	 */
	public void setTrustAllRealms(Boolean value) {
		this.trustAllRealms = value;
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
		if (this.realmList != null) {
			ret.put("realmList", this.realmList);
		}
		if (this.securityDomainName != null) {
			ret.put("securityDomainName", this.securityDomainName);
		}
		if (this.trustAllRealms != null) {
			ret.put("trustAllRealms", this.trustAllRealms);
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
