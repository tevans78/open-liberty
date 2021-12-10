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
 * Lists the Web service endpoints that are port names defined in a Web service in an enterprise application.
 *   'application': The enterprise application name that is deployed.
 *   'module': The module name within a specified application.
 *   'service': The Web service name that is deployed within a specified application.
 *   'client': Indicate if the service is a service client.
 * The required parameters are found in the constructor.
 */
public class ListWebServiceEndpoints extends Command {

	private List<Command> __steps;
	private String application;
	private String module;
	private String service;
	private Boolean client;

	public ListWebServiceEndpoints(String application, String module, String service) {
		super("listWebServiceEndpoints");
		this.application = application;
		this.module = module;
		this.service = service;
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
	 * The module name within a specified application.
	 */
	public String getModule() {
		return this.module;
	}

	/**
	 * The module name within a specified application.
	 */
	public void setModule(String value) {
		this.module = value;
	}

	/**
	 * The Web service name that is deployed within a specified application.
	 */
	public String getService() {
		return this.service;
	}

	/**
	 * The Web service name that is deployed within a specified application.
	 */
	public void setService(String value) {
		this.service = value;
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
		ret.put("application", this.application);
		ret.put("module", this.module);
		ret.put("service", this.service);
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
	 * Lists the logical endpoints that are port names in a Web service.
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
