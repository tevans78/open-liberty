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

package com.ibm.websphere.simplicity.commands.auditeventfactory;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Creates an entry in the audit.xml to reference the configuration of an audit event factory implementation of the Audit Event Factory interface.
 *   'provider': Supply a reference to identify the audit service provider implementation to associate with this audit event factory implementation.
 *   'uniqueName': Supply a unique name to identify the implementation.
 *   'customProperties': Specifies a comma separated list of attribute=value custom property pairs to be added to the security object.
 *   'auditFilters': Supply references to pre-defined audit filters to apply to this implementation.
 *   'className': Supply the class name to identify the implementation.
 * The required parameters are found in the constructor.
 */
public class CreateAuditEventFactory extends Command {

	private String provider;
	private String uniqueName;
	private String customProperties;
	private String auditFilters;
	private String className;

	public CreateAuditEventFactory(String provider, String uniqueName, String auditFilters, String className) {
		super("createAuditEventFactory");
		this.provider = provider;
		this.uniqueName = uniqueName;
		this.auditFilters = auditFilters;
		this.className = className;
	}

	/**
	 * Supply a reference to identify the audit service provider implementation to associate with this audit event factory implementation.
	 */
	public String getProvider() {
		return this.provider;
	}

	/**
	 * Supply a reference to identify the audit service provider implementation to associate with this audit event factory implementation.
	 */
	public void setProvider(String value) {
		this.provider = value;
	}

	/**
	 * Supply a unique name to identify the implementation.
	 */
	public String getUniqueName() {
		return this.uniqueName;
	}

	/**
	 * Supply a unique name to identify the implementation.
	 */
	public void setUniqueName(String value) {
		this.uniqueName = value;
	}

	/**
	 * Specifies a comma separated list of attribute=value custom property pairs to be added to the security object.
	 */
	public String getCustomProperties() {
		return this.customProperties;
	}

	/**
	 * Specifies a comma separated list of attribute=value custom property pairs to be added to the security object.
	 */
	public void setCustomProperties(String value) {
		this.customProperties = value;
	}

	/**
	 * Supply references to pre-defined audit filters to apply to this implementation.
	 */
	public String getAuditFilters() {
		return this.auditFilters;
	}

	/**
	 * Supply references to pre-defined audit filters to apply to this implementation.
	 */
	public void setAuditFilters(String value) {
		this.auditFilters = value;
	}

	/**
	 * Supply the class name to identify the implementation.
	 */
	public String getClassName() {
		return this.className;
	}

	/**
	 * Supply the class name to identify the implementation.
	 */
	public void setClassName(String value) {
		this.className = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("provider", this.provider);
		ret.put("uniqueName", this.uniqueName);
		if (this.customProperties != null) {
			ret.put("customProperties", this.customProperties);
		}
		ret.put("auditFilters", this.auditFilters);
		ret.put("className", this.className);
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
