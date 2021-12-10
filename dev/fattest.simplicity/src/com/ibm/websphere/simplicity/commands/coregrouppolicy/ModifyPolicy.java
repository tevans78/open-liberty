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

package com.ibm.websphere.simplicity.commands.coregrouppolicy;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Modify a policy that matches the provided policy name.
 *   'coreGroupName': The name of the core group which this policy applies to.
 *   'newPolicyName': Policy name
 *   'policyName': The name of the policy that task will create, modify, or delete.
 *   'isAlive': Specifies in seconds how frequently the high availability manager checks the health of the active group members governed by this policy.
 *   'matchCriteria': Specifies name and value pairs that determine which high availability groups are governed by this policy.
 *   'description': A description for this policy.
 *   'customProperties': Specifies additional custom properties for this policy.
 *   'quorum': Specifies whether or not quorum checking is enabled for a high availability group governed by this policy.
 *   'failBack': Specifies whether active group members are moved to the most preferred server at any given time.
 *   'preferredOnly': Specifies whether group members are activated only on servers from the list of preferred servers.
 *   'serversList': Specifies a list of core group servers for this policy.
 *   'numActive': Specifies the number of group members to activate at startup.
 * The required parameters are found in the constructor.
 */
public class ModifyPolicy extends Command {

	private String coreGroupName;
	private String newPolicyName;
	private String policyName;
	private Integer isAlive;
	private java.util.Properties matchCriteria;
	private String description;
	private java.util.Properties customProperties;
	private Boolean quorum;
	private Boolean failBack;
	private Boolean preferredOnly;
	private java.lang.String[] serversList;
	private Integer numActive;

	public ModifyPolicy(String coreGroupName, String policyName) {
		super("modifyPolicy");
		this.coreGroupName = coreGroupName;
		this.policyName = policyName;
	}

	/**
	 * The name of the core group which this policy applies to.
	 */
	public String getCoreGroupName() {
		return this.coreGroupName;
	}

	/**
	 * The name of the core group which this policy applies to.
	 */
	public void setCoreGroupName(String value) {
		this.coreGroupName = value;
	}

	/**
	 * Policy name
	 */
	public String getNewPolicyName() {
		return this.newPolicyName;
	}

	/**
	 * Policy name
	 */
	public void setNewPolicyName(String value) {
		this.newPolicyName = value;
	}

	/**
	 * The name of the policy that task will create, modify, or delete.
	 */
	public String getPolicyName() {
		return this.policyName;
	}

	/**
	 * The name of the policy that task will create, modify, or delete.
	 */
	public void setPolicyName(String value) {
		this.policyName = value;
	}

	/**
	 * Specifies in seconds how frequently the high availability manager checks the health of the active group members governed by this policy.
	 */
	public Integer getIsAlive() {
		return this.isAlive;
	}

	/**
	 * Specifies in seconds how frequently the high availability manager checks the health of the active group members governed by this policy.
	 */
	public void setIsAlive(Integer value) {
		this.isAlive = value;
	}

	/**
	 * Specifies name and value pairs that determine which high availability groups are governed by this policy.
	 */
	public java.util.Properties getMatchCriteria() {
		return this.matchCriteria;
	}

	/**
	 * Specifies name and value pairs that determine which high availability groups are governed by this policy.
	 */
	public void setMatchCriteria(java.util.Properties value) {
		this.matchCriteria = value;
	}

	/**
	 * A description for this policy.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * A description for this policy.
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Specifies additional custom properties for this policy.
	 */
	public java.util.Properties getCustomProperties() {
		return this.customProperties;
	}

	/**
	 * Specifies additional custom properties for this policy.
	 */
	public void setCustomProperties(java.util.Properties value) {
		this.customProperties = value;
	}

	/**
	 * Specifies whether or not quorum checking is enabled for a high availability group governed by this policy.
	 */
	public Boolean getQuorum() {
		return this.quorum;
	}

	/**
	 * Specifies whether or not quorum checking is enabled for a high availability group governed by this policy.
	 */
	public void setQuorum(Boolean value) {
		this.quorum = value;
	}

	/**
	 * Specifies whether active group members are moved to the most preferred server at any given time.
	 */
	public Boolean getFailBack() {
		return this.failBack;
	}

	/**
	 * Specifies whether active group members are moved to the most preferred server at any given time.
	 */
	public void setFailBack(Boolean value) {
		this.failBack = value;
	}

	/**
	 * Specifies whether group members are activated only on servers from the list of preferred servers.
	 */
	public Boolean getPreferredOnly() {
		return this.preferredOnly;
	}

	/**
	 * Specifies whether group members are activated only on servers from the list of preferred servers.
	 */
	public void setPreferredOnly(Boolean value) {
		this.preferredOnly = value;
	}

	/**
	 * Specifies a list of core group servers for this policy.
	 */
	public java.lang.String[] getServersList() {
		return this.serversList;
	}

	/**
	 * Specifies a list of core group servers for this policy.
	 */
	public void setServersList(java.lang.String[] value) {
		this.serversList = value;
	}

	/**
	 * Specifies the number of group members to activate at startup.
	 */
	public Integer getNumActive() {
		return this.numActive;
	}

	/**
	 * Specifies the number of group members to activate at startup.
	 */
	public void setNumActive(Integer value) {
		this.numActive = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("coreGroupName", this.coreGroupName);
		if (this.newPolicyName != null) {
			ret.put("newPolicyName", this.newPolicyName);
		}
		ret.put("policyName", this.policyName);
		if (this.isAlive != null) {
			ret.put("isAlive", this.isAlive);
		}
		if (this.matchCriteria != null) {
			ret.put("matchCriteria", this.matchCriteria);
		}
		if (this.description != null) {
			ret.put("description", this.description);
		}
		if (this.customProperties != null) {
			ret.put("customProperties", this.customProperties);
		}
		if (this.quorum != null) {
			ret.put("quorum", this.quorum);
		}
		if (this.failBack != null) {
			ret.put("failBack", this.failBack);
		}
		if (this.preferredOnly != null) {
			ret.put("preferredOnly", this.preferredOnly);
		}
		if (this.serversList != null) {
			ret.put("serversList", this.serversList);
		}
		if (this.numActive != null) {
			ret.put("numActive", this.numActive);
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
