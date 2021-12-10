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
 * updateSeveralWSSDistributedCacheConfigCmdDesc
 *   'renewIntervalBeforeTimeoutMinutes': Renewal cushion period before the token expires
 *   'minutesInCacheAfterTimeout': Time to stay in cache after token expires
 *   'notUpdate': notUpdateDesc
 *   'distributedCache': Indicate whether the cache for the token type is distributed.
 *   'clockSkewToleranceInMinutes': clockSkewToleranceCustomProperty
 * The required parameters are found in the constructor.
 */
public class UpdateDistributedCacheProperty extends Command {

	private Integer renewIntervalBeforeTimeoutMinutes;
	private Integer minutesInCacheAfterTimeout;
	private String notUpdate;
	private Boolean distributedCache;
	private Integer clockSkewToleranceInMinutes;

	public UpdateDistributedCacheProperty() {
		super("updateDistributedCacheProperty");
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
	 * notUpdateDesc
	 */
	public String getNotUpdate() {
		return this.notUpdate;
	}

	/**
	 * notUpdateDesc
	 */
	public void setNotUpdate(String value) {
		this.notUpdate = value;
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
	 * clockSkewToleranceCustomProperty
	 */
	public Integer getClockSkewToleranceInMinutes() {
		return this.clockSkewToleranceInMinutes;
	}

	/**
	 * clockSkewToleranceCustomProperty
	 */
	public void setClockSkewToleranceInMinutes(Integer value) {
		this.clockSkewToleranceInMinutes = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.renewIntervalBeforeTimeoutMinutes != null) {
			ret.put("renewIntervalBeforeTimeoutMinutes", this.renewIntervalBeforeTimeoutMinutes);
		}
		if (this.minutesInCacheAfterTimeout != null) {
			ret.put("minutesInCacheAfterTimeout", this.minutesInCacheAfterTimeout);
		}
		if (this.notUpdate != null) {
			ret.put("notUpdate", this.notUpdate);
		}
		if (this.distributedCache != null) {
			ret.put("distributedCache", this.distributedCache);
		}
		if (this.clockSkewToleranceInMinutes != null) {
			ret.put("clockSkewToleranceInMinutes", this.clockSkewToleranceInMinutes);
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
