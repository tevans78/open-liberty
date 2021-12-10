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

package com.ibm.websphere.simplicity.product;

/**
 * This enum represents an installation type. An installation type represents a software product
 * such as the WebSphere Application Server.
 */
public enum InstallationType {

    /**
     * IBM WebSphere Application Client
     */
    APP_CLIENT_INSTALL,
    /**
     * IBM HTTP Server
     */
    IHS_INSTALL,
    /**
     * WebSphere Application Server
     */
    WAS_INSTALL;
}
