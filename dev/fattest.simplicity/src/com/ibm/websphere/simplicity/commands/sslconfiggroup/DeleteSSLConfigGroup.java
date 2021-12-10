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

package com.ibm.websphere.simplicity.commands.sslconfiggroup;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Delete a SSLConfig group.
 *   'direction': Direction for this SSL configuration group, inbound or outbound.
 *   'name': Specifies a unique name to identify an SSL Configuration group.
 *   'scopeName': Specifies the management scope.
 * The required parameters are found in the constructor.
 */
public class DeleteSSLConfigGroup extends Command {

	private String direction;
	private String name;
	private String scopeName;

	public DeleteSSLConfigGroup(String direction, String name) {
		super("deleteSSLConfigGroup");
		this.direction = direction;
		this.name = name;
	}

	/**
	 * Direction for this SSL configuration group, inbound or outbound.
	 */
	public String getDirection() {
		return this.direction;
	}

	/**
	 * Direction for this SSL configuration group, inbound or outbound.
	 */
	public void setDirection(String value) {
		this.direction = value;
	}

	/**
	 * Specifies a unique name to identify an SSL Configuration group.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Specifies a unique name to identify an SSL Configuration group.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Specifies the management scope.
	 */
	public String getScopeName() {
		return this.scopeName;
	}

	/**
	 * Specifies the management scope.
	 */
	public void setScopeName(String value) {
		this.scopeName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("direction", this.direction);
		ret.put("name", this.name);
		if (this.scopeName != null) {
			ret.put("scopeName", this.scopeName);
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
