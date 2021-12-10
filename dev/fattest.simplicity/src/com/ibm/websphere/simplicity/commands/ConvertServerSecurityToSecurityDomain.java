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

package com.ibm.websphere.simplicity.commands;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Task to convert server level security configuration to a security domain configuration.
 *   'securityDomainDescription': Description of the security domain.
 *   'deleteServer': Specify true to delete the server level security configuration or specify false to leave the security configuration around.
 *   'serverResource': The server resource whose server level security configuration will be converted to a security domain.
 *   'securityDomain': The unique name of the newly created security domain where the server level security configuration will be converted to.
 * The required parameters are found in the constructor.
 */
public class ConvertServerSecurityToSecurityDomain extends Command {

	private String securityDomainDescription;
	private Boolean deleteServer = false;
	private String serverResource;
	private String securityDomain;

	public ConvertServerSecurityToSecurityDomain(String serverResource, String securityDomain) {
		super("convertServerSecurityToSecurityDomain");
		this.serverResource = serverResource;
		this.securityDomain = securityDomain;
	}

	/**
	 * Description of the security domain.
	 */
	public String getSecurityDomainDescription() {
		return this.securityDomainDescription;
	}

	/**
	 * Description of the security domain.
	 */
	public void setSecurityDomainDescription(String value) {
		this.securityDomainDescription = value;
	}

	/**
	 * Specify true to delete the server level security configuration or specify false to leave the security configuration around.
	 */
	public Boolean getDeleteServer() {
		return this.deleteServer;
	}

	/**
	 * Specify true to delete the server level security configuration or specify false to leave the security configuration around.
	 */
	public void setDeleteServer(Boolean value) {
		this.deleteServer = value;
	}

	/**
	 * The server resource whose server level security configuration will be converted to a security domain.
	 */
	public String getServerResource() {
		return this.serverResource;
	}

	/**
	 * The server resource whose server level security configuration will be converted to a security domain.
	 */
	public void setServerResource(String value) {
		this.serverResource = value;
	}

	/**
	 * The unique name of the newly created security domain where the server level security configuration will be converted to.
	 */
	public String getSecurityDomain() {
		return this.securityDomain;
	}

	/**
	 * The unique name of the newly created security domain where the server level security configuration will be converted to.
	 */
	public void setSecurityDomain(String value) {
		this.securityDomain = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.securityDomainDescription != null) {
			ret.put("securityDomainDescription", this.securityDomainDescription);
		}
		if (this.deleteServer != null) {
			ret.put("deleteServer", this.deleteServer);
		}
		ret.put("serverResource", this.serverResource);
		ret.put("securityDomain", this.securityDomain);
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
