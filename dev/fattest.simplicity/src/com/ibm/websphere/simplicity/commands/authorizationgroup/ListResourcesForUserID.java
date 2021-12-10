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

package com.ibm.websphere.simplicity.commands.authorizationgroup;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * List all the objects that a given user has access to.
 *   'userid': User ID.
 * The required parameters are found in the constructor.
 */
public class ListResourcesForUserID extends Command {

	private String userid;

	public ListResourcesForUserID(String userid) {
		super("listResourcesForUserID");
		this.userid = userid;
	}

	/**
	 * User ID.
	 */
	public String getUserid() {
		return this.userid;
	}

	/**
	 * User ID.
	 */
	public void setUserid(String value) {
		this.userid = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("userid", this.userid);
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
