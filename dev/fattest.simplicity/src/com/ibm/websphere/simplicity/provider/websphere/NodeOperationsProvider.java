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

import java.util.Properties;

import com.ibm.websphere.simplicity.ConfigIdentifier;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.managedobjectmetadata.GetMetadataProperties;
import com.ibm.websphere.simplicity.commands.server.CreateApplicationServer;
import com.ibm.websphere.simplicity.provider.CategorizedOperationsBase;

/**
 * This class provides operations which are performed on WebSphere Nodes
 */
public abstract class NodeOperationsProvider extends CategorizedOperationsBase {

    public NodeOperationsProvider(WebSphereOperationsProvider parent) {
        super(parent);
    }
    
    /**
     * Get the metadata properties for a node. This metadata properties are found in the node-metadata.properties
     * within the node config directory.
     * 
     * @param result The result of the {@link GetMetadataProperties} AdminTask
     * @return A Java Properties Object containing the metadata properties 
     * @throws Exception
     */
    public abstract Properties getMetadataProperties(Object result) throws Exception;
    
    /**
     * Create a new application server.
     * 
     * @param result The result of the {@link CreateApplicationServer} AdminTask
     * @return An {@link OperationResults} with the {@link ConfigIdentifier} for the new application server
     * @throws Exception
     */
    public abstract OperationResults<ConfigIdentifier> createApplicationServer(Object result) throws Exception;
    
    /**
     * Convert a provider specific id to a {@link ConfigIdentifier}
     * @param configId The result to covert
     * @return The corresponding {@link ConfigIdentifier}
     */
    public abstract ConfigIdentifier convertIdToConfigIdentifier(Object configId);
}
