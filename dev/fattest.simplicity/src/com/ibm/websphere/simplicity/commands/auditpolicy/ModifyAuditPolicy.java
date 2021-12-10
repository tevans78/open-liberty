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

package com.ibm.websphere.simplicity.commands.auditpolicy;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Modifies the audit policy attributes.
 *   'auditPolicy': Describes the behavior of the WebSphere process in the event of an audit failure.
 *   'auditEnabled': Describes the state of audit enablement.
 *   'sign': Enables signing of the audit records.
 *   'encrypt': Enables the encryption of audit records.
 *   'verbose': Enables the verbose capture of audit data.
 *   'encryptionCert': Reference ID of encryption certificate used to encrypt the audit records.
 *   'auditorId': Supply the name of a person given the Auditor role.
 *   'auditorPwd': Supply a unique name to identify the audit specification.
 * The required parameters are found in the constructor.
 */
public class ModifyAuditPolicy extends Command {

	private String auditPolicy;
	private Boolean auditEnabled;
	private Boolean sign;
	private Boolean encrypt;
	private Boolean verbose;
	private String encryptionCert;
	private String auditorId;
	private String auditorPwd;

	public ModifyAuditPolicy() {
		super("modifyAuditPolicy");
	}

	/**
	 * Describes the behavior of the WebSphere process in the event of an audit failure.
	 */
	public String getAuditPolicy() {
		return this.auditPolicy;
	}

	/**
	 * Describes the behavior of the WebSphere process in the event of an audit failure.
	 */
	public void setAuditPolicy(String value) {
		this.auditPolicy = value;
	}

	/**
	 * Describes the state of audit enablement.
	 */
	public Boolean getAuditEnabled() {
		return this.auditEnabled;
	}

	/**
	 * Describes the state of audit enablement.
	 */
	public void setAuditEnabled(Boolean value) {
		this.auditEnabled = value;
	}

	/**
	 * Enables signing of the audit records.
	 */
	public Boolean getSign() {
		return this.sign;
	}

	/**
	 * Enables signing of the audit records.
	 */
	public void setSign(Boolean value) {
		this.sign = value;
	}

	/**
	 * Enables the encryption of audit records.
	 */
	public Boolean getEncrypt() {
		return this.encrypt;
	}

	/**
	 * Enables the encryption of audit records.
	 */
	public void setEncrypt(Boolean value) {
		this.encrypt = value;
	}

	/**
	 * Enables the verbose capture of audit data.
	 */
	public Boolean getVerbose() {
		return this.verbose;
	}

	/**
	 * Enables the verbose capture of audit data.
	 */
	public void setVerbose(Boolean value) {
		this.verbose = value;
	}

	/**
	 * Reference ID of encryption certificate used to encrypt the audit records.
	 */
	public String getEncryptionCert() {
		return this.encryptionCert;
	}

	/**
	 * Reference ID of encryption certificate used to encrypt the audit records.
	 */
	public void setEncryptionCert(String value) {
		this.encryptionCert = value;
	}

	/**
	 * Supply the name of a person given the Auditor role.
	 */
	public String getAuditorId() {
		return this.auditorId;
	}

	/**
	 * Supply the name of a person given the Auditor role.
	 */
	public void setAuditorId(String value) {
		this.auditorId = value;
	}

	/**
	 * Supply a unique name to identify the audit specification.
	 */
	public String getAuditorPwd() {
		return this.auditorPwd;
	}

	/**
	 * Supply a unique name to identify the audit specification.
	 */
	public void setAuditorPwd(String value) {
		this.auditorPwd = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.auditPolicy != null) {
			ret.put("auditPolicy", this.auditPolicy);
		}
		if (this.auditEnabled != null) {
			ret.put("auditEnabled", this.auditEnabled);
		}
		if (this.sign != null) {
			ret.put("sign", this.sign);
		}
		if (this.encrypt != null) {
			ret.put("encrypt", this.encrypt);
		}
		if (this.verbose != null) {
			ret.put("verbose", this.verbose);
		}
		if (this.encryptionCert != null) {
			ret.put("encryptionCert", this.encryptionCert);
		}
		if (this.auditorId != null) {
			ret.put("auditorId", this.auditorId);
		}
		if (this.auditorPwd != null) {
			ret.put("auditorPwd", this.auditorPwd);
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
