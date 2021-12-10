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

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Lists the services based on a generic query properties. It provides more generic query functions than listWebServices, listWebServiceEndpoints, listWebServiceOperations, and getWebService commands.
 *   'queryProps': The query properties for services.
 *   'expandResource': Expand endpoint or operation resource in the service.
 * The required parameters are found in the constructor.
 */
public class ListServices extends Command {

	private java.util.Properties queryProps;
	private String expandResource;

	public ListServices() {
		super("listServices");
	}

	/**
	 * The query properties for services.
	 */
	public java.util.Properties getQueryProps() {
		return this.queryProps;
	}

	/**
	 * The query properties for services.
	 */
	public void setQueryProps(java.util.Properties value) {
		this.queryProps = value;
	}

	/**
	 * Expand endpoint or operation resource in the service.
	 */
	public String getExpandResource() {
		return this.expandResource;
	}

	/**
	 * Expand endpoint or operation resource in the service.
	 */
	public void setExpandResource(String value) {
		this.expandResource = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.queryProps != null) {
			ret.put("queryProps", this.queryProps);
		}
		if (this.expandResource != null) {
			ret.put("expandResource", this.expandResource);
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
