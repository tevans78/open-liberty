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

package com.ibm.websphere.simplicity.commands.auditemitter;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Modifies an audit service provider implementation in the audit.xml file
 *   'emitterRef': Supply a valid reference to an audit service provider implementation.
 *   'customProperties': Specifies a comma separated list of attribute=value custom property pairs to be added to the security object.
 *   'auditFilters': Supply references to pre-defined audit filters to apply to this implementation.
 *   'eventFormatterClass': Supply the class name to identify the event formatter.
 *   'className': Supply the class name to identify the implementation.
 *   'fileLocation': Supply the file location for the audit log.
 *   'maxLogs': Supply the maximum number of audit logs to generate before the oldest is rewritten.
 *   'maxFileSize': Supply the maximum size, in MB, of each binary audit log.
 * The required parameters are found in the constructor.
 */
public class ModifyAuditEmitter extends Command {

	private String emitterRef;
	private String customProperties;
	private String auditFilters;
	private String eventFormatterClass;
	private String className;
	private String fileLocation;
	private Integer maxLogs;
	private Integer maxFileSize;

	public ModifyAuditEmitter(String emitterRef) {
		super("modifyAuditEmitter");
		this.emitterRef = emitterRef;
	}

	/**
	 * Supply a valid reference to an audit service provider implementation.
	 */
	public String getEmitterRef() {
		return this.emitterRef;
	}

	/**
	 * Supply a valid reference to an audit service provider implementation.
	 */
	public void setEmitterRef(String value) {
		this.emitterRef = value;
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
	 * Supply the class name to identify the event formatter.
	 */
	public String getEventFormatterClass() {
		return this.eventFormatterClass;
	}

	/**
	 * Supply the class name to identify the event formatter.
	 */
	public void setEventFormatterClass(String value) {
		this.eventFormatterClass = value;
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

	/**
	 * Supply the file location for the audit log.
	 */
	public String getFileLocation() {
		return this.fileLocation;
	}

	/**
	 * Supply the file location for the audit log.
	 */
	public void setFileLocation(String value) {
		this.fileLocation = value;
	}

	/**
	 * Supply the maximum number of audit logs to generate before the oldest is rewritten.
	 */
	public Integer getMaxLogs() {
		return this.maxLogs;
	}

	/**
	 * Supply the maximum number of audit logs to generate before the oldest is rewritten.
	 */
	public void setMaxLogs(Integer value) {
		this.maxLogs = value;
	}

	/**
	 * Supply the maximum size, in MB, of each binary audit log.
	 */
	public Integer getMaxFileSize() {
		return this.maxFileSize;
	}

	/**
	 * Supply the maximum size, in MB, of each binary audit log.
	 */
	public void setMaxFileSize(Integer value) {
		this.maxFileSize = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("emitterRef", this.emitterRef);
		if (this.customProperties != null) {
			ret.put("customProperties", this.customProperties);
		}
		if (this.auditFilters != null) {
			ret.put("auditFilters", this.auditFilters);
		}
		if (this.eventFormatterClass != null) {
			ret.put("eventFormatterClass", this.eventFormatterClass);
		}
		if (this.className != null) {
			ret.put("className", this.className);
		}
		if (this.fileLocation != null) {
			ret.put("fileLocation", this.fileLocation);
		}
		if (this.maxLogs != null) {
			ret.put("maxLogs", this.maxLogs);
		}
		if (this.maxFileSize != null) {
			ret.put("maxFileSize", this.maxFileSize);
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
