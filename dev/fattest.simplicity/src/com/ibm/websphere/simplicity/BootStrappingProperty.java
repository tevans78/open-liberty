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
 * This enum contains the valid properties and property keys for the bootstrapping properties file.
 * Property "keys" end with the String "KEY" (ex: WAS_CELL_KEY) and are used to identify what entity
 * a property value belongs to.<br>
 * Ex: was.cell.1.cellName=Cell01 identifies the name of the cell referenced by key was.cell.1.
 */
public enum BootStrappingProperty {
    
    // Properties
    ALIAS("alias"),
    APPENDTRACE ("appendtrace"),
    BASE_PRODUCT_VERSION("baseProductVersion"),
    BUILD_DATE ("buildDate"),
    BUILD_LEVEL ("buildLevel"),
    CELL_NAME ("cellName"),
    CLUSTER_NAME ("clusterName"),
    CONFIG_PATH ("configPath"),
    CONN_TYPE ("connType"),
    CONN_PORT ("connPort"),
    DEFAULT_ENCODING ("defaultEncoding"),
    EXEC_FILE_SUFFIX ("execFileSuffix"),
    FILE_SEPARATOR ("fileSeparator"),
    FINALIZED ("finalized"),
    HOSTNAME ("hostname"),
    INSTALL ("install"),
    INSTALL_ROOT ("installRoot"),
    INSTALL_TYPE ("installType"),
    JAVAOPTION ("javaoption"),
    LINE_SEPARATOR ("lineSeparator"),
    LOCAL_WSADMIN ("local.wsadmin"),
    MACHINE ("machine"),
    NODE_NAME ("nodeName"),
    OBJECT_NAME ("objectName"),
    OS ("operatingSystem"),
    OS_VERSION ("osVersion"),
    PASSWORD ("password"),
    PATH_SEPARATOR ("pathSeparator"),
    PLUGIN_CONFIG_PATH ("pluginConfigPath"),
    PLUGIN_INSTALL_ROOT ("pluginInstallRoot"),
    PORT ("port"),
    PORT_HOST ("portHost"),
    PROFILE_PATH ("profilePath"),
    PROFILE_NAME ("profileName"),
    RAW_OS_NAME ("rawOSName"),
    ROOT_NODE_HOSTNAME ("rootNodeHostname"),
    ROOT_NODE_PROFILE_PATH ("rootNodeProfilePath"),
    ROOT_NODE_INSTALL_PATH ("rootNodeInstallPath"),
    SECURITY_ENABLED ("securityEnabled"),
    SERVER ("server"),
    SERVER_NAME ("serverName"),
    SERVER_TYPE ("serverType"),
    TEMP_DIR ("tempDir"),
    TOPOLOGY_TYPE ("topology"),
    TRACEFILE ("tracefile"),
    USER ("user"),
    WAS_USERNAME ("WASUsername"),
    WAS_PASSWORD ("WASPassword"),
    WAS_PRODUCT ("wasProduct"),
    WAS_PRODUCT_ID ("wasProductId"),
    WAS_PRODUCT_NAME ("wasProductName"),
    WAS_VERSION ("wasVersion"),
    WEB_SERVER_START_CMD ("webServerStartCommand"),
    WEB_SERVER_START_CMD_ARGS ("webServerStartCommandArgs"),
    WEB_SERVER_STOP_CMD ("webServerStopCommand"),
    WEB_SERVER_STOP_CMD_ARGS ("webServerStopCommandArgs"),
    WSADMIN ("wsadmin"),
    WSADMIN_CONFIG_ID ("wsadminConfigId"),
    
    // Bootstrap Keys
    MACHINE_KEY ("machine"),
    WAS_CELL_KEY ("was.cell."),
    WAS_CLUSTER_KEY ("was.cluster."),
    WAS_CLUSTER_MEMBER_KEY ("was.cluster.member."),
    WAS_INSTALL_KEY ("was.install."),
    WAS_NODE_KEY ("was.node."),
    WAS_PRODUCT_KEY ("was.product."),
    WAS_SERVER_KEY ("was.server."),
    
    // SSH properties
    KEYSTORE ("keystore"),
    PASSPHRASE ("passphrase"),
    
    DATA ("data"),
    PROPERTY_SEP (".");
    
    public static BootStrappingProperty fromPropertyName(String prop) {
    	for (BootStrappingProperty boot : BootStrappingProperty.values()) {
    		if (boot.getPropertyName().equalsIgnoreCase(prop)) {
    			return boot;
    		}
    	}
    	return null;
    }
    
    private String propertyName;
    
    private BootStrappingProperty(String propertyName) {
        this.propertyName = propertyName;
    }
    
    /**
     * Get the String value of the property that is read from and written to the bootstrapping
     * properties file.
     * 
     * @return The String value of the property
     */
    public String getPropertyName() {
        return this.propertyName;
    }
    
    public String toString() {
        return this.propertyName;
    }
}
