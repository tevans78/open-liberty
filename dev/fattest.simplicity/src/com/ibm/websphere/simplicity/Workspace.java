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
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.ibm.websphere.simplicity.Transaction.TransactionState;
import com.ibm.websphere.simplicity.config.Configurable;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.runtime.ProcessStatus;

/**
 * 
 * @author SterlingBates
 *
 */
public class Workspace {
	
	private class ChangedElements extends HashMap<String, Object> {
		private static final long serialVersionUID = 1L;
	}
	
	private static Class c = Workspace.class;
	
	private Cell cell;
	private AbstractSession session;
	private boolean readonly = false;
	private String[] workspaceChanges;
    private Transaction current;
    private List<Transaction> history;
    private Map<Configurable, ChangedElements> changedObjects = new HashMap<Configurable, ChangedElements>();
	
	protected Workspace(Cell cell) throws Exception {
		Log.entering(c, "constructor");
		this.cell = cell;
		this.session = Topology.getOperationsProvider().getConfigurationOperationsProvider().createSession(cell);
        this.current = new Transaction();
        this.history = new ArrayList<Transaction>();
        this.workspaceChanges = new String[0];
		Log.exiting(c, "constructor");
	}
	
	public AbstractSession getSession() {
		return this.session;
	}
	
	public String[] getCurrentChanges() throws Exception {
		Log.debug(c, "getChanges state: "+this.getState().name());
		if (!this.getState().equals(TransactionState.CLOSED))
			return Topology.getOperationsProvider().getConfigurationOperationsProvider().getUnsavedChanges(cell, this.session);
		else
			return this.workspaceChanges;
	}
	
	public void save() throws Exception {
		Log.entering(c, "save", this);
		if (!readonly) {
			this.workspaceChanges = Topology.getOperationsProvider().getConfigurationOperationsProvider().getUnsavedChanges(cell, this.session);
			Topology.getOperationsProvider().getConfigurationOperationsProvider().save(cell, this.session);
		}
		closeTransaction(true);
		
		// Perform a discard to clean up the session
		Topology.getOperationsProvider().getConfigurationOperationsProvider().discard(cell, this.session);
		// reset the workspace
		Topology.getOperationsProvider().getConfigurationOperationsProvider().reset(cell, this.session);
		Log.exiting(c, "save", this.workspaceChanges);
	}
    
    /**
     * This method saves the configuration and syncs the nodes in an ND topology. If the topology is
     * not {@link WebSphereTopologyType#ND}, this method will ONLY save and will not attempt to
     * sync any nodes.
     * 
     * @throws Exception
     */
    public void saveAndSync() throws Exception {
        save();
        if(cell.getTopologyType() == WebSphereTopologyType.ND && cell.getConnInfo().getConnType() != ConnectorType.NONE) {
            for(Node node : cell.getNodes()) {
                if(node.getManager().getServerType() == ServerType.NODE_AGENT && node.getManager().getServerStatus() == ProcessStatus.RUNNING) {
                    node.sync();
                }
            }
        }
    }
	
	public void discard() throws Exception {
		Log.entering(c, "discard");
		Topology.getOperationsProvider().getConfigurationOperationsProvider().discard(cell, this.session);
		closeTransaction(false);
		Log.exiting(c, "discard");
	}

	public TransactionState getState() {
		return this.current.getState();
	}

	/**
	 * The semantics for read-only aren't yet fully fleshed out.  Scope cannot yet offer
	 * a getReadOnlyTransaction() method because then write operations cannot be performed
	 * in that transaction.  Plus, with WebSphere's flat transaction implementation we
	 * can't offer nested transactions.  So read-only may be workable, but at this point
	 * is just a flag.
	 */
	protected void setReadonly() {
        final String method = "setReadOnly";
        Log.entering(c, method);
		Log.finer(c, method, "Setting readonly true");
		this.readonly = true;
        Log.exiting(c, method);
	}
    
    public List<Transaction> getTransactionHistory() {
        return this.history;
    }
    
    public void registerConfigChange(Configurable configObject) {
        registerConfigChange(configObject, null, null);
    }
	
    public void registerConfigChange(Configurable configObject, String attrib, Object origValue) {
        this.current.setDirty();
        ChangedElements elements = changedObjects.get(configObject);
        if (elements == null)
            elements = new ChangedElements();
        if (attrib != null) {
        	// ONLY store the *first* original value
        	if (!elements.containsKey(attrib))
        		elements.put(attrib, origValue);
        }
        this.changedObjects.put(configObject, elements);
    }
	
	private void closeTransaction(boolean commit) throws Exception {
        for(Map.Entry<Configurable, ChangedElements> change : this.changedObjects.entrySet()) {
        	Configurable obj = change.getKey();
        	HashMap<String, Object> values = change.getValue();
            if(commit) {
                obj.commit(values);
            } else {
                obj.rollback(values);
            }
        }
        changedObjects = new Hashtable<Configurable, ChangedElements>();
        current.close(this.workspaceChanges);
        history.add(this.current);
        current = new Transaction();
	}

    public Cell getCell() {
        return this.cell;
    }
}
