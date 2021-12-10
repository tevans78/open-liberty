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

package com.ibm.websphere.simplicity.commands.server;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;
import java.util.ArrayList;
import com.ibm.websphere.simplicity.commands.CommandStep;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Command that creates a server
 *   'name': The Server Name
 *   'templateName': The Template Name
 *   'genUniquePorts': Parameter to generate unique http ports for a server.
 *   'templateLocation': The location where the template is stored. Use system defined location if it is not specified. Using system defined location is recommended.
 *   'specificShortName': The server specific short name is applicable only on zOS platforms. This represents the specific short name of the server. All servers should have unique specific short name. This parameter is optional and when it is not specified a unique specific short name is automatically assigned. The value should be 8 chars or less and all upper case.
 *   'genericShortName': The server generic short name is applicable only on zOS platforms. This represents the generic short name of the server. All members of a cluster should share the same generic short name. Individual servers should have unique generic short name. This parameter is optional and when it is not specified a unique generic short name is automatically assigned. The value should be 8 chars or less and all upper case.
 *   'clusterName': clusterName
 *   'bitmode': bitmode
 * The required parameters are found in the constructor.
 */
public class CreateWebServer extends Command {

	private String __target;
	private List<Command> __steps;
	private String name;
	private String templateName;
	private Boolean genUniquePorts = true;
	private com.ibm.websphere.simplicity.ConfigIdentifier templateLocation;
	private String specificShortName;
	private String genericShortName;
	private String clusterName;
	private String bitmode;

	public CreateWebServer(String commandTarget, String name) {
		super("createWebServer");
		this.__target = commandTarget;
		this.name = name;
	}

	/**
	 * The Server Name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The Server Name
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * The Template Name
	 */
	public String getTemplateName() {
		return this.templateName;
	}

	/**
	 * The Template Name
	 */
	public void setTemplateName(String value) {
		this.templateName = value;
	}

	/**
	 * Parameter to generate unique http ports for a server.
	 */
	public Boolean getGenUniquePorts() {
		return this.genUniquePorts;
	}

	/**
	 * Parameter to generate unique http ports for a server.
	 */
	public void setGenUniquePorts(Boolean value) {
		this.genUniquePorts = value;
	}

	/**
	 * The location where the template is stored. Use system defined location if it is not specified. Using system defined location is recommended.
	 */
	public com.ibm.websphere.simplicity.ConfigIdentifier getTemplateLocation() {
		return this.templateLocation;
	}

	/**
	 * The location where the template is stored. Use system defined location if it is not specified. Using system defined location is recommended.
	 */
	public void setTemplateLocation(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.templateLocation = value;
	}

	/**
	 * The server specific short name is applicable only on zOS platforms. This represents the specific short name of the server. All servers should have unique specific short name. This parameter is optional and when it is not specified a unique specific short name is automatically assigned. The value should be 8 chars or less and all upper case.
	 */
	public String getSpecificShortName() {
		return this.specificShortName;
	}

	/**
	 * The server specific short name is applicable only on zOS platforms. This represents the specific short name of the server. All servers should have unique specific short name. This parameter is optional and when it is not specified a unique specific short name is automatically assigned. The value should be 8 chars or less and all upper case.
	 */
	public void setSpecificShortName(String value) {
		this.specificShortName = value;
	}

	/**
	 * The server generic short name is applicable only on zOS platforms. This represents the generic short name of the server. All members of a cluster should share the same generic short name. Individual servers should have unique generic short name. This parameter is optional and when it is not specified a unique generic short name is automatically assigned. The value should be 8 chars or less and all upper case.
	 */
	public String getGenericShortName() {
		return this.genericShortName;
	}

	/**
	 * The server generic short name is applicable only on zOS platforms. This represents the generic short name of the server. All members of a cluster should share the same generic short name. Individual servers should have unique generic short name. This parameter is optional and when it is not specified a unique generic short name is automatically assigned. The value should be 8 chars or less and all upper case.
	 */
	public void setGenericShortName(String value) {
		this.genericShortName = value;
	}

	/**
	 * clusterName
	 */
	public String getClusterName() {
		return this.clusterName;
	}

	/**
	 * clusterName
	 */
	public void setClusterName(String value) {
		this.clusterName = value;
	}

	/**
	 * bitmode
	 */
	public String getBitmode() {
		return this.bitmode;
	}

	/**
	 * bitmode
	 */
	public void setBitmode(String value) {
		this.bitmode = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(String value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("name", this.name);
		if (this.templateName != null) {
			ret.put("templateName", this.templateName);
		}
		if (this.genUniquePorts != null) {
			ret.put("genUniquePorts", this.genUniquePorts);
		}
		if (this.templateLocation != null) {
			ret.put("templateLocation", this.templateLocation);
		}
		if (this.specificShortName != null) {
			ret.put("specificShortName", this.specificShortName);
		}
		if (this.genericShortName != null) {
			ret.put("genericShortName", this.genericShortName);
		}
		if (this.clusterName != null) {
			ret.put("clusterName", this.clusterName);
		}
		if (this.bitmode != null) {
			ret.put("bitmode", this.bitmode);
		}
		return ret;
	}

	public Object __getTarget() {
		return this.__target;
	}

	public List<Command> __getSteps() {
		return this.__steps;
	}

	/**
	 * Executes the command against the specified scope.
	 * Steps are required by this command, and they appear after the scope parameter.
	 * Classes for these steps are statically available through this admin command class.
	 */
	public OperationResults<Object> run(Scope scope, ServerConfig serverConfig, RemoteServerConfig remoteServerConfig) throws Exception {
		this.__steps = new ArrayList<Command>();
		if (serverConfig != null)
			this.__steps.add(serverConfig);
		if (remoteServerConfig != null)
			this.__steps.add(remoteServerConfig);
		return super.run(scope);
	}

	/**
	 * Specify the configuration properties for IBM HTTP Server.
	 *   'webPort': Web server Port.
	 *   'webInstallRoot': Install Root for Web server.
	 *   'pluginInstallRoot': Plugin Install Root.
	 *   'configurationFile': configurationFileDesc_2
	 *   'serviceName': Windows ServiceName for starting IHS Web server as a Service.
	 *   'errorLogfile': errorLogfileDesc_2
	 *   'accessLogfile': accessLogfileDesc_2
	 *   'webProtocol': Web server protocol.
	 *   'webAppMapping': Web server application mapping.
	 * The required parameters are found in the constructor.
	 */
	public static class ServerConfig extends CommandStep {

		private Integer webPort = 80;
		private String webInstallRoot;
		private String pluginInstallRoot;
		private String configurationFile;
		private String serviceName;
		private String errorLogfile;
		private String accessLogfile;
		private String webProtocol = "HTTP";
		private String webAppMapping = "none";

		public ServerConfig() {
			super("serverConfig");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			if (this.webPort != null) {
				ret.put("webPort", this.webPort);
			}
			if (this.webInstallRoot != null) {
				ret.put("webInstallRoot", this.webInstallRoot);
			}
			if (this.pluginInstallRoot != null) {
				ret.put("pluginInstallRoot", this.pluginInstallRoot);
			}
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
			return ret;
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

	}
	/**
	 * Specified the configuration properties for IBM Adminstration Server.
	 *   'adminPort': IBM Administration Server Port.
	 *   'adminUserID': IBM Administration Server userID.
	 *   'adminPasswd': IBM Administration Server userID password.
	 *   'adminProtocol': IBM Administration Server protocol.
	 * The required parameters are found in the constructor.
	 */
	public static class RemoteServerConfig extends CommandStep {

		private Integer adminPort;
		private String adminUserID;
		private String adminPasswd;
		private String adminProtocol = "HTTP";

		public RemoteServerConfig() {
			super("remoteServerConfig");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
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

	}
}
