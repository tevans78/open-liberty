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

package com.ibm.websphere.simplicity.commands.template;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Add feature pack or stack product features to existing server
 *   'nodeName': Node name of server
 *   'serverName': Server name which require update with new features
 *   'featureTemplateName': Feature pack or stack product template that needs to be added to the server
 *   'serverType': Servertype of Feature pack or stack product template that needs to be added to the server
 * The required parameters are found in the constructor.
 */
public class AddFeaturesToServer extends Command {

	private String nodeName;
	private String serverName;
	private String featureTemplateName;
	private String serverType;

	public AddFeaturesToServer(String nodeName, String featureTemplateName, String serverType) {
		super("addFeaturesToServer");
		this.nodeName = nodeName;
		this.featureTemplateName = featureTemplateName;
		this.serverType = serverType;
	}

	/**
	 * Node name of server
	 */
	public String getNodeName() {
		return this.nodeName;
	}

	/**
	 * Node name of server
	 */
	public void setNodeName(String value) {
		this.nodeName = value;
	}

	/**
	 * Server name which require update with new features
	 */
	public String getServerName() {
		return this.serverName;
	}

	/**
	 * Server name which require update with new features
	 */
	public void setServerName(String value) {
		this.serverName = value;
	}

	/**
	 * Feature pack or stack product template that needs to be added to the server
	 */
	public String getFeatureTemplateName() {
		return this.featureTemplateName;
	}

	/**
	 * Feature pack or stack product template that needs to be added to the server
	 */
	public void setFeatureTemplateName(String value) {
		this.featureTemplateName = value;
	}

	/**
	 * Servertype of Feature pack or stack product template that needs to be added to the server
	 */
	public String getServerType() {
		return this.serverType;
	}

	/**
	 * Servertype of Feature pack or stack product template that needs to be added to the server
	 */
	public void setServerType(String value) {
		this.serverType = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("nodeName", this.nodeName);
		if (this.serverName != null) {
			ret.put("serverName", this.serverName);
		}
		ret.put("featureTemplateName", this.featureTemplateName);
		ret.put("serverType", this.serverType);
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
