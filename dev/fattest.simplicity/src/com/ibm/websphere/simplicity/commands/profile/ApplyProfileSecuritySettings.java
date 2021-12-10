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

package com.ibm.websphere.simplicity.commands.profile;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Applies the security settings selected during install or profile creation time.
 *   'enableAdmin': Supply a true or false value. Updates the administrative security field in the security.xml based on the user input of either true or false.
 *   'adminPwd': Supply an administrative user password.
 *   'adminUser': Supply an administrative user name.
 * The required parameters are found in the constructor.
 */
public class ApplyProfileSecuritySettings extends Command {

	private String enableAdmin;
	private String adminPwd;
	private String adminUser;

	public ApplyProfileSecuritySettings(String enableAdmin) {
		super("applyProfileSecuritySettings");
		this.enableAdmin = enableAdmin;
	}

	/**
	 * Supply a true or false value. Updates the administrative security field in the security.xml based on the user input of either true or false.
	 */
	public String getEnableAdmin() {
		return this.enableAdmin;
	}

	/**
	 * Supply a true or false value. Updates the administrative security field in the security.xml based on the user input of either true or false.
	 */
	public void setEnableAdmin(String value) {
		this.enableAdmin = value;
	}

	/**
	 * Supply an administrative user password.
	 */
	public String getAdminPwd() {
		return this.adminPwd;
	}

	/**
	 * Supply an administrative user password.
	 */
	public void setAdminPwd(String value) {
		this.adminPwd = value;
	}

	/**
	 * Supply an administrative user name.
	 */
	public String getAdminUser() {
		return this.adminUser;
	}

	/**
	 * Supply an administrative user name.
	 */
	public void setAdminUser(String value) {
		this.adminUser = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("enableAdmin", this.enableAdmin);
		if (this.adminPwd != null) {
			ret.put("adminPwd", this.adminPwd);
		}
		if (this.adminUser != null) {
			ret.put("adminUser", this.adminUser);
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
