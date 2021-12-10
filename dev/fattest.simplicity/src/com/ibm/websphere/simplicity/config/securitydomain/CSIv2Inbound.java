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

import com.ibm.websphere.simplicity.commands.securityconfiguration.GetCSIInboundInfo;
import com.ibm.websphere.simplicity.config.ConfigObject;
import com.ibm.websphere.simplicity.config.Configurable;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;

/**
 * Authentication settings for requests that are received and transport settings for connections
 * that are accepted by this server using the Object Management Group (OMG) Common Secure
 * Interoperability (CSI) authentication protocol.
 */
public class CSIv2Inbound  implements Configurable {

    private static final Class c = CSIv2Inbound.class;
    private static final String CHANGE_KEY_CSIINBOUND = "CSIv2Inbound";

    protected CSIInboundSettings attributes;
    protected RMI_IIOP parent;

    /**
     * Constructor
     * 
     * @param parent The parent {@link RMI_IIOP}
     */
    protected CSIv2Inbound(RMI_IIOP parent) {
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
        CSIInboundSettings settings = new CSIInboundSettings();
        settings.setEnableAttributePropagation(enable);
        parent.configureCSIV2Inbound(settings);
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
        CSIInboundSettings settings = new CSIInboundSettings();
        settings.setEnableIdentityAssertion(enable);
        parent.configureCSIV2Inbound(settings);
        getAttributes().setEnableIdentityAssertion(enable);
    }

    /**
     * Specifies a list of trusted server identities.
     * 
     * @return The trusted identities list
     */
    public List<String> getTrustedIdentities() throws Exception {
        return getAttributes().getTrustedIdentities();
    }

    /**
     * Set a list of trusted server identities, separated by the pipe character (|). To specify a
     * null value, set the value of the identities parameter as an empty string ("").
     * 
     * @param identities The trusted identities
     */
    public void setTrustedIdentities(List<String> identities) throws Exception {
        CSIInboundSettings settings = new CSIInboundSettings();
        settings.setTrustedIdentities(identities);
        parent.configureCSIV2Inbound(settings);
        getAttributes().setTrustedIdentities(identities);
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
        CSIInboundSettings settings = new CSIInboundSettings();
        settings.setClientCertAuth(authentication);
        parent.configureCSIV2Inbound(settings);
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
        CSIInboundSettings settings = new CSIInboundSettings();
        settings.setTransportLayer(layer);
        parent.configureCSIV2Inbound(settings);
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
        CSIInboundSettings settings = new CSIInboundSettings();
        settings.setSslConfiguration(sslConfiguration);
        parent.configureCSIV2Inbound(settings);
        getAttributes().setSslConfiguration(sslConfiguration);
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
        CSIInboundSettings settings = new CSIInboundSettings();
        settings.setMessageLevelAuth(authLevel);
        parent.configureCSIV2Inbound(settings);
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
        CSIInboundSettings settings = new CSIInboundSettings();
        settings.setSupportedAuthMechList(supportedAuthMechList);
        parent.configureCSIV2Inbound(settings);
        getAttributes().setSupportedAuthMechList(supportedAuthMechList);
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
        CSIInboundSettings settings = new CSIInboundSettings();
        settings.setEnableStatefulSesssion(enabled);
        parent.configureCSIV2Inbound(settings);
        getAttributes().setEnableStatefulSesssion(enabled);
    }

    public void commit(HashMap<String, Object> values) throws Exception {
    }

    public void rollback(HashMap<String, Object> values) throws Exception {
        this.attributes = (CSIInboundSettings)values.get(CHANGE_KEY_CSIINBOUND);
    }
    
    /**
     * Get the {@link RMI_IIOP} parent Object
     * 
     * @return The {@link RMI_IIOP} parent Object
     */
    public RMI_IIOP getParent() {
        return this.parent;
    }

    protected CSIInboundSettings getAttributes() throws Exception {
        final String method = "getAttributes";
        if(this.attributes == null) {
            if(getParent().getSecurityDomain().isAtLeast70()) {
                GetCSIInboundInfo adminTask = new GetCSIInboundInfo();
                adminTask.setDisplayModel(false);
                if(!(parent.getSecurityDomain() instanceof GlobalSecurityDomain)) {
                    adminTask.setSecurityDomainName(parent.getSecurityDomain().getName());
                }
                Object result = adminTask.run(parent.getSecurityDomain().getCell()).getResult();
                this.attributes = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().getCSIv2InboundAttributes(result);
            } else { // look at what we have to do for 6.1 =(
                ConfigObject csi = RMI_IIOP.getCSIConfiguration(getParent().getSecurityDomain());
                this.attributes = new CSIInboundSettings();
                ConfigObject claims = csi.getChildObjectListByName("claims").get(0);
                List<ConfigObject> layers = claims.getChildObjectListByName("layers");
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
                    } else if(layer.getMetadata().getDataType().equals("IdentityAssertionLayer")) {
                        this.attributes.setEnableIdentityAssertion(layer.getChildObjectListByName("supportedQOP").get(0).getAttributeByName("enable").getValueAsBoolean());
                        List<ConfigObject> trustedServerObjects = layer.getChildObjectListByName("trustedServers");
                        List<String> trustedServers = new ArrayList<String>();
                        if (trustedServerObjects.size() > 0) {
	                        String trustedServersString = trustedServerObjects.get(0).getAttributeByName("serverId").getValueAsString();
	                        StringTokenizer t = new StringTokenizer(trustedServersString, "\r\n\t\f|");
	                        while(t.hasMoreTokens())
	                            trustedServers.add(t.nextToken());
                        }
                        this.attributes.setTrustedIdentities(trustedServers);
                    } else if(layer.getMetadata().getDataType().equals("MessageLayer")) {
                        boolean required = layer.getChildObjectListByName("requiredQOP").get(0).getAttributeByName("establishTrustInClient").getValueAsBoolean();
                        boolean supported = layer.getChildObjectListByName("supportedQOP").get(0).getAttributeByName("establishTrustInClient").getValueAsBoolean();
                        if(required)
                            this.attributes.setMessageLevelAuth("Required");
                        else if(supported)
                            this.attributes.setMessageLevelAuth("Supported");
                        else
                            this.attributes.setMessageLevelAuth("Never");
                    }
                }
                List<ConfigObject> secProps = getParent().getSecurityDomain().getconfigObject().getChildObjectsByDataType("Property");
                for(ConfigObject prop : secProps) {
                    if(prop.getAttributeByName("name").getValueAsString().equals("com.ibm.CSI.rmiInboundPropagationEnabled")) {
                        this.attributes.setEnableAttributePropagation(prop.getAttributeByName("value").getValueAsBoolean());
                        break;
                    }
                }
                this.attributes.setEnableStatefulSesssion(claims.getAttributeByName("stateful").getValueAsBoolean());
            }
        }
        Log.exiting(c, method, attributes);
        return this.attributes;
    }

    protected void registerChange() throws Exception {
        // save the original attributes
        CSIInboundSettings shadow = new CSIInboundSettings();
        CSIInboundSettings current = getAttributes();
        shadow.setClientCertAuth(current.getClientCertAuth());
        shadow.setEnableAttributePropagation(current.getEnableAttributePropagation());
        shadow.setEnableIdentityAssertion(current.getEnableIdentityAssertion());
        shadow.setEnableStatefulSesssion(current.getEnableStatefulSesssion());
        shadow.setMessageLevelAuth(current.getMessageLevelAuth());
        shadow.setSslConfiguration(current.getSslConfiguration());
        shadow.setSupportedAuthMechList(current.getSupportedAuthMechList());
        shadow.setTransportLayer(current.getTransportLayer());
        shadow.setTrustedIdentities(current.getTrustedIdentities());
        parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_CSIINBOUND, shadow);
    }
}
