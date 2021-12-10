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
 * Enable or disable "autostart"
 *   'blaID': ID for the business-level application in any of the following forms:  &lt;bla name&gt;; blaname=&lt;bla name&gt;; WebSphere:blaname=&lt;bla name&gt;; or WebSphere:blaname=&lt;bla name&gt;,blaedition=&lt;bla edition&gt;.  The edition does not need to be specified unless there is more than one edition.
 *   'cuID': ID for the composition unit in any of the following forms:  &lt;cu name&gt;; cuname=&lt;cu name&gt;; WebSphere:cuname=&lt;cu name&gt;; or WebSphere:cuname=&lt;cu name&gt;,cuedition=&lt;cu edition&gt;.  The edition does not need to be specified unless there is more than one edition.
 *   'targetID': The ID of the specified composition unit's target.  Target ID format is as follows: &lt;server name&gt;; &lt;cluster name&gt;; WebSphere:node=&lt;node name&gt;,server=&lt;server name&gt;; or WebSphere:cluster=&lt;cluster name&gt;.
 *   'enable': Specify "true" to enable "autostart", or "false" to disable "autostart".
 * The required parameters are found in the constructor.
 */
public class SetCompUnitTargetAutoStart extends Command {

	private String blaID;
	private String cuID;
	private String targetID;
	private String enable;

	public SetCompUnitTargetAutoStart(String blaID, String cuID, String targetID, String enable) {
		super("setCompUnitTargetAutoStart");
		this.blaID = blaID;
		this.cuID = cuID;
		this.targetID = targetID;
		this.enable = enable;
	}

	/**
	 * ID for the business-level application in any of the following forms:  &lt;bla name&gt;; blaname=&lt;bla name&gt;; WebSphere:blaname=&lt;bla name&gt;; or WebSphere:blaname=&lt;bla name&gt;,blaedition=&lt;bla edition&gt;.  The edition does not need to be specified unless there is more than one edition.
	 */
	public String getBlaID() {
		return this.blaID;
	}

	/**
	 * ID for the business-level application in any of the following forms:  &lt;bla name&gt;; blaname=&lt;bla name&gt;; WebSphere:blaname=&lt;bla name&gt;; or WebSphere:blaname=&lt;bla name&gt;,blaedition=&lt;bla edition&gt;.  The edition does not need to be specified unless there is more than one edition.
	 */
	public void setBlaID(String value) {
		this.blaID = value;
	}

	/**
	 * ID for the composition unit in any of the following forms:  &lt;cu name&gt;; cuname=&lt;cu name&gt;; WebSphere:cuname=&lt;cu name&gt;; or WebSphere:cuname=&lt;cu name&gt;,cuedition=&lt;cu edition&gt;.  The edition does not need to be specified unless there is more than one edition.
	 */
	public String getCuID() {
		return this.cuID;
	}

	/**
	 * ID for the composition unit in any of the following forms:  &lt;cu name&gt;; cuname=&lt;cu name&gt;; WebSphere:cuname=&lt;cu name&gt;; or WebSphere:cuname=&lt;cu name&gt;,cuedition=&lt;cu edition&gt;.  The edition does not need to be specified unless there is more than one edition.
	 */
	public void setCuID(String value) {
		this.cuID = value;
	}

	/**
	 * The ID of the specified composition unit's target.  Target ID format is as follows: &lt;server name&gt;; &lt;cluster name&gt;; WebSphere:node=&lt;node name&gt;,server=&lt;server name&gt;; or WebSphere:cluster=&lt;cluster name&gt;.
	 */
	public String getTargetID() {
		return this.targetID;
	}

	/**
	 * The ID of the specified composition unit's target.  Target ID format is as follows: &lt;server name&gt;; &lt;cluster name&gt;; WebSphere:node=&lt;node name&gt;,server=&lt;server name&gt;; or WebSphere:cluster=&lt;cluster name&gt;.
	 */
	public void setTargetID(String value) {
		this.targetID = value;
	}

	/**
	 * Specify "true" to enable "autostart", or "false" to disable "autostart".
	 */
	public String getEnable() {
		return this.enable;
	}

	/**
	 * Specify "true" to enable "autostart", or "false" to disable "autostart".
	 */
	public void setEnable(String value) {
		this.enable = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("blaID", this.blaID);
		ret.put("cuID", this.cuID);
		ret.put("targetID", this.targetID);
		ret.put("enable", this.enable);
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
