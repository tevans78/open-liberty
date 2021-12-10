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
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.ibm.websphere.simplicity.configuration.ConfigurationProvider;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;
import com.ibm.websphere.simplicity.provider.commandline.CommandLineProvider;
import com.ibm.websphere.simplicity.provider.commandline.CommandLineProviderFactory;
import com.ibm.websphere.simplicity.provider.websphere.WebSphereOperationsProvider;
import com.ibm.websphere.simplicity.util.AlphabeticalBootstrapKeyComparator;

/**
 * The Topology class is the entry point into the Simplicity WebSphere topology
 * Object model. A WebSphere topology is the collection of all servers
 * underneath a top-level server, such as a deployment manager, admin agent, or
 * job manager. This class provides access to that information, as well as
 * client-side operations such as tracing. Additionally, this class provides
 * methods to programmatically set Simplicity settings and prefernces.
 */
public class Topology {

    /**
     * This is the default configuration file in which settings such which
     * {@link WebSphereOperationsProvider} should be used. The configuration
     * file to use can be specified using the jvm arg <b>configProps</b>.<br/>
     * ex: -DconfigProps=myConfig.props
     */
    public static final String                 DEFAULT_CONFIG_FILE    = "simplicityConfig.props";
    /**
     * Simplicity version number
     */
    public static final String                 SIMPLICITY_VERSION     = "1.0.12.2";

    private static Class<?>                    c                      = Topology.class;
    private static List<Cell>                  cells                  = new ArrayList<Cell>();
    private static boolean                     inited                 = false;
    private static WebSphereOperationsProvider operationsProvider;
    private static CommandLineProvider         commandLineProvider;
    private static BootStrappingFileOperations bootstrapFileOps;
    private static ConfigurationProvider       configProvider;
    private static File                        bootStrappingFile;
    private static boolean                     topologyCachingEnabled = false;

    private Topology() {
    }

    /**
     * This method returns true if the topology has already been initialized
     * using one of the init methods of this class
     * 
     * @return true if the Simplicity Object model has already been initialized.
     */
    public static boolean isInited() {
        return inited;
    }

    /**
     * Returns a List of initialized {@link Cell}s. The {@link Cell} Object
     * provides access to all other objects in the topology object model. This
     * method returns the Cells in the order they are defined in the
     * bootstrapping file if one is being used, or in the order that they are
     * initialized.
     * 
     * @return A List of initialized {@link Cell}s
     */
    public static List<Cell> getCells() {
        return cells;
    }

    /**
     * Get a sorted List of {@link Cell}s.
     * 
     * @param c The Comparator that defines how to sort the {@link Cell}s
     * @return A List containing the Cells in sorted order
     */
    public static List<Cell> getCells(Comparator<Cell> c) {
        List<Cell> cells = getCells();
        Collections.sort(cells, c);
        return cells;
    }

    /**
     * Get all the cells that have the specific {@link WebSphereTopologyType}
     * 
     * @param type The type to get
     * @return All the cells with the specified {@link WebSphereTopologyType}
     * @throws Exception
     */
    public static Set<Cell> getCellsByType(WebSphereTopologyType type) throws Exception {
        Set<Cell> ret = new HashSet<Cell>();
        for (Cell c : cells)
            if (c.getTopologyType().equals(type))
                ret.add(c);
        return ret;
    }

    /**
     * Get a {@link Cell} with a specific name. Note that if multiple cells have
     * been initialized with the same name, this method will return the first
     * {@link Cell} found.
     * 
     * @param name The name of the {@link Cell} to retrieve
     * @return The {@link Cell} with the specified name, or null if no
     *         {@link Cell} exists with the name
     */
    public static Cell getCellByName(String name) {
        for (Cell c : cells)
            if (c.getName().equalsIgnoreCase(name))
                return c;
        return null;
    }

    /**
     * Get a {@link Cell} with a specific bootstrap key. The boostrap key
     * uniquely identifies a {@link Cell} within the bootstrapping properties
     * file.
     * 
     * @param bootstrapKey The key of the {@link Cell} to retrieve
     * @return The {@link Cell} with the specified bootstrap key or null of no
     *         {@link Cell} exists with the key
     */
    public static Cell getCellByBootstrapKey(String bootstrapKey) {
        for (Cell cell : cells) {
            if (cell.getBootstrapFileKey().equals(bootstrapKey)) {
                return cell;
            }
        }
        return null;
    }

    /**
     * Loads all the {@link Cell}s defined in bootstrapping properties file. If
     * no bootstrapping properties file exists, an Exception is thrown. The
     * {@link Cell}s are then accessible via the getCell* methods of this class.
     * 
     * @throws Exception
     */
    public static void init() throws Exception {
        Log.entering(c, "init");
        if (inited) {
            Log.exiting(c, "init (already initialized)");
            return;
        }

        // loadSettings();

        bootstrapFileOps = getBootstrapFileOps();
        List<String> cellBoostrapFileKeys = bootstrapFileOps.getCellBootstrapFileKeys();
        for (String cellBootstrapFileKey : cellBoostrapFileKeys) {
            if (topologyCachingEnabled && bootstrapFileOps.cacheComplete(cellBootstrapFileKey)
                && bootstrapFileOps.cellCacheUpToDate(cellBootstrapFileKey)) {
                Log.finer(c, "init", "Constructing Cell from cache.");
                constructCellFromCache(cellBootstrapFileKey);
            } else {
                // cell not cached or don't use caching
                ConnectionInfo connInfo =
                    bootstrapFileOps.getCellConnectionInfo(cellBootstrapFileKey);
                List<Cell> cells = connInfoInit(connInfo);
                Collections.sort(cells, new AlphabeticalBootstrapKeyComparator<Cell>());
                // set the bootstrap file key for the cells and cache; currently
                // only one cell returned
                // TODO May need to revisit this logic if we find a case where
                // more than a single cell gets returned
                for (Cell cell : cells) {
                    cell.setBootstrapFileKey(cellBootstrapFileKey);
                    if (topologyCachingEnabled) {
                        bootstrapFileOps.cache(cell);
                    }
                }
            }
        }

        // now the topologies have been loaded. lets check for flex and/or aa
        // topologies and load their managed nodes
        // to create the links between job manager, admin agent, and the
        // registered nodes
        Set<Cell> allCells = new HashSet<Cell>();
        allCells.addAll(Topology.getCellsByType(WebSphereTopologyType.FLEX));
        allCells.addAll(Topology.getCellsByType(WebSphereTopologyType.ADMIN_AGENT));
        Iterator<Cell> iter = allCells.iterator();
        while (iter.hasNext())
            iter.next().getManagedNodes();

        inited = true;
        Log.exiting(c, "init");
    }

    /**
     * This method clears the internal cell cache and reloads the cells defined
     * in the bootstrapping properties file.<br/>
     * WARNING!! Calling this method invalidates all pointers to any Simplicity
     * Objects. Only call this method if you absolutely want to reset the
     * topology Object model.
     * 
     * @throws Exception
     */
    public static void reset() throws Exception {
        for(Cell cell : cells)
            cell.popAllConnections();
        cells = new ArrayList<Cell>();
        inited = false;
        if (topologyCachingEnabled) {
            bootstrapFileOps.clearCache();
        }

        init();
    }

    /**
     * Construct a cached {@link Cell} referenced by the bootstrap file key
     * 
     * @param bootstrapFileKey The key that defines the {@link Cell} in the
     *            bootstrap file
     * @throws Exception
     */
    private static void constructCellFromCache(String bootstrapFileKey) throws Exception {
        // construct cell
        Cell cell = bootstrapFileOps.getCachedCell(bootstrapFileKey);

        // construct nodes
        List<String> nodeEntities = bootstrapFileOps.getNodeBootstrapFileKeys(bootstrapFileKey);
        for (String nodeEntity : nodeEntities) {
            Node node = bootstrapFileOps.getCachedNode(cell, nodeEntity);
            cell.addNode(node);

            // construct servers
            List<String> serverEntities = bootstrapFileOps.getServerBootstrapFileKeys(nodeEntity);
            for (String serverEntity : serverEntities) {
                Server server = bootstrapFileOps.getCachedServer(cell, node, serverEntity);
                node.addServer(server);
            }
        }

        // construct clusters
        List<String> clusterEntites =
            bootstrapFileOps.getClusterBootstrapFileKeys(bootstrapFileKey);
        for (String clusterEntity : clusterEntites) {
            Cluster cluster = bootstrapFileOps.getCachedCluster(cell, clusterEntity);

            // cluster members
            List<String> members =
                bootstrapFileOps.getClusterMemberBootstrapFileKeys(clusterEntity);
            for (String member : members) {
                String fullProp =
                    member + BootStrappingProperty.PROPERTY_SEP
                        + BootStrappingProperty.DATA
                        + BootStrappingProperty.PROPERTY_SEP
                        + BootStrappingProperty.SERVER;
                Server serverMember =
                    cell.getServerByBootstrapKey(bootstrapFileOps.getConfigurationProvider()
                        .getProperty(fullProp));
                cluster.addMember(serverMember);
            }
            cell.addCluster(cluster);
        }

        cells.add(cell);
    }

    /**
     * Initialized the topology using the provided {@link ConnectionInfo}. A
     * wsadmin or JMX connection is made (depending on the specified
     * {@link WebSphereOperationsProvider}). Using the connection, the
     * {@link Cell} is initialized. The {@link Cell}s are then accessible via
     * the getCell* methods of this class.
     * 
     * @param connInfo The {@link ConnectionInfo} that contains information
     *            needed to make a WebSphere administrative connection
     * @throws Exception
     */
    public static void init(ConnectionInfo connInfo) throws Exception {
        Log.entering(c, "init", new Object[] {connInfo});
        if (inited) {
            Log.exiting(c, "init (already initialized)");
            return;
        }

        // loadSettings();
        connInfoInit(connInfo);

        if (topologyCachingEnabled) {
            for (Cell cell : cells) {
                String cellBootstrapFileKey =
                    bootstrapFileOps.findNextKey(BootStrappingProperty.WAS_CELL_KEY.toString());
                cell.setBootstrapFileKey(cellBootstrapFileKey);
                bootstrapFileOps.cache(cell);
            }
        }

        inited = true;
        Log.exiting(c, "init");
    }

    /**
     * Initialized the topology using a {@link ConnectionInfo}. A wsadmin or JMX
     * connection is made (depending on the specified
     * {@link WebSphereOperationsProvider})
     * 
     * @param connInfo The {@link ConnectionInfo} that contains information
     *            needed to make a WebSphere administrative connection
     * @return A List of cells found
     * @throws Exception
     */
    protected static List<Cell> connInfoInit(ConnectionInfo connInfo) throws Exception {
        List<Cell> container = getOperationsProvider().getTopology(connInfo);
        if (cells == null) {
            cells = new ArrayList<Cell>();
        }
        cells.addAll(container);
        return new ArrayList<Cell>(container);
    }

    /**
     * Set the default {@link OperationsProviderType} to use to perform
     * WebSphere operations. This type of operations provider will be used by
     * the {@link WebSphereOperationsProvider}.
     * 
     * @param type The {@link OperationsProviderType} to use when performing
     *            WebSphere operations.
     * @throws Exception
     */
    public static void setDefaultOperationsProvider(OperationsProviderType type) throws Exception {
        OperationsProviderFactory.setDefaultCommandProvider(type);
        operationsProvider = null;
    }

    /**
     * Get the {@link WebSphereOperationsProvider} used to perform WebSphere
     * operations.
     * 
     * @return The {@link WebSphereOperationsProvider}
     * @throws Exception
     */
    public static WebSphereOperationsProvider getOperationsProvider() throws Exception {
        if (operationsProvider == null) {
            operationsProvider = OperationsProviderFactory.getProvider();
        }
        return operationsProvider;
    }

    /**
     * Set the default {@link CommandLineProviderType} to use to perform command
     * line type operations. This type of operations provider will be used by
     * the {@link CommandLineProvider}.
     * 
     * @param type The {@link CommandLineProviderType} to use when performing
     *            command line operations.
     * @throws Exception
     */
    public static void setDefaultCommandLineProvider(CommandLineProviderType type) throws Exception {
        CommandLineProviderFactory.setDefaultCommandLineProvider(type);
        commandLineProvider = null;
    }

    /**
     * Get the {@link CommandLineProvider} used to perform command line
     * operations
     * 
     * @return The {@link CommandLineProvider}
     * @throws Exception
     */
    public static CommandLineProvider getCommandLineProvider() throws Exception {
        if (commandLineProvider == null) {
            commandLineProvider = CommandLineProviderFactory.getProvider();
        }
        return commandLineProvider;
    }

    /**
     * Sets the client-side trace for WAS libraries.
     * 
     * @param spec
     * @throws Exception
     */
    public static void setClientTrace(String spec) throws Exception {
        setClientTrace(spec, null);
    }

    /**
     * Sets the client-side trace, and its destination file, for WAS libraries.
     * 
     * @param spec
     * @throws Exception
     */
    public static void setClientTrace(String spec, String filename) throws Exception {
        getOperationsProvider().getLoggingOperationsProvider().setClientTrace(spec, filename);
    }

    /**
     * Set the bootstrapping file to read from when initializing the WebSphere
     * topology Object model.
     * 
     * @param bootStrappingFile The file that contains the {@link Cell}
     *            definitions
     */
    public static void setBootStrappingFile(File bootStrappingFile) {
        Topology.bootStrappingFile = bootStrappingFile;
    }

    /**
     * Get the bootstrapping file used to read from when initializing the
     * WebSphere topology Object model.
     * 
     * @return The file that contains the {@link Cell} definitions
     */
    public static File getBootStrappingFile() {
        if (bootStrappingFile == null) {
            bootStrappingFile = new File("bootstrapping.properties");
        }
        return bootStrappingFile;
    }

    /**
     * Get the bootstrapping file used to initialize the WebSphere topology
     * Object model
     * 
     * @return The bootstrapping file
     * @throws Exception
     */
    public static BootStrappingFileOperations getBootstrapFileOps() throws Exception {
        if (bootstrapFileOps == null) {
            bootstrapFileOps = new BootStrappingFileOperations(getBootStrappingFile());
        }
        return bootstrapFileOps;
    }

    /**
     * Set if topology caching should be used when initializing the topology
     * Object model. If true, {@link Cell}, {@link Node}, {@link Server},
     * {@link Cluster}, and {@link Machine} data are cached to the bootstrapping
     * properties file. These properties can then be used externally or used to
     * reinitalized the topology Object model without incurring the cost of a
     * wsadmin or JMX connection.
     * 
     * @param enabled true if topology caching should be used
     */
    public static void setTopologyCaching(boolean enabled) {
        topologyCachingEnabled = enabled;
    }

    /**
     * @return true if topology caching is enabled
     */
    public static boolean isTopologyCachingEnabled() {
        return topologyCachingEnabled;
    }

    /**
     * Get the Configuration Provider used to read the settings. The
     * Configuration Provider loads the config file and provides access to the
     * configuration settings. If the {@link #DEFAULT_CONFIG_FILE} does not
     * exist and no config file is specified on the command line, then no
     * Configuration Provider is created and this method returns null.
     * 
     * @return The Configuration Provider used to read the config settings if
     *         one exists; null otherwise.
     * @throws Exception
     */
    public static ConfigurationProvider getConfigurationProvider() throws Exception {
        if (configProvider == null) {
            // loadSettings();
        }
        return configProvider;
    }

    /**
     * Load the configuration settings from the config file if one exists.
     * Otherwise an attempt will be made to read the corresponding System
     * properties. If the property is found the providers and bootstrapping
     * properties file are set. If not, then these settings are left
     * uninitialized and defaults are used.
     * 
     * @throws Exception
     */
    // private static void loadSettings() throws Exception {
    static {
        final String method = "static";
        Log.entering(c, method);

        Log.finer(c, method, "Simplicity version number: " + Topology.SIMPLICITY_VERSION);

        try {
            // load the config file
            File config = new File(DEFAULT_CONFIG_FILE);
            if (!config.exists()) {
                Log.finer(c, method, "The default simplicity config file " + config
                    .getAbsolutePath()
                    + " does not exist. Checking for System property defined location.");
                // see if they have specified a config file as a jvm arg
                String key = System.getProperty(ConfigProperties.CONFIG_PROPS.toString());
                if (key != null) {
                    Log.finer(c, method, "User specified the config file " + key
                        + ". Using this file.");
                    config = new File(key);
                } else {
                    Log.finer(c, method, "No user specified simplicity config file specified.");
                }
            } else {
                Log.finer(c, method, "Default simplicity config file exists.");
            }

            String websphereOperationsProvider = null;
            String commandLineProvider = null;
            String bootStrappingPropsFile = null;
            String useTopologyCaching = null;
            String useLocalWrapper = null;

            if (config.exists()) {
                Log.finer(c, method, "Loading simplicity settings using the config file " + config
                    .getAbsolutePath());
                // attempt to load settings using the config file
                configProvider = ConfigurationProvider.getProvider(config);
                websphereOperationsProvider =
                    configProvider.getProperty(ConfigProperties.WEBSPHERE_OPERATIONS_PROVIDER
                        .toString());
                commandLineProvider =
                    configProvider.getProperty(ConfigProperties.COMMAND_LINE_PROVIDER.toString());
                bootStrappingPropsFile =
                    configProvider
                        .getProperty(ConfigProperties.BOOTSTRAPPING_PROPS_FILE.toString());
                useTopologyCaching =
                    configProvider.getProperty(ConfigProperties.USE_TOPOLOGY_CACHING.toString());
                useLocalWrapper =
                    configProvider.getProperty(ConfigProperties.USE_LOCAL_COMMAND_LINE_WRAPPER
                        .toString());
            } else {
                Log.finer(c, method, "The config file " + config.getAbsolutePath()
                    + " does not exist. Settings were not loaded.");
            }

            // properties not in a config file lets see if they were set as jvm
            // args
            if (websphereOperationsProvider == null) {
                Log
                    .finer(c,
                           method,
                           "Attempting to load the WebSphere Operations Provider using the System property: " + ConfigProperties.WEBSPHERE_OPERATIONS_PROVIDER);
                websphereOperationsProvider =
                    System.getProperty(ConfigProperties.WEBSPHERE_OPERATIONS_PROVIDER.toString());
            }
            if (commandLineProvider == null) {
                Log
                    .finer(c,
                           method,
                           "Attempting to load the Command Line Provider using the System property: " + ConfigProperties.COMMAND_LINE_PROVIDER);
                commandLineProvider =
                    System.getProperty(ConfigProperties.COMMAND_LINE_PROVIDER.toString());
            }
            if (bootStrappingPropsFile == null) {
                Log
                    .finer(c,
                           method,
                           "Attempting to load the bootstrapping properties file using the System property: " + ConfigProperties.BOOTSTRAPPING_PROPS_FILE);
                bootStrappingPropsFile =
                    System.getProperty(ConfigProperties.BOOTSTRAPPING_PROPS_FILE.toString());
            }
            if (useTopologyCaching == null) {
                Log
                    .finer(c,
                           method,
                           "Attempting to load the topology file caching setting using the System property: " + ConfigProperties.USE_TOPOLOGY_CACHING);
                useTopologyCaching =
                    System.getProperty(ConfigProperties.USE_TOPOLOGY_CACHING.toString());
            }
            if (useLocalWrapper == null) {
                Log
                    .finer(c,
                           method,
                           "Attempting to load the local wrapper setting using the System property: " + ConfigProperties.USE_LOCAL_COMMAND_LINE_WRAPPER);
                useLocalWrapper =
                    System.getProperty(ConfigProperties.USE_LOCAL_COMMAND_LINE_WRAPPER.toString());
            }

            // for the settings we found, set them. defaults are used for
            // settings not specified
            if (websphereOperationsProvider != null) {
                Log
                    .finer(c,
                           method,
                           "WebSphere Operations Provider being set to " + websphereOperationsProvider
                               + ".");
                OperationsProviderFactory.setDefaultCommandProvider(OperationsProviderType
                    .valueOf(websphereOperationsProvider));
            } else {
                Log.finer(c,
                          method,
                          "Default value being used for WebSphere Operations Provider: JMX");
            }
            if (commandLineProvider != null) {
                Log.finer(c, method, "Command Line Provider being set to " + commandLineProvider
                    + ".");
                CommandLineProviderFactory.setDefaultCommandLineProvider(CommandLineProviderType
                    .valueOf(commandLineProvider));
            } else {
                Log.finer(c, method, "Default value being used for Command Line Provider: RXA");
            }
            if (bootStrappingPropsFile != null) {
                Log.finer(c,
                          method,
                          "Bootstrapping properties file being set to " + bootStrappingPropsFile
                              + ".");
                bootStrappingFile = new File(bootStrappingPropsFile);
            } else {
                Log
                    .finer(c,
                           method,
                           "Default value being used for bootstrapping file: " + new File(
                                                                                          "bootstrapping.properties")
                               .getAbsolutePath());
            }
            if (useTopologyCaching != null) {
                Log.finer(c,
                          method,
                          "Topology file caching setting being set to " + useTopologyCaching + ".");
                topologyCachingEnabled = Boolean.parseBoolean(useTopologyCaching);
            } else {
                Log.finer(c,
                          method,
                          "Default value being used for topology file caching setting: false.");
            }
            if (useLocalWrapper != null) {
                Log.finer(c, method, "LocalWrapper use being set to " + useLocalWrapper + ".");
                CommandLineProviderFactory.setUseLocalCommandLineWrapper(Boolean
                    .parseBoolean(useLocalWrapper));
            } else {
                Log.finer(c, method, "Default value being used for local wrapper setting: true");
            }
        } catch (Exception e) {
        }
    }
}
