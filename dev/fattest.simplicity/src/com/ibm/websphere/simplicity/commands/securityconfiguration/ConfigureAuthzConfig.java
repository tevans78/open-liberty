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
 * Configures an external authorization provider in global security or in an application security domain.
 *   'description': Description of the authorization provider.
 *   'useJACCProvider': Enables the JAAC authorization provider.
 *   'name': Name of the authorization provider.
 *   'securityDomainName': Name used to uniquely identify the security domain.
 *   'customProperties': Add, modify, or remove custom properties on the security object.
 *   'initializeJACCProviderClassName': Specifies the class name of an implementation class that implements the com.ibm.wsspi.security.authorization.InitializeJACCProvider interface.
 *   'roleConfigurationFactoryImplClassName': Specifies the class name of an implementation class that implements the com.ibm.wsspi.security.authorization.RoleConfigurationFactory interface.
 *   'policyConfigurationFactoryImplClassName': Policy configuration factory class name
 *   'j2eePolicyImplClassName': Specifies the class name of an implementation class that represents the javax.security.jacc.policy.provider property according to the specification.
 *   'requiresEJBArgumentsPolicyContextHandler': Requires the EJB arguments policy context handler for access decisions (true/false)
 *   'supportsDynamicModuleUpdates': Supports dynamic module updates (true/false)
 * The required parameters are found in the constructor.
 */
public class ConfigureAuthzConfig extends Command {

	private String description;
	private Boolean useJACCProvider;
	private String name;
	private String securityDomainName;
	private String customProperties;
	private String initializeJACCProviderClassName;
	private String roleConfigurationFactoryImplClassName;
	private String policyConfigurationFactoryImplClassName;
	private String j2eePolicyImplClassName;
	private Boolean requiresEJBArgumentsPolicyContextHandler;
	private Boolean supportsDynamicModuleUpdates;

	public ConfigureAuthzConfig() {
		super("configureAuthzConfig");
	}

	/**
	 * Description of the authorization provider.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Description of the authorization provider.
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Enables the JAAC authorization provider.
	 */
	public Boolean getUseJACCProvider() {
		return this.useJACCProvider;
	}

	/**
	 * Enables the JAAC authorization provider.
	 */
	public void setUseJACCProvider(Boolean value) {
		this.useJACCProvider = value;
	}

	/**
	 * Name of the authorization provider.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Name of the authorization provider.
	 */
	public void setName(String value) {
		this.name = value;
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
	 * Add, modify, or remove custom properties on the security object.
	 */
	public String getCustomProperties() {
		return this.customProperties;
	}

	/**
	 * Add, modify, or remove custom properties on the security object.
	 */
	public void setCustomProperties(String value) {
		this.customProperties = value;
	}

	/**
	 * Specifies the class name of an implementation class that implements the com.ibm.wsspi.security.authorization.InitializeJACCProvider interface.
	 */
	public String getInitializeJACCProviderClassName() {
		return this.initializeJACCProviderClassName;
	}

	/**
	 * Specifies the class name of an implementation class that implements the com.ibm.wsspi.security.authorization.InitializeJACCProvider interface.
	 */
	public void setInitializeJACCProviderClassName(String value) {
		this.initializeJACCProviderClassName = value;
	}

	/**
	 * Specifies the class name of an implementation class that implements the com.ibm.wsspi.security.authorization.RoleConfigurationFactory interface.
	 */
	public String getRoleConfigurationFactoryImplClassName() {
		return this.roleConfigurationFactoryImplClassName;
	}

	/**
	 * Specifies the class name of an implementation class that implements the com.ibm.wsspi.security.authorization.RoleConfigurationFactory interface.
	 */
	public void setRoleConfigurationFactoryImplClassName(String value) {
		this.roleConfigurationFactoryImplClassName = value;
	}

	/**
	 * Policy configuration factory class name
	 */
	public String getPolicyConfigurationFactoryImplClassName() {
		return this.policyConfigurationFactoryImplClassName;
	}

	/**
	 * Policy configuration factory class name
	 */
	public void setPolicyConfigurationFactoryImplClassName(String value) {
		this.policyConfigurationFactoryImplClassName = value;
	}

	/**
	 * Specifies the class name of an implementation class that represents the javax.security.jacc.policy.provider property according to the specification.
	 */
	public String getJ2eePolicyImplClassName() {
		return this.j2eePolicyImplClassName;
	}

	/**
	 * Specifies the class name of an implementation class that represents the javax.security.jacc.policy.provider property according to the specification.
	 */
	public void setJ2eePolicyImplClassName(String value) {
		this.j2eePolicyImplClassName = value;
	}

	/**
	 * Requires the EJB arguments policy context handler for access decisions (true/false)
	 */
	public Boolean getRequiresEJBArgumentsPolicyContextHandler() {
		return this.requiresEJBArgumentsPolicyContextHandler;
	}

	/**
	 * Requires the EJB arguments policy context handler for access decisions (true/false)
	 */
	public void setRequiresEJBArgumentsPolicyContextHandler(Boolean value) {
		this.requiresEJBArgumentsPolicyContextHandler = value;
	}

	/**
	 * Supports dynamic module updates (true/false)
	 */
	public Boolean getSupportsDynamicModuleUpdates() {
		return this.supportsDynamicModuleUpdates;
	}

	/**
	 * Supports dynamic module updates (true/false)
	 */
	public void setSupportsDynamicModuleUpdates(Boolean value) {
		this.supportsDynamicModuleUpdates = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.description != null) {
			ret.put("description", this.description);
		}
		if (this.useJACCProvider != null) {
			ret.put("useJACCProvider", this.useJACCProvider);
		}
		if (this.name != null) {
			ret.put("name", this.name);
		}
		if (this.securityDomainName != null) {
			ret.put("securityDomainName", this.securityDomainName);
		}
		if (this.customProperties != null) {
			ret.put("customProperties", this.customProperties);
		}
		if (this.initializeJACCProviderClassName != null) {
			ret.put("initializeJACCProviderClassName", this.initializeJACCProviderClassName);
		}
		if (this.roleConfigurationFactoryImplClassName != null) {
			ret.put("roleConfigurationFactoryImplClassName", this.roleConfigurationFactoryImplClassName);
		}
		if (this.policyConfigurationFactoryImplClassName != null) {
			ret.put("policyConfigurationFactoryImplClassName", this.policyConfigurationFactoryImplClassName);
		}
		if (this.j2eePolicyImplClassName != null) {
			ret.put("j2eePolicyImplClassName", this.j2eePolicyImplClassName);
		}
		if (this.requiresEJBArgumentsPolicyContextHandler != null) {
			ret.put("requiresEJBArgumentsPolicyContextHandler", this.requiresEJBArgumentsPolicyContextHandler);
		}
		if (this.supportsDynamicModuleUpdates != null) {
			ret.put("supportsDynamicModuleUpdates", this.supportsDynamicModuleUpdates);
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
