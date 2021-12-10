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

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ibm.websphere.simplicity.cluster.ClusterMemberCreationOptions;
import com.ibm.websphere.simplicity.cluster.ClusterType;
import com.ibm.websphere.simplicity.commands.clusterconfig.CreateClusterMember;
import com.ibm.websphere.simplicity.commands.clusterconfig.DeleteClusterMember;
import com.ibm.websphere.simplicity.commands.clusterconfig.UpdateCluster;
import com.ibm.websphere.simplicity.commands.clusterconfig.CreateClusterMember.FirstMember;
import com.ibm.websphere.simplicity.commands.clusterconfig.CreateClusterMember.MemberConfig;
import com.ibm.websphere.simplicity.commands.clusterconfig.UpdateCluster.BoundingNodeGroupName;
import com.ibm.websphere.simplicity.commands.clusterconfig.UpdateCluster.PreferLocal;
import com.ibm.websphere.simplicity.commands.clusterconfig.UpdateCluster.TransactionLogRecovery;
import com.ibm.websphere.simplicity.config.ConfigObject;
import com.ibm.websphere.simplicity.config.Configurable;
import com.ibm.websphere.simplicity.config.securitydomain.SecurityDomain;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.ClusterMember;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;
import com.ibm.websphere.simplicity.provider.websphere.CellOperationsProvider;
import com.ibm.websphere.simplicity.runtime.ClusterMBean;
import com.ibm.websphere.simplicity.runtime.ClusterStatus;

/**
 * A WebSphere cluster is a logical grouping of servers. Clusters are groups of servers that are
 * managed together and participate in workload management. This class is a representation of that
 * WebSphere scope type.
 * 
 * @see ScopeType#CLUSTER
 */
public class Cluster extends Scope implements Configurable {
    
    private static Class c = Cluster.class;
    private static final String CHANGE_KEY_MEMBERS = "members";
    
	private Set<Server> servers = null;
    private ClusterType type;
    private ClusterMBean clusterMBean;
	
    /**
     * Used by {@link Cell} and {@link Topology} to create existing Cluster instances.
     * 
     * @param configId The {@link ConfigIdentifier} of this Cluster
     * @param c The {@link Cell} that the cluster belongs to
     * @param type The type of Cluster
     */
	protected Cluster(ConfigIdentifier configId, Cell c, ClusterType type) {
		super(configId, c, c);
        this.type = type;
	}
	
	@Override
	public String getConfigPath() throws Exception {
		return cell.getConfigPath()+"clusters/"+this.getName()+"/";
	}

	@Override
	public String getObjectNameFragment() {
		// A cluster is not a "scope" in mbean terms, but a cluster does have an mbean
		return cell.getObjectNameFragment()+",type=Cluster,name="+this.getName();
	}
	
    /**
     * Returns the String used by WebSphere to target entities such as application modules to the
     * cluster
     * 
     * @return The cluster target mapping string
     */
	public String getMappingName() {
		return "WebSphere:cell="+getCell().getName()+",cluster="+getName();
	}

	@Override
	public ScopeHelper getScopeHelper() {
		return new ScopeHelper(this);
	}
    
    /**
     * Get the type of cluster that this is. Examples include application server clusers and proxy
     * server clusters. This determines the type of servers that can be added as members to the
     * cluster.
     * 
     * @return The cluster type for this cluster.
     */
    public ClusterType getType() {
        return type;
    }
    
    @Override
    public SecurityDomain getSecurityDomain() throws Exception {
        return super.getSecurityDomain();
    }
    
    /**
     * Get the {@link Server}s that are members of this cluster
     * 
     * @return A set of {@link Server}s containing the cluster members
     * @throws Exception
     */
	public Set<Server> getMembers() throws Exception {
        final String method = "getMembers";
        Log.entering(c, method);
		if (this.servers == null) {
            Log.finer(c, method, "Initializing servers.");
            if(!Topology.isTopologyCachingEnabled() || !Topology.getBootstrapFileOps().cacheComplete(getCell().getBootstrapFileKey())) {
                Log.finer(c, method, "Loading servers.");
                loadServers();
            } else {
                Log.finer(c, method, "No servers in this cluster. Creating an empty Set.");
                this.servers = new HashSet<Server>();
            }
        }
        Log.exiting(c, method, this.servers);
		return new HashSet<Server>(this.servers);
	}
	
    /**
     * Return the {@link Server} that has the specified name that is also a member of this cluster
     * 
     * @param name The name of the {@link Server} to get
     * @return The {@link Server} representing the cluster member that has the specified name
     * @throws Exception
     */
	public Server getMemberByName(String name) throws Exception {
        final String method = "getMemberByName";
        Log.entering(c, method, name);
		for (Server server : getMembers()) {
            Log.finest(c, method, "Current server name: " + server.getName());
			if (server.getName().equalsIgnoreCase(name)) {
                Log.finer(c, method, "Found server with matching name.");
                Log.exiting(c, method, server);
				return server;
            }
        }
        Log.finer(c, method, "No server found with name " + name);
        Log.exiting(c, method, null);
		return null;
	}
	
    /**
     * Create a new member for this cluster. This method creates a new physical WebSphere
     * {@link Server} and adds it as a member to this cluster.
     * 
     * @param node The {@link Node} that the member should be created under
     * @param serverName The name for the member
     * @return An {@link OperationResults} that contains a {@link Server} representation of the new cluster member as the result
     * @throws Exception
     */
	public OperationResults<Server> createMember(final Node node, final String serverName) throws Exception {
        ClusterMemberCreationOptions options = new ClusterMemberCreationOptions();
        options.getMemberConfigOptions().setMemberNode(node);
        options.getMemberConfigOptions().setMemberName(serverName);
        return createMember(options);
	}
    
    /**
     * Create a new member for this cluster using the specified options. This method creates a new physical WebSphere
     * {@link Server} and adds it as a member to this cluster.
     * 
     * @param options The options to use when creating the cluster
     * @return An {@link OperationResults} that contains a {@link Server} representation of the new cluster member as the result
     * @throws Exception
     */
    public OperationResults<Server> createMember(ClusterMemberCreationOptions options) throws Exception {
        final String method = "createMember";
        Log.entering(c, method, new Object[]{options});
        if(options.getMemberConfigOptions().getMemberNode() == null || options.getMemberConfigOptions().getMemberName() == null) {
            throw new IllegalArgumentException("Member node and member name must be specified.");
        }
        if (getMemberByName(options.getMemberConfigOptions().getMemberName()) != null)
            throw new IllegalArgumentException("Cluster already contains a server named: " + options.getMemberConfigOptions().getMemberName());

        cell.getWorkspace().registerConfigChange(this, CHANGE_KEY_MEMBERS, getMembers());

        CreateClusterMember task = new CreateClusterMember(null);
        task.setClusterName(this.getName());
        com.ibm.websphere.simplicity.cluster.MemberConfig mcOps = options.getMemberConfigOptions();
        MemberConfig mc = new MemberConfig(mcOps.getMemberNode().getName(), mcOps.getMemberName());
        FirstMember fm = null;
        mc.setMemberWeight(mcOps.getMemberWeight());
        mc.setGenUniquePorts(mcOps.getGenUniquePorts());
        mc.setReplicatorEntry(mcOps.getReplicatorEntry());
        if(mcOps.getMemberUUID() != null)
            mc.setMemberUUID(mcOps.getMemberUUID());
        if(options.getFirstMemberOptions() != null && !(options.getFirstMemberOptions().getTemplateName() == null && options.getFirstMemberOptions().getTemplateServer() == null)) {
            fm = new FirstMember();
            com.ibm.websphere.simplicity.cluster.FirstMember fmOps = options.getFirstMemberOptions();
            if(fmOps.getTemplateName() != null)
                fm.setTemplateName(fmOps.getTemplateName());
            if(fmOps.getTemplateServer() != null) {
                fm.setTemplateServerNode(fmOps.getTemplateServer().getNode().getName());
                fm.setTemplateServerName(fmOps.getTemplateServer().getName());
            }
            if(fmOps.getNodeGroup() != null)
                fm.setNodeGroup(fmOps.getNodeGroup().getName());
        }
        Object result = task.run(this, mc, fm, null, null);
        OperationResults<ConfigIdentifier> cid = OperationsProviderFactory.getProvider().getCellOperationsProvider().addClusterMember(result);
        
        // Create a Server instance
        Server server = null;
        OperationResults<Server> results = new OperationResults<Server>();
        OperationResults.setOperationResults(results, cid);
        Log.finer(c, method, "Creating the server using the config ID " + cid.getResult().getConfigId());
        Node node = options.getMemberConfigOptions().getMemberNode();
        if(this.getType() == ClusterType.APPLICATION_SERVER) {
            // convert the cluster member config id to a normal server config id
        	List<ConfigObject> coList = ConfigObject.getConfigObjectList(node, node.getConfigId(), "Server");
        	for(ConfigObject co : coList) {
        		if(co.getConfigIdentifier().getDisplayName().equals(cid.getResult().getDisplayName())) {
        			server = new ApplicationServer(co.getConfigIdentifier(), cell, node);
        			break;
        		}
        	}
        } // TODO add more here when we support other server types
        node.addServer(server);
        this.servers.add(server);
        results.setResult(server);
        
        // cache
        if(Topology.isTopologyCachingEnabled()) {
            Log.finer(c, method, "Caching the new server.");
            Topology.getBootstrapFileOps().cache(this.getCell());
        }
        
        Log.exiting(c, method, results.getResult());
        return results;
    }
	
    /**
     * Delete a member from the cluster. This method removes the {@link ApplicationServer} from the cluster and
     * deletes the {@link ApplicationServer} from the the parent {@link Node} and {@link Cell}
     * 
     * @param server The {@link ApplicationServer} to delete
     * @return An {@link OperationResults} with the results of the operation
     * @throws Exception
     */
	public OperationResults<Boolean> deleteMember(Server server) throws Exception {
        return deleteMember(server, null);
	}
    
    /**
     * Delete a member from the cluster. This method removes the {@link ApplicationServer} from the cluster and
     * deletes the {@link ApplicationServer} from the the parent {@link Node} and {@link Cell}
     * 
     * @param server The {@link ApplicationServer} to delete
     * @param deleteReplicatorEntry true if the replicator entry should be deleted
     * @return An {@link OperationResults} with the results of the operation
     * @throws Exception
     */
    public OperationResults<Boolean> deleteMember(Server server, Boolean deleteReplicatorEntry) throws Exception {
        final String method = "deleteMember";
        Log.entering(c, method, new Object[]{server, deleteReplicatorEntry});
        if (!getMembers().contains(server)) {
            throw new IllegalArgumentException("Cluster does not contain a server named: "+server.getName());
        }

        cell.getWorkspace().registerConfigChange(this, CHANGE_KEY_MEMBERS, getMembers());

        DeleteClusterMember task = new DeleteClusterMember(null);
        task.setClusterName(this.getName());
        task.setMemberName(server.getName());
        task.setMemberNode(server.getNodeName());
        DeleteClusterMember.ReplicatorEntry re = null;
        if(deleteReplicatorEntry != null) {
            re = new DeleteClusterMember.ReplicatorEntry();
            re.setDeleteEntry(deleteReplicatorEntry);
        }
        OperationResults<Object> res = task.run(this, re, null, null);
        OperationResults<Boolean> results = new OperationResults<Boolean>();
        OperationResults.setOperationResults(results, res);
        results.setResult(true);
        this.servers.remove(server);
            
        // cache
        if(Topology.isTopologyCachingEnabled()) {
            Log.finer(c, method, "Rewriting cache without server.");
            Topology.getBootstrapFileOps().cache(this.getCell());
        }
        
        Log.exiting(c, method, results.getResult());
        return results;
    }
    
    public OperationResults<Boolean> update(boolean preferLocal, String transactionLogRecovery, String boundingNodeGroupName) throws Exception {
        final String method = "update";
        Log.entering(c, method, new Object[]{preferLocal, transactionLogRecovery, boundingNodeGroupName});
        
        UpdateCluster task = new UpdateCluster(null);
        task.setClusterName(this.getName());
        PreferLocal pl = new PreferLocal();
        pl.setPreferLocal(preferLocal);
        TransactionLogRecovery tlr = new TransactionLogRecovery();
        tlr.setTransactionLogRecovery(transactionLogRecovery);
        BoundingNodeGroupName bngn = new BoundingNodeGroupName();
        bngn.setBoundingNodeGroupName(boundingNodeGroupName);
        
        OperationResults<Object> res = task.run(this, pl, tlr, bngn);
        OperationResults<Boolean> results = new OperationResults<Boolean>();
        OperationResults.setOperationResults(results, res);
        results.setResult(true);
    	
        Log.exiting(c, method, results.getResult());
        return results;
    }
    
    /**
     * Start this Cluster. This cluster does NOT wait
     * until the cluster has been completely started.
     * Use the {@link #getStatus()} method to get the
     * {@link ClusterStatus}.
     * 
     * @throws Exception
     */
    public void start() throws Exception {
        final String method = "start";
        Log.entering(c, method);
        getClusterMBean().start();
        Log.exiting(c, method);
    }
    
    /**
     * Perform a synchronous cluster start. This method does not
     * return until the status of the Cluster is {@link ClusterStatus#RUNNING}
     * or the maxWait time limit has been reached.
     * 
     * @param maxWait The maximum amount of time to wait for the cluster to start in seconds
     * @param waitInterval The amount of time to wait in between status check in seconds
     * @throws Exception
     */
    public void startSynchronous(int maxWait, int waitInterval) throws Exception {
        final String method = "startSynchronous";
        Log.entering(c, method, new Object[]{maxWait, waitInterval});
        start();
        waitForStatus(ClusterStatus.RUNNING, maxWait, waitInterval);
        Log.exiting(c, method);
    }
    
    /**
     * Stop the Cluster. This cluster does NOT wait
     * until the cluster has been completely stopped.
     * Use the {@link #getStatus()} method to get the
     * {@link ClusterStatus}.
     * 
     * @throws Exception
     */
    public void stop() throws Exception {
        final String method = "stop";
        Log.entering(c, method);
        getClusterMBean().stop();
        Log.exiting(c, method);
    }
    
    /**
     * Perform a synchronous cluster stop. This method does not
     * return until the status of the Cluster is {@link ClusterStatus#STOPPED}
     * or the maxWait time limit has been reached.
     * 
     * @param maxWait The maximum amount of time to wait for the cluster to start in seconds
     * @param waitInterval The amount of time to wait in between status check in seconds
     * @throws Exception
     */
    public void stopSynchronous(int maxWait, int waitInterval) throws Exception {
        final String method = "stopSynchronous";
        Log.entering(c, method, new Object[]{maxWait, waitInterval});
        stop();
        waitForStatus(ClusterStatus.STOPPED, maxWait, waitInterval);
        Log.exiting(c, method);
    }
    
    /**
     * Wait for the cluster to have a specific status
     * 
     * @param endStatus The {@link ClusterStatus} to wait for
     * @param maxWait The maximum amount of time to wait for the cluster to start in seconds
     * @param waitInterval The amount of time to wait in between status check in seconds
     * @throws Exception
     */
    public void waitForStatus(ClusterStatus endStatus, int maxWait, int waitInterval) throws Exception {
        final String method = "waitForStatus";
        Log.entering(c, method, new Object[]{maxWait, waitInterval});
        ClusterStatus status = getStatus();
        int time = 0;
        int intervalMilli = waitInterval * 1000;
        while(!status.equals(endStatus) && time < maxWait) {
            try {
                Log.finer(c, method, "Waiting for " + intervalMilli + " millisecons.");
                Thread.sleep(intervalMilli);
            } catch(Exception e) {}
            status = getStatus();
            time += waitInterval;
            Log.finer(c, method, "Current status: " + status);
            Log.finer(c, method, "Elapsed time in seconds: " + time);
        }
        Log.exiting(c, method);
    }
    
    /**
     * Stop the cluster
     * 
     * @throws Exception
     */
    public void stopImmediate() throws Exception {
        final String method = "stopImmediate";
        Log.entering(c, method);
        getClusterMBean().stopImmediate();
        Log.exiting(c, method);
    }
    
    /**
     * Start the cluster
     * @throws Exception
     */
    public void rippleStart() throws Exception {
        final String method = "rippleStart";
        Log.entering(c, method);
        getClusterMBean().rippleStart();
        Log.exiting(c, method);
    }
    
    /**
     * Get the status of this cluster (ex: stopped, started, partially started).
     * @return The {@link ClusterStatus} of this Cluster
     * @throws Exception
     */
    public ClusterStatus getStatus() throws Exception {
        final String method = "getStatus";
        Log.entering(c, method);
        ClusterStatus ret = getClusterMBean().getState();
        Log.exiting(c, method, ret);
        return ret;
    }
	
    /**
     * Add a cluster member to this cluster's private Set
     * 
     * @param server The {@link ApplicationServer} to add
     */
    protected void addMember(Server server) {
        if(this.servers == null) {
            this.servers = new HashSet<Server>();
        }
        this.servers.add(server);
    }
	
    /**
     * Delegate the {@link CellOperationsProvider} to obtain an AttributeList containing the node
     * and server names for the members of this cell. The corresponding {@link Node} and
     * {@link Server} Objects are found and the {@link Server} is added to this cluster.
     * 
     * @throws Exception
     */
	private void loadServers() throws Exception {
        final String method = "loadServers";
        Log.entering(c, method);
		
        this.servers = new HashSet<Server>();
		AbstractSession sessionKey = cell.getActiveSession();
		Set<ClusterMember> members = OperationsProviderFactory.getProvider().getCellOperationsProvider().listClusterMembers(this, sessionKey);
		for (ClusterMember member : members) {
			if (member.nodeName != null && member.serverName != null) {
                Log.finer(c, method, "Loading member " + member.serverName + " on node " + member.nodeName);
				// Add the specified server to the cluster
				Node node = cell.getNodeByName(member.nodeName);
				Server server = node.getServerByName(member.serverName);
				if (server != null)
					addMember(server);
			}
		}
        Log.exiting(c, method);
	}

    public void commit(HashMap<String, Object> values) throws Exception {
    }

    @SuppressWarnings("unchecked")
    public void rollback(HashMap<String, Object> values) throws Exception {
        for(Map.Entry<String, Object> entry : values.entrySet()) {
        	String key = entry.getKey();
        	Object value = entry.getValue();
        	
            if(key.equals(CHANGE_KEY_MEMBERS)) {
                this.servers = (Set)value;
            }
        }
        
        if(Topology.isTopologyCachingEnabled()) {
            Topology.getBootstrapFileOps().cache(cell);
        }
    }
	
    private ClusterMBean getClusterMBean() throws Exception {
        if(this.clusterMBean == null) {
            this.clusterMBean = new ClusterMBean((Dmgr)this.cell.getManager(), this);
        }
        return this.clusterMBean;
    }
}
