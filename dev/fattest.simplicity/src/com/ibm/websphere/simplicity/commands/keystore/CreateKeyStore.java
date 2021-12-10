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

package com.ibm.websphere.simplicity.commands.keystore;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Creates a new keystore.
 *   'controlRegionUser': Specify this field if creating a writable keystore object for the control regions keyring.
 *   'servantRegionUser': Specify this field if creating a writable keystore object for the servant regions keyring.
 *   'keyStoreHostList': Specifies a comma separated the list of hosts where the keystore is remotely managed.
 *   'keyStoreType': Specifies one of the predefined keystore types.
 *   'keyStorePasswordVerify': Specifies the confirmation of the password to open the keystore.
 *   'keyStoreLocation': Specifies the location of the keystore file.
 *   'scopeName': Specifies the management scope.
 *   'keyStorePassword': Specifies the password to open the keystore.
 *   'keyStoreProvider': Specifies the provider for the keystore.
 *   'keyStoreName': Specifies the unique name to identify the keystore.
 *   'keyStoreReadOnly': Specifies whether the keystore can be written to or not.
 *   'keyStoreInitAtStartup': Specifies whether the keystore needs to be initialized at server startup or not.
 *   'keyStoreStashFile': Specifies whether to stash the keystore password to a file or not.  This only applies to the CMS keystore type.
 *   'keyStoreIsFileBased': Keystore is File Based
 *   'enableCryptoOperations': Specify true to enable cryptographic operations on hardware devices.
 *   'keyStoreDescription': Statement that describes the keystore.
 *   'keyStoreUsage': What the key store can be used for.
 * The required parameters are found in the constructor.
 */
public class CreateKeyStore extends Command {

	private String controlRegionUser;
	private String servantRegionUser;
	private String keyStoreHostList;
	private String keyStoreType = "PKCS12";
	private String keyStorePasswordVerify;
	private String keyStoreLocation;
	private String scopeName;
	private String keyStorePassword;
	private String keyStoreProvider;
	private String keyStoreName;
	private Boolean keyStoreReadOnly = false;
	private Boolean keyStoreInitAtStartup = false;
	private Boolean keyStoreStashFile = false;
	private Boolean keyStoreIsFileBased = true;
	private Boolean enableCryptoOperations;
	private String keyStoreDescription;
	private String keyStoreUsage;

	public CreateKeyStore(String keyStoreType, String keyStoreLocation, String keyStoreName) {
		super("createKeyStore");
		this.keyStoreType = keyStoreType;
		this.keyStoreLocation = keyStoreLocation;
		this.keyStoreName = keyStoreName;
	}

	/**
	 * Specify this field if creating a writable keystore object for the control regions keyring.
	 */
	public String getControlRegionUser() {
		return this.controlRegionUser;
	}

	/**
	 * Specify this field if creating a writable keystore object for the control regions keyring.
	 */
	public void setControlRegionUser(String value) {
		this.controlRegionUser = value;
	}

	/**
	 * Specify this field if creating a writable keystore object for the servant regions keyring.
	 */
	public String getServantRegionUser() {
		return this.servantRegionUser;
	}

	/**
	 * Specify this field if creating a writable keystore object for the servant regions keyring.
	 */
	public void setServantRegionUser(String value) {
		this.servantRegionUser = value;
	}

	/**
	 * Specifies a comma separated the list of hosts where the keystore is remotely managed.
	 */
	public String getKeyStoreHostList() {
		return this.keyStoreHostList;
	}

	/**
	 * Specifies a comma separated the list of hosts where the keystore is remotely managed.
	 */
	public void setKeyStoreHostList(String value) {
		this.keyStoreHostList = value;
	}

	/**
	 * Specifies one of the predefined keystore types.
	 */
	public String getKeyStoreType() {
		return this.keyStoreType;
	}

	/**
	 * Specifies one of the predefined keystore types.
	 */
	public void setKeyStoreType(String value) {
		this.keyStoreType = value;
	}

	/**
	 * Specifies the confirmation of the password to open the keystore.
	 */
	public String getKeyStorePasswordVerify() {
		return this.keyStorePasswordVerify;
	}

	/**
	 * Specifies the confirmation of the password to open the keystore.
	 */
	public void setKeyStorePasswordVerify(String value) {
		this.keyStorePasswordVerify = value;
	}

	/**
	 * Specifies the location of the keystore file.
	 */
	public String getKeyStoreLocation() {
		return this.keyStoreLocation;
	}

	/**
	 * Specifies the location of the keystore file.
	 */
	public void setKeyStoreLocation(String value) {
		this.keyStoreLocation = value;
	}

	/**
	 * Specifies the management scope.
	 */
	public String getScopeName() {
		return this.scopeName;
	}

	/**
	 * Specifies the management scope.
	 */
	public void setScopeName(String value) {
		this.scopeName = value;
	}

	/**
	 * Specifies the password to open the keystore.
	 */
	public String getKeyStorePassword() {
		return this.keyStorePassword;
	}

	/**
	 * Specifies the password to open the keystore.
	 */
	public void setKeyStorePassword(String value) {
		this.keyStorePassword = value;
	}

	/**
	 * Specifies the provider for the keystore.
	 */
	public String getKeyStoreProvider() {
		return this.keyStoreProvider;
	}

	/**
	 * Specifies the provider for the keystore.
	 */
	public void setKeyStoreProvider(String value) {
		this.keyStoreProvider = value;
	}

	/**
	 * Specifies the unique name to identify the keystore.
	 */
	public String getKeyStoreName() {
		return this.keyStoreName;
	}

	/**
	 * Specifies the unique name to identify the keystore.
	 */
	public void setKeyStoreName(String value) {
		this.keyStoreName = value;
	}

	/**
	 * Specifies whether the keystore can be written to or not.
	 */
	public Boolean getKeyStoreReadOnly() {
		return this.keyStoreReadOnly;
	}

	/**
	 * Specifies whether the keystore can be written to or not.
	 */
	public void setKeyStoreReadOnly(Boolean value) {
		this.keyStoreReadOnly = value;
	}

	/**
	 * Specifies whether the keystore needs to be initialized at server startup or not.
	 */
	public Boolean getKeyStoreInitAtStartup() {
		return this.keyStoreInitAtStartup;
	}

	/**
	 * Specifies whether the keystore needs to be initialized at server startup or not.
	 */
	public void setKeyStoreInitAtStartup(Boolean value) {
		this.keyStoreInitAtStartup = value;
	}

	/**
	 * Specifies whether to stash the keystore password to a file or not.  This only applies to the CMS keystore type.
	 */
	public Boolean getKeyStoreStashFile() {
		return this.keyStoreStashFile;
	}

	/**
	 * Specifies whether to stash the keystore password to a file or not.  This only applies to the CMS keystore type.
	 */
	public void setKeyStoreStashFile(Boolean value) {
		this.keyStoreStashFile = value;
	}

	/**
	 * Keystore is File Based
	 */
	public Boolean getKeyStoreIsFileBased() {
		return this.keyStoreIsFileBased;
	}

	/**
	 * Keystore is File Based
	 */
	public void setKeyStoreIsFileBased(Boolean value) {
		this.keyStoreIsFileBased = value;
	}

	/**
	 * Specify true to enable cryptographic operations on hardware devices.
	 */
	public Boolean getEnableCryptoOperations() {
		return this.enableCryptoOperations;
	}

	/**
	 * Specify true to enable cryptographic operations on hardware devices.
	 */
	public void setEnableCryptoOperations(Boolean value) {
		this.enableCryptoOperations = value;
	}

	/**
	 * Statement that describes the keystore.
	 */
	public String getKeyStoreDescription() {
		return this.keyStoreDescription;
	}

	/**
	 * Statement that describes the keystore.
	 */
	public void setKeyStoreDescription(String value) {
		this.keyStoreDescription = value;
	}

	/**
	 * What the key store can be used for.
	 */
	public String getKeyStoreUsage() {
		return this.keyStoreUsage;
	}

	/**
	 * What the key store can be used for.
	 */
	public void setKeyStoreUsage(String value) {
		this.keyStoreUsage = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.controlRegionUser != null) {
			ret.put("controlRegionUser", this.controlRegionUser);
		}
		if (this.servantRegionUser != null) {
			ret.put("servantRegionUser", this.servantRegionUser);
		}
		if (this.keyStoreHostList != null) {
			ret.put("keyStoreHostList", this.keyStoreHostList);
		}
		ret.put("keyStoreType", this.keyStoreType);
		if (this.keyStorePasswordVerify != null) {
			ret.put("keyStorePasswordVerify", this.keyStorePasswordVerify);
		}
		ret.put("keyStoreLocation", this.keyStoreLocation);
		if (this.scopeName != null) {
			ret.put("scopeName", this.scopeName);
		}
		if (this.keyStorePassword != null) {
			ret.put("keyStorePassword", this.keyStorePassword);
		}
		if (this.keyStoreProvider != null) {
			ret.put("keyStoreProvider", this.keyStoreProvider);
		}
		ret.put("keyStoreName", this.keyStoreName);
		if (this.keyStoreReadOnly != null) {
			ret.put("keyStoreReadOnly", this.keyStoreReadOnly);
		}
		if (this.keyStoreInitAtStartup != null) {
			ret.put("keyStoreInitAtStartup", this.keyStoreInitAtStartup);
		}
		if (this.keyStoreStashFile != null) {
			ret.put("keyStoreStashFile", this.keyStoreStashFile);
		}
		if (this.keyStoreIsFileBased != null) {
			ret.put("keyStoreIsFileBased", this.keyStoreIsFileBased);
		}
		if (this.enableCryptoOperations != null) {
			ret.put("enableCryptoOperations", this.enableCryptoOperations);
		}
		if (this.keyStoreDescription != null) {
			ret.put("keyStoreDescription", this.keyStoreDescription);
		}
		if (this.keyStoreUsage != null) {
			ret.put("keyStoreUsage", this.keyStoreUsage);
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
