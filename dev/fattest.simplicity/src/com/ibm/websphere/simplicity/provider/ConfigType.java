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

public enum ConfigType {
    
    APP_SECURITY("AppSecurity"),
    CLUSTER_MEMBER("ClusterMember"),
    ENDPOINT("EndPoint"),
    NAMED_ENDPOINT("NamedEndPoint"),
    NODE("Node"),
    NODEGROUP("NodeGroup"),
    SECURITY("Security"),
    SECURITY_DOMAIN("SecurityDomain"),
    SERVER("Server"),
    SERVER_CLUSTER("ServerCluster"),
    SERVER_ENTRY("ServerEntry"),
    TRACE_LOG("TraceLog"),
    TRACE_SERVICE("TraceService"),
    VARIABLE_MAP("VariableMap"),
    VARIABLE_SUBSTITUION_ENTRY ("VariableSubstitutionEntry");

    private String type;
    
    private ConfigType(String type) {
        this.type = type;
    }
    
    public String getType() {
        return this.type;
    }
    
}
