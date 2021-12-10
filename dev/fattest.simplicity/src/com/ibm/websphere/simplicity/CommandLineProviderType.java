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

package com.ibm.websphere.simplicity;

public enum CommandLineProviderType {
    
    LOCAL ("com.ibm.websphere.simplicity.provider.commandline.local.LocalCommandLineProvider"),
    RXA ("com.ibm.websphere.simplicity.provider.commandline.rxa.RXACommandLineProvider");
    
    private String className;
    
    private CommandLineProviderType(String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }
}
