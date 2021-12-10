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

package com.ibm.websphere.simplicity.commands.sibadmin;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Create a mediation.
 *   'bus': The name of the bus where the mediation is to be created.
 *   'mediationName': The name to be given to the mediation.
 *   'description': Description of the mediation.
 *   'handlerListName': The name of the handler list that was defined when the mediation was deployed.
 *   'globalTransaction': Whether or not a global transaction is started for each message processed.
 *   'allowConcurrentMediation': Whether or not to apply the mediation to multiple messages concurrently, and preserve message ordering.
 *   'selector': The text string that must be present in a message for the mediation to process the message.
 *   'discriminator': The text string that must not be present in a message for the mediation to process the message.
 * The required parameters are found in the constructor.
 */
public class CreateSIBMediation extends Command {

	private String bus;
	private String mediationName;
	private String description;
	private String handlerListName;
	private Boolean globalTransaction = false;
	private Boolean allowConcurrentMediation = false;
	private String selector;
	private String discriminator;

	public CreateSIBMediation(String bus, String mediationName, String handlerListName) {
		super("createSIBMediation");
		this.bus = bus;
		this.mediationName = mediationName;
		this.handlerListName = handlerListName;
	}

	/**
	 * The name of the bus where the mediation is to be created.
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * The name of the bus where the mediation is to be created.
	 */
	public void setBus(String value) {
		this.bus = value;
	}

	/**
	 * The name to be given to the mediation.
	 */
	public String getMediationName() {
		return this.mediationName;
	}

	/**
	 * The name to be given to the mediation.
	 */
	public void setMediationName(String value) {
		this.mediationName = value;
	}

	/**
	 * Description of the mediation.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Description of the mediation.
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * The name of the handler list that was defined when the mediation was deployed.
	 */
	public String getHandlerListName() {
		return this.handlerListName;
	}

	/**
	 * The name of the handler list that was defined when the mediation was deployed.
	 */
	public void setHandlerListName(String value) {
		this.handlerListName = value;
	}

	/**
	 * Whether or not a global transaction is started for each message processed.
	 */
	public Boolean getGlobalTransaction() {
		return this.globalTransaction;
	}

	/**
	 * Whether or not a global transaction is started for each message processed.
	 */
	public void setGlobalTransaction(Boolean value) {
		this.globalTransaction = value;
	}

	/**
	 * Whether or not to apply the mediation to multiple messages concurrently, and preserve message ordering.
	 */
	public Boolean getAllowConcurrentMediation() {
		return this.allowConcurrentMediation;
	}

	/**
	 * Whether or not to apply the mediation to multiple messages concurrently, and preserve message ordering.
	 */
	public void setAllowConcurrentMediation(Boolean value) {
		this.allowConcurrentMediation = value;
	}

	/**
	 * The text string that must be present in a message for the mediation to process the message.
	 */
	public String getSelector() {
		return this.selector;
	}

	/**
	 * The text string that must be present in a message for the mediation to process the message.
	 */
	public void setSelector(String value) {
		this.selector = value;
	}

	/**
	 * The text string that must not be present in a message for the mediation to process the message.
	 */
	public String getDiscriminator() {
		return this.discriminator;
	}

	/**
	 * The text string that must not be present in a message for the mediation to process the message.
	 */
	public void setDiscriminator(String value) {
		this.discriminator = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("bus", this.bus);
		ret.put("mediationName", this.mediationName);
		if (this.description != null) {
			ret.put("description", this.description);
		}
		ret.put("handlerListName", this.handlerListName);
		if (this.globalTransaction != null) {
			ret.put("globalTransaction", this.globalTransaction);
		}
		if (this.allowConcurrentMediation != null) {
			ret.put("allowConcurrentMediation", this.allowConcurrentMediation);
		}
		if (this.selector != null) {
			ret.put("selector", this.selector);
		}
		if (this.discriminator != null) {
			ret.put("discriminator", this.discriminator);
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
