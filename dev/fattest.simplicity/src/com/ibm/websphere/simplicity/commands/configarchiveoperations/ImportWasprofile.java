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
//import java.util.ArrayList;
//import com.ibm.websphere.simplicity.commands.CommandStep;
//
///**
// * NOTE: Please do not use this command unless a Simplicity API does not already exist.
// * Import the configuration of a wasprofile profile from a configuration archive. This command overwrites the configuration of the current wasprofile configuration.
// *   'archive': the fully qualified file path of a config archive.
// * The required parameters are found in the constructor.
// */
//public class ImportWasprofile extends Command {
//
//	private List<Command> __steps;
//	private com.ibm.websphere.management.cmdframework.UploadFile archive;
//
//	public ImportWasprofile(com.ibm.websphere.management.cmdframework.UploadFile archive) {
//		super("importWasprofile");
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
//	public Properties __getParameters() {
//		Properties ret = new Properties();
//		ret.put("archive", this.archive);
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
//	public OperationResults<Object> run(Scope scope, UpdateNameBindings updateNameBindings, ConfigCoreGroup configCoreGroup, SIBConfig sIBConfig) throws Exception {
//		this.__steps = new ArrayList<Command>();
//		if (updateNameBindings != null)
//			this.__steps.add(updateNameBindings);
//		if (configCoreGroup != null)
//			this.__steps.add(configCoreGroup);
//		if (sIBConfig != null)
//			this.__steps.add(sIBConfig);
//		return super.run(scope);
//	}
//
//	/**
//	 *
//	 * The required parameters are found in the constructor.
//	 */
//	public static class UpdateNameBindings extends CommandStep {
//
//		public UpdateNameBindings() {
//			super("UpdateNameBindings");
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
//	 * The required parameters are found in the constructor.
//	 */
//	public static class ConfigCoreGroup extends CommandStep {
//
//		public ConfigCoreGroup() {
//			super("ConfigCoreGroup");
//		}
//
//		public Properties __getParameters() {
//			Properties ret = new Properties();
//			return ret;
//		}
//
//	}
//	/**
//	 * Update the imported configuration with SIB configuration.
//	 *   'addSIBConfig': Set this flag to update the imported configuration with SIB configuration.
//	 * The required parameters are found in the constructor.
//	 */
//	public static class SIBConfig extends CommandStep {
//
//		private Boolean addSIBConfig;
//
//		public SIBConfig() {
//			super("SIBConfig");
//		}
//
//		public Properties __getParameters() {
//			Properties ret = new Properties();
//			if (this.addSIBConfig != null) {
//				ret.put("addSIBConfig", this.addSIBConfig);
//			}
//			return ret;
//		}
//
//		/**
//		 * Set this flag to update the imported configuration with SIB configuration.
//		 */
//		public Boolean getAddSIBConfig() {
//			return this.addSIBConfig;
//		}
//
//		/**
//		 * Set this flag to update the imported configuration with SIB configuration.
//		 */
//		public void setAddSIBConfig(Boolean value) {
//			this.addSIBConfig = value;
//		}
//
//	}
//}
