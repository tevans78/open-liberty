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
 * Exchange Signer Certificates
 *   'keyStoreName1': Keystore name that will exchange signers with another keystore.
 *   'keyStoreName2': Keystore name that will exchange signers with another keystore.
 *   'certificateAliasList1': Specifies colon separated list of certificates whose signer will be added to another keystore.
 *   'certificateAliasList2': Specifies colon separated list of certificates whose signer will be added to another keystore.
 *   'keyStoreScope1': Specifies the management scope.
 *   'keyStoreScope2': Specifies the management scope.
 * The required parameters are found in the constructor.
 */
public class ExchangeSigners extends Command {

	private String keyStoreName1;
	private String keyStoreName2;
	private String certificateAliasList1;
	private String certificateAliasList2;
	private String keyStoreScope1;
	private String keyStoreScope2;

	public ExchangeSigners(String keyStoreName1, String keyStoreName2) {
		super("exchangeSigners");
		this.keyStoreName1 = keyStoreName1;
		this.keyStoreName2 = keyStoreName2;
	}

	/**
	 * Keystore name that will exchange signers with another keystore.
	 */
	public String getKeyStoreName1() {
		return this.keyStoreName1;
	}

	/**
	 * Keystore name that will exchange signers with another keystore.
	 */
	public void setKeyStoreName1(String value) {
		this.keyStoreName1 = value;
	}

	/**
	 * Keystore name that will exchange signers with another keystore.
	 */
	public String getKeyStoreName2() {
		return this.keyStoreName2;
	}

	/**
	 * Keystore name that will exchange signers with another keystore.
	 */
	public void setKeyStoreName2(String value) {
		this.keyStoreName2 = value;
	}

	/**
	 * Specifies colon separated list of certificates whose signer will be added to another keystore.
	 */
	public String getCertificateAliasList1() {
		return this.certificateAliasList1;
	}

	/**
	 * Specifies colon separated list of certificates whose signer will be added to another keystore.
	 */
	public void setCertificateAliasList1(String value) {
		this.certificateAliasList1 = value;
	}

	/**
	 * Specifies colon separated list of certificates whose signer will be added to another keystore.
	 */
	public String getCertificateAliasList2() {
		return this.certificateAliasList2;
	}

	/**
	 * Specifies colon separated list of certificates whose signer will be added to another keystore.
	 */
	public void setCertificateAliasList2(String value) {
		this.certificateAliasList2 = value;
	}

	/**
	 * Specifies the management scope.
	 */
	public String getKeyStoreScope1() {
		return this.keyStoreScope1;
	}

	/**
	 * Specifies the management scope.
	 */
	public void setKeyStoreScope1(String value) {
		this.keyStoreScope1 = value;
	}

	/**
	 * Specifies the management scope.
	 */
	public String getKeyStoreScope2() {
		return this.keyStoreScope2;
	}

	/**
	 * Specifies the management scope.
	 */
	public void setKeyStoreScope2(String value) {
		this.keyStoreScope2 = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("keyStoreName1", this.keyStoreName1);
		ret.put("keyStoreName2", this.keyStoreName2);
		if (this.certificateAliasList1 != null) {
			ret.put("certificateAliasList1", this.certificateAliasList1);
		}
		if (this.certificateAliasList2 != null) {
			ret.put("certificateAliasList2", this.certificateAliasList2);
		}
		if (this.keyStoreScope1 != null) {
			ret.put("keyStoreScope1", this.keyStoreScope1);
		}
		if (this.keyStoreScope2 != null) {
			ret.put("keyStoreScope2", this.keyStoreScope2);
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
