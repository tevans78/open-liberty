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
 * This command modifies SPNEGO Web authentication Filter attributes in the security configuration.
 *   'trimUserName': Indicate whether or not Kerberos realm name is to be removed from the Kerberos principal name.
 *   'enabledGssCredDelegate': Indicate whether or not to extract and place the client GSS delegation credential in the subject.
 *   'securityDomainName': Name used to uniquely identify the security domain.
 *   'filterClass': Supply HTTP filter classname.
 *   'filterCriteria': Supply HTTP request filter rules.
 *   'ntlmTokenReceivedPage': Supply URI of resource with response for use when NTLM token is received. If not specified, the response is "Your browser configuration is correct, but you have not logged into a supported Microsoft(R) Windows(R) Domain. Please login to the application using the normal login page."
 *   'spnegoNotSupportedPage': Supply URI of resource with response for use when SPNEGO is not supported. If not specified, the response is "SPNEGO authentication is not supported on this client."
 *   'krb5Realm': Supply a Kerberos realm.
 *   'hostName': Supply a long host name.
 * The required parameters are found in the constructor.
 */
public class ModifySpnegoFilter extends Command {

	private Boolean trimUserName = true;
	private Boolean enabledGssCredDelegate = true;
	private String securityDomainName;
	private String filterClass = "com.ibm.ws.security.spnego.HTTPHeaderFilter";
	private String filterCriteria;
	private String ntlmTokenReceivedPage;
	private String spnegoNotSupportedPage;
	private String krb5Realm;
	private String hostName;

	public ModifySpnegoFilter(String hostName) {
		super("modifySpnegoFilter");
		this.hostName = hostName;
	}

	/**
	 * Indicate whether or not Kerberos realm name is to be removed from the Kerberos principal name.
	 */
	public Boolean getTrimUserName() {
		return this.trimUserName;
	}

	/**
	 * Indicate whether or not Kerberos realm name is to be removed from the Kerberos principal name.
	 */
	public void setTrimUserName(Boolean value) {
		this.trimUserName = value;
	}

	/**
	 * Indicate whether or not to extract and place the client GSS delegation credential in the subject.
	 */
	public Boolean getEnabledGssCredDelegate() {
		return this.enabledGssCredDelegate;
	}

	/**
	 * Indicate whether or not to extract and place the client GSS delegation credential in the subject.
	 */
	public void setEnabledGssCredDelegate(Boolean value) {
		this.enabledGssCredDelegate = value;
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
	 * Supply HTTP filter classname.
	 */
	public String getFilterClass() {
		return this.filterClass;
	}

	/**
	 * Supply HTTP filter classname.
	 */
	public void setFilterClass(String value) {
		this.filterClass = value;
	}

	/**
	 * Supply HTTP request filter rules.
	 */
	public String getFilterCriteria() {
		return this.filterCriteria;
	}

	/**
	 * Supply HTTP request filter rules.
	 */
	public void setFilterCriteria(String value) {
		this.filterCriteria = value;
	}

	/**
	 * Supply URI of resource with response for use when NTLM token is received. If not specified, the response is "Your browser configuration is correct, but you have not logged into a supported Microsoft(R) Windows(R) Domain. Please login to the application using the normal login page."
	 */
	public String getNtlmTokenReceivedPage() {
		return this.ntlmTokenReceivedPage;
	}

	/**
	 * Supply URI of resource with response for use when NTLM token is received. If not specified, the response is "Your browser configuration is correct, but you have not logged into a supported Microsoft(R) Windows(R) Domain. Please login to the application using the normal login page."
	 */
	public void setNtlmTokenReceivedPage(String value) {
		this.ntlmTokenReceivedPage = value;
	}

	/**
	 * Supply URI of resource with response for use when SPNEGO is not supported. If not specified, the response is "SPNEGO authentication is not supported on this client."
	 */
	public String getSpnegoNotSupportedPage() {
		return this.spnegoNotSupportedPage;
	}

	/**
	 * Supply URI of resource with response for use when SPNEGO is not supported. If not specified, the response is "SPNEGO authentication is not supported on this client."
	 */
	public void setSpnegoNotSupportedPage(String value) {
		this.spnegoNotSupportedPage = value;
	}

	/**
	 * Supply a Kerberos realm.
	 */
	public String getKrb5Realm() {
		return this.krb5Realm;
	}

	/**
	 * Supply a Kerberos realm.
	 */
	public void setKrb5Realm(String value) {
		this.krb5Realm = value;
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
		if (this.trimUserName != null) {
			ret.put("trimUserName", this.trimUserName);
		}
		if (this.enabledGssCredDelegate != null) {
			ret.put("enabledGssCredDelegate", this.enabledGssCredDelegate);
		}
		if (this.securityDomainName != null) {
			ret.put("securityDomainName", this.securityDomainName);
		}
		if (this.filterClass != null) {
			ret.put("filterClass", this.filterClass);
		}
		if (this.filterCriteria != null) {
			ret.put("filterCriteria", this.filterCriteria);
		}
		if (this.ntlmTokenReceivedPage != null) {
			ret.put("ntlmTokenReceivedPage", this.ntlmTokenReceivedPage);
		}
		if (this.spnegoNotSupportedPage != null) {
			ret.put("spnegoNotSupportedPage", this.spnegoNotSupportedPage);
		}
		if (this.krb5Realm != null) {
			ret.put("krb5Realm", this.krb5Realm);
		}
		ret.put("hostName", this.hostName);
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
