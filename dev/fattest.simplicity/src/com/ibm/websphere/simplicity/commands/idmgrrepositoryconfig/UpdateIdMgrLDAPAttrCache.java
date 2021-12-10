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
 * Updates the LDAP attribute cache configuration.
 *   'cacheSize': The maximum size of the attribute cache (the number of Attributes objects that can be put into the attributes Cache). The minimum cacheSize value is 100.
 *   'cacheTimeOut': The number of seconds before the cached entries in the attributes cache can be invalidated. The minimum cacheTimeout value is 0. The cached Attributes objects stays in the attributes cache until the Attributes objects are changed by virtual member manager through operations, like updating, removing, or renaming.
 *   'enabled': Whether or not to enable attribute cache.
 *   'attributeSizeLimit': An integer that represents the maximum number of values of an Attributes object that can be cached in the attributes Cache. If not present, the default value is 2000. Some attributes like member, usually contain a large number of values. This parameter is used to prevent the attributes cache from caching large attributes.
 *   'cachesDiskOffLoad': Whether or not to off-load the cache to a hard disk. This parameter affects both the attributes cache and the search results cache. By default, when the number of cache entries reaches the maximum size of the cache, eviction of cache entries occurs, allowing new entries to enter the caches. If the cachesDiskOffLoad option is enabled, the evicted cache entries are copied to disk for future access.
 *   'id': The unique identifier of the repository.
 *   'serverTTLAttribute': The name of the ttl attribute that is supported by the LDAP server. The attributes cache can use the value of this attribute to determine when the cached entries in the attributes cache time out. The ttl attribute contains the time, in seconds, that any information from the entry is kept by a client before it is considered stale and a new copy is retrieved. A value of 0 implies that the object must not be cached. For more information about this attribute, visit http://www.ietf.org/proceedings/98aug/I-D/draft-ietf-asid-ldap-cache-01.txt. The ttl attribute is not supported by all LDAP servers. If this attribute is supported by an LDAP server, the value of the serverTTLAttribute parameter can be set to the name of the ttl attribute (usually it is called 'ttl') to let the value of this attribute determine the timeout of the cached entry. In this way, the timeout value for different entries in the attributes cache might be different. For example, if this parameter is set to 'ttl', when Attributes cache retrieves attributes of a user from LDAP server, it also retrieves the value of the ttl attribute of this user. If the value is 200, then virtual member manager uses this value to set the timeout for the attributes of this user in the attributes cache instead of using the cacheTimeout value. The administrator of the LDAP server can set the ttl attribute differently for different users. For a regular employee, the value of the ttl attribute can be set to a longer value, while for a guest, it can be set to a shorter value.
 * The required parameters are found in the constructor.
 */
public class UpdateIdMgrLDAPAttrCache extends Command {

	private Integer cacheSize;
	private Integer cacheTimeOut;
	private Boolean enabled;
	private Integer attributeSizeLimit;
	private Boolean cachesDiskOffLoad;
	private String id;
	private String serverTTLAttribute;

	public UpdateIdMgrLDAPAttrCache(String id) {
		super("updateIdMgrLDAPAttrCache");
		this.id = id;
	}

	/**
	 * The maximum size of the attribute cache (the number of Attributes objects that can be put into the attributes Cache). The minimum cacheSize value is 100.
	 */
	public Integer getCacheSize() {
		return this.cacheSize;
	}

	/**
	 * The maximum size of the attribute cache (the number of Attributes objects that can be put into the attributes Cache). The minimum cacheSize value is 100.
	 */
	public void setCacheSize(Integer value) {
		this.cacheSize = value;
	}

	/**
	 * The number of seconds before the cached entries in the attributes cache can be invalidated. The minimum cacheTimeout value is 0. The cached Attributes objects stays in the attributes cache until the Attributes objects are changed by virtual member manager through operations, like updating, removing, or renaming.
	 */
	public Integer getCacheTimeOut() {
		return this.cacheTimeOut;
	}

	/**
	 * The number of seconds before the cached entries in the attributes cache can be invalidated. The minimum cacheTimeout value is 0. The cached Attributes objects stays in the attributes cache until the Attributes objects are changed by virtual member manager through operations, like updating, removing, or renaming.
	 */
	public void setCacheTimeOut(Integer value) {
		this.cacheTimeOut = value;
	}

	/**
	 * Whether or not to enable attribute cache.
	 */
	public Boolean getEnabled() {
		return this.enabled;
	}

	/**
	 * Whether or not to enable attribute cache.
	 */
	public void setEnabled(Boolean value) {
		this.enabled = value;
	}

	/**
	 * An integer that represents the maximum number of values of an Attributes object that can be cached in the attributes Cache. If not present, the default value is 2000. Some attributes like member, usually contain a large number of values. This parameter is used to prevent the attributes cache from caching large attributes.
	 */
	public Integer getAttributeSizeLimit() {
		return this.attributeSizeLimit;
	}

	/**
	 * An integer that represents the maximum number of values of an Attributes object that can be cached in the attributes Cache. If not present, the default value is 2000. Some attributes like member, usually contain a large number of values. This parameter is used to prevent the attributes cache from caching large attributes.
	 */
	public void setAttributeSizeLimit(Integer value) {
		this.attributeSizeLimit = value;
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
	 * The name of the ttl attribute that is supported by the LDAP server. The attributes cache can use the value of this attribute to determine when the cached entries in the attributes cache time out. The ttl attribute contains the time, in seconds, that any information from the entry is kept by a client before it is considered stale and a new copy is retrieved. A value of 0 implies that the object must not be cached. For more information about this attribute, visit http://www.ietf.org/proceedings/98aug/I-D/draft-ietf-asid-ldap-cache-01.txt. The ttl attribute is not supported by all LDAP servers. If this attribute is supported by an LDAP server, the value of the serverTTLAttribute parameter can be set to the name of the ttl attribute (usually it is called 'ttl') to let the value of this attribute determine the timeout of the cached entry. In this way, the timeout value for different entries in the attributes cache might be different. For example, if this parameter is set to 'ttl', when Attributes cache retrieves attributes of a user from LDAP server, it also retrieves the value of the ttl attribute of this user. If the value is 200, then virtual member manager uses this value to set the timeout for the attributes of this user in the attributes cache instead of using the cacheTimeout value. The administrator of the LDAP server can set the ttl attribute differently for different users. For a regular employee, the value of the ttl attribute can be set to a longer value, while for a guest, it can be set to a shorter value.
	 */
	public String getServerTTLAttribute() {
		return this.serverTTLAttribute;
	}

	/**
	 * The name of the ttl attribute that is supported by the LDAP server. The attributes cache can use the value of this attribute to determine when the cached entries in the attributes cache time out. The ttl attribute contains the time, in seconds, that any information from the entry is kept by a client before it is considered stale and a new copy is retrieved. A value of 0 implies that the object must not be cached. For more information about this attribute, visit http://www.ietf.org/proceedings/98aug/I-D/draft-ietf-asid-ldap-cache-01.txt. The ttl attribute is not supported by all LDAP servers. If this attribute is supported by an LDAP server, the value of the serverTTLAttribute parameter can be set to the name of the ttl attribute (usually it is called 'ttl') to let the value of this attribute determine the timeout of the cached entry. In this way, the timeout value for different entries in the attributes cache might be different. For example, if this parameter is set to 'ttl', when Attributes cache retrieves attributes of a user from LDAP server, it also retrieves the value of the ttl attribute of this user. If the value is 200, then virtual member manager uses this value to set the timeout for the attributes of this user in the attributes cache instead of using the cacheTimeout value. The administrator of the LDAP server can set the ttl attribute differently for different users. For a regular employee, the value of the ttl attribute can be set to a longer value, while for a guest, it can be set to a shorter value.
	 */
	public void setServerTTLAttribute(String value) {
		this.serverTTLAttribute = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.cacheSize != null) {
			ret.put("cacheSize", this.cacheSize);
		}
		if (this.cacheTimeOut != null) {
			ret.put("cacheTimeOut", this.cacheTimeOut);
		}
		if (this.enabled != null) {
			ret.put("enabled", this.enabled);
		}
		if (this.attributeSizeLimit != null) {
			ret.put("attributeSizeLimit", this.attributeSizeLimit);
		}
		if (this.cachesDiskOffLoad != null) {
			ret.put("cachesDiskOffLoad", this.cachesDiskOffLoad);
		}
		ret.put("id", this.id);
		if (this.serverTTLAttribute != null) {
			ret.put("serverTTLAttribute", this.serverTTLAttribute);
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
