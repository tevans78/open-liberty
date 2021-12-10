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

package com.ibm.websphere.simplicity.commands.server;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * A command that can be used to change the cluster's short name.
 *   'clusterName': The cluster short name is applicable only on zOS platforms. This represents the short name of the cluster. Every cluster should have unique short name. This parameter is optional and when it is not specified a unique short name is automatically assigned. The value should be 8 chars or less and all upper case.
 *   'shortName': The cluster short name is applicable only on zOS platforms. This represents the short name of the cluster. Every cluster should have unique short name. This parameter is optional and when it is not specified a unique short name is automatically assigned. The value should be 8 chars or less and all upper case.
 * The required parameters are found in the constructor.
 */
public class ChangeClusterShortName extends Command {

	private String clusterName;
	private String shortName;

	public ChangeClusterShortName(String clusterName, String shortName) {
		super("changeClusterShortName");
		this.clusterName = clusterName;
		this.shortName = shortName;
	}

	/**
	 * The cluster short name is applicable only on zOS platforms. This represents the short name of the cluster. Every cluster should have unique short name. This parameter is optional and when it is not specified a unique short name is automatically assigned. The value should be 8 chars or less and all upper case.
	 */
	public String getClusterName() {
		return this.clusterName;
	}

	/**
	 * The cluster short name is applicable only on zOS platforms. This represents the short name of the cluster. Every cluster should have unique short name. This parameter is optional and when it is not specified a unique short name is automatically assigned. The value should be 8 chars or less and all upper case.
	 */
	public void setClusterName(String value) {
		this.clusterName = value;
	}

	/**
	 * The cluster short name is applicable only on zOS platforms. This represents the short name of the cluster. Every cluster should have unique short name. This parameter is optional and when it is not specified a unique short name is automatically assigned. The value should be 8 chars or less and all upper case.
	 */
	public String getShortName() {
		return this.shortName;
	}

	/**
	 * The cluster short name is applicable only on zOS platforms. This represents the short name of the cluster. Every cluster should have unique short name. This parameter is optional and when it is not specified a unique short name is automatically assigned. The value should be 8 chars or less and all upper case.
	 */
	public void setShortName(String value) {
		this.shortName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("clusterName", this.clusterName);
		ret.put("shortName", this.shortName);
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
