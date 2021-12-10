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

package com.ibm.websphere.simplicity.server;

import com.ibm.websphere.simplicity.ConfigIdentifier;

public class WebServerCreationOptions {

	/**
	 * Specifies the Web server definition properties.
	 */
	public static enum WebProtocol {
		HTTP,
		HTTPS;
	}
    
    /**
     * Valid template names for a web server
     */
    public static enum Template {
        IHS ("IHS"),
        IPLANET ("iPlanet"),
        IIS ("IIS"),
        DOMINO ("DOMINO"),
        APACHE ("APACHE");
        
        private String templateName;
        
        private Template(String templateName) {
            this.templateName = templateName;
        }
        
        public String getTemplateName() {
            return this.templateName;
        }
    }
	
	/**
	 * Specifies the Web server definition properties. All fields in this class are required.
	 */
	public static class ServerConfig {
		
		private Integer webPort;
		private String webInstallRoot;
		private String pluginInstallRoot;
		private String configurationFile;
		private String serviceName;
		private String errorLogfile;
		private String accessLogfile;
		private WebProtocol webProtocol;
		private String webAppMapping;

		/**
		 * 
		 * @param webPort Specifies the port number of the Web server.
		 * @param webInstallRoot Specifies the install path directory for the Web server. This option is required for IBM HTTP Server Admin Function.
		 * @param pluginInstallRoot Specifies the installation root directory where the plugin for the Web server is installed.
		 * @param configurationFile Specifies the file path for the IBM HTTP Server. This option is required for view and edit of the IBM HTTP Server Configuration file only.
		 * @param serviceName Specifies the windows service name on which to start the IBM HTTP Server. This option is required for start and stop of the IBM HTTP Server Web server only.
		 * @param errorLogfile Specifies the path for the IBM HTTP Server error log (error.log).
		 * @param accessLogfile Specifies the path for the IBM HTTP Server access log (access.log).
		 * @param webProtocol Specifies the IBM HTTP Server administration server running with an unmanaged or remote Web server. Options include HTTP or HTTPS. The default is HTTP.
		 * @param webAppMapping Specifies configuration information for Web application mapping.
		 */
		public ServerConfig(int webPort, String webInstallRoot, String pluginInstallRoot, String configurationFile, String serviceName, String errorLogfile, String accessLogfile, WebProtocol webProtocol, String webAppMapping) {
			this.webPort = webPort;
			this.webInstallRoot = webInstallRoot;
			this.pluginInstallRoot = pluginInstallRoot;
			this.configurationFile = configurationFile;
			this.serviceName = serviceName;
			this.errorLogfile = errorLogfile;
			this.accessLogfile = accessLogfile;
			this.webProtocol = webProtocol;
			this.webAppMapping = webAppMapping;
		}

		/**
		 * Specifies the port number of the Web server.
		 * @return The port number
		 */
		public Integer getWebPort() {
			return webPort;
		}

		/**
		 * Specifies the port number of the Web server.
		 * @param webPort
		 */
		public void setWebPort(int webPort) {
			this.webPort = webPort;
		}

		/**
		 * Specifies the install path directory for the Web server.
		 * @return The install root
		 */
		public String getWebInstallRoot() {
			return webInstallRoot;
		}

		/**
		 * Specifies the install path directory for the Web server.
		 * @param webInstallRoot
		 */
		public void setWebInstallRoot(String webInstallRoot) {
			this.webInstallRoot = webInstallRoot;
		}

		/**
		 * Specifies the installation root directory where the plugin for the Web server is installed.
		 * @return The pluging install root
		 */
		public String getPluginInstallRoot() {
			return pluginInstallRoot;
		}

		/**
		 * Specifies the installation root directory where the plugin for the Web server is installed.
		 * @param pluginInstallRoot
		 */
		public void setPluginInstallRoot(String pluginInstallRoot) {
			this.pluginInstallRoot = pluginInstallRoot;
		}

		/**
		 * Specifies the file path for the IBM HTTP Server.
		 * @return The file path
		 */
		public String getConfigurationFile() {
			return configurationFile;
		}

		/**
		 * Specifies the file path for the IBM HTTP Server.
		 * @param configurationFile
		 */
		public void setConfigurationFile(String configurationFile) {
			this.configurationFile = configurationFile;
		}

		/**
		 * Specifies the windows service name on which to start the IBM HTTP Server.
		 * @return The windows service name
		 */
		public String getServiceName() {
			return serviceName;
		}

		/**
		 * Specifies the windows service name on which to start the IBM HTTP Server.
		 * @param serviceName
		 */
		public void setServiceName(String serviceName) {
			this.serviceName = serviceName;
		}

		/**
		 * Specifies the path for the IBM HTTP Server error log (error.log).
		 * @return The error log path
		 */
		public String getErrorLogfile() {
			return errorLogfile;
		}

		/**
		 * Specifies the path for the IBM HTTP Server error log (error.log).
		 * @param errorLogfile
		 */
		public void setErrorLogfile(String errorLogfile) {
			this.errorLogfile = errorLogfile;
		}

		/**
		 * Specifies the path for the IBM HTTP Server access log (access.log).
		 * @return The access log path
		 */
		public String getAccessLogfile() {
			return accessLogfile;
		}

		/**
		 * Specifies the path for the IBM HTTP Server access log (access.log).
		 * @param accessLogfile
		 */
		public void setAccessLogfile(String accessLogfile) {
			this.accessLogfile = accessLogfile;
		}

		/**
		 * Specifies the IBM HTTP Server administration server running with an unmanaged or remote Web server. Options include HTTP or HTTPS. The default is HTTP.
		 * @return The web protocol
		 */
		public WebProtocol getWebProtocol() {
			return webProtocol;
		}

		/**
		 * Specifies the IBM HTTP Server administration server running with an unmanaged or remote Web server. Options include HTTP or HTTPS. The default is HTTP.
		 * @param webProtocol
		 */
		public void setWebProtocol(WebProtocol webProtocol) {
			this.webProtocol = webProtocol;
		}

		/**
		 * Specifies configuration information for Web application mapping.
		 * @return The web mapping configuration
		 */
		public String getWebAppMapping() {
			return webAppMapping;
		}

		/**
		 * Specifies configuration information for Web application mapping.
		 * @param webAppMapping
		 */
		public void setWebAppMapping(String webAppMapping) {
			this.webAppMapping = webAppMapping;
		}
		
	}
	
	/**
	 * Specifies additional Web server definition properties that are only necessary if 
	 * the IBM HTTP Server Web server is installed on a machine remote from the application 
	 * server.
	 */
	public static class RemoteServerConfig {
		
		private Integer adminPort;
		private WebProtocol adminProtocol;
		private String userID;
		private String password;
		
		/**
		 * 
		 * @param adminPort Specifies the port of the IBM HTTP Server administrative server. The administration server is installed on the same machine as the IBM HTTP Server and handles administrative requests to the IBM HTTP Server Web server.
		 * @param adminProtocol Specifies the administrative protocol title. Options include HTTP or HTTPS. The default is HTTP.
		 */
		public RemoteServerConfig(int adminPort, WebProtocol adminProtocol) {
			this(adminPort, adminProtocol, null, null);
		}
		
		/**
		 * 
		 * @param adminPort Specifies the port of the IBM HTTP Server administrative server. The administration server is installed on the same machine as the IBM HTTP Server and handles administrative requests to the IBM HTTP Server Web server.
		 * @param adminProtocol Specifies the administrative protocol title. Options include HTTP or HTTPS. The default is HTTP.
		 * @param userID Specifies the user ID, if authentication is activated on the Administration server in the admin configuration file (admin.conf). This value should match the authentication in the admin.conf file.
		 * @param password Specifies the password for the user ID. The password is generated by the htpasswd utility in the admin.passwd file.
		 */
		public RemoteServerConfig(int adminPort, WebProtocol adminProtocol, String userID, String password) {
			this.adminPort = adminPort;
			this.adminProtocol = adminProtocol;
			this.userID = userID;
			this.password = password;
		}

		/**
		 * Specifies the port of the IBM HTTP Server administrative server. The administration server is installed on the same machine as the IBM HTTP Server and handles administrative requests to the IBM HTTP Server Web server.
		 * @return The admin port
		 */
		public Integer getAdminPort() {
			return adminPort;
		}

		/**
		 * Specifies the port of the IBM HTTP Server administrative server. The administration server is installed on the same machine as the IBM HTTP Server and handles administrative requests to the IBM HTTP Server Web server.
		 * @param adminPort
		 */
		public void setAdminPort(int adminPort) {
			this.adminPort = adminPort;
		}

		/**
		 * Specifies the administrative protocol title. Options include HTTP or HTTPS. The default is HTTP.
		 * @return The admin protocol
		 */ 
		public WebProtocol getAdminProtocol() {
			return adminProtocol;
		}

		/**
		 * Specifies the administrative protocol title. Options include HTTP or HTTPS. The default is HTTP.
		 * @param adminProtocol
		 */
		public void setAdminProtocol(WebProtocol adminProtocol) {
			this.adminProtocol = adminProtocol;
		}

		/**
		 * Specifies the user ID, if authentication is activated on the Administration server in the admin configuration file (admin.conf). This value should match the authentication in the admin.conf file.
		 * @return The user ID
		 */
		public String getUserID() {
			return userID;
		}

		/**
		 * Specifies the user ID, if authentication is activated on the Administration server in the admin configuration file (admin.conf). This value should match the authentication in the admin.conf file.
		 * @param userID
		 */
		public void setUserID(String userID) {
			this.userID = userID;
		}

		/**
		 * Specifies the password for the user ID. The password is generated by the htpasswd utility in the admin.passwd file.
		 * @return The password
		 */
		public String getPassword() {
			return password;
		}

		/**
		 * Specifies the password for the user ID. The password is generated by the htpasswd utility in the admin.passwd file.
		 * @param password
		 */
		public void setPassword(String password) {
			this.password = password;
		}
		
	}
	
	private String name;
    private Template templateName;
    private Boolean genUniquePorts;
    private ConfigIdentifier templateLocation;
    private String clusterName;
	private ServerConfig serverConfig;
	private RemoteServerConfig remoteServerConfig;
    
	
	/**
	 * 
	 * @param name Specifies the name of the server.
	 * @param serverConfig Specifies the Web server definition properties.
	 * @param remoteServerConfig Specifies additional Web server definition properties that are only necessary if the IBM HTTP Server Web server is installed on a machine remote from the application server.

	 */
	public WebServerCreationOptions(String name, ServerConfig serverConfig, RemoteServerConfig remoteServerConfig) {
		this.name = name;
		this.serverConfig = serverConfig;
		this.remoteServerConfig = remoteServerConfig;
	}

	/**
	 * Specifies the name of the server.
	 * @return The server name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Specifies the name of the server.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Specifies the Web server definition properties.
	 * @return The server config properties
	 */
	public ServerConfig getServerConfig() {
		return serverConfig;
	}

	/**
	 * Specifies the Web server definition properties.
	 * @param serverConfig
	 */
	public void setServerConfig(ServerConfig serverConfig) {
		this.serverConfig = serverConfig;
	}

	/**
	 * Specifies additional Web server definition properties that are only necessary if 
	 * the IBM HTTP Server Web server is installed on a machine remote from the application 
	 * server.
	 * @return The remote server config properties
	 */
	public RemoteServerConfig getRemoteServerConfig() {
		return remoteServerConfig;
	}

	/**
	 * Specifies additional Web server definition properties that are only necessary if 
	 * the IBM HTTP Server Web server is installed on a machine remote from the application 
	 * server.
	 * @param remoteServerConfig
	 */
	public void setRemoteServerConfig(RemoteServerConfig remoteServerConfig) {
		this.remoteServerConfig = remoteServerConfig;
	}

    /**
     * Specifies the cluster of interest.
     * @return The cluster
     */
    public String getClusterName() {
        return clusterName;
    }

    /**
     * Specifies the cluster of interest.
     * @param clusterName
     */
    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    /**
     * Specifies whether the system generates unique HTTP ports for the server. The default value is true. Specify false if you do not want to generate unique HTTP ports for the server.
     * @return true to generate unique ports
     */
    public Boolean getGenUniquePorts() {
        return genUniquePorts;
    }

    /**
     * Specifies whether the system generates unique HTTP ports for the server. The default value is true. Specify false if you do not want to generate unique HTTP ports for the server.
     * @param genUniquePorts
     */
    public void setGenUniquePorts(Boolean genUniquePorts) {
        this.genUniquePorts = genUniquePorts;
    }

    /**
     * The configuration Id that represents the location of a template. Specify the _Websphere_Config_Data_Id=templates/servertypes/WEB_SERVER|servertype-metadata.xml configuration Id to create a generic server.
     * @return The config ID of the template
     */
    public ConfigIdentifier getTemplateLocation() {
        return templateLocation;
    }

    /**
     * The configuration Id that represents the location of a template. Specify the _Websphere_Config_Data_Id=templates/servertypes/WEB_SERVER|servertype-metadata.xml configuration Id to create a generic server.
     * @param templateLocation
     */
    public void setTemplateLocation(ConfigIdentifier templateLocation) {
        this.templateLocation = templateLocation;
    }

    /**
     * Specifies the name of the template that you want to use. Templates include the following: IHS, iPlanet, IIS, DOMINO, APACHE. The default template is IHS.
     * @return The template name
     */
    public Template getTemplateName() {
        return templateName;
    }

    /**
     * Specifies the name of the template that you want to use. Templates include the following: IHS, iPlanet, IIS, DOMINO, APACHE. The default template is IHS.
     * @param templateName
     */
    public void setTemplateName(Template templateName) {
        this.templateName = templateName;
    }
	
}
