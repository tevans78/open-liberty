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

package com.ibm.websphere.simplicity.commands.rarupdate;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;
import java.util.ArrayList;
import com.ibm.websphere.simplicity.commands.CommandStep;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Compare a list of multiple resource adapters to see if they are all able to be updated with the same RAR file.
 * The required parameters are found in the constructor.
 */
public class CompareMultipleResourceAdapters extends Command {

	private List<Command> __steps;
	public CompareMultipleResourceAdapters() {
		super("compareMultipleResourceAdapters");
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		return ret;
	}

	public Object __getTarget() {
		return null;
	}

	public List<Command> __getSteps() {
		return this.__steps;
	}

	/**
	 * Executes the command against the specified scope.
	 * Steps are required by this command, and they appear after the scope parameter.
	 * Classes for these steps are statically available through this admin command class.
	 */
	public OperationResults<Object> run(Scope scope, GetResourceAdapterList getResourceAdapterList) throws Exception {
		this.__steps = new ArrayList<Command>();
		if (getResourceAdapterList != null)
			this.__steps.add(getResourceAdapterList);
		return super.run(scope);
	}

	/**
	 * Enter a list of resource adapters to be compared against each other for compatibility.
	 *   'name': Enter the ObjectName of the Resource Adapter to compare.
	 * The required parameters are found in the constructor.
	 */
	public static class GetResourceAdapterList extends CommandStep {

		private com.ibm.websphere.simplicity.ConfigIdentifier name;

		public GetResourceAdapterList(com.ibm.websphere.simplicity.ConfigIdentifier name) {
			super("GetResourceAdapterList");
			this.name = name;
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			ret.put("name", this.name);
			return ret;
		}

		/**
		 * Enter the ObjectName of the Resource Adapter to compare.
		 */
		public com.ibm.websphere.simplicity.ConfigIdentifier getName() {
			return this.name;
		}

		/**
		 * Enter the ObjectName of the Resource Adapter to compare.
		 */
		public void setName(com.ibm.websphere.simplicity.ConfigIdentifier value) {
			this.name = value;
		}

	}
}
