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

import com.ibm.websphere.simplicity.BootStrappingFileOperations;
import com.ibm.websphere.simplicity.BootStrappingProperty;
import com.ibm.websphere.simplicity.Cell;
import com.ibm.websphere.simplicity.Topology;
import com.ibm.websphere.simplicity.config.SecurityConfiguration;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.websphere.config.securitydomain.ActiveSecuritySettingsWrapper;

/**
 * This class represents the global security domain for the {@link Cell}. This security
 * configuration applies to the security policy for all administrative functions and is used as a
 * default security policy for user applications. Security domains can be defined to override and
 * customize the security policies for user applications.
 */
public class GlobalSecurityDomain extends SecurityDomain {

    private static final Class<?> c = GlobalSecurityDomain.class;
    private Boolean securityEnabled; // needed for topology caching

    /**
     * Constructor
     *
     * @param cell   The {@link Cell} that the domain belongs to
     * @param parent The parent {@link SecurityConfiguration} class
     */
    public GlobalSecurityDomain(Cell cell, SecurityConfiguration parent) {
        super(cell, parent);
    }

    /**
     * Get whether or not global security is currently enabled in the configuration.
     *
     * @return           true if global security is enabled
     * @throws Exception
     */
    public boolean isGlobalSecurityEnabled() throws Exception {
        if (this.securityEnabled == null) {
            // first try to read it from the cache
            if (Topology.isTopologyCachingEnabled()) {
                String value = Topology.getBootstrapFileOps()
                                .getConfigurationProvider()
                                .getProperty(
                                             cell.getBootstrapFileKey() + BootStrappingFileOperations.SEP + BootStrappingFileOperations.DATA
                                             + BootStrappingFileOperations.SEP + BootStrappingProperty.SECURITY_ENABLED);
                if (value != null) {
                    this.securityEnabled = new Boolean(value);
                } else {
                    // get it from the active security settings
                    this.securityEnabled = getActiveSecuritySettings().getEnableGlobalSecurity();
                }
            } else {
                // get it from the active security settings
                this.securityEnabled = getActiveSecuritySettings().getEnableGlobalSecurity();
            }
        }
        return this.securityEnabled;
    }

    /**
     * Enable administrative security for this application server domain. Administrative security
     * requires users to authenticate before obtaining administrative control of the application
     * server.
     *
     * @throws Exception
     */
    public void enableAdministrativeSecurity() throws Exception {
        final String method = "enableAdministrativeSecurity";
        Log.entering(c, method);
        ActiveSecuritySettingsWrapper settings = new ActiveSecuritySettingsWrapper();
        settings.setEnableGlobalSecurity(true);
        super.applyActiveSecuritySettings(settings);
        this.securityEnabled = true;
        if (Topology.isTopologyCachingEnabled())
            Topology.getBootstrapFileOps().clearCache(this.cell);
        Log.entering(c, method);
    }

    /**
     * Diable administrative security for this application server domain. Administrative security
     * requires users to authenticate before obtaining administrative control of the application
     * server.
     *
     * @throws Exception
     */
    public void disableAdministrativeSecurity() throws Exception {
        final String method = "disableAdministrativeSecurity";
        Log.entering(c, method);
        ActiveSecuritySettingsWrapper settings = new ActiveSecuritySettingsWrapper();
        settings.setEnableGlobalSecurity(false);
        super.applyActiveSecuritySettings(settings);
        this.securityEnabled = false;
        if (Topology.isTopologyCachingEnabled())
            Topology.getBootstrapFileOps().clearCache(this.cell);
        Log.entering(c, method);
    }

    /**
     * Get the current active authentication mechanism. Ex: LTPA
     *
     * @return           The currently active authentication mechanism
     * @throws Exception
     */
    public String getActiveAuthMechanism() throws Exception {
        final String method = "getActiveAuthMechanism";
        Log.entering(c, method);

        String activeAuthMech = getActiveSecuritySettings().getActiveAuthMechanism();

        Log.exiting(c, method, activeAuthMech);
        return activeAuthMech;
    }

}
