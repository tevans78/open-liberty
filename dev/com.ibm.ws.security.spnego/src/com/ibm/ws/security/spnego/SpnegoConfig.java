/*******************************************************************************
 * Copyright (c) 2014, 2020 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.security.spnego;

import org.ietf.jgss.GSSCredential;

/**
 * Represents security configurable options for SPNEGO web.
 */
public interface SpnegoConfig {

    public String getId();

    boolean getAllowLocalHost();

    public boolean isCanonicalHostName();

    public String getKrb5Config();

    public String getKrb5Keytab();

    public String getHostName();

    public boolean getSkipForUnprotectedURI();

    public boolean getDisableFailOverToAppAuthType();

    public boolean isInvokeAfterSSO();

    public String getSpnegoNotSupportedErrorPageURL();

    public String getNtlmTokenReceivedErrorPageURL();

    public String getSpnegoAuthenticationErrorPageURL();

    public boolean isTrimKerberosRealmNameFromPrincipal();

    public boolean isIncludeClientGSSCredentialInSubject();

    public boolean isIncludeCustomCacheKeyInSubject();

    public ErrorPageConfig getErrorPageConfig();

    public GSSCredential getSpnGSSCredential(String hostName);

    boolean isSpnGssCredentialEmpty();

    boolean isDisableLtpaCookie();
}
