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
// * Extract configuration to a properties file. Extracts configuration of the object specified by ConfigId or ConfigData parameter. ConfigData parameter should be of the form Node=nodeName:Server=serverName.
// *   'propertiesFileName': Name of file to extract configuration properties.
// *   'configData': Configuration scope to be extracted. Example, Node=nodeName or Node=nodeName:Server=serverName
// *   'options': Additional options (GENERATETEMPLATE=true)
// *   'filterMechanism': Filter Mechanism [All, NO_SUBTYPES, SELECTED_SUBTYPES]
// *   'selectedSubTypes': Selected SubTypes (Example of Server SubTypes: ApplicationServer, EJBContainer)
// * The required parameters are found in the constructor.
// */
//public class ExtractConfigProperties extends Command {
//
//	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
//	private com.ibm.websphere.management.cmdframework.DownloadFile propertiesFileName;
//	private java.lang.String configData;
//	private java.util.Properties options;
//	private java.lang.String filterMechanism;
//	private java.lang.String[] selectedSubTypes;
//
//	public ExtractConfigProperties(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, com.ibm.websphere.management.cmdframework.DownloadFile propertiesFileName) {
//		super("extractConfigProperties");
//		this.__target = commandTarget;
//		this.propertiesFileName = propertiesFileName;
//	}
//
//	/**
//	 * Name of file to extract configuration properties.
//	 */
//	public com.ibm.websphere.management.cmdframework.DownloadFile getPropertiesFileName() {
//		return this.propertiesFileName;
//	}
//
//	/**
//	 * Name of file to extract configuration properties.
//	 */
//	public void setPropertiesFileName(com.ibm.websphere.management.cmdframework.DownloadFile value) {
//		this.propertiesFileName = value;
//	}
//
//	/**
//	 * Configuration scope to be extracted. Example, Node=nodeName or Node=nodeName:Server=serverName
//	 */
//	public java.lang.String getConfigData() {
//		return this.configData;
//	}
//
//	/**
//	 * Configuration scope to be extracted. Example, Node=nodeName or Node=nodeName:Server=serverName
//	 */
//	public void setConfigData(java.lang.String value) {
//		this.configData = value;
//	}
//
//	/**
//	 * Additional options (GENERATETEMPLATE=true)
//	 */
//	public java.util.Properties getOptions() {
//		return this.options;
//	}
//
//	/**
//	 * Additional options (GENERATETEMPLATE=true)
//	 */
//	public void setOptions(java.util.Properties value) {
//		this.options = value;
//	}
//
//	/**
//	 * Filter Mechanism [All, NO_SUBTYPES, SELECTED_SUBTYPES]
//	 */
//	public java.lang.String getFilterMechanism() {
//		return this.filterMechanism;
//	}
//
//	/**
//	 * Filter Mechanism [All, NO_SUBTYPES, SELECTED_SUBTYPES]
//	 */
//	public void setFilterMechanism(java.lang.String value) {
//		this.filterMechanism = value;
//	}
//
//	/**
//	 * Selected SubTypes (Example of Server SubTypes: ApplicationServer, EJBContainer)
//	 */
//	public java.lang.String[] getSelectedSubTypes() {
//		return this.selectedSubTypes;
//	}
//
//	/**
//	 * Selected SubTypes (Example of Server SubTypes: ApplicationServer, EJBContainer)
//	 */
//	public void setSelectedSubTypes(java.lang.String[] value) {
//		this.selectedSubTypes = value;
//	}
//
//	/**
//	 * Change the command's target (originally specified in constructor).
//	 */
//	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
//		this.__target = value;
//	}
//
//	public Properties __getParameters() {
//		Properties ret = new Properties();
//		ret.put("propertiesFileName", this.propertiesFileName);
//		if (this.configData != null) {
//			ret.put("configData", this.configData);
//		}
//		if (this.options != null) {
//			ret.put("options", this.options);
//		}
//		if (this.filterMechanism != null) {
//			ret.put("filterMechanism", this.filterMechanism);
//		}
//		if (this.selectedSubTypes != null) {
//			ret.put("selectedSubTypes", this.selectedSubTypes);
//		}
//		return ret;
//	}
//
//	public Object __getTarget() {
//		return this.__target;
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
