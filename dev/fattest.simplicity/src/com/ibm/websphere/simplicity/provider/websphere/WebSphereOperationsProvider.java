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

package com.ibm.websphere.simplicity.provider.websphere;

import java.util.List;

import com.ibm.websphere.simplicity.Cell;
import com.ibm.websphere.simplicity.ConnectionInfo;
import com.ibm.websphere.simplicity.OperationsProviderType;
import com.ibm.websphere.simplicity.provider.Provider;

/**
 * The WebSphereOperationsProvider class is the core interface to 
 * communicating and configuring WebSphere installations. Everything
 * from applications to MBeans to offline configuration management
 * is exposed from this class.
 * <p>
 * Specific protocol providers will implement this class to enable
 * execution of these operations across that protocol.
 */
public abstract class WebSphereOperationsProvider extends Provider {
	
	public WebSphereOperationsProvider(OperationsProviderType type) {
		super(type);
	}

    public abstract List<Cell> getTopology(ConnectionInfo connInfo) throws Exception;

    /**
     * An application operations provider exposes APIs to interact with
     * both individual applications, and all applications as a whole.
     * Such things as starting, stopping, installing and uninstalling
     * applications can be performed from this location.
     * @return An instance of ApplicationOperationsProvider.
     */
    public abstract ApplicationOperationsProvider getApplicationOperationsProvider();
    /**
     * The configuration operations provider enables users to both retrieve
     * and modify off-line configuration data. In addition, it provides easy
     * access to metadata stored in the configuration repository.
     * @return An instance of ConfigurationOperationsProvider.
     */
    public abstract ConfigurationOperationsProvider getConfigurationOperationsProvider();
    /**
     * Logging operations largely consist of client-side, runtime manipulation
     * of WebSphere's internal trace settings. This enables users to toggle
     * between various trace settings during the runtime of their application.
     * @return An instance of LoggingOperationsProvider.
     */
    public abstract LoggingOperationsProvider getLoggingOperationsProvider();
    /**
     * MBeans are runtime entities that expose methods and attributes for
     * discovery and manipulation of runtime settings. The MBean operations
     * provider exposes the APIs that are required to work with MBeans.
     * @return An instance of MBeanOperationsProvider.
     */
    public abstract MBeanOperationsProvider getMBeanOperationsProvider();
    /**
     * The cell operations provider enables users to manage such entities as
     * clusters and node groups, along with other cell-level configuration
     * elements like security, resources, and so on.
     * @return An instance of CellOperationsProvider.
     */
    public abstract CellOperationsProvider getCellOperationsProvider();
    /**
     * The node operations provider exposes methods for interacting with
     * nodes. Things such as getting a node's version or installation data
     * can be performed from this location.
     * @return An instance of {@link NodeOperationsProvider}
     */
    public abstract NodeOperationsProvider getNodeOperationsProvider();
    /**
     * The security operations provider exposes methods for obtaining and configuring
     * security settings for security domains.
     * @return An instance of {@link SecurityOperationsProvider}
     */
    public abstract SecurityOperationsProvider getSecurityOperationsProvider();
    /**
     * This method (and attending class) is deprecated in favor of the new
     * command-line provider APIs.
     * @deprecated
     * @return An instance of FileTransferOperationsProvider.
     */
    public abstract FileTransferOperationsProvider getFileTransferOperationsProvider();
    /**
     * The AdminCommandOperationsProvider exposes direct AdminTask 
     * (for wsadmin) and AdminCommand (for JMX, etc) access independent 
     * of the provider type.
     */
    public abstract AdminCommandOperationsProvider getAdminCommandOperationsProvider();
    
}
