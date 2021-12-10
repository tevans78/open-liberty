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

package com.ibm.websphere.simplicity.commands.sslmigration;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Converts old style SSL configuration to new style SSL configurations.  The CONVERT_SSLCONFIGS option will look for old style SSL configuration objects and change them to look like new style SSL configuration objects.  The CONVERT_TO_DEFAULT will go through make convert the whole SSL configuration to the new centralized SSL configuration style, removing the SSL configuraiton direct referencing from the servers.
 *   'sslConversionOption': Specify CONVERT_SSLCONFIGS to convert the SSL configuration objects from the old style SSL configuration object to a new style SSL configuration objects or specify CONVERT_TO_DEFAULT to convert the whole configuration to the new style centralized SSL configuration.
 * The required parameters are found in the constructor.
 */
public class ConvertSSLConfig extends Command {

	private String sslConversionOption;

	public ConvertSSLConfig(String sslConversionOption) {
		super("convertSSLConfig");
		this.sslConversionOption = sslConversionOption;
	}

	/**
	 * Specify CONVERT_SSLCONFIGS to convert the SSL configuration objects from the old style SSL configuration object to a new style SSL configuration objects or specify CONVERT_TO_DEFAULT to convert the whole configuration to the new style centralized SSL configuration.
	 */
	public String getSslConversionOption() {
		return this.sslConversionOption;
	}

	/**
	 * Specify CONVERT_SSLCONFIGS to convert the SSL configuration objects from the old style SSL configuration object to a new style SSL configuration objects or specify CONVERT_TO_DEFAULT to convert the whole configuration to the new style centralized SSL configuration.
	 */
	public void setSslConversionOption(String value) {
		this.sslConversionOption = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("sslConversionOption", this.sslConversionOption);
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
