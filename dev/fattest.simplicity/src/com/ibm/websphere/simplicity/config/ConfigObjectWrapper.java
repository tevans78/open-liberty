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

package com.ibm.websphere.simplicity.config;

import com.ibm.websphere.simplicity.Scope;

/**
 * The ConfigObjectWrapper class is intended as a base class for concrete
 * configuration classes.  For example, the TraceService class extends it
 * to provide concrete methods for modifying server.xml trace settings for
 * a particular server.
 */
public abstract class ConfigObjectWrapper {
	
	private Scope scope;
	private ConfigObject root;

	/**
	 * @param scope The scope in which the ConfigObject exists.
	 */
	public ConfigObjectWrapper(Scope scope) {
		this.scope = scope;
	}
	
	/**
	 * A ConfigObject's scope can be greater than its actual location, but it
	 * cannot be lesser.  For example, if the object resides in a server-level 
	 * xml file, the scope can be any of a Cell, Node or Server.  But if the 
	 * object resides in a node-level XML file the scope cannot be a Server.
	 * @return The scope at which the represented ConfigObject exists.
	 */
	public Scope getScope() {
		return this.scope;
	}
	
	/**
	 * @return The actual configuration object represented by this wrapper.
	 */
	public ConfigObject getConfigObject() {
		return this.root;
	}
	
	protected Object getAttribute(String name) throws Exception {
        return root.getAttributeByName(name).getValue();
	}
    
    protected String getStringAttribute(String name) throws Exception {
        return root.getAttributeByName(name).getValueAsString();
    }
    
    protected int getIntAttribute(String name) throws Exception {
        return root.getAttributeByName(name).getValueAsInt();
    }
    
    protected boolean getBooleanAttribute(String name) throws Exception {
        return root.getAttributeByName(name).getValueAsBoolean();
    }
    
	protected void setAttribute(String name, Object value) throws Exception {
        root.getAttributeByName(name).setValue(value);
	}
	
	protected void setConfigObject(ConfigObject obj) {
		this.root = obj;
	}

}
