/*******************************************************************************
 * Copyright (c) 2011, 2022 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.websphere.simplicity.provider.commandline;

import java.util.Properties;

import com.ibm.websphere.simplicity.CommandLineProviderType;
import com.ibm.websphere.simplicity.Machine;
import com.ibm.websphere.simplicity.RemoteCommand;
import com.ibm.websphere.simplicity.provider.commandline.local.LocalRemoteCommand;
import com.ibm.websphere.simplicity.provider.commandline.local.LocalWrapper;

/**
 * Generates an instance of {@link RemoteCommand}
 */
public class RemoteCommandFactory {

    public static RemoteCommand getInstance(String command, String[] parameters, String workDir, Properties envVars, Machine machine) throws Exception {
        CommandLineProvider clp = CommandLineProviderFactory.getProvider();
        if (LocalWrapper.isLocal(machine.getHostname(), null)) {
            return new LocalRemoteCommand(command, parameters, workDir, envVars, machine);
        } else if (clp.getCommandLineType() == CommandLineProviderType.RXA) {
            throw new UnsupportedOperationException("CommandLineProviderType RXA not supported");
            //return new RXARemoteCommand(command, parameters, workDir, envVars, machine);
        } else if (clp.getCommandLineType() == CommandLineProviderType.LOCAL) {
            return new LocalRemoteCommand(command, parameters, workDir, envVars, machine);
        } else {
            throw new Exception("RemoteCommand is not supported for command line provider " + clp.getCommandLineType());
        }
    }
}
