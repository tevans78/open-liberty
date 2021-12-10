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
 * Updates the LDAP search result cache configuration.
 *   'cacheSize': cacheSizeDesc
 *   'cachesDiskOffLoad': Whether or not to off-load the cache to a hard disk. This parameter affects both the attributes cache and the search results cache. By default, when the number of cache entries reaches the maximum size of the cache, eviction of cache entries occurs, allowing new entries to enter the caches. If the cachesDiskOffLoad option is enabled, the evicted cache entries are copied to disk for future access.
 *   'id': The unique identifier of the repository.
 *   'enabled': Whether or not to enable the search results cache.
 *   'cacheTimeOut': The number of seconds before the cached entries in the search results cache can be invalidated. The minimum cacheTimeout value is 0. The cached NamingEnumeration objects stay in the search results cache until updating operations occur, like updating, removing, or renaming.
 *   'searchResultSizeLimit': An integer that represents the maximum number of entries contained in the NamingEnumeration object that can be cached in the search results cache. If not present, the default value is 1000. For example, if the result from a search contains 2000 users, these search results are not cached in the search results cache if the value of this property is set to 1000.
 * The required parameters are found in the constructor.
 */
public class UpdateIdMgrLDAPSearchResultCache extends Command {

	private Integer cacheSize;
	private Boolean cachesDiskOffLoad;
	private String id;
	private Boolean enabled;
	private Integer cacheTimeOut;
	private Integer searchResultSizeLimit;

	public UpdateIdMgrLDAPSearchResultCache(String id) {
		super("updateIdMgrLDAPSearchResultCache");
		this.id = id;
	}

	/**
	 * cacheSizeDesc
	 */
	public Integer getCacheSize() {
		return this.cacheSize;
	}

	/**
	 * cacheSizeDesc
	 */
	public void setCacheSize(Integer value) {
		this.cacheSize = value;
	}

	/**
	 * Whether or not to off-load the cache to a hard disk. This parameter affects both the attributes cache and the search results cache. By default, when the number of cache entries reaches the maximum size of the cache, eviction of cache entries occurs, allowing new entries to enter the caches. If the cachesDiskOffLoad option is enabled, the evicted cache entries are copied to disk for future access.
	 */
	public Boolean getCachesDiskOffLoad() {
		return this.cachesDiskOffLoad;
	}

	/**
	 * Whether or not to off-load the cache to a hard disk. This parameter affects both the attributes cache and the search results cache. By default, when the number of cache entries reaches the maximum size of the cache, eviction of cache entries occurs, allowing new entries to enter the caches. If the cachesDiskOffLoad option is enabled, the evicted cache entries are copied to disk for future access.
	 */
	public void setCachesDiskOffLoad(Boolean value) {
		this.cachesDiskOffLoad = value;
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
	 * Whether or not to enable the search results cache.
	 */
	public Boolean getEnabled() {
		return this.enabled;
	}

	/**
	 * Whether or not to enable the search results cache.
	 */
	public void setEnabled(Boolean value) {
		this.enabled = value;
	}

	/**
	 * The number of seconds before the cached entries in the search results cache can be invalidated. The minimum cacheTimeout value is 0. The cached NamingEnumeration objects stay in the search results cache until updating operations occur, like updating, removing, or renaming.
	 */
	public Integer getCacheTimeOut() {
		return this.cacheTimeOut;
	}

	/**
	 * The number of seconds before the cached entries in the search results cache can be invalidated. The minimum cacheTimeout value is 0. The cached NamingEnumeration objects stay in the search results cache until updating operations occur, like updating, removing, or renaming.
	 */
	public void setCacheTimeOut(Integer value) {
		this.cacheTimeOut = value;
	}

	/**
	 * An integer that represents the maximum number of entries contained in the NamingEnumeration object that can be cached in the search results cache. If not present, the default value is 1000. For example, if the result from a search contains 2000 users, these search results are not cached in the search results cache if the value of this property is set to 1000.
	 */
	public Integer getSearchResultSizeLimit() {
		return this.searchResultSizeLimit;
	}

	/**
	 * An integer that represents the maximum number of entries contained in the NamingEnumeration object that can be cached in the search results cache. If not present, the default value is 1000. For example, if the result from a search contains 2000 users, these search results are not cached in the search results cache if the value of this property is set to 1000.
	 */
	public void setSearchResultSizeLimit(Integer value) {
		this.searchResultSizeLimit = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.cacheSize != null) {
			ret.put("cacheSize", this.cacheSize);
		}
		if (this.cachesDiskOffLoad != null) {
			ret.put("cachesDiskOffLoad", this.cachesDiskOffLoad);
		}
		ret.put("id", this.id);
		if (this.enabled != null) {
			ret.put("enabled", this.enabled);
		}
		if (this.cacheTimeOut != null) {
			ret.put("cacheTimeOut", this.cacheTimeOut);
		}
		if (this.searchResultSizeLimit != null) {
			ret.put("searchResultSizeLimit", this.searchResultSizeLimit);
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
