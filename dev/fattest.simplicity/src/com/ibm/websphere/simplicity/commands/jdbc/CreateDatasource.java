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

package com.ibm.websphere.simplicity.commands.jdbc;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;
import java.util.ArrayList;
import com.ibm.websphere.simplicity.commands.CommandStep;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Create a new Datasource to access the backend data store.  Application components use the Datasource to access connection instances to your database. A connection pool is associated with each Datasource.
 *   'name': The name of the Datasource.
 *   'jndiName': The Java Naming and Directory Interface (JNDI) name for this Datasource.
 *   'description': The description for the Datasource.
 *   'category': The category that can be used to classify or group the resource.
 *   'dataStoreHelperClassName': The name of the DataStoreHelper implementation class that extends the capabilities of the implementation class of the JDBC driver to perform functions that are specific to the data.
 *   'componentManagedAuthenticationAlias': The alias used for database authentication at run time.  This alias is only used when the application resource reference is using res-auth=Application.
 *   'containerManagedPersistence': Specifies if this Datasource is used for container-managed persistence of enterprise beans. The default value is true.
 *   'xaRecoveryAuthAlias': The alias used database authentication during XA recovery processing. When this property is specified, the default value is the alias for application authentication.
 * The required parameters are found in the constructor.
 */
public class CreateDatasource extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private List<Command> __steps;
	private String name;
	private String jndiName;
	private String description;
	private String category;
	private String dataStoreHelperClassName;
	private String componentManagedAuthenticationAlias;
	private Boolean containerManagedPersistence = true;
	private String xaRecoveryAuthAlias;

	public CreateDatasource(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String name, String jndiName, String dataStoreHelperClassName) {
		super("createDatasource");
		this.__target = commandTarget;
		this.name = name;
		this.jndiName = jndiName;
		this.dataStoreHelperClassName = dataStoreHelperClassName;
	}

	/**
	 * The name of the Datasource.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The name of the Datasource.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * The Java Naming and Directory Interface (JNDI) name for this Datasource.
	 */
	public String getJndiName() {
		return this.jndiName;
	}

	/**
	 * The Java Naming and Directory Interface (JNDI) name for this Datasource.
	 */
	public void setJndiName(String value) {
		this.jndiName = value;
	}

	/**
	 * The description for the Datasource.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * The description for the Datasource.
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * The category that can be used to classify or group the resource.
	 */
	public String getCategory() {
		return this.category;
	}

	/**
	 * The category that can be used to classify or group the resource.
	 */
	public void setCategory(String value) {
		this.category = value;
	}

	/**
	 * The name of the DataStoreHelper implementation class that extends the capabilities of the implementation class of the JDBC driver to perform functions that are specific to the data.
	 */
	public String getDataStoreHelperClassName() {
		return this.dataStoreHelperClassName;
	}

	/**
	 * The name of the DataStoreHelper implementation class that extends the capabilities of the implementation class of the JDBC driver to perform functions that are specific to the data.
	 */
	public void setDataStoreHelperClassName(String value) {
		this.dataStoreHelperClassName = value;
	}

	/**
	 * The alias used for database authentication at run time.  This alias is only used when the application resource reference is using res-auth=Application.
	 */
	public String getComponentManagedAuthenticationAlias() {
		return this.componentManagedAuthenticationAlias;
	}

	/**
	 * The alias used for database authentication at run time.  This alias is only used when the application resource reference is using res-auth=Application.
	 */
	public void setComponentManagedAuthenticationAlias(String value) {
		this.componentManagedAuthenticationAlias = value;
	}

	/**
	 * Specifies if this Datasource is used for container-managed persistence of enterprise beans. The default value is true.
	 */
	public Boolean getContainerManagedPersistence() {
		return this.containerManagedPersistence;
	}

	/**
	 * Specifies if this Datasource is used for container-managed persistence of enterprise beans. The default value is true.
	 */
	public void setContainerManagedPersistence(Boolean value) {
		this.containerManagedPersistence = value;
	}

	/**
	 * The alias used database authentication during XA recovery processing. When this property is specified, the default value is the alias for application authentication.
	 */
	public String getXaRecoveryAuthAlias() {
		return this.xaRecoveryAuthAlias;
	}

	/**
	 * The alias used database authentication during XA recovery processing. When this property is specified, the default value is the alias for application authentication.
	 */
	public void setXaRecoveryAuthAlias(String value) {
		this.xaRecoveryAuthAlias = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("name", this.name);
		ret.put("jndiName", this.jndiName);
		if (this.description != null) {
			ret.put("description", this.description);
		}
		if (this.category != null) {
			ret.put("category", this.category);
		}
		ret.put("dataStoreHelperClassName", this.dataStoreHelperClassName);
		if (this.componentManagedAuthenticationAlias != null) {
			ret.put("componentManagedAuthenticationAlias", this.componentManagedAuthenticationAlias);
		}
		if (this.containerManagedPersistence != null) {
			ret.put("containerManagedPersistence", this.containerManagedPersistence);
		}
		if (this.xaRecoveryAuthAlias != null) {
			ret.put("xaRecoveryAuthAlias", this.xaRecoveryAuthAlias);
		}
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
	public OperationResults<Object> run(Scope scope, ConfigureResourceProperties configureResourceProperties) throws Exception {
		this.__steps = new ArrayList<Command>();
		if (configureResourceProperties != null)
			this.__steps.add(configureResourceProperties);
		return super.run(scope);
	}

	/**
	 * Configure the resource properties for the Datasource.  These are required properties that are specific to the type of Datasource being configured. This is a required step.
	 *   'name': The name of the resource property. This is a read-only parameter.
	 *   'type': The type of the resource property.  This is a read-only parameter.
	 *   'value': The value for the resource property.  This is a required parameter.
	 * The required parameters are found in the constructor.
	 */
	public static class ConfigureResourceProperties extends CommandStep {

		private String name;
		private String type;
		private String value;

		public ConfigureResourceProperties(String name, String type) {
			super("configureResourceProperties");
			this.name = name;
			this.type = type;
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			ret.put("name", this.name);
			ret.put("type", this.type);
			if (this.value != null) {
				ret.put("value", this.value);
			}
			return ret;
		}

		/**
		 * The name of the resource property. This is a read-only parameter.
		 */
		public String getName() {
			return this.name;
		}

		/**
		 * The name of the resource property. This is a read-only parameter.
		 */
		public void setName(String value) {
			this.name = value;
		}

		/**
		 * The type of the resource property.  This is a read-only parameter.
		 */
		public String getType() {
			return this.type;
		}

		/**
		 * The type of the resource property.  This is a read-only parameter.
		 */
		public void setType(String value) {
			this.type = value;
		}

		/**
		 * The value for the resource property.  This is a required parameter.
		 */
		public String getValue() {
			return this.value;
		}

		/**
		 * The value for the resource property.  This is a required parameter.
		 */
		public void setValue(String value) {
			this.value = value;
		}

	}
}
