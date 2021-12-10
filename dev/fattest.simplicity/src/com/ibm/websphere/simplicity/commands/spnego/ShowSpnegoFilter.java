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

package com.ibm.websphere.simplicity.commands.spnego;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * This command displays the SPNEGO Web authentication Filter in the security configuration. If a host name is not specified, all the SPNEGO Web authentication Filters are displayed.
 *   'securityDomainName': Name used to uniquely identify the security domain.
 *   'hostName': Supply a long host name.
 * The required parameters are found in the constructor.
 */
public class ShowSpnegoFilter extends Command {

	private String securityDomainName;
	private String hostName;

	public ShowSpnegoFilter() {
		super("showSpnegoFilter");
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
	 * Supply a long host name.
	 */
	public String getHostName() {
		return this.hostName;
	}

	/**
	 * Supply a long host name.
	 */
	public void setHostName(String value) {
		this.hostName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.securityDomainName != null) {
			ret.put("securityDomainName", this.securityDomainName);
		}
		if (this.hostName != null) {
			ret.put("hostName", this.hostName);
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
