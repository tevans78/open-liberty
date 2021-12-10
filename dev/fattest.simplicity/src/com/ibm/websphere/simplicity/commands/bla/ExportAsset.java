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
//package com.ibm.websphere.simplicity.commands.bla;
//
//import java.util.Properties;
//import java.util.List;
//import com.ibm.websphere.simplicity.Scope;
//import com.ibm.websphere.simplicity.OperationResults;
//import com.ibm.websphere.simplicity.commands.Command;
//
///**
// * NOTE: Please do not use this command unless a Simplicity API does not already exist.
// * Export an asset which has been imported into the product configuration repository.  Only the asset file itself is exported.  No import options for the asset are exported.
// *   'assetID': ID for the asset in any of the following forms:  &lt;asset name&gt;; assetname=&lt;asset name&gt;; WebSphere:assetname=&lt;asset name&gt;; or WebSphere:assetname=&lt;asset name&gt;,assetversion=&lt;asset version&gt;.  The version does not need to be specified unless there is more than one version.
// *   'filename': The name of the exported asset file.
// * The required parameters are found in the constructor.
// */
//public class ExportAsset extends Command {
//
//	private String assetID;
//	private com.ibm.websphere.management.cmdframework.DownloadFile filename;
//
//	public ExportAsset(String assetID, com.ibm.websphere.management.cmdframework.DownloadFile filename) {
//		super("exportAsset");
//		this.assetID = assetID;
//		this.filename = filename;
//	}
//
//	/**
//	 * ID for the asset in any of the following forms:  &lt;asset name&gt;; assetname=&lt;asset name&gt;; WebSphere:assetname=&lt;asset name&gt;; or WebSphere:assetname=&lt;asset name&gt;,assetversion=&lt;asset version&gt;.  The version does not need to be specified unless there is more than one version.
//	 */
//	public String getAssetID() {
//		return this.assetID;
//	}
//
//	/**
//	 * ID for the asset in any of the following forms:  &lt;asset name&gt;; assetname=&lt;asset name&gt;; WebSphere:assetname=&lt;asset name&gt;; or WebSphere:assetname=&lt;asset name&gt;,assetversion=&lt;asset version&gt;.  The version does not need to be specified unless there is more than one version.
//	 */
//	public void setAssetID(String value) {
//		this.assetID = value;
//	}
//
//	/**
//	 * The name of the exported asset file.
//	 */
//	public com.ibm.websphere.management.cmdframework.DownloadFile getFilename() {
//		return this.filename;
//	}
//
//	/**
//	 * The name of the exported asset file.
//	 */
//	public void setFilename(com.ibm.websphere.management.cmdframework.DownloadFile value) {
//		this.filename = value;
//	}
//
//	public Properties __getParameters() {
//		Properties ret = new Properties();
//		ret.put("assetID", this.assetID);
//		ret.put("filename", this.filename);
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
