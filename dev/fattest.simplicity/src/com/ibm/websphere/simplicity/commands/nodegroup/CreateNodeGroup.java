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

package com.ibm.websphere.simplicity.commands.nodegroup;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * create a node group
 *   'shortName': the shortName (alias) of the node group
 *   'description': a description for the node group
 * The required parameters are found in the constructor.
 */
public class CreateNodeGroup extends Command {

	private String __target;
	private String shortName;
	private String description;

    /**
     * Constructor
     * @param nodeGroupName the name of the node group
     */
	public CreateNodeGroup(String nodeGroupName) {
		super("createNodeGroup");
		this.__target = nodeGroupName;
	}

	/**
	 * the shortName (alias) of the node group
	 */
	public String getShortName() {
		return this.shortName;
	}

	/**
	 * the shortName (alias) of the node group
	 */
	public void setShortName(String value) {
		this.shortName = value;
	}

	/**
	 * a description for the node group
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * a description for the node group
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(String value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.shortName != null) {
			ret.put("shortName", this.shortName);
		}
		if (this.description != null) {
			ret.put("description", this.description);
		}
		return ret;
	}

	public Object __getTarget() {
		return this.__target;
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
