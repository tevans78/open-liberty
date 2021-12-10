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

package com.ibm.websphere.simplicity.commands.wsgateway;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Create a gateway service.
 *   'name': Name of the gateway service to be created.
 *   'requestDestination': Name to use for the gateway service's underlying request destination.
 *   'replyDestination': Name to use for the gateway service's underlying reply destination.
 *   'targetDestination': Name of the target destination for this gateway service.
 *   'targetService': Name of the target outbound service for this gateway service.
 *   'targetBus': Name of the bus where the target is located.
 *   'wsdlLocation': Location of the template WSDL for the gateway service.
 *   'wsdlServiceName': Name of the service within the template WSDL.
 *   'wsdlServiceNamespace': Namespace of the service within the template WSDL.
 *   'uddiReference': UDDI reference (if WSDL location is a UDDI key).
 *   'userId': User ID to be used if WSDL is obtained from an authorizing proxy.
 *   'password': Password to be used if WSDL is obtained from an authorizing proxy.
 * The required parameters are found in the constructor.
 */
public class CreateWSGWGatewayService extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String name;
	private String requestDestination;
	private String replyDestination;
	private String targetDestination;
	private String targetService;
	private String targetBus;
	private String wsdlLocation;
	private String wsdlServiceName;
	private String wsdlServiceNamespace;
	private String uddiReference;
	private String userId;
	private String password;

	public CreateWSGWGatewayService(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String name) {
		super("createWSGWGatewayService");
		this.__target = commandTarget;
		this.name = name;
	}

	/**
	 * Name of the gateway service to be created.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Name of the gateway service to be created.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Name to use for the gateway service's underlying request destination.
	 */
	public String getRequestDestination() {
		return this.requestDestination;
	}

	/**
	 * Name to use for the gateway service's underlying request destination.
	 */
	public void setRequestDestination(String value) {
		this.requestDestination = value;
	}

	/**
	 * Name to use for the gateway service's underlying reply destination.
	 */
	public String getReplyDestination() {
		return this.replyDestination;
	}

	/**
	 * Name to use for the gateway service's underlying reply destination.
	 */
	public void setReplyDestination(String value) {
		this.replyDestination = value;
	}

	/**
	 * Name of the target destination for this gateway service.
	 */
	public String getTargetDestination() {
		return this.targetDestination;
	}

	/**
	 * Name of the target destination for this gateway service.
	 */
	public void setTargetDestination(String value) {
		this.targetDestination = value;
	}

	/**
	 * Name of the target outbound service for this gateway service.
	 */
	public String getTargetService() {
		return this.targetService;
	}

	/**
	 * Name of the target outbound service for this gateway service.
	 */
	public void setTargetService(String value) {
		this.targetService = value;
	}

	/**
	 * Name of the bus where the target is located.
	 */
	public String getTargetBus() {
		return this.targetBus;
	}

	/**
	 * Name of the bus where the target is located.
	 */
	public void setTargetBus(String value) {
		this.targetBus = value;
	}

	/**
	 * Location of the template WSDL for the gateway service.
	 */
	public String getWsdlLocation() {
		return this.wsdlLocation;
	}

	/**
	 * Location of the template WSDL for the gateway service.
	 */
	public void setWsdlLocation(String value) {
		this.wsdlLocation = value;
	}

	/**
	 * Name of the service within the template WSDL.
	 */
	public String getWsdlServiceName() {
		return this.wsdlServiceName;
	}

	/**
	 * Name of the service within the template WSDL.
	 */
	public void setWsdlServiceName(String value) {
		this.wsdlServiceName = value;
	}

	/**
	 * Namespace of the service within the template WSDL.
	 */
	public String getWsdlServiceNamespace() {
		return this.wsdlServiceNamespace;
	}

	/**
	 * Namespace of the service within the template WSDL.
	 */
	public void setWsdlServiceNamespace(String value) {
		this.wsdlServiceNamespace = value;
	}

	/**
	 * UDDI reference (if WSDL location is a UDDI key).
	 */
	public String getUddiReference() {
		return this.uddiReference;
	}

	/**
	 * UDDI reference (if WSDL location is a UDDI key).
	 */
	public void setUddiReference(String value) {
		this.uddiReference = value;
	}

	/**
	 * User ID to be used if WSDL is obtained from an authorizing proxy.
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * User ID to be used if WSDL is obtained from an authorizing proxy.
	 */
	public void setUserId(String value) {
		this.userId = value;
	}

	/**
	 * Password to be used if WSDL is obtained from an authorizing proxy.
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Password to be used if WSDL is obtained from an authorizing proxy.
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
		if (this.requestDestination != null) {
			ret.put("requestDestination", this.requestDestination);
		}
		if (this.replyDestination != null) {
			ret.put("replyDestination", this.replyDestination);
		}
		if (this.targetDestination != null) {
			ret.put("targetDestination", this.targetDestination);
		}
		if (this.targetService != null) {
			ret.put("targetService", this.targetService);
		}
		if (this.targetBus != null) {
			ret.put("targetBus", this.targetBus);
		}
		if (this.wsdlLocation != null) {
			ret.put("wsdlLocation", this.wsdlLocation);
		}
		if (this.wsdlServiceName != null) {
			ret.put("wsdlServiceName", this.wsdlServiceName);
		}
		if (this.wsdlServiceNamespace != null) {
			ret.put("wsdlServiceNamespace", this.wsdlServiceNamespace);
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
