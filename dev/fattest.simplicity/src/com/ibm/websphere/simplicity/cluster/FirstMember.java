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

package com.ibm.websphere.simplicity.cluster;

import com.ibm.websphere.simplicity.NodeGroup;
import com.ibm.websphere.simplicity.Server;

/**
 * FirstMember options for creating a new cluster member.
 */
public class FirstMember {

    private String templateName;
    private Server templateServer;
    private NodeGroup nodeGroup;
    // TODO add support for CoreGroups
    
    /**
     * Optionally specifies the node group to which the new cluster member and each additional
     * cluster member belongs. Each cluster member must reside on nodes in the same node group. If
     * specified, it must be one of the node groups which this member node belongs to. If you do not
     * specify this parameter, the system assigns the first node group listed for the member node.
     * 
     * @return The {@link NodeGroup} for the cluster member
     */
    public NodeGroup getNodeGroup() {
        return nodeGroup;
    }
    /**
     * Optionally specifies the node group to which the new cluster member and each additional
     * cluster member belongs. Each cluster member must reside on nodes in the same node group. If
     * specified, it must be one of the node groups which this member node belongs to. If you do not
     * specify this parameter, the system assigns the first node group listed for the member node.
     * 
     * @param nodeGroup The {@link NodeGroup} on which the cluster member belongs to
     */
    public void setNodeGroup(NodeGroup nodeGroup) {
        this.nodeGroup = nodeGroup;
    }
    /**
     * Optionally specifies the name of an application server template to use when creating the new
     * cluster member. If you specify a template, you cannot specify the templateServer parameter to
     * use an existing application server as a template. You are required to specify either the
     * templateName parameter, or the templateServer parameter in this step.
     * 
     * @return The template name
     */
    public String getTemplateName() {
        return templateName;
    }
    /**
     * Optionally specifies the name of an application server template to use when creating the new
     * cluster member. If you specify a template, you cannot specify the templateServer parameter to
     * use an existing application server as a template. You are required to specify either the
     * templateName parameter, or the templateServer parameter in this step.
     * 
     * @param templateName The application server template to use when creating the new cluster member
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
    /**
     * Optionally specifies the server to use as the model when creating the new cluster
     * member. If you specify the templateServer, you cannot specify the templateName parameter. You
     * are required to specify either the templateName parameter, or the templateServer arameter, in
     * this command step.
     * 
     * @return The template {@link Server} to use as the model when creating the new cluster member
     */
    public Server getTemplateServer() {
        return templateServer;
    }
    /**
     * Optionally specifies the server to use as the model when creating the new cluster
     * member. If you specify the templateServer, you cannot specify the templateName parameter. You
     * are required to specify either the templateName parameter, or the templateServer arameter, in
     * this command step.
     * 
     * @param templateServer The template {@link Server} to use as the model when creating the new cluster member
     */
    public void setTemplateServer(Server templateServer) {
        this.templateServer = templateServer;
    }
    
    
}
