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
 * Delete a composition unit from a business-level application.
 *   'blaID': ID for the business-level application in any of the following forms:  &lt;bla name&gt;; blaname=&lt;bla name&gt;; WebSphere:blaname=&lt;bla name&gt;; or WebSphere:blaname=&lt;bla name&gt;,blaedition=&lt;bla edition&gt;.  The edition does not need to be specified unless there is more than one edition.
 *   'cuID': ID for the composition unit in any of the following forms:  &lt;cu name&gt;; cuname=&lt;cu name&gt;; WebSphere:cuname=&lt;cu name&gt;; or WebSphere:cuname=&lt;cu name&gt;,cuedition=&lt;cu edition&gt;.  The edition does not need to be specified unless there is more than one edition.
 *   'force': A value of "true" removes all dependency relationships that other composition units declare on the deleted composition unit.  A value of "false" allows the composition unit to be deleted only if no other composition units declare a dependency on the deleted composition unit.  The default is "false".
 * The required parameters are found in the constructor.
 */
public class DeleteCompUnit extends Command {

	private String blaID;
	private String cuID;
	private String force;

	public DeleteCompUnit(String blaID, String cuID) {
		super("deleteCompUnit");
		this.blaID = blaID;
		this.cuID = cuID;
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
	 * A value of "true" removes all dependency relationships that other composition units declare on the deleted composition unit.  A value of "false" allows the composition unit to be deleted only if no other composition units declare a dependency on the deleted composition unit.  The default is "false".
	 */
	public String getForce() {
		return this.force;
	}

	/**
	 * A value of "true" removes all dependency relationships that other composition units declare on the deleted composition unit.  A value of "false" allows the composition unit to be deleted only if no other composition units declare a dependency on the deleted composition unit.  The default is "false".
	 */
	public void setForce(String value) {
		this.force = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("blaID", this.blaID);
		ret.put("cuID", this.cuID);
		if (this.force != null) {
			ret.put("force", this.force);
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
