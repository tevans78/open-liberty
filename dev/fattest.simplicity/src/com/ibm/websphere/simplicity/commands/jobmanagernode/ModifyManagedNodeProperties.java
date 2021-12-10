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

package com.ibm.websphere.simplicity.commands.jobmanagernode;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Modify properties associated with a specific managed node.
 *   'managedNodeName': Name of the managed node.
 *   'managedNodeProps': Retrieve properties associated with managed resources.
 *   'replace': Flag to either replace the existing properties or not. The default is false.
 * The required parameters are found in the constructor.
 */
public class ModifyManagedNodeProperties extends Command {

	private java.lang.String managedNodeName;
	private java.util.Properties managedNodeProps;
	private Boolean replace = false;

	public ModifyManagedNodeProperties(java.lang.String managedNodeName, java.util.Properties managedNodeProps) {
		super("modifyManagedNodeProperties");
		this.managedNodeName = managedNodeName;
		this.managedNodeProps = managedNodeProps;
	}

	/**
	 * Name of the managed node.
	 */
	public java.lang.String getManagedNodeName() {
		return this.managedNodeName;
	}

	/**
	 * Name of the managed node.
	 */
	public void setManagedNodeName(java.lang.String value) {
		this.managedNodeName = value;
	}

	/**
	 * Retrieve properties associated with managed resources.
	 */
	public java.util.Properties getManagedNodeProps() {
		return this.managedNodeProps;
	}

	/**
	 * Retrieve properties associated with managed resources.
	 */
	public void setManagedNodeProps(java.util.Properties value) {
		this.managedNodeProps = value;
	}

	/**
	 * Flag to either replace the existing properties or not. The default is false.
	 */
	public Boolean getReplace() {
		return this.replace;
	}

	/**
	 * Flag to either replace the existing properties or not. The default is false.
	 */
	public void setReplace(Boolean value) {
		this.replace = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("managedNodeName", this.managedNodeName);
		ret.put("managedNodeProps", this.managedNodeProps);
		if (this.replace != null) {
			ret.put("replace", this.replace);
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
