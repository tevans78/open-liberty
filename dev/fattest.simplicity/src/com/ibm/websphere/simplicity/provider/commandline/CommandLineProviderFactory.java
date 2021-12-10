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

package com.ibm.websphere.simplicity.provider.commandline;

import java.lang.reflect.Constructor;
import java.util.HashMap;

import com.ibm.websphere.simplicity.CommandLineProviderType;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.commandline.local.LocalWrapper;

public class CommandLineProviderFactory {

    private static Class c = CommandLineProviderFactory.class;
    private static HashMap<CommandLineProviderType, CommandLineProvider> instances = new HashMap<CommandLineProviderType, CommandLineProvider>();
    private static CommandLineProviderType defaultProviderType = CommandLineProviderType.RXA;
    private static boolean useLocalWrapper = true;
    
    public static void setDefaultCommandLineProvider(CommandLineProviderType type) throws Exception {
        if (type == null)
            throw new Exception("Cannot set default command line provider to null");
        defaultProviderType = type;
    }
    
    public static void setUseLocalCommandLineWrapper(boolean useWrapper) {
        useLocalWrapper = useWrapper;
    }
    
    public static CommandLineProvider getProvider() throws Exception {
        return getProvider(defaultProviderType);
    }
    
    public static CommandLineProvider getProvider(CommandLineProviderType providerType) throws Exception {
        Log.entering(c, "getProvider", providerType.name());
        CommandLineProvider ret = null;
        if (instances.containsKey(providerType))
            ret = instances.get(providerType);
        else {
            String clsname = providerType.getClassName();
            Class clazz;
            try {
            	clazz = Class.forName(clsname);
            }
            catch(Exception e) {
            	throw new Exception("Commandline provider not available: "+providerType.name(), e);
            }
            Constructor[] constructors = clazz.getConstructors();
            if (constructors.length == 0)
                throw new Exception("Invalid class constructor list: "+clsname);
            
            Constructor constructor = constructors[0];
            ret = (CommandLineProvider)constructor.newInstance();
            instances.put(providerType, ret);
        }
        
        Log.exiting(c, "getProvider", ret);
        if(useLocalWrapper)
            return new LocalWrapper(ret);
        else
            return ret;
    }
    
}
