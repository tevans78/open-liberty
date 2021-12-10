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
// * Import a Secure Proxy Profile into this cell.
// *   'archive': the fully qualified file path of a config archive.
// *   'deleteExistingServers':
// *   'options':
// * The required parameters are found in the constructor.
// */
//public class ImportProxyProfile extends Command {
//
//	private com.ibm.websphere.management.cmdframework.UploadFile archive;
//	private Boolean deleteExistingServers = false;
//	private java.util.Properties options;
//
//	public ImportProxyProfile(com.ibm.websphere.management.cmdframework.UploadFile archive) {
//		super("importProxyProfile");
//		this.archive = archive;
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
//	 *
//	 */
//	public Boolean getDeleteExistingServers() {
//		return this.deleteExistingServers;
//	}
//
//	/**
//	 *
//	 */
//	public void setDeleteExistingServers(Boolean value) {
//		this.deleteExistingServers = value;
//	}
//
//	/**
//	 *
//	 */
//	public java.util.Properties getOptions() {
//		return this.options;
//	}
//
//	/**
//	 *
//	 */
//	public void setOptions(java.util.Properties value) {
//		this.options = value;
//	}
//
//	public Properties __getParameters() {
//		Properties ret = new Properties();
//		ret.put("archive", this.archive);
//		if (this.deleteExistingServers != null) {
//			ret.put("deleteExistingServers", this.deleteExistingServers);
//		}
//		if (this.options != null) {
//			ret.put("options", this.options);
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
