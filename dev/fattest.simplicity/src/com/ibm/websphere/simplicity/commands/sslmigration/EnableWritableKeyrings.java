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
 * Modify keystore for writable SAF support.  This task is used during the migration process and will create additional writable keystore objects for the control region and servant region keyrings for SSL keystores.
 *   'controlRegionUser': Specify this field if creating a writable keystore object for the control regions keyring.
 *   'servantRegionUser': Specify this field if creating a writable keystore object for the servant regions keyring.
 *   'scopeName': Specifies the management scope.
 *   'keyStoreName': Specifies the unique name to identify the keystore.
 * The required parameters are found in the constructor.
 */
public class EnableWritableKeyrings extends Command {

	private String controlRegionUser;
	private String servantRegionUser;
	private String scopeName;
	private String keyStoreName;

	public EnableWritableKeyrings(String controlRegionUser, String servantRegionUser, String keyStoreName) {
		super("enableWritableKeyrings");
		this.controlRegionUser = controlRegionUser;
		this.servantRegionUser = servantRegionUser;
		this.keyStoreName = keyStoreName;
	}

	/**
	 * Specify this field if creating a writable keystore object for the control regions keyring.
	 */
	public String getControlRegionUser() {
		return this.controlRegionUser;
	}

	/**
	 * Specify this field if creating a writable keystore object for the control regions keyring.
	 */
	public void setControlRegionUser(String value) {
		this.controlRegionUser = value;
	}

	/**
	 * Specify this field if creating a writable keystore object for the servant regions keyring.
	 */
	public String getServantRegionUser() {
		return this.servantRegionUser;
	}

	/**
	 * Specify this field if creating a writable keystore object for the servant regions keyring.
	 */
	public void setServantRegionUser(String value) {
		this.servantRegionUser = value;
	}

	/**
	 * Specifies the management scope.
	 */
	public String getScopeName() {
		return this.scopeName;
	}

	/**
	 * Specifies the management scope.
	 */
	public void setScopeName(String value) {
		this.scopeName = value;
	}

	/**
	 * Specifies the unique name to identify the keystore.
	 */
	public String getKeyStoreName() {
		return this.keyStoreName;
	}

	/**
	 * Specifies the unique name to identify the keystore.
	 */
	public void setKeyStoreName(String value) {
		this.keyStoreName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("controlRegionUser", this.controlRegionUser);
		ret.put("servantRegionUser", this.servantRegionUser);
		if (this.scopeName != null) {
			ret.put("scopeName", this.scopeName);
		}
		ret.put("keyStoreName", this.keyStoreName);
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
