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

package com.ibm.websphere.simplicity.commands.wsnotification;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Create a WS-Notification service
 *   'name': Name of the WS-Notification service
 *   'type': Used to determine what type of WSNService should be created. The two options are V6.1 (default) or V7.0, which creates a new style service that permits composability with WS-RM.
 *   'bus': Name of the service integration bus to create for the WS-Notification service to be configured on
 *   'description': Description of the WS-Notification service
 *   'permitsDynamicNamespace': Indicates whether dynamic topic namespaces are allowed (TRUE or FALSE)
 *   'requiresRegistration': Indicates whether publisher applications are required to register with the broker before they can publish notifications (TRUE or FALSE)
 *   'dynamicTopicSpace': The name of the service integration bus topic space to use for a dynamic topic space (defaults to WSN_dynamic_&lt;WS-Notification service name&gt;)
 *   'jaxrpcHandlerListName': The JAX-RPC handler list that is applied to inbound service requests for the WS-Notification service.
 *   'jaxwsHandlerListName': The JAX-WS handler list that is applied when the service invokes external WS-Notification service interfaces.
 *   'outboundSecurityConfigName': Specifies the details of how security is applied to requests and responses.
 *   'outboundSecurityRequestBindingName': The security binding to be used with consumer notifications and remote publisher requests sent by this WS-Notification service.
 *   'outboundSecurityResponseBindingName': The security binding to be used with remote publisher responses received by this WS-Notification service.
 *   'queryWSDL': Discover remote endpoint information from published WSDL. Default value is TRUE.
 * The required parameters are found in the constructor.
 */
public class CreateWSNService extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String name;
	private String type = "V6.1";
	private String bus;
	private String description;
	private Boolean permitsDynamicNamespace = true;
	private Boolean requiresRegistration = false;
	private String dynamicTopicSpace;
	private String jaxrpcHandlerListName;
	private String jaxwsHandlerListName;
	private String outboundSecurityConfigName;
	private String outboundSecurityRequestBindingName;
	private String outboundSecurityResponseBindingName;
	private Boolean queryWSDL;

	public CreateWSNService(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String name) {
		super("createWSNService");
		this.__target = commandTarget;
		this.name = name;
	}

	/**
	 * Name of the WS-Notification service
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Name of the WS-Notification service
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Used to determine what type of WSNService should be created. The two options are V6.1 (default) or V7.0, which creates a new style service that permits composability with WS-RM.
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Used to determine what type of WSNService should be created. The two options are V6.1 (default) or V7.0, which creates a new style service that permits composability with WS-RM.
	 */
	public void setType(String value) {
		this.type = value;
	}

	/**
	 * Name of the service integration bus to create for the WS-Notification service to be configured on
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * Name of the service integration bus to create for the WS-Notification service to be configured on
	 */
	public void setBus(String value) {
		this.bus = value;
	}

	/**
	 * Description of the WS-Notification service
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Description of the WS-Notification service
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Indicates whether dynamic topic namespaces are allowed (TRUE or FALSE)
	 */
	public Boolean getPermitsDynamicNamespace() {
		return this.permitsDynamicNamespace;
	}

	/**
	 * Indicates whether dynamic topic namespaces are allowed (TRUE or FALSE)
	 */
	public void setPermitsDynamicNamespace(Boolean value) {
		this.permitsDynamicNamespace = value;
	}

	/**
	 * Indicates whether publisher applications are required to register with the broker before they can publish notifications (TRUE or FALSE)
	 */
	public Boolean getRequiresRegistration() {
		return this.requiresRegistration;
	}

	/**
	 * Indicates whether publisher applications are required to register with the broker before they can publish notifications (TRUE or FALSE)
	 */
	public void setRequiresRegistration(Boolean value) {
		this.requiresRegistration = value;
	}

	/**
	 * The name of the service integration bus topic space to use for a dynamic topic space (defaults to WSN_dynamic_&lt;WS-Notification service name&gt;)
	 */
	public String getDynamicTopicSpace() {
		return this.dynamicTopicSpace;
	}

	/**
	 * The name of the service integration bus topic space to use for a dynamic topic space (defaults to WSN_dynamic_&lt;WS-Notification service name&gt;)
	 */
	public void setDynamicTopicSpace(String value) {
		this.dynamicTopicSpace = value;
	}

	/**
	 * The JAX-RPC handler list that is applied to inbound service requests for the WS-Notification service.
	 */
	public String getJaxrpcHandlerListName() {
		return this.jaxrpcHandlerListName;
	}

	/**
	 * The JAX-RPC handler list that is applied to inbound service requests for the WS-Notification service.
	 */
	public void setJaxrpcHandlerListName(String value) {
		this.jaxrpcHandlerListName = value;
	}

	/**
	 * The JAX-WS handler list that is applied when the service invokes external WS-Notification service interfaces.
	 */
	public String getJaxwsHandlerListName() {
		return this.jaxwsHandlerListName;
	}

	/**
	 * The JAX-WS handler list that is applied when the service invokes external WS-Notification service interfaces.
	 */
	public void setJaxwsHandlerListName(String value) {
		this.jaxwsHandlerListName = value;
	}

	/**
	 * Specifies the details of how security is applied to requests and responses.
	 */
	public String getOutboundSecurityConfigName() {
		return this.outboundSecurityConfigName;
	}

	/**
	 * Specifies the details of how security is applied to requests and responses.
	 */
	public void setOutboundSecurityConfigName(String value) {
		this.outboundSecurityConfigName = value;
	}

	/**
	 * The security binding to be used with consumer notifications and remote publisher requests sent by this WS-Notification service.
	 */
	public String getOutboundSecurityRequestBindingName() {
		return this.outboundSecurityRequestBindingName;
	}

	/**
	 * The security binding to be used with consumer notifications and remote publisher requests sent by this WS-Notification service.
	 */
	public void setOutboundSecurityRequestBindingName(String value) {
		this.outboundSecurityRequestBindingName = value;
	}

	/**
	 * The security binding to be used with remote publisher responses received by this WS-Notification service.
	 */
	public String getOutboundSecurityResponseBindingName() {
		return this.outboundSecurityResponseBindingName;
	}

	/**
	 * The security binding to be used with remote publisher responses received by this WS-Notification service.
	 */
	public void setOutboundSecurityResponseBindingName(String value) {
		this.outboundSecurityResponseBindingName = value;
	}

	/**
	 * Discover remote endpoint information from published WSDL. Default value is TRUE.
	 */
	public Boolean getQueryWSDL() {
		return this.queryWSDL;
	}

	/**
	 * Discover remote endpoint information from published WSDL. Default value is TRUE.
	 */
	public void setQueryWSDL(Boolean value) {
		this.queryWSDL = value;
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
		if (this.type != null) {
			ret.put("type", this.type);
		}
		if (this.bus != null) {
			ret.put("bus", this.bus);
		}
		if (this.description != null) {
			ret.put("description", this.description);
		}
		if (this.permitsDynamicNamespace != null) {
			ret.put("permitsDynamicNamespace", this.permitsDynamicNamespace);
		}
		if (this.requiresRegistration != null) {
			ret.put("requiresRegistration", this.requiresRegistration);
		}
		if (this.dynamicTopicSpace != null) {
			ret.put("dynamicTopicSpace", this.dynamicTopicSpace);
		}
		if (this.jaxrpcHandlerListName != null) {
			ret.put("jaxrpcHandlerListName", this.jaxrpcHandlerListName);
		}
		if (this.jaxwsHandlerListName != null) {
			ret.put("jaxwsHandlerListName", this.jaxwsHandlerListName);
		}
		if (this.outboundSecurityConfigName != null) {
			ret.put("outboundSecurityConfigName", this.outboundSecurityConfigName);
		}
		if (this.outboundSecurityRequestBindingName != null) {
			ret.put("outboundSecurityRequestBindingName", this.outboundSecurityRequestBindingName);
		}
		if (this.outboundSecurityResponseBindingName != null) {
			ret.put("outboundSecurityResponseBindingName", this.outboundSecurityResponseBindingName);
		}
		if (this.queryWSDL != null) {
			ret.put("queryWSDL", this.queryWSDL);
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
