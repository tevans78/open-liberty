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

package com.ibm.websphere.simplicity.provider.commandline.local;

import java.util.Properties;

import com.ibm.websphere.simplicity.CommandLineProviderType;
import com.ibm.websphere.simplicity.Machine;
import com.ibm.websphere.simplicity.ProgramOutput;
import com.ibm.websphere.simplicity.RemoteCommand;
import com.ibm.websphere.simplicity.provider.commandline.CommandLineProvider;
import com.ibm.websphere.simplicity.provider.commandline.CommandLineProviderFactory;

public class LocalRemoteCommand extends RemoteCommand {

    public LocalRemoteCommand(String command, String[] parameters, String workDir, Properties envVars, Machine machine) {
        super(command, parameters, workDir, envVars, machine);
    }

    @Override
    protected ProgramOutput execute() throws Exception {
        CommandLineProvider clp = CommandLineProviderFactory.getProvider(CommandLineProviderType.LOCAL);
        if(clp instanceof LocalWrapper) {
            clp = ((LocalWrapper)clp).getRemoteProvider();
        }
        LocalCommandLineProvider provider = (LocalCommandLineProvider)clp;
        return provider.executeCommand(machine, command, parameters, workDir, envVars);
    }
    
}
