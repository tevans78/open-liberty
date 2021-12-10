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

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.management.ObjectName;

import com.ibm.websphere.simplicity.cluster.ClusterType;
import com.ibm.websphere.simplicity.configuration.ConfigurationProvider;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.product.InstallationType;
import com.ibm.websphere.simplicity.product.InstalledWASProduct;
import com.ibm.websphere.simplicity.product.WASInstallation;
import com.ibm.websphere.simplicity.product.InstalledWASProduct.WASProductID;
import com.ibm.websphere.simplicity.provider.commandline.local.LocalWrapper;

/**
 * This class provides methods to interact with the bootstrapping properties file. It provides a
 * means to cache and retrieve cached information about machines and WebSphere topologies.<br>
 * The boostrapping properties file is used to provide connection information about machines and
 * WebSphere cells. To define a WebSphere cell the following properties should be defined:<br>
 * was.cell.X.rootNodeHostname=hostname<br>
 * was.cell.X.rootNodeProfilePath=profilePath<br>
 * was.cell.X.WASUsername=webSphereAdminUser<br>
 * was.cell.X.WASPassword=webSphereAdminPasssword<br>
 * was.cell.X.connType=connType<br>
 * was.cell.X.connPort=connPort<br>
 * <br>
 * The 'X' character in the property name should be replaced with a numeric integer to form a cell
 * 'key'. Multiple cells can be difiened using unique cell keys.<br>
 * ex:<br>
 * was.cell.1<br>
 * was.cell.2<br>
 * The connType property is the {@link ConnectorType} to use in the connection. The connPort
 * property is the correpsonding port value. The rootNode refers to the administrative Node in the
 * WebSphere cell. In a BASE topology this is the BASE node. In an ND topology this is the
 * deployment manager node.<br>
 * <br>
 * To define a machine the following properties should be defined:<br>
 * hostname.user=username<br>
 * hostname.password=password<br>
 * hostname is the fully qualified hostname of the machine. <br>
 * The {@link BootStrappingProperty} enum defines valud key and property values for the
 * bootstrapping file.
 */
public class BootStrappingFileOperations {
    
    private static final Class<?> c = BootStrappingFileOperations.class;
    
    private ConfigurationProvider configProvider;
    public static final String SEP = BootStrappingProperty.PROPERTY_SEP.toString();
    public static final String DATA = BootStrappingProperty.DATA.toString();
    
    /**
     * File Constructor
     * 
     * @param bootstrapFile The bootstrapping file that contains cell and machine definitions
     * @throws Exception
     */
    protected BootStrappingFileOperations(File bootstrapFile) throws Exception {
        configProvider = ConfigurationProvider.getProvider(bootstrapFile);
    }

    /**
     * Returns a List of unique cell keys found in the bootstrapping file
     * 
     * @return A List of unique cell keys found in the bootstrapping file
     */
    public List<String> getCellBootstrapFileKeys() throws Exception {
        checkConfigProvider();
        return findKeys(BootStrappingProperty.WAS_CELL_KEY.getPropertyName());
    }
    
    /**
     * Returns a List of unique keys found in the bootstrapping file which define nodes in a
     * WebSphere cell. Node keys are automatically generated when topology caching is enabled. They
     * are of the form was.cell.X.was.node.X.
     * 
     * @param cellBootstrapKey The key of the cell which the node is a part of
     * @return A List of unique node keys
     */
    protected List<String> getNodeBootstrapFileKeys(String cellBootstrapKey) {
        return findKeys(cellBootstrapKey + SEP + BootStrappingProperty.WAS_NODE_KEY);
    }
    
    /**
     * Returns a List of unique keys found in the bootstrapping file which define clusters in a
     * WebSphere cell. Cluster keys are automatically generated when topology caching is enabled. They
     * are of the form was.cell.X.was.cluster.X.
     * 
     * @param cellBootstrapKey The key of the cell which the cluster is a part of
     * @return A List of unique cluster keys
     */
    protected List<String> getClusterBootstrapFileKeys(String cellBootstrapKey) {
        return findKeys(cellBootstrapKey + SEP + BootStrappingProperty.WAS_CLUSTER_KEY);
    }
    
    /**
     * Returns a List of unique keys found in the bootstrapping file which define servers in a
     * WebSphere cell. Server keys are automatically generated when topology caching is enabled. They
     * are of the form was.cell.X.was.node.X.was.server.X
     * 
     * @param nodeBootstrapKey The key of the node which the server is a part of
     * @return A List of unique server keys
     */
    protected List<String> getServerBootstrapFileKeys(String nodeBootstrapKey) {
        return findKeys(nodeBootstrapKey + SEP + BootStrappingProperty.WAS_SERVER_KEY);
    }
    
    /**
     * Returns a List of unique keys found in the bootstrapping file which define cluster members in a
     * WebSphere cluster. Cluster member keys are automatically generated when topology caching is enabled. The
     * are of the form was.cell.X.was.cluster.X.was.cluster.member.X
     * 
     * @param clusterBootstrapKey The key of the cluster which the node is a part of
     * @return A List of unique cluster member keys
     */
    protected List<String> getClusterMemberBootstrapFileKeys(String clusterBootstrapKey) {
        return findKeys(clusterBootstrapKey + SEP + BootStrappingProperty.WAS_CLUSTER_MEMBER_KEY);
    }
    
    /**
     * Returns the {@link ConfigurationProvider} being used by this
     * {@link BootStrappingFileOperations} instance to ready and write property values.
     * 
     * @return A {@link ConfigurationProvider} instance
     */
    public ConfigurationProvider getConfigurationProvider() {
        return this.configProvider;
    }
    
    /**
     * Returns the bootstrapping property file being used by this instance. The bootstrapping
     * property file contains machine and WebSphere cell definitions.
     * 
     * @return The bootstrapping property file.
     * @see BootStrappingFileOperations
     */
    public File getBootstrapFile() throws Exception {
        checkConfigProvider();
        return this.configProvider.getConfigFile();
    }
    
    /**
     * Cache topology information to the bootstrapping file for a specified {@link Cell} Object. The
     * resulting cached data can be consumed using java.util.Properties and can be accessed outside
     * the topology Object model provided. Additionally, the cached data can be consumed using the
     * {@link Topology} class by enabling caching. This allows the topology Object model for often
     * read WebSphere topology entities (cell, nodes, servers, clusters) to be built without the
     * overhead of an administrative connection using JMX or wsadmin. Any existing cached data for
     * the {@link Cell} will be cleared before the {@link Cell} is cached.
     * 
     * @param cell The {@link Cell} Object who's topology structure data should be cached
     * @throws Exception
     */
    protected void cache(Cell cell) throws Exception {
        // first clear the cache
        clearCache(cell);
        
        String cellKey = cell.getBootstrapFileKey();
        // cell name
        String key = cellKey + SEP + DATA + SEP + BootStrappingProperty.CELL_NAME;
        String value = cell.getName();
        String name = value;
        configProvider.setProperty(key, value);
        // cell wsadmin config id
        key = cellKey + SEP + DATA + SEP + BootStrappingProperty.WSADMIN_CONFIG_ID;
        value = cell.getConfigId().getConfigId();
        if(value != null) {
            value = name + value;
            configProvider.setProperty(key, value);
        } else {
            configProvider.setProperty(key, "");
        }
        // cell ObjectName
        key = cellKey + SEP + DATA + SEP + BootStrappingProperty.OBJECT_NAME;
        if(cell.getConfigId().getObjectName() != null) {
            value = cell.getConfigId().getObjectName().toString();
            configProvider.setProperty(key, value);
        } else {
            configProvider.setProperty(key, "");
        }
        // topology
        key = cellKey + SEP + DATA + SEP + BootStrappingProperty.TOPOLOGY_TYPE;
        value = "" + cell.getTopologyType();
        configProvider.setProperty(key, value);
        // security
        key = cellKey + SEP + DATA + SEP + BootStrappingProperty.SECURITY_ENABLED;
        value = "" + cell.getSecurityConfiguration().getGlobalSecurityDomain().isGlobalSecurityEnabled();
        configProvider.setProperty(key, value);
        
        // nodes
        Set<Node> nodes = cell.getNodes();
        Machine machine;
        WASInstallation install;
        int i = 1;
        for(Node node : nodes) {
            String nodeKey = cellKey + SEP + BootStrappingProperty.WAS_NODE_KEY + i;
            node.setBootstrapFileKey(nodeKey);
            // machine
            machine = node.getMachine();
            cache(machine);
            // installation
            install = node.getWASInstall();
            cache(install);
            
            // node name
            key = nodeKey + SEP + DATA + SEP + BootStrappingProperty.NODE_NAME;
            value = node.getName();
            name = value;
            configProvider.setProperty(key, value);
            key = nodeKey + SEP + DATA + SEP + BootStrappingProperty.PROFILE_PATH;
            value = node.getProfileDir();
            configProvider.setProperty(key, value);
            // node wsadmin config id
            key = nodeKey + SEP + DATA + SEP + BootStrappingProperty.WSADMIN_CONFIG_ID;
            value = node.getConfigId().getConfigId();
            if(value != null) {
                value = name + value;
                configProvider.setProperty(key, value);
            } else {
                configProvider.setProperty(key, "");
            }
            // node ObjectName
            key = nodeKey + SEP + DATA + SEP + BootStrappingProperty.OBJECT_NAME;
            if(node.getConfigId().getObjectName() != null) {
                value = node.getConfigId().getObjectName().toString();
                configProvider.setProperty(key, value);
            } else {
                configProvider.setProperty(key, "");
            }
            // config dir
            key = nodeKey + SEP + DATA + SEP + BootStrappingProperty.CONFIG_PATH;
            value = node.getConfigPath();
            configProvider.setProperty(key, value);
            // profile name
            key = nodeKey + SEP + DATA + SEP + BootStrappingProperty.PROFILE_NAME;
            value = node.getProfileName();
            configProvider.setProperty(key, value);
            // machine reference
            key = nodeKey + SEP + DATA + SEP + BootStrappingProperty.MACHINE;
            value = machine.getBootstrapFileKey();
            configProvider.setProperty(key, value);
            // install reference
            key = nodeKey + SEP + DATA + SEP + BootStrappingProperty.INSTALL;
            value = node.getWASInstall().getBootstrapFileKey();
            configProvider.setProperty(key, value);
            // base product version
            key = nodeKey + SEP + DATA + SEP + BootStrappingProperty.BASE_PRODUCT_VERSION;
            value = "" + node.getBaseProductVersion();
            configProvider.setProperty(key, value);
            // all versions
            key = nodeKey + SEP + DATA + SEP + BootStrappingProperty.WAS_VERSION;
            Set<InstalledWASProduct> products = node.getInstalledWASProducts();
            for(InstalledWASProduct product : products) {
                String keyFinal = (key + BootStrappingProperty.PROPERTY_SEP + product.getProductId());
                value = product.getVersion().toString();
                configProvider.setProperty(keyFinal, value);
            }
            
            // servers
            Set<Server> servers = node.getServers();
            int k = 1;
            for(Server server : servers) {
                String serverKey = nodeKey + SEP + BootStrappingProperty.WAS_SERVER_KEY + k;
                server.setBootstrapFileKey(serverKey);
                // server name
                key = serverKey + SEP + DATA + SEP + BootStrappingProperty.SERVER_NAME;
                value = server.getName();
                name = value;
                configProvider.setProperty(key, value);
                // server wsadmin config id
                key = serverKey + SEP + DATA + SEP + BootStrappingProperty.WSADMIN_CONFIG_ID;
                value = server.getConfigId().getConfigId();
                if(value != null) {
                    value = name + value;
                    configProvider.setProperty(key, value);
                } else {
                    configProvider.setProperty(key, "");
                }
                // server ObjectName
                key = serverKey + SEP + DATA + SEP + BootStrappingProperty.OBJECT_NAME;
                if(server.getConfigId().getObjectName() != null) {
                    value = server.getConfigId().getObjectName().toString();
                    configProvider.setProperty(key, value);
                } else {
                    configProvider.setProperty(key, "");
                }
                // server type
                key = serverKey + SEP + DATA + SEP + BootStrappingProperty.SERVER_TYPE;
                value = "" + server.getServerType();
                configProvider.setProperty(key, value);
                // config path
                key = serverKey + SEP + DATA + SEP + BootStrappingProperty.CONFIG_PATH;
                value = server.getConfigPath();
                configProvider.setProperty(key, value);
                // ports
                PortType[] portTypes = PortType.values();
                PortType portType;
                for(int j = 0; j < portTypes.length; ++j) {
                    portType = portTypes[j];
                    key = serverKey + SEP + DATA + SEP + BootStrappingProperty.PORT + SEP + portType;
                    Integer port = null;
                    try {
                        port = server.getPortNumber(portType);
                    } catch(IllegalArgumentException e) {
                        // server does not contain port
                        continue;
                    }
                    if(port != null && port != -1) {
                        value = "" + port.intValue();
                        configProvider.setProperty(key, value);
                        key = serverKey + SEP + DATA + SEP + BootStrappingProperty.PORT_HOST + SEP + portType;
                        value = server.getPortHost(portType);
                        configProvider.setProperty(key, value);
                    }
                }
                if (server instanceof WebServer) {
                    WebServer temp = (WebServer)server;
                    temp.getStartStopCommandsAndArgs();
                    // install root
                    key = serverKey + SEP + DATA + SEP + BootStrappingProperty.INSTALL_ROOT;
                    value = temp.getInstallRoot();
                    configProvider.setProperty(key, value);
                    // plugin config path
                    key = serverKey + SEP + DATA + SEP + BootStrappingProperty.PLUGIN_CONFIG_PATH;
                    value = temp.getPluginConfigPath();
                    configProvider.setProperty(key, value);
                    // plugin install root
                    key = serverKey + SEP + DATA + SEP + BootStrappingProperty.PLUGIN_INSTALL_ROOT;
                    value = temp.getPluginInstallRoot();
                    configProvider.setProperty(key, value);
                    // start command and args
                    key = serverKey + SEP + DATA + SEP + BootStrappingProperty.WEB_SERVER_START_CMD;
                    value = temp.startCommand;
                    configProvider.setProperty(key, value);
                    key = serverKey + SEP + DATA + SEP + BootStrappingProperty.WEB_SERVER_START_CMD_ARGS;
                    String[] args = temp.startCommandArgs;
                    String argsString = "{";
                    for(int p = 0; p < args.length; ++p)
                        argsString += (args[p]+",");
                    argsString += "}";
                    configProvider.setProperty(key, argsString);
                    // stop command and args
                    key = serverKey + SEP + DATA + SEP + BootStrappingProperty.WEB_SERVER_STOP_CMD;
                    value = temp.stopCommand;
                    configProvider.setProperty(key, value);
                    key = serverKey + SEP + DATA + SEP + BootStrappingProperty.WEB_SERVER_STOP_CMD_ARGS;
                    args = temp.stopCommandArgs;
                    argsString = "{";
                    for(int p = 0; p < args.length; ++p)
                        argsString += (args[p]+",");
                    argsString += "}";
                    configProvider.setProperty(key, argsString);
                }
                ++k; // incremement server
            }
            ++i; // increment node
        }
        
        // clusters
        Set<Cluster> clusters = cell.getClusters();
        int k = 1;
        // TODO cache cluster type
        for(Cluster cluster : clusters) {
            String clusterKey = cellKey + SEP  + BootStrappingProperty.WAS_CLUSTER_KEY + k;
            cluster.setBootstrapFileKey(clusterKey);
            // cluster name
            key =  clusterKey + SEP + DATA + SEP + BootStrappingProperty.CLUSTER_NAME;
            value = cluster.getName();
            name = value;
            configProvider.setProperty(key, value);
            // cluster wsadmin config id
            key = clusterKey + SEP + DATA + SEP + BootStrappingProperty.WSADMIN_CONFIG_ID;
            value = cluster.getConfigId().getConfigId();
            if(value != null) {
                value = name + value;
                configProvider.setProperty(key, value);
            } else {
                configProvider.setProperty(key, "");
            }
            // cluster ObjectName
            key = clusterKey + SEP + DATA + SEP + BootStrappingProperty.OBJECT_NAME;
            if(cluster.getConfigId().getObjectName() != null) {
                value = cluster.getConfigId().getObjectName().toString();
                configProvider.setProperty(key, value);
            } else {
                configProvider.setProperty(key, "");
            }
            // cluster members
            int j = 1;
            Set<Server> members = cluster.getMembers();
            for(Server member : members) {
                key =  clusterKey + SEP + BootStrappingProperty.WAS_CLUSTER_MEMBER_KEY + j + SEP + DATA + SEP + BootStrappingProperty.SERVER;
                value = member.getBootstrapFileKey();
                configProvider.setProperty(key, value);
                ++ j; // increment cluster member
            }
            ++ k; // increment cluster
        }
        
        // finalize data
        key = cellKey + SEP + DATA + SEP + BootStrappingProperty.FINALIZED + SEP + BootStrappingProperty.ROOT_NODE_HOSTNAME;
        value = configProvider.getProperty(cellKey + SEP + BootStrappingProperty.ROOT_NODE_HOSTNAME);
        configProvider.setProperty(key, value);
        key = cellKey + SEP + DATA + SEP + BootStrappingProperty.FINALIZED + SEP + BootStrappingProperty.ROOT_NODE_PROFILE_PATH;
        value = configProvider.getProperty(cellKey + SEP + BootStrappingProperty.ROOT_NODE_PROFILE_PATH);
        configProvider.setProperty(key, value);
        key = cellKey + SEP + DATA + SEP + BootStrappingProperty.FINALIZED;
        configProvider.setProperty(key, "true");
        
        configProvider.writeProperties();
    }
    
    /**
     * Cache machine information to the bootstrapping properties file. The resulting cached data can
     * be consumed using java.util.Properties and can be accessed outside the {@link Machine} Object
     * model provided. Additionally, the cached data can be consumed using the {@link Machine} class
     * by enabling caching in the {@link Topology} oracle. This allows the {@link Machine} Object
     * structure to be built without the need of making a remote connection to the machine.
     * 
     * @param machine The {@link Machine} Object who's data should be cached to the bootstrapping
     *            file.
     * @throws Exception
     */
    protected void cache(Machine machine) throws Exception {
        String machineKey = machine.getBootstrapFileKey();
        if(machineKey == null) {
            machineKey = findNextKey(machine.getHostname());
        } else {
            // machine is already cached
            return;
        }
        machine.setBootstrapFileKey(machine.getHostname());
        machineKey = machine.getHostname();
        
        // hostname
        String key = machineKey + SEP + DATA + SEP + BootStrappingProperty.HOSTNAME;
        String value = machine.getHostname();
        configProvider.setProperty(key, value);
        // OS version
        key = machineKey + SEP + DATA + SEP + BootStrappingProperty.OS_VERSION;
        value = machine.getOSVersion();
        configProvider.setProperty(key, value);
        // raw OS name
        key = machineKey + SEP + DATA + SEP + BootStrappingProperty.RAW_OS_NAME;
        value = machine.getRawOSName();
        configProvider.setProperty(key, value);
        // temp dir
        key = machineKey + SEP + DATA + SEP + BootStrappingProperty.TEMP_DIR;
        value = machine.getTempDir().getAbsolutePath();
        configProvider.setProperty(key, value);
        // Operating System
        OperatingSystem os = machine.getOperatingSystem();
        key = machineKey + SEP + DATA + SEP + BootStrappingProperty.OS;
        value = os.toString();
        configProvider.setProperty(key, value);
        // default encoding
        key = machineKey + SEP + DATA + SEP + BootStrappingProperty.DEFAULT_ENCODING;
        value = os.getDefaultEncoding();
        configProvider.setProperty(key, value);
        // exec file suffix
        key = machineKey + SEP + DATA + SEP + BootStrappingProperty.EXEC_FILE_SUFFIX;
        value = os.getDefaultScriptSuffix();
        configProvider.setProperty(key, value);
        // file separator
        key = machineKey + SEP + DATA + SEP + BootStrappingProperty.FILE_SEPARATOR;
        value = os.getFileSeparator();
        configProvider.setProperty(key, value);
        // line separator
        key = machineKey + SEP + DATA + SEP + BootStrappingProperty.LINE_SEPARATOR;
        value = os.getLineSeparator();
        configProvider.setProperty(key, value);
        // path separator
        key = machineKey + SEP + DATA + SEP + BootStrappingProperty.PATH_SEPARATOR;
        value = os.getPathSeparator();
        configProvider.setProperty(key, value);
        
        configProvider.setProperty(key, value);
        key = machineKey + SEP + DATA + SEP + BootStrappingProperty.FINALIZED;
        configProvider.setProperty(key, "true");
        
        configProvider.writeProperties();
    }
    
    /**
     * Cache WebSphere installation information to the bootstrapping file for a specified
     * {@link WASInstallation} Object. The resulting cached data can be consumed using
     * java.util.Properties and can be accessed outside the topology Object model provided.
     * Additionally, the cached data can be consumed using the {@link WASInstallation} class by enabling
     * caching. A WASInstall can only be cached when a {@link Cell} is cached.
     * 
     * @param install The {@link WASInstallation} to cache
     */
    private void cache(WASInstallation install) throws Exception {
        String installKey = install.getBootstrapFileKey();
        if(installKey == null) {
            installKey = findNextKey(BootStrappingProperty.WAS_INSTALL_KEY.toString());
        } else {
            // install is already cached
            return;
        }
        install.setBootstrapFileKey(installKey);
        
        // machine
        String key = installKey + SEP + DATA + SEP + BootStrappingProperty.MACHINE;
        configProvider.setProperty(key, install.getMachine().getBootstrapFileKey());
        // install root
        key = installKey + SEP + DATA + SEP + BootStrappingProperty.INSTALL_ROOT;
        configProvider.setProperty(key, install.getInstallRoot());
        // install type
        key = installKey + SEP + DATA + SEP + BootStrappingProperty.INSTALL_TYPE;
        configProvider.setProperty(key, "" + install.getInstallType());
        // install products
        Set<InstalledWASProduct> products = install.getWASProducts();
        int i = 1;
        for(InstalledWASProduct product : products) {
            // id
            key = installKey + SEP + BootStrappingProperty.WAS_PRODUCT_KEY + i + SEP + DATA + SEP + BootStrappingProperty.WAS_PRODUCT_ID;
            configProvider.setProperty(key, product.getProductId().toString());
            // build date
            key = installKey + SEP + BootStrappingProperty.WAS_PRODUCT_KEY + i + SEP + DATA + SEP + BootStrappingProperty.BUILD_DATE;
            configProvider.setProperty(key, product.getBuildDate());
            // build level
            key = installKey + SEP + BootStrappingProperty.WAS_PRODUCT_KEY + i + SEP + DATA + SEP + BootStrappingProperty.BUILD_LEVEL;
            configProvider.setProperty(key, product.getBuildLevel());
            // name
            key = installKey + SEP + BootStrappingProperty.WAS_PRODUCT_KEY + i + SEP + DATA + SEP + BootStrappingProperty.WAS_PRODUCT_NAME;
            configProvider.setProperty(key, product.getName());
            // version
            key = installKey + SEP + BootStrappingProperty.WAS_PRODUCT_KEY + i + SEP + DATA + SEP + BootStrappingProperty.WAS_VERSION;
            configProvider.setProperty(key, "" + product.getVersion());
            ++i;
        }
        
        // finalize
        key = installKey + SEP + DATA + SEP + BootStrappingProperty.FINALIZED;
        configProvider.setProperty(key, "true");
        
        configProvider.writeProperties();
    }
    
    /**
     * Clear all cached data from the bootstrapping file
     * 
     * @throws Exception
     */
    public void clearCache() throws Exception {
        checkConfigProvider();
        
        Enumeration<?> propNames = configProvider.getPropertyNames();
        while(propNames.hasMoreElements()) {
            String next = (String)propNames.nextElement();
            if(next.indexOf(BootStrappingProperty.PROPERTY_SEP.toString()
                            + BootStrappingProperty.DATA.toString()
                            + BootStrappingProperty.PROPERTY_SEP.toString()) != -1) {
                configProvider.removeProperty(next);
            }
        }
        configProvider.writeProperties();
    }
    
    /**
     * Clear any cached data from the bootstrapping file that exists for this {@link Cell} Object
     * 
     * @param cell The {@link Cell} who's cached data should be cleared
     * @throws Exception
     */
    public void clearCache(Cell cell) throws Exception {
        checkConfigProvider();
        clearCache(cell.getBootstrapFileKey());
    }
    
    /**
     * Clear any cached data from the bootstrapping file that exists for this {@link Machine} Object
     * 
     * @param machine The {@link Machine} who's cached data should be cleared
     * @throws Exception
     */
    public void clearCache(Machine machine) throws Exception {
        checkConfigProvider();
        clearCache(machine.getBootstrapFileKey());
    }
    
    /**
     * Clear any cached data for an entity defined by the specified property key
     * 
     * @param propertyKey The key of the entity who's cached data should be cleared
     * @throws Exception
     */
    private void clearCache(String propertyKey) throws Exception {
        if(propertyKey == null) {
            return;
        }
        
        Enumeration<?> propNames = configProvider.getPropertyNames();
        while(propNames.hasMoreElements()) {
            String next = (String)propNames.nextElement();
            if(next.startsWith(propertyKey) 
            		&& (next.indexOf(BootStrappingProperty.PROPERTY_SEP + BootStrappingProperty.DATA.toString() + BootStrappingProperty.PROPERTY_SEP) != -1)) {
                configProvider.removeProperty(next);
            }
        }
        configProvider.writeProperties();
    }
    
    /**
     * Get a {@link Cell} defined by the specified bootstrap key.
     * 
     * @param bootstrapKey The key that defines the {@link Cell} in the bootstrap property file
     * @return A {@link Cell} defined by the bootstrap key in the bootstrap file or null of no cell
     *         is defined by the key
     * @throws Exception
     */
    protected Cell getCachedCell(String bootstrapKey) throws Exception {
        if(!cacheComplete(bootstrapKey)) {
            return null;
        }
        
        ConnectionInfo connInfo = getCellConnectionInfo(bootstrapKey);
        Cell cell = new Cell(getConfigIdentifier(bootstrapKey), connInfo);
        cell.setBootstrapFileKey(bootstrapKey);
        
        // get the cell name
        String key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.CELL_NAME;
        cell.setName(configProvider.getProperty(key));
        // topology
        key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.TOPOLOGY_TYPE;
        cell.setTopologyType(WebSphereTopologyType.valueOf(configProvider.getProperty(key)));
        
        return cell;
    }
    
    /**
     * Get a {@link Node} defined by the specified bootstrap key.
     * 
     * @param cell The {@link Cell} Object that represents the WebSphere cell that the node is a
     *            part of
     * @param bootstrapKey The key that defines the {@link Node} in the bootstrap property file
     * @return A {@link Node} defined by the bootstrap key in the bootstrap file or null of no node
     *         is defined by the key
     * @throws Exception
     */
    protected Node getCachedNode(Cell cell, String bootstrapKey) throws Exception {
        if(!cacheComplete(cell.getBootstrapFileKey())) {
            return null;
        }
       
        Node node = new Node(getConfigIdentifier(bootstrapKey), cell);
        node.setBootstrapFileKey(bootstrapKey);
        
        // configPath
        String key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.CONFIG_PATH;
        node.setConfigPath(configProvider.getProperty(key));
        // machine
        key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.MACHINE;
        String machineKey = configProvider.getProperty(key);
        Machine machine = getCachedMachine(machineKey);
        node.setMachine(machine);
        // install
        key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.INSTALL;
        String installBootStrapKey = configProvider.getProperty(key);
        WASInstallation install = getCachedWASInstall(installBootStrapKey);
        node.setWASInstall(install);
        // name
        key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.NODE_NAME;
        node.setName(configProvider.getProperty(key));
        // profile path
        key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.PROFILE_PATH;
        node.setProfileDir(configProvider.getProperty(key));
        // profile name
        key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.PROFILE_NAME;
        node.setProfileName(configProvider.getProperty(key));
        // base product version
        key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.BASE_PRODUCT_VERSION;
        node.setBaseProductVersion(new WebSphereVersion(configProvider.getProperty(key)));
        
        return node;
    }
    
    protected WASInstallation getCachedWASInstall(String bootstrapKey) throws Exception {
        if(!cacheComplete(bootstrapKey)) {
            return null;
        }
        
        WASInstallation install;
        
        // machine
        String key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.MACHINE;
        String value = configProvider.getProperty(key);
        Machine machine = getCachedMachine(value);
        // install root
        key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.INSTALL_ROOT;
        value = configProvider.getProperty(key);
        String installRoot = value;
        // install type
        key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.INSTALL_TYPE;
        value = configProvider.getProperty(key);
        InstallationType installType = InstallationType.valueOf(value);
        
        install = new WASInstallation(machine, installRoot, installType);
        install.setBootstrapFileKey(bootstrapKey);
        
        // products
        List<String> productKeys = findKeys(bootstrapKey + SEP + BootStrappingProperty.WAS_PRODUCT_KEY);
        InstalledWASProduct pKey;
        for(String productKey : productKeys) {
            // id
            key = productKey + SEP + DATA + SEP + BootStrappingProperty.WAS_PRODUCT_ID;
            WASProductID id = WASProductID.valueOf(configProvider.getProperty(key));
            // build date
            key = productKey + SEP + DATA + SEP + BootStrappingProperty.BUILD_DATE;
            String buildDate = configProvider.getProperty(key);
            // build level
            key = productKey + SEP + DATA + SEP + BootStrappingProperty.BUILD_LEVEL;
            String buildLevel = configProvider.getProperty(key);
            // name
            key = productKey + SEP + DATA + SEP + BootStrappingProperty.WAS_PRODUCT_NAME;
            String name = configProvider.getProperty(key);
            // version
            key = productKey + SEP + DATA + SEP + BootStrappingProperty.WAS_VERSION;
            String version = configProvider.getProperty(key);

            pKey = new InstalledWASProduct(id, name, buildDate, buildLevel, new WebSphereVersion(version));
            install.addProduct(pKey);
        }
        
        return install;
    }
    
    /**
     * Get a {@link Server} defined by the specified bootstrap key.
     * 
     * @param cell The {@link Cell} Object that represents the WebSphere cell that the server is a
     *            part of
     * @param node The {@link Node} Object that represents the WebSphere node that the server is a
     *            part of
     * @param bootstrapKey The key that defines the {@link Server} in the bootstrap property file
     * @return A {@link Server} defined by the bootstrap key in the bootstrap file or null of no
     *         server is defined by the key
     * @throws Exception
     */
    protected Server getCachedServer(Cell cell, Node node, String bootstrapKey) throws Exception {
        if(!cacheComplete(cell.getBootstrapFileKey())) {
            return null;
        }

        // server type
        String key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.SERVER_TYPE;
        ServerType type = ServerType.valueOf(configProvider.getProperty(key));
        ConfigIdentifier cid = getConfigIdentifier(bootstrapKey);
        Server server = null;
        
        switch(type) {
        	case ADMIN_AGENT:
                server = new AdminAgent(cid, cell, node, null);
        		break;
        	case APPLICATION_SERVER:
                server = new ApplicationServer(cid, cell, node);
        		break;
        	case ADMIN_AGENT_SUB_SYSTEM:
                server = new SubSystem(cid, cell, node, null);
        		break;
        	case DEPLOYMENT_MANAGER:
                server = new Dmgr(cid, cell, node, null);
        		break;
        	case JOB_MANAGER:
                server = new JobManager(cid, cell, node, null);
        		break;
        	case NODE_AGENT:
                server = new NodeAgent(cid, cell, node, null);
        		break;
            case WEB_SERVER:
                server = new WebServer(cid, cell, node, null, "", new String[]{}, "", new String[]{});
                break;
            case PROXY_SERVER:
                server = new ProxyServer(cid, cell, node, null);
                break;
        }

        server.setBootstrapFileKey(bootstrapKey);
        // config path
        key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.CONFIG_PATH;
        server.setConfigPath(configProvider.getProperty(key));
        if(server instanceof ApplicationServer) {
            // ports
            PortType[] portTypes = PortType.values();
            String portValue = null;
            String portHost = null;
            for(int i = 0; i < portTypes.length; ++i) {
                key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.PORT + SEP + portTypes[i];
                portValue = configProvider.getProperty(key);
                key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.PORT_HOST + SEP + portTypes[i];
                portHost = configProvider.getProperty(key);
                if(portValue != null) {
                    server.setPort(portTypes[i], new Port(portHost, Integer.parseInt(portValue)));
                }
            }
        }
        // name
        key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.SERVER_NAME;
        server.setName(configProvider.getProperty(key));
        
        if(server instanceof WebServer) {
            WebServer temp = (WebServer)server;
            // install root
            key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.INSTALL_ROOT;
            temp.setInstallRoot(configProvider.getProperty(key));
            // plugin config path
            key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.PLUGIN_CONFIG_PATH;
            temp.setPluginConfigPath(configProvider.getProperty(key));
            // plugin install root
            key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.PLUGIN_INSTALL_ROOT;
            temp.setPluginInstallRoot(configProvider.getProperty(key));
            // start command and args
            key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.WEB_SERVER_START_CMD;
            String cmd = configProvider.getProperty(key);
            key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.WEB_SERVER_START_CMD_ARGS;
            String argsString = configProvider.getProperty(key);
            StringTokenizer st = new StringTokenizer(argsString, "\r\n\t\f{}, ");
            String[] args = new String[st.countTokens()];
            int i =0;
            while(st.hasMoreTokens())
                args[i++] = st.nextToken();
            temp.setStartCommand(cmd, args);
            // stop command and args
            key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.WEB_SERVER_STOP_CMD;
            cmd = configProvider.getProperty(key);
            key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.WEB_SERVER_STOP_CMD_ARGS;
            argsString = configProvider.getProperty(key);
            st = new StringTokenizer(argsString, "\r\n\t\f{}, ");
            args = new String[st.countTokens()];
            i =0;
            while(st.hasMoreTokens())
                args[i++] = st.nextToken();
            temp.setStopCommand(cmd, args);
        }
        
        return server;
    }
    
    /**
     * Get a {@link Cluster} defined by the specified bootstrap key.
     * 
     * @param cell The {@link Cell} Object that represents the WebSphere cell that the cluster is a
     *            part of
     * @param bootstrapKey The key that defines the {@link Cluster} in the bootstrap property file
     * @return A {@link Cluster} defined by the bootstrap key in the bootstrap file or null of no
     *         cluster is defined by the key
     * @throws Exception
     */
    protected Cluster getCachedCluster(Cell cell, String bootstrapKey) throws Exception {
        if(!cacheComplete(cell.getBootstrapFileKey())) {
            return null;
        }
        
        // TODO read cluster type
        Cluster cluster = new Cluster(getConfigIdentifier(bootstrapKey), cell, ClusterType.APPLICATION_SERVER);
        cluster.setBootstrapFileKey(bootstrapKey);
        
        // name
        String key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.CLUSTER_NAME;
        cluster.setName(configProvider.getProperty(key));
        
        return cluster;
    }

    /**
     * Get a {@link Machine} defined by the specified bootstrap key.
     * 
     * @param bootstrapKey The key that defines the {@link Machine} in the bootstrap property file
     * @return A {@link Machine} defined by the bootstrap key in the bootstrap file or null of no
     *         machine is defined by the key
     * @throws Exception
     */
    protected Machine getCachedMachine(String bootstrapKey) throws Exception {
        if(!cacheComplete(bootstrapKey)) {
            return null;
        }
        
        // hostname, username, password
        String key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.HOSTNAME;
        String hostname = configProvider.getProperty(key);
        ConnectionInfo connInfo = getMachineConnectionInfo(hostname);
        if(connInfo.getUser() == null && connInfo.getPassword() == null) {
            if(LocalWrapper.isLocal(hostname, null)) {
                // make second attempt
                key = LocalWrapper.LOCALHOST + SEP + BootStrappingProperty.USER;
                String user = configProvider.getProperty(key);
                key = LocalWrapper.LOCALHOST + SEP + BootStrappingProperty.PASSWORD;
                String password = configProvider.getProperty(key);
                ConnectionInfo temp = new ConnectionInfo(connInfo.getHost(), user, password);
                connInfo = temp;
            }
        }
        Machine machine = Machine.getMachine(connInfo);
        machine.setBootstrapFileKey(bootstrapKey);
        // OS Version
        key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.OS_VERSION;
        machine.setOSVersion(configProvider.getProperty(key));
        // raw OS name
        key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.RAW_OS_NAME;
        machine.setRawOSName(configProvider.getProperty(key));
        // temp dir
        key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.TEMP_DIR;
        machine.setTempDir(configProvider.getProperty(key));
        // OS
        key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.OS;
        machine.setOperatingSystem(OperatingSystem.valueOf(configProvider.getProperty(key)));
        
        return machine;
    }
    
    /**
     * Read the properties for the entity defined by the bootstrapKey which define a
     * {@link ConfigIdentifier} instance and return that instance.
     * 
     * @param bootstrapKey The boostrap key that defines the entity in the bootstrap file
     * @return The {@link ConfigIdentifier} for that entity
     * @throws Exception
     */
    private ConfigIdentifier getConfigIdentifier(String bootstrapKey) throws Exception {
        ConfigIdentifier configId = null;
        
        // get the config id info
        String key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.OBJECT_NAME;
        String id = configProvider.getProperty(key);
        if(id != null && !id.equals("")) {
            configId = new ConfigIdentifier(new ObjectName(id));
        } else {
            key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.WSADMIN_CONFIG_ID;
            id = configProvider.getProperty(key);
            configId = new ConfigIdentifier(id);
        }
        return configId;
    }
    
    /**
     * Generate a {@link ConnectionInfo} Object that can be used to connect to the WebSphere
     * {@link Cell} defined by the specified bootstrap key.
     * 
     * @param bootstrapKey The key that defines a {@link Cell} in the bootstrap properties file
     * @return A corresponding {@link ConnectionInfo} for the cell defined by the bootsrap key
     * @throws Exception
     */
    public ConnectionInfo getCellConnectionInfo(String bootstrapKey) throws Exception {
        final String method = "getCellConnectionInfo";
        Log.entering(c, method, bootstrapKey);
        checkConfigProvider();
        
        String connType = null;
        String hostname = null;
        Integer port = null;
        String profileDir = null;
        String username = null;
        String password = null;
        ConnectionInfo connInfo = null;
        connType = configProvider.getProperty(bootstrapKey + SEP + BootStrappingProperty.CONN_TYPE.getPropertyName());
        hostname = configProvider.getProperty(bootstrapKey + SEP + BootStrappingProperty.ROOT_NODE_HOSTNAME.getPropertyName());
        username = configProvider.getProperty(bootstrapKey + SEP + BootStrappingProperty.WAS_USERNAME.getPropertyName());
        password = configProvider.getProperty(bootstrapKey + SEP + BootStrappingProperty.WAS_PASSWORD.getPropertyName());
        String portNum = configProvider.getProperty(bootstrapKey + SEP + BootStrappingProperty.CONN_PORT.getPropertyName());
        if(portNum != null && portNum.length() > 0 && !portNum.equalsIgnoreCase("None")) {
            port = Integer.parseInt(portNum);
        }
        
        ConnectionInfo machineConnInfo = getMachineConnectionInfo(hostname);
        profileDir = configProvider.getProperty(bootstrapKey + SEP + BootStrappingProperty.ROOT_NODE_PROFILE_PATH.getPropertyName());
        
        Log.finer(c, method, "connType: " + connType);
        Log.finer(c, method, "hostname: " + hostname);
        Log.finer(c, method, "port: " + port);
        Log.finer(c, method, "profileDir: " + profileDir);
        Log.finer(c, method, "username: " + username);
        Log.finer(c, method, "password: " + password);
        
        if(Topology.getOperationsProvider().getOperationsType() == OperationsProviderType.WSADMIN) {
            boolean preferLocalWsadmin = true;
            if(Topology.getConfigurationProvider() != null) {
                ConfigurationProvider configProv = Topology.getConfigurationProvider();
                String setting = configProv.getProperty(ConfigProperties.PREFER_WSADMIN_THIN_CLIENT.toString());
                if(setting != null)
                    preferLocalWsadmin = Boolean.parseBoolean(setting);
                Log.finer(c, method, "preferLocalWsadmin setting: " + preferLocalWsadmin);
            }
            String localWsadmin = configProvider.getProperty(BootStrappingProperty.LOCAL_WSADMIN.getPropertyName());
            if(preferLocalWsadmin && localWsadmin != null && (new File(localWsadmin)).exists()) {
                Log.finer(c, method, "Constructing a WsadminThinClientConnectionOptions");
                connInfo = new WsadminThinClientConnectionOptions(ConnectorType.valueOf(connType), hostname, port, username, password, profileDir, new File(localWsadmin));
            } else {
                Log.finer(c, method, "Constructing a WsadminConnectionOptions");
                connInfo = new WsadminConnectionOptions(ConnectorType.valueOf(connType), hostname, port, username, password, profileDir, machineConnInfo);
            }
            ((WsadminConnectionOptions)connInfo).setLang("jython");
            // check for wsadmin trace properties
            String appendtrace = null;
            String tracefile = null;
            List<String> javaoptions = null;
            String javaoption = null;
            appendtrace = configProvider.getProperty(bootstrapKey + SEP + BootStrappingProperty.WSADMIN.getPropertyName() + SEP + BootStrappingProperty.APPENDTRACE.getPropertyName());
            tracefile = configProvider.getProperty(bootstrapKey + SEP + BootStrappingProperty.WSADMIN.getPropertyName() + SEP + BootStrappingProperty.TRACEFILE.getPropertyName());
            int i = 1;
            do {
                javaoption = configProvider.getProperty(bootstrapKey + SEP + BootStrappingProperty.WSADMIN.getPropertyName() + SEP + BootStrappingProperty.JAVAOPTION.getPropertyName() + SEP + i++);
                if(javaoption != null) {
                    if(javaoptions == null)
                        javaoptions = new ArrayList<String>();
                    javaoptions.add(javaoption);
                }
            } while(javaoption != null);
            Log.finer(c, method, "appendtrace: " + appendtrace);
            Log.finer(c, method, "tracefile: " + tracefile);
            Log.finer(c, method, "javaoptions: " + javaoptions);
            if(appendtrace != null)
                ((WsadminConnectionOptions)connInfo).setAppendtrace(Boolean.valueOf(appendtrace));
            if(tracefile != null)
                ((WsadminConnectionOptions)connInfo).setTracefile(tracefile);
            if(javaoptions != null)
                ((WsadminConnectionOptions)connInfo).setJavaoptions(javaoptions);
        } else {
            connInfo = new JMXConnectionOptions(ConnectorType.valueOf(connType), hostname, port, username, password, profileDir);
        }
        
        Log.exiting(c, method, connInfo);
        return connInfo;
    }
    
    /**
     * Generate a {@link ConnectionInfo} Object that can be used to connect to {@link Machine}
     * defined by the specified bootstrap key.
     * 
     * @param bootstrapKey The key that defines a {@link Machine} in the bootstrap properties file
     * @return A corresponding {@link ConnectionInfo} for the machine defined by the bootsrap key
     * @throws Exception
     */
    public ConnectionInfo getMachineConnectionInfo(String bootstrapKey) throws Exception {
        final String method = "getMachineConnectionInfo";
        Log.entering(c, method, bootstrapKey);
        checkConfigProvider();
        
        // check if there is an alias for the hostname defined
        String aliasKey = bootstrapKey + SEP + BootStrappingProperty.ALIAS.getPropertyName();
        String alias = configProvider.getProperty(aliasKey);
        Log.finer(c, method, "alias: " + alias);
        if(alias != null) {
            Log.finer(c, method, "Seeting bootsrapKey to aliasKey");
            bootstrapKey = alias;
        }
        
        String machineUsernameKey = bootstrapKey + SEP + BootStrappingProperty.USER.getPropertyName();
        Log.finer(c, method, "machineUsernameKey: " + machineUsernameKey);
        String machinePasswordKey = bootstrapKey + SEP + BootStrappingProperty.PASSWORD.getPropertyName();
        Log.finer(c, method, "machinePasswordKey: " + machinePasswordKey);
        String machineUsername = null;
        String machinePassword = null;
        
        // get the machine username and password values in a case-insensitive manner
        Enumeration<?> properties = configProvider.getPropertyNames();
        String next = null;
        while(properties.hasMoreElements()) {
            next = (String)properties.nextElement();
            Log.finest(c, method, "next: " + next);
            if(next.equalsIgnoreCase(machineUsernameKey)) {
                machineUsername = configProvider.getProperty(next);
            } else if(next.equalsIgnoreCase(machinePasswordKey)) {
                machinePassword = configProvider.getProperty(next);
            }
            Log.finest(c, method, "machineUserName: " + machineUsername);
            Log.finest(c, method, "machinePassword: " + machinePassword);
            if(machineUsername != null && machinePassword != null) {
                Log.finer(c, method, "found machineUserName: " + machineUsername);
                Log.finer(c, method, "found machinePassword: " + machinePassword);
                break;
            }
        }
         
        String keyStore = configProvider.getProperty(BootStrappingProperty.KEYSTORE.getPropertyName());
        String passPhrase = configProvider.getProperty(BootStrappingProperty.PASSPHRASE.getPropertyName());
        Log.finer(c, method, "keyStore: " + keyStore);
        Log.finer(c, method, "passPhrase: " + passPhrase);
        
        if(keyStore != null && keyStore.length() > 0 && passPhrase != null) {
        	if (machineUsername == null) {
                Log.finer(c, method, "machineUserName is null. Setting it to the empty String.");
        		machineUsername = "";
            }
        	ConnectionInfo ret = null;
    		Log.finer(c, method, "Using ConnectionInfo with keystore and passphrase.");
    		ret = new ConnectionInfo(bootstrapKey, new File(keyStore), machineUsername, passPhrase);
            Log.exiting(c, method, ret);
            return ret;
        }
        
        Log.finer(c, method, "Creating ConnectionInfo with machineUsername and machinePassword.");
        ConnectionInfo ret = new ConnectionInfo(bootstrapKey, machineUsername, machinePassword);
        Log.exiting(c, method, ret);
        return ret;
    }
    
    /**
     * Returns true if the cache for the entity defined by the bootstrap key is complete. Returns
     * false if there is no entity defined by the bootstrap key or if the cache for the entity is
     * not complete. The cache may not be complete if an Exception is thrown during the cache
     * operation.
     * 
     * @param bootstrapKey The key that defines the entity in the bootstrapping property file.
     * @return true if the cache is complete
     */
    protected boolean cacheComplete(String bootstrapKey) throws Exception {
        if(bootstrapKey == null) {
            return false;
        }
        String key = bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.FINALIZED;
        String value = configProvider.getProperty(key);
        return ((value != null) && (value.equals("true")));
    }
    
    /**
     * Check if cached cell information is up to date based off current user provided data and the
     * data used to cache the cell
     * 
     * @param bootstrapKey The cell bootstrap key
     * @return true if the cache is current; false if stale
     */
    protected boolean cellCacheUpToDate(String bootstrapKey) {
        // get user defined data
        String userHostname = configProvider.getProperty(bootstrapKey + SEP + BootStrappingProperty.ROOT_NODE_HOSTNAME.getPropertyName());
        String userProfilePath = configProvider.getProperty(bootstrapKey + SEP + BootStrappingProperty.ROOT_NODE_PROFILE_PATH.getPropertyName());
        
        // get cached data
        String cachedHostname = configProvider.getProperty(bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.FINALIZED + SEP + BootStrappingProperty.ROOT_NODE_HOSTNAME);
        String cachedProfilePath = configProvider.getProperty(bootstrapKey + SEP + DATA + SEP + BootStrappingProperty.FINALIZED + SEP + BootStrappingProperty.ROOT_NODE_PROFILE_PATH);

        
        // compare
        return ((userHostname.equals(cachedHostname)) && (userProfilePath.equals(cachedProfilePath)));
    }
    
    /**
     * Get the cell key portion for a general key identifier.<br>
     * Ex: was.cell.1.was.node.1 returns was.cell.1
     * 
     * @param bootstrapKey The key that identifies the entity in the bootstrapping property file
     * @return Either the cell key portion of the bootstrap key or null if the bootstrap key does
     *         not contain a cell portion
     */
    public String getCellKey(String bootstrapKey) {
        if(bootstrapKey.indexOf(BootStrappingProperty.WAS_CELL_KEY.toString()) != -1) {
            String suffix = bootstrapKey.substring(BootStrappingProperty.WAS_CELL_KEY.toString().length());
            if(suffix.equals("")) {
                return bootstrapKey;
            }
            return bootstrapKey.substring(0, suffix.indexOf("."));
        }
        
        return null;
    }
    
    /**
     * Find the next available key for a given key type.<br>
     * Ex: keyStart of was.cell. returns was.cell.1 if no cells are defined in the bootstrapping
     * properties file.
     * 
     * @param keyStart The start of the key
     * @return The next available key
     */
    public String findNextKey(String keyStart) {
        List<String> currentKeys = findKeys(keyStart);
        int i = 1;
        for(; i < currentKeys.size() + 1; ++i) {
            if(!currentKeys.contains(keyStart + i)) {
                return (keyStart + i);
            }
        }
        return (keyStart + i);
    }
    
    /**
     * Get a List of unique keys that begin with keyStart
     * @param keyStart The prefix of the key to find
     * @return A List of unique keys that begin with keyStart
     */
    private List<String> findKeys(String keyStart) {
        List<String> keyList = new ArrayList<String>();
        Enumeration<?> propNames = configProvider.getPropertyNames();
        while(propNames.hasMoreElements()) {
            String next = (String)propNames.nextElement();
            if(next.startsWith(keyStart)) {
                String suffix = next.substring(keyStart.length());
                String key = keyStart + suffix.substring(0, suffix.indexOf(SEP));
                if(!keyList.contains(key)) {
                    keyList.add(key);
                }
            }
        }
        return keyList;
    }
    
    private void checkConfigProvider() throws Exception {
        if (configProvider == null)
        	throw new Exception("This API required a valid bootstrapping.properties file.");
    }
    
}
