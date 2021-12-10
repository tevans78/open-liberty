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

package com.ibm.websphere.simplicity.commands.server;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Set Java virtual machine (JVM) configuration for the application server.
 *   'serverName': The name of the Server whose process definition is modified. If there is only one server in the entire configuration, then this parameter is optional.
 *   'nodeName': The name of the node. This is only needed for the server scopes that do not have a unique name across nodes.
 *   'processType': The process type of the server.  This is for zOS only.
 *   'classpath': The standard class path in which the Java virtual machine code looks for classes.
 *   'bootClasspath': Bootstrap classes and resources for JVM code. This option is only available for JVM instructions that support bootstrap classes and resources. You can separate multiple paths by a colon (:) or semi-colon (;), depending on operating system of the node.
 *   'verboseModeClass': Specifies whether to use verbose debug output for class loading. The default is not to enable verbose class loading.
 *   'verboseModeGarbageCollection': Specifies whether to use verbose debug output for garbage collection. The default is not to enable verbose garbage collection
 *   'verboseModeJNI': Specifies whether to use verbose debug output for native method invocation. The default is not to enable verbose Java Native Interface (JNI) activity.
 *   'initialHeapSize': Specifies the initial heap size available to the JVM code, in megabytes.
 *   'maximumHeapSize': Specifies the maximum heap size available to the JVM code, in megabytes.
 *   'runHProf': This setting applies to base WebSphere Application Server only. It specifies whether to use HProf profiler support. To use another profiler, specify the custom profiler settings using the HProf Arguments setting. The default is not to enable HProf profiler support.
 *   'hprofArguments': This setting applies to base WebSphere Application Server only. It specifies command-line profiler arguments to pass to the JVM code that starts the application server process. You can specify arguments when HProf profiler support is enabled.
 *   'debugMode': Specifies whether to run the JVM in debug mode. The default is not to enable debug mode support.
 *   'debugArgs': Specifies command-line debug arguments to pass to the JVM code that starts the application server process. You can specify arguments when Debug Mode is enabled.
 *   'genericJvmArguments': Specifies command line arguments to pass to the Java virtual machine code that starts the application server process.
 *   'internalClassAccessMode': Specifies the internal Class Access Mode for the JVM.  &lt;ALLOW | RESTRICT&gt;
 *   'executableJarFileName': Specifies a full path name for an executable JAR file that the JVM code uses.
 *   'disableJIT': Specifies whether to disable the just in time (JIT) compiler option of the JVM code.
 *   'osName': Specifies JVM settings for a given operating system. When started, the process uses the JVM settings for the operating system of the node.
 * The required parameters are found in the constructor.
 */
public class SetJVMProperties extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String serverName;
	private String nodeName;
	private String processType;
	private java.lang.String[] classpath;
	private java.lang.String[] bootClasspath;
	private Boolean verboseModeClass;
	private Boolean verboseModeGarbageCollection;
	private Boolean verboseModeJNI;
	private Integer initialHeapSize;
	private Integer maximumHeapSize;
	private Boolean runHProf;
	private String hprofArguments;
	private Boolean debugMode;
	private String debugArgs;
	private String genericJvmArguments;
	private String internalClassAccessMode;
	private String executableJarFileName;
	private Boolean disableJIT;
	private String osName;

	public SetJVMProperties(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget) {
		super("setJVMProperties");
		this.__target = commandTarget;
	}

	/**
	 * The name of the Server whose process definition is modified. If there is only one server in the entire configuration, then this parameter is optional.
	 */
	public String getServerName() {
		return this.serverName;
	}

	/**
	 * The name of the Server whose process definition is modified. If there is only one server in the entire configuration, then this parameter is optional.
	 */
	public void setServerName(String value) {
		this.serverName = value;
	}

	/**
	 * The name of the node. This is only needed for the server scopes that do not have a unique name across nodes.
	 */
	public String getNodeName() {
		return this.nodeName;
	}

	/**
	 * The name of the node. This is only needed for the server scopes that do not have a unique name across nodes.
	 */
	public void setNodeName(String value) {
		this.nodeName = value;
	}

	/**
	 * The process type of the server.  This is for zOS only.
	 */
	public String getProcessType() {
		return this.processType;
	}

	/**
	 * The process type of the server.  This is for zOS only.
	 */
	public void setProcessType(String value) {
		this.processType = value;
	}

	/**
	 * The standard class path in which the Java virtual machine code looks for classes.
	 */
	public java.lang.String[] getClasspath() {
		return this.classpath;
	}

	/**
	 * The standard class path in which the Java virtual machine code looks for classes.
	 */
	public void setClasspath(java.lang.String[] value) {
		this.classpath = value;
	}

	/**
	 * Bootstrap classes and resources for JVM code. This option is only available for JVM instructions that support bootstrap classes and resources. You can separate multiple paths by a colon (:) or semi-colon (;), depending on operating system of the node.
	 */
	public java.lang.String[] getBootClasspath() {
		return this.bootClasspath;
	}

	/**
	 * Bootstrap classes and resources for JVM code. This option is only available for JVM instructions that support bootstrap classes and resources. You can separate multiple paths by a colon (:) or semi-colon (;), depending on operating system of the node.
	 */
	public void setBootClasspath(java.lang.String[] value) {
		this.bootClasspath = value;
	}

	/**
	 * Specifies whether to use verbose debug output for class loading. The default is not to enable verbose class loading.
	 */
	public Boolean getVerboseModeClass() {
		return this.verboseModeClass;
	}

	/**
	 * Specifies whether to use verbose debug output for class loading. The default is not to enable verbose class loading.
	 */
	public void setVerboseModeClass(Boolean value) {
		this.verboseModeClass = value;
	}

	/**
	 * Specifies whether to use verbose debug output for garbage collection. The default is not to enable verbose garbage collection
	 */
	public Boolean getVerboseModeGarbageCollection() {
		return this.verboseModeGarbageCollection;
	}

	/**
	 * Specifies whether to use verbose debug output for garbage collection. The default is not to enable verbose garbage collection
	 */
	public void setVerboseModeGarbageCollection(Boolean value) {
		this.verboseModeGarbageCollection = value;
	}

	/**
	 * Specifies whether to use verbose debug output for native method invocation. The default is not to enable verbose Java Native Interface (JNI) activity.
	 */
	public Boolean getVerboseModeJNI() {
		return this.verboseModeJNI;
	}

	/**
	 * Specifies whether to use verbose debug output for native method invocation. The default is not to enable verbose Java Native Interface (JNI) activity.
	 */
	public void setVerboseModeJNI(Boolean value) {
		this.verboseModeJNI = value;
	}

	/**
	 * Specifies the initial heap size available to the JVM code, in megabytes.
	 */
	public Integer getInitialHeapSize() {
		return this.initialHeapSize;
	}

	/**
	 * Specifies the initial heap size available to the JVM code, in megabytes.
	 */
	public void setInitialHeapSize(Integer value) {
		this.initialHeapSize = value;
	}

	/**
	 * Specifies the maximum heap size available to the JVM code, in megabytes.
	 */
	public Integer getMaximumHeapSize() {
		return this.maximumHeapSize;
	}

	/**
	 * Specifies the maximum heap size available to the JVM code, in megabytes.
	 */
	public void setMaximumHeapSize(Integer value) {
		this.maximumHeapSize = value;
	}

	/**
	 * This setting applies to base WebSphere Application Server only. It specifies whether to use HProf profiler support. To use another profiler, specify the custom profiler settings using the HProf Arguments setting. The default is not to enable HProf profiler support.
	 */
	public Boolean getRunHProf() {
		return this.runHProf;
	}

	/**
	 * This setting applies to base WebSphere Application Server only. It specifies whether to use HProf profiler support. To use another profiler, specify the custom profiler settings using the HProf Arguments setting. The default is not to enable HProf profiler support.
	 */
	public void setRunHProf(Boolean value) {
		this.runHProf = value;
	}

	/**
	 * This setting applies to base WebSphere Application Server only. It specifies command-line profiler arguments to pass to the JVM code that starts the application server process. You can specify arguments when HProf profiler support is enabled.
	 */
	public String getHprofArguments() {
		return this.hprofArguments;
	}

	/**
	 * This setting applies to base WebSphere Application Server only. It specifies command-line profiler arguments to pass to the JVM code that starts the application server process. You can specify arguments when HProf profiler support is enabled.
	 */
	public void setHprofArguments(String value) {
		this.hprofArguments = value;
	}

	/**
	 * Specifies whether to run the JVM in debug mode. The default is not to enable debug mode support.
	 */
	public Boolean getDebugMode() {
		return this.debugMode;
	}

	/**
	 * Specifies whether to run the JVM in debug mode. The default is not to enable debug mode support.
	 */
	public void setDebugMode(Boolean value) {
		this.debugMode = value;
	}

	/**
	 * Specifies command-line debug arguments to pass to the JVM code that starts the application server process. You can specify arguments when Debug Mode is enabled.
	 */
	public String getDebugArgs() {
		return this.debugArgs;
	}

	/**
	 * Specifies command-line debug arguments to pass to the JVM code that starts the application server process. You can specify arguments when Debug Mode is enabled.
	 */
	public void setDebugArgs(String value) {
		this.debugArgs = value;
	}

	/**
	 * Specifies command line arguments to pass to the Java virtual machine code that starts the application server process.
	 */
	public String getGenericJvmArguments() {
		return this.genericJvmArguments;
	}

	/**
	 * Specifies command line arguments to pass to the Java virtual machine code that starts the application server process.
	 */
	public void setGenericJvmArguments(String value) {
		this.genericJvmArguments = value;
	}

	/**
	 * Specifies the internal Class Access Mode for the JVM.  &lt;ALLOW | RESTRICT&gt;
	 */
	public String getInternalClassAccessMode() {
		return this.internalClassAccessMode;
	}

	/**
	 * Specifies the internal Class Access Mode for the JVM.  &lt;ALLOW | RESTRICT&gt;
	 */
	public void setInternalClassAccessMode(String value) {
		this.internalClassAccessMode = value;
	}

	/**
	 * Specifies a full path name for an executable JAR file that the JVM code uses.
	 */
	public String getExecutableJarFileName() {
		return this.executableJarFileName;
	}

	/**
	 * Specifies a full path name for an executable JAR file that the JVM code uses.
	 */
	public void setExecutableJarFileName(String value) {
		this.executableJarFileName = value;
	}

	/**
	 * Specifies whether to disable the just in time (JIT) compiler option of the JVM code.
	 */
	public Boolean getDisableJIT() {
		return this.disableJIT;
	}

	/**
	 * Specifies whether to disable the just in time (JIT) compiler option of the JVM code.
	 */
	public void setDisableJIT(Boolean value) {
		this.disableJIT = value;
	}

	/**
	 * Specifies JVM settings for a given operating system. When started, the process uses the JVM settings for the operating system of the node.
	 */
	public String getOsName() {
		return this.osName;
	}

	/**
	 * Specifies JVM settings for a given operating system. When started, the process uses the JVM settings for the operating system of the node.
	 */
	public void setOsName(String value) {
		this.osName = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.serverName != null) {
			ret.put("serverName", this.serverName);
		}
		if (this.nodeName != null) {
			ret.put("nodeName", this.nodeName);
		}
		if (this.processType != null) {
			ret.put("processType", this.processType);
		}
		if (this.classpath != null) {
			ret.put("classpath", this.classpath);
		}
		if (this.bootClasspath != null) {
			ret.put("bootClasspath", this.bootClasspath);
		}
		if (this.verboseModeClass != null) {
			ret.put("verboseModeClass", this.verboseModeClass);
		}
		if (this.verboseModeGarbageCollection != null) {
			ret.put("verboseModeGarbageCollection", this.verboseModeGarbageCollection);
		}
		if (this.verboseModeJNI != null) {
			ret.put("verboseModeJNI", this.verboseModeJNI);
		}
		if (this.initialHeapSize != null) {
			ret.put("initialHeapSize", this.initialHeapSize);
		}
		if (this.maximumHeapSize != null) {
			ret.put("maximumHeapSize", this.maximumHeapSize);
		}
		if (this.runHProf != null) {
			ret.put("runHProf", this.runHProf);
		}
		if (this.hprofArguments != null) {
			ret.put("hprofArguments", this.hprofArguments);
		}
		if (this.debugMode != null) {
			ret.put("debugMode", this.debugMode);
		}
		if (this.debugArgs != null) {
			ret.put("debugArgs", this.debugArgs);
		}
		if (this.genericJvmArguments != null) {
			ret.put("genericJvmArguments", this.genericJvmArguments);
		}
		if (this.internalClassAccessMode != null) {
			ret.put("internalClassAccessMode", this.internalClassAccessMode);
		}
		if (this.executableJarFileName != null) {
			ret.put("executableJarFileName", this.executableJarFileName);
		}
		if (this.disableJIT != null) {
			ret.put("disableJIT", this.disableJIT);
		}
		if (this.osName != null) {
			ret.put("osName", this.osName);
		}
		return ret;
	}

	public Object __getTarget() {
		return this.__target;
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
