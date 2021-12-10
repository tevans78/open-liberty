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

package com.ibm.websphere.simplicity.commands.wsnotification;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;
import java.util.ArrayList;
import com.ibm.websphere.simplicity.commands.CommandStep;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Create a JAX-WS Handler List
 *   'name': The name given to the JAX-WS Handler List
 *   'description': The description associated with the JAX-WS Handler List
 * The required parameters are found in the constructor.
 */
public class CreateJAXWSHandlerList extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private List<Command> __steps;
	private String name;
	private String description;

	public CreateJAXWSHandlerList(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String name) {
		super("createJAXWSHandlerList");
		this.__target = commandTarget;
		this.name = name;
	}

	/**
	 * The name given to the JAX-WS Handler List
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The name given to the JAX-WS Handler List
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * The description associated with the JAX-WS Handler List
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * The description associated with the JAX-WS Handler List
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("name", this.name);
		if (this.description != null) {
			ret.put("description", this.description);
		}
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
	public OperationResults<Object> run(Scope scope, Handlers handlers) throws Exception {
		this.__steps = new ArrayList<Command>();
		if (handlers != null)
			this.__steps.add(handlers);
		return super.run(scope);
	}

	/**
	 * The list of JAX-WS Handlers to associate with the JAX-WS Handler List
	 *   'handlerName': The name of the JAX-WS Handler
	 * The required parameters are found in the constructor.
	 */
	public static class Handlers extends CommandStep {

		private String handlerName;

		public Handlers(String handlerName) {
			super("handlers");
			this.handlerName = handlerName;
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			ret.put("handlerName", this.handlerName);
			return ret;
		}

		/**
		 * The name of the JAX-WS Handler
		 */
		public String getHandlerName() {
			return this.handlerName;
		}

		/**
		 * The name of the JAX-WS Handler
		 */
		public void setHandlerName(String value) {
			this.handlerName = value;
		}

	}
}
