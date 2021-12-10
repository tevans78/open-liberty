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

import com.ibm.websphere.simplicity.application.Application;
import com.ibm.websphere.simplicity.application.ApplicationManager;
import com.ibm.websphere.simplicity.cluster.ClusterConfig;
import com.ibm.websphere.simplicity.cluster.ClusterCreationOptions;
import com.ibm.websphere.simplicity.cluster.ClusterDeletionOptions;
import com.ibm.websphere.simplicity.cluster.ClusterType;
import com.ibm.websphere.simplicity.cluster.CreateReplicationDomain;
import com.ibm.websphere.simplicity.cluster.DeleteReplicationDomain;
import com.ibm.websphere.simplicity.commands.GetManagedNodeConnectorProperties;
import com.ibm.websphere.simplicity.commands.clusterconfig.CreateCluster;
import com.ibm.websphere.simplicity.commands.clusterconfig.DeleteCluster;
import com.ibm.websphere.simplicity.commands.clusterconfig.CreateCluster.ConvertServer;
import com.ibm.websphere.simplicity.commands.clusterconfig.CreateCluster.ReplicationDomain;
import com.ibm.websphere.simplicity.commands.jobmanagernode.GetManagedNodeProperties;
import com.ibm.websphere.simplicity.commands.jobmanagernode.QueryManagedNodes;
import com.ibm.websphere.simplicity.commands.nodegroup.CreateNodeGroup;
import com.ibm.websphere.simplicity.commands.nodegroup.RemoveNodeGroup;
import com.ibm.websphere.simplicity.commands.profile.GetProfileKey;
import com.ibm.websphere.simplicity.config.ConfigObject;
import com.ibm.websphere.simplicity.config.Configurable;
import com.ibm.websphere.simplicity.config.SecurityConfiguration;
import com.ibm.websphere.simplicity.config.securitydomain.SecurityDomain;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.ConfigType;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;
import com.ibm.websphere.simplicity.provider.websphere.CellOperationsProvider;
import com.ibm.websphere.simplicity.provider.websphere.ConfigurationOperationsProvider;
import com.ibm.websphere.simplicity.runtime.ProcessStatus;
import com.ibm.websphere.simplicity.util.ApplicationServerInstanceFilter;
import com.ibm.websphere.simplicity.util.CollectionUtility;

/**
 * This class represents a WebSphere cell. The Cell instance of {@link Scope},
 * being the highest, can see and affect all other scopes in the topology. A
 * Cell is logical structural entity used to group other entities such as
 * {@link Node}s, {@link Cluster}s, and {@link NodeGroup}s.
 */
public class Cell extends Scope implements Configurable {

    private static Class<?>       c                    = Cell.class;
    private static final String   CHANGE_KEY_CLUSTER   = "cluster";
    private static final String   CHANGE_KEY_NODEGROUP = "nodegroup";

    private Set<Cluster>          clusters;
    private Set<Node>             nodes;
    private Set<Node>             managedNodes;
    private Set<NodeGroup>        nodeGroups;
    private SecurityConfiguration securityConfiguration;
    private ApplicationServer     manager;
    private ApplicationManager    applicationManager   = null;
    private WebSphereTopologyType topology;
    private String                profileKey;                        // job
    // manager only
    private boolean               profileKeyInit       = false;      // job
    // manager only
    protected Workspace           workspace;

    /**
     * Constructor
     * 
     * @param configId The {@link ConfigIdentifier} that uniquely identifies
     *            this Cell
     * @param connInfo The {@link ConnectionInfo} that holds data on how to
     *            connect to the Cell
     */
    public Cell(ConfigIdentifier configId, ConnectionInfo connInfo) {
        super(configId, connInfo, null);
        this.cell = this;
    }

    @Override
    public String getObjectNameFragment() {
        return "WebSphere:cell=" + this.getName();
    }

    @Override
    public ScopeHelper getScopeHelper() {
        return new ScopeHelper(this);
    }

    @Override
    public String getConfigPath() throws Exception {
        return "$(USER_INSTALL_ROOT)/config/cells/" + this.name + "/";
    }

    /**
     * Get the {@link ApplicationManager} for the cell. The ApplicationManager
     * can be used to obtain {@link Application} instances.
     * 
     * @return The {@link ApplicationManager} for the cell.
     * @throws Exception
     */
    public ApplicationManager getApplicationManager() throws Exception {
        if (applicationManager == null)
            applicationManager = new ApplicationManager(this);
        return applicationManager;
    }

    /**
     * Get the {@link Cluster}s in this cell. A {@link Cluster} is a logical
     * entity for a group of servers and provides features such as load
     * balancing for those servers.
     * 
     * @return A Set of {@link Cluster}s in this cell
     * @throws Exception
     */
    public Set<Cluster> getClusters() throws Exception {
        final String method = "getClusters";
        Log.entering(c, method);
        if (this.clusters == null) {
            Log.finer(c, method, "Initializing clusters.");
            if (!Topology.isTopologyCachingEnabled() || !Topology.getBootstrapFileOps()
                .cacheComplete(this.getBootstrapFileKey())) {
                Log.finer(c, method, "Loading clusters.");
                loadClusters();
            } else {
                Log.finer(c, method, "No clusters exist. Creating empty set.");
                this.clusters = new HashSet<Cluster>();
            }
        }
        Log.exiting(c, method, this.clusters);
        return new HashSet<Cluster>(this.clusters);
    }

    /**
     * Get a specific {@link Cluster} in this cell that has the specified name.
     * 
     * @param name The name of the cluster to get
     * @return The existing {@link Cluster} in this cell that has the specified
     *         name or null if no cluster exists with the name.
     * @throws Exception
     */
    public Cluster getClusterByName(String name) throws Exception {
        final String method = "getClusterByName";
        Log.entering(c, method, name);
        for (Cluster c : getClusters()) {
            Log.finest(Cell.c, method, "Current cluster name: " + c.getName());
            if (c.getName().equalsIgnoreCase(name)) {
                Log.finer(Cell.c, method, "Found a cluster with name " + name);
                Log.exiting(Cell.c, method, c);
                return c;
            }
        }

        Log.exiting(c, method, null);
        return null;
    }

    /**
     * Get the {@link Server}s that exist in this cell across all {@link Node}s
     * in the cell.
     * 
     * @return A Set of {@link Server}s in the cell
     * @throws Exception
     */
    public Set<Server> getServers() throws Exception {
        final String method = "getServers";
        Log.entering(c, method);
        Set<Server> ret = new HashSet<Server>();
        for (Node n : this.getNodes()) {
            ret.addAll(n.getServers());
        }
        Log.exiting(c, method, ret);
        return ret;
    }

    /**
     * Get a specific {@link Server}
     * 
     * @param name The name of the server to get
     * @return The {@link Server} with the specified name or null if no Server
     *         with the name exists
     * @throws Exception
     */
    public Server getServerByName(String name) throws Exception {
        final String method = "getServerByName";
        Log.entering(c, method, name);
        Set<Server> servers = getServers();
        for (Server server : servers) {
            if (server.getName().equals(name)) {
                Log.exiting(c, method, server);
                return server;
            }
        }
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
        Set<Node> nodes = getNodes();
        for (Node node : nodes) {
            ret.addAll(node.getServersByType(type));
        }
        Log.exiting(c, method, ret);
        return ret;
    }

    /**
     * Get the {@link ApplicationServer} in this cell that is definined in the
     * bootstrapping property file by the specified bootstrap key
     * 
     * @param bootstrapKey The bootstrap key that defines the server in the
     *            bootstrap file
     * @return The {@link ApplicationServer} that is defined by the bootstrap
     *         key in the bootstrap file or null if there is not a server
     *         defined by the bootstrap key
     * @throws Exception
     * @see BootStrappingFileOperations
     * @see BootStrappingProperty
     */
    protected ApplicationServer getServerByBootstrapKey(String bootstrapKey) throws Exception {
        final String method = "getServerByBootstrapKey";
        Log.entering(c, method, bootstrapKey);
        for (Server server : getServers()) {
            if (server.getServerType() == ServerType.APPLICATION_SERVER) {
                Log.finest(c, method, "Current server bootstrap key: " + server
                    .getBootstrapFileKey());
                if (server.getBootstrapFileKey() != null && server.getBootstrapFileKey()
                    .equals(bootstrapKey)) {
                    Log.finer(c, method, "Found a server with a matching bootstrap key.");
                    Log.exiting(c, method, server);
                    return (ApplicationServer)server;
                }
            }
        }
        Log.finer(c, method, "No server found with matching bootsrap key");
        Log.exiting(c, method, null);
        return null;
    }

    /**
     * Get the {@link Node}s that exist in this cell
     * 
     * @return A Set of {@link Node}s in the cell
     * @throws Exception
     */
    public Set<Node> getNodes() throws Exception {
        final String method = "getNodes";
        Log.entering(c, method);
        if (this.nodes == null) {
            Log.finer(c, method, "Initializing nodes.");
            if (!Topology.isTopologyCachingEnabled() || !Topology.getBootstrapFileOps()
                .cacheComplete(this.getBootstrapFileKey())) {
                Log.finer(c, method, "Loading nodes.");
                loadNodes();
            } else {
                Log.finer(c, method, "No nodes exist. Creating empty set.");
                this.nodes = new HashSet<Node>();
            }
        }
        Log.exiting(c, method, this.nodes);
        return this.nodes;
    }

    /**
     * Returns a list of cells that are managed by this cell. This is only
     * applicable to admin agent and job manager cells; all other types will
     * return null. While WebSphere Application Server traditionally calls them
     * managed "nodes", each of the managed nodes is, in fact, an independent
     * cell in its own right.
     * 
     * @return A Set of cells managed by an admin agent
     * @throws Exception
     */
    public Set<Node> getManagedNodes() throws Exception {
        final String method = "getManagedNodes";
        Log.entering(c, method);
        if (this.managedNodes == null) {
            Log.finer(c, method, "Initializing nodes.");
            if (!Topology.isTopologyCachingEnabled() || !Topology.getBootstrapFileOps()
                .cacheComplete(this.getBootstrapFileKey())) {
                Log.finer(c, method, "Loading managed nodes.");
                loadManagedNodes();
            } else {
                Log.finer(c, method, "No nodes exist. Creating empty set.");
                this.managedNodes = new HashSet<Node>();
            }
        }
        Log.exiting(c, method, this.managedNodes);
        return this.managedNodes;
    }

    public String getProfileKey() throws Exception {
        if (!this.profileKeyInit) {
            try {
                this.profileKeyInit = true;
                if (this.getTopologyType().equals(WebSphereTopologyType.BASE)) {
                    ConfigObject co = ConfigObject.getConfigObject(this, "AdminAgentRegistration");
                    this.profileKey = co.getAttributeByName("UUID").getValueAsString();
                } else {
                    GetProfileKey task = new GetProfileKey();
                    this.profileKey = (String)task.run(this).getResult();
                }
            } catch (Exception e) {
                // Swallow exception, return null for non-managed nodes
            }
        }
        return this.profileKey;
    }

    /**
     * Get a List of sorted Nodes
     * 
     * @param c The Comparator that defines how to sort the Nodes
     * @return A List containing the Nodes in the Cell in sorted order
     * @throws Exception
     */
    public List<Node> getNodes(Comparator<Node> c) throws Exception {
        return CollectionUtility.sort(getNodes(), c);
    }

    /**
     * Get a specific {@link Node} in this cell that has the specified name
     * 
     * @param name The name of the node to get
     * @return The existing {@link Node} in this cell that has the specified
     *         name or null if there is no {@link Node} with the name
     * @throws Exception
     */
    public Node getNodeByName(String name) throws Exception {
        final String method = "getNodeByName";
        Log.entering(c, method, name);
        for (Node n : this.getNodes()) {
            Log.finest(c, method, "Current node name: " + n.getName());
            if (n.getName().equalsIgnoreCase(name)) {
                Log.finer(c, method, "Found a node with matching name.");
                Log.exiting(c, method, n);
                return n;
            }
        }
        Log.finer(c, method, "No node found with matching name.");
        Log.exiting(c, method, null);
        return null;
    }

    /**
     * Get the {@link NodeGroup}s that exist in this cell
     * 
     * @return A Set {@link NodeGroup}s in the cell
     * @throws Exception
     */
    public Set<NodeGroup> getNodeGroups() throws Exception {
        final String method = "getNodeGroups";
        Log.entering(c, method);
        if (this.nodeGroups == null) {
            Log.finer(c, method, "Loading node groups.");
            loadNodeGroups();
        }
        Log.exiting(c, method, this.nodeGroups);
        return new HashSet<NodeGroup>(this.nodeGroups);
    }

    /**
     * Get a specific {@link NodeGroup} in this cell that has the specified
     * name. If no nodegroup exists with the name, null is returned.
     * 
     * @param name The name of the node group to get
     * @return The existing {@link NodeGroup} in this cell that has the
     *         specified name or null if non exists
     * @throws Exception
     */
    public NodeGroup getNodeGroupByName(String name) throws Exception {
        final String method = "getNodeGroupByName";
        Log.entering(c, method, name);
        for (NodeGroup ng : getNodeGroups()) {
            Log.finest(c, method, "Current node group name: " + ng.getName());
            if (ng.getName().equalsIgnoreCase(name)) {
                Log.finer(c, method, "Found node group with matching name.");
                Log.exiting(c, method, ng);
                return ng;
            }
        }
        Log.exiting(c, method, null);
        return null;
    }

    /**
     * Get the {@link SecurityConfiguration} for this cell. The
     * {@link SecurityConfiguration} can be used to configure security settings
     * for the cell
     * 
     * @return A {@link SecurityConfiguration} instance
     */
    public SecurityConfiguration getSecurityConfiguration() throws Exception {
        if (this.securityConfiguration == null)
            this.securityConfiguration = new SecurityConfiguration(this);
        return this.securityConfiguration;
    }

    /**
     * Get the management {@link ApplicationServer} for this cell. This is
     * defined as the {@link Dmgr} server if the topology is
     * {@link WebSphereTopologyType#ND}, the BASE {@link ApplicationServer} if
     * the topology is {@link WebSphereTopologyType#BASE}, the
     * {@link AdminAgent} server if the topology is
     * {@link WebSphereTopologyType#ADMIN_AGENT}, or the {@link JobManager}
     * server if the topology is {@link WebSphereTopologyType#FLEX}.
     * 
     * @return The manager server based on the above definition or null if the
     *         defined server type cannot be found.
     */
    public ApplicationServer getManager() throws Exception {
        final String method = "getManager";
        Log.entering(c, method);
        if (this.manager == null) {
            Log.finer(c, method, "Manager is currently null. Finding manager.");
            Set<Server> list = this.getServers();
            for (Server ep : list) {
                Log.finest(c, method, "Current server type: " + ep.getServerType());
                if ((ep instanceof Dmgr) || (ep instanceof AdminAgent)
                    || (ep instanceof JobManager)) {
                    Log.finer(c, method, "Found manager of type " + ep.getServerType());
                    manager = (ApplicationServer)ep;
                    break;
                }
            }
            if (manager == null) {
                Log.finer(c, method, "No manager found. Checking for base server.");
                /*
                 * Do not assign |manager| here. It causes havoc during
                 * initialization for some ND scenarios. If non-dmgr nodes are
                 * initialized first, they can end up being assigned as the
                 * manager, which is a bad thing. Until we actually find a
                 * manager we'll just return an appserver. We need to return the
                 * same one each time so that in a mixed cell we don't run into
                 * differences with config IDs.
                 */
                Set<Server> appServers =
                    CollectionUtility.filter(list, new ApplicationServerInstanceFilter());
                if (appServers.size() > 0) {
                    ApplicationServer ret = null;
                    for (Server s : appServers)
                        if (ret == null || ret.getNode().getBaseProductVersion().toString()
                            .compareTo(s.getNode().getBaseProductVersion().toString()) < 1)
                            ret = (ApplicationServer)s;
                    Log.exiting(c, method, ret);
                    return ret;
                }
            }
        }
        Log.exiting(c, method, this.manager);
        return manager;
    }

    /**
     * Get the {@link WebSphereTopologyType} for this cell
     * 
     * @return The {@link WebSphereTopologyType}
     * @throws Exception
     */
    public WebSphereTopologyType getTopologyType() throws Exception {
        final String method = "getTopologyType";
        Log.entering(c, method);
        if (this.topology == null) {
            Log.finer(c, method, "Setting topology type.");
            setTopologyType(getManager().getServerType().toTopologyType());
        }
        Log.exiting(c, method, this.topology);
        return this.topology;
    }

    /**
     * Set the topology type
     * 
     * @param topology The {@link WebSphereTopologyType} for this Cell
     */
    void setTopologyType(WebSphereTopologyType topology) {
        this.topology = topology;
    }

    /**
     * Start all the servers in the cell. The Cell manager is started first. For
     * each node, the node manager is started followed by the remaining servers
     * on the node.
     * 
     * @param mbeanWaitDuration The maximum time to wait (in seconds) for the
     *            server to activate mbeans (slower servers take longer). This
     *            is a per server value
     * @throws Exception
     */
    public void start(int mbeanWaitDuration) throws Exception {
        final String method = "start";
        Log.entering(c, method, mbeanWaitDuration);

        Log.finer(c, method, "Starting Cell " + this.getName() + ".");
        Exception e1 = null;

        // first start the cell manager
        Log.finer(c, method, "Staring the cell manager.");
        ApplicationServer cellManager = this.getManager();
        try {
            cellManager.start(mbeanWaitDuration);
        } catch (Exception e) {
            e1 = e;
        }

        ApplicationServer nodeManager = null;
        for (Node node : this.getNodes()) {
            nodeManager = node.getManager();
            // first start the node manager
            if (nodeManager != cellManager) {
                Log.finer(c, method, "Starting the manager for node " + node.getName());
                try {
                    nodeManager.start(mbeanWaitDuration);
                } catch (Exception e) {
                    if (e1 == null)
                        e1 = e;
                }
            }
            Log.finer(c, method, "Starting any remaining servers on the node.");
            for (Server server : node.getServers()) {
                if (server != nodeManager && server != cellManager) {
                    try {
                        server.start(mbeanWaitDuration);
                    } catch (Exception e) {
                        if (e1 == null)
                            e1 = e;
                    }
                }
            }
        }

        if (e1 != null)
            throw e1;

        Log.finer(c, method, "Cell " + this.getName() + " started.");

        Log.exiting(c, method);
    }

    /**
     * Start all the servers in the cell. The Cell manager is started first. For
     * each node, the node manager is started followed by the remaining servers
     * on the node.
     * 
     * @throws Exception
     */
    public void start() throws Exception {
        start(120);
    }

    /**
     * Stop all the servers in the cell.
     * 
     * @param timeout The time to wait (in seconds). This is a per server value.
     * @throws Exception
     */
    public void stop(long timeout) throws Exception {
        final String method = "stop";
        Log.entering(c, method, timeout);

        Log.finer(c, method, "Stopping Cell " + this.getName());
        Exception e1 = null;

        // this is going to make us lose our admin connection. We need to stop
        // non-managers first, followed by node managers, followed by the cell
        // manager
        ApplicationServer cellManager = this.getManager();
        ApplicationServer nodeManager = null;

        for (Node node : this.getNodes()) {
            nodeManager = node.getManager();
            // first non-manager servers
            Log.finer(c, method, "Stopping all the non-manager servers for node " + node.getName());
            for (Server server : node.getServers()) {
                if (server != nodeManager && server != cellManager) {
                    try {
                        server.stop(timeout);
                    } catch (Exception e) {
                        if (e1 == null)
                            e1 = e;
                    }
                }
            }
            // now the node manager
            if (nodeManager != cellManager) {
                Log.finer(c, method, "Stopping the manager for node " + node.getName());
                try {
                    nodeManager.stop(timeout);
                } catch (Exception e) {
                    if (e1 == null)
                        e1 = e;
                }
            }
        }
        // lastly the cell manager
        Log.finer(c, method, "Stopping the cell manager.");
        try {
            cellManager.stop(timeout);
        } catch (Exception e) {
            if (e1 == null)
                e1 = e;
        }

        if (e1 != null)
            throw e1;

        Log.finer(c, method, "Cell " + this.getName() + " stopped.");

        Log.exiting(c, method);
    }

    /**
     * Stop all the servers in the cell.
     * 
     * @throws Exception
     */
    public void stop() throws Exception {
        stop(600);
    }

    /**
     * Restarts all servers in the cell. All servers should be running at the
     * end.
     * 
     * @throws Exception
     */
    public void restart() throws Exception {
        stop();
        start();
    }

    /**
     * Restarts all servers in the cell. All servers should be running at the
     * end.
     * 
     * @param timeout The timeout in seconds for each of stop and start
     *            duration.
     * @throws Exception
     */
    public void restart(long timeout) throws Exception {
        stop(timeout);
        start((int)timeout);
    }

    /**
     * Stops and starts all of the servers currently started in the cell. Note
     * that this implementation may be slower than calling restart().
     * 
     * @throws Exception
     */
    public void restartRunningServers() throws Exception {
        restartRunningServers(150);
    }

    /**
     * Stops and starts all of the servers currently started in the cell. Note
     * that this implementation may be slower than calling restart().
     * 
     * @param timeout The timeout in seconds for each of stop and start
     *            duration.
     * @throws Exception
     */
    public void restartRunningServers(int timeout) throws Exception {
        List<Server> running = new ArrayList<Server>();
        for (Server server : getServers()) {
            if (server.getServerStatus().equals(ProcessStatus.RUNNING))
                running.add(server);
        }

        // Follow proper procedure for stopping & starting servers
        ApplicationServer cellmgr = this.getManager();
        for (Server server : running) {
            if (server != cellmgr && server != server.getNode().getManager())
                server.stop(timeout);
        }
        for (Server server : running) {
            if (server != cellmgr && server == server.getNode().getManager())
                server.stop(timeout);
        }
        cellmgr.stop(timeout);

        cellmgr.start(timeout);
        for (Server server : running) {
            if (server != cellmgr && server == server.getNode().getManager())
                server.start(timeout);
        }
        for (Server server : running) {
            if (server != cellmgr && server != server.getNode().getManager())
                server.start(timeout);
        }
    }

    /**
     * This method creates an empty {@link Cluster}. The cluster is created in
     * the WebSphere configuration and in the topology Object model.
     * 
     * @param clusterName The name of the cluster to create.
     * @return An {@link OperationResults} Object containing the new
     *         {@link Cluster} for the result
     * @throws Exception
     */
    public OperationResults<Cluster> createCluster(String clusterName) throws Exception {
        ClusterCreationOptions options = new ClusterCreationOptions();
        options.getClusterConfigOptions().setClusterName(clusterName);
        return createCluster(options);
    }

    /**
     * This method creates a cluster using the specified options. The cluster is
     * created in the WebSphere configuration and in the topology Object model.
     * 
     * @param options The options to use when creating the cluster
     * @return An {@link OperationResults} Object containing the new
     *         {@link Cluster} for the result
     * @throws Exception
     */
    public OperationResults<Cluster> createCluster(ClusterCreationOptions options) throws Exception {
        final String method = "createCluster";
        Log.entering(c, method, options);

        if (options.getClusterConfigOptions() == null || options.getClusterConfigOptions()
            .getClusterName() == null) {
            throw new IllegalArgumentException(
                                               "At a minimum the clusterName options must be specified.");
        }

        getWorkspace().registerConfigChange(this, CHANGE_KEY_CLUSTER, getClusters());

        CreateCluster task = new CreateCluster();
        // cluster config
        ClusterConfig clusterConfig = options.getClusterConfigOptions();
        com.ibm.websphere.simplicity.commands.clusterconfig.CreateCluster.ClusterConfig cfg =
            new CreateCluster.ClusterConfig(clusterConfig.getClusterName());
        cfg.setClusterName(clusterConfig.getClusterName());
        cfg.setClusterType(clusterConfig.getClusterType().toString());
        cfg.setPreferLocal(clusterConfig.getPreferLocal());
        if (clusterConfig.getShortName() != null)
            cfg.setShortName(clusterConfig.getShortName());
        // replication domain
        ReplicationDomain repDomain = null;
        if (options.getReplicationDomainOptions() != null) {
            repDomain = new CreateCluster.ReplicationDomain();
            CreateReplicationDomain ops = options.getReplicationDomainOptions();
            repDomain.setCreateDomain(ops.getCreateDomain());
        }
        // convert server
        ConvertServer cs = null;
        if (options.getConvertServerOptions() != null && options.getConvertServerOptions()
            .getServer() != null) {
            com.ibm.websphere.simplicity.cluster.ConvertServer ops =
                options.getConvertServerOptions();
            cs = new CreateCluster.ConvertServer(true);
            cs.setServerNode(ops.getServer().getNodeName());
            cs.setServerName(ops.getServer().getName());
            cs.setMemberWeight(ops.getMemberWeight());
            if (ops.getNodeGroup() != null)
                cs.setNodeGroup(ops.getNodeGroup().getName());
            cs.setReplicatorEntry(ops.getReplicatorEntry());
        }
        Object result = task.run(this, cfg, repDomain, cs, null, null);

        OperationResults<ConfigIdentifier> configId =
            OperationsProviderFactory.getProvider().getCellOperationsProvider()
                .createCluster(result);
        Cluster cluster = null;
        OperationResults<Cluster> results = new OperationResults<Cluster>();
        OperationResults.setOperationResults(results, configId);

        cluster =
            new Cluster(configId.getResult(), this, options.getClusterConfigOptions()
                .getClusterType());
        results.setResult(cluster);
        addCluster(cluster);
        if (options.getConvertServerOptions().getServer() != null) {
            cluster.addMember(options.getConvertServerOptions().getServer());
        }
        Log.finer(c, method, "Cluster created.");

        // cache
        if (Topology.isTopologyCachingEnabled()) {
            Log.finer(c, method, "Rewriting cache with new cluster.");
            Topology.getBootstrapFileOps().cache(this);
        }

        Log.exiting(c, method, results);
        return results;
    }

    /**
     * This method deletes this cluster and all members from the parent
     * {@link Cell}
     * 
     * @param clusterName The name of the cluster to delete
     * @throws Exception
     */
    public void deleteCluster(String clusterName) throws Exception {
        this.deleteCluster(clusterName, new ClusterDeletionOptions());
    }

    /**
     * This method deletes the cluster and all members from the parent
     * {@link Cell} using the specified options
     * 
     * @param clusterName The name of the cluster to delete
     * @param options The options to use when deleting the cluster
     * @throws Exception
     */
    public void deleteCluster(String clusterName, ClusterDeletionOptions options) throws Exception {
        final String method = "deleteCluster";
        Log.entering(c, method, new Object[] {clusterName, options});
        Cluster cluster = this.getClusterByName(clusterName);
        if (cluster == null) {
            throw new Exception("A cluster with name " + clusterName + " does not exist.");
        }

        // make sure cluster members are cached in memory to avoid problems
        // removing them
        for (Server member : cluster.getMembers()) {
            getWorkspace().registerConfigChange(member.getNode(),
                                                Node.CHANGE_KEY_SERVERS,
                                                member.getNode().getServers());
        }
        getWorkspace().registerConfigChange(this, CHANGE_KEY_CLUSTER, getClusters());

        Log.finer(c, method, "Deleting the cluster in WAS.");
        DeleteCluster task = new DeleteCluster(null);
        task.setClusterName(clusterName);
        com.ibm.websphere.simplicity.commands.clusterconfig.DeleteCluster.ReplicationDomain repDomain =
            null;
        if (options.getReplicationDomainOptions() != null) {
            repDomain = new DeleteCluster.ReplicationDomain();
            DeleteReplicationDomain ops = options.getReplicationDomainOptions();
            repDomain.setDeleteRepDomain(ops.getDeleteDomain());
        }
        task.run(this, repDomain, null);
        Log.finer(c, method, "Deleting the cluster from the Object model.");

        // update Object model
        for (Server member : cluster.getMembers()) {
            member.getNode().removeServer(member);
        }
        this.removeCluster(cluster);

        // cache
        if (Topology.isTopologyCachingEnabled()) {
            Log.finer(c, method, "Rewriting the cache with the cluster deleted.");
            Topology.getBootstrapFileOps().cache(this);
        }

        Log.exiting(c, method);
    }

    /**
     * This method creates an empty node group. The node group is created in the
     * WebSphere config and in the topology Object model.
     * 
     * @param name The name of the node group to create
     * @param description The description of the node group to create
     * @return An {@link OperationResults} Object containing the new
     *         {@link NodeGroup} for the result
     * @throws Exception
     */
    public OperationResults<NodeGroup> createNodeGroup(String name, String description)
        throws Exception {
        final String method = "createNodeGroup";
        Log.entering(c, method, new Object[] {name, description});
        if (name == null || name.length() < 1) {
            throw new IllegalArgumentException(
                                               "Name must not be null and have length greater than 0");
        }

        getWorkspace().registerConfigChange(this, CHANGE_KEY_NODEGROUP, getNodeGroups());

        CreateNodeGroup task = new CreateNodeGroup(name);
        task.setDescription(description);
        Object result = task.run(this);

        OperationResults<ConfigIdentifier> configId =
            OperationsProviderFactory.getProvider().getCellOperationsProvider()
                .createNodeGroup(result);
        NodeGroup ng = null;
        OperationResults<NodeGroup> results = new OperationResults<NodeGroup>();
        OperationResults.setOperationResults(results, configId);
        ng = new NodeGroup(configId.getResult(), this);
        results.setResult(ng);
        this.addNodeGroup(ng);

        Log.exiting(c, method, results);
        return results;
    }

    /**
     * This method can be used to create a new connection used to administer the
     * Cell. When this method is called, the new connection data specified is
     * placed on a stack and becomes the current connection. An actual physical
     * connection is made. Any administrative calls made using the Simplicity
     * api will use this current connection at the top of the stack. Every time
     * this method is called, the information specified in the call becomes
     * current, is placed at the top of the stack. Use the
     * {@link #popConnection()} method to "pop" the connection stack and revert
     * to the previous connection information. Use the
     * {@link #popAllConnections()} method to clear the stack and use the
     * initial connection information used to boostrap the Cell.
     * 
     * @param connType The type of connection to make
     * @param username The username to use in the new connection
     * @param password The password to use in the new connection
     * @throws Exception
     */
    public void pushConnection(ConnectorType connType, String username, String password)
        throws Exception {
        final String method = "pushConnection";
        Log.entering(c, method, new Object[] {connType, username, password});
        Integer port = null;
        if (connType != ConnectorType.NONE) {
            port = this.getManager().getPortNumber(connType);
            Log.finer(c, method, "port: " + port);
        }
        pushConnection(connType, port, username, password);
        Log.exiting(c, method);
    }

    /**
     * This method can be used to change the administrative connection used to
     * administer the Cell. When this method is called, the new connection data
     * specified is placed on a stack and becomes the current connection data. A
     * new administrative connection is then established using the new
     * connection information. Every time this method is called, the information
     * specified in the call becomes current is placed at the top of the stack.
     * Use the {@link #popConnection()} to "pop" the connection stack and revert
     * to the previous connection information. Use the
     * {@link #popAllConnections()} method to clear the stack and use the
     * initial connection information used to boostrap the Cell.<br>
     * 
     * @param connType The type of connection to make
     * @param port The port to use when connecting
     * @param username The username to use in the new connection
     * @param password The password to use in the new connection
     * @throws Exception
     */
    public void pushConnection(ConnectorType connType,
                               Integer port,
                               String username,
                               String password) throws Exception {
        final String method = "pushConnection";
        Log.entering(c, method, new Object[] {connType, port, username, password});
        // set the connection info
        ConnectionInfo next = (ConnectionInfo)getConnInfo().clone();
        next.setConnType(connType);
        next.setUser(username);
        next.setPassword(password);
        next.setPort(port);
        this.connectionData.push(next);
        Log.exiting(c, method);
    }

    /**
     * This method can be used to change the administrative connection used to
     * administer the Cell. When this method is called, the new connection data
     * specified is placed on a stack and becomes the current connection data. A
     * new administrative connection is then established using the new
     * connection information. Every time this method is called, the information
     * specified in the call becomes current is placed at the top of the stack.
     * Use the {@link #popConnection()} to "pop" the connection stack and revert
     * to the previous connection information. Use the
     * {@link #popAllConnections()} method to clear the stack and use the
     * initial connection information used to boostrap the Cell.<br>
     * 
     * @param connInfo The {@link ConnectionInfo} that has information needed to
     *            make an admin connection
     * @throws Exception
     */
    public void pushConnection(ConnectionInfo connInfo) throws Exception {
        final String method = "pushConnection";
        Log.entering(c, method, new Object[] {connInfo});
        ConnectionInfo next = (ConnectionInfo)getConnInfo().clone();
        next.setConnType(connInfo.getConnType());
        next.setUser(connInfo.getUser());
        next.setPassword(connInfo.getPassword());
        next.setPort(connInfo.getPort());
        this.connectionData.push(next);
        Log.exiting(c, method);
    }

    /**
     * Use this method to revert back to the initial connection information used
     * to boostrapt the Cell. This method closes all connections. Next, it
     * clears the connection information stack built up using calls to the
     * {@link #pushConnection(ConnectorType, String, String)} and
     * {@link #pushConnection(ConnectionInfo)} methods, leaving only the initial
     * connection.
     * 
     * @throws Exception
     */
    public void popAllConnections() throws Exception {
        final String method = "popAllConnections";
        Log.entering(c, method);
        do {
            if (this.isConnected()) {
                Log.finer(c, method, "Closing current connection.");
                this.disconnect();
            }
            Log.finer(c, method, "Popping current connection.");
        } while (this.connectionData.pop() != null);
    }

    /**
     * Make an administrative connection to manage the Cell.
     * 
     * @throws Exception
     */
    public void connect() throws Exception {
        final String method = "connect";
        Log.entering(c, method);
        if (!this.isConnected()) {
            Log.finer(c, method, "Making a connection to the cell.");
            OperationsProviderFactory.getProvider().getCellOperationsProvider()
                .connect(this, getConnInfo());
        }
        Log.exiting(c, method);
    }

    /**
     * Shut down the administrative connection to manage the Cell.<br/>
     * Note that if the administrative connection is closed and a method call is
     * made in which a connection is needed, the providers will implicitly open
     * a connection using the current connection information.
     * 
     * @throws Exception
     */
    public void disconnect() throws Exception {
        final String method = "disconnect";
        Log.entering(c, method);
        if (this.isConnected()) {
            Log.finer(c, method, "Disconnecting the cell.");
            OperationsProviderFactory.getProvider().getCellOperationsProvider()
                .disconnect(this, getConnInfo());
        }
        Log.exiting(c, method);
    }

    /**
     * Returns true if there is currently a live connection to administer the
     * Cell
     * 
     * @return true If there is currently a live connection to administer the
     *         Cell
     * @throws Exception
     */
    public boolean isConnected() throws Exception {
        final String method = "isConnected";
        Log.entering(c, method);
        boolean connected =
            OperationsProviderFactory.getProvider().getCellOperationsProvider()
                .isConnected(this, getConnInfo());
        Log.exiting(c, method, connected);
        return connected;
    }

    /**
     * This method can be used to revert back to the previous connection
     * information used to administer the Cell. This method first closes the
     * current administrative connection. It then "pops" the current connection
     * information off of the connection information stack built up using calls
     * to the {@link #pushConnection(ConnectorType, String, String)} and
     * {@link #pushConnection(ConnectionInfo)} methods, making the previous
     * connection information current.<br>
     * Note that the connection information used to initially bootstrap the Cell
     * cannot be removed from the connection information stack. This method
     * returns true if the current connection information was removed.
     * 
     * @return true If the current connection information was removed. The
     *         initial connection information used to bootstrap the Cell cannot
     *         be removed if current.
     * @throws Exception
     */
    public boolean popConnection() throws Exception {
        final String method = "popConnection";
        Log.entering(c, method);
        if (this.isConnected()) {
            Log.finer(c, method, "Closing the current connection.");
            this.disconnect();
        }

        boolean ret = (this.connectionData.pop() != null);
        Log.exiting(c, method, ret);
        return ret;
    }

    /**
     * This method deletes a NodeGroup. Note that a non-empty NodeGroup and the
     * DefaultNodeGroup cannot be deleted.
     * 
     * @param nodeGroupName The name of the node group to delete
     * @throws Exception
     */
    public void deleteNodeGroup(String nodeGroupName) throws Exception {
        final String method = "deleteNodeGroup";
        Log.entering(c, method, nodeGroupName);
        NodeGroup ng = this.getNodeGroupByName(nodeGroupName);
        if (ng == null) {
            throw new Exception("A node group with name " + nodeGroupName + " does not exist.");
        }

        getWorkspace().registerConfigChange(this, CHANGE_KEY_NODEGROUP, getNodeGroups());

        Log.finer(c, method, "Deleting the node group in WAS.");
        RemoveNodeGroup task = new RemoveNodeGroup(nodeGroupName);
        task.run(this);
        Log.finer(c, method, "Removing the node group from the Object model.");
        this.removeNodeGroup(ng);
        Log.exiting(c, method);
    }

    /**
     * This method clears all cached data for this Cell. Further requests for
     * information will be loaded fresh from the WAS instance.
     * <p>
     * WARNING!!! Calling this method invalidates all pointers to any Simplicity
     * objects obtained from the Cell and its children. Only call this method if
     * you absolutely want to reset the topology object model underneath this
     * Cell.
     * 
     * @throws Exception
     */
    public void resetCell() throws Exception {
        final String method = "resetCell";
        Log.entering(c, method);

        Log.finer(c, method, "Resetting all the \"child\" private data of this Cell.");
        this.managedNodes = null;
        this.applicationManager = null;
        this.clusters = null;
        this.nodes = null;
        this.nodeGroups = null;
        this.securityConfiguration = null;
        this.manager = null;
        this.topology = null;

        if (Topology.isTopologyCachingEnabled()) {
            Topology.getBootstrapFileOps().cache(this);
        }

        Log.exiting(c, method);
    }

    @Override
    public SecurityDomain getSecurityDomain() throws Exception {
        return super.getSecurityDomain();
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
     * <p>
     * Note that the cell does not contain many variables, so most expansions
     * will result in empty values.
     * 
     * @param str A string that contains zero or more variables.
     * @return The fully-expanded version of the string.
     * @throws Exception
     */
    public String expandString(String str) throws Exception {
        return Scope.expandString(this, str);
    }

    /**
     * Add a {@link Node} to this cells private Set
     * 
     * @param node The {@link Node} to add
     * @throws Exception
     */
    protected void addNode(Node node) throws Exception {
        if (this.getNodeByName(node.getName()) != null)
            return;
        this.nodes.add(node);
    }

    /**
     * Add a {@link NodeGroup} to this cell's private list
     * 
     * @param ng The {@link NodeGroup} to add
     */
    protected void addNodeGroup(NodeGroup ng) throws Exception {
        if (this.getNodeGroupByName(ng.getName()) != null)
            return;
        this.nodeGroups.add(ng);
    }

    /**
     * Remove a {@link NodeGroup} from this cell's private list
     * 
     * @param ng The {@link NodeGroup} to remove
     */
    protected void removeNodeGroup(NodeGroup ng) throws Exception {
        NodeGroup remove = this.getNodeGroupByName(ng.getName());
        if (remove == null) {
            return;
        }
        this.nodeGroups.remove(remove);
    }

    /**
     * Add a {@link Cluster} to this cell's private list
     * 
     * @param c The {@link Cluster} to add
     */
    protected void addCluster(Cluster c) throws Exception {
        if (this.getClusterByName(c.getName()) != null)
            return;
        this.clusters.add(c);
    }

    /**
     * Remove a {@link Cluster} from this cell's private list
     * 
     * @param c The {@link Cluster} to remove
     */
    protected void removeCluster(Cluster c) throws Exception {
        Cluster remove = getClusterByName(c.getName());
        if (remove != null) {
            this.clusters.remove(remove);
        }
    }

    /**
     * Delegate to the {@link ConfigurationOperationsProvider} to obtain a list
     * of {@link ConfigIdentifier}s for the {@link Cluster}s in the cell
     * 
     * @throws Exception
     */
    private void loadClusters() throws Exception {
        final String method = "loadClusters";
        Log.entering(c, method);
        this.clusters = new HashSet<Cluster>();
        ConfigIdentifier[] configIds =
            OperationsProviderFactory.getProvider().getConfigurationOperationsProvider()
                .queryConfigObjects(this,
                                    getActiveSession(),
                                    this.getConfigId(),
                                    ConfigType.SERVER_CLUSTER.getType());
        for (int i = 0; i < configIds.length; ++i) {
            Log.finer(c, method, "Creating cluster with configID " + configIds[i].getConfigId());
            // TODO Find cluster type
            Cluster cluster = new Cluster(configIds[i], this, ClusterType.APPLICATION_SERVER);
            this.clusters.add(cluster);
        }
        Log.exiting(c, method);
    }

    /**
     * Delegate to the {@link ConfigurationOperationsProvider} to obtain a list
     * of {@link ConfigIdentifier}s for the {@link Node}s in the cell
     * 
     * @throws Exception
     */
    private void loadNodes() throws Exception {
        final String method = "loadNodes";
        Log.entering(c, method);
        this.nodes = new HashSet<Node>();
        AbstractSession session = getWorkspace().getSession();
        ConfigIdentifier[] configIds =
            OperationsProviderFactory.getProvider().getConfigurationOperationsProvider()
                .queryConfigObjects(this, session, this.getConfigId(), ConfigType.NODE.getType());
        for (ConfigIdentifier cid : configIds) {
            Log.finer(c, method, "Creating node with configID " + cid.getConfigId());
            Node node = new Node(cid, this);
            if (node.getProfileDir() != null)
                this.nodes.add(node);
            else
                // TODO temporary until unmanaged support is added
                Log.finer(c, method, "Node with config Id " + cid
                    + " appears to be an unmananged node and is being excluded.");
        }
        Log.exiting(c, method);
    }

    private void loadManagedNodes() throws Exception {
        this.managedNodes = new HashSet<Node>();
        if (this.getTopologyType().equals(WebSphereTopologyType.ADMIN_AGENT))
            loadAdminAgentManagedNodes();
        else if (this.getTopologyType().equals(WebSphereTopologyType.FLEX))
            loadFlexManagedNodes();
    }

    /**
     * Retrieves names and connection properties for managed nodes in an admin
     * agent topology.
     */
    private void loadAdminAgentManagedNodes() throws Exception {
        List<ConfigObject> mnodes = ConfigObject.getConfigObjectList(this, "ManagedNode");
        for (ConfigObject mnode : mnodes) {
            String targetkey = null;
            String nodename = mnode.getAttributeByName("name").getValueAsString();

            List<ConfigObject> properties = mnode.getChildObjectsByDataType("Property");
            for (ConfigObject property : properties) {
                String pname = property.getAttributeByName("name").getValueAsString();
                String pvalue = property.getAttributeByName("value").getValueAsString();
                if (pname.equalsIgnoreCase("profile.registry.profile.key"))
                    targetkey = pvalue;
                else if (pname.equalsIgnoreCase("profile.registry.managed.node.name"))
                    nodename = pvalue;
            }

            List<Cell> cells = Topology.getCells();
            Cell target = null;
            for (Cell c : cells) {
                if (c.getProfileKey().equals(targetkey)) {
                    target = c;
                    break;
                }
            }

            if (target == null) {
                // we have to add the cell
                // this is a bad thing to do so late, particularly if the cell
                // reference
                // is in an iterator loop: there's no way to insert the cell
                // into the
                // array being iterated over. This registered node check should
                // be done
                // sooner, i.e. during topology initialization.
                // See Topology.connInfoInit(connInfo)
                throw new Exception(
                                    "All registered nodes must be listed in bootstrapping.properties");
            } else {
                ConnectionInfo existing = target.getConnInfo();
                GetManagedNodeConnectorProperties task =
                    new GetManagedNodeConnectorProperties(existing.getConnType().toString());
                task.setManagedNodeName(nodename);
                Object result = task.run(this).getResult();
                CellOperationsProvider cellops =
                    OperationsProviderFactory.getProvider().getCellOperationsProvider();
                Properties p = cellops.getManagedNodeConnectorProperties(result);
                int port = Integer.parseInt((String)p.getProperty("port"));

                // They may already be connected to the subsystem port
                if (target.getConnInfo().getPort() != port) {
                    target.disconnect();
                    target.pushConnection(existing.getConnType(),
                                          port,
                                          existing.getUser(),
                                          existing.getPassword());
                    target.connect();
                }
                // Identify the node as registered to the admin agent
                Node n = target.getNodes().iterator().next();
                n.setRegisteredToAdminAgent(this, nodename);
                this.managedNodes.add(n);
            }
        }
    }

    /**
     * Retrieves names and connection properties for managed nodes in a flex
     * topology.
     */
    private void loadFlexManagedNodes() throws Exception {
        final String method = "loadFlexManagedNodes";
        Log.entering(c, method);
        String key = this.getProfileKey();
        CellOperationsProvider cellops =
            OperationsProviderFactory.getProvider().getCellOperationsProvider();
        QueryManagedNodes task = new QueryManagedNodes(1000);
        Object result = task.run(this).getResult();
        List<String> aliases = cellops.queryManagedNodes(result);
        if (aliases == null) {
            throw new Exception("Unable to obtain a list of aliases for job mgr");
        }
        if(aliases.size() == 0) {
            Log.finer(c, method, "No flex managed nodes found.");
            Log.exiting(c, method);
            return;
        }
        GetManagedNodeProperties gmnp = new GetManagedNodeProperties();
        gmnp.setManagedNodeNameList(aliases.toArray(new String[] {}));
        Object res = gmnp.run(this).getResult();
        List<Properties> managedprops = cellops.getManagedNodeProperties(res);

        /*
         * Iterate over cells, look for a JobManagerRegistration config object
         * type. If one exists, see if it belongs to *this* job manager. Note
         * that a single server can belong to more than one job manager.
         */
        List<Cell> cells = Topology.getCells();
        for (Cell cell : cells) {
            if (cell.equals(this))
                continue;

            List<ConfigObject> mgdnodes = ConfigObject.getConfigObjectList(cell, "ManagedNode");

            for (ConfigObject mgdnode : mgdnodes) {
                List<ConfigObject> jregs =
                    mgdnode.getChildObjectsByDataType("JobManagerRegistration");
                if (jregs.size() == 0) {
                    // Cell is not registered to a job manager, so move on
                    continue;
                }
                ConfigObject jreg = jregs.iterator().next();

                // OK, have a job manager registration element, resolve the
                // target node.
                String uuid = jreg.getAttributeByName("jobManagerUUID").getValueAsString();
                if (uuid.equals(key)) {
                    // It is registered to this job manager. Find alias. Long
                    // process.
                    String alias = null;
                    Cell target = null;
                    Node node = null;
                    String targetkey = null;

                    // First, if we're in AA topology, point to base cell
                    boolean isagent = false;
                    if (cell.getTopologyType().equals(WebSphereTopologyType.ADMIN_AGENT)) {
                        isagent = true;

                        // Find the uuid for the registered node
                        List<ConfigObject> properties =
                            mgdnode.getChildObjectsByDataType("Property");
                        for (ConfigObject property : properties) {
                            String pname = property.getAttributeByName("name").getValueAsString();
                            String pvalue = property.getAttributeByName("value").getValueAsString();
                            if (pname.equalsIgnoreCase("profile.registry.profile.key"))
                                targetkey = pvalue;
                        }

                        Set<Node> nodes = cell.getManagedNodes();
                        for (Node n : nodes) {
                            if (n.getCell().getProfileKey().equals(targetkey)) {
                                target = n.getCell();
                                node = n;
                                break;
                            }
                        }
                        if (node == null)
                            throw new Exception(
                                                "Unable to find registered node w/UUID of " + targetkey);
                    } else {
                        target = cell;
                        node = cell.getManager().getNode();
                    }

                    // Find the registered node's profile key
                    String cellkey = (String)new GetProfileKey().run(this).getResult();

                    // Now find the Properties container for this registered
                    // node
                    for (Properties props : managedprops) {
                        boolean match = false;
                        if (isagent)
                            match =
                                props.getProperty("profile.registry.profile.key").equals(target
                                    .getProfileKey());
                        else
                            match = props.getProperty("uuid").equals(cellkey);

                        if (match) {
                            // We have a match -- we know both sides of the
                            // exchange now
                            alias = props.getProperty("managedNodeName");
                            break;
                        }
                    }
                    // Default the alias to the node's name?
                    if (alias == null)
                        alias = node.getName();
                    node.setRegisteredToJobMgr(this, alias);
                    this.managedNodes.add(node);
                }
            }
        }
        Log.exiting(c, method);
    }

    /**
     * Delegate to the {@link ConfigurationOperationsProvider} to obtain a list
     * of {@link ConfigIdentifier}s for the {@link NodeGroup}s in the cell
     * 
     * @throws Exception
     */
    private void loadNodeGroups() throws Exception {
        final String method = "loadNodeGroups";
        Log.entering(c, method);
        this.nodeGroups = new HashSet<NodeGroup>();
        ConfigIdentifier[] configIds =
            OperationsProviderFactory.getProvider().getConfigurationOperationsProvider()
                .queryConfigObjects(this,
                                    getActiveSession(),
                                    this.getConfigId(),
                                    ConfigType.NODEGROUP.getType());
        for (ConfigIdentifier cid : configIds) {
            Log.finer(c, method, "Creating node group with configID " + cid.getConfigId());
            NodeGroup group = new NodeGroup(cid, this);
            this.nodeGroups.add(group);
        }
        Log.exiting(c, method);
    }

    public void commit(HashMap<String, Object> values) throws Exception {
    }

    @SuppressWarnings("unchecked")
    public void rollback(HashMap<String, Object> values) throws Exception {
        for (Map.Entry<String, Object> entry : values.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (key.equals(CHANGE_KEY_CLUSTER)) {
                this.clusters = (Set)value;
            } else if (key.equals(CHANGE_KEY_NODEGROUP)) {
                this.nodeGroups = (Set)value;
            }
        }

        if (Topology.isTopologyCachingEnabled()) {
            Topology.getBootstrapFileOps().cache(this);
        }
    }

}
