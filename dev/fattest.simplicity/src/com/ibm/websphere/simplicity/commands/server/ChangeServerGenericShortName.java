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
 * A command that can be used to change the server generic short name.
 *   'serverName': The Server Name
 *   'nodeName': The Node Name
 *   'genericShortName': The server generic short name is applicable only on zOS platforms. This represents the generic short name of the server. All members of a cluster should share the same generic short name. Individual servers should have unique generic short name. This parameter is optional and when it is not specified a unique generic short name is automatically assigned. The value should be 8 chars or less and all upper case.
 * The required parameters are found in the constructor.
 */
public class ChangeServerGenericShortName extends Command {

	private String serverName;
	private String nodeName;
	private String genericShortName;

	public ChangeServerGenericShortName(String serverName, String nodeName, String genericShortName) {
		super("changeServerGenericShortName");
		this.serverName = serverName;
		this.nodeName = nodeName;
		this.genericShortName = genericShortName;
	}

	/**
	 * The Server Name
	 */
	public String getServerName() {
		return this.serverName;
	}

	/**
	 * The Server Name
	 */
	public void setServerName(String value) {
		this.serverName = value;
	}

	/**
	 * The Node Name
	 */
	public String getNodeName() {
		return this.nodeName;
	}

	/**
	 * The Node Name
	 */
	public void setNodeName(String value) {
		this.nodeName = value;
	}

	/**
	 * The server generic short name is applicable only on zOS platforms. This represents the generic short name of the server. All members of a cluster should share the same generic short name. Individual servers should have unique generic short name. This parameter is optional and when it is not specified a unique generic short name is automatically assigned. The value should be 8 chars or less and all upper case.
	 */
	public String getGenericShortName() {
		return this.genericShortName;
	}

	/**
	 * The server generic short name is applicable only on zOS platforms. This represents the generic short name of the server. All members of a cluster should share the same generic short name. Individual servers should have unique generic short name. This parameter is optional and when it is not specified a unique generic short name is automatically assigned. The value should be 8 chars or less and all upper case.
	 */
	public void setGenericShortName(String value) {
		this.genericShortName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("serverName", this.serverName);
		ret.put("nodeName", this.nodeName);
		ret.put("genericShortName", this.genericShortName);
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
