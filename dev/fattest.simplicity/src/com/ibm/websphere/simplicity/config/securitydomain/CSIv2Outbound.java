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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import com.ibm.websphere.simplicity.commands.securityconfiguration.GetCSIOutboundInfo;
import com.ibm.websphere.simplicity.config.ConfigObject;
import com.ibm.websphere.simplicity.config.Configurable;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;

public class CSIv2Outbound implements Configurable {
    
    private static Class c = CSIv2Outbound.class;
    private static final String CHANGE_KEY_CSIOUTBOUND = "CSIv2Outbound";

    protected RMI_IIOP parent;
    protected CSIOutboundSettings attributes;
    
    /**
     * Constructor
     * 
     * @param parent The {@link RMI_IIOP} parent
     */
    public CSIv2Outbound(RMI_IIOP parent) {
        this.parent = parent;
    }
    
    /**
     * Specifies whether to enable security attribute propagation. Security attribute propagation
     * allows the application server to transport authenticated Subject contents and security
     * context information from one server to another in your configuration.
     * 
     * @return true if attribute propagation is enabled
     */
    public Boolean isAttributePropagationEnabled() throws Exception {
        return getAttributes().getEnableAttributePropagation();
    }

    /**
     * Set whether to enable security attribute propagation. Security attribute propagation allows
     * the application server to transport authenticated Subject contents and security context
     * information from one server to another in your configuration.
     * 
     * @param enable true to enable security attribute propagation
     */
    public void setEnableAttributePropagation(boolean enable) throws Exception {
        CSIOutboundSettings settings = new CSIOutboundSettings();
        settings.setEnableAttributePropagation(enable);
        parent.configureCSIOutbound(settings);
        getAttributes().setEnableAttributePropagation(enable);
    }
    
    /**
     * Specifies whether to enable identity assertion. When using the identity assertion
     * authentication method, the security token generated is a <wsse:UsernameToken> element that
     * contains a <wsse:Username> element.
     * 
     * @return true if identity assertion is enabled
     */
    public Boolean isIdentityAssertionEnabled() throws Exception {
        return getAttributes().getEnableIdentityAssertion();
    }

    /**
     * Set whether to enable identity assertion. When using the identity assertion authentication
     * method, the security token generated is a <wsse:UsernameToken> element that contains a
     * <wsse:Username> element.
     * 
     * @param enable true to enable identity assertion
     */
    public void setEnableIdentityAssertion(boolean enable) throws Exception {
        CSIOutboundSettings settings = new CSIOutboundSettings();
        settings.setEnableIdentityAssertion(enable);
        parent.configureCSIOutbound(settings);
        getAttributes().setEnableIdentityAssertion(enable);
    }
    
    /**
     * Specifies whether to use the server identity to establish trust with the target server.
     * 
     * @return true if server identity is used
     * @throws Exception
     */
    public Boolean getUseServerIdentity() throws Exception {
        return getAttributes().getUseServerIdentity();
    }
    
    /**
     * Set whether to use the server identity to establish trust with the target server.
     * 
     * @param useServerIdentity true to use server identity
     * @throws Exception
     */
    public void setUseServerIdentity(boolean useServerIdentity) throws Exception {
        CSIOutboundSettings settings = new CSIOutboundSettings();
        settings.setUseServerIdentity(useServerIdentity);
        parent.configureCSIOutbound(settings);
        getAttributes().setUseServerIdentity(useServerIdentity);
    }
    
    /**
     * Specifies the trusted identity that the application server uses to establish trust with the target server.
     * 
     * @return The trusted identity
     * @throws Exception
     */
    public String getTrustedId() throws Exception {
        return getAttributes().getTrustedId();
    }
    
    /**
     * Set the trusted identity that the application server uses to establish trust with the target server.
     * 
     * @param trustedId The trusted identity
     * @param password The password that corresponds to the trustedId
     * @throws Exception
     */
    public void setTrustedId(String trustedId, String password) throws Exception {
        CSIOutboundSettings settings = new CSIOutboundSettings();
        settings.setTrustedId(trustedId);
        settings.setTrustedIdPassword(password);
        parent.configureCSIOutbound(settings);
        getAttributes().setTrustedId(trustedId);
    }

    /**
     * Specifies whether clients connecting to this server must specify a user ID and password.
     * 
     * @return Whether clients must specify a user ID and password
     */
    public String getMessageLevelAuth() throws Exception {
        return getAttributes().getMessageLevelAuth();
    }

    /**
     * Set whether clients connecting to this server must specify a user ID and password. Specify
     * Never to disable the user ID and password requirement. Specify Supported to accept a user ID
     * and password. Specify Required to require a user ID and password.
     * 
     * @param authLevel The authentication level
     */
    public void setMessageLevelAuth(String authLevel) throws Exception {
        CSIOutboundSettings settings = new CSIOutboundSettings();
        settings.setMessageLevelAuth(authLevel);
        parent.configureCSIOutbound(settings);
        getAttributes().setMessageLevelAuth(authLevel);
    }

    /**
     * Specifies the authentication mechanism to use.
     * 
     * @return The authentication mechanism to use
     */
    public List<String> getSupportedAuthMechList() throws Exception {
        return getAttributes().getSupportedAuthMechList();
    }

    /**
     * Set the authentication mechanism to use. Specify KRB5 for Kerberos authentication, LTPA for
     * Lightweight Third-Party Authentication, BasicAuth for BasicAuth authentication, and custom to
     * use your own authentication token implementation. You can specify more then one in a
     * space-separated list.
     * 
     * @param supportedAuthMechList The List of supported authentication mechanisms
     */
    public void setSupportedAuthMechList(List<String> supportedAuthMechList) throws Exception {
        CSIOutboundSettings settings = new CSIOutboundSettings();
        settings.setSupportedAuthMechList(supportedAuthMechList);
        parent.configureCSIOutbound(settings);
        getAttributes().setSupportedAuthMechList(supportedAuthMechList);
    }

    /**
     * Specifies whether a client that connects to the server must connect using an SSL certificate.
     * 
     * @return Whether a client must use an SSL certificate
     */
    public String getClientCertAuth() throws Exception {
        return getAttributes().getClientCertAuth();
    }

    /**
     * Set whether a client that connects to the server must connect using an SSL certificate.
     * Specify Never to allow clients to connect without SSL certificates. Specify Supported to
     * accept clients connecting with and without SSL certificates. Specify Required to require
     * clients to use SSL certificate.
     * 
     * @param authentication Whether or not to authenticate
     */
    public void setClientCetAuth(String authentication) throws Exception {
        CSIOutboundSettings settings = new CSIOutboundSettings();
        settings.setClientCertAuth(authentication);
        parent.configureCSIOutbound(settings);
        getAttributes().setClientCertAuth(authentication);
    }

    /**
     * Specifies the transport layer support level.
     * 
     * @return The transport layer support level
     */
    public String getTransportLayer() throws Exception {
        return getAttributes().getTransportLayer();
    }

    /**
     * Set the transport layer support level. Specify Never to disable transport layer support.
     * Specify Supported to enable transport layer support. Specify Required to require transport
     * layer support.
     * 
     * @param layer The transport support level
     */
    public void setTransportLayer(String layer) throws Exception {
        CSIOutboundSettings settings = new CSIOutboundSettings();
        settings.setTransportLayer(layer);
        parent.configureCSIOutbound(settings);
        getAttributes().setTransportLayer(layer);
    }

    /**
     * Specifies the SSL configuration alias to use for inbound transport.
     * 
     * @return The SSL configuration
     */
    public String getSSLConfiguration() throws Exception {
        return getAttributes().getSslConfiguration();
    }

    /**
     * Set the SSL configuration alias to use for inbound transport.
     * 
     * @param sslConfiguration The SSL configuration alias
     */
    public void setSSLConfiguration(String sslConfiguration) throws Exception {
        CSIOutboundSettings settings = new CSIOutboundSettings();
        settings.setSslConfiguration(sslConfiguration);
        parent.configureCSIOutbound(settings);
        getAttributes().setSslConfiguration(sslConfiguration);
    }

    /**
     * Specifies whether to enable a stateful session.
     * 
     * @return Whether or not a stateful session is enabled
     */
    public Boolean isStatefulSessionEnabled() throws Exception {
        return getAttributes().getEnableStatefulSesssion();
    }

    /**
     * Set whether to enable a stateful session.
     * 
     * @param enabled true to enable a stateful session
     */
    public void setStateFulSessionEnabled(boolean enabled) throws Exception {
        CSIOutboundSettings settings = new CSIOutboundSettings();
        settings.setEnableStatefulSesssion(enabled);
        parent.configureCSIOutbound(settings);
        getAttributes().setEnableStatefulSesssion(enabled);
    }

    /**
     * Specifies whether to enable custom outbound identity mapping.
     * 
     * @return true if custom outbound identity mapping is enabled
     * @throws Exception
     */
    public Boolean isOutboundMappingEnabled() throws Exception {
        return getAttributes().getEnableOutboundMapping();
    }
    
    /**
     * Set whether to enable custom outbound identity mapping.
     * 
     * @param enabled true to enable custom outbound identity mapping
     * @throws Exception
     */
    public void setEnableOutboundMapping(boolean enabled) throws Exception {
        CSIOutboundSettings settings = new CSIOutboundSettings();
        settings.setEnableOutboundMapping(enabled);
        parent.configureCSIOutbound(settings);
        getAttributes().setEnableOutboundMapping(enabled);
    }
    
    /**
     * Specifies a list of target realms to trust.
     * 
     * @return A List of the trusted realms
     * @throws Exception
     */
    public List<String> getTrustedRealms()  throws Exception {
        return getAttributes().getTrustedTargetRealms();
    }
    
    /**
     * Set the trusted realms
     * 
     * @param trustedRealms A List contain the realm names
     * @throws Exception
     */
    public void setTrustedRealms(List<String> trustedRealms) throws Exception {
        CSIOutboundSettings settings = new CSIOutboundSettings();
        settings.setTrustedTargetRealms(trustedRealms);
        parent.configureCSIOutbound(settings);
        getAttributes().setTrustedTargetRealms(trustedRealms);
    }
    
    /**
     * Get the {@link RMI_IIOP} parent Object
     * 
     * @return The {@link RMI_IIOP} parent
     */
    public RMI_IIOP getParent() {
        return this.parent;
    }

    public void commit(HashMap<String, Object> values) throws Exception {
    }

    public void rollback(HashMap<String, Object> values) throws Exception {
        this.attributes = (CSIOutboundSettings)values.get(CHANGE_KEY_CSIOUTBOUND);
    }

    protected CSIOutboundSettings getAttributes() throws Exception {
        final String method = "getAttributes";
        if(this.attributes == null) {
            if(getParent().getSecurityDomain().isAtLeast70()) {
                GetCSIOutboundInfo adminTask = new GetCSIOutboundInfo();
                adminTask.setDisplayModel(false);
                if(!(parent.getSecurityDomain() instanceof GlobalSecurityDomain)) {
                    adminTask.setSecurityDomainName(parent.getSecurityDomain().getName());
                }
                Object result = adminTask.run(parent.getSecurityDomain().getCell()).getResult();
                this.attributes = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().getCSIv2OutboundAttributes(result);
            } else {
                this.attributes = new CSIOutboundSettings();
                ConfigObject csi = RMI_IIOP.getCSIConfiguration(getParent().getSecurityDomain());
                ConfigObject performs = csi.getChildObjectListByName("performs").get(0);
                List<ConfigObject> layers = performs.getChildObjectListByName("layers");
                for(ConfigObject layer : layers) {
                    if(layer.getMetadata().getDataType().equals("TransportLayer")) {
                        ConfigObject requiredQOP = layer.getChildObjectListByName("requiredQOP").get(0);
                        ConfigObject supportedQOP = layer.getChildObjectListByName("supportedQOP").get(0);
                        boolean required = requiredQOP.getAttributeByName("establishTrustInClient").getValueAsBoolean();
                        boolean supported = supportedQOP.getAttributeByName("establishTrustInClient").getValueAsBoolean();
                        if(required)
                            this.attributes.setClientCertAuth("Required");
                        else if(supported)
                            this.attributes.setClientCertAuth("Supported");
                        else
                            this.attributes.setClientCertAuth("Never");
                        required = requiredQOP.getAttributeByName("enableProtection").getValueAsBoolean();
                        supported = supportedQOP.getAttributeByName("enableProtection").getValueAsBoolean();
                        if(required)
                            this.attributes.setTransportLayer("Required");
                        else if(supported)
                            this.attributes.setTransportLayer("Supported");
                        else
                            this.attributes.setTransportLayer("Never");
                        this.attributes.setSslConfiguration(layer.getChildObjectListByName("serverAuthentication").get(0).getAttributeByName("sslConfig").getValueAsString());
                    } else if(layer.getMetadata().getDataType().equals("MessageLayer")) {
                        boolean required = layer.getChildObjectListByName("requiredQOP").get(0).getAttributeByName("establishTrustInClient").getValueAsBoolean();
                        boolean supported = layer.getChildObjectListByName("supportedQOP").get(0).getAttributeByName("establishTrustInClient").getValueAsBoolean();
                        if(required)
                            this.attributes.setMessageLevelAuth("Required");
                        else if(supported)
                            this.attributes.setMessageLevelAuth("Supported");
                        else
                            this.attributes.setMessageLevelAuth("Never");
                    } else if(layer.getMetadata().getDataType().equals("IdentityAssertionLayer")) {
                        ConfigObject supportedQOP = layer.getChildObjectListByName("supportedQOP").get(0);
                        boolean enable = supportedQOP.getAttributeByName("enable").getValueAsBoolean();
                        this.attributes.setEnableIdentityAssertion(enable);
                        ConfigObject trustedId = supportedQOP.getAttributeByName("trustedId");
                        if(enable)
                            if(trustedId != null) {
                                this.attributes.setTrustedId(trustedId.getValueAsString());
                                this.attributes.setUseServerIdentity(false);
                            }
                            else
                                this.attributes.setUseServerIdentity(true);
                    }
                }
                String trustedRealmsString = getParent().getSecurityDomain().getCustomProperties().get("com.ibm.CSI.supportedTargetRealms");
                if(trustedRealmsString != null) {
                    List<String> trustedRealms = new ArrayList<String>();
                    StringTokenizer t = new StringTokenizer(trustedRealmsString, "\r\n\t\f|");
                    while(t.hasMoreTokens())
                        trustedRealms.add(t.nextToken());
                    this.attributes.setTrustedTargetRealms(trustedRealms);
                }
                String attPropEnabled = getParent().getSecurityDomain().getCustomProperties().get("com.ibm.CSI.rmiOutboundPropagationEnabled");
                if(attPropEnabled != null)
                    this.attributes.setEnableAttributePropagation(Boolean.parseBoolean(attPropEnabled));
                String outboundMappingEnabled = getParent().getSecurityDomain().getCustomProperties().get("com.ibm.CSI.rmiOutboundLoginEnabled");
                if(outboundMappingEnabled != null)
                    this.attributes.setEnableOutboundMapping(Boolean.parseBoolean(outboundMappingEnabled));
                this.attributes.setEnableStatefulSesssion(performs.getAttributeByName("stateful").getValueAsBoolean());
            }
        }
        Log.exiting(c, method, attributes);
        return this.attributes;
    }

    protected void registerChange() throws Exception {
        // save the original attributes
        CSIOutboundSettings shadow = new CSIOutboundSettings();
        CSIOutboundSettings current = getAttributes();
        shadow.setClientCertAuth(current.getClientCertAuth());
        shadow.setEnableAttributePropagation(current.getEnableAttributePropagation());
        shadow.setEnableIdentityAssertion(current.getEnableIdentityAssertion());
        shadow.setEnableStatefulSesssion(current.getEnableStatefulSesssion());
        shadow.setMessageLevelAuth(current.getMessageLevelAuth());
        shadow.setSslConfiguration(current.getSslConfiguration());
        shadow.setSupportedAuthMechList(current.getSupportedAuthMechList());
        shadow.setTransportLayer(current.getTransportLayer());
        shadow.setUseServerIdentity(current.getUseServerIdentity());
        shadow.setTrustedId(current.getTrustedId());
        shadow.setEnableOutboundMapping(current.getEnableOutboundMapping());
        shadow.setTrustedTargetRealms(current.getTrustedTargetRealms());
        parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_CSIOUTBOUND, shadow);
    }
}
