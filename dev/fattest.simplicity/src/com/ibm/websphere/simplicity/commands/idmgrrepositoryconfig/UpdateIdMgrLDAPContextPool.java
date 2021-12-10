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

package com.ibm.websphere.simplicity.commands.idmgrrepositoryconfig;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Updates the LDAP context pool configuration.
 *   'enabled': By default, the context pool is enabled. If "enabled" is set to "false", the context pool is disabled. This setting indicates to create a new context instance for each request.
 *   'id': The unique identifier of the repository.
 *   'initPoolSize': The number of context instances that the virtual member manager LDAP adapter creates when first creating the pool. The range of the initPoolSize option is from 1 to 50.
 *   'maxPoolSize': The maximum number of context instances that can be maintained concurrently by the context pool. Both in-use and idle context instances contribute to this number. When the pool size reaches this number, no new context instances are created for a new request. The new request is blocked until a context instance is released by another request or is removed. The request checks for available context instances in the pool every time period, as defined by the poolWaitTime option. The minimum maxPoolSize value is 0; no maximum value exists. A maximum pool size of 0 means that no maximum size is defined: A request for a pooled context instance uses an existing pooled idle context instance or a newly created pooled context instance.
 *   'poolTimeOut': An integer that represents the number of seconds that an idle context instance can remain in the pool without being closed and removed from the pool. When a context instance is requested from the pool, if this context already exists in the pool for more than the time defined by the poolTimeout option, this connection is closed regardless of whether this context instance is stale or active. A new context instance is created and put back to the pool after it is released from the request. The minimum value of poolTimeout is 0. No maximum value is defined. A poolTimeout value of 0 means that the context instances in the pool remain in the pool until they are staled. In this case, the context pool catches the communication exception and recreates a new context instance.
 *   'poolWaitTime': The time interval, in milliseconds, that the request waits until the context pool checks again if an idle context instance is available in the pool when the number of context instances reaches the maximum pool size. If no idle context instance exists, the request continues to wait for the same period of time before checking. The minimum poolWaitout value is 0; no maximum value is defined. A poolWaitTime value of 0 means that the Context Pool does not check for idle context instances. Instead, the request will be notified when a context instance is released from other requests.
 *   'prefPoolSize': The preferred number of context instances for the context pool to maintain. Both in-use and idle context instances contribute to this number. When a request for the use of a pooled context instance and the pool size is less than the preferred size, the context pool creates and uses a new pooled context instance regardless of whether an idle connection is available. When a request is finished with a pooled context instance and the pool size is greater than the preferred size, the context pool closes and removes the pooled context instance from the pool. The range of prefPoolSize values is from 0 to 100. A preferred pool size of 0 means that no preferred size exists: A request for a pooled context instance results in a newly created context instance only if no idle ones are available.
 * The required parameters are found in the constructor.
 */
public class UpdateIdMgrLDAPContextPool extends Command {

	private Boolean enabled;
	private String id;
	private Integer initPoolSize;
	private Integer maxPoolSize;
	private Integer poolTimeOut;
	private Integer poolWaitTime;
	private Integer prefPoolSize;

	public UpdateIdMgrLDAPContextPool(String id) {
		super("updateIdMgrLDAPContextPool");
		this.id = id;
	}

	/**
	 * By default, the context pool is enabled. If "enabled" is set to "false", the context pool is disabled. This setting indicates to create a new context instance for each request.
	 */
	public Boolean getEnabled() {
		return this.enabled;
	}

	/**
	 * By default, the context pool is enabled. If "enabled" is set to "false", the context pool is disabled. This setting indicates to create a new context instance for each request.
	 */
	public void setEnabled(Boolean value) {
		this.enabled = value;
	}

	/**
	 * The unique identifier of the repository.
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * The unique identifier of the repository.
	 */
	public void setId(String value) {
		this.id = value;
	}

	/**
	 * The number of context instances that the virtual member manager LDAP adapter creates when first creating the pool. The range of the initPoolSize option is from 1 to 50.
	 */
	public Integer getInitPoolSize() {
		return this.initPoolSize;
	}

	/**
	 * The number of context instances that the virtual member manager LDAP adapter creates when first creating the pool. The range of the initPoolSize option is from 1 to 50.
	 */
	public void setInitPoolSize(Integer value) {
		this.initPoolSize = value;
	}

	/**
	 * The maximum number of context instances that can be maintained concurrently by the context pool. Both in-use and idle context instances contribute to this number. When the pool size reaches this number, no new context instances are created for a new request. The new request is blocked until a context instance is released by another request or is removed. The request checks for available context instances in the pool every time period, as defined by the poolWaitTime option. The minimum maxPoolSize value is 0; no maximum value exists. A maximum pool size of 0 means that no maximum size is defined: A request for a pooled context instance uses an existing pooled idle context instance or a newly created pooled context instance.
	 */
	public Integer getMaxPoolSize() {
		return this.maxPoolSize;
	}

	/**
	 * The maximum number of context instances that can be maintained concurrently by the context pool. Both in-use and idle context instances contribute to this number. When the pool size reaches this number, no new context instances are created for a new request. The new request is blocked until a context instance is released by another request or is removed. The request checks for available context instances in the pool every time period, as defined by the poolWaitTime option. The minimum maxPoolSize value is 0; no maximum value exists. A maximum pool size of 0 means that no maximum size is defined: A request for a pooled context instance uses an existing pooled idle context instance or a newly created pooled context instance.
	 */
	public void setMaxPoolSize(Integer value) {
		this.maxPoolSize = value;
	}

	/**
	 * An integer that represents the number of seconds that an idle context instance can remain in the pool without being closed and removed from the pool. When a context instance is requested from the pool, if this context already exists in the pool for more than the time defined by the poolTimeout option, this connection is closed regardless of whether this context instance is stale or active. A new context instance is created and put back to the pool after it is released from the request. The minimum value of poolTimeout is 0. No maximum value is defined. A poolTimeout value of 0 means that the context instances in the pool remain in the pool until they are staled. In this case, the context pool catches the communication exception and recreates a new context instance.
	 */
	public Integer getPoolTimeOut() {
		return this.poolTimeOut;
	}

	/**
	 * An integer that represents the number of seconds that an idle context instance can remain in the pool without being closed and removed from the pool. When a context instance is requested from the pool, if this context already exists in the pool for more than the time defined by the poolTimeout option, this connection is closed regardless of whether this context instance is stale or active. A new context instance is created and put back to the pool after it is released from the request. The minimum value of poolTimeout is 0. No maximum value is defined. A poolTimeout value of 0 means that the context instances in the pool remain in the pool until they are staled. In this case, the context pool catches the communication exception and recreates a new context instance.
	 */
	public void setPoolTimeOut(Integer value) {
		this.poolTimeOut = value;
	}

	/**
	 * The time interval, in milliseconds, that the request waits until the context pool checks again if an idle context instance is available in the pool when the number of context instances reaches the maximum pool size. If no idle context instance exists, the request continues to wait for the same period of time before checking. The minimum poolWaitout value is 0; no maximum value is defined. A poolWaitTime value of 0 means that the Context Pool does not check for idle context instances. Instead, the request will be notified when a context instance is released from other requests.
	 */
	public Integer getPoolWaitTime() {
		return this.poolWaitTime;
	}

	/**
	 * The time interval, in milliseconds, that the request waits until the context pool checks again if an idle context instance is available in the pool when the number of context instances reaches the maximum pool size. If no idle context instance exists, the request continues to wait for the same period of time before checking. The minimum poolWaitout value is 0; no maximum value is defined. A poolWaitTime value of 0 means that the Context Pool does not check for idle context instances. Instead, the request will be notified when a context instance is released from other requests.
	 */
	public void setPoolWaitTime(Integer value) {
		this.poolWaitTime = value;
	}

	/**
	 * The preferred number of context instances for the context pool to maintain. Both in-use and idle context instances contribute to this number. When a request for the use of a pooled context instance and the pool size is less than the preferred size, the context pool creates and uses a new pooled context instance regardless of whether an idle connection is available. When a request is finished with a pooled context instance and the pool size is greater than the preferred size, the context pool closes and removes the pooled context instance from the pool. The range of prefPoolSize values is from 0 to 100. A preferred pool size of 0 means that no preferred size exists: A request for a pooled context instance results in a newly created context instance only if no idle ones are available.
	 */
	public Integer getPrefPoolSize() {
		return this.prefPoolSize;
	}

	/**
	 * The preferred number of context instances for the context pool to maintain. Both in-use and idle context instances contribute to this number. When a request for the use of a pooled context instance and the pool size is less than the preferred size, the context pool creates and uses a new pooled context instance regardless of whether an idle connection is available. When a request is finished with a pooled context instance and the pool size is greater than the preferred size, the context pool closes and removes the pooled context instance from the pool. The range of prefPoolSize values is from 0 to 100. A preferred pool size of 0 means that no preferred size exists: A request for a pooled context instance results in a newly created context instance only if no idle ones are available.
	 */
	public void setPrefPoolSize(Integer value) {
		this.prefPoolSize = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.enabled != null) {
			ret.put("enabled", this.enabled);
		}
		ret.put("id", this.id);
		if (this.initPoolSize != null) {
			ret.put("initPoolSize", this.initPoolSize);
		}
		if (this.maxPoolSize != null) {
			ret.put("maxPoolSize", this.maxPoolSize);
		}
		if (this.poolTimeOut != null) {
			ret.put("poolTimeOut", this.poolTimeOut);
		}
		if (this.poolWaitTime != null) {
			ret.put("poolWaitTime", this.poolWaitTime);
		}
		if (this.prefPoolSize != null) {
			ret.put("prefPoolSize", this.prefPoolSize);
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
