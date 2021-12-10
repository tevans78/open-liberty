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

package com.ibm.websphere.simplicity;

import java.util.ArrayList;

import javax.management.AttributeList;



/**
 * An Admin Agent subsystem is a kind of proxy -- or single point of contact -- for
 * a registered node.  A registered node is an application server node that has been 
 * registered to an admin agent.  Registered nodes must exist on the same server as
 * the admin agent process.
 * <p>When the application server node has been registered, a subsystem is automatically
 * created to represent that node.  If multiple application server nodes have been
 * registered, then there will be just as many subsystems.
 * <p>After the node has been registered to the admin agent, the preferred approach is
 * to talk to the node through the subsystem, rather than doing so directly through one
 * of the servers in that node.
 */
public class SubSystem extends ApplicationServer {

    /**
     * Constructor
     * 
     * @param configId The {@link ConfigIdentifier} that uniquely identifies this SubSystem
     * @param cell The {@link Cell} to which this SubSystem belongs
     * @param node The {@link Node} to which this SubSystem belongs
     */
	public SubSystem(ConfigIdentifier configId, Cell cell, Node node, ArrayList<AttributeList> portInitData) throws Exception {
		super(configId, cell, node, ServerType.ADMIN_AGENT_SUB_SYSTEM, portInitData);
	}

}
