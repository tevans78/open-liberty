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

package com.ibm.websphere.simplicity.commands.createwebserverbyhostname;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Create Web server definition using hostname.
 *   'hostName': Specify the host name where the Web server is installed.
 *   'platform': platformDesc
 *   'webserverName': Specify the name for this Web server defintion.
 *   'templateName': TemplateNameDesc
 *   'webPort': Web server Port.
 *   'webInstallRoot': Install Root for Web server.
 *   'pluginInstallRoot': Plugin Install Root.
 *   'configurationFile': configurationFileDesc_2
 *   'serviceName': Windows ServiceName for starting IHS Web server as a Service.
 *   'errorLogfile': errorLogfileDesc_2
 *   'accessLogfile': accessLogfileDesc_2
 *   'webProtocol': Web server protocol.
 *   'webAppMapping': Web server application mapping.
 *   'adminPort': IBM Administration Server Port.
 *   'adminUserID': IBM Administration Server userID.
 *   'adminPasswd': IBM Administration Server userID password.
 *   'adminProtocol': IBM Administration Server protocol.
 * The required parameters are found in the constructor.
 */
public class CreateWebServerByHostName extends Command {

	private String hostName;
	private String platform;
	private String webserverName;
	private String templateName;
	private Integer webPort = 80;
	private String webInstallRoot;
	private String pluginInstallRoot;
	private String configurationFile;
	private String serviceName;
	private String errorLogfile;
	private String accessLogfile;
	private String webProtocol = "HTTP";
	private String webAppMapping = "none";
	private Integer adminPort;
	private String adminUserID;
	private String adminPasswd;
	private String adminProtocol = "HTTP";

	public CreateWebServerByHostName(String hostName, String platform, String webserverName, String pluginInstallRoot) {
		super("createWebServerByHostName");
		this.hostName = hostName;
		this.platform = platform;
		this.webserverName = webserverName;
		this.pluginInstallRoot = pluginInstallRoot;
	}

	/**
	 * Specify the host name where the Web server is installed.
	 */
	public String getHostName() {
		return this.hostName;
	}

	/**
	 * Specify the host name where the Web server is installed.
	 */
	public void setHostName(String value) {
		this.hostName = value;
	}

	/**
	 * platformDesc
	 */
	public String getPlatform() {
		return this.platform;
	}

	/**
	 * platformDesc
	 */
	public void setPlatform(String value) {
		this.platform = value;
	}

	/**
	 * Specify the name for this Web server defintion.
	 */
	public String getWebserverName() {
		return this.webserverName;
	}

	/**
	 * Specify the name for this Web server defintion.
	 */
	public void setWebserverName(String value) {
		this.webserverName = value;
	}

	/**
	 * TemplateNameDesc
	 */
	public String getTemplateName() {
		return this.templateName;
	}

	/**
	 * TemplateNameDesc
	 */
	public void setTemplateName(String value) {
		this.templateName = value;
	}

	/**
	 * Web server Port.
	 */
	public Integer getWebPort() {
		return this.webPort;
	}

	/**
	 * Web server Port.
	 */
	public void setWebPort(Integer value) {
		this.webPort = value;
	}

	/**
	 * Install Root for Web server.
	 */
	public String getWebInstallRoot() {
		return this.webInstallRoot;
	}

	/**
	 * Install Root for Web server.
	 */
	public void setWebInstallRoot(String value) {
		this.webInstallRoot = value;
	}

	/**
	 * Plugin Install Root.
	 */
	public String getPluginInstallRoot() {
		return this.pluginInstallRoot;
	}

	/**
	 * Plugin Install Root.
	 */
	public void setPluginInstallRoot(String value) {
		this.pluginInstallRoot = value;
	}

	/**
	 * configurationFileDesc_2
	 */
	public String getConfigurationFile() {
		return this.configurationFile;
	}

	/**
	 * configurationFileDesc_2
	 */
	public void setConfigurationFile(String value) {
		this.configurationFile = value;
	}

	/**
	 * Windows ServiceName for starting IHS Web server as a Service.
	 */
	public String getServiceName() {
		return this.serviceName;
	}

	/**
	 * Windows ServiceName for starting IHS Web server as a Service.
	 */
	public void setServiceName(String value) {
		this.serviceName = value;
	}

	/**
	 * errorLogfileDesc_2
	 */
	public String getErrorLogfile() {
		return this.errorLogfile;
	}

	/**
	 * errorLogfileDesc_2
	 */
	public void setErrorLogfile(String value) {
		this.errorLogfile = value;
	}

	/**
	 * accessLogfileDesc_2
	 */
	public String getAccessLogfile() {
		return this.accessLogfile;
	}

	/**
	 * accessLogfileDesc_2
	 */
	public void setAccessLogfile(String value) {
		this.accessLogfile = value;
	}

	/**
	 * Web server protocol.
	 */
	public String getWebProtocol() {
		return this.webProtocol;
	}

	/**
	 * Web server protocol.
	 */
	public void setWebProtocol(String value) {
		this.webProtocol = value;
	}

	/**
	 * Web server application mapping.
	 */
	public String getWebAppMapping() {
		return this.webAppMapping;
	}

	/**
	 * Web server application mapping.
	 */
	public void setWebAppMapping(String value) {
		this.webAppMapping = value;
	}

	/**
	 * IBM Administration Server Port.
	 */
	public Integer getAdminPort() {
		return this.adminPort;
	}

	/**
	 * IBM Administration Server Port.
	 */
	public void setAdminPort(Integer value) {
		this.adminPort = value;
	}

	/**
	 * IBM Administration Server userID.
	 */
	public String getAdminUserID() {
		return this.adminUserID;
	}

	/**
	 * IBM Administration Server userID.
	 */
	public void setAdminUserID(String value) {
		this.adminUserID = value;
	}

	/**
	 * IBM Administration Server userID password.
	 */
	public String getAdminPasswd() {
		return this.adminPasswd;
	}

	/**
	 * IBM Administration Server userID password.
	 */
	public void setAdminPasswd(String value) {
		this.adminPasswd = value;
	}

	/**
	 * IBM Administration Server protocol.
	 */
	public String getAdminProtocol() {
		return this.adminProtocol;
	}

	/**
	 * IBM Administration Server protocol.
	 */
	public void setAdminProtocol(String value) {
		this.adminProtocol = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("hostName", this.hostName);
		ret.put("platform", this.platform);
		ret.put("webserverName", this.webserverName);
		if (this.templateName != null) {
			ret.put("templateName", this.templateName);
		}
		if (this.webPort != null) {
			ret.put("webPort", this.webPort);
		}
		if (this.webInstallRoot != null) {
			ret.put("webInstallRoot", this.webInstallRoot);
		}
		ret.put("pluginInstallRoot", this.pluginInstallRoot);
		if (this.configurationFile != null) {
			ret.put("configurationFile", this.configurationFile);
		}
		if (this.serviceName != null) {
			ret.put("serviceName", this.serviceName);
		}
		if (this.errorLogfile != null) {
			ret.put("errorLogfile", this.errorLogfile);
		}
		if (this.accessLogfile != null) {
			ret.put("accessLogfile", this.accessLogfile);
		}
		if (this.webProtocol != null) {
			ret.put("webProtocol", this.webProtocol);
		}
		if (this.webAppMapping != null) {
			ret.put("webAppMapping", this.webAppMapping);
		}
		if (this.adminPort != null) {
			ret.put("adminPort", this.adminPort);
		}
		if (this.adminUserID != null) {
			ret.put("adminUserID", this.adminUserID);
		}
		if (this.adminPasswd != null) {
			ret.put("adminPasswd", this.adminPasswd);
		}
		if (this.adminProtocol != null) {
			ret.put("adminProtocol", this.adminProtocol);
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
