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

package com.ibm.websphere.simplicity.provider;

public enum ConfigAttribute {

	ENABLE("enable"),
	FILE_NAME("fileName"),
	MAX_NUMBER_OF_BACKUP_FILES("maxNumberOfBackupFiles"),
    NODE_NAME("nodeName"),
    ROLLOVER_SIZE("rolloverSize"),
    SERVER_NAME("serverName"),
    SERVER_TYPE("serverType"),
    SERVER_VERSION("serverVersion"),
    SERVER_DISPLAY_NAME("serverDisplayName"),
    SYMBOLIC_NAME("symbolicName"),
    TRACE_FORMAT("traceFormat"),
    TRACE_OUTPUT_TYPE("traceOutputType"),
    TRACE_SPECIFICATION("startupTraceSpecification");

    
    private String attribute;
    
    private ConfigAttribute(String attribute) {
        this.attribute = attribute;
    }
    
    public String getAttribute() {
        return this.attribute;
    }
}
