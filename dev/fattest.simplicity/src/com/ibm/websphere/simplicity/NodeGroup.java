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

import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.ibm.websphere.simplicity.commands.nodegroup.AddNodeGroupMember;
import com.ibm.websphere.simplicity.commands.nodegroup.ListNodes;
import com.ibm.websphere.simplicity.commands.nodegroup.RemoveNodeGroupMember;
import com.ibm.websphere.simplicity.config.Configurable;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;

/**
 * A WebSphere node group is a logical grouping of nodes. A node group defines a boundary for server
 * cluster formation. This class is a representation of that WebSphere scope type.
 * 
 * @see ScopeType#NODE_GROUP
 */
public class NodeGroup extends Scope implements Configurable {
	
	private static Class c = NodeGroup.class;
	private static final String CHANGE_KEY_NODES = "nodes";
    
    private Set<Node> nodes;
	private String description = "";
	
    /**
     * Used to create an instance of NodeGroup for existing node groups
     * 
     * @param configId The {@link ConfigIdentifier} of the node group
     * @param cell The {@link Cell} of the node group
     */
	protected NodeGroup(ConfigIdentifier configId, Cell cell) {
		super(configId, cell, cell);
	}
	
	@Override
	/**
	 * Node groups do not have mbeans, and no means of specifying them in an ObjectName.
     * 
     * @return null
	 */
	public String getObjectNameFragment() {
		return null;
	}

	@Override
	public ScopeHelper getScopeHelper() {
		return new ScopeHelper(this);
	}
	
	@Override
	public String getConfigPath() throws Exception {
		return this.cell.getConfigPath()+"nodegroups/"+this.getName()+"/";
	}
    
    /**
     * Get this node group's description. The description is provided by the user during node group
     * creation.
     * 
     * @return The node group's description
     */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * Will return a Set of {@link Node} instances registered to this node group.  If the
	 * Set has not yet been populated, it will attempt to resolve the list dynamically.
	 * Note that a copy of the Set is returned, not the original Set.  This prevents
	 * problems during add and remove operations while the Set is being iterated.
     * 
	 * @return A Set of Node instances representing nodes registered to this node group.
	 * @throws Exception
	 */
	public Set<Node> getNodes() throws Exception {
		Log.entering(c, "getNodes");
		if (this.nodes == null) {
			loadNodes();
		}
		/*
		 * Return a new list here, because remove and add operations affect the
		 * original list, busting iteration.  Yes, it's heavy, so don't call this often.
		 */
		Log.exiting(c, "getNodes", this.nodes.toArray());
		return new HashSet<Node>(this.nodes);
	}
	
    /**
     * Get a specific {@link Node} in this node group that has the specified name
     * 
     * @param name The name of the node to get
     * @return The existing {@link Node} in this node group that has the specified name or null of
     *         there is no {@link Node} with the name
     * @throws Exception
     */
	public Node getNodeByName(String name) {
        final String method = "getNodeByName";
        Log.entering(c, method, name);
		for (Node n : this.nodes) {
            Log.finest(c, method, "Current node name: " + n.getName());
			if (n.getName().equalsIgnoreCase(name)) {
                Log.finer(c, method, "Found node with matching name.");
                Log.exiting(c, method, n);
				return n;
            }
        }
        Log.finer(c, method, "No node found with matching name.");
        Log.exiting(c, method, null);
		return null;
	}
	
    /**
     * Returns true if the {@link Node} instance is part of this NodeGroup
     * 
     * @param node The {@link Node} to check
     * @return true if the {@link Node} instance is part of this NodeGroup
     * @throws Exception
     */
    public boolean isMember(Node node) throws Exception {
    	return (getNodeByName(node.getName()) != null);
    }
    
    /**
     * This method adds the {@link Node} instance to this NodeGroup
     * 
     * @param node The {@link Node} to add
     * @throws Exception
     */
    public void addNode(Node node) throws Exception {
        final String method = "addNode";
        Log.entering(c, method, node);
		if (getNodes().contains(node)) {
			throw new Exception("The node already exists in the node group.");
        }

		getWorkspace().registerConfigChange(this, CHANGE_KEY_NODES, getNodes());

		Log.finer(c, method, "Adding the node to the node group in WAS.");
        AddNodeGroupMember task = new AddNodeGroupMember(this.getName(), node.getName());
        task.run(this);
        Log.finer(c, method, "Adding the node to the node group in the Object model.");
    	this.nodes.add(node);
        Log.exiting(c, method);
    }
    
    /**
     * Remove the specified {@link Node} from this NodeGroup. This does not remove the {@link Node}
     * from the {@link Cell}
     * 
     * @param node The {@link Node} to remove
     * @throws Exception
     */
    public void removeNode(Node node) throws Exception {
        final String method = "removeNode";
        Log.entering(c, method, node);
		if (!getNodes().contains(node)) {
            throw new Exception("The node does not exist in this node group.");
        }

		getWorkspace().registerConfigChange(this, CHANGE_KEY_NODES, getNodes());

		Log.finer(c, method, "Removing the node from the node group in WAS.");
        RemoveNodeGroupMember task = new RemoveNodeGroupMember(this.getName(), node.getName());
        task.run(this);
        Log.finer(c, method, "Removing the node from the node group in the object model.");
    	this.nodes.remove(node);
        Log.exiting(c, method);
    }
       
    /**
     * Retrieves a list of node names within the node group, then pulls
     * the node instances from the cell.
     */
    private void loadNodes() throws Exception {
        final String method = "loadNodes";
        Log.entering(c, method);
    	Log.finer(c, method, "Initializing member list");
		this.nodes = new HashSet<Node>();

        ListNodes task = new ListNodes(null);
        task.setNodeGroup(this.getName());
        Object result = task.run(this).getResult();
		String[] names = OperationsProviderFactory.getProvider().getCellOperationsProvider().listNodes(result);
		for (String nodeName : names) {
			Log.finer(c, method, "Found node: "+nodeName);
			Node n = cell.getNodeByName(nodeName);
			Log.finer(c, method, "Node exists in cell: "+(n != null));
			this.nodes.add(n);
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
        	
            if(key.equals(CHANGE_KEY_NODES)) {
                this.nodes = (Set)value;
            }
        }
    }

}
