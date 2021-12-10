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

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Create a new JDBC provider that is used to connect with a relational database for data access.
 *   'scope': The scope for the new JDBC provider in the form type=name, where type is one of Cell | Node | Server | Application | Cluster, and name is the Cell, Node, Server, Application, or Cluster instance.
 *   'databaseType': The type of database used by this JDBC provider.
 *   'providerType': The JDBC provider type used by this JDBC provider.
 *   'implementationType': The implementation type for this JDBC provider. Use 'Connection pool data source' if your application runs in a single phase or local transaction.  Use 'XA data source' to run in a global transaction.
 *   'name': The name of the JDBC provider.
 *   'description': The description for the JDBC provider.
 *   'implementationClassName': The name of the Java class for the implementation of the JDBC driver.
 *   'classpath': Specifies a list of paths or JAR file names that together form the location for the resource provider classes. The classpath might contain multiple elements if they are separated with a colon, semicolon, or comma.
 *   'nativePath': Specifies a list of paths that forms the location for the resource provider native libraries.  The native path might contain multiple elements if they are separated with a colon, semicolon, or comma.
 *   'isolated': Load this JDBC Provider using a unique shared library classloader.
 * The required parameters are found in the constructor.
 */
public class CreateJDBCProvider extends Command {

	private String scope;
	private String databaseType;
	private String providerType;
	private String implementationType;
	private String name;
	private String description;
	private String implementationClassName;
	private java.lang.String[] classpath;
	private java.lang.String[] nativePath;
	private Boolean isolated = false;

	public CreateJDBCProvider(String scope, String databaseType, String providerType, String implementationType) {
		super("createJDBCProvider");
		this.scope = scope;
		this.databaseType = databaseType;
		this.providerType = providerType;
		this.implementationType = implementationType;
	}

	/**
	 * The scope for the new JDBC provider in the form type=name, where type is one of Cell | Node | Server | Application | Cluster, and name is the Cell, Node, Server, Application, or Cluster instance.
	 */
	public String getScope() {
		return this.scope;
	}

	/**
	 * The scope for the new JDBC provider in the form type=name, where type is one of Cell | Node | Server | Application | Cluster, and name is the Cell, Node, Server, Application, or Cluster instance.
	 */
	public void setScope(String value) {
		this.scope = value;
	}

	/**
	 * The type of database used by this JDBC provider.
	 */
	public String getDatabaseType() {
		return this.databaseType;
	}

	/**
	 * The type of database used by this JDBC provider.
	 */
	public void setDatabaseType(String value) {
		this.databaseType = value;
	}

	/**
	 * The JDBC provider type used by this JDBC provider.
	 */
	public String getProviderType() {
		return this.providerType;
	}

	/**
	 * The JDBC provider type used by this JDBC provider.
	 */
	public void setProviderType(String value) {
		this.providerType = value;
	}

	/**
	 * The implementation type for this JDBC provider. Use 'Connection pool data source' if your application runs in a single phase or local transaction.  Use 'XA data source' to run in a global transaction.
	 */
	public String getImplementationType() {
		return this.implementationType;
	}

	/**
	 * The implementation type for this JDBC provider. Use 'Connection pool data source' if your application runs in a single phase or local transaction.  Use 'XA data source' to run in a global transaction.
	 */
	public void setImplementationType(String value) {
		this.implementationType = value;
	}

	/**
	 * The name of the JDBC provider.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The name of the JDBC provider.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * The description for the JDBC provider.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * The description for the JDBC provider.
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * The name of the Java class for the implementation of the JDBC driver.
	 */
	public String getImplementationClassName() {
		return this.implementationClassName;
	}

	/**
	 * The name of the Java class for the implementation of the JDBC driver.
	 */
	public void setImplementationClassName(String value) {
		this.implementationClassName = value;
	}

	/**
	 * Specifies a list of paths or JAR file names that together form the location for the resource provider classes. The classpath might contain multiple elements if they are separated with a colon, semicolon, or comma.
	 */
	public java.lang.String[] getClasspath() {
		return this.classpath;
	}

	/**
	 * Specifies a list of paths or JAR file names that together form the location for the resource provider classes. The classpath might contain multiple elements if they are separated with a colon, semicolon, or comma.
	 */
	public void setClasspath(java.lang.String[] value) {
		this.classpath = value;
	}

	/**
	 * Specifies a list of paths that forms the location for the resource provider native libraries.  The native path might contain multiple elements if they are separated with a colon, semicolon, or comma.
	 */
	public java.lang.String[] getNativePath() {
		return this.nativePath;
	}

	/**
	 * Specifies a list of paths that forms the location for the resource provider native libraries.  The native path might contain multiple elements if they are separated with a colon, semicolon, or comma.
	 */
	public void setNativePath(java.lang.String[] value) {
		this.nativePath = value;
	}

	/**
	 * Load this JDBC Provider using a unique shared library classloader.
	 */
	public Boolean getIsolated() {
		return this.isolated;
	}

	/**
	 * Load this JDBC Provider using a unique shared library classloader.
	 */
	public void setIsolated(Boolean value) {
		this.isolated = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("scope", this.scope);
		ret.put("databaseType", this.databaseType);
		ret.put("providerType", this.providerType);
		ret.put("implementationType", this.implementationType);
		if (this.name != null) {
			ret.put("name", this.name);
		}
		if (this.description != null) {
			ret.put("description", this.description);
		}
		if (this.implementationClassName != null) {
			ret.put("implementationClassName", this.implementationClassName);
		}
		if (this.classpath != null) {
			ret.put("classpath", this.classpath);
		}
		if (this.nativePath != null) {
			ret.put("nativePath", this.nativePath);
		}
		if (this.isolated != null) {
			ret.put("isolated", this.isolated);
		}
		return ret;
	}

	public Object __getTarget() {
		return null;
	}

	public List<Command> __getSteps() {
		return null;
	}

	/**
	 * Executes the command against the specified scope.
	 */
	public OperationResults<Object> run(Scope scope) throws Exception {
		return super.run(scope);
	}

}
