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

package com.ibm.websphere.simplicity.commands;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Create an STS token type configuration. Token type local names and URIs must be unique.
 *   'URI': The URI of the token type.
 *   'HandlerFactory': The fully qualified class name that will handle messages of this token type.
 *   'lifetimeMinutes': The maximum lifetime (specified in minutes) of the token type.
 *   'distributedCache': Indicate whether the cache for the token type is distributed.
 *   'tokenCacheFactory': The fully qualified class name of an implementation of com.ibm.ws.wssecurity.sts.ext.cache.TokenCacheFactory to use for this token type.
 *   'postdatable': Indicate whether postdating of tokens is allowed.
 *   'renewableAfterExpiration': Indicate whether renewal of expired tokens is allowed.
 *   'renewalWindowMinutes': The amount of time tokens are kept in the cache after expiration (specified in minutes).
 *   'customProperties': Token type custom properties.
 * The required parameters are found in the constructor.
 */
public class CreateSTSTokenTypeConfiguration extends Command {

	private String __target;
	private String URI;
	private String HandlerFactory;
	private Integer lifetimeMinutes = 120;
	private Boolean distributedCache = false;
	private String tokenCacheFactory = "com.ibm.ws.wssecurity.platform.websphere.trust.server.sts.ext.cache.STSTokenCacheFactoryImpl";
	private Boolean postdatable = false;
	private Boolean renewableAfterExpiration = false;
	private Integer renewalWindowMinutes = 120;
	private java.util.Properties customProperties;

	public CreateSTSTokenTypeConfiguration(String commandTarget, String URI, String HandlerFactory) {
		super("createSTSTokenTypeConfiguration");
		this.__target = commandTarget;
		this.URI = URI;
		this.HandlerFactory = HandlerFactory;
	}

	/**
	 * The URI of the token type.
	 */
	public String getURI() {
		return this.URI;
	}

	/**
	 * The URI of the token type.
	 */
	public void setURI(String value) {
		this.URI = value;
	}

	/**
	 * The fully qualified class name that will handle messages of this token type.
	 */
	public String getHandlerFactory() {
		return this.HandlerFactory;
	}

	/**
	 * The fully qualified class name that will handle messages of this token type.
	 */
	public void setHandlerFactory(String value) {
		this.HandlerFactory = value;
	}

	/**
	 * The maximum lifetime (specified in minutes) of the token type.
	 */
	public Integer getLifetimeMinutes() {
		return this.lifetimeMinutes;
	}

	/**
	 * The maximum lifetime (specified in minutes) of the token type.
	 */
	public void setLifetimeMinutes(Integer value) {
		this.lifetimeMinutes = value;
	}

	/**
	 * Indicate whether the cache for the token type is distributed.
	 */
	public Boolean getDistributedCache() {
		return this.distributedCache;
	}

	/**
	 * Indicate whether the cache for the token type is distributed.
	 */
	public void setDistributedCache(Boolean value) {
		this.distributedCache = value;
	}

	/**
	 * The fully qualified class name of an implementation of com.ibm.ws.wssecurity.sts.ext.cache.TokenCacheFactory to use for this token type.
	 */
	public String getTokenCacheFactory() {
		return this.tokenCacheFactory;
	}

	/**
	 * The fully qualified class name of an implementation of com.ibm.ws.wssecurity.sts.ext.cache.TokenCacheFactory to use for this token type.
	 */
	public void setTokenCacheFactory(String value) {
		this.tokenCacheFactory = value;
	}

	/**
	 * Indicate whether postdating of tokens is allowed.
	 */
	public Boolean getPostdatable() {
		return this.postdatable;
	}

	/**
	 * Indicate whether postdating of tokens is allowed.
	 */
	public void setPostdatable(Boolean value) {
		this.postdatable = value;
	}

	/**
	 * Indicate whether renewal of expired tokens is allowed.
	 */
	public Boolean getRenewableAfterExpiration() {
		return this.renewableAfterExpiration;
	}

	/**
	 * Indicate whether renewal of expired tokens is allowed.
	 */
	public void setRenewableAfterExpiration(Boolean value) {
		this.renewableAfterExpiration = value;
	}

	/**
	 * The amount of time tokens are kept in the cache after expiration (specified in minutes).
	 */
	public Integer getRenewalWindowMinutes() {
		return this.renewalWindowMinutes;
	}

	/**
	 * The amount of time tokens are kept in the cache after expiration (specified in minutes).
	 */
	public void setRenewalWindowMinutes(Integer value) {
		this.renewalWindowMinutes = value;
	}

	/**
	 * Token type custom properties.
	 */
	public java.util.Properties getCustomProperties() {
		return this.customProperties;
	}

	/**
	 * Token type custom properties.
	 */
	public void setCustomProperties(java.util.Properties value) {
		this.customProperties = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(String value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("URI", this.URI);
		ret.put("HandlerFactory", this.HandlerFactory);
		if (this.lifetimeMinutes != null) {
			ret.put("lifetimeMinutes", this.lifetimeMinutes);
		}
		if (this.distributedCache != null) {
			ret.put("distributedCache", this.distributedCache);
		}
		if (this.tokenCacheFactory != null) {
			ret.put("tokenCacheFactory", this.tokenCacheFactory);
		}
		if (this.postdatable != null) {
			ret.put("postdatable", this.postdatable);
		}
		if (this.renewableAfterExpiration != null) {
			ret.put("renewableAfterExpiration", this.renewableAfterExpiration);
		}
		if (this.renewalWindowMinutes != null) {
			ret.put("renewalWindowMinutes", this.renewalWindowMinutes);
		}
		if (this.customProperties != null) {
			ret.put("customProperties", this.customProperties);
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
