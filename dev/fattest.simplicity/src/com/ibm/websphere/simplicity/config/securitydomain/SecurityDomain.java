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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ibm.websphere.simplicity.AdminAgent;
import com.ibm.websphere.simplicity.ApplicationServer;
import com.ibm.websphere.simplicity.Cell;
import com.ibm.websphere.simplicity.Cluster;
import com.ibm.websphere.simplicity.Dmgr;
import com.ibm.websphere.simplicity.JobManager;
import com.ibm.websphere.simplicity.Node;
import com.ibm.websphere.simplicity.NodeAgent;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.ServerType;
import com.ibm.websphere.simplicity.SubSystem;
import com.ibm.websphere.simplicity.WebSphereVersion;
import com.ibm.websphere.simplicity.config.ConfigObject;
import com.ibm.websphere.simplicity.config.Configurable;
import com.ibm.websphere.simplicity.config.SecurityConfiguration;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;
import com.ibm.websphere.simplicity.provider.websphere.config.securitydomain.ActiveSecuritySettingsWrapper;

/**
 * This class represents a WebSphere security domain. Security domains provide a mechanism to use
 * different security settings for administrative applications and user applications. They also
 * provide the ability to support multiple security settings so different applications can use
 * different security attributes like user registry or login configurations. This class contains
 * methods to retrieve and configure the domain attributes that are generic to all security domains.
 * Attributes specific to the global security domain can be set using the
 * {@link GlobalSecurityDomain} Object, available via
 * {@link SecurityConfiguration#getGlobalSecurityDomain()}
 */
public class SecurityDomain implements Configurable {
    
    private static final Class c = SecurityDomain.class;
    private static final String CHANGE_KEY_ACTIVE_SECURITY_SETTINGS = "activeSecuritySettings";
    private static final String CHANGE_KEY_MAPPED_SCOPES = "mappedScopes";
	
	protected Cell cell;
	protected String name;
	protected String description;
    protected SecurityConfiguration parent;
	protected Set<Scope> scopes;
    protected Map<String, String> customProperties;
    protected ActiveSecuritySettingsWrapper activeSecuritySettings;
    protected ConfigObject configObject; // for 6.1 security
    
	// Security settings
	protected ApplicationSecurity app = new ApplicationSecurity(this);
	protected Java2Security java2 = new Java2Security(this);
	protected UserRealms realm = new UserRealms(this);
	protected TrustAssociation trust = new TrustAssociation(this);
	protected JAASApplicationLogins jaasApp = new JAASApplicationLogins(this);
	protected JAASSystemLogins jaasSys = new JAASSystemLogins(this);
	protected AuthMechanismAttributes authAttribs = new AuthMechanismAttributes(this);
	protected AuthorizationConfig authorizationConfig = new AuthorizationConfig(this);
    protected JAASJ2CAuthenticationData j2cAuthData = new JAASJ2CAuthenticationData(this);
    protected RMI_IIOP rmi_iiop = new RMI_IIOP(this);
	
    /**
     * Constructor to create the global security domain
     * 
     * @param cell The {@link Cell} of the domain
     * @param parent The {@link SecurityConfiguration} of the domain
     */
	public SecurityDomain(Cell cell, SecurityConfiguration parent) {
		this.cell = cell;
        this.parent = parent;
	}
	
    /**
     * Constructor to create a security domain
     * 
     * @param cell The {@link Cell} of the domain
     * @param name The domain name
     * @param description The domain description
     * @param parent The {@link SecurityConfiguration} of the domain
     */
	public SecurityDomain(Cell cell, String name, String description, SecurityConfiguration parent) {
		this.cell = cell;
		this.name = name;
        this.description = description;
        this.parent = parent;
	}
	
    /**
     * Get the {@link Cell} that this domain belongs to
     * 
     * @return The Cell of the domain
     */
	public Cell getCell() {
		return this.cell;
	}
    
    /**
     * Get the {@link SecurityConfiguration} parent for this domain
     * 
     * @return The {@link SecurityConfiguration} that this domain belongs to
     */
    public SecurityConfiguration getSecurityConfiguration() {
        return this.parent;
    }
    
    /**
     * Get the currently active security settings for this domain.
     * 
     * @return An {@link ActiveSecuritySettingsWrapper} containing the security settings for this
     *         domain.
     * @throws Exception
     */
    protected ActiveSecuritySettingsWrapper getActiveSecuritySettings() throws Exception {
        final String method = "getActiveSecuritySettings";
        Log.entering(c, method);
        if(this.activeSecuritySettings == null) {
            if(this instanceof GlobalSecurityDomain && this.isAtLeast70()) {
                Log.finer(c, method, "Loading global domain active security settings.");
                this.activeSecuritySettings = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().getGlobalActiveSecuritySettings(this.cell, this.cell.getWorkspace().getSession());
            } else if(this instanceof GlobalSecurityDomain) {
                // get the information the 6.1 way for the global domain
                Log.finer(c, method, "This is a 6.1 version or earlier Cell. Need to use the ConfigObject api to get security information.");
                this.activeSecuritySettings = getSecuritySettingsFromConfig(); 
            } else { // this is a 7.0 app security domain
                Log.finer(c, method, "Loading domain specific active security settings.");
                this.activeSecuritySettings = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().getDomainActiveSecuritySettings(this.cell, this.name, this.cell.getWorkspace().getSession());
            } 
        }
        Log.exiting(c, method, this.activeSecuritySettings);
        return this.activeSecuritySettings;
    }
    
    /**
     * Get the active security settings using ConfigObject. This is neede for WAS 6.1 and earlier.
     * We can reliably do it this way since there is only a single Security config Object in earlier
     * versions.
     * 
     * @return The {@link ActiveSecuritySettingsWrapper} for the Global domain
     * @throws Exception
     */
    protected ActiveSecuritySettingsWrapper getSecuritySettingsFromConfig() throws Exception {
        final String method = "getSecuritySettingsFromConfig";
        Log.entering(c, method);
        
        getconfigObject();
        ActiveSecuritySettingsWrapper settings = new ActiveSecuritySettingsWrapper();
        settings.setEnableGlobalSecurity(this.configObject.getAttributeByName("enabled").getValueAsBoolean());
        ConfigObject activeRegistryRef = this.configObject.getAttributeByName("activeUserRegistry");
        String registryConfigId = activeRegistryRef.getValue().toString();
        List<ConfigObject> registries = this.configObject.getChildObjectsByDataType("UserRegistry");
        for(ConfigObject registry : registries) {
            if(registry.getConfigIdentifier().toString().equals(registryConfigId)) {
                settings.setActiveUserRegistry(registry.getMetadata().getDataType());
                break;
            }
        }
        settings.setAppSecurityEnabled(this.configObject.getAttributeByName("appEnabled").getValueAsBoolean());
        settings.setCacheTimeout(this.configObject.getAttributeByName("cacheTimeout").getValueAsInt());
        settings.setDynUpdateSSLConfig(this.configObject.getAttributeByName("dynamicallyUpdateSSLConfig").getValueAsBoolean());
        settings.setEnforceFineGrainedJCASecurity(this.configObject.getAttributeByName("enforceFineGrainedJCASecurity").getValueAsBoolean());
        settings.setEnforceJava2Security(this.configObject.getAttributeByName("enforceJava2Security").getValueAsBoolean());
        settings.setIssuePermissionWarning(this.configObject.getAttributeByName("issuePermissionWarning").getValueAsBoolean());
        settings.setUseDomainQualifiedUserNames(this.configObject.getAttributeByName("useDomainQualifiedUserNames").getValueAsBoolean());
        // custom properties
        Map<String, String> customProperties = new HashMap<String, String>();
        List<ConfigObject> customProps = this.configObject.getChildObjectsByDataType("Property");
        for(ConfigObject customProp : customProps) {
            customProperties.put(customProp.getAttributeByName("name").getValueAsString(), customProp.getAttributeByName("value").getValueAsString());
        }
        settings.setCustomProperties(customProperties);
        
        Log.exiting(c, method, settings);
        return settings;
    }
    
    /**
     * Update the active security settings for this domain using the specified settings.
     * 
     * @param settings An {@link ActiveSecuritySettingsWrapper} containing the settings to use.
     * @throws Exception
     */
    protected void applyActiveSecuritySettings(ActiveSecuritySettingsWrapper settings) throws Exception {
        final String method = "applyActiveSecuritySettings";
        Log.entering(c, method, settings);
        
        setActiveSecuritySettingsDirty();
        
        if(this instanceof GlobalSecurityDomain && this.isAtLeast70()) {
            Log.finer(c, method, "Setting the active security settings for the global domain.");
            OperationsProviderFactory.getProvider().getSecurityOperationsProvider().setAdminActiveSecuritySettings(getCell(), settings, getCell().getActiveSession());
        } else if(this instanceof GlobalSecurityDomain) {
            Log.finer(c, method, "This is a 6.1 or earlier global domain. Set the data using ConfigObject.");
            applySettingsUsingAdminConfig(settings);
        } else { // 7.0 app domain
            Log.finer(c, method, "Setting the active security settings for the domain " + this.getName() + ".");
            OperationsProviderFactory.getProvider().getSecurityOperationsProvider().setAppActiveSecuritySettings(getCell(), getName(), settings, getCell().getActiveSession());
        }
        
        if(settings.getActiveAuthMechanism() != null) {
            activeSecuritySettings.setActiveAuthMechanism(settings.getActiveAuthMechanism());
        }
        if(settings.getActiveUserRegistry() != null) {
            activeSecuritySettings.setActiveUserRegistry(settings.getActiveUserRegistry());
        }
        if(settings.getAdminPreferredAuthMech() != null) {
            activeSecuritySettings.setAdminPreferredAuthMech(settings.getAdminPreferredAuthMech());
        }
        if(settings.getAppSecurityEnabled() != null) {
            activeSecuritySettings.setAppSecurityEnabled(settings.getAppSecurityEnabled());
        }
        if(settings.getCacheTimeout() != null) {
            activeSecuritySettings.setCacheTimeout(settings.getCacheTimeout());
        }
        if(settings.getCustomProperties() != null) {
            if(activeSecuritySettings.getCustomProperties() == null) {
                activeSecuritySettings.setCustomProperties(new HashMap<String, String>());
            }
            Map<String, String> props = settings.getCustomProperties();
            for(String prop : props.keySet()) {
                if(props.get(prop) == null) {
                    activeSecuritySettings.getCustomProperties().remove(prop);
                } else {
                    activeSecuritySettings.getCustomProperties().put(prop, props.get(prop));
                }
            }
        }
        if(settings.getDynUpdateSSLConfig() != null) {
            activeSecuritySettings.setDynUpdateSSLConfig(settings.getDynUpdateSSLConfig());
        }
        if(settings.getEnableGlobalSecurity() != null) {
            activeSecuritySettings.setEnableGlobalSecurity(settings.getEnableGlobalSecurity());
        }
        if(settings.getEnforceFineGrainedJCASecurity() != null) {
            activeSecuritySettings.setEnforceFineGrainedJCASecurity(settings.getEnforceFineGrainedJCASecurity());
        }
        if(settings.getEnforceJava2Security() != null) {
            activeSecuritySettings.setEnforceJava2Security(settings.getEnforceJava2Security());
        }
        if(settings.getIssuePermissionWarning() != null) {
            activeSecuritySettings.setIssuePermissionWarning(settings.getIssuePermissionWarning());
        }
        if(settings.getUseDomainQualifiedUserNames() != null) {
            activeSecuritySettings.setUseDomainQualifiedUserNames(settings.getUseDomainQualifiedUserNames());
        }
        
        Log.exiting(c, method);
    }
    
    protected void applySettingsUsingAdminConfig(ActiveSecuritySettingsWrapper settings) throws Exception {
        final String method = "applySettingsUsingAdminConfig";
        Log.entering(c, method, settings);
        
        getconfigObject();
        if(settings.getActiveUserRegistry() != null) {
            ConfigObject activeRegistryRef = this.configObject.getAttributeByName("activeUserRegistry");
            List<ConfigObject> registries = this.configObject.getChildObjectsByDataType("UserRegistry");
            for (ConfigObject reg : registries) {
                if (reg.getMetadata().getDataType().equals(settings.getActiveUserRegistry())) {
                    activeRegistryRef.setValue(reg);
                    break;
                }
            }
        }
        if(settings.getAppSecurityEnabled() != null) {
            this.configObject.getAttributeByName("appEnabled").setValue(settings.getAppSecurityEnabled());
        }
        if(settings.getCacheTimeout() != null) {
            this.configObject.getAttributeByName("cacheTimeout").setValue(settings.getCacheTimeout());
        }
        if(settings.getCustomProperties() != null) {
            List<ConfigObject> currentProps = this.configObject.getChildObjectsByDataType("Property");
            Map<String, String> propsToSet = new HashMap<String, String>(settings.getCustomProperties());
            String name = null;
            ConfigObject value = null;
            ConfigObject next = null;
            // an alternative would be to loop through propsToSet and compare.
            // this would make a little more sense but it's easier to compare a List of ConfigObjects
            // to a Map of strings than the other way around
            for(ConfigObject current : currentProps) {
                name = current.getAttributeByName("name").getValueAsString();
                value = current.getAttributeByName("value");
                if(propsToSet.containsKey(name)) {
                    if(propsToSet.get(name) == null) {
                        // property has been deleted
                        current.delete();
                    } else if(!value.getValueAsString().equals(propsToSet.get(name))) {
                        // value has changed
                        value.setValue(propsToSet.get(name));
                    } // else they set the property with the same value as before
                    propsToSet.remove(name); // we're done with it
                } // property not being altered
            }
            // anything left over is new
            for(String newProp : propsToSet.keySet()) {
                next = ConfigObject.createConfigObject(this.cell, "Property", this.configObject);
                next.getAttributeByName("name").setValue(newProp);
                next.getAttributeByName("value").setValue(propsToSet.get(newProp));
                next.getAttributeByName("required").setValue(false);
            }
        }
        if(settings.getDynUpdateSSLConfig() != null) {
            this.configObject.getAttributeByName("dynamicallyUpdateSSLConfig").setValue(settings.getDynUpdateSSLConfig());
        }
        if(settings.getEnableGlobalSecurity() != null) {
            this.configObject.getAttributeByName("enabled").setValue(settings.getEnableGlobalSecurity());
        }
        if(settings.getEnforceFineGrainedJCASecurity() != null) {
            this.configObject.getAttributeByName("enforceFineGrainedJCASecurity").setValue(settings.getEnforceFineGrainedJCASecurity());
        }
        if(settings.getEnforceJava2Security() != null) {
            this.configObject.getAttributeByName("enforceJava2Security").setValue(settings.getEnforceJava2Security());
        }
        if(settings.getIssuePermissionWarning() != null) {
            this.configObject.getAttributeByName("issuePermissionWarning").setValue(settings.getIssuePermissionWarning());
        }
        if(settings.getUseDomainQualifiedUserNames() != null) {
            this.configObject.getAttributeByName("useDomainQualifiedUserNames").setValue(settings.getUseDomainQualifiedUserNames());
        }
        
        Log.exiting(c, method);
    }
    
    /**
     * Unset the active security settings for a specific security attribute class. This will remove
     * the settings from the domain and revert to the global domain settings for the security
     * attribute.
     * 
     * @param securityAttribute The Class of the security attribute to unset
     * @throws Exception
     */
    protected void unsetAppActiveSecuritySettings(Class securityAttribute) throws Exception {
        final String method = "unsetAppActiveSecuritySettings";
        Log.entering(c, method, securityAttribute);
        
        setActiveSecuritySettingsDirty();
        
        if(!(this instanceof GlobalSecurityDomain)) {
            Log.finer(c, method, "Unsetting the active security settings for the domain " + this.getName() + ".");
            OperationsProviderFactory.getProvider().getSecurityOperationsProvider().unsetAppActiveSecuritySettings(getCell(), getName(), securityAttribute, getCell().getActiveSession());
            
            if(securityAttribute.equals(AuthMechanismAttributes.class)) {
                activeSecuritySettings.setCacheTimeout(null);
                activeSecuritySettings.setUseDomainQualifiedUserNames(null);
            } else if(securityAttribute.equals(ApplicationSecurity.class)) {
                activeSecuritySettings.setAppSecurityEnabled(null);
            } else if(securityAttribute.equals(Java2Security.class)) {
                activeSecuritySettings.setEnforceJava2Security(null);
                activeSecuritySettings.setIssuePermissionWarning(null);
                activeSecuritySettings.setEnforceFineGrainedJCASecurity(null);
            } else if(securityAttribute.equals(UserRealms.class)) {
                activeSecuritySettings.setActiveUserRegistry(null);
            }
        } else {
            throw new Exception("Cannot unset the active security domain settings for the global domain.");
        }
        
        Log.exiting(c, method);
    }
    
    protected void setActiveSecuritySettingsDirty() throws Exception {
        ActiveSecuritySettingsWrapper temp = getActiveSecuritySettings().clone();
        this.cell.getWorkspace().registerConfigChange(this, CHANGE_KEY_ACTIVE_SECURITY_SETTINGS, temp);
    }
	
    /**
     * Get the description for this domain
     * 
     * @return The description or null if this is the {@link GlobalSecurityDomain}
     */
	public String getDescription() {
		return this.description;
	}
	
    /**
     * Get the name for this domain
     * 
     * @return The domain name or null if this is the {@link GlobalSecurityDomain}
     */
	public String getName() {
		return this.name;
	}
	
    /**
     * Map a {@link Scope} (resource) to a security domain. This method does nothing if this is the
     * {@link GlobalSecurityDomain}. Not all Scopes are valid to be mapped to a domain. Use the
     * {@link #isValidScope(Scope)} method to determine if a Scope is valid.
     * 
     * @param s The scope to map to the domain
     * @throws Exception
     */
	public void mapScopeToDomain(Scope s) throws Exception {
        final String method = "mapScopeToDomain";
        Log.entering(c, method, s);
        
        if(!isValidScope(s)) {
            throw new Exception("The scope is not valid to map to this domain.");
        }
        
        if(this instanceof GlobalSecurityDomain) {
            Log.finer(c, method, "This is the global domain. Nothing to do.");
            Log.exiting(c, method);
            return;
        }
        
        this.cell.getWorkspace().registerConfigChange(this, CHANGE_KEY_MAPPED_SCOPES, getMappedScopes());
        
        OperationsProviderFactory.getProvider().getSecurityOperationsProvider().mapResourceToSecurityDomain(s, getResourceMapString(s), getName(), s.getActiveSession());
        getMappedScopes().add(s);
        Log.exiting(c, method);
	}
    
    /**
     * Remove a mapped {@link Scope} from the domain
     * 
     * @param s The scope to remove
     * @throws Exception
     */
    public void removeScopeFromDomain(Scope s) throws Exception {
        final String method = "removeScopeFromDomain";
        Log.entering(c, method, s);
        
        if(!getMappedScopes().contains(s)) {
            throw new Exception("Scope " + s.getName() + " is not mapped to this domain.");
        }
        
        this.cell.getWorkspace().registerConfigChange(this, CHANGE_KEY_MAPPED_SCOPES, getMappedScopes());

        OperationsProviderFactory.getProvider().getSecurityOperationsProvider().removeResourceFromSecurityDomain(s, getResourceMapString(s), getName(), s.getActiveSession());
        
        getMappedScopes().remove(s);
        Log.exiting(c, method);
    }
    
    /**
     * Return a String representation of the Scope that can be passed to the AdminTask used to map
     * and remove a scope from a domain
     * 
     * @param s The scope to get the resource STring for
     * @return A String representation of the Scope that can be passed to the AdminTask used to map
     *         and remove a scope from a domain
     */
    protected String getResourceMapString(Scope s) {
        if(s instanceof ApplicationServer) {
            ApplicationServer server = (ApplicationServer)s;
            return "Cell=" + server.getCellName() + ":Node=" + server.getNode().getName() + ":Server=" + server.getName();
        } else if(s instanceof Cluster) {
            Cluster cluster = (Cluster)s;
            return "Cell=" + cluster.getCell().getName() + ":ServerCluster=" + cluster.getName();
        } else {
            return "Cell=" + ((Cell)s).getName();
        }
    }
    
    /**
     * Get the scopes that are mapped to this security domain. If this is the
     * {@link GlobalSecurityDomain}, this method returns null. All scopes belong to the global
     * domain.
     * 
     * @return The scopes mapped to this domain or null if this is the {@link GlobalSecurityDomain}
     * @throws Exception
     */
    public Set<Scope> getMappedScopes() throws Exception {
        final String method = "getMappedScopes";
        Log.entering(c, method);
        
        if(this.scopes == null && !(this instanceof GlobalSecurityDomain)) {
            this.scopes = new HashSet<Scope>();
            List<String> resources = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().listResourcesInDomain(this.cell, getName(), this.cell.getWorkspace().getSession());
            for(String resource : resources) {
                if(resource.indexOf("Server=") != -1) {
                    Log.finer(c, method, "Adding a server scope.");
                    String start = "Cell=" + this.cell.getName() + ":Node=";
                    String end = ":Server=";
                    String nodeName = resource.substring(start.length(), resource.indexOf(end));
                    Node node = this.cell.getNodeByName(nodeName);
                    String serverName = resource.substring(resource.indexOf(end) + end.length());
                    this.scopes.add(node.getServerByName(serverName));
                } else if(resource.indexOf("Cluster=") != -1) {
                    Log.finer(c, method, "Adding a cluster scope.");
                    String clusterName = resource.substring(resource.indexOf("Cluster=") + "Cluster=".length());
                    this.scopes.add(this.cell.getClusterByName(clusterName));
                } else if(resource.equals("Cell=" + this.cell.getName())){
                    Log.finer(c, method, "Adding a cell scope.");
                    this.scopes.add(this.cell);
                } else {
                    // TODO add additional scopes such as SIBus
                    Log.finer(c, method, "Encountered a mapped resource that is not yet implemented: " + resource);
                }
            }
        }
        
        Log.exiting(c, method, this.scopes);
        return this.scopes;
    }
    
    /**
     * Get the application security attributes for this domain
     * 
     * @return An {@link ApplicationSecurity} Object
     */
	public ApplicationSecurity getApplicationSecurity() {
		return this.app;
	}
	
    /**
     * Get the Java 2 Security attributes for this domain
     * 
     * @return A {@link Java2Security} Object
     */
	public Java2Security getJava2Security() {
		return this.java2;
	}
	
    /**
     * Get the user realms for this domain
     * 
     * @return A {@link UserRealms} Object
     */
	public UserRealms getUserRealms() {
		return this.realm;
	}
	
    /**
     * Get the trust association attributes for this domain
     * 
     * @return A {@link TrustAssociation} Object
     */
	public TrustAssociation getTrustAssociation() {
		return this.trust;
	}
    
    /**
     * Get the JAAS application logins for this domain
     * 
     * @return A {@link JAASApplicationLogins} Object
     */
	public JAASApplicationLogins getJAASApplicationLogins() {
		return this.jaasApp;
	}
	
    /**
     * Get the JAAS system logins for this domain
     * 
     * @return A {@link JAASSystemLogins} Object
     */
	public JAASSystemLogins getJAASSystemLogins() {
		return this.jaasSys;
	}
	
    /**
     * Get the authentication mechanism attribute for this domain
     * 
     * @return An {@link AuthMechanismAttributes} Object
     */
	public AuthMechanismAttributes getAuthMechanismAttributes() {
		return this.authAttribs;
	}
	
    /**
     * Get the authorization attributes for this domain
     * 
     * @return An {@link AuthorizationConfig} Object
     */
	public AuthorizationConfig getAuthorizationConfig() {
		return this.authorizationConfig;
	}
	
    /**
     * Get the JAAS J2C authentication data for this domain
     * 
     * @return A {@link JAASJ2CAuthenticationData} Object
     */
    public JAASJ2CAuthenticationData getJAASJ2CAuthenticationData() {
        return this.j2cAuthData;
    }
    
    /**
     * Get the RMI/IIOP communications settings for this domain
     * 
     * @return An {@link RMI_IIOP} Object
     */
    public RMI_IIOP getRMI_IIOPConfiguration() {
        return this.rmi_iiop;
    }
    
    /**
     * Get the custom properties for this domain.
     * 
     * @return The custom properties
     * @throws Exception
     */
    public Map<String, String> getCustomProperties() throws Exception {
        return getActiveSecuritySettings().getCustomProperties();
    }
    
    /**
     * Set a custom property
     * 
     * @param property The property name
     * @param value The property value
     * @throws Exception
     */
    public void setCustomProperty(String property, String value) throws Exception {
        Map<String, String> customProperties = new HashMap<String, String>();
        customProperties.put(property, value);
        setCustomProperties(customProperties);
    }
    
    /**
     * Remove a custom property
     * 
     * @param property The property to remove
     * @throws Exception
     */
    public void removeCustomProperty(String property) throws Exception {
        if(getCustomProperties().get(property) == null) {
            throw new Exception("Custom property " + property + " does not exist.");
        }
        Map<String, String> customProperties = new HashMap<String, String>();
        customProperties.put(property, null);
        setCustomProperties(customProperties);
    }
    
    /**
     * Set the custom properties for the domain. Use a null value to remove a property. Existing
     * custom properties not in the Map are not affected.
     * 
     * @param customProperties The custom properties to set
     * @throws Exception
     */
    public void setCustomProperties(Map<String, String> customProperties) throws Exception {
        final String method = "setCustomProperties";
        Log.entering(c, method, customProperties);
        
        setActiveSecuritySettingsDirty();
        
        ActiveSecuritySettingsWrapper settings = new ActiveSecuritySettingsWrapper();
        settings.setCustomProperties(customProperties);
        applyActiveSecuritySettings(settings);
        
        Log.exiting(c, method);
    }
    
    // TODO Update this javadoc after implementing SIBus's
    /**
     * Returns true if the {@link Scope} can be mapped to a security domain. Valid scopes are
     * {@link Cell}s, {@link ApplicationServer}s that are not the {@link Dmgr}, {@link NodeAgent},
     * {@link JobManager}, {@link AdminAgent}, or a {@link SubSystem} and are not part of a
     * {@link Cluster}, and Service Integration Buses (not yet implemented)
     * 
     * @param s The Scope to check
     * @return true if the scope is valid for a domain, false otherwise
     * @throws Exception
     */
	public boolean isValidScope(Scope s) throws Exception {
		boolean valid = (s instanceof Cell || s instanceof ApplicationServer || s instanceof Cluster);
		if (!valid)
			return false;
		if (s instanceof ApplicationServer) {
			ApplicationServer server = (ApplicationServer)s;
            if(server.getServerType() != ServerType.APPLICATION_SERVER) {
                return false;
            }
			if (server.getClusters().size() > 0)
				return false;
		}
		
		return true;
	}
	
    public void commit(HashMap<String, Object> values) throws Exception {
    }
    
    @SuppressWarnings("unchecked")
    public void rollback(HashMap<String, Object> values) throws Exception {
        final String method = "rollback";
        Log.entering(c, method);
        
        for(Map.Entry<String, Object> entry : values.entrySet()) {
        	String key = entry.getKey();
        	Object value = entry.getValue();
        	
            if(key.equals(CHANGE_KEY_ACTIVE_SECURITY_SETTINGS)) {
                this.activeSecuritySettings = (ActiveSecuritySettingsWrapper)value;
            } else if(key.equals(CHANGE_KEY_MAPPED_SCOPES)) {
                this.scopes = (Set)value;
            }
        }
        
        Log.exiting(c, method);
    }
    
    protected ConfigObject getconfigObject() throws Exception {
        if(this.configObject == null) {
            this.configObject = ConfigObject.getConfigObject(this.cell, null, "Security");
        }
        return this.configObject;
    }
    
    protected boolean isAtLeast70() throws Exception {
        return this.cell.getManager().getNode().getBaseProductVersion().compareToPartial(new WebSphereVersion("7.0")) >= 0;
    }
}
