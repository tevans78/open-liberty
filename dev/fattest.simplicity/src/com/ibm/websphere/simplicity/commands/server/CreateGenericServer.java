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
import java.util.ArrayList;
import com.ibm.websphere.simplicity.commands.CommandStep;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Command that creates a server
 *   'name': The Server Name
 *   'templateName': The Template Name
 *   'genUniquePorts': Parameter to generate unique http ports for a server.
 *   'templateLocation': The location where the template is stored. Use system defined location if it is not specified. Using system defined location is recommended.
 *   'specificShortName': The server specific short name is applicable only on zOS platforms. This represents the specific short name of the server. All servers should have unique specific short name. This parameter is optional and when it is not specified a unique specific short name is automatically assigned. The value should be 8 chars or less and all upper case.
 *   'genericShortName': The server generic short name is applicable only on zOS platforms. This represents the generic short name of the server. All members of a cluster should share the same generic short name. Individual servers should have unique generic short name. This parameter is optional and when it is not specified a unique generic short name is automatically assigned. The value should be 8 chars or less and all upper case.
 *   'clusterName': clusterName
 *   'bitmode': bitmode
 * The required parameters are found in the constructor.
 */
public class CreateGenericServer extends Command {

	private String __target;
	private List<Command> __steps;
	private String name;
	private String templateName;
	private Boolean genUniquePorts = true;
	private com.ibm.websphere.simplicity.ConfigIdentifier templateLocation;
	private String specificShortName;
	private String genericShortName;
	private String clusterName;
	private String bitmode;

	public CreateGenericServer(String commandTarget, String name) {
		super("createGenericServer");
		this.__target = commandTarget;
		this.name = name;
	}

	/**
	 * The Server Name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The Server Name
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * The Template Name
	 */
	public String getTemplateName() {
		return this.templateName;
	}

	/**
	 * The Template Name
	 */
	public void setTemplateName(String value) {
		this.templateName = value;
	}

	/**
	 * Parameter to generate unique http ports for a server.
	 */
	public Boolean getGenUniquePorts() {
		return this.genUniquePorts;
	}

	/**
	 * Parameter to generate unique http ports for a server.
	 */
	public void setGenUniquePorts(Boolean value) {
		this.genUniquePorts = value;
	}

	/**
	 * The location where the template is stored. Use system defined location if it is not specified. Using system defined location is recommended.
	 */
	public com.ibm.websphere.simplicity.ConfigIdentifier getTemplateLocation() {
		return this.templateLocation;
	}

	/**
	 * The location where the template is stored. Use system defined location if it is not specified. Using system defined location is recommended.
	 */
	public void setTemplateLocation(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.templateLocation = value;
	}

	/**
	 * The server specific short name is applicable only on zOS platforms. This represents the specific short name of the server. All servers should have unique specific short name. This parameter is optional and when it is not specified a unique specific short name is automatically assigned. The value should be 8 chars or less and all upper case.
	 */
	public String getSpecificShortName() {
		return this.specificShortName;
	}

	/**
	 * The server specific short name is applicable only on zOS platforms. This represents the specific short name of the server. All servers should have unique specific short name. This parameter is optional and when it is not specified a unique specific short name is automatically assigned. The value should be 8 chars or less and all upper case.
	 */
	public void setSpecificShortName(String value) {
		this.specificShortName = value;
	}

	/**
	 * The server generic short name is applicable only on zOS platforms. This represents the generic short name of the server. All members of a cluster should share the same generic short name. Individual servers should have unique generic short name. This parameter is optional and when it is not specified a unique generic short name is automatically assigned. The value should be 8 chars or less and all upper case.
	 */
	public String getGenericShortName() {
		return this.genericShortName;
	}

	/**
	 * The server generic short name is applicable only on zOS platforms. This represents the generic short name of the server. All members of a cluster should share the same generic short name. Individual servers should have unique generic short name. This parameter is optional and when it is not specified a unique generic short name is automatically assigned. The value should be 8 chars or less and all upper case.
	 */
	public void setGenericShortName(String value) {
		this.genericShortName = value;
	}

	/**
	 * clusterName
	 */
	public String getClusterName() {
		return this.clusterName;
	}

	/**
	 * clusterName
	 */
	public void setClusterName(String value) {
		this.clusterName = value;
	}

	/**
	 * bitmode
	 */
	public String getBitmode() {
		return this.bitmode;
	}

	/**
	 * bitmode
	 */
	public void setBitmode(String value) {
		this.bitmode = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(String value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("name", this.name);
		if (this.templateName != null) {
			ret.put("templateName", this.templateName);
		}
		if (this.genUniquePorts != null) {
			ret.put("genUniquePorts", this.genUniquePorts);
		}
		if (this.templateLocation != null) {
			ret.put("templateLocation", this.templateLocation);
		}
		if (this.specificShortName != null) {
			ret.put("specificShortName", this.specificShortName);
		}
		if (this.genericShortName != null) {
			ret.put("genericShortName", this.genericShortName);
		}
		if (this.clusterName != null) {
			ret.put("clusterName", this.clusterName);
		}
		if (this.bitmode != null) {
			ret.put("bitmode", this.bitmode);
		}
		return ret;
	}

	public Object __getTarget() {
		return this.__target;
	}

	public List<Command> __getSteps() {
		return this.__steps;
	}

	/**
	 * Executes the command against the specified scope.
	 * Steps are required by this command, and they appear after the scope parameter.
	 * Classes for these steps are statically available through this admin command class.
	 */
	public OperationResults<Object> run(Scope scope, ConfigProcDef configProcDef) throws Exception {
		this.__steps = new ArrayList<Command>();
		if (configProcDef != null)
			this.__steps.add(configProcDef);
		return super.run(scope);
	}

	/**
	 * Allows user to specify configuration parameters
	 *   'startCommand': The command to run when the generic server is started
	 *   'startCommandArgs': The command line arguments that will be passed to the start command
	 *   'executableTargetKind': Specifies whether a Java classname (use JAVA_CLASS)or the name of an executable Jar file (use EXECUTABLE_JAR) will be used as the executable target for this process.  This field should be left blank for binary executables.
	 *   'executableTarget': The name of the executable target (a Java class containing a main() method or the name of an executable jar), depending on the executable target type.  This field should be left blank for binary executables.
	 *   'workingDirectory': The working directory that will be used for this generic server
	 *   'stopCommand': The command to run when the generic server is stopped
	 *   'stopCommandArgs': The command line arguments that will be passed to the stop command
	 * The required parameters are found in the constructor.
	 */
	public static class ConfigProcDef extends CommandStep {

		private String startCommand;
		private String startCommandArgs;
		private String executableTargetKind;
		private String executableTarget;
		private String workingDirectory;
		private String stopCommand;
		private String stopCommandArgs;

		public ConfigProcDef() {
			super("ConfigProcDef");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			if (this.startCommand != null) {
				ret.put("startCommand", this.startCommand);
			}
			if (this.startCommandArgs != null) {
				ret.put("startCommandArgs", this.startCommandArgs);
			}
			if (this.executableTargetKind != null) {
				ret.put("executableTargetKind", this.executableTargetKind);
			}
			if (this.executableTarget != null) {
				ret.put("executableTarget", this.executableTarget);
			}
			if (this.workingDirectory != null) {
				ret.put("workingDirectory", this.workingDirectory);
			}
			if (this.stopCommand != null) {
				ret.put("stopCommand", this.stopCommand);
			}
			if (this.stopCommandArgs != null) {
				ret.put("stopCommandArgs", this.stopCommandArgs);
			}
			return ret;
		}

		/**
		 * The command to run when the generic server is started
		 */
		public String getStartCommand() {
			return this.startCommand;
		}

		/**
		 * The command to run when the generic server is started
		 */
		public void setStartCommand(String value) {
			this.startCommand = value;
		}

		/**
		 * The command line arguments that will be passed to the start command
		 */
		public String getStartCommandArgs() {
			return this.startCommandArgs;
		}

		/**
		 * The command line arguments that will be passed to the start command
		 */
		public void setStartCommandArgs(String value) {
			this.startCommandArgs = value;
		}

		/**
		 * Specifies whether a Java classname (use JAVA_CLASS)or the name of an executable Jar file (use EXECUTABLE_JAR) will be used as the executable target for this process.  This field should be left blank for binary executables.
		 */
		public String getExecutableTargetKind() {
			return this.executableTargetKind;
		}

		/**
		 * Specifies whether a Java classname (use JAVA_CLASS)or the name of an executable Jar file (use EXECUTABLE_JAR) will be used as the executable target for this process.  This field should be left blank for binary executables.
		 */
		public void setExecutableTargetKind(String value) {
			this.executableTargetKind = value;
		}

		/**
		 * The name of the executable target (a Java class containing a main() method or the name of an executable jar), depending on the executable target type.  This field should be left blank for binary executables.
		 */
		public String getExecutableTarget() {
			return this.executableTarget;
		}

		/**
		 * The name of the executable target (a Java class containing a main() method or the name of an executable jar), depending on the executable target type.  This field should be left blank for binary executables.
		 */
		public void setExecutableTarget(String value) {
			this.executableTarget = value;
		}

		/**
		 * The working directory that will be used for this generic server
		 */
		public String getWorkingDirectory() {
			return this.workingDirectory;
		}

		/**
		 * The working directory that will be used for this generic server
		 */
		public void setWorkingDirectory(String value) {
			this.workingDirectory = value;
		}

		/**
		 * The command to run when the generic server is stopped
		 */
		public String getStopCommand() {
			return this.stopCommand;
		}

		/**
		 * The command to run when the generic server is stopped
		 */
		public void setStopCommand(String value) {
			this.stopCommand = value;
		}

		/**
		 * The command line arguments that will be passed to the stop command
		 */
		public String getStopCommandArgs() {
			return this.stopCommandArgs;
		}

		/**
		 * The command line arguments that will be passed to the stop command
		 */
		public void setStopCommandArgs(String value) {
			this.stopCommandArgs = value;
		}

	}
}
