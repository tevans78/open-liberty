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

import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ibm.websphere.simplicity.AbstractSession;
import com.ibm.websphere.simplicity.Cell;
import com.ibm.websphere.simplicity.ConfigIdentifier;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.config.ConfigObject;
import com.ibm.websphere.simplicity.config.Configurable;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;

/**
 * This class contains the JAAS J2C Authentication data settings for the domain
 */
public class JAASJ2CAuthenticationData extends SecurityDomainAttribute implements Configurable {
    
    private static final Class c = JAASJ2CAuthenticationData.class;
    private static final String CHANGE_KEY_AUTH_ENTRIES = "authDataEntries";

	private Set<JAASJ2CAuthenticationEntry> entries;
	
    /**
     * Constructor
     * 
     * @param domain The parent {@link SecurityDomain}
     */
	protected JAASJ2CAuthenticationData(SecurityDomain domain) {
		super(domain);
	}
	
    /**
     * Get the J2C authentication entries for this domain
     * 
     * @return A Set of {@link JAASJ2CAuthenticationEntry} or null of no J2C Authentication configuration exists for the domain
     * @throws Exception
     */
	public Set<JAASJ2CAuthenticationEntry> getEntries() throws Exception {
		if(this.entries == null) {
            this.entries = new HashSet<JAASJ2CAuthenticationEntry>();
            if(getSecurityDomain().isAtLeast70()) {
                Cell cell = getSecurityDomain().getCell();
                String domainName = getSecurityDomain().getName();
                AbstractSession session = cell.getWorkspace().getSession();
                Set<ConfigIdentifier> configIds = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().getAuthDataEntries(cell, domainName, session);
                if(configIds != null) {
                    for(ConfigIdentifier configId : configIds) {
                        this.entries.add(new JAASJ2CAuthenticationEntry(this, configId));
                    }
                }
            } else {
                List<ConfigObject> authDataEntries = getSecurityDomain().getconfigObject().getChildObjectsByDataType("JAASAuthData");
                if(authDataEntries.size() > 0) {
                    for(ConfigObject entry : authDataEntries) {
                        this.entries.add(new JAASJ2CAuthenticationEntry(this, entry.getConfigIdentifier()));
                    }
                }
            }
        }
        return new HashSet<JAASJ2CAuthenticationEntry>(this.entries);
	}
    
    /**
     * Get a specific {@link JAASJ2CAuthenticationEntry}
     * 
     * @param alias The alias of the entry to get
     * @return The {@link JAASJ2CAuthenticationEntry} identified by the alias or null if no
     *         {@link JAASJ2CAuthenticationEntry} exists with the alias
     * @throws Exception
     */
    public JAASJ2CAuthenticationEntry getEntryByAlias(String alias) throws Exception {
        Set<JAASJ2CAuthenticationEntry> entries = getEntries();
        if(entries != null) {
            for(JAASJ2CAuthenticationEntry entry : entries) {
                if(entry.getAlias().equals(alias)) {
                    return entry;
                }
            }
        }
        return null;
    }
    
    /**
     * Create a {@link JAASJ2CAuthenticationEntry}
     * 
     * @param settings The settings to use when creating the {@link JAASJ2CAuthenticationEntry}
     * @return An {@link OperationResults} containing the new {@link JAASJ2CAuthenticationEntry}
     * @throws Exception
     */
    public OperationResults<JAASJ2CAuthenticationEntry> createJ2CAuthenticationDataEntry(JAASJ2CAuthenticationEntrySettings settings) throws Exception {
        final String method = "createJ2CAuthenticationDataEntry";
        Log.entering(c, method, settings);
        if(settings == null) {
            throw new IllegalArgumentException("Settings cannot be null.");
        }
        if(settings.getAlias() == null || settings.getAlias().length() < 1) {
            throw new IllegalArgumentException("Alias must be specified.");
        }
        if(settings.getUser() == null || settings.getUser().length() < 1) {
            throw new IllegalArgumentException("User must be specified.");
        }
        if(settings.getPassword() == null || settings.getPassword().length() < 1) {
            throw new IllegalArgumentException("Password must be specified.");
        }
        if(getEntryByAlias(settings.getAlias()) != null) {
            throw new Exception("A J2C authentication entry with alias " + settings.getAlias() + " already exists.");
        }

        this.domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_AUTH_ENTRIES, getEntries());

        OperationResults<JAASJ2CAuthenticationEntry> ret = new OperationResults<JAASJ2CAuthenticationEntry>();
        ConfigIdentifier configId = null;
        final Cell fcell = getSecurityDomain().getCell();
        if(getSecurityDomain().isAtLeast70()) {
            final JAASJ2CAuthenticationEntrySettings fsettings = settings;
            final String fname = getSecurityDomain().getName();
            OperationResults<ConfigIdentifier> results = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().createAuthenticationDataEntry(fcell, fsettings, fname, fcell.getActiveSession());
            OperationResults.setOperationResults(ret, results);
            configId = results.getResult();
        } else {
            ConfigObject security = getSecurityDomain().getconfigObject();
            ConfigObject authDataEntry = ConfigObject.createConfigObject(fcell, "JAASAuthData", security);
            authDataEntry.getAttributeByName("alias").setValue(settings.getAlias());
            authDataEntry.getAttributeByName("userId").setValue(settings.getUser());
            authDataEntry.getAttributeByName("description").setValue(settings.getDescription());
            authDataEntry.getAttributeByName("password").setValue(settings.getPassword());
            configId = authDataEntry.getConfigIdentifier();
        }
        
        if(this.entries == null) {
            ret.setResult(getEntryByAlias(settings.getAlias()));
        } else {
            JAASJ2CAuthenticationEntry entry = new JAASJ2CAuthenticationEntry(this, configId);
            this.entries.add(entry);
            ret.setResult(entry);
        }
        
        Log.exiting(c, method, ret);
        return ret;
    }
    
    /**
     * Delete a {@link JAASJ2CAuthenticationEntry}
     * 
     * @param alias The alias of the entry to delete
     * @throws Exception
     */
    public void deleteJ2CAuthenticationDataEntry(String alias) throws Exception {
        final String method = "deleteJ2CAuthenticationDataEntry";
        Log.entering(c, method, alias);
        if(alias == null || alias.length() < 1) {
            throw new IllegalArgumentException("alias must be specified.");
        }
        if(getEntryByAlias(alias) == null) {
            throw new Exception("No J2C authentication data entry exists with alias " + alias);
        }
        this.domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_AUTH_ENTRIES, getEntries());

        if(getSecurityDomain().isAtLeast70()) {
            final Cell fcell = getSecurityDomain().getCell();
            final String falias = alias;
            final String fname = getSecurityDomain().getName();
            OperationsProviderFactory.getProvider().getSecurityOperationsProvider().deleteAuthenticationDataEntry(fcell, falias, fname, fcell.getActiveSession());
        } else {
            List<ConfigObject> authDataEntries = getSecurityDomain().getconfigObject().getChildObjectsByDataType("JAASAuthData");
            for(ConfigObject entry : authDataEntries) {
                if(entry.getAttributeByName("alias").getValueAsString().equals(alias)) {
                    entry.delete();
                    break;
                }
            }
        }
        JAASJ2CAuthenticationEntry entry = getEntryByAlias(alias);
        this.entries.remove(entry);
        if(this.entries.size() == 0) {
            this.entries = null;
        }
        
        Log.exiting(c, method);
    }

    @Override
    public boolean globalSettingsInUse() throws Exception {
        return ((this.getSecurityDomain() instanceof GlobalSecurityDomain) || (getEntries() == null));
    }

    @Override
    public void useGlobalDomainSettings() throws Exception {
        final String method = "useGlobalDomainSettings";
        Log.entering(c, method);
        
        this.domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_AUTH_ENTRIES, getEntries());
        
        Set<JAASJ2CAuthenticationEntry> entries = getEntries();
        if(getSecurityDomain() instanceof GlobalSecurityDomain) {
            Log.finer(c, method, "This is the global security domain. Nothing to do.");
            Log.exiting(c, method);
            return;
        }
        
        for(JAASJ2CAuthenticationEntry entry : entries) {
            deleteJ2CAuthenticationDataEntry(entry.getAlias());
        }
        
        Log.exiting(c, method);
    }

    public void commit(HashMap<String, Object> values) throws Exception {
    }

    @SuppressWarnings("unchecked")
    public void rollback(HashMap<String, Object> values) throws Exception {
        for(Map.Entry<String, Object> entry : values.entrySet()) {
        	String key = entry.getKey();
        	Object value = entry.getValue();
        	
            if(key.equals(CHANGE_KEY_AUTH_ENTRIES)) {
	            this.entries = (Set)value;
	        }
        }
    }
    
}
