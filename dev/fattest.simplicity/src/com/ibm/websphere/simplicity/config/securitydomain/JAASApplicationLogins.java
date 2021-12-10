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
import java.util.List;
import java.util.Set;

import com.ibm.websphere.simplicity.AbstractSession;
import com.ibm.websphere.simplicity.Cell;
import com.ibm.websphere.simplicity.ConfigIdentifier;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.config.ConfigObject;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;

/**
 * Like {@link JAASSystemLogins}, but for applications
 */
public class JAASApplicationLogins extends JAASLogins {
    
    /**
     * Constructor
     * 
     * @param domain Parent {@link SecurityDomain}
     */
	protected JAASApplicationLogins(SecurityDomain domain) {
		super(domain, JAASLoginType.APPLICATION);
	}
    
    /**
     * Get the {@link JAASApplicationLogin}s for this domain
     * 
     * @return A Set of {@link JAASApplicationLogin}s or null there is no JAAS application login
     *         configuration for the domain
     * @throws Exception
     */
    public Set<JAASApplicationLogin> getJAASApplicationLogins() throws Exception {
        Set<JAASLogin> logins = super.getJAASLogins();
        Set<JAASApplicationLogin> appLogins = null;
        if(logins != null) {
            appLogins = new HashSet<JAASApplicationLogin>();
            for(JAASLogin login : logins) {
                appLogins.add((JAASApplicationLogin)login);
            }
        }
        return appLogins;
    }
    
    /**
     * Get a specific {@link JAASApplicationLogin}
     * 
     * @param alias The name of the {@link JAASApplicationLogin} to get
     * @return The {@link JAASApplicationLogin} with the alias or null if no
     *         {@link JAASApplicationLogin} exists with the alias
     * @throws Exception
     */
    public JAASApplicationLogin getJAASApplicationLoginByAlias(String alias) throws Exception {
        if(alias == null) {
            throw new IllegalArgumentException("alias cannot be null.");
        }
        return (JAASApplicationLogin)super.getJAASLoginByAlias(alias);
    }

    /**
     * Create a {@link JAASApplicationLogin}
     * 
     * @param alias The alias of the login
     * @return An {@link OperationResults} containing the new {@link JAASApplicationLogin}
     * @throws Exception
     */
    public OperationResults<JAASApplicationLogin> createJAASApplicationLogin(String alias) throws Exception {
        if(getJAASApplicationLoginByAlias(alias) != null) {
            throw new Exception("A JAAS login with alias " + alias + " already exists.");
        }
        OperationResults<Boolean> result = super.configureJAASLogin(alias, null);
        OperationResults<JAASApplicationLogin> ret = new OperationResults<JAASApplicationLogin>();
        ret.setSuccess(result.isSuccess());
        ret.setSystemErr(result.getSystemErr());
        ret.setSystemOut(ret.getSystemOut());
        ret.addNotifications(result.getNotifications());
        if(result.getResult()) {
            if(this.jaasLogins == null) {
                ret.setResult(getJAASApplicationLoginByAlias(alias));
            } else {
                Set<ConfigIdentifier> logins = null;
                if(getSecurityDomain().isAtLeast70()) {
                    Cell cell = getSecurityDomain().getCell();
                    String name = getSecurityDomain().getName();
                    AbstractSession session = cell.getWorkspace().getSession();
                    logins = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().getJAASLoginEntries(cell, name, this.type, session);
                } else {
                    logins = new HashSet<ConfigIdentifier>();
                    List<ConfigObject> entries = getJAASLoginsConfigObject().getChildObjectsByDataType("JAASConfigurationEntry");
                    for(ConfigObject entry : entries) {
                        logins.add(entry.getConfigIdentifier());
                    }
                }
                JAASApplicationLogin temp = null;
                for(ConfigIdentifier login : logins) {
                    temp = new JAASApplicationLogin(this, login);
                    if(temp.getAlias().equals(alias)) {
                        getJAASLogins().add(temp);
                        ret.setResult(temp);
                    }
                }
            }
        }
        return ret;
    }
}
