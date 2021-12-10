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
 * Java(TM) Authentication and Authorization Service (JAAS) login configurations are used by system
 * resources including the authentication mechanism, principal mapping, and credential mapping.
 */
public class JAASApplicationLogin extends JAASLogin {

    /**
     * Constructor to create a JAAS Application login
     * 
     * @param parent The {@link JAASApplicationLogins} parent
     * @param configId The {@link ConfigIdentifier} for this login
     */
    protected JAASApplicationLogin(JAASApplicationLogins parent, ConfigIdentifier configId) {
        super(parent, JAASLoginType.APPLICATION, configId);
    }
}
