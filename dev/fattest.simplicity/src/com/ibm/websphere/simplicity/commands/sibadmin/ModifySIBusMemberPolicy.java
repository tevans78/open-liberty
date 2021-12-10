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

package com.ibm.websphere.simplicity.commands.sibadmin;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Modify a cluster bus members messaging engine policy assistance settings.
 *   'bus': Name of bus to which the member belongs.
 *   'cluster': The name of the cluster that belongs to the bus.
 *   'enableAssistance': Select this option to enable messaging engine policy assistance. A policy name must also be supplied.
 *   'policyName': The name of the policy that the messaging engine policy assistance should apply. Messaging engine policy assistance must be enabled.
 * The required parameters are found in the constructor.
 */
public class ModifySIBusMemberPolicy extends Command {

	private String bus;
	private String cluster;
	private Boolean enableAssistance;
	private String policyName;

	public ModifySIBusMemberPolicy(String bus, String cluster) {
		super("modifySIBusMemberPolicy");
		this.bus = bus;
		this.cluster = cluster;
	}

	/**
	 * Name of bus to which the member belongs.
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * Name of bus to which the member belongs.
	 */
	public void setBus(String value) {
		this.bus = value;
	}

	/**
	 * The name of the cluster that belongs to the bus.
	 */
	public String getCluster() {
		return this.cluster;
	}

	/**
	 * The name of the cluster that belongs to the bus.
	 */
	public void setCluster(String value) {
		this.cluster = value;
	}

	/**
	 * Select this option to enable messaging engine policy assistance. A policy name must also be supplied.
	 */
	public Boolean getEnableAssistance() {
		return this.enableAssistance;
	}

	/**
	 * Select this option to enable messaging engine policy assistance. A policy name must also be supplied.
	 */
	public void setEnableAssistance(Boolean value) {
		this.enableAssistance = value;
	}

	/**
	 * The name of the policy that the messaging engine policy assistance should apply. Messaging engine policy assistance must be enabled.
	 */
	public String getPolicyName() {
		return this.policyName;
	}

	/**
	 * The name of the policy that the messaging engine policy assistance should apply. Messaging engine policy assistance must be enabled.
	 */
	public void setPolicyName(String value) {
		this.policyName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("bus", this.bus);
		ret.put("cluster", this.cluster);
		if (this.enableAssistance != null) {
			ret.put("enableAssistance", this.enableAssistance);
		}
		if (this.policyName != null) {
			ret.put("policyName", this.policyName);
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
