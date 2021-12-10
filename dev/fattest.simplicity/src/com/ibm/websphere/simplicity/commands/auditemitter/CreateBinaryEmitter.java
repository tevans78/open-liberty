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
 * Creates an entry in the audit.xml to reference the configuration of the Binary File Emitter implementation of the Service Provider interface.
 *   'uniqueName': Supply a unique name to identify the implementation.
 *   'auditFilters': Supply references to pre-defined audit filters to apply to this implementation.
 *   'eventFormatterClass': Supply the class name to identify the event formatter.
 *   'className': Supply the class name to identify the implementation.
 *   'fileLocation': Supply the file location for the audit log.
 *   'maxLogs': Supply the maximum number of audit logs to generate before the oldest is rewritten.
 *   'maxFileSize': Supply the maximum size, in MB, of each binary audit log.
 * The required parameters are found in the constructor.
 */
public class CreateBinaryEmitter extends Command {

	private String uniqueName;
	private String auditFilters;
	private String eventFormatterClass;
	private String className;
	private String fileLocation;
	private Integer maxLogs;
	private Integer maxFileSize;

	public CreateBinaryEmitter(String uniqueName, String auditFilters, String className, String fileLocation) {
		super("createBinaryEmitter");
		this.uniqueName = uniqueName;
		this.auditFilters = auditFilters;
		this.className = className;
		this.fileLocation = fileLocation;
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
		ret.put("uniqueName", this.uniqueName);
		ret.put("auditFilters", this.auditFilters);
		if (this.eventFormatterClass != null) {
			ret.put("eventFormatterClass", this.eventFormatterClass);
		}
		ret.put("className", this.className);
		ret.put("fileLocation", this.fileLocation);
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
