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
import com.ibm.websphere.simplicity.WebServer;

/**
 * Managed object for Web Server functions.
 */
// TODO Finish remaining APIs from: http://publib.boulder.ibm.com/infocenter/wasinfo/v6r1/index.jsp?topic=/com.ibm.websphere.javadoc.doc/public_html/mbeandocs/WebServer.html
public class WebServerMBean extends MBean {
	
	private WebServer webServer;

	public WebServerMBean(ApplicationServer scope, WebServer webServer) throws Exception {
		super(scope);
		this.webServer = webServer;
        resolveObjectName("*:type=WebServer,node=" + scope.getNode().getName() + ",*");
	}
	
	/**
	 * Start the WebServer.
	 * @throws Exception
	 */
	public void start() throws Exception {
		invoke("start", new Object[] { this.webServer.getCellName(), this.webServer.getNodeName(), this.webServer.getName() });
	}
	
	/**
	 * Stop the WebServer.
	 * @throws Exception
	 */
	public void stop() throws Exception {
		invoke("stop", new Object[] { this.webServer.getCellName(), this.webServer.getNodeName(), this.webServer.getName() });
	}
	
	/**
	 * Get the WebServer status.
	 * @return The process status of the web server.
	 * @throws Exception
	 */
	public ProcessStatus status() throws Exception {
		String s = (String)invoke("status", new Object[] { this.webServer.getCellName(), this.webServer.getNodeName(), this.webServer.getName() });
		ProcessStatus ret = ProcessStatus.valueOf(s);
		return ret;
	}
	
}
