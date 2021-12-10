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

package com.ibm.websphere.simplicity.server;

import com.ibm.websphere.simplicity.ApplicationServer;

/**
 * Options for creating an {@link ApplicationServer}
 */
public class AppServerCreationOptions {
    
    private boolean genUniquePorts = true;
    private String serverName;
    private String templateName;
    
    /**
     * Specifies that unique ports should be created for the server.
     * 
     * @return The genUniquePorts value
     */
    public boolean getGenUniquePorts() {
        return genUniquePorts;
    }
    
    /**
     * Specifies that unique ports should be created for the server. Default value is true.
     * 
     * @param genUniquePorts Whether or not to generate unique ports when creating a new server.
     */
    public void setGenUniquePorts(boolean genUniquePorts) {
        this.genUniquePorts = genUniquePorts;
    }
    
    /**
     * The name of the server that you want to create. Required.
     * 
     * @return The name of the new server
     */
    public String getServerName() {
        return serverName;
    }
    
    /**
     * The name of the server that you want to create.
     * 
     * @param serverName The name to use when creating the new server.
     */
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }
    
    /**
     * The template used to create the server.  Optional.
     * 
     * @return The name of the template for the new server.
     */
    public String getTemplateName() {
    	return templateName;
    }
    
    /**
     * The template used to create the server.
     * 
     * @param templateName The template to use when creating the new server.
     */
    public void setTemplateName(String templateName) {
    	this.templateName = templateName;
    }

}
