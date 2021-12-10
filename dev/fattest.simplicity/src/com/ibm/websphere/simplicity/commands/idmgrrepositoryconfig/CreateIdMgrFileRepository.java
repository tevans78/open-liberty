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
 * Creates a file repository configuration.
 *   'adapterClassName': The implementation class name for the repository adapter.
 *   'baseDirectory': Base directory where the file is created to store the data
 *   'fileName': File name of the repository
 *   'id': The unique identifier of the repository.
 *   'isExtIdUnique': A boolean representing if the external ID for entities in the repository is unique
 *   'messageDigestAlgorithm': The message digest algorithm to use for hashing the password
 *   'saltLength': The salt length of the randomly generated salt for password hashing. Default value is 12.
 *   'supportAsyncMode': A boolean representing if the adapter supports asynchronous mode
 *   'supportExternalName': A boolean representing if the repository supports external names
 *   'supportPaging': A boolean representing if the repository supports paging
 *   'supportSorting': A boolean representing if the repository supports sorting
 *   'supportTransactions': A boolean representing if the repository supports transactions
 * The required parameters are found in the constructor.
 */
public class CreateIdMgrFileRepository extends Command {

	private String adapterClassName = "com.ibm.ws.wim.adapter.file.was.FileAdapter";
	private String baseDirectory;
	private String fileName;
	private String id;
	private Boolean isExtIdUnique = true;
	private String messageDigestAlgorithm = "SHA-1";
	private Integer saltLength = 12;
	private Boolean supportAsyncMode = false;
	private Boolean supportExternalName = false;
	private Boolean supportPaging = false;
	private Boolean supportSorting = false;
	private Boolean supportTransactions = false;

	public CreateIdMgrFileRepository(String id) {
		super("createIdMgrFileRepository");
		this.id = id;
	}

	/**
	 * The implementation class name for the repository adapter.
	 */
	public String getAdapterClassName() {
		return this.adapterClassName;
	}

	/**
	 * The implementation class name for the repository adapter.
	 */
	public void setAdapterClassName(String value) {
		this.adapterClassName = value;
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
	 * A boolean representing if the external ID for entities in the repository is unique
	 */
	public Boolean getIsExtIdUnique() {
		return this.isExtIdUnique;
	}

	/**
	 * A boolean representing if the external ID for entities in the repository is unique
	 */
	public void setIsExtIdUnique(Boolean value) {
		this.isExtIdUnique = value;
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

	/**
	 * A boolean representing if the adapter supports asynchronous mode
	 */
	public Boolean getSupportAsyncMode() {
		return this.supportAsyncMode;
	}

	/**
	 * A boolean representing if the adapter supports asynchronous mode
	 */
	public void setSupportAsyncMode(Boolean value) {
		this.supportAsyncMode = value;
	}

	/**
	 * A boolean representing if the repository supports external names
	 */
	public Boolean getSupportExternalName() {
		return this.supportExternalName;
	}

	/**
	 * A boolean representing if the repository supports external names
	 */
	public void setSupportExternalName(Boolean value) {
		this.supportExternalName = value;
	}

	/**
	 * A boolean representing if the repository supports paging
	 */
	public Boolean getSupportPaging() {
		return this.supportPaging;
	}

	/**
	 * A boolean representing if the repository supports paging
	 */
	public void setSupportPaging(Boolean value) {
		this.supportPaging = value;
	}

	/**
	 * A boolean representing if the repository supports sorting
	 */
	public Boolean getSupportSorting() {
		return this.supportSorting;
	}

	/**
	 * A boolean representing if the repository supports sorting
	 */
	public void setSupportSorting(Boolean value) {
		this.supportSorting = value;
	}

	/**
	 * A boolean representing if the repository supports transactions
	 */
	public Boolean getSupportTransactions() {
		return this.supportTransactions;
	}

	/**
	 * A boolean representing if the repository supports transactions
	 */
	public void setSupportTransactions(Boolean value) {
		this.supportTransactions = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.adapterClassName != null) {
			ret.put("adapterClassName", this.adapterClassName);
		}
		if (this.baseDirectory != null) {
			ret.put("baseDirectory", this.baseDirectory);
		}
		if (this.fileName != null) {
			ret.put("fileName", this.fileName);
		}
		ret.put("id", this.id);
		if (this.isExtIdUnique != null) {
			ret.put("isExtIdUnique", this.isExtIdUnique);
		}
		if (this.messageDigestAlgorithm != null) {
			ret.put("messageDigestAlgorithm", this.messageDigestAlgorithm);
		}
		if (this.saltLength != null) {
			ret.put("saltLength", this.saltLength);
		}
		if (this.supportAsyncMode != null) {
			ret.put("supportAsyncMode", this.supportAsyncMode);
		}
		if (this.supportExternalName != null) {
			ret.put("supportExternalName", this.supportExternalName);
		}
		if (this.supportPaging != null) {
			ret.put("supportPaging", this.supportPaging);
		}
		if (this.supportSorting != null) {
			ret.put("supportSorting", this.supportSorting);
		}
		if (this.supportTransactions != null) {
			ret.put("supportTransactions", this.supportTransactions);
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
