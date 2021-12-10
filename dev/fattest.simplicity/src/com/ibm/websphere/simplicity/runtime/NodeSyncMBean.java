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

package com.ibm.websphere.simplicity.runtime;

import com.ibm.websphere.simplicity.ApplicationServer;

/**
 * Represents the node sync mbean for a particular node.  Multiple instances of this
 * class created with servers from the same node will all point to the same mbean. 
 */
public class NodeSyncMBean extends MBean {
	
	protected static final String AUTO_SYNC_ENABLED = "autoSyncEnabled";
	protected static final String SERVER_STARTUP_SYNC_ENABLED = "serverStartupSyncEnabled";
	protected static final String SYNC_INTERVAL = "syncInterval";

	public NodeSyncMBean(ApplicationServer scope) throws Exception {
		super(scope);
        resolveObjectName("*:name=nodeSync,type=NodeSync,node=" + scope.getNode().getName() + ",*");
	}
	
	public boolean isAutoSyncEnabled() throws Exception {
		return (Boolean)this.getAttribute(AUTO_SYNC_ENABLED);
	}
	
	public boolean isServerStartupSyncEnabled() throws Exception {
		return (Boolean)this.getAttribute(SERVER_STARTUP_SYNC_ENABLED);
	}
	
	public int getSyncInterval() throws Exception {
		return (Integer)this.getAttribute(SYNC_INTERVAL);
	}
	
	public void setAutoSyncEnabled(boolean value) throws Exception {
		this.setAttribute(AUTO_SYNC_ENABLED, value);
	}
	
	public void setServerStartupSyncEnabled(boolean value) throws Exception {
		this.setAttribute(SERVER_STARTUP_SYNC_ENABLED, value);
	}
	
	public void setSyncInterval(int value) throws Exception {
		this.setAttribute(SYNC_INTERVAL, value);
	}
	
	/**
	 * A blocking call to synchronize the node with the cell.
	 * @return The success or failure of the synchronize call.
	 * @throws Exception
	 */
	public boolean sync() throws Exception {
		return (Boolean)this.invoke("sync");
	}
	
	/**
	 * A non-blocking call to synchronize the node with the cell.
	 * @return True if the synchronize request was accepted.
	 * @throws Exception
	 */
	public boolean requestSync() throws Exception {
		return (Boolean)this.invoke("requestSync");
	}
	
	/**
	 * This is a blocking call that will either a) wait for an in-progress sync
	 * to finish; or b) initiate a new sync, and wait for it to finish.
	 * @return True if the node is synchronized with the cell.
	 * @throws Exception
	 */
	public boolean isNodeSynchronized() throws Exception {
		return (Boolean)this.invoke("isNodeSynchronized");
	}
	
	/**
	 * Get the results of the most resent sync
     * 
	 * @return A {@link NodeSyncResult} with the latest sync results
	 * @throws Exception
	 */
	public NodeSyncResult getResult() throws Exception {
        Object results = this.invoke("getResult");
        return getOperationsProvider().convertToNodeSyncResult(results);
    }
}
