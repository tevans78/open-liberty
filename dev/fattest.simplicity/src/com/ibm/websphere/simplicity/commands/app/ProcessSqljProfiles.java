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
 * Process the serialized SQLJ profiles that are in an installed application.  Customize the profiles with information for run time and bind static SQL packages in a database.  Refer to the DB2 information center documentation for the commands db2sqljcustomize and db2sqljbind.
 *   'bindOnly': When set to true, only the bind process will be executed.  The SQLJ profiles must be customized before binding can be done.  Default is false.
 *   'appName': The name of an installed application that contains the SQLJ profiles to be processed.
 *   'classpath': A list of the paths to the .jar files that contain the SQLJ customize and bind tools: db2jcc4.jar or db2jcc.jar.  Use / or \\ as a file separator.  If you specify multiple paths for the .jar files, use a blank space to separate them.
 *   'url': The URL for connecting to the database.  The format is jdbc:db2://server_name:port/database_name.
 *   'user': The user name for connecting to the database.
 *   'password': The password for connecting to the database.
 *   'options': Any additional options that are needed by the SQLJ customize and bind tools.  Provide bind options as: -bindoptions "options-string".  Refer to the DB2 information center documentation for the commands db2sqljcustomize and db2sqljbind.
 *   'profiles': A list of the names of the SQLJ profiles to be customized and bound, or the name of a .grp file that contains a list of profile names.  The profile path names must be relative to the application .ear file that contains them.  Use / or \\ as a file separator.  If you specify multiple profile paths, use a blank space to separate them.
 * The required parameters are found in the constructor.
 */
public class ProcessSqljProfiles extends Command {

	private Boolean bindOnly = false;
	private String appName;
	private java.lang.String[] classpath;
	private String url;
	private String user;
	private String password;
	private String options;
	private java.lang.String[] profiles;

	public ProcessSqljProfiles(String appName, java.lang.String[] profiles) {
		super("processSqljProfiles");
		this.appName = appName;
		this.profiles = profiles;
	}

	/**
	 * When set to true, only the bind process will be executed.  The SQLJ profiles must be customized before binding can be done.  Default is false.
	 */
	public Boolean getBindOnly() {
		return this.bindOnly;
	}

	/**
	 * When set to true, only the bind process will be executed.  The SQLJ profiles must be customized before binding can be done.  Default is false.
	 */
	public void setBindOnly(Boolean value) {
		this.bindOnly = value;
	}

	/**
	 * The name of an installed application that contains the SQLJ profiles to be processed.
	 */
	public String getAppName() {
		return this.appName;
	}

	/**
	 * The name of an installed application that contains the SQLJ profiles to be processed.
	 */
	public void setAppName(String value) {
		this.appName = value;
	}

	/**
	 * A list of the paths to the .jar files that contain the SQLJ customize and bind tools: db2jcc4.jar or db2jcc.jar.  Use / or \\ as a file separator.  If you specify multiple paths for the .jar files, use a blank space to separate them.
	 */
	public java.lang.String[] getClasspath() {
		return this.classpath;
	}

	/**
	 * A list of the paths to the .jar files that contain the SQLJ customize and bind tools: db2jcc4.jar or db2jcc.jar.  Use / or \\ as a file separator.  If you specify multiple paths for the .jar files, use a blank space to separate them.
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
	 * Any additional options that are needed by the SQLJ customize and bind tools.  Provide bind options as: -bindoptions "options-string".  Refer to the DB2 information center documentation for the commands db2sqljcustomize and db2sqljbind.
	 */
	public String getOptions() {
		return this.options;
	}

	/**
	 * Any additional options that are needed by the SQLJ customize and bind tools.  Provide bind options as: -bindoptions "options-string".  Refer to the DB2 information center documentation for the commands db2sqljcustomize and db2sqljbind.
	 */
	public void setOptions(String value) {
		this.options = value;
	}

	/**
	 * A list of the names of the SQLJ profiles to be customized and bound, or the name of a .grp file that contains a list of profile names.  The profile path names must be relative to the application .ear file that contains them.  Use / or \\ as a file separator.  If you specify multiple profile paths, use a blank space to separate them.
	 */
	public java.lang.String[] getProfiles() {
		return this.profiles;
	}

	/**
	 * A list of the names of the SQLJ profiles to be customized and bound, or the name of a .grp file that contains a list of profile names.  The profile path names must be relative to the application .ear file that contains them.  Use / or \\ as a file separator.  If you specify multiple profile paths, use a blank space to separate them.
	 */
	public void setProfiles(java.lang.String[] value) {
		this.profiles = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.bindOnly != null) {
			ret.put("bindOnly", this.bindOnly);
		}
		ret.put("appName", this.appName);
		if (this.classpath != null) {
			ret.put("classpath", this.classpath);
		}
		if (this.url != null) {
			ret.put("url", this.url);
		}
		if (this.user != null) {
			ret.put("user", this.user);
		}
		if (this.password != null) {
			ret.put("password", this.password);
		}
		if (this.options != null) {
			ret.put("options", this.options);
		}
		ret.put("profiles", this.profiles);
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
