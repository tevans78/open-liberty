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
//package com.ibm.websphere.simplicity.commands.propertiesbasedconfiguration;
//
//import java.util.Properties;
//import java.util.List;
//import com.ibm.websphere.simplicity.Scope;
//import com.ibm.websphere.simplicity.OperationResults;
//import com.ibm.websphere.simplicity.commands.Command;
//
///**
// * NOTE: Please do not use this command unless a Simplicity API does not already exist.
// * Create properties file template for create/delete objects
// *   'propertiesFileName': Name of template properties file to create.
// *   'configType': Configuration type for which template properties to be created.
// * The required parameters are found in the constructor.
// */
//public class CreatePropertiesFileTemplates extends Command {
//
//	private com.ibm.websphere.management.cmdframework.DownloadFile propertiesFileName;
//	private java.lang.String configType;
//
//	public CreatePropertiesFileTemplates(com.ibm.websphere.management.cmdframework.DownloadFile propertiesFileName, java.lang.String configType) {
//		super("createPropertiesFileTemplates");
//		this.propertiesFileName = propertiesFileName;
//		this.configType = configType;
//	}
//
//	/**
//	 * Name of template properties file to create.
//	 */
//	public com.ibm.websphere.management.cmdframework.DownloadFile getPropertiesFileName() {
//		return this.propertiesFileName;
//	}
//
//	/**
//	 * Name of template properties file to create.
//	 */
//	public void setPropertiesFileName(com.ibm.websphere.management.cmdframework.DownloadFile value) {
//		this.propertiesFileName = value;
//	}
//
//	/**
//	 * Configuration type for which template properties to be created.
//	 */
//	public java.lang.String getConfigType() {
//		return this.configType;
//	}
//
//	/**
//	 * Configuration type for which template properties to be created.
//	 */
//	public void setConfigType(java.lang.String value) {
//		this.configType = value;
//	}
//
//	public Properties __getParameters() {
//		Properties ret = new Properties();
//		ret.put("propertiesFileName", this.propertiesFileName);
//		ret.put("configType", this.configType);
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
