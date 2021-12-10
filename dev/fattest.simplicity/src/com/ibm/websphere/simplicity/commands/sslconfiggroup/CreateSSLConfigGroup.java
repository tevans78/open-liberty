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

package com.ibm.websphere.simplicity.commands.sslconfiggroup;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Create a SSL Configuration Group.
 *   'direction': Direction for this SSL configuration group, inbound or outbound.
 *   'name': Specifies a unique name to identify an SSL Configuration group.
 *   'sslConfigAliasName': Specifies alias that uniquely identifies a SSL configuration.
 *   'scopeName': Specifies the management scope.
 *   'sslConfigScopeName': Specifies the scope name of the SSL configuration.
 *   'certificateAlias': Specifies a unique name to identify a certificate.
 * The required parameters are found in the constructor.
 */
public class CreateSSLConfigGroup extends Command {

	private String direction;
	private String name;
	private String sslConfigAliasName;
	private String scopeName;
	private String sslConfigScopeName;
	private String certificateAlias;

	public CreateSSLConfigGroup(String direction, String name, String sslConfigAliasName, String certificateAlias) {
		super("createSSLConfigGroup");
		this.direction = direction;
		this.name = name;
		this.sslConfigAliasName = sslConfigAliasName;
		this.certificateAlias = certificateAlias;
	}

	/**
	 * Direction for this SSL configuration group, inbound or outbound.
	 */
	public String getDirection() {
		return this.direction;
	}

	/**
	 * Direction for this SSL configuration group, inbound or outbound.
	 */
	public void setDirection(String value) {
		this.direction = value;
	}

	/**
	 * Specifies a unique name to identify an SSL Configuration group.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Specifies a unique name to identify an SSL Configuration group.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Specifies alias that uniquely identifies a SSL configuration.
	 */
	public String getSslConfigAliasName() {
		return this.sslConfigAliasName;
	}

	/**
	 * Specifies alias that uniquely identifies a SSL configuration.
	 */
	public void setSslConfigAliasName(String value) {
		this.sslConfigAliasName = value;
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
	 * Specifies the scope name of the SSL configuration.
	 */
	public String getSslConfigScopeName() {
		return this.sslConfigScopeName;
	}

	/**
	 * Specifies the scope name of the SSL configuration.
	 */
	public void setSslConfigScopeName(String value) {
		this.sslConfigScopeName = value;
	}

	/**
	 * Specifies a unique name to identify a certificate.
	 */
	public String getCertificateAlias() {
		return this.certificateAlias;
	}

	/**
	 * Specifies a unique name to identify a certificate.
	 */
	public void setCertificateAlias(String value) {
		this.certificateAlias = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("direction", this.direction);
		ret.put("name", this.name);
		ret.put("sslConfigAliasName", this.sslConfigAliasName);
		if (this.scopeName != null) {
			ret.put("scopeName", this.scopeName);
		}
		if (this.sslConfigScopeName != null) {
			ret.put("sslConfigScopeName", this.sslConfigScopeName);
		}
		ret.put("certificateAlias", this.certificateAlias);
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
