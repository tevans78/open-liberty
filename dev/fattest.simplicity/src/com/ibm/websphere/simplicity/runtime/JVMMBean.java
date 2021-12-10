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

import com.ibm.websphere.simplicity.ApplicationServer;

public class JVMMBean extends MBean {
	
	public JVMMBean(ApplicationServer server) throws Exception {
        super(server);
        resolveObjectName("*:type=JVM,node="+scope.getNode().getName()+",process="+scope.getName()+",*");
	}
	
	/**
	 * Identifies the Java Runtime Environment vendor of this Java VM. The value of javaVendor is identical to the value of the system property java.vendor.
	 * @return The JVM vendor
	 * @throws Exception
	 */
	public String getJavaVendor() throws Exception {
		return (String)getAttribute("javaVendor");
	}
	
	/**
	 * Identifies the Java Runtime Environment version of this Java VM. The value of javaVersion is identical to the value of the system property java.version.
	 * @return The version of the JVM
	 * @throws Exception
	 */
	public String getJavaVersion() throws Exception {
		return (String)getAttribute("javaVersion");
	}

	/**
	 * Identifies the node (machine) this JVM is running on. The value of the node attribute is the fully quailified hostname of the node the JVM is running on.
	 * @return The fully quailified hostname of the node the JVM is running on
	 * @throws Exception
	 */
	public String getHostName() throws Exception {
		return (String)getAttribute("node");
	}
	
	public String getHeapSize() throws Exception {
		return (String)getAttribute("heapSize");
	}
	
	public String getFreeMemory() throws Exception {
		return (String)getAttribute("freeMemory");
	}

	/**
	 * @return Max heap memory this JVM will attempt to use
	 * @throws Exception
	 */
	public String getMaxMemory() throws Exception {
		return (String)getAttribute("maxMemory");
	}
	
	/**
	 * @return Max number of heap dumps allowed on disk
	 * @throws Exception
	 */
	public Integer getMaxHeapDumpsOnDisk() throws Exception {
		return (Integer)getAttribute("maxHeapDumpsOnDisk");
	}
	
	/**
	 * Set the max number of heap dumps allowed on disk
	 * @param value The max number of heap dumps
	 * @throws Exception
	 */
	public void setMaxHeapDumpsOnDisk(Integer value) throws Exception {
		setAttribute("maxHeapDumpsOnDisk", value);
	}
	
	/**
	 * Dump the threads for this JVM
	 * @throws Exception
	 */
	public void dumpThreads() throws Exception {
		invoke("dumpThreads");
	}
	
	/**
	 * Gets the system property indicated by the specified key, the same as calling System.getProperty(key).
	 * @param key The name of the system property
	 * @return The value of the specified system property.
	 * @throws Exception
	 */
	public String getProperty(String key) throws Exception {
		return (String)invoke("getProperty", new Object[] { key });
	}

	/**
	 * Returns the IP address of the given host, or null if the host is unknown.
	 * @param hostname Name of the host to lookup
	 * @return The IP address of the host, or null if unknown.
	 * @throws Exception
	 */
	public String getIPAddress(String hostname) throws Exception {
		return (String)invoke("getIPAddress", new Object[] { hostname });
	}

	/**
	 * Gets the current system time in milliseconds, the same as calling System.currentTimeMillis().
	 * @return The current system time in milliseconds.
	 * @throws Exception
	 */
	public Long getCurrentTimeInMillis() throws Exception {
		return (Long)invoke("getCurrentTimeInMillis");
	}
	
	/**
	 * Generates a heap dump for the JVM.  Not supported on Solaris.
	 * @return The file name for the generated heap dump.
	 * @throws Exception
	 */
	public String generateHeapDump() throws Exception {
		return (String)invoke("generateHeapDump");
	}
	
	/**
	 * Generates a heap dump for the JVM.  Not supported on Solaris.
	 * @return The file names for the generated heap dumps.
	 * @throws Exception
	 */
	public String[] generateHeapDumps() throws Exception {
		return (String[])invoke("generateHeapDumps");
	}

	/**
	 * Generate heap dump for all JVMs.  z/OS only?
	 * @param stoken stoken of the region to generate the dump on, if null generates on all of them
	 * @return The file names for the generated heap dumps.
	 * @throws Exception
	 */
	public String[] generateHeapDump(String stoken) throws Exception {
		return (String[])invoke("generateHeapDump", new Object[] { stoken });
	}
	
	/**
	 * Tests if verbose output for the memory system is enabled.  z/OS only?
	 * @return True if verbose output is enabled
	 * @throws Exception
	 */
	public Boolean isVerbose() throws Exception {
		return (Boolean)invoke("isVerbose");
	}
	
	/**
	 * Enables or disables verbose output for the memory system.  z/OS only?
	 * @param value the name of the system property
	 * @param processType the processType - Control, servant, adjunct
	 * @throws Exception
	 */
	public void setVerbose(Boolean value, String processType) throws Exception {
		invoke("setVerbose", new Object[] { value, processType });
	}

}
