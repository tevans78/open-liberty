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

package com.ibm.websphere.simplicity.provider;

import java.io.File;

import com.ibm.websphere.simplicity.CommandLineProviderType;
import com.ibm.websphere.simplicity.OperationsProviderType;
import com.ibm.websphere.simplicity.configuration.ConfigurationProvider;

public abstract class Provider {

    protected OperationsProviderType operationsType;
    protected CommandLineProviderType commandLineType;
    protected ConfigurationProvider config;
    
    public Provider(OperationsProviderType type) {
        this.operationsType = type;
    }
    
    public Provider(CommandLineProviderType type) {
        this.commandLineType = type;
    }
    
    public OperationsProviderType getOperationsType() {
        return this.operationsType;
    }
    
    public CommandLineProviderType getCommandLineType() {
        return this.commandLineType;
    }
    
    public ConfigurationProvider getConfigProvider() throws Exception {
        if (config == null) {
            config = ConfigurationProvider.getProvider(new File("topology.props"));
        }
        return config;
    }
}
