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

package com.ibm.websphere.simplicity.commands.jca;

import com.ibm.websphere.simplicity.AbstractSession;
import com.ibm.websphere.simplicity.ConfigIdentifier;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Uninstall a Java 2 Connector (J2C) resource adapter.
 * The required parameters are found in the constructor.
 */
public class UninstallResourceAdapter {

    private ConfigIdentifier target;
    private Boolean force;
    
    public UninstallResourceAdapter(ConfigIdentifier target) {
        this.target = target;
    }
    
    /**
     * Change the command's target (originally specified in constructor).
     */
    public void setCommandTarget(ConfigIdentifier target) {
        this.target = target;
    }
    
    public void setForce(boolean force) {
        this.force = force;
    }
    
    public Boolean getForce() {
        return this.force;
    }
    
    public OperationResults<Object> run(Scope scope) throws Exception {
        Scope key = target.getScope();
        AbstractSession session = key.getActiveSession();
        return OperationsProviderFactory.getProvider().getConfigurationOperationsProvider().uninstallResourceAdaptor(key, session, target, this.force);
    }
}
