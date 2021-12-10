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
 * Set Server Instance configuration. This command only applies to the z/OS platform.
 *   'serverName': The name of the Server whose process definition is modified. If there is only one server in the entire configuration, then this parameter is optional.
 *   'nodeName': The name of the node. This is only needed for the server scopes that do not have a unique name across nodes.
 *   'enableMultipleServerInstances': Enable Multiple  Server Instances.  This parameter only applies to the z/OS platform.
 *   'minimumNumOfInstances': Minimum Number Of Instances.  This parameter only applies to the z/OS platform.
 *   'maximumNumberOfInstances': Maximum Number Of Instances.   This parameter only applies to the z/OS platform.
 * The required parameters are found in the constructor.
 */
public class SetServerInstance extends Command {

	private String serverName;
	private String nodeName;
	private Boolean enableMultipleServerInstances;
	private Integer minimumNumOfInstances;
	private Integer maximumNumberOfInstances;

	public SetServerInstance() {
		super("setServerInstance");
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
	 * Enable Multiple  Server Instances.  This parameter only applies to the z/OS platform.
	 */
	public Boolean getEnableMultipleServerInstances() {
		return this.enableMultipleServerInstances;
	}

	/**
	 * Enable Multiple  Server Instances.  This parameter only applies to the z/OS platform.
	 */
	public void setEnableMultipleServerInstances(Boolean value) {
		this.enableMultipleServerInstances = value;
	}

	/**
	 * Minimum Number Of Instances.  This parameter only applies to the z/OS platform.
	 */
	public Integer getMinimumNumOfInstances() {
		return this.minimumNumOfInstances;
	}

	/**
	 * Minimum Number Of Instances.  This parameter only applies to the z/OS platform.
	 */
	public void setMinimumNumOfInstances(Integer value) {
		this.minimumNumOfInstances = value;
	}

	/**
	 * Maximum Number Of Instances.   This parameter only applies to the z/OS platform.
	 */
	public Integer getMaximumNumberOfInstances() {
		return this.maximumNumberOfInstances;
	}

	/**
	 * Maximum Number Of Instances.   This parameter only applies to the z/OS platform.
	 */
	public void setMaximumNumberOfInstances(Integer value) {
		this.maximumNumberOfInstances = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.serverName != null) {
			ret.put("serverName", this.serverName);
		}
		if (this.nodeName != null) {
			ret.put("nodeName", this.nodeName);
		}
		if (this.enableMultipleServerInstances != null) {
			ret.put("enableMultipleServerInstances", this.enableMultipleServerInstances);
		}
		if (this.minimumNumOfInstances != null) {
			ret.put("minimumNumOfInstances", this.minimumNumOfInstances);
		}
		if (this.maximumNumberOfInstances != null) {
			ret.put("maximumNumberOfInstances", this.maximumNumberOfInstances);
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
