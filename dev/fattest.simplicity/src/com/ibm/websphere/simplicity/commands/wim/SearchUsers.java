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
 * Searches PersonAccounts.
 *   'cn': The common name of the entity.
 *   'countLimit': The maximum number of entities to return.
 *   'mail': The e-mail address of the PersonAccount.
 *   'principalName': The principal name of a PersonAccount.
 *   'sn': The surname of the entity.
 *   'timeLimit': A maximum amount of time, in milliseconds, to run a search.
 *   'uid': The UID of the PersonAccount.
 * The required parameters are found in the constructor.
 */
public class SearchUsers extends Command {

	private String cn;
	private Integer countLimit = 0;
	private String mail;
	private String principalName;
	private String sn;
	private Integer timeLimit = 0;
	private String uid;

	public SearchUsers() {
		super("searchUsers");
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
	 * The maximum number of entities to return.
	 */
	public Integer getCountLimit() {
		return this.countLimit;
	}

	/**
	 * The maximum number of entities to return.
	 */
	public void setCountLimit(Integer value) {
		this.countLimit = value;
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
	 * The principal name of a PersonAccount.
	 */
	public String getPrincipalName() {
		return this.principalName;
	}

	/**
	 * The principal name of a PersonAccount.
	 */
	public void setPrincipalName(String value) {
		this.principalName = value;
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
	 * A maximum amount of time, in milliseconds, to run a search.
	 */
	public Integer getTimeLimit() {
		return this.timeLimit;
	}

	/**
	 * A maximum amount of time, in milliseconds, to run a search.
	 */
	public void setTimeLimit(Integer value) {
		this.timeLimit = value;
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
		if (this.cn != null) {
			ret.put("cn", this.cn);
		}
		if (this.countLimit != null) {
			ret.put("countLimit", this.countLimit);
		}
		if (this.mail != null) {
			ret.put("mail", this.mail);
		}
		if (this.principalName != null) {
			ret.put("principalName", this.principalName);
		}
		if (this.sn != null) {
			ret.put("sn", this.sn);
		}
		if (this.timeLimit != null) {
			ret.put("timeLimit", this.timeLimit);
		}
		if (this.uid != null) {
			ret.put("uid", this.uid);
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
