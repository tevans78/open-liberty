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

/**
 * This enum contains values for the supported LDAP server types
 */
public enum LDAPServerType {

    IBM_DIRECTORY_SERVER,
    IPLANET,
    NETSCAPE,
    NDS,
    DOMINO502,
    SECUREWAY,
    ACTIVE_DIRECTORY,
    CUSTOM;
}
