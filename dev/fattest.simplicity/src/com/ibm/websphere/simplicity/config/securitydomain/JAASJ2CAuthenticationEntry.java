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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.websphere.simplicity.AbstractSession;
import com.ibm.websphere.simplicity.Cell;
import com.ibm.websphere.simplicity.ConfigIdentifier;
import com.ibm.websphere.simplicity.config.ConfigObject;
import com.ibm.websphere.simplicity.config.Configurable;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;

/**
 * J2C Authentication Entries specify user identities and passwords for Java(TM) 2 connector
 * security to use.
 */
public class JAASJ2CAuthenticationEntry implements Configurable {
    
    private static final Class c = JAASJ2CAuthenticationEntry.class;
    private static final String CHANGE_KEY_USERID = "userid";
    private static final String CHANGE_KEY_DESCRIPTION = "description";
	
	private String alias;
	private String userid;
	private String description;
    private ConfigIdentifier configId;
    private JAASJ2CAuthenticationData parent;
	
    /**
     * Constructor
     * 
     * @param parent The {@link JAASJ2CAuthenticationData} parent class
     * @param configId The {@link ConfigIdentifier} of this entry
     */
	protected JAASJ2CAuthenticationEntry(JAASJ2CAuthenticationData parent, ConfigIdentifier configId) {
        this.parent = parent;
		this.configId = configId;
	}

    /**
     * Get the name of the authentication data entry.
     * 
     * @return The name of the authentication data entry.
     * @throws Exception
     */
	public String getAlias() throws Exception {
		if(this.alias == null) {
            Cell cell = this.parent.getSecurityDomain().getCell();
            AbstractSession session = cell.getWorkspace().getSession();
            this.alias = OperationsProviderFactory.getProvider().getConfigurationOperationsProvider().getAttribute(cell, session, this.configId, "alias").toString();
        }
        return this.alias;
	}

    /**
     * Get the user identity
     * 
     * @return The user identity
     * @throws Exception
     */
	public String getUserid() throws Exception {
        if(this.userid == null) {
            Cell cell = this.parent.getSecurityDomain().getCell();
            AbstractSession session = cell.getWorkspace().getSession();
            this.userid = OperationsProviderFactory.getProvider().getConfigurationOperationsProvider().getAttribute(cell, session, this.configId, "userId").toString();
        }
        return this.userid;
	}

    /**
     * Set the user identity
     * 
     * @param userid The user id to set
     * @throws Exception
     */
	public void setUserid(String userid) throws Exception {
        this.parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_USERID, getUserid());

		JAASJ2CAuthenticationEntrySettings settings = new JAASJ2CAuthenticationEntrySettings();
        settings.setUser(userid);
        settings.setAlias(getAlias());
        JAASJ2CAuthenticationEntry.modifyJ2CAuthenticationDataEntry(parent.getSecurityDomain(), settings);
        this.userid = userid;
	}

    /**
     * Specifies an optional description of the authentication data entry.
     * 
     * @return The description of the entry
     * @throws Exception
     */
	public String getDescription() throws Exception {
        if(this.description == null) {
            Cell cell = this.parent.getSecurityDomain().getCell();
            AbstractSession session = cell.getWorkspace().getSession();
            this.description = OperationsProviderFactory.getProvider().getConfigurationOperationsProvider().getAttribute(cell, session, this.configId, "description").toString();
        }
        return this.description;
	}

    /**
     * Set an optional description of the authentication data entry.
     * 
     * @param description The description to set
     * @throws Exception
     */
	public void setDescription(String description) throws Exception {
        this.parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_DESCRIPTION, getDescription());

        JAASJ2CAuthenticationEntrySettings settings = new JAASJ2CAuthenticationEntrySettings();
        settings.setDescription(description);
        settings.setAlias(getAlias());
        JAASJ2CAuthenticationEntry.modifyJ2CAuthenticationDataEntry(parent.getSecurityDomain(), settings);
        this.description = description;
	}
    
    /**
     * Set the password that is associated with the user identity.
     * 
     * @param password The password to set
     * @throws Exception
     */
    public void setPassword(String password) throws Exception {
        JAASJ2CAuthenticationEntrySettings settings = new JAASJ2CAuthenticationEntrySettings();
        settings.setPassword(password);
        settings.setAlias(getAlias());
        JAASJ2CAuthenticationEntry.modifyJ2CAuthenticationDataEntry(parent.getSecurityDomain(), settings);
    }

    /**
     * Get the {@link ConfigIdentifier} of this entry
     * 
     * @return The entry's {@link ConfigIdentifier}
     */
    public ConfigIdentifier getConfigId() {
        return configId;
    }
    
    /**
     * Get the {@link JAASJ2CAuthenticationData} parent
     * 
     * @return The parent of this entry
     */
    public JAASJ2CAuthenticationData getJAASJ2cAuthenticationData() {
        return this.parent;
    }
    
    /**
     * Modify an entry
     * 
     * @param domain The domain that the entry belongs to
     * @param settings The settings to use in the modification
     * @throws Exception
     */
    private static void modifyJ2CAuthenticationDataEntry(SecurityDomain domain, JAASJ2CAuthenticationEntrySettings settings) throws Exception {
        final String method = "modifyJ2CAuthenticationDataEntry";
        Log.entering(c, method, settings);
        if(settings.getAlias() == null || settings.getAlias().length() < 1) {
            throw new IllegalArgumentException("Alias must be specified.");
        }
        if(domain.isAtLeast70()) {
            final Cell fcell = domain.getCell();
            final JAASJ2CAuthenticationEntrySettings fsettings = settings;
            final String fname = domain.getName();
            OperationsProviderFactory.getProvider().getSecurityOperationsProvider().modifyAuthenticationDataEntry(fcell, fsettings, fname, fcell.getActiveSession());
        } else {
            List<ConfigObject> entries = domain.getconfigObject().getChildObjectsByDataType("JAASAuthData");
            for(ConfigObject entry : entries) {
                if(entry.getAttributeByName("alias").getValueAsString().equals(settings.getAlias())) {
                    if(settings.getDescription() != null) {
                        entry.getAttributeByName("description").setValue(settings.getDescription());
                    } 
                    if(settings.getUser() != null) {
                        entry.getAttributeByName("userId").setValue(settings.getUser());
                    } 
                    if(settings.getPassword() != null) {
                        entry.getAttributeByName("password").setValue(settings.getPassword());
                    }
                    break;
                }
            }
        }
        Log.exiting(c, method);
    }
    
    public void commit(HashMap<String, Object> values) {
    }
    
    public void rollback(HashMap<String, Object> values) {
        for(Map.Entry<String, Object> entry : values.entrySet()) {
        	String key = entry.getKey();
        	Object value = entry.getValue();
        	
            if(key.equals(CHANGE_KEY_USERID)) {
                this.userid = (String)value;
            }
            if(key.equals(CHANGE_KEY_DESCRIPTION)) {
                this.description = (String)value;
            }
        }
    }
    
}
