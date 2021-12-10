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

package com.ibm.websphere.simplicity.commands.securitydomain;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Creates a security domain by coping from another security domain.
 *   'securityDomainDescription': Description of the security domain.
 *   'realmName': If an active user registry is defined then a new realm name must be used in the new security domain.
 *   'copyFromSecurityDomainName': Name of the pre-existing security domain used to copy information from.
 *   'securityDomainName': Name used to uniquely identify the security domain.
 * The required parameters are found in the constructor.
 */
public class CopySecurityDomain extends Command {

	private String securityDomainDescription;
	private String realmName;
	private String copyFromSecurityDomainName;
	private String securityDomainName;

	public CopySecurityDomain(String copyFromSecurityDomainName, String securityDomainName) {
		super("copySecurityDomain");
		this.copyFromSecurityDomainName = copyFromSecurityDomainName;
		this.securityDomainName = securityDomainName;
	}

	/**
	 * Description of the security domain.
	 */
	public String getSecurityDomainDescription() {
		return this.securityDomainDescription;
	}

	/**
	 * Description of the security domain.
	 */
	public void setSecurityDomainDescription(String value) {
		this.securityDomainDescription = value;
	}

	/**
	 * If an active user registry is defined then a new realm name must be used in the new security domain.
	 */
	public String getRealmName() {
		return this.realmName;
	}

	/**
	 * If an active user registry is defined then a new realm name must be used in the new security domain.
	 */
	public void setRealmName(String value) {
		this.realmName = value;
	}

	/**
	 * Name of the pre-existing security domain used to copy information from.
	 */
	public String getCopyFromSecurityDomainName() {
		return this.copyFromSecurityDomainName;
	}

	/**
	 * Name of the pre-existing security domain used to copy information from.
	 */
	public void setCopyFromSecurityDomainName(String value) {
		this.copyFromSecurityDomainName = value;
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

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.securityDomainDescription != null) {
			ret.put("securityDomainDescription", this.securityDomainDescription);
		}
		if (this.realmName != null) {
			ret.put("realmName", this.realmName);
		}
		ret.put("copyFromSecurityDomainName", this.copyFromSecurityDomainName);
		ret.put("securityDomainName", this.securityDomainName);
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
