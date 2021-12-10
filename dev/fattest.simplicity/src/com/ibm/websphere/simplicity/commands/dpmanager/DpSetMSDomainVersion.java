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

package com.ibm.websphere.simplicity.commands.dpmanager;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Use the dpSetMSDomainVersion command to modify a DataPower appliance manager managed domain version.
 *   'msDomainVersionId': Specifies the ID of the managed domain version of interest in the DataPower appliance manager.
 *   'userComment': Specifies the comment to store in the domain version.
 * The required parameters are found in the constructor.
 */
public class DpSetMSDomainVersion extends Command {

	private String msDomainVersionId;
	private String userComment;

	public DpSetMSDomainVersion(String msDomainVersionId) {
		super("dpSetMSDomainVersion");
		this.msDomainVersionId = msDomainVersionId;
	}

	/**
	 * Specifies the ID of the managed domain version of interest in the DataPower appliance manager.
	 */
	public String getMsDomainVersionId() {
		return this.msDomainVersionId;
	}

	/**
	 * Specifies the ID of the managed domain version of interest in the DataPower appliance manager.
	 */
	public void setMsDomainVersionId(String value) {
		this.msDomainVersionId = value;
	}

	/**
	 * Specifies the comment to store in the domain version.
	 */
	public String getUserComment() {
		return this.userComment;
	}

	/**
	 * Specifies the comment to store in the domain version.
	 */
	public void setUserComment(String value) {
		this.userComment = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("msDomainVersionId", this.msDomainVersionId);
		if (this.userComment != null) {
			ret.put("userComment", this.userComment);
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
