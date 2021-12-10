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

package com.ibm.websphere.simplicity.commands.auditreader;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Binary Audit Log Reader Command
 *   'fileName': Specifies the fully qualified path of the Binary Audit Log
 *   'outputLocation': Specifies the location of the output HTML report
 *   'keyStorePassword': Specifies the password to open the key store.
 *   'dataPoints': Specifies the specific data points to be reported for each audit record
 *   'timeStampFilter': Specifies which timestamp range of records to read and report
 *   'reportMode': Specifies the type of report: basic, complete or custom
 *   'outcomeFilter': Specifies which audit event outcome(s) to read and report
 *   'eventFilter': Specifies which audit event type(s) to read and report
 *   'sequenceFilter': Specifies which sequence of records to read and report
 * The required parameters are found in the constructor.
 */
public class BinaryAuditLogReader extends Command {

	private String fileName;
	private String outputLocation;
	private String keyStorePassword;
	private String dataPoints;
	private String timeStampFilter;
	private String reportMode;
	private String outcomeFilter;
	private String eventFilter;
	private String sequenceFilter;

	public BinaryAuditLogReader(String fileName, String outputLocation) {
		super("binaryAuditLogReader");
		this.fileName = fileName;
		this.outputLocation = outputLocation;
	}

	/**
	 * Specifies the fully qualified path of the Binary Audit Log
	 */
	public String getFileName() {
		return this.fileName;
	}

	/**
	 * Specifies the fully qualified path of the Binary Audit Log
	 */
	public void setFileName(String value) {
		this.fileName = value;
	}

	/**
	 * Specifies the location of the output HTML report
	 */
	public String getOutputLocation() {
		return this.outputLocation;
	}

	/**
	 * Specifies the location of the output HTML report
	 */
	public void setOutputLocation(String value) {
		this.outputLocation = value;
	}

	/**
	 * Specifies the password to open the key store.
	 */
	public String getKeyStorePassword() {
		return this.keyStorePassword;
	}

	/**
	 * Specifies the password to open the key store.
	 */
	public void setKeyStorePassword(String value) {
		this.keyStorePassword = value;
	}

	/**
	 * Specifies the specific data points to be reported for each audit record
	 */
	public String getDataPoints() {
		return this.dataPoints;
	}

	/**
	 * Specifies the specific data points to be reported for each audit record
	 */
	public void setDataPoints(String value) {
		this.dataPoints = value;
	}

	/**
	 * Specifies which timestamp range of records to read and report
	 */
	public String getTimeStampFilter() {
		return this.timeStampFilter;
	}

	/**
	 * Specifies which timestamp range of records to read and report
	 */
	public void setTimeStampFilter(String value) {
		this.timeStampFilter = value;
	}

	/**
	 * Specifies the type of report: basic, complete or custom
	 */
	public String getReportMode() {
		return this.reportMode;
	}

	/**
	 * Specifies the type of report: basic, complete or custom
	 */
	public void setReportMode(String value) {
		this.reportMode = value;
	}

	/**
	 * Specifies which audit event outcome(s) to read and report
	 */
	public String getOutcomeFilter() {
		return this.outcomeFilter;
	}

	/**
	 * Specifies which audit event outcome(s) to read and report
	 */
	public void setOutcomeFilter(String value) {
		this.outcomeFilter = value;
	}

	/**
	 * Specifies which audit event type(s) to read and report
	 */
	public String getEventFilter() {
		return this.eventFilter;
	}

	/**
	 * Specifies which audit event type(s) to read and report
	 */
	public void setEventFilter(String value) {
		this.eventFilter = value;
	}

	/**
	 * Specifies which sequence of records to read and report
	 */
	public String getSequenceFilter() {
		return this.sequenceFilter;
	}

	/**
	 * Specifies which sequence of records to read and report
	 */
	public void setSequenceFilter(String value) {
		this.sequenceFilter = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("fileName", this.fileName);
		ret.put("outputLocation", this.outputLocation);
		if (this.keyStorePassword != null) {
			ret.put("keyStorePassword", this.keyStorePassword);
		}
		if (this.dataPoints != null) {
			ret.put("dataPoints", this.dataPoints);
		}
		if (this.timeStampFilter != null) {
			ret.put("timeStampFilter", this.timeStampFilter);
		}
		if (this.reportMode != null) {
			ret.put("reportMode", this.reportMode);
		}
		if (this.outcomeFilter != null) {
			ret.put("outcomeFilter", this.outcomeFilter);
		}
		if (this.eventFilter != null) {
			ret.put("eventFilter", this.eventFilter);
		}
		if (this.sequenceFilter != null) {
			ret.put("sequenceFilter", this.sequenceFilter);
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
