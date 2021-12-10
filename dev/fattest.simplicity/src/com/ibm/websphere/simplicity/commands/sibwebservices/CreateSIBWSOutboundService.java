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

package com.ibm.websphere.simplicity.commands.sibwebservices;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Create an outbound service.
 *   'name': Administrative name of the outbound service.
 *   'wsdlLocation': Web service WSDL location.
 *   'wsdlServiceNamespace': Web service namespace.
 *   'wsdlServiceName': Web service name.
 *   'uddiReference': UDDI reference.
 *   'destination': Name to use for the associated service destination.
 *   'userId': User ID to be used if WSDL is obtained through an authorizing proxy.
 *   'password': Password to be used if WSDL is obtained through an authorizing proxy.
 * The required parameters are found in the constructor.
 */
public class CreateSIBWSOutboundService extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String name;
	private String wsdlLocation;
	private String wsdlServiceNamespace;
	private String wsdlServiceName;
	private String uddiReference;
	private String destination;
	private String userId;
	private String password;

	public CreateSIBWSOutboundService(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String name, String wsdlLocation) {
		super("createSIBWSOutboundService");
		this.__target = commandTarget;
		this.name = name;
		this.wsdlLocation = wsdlLocation;
	}

	/**
	 * Administrative name of the outbound service.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Administrative name of the outbound service.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Web service WSDL location.
	 */
	public String getWsdlLocation() {
		return this.wsdlLocation;
	}

	/**
	 * Web service WSDL location.
	 */
	public void setWsdlLocation(String value) {
		this.wsdlLocation = value;
	}

	/**
	 * Web service namespace.
	 */
	public String getWsdlServiceNamespace() {
		return this.wsdlServiceNamespace;
	}

	/**
	 * Web service namespace.
	 */
	public void setWsdlServiceNamespace(String value) {
		this.wsdlServiceNamespace = value;
	}

	/**
	 * Web service name.
	 */
	public String getWsdlServiceName() {
		return this.wsdlServiceName;
	}

	/**
	 * Web service name.
	 */
	public void setWsdlServiceName(String value) {
		this.wsdlServiceName = value;
	}

	/**
	 * UDDI reference.
	 */
	public String getUddiReference() {
		return this.uddiReference;
	}

	/**
	 * UDDI reference.
	 */
	public void setUddiReference(String value) {
		this.uddiReference = value;
	}

	/**
	 * Name to use for the associated service destination.
	 */
	public String getDestination() {
		return this.destination;
	}

	/**
	 * Name to use for the associated service destination.
	 */
	public void setDestination(String value) {
		this.destination = value;
	}

	/**
	 * User ID to be used if WSDL is obtained through an authorizing proxy.
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * User ID to be used if WSDL is obtained through an authorizing proxy.
	 */
	public void setUserId(String value) {
		this.userId = value;
	}

	/**
	 * Password to be used if WSDL is obtained through an authorizing proxy.
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Password to be used if WSDL is obtained through an authorizing proxy.
	 */
	public void setPassword(String value) {
		this.password = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("name", this.name);
		ret.put("wsdlLocation", this.wsdlLocation);
		if (this.wsdlServiceNamespace != null) {
			ret.put("wsdlServiceNamespace", this.wsdlServiceNamespace);
		}
		if (this.wsdlServiceName != null) {
			ret.put("wsdlServiceName", this.wsdlServiceName);
		}
		if (this.uddiReference != null) {
			ret.put("uddiReference", this.uddiReference);
		}
		if (this.destination != null) {
			ret.put("destination", this.destination);
		}
		if (this.userId != null) {
			ret.put("userId", this.userId);
		}
		if (this.password != null) {
			ret.put("password", this.password);
		}
		return ret;
	}

	public Object __getTarget() {
		return this.__target;
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
