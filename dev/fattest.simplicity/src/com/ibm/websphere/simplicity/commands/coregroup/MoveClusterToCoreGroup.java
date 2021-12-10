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
 * Move all servers in a cluster from one core group to another.
 *   'source': The name of the core group the cluster is to be moved from
 *   'target': The name of the core group the cluster is to be moved to
 *   'clusterName': The name of the cluster containing the servers to be moved
 *   'checkConfig': If checking is disabled, do not check to ensure that all cluster members are currently in the same core group. Checking should only be disabled on the advice of IBM support to recover an inconsistent configuration.
 * The required parameters are found in the constructor.
 */
public class MoveClusterToCoreGroup extends Command {

	private String source;
	private String target;
	private String clusterName;
	private Boolean checkConfig = true;

	public MoveClusterToCoreGroup(String source, String target, String clusterName) {
		super("moveClusterToCoreGroup");
		this.source = source;
		this.target = target;
		this.clusterName = clusterName;
	}

	/**
	 * The name of the core group the cluster is to be moved from
	 */
	public String getSource() {
		return this.source;
	}

	/**
	 * The name of the core group the cluster is to be moved from
	 */
	public void setSource(String value) {
		this.source = value;
	}

	/**
	 * The name of the core group the cluster is to be moved to
	 */
	public String getTarget() {
		return this.target;
	}

	/**
	 * The name of the core group the cluster is to be moved to
	 */
	public void setTarget(String value) {
		this.target = value;
	}

	/**
	 * The name of the cluster containing the servers to be moved
	 */
	public String getClusterName() {
		return this.clusterName;
	}

	/**
	 * The name of the cluster containing the servers to be moved
	 */
	public void setClusterName(String value) {
		this.clusterName = value;
	}

	/**
	 * If checking is disabled, do not check to ensure that all cluster members are currently in the same core group. Checking should only be disabled on the advice of IBM support to recover an inconsistent configuration.
	 */
	public Boolean getCheckConfig() {
		return this.checkConfig;
	}

	/**
	 * If checking is disabled, do not check to ensure that all cluster members are currently in the same core group. Checking should only be disabled on the advice of IBM support to recover an inconsistent configuration.
	 */
	public void setCheckConfig(Boolean value) {
		this.checkConfig = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("source", this.source);
		ret.put("target", this.target);
		ret.put("clusterName", this.clusterName);
		if (this.checkConfig != null) {
			ret.put("checkConfig", this.checkConfig);
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
