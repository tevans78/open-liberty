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

package com.ibm.websphere.simplicity.commands.bla;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Determine whether a business-level application or composition unit is running or stopped.
 *   'blaID': getblastatus_blaid_desc
 *   'cuID': The ID for the composition unit for which to obtain run status.  The ID can be specified in any of the following forms:  &lt;cu name&gt;; cuname=&lt;cu name&gt;; WebSphere:cuname=&lt;cu name&gt;; or WebSphere:cuname=&lt;cu name&gt;,cuedition=&lt;cu edition&gt;.  If no composition unit ID is specified, the command returns an aggregate status of all composition units comprising the business-level application.
 *   'targetID': The ID of the target server from which to obtain status.  If no target ID is specified, status includes all servers in the cell.  Target ID format is as follows: WebSphere:node=&lt;node name&gt;,server=&lt;server name&gt; or WebSphere:cluster=&lt;cluster name&gt;.
 * The required parameters are found in the constructor.
 */
public class GetBLAStatus extends Command {

	private String blaID;
	private String cuID;
	private String targetID;

	public GetBLAStatus(String blaID) {
		super("getBLAStatus");
		this.blaID = blaID;
	}

	/**
	 * getblastatus_blaid_desc
	 */
	public String getBlaID() {
		return this.blaID;
	}

	/**
	 * getblastatus_blaid_desc
	 */
	public void setBlaID(String value) {
		this.blaID = value;
	}

	/**
	 * The ID for the composition unit for which to obtain run status.  The ID can be specified in any of the following forms:  &lt;cu name&gt;; cuname=&lt;cu name&gt;; WebSphere:cuname=&lt;cu name&gt;; or WebSphere:cuname=&lt;cu name&gt;,cuedition=&lt;cu edition&gt;.  If no composition unit ID is specified, the command returns an aggregate status of all composition units comprising the business-level application.
	 */
	public String getCuID() {
		return this.cuID;
	}

	/**
	 * The ID for the composition unit for which to obtain run status.  The ID can be specified in any of the following forms:  &lt;cu name&gt;; cuname=&lt;cu name&gt;; WebSphere:cuname=&lt;cu name&gt;; or WebSphere:cuname=&lt;cu name&gt;,cuedition=&lt;cu edition&gt;.  If no composition unit ID is specified, the command returns an aggregate status of all composition units comprising the business-level application.
	 */
	public void setCuID(String value) {
		this.cuID = value;
	}

	/**
	 * The ID of the target server from which to obtain status.  If no target ID is specified, status includes all servers in the cell.  Target ID format is as follows: WebSphere:node=&lt;node name&gt;,server=&lt;server name&gt; or WebSphere:cluster=&lt;cluster name&gt;.
	 */
	public String getTargetID() {
		return this.targetID;
	}

	/**
	 * The ID of the target server from which to obtain status.  If no target ID is specified, status includes all servers in the cell.  Target ID format is as follows: WebSphere:node=&lt;node name&gt;,server=&lt;server name&gt; or WebSphere:cluster=&lt;cluster name&gt;.
	 */
	public void setTargetID(String value) {
		this.targetID = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("blaID", this.blaID);
		if (this.cuID != null) {
			ret.put("cuID", this.cuID);
		}
		if (this.targetID != null) {
			ret.put("targetID", this.targetID);
		}
		return ret;
	}

	public Object __getTarget() {
		return null;
	}

	public List<Command> __getSteps() {
		return null;
	}

	/**
	 * Executes the command against the specified scope.
	 */
	public OperationResults<Object> run(Scope scope) throws Exception {
		return super.run(scope);
	}

}
