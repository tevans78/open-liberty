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

package com.ibm.websphere.simplicity.commands.spnegotai;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * This command displays the SPNEGO TAI properties in the security configuration. If an spnId is not specified, all the SPNEGO TAI properties are displayed.
 *   'spnId': Supply SPN identifier number. If not specified, all SPNEGO TAI configuration properties are displayed.
 * The required parameters are found in the constructor.
 */
public class ShowSpnegoTAIProperties extends Command {

	private Integer spnId;

	public ShowSpnegoTAIProperties() {
		super("showSpnegoTAIProperties");
	}

	/**
	 * Supply SPN identifier number. If not specified, all SPNEGO TAI configuration properties are displayed.
	 */
	public Integer getSpnId() {
		return this.spnId;
	}

	/**
	 * Supply SPN identifier number. If not specified, all SPNEGO TAI configuration properties are displayed.
	 */
	public void setSpnId(Integer value) {
		this.spnId = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.spnId != null) {
			ret.put("spnId", this.spnId);
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
