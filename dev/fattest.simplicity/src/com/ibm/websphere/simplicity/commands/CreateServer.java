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

package com.ibm.websphere.simplicity.commands;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

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
public class CreateServer extends Command {

	private String __target;
	private String name;
	private String templateName;
	private Boolean genUniquePorts = true;
	private com.ibm.websphere.simplicity.ConfigIdentifier templateLocation;
	private String specificShortName;
	private String genericShortName;
	private String clusterName;
	private String bitmode;

	public CreateServer(String commandTarget, String name) {
		super("createServer");
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
		return null;
	}

	/**
	 * Executes the command against the specified scope.
	 */
	public OperationResults<Object> run(Scope scope) throws Exception {
		return super.run(scope);
	}

}
