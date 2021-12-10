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

package com.ibm.websphere.simplicity.commands.app;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Process the pureQuery bind files that are in an installed application.  Bind static SQL packages in a database.  Refer to the information center documentation for the pureQuery bind utility.
 *   'appName': The name of an installed application that contains the pureQuery bind files to be processed.
 *   'classpath': A list of the paths to the .jar files that contain the pureQuery bind utility and its dependencies: pdq.jar, pdqmgmt.jar, and db2jcc4.jar or db2jcc.jar.  Use / or \\ as a file separator.  Use a blank space to separate the paths for the .jar files.
 *   'url': The URL for connecting to the database.  The format is jdbc:db2://server_name:port/database_name.
 *   'user': The user name for connecting to the database.
 *   'password': The password for connecting to the database.
 *   'options': Any additional options that are needed by the pureQuery bind utility.  Provide bind options as: -bindoptions "options-string".  Refer to the information center documentation for the pureQuery bind utility.
 *   'files': A list of the names of the pureQuery bind files to be processed.  The bind file path names must be relative to the application .ear file that contains them.  Use / or \\ as a file separator.  If you specify multiple file paths, use a blank space to separate them.
 * The required parameters are found in the constructor.
 */
public class ProcessPureQueryBindFiles extends Command {

	private String appName;
	private java.lang.String[] classpath;
	private String url;
	private String user;
	private String password;
	private String options;
	private java.lang.String[] files;

	public ProcessPureQueryBindFiles(String appName, String url, java.lang.String[] files) {
		super("processPureQueryBindFiles");
		this.appName = appName;
		this.url = url;
		this.files = files;
	}

	/**
	 * The name of an installed application that contains the pureQuery bind files to be processed.
	 */
	public String getAppName() {
		return this.appName;
	}

	/**
	 * The name of an installed application that contains the pureQuery bind files to be processed.
	 */
	public void setAppName(String value) {
		this.appName = value;
	}

	/**
	 * A list of the paths to the .jar files that contain the pureQuery bind utility and its dependencies: pdq.jar, pdqmgmt.jar, and db2jcc4.jar or db2jcc.jar.  Use / or \\ as a file separator.  Use a blank space to separate the paths for the .jar files.
	 */
	public java.lang.String[] getClasspath() {
		return this.classpath;
	}

	/**
	 * A list of the paths to the .jar files that contain the pureQuery bind utility and its dependencies: pdq.jar, pdqmgmt.jar, and db2jcc4.jar or db2jcc.jar.  Use / or \\ as a file separator.  Use a blank space to separate the paths for the .jar files.
	 */
	public void setClasspath(java.lang.String[] value) {
		this.classpath = value;
	}

	/**
	 * The URL for connecting to the database.  The format is jdbc:db2://server_name:port/database_name.
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * The URL for connecting to the database.  The format is jdbc:db2://server_name:port/database_name.
	 */
	public void setUrl(String value) {
		this.url = value;
	}

	/**
	 * The user name for connecting to the database.
	 */
	public String getUser() {
		return this.user;
	}

	/**
	 * The user name for connecting to the database.
	 */
	public void setUser(String value) {
		this.user = value;
	}

	/**
	 * The password for connecting to the database.
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * The password for connecting to the database.
	 */
	public void setPassword(String value) {
		this.password = value;
	}

	/**
	 * Any additional options that are needed by the pureQuery bind utility.  Provide bind options as: -bindoptions "options-string".  Refer to the information center documentation for the pureQuery bind utility.
	 */
	public String getOptions() {
		return this.options;
	}

	/**
	 * Any additional options that are needed by the pureQuery bind utility.  Provide bind options as: -bindoptions "options-string".  Refer to the information center documentation for the pureQuery bind utility.
	 */
	public void setOptions(String value) {
		this.options = value;
	}

	/**
	 * A list of the names of the pureQuery bind files to be processed.  The bind file path names must be relative to the application .ear file that contains them.  Use / or \\ as a file separator.  If you specify multiple file paths, use a blank space to separate them.
	 */
	public java.lang.String[] getFiles() {
		return this.files;
	}

	/**
	 * A list of the names of the pureQuery bind files to be processed.  The bind file path names must be relative to the application .ear file that contains them.  Use / or \\ as a file separator.  If you specify multiple file paths, use a blank space to separate them.
	 */
	public void setFiles(java.lang.String[] value) {
		this.files = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("appName", this.appName);
		if (this.classpath != null) {
			ret.put("classpath", this.classpath);
		}
		ret.put("url", this.url);
		if (this.user != null) {
			ret.put("user", this.user);
		}
		if (this.password != null) {
			ret.put("password", this.password);
		}
		if (this.options != null) {
			ret.put("options", this.options);
		}
		ret.put("files", this.files);
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
