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

import java.util.List;

/**
 * This class contains settings used to configure CSIv2Outbound communications
 */
public class CSIOutboundSettings {

    private String messageLevelAuth;
    private List<String> supportedAuthMechList;
    private String clientCertAuth;
    private String transportLayer;
    private String sslConfiguration;
    private Boolean enableIdentityAssertion;
    private Boolean enableAttributePropagation;
    private Boolean enableStatefulSesssion;
    private Boolean useServerIdentity;
    private String trustedId;
    private String trustedIdPassword;
    private Boolean enableOutboundMapping;
    private List<String> trustedTargetRealms;
    
    /**
     * Specifies whether a client that connects to the server must connect using an SSL certificate.
     * 
     * @return Whether a client must use an SSL certificate
     */
    public String getClientCertAuth() {
        return clientCertAuth;
    }
    /**
     * Set whether a client that connects to the server must connect using an SSL certificate.
     * Specify Never to allow clients to connect without SSL certificates. Specify Supported to
     * accept clients connecting with and without SSL certificates. Specify Required to require
     * clients to use SSL certificate.
     * 
     * @param clientCertAuth Whether or not to authenticate
     */
    public void setClientCertAuth(String clientCertAuth) {
        this.clientCertAuth = clientCertAuth;
    }
    /**
     * Specifies whether to enable security attribute propagation. Security attribute propagation
     * allows the application server to transport authenticated Subject contents and security
     * context information from one server to another in your configuration.
     * 
     * @return true if attribute propagation is enabled
     */
    public Boolean getEnableAttributePropagation() {
        return enableAttributePropagation;
    }
    /**
     * Set whether to enable security attribute propagation. Security attribute propagation allows
     * the application server to transport authenticated Subject contents and security context
     * information from one server to another in your configuration.
     * 
     * @param enableAttributePropagation true to enable security attribute propagation
     */
    public void setEnableAttributePropagation(Boolean enableAttributePropagation) {
        this.enableAttributePropagation = enableAttributePropagation;
    }
    /**
     * Specifies whether to enable identity assertion. When using the identity assertion
     * authentication method, the security token generated is a <wsse:UsernameToken> element that
     * contains a <wsse:Username> element.
     * 
     * @return true if identity assertion is enabled
     */
    public Boolean getEnableIdentityAssertion() {
        return enableIdentityAssertion;
    }
    /**
     * Set whether to enable identity assertion. When using the identity assertion authentication
     * method, the security token generated is a <wsse:UsernameToken> element that contains a
     * <wsse:Username> element.
     * 
     * @param enableIdentityAssertion true to enable identity assertion
     */
    public void setEnableIdentityAssertion(Boolean enableIdentityAssertion) {
        this.enableIdentityAssertion = enableIdentityAssertion;
    }
    /**
     * Specifies whether clients connecting to this server must specify a user ID and password.
     * 
     * @return Whether clients must specify a user ID and password
     */
    public String getMessageLevelAuth() {
        return messageLevelAuth;
    }
    /**
     * Set whether clients connecting to this server must specify a user ID and password. Specify
     * Never to disable the user ID and password requirement. Specify Supported to accept a user ID
     * and password. Specify Required to require a user ID and password.
     * 
     * @param messageLevelAuth The authentication level
     */
    public void setMessageLevelAuth(String messageLevelAuth) {
        this.messageLevelAuth = messageLevelAuth;
    }
    /**
     * Specifies the SSL configuration alias to use for inbound transport.
     * 
     * @return The SSL configuration
     */
    public String getSslConfiguration() {
        return sslConfiguration;
    }
    /**
     * Set the SSL configuration alias to use for inbound transport.
     * 
     * @param sslConfiguration The SSL configuration alias
     */
    public void setSslConfiguration(String sslConfiguration) {
        this.sslConfiguration = sslConfiguration;
    }
    /**
     * Specifies the authentication mechanism to use.
     * 
     * @return The authentication mechanism to use
     */
    public List<String> getSupportedAuthMechList() {
        return supportedAuthMechList;
    }
    /**
     * Set the authentication mechanism to use. Specify KRB5 for Kerberos authentication, LTPA for
     * Lightweight Third-Party Authentication, BasicAuth for BasicAuth authentication, and custom to
     * use your own authentication token implementation. You can specify more then one in a
     * space-separated list.
     * 
     * @param supportedAuthMechList The List of supported authentication mechanisms
     */
    public void setSupportedAuthMechList(List<String> supportedAuthMechList) {
        this.supportedAuthMechList = supportedAuthMechList;
    }
    /**
     * Lists the external trusted realms.
     * 
     * @return The authentication mechanism to use
     */
    public List<String> getTrustedTargetRealms() {
        return trustedTargetRealms;
    }
    /**
     * @param trustedRealms The list of external trusted realms
     */
    public void setTrustedTargetRealms(List<String> trustedRealms) {
        this.trustedTargetRealms = trustedRealms;
    }
    /**
     * Specifies the transport layer support level.
     * 
     * @return The transport layer support level
     */
    public String getTransportLayer() {
        return transportLayer;
    }
    /**
     * Set the transport layer support level. Specify Never to disable transport layer support.
     * Specify Supported to enable transport layer support. Specify Required to require transport
     * layer support.
     * 
     * @param transportLayer The transport support level
     */
    public void setTransportLayer(String transportLayer) {
        this.transportLayer = transportLayer;
    }
    /**
     * Specifies whether to enable a stateful session.
     * 
     * @return Whether or not a stateful session is enabled
     */
    public Boolean getEnableStatefulSesssion() {
        return enableStatefulSesssion;
    }
    /**
     * Set whether to enable a stateful session.
     * 
     * @param enableStatefulSesssion true to enable a stateful session
     */
    public void setEnableStatefulSesssion(Boolean enableStatefulSesssion) {
        this.enableStatefulSesssion = enableStatefulSesssion;
    }
    /**
     * Specifies whether to use the server identity to establish trust with the target server.
     * 
     * @return true if server identity is used
     */
    public Boolean getUseServerIdentity() {
        return useServerIdentity;
    }
    /**
     * Set whether to use the server identity to establish trust with the target server.
     * 
     * @param useServerIdentity true to use server identity
     */
    public void setUseServerIdentity(Boolean useServerIdentity) {
        this.useServerIdentity = useServerIdentity;
    }
    /**
     * Specifies the trusted identity that the application server uses to establish trust with the target server.
     * 
     * @return The trusted identity
     */
    public String getTrustedId() {
        return trustedId;
    }
    /**
     * Set the trusted identity that the application server uses to establish trust with the target server.
     * 
     * @param trustedId The trusted identity
     */
    public void setTrustedId(String trustedId) {
        this.trustedId = trustedId;
    }
    /**
     * Specifies the password of the trusted server identity.
     * 
     * @return The password
     */
    public String getTrustedIdPassword() {
        return trustedIdPassword;
    }
    /**
     * Set the password of the trusted server identity.
     * 
     * @param trustedIdPassword The password to set
     */
    public void setTrustedIdPassword(String trustedIdPassword) {
        this.trustedIdPassword = trustedIdPassword;
    }
    /**
     * Specifies whether to enable custom outbound identity mapping.
     * 
     * @return true if custom outbound identity mapping is enabled
     */
    public Boolean getEnableOutboundMapping() {
        return enableOutboundMapping;
    }
    /**
     * Set whether to enable custom outbound identity mapping.
     * 
     * @param enableOutboundMapping true to enable custom outbound identity mapping
     */
    public void setEnableOutboundMapping(Boolean enableOutboundMapping) {
        this.enableOutboundMapping = enableOutboundMapping;
    }
    
}
