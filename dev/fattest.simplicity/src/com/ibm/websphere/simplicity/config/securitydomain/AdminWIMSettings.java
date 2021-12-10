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

/**
 * This class contains WIM settings specific to the WIM user registry of the global security domain.
 * 
 */
public class AdminWIMSettings extends WIMSettings implements AdminUserRegistrySettings {

    public Boolean getAutoGenerateServerId() {
        return super.getAutoGenerateServerId();
    }

    public String getPrimaryAdminId() {
        return super.getPrimaryAdminId();
    }

    public String getServerId() {
        return super.getServerId();
    }

    public String getServerIdPassword() {
        return super.getServerIdPassword();
    }

    public void setAutoGenerateServerId(Boolean autoGenerateServerId) {
        super.setAutoGenerateServerId(autoGenerateServerId);
    }

    public void setPrimaryAdminId(String primaryAdminId) {
        super.setPrimaryAdminId(primaryAdminId);
    }

    public void setServerId(String serverId) {
        super.setServerId(serverId);
    }

    public void setServerIdPassword(String serverIdPassword) {
        super.setServerIdPassword(serverIdPassword);
    }

    @Override
    /**
     * Specifies the realm of the user registry. The system automatically generates a realm name if
     * you do not specify a value.
     * 
     * @return The realm name setting
     */
    public String getRealmName() {
        return super.getRealmName();
    }

    @Override
    /**
     * Specifies the realm of the user registry. The system automatically generates a realm name if
     * you do not specify a value.
     * 
     * @param realmName The realm name to use
     */
    public void setRealmName(String realmName) {
        super.setRealmName(realmName);
    }

    
}
