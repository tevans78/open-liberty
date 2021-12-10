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

package com.ibm.websphere.simplicity.commands.wmqadmin;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Lists the WMQ Connection Factories defined at the scope provided to the command.
 *   'type': The type of WMQ Connection Factory to list. Valid values are "CF", "QCF", and "TCF".
 * The required parameters are found in the constructor.
 */
public class ListWMQConnectionFactories extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String type;

	public ListWMQConnectionFactories(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget) {
		super("listWMQConnectionFactories");
		this.__target = commandTarget;
	}

	/**
	 * The type of WMQ Connection Factory to list. Valid values are "CF", "QCF", and "TCF".
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * The type of WMQ Connection Factory to list. Valid values are "CF", "QCF", and "TCF".
	 */
	public void setType(String value) {
		this.type = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.type != null) {
			ret.put("type", this.type);
		}
		return ret;
	}

	public Object __getTarget() {
		return this.__target;
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
