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

import com.ibm.websphere.simplicity.AbstractSession;
import com.ibm.websphere.simplicity.Cell;
import com.ibm.websphere.simplicity.ConfigIdentifier;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;

/**
 * A custom registry implements the UserRegistry interface in the com.ibm.websphere.security
 * package. For backward compatibility, the application server also supports a custom registry that
 * implements the CustomRegistry interface in the com.ibm.websphere.security package.
 */
public class CustomUserRealm extends UserRealm {
    
    /**
     * Constructor
     * 
     * @param parent The {@link UserRealms} parent
     * @param configId The {@link ConfigIdentifier} of this user realm
     */
    protected CustomUserRealm(UserRealms parent, ConfigIdentifier configId) {
        super(parent, UserRealmType.CustomUserRegistry, configId);
    }

    /**
     * Get the registry class name. This is a dot-separated class name that implements the
     * com.ibm.websphere.security.UserRegistry interface.
     * 
     * @return The custom registry class name
     * @throws Exception
     */
    public String getCustomRegistryClassName() throws Exception {
        if(getAttributes().getCustomRegistryClass() == null) {
            Cell cell = parent.getSecurityDomain().getCell();
            AbstractSession session = cell.getWorkspace().getSession();
            getAttributes().setCustomRegistryClass(OperationsProviderFactory.getProvider().getConfigurationOperationsProvider().getAttribute(cell, session, configId, "customRegistryClassName").toString());
        }
        return getAttributes().getCustomRegistryClass();
    }
    
    /**
     * Get the attributes of the custom registry
     * 
     * @return The registry attributes
     */
    private CustomSettings getAttributes() {
        return (CustomSettings)getRealmAttributes();
    }

}
