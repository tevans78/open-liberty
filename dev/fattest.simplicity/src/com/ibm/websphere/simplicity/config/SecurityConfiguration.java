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

import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ibm.websphere.simplicity.Cell;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.WebSphereVersion;
import com.ibm.websphere.simplicity.config.securitydomain.GlobalSecurityDomain;
import com.ibm.websphere.simplicity.config.securitydomain.SecurityDomain;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.ConfigType;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;

public class SecurityConfiguration implements Configurable {
    
    private static final Class c = SecurityConfiguration.class;
    private static final String CHANGE_KEY_DOMAINS = "domains";
    
    private GlobalSecurityDomain globalDomain;
    private Set<SecurityDomain> securityDomains;
    private Cell cell = null;
    private WIMUserAndGroupConfiguration wimManagement;
    
    /**
     * Constructor
     * 
     * @param c The {@link Cell} to get the security configuration for
     * @throws Exception
     */
    public SecurityConfiguration(Cell c) throws Exception {
    	cell = c;
        wimManagement = new WIMUserAndGroupConfiguration(this);
    }
    
    /**
     * Get the security domains for a {@link Cell}. This method does not return the
     * {@link GlobalSecurityDomain}. Use the {@link #getGlobalSecurityDomain()} method to get the
     * global domain. Security domains provide a mechanism to use different security settings for
     * administrative applications and user applications. They also provide the ability to support
     * multiple security settings so different applications can use different security attributes
     * like user registry or login configurations.
     * 
     * @return A Set of security domains
     * @throws Exception
     */
    public Set<SecurityDomain> getSecurityDomains() throws Exception {
    	if (this.securityDomains == null) {
            this.securityDomains = new HashSet<SecurityDomain>();
            
            // 6.1 does not support domains, so we only complete the call if the target
            // is 7.0 or greater.  An empty set is returned for 6.1.
            WebSphereVersion version = this.getCell().getManager().getNode().getBaseProductVersion();
            if (version.compareToPartial(new WebSphereVersion("7.0")) >= 0) {
	    		List<ConfigObject> domains = ConfigObject.getConfigObjectList(this.cell, ConfigType.SECURITY_DOMAIN.getType(), false);
	            for(ConfigObject domain : domains) {
	                this.securityDomains.add(new SecurityDomain(this.cell, domain.getAttributeByName("name").getValueAsString(), domain.getAttributeByName("description").getValueAsString(), this));
	            }
            }
    	}
    	return new HashSet<SecurityDomain>(this.securityDomains);
    }
    
    /**
     * Get a specific security domain
     * 
     * @param name The name of the domain to get
     * @return The {@link SecurityDomain} with the name or null if no security domain with the name
     *         exists
     * @throws Exception
     */
    public SecurityDomain getSecurityDomainByName(String name) throws Exception {
        Set<SecurityDomain> domains = getSecurityDomains();
        for(SecurityDomain domain : domains) {
            if(domain.getName().equals(name)) {
                return domain;
            }
        }
        return null;
    }
    
    /**
     * Get the global security domain. This security configuration applies to the security policy
     * for all administrative functions and is used as a default security policy for user
     * applications. Security domains can be defined to override and customize the security policies
     * for user applications.
     * 
     * @return The {@link GlobalSecurityDomain}
     * @throws Exception
     */
    public GlobalSecurityDomain getGlobalSecurityDomain() throws Exception {
        if(this.globalDomain == null) {
            this.globalDomain = new GlobalSecurityDomain(this.cell, this);
        }
        return this.globalDomain;
    }
    
    /**
     * Create a security domain. Security domains provide a mechanism to use different security
     * settings for administrative applications and user applications. They also provide the ability
     * to support multiple security settings so different applications can use different security
     * attributes like user registry or login configurations.
     * 
     * @param name The name of the domain to create
     * @param description An optional description for the new domain
     * @return An {@link OperationResults} containing the newly created {@link SecurityDomain}
     * @throws Exception
     */
    public OperationResults<SecurityDomain> createSecurityDomain(String name, String description) throws Exception {
        final String method = "createSecurityDomain";
        Log.entering(c, method, new Object[]{name, description});
        
        if(getSecurityDomainByName(name) != null) {
            throw new Exception("A security domain with name " + name + " already exists.");
        }
        
        this.cell.getWorkspace().registerConfigChange(this, CHANGE_KEY_DOMAINS, getSecurityDomains());
        
        OperationResults<Boolean> results = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().createSecurityDomain(cell, name, description, cell.getActiveSession());
        
        OperationResults<SecurityDomain> ret = new OperationResults<SecurityDomain>();
        OperationResults.setOperationResults(ret, results);
        SecurityDomain domain = new SecurityDomain(this.cell, name, description, this);
        ret.setResult(domain);
        this.addSecurityDomain(domain);
        
        Log.exiting(c, method, results.getResult());
        return ret;
    }

    /**
     * Delete a security domain.
     * 
     * @param name The name of the domain to delete
     * @throws Exception
     */
    public void deleteSecurityDomain(String name) throws Exception {
        final String method = "deleteSecurityDomain";
        Log.entering(c, method, name);
        SecurityDomain domain  = getSecurityDomainByName(name);
        if(domain == null) {
            throw new Exception("No security domain exists with name " + name + ".");
        }
        if(domain.getMappedScopes().size() > 0) {
            throw new Exception("A security domain with mapped resources cannot be deleted. Remove all scopes from the domain before deleting.");
        }
        
        this.cell.getWorkspace().registerConfigChange(this, CHANGE_KEY_DOMAINS, getSecurityDomains());

        OperationsProviderFactory.getProvider().getSecurityOperationsProvider().deleteSecurityDomain(cell, name, false, cell.getActiveSession());
        if(this.securityDomains == null) {
            getSecurityDomains();
        }
        this.securityDomains.remove(domain);
        Log.exiting(c, method);
    }
    
    /**
     * Create a new security domain by copying an existing domain.
     * 
     * @param name The name of the domain to create
     * @param description An optional description for the domain
     * @param realmName The realm name for the new domain
     * @param sourceName The name of the domain to copy
     * @return An {@link OperationResults} containing the newly created security domain
     * @throws Exception
     */
    public OperationResults<SecurityDomain> copySecurityDomain(String name, String description, String realmName, String sourceName) throws Exception {
        final String method = "copySecurityDomain";
        Log.entering(c, method, new Object[]{name, description, realmName, sourceName});
        
        if(getSecurityDomainByName(sourceName) == null) {
            throw new Exception("There is no domain with name " + sourceName + ". You must specify a name of an existing security domain to copy from.");
        }
        if(getSecurityDomainByName(name) != null) {
            throw new Exception("A security domain with name " + name + " already exists.");
        }

        this.cell.getWorkspace().registerConfigChange(this, CHANGE_KEY_DOMAINS, getSecurityDomains());

        OperationResults<Boolean> results = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().copySecurityDomain(cell, name, description, sourceName, realmName, cell.getActiveSession());
        
        OperationResults<SecurityDomain> ret = new OperationResults<SecurityDomain>();
        OperationResults.setOperationResults(ret, results);
        SecurityDomain domain = new SecurityDomain(this.cell, name, description, this);
        ret.setResult(domain);
        this.addSecurityDomain(domain);
        Log.exiting(c, method, results.getResult());
        return ret;
    }

    /**
     * Create a security domain by copying the {@link GlobalSecurityDomain}.
     * 
     * @param name The name of the new domain
     * @param description An optional description for the domain
     * @param realmName The realm name for the domain
     * @return An {@link OperationResults} containing the new {@link SecurityDomain}
     * @throws Exception
     */
    public OperationResults<SecurityDomain> copyGlobalSecurityDomain(String name, String description, String realmName) throws Exception {
        final String method = "copySecurityDomain";
        Log.entering(c, method, new Object[]{name, description, realmName});
        
        if(getSecurityDomainByName(name) != null) {
            throw new Exception("A security domain with name " + name + " already exists.");
        }

        this.cell.getWorkspace().registerConfigChange(this, CHANGE_KEY_DOMAINS, getSecurityDomains());

        OperationResults<Boolean> results = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().copyGlobalDomain(cell, name, description, realmName, cell.getActiveSession());
        OperationResults<SecurityDomain> ret = new OperationResults<SecurityDomain>();
        OperationResults.setOperationResults(ret, results);
        SecurityDomain domain = new SecurityDomain(this.cell, name, description, this);
        ret.setResult(domain);
        this.addSecurityDomain(domain);
        Log.exiting(c, method, results.getResult());
        return ret;
    }
    
    public Cell getCell() {
        return this.cell;
    }
    
    /**
     * Get the {@link WIMUserAndGroupConfiguration} Object. This Object can
     * be used to manager WIM users and groups.
     * 
     * @return A {@link WIMUserAndGroupConfiguration}
     */
    public WIMUserAndGroupConfiguration getWIMUserAndGroupConfiguration() {
        return this.wimManagement;
    }

    public void commit(HashMap<String, Object> values) throws Exception {
    }

    @SuppressWarnings("unchecked")
    public void rollback(HashMap<String, Object> values) throws Exception {
        for(Map.Entry<String, Object> entry : values.entrySet()) {
        	String key = entry.getKey();
        	Object value = entry.getValue();
        	
            if(key.equals(CHANGE_KEY_DOMAINS)) {
                this.securityDomains = (Set)value;
            }
        }
    }
    
    private void addSecurityDomain(SecurityDomain domain) throws Exception {
        if(this.securityDomains == null) {
            getSecurityDomains();
        }
        if(!this.securityDomains.contains(domain)) {
            this.securityDomains.add(domain);
        }
    }
}
