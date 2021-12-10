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

import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;

/**
 * The ConfigIdentifier class is a Simplicity abstraction for the uniqe identifer of a WebSphere
 * object such as a cell, node, or server. What this actually represents depends on the Simplicity
 * implementation being used. For example, in JMX, this is a wrapper for the ObjectName that
 * identifies an entity in the WebSphere configuration. If the wsadmin provider is being used, this
 * is a wrapper for the jython String configuration identifier.
 */
public class ConfigIdentifier {
	
	private static final Class<ConfigIdentifier> c = ConfigIdentifier.class;
	private static final String ConfigPrefix = "_Websphere_Config_Data_";
	
	private Scope scope;
	private IdentifierType type;
	private ObjectName objectName;
	private String wsAdminIdentifier;
	private String displayName;
	private String configId;
	private String dataType;
	
	/**
	 * Accepts a JMX-compatible ObjectName.
     * 
	 * @param objectName The ObjectName identifier
	 */
	public ConfigIdentifier(ObjectName objectName) {
		Log.entering(c, "ConfigIdentifier");
		this.objectName = objectName;
		this.type = IdentifierType.JMX;
		init();
		Log.exiting(c, "ConfigIdentifier");
	}
	
	/**
	 * Accepts a WsAdmin-compatible config identifier.
	 * These are usually in the form: name(id), example: nocodeNode01Cell(cells/nocodeNode01Cell|cell.xml#Cell_1)
	 * If the identifier does not have a display name, that portion of the ID is absent.
     * 
	 * @param identifier The String identifier
	 */
	public ConfigIdentifier(String identifier) {
		this.wsAdminIdentifier = identifier;
		// WAS 6.1 uses JMX style even though we are passed a string
		if (identifier.indexOf(ConfigPrefix) > -1) {
			try {
				this.objectName = new ObjectName(identifier);
			} catch (MalformedObjectNameException e) {
				this.type = IdentifierType.WSADMIN;
			} catch (NullPointerException e) {
				this.type = IdentifierType.WSADMIN;
			}
			this.type = IdentifierType.JMX;
		} else {
			this.type = IdentifierType.WSADMIN;
		}
		init();
	}
	
    /**
     * Get the display name
     * 
     * @return The display name
     */
	public String getDisplayName() {
		return this.displayName;
	}
	
    /**
     * Get the data type of this config identifier
     * 
     * @return The data type
     * @throws Exception
     */
	public String getDataType() throws Exception {
		if (this.dataType == null && this.type.equals(IdentifierType.WSADMIN)) {
			this.dataType = OperationsProviderFactory.getProvider().getConfigurationOperationsProvider().getObjectType(this);
		}
		return this.dataType;
	}
	
    /**
     * Get the String config identifier consumable by wsadmin
     * 
     * @return The String config identifier
     */
	public String getConfigId() {
		return this.configId;
	}
	
    /**
     * Get the {@link Scope} that this ConfigIdentifier identifies
     * 
     * @return The {@link Scope} that this identifies
     */
	public Scope getScope() {
		return this.scope;
	}
    
    /**
     * Set the {@link Scope} that this config identifier identifies
     * 
     * @param scope The {@link Scope} to set
     */
    public void setScope(Scope scope) {
        this.scope = scope;
    }
	
    /**
     * Get the JMX consumable ObjectName
     * 
     * @return The ObjectName for this identifier
     */
	public ObjectName getObjectName() {
		return this.objectName;
	}
	
    /**
     * Converts this ConfigIdentifier to a String
     * 
     * @return A String representation of this identifier
     */
	public String toString() {
		switch(this.type) {
			case JMX: return this.objectName.toString();
			case WSADMIN: return this.configId;
		}
		return null;
	}
    
	private void init() {
		switch(this.type) {
			case JMX:
				this.displayName = objectName.getKeyProperty(ConfigPrefix+"Display_Name");
				this.dataType = objectName.getKeyProperty(ConfigPrefix+"Type");
				this.configId = "("+objectName.getKeyProperty(ConfigPrefix+"Id")+")";
				break;
			case WSADMIN:
				int index = this.wsAdminIdentifier.lastIndexOf('(');
				if(index != -1) {
					this.displayName = this.wsAdminIdentifier.substring(0, index);
					this.configId = this.wsAdminIdentifier.substring(index + 1, this.wsAdminIdentifier.lastIndexOf(')'));
				} else
					this.configId = this.wsAdminIdentifier;
				this.configId  = ("(" + this.configId + ")");
                try {
                	this.dataType = OperationsProviderFactory.getProvider().getConfigurationOperationsProvider().getObjectType(this);
                }
                catch(Exception e) {
                	// ignore?
                }
				break;
		}
	}
    
    public boolean equals(Object o) {
        if(o == null) {
            return false;
        }
        if(!(o instanceof ConfigIdentifier)) {
            return false;
        }
        
        ConfigIdentifier other = (ConfigIdentifier)o;
        
        // everything derives from JMX or wsadmin identifies
        if(this.objectName != null && this.objectName.equals(other.getObjectName())) {
            return true;
        } else if(this.wsAdminIdentifier != null && this.wsAdminIdentifier.equals(other.wsAdminIdentifier)) {
            return true;
        }
        
        return false;
    }

}

enum IdentifierType {
	
	JMX,
	WSADMIN;
	
}