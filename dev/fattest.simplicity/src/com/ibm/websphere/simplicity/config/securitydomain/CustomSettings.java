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
 * This abstract class holds custom registry settings that are common to the admin custom registry
 * and application domain custom registries.
 */
public abstract class CustomSettings extends UserRealmSettings {
    
    private String customRegistryClass;
    
    /**
     * Specifies the class name that implements the UserRegistry interface in
     * com.ibm.websphere.security property.
     * 
     * @return The custom registry class
     */
    public String getCustomRegistryClass() {
        return customRegistryClass;
    }
    /**
     * Specifies the class name that implements the UserRegistry interface in
     * com.ibm.websphere.security property.
     * 
     * @param customRegistryClass The custom registry class to set
     */
    public void setCustomRegistryClass(String customRegistryClass) {
        this.customRegistryClass = customRegistryClass;
    }
}
