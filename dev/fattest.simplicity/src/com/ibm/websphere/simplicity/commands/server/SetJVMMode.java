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

package com.ibm.websphere.simplicity.commands.server;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Set the JVM mode to either 64 or 31 bit. If 64-bit is set, the JAVA_HOME will be set to $WAS_HOME/java64. The default jvm mode is 31 bit.
 *   'serverName': 
 *   'nodeName': 
 *   'mode': 
 * The required parameters are found in the constructor.
 */
public class SetJVMMode extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String serverName;
	private String nodeName;
	private String mode;

	public SetJVMMode(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String mode) {
		super("setJVMMode");
		this.__target = commandTarget;
		this.mode = mode;
	}

	/**
	 * 
	 */
	public String getServerName() {
		return this.serverName;
	}

	/**
	 * 
	 */
	public void setServerName(String value) {
		this.serverName = value;
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
	public String getMode() {
		return this.mode;
	}

	/**
	 * 
	 */
	public void setMode(String value) {
		this.mode = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.serverName != null) {
			ret.put("serverName", this.serverName);
		}
		if (this.nodeName != null) {
			ret.put("nodeName", this.nodeName);
		}
		ret.put("mode", this.mode);
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
