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

package com.ibm.websphere.simplicity.commands.jca;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Install a J2C resource adapter
 *   'nodeName': The name of the node in which to install the resource adapter to.
 *   'rarPath': The fully qualified RAR file name resided in the specified node.
 *   'rar.name': The name for the J2CResourceAdapter. If not specified, then the display name in the rar's deployment descriptor or the rar filename is used.
 *   'rar.desc': The description of the J2CResourceAdapter.
 *   'rar.archivePath': The name of the path where the file is to be extracted.  If this is not specified, then the archive will be extracted to $CONNECTOR_INSTALL_ROOT directory.
 *   'rar.classpath': The additional classpath.
 *   'rar.nativePath': The native path.
 *   'rar.threadPoolAlias': The alias of the thread pool.
 *   'rar.propertiesSet': The property set of the J2CResourceAdapter.
 *   'rar.DeleteSourceRar': 
 *   'rar.isolatedClassLoader': The boolean value of IsolatedClassLoader
 *   'rar.enableHASupport': The boolean value of enabled HA
 *   'rar.HACapability': The kind of HACapability
 * The required parameters are found in the constructor.
 */
public class InstallResourceAdapter extends Command {

	private String nodeName;
	private String rarPath;
	private String rar_name;
	private String rar_desc;
	private String rar_archivePath;
	private String rar_classpath;
	private String rar_nativePath;
	private String rar_threadPoolAlias;
	private java.util.Properties rar_propertiesSet;
	private Boolean rar_DeleteSourceRar = false;
	private Boolean rar_isolatedClassLoader = false;
	private Boolean rar_enableHASupport = false;
	private String rar_HACapability = "no";

	public InstallResourceAdapter(String nodeName, String rarPath) {
		super("installResourceAdapter");
		this.nodeName = nodeName;
		this.rarPath = rarPath;
	}

	/**
	 * The name of the node in which to install the resource adapter to.
	 */
	public String getNodeName() {
		return this.nodeName;
	}

	/**
	 * The name of the node in which to install the resource adapter to.
	 */
	public void setNodeName(String value) {
		this.nodeName = value;
	}

	/**
	 * The fully qualified RAR file name resided in the specified node.
	 */
	public String getRarPath() {
		return this.rarPath;
	}

	/**
	 * The fully qualified RAR file name resided in the specified node.
	 */
	public void setRarPath(String value) {
		this.rarPath = value;
	}

	/**
	 * The name for the J2CResourceAdapter. If not specified, then the display name in the rar's deployment descriptor or the rar filename is used.
	 */
	public String getRar_name() {
		return this.rar_name;
	}

	/**
	 * The name for the J2CResourceAdapter. If not specified, then the display name in the rar's deployment descriptor or the rar filename is used.
	 */
	public void setRar_name(String value) {
		this.rar_name = value;
	}

	/**
	 * The description of the J2CResourceAdapter.
	 */
	public String getRar_desc() {
		return this.rar_desc;
	}

	/**
	 * The description of the J2CResourceAdapter.
	 */
	public void setRar_desc(String value) {
		this.rar_desc = value;
	}

	/**
	 * The name of the path where the file is to be extracted.  If this is not specified, then the archive will be extracted to $CONNECTOR_INSTALL_ROOT directory.
	 */
	public String getRar_archivePath() {
		return this.rar_archivePath;
	}

	/**
	 * The name of the path where the file is to be extracted.  If this is not specified, then the archive will be extracted to $CONNECTOR_INSTALL_ROOT directory.
	 */
	public void setRar_archivePath(String value) {
		this.rar_archivePath = value;
	}

	/**
	 * The additional classpath.
	 */
	public String getRar_classpath() {
		return this.rar_classpath;
	}

	/**
	 * The additional classpath.
	 */
	public void setRar_classpath(String value) {
		this.rar_classpath = value;
	}

	/**
	 * The native path.
	 */
	public String getRar_nativePath() {
		return this.rar_nativePath;
	}

	/**
	 * The native path.
	 */
	public void setRar_nativePath(String value) {
		this.rar_nativePath = value;
	}

	/**
	 * The alias of the thread pool.
	 */
	public String getRar_threadPoolAlias() {
		return this.rar_threadPoolAlias;
	}

	/**
	 * The alias of the thread pool.
	 */
	public void setRar_threadPoolAlias(String value) {
		this.rar_threadPoolAlias = value;
	}

	/**
	 * The property set of the J2CResourceAdapter.
	 */
	public java.util.Properties getRar_propertiesSet() {
		return this.rar_propertiesSet;
	}

	/**
	 * The property set of the J2CResourceAdapter.
	 */
	public void setRar_propertiesSet(java.util.Properties value) {
		this.rar_propertiesSet = value;
	}

	/**
	 * 
	 */
	public Boolean getRar_DeleteSourceRar() {
		return this.rar_DeleteSourceRar;
	}

	/**
	 * 
	 */
	public void setRar_DeleteSourceRar(Boolean value) {
		this.rar_DeleteSourceRar = value;
	}

	/**
	 * The boolean value of IsolatedClassLoader
	 */
	public Boolean getRar_isolatedClassLoader() {
		return this.rar_isolatedClassLoader;
	}

	/**
	 * The boolean value of IsolatedClassLoader
	 */
	public void setRar_isolatedClassLoader(Boolean value) {
		this.rar_isolatedClassLoader = value;
	}

	/**
	 * The boolean value of enabled HA
	 */
	public Boolean getRar_enableHASupport() {
		return this.rar_enableHASupport;
	}

	/**
	 * The boolean value of enabled HA
	 */
	public void setRar_enableHASupport(Boolean value) {
		this.rar_enableHASupport = value;
	}

	/**
	 * The kind of HACapability
	 */
	public String getRar_HACapability() {
		return this.rar_HACapability;
	}

	/**
	 * The kind of HACapability
	 */
	public void setRar_HACapability(String value) {
		this.rar_HACapability = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("nodeName", this.nodeName);
		ret.put("rarPath", this.rarPath);
		if (this.rar_name != null) {
			ret.put("rar.name", this.rar_name);
		}
		if (this.rar_desc != null) {
			ret.put("rar.desc", this.rar_desc);
		}
		if (this.rar_archivePath != null) {
			ret.put("rar.archivePath", this.rar_archivePath);
		}
		if (this.rar_classpath != null) {
			ret.put("rar.classpath", this.rar_classpath);
		}
		if (this.rar_nativePath != null) {
			ret.put("rar.nativePath", this.rar_nativePath);
		}
		if (this.rar_threadPoolAlias != null) {
			ret.put("rar.threadPoolAlias", this.rar_threadPoolAlias);
		}
		if (this.rar_propertiesSet != null) {
			ret.put("rar.propertiesSet", this.rar_propertiesSet);
		}
		if (this.rar_DeleteSourceRar != null) {
			ret.put("rar.DeleteSourceRar", this.rar_DeleteSourceRar);
		}
		if (this.rar_isolatedClassLoader != null) {
			ret.put("rar.isolatedClassLoader", this.rar_isolatedClassLoader);
		}
		if (this.rar_enableHASupport != null) {
			ret.put("rar.enableHASupport", this.rar_enableHASupport);
		}
		if (this.rar_HACapability != null) {
			ret.put("rar.HACapability", this.rar_HACapability);
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
