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
 * Configures the CSI inbound information in the administrative security configuration or in an application security domain.
 *   'trustedIdentities': A pipe separated list of trusted identities
 *   'clientCertAuth': Client certificate authentication.  Values are: Never, Supported, and Required
 *   'messageLevelAuth': Message level authentication.  Valid values are: Never, Supported, and Required
 *   'sslConfiguration': Specify SSL configuration alias for inbound connections.
 *   'enableAttributePropagation': Specify to true to enable attribute propagation and false to disable.
 *   'enableIdentityAssertion': Specify true to enable identity assertion and false to disable
 *   'statefulSession': Specify true to make the session stateful and false not to have stateful session
 *   'supportedAuthMechList': Supported authentication mechanisms, valid values are: KRB5, LTPA, BasicAuth, and custom
 *   'transportLayer': Transport layer authentication.  Valid values are: Never, Supported, and Required
 *   'securityDomainName': Name used to uniquely identify the security domain.
 * The required parameters are found in the constructor.
 */
public class ConfigureCSIInbound extends Command {

	private String trustedIdentities;
	private String clientCertAuth;
	private String messageLevelAuth;
	private String sslConfiguration;
	private Boolean enableAttributePropagation;
	private Boolean enableIdentityAssertion;
	private Boolean statefulSession;
	private String supportedAuthMechList;
	private String transportLayer;
	private String securityDomainName;

	public ConfigureCSIInbound() {
		super("configureCSIInbound");
	}

	/**
	 * A pipe separated list of trusted identities
	 */
	public String getTrustedIdentities() {
		return this.trustedIdentities;
	}

	/**
	 * A pipe separated list of trusted identities
	 */
	public void setTrustedIdentities(String value) {
		this.trustedIdentities = value;
	}

	/**
	 * Client certificate authentication.  Values are: Never, Supported, and Required
	 */
	public String getClientCertAuth() {
		return this.clientCertAuth;
	}

	/**
	 * Client certificate authentication.  Values are: Never, Supported, and Required
	 */
	public void setClientCertAuth(String value) {
		this.clientCertAuth = value;
	}

	/**
	 * Message level authentication.  Valid values are: Never, Supported, and Required
	 */
	public String getMessageLevelAuth() {
		return this.messageLevelAuth;
	}

	/**
	 * Message level authentication.  Valid values are: Never, Supported, and Required
	 */
	public void setMessageLevelAuth(String value) {
		this.messageLevelAuth = value;
	}

	/**
	 * Specify SSL configuration alias for inbound connections.
	 */
	public String getSslConfiguration() {
		return this.sslConfiguration;
	}

	/**
	 * Specify SSL configuration alias for inbound connections.
	 */
	public void setSslConfiguration(String value) {
		this.sslConfiguration = value;
	}

	/**
	 * Specify to true to enable attribute propagation and false to disable.
	 */
	public Boolean getEnableAttributePropagation() {
		return this.enableAttributePropagation;
	}

	/**
	 * Specify to true to enable attribute propagation and false to disable.
	 */
	public void setEnableAttributePropagation(Boolean value) {
		this.enableAttributePropagation = value;
	}

	/**
	 * Specify true to enable identity assertion and false to disable
	 */
	public Boolean getEnableIdentityAssertion() {
		return this.enableIdentityAssertion;
	}

	/**
	 * Specify true to enable identity assertion and false to disable
	 */
	public void setEnableIdentityAssertion(Boolean value) {
		this.enableIdentityAssertion = value;
	}

	/**
	 * Specify true to make the session stateful and false not to have stateful session
	 */
	public Boolean getStatefulSession() {
		return this.statefulSession;
	}

	/**
	 * Specify true to make the session stateful and false not to have stateful session
	 */
	public void setStatefulSession(Boolean value) {
		this.statefulSession = value;
	}

	/**
	 * Supported authentication mechanisms, valid values are: KRB5, LTPA, BasicAuth, and custom
	 */
	public String getSupportedAuthMechList() {
		return this.supportedAuthMechList;
	}

	/**
	 * Supported authentication mechanisms, valid values are: KRB5, LTPA, BasicAuth, and custom
	 */
	public void setSupportedAuthMechList(String value) {
		this.supportedAuthMechList = value;
	}

	/**
	 * Transport layer authentication.  Valid values are: Never, Supported, and Required
	 */
	public String getTransportLayer() {
		return this.transportLayer;
	}

	/**
	 * Transport layer authentication.  Valid values are: Never, Supported, and Required
	 */
	public void setTransportLayer(String value) {
		this.transportLayer = value;
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
		if (this.trustedIdentities != null) {
			ret.put("trustedIdentities", this.trustedIdentities);
		}
		if (this.clientCertAuth != null) {
			ret.put("clientCertAuth", this.clientCertAuth);
		}
		if (this.messageLevelAuth != null) {
			ret.put("messageLevelAuth", this.messageLevelAuth);
		}
		if (this.sslConfiguration != null) {
			ret.put("sslConfiguration", this.sslConfiguration);
		}
		if (this.enableAttributePropagation != null) {
			ret.put("enableAttributePropagation", this.enableAttributePropagation);
		}
		if (this.enableIdentityAssertion != null) {
			ret.put("enableIdentityAssertion", this.enableIdentityAssertion);
		}
		if (this.statefulSession != null) {
			ret.put("statefulSession", this.statefulSession);
		}
		if (this.supportedAuthMechList != null) {
			ret.put("supportedAuthMechList", this.supportedAuthMechList);
		}
		if (this.transportLayer != null) {
			ret.put("transportLayer", this.transportLayer);
		}
		if (this.securityDomainName != null) {
			ret.put("securityDomainName", this.securityDomainName);
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
