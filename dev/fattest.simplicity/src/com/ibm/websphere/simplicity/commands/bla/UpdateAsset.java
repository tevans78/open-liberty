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
// * Update an imported asset file.
// *   'assetID': ID for the asset in any of the following forms:  &lt;asset name&gt;; assetname=&lt;asset name&gt;; WebSphere:assetname=&lt;asset name&gt;; or WebSphere:assetname=&lt;asset name&gt;,assetversion=&lt;asset version&gt;.  The version does not need to be specified unless there is more than one version.
// *   'operation': Specify the type of update operation you want to perform.  Specify "replace" to replace the entire asset.  Specify "add" to add a single file to the asset archive.  Specify "update" to update a single existing file in the asset archive.  Specify "addupdate" to add or update a single file in the asset archive.  Specify "delete" to delete a single file in the asset archive.  Specify "merge" to add, update, and delete multiple asset archive files.  To delete files from an archive, place META-INF/ibm-partialapp-delete.props file in the input archive. This file should contain the URIs of the files to be deleted from the asset archive with one URI on each line.
// *   'contents': Specify contents for asset update. This option is required for "operation" parameter values except "delete".  If the "operation" parameter value is "replace", the "contents" value is the file pathname of the archive file that completely replaces the existing asset archive.  If the "operation" parameter value is "add", "update", or "addupdate", the "contents" value must be the file pathname of a single file.  In addtion, the "contenturi" paramter must be specified.  If the "operation" parameter value is "merge", the "contents" value is the file pathname of an archive of files.   Those files are merged into the asset being updated.  That is, all files in the input archive are added to or replace the target asset files.
// *   'contenturi': If you specified a single input file, that is, if you specfied an "operation" parameter value other than "replace" or "merge", specify a content URI.  The value specifies the URI within the asset archive which is being added, updated, or deleted.
// * The required parameters are found in the constructor.
// */
//public class UpdateAsset extends Command {
//
//	private String assetID;
//	private String operation;
//	private com.ibm.websphere.management.cmdframework.UploadFile contents;
//	private String contenturi;
//
//	public UpdateAsset(String assetID, String operation) {
//		super("updateAsset");
//		this.assetID = assetID;
//		this.operation = operation;
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
//	 * Specify the type of update operation you want to perform.  Specify "replace" to replace the entire asset.  Specify "add" to add a single file to the asset archive.  Specify "update" to update a single existing file in the asset archive.  Specify "addupdate" to add or update a single file in the asset archive.  Specify "delete" to delete a single file in the asset archive.  Specify "merge" to add, update, and delete multiple asset archive files.  To delete files from an archive, place META-INF/ibm-partialapp-delete.props file in the input archive. This file should contain the URIs of the files to be deleted from the asset archive with one URI on each line.
//	 */
//	public String getOperation() {
//		return this.operation;
//	}
//
//	/**
//	 * Specify the type of update operation you want to perform.  Specify "replace" to replace the entire asset.  Specify "add" to add a single file to the asset archive.  Specify "update" to update a single existing file in the asset archive.  Specify "addupdate" to add or update a single file in the asset archive.  Specify "delete" to delete a single file in the asset archive.  Specify "merge" to add, update, and delete multiple asset archive files.  To delete files from an archive, place META-INF/ibm-partialapp-delete.props file in the input archive. This file should contain the URIs of the files to be deleted from the asset archive with one URI on each line.
//	 */
//	public void setOperation(String value) {
//		this.operation = value;
//	}
//
//	/**
//	 * Specify contents for asset update. This option is required for "operation" parameter values except "delete".  If the "operation" parameter value is "replace", the "contents" value is the file pathname of the archive file that completely replaces the existing asset archive.  If the "operation" parameter value is "add", "update", or "addupdate", the "contents" value must be the file pathname of a single file.  In addtion, the "contenturi" paramter must be specified.  If the "operation" parameter value is "merge", the "contents" value is the file pathname of an archive of files.   Those files are merged into the asset being updated.  That is, all files in the input archive are added to or replace the target asset files.
//	 */
//	public com.ibm.websphere.management.cmdframework.UploadFile getContents() {
//		return this.contents;
//	}
//
//	/**
//	 * Specify contents for asset update. This option is required for "operation" parameter values except "delete".  If the "operation" parameter value is "replace", the "contents" value is the file pathname of the archive file that completely replaces the existing asset archive.  If the "operation" parameter value is "add", "update", or "addupdate", the "contents" value must be the file pathname of a single file.  In addtion, the "contenturi" paramter must be specified.  If the "operation" parameter value is "merge", the "contents" value is the file pathname of an archive of files.   Those files are merged into the asset being updated.  That is, all files in the input archive are added to or replace the target asset files.
//	 */
//	public void setContents(com.ibm.websphere.management.cmdframework.UploadFile value) {
//		this.contents = value;
//	}
//
//	/**
//	 * If you specified a single input file, that is, if you specfied an "operation" parameter value other than "replace" or "merge", specify a content URI.  The value specifies the URI within the asset archive which is being added, updated, or deleted.
//	 */
//	public String getContenturi() {
//		return this.contenturi;
//	}
//
//	/**
//	 * If you specified a single input file, that is, if you specfied an "operation" parameter value other than "replace" or "merge", specify a content URI.  The value specifies the URI within the asset archive which is being added, updated, or deleted.
//	 */
//	public void setContenturi(String value) {
//		this.contenturi = value;
//	}
//
//	public Properties __getParameters() {
//		Properties ret = new Properties();
//		ret.put("assetID", this.assetID);
//		ret.put("operation", this.operation);
//		if (this.contents != null) {
//			ret.put("contents", this.contents);
//		}
//		if (this.contenturi != null) {
//			ret.put("contenturi", this.contenturi);
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
