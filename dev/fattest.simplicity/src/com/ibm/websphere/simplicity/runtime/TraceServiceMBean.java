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

package com.ibm.websphere.simplicity.runtime;

import javax.management.Attribute;
import javax.management.AttributeList;

import com.ibm.websphere.simplicity.log.Log;

/**
 * Represents an instance of TraceServiceMBean for a particular server.  Trace
 * is only generated on a per-server basis, rather than per-node or per-cell.
 */
public class TraceServiceMBean extends MBean {
	
	/**
	 * Identifies the formatting settings for the log output.
	 */
	public static enum TraceFormat {
		/**
		 * The most common trace format setting.  Most trace output is placed on
		 * a single line, with parameters tending to occupy subsequent newlines.
		 */
		BASIC,
		/**
		 * Most trace output occupies two lines with considerably more debugging.
		 * This format is less readable.
		 */
		ADVANCED,
		/**
		 * A format designed for log analyzing software.
		 */
		LOGANALYZER;
		
		/**
		 * Same as valueOf(), but case-insensitive.
		 * @param s The value to convert to a TraceFormat instance.
		 * @return A TraceFormat instance if a case-insensitive match is found, null otherwise.
		 */
		public static TraceFormat fromString(String s) {
			for (TraceFormat type : TraceFormat.values())
				if (type.name().equalsIgnoreCase(s))
					return type;
			return null;
		}
	}
	
	private static Class c = TraceServiceMBean.class;

	public TraceServiceMBean(com.ibm.websphere.simplicity.ApplicationServer scope) throws Exception {
		super(scope);
		resolveObjectName("*:name=TraceService,type=TraceService,node=" + scope.getNode().getName() + ",process=" + scope.getName() + ",*");
	}
	
	/**
	 * Stops any running trace.
	 * @throws Exception
	 */
	public void disableTrace() throws Exception {
		this.invoke("disableTraceOutput");
	}
	
	/**
	 * Retrieves the current trace specification on the target.  It's not
	 * known whether this returns a value when trace is disabled.
	 * @return The current trace specification.
	 * @throws Exception
	 */
	public String getTraceSpecification() throws Exception {
		String[] list = { "traceSpecification" };
		AttributeList attributes = getOperationsProvider().getMBeanAttributes(this.scope, this.objectName, list);
		// If we get here, attribute was found
		Attribute attribute = (Attribute)attributes.get(0);
		return (String)attribute.getValue();
	}
	
	/**
	 * Modifies the target's trace specification.  Trace must be enabled for this
	 * method to take effect.
	 * @param spec The new trace specification.
	 * @throws Exception
	 */
	public void setTraceSpecification(String spec) throws Exception {
		Attribute attrib = new Attribute("traceSpecification", spec);
		AttributeList attributes = new AttributeList();
		attributes.add(attrib);
		getOperationsProvider().setMBeanAttributes(this.scope, this.objectName, attributes);
	}
	
	/**
	 * Modifies the existing trace settings, such as the target file, maximum log size, and so on.
	 * @param filePath The path and file name for the trace file.
	 * @param size The maximum size of the trace file.
	 * @param backups The number of backup trace files of size |size|.
	 * @param traceFormat The format to use for the resulting trace.
	 * @throws Exception
	 */
	public void setLogSettings(String filePath, int size, int backups, TraceFormat traceFormat) throws Exception {
		Log.entering(c, "setLogSettings", new Object[] { filePath, size, backups, traceFormat });
		Object[] args = new Object[4];
		args[0] = filePath;
		args[1] = new Integer(size);
		args[2] = new Integer(backups);
		args[3] = traceFormat.name().toLowerCase();
		this.invoke("setTraceOutputToFile", args);
		Log.exiting(c, "setLogSettings");
	}
	
}
