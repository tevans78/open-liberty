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
 * Modify configuration data for a given authentication provider and associated modules.
 *   'providerName': Specify a unique name that identifies the authentication provider.
 *   'className': Specify the package-qualified name of the class that implements the authentication provider.
 *   'securityDomainName': Specify the name of the security domain.
 *   'description': Specify a explanatory description of the authentication provider.
 *   'properties': Specify any additional configuration options needed to initialize the authentication provider.
 * The required parameters are found in the constructor.
 */
public class ModifyJaspiProvider extends Command {

	private java.lang.String providerName;
	private java.lang.String className;
	private java.lang.String securityDomainName;
	private java.lang.String description;
	private java.util.Properties properties;

	public ModifyJaspiProvider(java.lang.String providerName) {
		super("modifyJaspiProvider");
		this.providerName = providerName;
	}

	/**
	 * Specify a unique name that identifies the authentication provider.
	 */
	public java.lang.String getProviderName() {
		return this.providerName;
	}

	/**
	 * Specify a unique name that identifies the authentication provider.
	 */
	public void setProviderName(java.lang.String value) {
		this.providerName = value;
	}

	/**
	 * Specify the package-qualified name of the class that implements the authentication provider.
	 */
	public java.lang.String getClassName() {
		return this.className;
	}

	/**
	 * Specify the package-qualified name of the class that implements the authentication provider.
	 */
	public void setClassName(java.lang.String value) {
		this.className = value;
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
	 * Specify a explanatory description of the authentication provider.
	 */
	public java.lang.String getDescription() {
		return this.description;
	}

	/**
	 * Specify a explanatory description of the authentication provider.
	 */
	public void setDescription(java.lang.String value) {
		this.description = value;
	}

	/**
	 * Specify any additional configuration options needed to initialize the authentication provider.
	 */
	public java.util.Properties getProperties() {
		return this.properties;
	}

	/**
	 * Specify any additional configuration options needed to initialize the authentication provider.
	 */
	public void setProperties(java.util.Properties value) {
		this.properties = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("providerName", this.providerName);
		if (this.className != null) {
			ret.put("className", this.className);
		}
		if (this.securityDomainName != null) {
			ret.put("securityDomainName", this.securityDomainName);
		}
		if (this.description != null) {
			ret.put("description", this.description);
		}
		if (this.properties != null) {
			ret.put("properties", this.properties);
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
	 * Steps are required by this command, and they appear after the scope parameter.
	 * Classes for these steps are statically available through this admin command class.
	 */
	public OperationResults<Object> run(Scope scope) throws Exception {
		return super.run(scope);
	}

}
