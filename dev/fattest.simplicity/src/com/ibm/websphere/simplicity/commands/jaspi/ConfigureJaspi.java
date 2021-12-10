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

package com.ibm.websphere.simplicity.commands.jaspi;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Configure the Jaspi configuration.
 *   'securityDomainName': Specify the name of the security domain.
 *   'enabled': Specify true to enable the Jaspi configuration and false to disable the Jaspi configuration.
 *   'defaultProviderName': The name of the default authentication provider.
 * The required parameters are found in the constructor.
 */
public class ConfigureJaspi extends Command {

	private java.lang.String securityDomainName;
	private java.lang.Boolean enabled;
	private java.lang.String defaultProviderName;

	public ConfigureJaspi() {
		super("configureJaspi");
	}

	/**
	 * Specify the name of the security domain.
	 */
	public java.lang.String getSecurityDomainName() {
		return this.securityDomainName;
	}

	/**
	 * Specify the name of the security domain.
	 */
	public void setSecurityDomainName(java.lang.String value) {
		this.securityDomainName = value;
	}

	/**
	 * Specify true to enable the Jaspi configuration and false to disable the Jaspi configuration.
	 */
	public java.lang.Boolean getEnabled() {
		return this.enabled;
	}

	/**
	 * Specify true to enable the Jaspi configuration and false to disable the Jaspi configuration.
	 */
	public void setEnabled(java.lang.Boolean value) {
		this.enabled = value;
	}

	/**
	 * The name of the default authentication provider.
	 */
	public java.lang.String getDefaultProviderName() {
		return this.defaultProviderName;
	}

	/**
	 * The name of the default authentication provider.
	 */
	public void setDefaultProviderName(java.lang.String value) {
		this.defaultProviderName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.securityDomainName != null) {
			ret.put("securityDomainName", this.securityDomainName);
		}
		if (this.enabled != null) {
			ret.put("enabled", this.enabled);
		}
		if (this.defaultProviderName != null) {
			ret.put("defaultProviderName", this.defaultProviderName);
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
