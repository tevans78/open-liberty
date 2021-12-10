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
 * Delete a named WebSphere MQ server. Also, delete its membership of any buses, and cleanup all associated configuration.
 *   'name': The name of the WebSphere MQ server. This is for administrative purposes only and can be decided by the administrator. The name is only meaningful inside WebSphere Application server administration, and must be unique at cell level.
 * The required parameters are found in the constructor.
 */
public class DeleteSIBWMQServer extends Command {

	private String name;

	public DeleteSIBWMQServer(String name) {
		super("deleteSIBWMQServer");
		this.name = name;
	}

	/**
	 * The name of the WebSphere MQ server. This is for administrative purposes only and can be decided by the administrator. The name is only meaningful inside WebSphere Application server administration, and must be unique at cell level.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The name of the WebSphere MQ server. This is for administrative purposes only and can be decided by the administrator. The name is only meaningful inside WebSphere Application server administration, and must be unique at cell level.
	 */
	public void setName(String value) {
		this.name = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("name", this.name);
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
