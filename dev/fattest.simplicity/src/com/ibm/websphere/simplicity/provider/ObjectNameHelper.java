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

package com.ibm.websphere.simplicity.provider;

import java.util.*;

import javax.management.ObjectName;

import com.ibm.websphere.simplicity.ApplicationServer;
import com.ibm.websphere.simplicity.Cell;
import com.ibm.websphere.simplicity.Node;
import com.ibm.websphere.simplicity.NodeAgent;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.ScopeHelper;
import com.ibm.websphere.simplicity.ScopeHelperType;
import com.ibm.websphere.simplicity.ServerType;

public class ObjectNameHelper {
	
	/**
	 * Start static accessors
	 */
	
	public static ObjectNameHelper getEmptySpec() {
		return new ObjectNameHelper(Constants.Wildcard);
	}

	/**
	 * @param scope
	 * @param applicationName
	 * @return A query to resolve the specified application on the specified endpoint.
	 */
	public static ObjectNameHelper getApplication(Scope scope, String applicationName) {
		ObjectNameHelper ret = new ObjectNameHelper(Constants.Wildcard);
		ret.setType(Constants.Application);
		ret.addFragment(scope.getObjectNameFragment());
		ret.setName(applicationName);
		return ret;
	}
	
	/**
	 * @param scope
	 * @param applicationName
	 * @return A query to resolve the specified application on the specified endpoint.
	 */
	public static ObjectNameHelper getJ2EEApplication(Scope scope, String applicationName) {
		ObjectNameHelper ret = new ObjectNameHelper(Constants.Wildcard);
		ret.setType(Constants.J2EEApplication);
		ret.addFragment(scope.getObjectNameFragment());
		ret.setName(applicationName);
		return ret;
	}

	/**
	 * @param type
	 * @return A query to resolve all ObjectNames identified by the specified type.
	 */
	public static ObjectNameHelper getByType(String type) {
		ObjectNameHelper ret = new ObjectNameHelper(Constants.Wildcard);
		ret.setType(type);
		return ret;
	}

	/**
	 * @param type
	 * @param scope
	 * @return A query to resolve all ObjectNames identified by the specified type within the specified scope.
	 */
	public static ObjectNameHelper getByType(String type, ScopeHelper scope) {
		ObjectNameHelper ret = new ObjectNameHelper(Constants.Wildcard);
		ret.setType(type);
		ret.setScope(scope);
		return ret;
	}
	
	/**
	 * @param scope
	 * @return A query to resolve the application manager mbean on the target endpoint.
	 */
	public static ObjectNameHelper getApplicationManagement(Scope scope) {
		ObjectNameHelper ret = new ObjectNameHelper(Constants.WebSphere);
		ret.setType(Constants.AppMgmt);
		ret.addFragment(scope.getObjectNameFragment());
		return ret;
	}
	
	public static ObjectNameHelper getFileBrowser(Scope scope) {
		ObjectNameHelper ret = new ObjectNameHelper(Constants.WebSphere);
		ret.setType("FileBrowser");
		ret.addFragment(scope.getObjectNameFragment());
		return ret;
	}
	
	/**
	 * @param server
	 * @return A query to resolve the trace service mbean on the target endpoint.
	 */
	public static ObjectNameHelper getTraceService(ApplicationServer server) {
		ObjectNameHelper ret = new ObjectNameHelper(Constants.WebSphere);
		ret.setType("TraceService");
		ret.setName("TraceService");
		ret.setCell(server.getCellName());
		ret.setNode(server.getNode().getName());
		ret.setProcess(server.getName());
		return ret;
	}

	/**
	 * @param cell
	 * @return A query to resolve the authorization group manager for the target endpoint.
	 */
	public static ObjectNameHelper getAuthorizationGroupManager(Cell cell) {
		ObjectNameHelper ret = new ObjectNameHelper(Constants.WebSphere);
		ret.setType(Constants.AuthGroupMgr);
		ret.setCell(cell.getName());
		return ret;
	}

	/**
	 * @param node
	 * @return A query to resolve the admin operations mbean for the target endpoint's node.
	 */
	public static ObjectNameHelper getAdminOperationsByNode(Node node) {
		ObjectNameHelper ret = new ObjectNameHelper(Constants.WebSphere);
		ret.setType(Constants.AdminOps);
		ret.setNode(node.getName());
		return ret;
	}

	/**
	 * @param server
	 * @return A query to resolve the admin operations mbean for the target endpoint.
	 */
	public static ObjectNameHelper getAdminOperationsByProcess(ApplicationServer server) {
		ObjectNameHelper ret = getAdminOperationsByNode(server.getNode());
		ret.setProcess(server.getName());
		return ret;
	}

	/**
	 * @param type
	 * @return A query to resolve all server ObjectNames identified by the specified type.
	 * @throws Exception
	 */
	public static ObjectNameHelper getServer(ServerType type) throws Exception {
		ObjectNameHelper ret = new ObjectNameHelper(Constants.WebSphere);
		ret.setType(Constants.Server);
		ret.setProcessType(type.toProcessType());
		return ret;
	}

	/**
	 * @param type
	 * @param cellName
	 * @param nodeName
	 * @return A query to resolve all server ObjectNames identified by the specified type within the specified cell and node.
	 * @throws Exception
	 */
	public static ObjectNameHelper getServer(ServerType type, String cellName, String nodeName) throws Exception {
		ObjectNameHelper ret = new ObjectNameHelper(Constants.WebSphere);
		ret.setType(Constants.Server);
		ret.setProcessType(type.toProcessType());
		ret.setCell(cellName);
		ret.setNode(nodeName);
		return ret;
	}

	/**
	 * @param nodeName
	 * @param processName
	 * @return A query to resolve a single server ObjectName within a specified node.
	 */
	public static ObjectNameHelper getServer(String nodeName, String processName) {
		ObjectNameHelper ret = new ObjectNameHelper(Constants.Wildcard);
        ret.setType(Constants.Server);
		ret.setNode(nodeName);
		ret.setProcess(processName);
		return ret;
	}
	
	/**
	 * @param nodeName
	 * @return A query to resolve the NodeAgent mbean for the specified node.
	 */
	public static ObjectNameHelper getNodeAgent(String nodeName) {
		ObjectNameHelper ret = new ObjectNameHelper(Constants.Wildcard);
		ret.setType("NodeAgent");
		ret.setNode(nodeName);
		return ret;
	}
	
	/**
	 * @param node
	 * @return A query to resolve the node sync mbean on the specified NodeAgent.
	 */
	public static ObjectNameHelper getNodeSync(NodeAgent node) {
		ObjectNameHelper ret = new ObjectNameHelper(Constants.Wildcard);
		ret.setType(Constants.NodeSync);
		ret.setNode(node.getNode().getName());
		ret.setProcess(node.getName());
		return ret;
	}

	/**
	 * @param fullName
	 * @return A query to resolve the node group mbean identified by the specified name.
	 */
	public static ObjectNameHelper getNodeGroup(String fullName) {
		ObjectNameHelper ret = new ObjectNameHelper(Constants.Wildcard);
		ret.setType("NodeGroup");
		ret.setName(fullName);
		return ret;
	}

	/**
	 * @param name
	 * @param cell
	 * @return A query to resolve the specified cluster's mbean. 
	 */
	public static ObjectNameHelper getCluster(String name, Cell cell) {
		ObjectNameHelper ret = new ObjectNameHelper(Constants.Wildcard);
		ret.setCell(cell.getName());
		ret.setType("Cluster");
		ret.setName(name);
		return ret;
	}
	
	/**
	 * Start instance members
	 */
	
	protected Map<String, String> spec = new HashMap<String, String>();
	protected String prefix = "";
	
	private ObjectNameHelper(String prefix) {
		this.prefix = prefix;
	}
	
	/**
	 * Processes a portion of an ObjectName specification, such as:
	 * 	 cell=myCell
	 *   node=myNode,server=myServer
	 * @param fragment
	 */
	public void addFragment(String fragment) {
		String[] terms;
		if (fragment.contains(","))
			terms = fragment.split(",");
		else
			terms = new String[] { fragment };
		
		for (String term : terms) {
			if (!term.contains("="))
				continue;
            if(term.startsWith("WebSphere:"))
                term = term.substring(10);
			String[] parts = term.split("=");
			spec.put(parts[0], parts[1]);
		}
	}
	
	public void set(String key, String value) {
		spec.put(key, value);
	}
	
	public void setName(String value) {
		spec.put(Constants.Name, value);
	}
	
	public void setProcess(String value) {
		spec.put(Constants.Process, value);
	}
	
	public void setCell(String value) {
		set(Constants.Cell, value);
	}
	
	public void setNode(String value) {
		set(Constants.Node, value);
	}
	
	public void setType(String value) {
		set(Constants.Type, value);
	}
	
	public void setProcessType(String value) {
		set(Constants.ProcessType, value);
	}
	
	public void setCluster(String value) {
		set(Constants.Cluster, value);
	}
	
	public void setScope(ScopeHelper scope) {
		if (scope.contains(ScopeHelperType.CELL))
			setCell(scope.get(ScopeHelperType.CELL));
		if (scope.contains(ScopeHelperType.NODE))
			setNode(scope.get(ScopeHelperType.NODE));
		if (scope.contains(ScopeHelperType.SERVER))
			setProcess(scope.get(ScopeHelperType.SERVER));
		if (scope.contains(ScopeHelperType.SERVER_CLUSTER))
			setCluster(scope.get(ScopeHelperType.SERVER_CLUSTER));
	}
	
	public void remove(String key) {
		spec.remove(key);
	}
	
	public void setPrefix(String p) {
		prefix = p;
	}
	
	public String toString() {
		String res = "";
		if (prefix.equals(""))
			res += "*:";
		else
			res += prefix+":";
		for (Map.Entry<String, String> e : spec.entrySet())
			res += e.getKey()+"="+e.getValue()+",";
		res += "*";
		
		return res;
	}
	
	public String toConfigDataString() {
		String res = "Websphere:";
		for (Map.Entry<String, String> e : spec.entrySet()) {
			String key = convertToConfigDataKey(e.getKey());
			if (key != null) {
				res += key+"="+e.getValue()+",";
			}
		}
		res += "*";
		
		return res;
	}
	
	public ObjectName toObjectName() throws Exception {
		return new ObjectName(toString());
	}
	
	public ObjectName toConfigDataObjectName() throws Exception {
		return new ObjectName(toConfigDataString());
	}
	
	private String convertToConfigDataKey(String key) {
		String ret = null;
		if (key.equalsIgnoreCase(Constants.Name))
			ret = "_Websphere_Config_Data_Display_Name";
		else if (key.equalsIgnoreCase(Constants.Type))
			ret = "_Websphere_Config_Data_Type";
		else if (key.equalsIgnoreCase(Constants.Cluster))
			ret = "ServerCluster";
		return ret;
	}

}

class Constants {
	public static final String Wildcard = "*";
	public static final String WebSphere = "WebSphere";
	public static final String Server = "Server";
	public static final String AppMgmt = "AppManagement";
	public static final String AdminOps = "AdminOperations";
	public static final String AuthGroupMgr = "AuthorizationGroupManager";
	public static final String Application = "Application";
	public static final String J2EEApplication = "J2EEApplication";
	public static final String NodeSync = "NodeSync";
	public static final String Type = "type";
	public static final String Process = "process";
	public static final String ProcessType = "processType";
	public static final String Node = "node";
	public static final String Cell = "cell";
	public static final String Name = "name";
	public static final String Cluster = "cluster";
}