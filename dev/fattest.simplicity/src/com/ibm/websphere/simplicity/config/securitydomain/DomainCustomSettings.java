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
 * This class contains settings used to config a custom user registry for a security domain.
 */
public class DomainCustomSettings extends CustomSettings implements DomainUserRealmSettings {

    public String getRealmName() {
        return super.getRealmName();
    }

    public void setRealmName(String realmName) {
        super.setRealmName(realmName);
    }
}
