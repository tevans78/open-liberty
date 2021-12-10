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

package com.ibm.websphere.simplicity;

/**
 * This enum contains the property values found in the simplicityConfig.props file. These properties
 * can be used to set things like the prefered WebSphere Operations Provider, Command Line Provider,
 * and bootstrapping properties file location.
 */
public enum ConfigProperties {
    
    BOOTSTRAPPING_PROPS_FILE("bootstrappingPropsFile"),
    CLIENT_PROPS_DIR("clientPropsDir"),
    COMMAND_LINE_PROVIDER("commandLineProvider"),
    CONFIG_PROPS("simplicityConfigProps"),
    JIIWS_PORT("jiiwsPort"),
    JIIWS_INACTIVITY_TIMEOUT("jiiwsInactivityTimeout"),
    PREFER_JIIWS_WSADMIN("preferJIIWSWsAdmin"),
    PREFER_WSADMIN_THIN_CLIENT("preferWsadminThinClient"),
    USE_LOCAL_COMMAND_LINE_WRAPPER("useLocalCommandLineWrapper"),
    USE_TOPOLOGY_CACHING("useTopologyCaching"),
    WEBSPHERE_OPERATIONS_PROVIDER("webSphereOperationsProvider");
    
    private String property;
    
    private ConfigProperties(String property) {
        this.property = property;
    }
    
    public String toString() {
        return this.property;
    }
}