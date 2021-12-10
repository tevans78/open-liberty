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

package com.ibm.websphere.simplicity.commands.ejb;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * This command removes automatically created persistent EJBTimers for a specific application or module on a specific server.  Refer to the product InfoCenter for scenarios where this command might be used.
 *   'appName': The name of the application that contains the automatic persistent EJBTimers you are removing.
 *   'moduleName': The name of the module that contains the automatic persistent EJBTimers you are removing.
 *   'serverName': The name of the server that runs the application that contains the EJBTimers you are removing.
 *   'nodeName': The name of the node that contains the server you are targeting.
 *   'schedulerJNDIName': The JNDI name of the scheduler instance that supports the automatic EJBTimers you are removing.  If the default scheduler instance was used to support your EJBTimers, then you do not need to specify this parm.
 * The required parameters are found in the constructor.
 */
public class RemoveAutomaticEJBTimers extends Command {

	private String appName;
	private String moduleName;
	private String serverName;
	private String nodeName;
	private String schedulerJNDIName;

	public RemoveAutomaticEJBTimers(String appName, String serverName) {
		super("removeAutomaticEJBTimers");
		this.appName = appName;
		this.serverName = serverName;
	}

	/**
	 * The name of the application that contains the automatic persistent EJBTimers you are removing.
	 */
	public String getAppName() {
		return this.appName;
	}

	/**
	 * The name of the application that contains the automatic persistent EJBTimers you are removing.
	 */
	public void setAppName(String value) {
		this.appName = value;
	}

	/**
	 * The name of the module that contains the automatic persistent EJBTimers you are removing.
	 */
	public String getModuleName() {
		return this.moduleName;
	}

	/**
	 * The name of the module that contains the automatic persistent EJBTimers you are removing.
	 */
	public void setModuleName(String value) {
		this.moduleName = value;
	}

	/**
	 * The name of the server that runs the application that contains the EJBTimers you are removing.
	 */
	public String getServerName() {
		return this.serverName;
	}

	/**
	 * The name of the server that runs the application that contains the EJBTimers you are removing.
	 */
	public void setServerName(String value) {
		this.serverName = value;
	}

	/**
	 * The name of the node that contains the server you are targeting.
	 */
	public String getNodeName() {
		return this.nodeName;
	}

	/**
	 * The name of the node that contains the server you are targeting.
	 */
	public void setNodeName(String value) {
		this.nodeName = value;
	}

	/**
	 * The JNDI name of the scheduler instance that supports the automatic EJBTimers you are removing.  If the default scheduler instance was used to support your EJBTimers, then you do not need to specify this parm.
	 */
	public String getSchedulerJNDIName() {
		return this.schedulerJNDIName;
	}

	/**
	 * The JNDI name of the scheduler instance that supports the automatic EJBTimers you are removing.  If the default scheduler instance was used to support your EJBTimers, then you do not need to specify this parm.
	 */
	public void setSchedulerJNDIName(String value) {
		this.schedulerJNDIName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("appName", this.appName);
		if (this.moduleName != null) {
			ret.put("moduleName", this.moduleName);
		}
		ret.put("serverName", this.serverName);
		if (this.nodeName != null) {
			ret.put("nodeName", this.nodeName);
		}
		if (this.schedulerJNDIName != null) {
			ret.put("schedulerJNDIName", this.schedulerJNDIName);
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
