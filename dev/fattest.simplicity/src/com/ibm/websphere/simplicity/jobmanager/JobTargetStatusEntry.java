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

package com.ibm.websphere.simplicity.jobmanager;

import java.util.Set;
import java.util.Map.Entry;

import com.ibm.websphere.simplicity.JobManager;
import com.ibm.websphere.simplicity.Node;

public class JobTargetStatusEntry {
	
	private Node node;
	private JobStatusType status;
	
	protected JobTargetStatusEntry(Entry<Object, Object> entry, JobManager scope) throws Exception {
		String nodeAlias = (String)entry.getKey();
		String statusName = (String)entry.getValue();
		init(nodeAlias, statusName, scope);
	}
	
	private void init(String nodeAlias, String statusName, JobManager scope) throws Exception {
		// Find the actual target node
		Set<Node> nodes = scope.getCell().getManagedNodes();
		for (Node node : nodes)
			if (node.getAlias().equalsIgnoreCase(nodeAlias)) {
				this.node = node;
				break;
			}
		if (this.node == null)
			throw new Exception("Unknown node alias: "+nodeAlias);
		
		this.status = JobStatusType.fromTypeName(statusName);
		if (this.status == null)
			throw new Exception("Unknown job status: "+statusName);
	}
	
	public Node getNode() {
		return this.node;
	}
	
	public JobStatusType getStatus() {
		return this.status;
	}

}
