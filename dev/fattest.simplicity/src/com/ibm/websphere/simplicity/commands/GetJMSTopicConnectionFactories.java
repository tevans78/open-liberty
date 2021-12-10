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

package com.ibm.websphere.simplicity.commands;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;
import java.util.ArrayList;
import com.ibm.websphere.simplicity.commands.CommandStep;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Get the available JMS connection factories
 *   'allscopes': The type of object to be used with this provider
 * The required parameters are found in the constructor.
 */
public class GetJMSTopicConnectionFactories extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private List<Command> __steps;
	private java.lang.Boolean allscopes;

	public GetJMSTopicConnectionFactories(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, java.lang.Boolean allscopes) {
		super("getJMSTopicConnectionFactories");
		this.__target = commandTarget;
		this.allscopes = allscopes;
	}

	/**
	 * The type of object to be used with this provider
	 */
	public java.lang.Boolean getAllscopes() {
		return this.allscopes;
	}

	/**
	 * The type of object to be used with this provider
	 */
	public void setAllscopes(java.lang.Boolean value) {
		this.allscopes = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("allscopes", this.allscopes);
		return ret;
	}

	public Object __getTarget() {
		return this.__target;
	}

	public List<Command> __getSteps() {
		return this.__steps;
	}

	/**
	 * Executes the command against the specified scope.
	 * Steps are required by this command, and they appear after the scope parameter.
	 * Classes for these steps are statically available through this admin command class.
	 */
	public OperationResults<Object> run(Scope scope, GetSIBJMSTopicConnectionFactories getSIBJMSTopicConnectionFactories) throws Exception {
		this.__steps = new ArrayList<Command>();
		if (getSIBJMSTopicConnectionFactories != null)
			this.__steps.add(getSIBJMSTopicConnectionFactories);
		return super.run(scope);
	}

	/**
	 * 
	 * The required parameters are found in the constructor.
	 */
	public static class GetSIBJMSTopicConnectionFactories extends CommandStep {

		public GetSIBJMSTopicConnectionFactories() {
			super("getSIBJMSTopicConnectionFactories");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			return ret;
		}

	}
}
