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
 * Remove realms from the trusted realm list
 *   'securityDomainName': Name used to uniquely identify the security domain.
 *   'realmList': Removes a realm or list of realms from the list of trusted realms in a security domain or in global security.
 *   'communicationType': The type of trusted communication.  Valid values are inbound and outbound.
 * The required parameters are found in the constructor.
 */
public class RemoveTrustedRealms extends Command {

	private String securityDomainName;
	private String realmList;
	private String communicationType;

	public RemoveTrustedRealms(String realmList, String communicationType) {
		super("removeTrustedRealms");
		this.realmList = realmList;
		this.communicationType = communicationType;
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
	 * Removes a realm or list of realms from the list of trusted realms in a security domain or in global security.
	 */
	public String getRealmList() {
		return this.realmList;
	}

	/**
	 * Removes a realm or list of realms from the list of trusted realms in a security domain or in global security.
	 */
	public void setRealmList(String value) {
		this.realmList = value;
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
		ret.put("realmList", this.realmList);
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
