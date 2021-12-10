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

package com.ibm.websphere.simplicity.commands.coregroup;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Move a server from one core group to another.
 *   'source': The name of the core group the server is to be moved from
 *   'target': The name of the core group the server is to be moved to
 *   'nodeName': The name of the node hosting the server
 *   'serverName': The name of the server
 * The required parameters are found in the constructor.
 */
public class MoveServerToCoreGroup extends Command {

	private String source;
	private String target;
	private String nodeName;
	private String serverName;

	public MoveServerToCoreGroup(String source, String target, String nodeName, String serverName) {
		super("moveServerToCoreGroup");
		this.source = source;
		this.target = target;
		this.nodeName = nodeName;
		this.serverName = serverName;
	}

	/**
	 * The name of the core group the server is to be moved from
	 */
	public String getSource() {
		return this.source;
	}

	/**
	 * The name of the core group the server is to be moved from
	 */
	public void setSource(String value) {
		this.source = value;
	}

	/**
	 * The name of the core group the server is to be moved to
	 */
	public String getTarget() {
		return this.target;
	}

	/**
	 * The name of the core group the server is to be moved to
	 */
	public void setTarget(String value) {
		this.target = value;
	}

	/**
	 * The name of the node hosting the server
	 */
	public String getNodeName() {
		return this.nodeName;
	}

	/**
	 * The name of the node hosting the server
	 */
	public void setNodeName(String value) {
		this.nodeName = value;
	}

	/**
	 * The name of the server
	 */
	public String getServerName() {
		return this.serverName;
	}

	/**
	 * The name of the server
	 */
	public void setServerName(String value) {
		this.serverName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("source", this.source);
		ret.put("target", this.target);
		ret.put("nodeName", this.nodeName);
		ret.put("serverName", this.serverName);
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
