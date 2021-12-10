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
 *   'nodeName': 
 *   'platform': 
 *   'version': 
 *   'sysplexName': 
 *   'nodeGroupName': 
 * The required parameters are found in the constructor.
 */
public class CanNodeJoinNodeGroup extends Command {

	private String __target;
	private String nodeName;
	private String platform;
	private String version;
	private String sysplexName;
	private String nodeGroupName;

	public CanNodeJoinNodeGroup(String commandTarget) {
		super("canNodeJoinNodeGroup");
		this.__target = commandTarget;
	}

	/**
	 * 
	 */
	public String getNodeName() {
		return this.nodeName;
	}

	/**
	 * 
	 */
	public void setNodeName(String value) {
		this.nodeName = value;
	}

	/**
	 * 
	 */
	public String getPlatform() {
		return this.platform;
	}

	/**
	 * 
	 */
	public void setPlatform(String value) {
		this.platform = value;
	}

	/**
	 * 
	 */
	public String getVersion() {
		return this.version;
	}

	/**
	 * 
	 */
	public void setVersion(String value) {
		this.version = value;
	}

	/**
	 * 
	 */
	public String getSysplexName() {
		return this.sysplexName;
	}

	/**
	 * 
	 */
	public void setSysplexName(String value) {
		this.sysplexName = value;
	}

	/**
	 * 
	 */
	public String getNodeGroupName() {
		return this.nodeGroupName;
	}

	/**
	 * 
	 */
	public void setNodeGroupName(String value) {
		this.nodeGroupName = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(String value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.nodeName != null) {
			ret.put("nodeName", this.nodeName);
		}
		if (this.platform != null) {
			ret.put("platform", this.platform);
		}
		if (this.version != null) {
			ret.put("version", this.version);
		}
		if (this.sysplexName != null) {
			ret.put("sysplexName", this.sysplexName);
		}
		if (this.nodeGroupName != null) {
			ret.put("nodeGroupName", this.nodeGroupName);
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
