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
import java.util.Hashtable;
import java.util.Map;

import com.ibm.websphere.simplicity.application.Application;

/**
 * WebSphere has several types of "identification strings", including: the Java-standard
 * ObjectName for identifying server artifacts; a WebSphere-specific ObjectName to identify
 * configuration elements; and a server identifier for mapping modules to servers.  This
 * structure assists with the last.
 */
public class ScopeHelper {

	private Map<String, String> values = new HashMap<String, String>();
	
	public ScopeHelper() {
	}
	
	public ScopeHelper(Cell cell) {
		this.setCell(cell);
	}
	
	public ScopeHelper(Node node) {
		this(node.getCell());
		this.setNode(node);
	}
	
	public ScopeHelper(Server server) {
		this(server.getNode());
		this.setServer(server);
	}
	
	public ScopeHelper(NodeGroup nodegroup) {
		this(nodegroup.getCell());
		this.setNodeGroup(nodegroup);
	}
	
	public ScopeHelper(Cluster cluster) {
		this(cluster.getCell());
		this.setCluster(cluster);
	}
	
	public boolean contains(ScopeHelperType type) {
		return values.containsKey(type.name());
	}
	
	public String get(ScopeHelperType type) {
		if (values.containsKey(type.name()))
			return values.get(type.name());
		return null;
	}

	public void setCell(Cell cell) {
		setScopeType(ScopeHelperType.CELL, cell.getName());
	}
	
	public void setNode(Node node) {
		setScopeType(ScopeHelperType.NODE, node.getName());
	}
	
	public void setServer(Server process) {
		setScopeType(ScopeHelperType.SERVER, process.getName());
	}
	
	public void setApplication(Application application) {
		setScopeType(ScopeHelperType.DEPLOYMENT, application.getName());
	}
	
	public void setCluster(Cluster cluster) {
		setScopeType(ScopeHelperType.SERVER_CLUSTER, cluster.getName());
	}
	
	public void setNodeGroup(NodeGroup nodegroup) {
		setScopeType(ScopeHelperType.NODE_GROUP, nodegroup.getName());
	}
	
	/**
	 * Returns a scope string representation.
	 */
	public String toString() {
		String ret = "";
		for (Map.Entry<String, String> entry : values.entrySet())
			ret += entry.getKey()+"="+entry.getValue()+":";
		ret = ret.substring(0, ret.length()-1);
		return ret;
	}
	
	public Hashtable<String, String> toHashtable() {
		Hashtable<String, String> ret = new Hashtable<String, String>();
		for (Map.Entry<String, String> entry : values.entrySet())
			ret.put(entry.getKey(), entry.getValue());
		return ret;
	}
	
	private void setScopeType(ScopeHelperType type, String value) {
		values.put(type.name(), value);
	}
	
}
