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
 * Managed object for Web Server plugin configuration file generator.
 */
public class PluginCfgGeneratorMBean extends MBean {
	
	private WebServer webServer;

	public PluginCfgGeneratorMBean(ApplicationServer scope, WebServer webServer) throws Exception {
		super(scope);
		this.webServer = webServer;
        resolveObjectName("*:type=PluginCfgGenerator,node=" + scope.getNode().getName() + ",*");
	}
	
	/**
	 * Generate the plugin configuration file.
	 * @param outputFileName The name of the plugin cfg file.
	 * @throws Exception
	 */
	public void generate(String outputFileName) throws Exception {
		invoke("generate", new Object[] {
				getAppServerRoot(),
				getConfigRoot(),
				webServer.getCellName(),
				webServer.getNodeName(),
				webServer.getName(),
				outputFileName });
	}

	/**
	 * Generate the plugin configuration file.
	 * @param outputFileName The name of the plugin cfg file.
	 * @param destinationRoot An alternate root directory for the log file location and the keyfile/stashfiles.
	 * @param destinationOS The operating system of the destination system.
	 * @throws Exception
	 */
	public void generate(String outputFileName, String destinationRoot, String destinationOS) throws Exception {
		invoke("generate", new Object[] {
				getAppServerRoot(),
				getConfigRoot(),
				webServer.getCellName(),
				webServer.getNodeName(),
				webServer.getName(),
				outputFileName,
				destinationRoot,
				destinationOS });
	}
	
	/**
	 * Generate the plugin configuration file.
	 * @param propagate Propagate the config file.
	 * @throws Exception
	 */
	public void generate(boolean propagate) throws Exception {
		invoke("generate", new Object[] {
				getConfigRoot(),
				webServer.getCellName(),
				webServer.getNodeName(),
				webServer.getName(),
				propagate });
	}
	
	/**
	 * Propagate the config file.
	 * @throws Exception
	 */
	public void propagate() throws Exception {
		invoke("propagate", new Object[] {
				getConfigRoot(),
				webServer.getCellName(),
				webServer.getNodeName(),
				webServer.getName() });
	}
	
	private String getAppServerRoot() throws Exception {
		return webServer.getNode().getProfileDir();
	}
	
	private String getConfigRoot() throws Exception {
		return webServer.getCell().getManager().getNode().getProfileDir()+"/config";
	}

}
