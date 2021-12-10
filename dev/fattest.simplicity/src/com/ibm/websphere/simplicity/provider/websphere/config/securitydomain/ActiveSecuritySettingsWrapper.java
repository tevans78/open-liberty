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

import java.util.HashMap;
import java.util.Map;

/**
 * Wrapper for passing active security settings to and from the public api.
 */
public class ActiveSecuritySettingsWrapper {

    private Boolean enableGlobalSecurity;
    private Integer cacheTimeout;
    private Boolean issuePermissionWarning;
    private Boolean enforceJava2Security;
    private Boolean enforceFineGrainedJCASecurity;
    private Boolean appSecurityEnabled;
    private Boolean dynUpdateSSLConfig;
    private String activeAuthMechanism;
    private String adminPreferredAuthMech;
    private String activeUserRegistry;
    private Boolean useDomainQualifiedUserNames;
    private Map<String, String> customProperties;
    
    public String getActiveAuthMechanism() {
        return activeAuthMechanism;
    }
    public void setActiveAuthMechanism(String activeAuthMechanism) {
        this.activeAuthMechanism = activeAuthMechanism;
    }
    public String getActiveUserRegistry() {
        return activeUserRegistry;
    }
    public void setActiveUserRegistry(String activeUserRegistry) {
        this.activeUserRegistry = activeUserRegistry;
    }
    public String getAdminPreferredAuthMech() {
        return adminPreferredAuthMech;
    }
    public void setAdminPreferredAuthMech(String adminPreferredAuthMech) {
        this.adminPreferredAuthMech = adminPreferredAuthMech;
    }
    public Boolean getAppSecurityEnabled() {
        return appSecurityEnabled;
    }
    public void setAppSecurityEnabled(Boolean appSecurityEnabled) {
        this.appSecurityEnabled = appSecurityEnabled;
    }
    public Integer getCacheTimeout() {
        return cacheTimeout;
    }
    public void setCacheTimeout(Integer cacheTimeout) {
        this.cacheTimeout = cacheTimeout;
    }
    public Map<String, String> getCustomProperties() {
        return customProperties;
    }
    public void setCustomProperties(Map<String, String> customProperties) {
        this.customProperties = customProperties;
    }
    public Boolean getDynUpdateSSLConfig() {
        return dynUpdateSSLConfig;
    }
    public void setDynUpdateSSLConfig(Boolean dynUpdateSSLConfig) {
        this.dynUpdateSSLConfig = dynUpdateSSLConfig;
    }
    public Boolean getEnableGlobalSecurity() {
        return enableGlobalSecurity;
    }
    public void setEnableGlobalSecurity(Boolean enableGlobalSecurity) {
        this.enableGlobalSecurity = enableGlobalSecurity;
    }
    public Boolean getEnforceFineGrainedJCASecurity() {
        return enforceFineGrainedJCASecurity;
    }
    public void setEnforceFineGrainedJCASecurity(Boolean enforceFineGrainedJCASecurity) {
        this.enforceFineGrainedJCASecurity = enforceFineGrainedJCASecurity;
    }
    public Boolean getEnforceJava2Security() {
        return enforceJava2Security;
    }
    public void setEnforceJava2Security(Boolean enforceJava2Security) {
        this.enforceJava2Security = enforceJava2Security;
    }
    public Boolean getIssuePermissionWarning() {
        return issuePermissionWarning;
    }
    public void setIssuePermissionWarning(Boolean issuePermissionWarning) {
        this.issuePermissionWarning = issuePermissionWarning;
    }
    public Boolean getUseDomainQualifiedUserNames() {
        return useDomainQualifiedUserNames;
    }
    public void setUseDomainQualifiedUserNames(Boolean useDomainQualifiedUserNames) {
        this.useDomainQualifiedUserNames = useDomainQualifiedUserNames;
    }

    public ActiveSecuritySettingsWrapper clone() {
        ActiveSecuritySettingsWrapper ret = new ActiveSecuritySettingsWrapper();
        ret.setActiveAuthMechanism(this.getActiveAuthMechanism());
        ret.setActiveUserRegistry(this.getActiveUserRegistry());
        ret.setAdminPreferredAuthMech(this.getAdminPreferredAuthMech());
        ret.setAppSecurityEnabled(this.getAppSecurityEnabled());
        ret.setCacheTimeout(this.getCacheTimeout());
        if(this.getCustomProperties() != null) {
            ret.setCustomProperties(new HashMap<String, String>(this.getCustomProperties()));
        }
        ret.setDynUpdateSSLConfig(this.getDynUpdateSSLConfig());
        ret.setEnableGlobalSecurity(this.getEnableGlobalSecurity());
        ret.setEnforceFineGrainedJCASecurity(this.getEnforceFineGrainedJCASecurity());
        ret.setEnforceJava2Security(this.getEnforceJava2Security());
        ret.setIssuePermissionWarning(this.getIssuePermissionWarning());
        ret.setUseDomainQualifiedUserNames(this.getUseDomainQualifiedUserNames());
        return ret;
    }
    
}
