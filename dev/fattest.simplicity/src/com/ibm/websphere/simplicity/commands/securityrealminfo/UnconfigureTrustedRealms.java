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
 * Unconfigures an inbound or outbound trusted realms by removing the realm object from the configuration.
 *   'securityDomainName': Name used to uniquely identify the security domain.
 *   'communicationType': The type of trusted communication.  Valid values are inbound and outbound.
 * The required parameters are found in the constructor.
 */
public class UnconfigureTrustedRealms extends Command {

	private String securityDomainName;
	private String communicationType;

	public UnconfigureTrustedRealms(String communicationType) {
		super("unconfigureTrustedRealms");
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
