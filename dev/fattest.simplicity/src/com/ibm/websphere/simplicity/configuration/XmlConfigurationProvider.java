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

package com.ibm.websphere.simplicity.configuration;

import java.io.File;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

/**
 * A {@link ConfigurationProvider} for an XML configuration file.
 */
public class XmlConfigurationProvider extends ConfigurationProvider {

    /**
     * Constructor
     * 
     * @param configFile The XML configuration file to load
     */
	public XmlConfigurationProvider(File configFile) {
		super(configFile);
	}
	
	@Override
	public boolean hasProperty(String property) {
		return false;
	}

	@Override
	public String getProperty(String property) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProperty(String property, String value) {
		// TODO Auto-generated method stub
		
	}

    @Override
    public Enumeration<?> getPropertyNames() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void writeProperties() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setProperties(Map<String, String> props) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeProperty(String property) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void reloadProperties() throws Exception {
        // TODO Auto-generated method stub
        
    }

	@Override
	public Properties getProperties(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
