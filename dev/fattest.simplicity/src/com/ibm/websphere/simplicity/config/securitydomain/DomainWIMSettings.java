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

public class DomainWIMSettings extends WIMSettings implements DomainUserRealmSettings {

    @Override
    public String getRealmName() {
        return super.getRealmName();
    }

    @Override
    public void setRealmName(String realmName) {
        super.setRealmName(realmName);
    }

}
