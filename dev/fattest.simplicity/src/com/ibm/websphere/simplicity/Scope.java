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

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.management.ObjectName;

import com.ibm.websphere.simplicity.config.securitydomain.GlobalSecurityDomain;
import com.ibm.websphere.simplicity.config.securitydomain.SecurityDomain;
import com.ibm.websphere.simplicity.log.Log;

/**
 * The Scope class is the parent for defined areas of visibility in a WebSphere topology. The Cell
 * instance of Scope, being the highest, can see and affect all other scopes in the topology. A Node
 * instance of Scope has visibility to the servers within it. A Server instance of Scope is the most
 * limited view, and can only affect settings and other values directly impacting the Server itself.
 */
public abstract class Scope {
	
	private static Class c = Scope.class;
    
    protected String bootstrapFileKey;
	protected ConfigIdentifier configId;
	protected String name;
	protected Scope parent = null;
    protected Cell cell;
    // can't be static since we need one per Cell; non-Cell scopes have null references
    protected ConnectionInfoThreadLocal connectionData = null;

    class ConnectionInfoThreadLocal extends ThreadLocal<ConnectionInfo> {
        private List<ConnectionInfo> connInfoStack = null;
        
        public ConnectionInfo get() {
            if(connInfoStack == null || connInfoStack.size() < 1) {
                return initialValue();
            }
            return connInfoStack.get(connInfoStack.size() - 1);
        }
        
        protected ConnectionInfo initialValue() {
            return null;
        }
        
        public void remove() {
            this.connInfoStack = null;
        }
        
        public void set(ConnectionInfo connInfo) {
            if(connInfoStack == null) {
                connInfoStack = new LinkedList<ConnectionInfo>();
                connInfoStack.add(connInfo);
            }
        }
        
        public void push(ConnectionInfo connInfo) {
            if(connInfoStack == null) {
                set(connInfo);
            } else {
                connInfoStack.add(connInfo);
            }
        }
        
        public ConnectionInfo pop() {
            if(connInfoStack.size() > 1) {
                return connInfoStack.remove(connInfoStack.size() - 1);
            } else {
                // do not remove the default
                return null;
            }
        }
        
        public ConnectionInfo getBottom() {
            return connInfoStack.get(0);
        }
    }

    // Centralized logic for recursive variable substitution
    protected static String expandString(Scope scope, String str) throws Exception {
        String ret = str;
        String regex = "\\$(\\{|\\()[A-Za-z0-9_]+(\\}|\\))";
        Pattern p = Pattern.compile(regex);
        Matcher m = null;
        while ((m = p.matcher(ret)).lookingAt()) {
            Scope current = scope;
        	String var = m.group();
        	String value = null;
        	// Search up the scope tree until we find a variable or never find it
        	while (value == null && current != null) {
            	if (current instanceof Cell)
            		value = ((Cell)current).expandVariable(var);
            	else if (current instanceof Node)
            		value = ((Node)current).expandVariable(var);
            	else if (current instanceof Server)
            		value = ((Server)current).expandVariable(var);
           		current = current.getParent();
        	}
        	if (value == null)
        		value = "";
        	ret = ret.replace(var, value);
        }
        return ret.replace('\\', '/');
    }
    
    /**
     * Constructor to create a parent-less Scope. Sets the {@link ConnectionInfo} to be used by this
     * Scope and all it's children
     * 
     * @param configId The {@link ConfigIdentifier} of this Scope
     * @param connInfo The {@link ConnectionInfo} that contains the data needed to make an
     *            administrative connection for this Scope
     */
	protected Scope(ConfigIdentifier configId, ConnectionInfo connInfo, Cell cell) {
        initConfigId(configId);
        this.parent = null;
        connectionData = new ConnectionInfoThreadLocal();
        connectionData.set(connInfo);
        this.cell = cell;
	}
	
    /**
     * Constructor to create a Scope with a parent
     * 
     * @param configId The {@link ConfigIdentifier} of this Scope
     * @param parent The parent Scope of this Scope
     */
	protected Scope(ConfigIdentifier configId, Scope parent, Cell cell) {
        initConfigId(configId);
        this.parent = parent;
        this.cell = cell;
	}
    
    private void initConfigId(ConfigIdentifier configId) {
    	final String method = "initConfigId";
    	Log.entering(c, method, configId);
        if (configId != null) {
            this.configId = configId;
            this.name = configId.getDisplayName();
            this.configId.setScope(this);
        }
        Log.exiting(c, method);
    }
	
	/**
     * A multi-purpose scope descriptor used by certain APIs.
     * 
	 * @return A multi-purpose scope descriptor.
	 */
	public abstract ScopeHelper getScopeHelper();
	
	/**
     * The scope portion of an ObjectName pattern corresponding to the scope represented by this
     * instance.
     * 
     * @return The scope portion of an ObjectName pattern corresponding to the scope represented by
     *         this instance.
     */
	public abstract String getObjectNameFragment();

	/**
     * Get the physical path to the scope's configuration repository on the file system that the
     * scope resides.
     * 
     * @return The physical path to the scope's configuration repository.
     */
	public abstract String getConfigPath() throws Exception;
	
	/**
     * @return The name of this scope
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Sets the name of this scope.
	 * @param name
	 */
    protected void setName(String name) {
        this.name = name;
    }
	
	/**
	 * @return Returns a public-friendly configuration identifier for the scope's main configuration element.
	 */
    public ConfigIdentifier getConfigId() {
        return this.configId;
    }
	
	/**
	 * @return The topological parent; in other words, a Server returns a Node, a Node returns a Cell, etc.
	 */
	public Scope getParent() {
		return this.parent;
	}
	
	/**
     * Get the {@link Cell} level {@link Workspace} Object
     * 
     * @return A representation of the config workspace
     * @throws Exception
     */
	public Workspace getWorkspace() throws Exception {
		if (this.cell.workspace == null) {
			this.cell.workspace = new Workspace(this.cell);
		}
		return this.cell.workspace;
	}
	
	/**
	 * @return A value describing the type of scope this instance represents.
	 */
	public ScopeType getScopeType() {
		if (this instanceof Cell)
			return ScopeType.CELL;
		else if (this instanceof Node)
			return ScopeType.NODE;
		else if (this instanceof Server)
			return ScopeType.SERVER;
		else if (this instanceof Cluster)
			return ScopeType.CLUSTER;
		else if (this instanceof NodeGroup)
			return ScopeType.NODE_GROUP;
		else
			return null;
	}
	
	/**
	 * @return The currently active session, or null if no active transaction exists.
	 * @throws Exception
	 */
	public AbstractSession getActiveSession() throws Exception {
        return getWorkspace().getSession();
	}
	
	/**
	 * @return A ConnectionInfo instance, which contains information used to communicate with the endpoint.  May return a reference to a parent connection.
	 */
    public ConnectionInfo getConnInfo() {
        if(this.parent != null) {
            return parent.getConnInfo();
        } else {
            return connectionData.get();
        }
    }

	/**
	 * @return The key from bootstrapping.properties which refers to this particular scope.
	 */
    public String getBootstrapFileKey() {
        return bootstrapFileKey;
    }

    protected void setBootstrapFileKey(String bootstrapFileKey) {
        this.bootstrapFileKey = bootstrapFileKey;
    }

    /**
     * Get the {@link SecurityDomain} that this server is mapped to. If it is not mapped to any
     * application security domains, the {@link GlobalSecurityDomain} is returned.
     * 
     * @return The {@link SecurityDomain} that this server belongs to
     * @throws Exception
     */
    protected SecurityDomain getSecurityDomain() throws Exception {
        final String method = "getSecurityDomain";
        Log.entering(c, method);
        Set<SecurityDomain> domains = this.cell.getSecurityConfiguration().getSecurityDomains();
        for (SecurityDomain domain : domains) {
            if (domain.getMappedScopes().contains(this)) {
                Log.finer(c, method, "Server " + this.name + " is part of domain " + domain.getName() + ".");
                Log.exiting(c, method, domain);
                return domain;
            }
        }
        Log.finer(c, method, "Server " + this.name + " is not mapped to a domain. Returning global domain.");
        Log.exiting(c, method, this.cell.getSecurityConfiguration().getGlobalSecurityDomain());
        return this.cell.getSecurityConfiguration().getGlobalSecurityDomain();
    }
    
    /**
     * Get the {@link Cell} that this Scope belongs to
     * 
     * @return The {@link Cell} of the Scope
     */
    public Cell getCell() {
        return this.cell;
    }
    
	protected static String getCellName(ObjectName on) {
		String ret = on.getKeyProperty("cell");
		if (ret != null)
			return ret;
		
		String[] parts = getConfigIdParts(on);
		// skip "cells"
		return parts[1];
	}
	
	protected static String getNodeName(ObjectName on) {
		String ret = on.getKeyProperty("cell");
		if (ret != null)
			return ret;
		String[] parts = getConfigIdParts(on);
		// skip "cells", "<cellname>", "nodes"
		return parts[3];
	}
	
	private static String[] getConfigIdParts(ObjectName on) {
		// configID looks something like this: cells/wssecsuse2Cell03/nodes/wssecsuse2Node03|node.xml
		String configID = on.getKeyProperty("_Websphere_Config_Data_Id");
		// First strip out everything after the pipe
		configID = configID.substring(0, configID.indexOf('|'));
		// Now split the string based on "/" delimiter
		String[] parts = configID.split("/");
		return parts;
	}
    
}
