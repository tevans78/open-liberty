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

package com.ibm.websphere.simplicity.commands.profilecreation;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Prepare keys and keystores for a profile creation.
 *   'defaultCertDN': Distinguished  name (DN) to be given to the servers default certificate.
 *   'rootCertDN': Distinguished name (DN) to be given to the server root certificate.
 *   'importRootCertAlias': Specifies the alias of the certificate to import and use as the default certificate.
 *   'cellName': Specifies the name of the cell as it appears in the repository root, e.g., /config/cells/&lt;cellname&gt;.
 *   'nodeName': Specifies the node name as it appears in the repository, e.g., /config/cells/&lt;cellname&gt;/nodes/&lt;nodename&gt;.
 *   'importRootCertKSPassword': Specifies the password of the key store file containing the root certificate.
 *   'keyStorePassword': Specifies the password to use as the default password for each key store created during profile creation.
 *   'importRootCertKS': Specifies the path to the key store file where the root certificate will be imported from.
 *   'profileRoot': Specifies the fully qualified profile path for the type of profile being created, e.g., c:/WebSphere/AppServer/profiles/AppSrv01.
 *   'importRootCertKSType': Specifies the type of the key store file containing the root certificate.
 *   'regenCerts': Specify true to regenerate certificates for the profile.
 *   'skipLTPAKeys': skipLTPADesc
 *   'rootCertValidityPeriod': The number of years root the certificate will be valid.
 *   'defaultCertValidityPeriod': The number of years the default certificate will be valid
 *   'importDefaultCertKS': The path to the key store where the servers default certificate will be imported from.
 *   'importDefaultCertAlias': Alias of certificate to use as the default certificate
 *   'importDefaultCertKSPassword': The password of the key store containing the default certificate.
 *   'importDefaultCertKSType': The type of the key store containing the default certificate.
 * The required parameters are found in the constructor.
 */
public class PrepareKeysForSingleProfile extends Command {

	private String defaultCertDN;
	private String rootCertDN;
	private String importRootCertAlias;
	private String cellName;
	private String nodeName;
	private String importRootCertKSPassword;
	private String keyStorePassword;
	private String importRootCertKS;
	private String profileRoot;
	private String importRootCertKSType;
	private Boolean regenCerts = false;
	private Boolean skipLTPAKeys = false;
	private String rootCertValidityPeriod;
	private String defaultCertValidityPeriod;
	private String importDefaultCertKS;
	private String importDefaultCertAlias;
	private String importDefaultCertKSPassword;
	private String importDefaultCertKSType;

	public PrepareKeysForSingleProfile(String cellName, String nodeName, String profileRoot) {
		super("prepareKeysForSingleProfile");
		this.cellName = cellName;
		this.nodeName = nodeName;
		this.profileRoot = profileRoot;
	}

	/**
	 * Distinguished  name (DN) to be given to the servers default certificate.
	 */
	public String getDefaultCertDN() {
		return this.defaultCertDN;
	}

	/**
	 * Distinguished  name (DN) to be given to the servers default certificate.
	 */
	public void setDefaultCertDN(String value) {
		this.defaultCertDN = value;
	}

	/**
	 * Distinguished name (DN) to be given to the server root certificate.
	 */
	public String getRootCertDN() {
		return this.rootCertDN;
	}

	/**
	 * Distinguished name (DN) to be given to the server root certificate.
	 */
	public void setRootCertDN(String value) {
		this.rootCertDN = value;
	}

	/**
	 * Specifies the alias of the certificate to import and use as the default certificate.
	 */
	public String getImportRootCertAlias() {
		return this.importRootCertAlias;
	}

	/**
	 * Specifies the alias of the certificate to import and use as the default certificate.
	 */
	public void setImportRootCertAlias(String value) {
		this.importRootCertAlias = value;
	}

	/**
	 * Specifies the name of the cell as it appears in the repository root, e.g., /config/cells/&lt;cellname&gt;.
	 */
	public String getCellName() {
		return this.cellName;
	}

	/**
	 * Specifies the name of the cell as it appears in the repository root, e.g., /config/cells/&lt;cellname&gt;.
	 */
	public void setCellName(String value) {
		this.cellName = value;
	}

	/**
	 * Specifies the node name as it appears in the repository, e.g., /config/cells/&lt;cellname&gt;/nodes/&lt;nodename&gt;.
	 */
	public String getNodeName() {
		return this.nodeName;
	}

	/**
	 * Specifies the node name as it appears in the repository, e.g., /config/cells/&lt;cellname&gt;/nodes/&lt;nodename&gt;.
	 */
	public void setNodeName(String value) {
		this.nodeName = value;
	}

	/**
	 * Specifies the password of the key store file containing the root certificate.
	 */
	public String getImportRootCertKSPassword() {
		return this.importRootCertKSPassword;
	}

	/**
	 * Specifies the password of the key store file containing the root certificate.
	 */
	public void setImportRootCertKSPassword(String value) {
		this.importRootCertKSPassword = value;
	}

	/**
	 * Specifies the password to use as the default password for each key store created during profile creation.
	 */
	public String getKeyStorePassword() {
		return this.keyStorePassword;
	}

	/**
	 * Specifies the password to use as the default password for each key store created during profile creation.
	 */
	public void setKeyStorePassword(String value) {
		this.keyStorePassword = value;
	}

	/**
	 * Specifies the path to the key store file where the root certificate will be imported from.
	 */
	public String getImportRootCertKS() {
		return this.importRootCertKS;
	}

	/**
	 * Specifies the path to the key store file where the root certificate will be imported from.
	 */
	public void setImportRootCertKS(String value) {
		this.importRootCertKS = value;
	}

	/**
	 * Specifies the fully qualified profile path for the type of profile being created, e.g., c:/WebSphere/AppServer/profiles/AppSrv01.
	 */
	public String getProfileRoot() {
		return this.profileRoot;
	}

	/**
	 * Specifies the fully qualified profile path for the type of profile being created, e.g., c:/WebSphere/AppServer/profiles/AppSrv01.
	 */
	public void setProfileRoot(String value) {
		this.profileRoot = value;
	}

	/**
	 * Specifies the type of the key store file containing the root certificate.
	 */
	public String getImportRootCertKSType() {
		return this.importRootCertKSType;
	}

	/**
	 * Specifies the type of the key store file containing the root certificate.
	 */
	public void setImportRootCertKSType(String value) {
		this.importRootCertKSType = value;
	}

	/**
	 * Specify true to regenerate certificates for the profile.
	 */
	public Boolean getRegenCerts() {
		return this.regenCerts;
	}

	/**
	 * Specify true to regenerate certificates for the profile.
	 */
	public void setRegenCerts(Boolean value) {
		this.regenCerts = value;
	}

	/**
	 * skipLTPADesc
	 */
	public Boolean getSkipLTPAKeys() {
		return this.skipLTPAKeys;
	}

	/**
	 * skipLTPADesc
	 */
	public void setSkipLTPAKeys(Boolean value) {
		this.skipLTPAKeys = value;
	}

	/**
	 * The number of years root the certificate will be valid.
	 */
	public String getRootCertValidityPeriod() {
		return this.rootCertValidityPeriod;
	}

	/**
	 * The number of years root the certificate will be valid.
	 */
	public void setRootCertValidityPeriod(String value) {
		this.rootCertValidityPeriod = value;
	}

	/**
	 * The number of years the default certificate will be valid
	 */
	public String getDefaultCertValidityPeriod() {
		return this.defaultCertValidityPeriod;
	}

	/**
	 * The number of years the default certificate will be valid
	 */
	public void setDefaultCertValidityPeriod(String value) {
		this.defaultCertValidityPeriod = value;
	}

	/**
	 * The path to the key store where the servers default certificate will be imported from.
	 */
	public String getImportDefaultCertKS() {
		return this.importDefaultCertKS;
	}

	/**
	 * The path to the key store where the servers default certificate will be imported from.
	 */
	public void setImportDefaultCertKS(String value) {
		this.importDefaultCertKS = value;
	}

	/**
	 * Alias of certificate to use as the default certificate
	 */
	public String getImportDefaultCertAlias() {
		return this.importDefaultCertAlias;
	}

	/**
	 * Alias of certificate to use as the default certificate
	 */
	public void setImportDefaultCertAlias(String value) {
		this.importDefaultCertAlias = value;
	}

	/**
	 * The password of the key store containing the default certificate.
	 */
	public String getImportDefaultCertKSPassword() {
		return this.importDefaultCertKSPassword;
	}

	/**
	 * The password of the key store containing the default certificate.
	 */
	public void setImportDefaultCertKSPassword(String value) {
		this.importDefaultCertKSPassword = value;
	}

	/**
	 * The type of the key store containing the default certificate.
	 */
	public String getImportDefaultCertKSType() {
		return this.importDefaultCertKSType;
	}

	/**
	 * The type of the key store containing the default certificate.
	 */
	public void setImportDefaultCertKSType(String value) {
		this.importDefaultCertKSType = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.defaultCertDN != null) {
			ret.put("defaultCertDN", this.defaultCertDN);
		}
		if (this.rootCertDN != null) {
			ret.put("rootCertDN", this.rootCertDN);
		}
		if (this.importRootCertAlias != null) {
			ret.put("importRootCertAlias", this.importRootCertAlias);
		}
		ret.put("cellName", this.cellName);
		ret.put("nodeName", this.nodeName);
		if (this.importRootCertKSPassword != null) {
			ret.put("importRootCertKSPassword", this.importRootCertKSPassword);
		}
		if (this.keyStorePassword != null) {
			ret.put("keyStorePassword", this.keyStorePassword);
		}
		if (this.importRootCertKS != null) {
			ret.put("importRootCertKS", this.importRootCertKS);
		}
		ret.put("profileRoot", this.profileRoot);
		if (this.importRootCertKSType != null) {
			ret.put("importRootCertKSType", this.importRootCertKSType);
		}
		if (this.regenCerts != null) {
			ret.put("regenCerts", this.regenCerts);
		}
		if (this.skipLTPAKeys != null) {
			ret.put("skipLTPAKeys", this.skipLTPAKeys);
		}
		if (this.rootCertValidityPeriod != null) {
			ret.put("rootCertValidityPeriod", this.rootCertValidityPeriod);
		}
		if (this.defaultCertValidityPeriod != null) {
			ret.put("defaultCertValidityPeriod", this.defaultCertValidityPeriod);
		}
		if (this.importDefaultCertKS != null) {
			ret.put("importDefaultCertKS", this.importDefaultCertKS);
		}
		if (this.importDefaultCertAlias != null) {
			ret.put("importDefaultCertAlias", this.importDefaultCertAlias);
		}
		if (this.importDefaultCertKSPassword != null) {
			ret.put("importDefaultCertKSPassword", this.importDefaultCertKSPassword);
		}
		if (this.importDefaultCertKSType != null) {
			ret.put("importDefaultCertKSType", this.importDefaultCertKSType);
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
