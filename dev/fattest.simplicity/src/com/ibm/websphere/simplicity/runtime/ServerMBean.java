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

/**
 * 
 * @author SterlingBates
 * 
 * Lists methods for interacting with a server management mbean.
 *
 */
public class ServerMBean extends MBean {

	public ServerMBean(ApplicationServer scope) throws Exception {
		super(scope);
		resolveObjectName("WebSphere:type=Server,name="+scope.getName()+",process="+scope.getName()+",node="+scope.getNodeName()+",*");
	}
	
	public String getProcessIdString() throws Exception {
		Object ret = getAttribute("pid");
		return ret.toString();
	}
	
	/**
     * @deprecated
     * @see #getProcessIdString()
     */
	public int getProcessId() throws Exception {
		Object ret = getAttribute("pid");
		if (ret instanceof String)
			return Integer.parseInt((String)ret);
		else
			return (Integer)ret;
	}
	
	public String getPlatformName() throws Exception {
		return (String)invoke("getPlatformName");
	}
	
	public String getPlatformVersion() throws Exception {
		return (String)invoke("getPlatformVersion");
	}
	
	public void stop() throws Exception {
		invoke("stop");
	}
	
	public void restart() throws Exception {
		invoke("restart");
	}
	
	public void stopImmediate() throws Exception {
		invoke("stopImmediate");
	}
}
