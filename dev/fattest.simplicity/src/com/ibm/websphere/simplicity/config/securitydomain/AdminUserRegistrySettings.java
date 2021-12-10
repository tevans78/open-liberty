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
 * This interface contains methods to get and set settings common to all user registries in the
 * global security domain.
 * 
 */
public interface AdminUserRegistrySettings {
    /**
     * Specifies whether the command automatically generates the server identity that the system
     * uses for internal process communication. Specify true to automatically generate the server
     * identity.
     * 
     * @return The autoGenerateId setting
     */
    public Boolean getAutoGenerateServerId();

    /**
     * Specifies whether the command automatically generates the server identity that the system
     * uses for internal process communication. Specify true to automatically generate the server
     * identity.
     * 
     * @param autoGenerateServerId true to automatically generate the server id
     */
    public void setAutoGenerateServerId(Boolean autoGenerateServerId);

    /**
     * Specifies the name of the user with administrative privileges that is defined in the
     * registry. This parameter does not apply to security configurations.
     * 
     * @return The primary admin ID
     */
    public String getPrimaryAdminId();

    /**
     * Specifies the name of the user with administrative privileges that is defined in the
     * registry. This parameter does not apply to security configurations.
     * 
     * @param primaryAdminId The primary admin ID to use
     */
    public void setPrimaryAdminId(String primaryAdminId);

    /**
     * Specifies the server identity in the repository that the system uses for internal process
     * communication.
     * 
     * @return The server ID
     */
    public String getServerId();

    /**
     * Specifies the server identity in the repository that the system uses for internal process
     * communication.
     * 
     * @param serverId The server ID to use
     */
    public void setServerId(String serverId);

    /**
     * Specifies the password that corresponds to the server identity.
     * 
     * @return The server password
     */
    public String getServerIdPassword();

    /**
     * Specifies the password that corresponds to the server identity.
     * 
     * @param serverIdPassword The server password to use
     */
    public void setServerIdPassword(String serverIdPassword);
}
