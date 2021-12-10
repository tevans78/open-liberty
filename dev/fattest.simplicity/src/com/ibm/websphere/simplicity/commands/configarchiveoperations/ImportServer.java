///*******************************************************************************
// * Copyright (c) 2011 IBM Corporation and others.
// * All rights reserved. This program and the accompanying materials
// * are made available under the terms of the Eclipse Public License v1.0
// * which accompanies this distribution, and is available at
// * http://www.eclipse.org/legal/epl-v10.html
// *
// * Contributors:
// *     IBM Corporation - initial API and implementation
// *******************************************************************************/
//
//package com.ibm.websphere.simplicity.commands.configarchiveoperations;
//
//import java.util.Properties;
//import java.util.List;
//import com.ibm.websphere.simplicity.Scope;
//import com.ibm.websphere.simplicity.OperationResults;
//import com.ibm.websphere.simplicity.commands.Command;
//
///**
// * NOTE: Please do not use this command unless a Simplicity API does not already exist.
// * Import a server configuration from a configuration archive. This command creates a new server based on the server configuration defined in the archive.
// *   'archive': the fully qualified file path of a config archive.
// *   'nodeName': node name where the server is imported.
// *   'serverName': the name of the imported server. By default it is the same as the server name in archive. If the server name collides with any existing server under the node, then an exception is thrown.
// *   'coreGroup': the name of the core group. Default core group is assumed if this parameter is not specified.
// *   'nodeInArchive': the name of a node defined in the config archive. This parameter becomes optional if there is only one node in the archive.
// *   'serverInArchive': the name of a server defined in the config archive. This parameter becomes optional if there is only one node in the archive.
// * The required parameters are found in the constructor.
// */
//public class ImportServer extends Command {
//
//	private com.ibm.websphere.management.cmdframework.UploadFile archive;
//	private String nodeName;
//	private String serverName;
//	private String coreGroup;
//	private String nodeInArchive;
//	private String serverInArchive;
//
//	public ImportServer(com.ibm.websphere.management.cmdframework.UploadFile archive, String nodeName) {
//		super("importServer");
//		this.archive = archive;
//		this.nodeName = nodeName;
//	}
//
//	/**
//	 * the fully qualified file path of a config archive.
//	 */
//	public com.ibm.websphere.management.cmdframework.UploadFile getArchive() {
//		return this.archive;
//	}
//
//	/**
//	 * the fully qualified file path of a config archive.
//	 */
//	public void setArchive(com.ibm.websphere.management.cmdframework.UploadFile value) {
//		this.archive = value;
//	}
//
//	/**
//	 * node name where the server is imported.
//	 */
//	public String getNodeName() {
//		return this.nodeName;
//	}
//
//	/**
//	 * node name where the server is imported.
//	 */
//	public void setNodeName(String value) {
//		this.nodeName = value;
//	}
//
//	/**
//	 * the name of the imported server. By default it is the same as the server name in archive. If the server name collides with any existing server under the node, then an exception is thrown.
//	 */
//	public String getServerName() {
//		return this.serverName;
//	}
//
//	/**
//	 * the name of the imported server. By default it is the same as the server name in archive. If the server name collides with any existing server under the node, then an exception is thrown.
//	 */
//	public void setServerName(String value) {
//		this.serverName = value;
//	}
//
//	/**
//	 * the name of the core group. Default core group is assumed if this parameter is not specified.
//	 */
//	public String getCoreGroup() {
//		return this.coreGroup;
//	}
//
//	/**
//	 * the name of the core group. Default core group is assumed if this parameter is not specified.
//	 */
//	public void setCoreGroup(String value) {
//		this.coreGroup = value;
//	}
//
//	/**
//	 * the name of a node defined in the config archive. This parameter becomes optional if there is only one node in the archive.
//	 */
//	public String getNodeInArchive() {
//		return this.nodeInArchive;
//	}
//
//	/**
//	 * the name of a node defined in the config archive. This parameter becomes optional if there is only one node in the archive.
//	 */
//	public void setNodeInArchive(String value) {
//		this.nodeInArchive = value;
//	}
//
//	/**
//	 * the name of a server defined in the config archive. This parameter becomes optional if there is only one node in the archive.
//	 */
//	public String getServerInArchive() {
//		return this.serverInArchive;
//	}
//
//	/**
//	 * the name of a server defined in the config archive. This parameter becomes optional if there is only one node in the archive.
//	 */
//	public void setServerInArchive(String value) {
//		this.serverInArchive = value;
//	}
//
//	public Properties __getParameters() {
//		Properties ret = new Properties();
//		ret.put("archive", this.archive);
//		ret.put("nodeName", this.nodeName);
//		if (this.serverName != null) {
//			ret.put("serverName", this.serverName);
//		}
//		if (this.coreGroup != null) {
//			ret.put("coreGroup", this.coreGroup);
//		}
//		if (this.nodeInArchive != null) {
//			ret.put("nodeInArchive", this.nodeInArchive);
//		}
//		if (this.serverInArchive != null) {
//			ret.put("serverInArchive", this.serverInArchive);
//		}
//		return ret;
//	}
//
//	public Object __getTarget() {
//		return null;
//	}
//
//	public List<Command> __getSteps() {
//		return null;
//	}
//
//	/**
//	 * Executes the command against the specified scope.
//	 */
//	public OperationResults<Object> run(Scope scope) throws Exception {
//		return super.run(scope);
//	}
//
//}
