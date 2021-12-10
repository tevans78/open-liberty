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
 * Set the process definition of an application server.
 *   'serverName': The name of the Server whose process definition is modified. If there is only one server in the entire configuration, then this parameter is optional.
 *   'nodeName': The name of the node. This is only needed for the server scopes that do not have a unique name across nodes.
 *   'processType': The process type of the server.  This is for zOS only.
 *   'executableName': The executable name that is invoked to start the process. This parameter is only applicable to WebSphere Application Server.
 *   'executableArguments': The arguments that are passed to the process when it is started. This parameter is only applicable to WebSphere Application Server only.
 *   'startCommand': This command applies to the z/OS platform only. It specifies the platform-specific command to launch the server process.
 *   'startCommandArgs': TThis command applies to the z/OS platform only. It specifies any additional arguments required by the start command.
 *   'stopCommand': This parameter applies to the z/OS platform only. It specifies the platform-specific command to stop the server process
 *   'stopCommandArgs': This parameter applies to the z/OS platform only. It specifies any additional arguments required by the stop command.
 *   'terminateCommand': This parameter only applies to the z/OS platform. It specifies the platform-specific command to terminate the server process.
 *   'terminateCommandArgs': This parameter only applies to the z/OS platform. It specifies any additional arguments required by the terminate command.
 *   'workingDirectory': The file system directory that the process uses as its current working directory.
 *   'executableTargetKind': The type of the executable target. &lt;JAVA_CLASS | EXECUTABLE_JAR&gt;
 *   'executableTarget': The name of the executable target (a Java class containing a main() method, or the name of an executable jar), depending on the executable target.
 * The required parameters are found in the constructor.
 */
public class SetProcessDefinition extends Command {

	private String serverName;
	private String nodeName;
	private String processType;
	private String executableName;
	private java.lang.String[] executableArguments;
	private String startCommand;
	private java.lang.String[] startCommandArgs;
	private String stopCommand;
	private java.lang.String[] stopCommandArgs;
	private String terminateCommand;
	private java.lang.String[] terminateCommandArgs;
	private String workingDirectory;
	private String executableTargetKind;
	private String executableTarget;

	public SetProcessDefinition() {
		super("setProcessDefinition");
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
	 * The executable name that is invoked to start the process. This parameter is only applicable to WebSphere Application Server.
	 */
	public String getExecutableName() {
		return this.executableName;
	}

	/**
	 * The executable name that is invoked to start the process. This parameter is only applicable to WebSphere Application Server.
	 */
	public void setExecutableName(String value) {
		this.executableName = value;
	}

	/**
	 * The arguments that are passed to the process when it is started. This parameter is only applicable to WebSphere Application Server only.
	 */
	public java.lang.String[] getExecutableArguments() {
		return this.executableArguments;
	}

	/**
	 * The arguments that are passed to the process when it is started. This parameter is only applicable to WebSphere Application Server only.
	 */
	public void setExecutableArguments(java.lang.String[] value) {
		this.executableArguments = value;
	}

	/**
	 * This command applies to the z/OS platform only. It specifies the platform-specific command to launch the server process.
	 */
	public String getStartCommand() {
		return this.startCommand;
	}

	/**
	 * This command applies to the z/OS platform only. It specifies the platform-specific command to launch the server process.
	 */
	public void setStartCommand(String value) {
		this.startCommand = value;
	}

	/**
	 * TThis command applies to the z/OS platform only. It specifies any additional arguments required by the start command.
	 */
	public java.lang.String[] getStartCommandArgs() {
		return this.startCommandArgs;
	}

	/**
	 * TThis command applies to the z/OS platform only. It specifies any additional arguments required by the start command.
	 */
	public void setStartCommandArgs(java.lang.String[] value) {
		this.startCommandArgs = value;
	}

	/**
	 * This parameter applies to the z/OS platform only. It specifies the platform-specific command to stop the server process
	 */
	public String getStopCommand() {
		return this.stopCommand;
	}

	/**
	 * This parameter applies to the z/OS platform only. It specifies the platform-specific command to stop the server process
	 */
	public void setStopCommand(String value) {
		this.stopCommand = value;
	}

	/**
	 * This parameter applies to the z/OS platform only. It specifies any additional arguments required by the stop command.
	 */
	public java.lang.String[] getStopCommandArgs() {
		return this.stopCommandArgs;
	}

	/**
	 * This parameter applies to the z/OS platform only. It specifies any additional arguments required by the stop command.
	 */
	public void setStopCommandArgs(java.lang.String[] value) {
		this.stopCommandArgs = value;
	}

	/**
	 * This parameter only applies to the z/OS platform. It specifies the platform-specific command to terminate the server process.
	 */
	public String getTerminateCommand() {
		return this.terminateCommand;
	}

	/**
	 * This parameter only applies to the z/OS platform. It specifies the platform-specific command to terminate the server process.
	 */
	public void setTerminateCommand(String value) {
		this.terminateCommand = value;
	}

	/**
	 * This parameter only applies to the z/OS platform. It specifies any additional arguments required by the terminate command.
	 */
	public java.lang.String[] getTerminateCommandArgs() {
		return this.terminateCommandArgs;
	}

	/**
	 * This parameter only applies to the z/OS platform. It specifies any additional arguments required by the terminate command.
	 */
	public void setTerminateCommandArgs(java.lang.String[] value) {
		this.terminateCommandArgs = value;
	}

	/**
	 * The file system directory that the process uses as its current working directory.
	 */
	public String getWorkingDirectory() {
		return this.workingDirectory;
	}

	/**
	 * The file system directory that the process uses as its current working directory.
	 */
	public void setWorkingDirectory(String value) {
		this.workingDirectory = value;
	}

	/**
	 * The type of the executable target. &lt;JAVA_CLASS | EXECUTABLE_JAR&gt;
	 */
	public String getExecutableTargetKind() {
		return this.executableTargetKind;
	}

	/**
	 * The type of the executable target. &lt;JAVA_CLASS | EXECUTABLE_JAR&gt;
	 */
	public void setExecutableTargetKind(String value) {
		this.executableTargetKind = value;
	}

	/**
	 * The name of the executable target (a Java class containing a main() method, or the name of an executable jar), depending on the executable target.
	 */
	public String getExecutableTarget() {
		return this.executableTarget;
	}

	/**
	 * The name of the executable target (a Java class containing a main() method, or the name of an executable jar), depending on the executable target.
	 */
	public void setExecutableTarget(String value) {
		this.executableTarget = value;
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
		if (this.executableName != null) {
			ret.put("executableName", this.executableName);
		}
		if (this.executableArguments != null) {
			ret.put("executableArguments", this.executableArguments);
		}
		if (this.startCommand != null) {
			ret.put("startCommand", this.startCommand);
		}
		if (this.startCommandArgs != null) {
			ret.put("startCommandArgs", this.startCommandArgs);
		}
		if (this.stopCommand != null) {
			ret.put("stopCommand", this.stopCommand);
		}
		if (this.stopCommandArgs != null) {
			ret.put("stopCommandArgs", this.stopCommandArgs);
		}
		if (this.terminateCommand != null) {
			ret.put("terminateCommand", this.terminateCommand);
		}
		if (this.terminateCommandArgs != null) {
			ret.put("terminateCommandArgs", this.terminateCommandArgs);
		}
		if (this.workingDirectory != null) {
			ret.put("workingDirectory", this.workingDirectory);
		}
		if (this.executableTargetKind != null) {
			ret.put("executableTargetKind", this.executableTargetKind);
		}
		if (this.executableTarget != null) {
			ret.put("executableTarget", this.executableTarget);
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
