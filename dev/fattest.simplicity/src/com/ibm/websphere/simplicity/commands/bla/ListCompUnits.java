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
 * List composition units belonging to a specified business-level application.
 *   'blaID': ID for the business-level application in any of the following forms:  &lt;bla name&gt;; blaname=&lt;bla name&gt;; WebSphere:blaname=&lt;bla name&gt;; or WebSphere:blaname=&lt;bla name&gt;,blaedition=&lt;bla edition&gt;.  The edition does not need to be specified unless there is more than one edition.
 *   'includeType': Include the composition unit type in the listing.
 *   'includeDescription': Controls whether or not the description is included in list output.  Specify a value of "true" to include descriptions, or "false" to omit them.  The default is "false".
 * The required parameters are found in the constructor.
 */
public class ListCompUnits extends Command {

	private String blaID;
	private String includeType;
	private String includeDescription;

	public ListCompUnits(String blaID) {
		super("listCompUnits");
		this.blaID = blaID;
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
	 * Include the composition unit type in the listing.
	 */
	public String getIncludeType() {
		return this.includeType;
	}

	/**
	 * Include the composition unit type in the listing.
	 */
	public void setIncludeType(String value) {
		this.includeType = value;
	}

	/**
	 * Controls whether or not the description is included in list output.  Specify a value of "true" to include descriptions, or "false" to omit them.  The default is "false".
	 */
	public String getIncludeDescription() {
		return this.includeDescription;
	}

	/**
	 * Controls whether or not the description is included in list output.  Specify a value of "true" to include descriptions, or "false" to omit them.  The default is "false".
	 */
	public void setIncludeDescription(String value) {
		this.includeDescription = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("blaID", this.blaID);
		if (this.includeType != null) {
			ret.put("includeType", this.includeType);
		}
		if (this.includeDescription != null) {
			ret.put("includeDescription", this.includeDescription);
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
