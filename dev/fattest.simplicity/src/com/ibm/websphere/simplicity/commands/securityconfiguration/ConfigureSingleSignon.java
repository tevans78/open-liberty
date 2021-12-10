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
 * Configure single signon.
 *   'enable': Set to enable or disable single signon.
 *   'requiresSSL': Set if SSL is required.
 *   'interoperable': Set the single signon interoperability mode.
 *   'attributePropagation': Configures single signon attribute propagation.
 *   'domainName': Configures the domain for single signon.
 * The required parameters are found in the constructor.
 */
public class ConfigureSingleSignon extends Command {

	private Boolean enable;
	private Boolean requiresSSL;
	private Boolean interoperable;
	private Boolean attributePropagation;
	private String domainName;

	public ConfigureSingleSignon() {
		super("configureSingleSignon");
	}

	/**
	 * Set to enable or disable single signon.
	 */
	public Boolean getEnable() {
		return this.enable;
	}

	/**
	 * Set to enable or disable single signon.
	 */
	public void setEnable(Boolean value) {
		this.enable = value;
	}

	/**
	 * Set if SSL is required.
	 */
	public Boolean getRequiresSSL() {
		return this.requiresSSL;
	}

	/**
	 * Set if SSL is required.
	 */
	public void setRequiresSSL(Boolean value) {
		this.requiresSSL = value;
	}

	/**
	 * Set the single signon interoperability mode.
	 */
	public Boolean getInteroperable() {
		return this.interoperable;
	}

	/**
	 * Set the single signon interoperability mode.
	 */
	public void setInteroperable(Boolean value) {
		this.interoperable = value;
	}

	/**
	 * Configures single signon attribute propagation.
	 */
	public Boolean getAttributePropagation() {
		return this.attributePropagation;
	}

	/**
	 * Configures single signon attribute propagation.
	 */
	public void setAttributePropagation(Boolean value) {
		this.attributePropagation = value;
	}

	/**
	 * Configures the domain for single signon.
	 */
	public String getDomainName() {
		return this.domainName;
	}

	/**
	 * Configures the domain for single signon.
	 */
	public void setDomainName(String value) {
		this.domainName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.enable != null) {
			ret.put("enable", this.enable);
		}
		if (this.requiresSSL != null) {
			ret.put("requiresSSL", this.requiresSSL);
		}
		if (this.interoperable != null) {
			ret.put("interoperable", this.interoperable);
		}
		if (this.attributePropagation != null) {
			ret.put("attributePropagation", this.attributePropagation);
		}
		if (this.domainName != null) {
			ret.put("domainName", this.domainName);
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
