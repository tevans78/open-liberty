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

package com.ibm.websphere.simplicity.commands.auditencryption;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Create a new self-signed certificate and store it in a key store.
 *   'certificateAlias': Certificate alias name.
 *   'certificateCommonName': Specifies the common name portion of the distinguished name (DN).
 *   'certificateCountry': Specifies the country portion of the distinguished name.
 *   'certificateValidDays': Specifies the length in days which the certificate will be valid.
 *   'certificateLocality': Specifies the locality portion of the distinguished name.
 *   'certificateOrganization': Specifies the organization portion of the distinguished name.
 *   'certificateOrganizationalUnit': Specifies the organization unit portion of the distinguished name.
 *   'keyStoreScope': Specifies the scope of the key store.
 *   'certificateSize': Specifies the size used by the private key of the personal certificate.
 *   'certificateState': Specifies the state portion of the distinguished name.
 *   'keyStoreName': Specifies the unique name to identify the key store.
 *   'certificateVersion': Specifies the version of the personal certificate.
 *   'certificateZip': Specifies the zip code portion of the distinguished name
 * The required parameters are found in the constructor.
 */
public class CreateAuditSelfSignedCertificate extends Command {

	private String certificateAlias;
	private String certificateCommonName;
	private String certificateCountry = "US";
	private Integer certificateValidDays = 365;
	private String certificateLocality;
	private String certificateOrganization;
	private String certificateOrganizationalUnit;
	private String keyStoreScope;
	private Integer certificateSize = 1024;
	private String certificateState;
	private String keyStoreName;
	private String certificateVersion;
	private String certificateZip;

	public CreateAuditSelfSignedCertificate(String certificateAlias, String certificateCommonName, Integer certificateSize, String keyStoreName) {
		super("createAuditSelfSignedCertificate");
		this.certificateAlias = certificateAlias;
		this.certificateCommonName = certificateCommonName;
		this.certificateSize = certificateSize;
		this.keyStoreName = keyStoreName;
	}

	/**
	 * Certificate alias name.
	 */
	public String getCertificateAlias() {
		return this.certificateAlias;
	}

	/**
	 * Certificate alias name.
	 */
	public void setCertificateAlias(String value) {
		this.certificateAlias = value;
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
	 * Specifies the length in days which the certificate will be valid.
	 */
	public Integer getCertificateValidDays() {
		return this.certificateValidDays;
	}

	/**
	 * Specifies the length in days which the certificate will be valid.
	 */
	public void setCertificateValidDays(Integer value) {
		this.certificateValidDays = value;
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
	 * Specifies the organization portion of the distinguished name.
	 */
	public String getCertificateOrganization() {
		return this.certificateOrganization;
	}

	/**
	 * Specifies the organization portion of the distinguished name.
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
	 * Specifies the scope of the key store.
	 */
	public String getKeyStoreScope() {
		return this.keyStoreScope;
	}

	/**
	 * Specifies the scope of the key store.
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
	 * Specifies the version of the personal certificate.
	 */
	public String getCertificateVersion() {
		return this.certificateVersion;
	}

	/**
	 * Specifies the version of the personal certificate.
	 */
	public void setCertificateVersion(String value) {
		this.certificateVersion = value;
	}

	/**
	 * Specifies the zip code portion of the distinguished name
	 */
	public String getCertificateZip() {
		return this.certificateZip;
	}

	/**
	 * Specifies the zip code portion of the distinguished name
	 */
	public void setCertificateZip(String value) {
		this.certificateZip = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("certificateAlias", this.certificateAlias);
		ret.put("certificateCommonName", this.certificateCommonName);
		if (this.certificateCountry != null) {
			ret.put("certificateCountry", this.certificateCountry);
		}
		if (this.certificateValidDays != null) {
			ret.put("certificateValidDays", this.certificateValidDays);
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
		ret.put("certificateSize", this.certificateSize);
		if (this.certificateState != null) {
			ret.put("certificateState", this.certificateState);
		}
		ret.put("keyStoreName", this.keyStoreName);
		if (this.certificateVersion != null) {
			ret.put("certificateVersion", this.certificateVersion);
		}
		if (this.certificateZip != null) {
			ret.put("certificateZip", this.certificateZip);
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
