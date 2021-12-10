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
import java.util.Map;

import com.ibm.websphere.simplicity.commands.securityconfiguration.ConfigureCSIInbound;
import com.ibm.websphere.simplicity.commands.securityconfiguration.ConfigureCSIOutbound;
import com.ibm.websphere.simplicity.commands.securityconfiguration.GetCSIInboundInfo;
import com.ibm.websphere.simplicity.commands.securityconfiguration.GetCSIOutboundInfo;
import com.ibm.websphere.simplicity.commands.securityconfiguration.UnconfigureCSIInbound;
import com.ibm.websphere.simplicity.commands.securityconfiguration.UnconfigureCSIOutbound;
import com.ibm.websphere.simplicity.config.ConfigObject;
import com.ibm.websphere.simplicity.config.Configurable;
import com.ibm.websphere.simplicity.log.Log;

public class RMI_IIOP extends SecurityDomainAttribute implements Configurable {
    
    private static final Class c = RMI_IIOP.class;
    private static final String CHANGE_KEY_CISINBOUND_CONFIG = "CSIv2InboundConfig";
    private static final String CHANGE_KEY_CSIOUTBOUND_CONFIG = "CSIv2OutboundConfig";
    
    private CSIv2Inbound inbound = null;
    private CSIv2Outbound outbound = null;
    
    /**
     * Constructor
     * 
     * @param domain The parent {@link SecurityDomain}
     */
    protected RMI_IIOP(SecurityDomain domain) {
        super(domain);
    }

    /**
     * Get the {@link CSIv2Inbound} configuration
     * 
     * @return A {@link CSIv2Inbound} Object or null if no configuration exists for the domain
     * @throws Exception
     */
    public CSIv2Inbound getCSIv2InboundConfiguration() throws Exception {
        if(inbound == null) {
            CSIv2Inbound temp = new CSIv2Inbound(this);
            if(temp.isAttributePropagationEnabled() != null) {
                inbound = temp;
            }
        }
        return inbound;
    }
    
    /**
     * Get the {@link CSIv2Outbound} configuration
     * 
     * @return A {@link CSIv2Outbound} Object or null if no configuration exists for the domain
     * @throws Exception
     */
    public CSIv2Outbound getCSIv2OutboundConfiguration() throws Exception {
        if(outbound == null) {
            CSIv2Outbound temp = new CSIv2Outbound(this);
            if(temp.isAttributePropagationEnabled() != null) {
                outbound = temp;
            }
        }
        return outbound;
    }
    
    public void commit(HashMap<String, Object> values) throws Exception {
    }
    
    public void rollback(HashMap<String, Object> values) throws Exception {
        for(Map.Entry<String, Object> entry : values.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            
            if(key.equals(CHANGE_KEY_CISINBOUND_CONFIG)) {
                this.inbound = (CSIv2Inbound)value;
            } else if(key.equals(CHANGE_KEY_CSIOUTBOUND_CONFIG)) {
                this.outbound = (CSIv2Outbound)value;
            }
        }
    }
    
    @Override
    public boolean globalSettingsInUse() throws Exception {
        return getCSIv2InboundConfiguration() == null;
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
        
        getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_CISINBOUND_CONFIG, getCSIv2InboundConfiguration());
        getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_CSIOUTBOUND_CONFIG, getCSIv2OutboundConfiguration());
        
        UnconfigureCSIInbound unconfigCSIInbound = new UnconfigureCSIInbound(getSecurityDomain().getName());
        unconfigCSIInbound.run(getSecurityDomain().getCell());
        UnconfigureCSIOutbound unconfigCSIOutbound = new UnconfigureCSIOutbound(getSecurityDomain().getName());
        unconfigCSIOutbound.run(getSecurityDomain().getCell());
        
        this.inbound = null;
        this.outbound = null;
        
        Log.exiting(c, method);
    }
    
    protected void configureCSIV2Inbound(CSIInboundSettings settings) throws Exception {
        final String method = "configureCSIV2Inbound";
        Log.entering(c, method, settings);

        getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_CISINBOUND_CONFIG, getCSIv2InboundConfiguration());
        // this affects the outbound configuration as well
        getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_CSIOUTBOUND_CONFIG, getCSIv2OutboundConfiguration());
        
        if(getCSIv2InboundConfiguration() != null) {
            getCSIv2InboundConfiguration().registerChange();
        }
        if(getCSIv2OutboundConfiguration() != null) {
            getCSIv2OutboundConfiguration().registerChange();
        }

        if(getSecurityDomain().isAtLeast70()) {
            ConfigureCSIInbound adminTask = new ConfigureCSIInbound();
            // not sure if it matters whether or not we set null values. I'll avoid it for now
            if (settings.getClientCertAuth() != null) {
                adminTask.setClientCertAuth(settings.getClientCertAuth());
            }
            if (settings.getEnableAttributePropagation() != null) {
                adminTask.setEnableAttributePropagation(settings.getEnableAttributePropagation());
            }
            if (settings.getEnableIdentityAssertion() != null) {
                adminTask.setEnableIdentityAssertion(settings.getEnableIdentityAssertion());
            }
            if (settings.getEnableStatefulSesssion() != null) {
                adminTask.setStatefulSession(settings.getEnableStatefulSesssion());
            }
            if (settings.getMessageLevelAuth() != null) {
                adminTask.setMessageLevelAuth(settings.getMessageLevelAuth());
            }
            if (settings.getSslConfiguration() != null) {
                adminTask.setSslConfiguration(settings.getSslConfiguration());
            }
            if (settings.getSupportedAuthMechList() != null) {
                String listString = "";
                for (String authMech : settings.getSupportedAuthMechList()) {
                    listString += (authMech + "|");
                }
                if (listString.length() > 0) {
                    listString = listString.substring(0, listString.length() - 1);
                }
                adminTask.setSupportedAuthMechList(listString);
            }
            if (settings.getTransportLayer() != null) {
                adminTask.setTransportLayer(settings.getTransportLayer());
            }
            if (settings.getTrustedIdentities() != null) {
                String listString = "";
                for (String trustedId : settings.getTrustedIdentities()) {
                    listString += (trustedId + "|");
                }
                if (listString.length() > 0) {
                    listString = listString.substring(0, listString.length() - 1);
                }
                adminTask.setTrustedIdentities(listString);
            }
            if (!(getSecurityDomain() instanceof GlobalSecurityDomain)) {
                adminTask.setSecurityDomainName(getSecurityDomain().getName());
            }
    
            adminTask.run(getSecurityDomain().getCell());
        } else {
            ConfigObject csi = getCSIConfiguration(getSecurityDomain());
            if(settings.getClientCertAuth() != null || settings.getTransportLayer() != null || settings.getSslConfiguration() != null) {
                ConfigObject transportLayer = csi.getChildObjectListByName("claims").get(0).getChildObjectsByDataType("TransportLayer").get(0);
                if(settings.getClientCertAuth() != null) {
                    boolean required = false;
                    boolean supported = false;
                    if(settings.getClientCertAuth().equals("Never")) {
                        required = false;
                        supported = false;
                    } else if(settings.getClientCertAuth().equals("Supported")) {
                        required = false;
                        supported = true;
                    } else if(settings.getClientCertAuth().equals("Required")) {
                        required = true;
                        supported = true;
                    } else
                        throw new Exception("Invalid clientCertAuth value " + settings.getClientCertAuth());
                    transportLayer.getChildObjectListByName("requiredQOP").get(0).getAttributeByName("establishTrustInClient").setValue(required);
                    transportLayer.getChildObjectListByName("supportedQOP").get(0).getAttributeByName("establishTrustInClient").setValue(supported);
                }
                if(settings.getTransportLayer() != null) {
                    boolean required = false;
                    boolean supported = false;
                    if(settings.getTransportLayer().equals("Never")) {
                        required = false;
                        supported = false;
                    } else if(settings.getTransportLayer().equals("Supported")) {
                        required = false;
                        supported = true;
                    } else if(settings.getTransportLayer().equals("Required")) {
                        required = true;
                        supported = true;
                    } else
                        throw new Exception("Invalid transportLayer value " + settings.getTransportLayer());
                    transportLayer.getChildObjectListByName("requiredQOP").get(0).getAttributeByName("enableProtection").setValue(required);
                    transportLayer.getChildObjectListByName("supportedQOP").get(0).getAttributeByName("enableProtection").setValue(supported);
                }
                if(settings.getSslConfiguration() != null)
                    transportLayer.getChildObjectListByName("serverAuthentication").get(0).getAttributeByName("sslConfig").setValue(settings.getSslConfiguration());
            }
            if(settings.getEnableIdentityAssertion() != null || (settings.getTrustedIdentities() != null && settings.getTrustedIdentities().size() > 0)) {
                ConfigObject identityAssertionLayer = csi.getChildObjectListByName("claims").get(0).getChildObjectsByDataType("IdentityAssertionLayer").get(0);
                if(settings.getEnableIdentityAssertion() != null) {
                    identityAssertionLayer.getChildObjectListByName("supportedQOP").get(0).getAttributeByName("enable").setValue(settings.getEnableIdentityAssertion());
                }
                if(settings.getTrustedIdentities() != null && settings.getTrustedIdentities().size() > 0) {
                    String ids = "";
                    for(String id : settings.getTrustedIdentities()) {
                        ids += (id + "|");
                    }
                    ids = ids.substring(0, ids.length() - 1);
                    identityAssertionLayer.getChildObjectListByName("trustedServers").get(0).getAttributeByName("serverId").setValue(ids);
                }
            }
            if(settings.getMessageLevelAuth() != null) {
                ConfigObject messageLayer = csi.getChildObjectListByName("claims").get(0).getChildObjectsByDataType("MessageLayer").get(0);
                boolean required = false;
                boolean supported = false;
                if(settings.getMessageLevelAuth().equals("Never")) {
                    required = false;
                    supported = false;
                } else if(settings.getMessageLevelAuth().equals("Supported")) {
                    required = false;
                    supported = true;
                } else if(settings.getMessageLevelAuth().equals("Required")) {
                    required = true;
                    supported = true;
                } else
                    throw new Exception("Invalid messageLevelAuth value " + settings.getMessageLevelAuth());
                messageLayer.getChildObjectListByName("requiredQOP").get(0).getAttributeByName("establishTrustInClient").setValue(required);
                messageLayer.getChildObjectListByName("supportedQOP").get(0).getAttributeByName("establishTrustInClient").setValue(supported);
            }
            if(settings.getEnableAttributePropagation() != null)
                getSecurityDomain().setCustomProperty("com.ibm.CSI.rmiInboundPropagationEnabled", "" + settings.getEnableAttributePropagation());
            if(settings.getEnableStatefulSesssion() != null)
                csi.getChildObjectListByName("claims").get(0).getAttributeByName("stateful").setValue(settings.getEnableStatefulSesssion());
        }
        
        Log.exiting(c, method);
    }

    /**
     * Configure the CSIv2Inbound configuration. When calling this method, if the inbound
     * configuration already exists for this domain, the internal pointer to the
     * {@link CSIv2Inbound} Object is reset. Use this method to configure a {@link CSIv2Inbound} for
     * the first time or to completely reset the configuration. To simply change attributes on an
     * existing configuration, use the {@link GetCSIInboundInfo} method of this class such to get
     * the configurations and fine tune the attributes.<br/><br/>
     * 
     * Note that calling this method results in the outbound configuration being set with default
     * values if it did not already exist.
     * 
     * @param settings The CSIInbound settings to configure
     * @throws Exception
     */
    public void configureCSIInbound(CSIInboundSettings settings) throws Exception {
        configureCSIV2Inbound(settings);
        this.inbound = null;
        this.outbound = null;
    }
    
    protected void configureCSIV2Outbound(CSIOutboundSettings settings) throws Exception {
        final String method = "configureCSIOutbound";
        Log.entering(c, method, settings);

        // this affects the inbound configuration as well
        getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_CISINBOUND_CONFIG, getCSIv2InboundConfiguration());
        getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_CSIOUTBOUND_CONFIG, getCSIv2OutboundConfiguration());

        if(getCSIv2InboundConfiguration() != null) {
            getCSIv2InboundConfiguration().registerChange();
        }
        if(getCSIv2OutboundConfiguration() != null) {
            getCSIv2OutboundConfiguration().registerChange();
        }

        if(getSecurityDomain().isAtLeast70()) {
            ConfigureCSIOutbound adminTask = new ConfigureCSIOutbound();
            // not sure if it matters whether or not we set null values. I'll avoid it for now
            if (settings.getClientCertAuth() != null) {
                adminTask.setClientCertAuth(settings.getClientCertAuth());
            }
            if (settings.getEnableAttributePropagation() != null) {
                adminTask.setEnableAttributePropagation(settings.getEnableAttributePropagation());
            }
            if (settings.getEnableIdentityAssertion() != null) {
                adminTask.setEnableIdentityAssertion(settings.getEnableIdentityAssertion());
            }
            if (settings.getEnableStatefulSesssion() != null) {
                adminTask.setStatefulSession(settings.getEnableStatefulSesssion());
            }
            if (settings.getMessageLevelAuth() != null) {
                adminTask.setMessageLevelAuth(settings.getMessageLevelAuth());
            }
            if (settings.getSslConfiguration() != null) {
                adminTask.setSslConfiguration(settings.getSslConfiguration());
            }
            if (settings.getSupportedAuthMechList() != null) {
                String listString = "";
                for (String authMech : settings.getSupportedAuthMechList()) {
                    listString += (authMech + "|");
                }
                if (listString.length() > 0) {
                    listString = listString.substring(0, listString.length() - 1);
                }
                adminTask.setSupportedAuthMechList(listString);
            }
            if (settings.getTransportLayer() != null) {
                adminTask.setTransportLayer(settings.getTransportLayer());
            }
            if(settings.getUseServerIdentity() != null) {
                adminTask.setUseServerIdentity(settings.getUseServerIdentity());
            }
            if(settings.getTrustedId() != null) {
                adminTask.setTrustedId(settings.getTrustedId());
            }
            if(settings.getTrustedIdPassword() != null) {
                adminTask.setTrustedIdentityPassword(settings.getTrustedIdPassword());
            }
            if(settings.getEnableOutboundMapping() != null) {
                adminTask.setEnableOutboundMapping(settings.getEnableOutboundMapping());
            }
            if (!(getSecurityDomain() instanceof GlobalSecurityDomain)) {
                adminTask.setSecurityDomainName(getSecurityDomain().getName());
            }
            if (settings.getTrustedTargetRealms() != null) {
                String listString = "";
                for (String realm : settings.getTrustedTargetRealms()) {
                    listString += (realm + "|");
                }
                if (listString.length() > 0) {
                    listString = listString.substring(0, listString.length() - 1);
                }
                adminTask.setTrustedTargetRealms(listString);
            }
    
            adminTask.run(getSecurityDomain().getCell());
        } else {
            ConfigObject csi = getCSIConfiguration(getSecurityDomain());
            if(settings.getClientCertAuth() != null || settings.getTransportLayer() != null || settings.getSslConfiguration() != null) {
                ConfigObject transportLayer = csi.getChildObjectListByName("performs").get(0).getChildObjectsByDataType("TransportLayer").get(0);
                if(settings.getClientCertAuth() != null) {
                    boolean required = false;
                    boolean supported = false;
                    if(settings.getClientCertAuth().equals("Never")) {
                        required = false;
                        supported = false;
                    } else if(settings.getClientCertAuth().equals("Supported")) {
                        required = false;
                        supported = true;
                    } else if(settings.getClientCertAuth().equals("Required")) {
                        required = true;
                        supported = true;
                    } else
                        throw new Exception("Invalid clientCertAuth value " + settings.getClientCertAuth());
                    transportLayer.getChildObjectListByName("requiredQOP").get(0).getAttributeByName("establishTrustInClient").setValue(required);
                    transportLayer.getChildObjectListByName("supportedQOP").get(0).getAttributeByName("establishTrustInClient").setValue(supported);
                }
                if(settings.getTransportLayer() != null) {
                    boolean required = false;
                    boolean supported = false;
                    if(settings.getTransportLayer().equals("Never")) {
                        required = false;
                        supported = false;
                    } else if(settings.getTransportLayer().equals("Supported")) {
                        required = false;
                        supported = true;
                    } else if(settings.getTransportLayer().equals("Required")) {
                        required = true;
                        supported = true;
                    } else
                        throw new Exception("Invalid transportLayer value " + settings.getTransportLayer());
                    transportLayer.getChildObjectListByName("requiredQOP").get(0).getAttributeByName("enableProtection").setValue(required);
                    transportLayer.getChildObjectListByName("supportedQOP").get(0).getAttributeByName("enableProtection").setValue(supported);
                }
                if(settings.getSslConfiguration() != null)
                    transportLayer.getChildObjectListByName("serverAuthentication").get(0).getAttributeByName("sslConfig").setValue(settings.getSslConfiguration());
            }
            if(settings.getEnableIdentityAssertion() != null || settings.getUseServerIdentity() != null || settings.getTrustedId() != null) {
                ConfigObject identityAssertionLayer = csi.getChildObjectListByName("performs").get(0).getChildObjectsByDataType("IdentityAssertionLayer").get(0);
                ConfigObject supportedQOP = identityAssertionLayer.getChildObjectListByName("supportedQOP").get(0);
                if(settings.getEnableIdentityAssertion() != null) {
                    supportedQOP.getAttributeByName("enable").setValue(settings.getEnableIdentityAssertion());
                }
                ConfigObject trustedId = supportedQOP.getAttributeByName("trustedId");
                ConfigObject password = supportedQOP.getAttributeByName("trustedPassword");
                if(settings.getUseServerIdentity() != null && settings.getUseServerIdentity()) {
                    if(trustedId != null)
                        trustedId.delete();
                    if(password != null)
                        password.delete();
                } else if(settings.getTrustedId() != null) {
                    if(trustedId == null)
                        trustedId = ConfigObject.createConfigObject(getSecurityDomain().getCell(), "String", supportedQOP);
                    trustedId.setValue(settings.getTrustedId());
                    if(password == null)
                        password = ConfigObject.createConfigObject(getSecurityDomain().getCell(), "String", supportedQOP);
                    password.setValue(settings.getTrustedIdPassword());
                }
            }
            if(settings.getMessageLevelAuth() != null) {
                ConfigObject messageLayer = csi.getChildObjectListByName("performs").get(0).getChildObjectsByDataType("MessageLayer").get(0);
                boolean required = false;
                boolean supported = false;
                if(settings.getMessageLevelAuth().equals("Never")) {
                    required = false;
                    supported = false;
                } else if(settings.getMessageLevelAuth().equals("Supported")) {
                    required = false;
                    supported = true;
                } else if(settings.getMessageLevelAuth().equals("Required")) {
                    required = true;
                    supported = true;
                } else
                    throw new Exception("Invalid messageLevelAuth value " + settings.getMessageLevelAuth());
                messageLayer.getChildObjectListByName("requiredQOP").get(0).getAttributeByName("establishTrustInClient").setValue(required);
                messageLayer.getChildObjectListByName("supportedQOP").get(0).getAttributeByName("establishTrustInClient").setValue(supported);
            }
            if(settings.getEnableAttributePropagation() != null)
                getSecurityDomain().setCustomProperty("com.ibm.CSI.rmiOutboundPropagationEnabled", "" + settings.getEnableAttributePropagation());
            if(settings.getEnableOutboundMapping() != null)
                getSecurityDomain().setCustomProperty("com.ibm.CSI.rmiOutboundLoginEnabled", "" + settings.getEnableOutboundMapping());
            if(settings.getEnableStatefulSesssion() != null)
                csi.getChildObjectListByName("performs").get(0).getAttributeByName("stateful").setValue(settings.getEnableStatefulSesssion());
            if(settings.getTrustedTargetRealms() != null && settings.getTrustedTargetRealms().size() > 0) {
                String realms = "";
                for(String realm : settings.getTrustedTargetRealms())
                    realms += (realm + "|");
                realms = realms.substring(0, realms.length() - 1);
                getSecurityDomain().setCustomProperty("com.ibm.CSI.supportedTargetRealms", "" + realms);
            }
        }
        
        Log.exiting(c, method);
    }
    
    /**
     * Configure the CSIv2OUtbound configuration. When calling this method, if the outbound
     * configuration already exists for this domain, the internal pointer to the
     * {@link CSIv2Outbound} Object is reset. Use this method to configure a {@link CSIv2Outbound} for
     * the first time or to completely reset the configuration. To simply change attributes on an
     * existing configuration, use the {@link GetCSIOutboundInfo} method of this class such to get
     * the configurations and fine tune the attributes.<br/><br/>
     * 
     * Note that calling this method results in the inbound configuration being set with default
     * values if it did not already exist.
     * 
     * @param settings The CSIOutbound settings to configure
     * @throws Exception
     */
    public void configureCSIOutbound(CSIOutboundSettings settings) throws Exception {
        configureCSIV2Outbound(settings);
        this.inbound = null;
        this.outbound = null;
    }
    
    protected static ConfigObject getCSIConfiguration(SecurityDomain domain) throws Exception {
        ConfigObject security = domain.getconfigObject();
        return security.getChildObjectListByName("CSI").get(0);
    }
}
