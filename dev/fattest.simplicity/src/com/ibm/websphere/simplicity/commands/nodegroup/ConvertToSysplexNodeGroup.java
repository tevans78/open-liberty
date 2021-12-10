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
 * 
 *   'shortName': 
 *   'sysplexProps': 
 * The required parameters are found in the constructor.
 */
public class ConvertToSysplexNodeGroup extends Command {

	private String __target;
	private String shortName;
	private java.util.Properties sysplexProps;

	public ConvertToSysplexNodeGroup(String commandTarget, java.util.Properties sysplexProps) {
		super("convertToSysplexNodeGroup");
		this.__target = commandTarget;
		this.sysplexProps = sysplexProps;
	}

	/**
	 * 
	 */
	public String getShortName() {
		return this.shortName;
	}

	/**
	 * 
	 */
	public void setShortName(String value) {
		this.shortName = value;
	}

	/**
	 * 
	 */
	public java.util.Properties getSysplexProps() {
		return this.sysplexProps;
	}

	/**
	 * 
	 */
	public void setSysplexProps(java.util.Properties value) {
		this.sysplexProps = value;
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
		ret.put("sysplexProps", this.sysplexProps);
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
