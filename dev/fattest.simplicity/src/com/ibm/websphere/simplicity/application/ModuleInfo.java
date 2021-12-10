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

package com.ibm.websphere.simplicity.application;

/**
 * This is a stub class to pass structured information about application modules (WAR modules, EJB
 * modules, etc) across the plugin barrier to the WebSphere operation providers.
 */
public class ModuleInfo {
	
	private String name;
	private String uri;
	
    /**
     * Constructor that takes in the module name and uri.
     * 
     * @param name The module name
     * @param uri The module uri
     */
	public ModuleInfo(String name, String uri) {
		this.name = name;
		this.uri = uri;
	}
	
    /**
     * Get the name of the application which is the war, jar, or rar file contained in the
     * application ear
     * 
     * @return The module name
     */
	public String getName() {
		return this.name;
	}
	
    /**
     * Get the uri of the application module which is usually of the form
     * moduleFile,deploymentDescriptorFile ex: webModule.war,WEB-INF/web.xml
     * 
     * @return The module uri
     */
	public String getUri() {
		return this.uri;
	}

}
