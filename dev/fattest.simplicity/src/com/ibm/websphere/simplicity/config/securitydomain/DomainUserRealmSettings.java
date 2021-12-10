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
 * This interface contains methods to get and set settings specific to a user registry in a security
 * domain.
 * 
 */
public interface DomainUserRealmSettings {


    /**
     * Specifies the realm of the user registry. The system automatically generates a realm name if
     * you do not specify a value.
     * 
     * @return The realm name setting
     */
    public String getRealmName();

    /**
     * Specifies the realm of the user registry. The system automatically generates a realm name if
     * you do not specify a value.
     * 
     * @param realmName The realm name to use
     */
    public void setRealmName(String realmName);
}
