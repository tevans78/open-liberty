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

import com.ibm.websphere.simplicity.ConfigIdentifier;

/**
 * This class represents a WIM user realm. By federating repositories, identities stored in multiple
 * repositories can be managed in a single, virtual realm. The realm can consist of identities in
 * the file-based repository that is built into the system, in one or more external repositories, or
 * in both the built-in repository and one or more external repositories.
 */
public class WIMUserRealm extends UserRealm {
    
    /**
     * Constructor
     * 
     * @param parent The {@link UserRealms} parent
     * @param configId The {@link ConfigIdentifier} of the user realm
     */
    protected WIMUserRealm(UserRealms parent, ConfigIdentifier configId) {
        super(parent, UserRealmType.WIMUserRegistry, configId);
    }

}
