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
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;

/**
 * This class is the parent for all base user realm classes
 */
public abstract class UserRealm implements Configurable {
    
	private static final String CHANGE_KEY_IGNORE_CASE = "ignoreCase";
	private static final String CHANGE_KEY_REALM_NAME = "realmName";
	private static final String CHANGE_KEY_CUSTOM_PROPERTIES = "customProperties";
	private static final String CHANGE_KEY_SERVER_ID = "serverId";
	private static final String CHANGE_KEY_PRIMARY_ADMIN = "primaryAdminId";
	
    protected UserRealms parent;
    protected UserRealmType type;
    protected ConfigIdentifier configId;
    protected UserRealmSettings attributes;
    
    /**
     * Constructor
     * 
     * @param parent The {@link UserRealms} parent
     * @param type The type of realm that this is
     * @param configId The {@link ConfigIdentifier} of the realm
     */
    protected UserRealm(UserRealms parent, UserRealmType type, ConfigIdentifier configId) {
        this.parent = parent;
        this.type = type;
        this.configId = configId;
    }
    
    /**
     * Get the {@link UserRealms} parent of this class
     * 
     * @return The {@link UserRealms} parent
     */
    public UserRealms getUserRealms() {
        return this.parent;
    }
    
    /**
     * Get the type of user realm that this is
     * 
     * @return The user realm type
     */
    public UserRealmType getType() {
        return this.type;
    }
    
    /**
     * Get whether or not a case-insensitive authorization check is performed.
     * 
     * @return true if a case-insensitive authorization check is performed
     * @throws Exception
     */
    public boolean getIgnoreCase() throws Exception {
        if(getRealmAttributes().getIgnoreCase() == null) {
            Cell cell = parent.getSecurityDomain().getCell();
            AbstractSession session = cell.getWorkspace().getSession();
            String value = OperationsProviderFactory.getProvider().getConfigurationOperationsProvider().getAttribute(cell, session, configId, "ignoreCase").toString();
            if(!getUserRealms().getSecurityDomain().isAtLeast70() && value.equals("1"))
                value = "true";
            else if(!getUserRealms().getSecurityDomain().isAtLeast70() && value.equals("0"))
                value = "false";
            getRealmAttributes().setIgnoreCase(Boolean.valueOf(value.toString()));
        }
        return getRealmAttributes().getIgnoreCase();
    }
    
    /**
     * Set whether or not a case-insensitive authorization check is performed.
     * 
     * @param ignoreCase true to perform case-insensitive authorization checks
     * @throws Exception
     */
    public void setIgnoreCase(boolean ignoreCase) throws Exception {
        this.parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_IGNORE_CASE, getRealmAttributes().getIgnoreCase());

        UserRealmSettings settings = getEmptyAttributes();
        settings.setIgnoreCase(ignoreCase);
        parent.configureUserRealm(type, settings, false);
        getRealmAttributes().setIgnoreCase(ignoreCase);
    }
    
    /**
     * Get the name of the realm.
     * 
     * @return The name of the realm
     * @throws Exception
     */
    public String getRealm() throws Exception {
        if(getRealmAttributes().getRealmName() == null) {
            Cell cell = parent.getSecurityDomain().getCell();
            AbstractSession session = cell.getWorkspace().getSession();
            Object realm = OperationsProviderFactory.getProvider().getConfigurationOperationsProvider().getAttribute(cell, session, configId, "realm");
            if(realm != null)
                getRealmAttributes().setRealmName(realm.toString());
        }
        return getRealmAttributes().getRealmName();
    }

    /**
     * Set the name of the realm.
     * 
     * @param realmName The realm name to set
     * @throws Exception
     */
    public void setRealm(String realmName) throws Exception {
        this.parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_REALM_NAME, getRealmAttributes().getRealmName());

        UserRealmSettings settings = getEmptyAttributes();
        settings.setRealmName(realmName);
        parent.configureUserRealm(this.type, settings, false);
        getRealmAttributes().setRealmName(realmName);
    }
    
    /**
     * Get the custom properties for this user realm
     * 
     * @return The realm's custom properties
     * @throws Exception
     */
    public Map<String, String> getCustomProperties() throws Exception {
        if(getRealmAttributes().getCustomProperties() == null) {
            Map<String, String> customProperties = new HashMap<String, String>();
            List<ConfigObject> props = ConfigObject.getConfigObjectList(parent.getSecurityDomain().getCell(), configId, "Property");
            String name = null;
            String value = null;
            for(ConfigObject prop : props) {
                name = prop.getAttributeByName("name").getValueAsString();
                value = prop.getAttributeByName("value").getValueAsString();
                customProperties.put(name, value);
            }
            getRealmAttributes().setCustomProperties(customProperties);
        }
        return getRealmAttributes().getCustomProperties();
    }
    
    /**
     * Set a custom property for the user realm.
     *  
     * @param property The property name
     * @param value The property value
     * @throws Exception
     */
    public void setCustomProperty(String property, String value) throws Exception {
        this.parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_CUSTOM_PROPERTIES, getRealmAttributes().getCustomProperties());

        UserRealmSettings settings = getEmptyAttributes();
        Map<String, String> props = new HashMap<String, String>();
        props.put(property, value);
        settings.setCustomProperties(props);
        parent.configureUserRealm(this.type, settings, false);
        getCustomProperties().put(property, value);
    }
    
    /**
     * Remove a custom property
     * 
     * @param property The property to remove
     * @throws Exception
     */
    public void removeCustomProperty(String property) throws Exception {
        if(getCustomProperties().get(property) == null) {
            throw new Exception("No property with name " + property + " exists.");
        }

        this.parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_CUSTOM_PROPERTIES, getRealmAttributes().getCustomProperties());

        UserRealmSettings settings = getEmptyAttributes();
        Map<String, String> props = new HashMap<String, String>();
        props.put(property, null);
        settings.setCustomProperties(props);
        parent.configureUserRealm(this.type, settings, false);
        getCustomProperties().remove(property);
    }
    
    /**
     * Get the user identity in the repository that is used for internal process communication. This
     * value only exists for user realms in the global domain.
     * 
     * @return The server ID
     * @throws Exception
     */
    public String getServerId() throws Exception {
        if(getRealmAttributes().getServerId() == null) {
            Cell cell = parent.getSecurityDomain().getCell();
            AbstractSession session = cell.getWorkspace().getSession();
            Object serverId = OperationsProviderFactory.getProvider().getConfigurationOperationsProvider().getAttribute(cell, session, configId, "serverId");
            if(serverId != null) {
                getRealmAttributes().setServerId(serverId.toString());
            }
        }
        return getRealmAttributes().getServerId();
    }

    /**
     * Set the user identity in the repository that is used for internal process communication. This
     * value can only be set for a user realm in the global domain.
     * 
     * @param serverId The server ID to set
     * @throws Exception
     */
    public void setServerId(String serverId) throws Exception {
        if(!(this.parent.getSecurityDomain() instanceof GlobalSecurityDomain)) {
            throw new Exception("Server Id can only be set on a user registry in the global domain.");
        }

        this.parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_SERVER_ID, getRealmAttributes().getServerId());

        UserRealmSettings settings = getEmptyAttributes();
        settings.setServerId(serverId);
        parent.configureUserRealm(this.type, settings, false);
        getRealmAttributes().setServerId(serverId);
    }
    
    /**
     * Get the name of the user with administrative privileges that is defined in the repository,
     * for example, adminUser. This value only exists for a user realm in the global domain.
     * 
     * @return The primary admin ID
     * @throws Exception
     */
    public String getPrimaryAdminId() throws Exception {
        if(getRealmAttributes().getPrimaryAdminId() == null) {
            Cell cell = parent.getSecurityDomain().getCell();
            AbstractSession session = cell.getWorkspace().getSession();
            Object primaryAdminId = OperationsProviderFactory.getProvider().getConfigurationOperationsProvider().getAttribute(cell, session, configId, "primaryAdminId");
            if(primaryAdminId != null) {
                getRealmAttributes().setPrimaryAdminId(primaryAdminId.toString());
            }
        }
        return getRealmAttributes().getPrimaryAdminId();
    }

    /**
     * Set the name of the user with administrative privileges that is defined in the repository,
     * for example, adminUser. This value can only be set on user realms in the global domain.
     * 
     * @param primaryAdminId The primary admin Id to set
     * @throws Exception
     */
    public void setPrimaryAdminId(String primaryAdminId) throws Exception {
        if(!(this.parent.getSecurityDomain() instanceof GlobalSecurityDomain)) {
            throw new Exception("Server Id can only be set on a user registry in the global domain.");
        }

        this.parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_PRIMARY_ADMIN, getRealmAttributes().getPrimaryAdminId());

        UserRealmSettings settings = getEmptyAttributes();
        settings.setPrimaryAdminId(primaryAdminId);
        this.parent.configureUserRealm(this.type, settings, false);
        getRealmAttributes().setPrimaryAdminId(primaryAdminId);
    }
    
    /**
     * Get the attributes for this user realm
     * 
     * @return The realm's attributes
     */
    protected UserRealmSettings getRealmAttributes() {
        if(this.attributes == null) {
            this.attributes = getEmptyAttributes();
        }
        return this.attributes;
    }
    
    /**
     * Get an empty {@link UserRealmSettings} Object
     * 
     * @return An empty {@link UserRealmSettings} Object
     */
    protected UserRealmSettings getEmptyAttributes() {
        UserRealmSettings attributes = null;
        if(this.getUserRealms().getSecurityDomain() instanceof GlobalSecurityDomain) {
            if(this.type == UserRealmType.CustomUserRegistry) {
                attributes = new AdminCustomSettings();
            } else if(this.type == UserRealmType.LocalOSUserRegistry) {
                attributes = new AdminLocalOSSettings();
            } else if(this.type == UserRealmType.LDAPUserRegistry) {
                attributes = new AdminLDAPSettings();
            } else if(this.type == UserRealmType.WIMUserRegistry) {
                attributes = new AdminWIMSettings();
            }
        } else {
            if(this.type == UserRealmType.CustomUserRegistry) {
                attributes = new DomainCustomSettings();
            } else if(this.type == UserRealmType.LocalOSUserRegistry) {
                attributes = new DomainLocalOSSettings();
            } else if(this.type == UserRealmType.LDAPUserRegistry) {
                attributes = new DomainLDAPSettings();
            } else if(this.type == UserRealmType.WIMUserRegistry) {
                attributes = new DomainWIMSettings();
            }
        }
        return attributes;
    }
    
    public void commit(HashMap<String, Object> values) {
    }
    
    @SuppressWarnings("unchecked")
    public void rollback(HashMap<String, Object> values) {
        for(Map.Entry<String, Object> entry : values.entrySet()) {
        	String key = entry.getKey();
        	Object value = entry.getValue();
        	
            if(key.equals(CHANGE_KEY_IGNORE_CASE)) {
                getRealmAttributes().setIgnoreCase((Boolean)value);
            } else if(key.equals(CHANGE_KEY_REALM_NAME)) {
                getRealmAttributes().setRealmName((String)value);
            } else if(key.equals(CHANGE_KEY_CUSTOM_PROPERTIES)) {
                getRealmAttributes().setCustomProperties((Map)value);
            } else if(key.equals(CHANGE_KEY_SERVER_ID)) {
                getRealmAttributes().setServerId((String)value);
            } else if(key.equals(CHANGE_KEY_PRIMARY_ADMIN)) {
                getRealmAttributes().setPrimaryAdminId((String)value);
            }
        }
    }
    
}
