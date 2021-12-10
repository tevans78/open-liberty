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

import java.util.Map;

/**
 * This class contains the settings that can be specified when configuring a {@link JAASLoginModule}.
 * 
 */
public class LoginModuleSettings {

    private String loginModule;
    private Boolean useLoginModuleProxy;
    private Map<String, String> customProps;
    private AuthenticationStrategy authStrategy;
    
    /**
     * A Java Authentication and Authorization Service (JAAS) authentication provider supplies the
     * authentication strategy. In JAAS, an authentication strategy is implemented through the
     * LoginModule interface.
     * 
     * @return The authentication strategy
     */
    public AuthenticationStrategy getAuthStrategy() {
        return authStrategy;
    }
    /**
     * A Java Authentication and Authorization Service (JAAS) authentication provider supplies the
     * authentication strategy. In JAAS, an authentication strategy is implemented through the
     * LoginModule interface.
     * 
     * @param authStrategy The authentication strategy to set
     */
    public void setAuthStrategy(AuthenticationStrategy authStrategy) {
        this.authStrategy = authStrategy;
    }
    /**
     * Custom properties
     * 
     * @return The custom properties
     */
    public Map<String, String> getCustomProps() {
        return customProps;
    }
    /**
     * Custom properties
     * 
     * @param customProps The custom properties to set
     */
    public void setCustomProps(Map<String, String> customProps) {
        this.customProps = customProps;
    }
    /**
     * Specifies the class name of the given login module.
     * 
     * @return The login module class name
     */
    public String getLoginModule() {
        return loginModule;
    }
    /**
     * Specifies the class name of the given login module.
     * 
     * @param loginModule The login module class name to set
     */
    public void setLoginModule(String loginModule) {
        this.loginModule = loginModule;
    }
    /**
     * Specifies that the JAAS loads the login module proxy class. JAAS then delegates calls to the
     * login module classes that are defined in the Module class name field. Specify true to use the
     * login module proxy.
     * 
     * @return true if using a login module proxy
     */
    public Boolean getUseLoginModuleProxy() {
        return useLoginModuleProxy;
    }

    /**
     * Specifies that the JAAS loads the login module proxy class. JAAS then delegates calls to the
     * login module classes that are defined in the Module class name field. Specify true to use the
     * login module proxy.
     * 
     * @param useLoginModuleProxy true to use a login module proxy
     */
    public void setUseLoginModuleProxy(boolean useLoginModuleProxy) {
        this.useLoginModuleProxy = useLoginModuleProxy;
    }
    
    
}
