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
 * Creates a PersonAccount in the default realm.
 *   'cn': The common name of the entity.
 *   'confirmPassword': Used to guarantee and confirm that the confirmPassword is the same as the password.
 *   'mail': The e-mail address of the PersonAccount.
 *   'parent': The parent of the entity.
 *   'password': The password of the user.
 *   'sn': The surname of the entity.
 *   'uid': The UID of the PersonAccount.
 * The required parameters are found in the constructor.
 */
public class CreateUser extends Command {

	private String cn;
	private String confirmPassword;
	private String mail;
	private String parent;
	private String password;
	private String sn;
	private String uid;

	public CreateUser(String cn, String password, String sn, String uid) {
		super("createUser");
		this.cn = cn;
		this.password = password;
		this.sn = sn;
		this.uid = uid;
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
	 * The parent of the entity.
	 */
	public String getParent() {
		return this.parent;
	}

	/**
	 * The parent of the entity.
	 */
	public void setParent(String value) {
		this.parent = value;
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

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("cn", this.cn);
		if (this.confirmPassword != null) {
			ret.put("confirmPassword", this.confirmPassword);
		}
		if (this.mail != null) {
			ret.put("mail", this.mail);
		}
		if (this.parent != null) {
			ret.put("parent", this.parent);
		}
		ret.put("password", this.password);
		ret.put("sn", this.sn);
		ret.put("uid", this.uid);
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
