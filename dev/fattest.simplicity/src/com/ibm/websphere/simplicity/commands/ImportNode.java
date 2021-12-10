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
//package com.ibm.websphere.simplicity.commands;
//
//import java.util.Properties;
//import java.util.List;
//import com.ibm.websphere.simplicity.Scope;
//import com.ibm.websphere.simplicity.OperationResults;
//import com.ibm.websphere.simplicity.commands.Command;
//import java.util.ArrayList;
//import com.ibm.websphere.simplicity.commands.CommandStep;
//
///**
// * NOTE: Please do not use this command unless a Simplicity API does not already exist.
// * import the configuration of a node from a config archive. This is a private command that is only invoked by addNode command.
// *   'archive': configArchiveDesc
// *   'nodeName': the node name of the added node. If the node name is not specified, then the node name in the config archive is assumed.
// *   'nodeGroupName': NodeGroupNameDesc
// *   'options':
// * The required parameters are found in the constructor.
// */
//public class ImportNode extends Command {
//
//	private List<Command> __steps;
//	private com.ibm.websphere.management.cmdframework.UploadFile archive;
//	private String nodeName;
//	private String nodeGroupName;
//	private java.util.Properties options;
//
//	public ImportNode(com.ibm.websphere.management.cmdframework.UploadFile archive) {
//		super("importNode");
//		this.archive = archive;
//	}
//
//	/**
//	 * configArchiveDesc
//	 */
//	public com.ibm.websphere.management.cmdframework.UploadFile getArchive() {
//		return this.archive;
//	}
//
//	/**
//	 * configArchiveDesc
//	 */
//	public void setArchive(com.ibm.websphere.management.cmdframework.UploadFile value) {
//		this.archive = value;
//	}
//
//	/**
//	 * the node name of the added node. If the node name is not specified, then the node name in the config archive is assumed.
//	 */
//	public String getNodeName() {
//		return this.nodeName;
//	}
//
//	/**
//	 * the node name of the added node. If the node name is not specified, then the node name in the config archive is assumed.
//	 */
//	public void setNodeName(String value) {
//		this.nodeName = value;
//	}
//
//	/**
//	 * NodeGroupNameDesc
//	 */
//	public String getNodeGroupName() {
//		return this.nodeGroupName;
//	}
//
//	/**
//	 * NodeGroupNameDesc
//	 */
//	public void setNodeGroupName(String value) {
//		this.nodeGroupName = value;
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
//		if (this.nodeName != null) {
//			ret.put("nodeName", this.nodeName);
//		}
//		if (this.nodeGroupName != null) {
//			ret.put("nodeGroupName", this.nodeGroupName);
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
//		return this.__steps;
//	}
//
//	/**
//	 * Executes the command against the specified scope.
//	 * Steps are required by this command, and they appear after the scope parameter.
//	 * Classes for these steps are statically available through this admin command class.
//	 */
//	public OperationResults<Object> run(Scope scope, MergeSecurity mergeSecurity, ConfigCoreGroup configCoreGroup, ImportSIBus importSIBus, WebsvcsConfigCoreGroup websvcsConfigCoreGroup) throws Exception {
//		this.__steps = new ArrayList<Command>();
//		if (mergeSecurity != null)
//			this.__steps.add(mergeSecurity);
//		if (configCoreGroup != null)
//			this.__steps.add(configCoreGroup);
//		if (importSIBus != null)
//			this.__steps.add(importSIBus);
//		if (websvcsConfigCoreGroup != null)
//			this.__steps.add(websvcsConfigCoreGroup);
//		return super.run(scope);
//	}
//
//	/**
//	 *
//	 * The required parameters are found in the constructor.
//	 */
//	public static class MergeSecurity extends CommandStep {
//
//		public MergeSecurity() {
//			super("MergeSecurity");
//		}
//
//		public Properties __getParameters() {
//			Properties ret = new Properties();
//			return ret;
//		}
//
//	}
//	/**
//	 *
//	 *   'coregroupName':
//	 * The required parameters are found in the constructor.
//	 */
//	public static class ConfigCoreGroup extends CommandStep {
//
//		private String coregroupName;
//
//		public ConfigCoreGroup() {
//			super("ConfigCoreGroup");
//		}
//
//		public Properties __getParameters() {
//			Properties ret = new Properties();
//			if (this.coregroupName != null) {
//				ret.put("coregroupName", this.coregroupName);
//			}
//			return ret;
//		}
//
//		/**
//		 *
//		 */
//		public String getCoregroupName() {
//			return this.coregroupName;
//		}
//
//		/**
//		 *
//		 */
//		public void setCoregroupName(String value) {
//			this.coregroupName = value;
//		}
//
//	}
//	/**
//	 * Import the bus from the federated node.
//	 *   'includeBuses': IMPORT_BUS_STEP_INCLUDE_BUSES_PARAM_DESCRIPTION
//	 * The required parameters are found in the constructor.
//	 */
//	public static class ImportSIBus extends CommandStep {
//
//		private Boolean includeBuses = false;
//
//		public ImportSIBus() {
//			super("ImportSIBus");
//		}
//
//		public Properties __getParameters() {
//			Properties ret = new Properties();
//			if (this.includeBuses != null) {
//				ret.put("includeBuses", this.includeBuses);
//			}
//			return ret;
//		}
//
//		/**
//		 * IMPORT_BUS_STEP_INCLUDE_BUSES_PARAM_DESCRIPTION
//		 */
//		public Boolean getIncludeBuses() {
//			return this.includeBuses;
//		}
//
//		/**
//		 * IMPORT_BUS_STEP_INCLUDE_BUSES_PARAM_DESCRIPTION
//		 */
//		public void setIncludeBuses(Boolean value) {
//			this.includeBuses = value;
//		}
//
//	}
//	/**
//	 *
//	 *   'coregroupName':
//	 * The required parameters are found in the constructor.
//	 */
//	public static class WebsvcsConfigCoreGroup extends CommandStep {
//
//		private String coregroupName;
//
//		public WebsvcsConfigCoreGroup() {
//			super("WebsvcsConfigCoreGroup");
//		}
//
//		public Properties __getParameters() {
//			Properties ret = new Properties();
//			if (this.coregroupName != null) {
//				ret.put("coregroupName", this.coregroupName);
//			}
//			return ret;
//		}
//
//		/**
//		 *
//		 */
//		public String getCoregroupName() {
//			return this.coregroupName;
//		}
//
//		/**
//		 *
//		 */
//		public void setCoregroupName(String value) {
//			this.coregroupName = value;
//		}
//
//	}
//}
