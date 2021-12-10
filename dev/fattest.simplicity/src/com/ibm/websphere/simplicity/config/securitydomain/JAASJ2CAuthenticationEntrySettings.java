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
 * This class contains the settings that can be specified when configuring a
 * {@link JAASJ2CAuthenticationEntry}
 */
public class JAASJ2CAuthenticationEntrySettings {

    private String alias;
    private String user;
    private String password;
    private String description;
    
    /**
     * Specifies the name that uniquely identifies the authentication data entry. Required.
     * 
     * @return The alias of the entry
     */
    public String getAlias() {
        return alias;
    }
    /**
     * Specifies the name that uniquely identifies the authentication data entry. Required.
     * 
     * @param alias The alias to set
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }
    /**
     * Specifies a description of the authentication data entry. Optional.
     * 
     * @return The alias description
     */
    public String getDescription() {
        return description;
    }
    /**
     * Specifies a description of the authentication data entry. 
     * 
     * @param description The description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Specifies the password to use for the target enterprise information system (EIS).
     * 
     * @return The password
     */
    public String getPassword() {
        return password;
    }
    /**
     * Specifies the password to use for the target enterprise information system (EIS).
     * 
     * @param password The password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Specifies the J2C authentication data user ID.
     * 
     * @return The user id
     */
    public String getUser() {
        return user;
    }
    /**
     * Specifies the J2C authentication data user ID.
     * 
     * @param user The user id to set
     */
    public void setUser(String user) {
        this.user = user;
    }
    
    
}
