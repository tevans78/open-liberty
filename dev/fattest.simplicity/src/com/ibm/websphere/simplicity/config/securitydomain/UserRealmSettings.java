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

package com.ibm.websphere.simplicity.config.securitydomain;

import java.util.Map;

/**
 * This class contains settings that can be used to configure all user registry types.
 */
public abstract class UserRealmSettings {

    protected Boolean ignoreCase;
    protected Boolean verifyRegistry;
    protected Map<String, String> customProperties;
    protected Boolean autoGenerateServerId;
    protected String serverId;
    protected String serverIdPassword;
    protected String primaryAdminId;
    protected String realmName;

    /**
     * Specifies attribute and value pairs that the system stores as custom properties on the user
     * registry object.
     * 
     * @return The custom properties for the custom registry
     */
    public Map<String, String> getCustomProperties() {
        return this.customProperties;
    }
    /**
     * Specifies attribute and value pairs that the system stores as custom properties on the user
     * registry object.
     * 
     * @param customProperties The custom properties to set
     */
    public void setCustomProperties(Map<String, String> customProperties) {
        this.customProperties = customProperties;
    }
    /**
     * Specifies whether authorization is case-sensitive. Specify true to ignore the case during
     * authorization.
     * 
     * @return The ignore case setting
     */
    public Boolean getIgnoreCase() {
        return ignoreCase;
    }
    /**
     * Specifies whether authorization is case-sensitive. Specify true to ignore the case during
     * authorization.
     * 
     * @param ignoreCase true to ignore the case during authorization
     */
    public void setIgnoreCase(Boolean ignoreCase) {
        this.ignoreCase = ignoreCase;
    }
    /**
     * Specifies whether to verify that the user registry configuration is correct. If you set this
     * parameter to true, then the system verifies the registry by making a call to the user
     * registry to verify the admin ID. If you specify a server ID and password, then the system
     * verifies the user and password with the user registry. Set the parameter to false to store
     * the attributes in the configuration without validation. The command verifies the registry
     * configuration by default.
     * 
     * @return If the registry should be verified
     */
    public Boolean getVerifyRegistry() {
        return verifyRegistry;
    }
    /**
     * Specifies whether to verify that the user registry configuration is correct. If you set this
     * parameter to true, then the system verifies the registry by making a call to the user
     * registry to verify the admin ID. If you specify a server ID and password, then the system
     * verifies the user and password with the user registry. Set the parameter to false to store
     * the attributes in the configuration without validation. The command verifies the registry
     * configuration by default.
     * 
     * @param verifyRegistry true to verify the registry
     */
    public void setVerifyRegistry(Boolean verifyRegistry) {
        this.verifyRegistry = verifyRegistry;
    }
    protected Boolean getAutoGenerateServerId() {
        return autoGenerateServerId;
    }
    protected void setAutoGenerateServerId(Boolean autoGenerateServerId) {
        this.autoGenerateServerId = autoGenerateServerId;
    }
    protected String getPrimaryAdminId() {
        return primaryAdminId;
    }
    protected void setPrimaryAdminId(String primaryAdminId) {
        this.primaryAdminId = primaryAdminId;
    }
    protected String getRealmName() {
        return realmName;
    }
    protected void setRealmName(String realmName) {
        this.realmName = realmName;
    }
    protected String getServerId() {
        return serverId;
    }
    protected void setServerId(String serverId) {
        this.serverId = serverId;
    }
    protected String getServerIdPassword() {
        return serverIdPassword;
    }
    protected void setServerIdPassword(String serverIdPassword) {
        this.serverIdPassword = serverIdPassword;
    }
    
}
