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
 * Set the trace specification for the server. If the server is running new trace specification takes effect immediately. This command also saves the trace specification in configuration.
 *   'serverName': The name of the Server whose process definition is modified. If there is only one server in the entire configuration, then this parameter is optional.
 *   'nodeName': The name of the node. This is only needed for the server scopes that do not have a unique name across nodes.
 *   'traceSpecification': Trace Specification
 *   'persist': Save the trace specification to the configuration.
 * The required parameters are found in the constructor.
 */
public class SetTraceSpecification extends Command {

	private String serverName;
	private String nodeName;
	private String traceSpecification;
	private Boolean persist = false;

	public SetTraceSpecification(String traceSpecification) {
		super("setTraceSpecification");
		this.traceSpecification = traceSpecification;
	}

	/**
	 * The name of the Server whose process definition is modified. If there is only one server in the entire configuration, then this parameter is optional.
	 */
	public String getServerName() {
		return this.serverName;
	}

	/**
	 * The name of the Server whose process definition is modified. If there is only one server in the entire configuration, then this parameter is optional.
	 */
	public void setServerName(String value) {
		this.serverName = value;
	}

	/**
	 * The name of the node. This is only needed for the server scopes that do not have a unique name across nodes.
	 */
	public String getNodeName() {
		return this.nodeName;
	}

	/**
	 * The name of the node. This is only needed for the server scopes that do not have a unique name across nodes.
	 */
	public void setNodeName(String value) {
		this.nodeName = value;
	}

	/**
	 * Trace Specification
	 */
	public String getTraceSpecification() {
		return this.traceSpecification;
	}

	/**
	 * Trace Specification
	 */
	public void setTraceSpecification(String value) {
		this.traceSpecification = value;
	}

	/**
	 * Save the trace specification to the configuration.
	 */
	public Boolean getPersist() {
		return this.persist;
	}

	/**
	 * Save the trace specification to the configuration.
	 */
	public void setPersist(Boolean value) {
		this.persist = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.serverName != null) {
			ret.put("serverName", this.serverName);
		}
		if (this.nodeName != null) {
			ret.put("nodeName", this.nodeName);
		}
		ret.put("traceSpecification", this.traceSpecification);
		if (this.persist != null) {
			ret.put("persist", this.persist);
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
