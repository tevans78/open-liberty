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

package com.ibm.websphere.simplicity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.management.Attribute;
import javax.management.AttributeList;

import com.ibm.websphere.simplicity.commands.managedobjectmetadata.GetMetadataProperties;
import com.ibm.websphere.simplicity.commands.managedobjectmetadata.GetNodeBaseProductVersion;
import com.ibm.websphere.simplicity.commands.server.CreateApplicationServer;
import com.ibm.websphere.simplicity.commands.server.CreateProxyServer;
import com.ibm.websphere.simplicity.commands.server.CreateWebServer;
import com.ibm.websphere.simplicity.commands.server.DeleteServer;
import com.ibm.websphere.simplicity.commands.server.CreateProxyServer.ConfigCoreGroup;
import com.ibm.websphere.simplicity.commands.server.CreateProxyServer.SelectProtocols;
import com.ibm.websphere.simplicity.commands.server.CreateWebServer.RemoteServerConfig;
import com.ibm.websphere.simplicity.commands.server.CreateWebServer.ServerConfig;
import com.ibm.websphere.simplicity.config.Configurable;
import com.ibm.websphere.simplicity.configuration.ConfigurationProvider;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.product.InstallationType;
import com.ibm.websphere.simplicity.product.InstalledWASProduct;
import com.ibm.websphere.simplicity.product.WASInstallation;
import com.ibm.websphere.simplicity.product.InstalledWASProduct.WASProductID;
import com.ibm.websphere.simplicity.provider.ConfigType;
import com.ibm.websphere.simplicity.provider.NodeMetadataProperties;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;
import com.ibm.websphere.simplicity.provider.websphere.ConfigurationOperationsProvider;
import com.ibm.websphere.simplicity.server.AppServerCreationOptions;
import com.ibm.websphere.simplicity.server.ProxyServerCreationOptions;
import com.ibm.websphere.simplicity.server.WebServerCreationOptions;
import com.ibm.websphere.simplicity.util.CollectionUtility;

/**
 * This class represents a WebSphere node. A Node is a logical grouping of
 * application servers. A Node instance of {@link Scope} has visibility to the
 * servers within it.
 */
public class Node extends Scope implements Configurable {

    private static Class<?>          c                  = Node.class;
    protected static final String    CHANGE_KEY_SERVERS = "servers";

    protected String                 alias;                          // job mgr
    protected String                 registeredNodeName;             // admin
    // agent
    private Set<Server>              servers;
    private Machine                  machine;
    private WASInstallation          install;
    private String                   configPath;
    private String                   profilePath;
    private WebSphereVersion         baseProductVersion;
    private Set<InstalledWASProduct> installedProducts;
    private String                   profileName;
    private Cell                     adminAgentCell;
    private Cell                     jobMgrCell;

    /**
     * Nodes can only be created by instances of {@link Cell} and
     * {@link Topology}.
     * 
     * @param configId The {@link ConfigIdentifier} for this node
     * @param cell The instance of {@link Cell} representing the cell to which
     *            this node belongs.
     */
    protected Node(ConfigIdentifier configId, Cell cell) throws Exception {
        super(configId, cell, cell);
        if (!Topology.isTopologyCachingEnabled() || !Topology.getBootstrapFileOps()
            .cacheComplete(getCell().getBootstrapFileKey()))
            getProfileDir();
    }

    @Override
    public String getObjectNameFragment() {
        return this.cell.getObjectNameFragment() + ",node=" + this.name;
    }

    @Override
    public ScopeHelper getScopeHelper() {
        return new ScopeHelper(this);
    }

    @Override
    public String getConfigPath() throws Exception {
        if (this.configPath == null) {
            this.configPath = expandString(this.cell.getConfigPath() + "nodes/" + this.name + "/");
        }
        return this.configPath;
    }

    protected void setConfigPath(String path) {
        this.configPath = path;
    }

    /**
     * Create a new application server within this node.
     * 
     * @param options The options to use when creating the app server
     * @return An {@link OperationResults} containing the new
     *         {@link ApplicationServer} for the result
     * @throws Exception
     */
    public OperationResults<ApplicationServer> createApplicationServer(AppServerCreationOptions options)
        throws Exception {
        final String method = "createApplicationServer";
        Log.entering(c, method, options);

        if (options == null) {
            throw new IllegalArgumentException("options cannot be null.");
        }
        if (options.getServerName() == null || options.getServerName().length() < 1) {
            throw new IllegalArgumentException("Server name must be specified in options.");
        }
        if (getServerByName(options.getServerName()) != null) {
            throw new IllegalArgumentException("Server with name " + options.getServerName()
                + " already exists.");
        }

        getWorkspace().registerConfigChange(this, CHANGE_KEY_SERVERS, getServers());

        Log.finer(c, method, "Creating application server in WAS.");
        CreateApplicationServer task =
            new CreateApplicationServer(this.getName(), options.getServerName());
        task.setGenUniquePorts(options.getGenUniquePorts());
        Object result = task.run(this, null, null, null);
        OperationResults<ConfigIdentifier> configId =
            OperationsProviderFactory.getProvider().getNodeOperationsProvider()
                .createApplicationServer(result);
        ApplicationServer appServer = null;
        OperationResults<ApplicationServer> results = new OperationResults<ApplicationServer>();
        OperationResults.setOperationResults(results, configId);
        appServer =
            new ApplicationServer(configId.getResult(), this.getCell(), this,
                                  ServerType.APPLICATION_SERVER, null);
        results.setResult(appServer);
        Log.finer(c, method, "Creating application server in the Object model.");
        this.addServer(appServer);

        if (Topology.isTopologyCachingEnabled()) {
            Log.finer(c, method, "Rewriting cache with new server.");
            Topology.getBootstrapFileOps().cache(this.getCell());
        }
        Log.exiting(c, method, configId.isSuccess());
        return results;
    }

    /**
     * Create a new web server within this node
     * 
     * @param options The options to use to create the new web server
     * @return An {@link OperationResults} containing the new {@link WebServer}
     *         for the result
     * @throws Exception
     */
    public OperationResults<WebServer> createWebServer(WebServerCreationOptions options)
        throws Exception {
        final String method = "createWebServer";
        Log.entering(c, method, options);

        if (options == null) {
            throw new IllegalArgumentException("options cannot be null.");
        }
        if (options.getName() == null || options.getName().length() < 1) {
            throw new IllegalArgumentException("Server name must be specified in options.");
        }
        if (getServerByName(options.getName()) != null) {
            throw new IllegalArgumentException("Server with name " + options.getName()
                + " already exists.");
        }

        getWorkspace().registerConfigChange(this, CHANGE_KEY_SERVERS, getServers());

        CreateWebServer task = new CreateWebServer(this.getName(), options.getName());
        ServerConfig serverCfg = null;
        RemoteServerConfig remoteServerCfg = null;
        if (options.getServerConfig() != null) {
            serverCfg = new CreateWebServer.ServerConfig();
            com.ibm.websphere.simplicity.server.WebServerCreationOptions.ServerConfig ops =
                options.getServerConfig();
            if (ops.getAccessLogfile() != null)
                serverCfg.setAccessLogfile(ops.getAccessLogfile());
            if (ops.getConfigurationFile() != null)
                serverCfg.setConfigurationFile(ops.getConfigurationFile());
            if (ops.getErrorLogfile() != null)
                serverCfg.setErrorLogfile(ops.getErrorLogfile());
            if (ops.getPluginInstallRoot() != null)
                serverCfg.setPluginInstallRoot(ops.getPluginInstallRoot());
            if (ops.getServiceName() != null)
                serverCfg.setServiceName(ops.getServiceName());
            if (ops.getWebAppMapping() != null)
                serverCfg.setWebAppMapping(ops.getWebAppMapping());
            if (ops.getWebInstallRoot() != null)
                serverCfg.setWebInstallRoot(ops.getWebInstallRoot());
            if (ops.getWebPort() != null)
                serverCfg.setWebPort(ops.getWebPort());
            if (ops.getWebProtocol() != null)
                serverCfg.setWebProtocol(ops.getWebProtocol().toString());
        }
        if (options.getRemoteServerConfig() != null) {
            remoteServerCfg = new CreateWebServer.RemoteServerConfig();
            com.ibm.websphere.simplicity.server.WebServerCreationOptions.RemoteServerConfig ops =
                options.getRemoteServerConfig();
            if (ops.getAdminPort() != null)
                remoteServerCfg.setAdminPort(ops.getAdminPort());
            if (ops.getAdminProtocol() != null)
                remoteServerCfg.setAdminProtocol(ops.getAdminProtocol().toString());
            if (ops.getPassword() != null)
                remoteServerCfg.setAdminPasswd(ops.getPassword());
            if (ops.getUserID() != null)
                remoteServerCfg.setAdminUserID(ops.getUserID());
        }
        if (options.getClusterName() != null)
            task.setClusterName(options.getClusterName());
        if (options.getGenUniquePorts() != null)
            task.setGenUniquePorts(options.getGenUniquePorts());
        if (options.getTemplateLocation() != null)
            task.setTemplateLocation(options.getTemplateLocation());
        if (options.getTemplateName() != null)
            task.setTemplateName(options.getTemplateName().getTemplateName());
        OperationResults<Object> results = task.run(this, serverCfg, remoteServerCfg);

        ConfigIdentifier configId =
            OperationsProviderFactory.getProvider().getNodeOperationsProvider()
                .convertIdToConfigIdentifier(results.getResult());
        WebServer webserver = new WebServer(configId, this.getCell(), this, null);
        OperationResults<WebServer> ret = new OperationResults<WebServer>();
        OperationResults.setOperationResults(ret, results);
        ret.setResult(webserver);
        this.addServer(webserver);

        if (Topology.isTopologyCachingEnabled()) {
            Log.finer(c, method, "Rewriting cache with new server.");
            Topology.getBootstrapFileOps().cache(this.getCell());
        }

        Log.exiting(c, method, ret);
        return ret;
    }

    /**
     * Create a new proxy server within this node.
     * 
     * @param options The options to use when creating the proxy server
     * @return An {@link OperationResults} containing the new
     *         {@link ProxyServer} for the result
     * @throws Exception
     */
    public OperationResults<ProxyServer> createProxyServer(ProxyServerCreationOptions options)
        throws Exception {
        final String method = "createProxyServer";
        Log.entering(c, method, options);

        if (options == null) {
            throw new IllegalArgumentException("options cannot be null.");
        }
        if (options.getServerName() == null || options.getServerName().length() < 1) {
            throw new IllegalArgumentException("Server name must be specified in options.");
        }
        if (getServerByName(options.getServerName()) != null) {
            throw new IllegalArgumentException("Server with name " + options.getServerName()
                + " already exists.");
        }

        getWorkspace().registerConfigChange(this, CHANGE_KEY_SERVERS, getServers());

        Log.finer(c, method, "Creating a proxy server in WAS.");
        CreateProxyServer task = new CreateProxyServer(this.getName(), options.getServerName());
        task.setGenUniquePorts(options.getGenUniquePorts());
        ConfigCoreGroup cfgCoreGroup = null;
        if (options.getConfigCoreGroup() != null) {
            cfgCoreGroup = new ConfigCoreGroup();
            cfgCoreGroup.setCoregroupName(options.getConfigCoreGroup().getCoreGroupName());
        }
        SelectProtocols selectProtocols = null;
        if (options.getSelectProtocols() != null) {
            selectProtocols = new SelectProtocols();
            selectProtocols
                .setList(options.getSelectProtocols().getList().toArray(new String[] {}));
        }
        Object result = task.run(this, cfgCoreGroup, selectProtocols, null, null, null);
        OperationResults<ConfigIdentifier> configId =
            OperationsProviderFactory.getProvider().getNodeOperationsProvider()
                .createApplicationServer(result);
        ProxyServer proxyServer = null;
        OperationResults<ProxyServer> results = new OperationResults<ProxyServer>();
        OperationResults.setOperationResults(results, configId);
        proxyServer = new ProxyServer(configId.getResult(), this.getCell(), this, null);
        results.setResult(proxyServer);
        Log.finer(c, method, "Creating proxy server in the Object model.");
        this.addServer(proxyServer);

        if (Topology.isTopologyCachingEnabled()) {
            Log.finer(c, method, "Rewriting cache with new server.");
            Topology.getBootstrapFileOps().cache(this.getCell());
        }
        Log.exiting(c, method, configId.isSuccess());
        return results;
    }

    /**
     * Delete a {@link Server} from the WAS configuration.
     * 
     * @param serverName The name of the server to delete
     * @throws Exception
     */
    public void deleteServer(String serverName) throws Exception {
        final String method = "deleteServer";
        Log.entering(c, method, serverName);

        if (serverName == null || serverName.length() < 1) {
            throw new IllegalArgumentException("Server name cannot be null or empty.");
        }
        Server server = this.getServerByName(serverName);
        if (server == null) {
            throw new IllegalArgumentException("A server with name " + serverName
                + " does not exist.");
        }

        getWorkspace().registerConfigChange(this, CHANGE_KEY_SERVERS, getServers());

        Log.finer(c, method, "Deleting the server.");
        DeleteServer task = new DeleteServer(serverName, this.getName());
        task.run(this, null, null);
        Log.finer(c, method, "Removing server from Object model.");
        this.removeServer(server);
        Log.finer(c, method, "Server is removed from Object model: " + (this
            .getServerByName(serverName) == null));

        if (Topology.isTopologyCachingEnabled()) {
            Log.finer(c, method, "Rewriting cache with server removed.");
            Topology.getBootstrapFileOps().cache(this.getCell());
        }

        Log.exiting(c, method);
    }

    /**
     * Get the name of the {@link Cell} to which this Node belongs
     * 
     * @return The name of the Node's {@link Cell}
     */
    public String getCellName() {
        return this.cell.getName();
    }

    /**
     * Get the {@link Server}s that exist in this Node
     * 
     * @return A Set of {@link Server}s in the this Node
     * @throws Exception
     */
    public Set<Server> getServers() throws Exception {
        final String method = "getServers";
        Log.entering(c, method);
        if (this.servers == null) {
            Log.finer(c, method, "Initializing servers");
            if (!Topology.isTopologyCachingEnabled() || !Topology.getBootstrapFileOps()
                .cacheComplete(getCell().getBootstrapFileKey())) {
                Log.finer(c, method, "Loading servers.");
                loadServers();
            } else {
                Log.finer(c, method, "No servers exist for this node. Creating an empty set.");
                this.servers = new HashSet<Server>();
            }
        }
        Log.exiting(c, method, this.servers);
        return new HashSet<Server>(this.servers);
    }

    /**
     * Get a sorted List of Servers in the Cell
     * 
     * @param c The Comparator that defines how to sort the Servers
     * @return A List containing the sorted Servers
     * @throws Exception
     */
    public List<Server> getServers(Comparator<Server> c) throws Exception {
        return CollectionUtility.sort(getServers(), c);
    }

    /**
     * This method returns the {@link WASInstallation} representation of the
     * installation under which this Node resides. Information such as installed
     * products and build level can be obtained from the {@link WASInstallation}
     * class.
     * 
     * @return The {@link WASInstallation} of this Node
     */
    public WASInstallation getWASInstall() throws Exception {
        final String method = "getWASInstall";
        Log.entering(c, method);
        if (this.install == null) {
            Log.finer(c, method, "Initializing install.");
            String installRoot =
                OperationsProviderFactory.getProvider().getConfigurationOperationsProvider()
                    .expandVariable(this,
                                    VariableType.WAS_INSTALL_ROOT.getValue(),
                                    this.getActiveSession());
            Log.finer(c, method, "installRoot: " + installRoot);
            if (installRoot == null) {
                Log
                    .finer(c,
                           method,
                           "Could not find the install root using variable type " + VariableType.WAS_INSTALL_ROOT
                               + ". Trying with "
                               + VariableType.WAS_HOME);
                installRoot =
                    OperationsProviderFactory.getProvider().getConfigurationOperationsProvider()
                        .expandVariable(this,
                                        VariableType.WAS_HOME.getValue(),
                                        this.getActiveSession());
                Log.finer(c, method, "installRoot: " + installRoot);
            }
            this.install =
                (WASInstallation)WASInstallation.getInstall(getMachine(),
                                                            installRoot,
                                                            InstallationType.WAS_INSTALL);
            this.install.addNode(this);
        }
        Log.exiting(c, method, this.install);
        return this.install;
    }

    protected void setWASInstall(WASInstallation install) {
        this.install = install;
    }

    protected void setBaseProductVersion(WebSphereVersion version) {
        this.baseProductVersion = version;
    }

    /**
     * Get a specific {@link Server} in this Node that has the specified name
     * 
     * @param name The name of the {@link Server} to get
     * @return The existing {@link Server} in this cell that has the specified
     *         name or null if no {@link Server} in the node exists with the
     *         name
     * @throws Exception
     */
    public Server getServerByName(String name) throws Exception {
        final String method = "getServerByName";
        Log.entering(c, method, name);
        for (Server server : getServers()) {
            Log.finest(c, method, "Current server name: " + server.getName());
            if (server.getName().equalsIgnoreCase(name)) {
                Log.finer(c, method, "Server with matching name found.");
                Log.exiting(c, method, server);
                return server;
            }
        }
        Log.finer(c, method, "No server with matching name found.");
        Log.exiting(c, method, null);
        return null;
    }

    /**
     * Retrieves all servers in the cell that match a certain server type.
     * 
     * @param name The name of the server to get
     * @return The {@link Server} with the specified name or null if no Server
     *         with the name exists
     * @throws Exception
     */
    public List<Server> getServersByType(ServerType type) throws Exception {
        final String method = "getServerByType";
        Log.entering(c, method, type);
        List<Server> ret = new ArrayList<Server>();
        Set<Server> servers = getServers();
        for (Server server : servers) {
            if (server.getServerType().equals(type)) {
                ret.add(server);
            }
        }
        Log.exiting(c, method, ret);
        return ret;
    }

    /**
     * Get the manager {@link ApplicationServer} of this Node. This is defined
     * to be a {@link NodeAgent} or {@link Dmgr} if the {@link Cell} topology is
     * {@link WebSphereTopologyType#ND}, a {@link ApplicationServer} if the
     * topology is {@link WebSphereTopologyType#BASE}, an {@link AdminAgent}
     * server if the topology is {@link WebSphereTopologyType#ADMIN_AGENT}, or a
     * {@link JobManager} if the topology is {@link WebSphereTopologyType#FLEX}.
     * 
     * @return A {@link Server} instance who's type is defined above or null if
     *         no {@link ApplicationServer}s exist in the {@link Node} that
     *         match the definition
     */
    public ApplicationServer getManager() throws Exception {
        final String method = "getManager";
        Log.entering(c, method);
        WebSphereTopologyType topology = getCell().getTopologyType();
        Log.finer(c, method, "Topology: " + topology);

        ServerType managerType = topology.toWebSphereEndpointType();
        if (topology == WebSphereTopologyType.ND) {
            managerType = ServerType.NODE_AGENT;
        }

        Log.finer(c, method, "Looking for server of type " + managerType);
        for (Server server : getServers()) {
            Log.finest(c, method, "Current server type: " + server.getServerType());
            if (server.getServerType().equals(managerType)) {
                Log.exiting(c, method, server);
                return (ApplicationServer)server;
            }
        }

        if (topology.equals(WebSphereTopologyType.ND)) {
            return getCell().getManager();
        }

        Log.exiting(c, method, null);
        return null;
    }

    /**
     * Get the profile directory of this Node. If the Node is not installed on
     * the local machine this will NOT refer to a path on the local machine. The
     * path exists on the machine that the Node is installed to.
     * 
     * @return The profile directory of the node
     * @throws Exception
     */
    public String getProfileDir() throws Exception {
        if (this.profilePath == null) {
            this.profilePath = expandVariable(VariableType.USER_INSTALL_ROOT);
            if (this.profilePath != null) // unmanaged nodes do not have a
                // profile path
                this.profilePath = this.profilePath.replace('\\', '/');
        }
        return this.profilePath;
    }

    /**
     * Translates a predefined variable into its corresponding string value.
     * 
     * @param variable The variable to translate.
     * @return The value of the variable, or null if it does not exist.
     * @throws Exception
     */
    public String expandVariable(VariableType variable) throws Exception {
        return expandVariable(variable.getValue());
    }

    /**
     * Translates a custom variable into its corresponding string value.
     * 
     * @param variable The variable name to translate.
     * @return The value of the variable, or null if it does not exist.
     * @throws Exception
     */
    public String expandVariable(String variable) throws Exception {
        // Remove the standard prefix & postfix, if any
        variable = variable.replace("${", "").replace("$(", "").replace("}", "").replace(")", "");
        return OperationsProviderFactory.getProvider().getConfigurationOperationsProvider()
            .expandVariable(this, variable, this.getActiveSession());
    }

    /**
     * Recursively expands all variables in the string to the corresponding
     * value from the server, and replaces backslashes with forward slashes. The
     * resulting string does not contain any variables.
     * 
     * @param str A string that contains zero or more variables.
     * @return The fully-expanded version of the string.
     * @throws Exception
     */
    public String expandString(String str) throws Exception {
        return Scope.expandString(this, str);
    }

    public boolean isRegisteredToAdminAgent() {
        return (this.adminAgentCell != null);
    }

    public boolean isRegisteredToJobMgr() {
        return (this.jobMgrCell != null);
    }

    public Cell getAdminAgent() {
        return this.adminAgentCell;
    }

    public Cell getJobMgr() {
        return this.jobMgrCell;
    }

    /**
     * @return The node's job manager alias. Null if the node is not registered
     *         to a job manager.
     */
    public String getAlias() {
        return this.alias;
    }

    /**
     * @return The node's admin agent alias. Null if the node is not registered
     *         to an admin agent.
     */
    public String getRegisteredNodeName() {
        return this.registeredNodeName;
    }

    /**
     * Sets the name by which the job manager identifies this particular node.
     * 
     * @param value
     */
    protected void setAlias(String value) {
        this.alias = value;
    }

    /**
     * Set the profile directory for this Node
     * 
     * @param path The profile directory path
     */
    protected void setProfileDir(String path) {
        this.profilePath = path;
    }

    /**
     * The hostname of the machine that the Node is installed on
     * 
     * @return The hostname of the machine that the node is installed on
     * @throws Exception
     */
    public String getHostname() throws Exception {
        return getMachine().getHostname();
    }

    /**
     * Get a {@link Machine} Object that represents the machine that this Node
     * is installed on
     * 
     * @return The {@link Machine} of this Node
     * @throws Exception
     */
    public Machine getMachine() throws Exception {
        final String method = "getMachine";
        Log.entering(c, method);
        if (this.machine == null) {
            Log.finer(c, method, "Initializing the machine.");
            // get the node's hostname
            AbstractSession session = this.cell.getWorkspace().getSession();
            String hostname =
                (String)OperationsProviderFactory.getProvider()
                    .getConfigurationOperationsProvider().getAttribute(this,
                                                                       session,
                                                                       this.getConfigId(),
                                                                       "hostName");
            Log.finer(c, method, "Node's hostname is " + hostname);
            // try to get the machine's username and password
            String user = null;
            String password = null;
            ConnectionInfo connInfo = null;
            ConfigurationProvider configProvider =
                Topology.getBootstrapFileOps().getConfigurationProvider();
            if (configProvider != null) {
                Log.finer(c, method, "Loading machine connectionInfo from bootstrapping file.");
                connInfo = Topology.getBootstrapFileOps().getMachineConnectionInfo(hostname);
            } else {
                connInfo = new ConnectionInfo(hostname, user, password);
            }
            Log.finer(c, method, "Constructing the machine.");
            this.machine = Machine.getMachine(connInfo);
        }
        Log.exiting(c, method, this.machine);
        return this.machine;
    }

    protected void setMachine(Machine machine) {
        this.machine = machine;
    }

    /**
     * Sync this Node with the Node of the {@link Dmgr} server. This method does
     * nothing and returns false if there is no {@link NodeAgent} server in the
     * node.
     * 
     * @return true if the node was synchronized successfully; false if the node
     *         sync failed or if this is not a federated node
     * @throws Exception
     */
    public boolean sync() throws Exception {
        final String method = "sync";
        Log.entering(c, method);
        ApplicationServer server = this.getManager();
        if (server instanceof NodeAgent) {
            Log.finer(c, method, "Syncing the node.");
            boolean ret = server.getRuntimeServices().getNodeSync().sync();
            Log.exiting(c, method, ret);
            return ret;
        } else {
            Log.finer(c, method, "The manager of this node is not a NodeAgent.");
            Log.exiting(c, method, false);
            return false;
        }
    }

    /**
     * Get the WAS base product version of a Node. The node's version is the
     * version of the WebSphere installation under which the node is created.
     * ex: 7.0.0.0.
     * 
     * @return The base version of the Node
     */
    public WebSphereVersion getBaseProductVersion() throws Exception {
        final String method = "getBaseProductVersion";
        Log.entering(c, method);
        if (this.baseProductVersion == null) {
            // To avoid stack overflow, assign a default "0.0" version
            this.baseProductVersion = new WebSphereVersion("0.0");
            GetNodeBaseProductVersion task = new GetNodeBaseProductVersion(this.getName());
            String versionString = (String)task.run(this).getResult();
            Log.finer(c, method, "version: " + versionString);
            this.baseProductVersion = new WebSphereVersion(versionString.trim());
        }
        Log.exiting(c, method, this.baseProductVersion);
        return this.baseProductVersion;
    }

    /**
     * Get the installed products for this Node. The installed product, along
     * with the version of the product, determine what functionality the servers
     * on the Node have. For example, a node with a feature pack installed will
     * have the functionality provided by that feature pack. A Node's installed
     * WAS products are not necessarily the same as those installed on the WAS
     * installation that the node is created under. For example, if a feature
     * pack is installed, the node may not be augmented and may only have base
     * product functionality.
     * 
     * @return The {@link InstalledWASProduct}s for this Node
     * @throws Exception
     */
    public Set<InstalledWASProduct> getInstalledWASProducts() throws Exception {
        final String method = "getInstalledWASProducts";
        Log.entering(c, method);
        if (this.installedProducts == null) {
            Log.finer(c, method, "Initializing installed products for this node.");
            this.installedProducts = new HashSet<InstalledWASProduct>();
            Log
                .finer(c,
                       method,
                       "Obtaining metadata properties for the node from the NodeOperationsProvider.");
            GetMetadataProperties task = new GetMetadataProperties(this.getName());
            Object result = task.run(this).getResult();
            Properties metadataProps =
                OperationsProviderFactory.getProvider().getNodeOperationsProvider()
                    .getMetadataProperties(result);
            Log.finer(c, method, "" + metadataProps);
            NodeMetadataProperties[] properties = NodeMetadataProperties.values();
            String value = null;
            for (NodeMetadataProperties property : properties) {
                if (property.getPropertyName().indexOf("ProductShortName") != -1) {
                    Log.finer(c, method, "Getting " + property.getPropertyName());
                    value = metadataProps.getProperty(property.getPropertyName());
                    Log.finer(c, method, "value: " + value);
                    if (value != null) {
                        Log.finer(c, method, "Adding product.");
                        this.installedProducts.add(this.getWASInstall().getWASProduct(WASProductID
                            .shortNameToProductID(value)));
                    }
                }
            }
        }

        Log.exiting(c, method, this.installedProducts);
        return this.installedProducts;
    }

    /**
     * This method clears all cached data for this Node. Further requests for
     * information will be loaded fresh from the WAS instance.
     * <p>
     * WARNING!!! Calling this method invalidates all pointers to any Simplicity
     * objects obtained from the Node and its children. Only call this method if
     * you absolutely want to reset the object model underneath this Node.
     * 
     * @throws Exception
     */
    public void resetNode() throws Exception {
        final String method = "resetNode";
        Log.entering(c, method);

        this.baseProductVersion = null;
        this.configPath = null;
        this.install = null;
        this.installedProducts = null;
        this.machine = null;
        this.profilePath = null;
        this.servers = null;

        if (Topology.isTopologyCachingEnabled()) {
            Topology.getBootstrapFileOps().cache(this.getCell());
        }

        Log.exiting(c, method);
    }

    /**
     * Get the name of the profile that this Node belongs to.<br/>
     * IMPORTANT!!!!<br/>
     * This method requires the use of a command line provider. If this method
     * is being run against a node on a remote machine, the command line
     * provider must have remote execution capabilities. ex: RXA provider
     * 
     * @return The profile name for the node
     * @throws Exception
     */
    public String getProfileName() throws Exception {
        final String method = "getProfileName";
        Log.entering(c, method);
        if (this.profileName == null) {
            Log.finer(c, method, "Obtaining profile name.");
            Machine m = getMachine();
            String[] params = new String[3];
            params[0] = "-getName";
            params[1] = "-profilePath";
            params[2] = getProfileDir();
            if (params[1].indexOf(" ") != -1) {
                params[1] = "\"" + params[1] + "\"";
            }
            String cmd = null;
            
            if(m.getOperatingSystem() == OperatingSystem.ISERIES) {
            	cmd = "qsh -c" + " " + getProfileDir() + "/bin/manageprofiles"
                + m.getOperatingSystem().getDefaultScriptSuffix();
            } else {
            cmd = getProfileDir() + "/bin/manageprofiles"
                    + m.getOperatingSystem().getDefaultScriptSuffix();
            
            
            }
            
            Log.finer(c, method, "cmd: " + cmd);
            Log.finer(c, method, "params: " + params);
            this.profileName = m.execute(cmd, params).getStdout().trim();
        }
        Log.exiting(c, method, this.profileName);
        return this.profileName;
    }

    /**
     * Set the profile name of the node
     * 
     * @param profileName The profile name to set
     */
    protected void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    /**
     * Add a {@link Server} to this Node's private Set
     * 
     * @param ep The {@link Server} to add
     * @throws Exception
     */
    protected void addServer(Server ep) throws Exception {
        if (this.servers == null) {
            this.servers = new HashSet<Server>();
        }
        this.servers.add(ep);
    }

    /**
     * Remove a {@link Server} from this Node's private Set
     * 
     * @param server The {@link Server} to remove
     * @throws Exception
     */
    protected void removeServer(Server server) throws Exception {
        final String method = "removeServer";
        Log.entering(c, method, server);
        Server s = this.getServerByName(server.getName());
        if (s == null) {
            return;
        }
        this.servers.remove(s);
        Log.finer(c, method, "Server is removed: " + !this.servers.contains(s));
        Log.exiting(c, method);
    }

    protected void setRegisteredToAdminAgent(Cell adminAgentCell, String registeredNodeName) {
        this.adminAgentCell = adminAgentCell;
        this.registeredNodeName = registeredNodeName;
    }

    protected void setRegisteredToJobMgr(Cell jobMgrCell, String alias) {
        this.jobMgrCell = jobMgrCell;
        this.alias = alias;
    }

    /**
     * Delegate to the {@link ConfigurationOperationsProvider} to obtain a list
     * of {@link ConfigIdentifier}s for the {@link ApplicationServer}s in the
     * cell
     * 
     * @throws Exception
     */
    private void loadServers() throws Exception {
        final String method = "loadServers";
        Log.entering(c, method);

        this.servers = new HashSet<Server>();
        AbstractSession session = this.cell.getWorkspace().getSession();
        ConfigurationOperationsProvider provider =
            OperationsProviderFactory.getProvider().getConfigurationOperationsProvider();

        ConfigIdentifier[] configIds =
            provider.queryConfigObjects(this, session, this.getConfigId(), ConfigType.SERVER
                .getType());
        ConfigIdentifier serverIndex =
            provider.queryConfigObjects(this, session, this.getConfigId(), "ServerIndex")[0];
        AttributeList attribs =
            provider
                .getAttributes(this, session, serverIndex, new String[] {"serverEntries"}, true);

        Attribute serverEntriesAttribute = (Attribute)attribs.get(0);
        ArrayList<AttributeList> serverEntries =
            (ArrayList<AttributeList>)serverEntriesAttribute.getValue();
        for (AttributeList serverAttributes : serverEntries) {
            ServerType serverType = null;
            String serverName = null;
            String dataId = null;
            ArrayList<AttributeList> specialEndpoints = null;

            for (Object o : serverAttributes) {
                Attribute serverAttribute = (Attribute)o;
                String aname = serverAttribute.getName();
                Object avalue = serverAttribute.getValue();

                if (aname.equalsIgnoreCase("serverType"))
                    serverType = ServerType.valueOf((String)avalue);
                else if (aname.equalsIgnoreCase("_Websphere_Config_Data_Id")) {
                    if (avalue instanceof String)
                        dataId = (String)avalue;
                    else
                        dataId = avalue.toString();
                } else if (aname.equalsIgnoreCase("specialEndpoints"))
                    specialEndpoints = (ArrayList<AttributeList>)avalue;
                else if (aname.equalsIgnoreCase("serverName"))
                    serverName = (String)avalue;
            }

            ConfigIdentifier id = null;
            String substring = "/" + serverName + "|";
            for (ConfigIdentifier cid : configIds) {
                boolean ismatch =
                    ((cid.getConfigId() != null && cid.getConfigId().contains(substring)) || (cid
                        .getObjectName() != null && cid.getObjectName().toString()
                        .contains(substring)));
                if (ismatch) {
                    id = cid;
                    break;
                }
            }
            if (id == null)
                throw new Exception("Could not find a match for " + dataId);
            try {
                Server server = null;
                switch (serverType) {
                    case DEPLOYMENT_MANAGER:
                        server = new Dmgr(id, getCell(), this, specialEndpoints);
                        break;
                    case APPLICATION_SERVER:
                        server =
                            new ApplicationServer(id, getCell(), this,
                                                  ServerType.APPLICATION_SERVER, specialEndpoints);
                        break;
                    case NODE_AGENT:
                        server = new NodeAgent(id, getCell(), this, specialEndpoints);
                        break;
                    case ADMIN_AGENT:
                        server = new AdminAgent(id, getCell(), this, specialEndpoints);
                        break;
                    case JOB_MANAGER:
                        server = new JobManager(id, getCell(), this, specialEndpoints);
                        break;
                    case WEB_SERVER:
                        server = new WebServer(id, getCell(), this, specialEndpoints);
                        break;
                    case PROXY_SERVER:
                        server = new ProxyServer(id, getCell(), this, specialEndpoints);
                        break;
                }
                if (server != null) {
                    Log.finer(c, method, "Adding server of type " + serverType);
                    addServer(server);
                }
            } catch (IllegalArgumentException e) {
                Log.error(c,
                          method,
                          e,
                          "Caught an IllegalArgumentException due to an unknown server type: " + e
                              .getMessage());
            }
            Log.exiting(c, method);
        }

        /*
         * We need to check here for an admin agent environment. If it is, then
         * scan the endpoint list immediately, and parse the "endpointName"
         * attribute of each "specialEndpoints" entry. If the endpointName ends
         * with the name of a node (i.e. "PROTOCOL_CONNECTOR_ADDRESS_nodeName")
         * then it's an endpoint for a subsystem. We then create the subsystem,
         * assign its ports to all those that end with "_nodeName", and figure
         * out a location for the SubSystem instance. I would imagine under the
         * target node itself (i.e. not under the admin agent...or at least
         * under both) because it's a proxy for all servers under that node.
         */
    }

    public void commit(HashMap<String, Object> values) throws Exception {
    }

    @SuppressWarnings("unchecked")
    public void rollback(HashMap<String, Object> values) throws Exception {
        for (Map.Entry<String, Object> entry : values.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (key.equals(CHANGE_KEY_SERVERS)) {
                this.servers = (Set)value;
            }
        }

        if (Topology.isTopologyCachingEnabled()) {
            Topology.getBootstrapFileOps().cache(cell);
        }
    }

}

class StartStopNodeCallable implements Callable<Object> {

    private static Class<?> c = StartStopNodeCallable.class;

    private Node            node;
    private Integer         timeout;
    private String          op;

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public void setOp(String op) {
        this.op = op;
    }

    @Override
    public Object call() throws Exception {
        final String method = "call";
        Log.entering(c, method);

        Log.finer(c, method, op + "ing node " + this.node.getName() + ".");

        List<Callable<Object>> startServers = new ArrayList<Callable<Object>>();
        for (Server server : node.getServers()) {
            if (server != node.getManager()) {
                StartStopServerCallable callable = new StartStopServerCallable();
                callable.setServer(server);
                callable.setTimeout(timeout);
                callable.setOperation(op);
                startServers.add(callable);
            }
        }

        if ("start".equals(op) && node.getManager() != node.getCell().getManager()) {
            // first start/stop the nodeagent
            Log.finer(c, method, "Starting the nodeagent.");
            node.getManager().start(timeout);
        }

        // next start/stop the servers in the node
        Log.finer(c, method, "Starting the rest of the servers in the node.");
        ExecutorService service = Executors.newCachedThreadPool();
        List<Future<Object>> results = null;
        results = service.invokeAll(startServers);

        // we don't actually return anything but this should throw an Exception
        // if there were any problems
        for (Future<Object> result : results)
            try {
                result.get();
            } catch (Exception e) {
                throw new Exception(e.getCause());
            }

        if ("stop".equals(op) && node.getManager() != node.getCell().getManager()) {
            Log.finer(c, method, "Stopping the nodeagent.");
            node.getManager().stop(timeout);
        }

        Log.exiting(c, method, null);
        return null;
    }

}
