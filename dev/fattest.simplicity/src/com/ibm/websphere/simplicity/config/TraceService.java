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

package com.ibm.websphere.simplicity.config;

import java.util.HashMap;

import com.ibm.websphere.simplicity.ApplicationServer;
import com.ibm.websphere.simplicity.provider.ConfigAttribute;
import com.ibm.websphere.simplicity.provider.ConfigType;
import com.ibm.websphere.simplicity.runtime.TraceServiceMBean;

/**
 * Provides a concrete API for modifying trace settings in a server's server.xml file.
 */
public class TraceService extends ConfigObjectWrapper {
	
	private static HashMap<ApplicationServer, TraceService> instances = new HashMap<ApplicationServer, TraceService>();
	
	/**
	 * A factory method for obtaining an instance of TraceService for a particular server.
	 * @param server The server whose trace settings will be managed.
	 * @return A TraceService instance for the specified server.
	 * @throws Exception
	 */
	public static TraceService getInstance(ApplicationServer server) throws Exception {
		TraceService ret = instances.get(server);
		if (ret == null) {
			ret = new TraceService(server);
			instances.put(server, ret);
		}
		return ret;
	}
	
	/**
	 * Identifies the trace target.
	 */
	public static enum TraceOutputType {
		SPECIFIED_FILE,
		MEMORY_BUFFER;
		
		/**
		 * Same as valueOf(), but case-insensitive.
		 * @param s The value to convert to a TraceOutputType instance.
		 * @return A TraceOutputType instance if a case-insensitive match is found, null otherwise.
		 */
		public static TraceOutputType fromString(String s) {
			for (TraceOutputType type : TraceOutputType.values())
				if (type.name().equalsIgnoreCase(s))
					return type;
			return null;
		}
	}
	
	/**
	 * Identifies the formatting settings for the log output.
	 */
	public static enum TraceFormat {
		/**
		 * The most common trace format setting.
		 */
		BASIC,
		/**
		 * TODO
		 */
		ADVANCED,
		/**
		 * TODO
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
	
	private TraceServiceMBean mbean;
	private TraceLog traceLog;
	
	private TraceService(ApplicationServer server) throws Exception {
		super(server);

		setConfigObject(ConfigObject.getConfigObject(server, ConfigType.TRACE_SERVICE.getType()));
		ConfigObject traceLogChild = getConfigObject().getChildObjectsByDataType(ConfigType.TRACE_LOG.getType()).get(0);
		this.traceLog = new TraceLog(server, traceLogChild);
	}
	
	@Override
	public ApplicationServer getScope() {
		return (ApplicationServer)super.getScope();
	}
	
	/**
	 * Attempts to retrieve an MBean instance representing trace services on the same server.
	 * @return A TraceServiceMBean instance.
	 * @throws Exception
	 */
	public TraceServiceMBean getMBean() throws Exception {
		if (mbean == null)
			mbean = new TraceServiceMBean(getScope());
		return mbean;
	}
	
	/**
	 * @return True if the trace service is enabled.
	 * @throws Exception
	 */
	public boolean isEnabled() throws Exception {
        Object attribute = getAttribute(ConfigAttribute.ENABLE.getAttribute());
        if(attribute instanceof String) {
            return Boolean.valueOf((String)attribute);
        }
		return (Boolean)attribute;
	}

	/**
	 * @return The current trace specification (e.g. "com.ibm.mypkg.*=all")
	 * @throws Exception
	 */
	public String getTraceSpecification() throws Exception {
		return (String)getAttribute(ConfigAttribute.TRACE_SPECIFICATION.getAttribute());
	}

	/**
	 * @return The configured trace target, either a file or memory.
	 * @throws Exception
	 */
	public TraceOutputType getTraceOutputType() throws Exception {
		String value = (String)getAttribute(ConfigAttribute.TRACE_OUTPUT_TYPE.getAttribute());
		return TraceOutputType.fromString(value);
	}
	
	/**
	 * @return The configured trace format for the log file.
	 * @throws Exception
	 */
	public TraceFormat getTraceFormat() throws Exception {
		String value = (String)getAttribute(ConfigAttribute.TRACE_FORMAT.getAttribute());
		return TraceFormat.fromString(value);
	}
	
	/**
	 * @return The full path to the target log file.
	 * @throws Exception
	 */
	public String getFileName() throws Exception {
		return traceLog.getFileName();
	}
	
	/**
	 * @return The size, in MB, of the log file before WAS starts a new log file (rollover).
	 * @throws Exception
	 */
	public int getRolloverSize() throws Exception {
		return traceLog.getRolloverSize();
	}
	
	/**
	 * @return The maximum number of log files WAS will rollover.
	 * @throws Exception
	 */
	public int getMaxNumberOfBackups() throws Exception {
		return traceLog.getMaxNumberOfBackups();
	}
	
	/**
	 * @param value True if tracing should be enabled.
	 * @throws Exception
	 */
	public void setEnabled(boolean value) throws Exception {
		setAttribute(ConfigAttribute.ENABLE.getAttribute(), value);
	}

	/**
	 * @param value The default trace specification (e.g. "com.ibm.mypkg.*=all").
	 * @throws Exception
	 */
	public void setTraceSpecification(String value) throws Exception {
		setAttribute(ConfigAttribute.TRACE_SPECIFICATION.getAttribute(), value);
	}

	/**
	 * @param value The default trace output target.
	 * @throws Exception
	 */
	public void setTraceOutputType(TraceOutputType value) throws Exception {
		setAttribute(ConfigAttribute.TRACE_OUTPUT_TYPE.getAttribute(), value.name());
	}

	/**
	 * @param value The default trace log format.
	 * @throws Exception
	 */
	public void setTraceFormat(TraceFormat value) throws Exception {
		setAttribute(ConfigAttribute.TRACE_FORMAT.getAttribute(), value.name());
	}
	
	/**
	 * @param value The full path and file name target for a file-based trace log.
	 * @throws Exception
	 */
	public void setFileName(String value) throws Exception {
		traceLog.setFileName(value);
	}

	/**
	 * @param value The size, in MB, at which WAS will start a new log file (rollover).
	 * @throws Exception
	 */
	public void setRolloverSize(int value) throws Exception {
		traceLog.setRolloverSize(value);
	}

	/**
	 * @param value The maximum number of log files WAS will rollover.
	 * @throws Exception
	 */
	public void setMaxNumberOfBackups(int value) throws Exception {
		traceLog.setMaxNumberOfBackups(value);
	}

}

class TraceLog extends ConfigObjectWrapper {
	
	protected TraceLog(ApplicationServer server, ConfigObject object) throws Exception {
		super(server);
		setConfigObject(object);
	}
	
	protected String getFileName() throws Exception {
		return (String)getAttribute(ConfigAttribute.FILE_NAME.getAttribute());
	}
	
	protected int getRolloverSize() throws Exception {
        Object attribute = getAttribute(ConfigAttribute.ROLLOVER_SIZE.getAttribute());
        if(attribute instanceof String) {
            return Integer.valueOf((String)attribute);
        }
		return (Integer)attribute;
	}
	
    // TODO Wsadmin provider should eliminate the need for the "if" statement
	protected int getMaxNumberOfBackups() throws Exception {
        Object attribute = getAttribute(ConfigAttribute.MAX_NUMBER_OF_BACKUP_FILES.getAttribute());
        if(attribute instanceof String) {
            return Integer.valueOf((String)attribute);
        }
		return (Integer)attribute;
	}
	
	protected void setFileName(String value) throws Exception {
		setAttribute(ConfigAttribute.FILE_NAME.getAttribute(), value);
	}
	
	protected void setRolloverSize(int value) throws Exception {
		setAttribute(ConfigAttribute.ROLLOVER_SIZE.getAttribute(), value);
	}
	
	protected void setMaxNumberOfBackups(int value) throws Exception {
		setAttribute(ConfigAttribute.MAX_NUMBER_OF_BACKUP_FILES.getAttribute(), value);
	}
	
}