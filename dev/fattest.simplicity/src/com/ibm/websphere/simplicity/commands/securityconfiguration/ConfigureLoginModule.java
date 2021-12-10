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
 * Configures a login module in the administrative security configuration or in an application security domain.
 *   'customProperties': Specifies a comma separated list of attribute=value custom property pairs to be added to the security object.
 *   'securityDomainName': Name used to uniquely identify the security domain.
 *   'loginType': Specifies the login module type.  Valid values are: system, application
 *   'loginEntryAlias': The alias name that identifies the login module entry.
 *   'authStrategy': The login module authentication strategy, Values include REQUIRED, REQUISITE, SUFFICIENT, and OPTIONAL.
 *   'loginModule': The login module class file name
 *   'useLoginModuleProxy': Use a login module proxy
 * The required parameters are found in the constructor.
 */
public class ConfigureLoginModule extends Command {

	private String customProperties;
	private String securityDomainName;
	private String loginType;
	private String loginEntryAlias;
	private String authStrategy;
	private String loginModule;
	private Boolean useLoginModuleProxy;

	public ConfigureLoginModule(String loginType, String loginEntryAlias, String loginModule) {
		super("configureLoginModule");
		this.loginType = loginType;
		this.loginEntryAlias = loginEntryAlias;
		this.loginModule = loginModule;
	}

	/**
	 * Specifies a comma separated list of attribute=value custom property pairs to be added to the security object.
	 */
	public String getCustomProperties() {
		return this.customProperties;
	}

	/**
	 * Specifies a comma separated list of attribute=value custom property pairs to be added to the security object.
	 */
	public void setCustomProperties(String value) {
		this.customProperties = value;
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
	 * Specifies the login module type.  Valid values are: system, application
	 */
	public String getLoginType() {
		return this.loginType;
	}

	/**
	 * Specifies the login module type.  Valid values are: system, application
	 */
	public void setLoginType(String value) {
		this.loginType = value;
	}

	/**
	 * The alias name that identifies the login module entry.
	 */
	public String getLoginEntryAlias() {
		return this.loginEntryAlias;
	}

	/**
	 * The alias name that identifies the login module entry.
	 */
	public void setLoginEntryAlias(String value) {
		this.loginEntryAlias = value;
	}

	/**
	 * The login module authentication strategy, Values include REQUIRED, REQUISITE, SUFFICIENT, and OPTIONAL.
	 */
	public String getAuthStrategy() {
		return this.authStrategy;
	}

	/**
	 * The login module authentication strategy, Values include REQUIRED, REQUISITE, SUFFICIENT, and OPTIONAL.
	 */
	public void setAuthStrategy(String value) {
		this.authStrategy = value;
	}

	/**
	 * The login module class file name
	 */
	public String getLoginModule() {
		return this.loginModule;
	}

	/**
	 * The login module class file name
	 */
	public void setLoginModule(String value) {
		this.loginModule = value;
	}

	/**
	 * Use a login module proxy
	 */
	public Boolean getUseLoginModuleProxy() {
		return this.useLoginModuleProxy;
	}

	/**
	 * Use a login module proxy
	 */
	public void setUseLoginModuleProxy(Boolean value) {
		this.useLoginModuleProxy = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.customProperties != null) {
			ret.put("customProperties", this.customProperties);
		}
		if (this.securityDomainName != null) {
			ret.put("securityDomainName", this.securityDomainName);
		}
		ret.put("loginType", this.loginType);
		ret.put("loginEntryAlias", this.loginEntryAlias);
		if (this.authStrategy != null) {
			ret.put("authStrategy", this.authStrategy);
		}
		ret.put("loginModule", this.loginModule);
		if (this.useLoginModuleProxy != null) {
			ret.put("useLoginModuleProxy", this.useLoginModuleProxy);
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
