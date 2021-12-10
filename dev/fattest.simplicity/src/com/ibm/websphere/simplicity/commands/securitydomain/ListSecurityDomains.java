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
 * Lists all security domains.
 *   'listDescription': Specify true to include the description of each security domain in the list returned false to just return the names of the security domains.
 *   'doNotDisplaySpecialDomains': Specify true to not include the special domains in the list of security domains returned and false to display the special domains.
 * The required parameters are found in the constructor.
 */
public class ListSecurityDomains extends Command {

	private Boolean listDescription = false;
	private Boolean doNotDisplaySpecialDomains = false;

	public ListSecurityDomains() {
		super("listSecurityDomains");
	}

	/**
	 * Specify true to include the description of each security domain in the list returned false to just return the names of the security domains.
	 */
	public Boolean getListDescription() {
		return this.listDescription;
	}

	/**
	 * Specify true to include the description of each security domain in the list returned false to just return the names of the security domains.
	 */
	public void setListDescription(Boolean value) {
		this.listDescription = value;
	}

	/**
	 * Specify true to not include the special domains in the list of security domains returned and false to display the special domains.
	 */
	public Boolean getDoNotDisplaySpecialDomains() {
		return this.doNotDisplaySpecialDomains;
	}

	/**
	 * Specify true to not include the special domains in the list of security domains returned and false to display the special domains.
	 */
	public void setDoNotDisplaySpecialDomains(Boolean value) {
		this.doNotDisplaySpecialDomains = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.listDescription != null) {
			ret.put("listDescription", this.listDescription);
		}
		if (this.doNotDisplaySpecialDomains != null) {
			ret.put("doNotDisplaySpecialDomains", this.doNotDisplaySpecialDomains);
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
