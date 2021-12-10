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
 * Lists the available Server Templates
 *   'version': The Product Version
 *   'serverType': The ServerType ie: (APPLICATION_SERVER)
 *   'name': The Template Name
 *   'queryExp': The Platform ie: (windows - linux - z/os)
 *   'nodeName': List only templates that macthes the node specified
 * The required parameters are found in the constructor.
 */
public class ListServerTemplates extends Command {

	private String version;
	private String serverType;
	private String name;
	private java.lang.String[] queryExp;
	private String nodeName;

	public ListServerTemplates() {
		super("listServerTemplates");
	}

	/**
	 * The Product Version
	 */
	public String getVersion() {
		return this.version;
	}

	/**
	 * The Product Version
	 */
	public void setVersion(String value) {
		this.version = value;
	}

	/**
	 * The ServerType ie: (APPLICATION_SERVER)
	 */
	public String getServerType() {
		return this.serverType;
	}

	/**
	 * The ServerType ie: (APPLICATION_SERVER)
	 */
	public void setServerType(String value) {
		this.serverType = value;
	}

	/**
	 * The Template Name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The Template Name
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * The Platform ie: (windows - linux - z/os)
	 */
	public java.lang.String[] getQueryExp() {
		return this.queryExp;
	}

	/**
	 * The Platform ie: (windows - linux - z/os)
	 */
	public void setQueryExp(java.lang.String[] value) {
		this.queryExp = value;
	}

	/**
	 * List only templates that macthes the node specified
	 */
	public String getNodeName() {
		return this.nodeName;
	}

	/**
	 * List only templates that macthes the node specified
	 */
	public void setNodeName(String value) {
		this.nodeName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.version != null) {
			ret.put("version", this.version);
		}
		if (this.serverType != null) {
			ret.put("serverType", this.serverType);
		}
		if (this.name != null) {
			ret.put("name", this.name);
		}
		if (this.queryExp != null) {
			ret.put("queryExp", this.queryExp);
		}
		if (this.nodeName != null) {
			ret.put("nodeName", this.nodeName);
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
