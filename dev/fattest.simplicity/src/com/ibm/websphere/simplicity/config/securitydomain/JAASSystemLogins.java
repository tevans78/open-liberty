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
 * Java(TM) Authentication and Authorization Service (JAAS) login configurations are used by system
 * resources including the authentication mechanism, principal mapping, and credential mapping.
 */
public class JAASSystemLogins extends JAASLogins {

    /**
     * Constructor
     * 
     * @param domain Parent {@link SecurityDomain}
     */
	public JAASSystemLogins(SecurityDomain domain) {
		super(domain, JAASLoginType.SYSTEM);
	}

    /**
     * Get the {@link JAASSystemLogin}s for this domain
     * 
     * @return A Set of {@link JAASSystemLogin}s or null there is no JAAS system login
     *         configuration for the domain
     * @throws Exception
     */
    public Set<JAASSystemLogin> getJAASSystemLogins() throws Exception {
        Set<JAASLogin> logins = super.getJAASLogins();
        Set<JAASSystemLogin> sysLogins = null;
        if(logins != null) {
            sysLogins = new HashSet<JAASSystemLogin>();
            for(JAASLogin login : logins) {
                sysLogins.add((JAASSystemLogin)login);
            }
        }
        return sysLogins;
    }

    /**
     * Get a specific {@link JAASSystemLogin}
     * 
     * @param alias The name of the {@link JAASSystemLogin} to get
     * @return The {@link JAASSystemLogin} with the alias or null if no
     *         {@link JAASSystemLogin} exists with the alias
     * @throws Exception
     */
    public JAASSystemLogin getJAASSystemLoginByAlias(String alias) throws Exception {
        if(alias == null) {
            throw new IllegalArgumentException("alias cannot be null.");
        }
        return (JAASSystemLogin)super.getJAASLoginByAlias(alias);
    }

    /**
     * Create a {@link JAASSystemLogin}
     * 
     * @param alias The alias of the login
     * @return An {@link OperationResults} containing the new {@link JAASSystemLogin}
     * @throws Exception
     */
    public OperationResults<JAASSystemLogin> createJAASSystemLogin(String alias) throws Exception {
        if(getJAASSystemLoginByAlias(alias) != null) {
            throw new Exception("A JAAS login with alias " + alias + " already exists.");
        }
        OperationResults<Boolean> result = super.configureJAASLogin(alias, null);
        OperationResults<JAASSystemLogin> ret = new OperationResults<JAASSystemLogin>();
        ret.setSuccess(result.isSuccess());
        ret.setSystemErr(result.getSystemErr());
        ret.setSystemOut(ret.getSystemOut());
        ret.addNotifications(result.getNotifications());
        if(result.getResult()) {
            if(this.jaasLogins == null) {
                ret.setResult(getJAASSystemLoginByAlias(alias));
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
                JAASSystemLogin temp = null;
                for(ConfigIdentifier login : logins) {
                    temp = new JAASSystemLogin(this, login);
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
