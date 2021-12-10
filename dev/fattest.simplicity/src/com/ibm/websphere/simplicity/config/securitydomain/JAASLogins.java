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

import com.ibm.websphere.simplicity.AbstractSession;
import com.ibm.websphere.simplicity.Cell;
import com.ibm.websphere.simplicity.ConfigIdentifier;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.config.ConfigObject;
import com.ibm.websphere.simplicity.config.Configurable;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;

/**
 * This is the parent class for specific JAAS login types such as {@link JAASSystemLogin}
 */
public abstract class JAASLogins extends SecurityDomainAttribute implements Configurable {
    
    private static final Class c = JAASLogins.class;
    private static final String CHANGE_KEY_LOGINS = "jaasLogins";

    protected Set<JAASLogin> jaasLogins;
    protected JAASLoginType type;
    
    /**
     * Constructor
     * 
     * @param parent The parent {@link SecurityDomain}
     * @param type The type of JAAS login that this is
     */
    protected JAASLogins(SecurityDomain parent, JAASLoginType type) {
        super(parent);
        this.type = type;
    }
    
    /**
     * Get a specific {@link JAASLogin}
     * 
     * @param alias The alias of the login to get
     * @return The requested {@link JAASLogin} or null if no JAAS login exists with the alias
     * @throws Exception
     */
    protected JAASLogin getJAASLoginByAlias(String alias) throws Exception {
        Set<JAASLogin> logins = getJAASLogins();
        if(logins != null) {
            for(JAASLogin l : logins) {
                if(l.getAlias().equals(alias)) {
                    return l;
                }
            }
        }
        return null;
    }
    
    /**
     * Get the JAASLogins for the domain
     * 
     * @return A Set of JAAS logins
     * @throws Exception
     */
    protected Set<JAASLogin> getJAASLogins() throws Exception {
        if(this.jaasLogins == null) {
            if(getSecurityDomain().isAtLeast70()) {
                Cell cell = getSecurityDomain().getCell();
                String name = getSecurityDomain().getName();
                AbstractSession session = cell.getWorkspace().getSession();
                Set<ConfigIdentifier> logins = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().getJAASLoginEntries(cell, name, this.type, session);
                if(logins != null) {
                    this.jaasLogins = new HashSet<JAASLogin>();
                    for(ConfigIdentifier login : logins) {
                        if(this.type == JAASLoginType.SYSTEM) {
                            this.jaasLogins.add(new JAASSystemLogin((JAASSystemLogins)this, login));
                        } else {
                            // application
                            this.jaasLogins.add(new JAASApplicationLogin((JAASApplicationLogins)this, login));
                        }
                    }
                }
            } else {
                List<ConfigObject> jaasLogins = getJAASLoginsConfigObject().getChildObjectsByDataType("JAASConfigurationEntry");
                if(jaasLogins.size() > 0) {
                    this.jaasLogins = new HashSet<JAASLogin>();
                    for(ConfigObject jaasLogin : jaasLogins) {
                        if(this.type == JAASLoginType.SYSTEM) {
                            this.jaasLogins.add(new JAASSystemLogin((JAASSystemLogins)this, jaasLogin.getConfigIdentifier()));
                        } else {
                            this.jaasLogins.add(new JAASApplicationLogin((JAASApplicationLogins)this, jaasLogin.getConfigIdentifier()));
                        }
                    }
                }
            }
        }
        return this.jaasLogins;
    }
    
    /**
     * Delete a JAAS login
     * 
     * @param alias The alias of the login to delete
     * @throws Exception
     */
    public void deleteJAASLogin(String alias) throws Exception {
        final String method = "deleteJAASLogin";
        Log.entering(c, method, alias);
        if(getJAASLoginByAlias(alias) == null) {
            throw new Exception("No JAAS login with alias " + alias + " exists.");
        }

        setLoginsShadow();
        
        if(getSecurityDomain().isAtLeast70()) {
            final Cell fcell = getSecurityDomain().getCell();
            final String falias = alias;
            final JAASLoginType ftype = this.type;
            final String fname = getSecurityDomain().getName();
            OperationsProviderFactory.getProvider().getSecurityOperationsProvider().unconfigureJAASLoginEntry(fcell, falias, ftype, fname, fcell.getActiveSession());
        } else {
            List<ConfigObject> entries = getJAASLoginsConfigObject().getChildObjectsByDataType("JAASConfigurationEntry");
            for(ConfigObject entry : entries) {
                if(entry.getAttributeByName("alias").getValueAsString().equals(alias)) {
                    entry.delete();
                    break;
                }
            }
        }
        
        this.jaasLogins.remove(getJAASLoginByAlias(alias));
        if(this.jaasLogins.size() == 0) {
            this.jaasLogins = null;
        }
        Log.exiting(c, method);
    }

    @Override
    public void useGlobalDomainSettings() throws Exception {
        final String method = "useGlobalDomainSettings";
        Log.entering(c, method);
        
        if(getSecurityDomain() instanceof GlobalSecurityDomain) {
            Log.finer(c, method, "This is the global security domain. Nothing to do.");
            Log.exiting(c, method);
            return;
        }
        
        setLoginsShadow();
        
        final Cell fcell = getSecurityDomain().getCell();
        final JAASLoginType ftype = this.type;
        final String fname = getSecurityDomain().getName();
        OperationsProviderFactory.getProvider().getSecurityOperationsProvider().unconfigureJAASLogin(fcell, ftype, fname, fcell.getActiveSession());
        this.jaasLogins = null;
        
        Log.exiting(c, method);
    }

    @Override
    public boolean globalSettingsInUse() throws Exception {
        return ((this.getSecurityDomain() instanceof GlobalSecurityDomain) || (getJAASLogins() == null));
    }

    protected OperationResults<Boolean> configureJAASLogin(String alias, List<String> loginModules) throws Exception {
        final String method = "createJAASLogin";
        Log.entering(c, method, new Object[]{alias, loginModules});
        
        setLoginsShadow();
        
        OperationResults<Boolean> results = new OperationResults<Boolean>();
        if(getSecurityDomain().isAtLeast70()) {
            final Cell fcell = getSecurityDomain().getCell();
            final String falias = alias;
            final JAASLoginType ftype = this.type;
            final String fname = getSecurityDomain().getName();
            final List<String> flist = loginModules;
            results = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().configureJAASLogin(fcell, falias, ftype, fname, flist, fcell.getActiveSession());
        } else {
            ConfigObject newEntry = ConfigObject.createConfigObject(getSecurityDomain().getCell(), "JAASConfigurationEntry", getJAASLoginsConfigObject());
            newEntry.getAttributeByName("alias").setValue(alias);
            results.setResult(true);
            results.setSuccess(true);
        }
        
        Log.exiting(c, method, results);
        return results;
    }
    
    protected void setLoginsShadow() throws Exception {
        Set<JAASLogin> tempLogins = null;
        Set<JAASLogin> logins = getJAASLogins();
        if(logins != null) {
            tempLogins = new HashSet<JAASLogin>(logins);
        }
        this.domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_LOGINS, tempLogins);
    }

    @SuppressWarnings("unchecked")
    public void rollback(HashMap<String, Object> values) {
        for(Map.Entry<String, Object> entry : values.entrySet()) {
        	String key = entry.getKey();
        	Object value = entry.getValue();
        	
            if(key.equals(CHANGE_KEY_LOGINS)) {
		        jaasLogins = (Set)value;
		    }
        }
    }

    public void commit(HashMap<String, Object> values) throws Exception {
    }
    
    protected ConfigObject getJAASLoginsConfigObject() throws Exception {
        List<ConfigObject> jaasLogins = null;
        if(this.type == JAASLoginType.SYSTEM) {
            jaasLogins = getSecurityDomain().getconfigObject().getChildObjectListByName("systemLoginConfig");
        } else {
            jaasLogins = getSecurityDomain().getconfigObject().getChildObjectListByName("applicationLoginConfig");
        }
        if(jaasLogins.size() > 0) {
            return jaasLogins.get(0);
        }
        throw new Exception("Unable to find the JAAS login configuration of type " + this.type);
    }
}
