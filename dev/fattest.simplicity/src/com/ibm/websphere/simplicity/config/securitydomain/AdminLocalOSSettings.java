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
 * This class contains settings specific to configuring a Local OS user registry for the global
 * security domain.
 */
public class AdminLocalOSSettings extends LocalOSSettings implements AdminUserRegistrySettings {

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

}
