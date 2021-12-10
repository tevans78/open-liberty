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
// * export the configuration of a server to a config archive.
// *   'serverName': the name of a server
// *   'nodeName': the name of a node. This parameter becomes optional if the specified server name is unique across the cell.
// *   'archive': the fully qualified file path of a config archive.
// * The required parameters are found in the constructor.
// */
//public class ExportServer extends Command {
//
//	private String serverName;
//	private String nodeName;
//	private com.ibm.websphere.management.cmdframework.DownloadFile archive;
//
//	public ExportServer(String serverName, String nodeName, com.ibm.websphere.management.cmdframework.DownloadFile archive) {
//		super("exportServer");
//		this.serverName = serverName;
//		this.nodeName = nodeName;
//		this.archive = archive;
//	}
//
//	/**
//	 * the name of a server
//	 */
//	public String getServerName() {
//		return this.serverName;
//	}
//
//	/**
//	 * the name of a server
//	 */
//	public void setServerName(String value) {
//		this.serverName = value;
//	}
//
//	/**
//	 * the name of a node. This parameter becomes optional if the specified server name is unique across the cell.
//	 */
//	public String getNodeName() {
//		return this.nodeName;
//	}
//
//	/**
//	 * the name of a node. This parameter becomes optional if the specified server name is unique across the cell.
//	 */
//	public void setNodeName(String value) {
//		this.nodeName = value;
//	}
//
//	/**
//	 * the fully qualified file path of a config archive.
//	 */
//	public com.ibm.websphere.management.cmdframework.DownloadFile getArchive() {
//		return this.archive;
//	}
//
//	/**
//	 * the fully qualified file path of a config archive.
//	 */
//	public void setArchive(com.ibm.websphere.management.cmdframework.DownloadFile value) {
//		this.archive = value;
//	}
//
//	public Properties __getParameters() {
//		Properties ret = new Properties();
//		ret.put("serverName", this.serverName);
//		ret.put("nodeName", this.nodeName);
//		ret.put("archive", this.archive);
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
