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

package com.ibm.websphere.simplicity.commands.dynamicsslconfigselection;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Create a Dynamic SSL configuration Selection.
 *   'dynSSLConfigSelectionDescription': Specifies a description of the dynamic SSL configuration selection.
 *   'sslConfigName': Specifies the SSL Configuration used for this dynamic SSL configuration selection.
 *   'dynSSLConfigSelectionInfo': Specifies the host and port information needed for dynamic SSL configuration.
 *   'scopeName': Specifies the management scope.
 *   'dynSSLConfigSelectionName': Specifies the name that uniquely identifies the dynamic SSL configuration selection.
 *   'sslConfigScope': Specifies the scope name of the SSL configuration.
 *   'certificateAlias': Specifies a unique name to identify a certificate.
 * The required parameters are found in the constructor.
 */
public class CreateDynamicSSLConfigSelection extends Command {

	private String dynSSLConfigSelectionDescription;
	private String sslConfigName;
	private String dynSSLConfigSelectionInfo;
	private String scopeName;
	private String dynSSLConfigSelectionName;
	private String sslConfigScope;
	private String certificateAlias;

	public CreateDynamicSSLConfigSelection(String dynSSLConfigSelectionDescription, String sslConfigName, String dynSSLConfigSelectionInfo, String dynSSLConfigSelectionName) {
		super("createDynamicSSLConfigSelection");
		this.dynSSLConfigSelectionDescription = dynSSLConfigSelectionDescription;
		this.sslConfigName = sslConfigName;
		this.dynSSLConfigSelectionInfo = dynSSLConfigSelectionInfo;
		this.dynSSLConfigSelectionName = dynSSLConfigSelectionName;
	}

	/**
	 * Specifies a description of the dynamic SSL configuration selection.
	 */
	public String getDynSSLConfigSelectionDescription() {
		return this.dynSSLConfigSelectionDescription;
	}

	/**
	 * Specifies a description of the dynamic SSL configuration selection.
	 */
	public void setDynSSLConfigSelectionDescription(String value) {
		this.dynSSLConfigSelectionDescription = value;
	}

	/**
	 * Specifies the SSL Configuration used for this dynamic SSL configuration selection.
	 */
	public String getSslConfigName() {
		return this.sslConfigName;
	}

	/**
	 * Specifies the SSL Configuration used for this dynamic SSL configuration selection.
	 */
	public void setSslConfigName(String value) {
		this.sslConfigName = value;
	}

	/**
	 * Specifies the host and port information needed for dynamic SSL configuration.
	 */
	public String getDynSSLConfigSelectionInfo() {
		return this.dynSSLConfigSelectionInfo;
	}

	/**
	 * Specifies the host and port information needed for dynamic SSL configuration.
	 */
	public void setDynSSLConfigSelectionInfo(String value) {
		this.dynSSLConfigSelectionInfo = value;
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
	 * Specifies the name that uniquely identifies the dynamic SSL configuration selection.
	 */
	public String getDynSSLConfigSelectionName() {
		return this.dynSSLConfigSelectionName;
	}

	/**
	 * Specifies the name that uniquely identifies the dynamic SSL configuration selection.
	 */
	public void setDynSSLConfigSelectionName(String value) {
		this.dynSSLConfigSelectionName = value;
	}

	/**
	 * Specifies the scope name of the SSL configuration.
	 */
	public String getSslConfigScope() {
		return this.sslConfigScope;
	}

	/**
	 * Specifies the scope name of the SSL configuration.
	 */
	public void setSslConfigScope(String value) {
		this.sslConfigScope = value;
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
		ret.put("dynSSLConfigSelectionDescription", this.dynSSLConfigSelectionDescription);
		ret.put("sslConfigName", this.sslConfigName);
		ret.put("dynSSLConfigSelectionInfo", this.dynSSLConfigSelectionInfo);
		if (this.scopeName != null) {
			ret.put("scopeName", this.scopeName);
		}
		ret.put("dynSSLConfigSelectionName", this.dynSSLConfigSelectionName);
		if (this.sslConfigScope != null) {
			ret.put("sslConfigScope", this.sslConfigScope);
		}
		if (this.certificateAlias != null) {
			ret.put("certificateAlias", this.certificateAlias);
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
