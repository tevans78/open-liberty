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

package com.ibm.websphere.simplicity.commands.personalcertificate;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Sends a request to a certificate authority to create a certificate authority (CA) personal certificate.
 *   'certificateCommonName': Specifies the common name portion of the distinguished name (DN).
 *   'certificateLocality': Specifies the locality portion of the distinguished name.
 *   'certificateOrganization': Specifies the organization portion of the distinguished name
 *   'certificateOrganizationalUnit': Specifies the organization unit portion of the distinguished name.
 *   'keyStoreScope': Specifies the scope of the keystore.
 *   'certificateSize': Specifies the size used by the private key of the personal certificate.
 *   'certificateCountry': Specifies the country portion of the distinguished name.
 *   'certificateState': Specifies the state portion of the distinguished name.
 *   'keyStoreName': Specifies the unique name to identify the keystore.
 *   'certificateZip': Specifies the zip code portion of the distinguished name.
 *   'caClientName': Specifies the name that uniquely identifies the certificate authority (CA) configurator.
 *   'caClientScope': The scope of the certificate authority (CA) client object used to create the certificate.
 *   'revocationPassword': The password used to revoke the certificate at a later time.
 *   'certificateAlias': Specifies a unique name to identify a certificate.
 * The required parameters are found in the constructor.
 */
public class RequestCACertificate extends Command {

	private String certificateCommonName;
	private String certificateLocality;
	private String certificateOrganization;
	private String certificateOrganizationalUnit;
	private String keyStoreScope;
	private Integer certificateSize = 1024;
	private String certificateCountry;
	private String certificateState;
	private String keyStoreName;
	private String certificateZip;
	private String caClientName;
	private String caClientScope;
	private String revocationPassword;
	private String certificateAlias;

	public RequestCACertificate(String keyStoreName, String caClientName, String revocationPassword, String certificateAlias) {
		super("requestCACertificate");
		this.keyStoreName = keyStoreName;
		this.caClientName = caClientName;
		this.revocationPassword = revocationPassword;
		this.certificateAlias = certificateAlias;
	}

	/**
	 * Specifies the common name portion of the distinguished name (DN).
	 */
	public String getCertificateCommonName() {
		return this.certificateCommonName;
	}

	/**
	 * Specifies the common name portion of the distinguished name (DN).
	 */
	public void setCertificateCommonName(String value) {
		this.certificateCommonName = value;
	}

	/**
	 * Specifies the locality portion of the distinguished name.
	 */
	public String getCertificateLocality() {
		return this.certificateLocality;
	}

	/**
	 * Specifies the locality portion of the distinguished name.
	 */
	public void setCertificateLocality(String value) {
		this.certificateLocality = value;
	}

	/**
	 * Specifies the organization portion of the distinguished name
	 */
	public String getCertificateOrganization() {
		return this.certificateOrganization;
	}

	/**
	 * Specifies the organization portion of the distinguished name
	 */
	public void setCertificateOrganization(String value) {
		this.certificateOrganization = value;
	}

	/**
	 * Specifies the organization unit portion of the distinguished name.
	 */
	public String getCertificateOrganizationalUnit() {
		return this.certificateOrganizationalUnit;
	}

	/**
	 * Specifies the organization unit portion of the distinguished name.
	 */
	public void setCertificateOrganizationalUnit(String value) {
		this.certificateOrganizationalUnit = value;
	}

	/**
	 * Specifies the scope of the keystore.
	 */
	public String getKeyStoreScope() {
		return this.keyStoreScope;
	}

	/**
	 * Specifies the scope of the keystore.
	 */
	public void setKeyStoreScope(String value) {
		this.keyStoreScope = value;
	}

	/**
	 * Specifies the size used by the private key of the personal certificate.
	 */
	public Integer getCertificateSize() {
		return this.certificateSize;
	}

	/**
	 * Specifies the size used by the private key of the personal certificate.
	 */
	public void setCertificateSize(Integer value) {
		this.certificateSize = value;
	}

	/**
	 * Specifies the country portion of the distinguished name.
	 */
	public String getCertificateCountry() {
		return this.certificateCountry;
	}

	/**
	 * Specifies the country portion of the distinguished name.
	 */
	public void setCertificateCountry(String value) {
		this.certificateCountry = value;
	}

	/**
	 * Specifies the state portion of the distinguished name.
	 */
	public String getCertificateState() {
		return this.certificateState;
	}

	/**
	 * Specifies the state portion of the distinguished name.
	 */
	public void setCertificateState(String value) {
		this.certificateState = value;
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
	 * Specifies the zip code portion of the distinguished name.
	 */
	public String getCertificateZip() {
		return this.certificateZip;
	}

	/**
	 * Specifies the zip code portion of the distinguished name.
	 */
	public void setCertificateZip(String value) {
		this.certificateZip = value;
	}

	/**
	 * Specifies the name that uniquely identifies the certificate authority (CA) configurator.
	 */
	public String getCaClientName() {
		return this.caClientName;
	}

	/**
	 * Specifies the name that uniquely identifies the certificate authority (CA) configurator.
	 */
	public void setCaClientName(String value) {
		this.caClientName = value;
	}

	/**
	 * The scope of the certificate authority (CA) client object used to create the certificate.
	 */
	public String getCaClientScope() {
		return this.caClientScope;
	}

	/**
	 * The scope of the certificate authority (CA) client object used to create the certificate.
	 */
	public void setCaClientScope(String value) {
		this.caClientScope = value;
	}

	/**
	 * The password used to revoke the certificate at a later time.
	 */
	public String getRevocationPassword() {
		return this.revocationPassword;
	}

	/**
	 * The password used to revoke the certificate at a later time.
	 */
	public void setRevocationPassword(String value) {
		this.revocationPassword = value;
	}

	/**
	 * Specifies a unique name to identify a certificate.
	 */
	public String getCertificateAlias() {
		return this.certificateAlias;
	}

	/**
	 * Specifies a unique name to identify a certificate.
	 */
	public void setCertificateAlias(String value) {
		this.certificateAlias = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.certificateCommonName != null) {
			ret.put("certificateCommonName", this.certificateCommonName);
		}
		if (this.certificateLocality != null) {
			ret.put("certificateLocality", this.certificateLocality);
		}
		if (this.certificateOrganization != null) {
			ret.put("certificateOrganization", this.certificateOrganization);
		}
		if (this.certificateOrganizationalUnit != null) {
			ret.put("certificateOrganizationalUnit", this.certificateOrganizationalUnit);
		}
		if (this.keyStoreScope != null) {
			ret.put("keyStoreScope", this.keyStoreScope);
		}
		if (this.certificateSize != null) {
			ret.put("certificateSize", this.certificateSize);
		}
		if (this.certificateCountry != null) {
			ret.put("certificateCountry", this.certificateCountry);
		}
		if (this.certificateState != null) {
			ret.put("certificateState", this.certificateState);
		}
		ret.put("keyStoreName", this.keyStoreName);
		if (this.certificateZip != null) {
			ret.put("certificateZip", this.certificateZip);
		}
		ret.put("caClientName", this.caClientName);
		if (this.caClientScope != null) {
			ret.put("caClientScope", this.caClientScope);
		}
		ret.put("revocationPassword", this.revocationPassword);
		ret.put("certificateAlias", this.certificateAlias);
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
