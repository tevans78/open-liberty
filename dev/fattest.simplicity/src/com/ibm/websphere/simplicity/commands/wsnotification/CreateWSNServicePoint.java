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
 * Create a WS-Notification service point
 *   'name': Name of the WS-Notification service point
 *   'description': Description of the WS-Notification service point
 *   'cluster': To specify a cluster endpoint, supply a cluster name but not a node and a server name.
 *   'node': To specify a server endpoint, supply a node and a server name, but not a cluster name.
 *   'server': To specify a server endpoint, supply a node and a server name, but not a cluster name.
 *   'eplName': Either the name of an existing endpoint listener to use or the name of the new endpoint listener to be created.
 *   'eplURLRoot': The URL root to use when creating a new endpoint listener
 *   'eplWSDLServingURLRoot': The WSDL serving URL root to use when creating a new endpoint listener
 *   'copyServicePoint': The name of an existing WS-Notification service point from which to copy inbound port JAX-RPC handler and security settings from.
 *   'transportURLRoot': The root of the externally visible endpoint address URL for web services accessed using this endpoint listener. The format of this attribute os &lt;protocol&gt;://&lt;host&gt;:&lt;port&gt;/&lt;contextRoot&gt;.
 *   'transportSoapVersion': Defines the version of SOAP supported by the service point. This affects the WSDL definition that will be exposed by the web service. Valid values are "1.1" for SOAP 1.1, and "1.2" for SOAP 1.2.
 *   'jaxwsHandlerListNB': The JAX-WS handler list that is applied to inbound requests from an application to the NotificationBroker endpoint of the WS-Notification service point.
 *   'jaxwsHandlerListSM': The JAX-WS handler list that is applied to inbound requests from an application to the SubscriptionManager endpoint of the WS-Notification service point.
 *   'jaxwsHandlerListPRM': The JAX-WS handler list that is applied to inbound requests from an application to the PublisherRegistrationManager endpoint of the WS-Notification service point.
 * The required parameters are found in the constructor.
 */
public class CreateWSNServicePoint extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String name;
	private String description;
	private String cluster;
	private String node;
	private String server;
	private String eplName;
	private String eplURLRoot;
	private String eplWSDLServingURLRoot;
	private String copyServicePoint;
	private String transportURLRoot;
	private String transportSoapVersion;
	private String jaxwsHandlerListNB;
	private String jaxwsHandlerListSM;
	private String jaxwsHandlerListPRM;

	public CreateWSNServicePoint(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String name) {
		super("createWSNServicePoint");
		this.__target = commandTarget;
		this.name = name;
	}

	/**
	 * Name of the WS-Notification service point
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Name of the WS-Notification service point
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Description of the WS-Notification service point
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Description of the WS-Notification service point
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * To specify a cluster endpoint, supply a cluster name but not a node and a server name.
	 */
	public String getCluster() {
		return this.cluster;
	}

	/**
	 * To specify a cluster endpoint, supply a cluster name but not a node and a server name.
	 */
	public void setCluster(String value) {
		this.cluster = value;
	}

	/**
	 * To specify a server endpoint, supply a node and a server name, but not a cluster name.
	 */
	public String getNode() {
		return this.node;
	}

	/**
	 * To specify a server endpoint, supply a node and a server name, but not a cluster name.
	 */
	public void setNode(String value) {
		this.node = value;
	}

	/**
	 * To specify a server endpoint, supply a node and a server name, but not a cluster name.
	 */
	public String getServer() {
		return this.server;
	}

	/**
	 * To specify a server endpoint, supply a node and a server name, but not a cluster name.
	 */
	public void setServer(String value) {
		this.server = value;
	}

	/**
	 * Either the name of an existing endpoint listener to use or the name of the new endpoint listener to be created.
	 */
	public String getEplName() {
		return this.eplName;
	}

	/**
	 * Either the name of an existing endpoint listener to use or the name of the new endpoint listener to be created.
	 */
	public void setEplName(String value) {
		this.eplName = value;
	}

	/**
	 * The URL root to use when creating a new endpoint listener
	 */
	public String getEplURLRoot() {
		return this.eplURLRoot;
	}

	/**
	 * The URL root to use when creating a new endpoint listener
	 */
	public void setEplURLRoot(String value) {
		this.eplURLRoot = value;
	}

	/**
	 * The WSDL serving URL root to use when creating a new endpoint listener
	 */
	public String getEplWSDLServingURLRoot() {
		return this.eplWSDLServingURLRoot;
	}

	/**
	 * The WSDL serving URL root to use when creating a new endpoint listener
	 */
	public void setEplWSDLServingURLRoot(String value) {
		this.eplWSDLServingURLRoot = value;
	}

	/**
	 * The name of an existing WS-Notification service point from which to copy inbound port JAX-RPC handler and security settings from.
	 */
	public String getCopyServicePoint() {
		return this.copyServicePoint;
	}

	/**
	 * The name of an existing WS-Notification service point from which to copy inbound port JAX-RPC handler and security settings from.
	 */
	public void setCopyServicePoint(String value) {
		this.copyServicePoint = value;
	}

	/**
	 * The root of the externally visible endpoint address URL for web services accessed using this endpoint listener. The format of this attribute os &lt;protocol&gt;://&lt;host&gt;:&lt;port&gt;/&lt;contextRoot&gt;.
	 */
	public String getTransportURLRoot() {
		return this.transportURLRoot;
	}

	/**
	 * The root of the externally visible endpoint address URL for web services accessed using this endpoint listener. The format of this attribute os &lt;protocol&gt;://&lt;host&gt;:&lt;port&gt;/&lt;contextRoot&gt;.
	 */
	public void setTransportURLRoot(String value) {
		this.transportURLRoot = value;
	}

	/**
	 * Defines the version of SOAP supported by the service point. This affects the WSDL definition that will be exposed by the web service. Valid values are "1.1" for SOAP 1.1, and "1.2" for SOAP 1.2.
	 */
	public String getTransportSoapVersion() {
		return this.transportSoapVersion;
	}

	/**
	 * Defines the version of SOAP supported by the service point. This affects the WSDL definition that will be exposed by the web service. Valid values are "1.1" for SOAP 1.1, and "1.2" for SOAP 1.2.
	 */
	public void setTransportSoapVersion(String value) {
		this.transportSoapVersion = value;
	}

	/**
	 * The JAX-WS handler list that is applied to inbound requests from an application to the NotificationBroker endpoint of the WS-Notification service point.
	 */
	public String getJaxwsHandlerListNB() {
		return this.jaxwsHandlerListNB;
	}

	/**
	 * The JAX-WS handler list that is applied to inbound requests from an application to the NotificationBroker endpoint of the WS-Notification service point.
	 */
	public void setJaxwsHandlerListNB(String value) {
		this.jaxwsHandlerListNB = value;
	}

	/**
	 * The JAX-WS handler list that is applied to inbound requests from an application to the SubscriptionManager endpoint of the WS-Notification service point.
	 */
	public String getJaxwsHandlerListSM() {
		return this.jaxwsHandlerListSM;
	}

	/**
	 * The JAX-WS handler list that is applied to inbound requests from an application to the SubscriptionManager endpoint of the WS-Notification service point.
	 */
	public void setJaxwsHandlerListSM(String value) {
		this.jaxwsHandlerListSM = value;
	}

	/**
	 * The JAX-WS handler list that is applied to inbound requests from an application to the PublisherRegistrationManager endpoint of the WS-Notification service point.
	 */
	public String getJaxwsHandlerListPRM() {
		return this.jaxwsHandlerListPRM;
	}

	/**
	 * The JAX-WS handler list that is applied to inbound requests from an application to the PublisherRegistrationManager endpoint of the WS-Notification service point.
	 */
	public void setJaxwsHandlerListPRM(String value) {
		this.jaxwsHandlerListPRM = value;
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
		if (this.description != null) {
			ret.put("description", this.description);
		}
		if (this.cluster != null) {
			ret.put("cluster", this.cluster);
		}
		if (this.node != null) {
			ret.put("node", this.node);
		}
		if (this.server != null) {
			ret.put("server", this.server);
		}
		if (this.eplName != null) {
			ret.put("eplName", this.eplName);
		}
		if (this.eplURLRoot != null) {
			ret.put("eplURLRoot", this.eplURLRoot);
		}
		if (this.eplWSDLServingURLRoot != null) {
			ret.put("eplWSDLServingURLRoot", this.eplWSDLServingURLRoot);
		}
		if (this.copyServicePoint != null) {
			ret.put("copyServicePoint", this.copyServicePoint);
		}
		if (this.transportURLRoot != null) {
			ret.put("transportURLRoot", this.transportURLRoot);
		}
		if (this.transportSoapVersion != null) {
			ret.put("transportSoapVersion", this.transportSoapVersion);
		}
		if (this.jaxwsHandlerListNB != null) {
			ret.put("jaxwsHandlerListNB", this.jaxwsHandlerListNB);
		}
		if (this.jaxwsHandlerListSM != null) {
			ret.put("jaxwsHandlerListSM", this.jaxwsHandlerListSM);
		}
		if (this.jaxwsHandlerListPRM != null) {
			ret.put("jaxwsHandlerListPRM", this.jaxwsHandlerListPRM);
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
