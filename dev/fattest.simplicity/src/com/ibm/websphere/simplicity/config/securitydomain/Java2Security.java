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

import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.websphere.config.securitydomain.ActiveSecuritySettingsWrapper;

/**
 * This class contains the Java 2 security attributes for the domain
 *
 */
public class Java2Security extends SecurityDomainAttribute {
    
    private final static Class c = Java2Security.class;
	
    /**
     * Constructor
     * 
     * @param domain The {@link SecurityDomain} parent
     */
	protected Java2Security(SecurityDomain domain) {
		super(domain);
	}
	
    /**
     * Get whether or not Java 2 security is enabled for the domain
     * 
     * @return true if Java 2 security is enabled, false if it is disabled, or null if there is no
     *         Java 2 security configuration defined for the domain
     * @throws Exception
     */
	public Boolean getEnforceJava2Security() throws Exception {
        final String method = "getEnforceJava2Security";
        Log.entering(c, method);
        Boolean enforce = this.getSecurityDomain().getActiveSecuritySettings().getEnforceJava2Security();
        Log.exiting(c, method, enforce);
        return enforce;
	}
	
    /**
     * Get whether or not during application deployment and application start, the security runtime
     * issues a warning if applications are granted any custom permissions.
     * 
     * @return true if an permission warning is issued, false if not, or null if there is no Java 2
     *         security configuration for the domain.
     * @throws Exception
     */
	public Boolean getIssuePermissionWarning() throws Exception {
        final String method = "getIssuePermissionWarning";
        Log.entering(c, method);
        Boolean issueWarning = this.getSecurityDomain().getActiveSecuritySettings().getIssuePermissionWarning();
        Log.exiting(c, method, issueWarning);
        return issueWarning;
	}
	
    /**
     * Returns true if fine grained JCA security is enabled. If enabled, this option add
     * fine-grained Java 2 security permission checking to the default principal mapping of the
     * WSPrincipalMappingLoginModule implementation.
     * 
     * @return true If fine grained JCA security is enabled, false if disabled, or null if no Java 2
     *         security configuration exists for the domain
     * @throws Exception
     */
	public Boolean getEnforceFineGrainedJCASecurity() throws Exception {
        final String method = "getEnforceFineGrainedJCASecurity";
        Log.entering(c, method);
        Boolean enforce = this.getSecurityDomain().getActiveSecuritySettings().getEnforceFineGrainedJCASecurity();
        Log.exiting(c, method, enforce);
        return enforce;
	}
	
    /**
     * Set whether or not Java 2 security is enabled for the domain
     * 
     * @param enforce true to enforce Java 2 security
     * @throws Exception
     */
	public void setEnforceJava2Security(boolean enforce) throws Exception {
        setJava2SecuritySettings(enforce, null, null);
	}
	
    /**
     * Set whether or not during application deployment and application start, the security runtime
     * issues a warning if applications are granted any custom permissions.
     * 
     * @param issueWarning true to issue a permission warning
     * @throws Exception
     */
	public void setIssuePermissionWarning(boolean issueWarning) throws Exception {
		setJava2SecuritySettings(null, issueWarning, null);
	}
	
    /**
     * Set fine grained JCA security. If enabled, this option add
     * fine-grained Java 2 security permission checking to the default principal mapping of the
     * WSPrincipalMappingLoginModule implementation.
     * 
     * @param enforce true to enforce fine grained JCA security
     * @throws Exception
     */
	public void setEnforceFineGrainedJCASecurity(boolean enforce) throws Exception {
		setJava2SecuritySettings(null, null, enforce);
	}

    /**
     * Set the Java 2 security settings
     * 
     * @param useJava2Security true to enforce Java 2 security
     * @param issuePermissionsWarning true to issue permission warnings
     * @param enforceJCASecurity true to enforce JCA security
     * @throws Exception
     */
    private void setJava2SecuritySettings(Boolean useJava2Security, Boolean issuePermissionsWarning, Boolean enforceJCASecurity) throws Exception {
        final String method = "setJava2SecuritySettings";
        Log.entering(c, method, new Object[]{useJava2Security, issuePermissionsWarning, enforceJCASecurity});
        if ((issuePermissionsWarning != null || enforceJCASecurity != null)
                && ((useJava2Security == null && getEnforceJava2Security().equals(false)) || (useJava2Security != null && useJava2Security.equals(false)))) {
            throw new Exception("Java2Security must be enabled to set issuePermissionsWarning or enforceJCASecurity.");
        }
        Log.finer(c, method, "Setting Java2 security settings.");
        ActiveSecuritySettingsWrapper settings = new ActiveSecuritySettingsWrapper();
        settings.setEnforceJava2Security(useJava2Security);
        settings.setIssuePermissionWarning(issuePermissionsWarning);
        settings.setEnforceFineGrainedJCASecurity(enforceJCASecurity);
        this.getSecurityDomain().applyActiveSecuritySettings(settings);
        Log.exiting(c, method);
    }

    @Override
    public void useGlobalDomainSettings() throws Exception {
        final String method = "useGlobalDomainSettings";
        Log.entering(c, method);
        
        if(!(this.getSecurityDomain() instanceof GlobalSecurityDomain)) {
            Log.finer(c, method, "Unsetting the application security settings.");
            this.getSecurityDomain().unsetAppActiveSecuritySettings(this.getClass());
        } else {
            Log.finer(c, method, "Nothing to do for the global domain.");
        }
        
        Log.exiting(c, method);
    }

    @Override
    public boolean globalSettingsInUse() throws Exception {
        return ((getSecurityDomain() instanceof GlobalSecurityDomain) || (getEnforceJava2Security() == null));
    }

}
