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

package com.ibm.websphere.simplicity.commands.idmgrrepositoryconfig;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Updates a file repository configuration.
 *   'baseDirectory': Base directory where the file is created to store the data
 *   'fileName': File name of the repository
 *   'id': The unique identifier of the repository.
 *   'messageDigestAlgorithm': The message digest algorithm to use for hashing the password
 *   'saltLength': The salt length of the randomly generated salt for password hashing. Default value is 12.
 * The required parameters are found in the constructor.
 */
public class UpdateIdMgrFileRepository extends Command {

	private String baseDirectory;
	private String fileName;
	private String id;
	private String messageDigestAlgorithm;
	private Integer saltLength;

	public UpdateIdMgrFileRepository(String id) {
		super("updateIdMgrFileRepository");
		this.id = id;
	}

	/**
	 * Base directory where the file is created to store the data
	 */
	public String getBaseDirectory() {
		return this.baseDirectory;
	}

	/**
	 * Base directory where the file is created to store the data
	 */
	public void setBaseDirectory(String value) {
		this.baseDirectory = value;
	}

	/**
	 * File name of the repository
	 */
	public String getFileName() {
		return this.fileName;
	}

	/**
	 * File name of the repository
	 */
	public void setFileName(String value) {
		this.fileName = value;
	}

	/**
	 * The unique identifier of the repository.
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * The unique identifier of the repository.
	 */
	public void setId(String value) {
		this.id = value;
	}

	/**
	 * The message digest algorithm to use for hashing the password
	 */
	public String getMessageDigestAlgorithm() {
		return this.messageDigestAlgorithm;
	}

	/**
	 * The message digest algorithm to use for hashing the password
	 */
	public void setMessageDigestAlgorithm(String value) {
		this.messageDigestAlgorithm = value;
	}

	/**
	 * The salt length of the randomly generated salt for password hashing. Default value is 12.
	 */
	public Integer getSaltLength() {
		return this.saltLength;
	}

	/**
	 * The salt length of the randomly generated salt for password hashing. Default value is 12.
	 */
	public void setSaltLength(Integer value) {
		this.saltLength = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.baseDirectory != null) {
			ret.put("baseDirectory", this.baseDirectory);
		}
		if (this.fileName != null) {
			ret.put("fileName", this.fileName);
		}
		ret.put("id", this.id);
		if (this.messageDigestAlgorithm != null) {
			ret.put("messageDigestAlgorithm", this.messageDigestAlgorithm);
		}
		if (this.saltLength != null) {
			ret.put("saltLength", this.saltLength);
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
