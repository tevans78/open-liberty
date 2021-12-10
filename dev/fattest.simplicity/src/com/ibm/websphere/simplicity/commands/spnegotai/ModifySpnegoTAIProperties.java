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

package com.ibm.websphere.simplicity.commands.spnegotai;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * This command modifies SPNEGO TAI properties in the security configuration.
 *   'trimUserName': Indicate whether or not Kerberos realm name is to be removed from the Kerberos principal name.
 *   'filterClass': Supply HTTP filter classname.
 *   'filter': Supply HTTP request filter rules.
 *   'spnId': Supply SPN identifier number.
 *   'ntlmTokenPage': Supply URI of resource with response for use when NTLM token is received. If not specified, the response is "Your browser configuration is correct, but you have not logged into a supported Microsoft(R) Windows(R) Domain. Please login to the application using the normal login page."
 *   'noSpnegoPage': Supply URI of resource with response for use when SPNEGO is not supported. If not specified, the response is "SPNEGO authentication is not supported on this client."
 *   'host': Supply a long host name.
 * The required parameters are found in the constructor.
 */
public class ModifySpnegoTAIProperties extends Command {

	private Boolean trimUserName;
	private String filterClass;
	private String filter;
	private Integer spnId;
	private String ntlmTokenPage;
	private String noSpnegoPage;
	private String host;

	public ModifySpnegoTAIProperties(Integer spnId) {
		super("modifySpnegoTAIProperties");
		this.spnId = spnId;
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
	public String getFilter() {
		return this.filter;
	}

	/**
	 * Supply HTTP request filter rules.
	 */
	public void setFilter(String value) {
		this.filter = value;
	}

	/**
	 * Supply SPN identifier number.
	 */
	public Integer getSpnId() {
		return this.spnId;
	}

	/**
	 * Supply SPN identifier number.
	 */
	public void setSpnId(Integer value) {
		this.spnId = value;
	}

	/**
	 * Supply URI of resource with response for use when NTLM token is received. If not specified, the response is "Your browser configuration is correct, but you have not logged into a supported Microsoft(R) Windows(R) Domain. Please login to the application using the normal login page."
	 */
	public String getNtlmTokenPage() {
		return this.ntlmTokenPage;
	}

	/**
	 * Supply URI of resource with response for use when NTLM token is received. If not specified, the response is "Your browser configuration is correct, but you have not logged into a supported Microsoft(R) Windows(R) Domain. Please login to the application using the normal login page."
	 */
	public void setNtlmTokenPage(String value) {
		this.ntlmTokenPage = value;
	}

	/**
	 * Supply URI of resource with response for use when SPNEGO is not supported. If not specified, the response is "SPNEGO authentication is not supported on this client."
	 */
	public String getNoSpnegoPage() {
		return this.noSpnegoPage;
	}

	/**
	 * Supply URI of resource with response for use when SPNEGO is not supported. If not specified, the response is "SPNEGO authentication is not supported on this client."
	 */
	public void setNoSpnegoPage(String value) {
		this.noSpnegoPage = value;
	}

	/**
	 * Supply a long host name.
	 */
	public String getHost() {
		return this.host;
	}

	/**
	 * Supply a long host name.
	 */
	public void setHost(String value) {
		this.host = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.trimUserName != null) {
			ret.put("trimUserName", this.trimUserName);
		}
		if (this.filterClass != null) {
			ret.put("filterClass", this.filterClass);
		}
		if (this.filter != null) {
			ret.put("filter", this.filter);
		}
		ret.put("spnId", this.spnId);
		if (this.ntlmTokenPage != null) {
			ret.put("ntlmTokenPage", this.ntlmTokenPage);
		}
		if (this.noSpnegoPage != null) {
			ret.put("noSpnegoPage", this.noSpnegoPage);
		}
		if (this.host != null) {
			ret.put("host", this.host);
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
