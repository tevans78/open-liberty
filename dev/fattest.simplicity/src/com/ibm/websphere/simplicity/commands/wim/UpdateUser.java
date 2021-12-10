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

package com.ibm.websphere.simplicity.commands.wim;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Updates the attributes of a user.
 *   'cn': The common name of the entity.
 *   'confirmPassword': Used to guarantee and confirm that the confirmPassword is the same as the password.
 *   'mail': The e-mail address of the PersonAccount.
 *   'password': The password of the user.
 *   'sn': The surname of the entity.
 *   'uid': The UID of the PersonAccount.
 *   'uniqueName': The name that uniquely identifies an object of a virtual member manager entity.
 * The required parameters are found in the constructor.
 */
public class UpdateUser extends Command {

	private String cn;
	private String confirmPassword;
	private String mail;
	private String password;
	private String sn;
	private String uid;
	private String uniqueName;

	public UpdateUser(String uniqueName) {
		super("updateUser");
		this.uniqueName = uniqueName;
	}

	/**
	 * The common name of the entity.
	 */
	public String getCn() {
		return this.cn;
	}

	/**
	 * The common name of the entity.
	 */
	public void setCn(String value) {
		this.cn = value;
	}

	/**
	 * Used to guarantee and confirm that the confirmPassword is the same as the password.
	 */
	public String getConfirmPassword() {
		return this.confirmPassword;
	}

	/**
	 * Used to guarantee and confirm that the confirmPassword is the same as the password.
	 */
	public void setConfirmPassword(String value) {
		this.confirmPassword = value;
	}

	/**
	 * The e-mail address of the PersonAccount.
	 */
	public String getMail() {
		return this.mail;
	}

	/**
	 * The e-mail address of the PersonAccount.
	 */
	public void setMail(String value) {
		this.mail = value;
	}

	/**
	 * The password of the user.
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * The password of the user.
	 */
	public void setPassword(String value) {
		this.password = value;
	}

	/**
	 * The surname of the entity.
	 */
	public String getSn() {
		return this.sn;
	}

	/**
	 * The surname of the entity.
	 */
	public void setSn(String value) {
		this.sn = value;
	}

	/**
	 * The UID of the PersonAccount.
	 */
	public String getUid() {
		return this.uid;
	}

	/**
	 * The UID of the PersonAccount.
	 */
	public void setUid(String value) {
		this.uid = value;
	}

	/**
	 * The name that uniquely identifies an object of a virtual member manager entity.
	 */
	public String getUniqueName() {
		return this.uniqueName;
	}

	/**
	 * The name that uniquely identifies an object of a virtual member manager entity.
	 */
	public void setUniqueName(String value) {
		this.uniqueName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.cn != null) {
			ret.put("cn", this.cn);
		}
		if (this.confirmPassword != null) {
			ret.put("confirmPassword", this.confirmPassword);
		}
		if (this.mail != null) {
			ret.put("mail", this.mail);
		}
		if (this.password != null) {
			ret.put("password", this.password);
		}
		if (this.sn != null) {
			ret.put("sn", this.sn);
		}
		if (this.uid != null) {
			ret.put("uid", this.uid);
		}
		ret.put("uniqueName", this.uniqueName);
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
