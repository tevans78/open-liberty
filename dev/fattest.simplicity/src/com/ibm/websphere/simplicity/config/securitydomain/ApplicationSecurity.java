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
 * This class contains application security attributes for a security domain.
 */
public class ApplicationSecurity extends SecurityDomainAttribute {
    
    private static final Class c = ApplicationSecurity.class;
	
    /**
     * Constructor
     * 
     * @param domain The parent security domain
     */
	protected ApplicationSecurity(SecurityDomain domain) {
		super(domain);
	}
	
    /**
     * Returns whether or not application security is enabled. This type of security provides
     * application isolation and requirements for authenticating application users.
     * 
     * @return true if application security is enabled, false if it is not, and null if application
     *         security is not configured for this domain
     * @throws Exception
     */
	public Boolean isEnabled() throws Exception {
        final String method = "getEnabled";
        Log.entering(c, method);
        Boolean enabled = this.getSecurityDomain().getActiveSecuritySettings().getAppSecurityEnabled();
        Log.exiting(c, method, enabled);
		return enabled;
	}

    /**
     * Set whether or not application security is enabled. This type of security provides
     * application isolation and requirements for authenticating application users.
     * 
     * @param value true to enable application security, false to disable it
     * @throws Exception
     */
	public void setEnabled(boolean value) throws Exception {
        final String method = "setEnabled";
        Log.entering(c, method, value);
        ActiveSecuritySettingsWrapper settings = new ActiveSecuritySettingsWrapper();
        settings.setAppSecurityEnabled(value);
        this.getSecurityDomain().applyActiveSecuritySettings(settings);
        Log.exiting(c, method);
    }

    @Override
    public void useGlobalDomainSettings() throws Exception {
        final String method = "useGlobalDomainSettings";
        Log.entering(c, method);
        
        if(!(this.getSecurityDomain() instanceof GlobalSecurityDomain)) {
            Log.finer(c, method, "Unsetting the application security settings.");
            this.getSecurityDomain().unsetAppActiveSecuritySettings(c);
        } else {
            Log.finer(c, method, "Nothing to do for the global domain.");
        }
        
        Log.exiting(c, method);
    }

    @Override
    public boolean globalSettingsInUse() throws Exception {
        return ((getSecurityDomain() instanceof GlobalSecurityDomain) || (isEnabled() == null));
    }

}
