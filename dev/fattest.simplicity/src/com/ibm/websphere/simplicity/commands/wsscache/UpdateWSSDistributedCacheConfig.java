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

package com.ibm.websphere.simplicity.commands.wsscache;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Update Web Services Security Distrubuted Cache configuration properties
 *   'renewIntervalBeforeTimeoutMinutes': Renewal cushion period before the token expires
 *   'minutesInCacheAfterTimeout': Time to stay in cache after token expires
 *   'distributedCache': Indicate whether the cache for the token type is distributed.
 *   'synchronousClusterUpdate': Synchronous update of token state changes on cluster members
 *   'tokenRecovery': Token recovery support
 *   'Datasource': Datasource JNDI name
 * The required parameters are found in the constructor.
 */
public class UpdateWSSDistributedCacheConfig extends Command {

	private Integer renewIntervalBeforeTimeoutMinutes;
	private Integer minutesInCacheAfterTimeout;
	private Boolean distributedCache;
	private Boolean synchronousClusterUpdate;
	private Boolean tokenRecovery;
	private String Datasource;

	public UpdateWSSDistributedCacheConfig() {
		super("updateWSSDistributedCacheConfig");
	}

	/**
	 * Renewal cushion period before the token expires
	 */
	public Integer getRenewIntervalBeforeTimeoutMinutes() {
		return this.renewIntervalBeforeTimeoutMinutes;
	}

	/**
	 * Renewal cushion period before the token expires
	 */
	public void setRenewIntervalBeforeTimeoutMinutes(Integer value) {
		this.renewIntervalBeforeTimeoutMinutes = value;
	}

	/**
	 * Time to stay in cache after token expires
	 */
	public Integer getMinutesInCacheAfterTimeout() {
		return this.minutesInCacheAfterTimeout;
	}

	/**
	 * Time to stay in cache after token expires
	 */
	public void setMinutesInCacheAfterTimeout(Integer value) {
		this.minutesInCacheAfterTimeout = value;
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
	 * Synchronous update of token state changes on cluster members
	 */
	public Boolean getSynchronousClusterUpdate() {
		return this.synchronousClusterUpdate;
	}

	/**
	 * Synchronous update of token state changes on cluster members
	 */
	public void setSynchronousClusterUpdate(Boolean value) {
		this.synchronousClusterUpdate = value;
	}

	/**
	 * Token recovery support
	 */
	public Boolean getTokenRecovery() {
		return this.tokenRecovery;
	}

	/**
	 * Token recovery support
	 */
	public void setTokenRecovery(Boolean value) {
		this.tokenRecovery = value;
	}

	/**
	 * Datasource JNDI name
	 */
	public String getDatasource() {
		return this.Datasource;
	}

	/**
	 * Datasource JNDI name
	 */
	public void setDatasource(String value) {
		this.Datasource = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.renewIntervalBeforeTimeoutMinutes != null) {
			ret.put("renewIntervalBeforeTimeoutMinutes", this.renewIntervalBeforeTimeoutMinutes);
		}
		if (this.minutesInCacheAfterTimeout != null) {
			ret.put("minutesInCacheAfterTimeout", this.minutesInCacheAfterTimeout);
		}
		if (this.distributedCache != null) {
			ret.put("distributedCache", this.distributedCache);
		}
		if (this.synchronousClusterUpdate != null) {
			ret.put("synchronousClusterUpdate", this.synchronousClusterUpdate);
		}
		if (this.tokenRecovery != null) {
			ret.put("tokenRecovery", this.tokenRecovery);
		}
		if (this.Datasource != null) {
			ret.put("Datasource", this.Datasource);
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
