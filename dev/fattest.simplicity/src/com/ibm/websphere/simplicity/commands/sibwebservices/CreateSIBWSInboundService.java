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
 * Create an inbound service.
 *   'name': Name of the inbound service.
 *   'destination': Name of the target destination.
 *   'wsdlLocation': Location of the schema WSDL.
 *   'wsdlServiceNamespace': Namespace of the template Web service.
 *   'wsdlServiceName': Name of the template Web service.
 *   'uddiReference': Name of the UDDI reference (if WSDL location is a UDDI key).
 *   'userId': User ID to be used if WSDL is obtained through an authorizing proxy.
 *   'password': Password to be used if WSDL is obtained through an authorizing proxy.
 * The required parameters are found in the constructor.
 */
public class CreateSIBWSInboundService extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String name;
	private String destination;
	private String wsdlLocation;
	private String wsdlServiceNamespace;
	private String wsdlServiceName;
	private String uddiReference;
	private String userId;
	private String password;

	public CreateSIBWSInboundService(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String name, String destination, String wsdlLocation) {
		super("createSIBWSInboundService");
		this.__target = commandTarget;
		this.name = name;
		this.destination = destination;
		this.wsdlLocation = wsdlLocation;
	}

	/**
	 * Name of the inbound service.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Name of the inbound service.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Name of the target destination.
	 */
	public String getDestination() {
		return this.destination;
	}

	/**
	 * Name of the target destination.
	 */
	public void setDestination(String value) {
		this.destination = value;
	}

	/**
	 * Location of the schema WSDL.
	 */
	public String getWsdlLocation() {
		return this.wsdlLocation;
	}

	/**
	 * Location of the schema WSDL.
	 */
	public void setWsdlLocation(String value) {
		this.wsdlLocation = value;
	}

	/**
	 * Namespace of the template Web service.
	 */
	public String getWsdlServiceNamespace() {
		return this.wsdlServiceNamespace;
	}

	/**
	 * Namespace of the template Web service.
	 */
	public void setWsdlServiceNamespace(String value) {
		this.wsdlServiceNamespace = value;
	}

	/**
	 * Name of the template Web service.
	 */
	public String getWsdlServiceName() {
		return this.wsdlServiceName;
	}

	/**
	 * Name of the template Web service.
	 */
	public void setWsdlServiceName(String value) {
		this.wsdlServiceName = value;
	}

	/**
	 * Name of the UDDI reference (if WSDL location is a UDDI key).
	 */
	public String getUddiReference() {
		return this.uddiReference;
	}

	/**
	 * Name of the UDDI reference (if WSDL location is a UDDI key).
	 */
	public void setUddiReference(String value) {
		this.uddiReference = value;
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
		ret.put("destination", this.destination);
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
