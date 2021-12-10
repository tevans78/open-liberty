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

package com.ibm.websphere.simplicity.runtime;

import com.ibm.websphere.simplicity.ApplicationServer;
import com.ibm.websphere.simplicity.Server;
import com.ibm.websphere.simplicity.runtime.MBean;

public class NodeAgentMBean extends MBean {

	public NodeAgentMBean(ApplicationServer scope) throws Exception {
		super(scope);
		resolveObjectName("WebSphere:type=NodeAgent,node="+scope.getNode().getName()+",*");
	}
	
	/**
	 * Attempts to launch the specified server via the node agent's MBean.
	 * @param instance
	 * @return True if the server started successfully, false otherwise.
	 * @throws Exception
	 */
	public boolean launchProcess(Server instance) throws Exception {
		return (Boolean)this.invoke("launchProcess", new Object[] { instance.getName() });
	}
	
	/**
	 * Attempts to launch the specified server via the node agent's MBean, and will
	 * fail if it does not start within the specified timeout period.
	 * @param instance
	 * @param timeout
	 * @return True if the server started successfully, false otherwise.
	 * @throws Exception
	 */
	public boolean launchProcess(Server instance, int timeout) throws Exception {
		return (Boolean)this.invoke("launchProcess", new Object[] { instance.getName(), timeout });
	}
	
	/**
	 * Returns a status of ProcessStatus.RUNNING or ProcessStatus.STOPPED.
	 * @param instance
	 * @return The running or stopped state of the specified server.
	 * @throws Exception
	 */
	public ProcessStatus getProcessStatus(Server instance) throws Exception {
		String res = (String)this.invoke("getProcessStatus", new Object[] { instance.getName() });
		ProcessStatus ret = ProcessStatus.valueOf(res);
		return ret;
	}

	/**
	 * Kills the target process without waiting for shutdown.
	 * @param instance The {@link Server} to terminate
	 * @return The result
	 * @throws Exception
	 */
	public boolean terminate(Server instance) throws Exception {
		return (Boolean)this.invoke("terminate", new Object[] { instance.getName() });
	}

	/**
	 * Stops all processes running in the node, including the node process itself.
	 * @throws Exception
	 */
	public void stopNode() throws Exception {
		this.invoke("stopNode");
	}

}
