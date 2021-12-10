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
// * Delete configuration specified in properties file
// *   'propertiesFileName': Name of file containing configuration properties to be deleted
// *   'variablesMapFileName': Name of file containing variables map to expand variables used in properties file
// *   'variablesMap': Variables map to expand variables used in properties file
// *   'reportFileName': Report file name
// *   'reportFilterMechanism': Report filter mechanism [Select one of these : All, Errors, Errors_And_Changes]
// *   'validate': ValidateProperties before applying
// * The required parameters are found in the constructor.
// */
//public class DeleteConfigProperties extends Command {
//
//	private com.ibm.websphere.management.cmdframework.UploadFile propertiesFileName;
//	private com.ibm.websphere.management.cmdframework.UploadFile variablesMapFileName;
//	private java.util.Properties variablesMap;
//	private com.ibm.websphere.management.cmdframework.DownloadFile reportFileName;
//	private java.lang.String reportFilterMechanism;
//	private Boolean validate = true;
//
//	public DeleteConfigProperties(com.ibm.websphere.management.cmdframework.UploadFile propertiesFileName) {
//		super("deleteConfigProperties");
//		this.propertiesFileName = propertiesFileName;
//	}
//
//	/**
//	 * Name of file containing configuration properties to be deleted
//	 */
//	public com.ibm.websphere.management.cmdframework.UploadFile getPropertiesFileName() {
//		return this.propertiesFileName;
//	}
//
//	/**
//	 * Name of file containing configuration properties to be deleted
//	 */
//	public void setPropertiesFileName(com.ibm.websphere.management.cmdframework.UploadFile value) {
//		this.propertiesFileName = value;
//	}
//
//	/**
//	 * Name of file containing variables map to expand variables used in properties file
//	 */
//	public com.ibm.websphere.management.cmdframework.UploadFile getVariablesMapFileName() {
//		return this.variablesMapFileName;
//	}
//
//	/**
//	 * Name of file containing variables map to expand variables used in properties file
//	 */
//	public void setVariablesMapFileName(com.ibm.websphere.management.cmdframework.UploadFile value) {
//		this.variablesMapFileName = value;
//	}
//
//	/**
//	 * Variables map to expand variables used in properties file
//	 */
//	public java.util.Properties getVariablesMap() {
//		return this.variablesMap;
//	}
//
//	/**
//	 * Variables map to expand variables used in properties file
//	 */
//	public void setVariablesMap(java.util.Properties value) {
//		this.variablesMap = value;
//	}
//
//	/**
//	 * Report file name
//	 */
//	public com.ibm.websphere.management.cmdframework.DownloadFile getReportFileName() {
//		return this.reportFileName;
//	}
//
//	/**
//	 * Report file name
//	 */
//	public void setReportFileName(com.ibm.websphere.management.cmdframework.DownloadFile value) {
//		this.reportFileName = value;
//	}
//
//	/**
//	 * Report filter mechanism [Select one of these : All, Errors, Errors_And_Changes]
//	 */
//	public java.lang.String getReportFilterMechanism() {
//		return this.reportFilterMechanism;
//	}
//
//	/**
//	 * Report filter mechanism [Select one of these : All, Errors, Errors_And_Changes]
//	 */
//	public void setReportFilterMechanism(java.lang.String value) {
//		this.reportFilterMechanism = value;
//	}
//
//	/**
//	 * ValidateProperties before applying
//	 */
//	public Boolean getValidate() {
//		return this.validate;
//	}
//
//	/**
//	 * ValidateProperties before applying
//	 */
//	public void setValidate(Boolean value) {
//		this.validate = value;
//	}
//
//	public Properties __getParameters() {
//		Properties ret = new Properties();
//		ret.put("propertiesFileName", this.propertiesFileName);
//		if (this.variablesMapFileName != null) {
//			ret.put("variablesMapFileName", this.variablesMapFileName);
//		}
//		if (this.variablesMap != null) {
//			ret.put("variablesMap", this.variablesMap);
//		}
//		if (this.reportFileName != null) {
//			ret.put("reportFileName", this.reportFileName);
//		}
//		if (this.reportFilterMechanism != null) {
//			ret.put("reportFilterMechanism", this.reportFilterMechanism);
//		}
//		if (this.validate != null) {
//			ret.put("validate", this.validate);
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
