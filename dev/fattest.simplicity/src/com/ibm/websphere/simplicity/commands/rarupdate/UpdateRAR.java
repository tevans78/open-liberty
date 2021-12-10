/*******************************************************************************
 * Copyright (c) 2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.websphere.simplicity.commands.rarupdate;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;
import java.util.ArrayList;
import com.ibm.websphere.simplicity.commands.CommandStep;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Update an existing resource adapter with the supplied RAR file and configure any new properties that exist on deployed objects within the resource adapter to be updated. Before using the updateRAR command, use the compareResourceAdapterToRAR command to verify the RAR is compatible for upgrading the resource adapter, and use the findOtherRAsToUpdate command to determine the set of resources adapters that need be updated using the supplied RAR.
 *   'rarPath': The absolute path to the new RAR file.
 * The required parameters are found in the constructor.
 */
public class UpdateRAR extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private List<Command> __steps;
	private String rarPath;

	public UpdateRAR(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String rarPath) {
		super("updateRAR");
		this.__target = commandTarget;
		this.rarPath = rarPath;
	}

	/**
	 * The absolute path to the new RAR file.
	 */
	public String getRarPath() {
		return this.rarPath;
	}

	/**
	 * The absolute path to the new RAR file.
	 */
	public void setRarPath(String value) {
		this.rarPath = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("rarPath", this.rarPath);
		return ret;
	}

	public Object __getTarget() {
		return this.__target;
	}

	public List<Command> __getSteps() {
		return this.__steps;
	}

	/**
	 * Executes the command against the specified scope.
	 * Steps are required by this command, and they appear after the scope parameter.
	 * Classes for these steps are statically available through this admin command class.
	 */
	public OperationResults<Object> run(Scope scope, ResourceAdapterProps resourceAdapterProps, ConnectionFactoryProps connectionFactoryProps, ActivationSpecProps activationSpecProps, AdminObjectProps adminObjectProps, UpdateMQRARExt updateMQRARExt) throws Exception {
		this.__steps = new ArrayList<Command>();
		if (resourceAdapterProps != null)
			this.__steps.add(resourceAdapterProps);
		if (connectionFactoryProps != null)
			this.__steps.add(connectionFactoryProps);
		if (activationSpecProps != null)
			this.__steps.add(activationSpecProps);
		if (adminObjectProps != null)
			this.__steps.add(adminObjectProps);
		if (updateMQRARExt != null)
			this.__steps.add(updateMQRARExt);
		return super.run(scope);
	}

	/**
	 * Enter new configuration properties for the Resource Adapter.
	 *   'name': Name of the new property
	 *   'value': Value of the new property
	 * The required parameters are found in the constructor.
	 */
	public static class ResourceAdapterProps extends CommandStep {

		private String name;
		private String value;

		public ResourceAdapterProps() {
			super("ResourceAdapterProps");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			if (this.name != null) {
				ret.put("name", this.name);
			}
			if (this.value != null) {
				ret.put("value", this.value);
			}
			return ret;
		}

		/**
		 * Name of the new property
		 */
		public String getName() {
			return this.name;
		}

		/**
		 * Name of the new property
		 */
		public void setName(String value) {
			this.name = value;
		}

		/**
		 * Value of the new property
		 */
		public String getValue() {
			return this.value;
		}

		/**
		 * Value of the new property
		 */
		public void setValue(String value) {
			this.value = value;
		}

	}
	/**
	 * Enter new configuration properties for the Connection Factories.
	 *   'name': Name of the new property
	 *   'value': Value of the new property
	 *   'jndiName': JNDI Name of the Configured Object
	 * The required parameters are found in the constructor.
	 */
	public static class ConnectionFactoryProps extends CommandStep {

		private String name;
		private String value;
		private String jndiName;

		public ConnectionFactoryProps() {
			super("ConnectionFactoryProps");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			if (this.name != null) {
				ret.put("name", this.name);
			}
			if (this.value != null) {
				ret.put("value", this.value);
			}
			if (this.jndiName != null) {
				ret.put("jndiName", this.jndiName);
			}
			return ret;
		}

		/**
		 * Name of the new property
		 */
		public String getName() {
			return this.name;
		}

		/**
		 * Name of the new property
		 */
		public void setName(String value) {
			this.name = value;
		}

		/**
		 * Value of the new property
		 */
		public String getValue() {
			return this.value;
		}

		/**
		 * Value of the new property
		 */
		public void setValue(String value) {
			this.value = value;
		}

		/**
		 * JNDI Name of the Configured Object
		 */
		public String getJndiName() {
			return this.jndiName;
		}

		/**
		 * JNDI Name of the Configured Object
		 */
		public void setJndiName(String value) {
			this.jndiName = value;
		}

	}
	/**
	 * Enter new configuration properties for the Activation Specifications.
	 *   'name': Name of the new property
	 *   'value': Value of the new property
	 *   'jndiName': JNDI Name of the Configured Object
	 * The required parameters are found in the constructor.
	 */
	public static class ActivationSpecProps extends CommandStep {

		private String name;
		private String value;
		private String jndiName;

		public ActivationSpecProps() {
			super("ActivationSpecProps");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			if (this.name != null) {
				ret.put("name", this.name);
			}
			if (this.value != null) {
				ret.put("value", this.value);
			}
			if (this.jndiName != null) {
				ret.put("jndiName", this.jndiName);
			}
			return ret;
		}

		/**
		 * Name of the new property
		 */
		public String getName() {
			return this.name;
		}

		/**
		 * Name of the new property
		 */
		public void setName(String value) {
			this.name = value;
		}

		/**
		 * Value of the new property
		 */
		public String getValue() {
			return this.value;
		}

		/**
		 * Value of the new property
		 */
		public void setValue(String value) {
			this.value = value;
		}

		/**
		 * JNDI Name of the Configured Object
		 */
		public String getJndiName() {
			return this.jndiName;
		}

		/**
		 * JNDI Name of the Configured Object
		 */
		public void setJndiName(String value) {
			this.jndiName = value;
		}

	}
	/**
	 * J2CA0619
	 *   'name': Name of the new property
	 *   'value': Value of the new property
	 *   'jndiName': JNDI Name of the Configured Object
	 * The required parameters are found in the constructor.
	 */
	public static class AdminObjectProps extends CommandStep {

		private String name;
		private String value;
		private String jndiName;

		public AdminObjectProps() {
			super("AdminObjectProps");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			if (this.name != null) {
				ret.put("name", this.name);
			}
			if (this.value != null) {
				ret.put("value", this.value);
			}
			if (this.jndiName != null) {
				ret.put("jndiName", this.jndiName);
			}
			return ret;
		}

		/**
		 * Name of the new property
		 */
		public String getName() {
			return this.name;
		}

		/**
		 * Name of the new property
		 */
		public void setName(String value) {
			this.name = value;
		}

		/**
		 * Value of the new property
		 */
		public String getValue() {
			return this.value;
		}

		/**
		 * Value of the new property
		 */
		public void setValue(String value) {
			this.value = value;
		}

		/**
		 * JNDI Name of the Configured Object
		 */
		public String getJndiName() {
			return this.jndiName;
		}

		/**
		 * JNDI Name of the Configured Object
		 */
		public void setJndiName(String value) {
			this.jndiName = value;
		}

	}
	/**
	 * 
	 * The required parameters are found in the constructor.
	 */
	public static class UpdateMQRARExt extends CommandStep {

		public UpdateMQRARExt() {
			super("updateMQRARExt");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			return ret;
		}

	}
}
