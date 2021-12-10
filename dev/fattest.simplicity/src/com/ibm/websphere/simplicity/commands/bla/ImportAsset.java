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
// * Import an application file into the product configuration repository as an asset.
// *   'source': Pathname to the file being imported.
// *   'storageType': The store type specifies how much of the imported asset is to be stored in product configuration repository.  A value of "FULL" indicates that the complete asset file is to be stored.  A value of "METADATA" indicates that only the metadata portion of the asset file is to be stored.  The metadata portion of a jar file, for example, would include files under the "META-INF" directory. Depending on the type of jar file, metadata might include other directories, also.  A value of "NONE" indicates that no part of the asset file is to be saved.  If the storage type is "NONE", the metadata for the asset must be available through the destination URI when it is configured as a composition unit. The default storage type is that set by the asset's content handler.
// * The required parameters are found in the constructor.
// */
//public class ImportAsset extends Command {
//
//	private com.ibm.websphere.management.cmdframework.UploadFile source;
//	private String storageType;
//
//	public ImportAsset(com.ibm.websphere.management.cmdframework.UploadFile source) {
//		super("importAsset");
//		this.source = source;
//	}
//
//	/**
//	 * Pathname to the file being imported.
//	 */
//	public com.ibm.websphere.management.cmdframework.UploadFile getSource() {
//		return this.source;
//	}
//
//	/**
//	 * Pathname to the file being imported.
//	 */
//	public void setSource(com.ibm.websphere.management.cmdframework.UploadFile value) {
//		this.source = value;
//	}
//
//	/**
//	 * The store type specifies how much of the imported asset is to be stored in product configuration repository.  A value of "FULL" indicates that the complete asset file is to be stored.  A value of "METADATA" indicates that only the metadata portion of the asset file is to be stored.  The metadata portion of a jar file, for example, would include files under the "META-INF" directory. Depending on the type of jar file, metadata might include other directories, also.  A value of "NONE" indicates that no part of the asset file is to be saved.  If the storage type is "NONE", the metadata for the asset must be available through the destination URI when it is configured as a composition unit. The default storage type is that set by the asset's content handler.
//	 */
//	public String getStorageType() {
//		return this.storageType;
//	}
//
//	/**
//	 * The store type specifies how much of the imported asset is to be stored in product configuration repository.  A value of "FULL" indicates that the complete asset file is to be stored.  A value of "METADATA" indicates that only the metadata portion of the asset file is to be stored.  The metadata portion of a jar file, for example, would include files under the "META-INF" directory. Depending on the type of jar file, metadata might include other directories, also.  A value of "NONE" indicates that no part of the asset file is to be saved.  If the storage type is "NONE", the metadata for the asset must be available through the destination URI when it is configured as a composition unit. The default storage type is that set by the asset's content handler.
//	 */
//	public void setStorageType(String value) {
//		this.storageType = value;
//	}
//
//	public Properties __getParameters() {
//		Properties ret = new Properties();
//		ret.put("source", this.source);
//		if (this.storageType != null) {
//			ret.put("storageType", this.storageType);
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
