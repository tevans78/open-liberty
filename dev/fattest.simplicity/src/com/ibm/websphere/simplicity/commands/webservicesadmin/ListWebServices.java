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

package com.ibm.websphere.simplicity.commands.webservicesadmin;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;
import java.util.ArrayList;
import com.ibm.websphere.simplicity.commands.CommandStep;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Lists the deployed Web services in enterprise applications. If there is no application name supplied, then all the Web services in the enterprise applications will are be listed.
 *   'application': The enterprise application name that is deployed.
 *   'client': Indicate if the service is a service client.
 * The required parameters are found in the constructor.
 */
public class ListWebServices extends Command {

	private List<Command> __steps;
	private String application;
	private Boolean client;

	public ListWebServices() {
		super("listWebServices");
	}

	/**
	 * The enterprise application name that is deployed.
	 */
	public String getApplication() {
		return this.application;
	}

	/**
	 * The enterprise application name that is deployed.
	 */
	public void setApplication(String value) {
		this.application = value;
	}

	/**
	 * Indicate if the service is a service client.
	 */
	public Boolean getClient() {
		return this.client;
	}

	/**
	 * Indicate if the service is a service client.
	 */
	public void setClient(Boolean value) {
		this.client = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.application != null) {
			ret.put("application", this.application);
		}
		if (this.client != null) {
			ret.put("client", this.client);
		}
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
	public OperationResults<Object> run(Scope scope, J2EEWSStep j2EEWSStep) throws Exception {
		this.__steps = new ArrayList<Command>();
		if (j2EEWSStep != null)
			this.__steps.add(j2EEWSStep);
		return super.run(scope);
	}

	/**
	 * Lists the Web services that are deployed in the enterprise applications.
	 * The required parameters are found in the constructor.
	 */
	public static class J2EEWSStep extends CommandStep {

		public J2EEWSStep() {
			super("J2EEWSStep");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			return ret;
		}

	}
}
