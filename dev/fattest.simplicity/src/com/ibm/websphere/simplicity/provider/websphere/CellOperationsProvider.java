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

package com.ibm.websphere.simplicity.provider.websphere;

import java.util.List;
import java.util.Properties;
import java.util.Set;

import com.ibm.websphere.simplicity.AbstractSession;
import com.ibm.websphere.simplicity.ApplicationServer;
import com.ibm.websphere.simplicity.Cell;
import com.ibm.websphere.simplicity.Cluster;
import com.ibm.websphere.simplicity.ConfigIdentifier;
import com.ibm.websphere.simplicity.ConnectionInfo;
import com.ibm.websphere.simplicity.Machine;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.commands.clusterconfig.CreateClusterMember;
import com.ibm.websphere.simplicity.commands.jobmanagernode.GetManagedNodeProperties;
import com.ibm.websphere.simplicity.commands.nodegroup.ListNodes;
import com.ibm.websphere.simplicity.provider.CategorizedOperationsBase;
import com.ibm.websphere.simplicity.provider.ClusterMember;
import com.ibm.websphere.simplicity.runtime.ProcessStatus;

public abstract class CellOperationsProvider extends CategorizedOperationsBase {

	/**
	 * Constructor.  For provider use only.
	 * @param parent 
	 */
    public CellOperationsProvider(WebSphereOperationsProvider parent) {
		super(parent);
	}
    
    /**
     * Creates a node group entity with the specified name and description for 
     * the specified cell.  The node group name must be unique.  The node group 
     * is immediately usable for adding and removing nodes.
     * @param result The result of the CreateNodeGroup AdminTask
     * @return An {@link OperationResults} Object containing the {@link ConfigIdentifier} for the node group
     * @throws Exception
     */
	public abstract OperationResults<ConfigIdentifier> createNodeGroup(Object result) throws Exception;

    /**
     * Obtains a list of nodes that have been added to the specified node group.
     * The nodes all exist in the cell, so only the display names are returned.
     * @param result The result of the {@link ListNodes} AdminTask
     * @return A list of node display names.
     * @throws Exception
     */
    public abstract String[] listNodes(Object result) throws Exception;
    
    /**
     * Retrieves the server and node names for all members of a cluster.  The
     * node name is retrieved because each server name is not guaranteed to 
     * be unique throughout the cell.
     * @param key The cluster whose members should be listed.
     * @param sessionKey A valid session obtained from a Transaction object.
     * @return A list of ClusterMember instances to resolve server instances.
     * @throws Exception
     */
    public abstract Set<ClusterMember> listClusterMembers(Cluster key, AbstractSession sessionKey) throws Exception;

    /**
     * Creates a cluster using the specified cluster creation options. Whether
     * the cluster is created using an existing server as the first server or not,
     * and what servers can be added afterwards depend on the options used.
     * 
     * @param result The result of the createCluster AdminTask
     * @return An {@link OperationResults} containing the {@link ConfigIdentifier} of the cluster
     * @throws Exception
     */
    public abstract OperationResults<ConfigIdentifier> createCluster(Object result) throws Exception;
    
    /**
     * Creates a new server to act as an application server in the specified
     * cluster.  The server will have the specified name, and will be created
     * in the context of the specified node.  The server name must be unique
     * from all other server names in the specified node.
     * 
     * @param result The result of the {@link CreateClusterMember} AdminTask
     * @return An {@link OperationResults} that contains the {@link ConfigIdentifier} of the new cluster member
     * @throws Exception
     */
    public abstract OperationResults<ConfigIdentifier> addClusterMember(Object result) throws Exception;
    
    /**
     * Job manager only.  Obtains references to the XML properties for the specified managed nodes.
     * 
     * @param res The result of the {@link GetManagedNodeProperties} Admin Task
     * @return A list of references to the XML properties for the managed nodes.
     * @throws Exception
     */
    public abstract List<Properties> getManagedNodeProperties(Object res) throws Exception;
    
    /**
     * Admin agent only.  Obtains the host, port, and type properties for the specified
     * connector type for the specified managed node's subsystem.  The subsystem is the
     * preferred connection endpoint for registered nodes.
     * 
     * @param result The result of the getManagedNodeConnectorProperties AdminTask
     * @return The "type", "port", and "host" values as properties.
     * @throws Exception
     */
    public abstract Properties getManagedNodeConnectorProperties(Object result) throws Exception;
    
    /**
     * Make an administrative connection to a WAS server using the specified {@link ConnectionInfo}
     * 
     * @param connInfo The {@link ConnectionInfo} which contains the data needed to make an
     *            administrative connection
     */
    public abstract void connect(Scope scope, ConnectionInfo connInfo) throws Exception;
    
    /**
     * Close an administrative connection to a WAS server
     * 
     * @param connInfo The {@link ConnectionInfo} associated with the connection
     */
    public abstract void disconnect(Scope scope, ConnectionInfo connInfo) throws Exception;
    
    /**
     * Returns true if the physical admin connection to a WAS server represented by the
     * {@link ConnectionInfo} is open
     * 
     * @param connInfo The {@link ConnectionInfo} associated with the connection
     */
    public abstract boolean isConnected(Scope scope, ConnectionInfo connInfo) throws Exception;
    
    /**
     * Returns a reference to the machine from which the connection the cell originates.
     * @param cell
     * @return The Machine where the connection to the cell originates
     * @throws Exception
     */
    public abstract Machine getExecutionSource(Cell cell) throws Exception;
    
    /**
     * Get the status of the server. This method is used to determine whether
     * or not the ApplicationServer is running.
     * 
     * @param server The {@link ApplicationServer} to query
     * @return The {@link ProcessStatus} of the server
     * @throws Exception
     */
    public abstract ProcessStatus getServerStatus(ApplicationServer server) throws Exception;
    
    /**
     * Returns a list of the aliases currently registered to the job manager.
     * @param result The result of the QueryManagedNodes AdminTask
     * @return List of managed nodes
     * @throws Exception
     */
	public abstract List<String> queryManagedNodes(Object result) throws Exception;
    
}
