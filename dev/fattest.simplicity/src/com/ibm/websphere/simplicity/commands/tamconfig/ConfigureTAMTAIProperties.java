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

package com.ibm.websphere.simplicity.commands.tamconfig;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * This command adds the custom properties to the security configuration for the embedded Tivoli Access Manager Trust Association Interceptor with classname TAMTrustAsociationInterceptorPlus.
 *   'loginId': Specifies the name of the TAM trusted user that will be used to authenticate trust.
 *   'checkViaHeader': Specifies whether or not the tai should examine the via header when determining if the request can be handled by this interceptor.
 *   'id': Specifies the headers that must exist for the request to be handled by this interceptor. Multiple values can be entered in a comma separated list.
 *   'hostnames': Specifies the hostnames that are trusted. If the via header contains other names then the request will not be handled by this interceptor. Multiple values can be entered in a comma separated list.
 *   'ports': Specifies the ports that are trusted. If the via header contains other ports then the request will not be handled by this interceptor. Multiple values can be entered in a comma separated list.
 *   'viaDepth': Specifies how many of the hosts in the via header need to be trusted. Hosts are counted in reverse order starting from the last one.
 *   'ssoPwdExpiry': Specifies the timeout for the trust authentication cache.
 *   'ignoreProxy': Specifies whether or not to ignore proxy servers when examining the via header for trusted hosts.
 *   'configURL': Specifies the url for the SvrSslCfg generated TAM client configuration properties file.
 * The required parameters are found in the constructor.
 */
public class ConfigureTAMTAIProperties extends Command {

	private String loginId;
	private String checkViaHeader = "false";
	private String id = "iv-creds";
	private String hostnames;
	private String ports;
	private String viaDepth = "0";
	private String ssoPwdExpiry = "600";
	private String ignoreProxy = "false";
	private String configURL = "${WAS_INSTALL_ROOT}/java/jre/PdPerm.properties";

	public ConfigureTAMTAIProperties(String loginId) {
		super("configureTAMTAIProperties");
		this.loginId = loginId;
	}

	/**
	 * Specifies the name of the TAM trusted user that will be used to authenticate trust.
	 */
	public String getLoginId() {
		return this.loginId;
	}

	/**
	 * Specifies the name of the TAM trusted user that will be used to authenticate trust.
	 */
	public void setLoginId(String value) {
		this.loginId = value;
	}

	/**
	 * Specifies whether or not the tai should examine the via header when determining if the request can be handled by this interceptor.
	 */
	public String getCheckViaHeader() {
		return this.checkViaHeader;
	}

	/**
	 * Specifies whether or not the tai should examine the via header when determining if the request can be handled by this interceptor.
	 */
	public void setCheckViaHeader(String value) {
		this.checkViaHeader = value;
	}

	/**
	 * Specifies the headers that must exist for the request to be handled by this interceptor. Multiple values can be entered in a comma separated list.
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Specifies the headers that must exist for the request to be handled by this interceptor. Multiple values can be entered in a comma separated list.
	 */
	public void setId(String value) {
		this.id = value;
	}

	/**
	 * Specifies the hostnames that are trusted. If the via header contains other names then the request will not be handled by this interceptor. Multiple values can be entered in a comma separated list.
	 */
	public String getHostnames() {
		return this.hostnames;
	}

	/**
	 * Specifies the hostnames that are trusted. If the via header contains other names then the request will not be handled by this interceptor. Multiple values can be entered in a comma separated list.
	 */
	public void setHostnames(String value) {
		this.hostnames = value;
	}

	/**
	 * Specifies the ports that are trusted. If the via header contains other ports then the request will not be handled by this interceptor. Multiple values can be entered in a comma separated list.
	 */
	public String getPorts() {
		return this.ports;
	}

	/**
	 * Specifies the ports that are trusted. If the via header contains other ports then the request will not be handled by this interceptor. Multiple values can be entered in a comma separated list.
	 */
	public void setPorts(String value) {
		this.ports = value;
	}

	/**
	 * Specifies how many of the hosts in the via header need to be trusted. Hosts are counted in reverse order starting from the last one.
	 */
	public String getViaDepth() {
		return this.viaDepth;
	}

	/**
	 * Specifies how many of the hosts in the via header need to be trusted. Hosts are counted in reverse order starting from the last one.
	 */
	public void setViaDepth(String value) {
		this.viaDepth = value;
	}

	/**
	 * Specifies the timeout for the trust authentication cache.
	 */
	public String getSsoPwdExpiry() {
		return this.ssoPwdExpiry;
	}

	/**
	 * Specifies the timeout for the trust authentication cache.
	 */
	public void setSsoPwdExpiry(String value) {
		this.ssoPwdExpiry = value;
	}

	/**
	 * Specifies whether or not to ignore proxy servers when examining the via header for trusted hosts.
	 */
	public String getIgnoreProxy() {
		return this.ignoreProxy;
	}

	/**
	 * Specifies whether or not to ignore proxy servers when examining the via header for trusted hosts.
	 */
	public void setIgnoreProxy(String value) {
		this.ignoreProxy = value;
	}

	/**
	 * Specifies the url for the SvrSslCfg generated TAM client configuration properties file.
	 */
	public String getConfigURL() {
		return this.configURL;
	}

	/**
	 * Specifies the url for the SvrSslCfg generated TAM client configuration properties file.
	 */
	public void setConfigURL(String value) {
		this.configURL = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("loginId", this.loginId);
		if (this.checkViaHeader != null) {
			ret.put("checkViaHeader", this.checkViaHeader);
		}
		if (this.id != null) {
			ret.put("id", this.id);
		}
		if (this.hostnames != null) {
			ret.put("hostnames", this.hostnames);
		}
		if (this.ports != null) {
			ret.put("ports", this.ports);
		}
		if (this.viaDepth != null) {
			ret.put("viaDepth", this.viaDepth);
		}
		if (this.ssoPwdExpiry != null) {
			ret.put("ssoPwdExpiry", this.ssoPwdExpiry);
		}
		if (this.ignoreProxy != null) {
			ret.put("ignoreProxy", this.ignoreProxy);
		}
		if (this.configURL != null) {
			ret.put("configURL", this.configURL);
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
