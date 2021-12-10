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

package com.ibm.websphere.simplicity.commands.jdbc;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * List the JDBC providers that are contained in the specified scope.
 *   'scope': Scope for JDBC providers that are to be listed in the forms type or type=name, where type is one of Cell | Node | Server | Application | Cluster, and name is the Cell, Node, Server, Application, or Cluster instance; default: All.
 * The required parameters are found in the constructor.
 */
public class ListJDBCProviders extends Command {

	private String scope;

	public ListJDBCProviders() {
		super("listJDBCProviders");
	}

	/**
	 * Scope for JDBC providers that are to be listed in the forms type or type=name, where type is one of Cell | Node | Server | Application | Cluster, and name is the Cell, Node, Server, Application, or Cluster instance; default: All.
	 */
	public String getScope() {
		return this.scope;
	}

	/**
	 * Scope for JDBC providers that are to be listed in the forms type or type=name, where type is one of Cell | Node | Server | Application | Cluster, and name is the Cell, Node, Server, Application, or Cluster instance; default: All.
	 */
	public void setScope(String value) {
		this.scope = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.scope != null) {
			ret.put("scope", this.scope);
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
