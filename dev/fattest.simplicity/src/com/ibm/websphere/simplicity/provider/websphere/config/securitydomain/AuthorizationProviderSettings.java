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

package com.ibm.websphere.simplicity.provider.websphere.config.securitydomain;

import java.util.Map;

public class AuthorizationProviderSettings {

    private String name;
    private String description;
    private Boolean useJAACProvider;
    private String j2eePolicyImplClassName;
    private String policyConfigurationFactoryImplClassName;
    private String roleConfigurationFactoryImplClassName;
    private Boolean requiresEJBArgumentsPolicyContextHandler;
    private String initializeJACCProviderClassName;
    private Boolean supportsDynamicModuleUpdates;
    private Map<String, String> customProperties;
    
    public Map<String, String> getCustomProperties() {
        return customProperties;
    }
    public void setCustomProperties(Map<String, String> customProperties) {
        this.customProperties = customProperties;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getInitializeJACCProviderClassName() {
        return initializeJACCProviderClassName;
    }
    public void setInitializeJACCProviderClassName(String initializeJACCProviderClassName) {
        this.initializeJACCProviderClassName = initializeJACCProviderClassName;
    }
    public String getJ2eePolicyImplClassName() {
        return j2eePolicyImplClassName;
    }
    public void setJ2eePolicyImplClassName(String policyImplClassName) {
        j2eePolicyImplClassName = policyImplClassName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPolicyConfigurationFactoryImplClassName() {
        return policyConfigurationFactoryImplClassName;
    }
    public void setPolicyConfigurationFactoryImplClassName(String policyConfigurationFactoryImplClassName) {
        this.policyConfigurationFactoryImplClassName = policyConfigurationFactoryImplClassName;
    }
    public Boolean getRequiresEJBArgumentsPolicyContextHandler() {
        return requiresEJBArgumentsPolicyContextHandler;
    }
    public void setRequiresEJBArgumentsPolicyContextHandler(Boolean requiresEJBArgumentsPolicyContextHandler) {
        this.requiresEJBArgumentsPolicyContextHandler = requiresEJBArgumentsPolicyContextHandler;
    }
    public String getRoleConfigurationFactoryImplClassName() {
        return roleConfigurationFactoryImplClassName;
    }
    public void setRoleConfigurationFactoryImplClassName(String roleConfigurationFactoryImplClassName) {
        this.roleConfigurationFactoryImplClassName = roleConfigurationFactoryImplClassName;
    }
    public Boolean getSupportsDynamicModuleUpdates() {
        return supportsDynamicModuleUpdates;
    }
    public void setSupportsDynamicModuleUpdates(Boolean supportsDynamicModuleUpdates) {
        this.supportsDynamicModuleUpdates = supportsDynamicModuleUpdates;
    }
    public Boolean getUseJAACProvider() {
        return useJAACProvider;
    }
    public void setUseJAACProvider(Boolean useJAACProvider) {
        this.useJAACProvider = useJAACProvider;
    }
    
}
