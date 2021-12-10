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

package com.ibm.websphere.simplicity.commands.auditkeystore;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Modifies a Keystore object.
 *   'keyStoreType': Specifies one of the predefined key store types.
 *   'keyStoreLocation': Specifies the location of the key store file.
 *   'scopeName': Specifies the management scope
 *   'keyStorePassword': Specifies the password to open the key store.
 *   'keyStoreName': Specifies the unique name to identify the key store.
 *   'keyStoreReadOnly': Specifies whether the key store can be written to or not.
 *   'keyStoreInitAtStartup': Specifies whether the key store needs to be initialized at server startup or not.
 *   'keyStoreIsFileBased': Specify true if the key store is file based and false if the key store is remotely managed.
 *   'keyStoreDescription': Statement to describe the key store.
 * The required parameters are found in the constructor.
 */
public class ModifyAuditKeyStore extends Command {

	private String keyStoreType = "PKCS12";
	private String keyStoreLocation;
	private String scopeName;
	private String keyStorePassword;
	private String keyStoreName;
	private Boolean keyStoreReadOnly = false;
	private Boolean keyStoreInitAtStartup = false;
	private Boolean keyStoreIsFileBased = true;
	private String keyStoreDescription;

	public ModifyAuditKeyStore(String keyStoreName) {
		super("modifyAuditKeyStore");
		this.keyStoreName = keyStoreName;
	}

	/**
	 * Specifies one of the predefined key store types.
	 */
	public String getKeyStoreType() {
		return this.keyStoreType;
	}

	/**
	 * Specifies one of the predefined key store types.
	 */
	public void setKeyStoreType(String value) {
		this.keyStoreType = value;
	}

	/**
	 * Specifies the location of the key store file.
	 */
	public String getKeyStoreLocation() {
		return this.keyStoreLocation;
	}

	/**
	 * Specifies the location of the key store file.
	 */
	public void setKeyStoreLocation(String value) {
		this.keyStoreLocation = value;
	}

	/**
	 * Specifies the management scope
	 */
	public String getScopeName() {
		return this.scopeName;
	}

	/**
	 * Specifies the management scope
	 */
	public void setScopeName(String value) {
		this.scopeName = value;
	}

	/**
	 * Specifies the password to open the key store.
	 */
	public String getKeyStorePassword() {
		return this.keyStorePassword;
	}

	/**
	 * Specifies the password to open the key store.
	 */
	public void setKeyStorePassword(String value) {
		this.keyStorePassword = value;
	}

	/**
	 * Specifies the unique name to identify the key store.
	 */
	public String getKeyStoreName() {
		return this.keyStoreName;
	}

	/**
	 * Specifies the unique name to identify the key store.
	 */
	public void setKeyStoreName(String value) {
		this.keyStoreName = value;
	}

	/**
	 * Specifies whether the key store can be written to or not.
	 */
	public Boolean getKeyStoreReadOnly() {
		return this.keyStoreReadOnly;
	}

	/**
	 * Specifies whether the key store can be written to or not.
	 */
	public void setKeyStoreReadOnly(Boolean value) {
		this.keyStoreReadOnly = value;
	}

	/**
	 * Specifies whether the key store needs to be initialized at server startup or not.
	 */
	public Boolean getKeyStoreInitAtStartup() {
		return this.keyStoreInitAtStartup;
	}

	/**
	 * Specifies whether the key store needs to be initialized at server startup or not.
	 */
	public void setKeyStoreInitAtStartup(Boolean value) {
		this.keyStoreInitAtStartup = value;
	}

	/**
	 * Specify true if the key store is file based and false if the key store is remotely managed.
	 */
	public Boolean getKeyStoreIsFileBased() {
		return this.keyStoreIsFileBased;
	}

	/**
	 * Specify true if the key store is file based and false if the key store is remotely managed.
	 */
	public void setKeyStoreIsFileBased(Boolean value) {
		this.keyStoreIsFileBased = value;
	}

	/**
	 * Statement to describe the key store.
	 */
	public String getKeyStoreDescription() {
		return this.keyStoreDescription;
	}

	/**
	 * Statement to describe the key store.
	 */
	public void setKeyStoreDescription(String value) {
		this.keyStoreDescription = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.keyStoreType != null) {
			ret.put("keyStoreType", this.keyStoreType);
		}
		if (this.keyStoreLocation != null) {
			ret.put("keyStoreLocation", this.keyStoreLocation);
		}
		if (this.scopeName != null) {
			ret.put("scopeName", this.scopeName);
		}
		if (this.keyStorePassword != null) {
			ret.put("keyStorePassword", this.keyStorePassword);
		}
		ret.put("keyStoreName", this.keyStoreName);
		if (this.keyStoreReadOnly != null) {
			ret.put("keyStoreReadOnly", this.keyStoreReadOnly);
		}
		if (this.keyStoreInitAtStartup != null) {
			ret.put("keyStoreInitAtStartup", this.keyStoreInitAtStartup);
		}
		if (this.keyStoreIsFileBased != null) {
			ret.put("keyStoreIsFileBased", this.keyStoreIsFileBased);
		}
		if (this.keyStoreDescription != null) {
			ret.put("keyStoreDescription", this.keyStoreDescription);
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
