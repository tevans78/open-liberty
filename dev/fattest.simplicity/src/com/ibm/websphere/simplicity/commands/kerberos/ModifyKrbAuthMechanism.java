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

package com.ibm.websphere.simplicity.commands.kerberos;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * The KRB5 authentication mechanism security object field in the security configuration file is modified based on the user input.
 *   'enabledGssCredDelegate': Indicate whether or not to extract and place the client GSS delegation credential in the subject.
 *   'allowKrbAuthForCsiInbound': Supply value for allowKrbAuthForCsiInbound: true/false.
 *   'allowKrbAuthForCsiOutbound': Supply value for allowKrbAuthForCsiOutbound: true/false.
 *   'krb5Config': Supply directory location and file name of the configuration (krb5.ini or krb5.conf) file.
 *   'krb5Keytab': Supply directory location and file name of the Kerberos keytab file.
 *   'krb5Realm': Supply value for Kerberos realm name.
 *   'serviceName': Supply value for the service name. It is the first component of the Kerberos service principal name.
 *   'trimUserName': Supply value for trimUserName: true/false.
 * The required parameters are found in the constructor.
 */
public class ModifyKrbAuthMechanism extends Command {

	private Boolean enabledGssCredDelegate = true;
	private Boolean allowKrbAuthForCsiInbound = true;
	private Boolean allowKrbAuthForCsiOutbound = true;
	private String krb5Config;
	private String krb5Keytab;
	private String krb5Realm;
	private String serviceName;
	private Boolean trimUserName = true;

	public ModifyKrbAuthMechanism() {
		super("modifyKrbAuthMechanism");
	}

	/**
	 * Indicate whether or not to extract and place the client GSS delegation credential in the subject.
	 */
	public Boolean getEnabledGssCredDelegate() {
		return this.enabledGssCredDelegate;
	}

	/**
	 * Indicate whether or not to extract and place the client GSS delegation credential in the subject.
	 */
	public void setEnabledGssCredDelegate(Boolean value) {
		this.enabledGssCredDelegate = value;
	}

	/**
	 * Supply value for allowKrbAuthForCsiInbound: true/false.
	 */
	public Boolean getAllowKrbAuthForCsiInbound() {
		return this.allowKrbAuthForCsiInbound;
	}

	/**
	 * Supply value for allowKrbAuthForCsiInbound: true/false.
	 */
	public void setAllowKrbAuthForCsiInbound(Boolean value) {
		this.allowKrbAuthForCsiInbound = value;
	}

	/**
	 * Supply value for allowKrbAuthForCsiOutbound: true/false.
	 */
	public Boolean getAllowKrbAuthForCsiOutbound() {
		return this.allowKrbAuthForCsiOutbound;
	}

	/**
	 * Supply value for allowKrbAuthForCsiOutbound: true/false.
	 */
	public void setAllowKrbAuthForCsiOutbound(Boolean value) {
		this.allowKrbAuthForCsiOutbound = value;
	}

	/**
	 * Supply directory location and file name of the configuration (krb5.ini or krb5.conf) file.
	 */
	public String getKrb5Config() {
		return this.krb5Config;
	}

	/**
	 * Supply directory location and file name of the configuration (krb5.ini or krb5.conf) file.
	 */
	public void setKrb5Config(String value) {
		this.krb5Config = value;
	}

	/**
	 * Supply directory location and file name of the Kerberos keytab file.
	 */
	public String getKrb5Keytab() {
		return this.krb5Keytab;
	}

	/**
	 * Supply directory location and file name of the Kerberos keytab file.
	 */
	public void setKrb5Keytab(String value) {
		this.krb5Keytab = value;
	}

	/**
	 * Supply value for Kerberos realm name.
	 */
	public String getKrb5Realm() {
		return this.krb5Realm;
	}

	/**
	 * Supply value for Kerberos realm name.
	 */
	public void setKrb5Realm(String value) {
		this.krb5Realm = value;
	}

	/**
	 * Supply value for the service name. It is the first component of the Kerberos service principal name.
	 */
	public String getServiceName() {
		return this.serviceName;
	}

	/**
	 * Supply value for the service name. It is the first component of the Kerberos service principal name.
	 */
	public void setServiceName(String value) {
		this.serviceName = value;
	}

	/**
	 * Supply value for trimUserName: true/false.
	 */
	public Boolean getTrimUserName() {
		return this.trimUserName;
	}

	/**
	 * Supply value for trimUserName: true/false.
	 */
	public void setTrimUserName(Boolean value) {
		this.trimUserName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.enabledGssCredDelegate != null) {
			ret.put("enabledGssCredDelegate", this.enabledGssCredDelegate);
		}
		if (this.allowKrbAuthForCsiInbound != null) {
			ret.put("allowKrbAuthForCsiInbound", this.allowKrbAuthForCsiInbound);
		}
		if (this.allowKrbAuthForCsiOutbound != null) {
			ret.put("allowKrbAuthForCsiOutbound", this.allowKrbAuthForCsiOutbound);
		}
		if (this.krb5Config != null) {
			ret.put("krb5Config", this.krb5Config);
		}
		if (this.krb5Keytab != null) {
			ret.put("krb5Keytab", this.krb5Keytab);
		}
		if (this.krb5Realm != null) {
			ret.put("krb5Realm", this.krb5Realm);
		}
		if (this.serviceName != null) {
			ret.put("serviceName", this.serviceName);
		}
		if (this.trimUserName != null) {
			ret.put("trimUserName", this.trimUserName);
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
