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
 * Creates an LDAP repository configuration object.
 *   'adapterClassName': The implementation class name for the repository adapter.
 *   'certificateFilter': If you specify the certificate map mode, use this property to specify the LDAP filter, which maps attributes in the client certificate to entries in LDAP.
 *   'certificateMapMode': Specifies whether to map X.509 certificates into an LDAP directory by exact distinguished name or certificate filter. Specify the certificate filter to use the specified certificate filter for the mapping.
 *   'default': A flag specifying whether to add the default setup.
 *   'id': The unique identifier of the repository.
 *   'isExtIdUnique': A boolean representing if the external ID for entities in the repository is unique
 *   'ldapServerType': The type of LDAP server used.
 *   'loginProperties': A semicolon separated list of virtual member manager properties that can be used for login. To add to the parameter, specify a list. To reset all the values of this parameter, specify an empty list.
 *   'primaryServerQueryTimeInterval': Polling interval for testing the primary server availability(in minutes)
 *   'returnToPrimaryServer': Return to the primary LDAP server when available
 *   'searchCountLimit': The maximum number of results returned from a search.
 *   'searchPageSize': The size of a page returned from a search.
 *   'searchTimeLimit': Set how long until a search terminates.
 *   'sslConfiguration': Secure Sockets Layer (SSL) configuration
 *   'supportAsyncMode': A boolean representing if the adapter supports asynchronous mode
 *   'supportExternalName': A boolean representing if the repository supports external names
 *   'supportPaging': A boolean representing if the repository supports paging
 *   'supportSorting': A boolean representing if the repository supports sorting
 *   'supportTransactions': A boolean representing if the repository supports transactions
 *   'translateRDN': Whether or not to translate the RDN when the LDAP distinguished name uses an RDN that is different from the virtual member manager default RDN for an entity.
 * The required parameters are found in the constructor.
 */
public class CreateIdMgrLDAPRepository extends Command {

	private String adapterClassName = "com.ibm.ws.wim.adapter.ldap.LdapAdapter";
	private String certificateFilter;
	private String certificateMapMode = "exactdn";
	private Boolean _default = true;
	private String id;
	private Boolean isExtIdUnique = true;
	private String ldapServerType = "IDS51";
	private String loginProperties;
	private Integer primaryServerQueryTimeInterval = 15;
	private Boolean returnToPrimaryServer = true;
	private Integer searchCountLimit;
	private Integer searchPageSize;
	private Integer searchTimeLimit;
	private String sslConfiguration;
	private Boolean supportAsyncMode = false;
	private Boolean supportExternalName = false;
	private Boolean supportPaging = false;
	private Boolean supportSorting = false;
	private Boolean supportTransactions = false;
	private Boolean translateRDN = false;

	public CreateIdMgrLDAPRepository(String id, String ldapServerType) {
		super("createIdMgrLDAPRepository");
		this.id = id;
		this.ldapServerType = ldapServerType;
	}

	/**
	 * The implementation class name for the repository adapter.
	 */
	public String getAdapterClassName() {
		return this.adapterClassName;
	}

	/**
	 * The implementation class name for the repository adapter.
	 */
	public void setAdapterClassName(String value) {
		this.adapterClassName = value;
	}

	/**
	 * If you specify the certificate map mode, use this property to specify the LDAP filter, which maps attributes in the client certificate to entries in LDAP.
	 */
	public String getCertificateFilter() {
		return this.certificateFilter;
	}

	/**
	 * If you specify the certificate map mode, use this property to specify the LDAP filter, which maps attributes in the client certificate to entries in LDAP.
	 */
	public void setCertificateFilter(String value) {
		this.certificateFilter = value;
	}

	/**
	 * Specifies whether to map X.509 certificates into an LDAP directory by exact distinguished name or certificate filter. Specify the certificate filter to use the specified certificate filter for the mapping.
	 */
	public String getCertificateMapMode() {
		return this.certificateMapMode;
	}

	/**
	 * Specifies whether to map X.509 certificates into an LDAP directory by exact distinguished name or certificate filter. Specify the certificate filter to use the specified certificate filter for the mapping.
	 */
	public void setCertificateMapMode(String value) {
		this.certificateMapMode = value;
	}

	/**
	 * A flag specifying whether to add the default setup.
	 */
	public Boolean getDefault() {
		return this._default;
	}

	/**
	 * A flag specifying whether to add the default setup.
	 */
	public void setDefault(Boolean value) {
		this._default = value;
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
	 * A boolean representing if the external ID for entities in the repository is unique
	 */
	public Boolean getIsExtIdUnique() {
		return this.isExtIdUnique;
	}

	/**
	 * A boolean representing if the external ID for entities in the repository is unique
	 */
	public void setIsExtIdUnique(Boolean value) {
		this.isExtIdUnique = value;
	}

	/**
	 * The type of LDAP server used.
	 */
	public String getLdapServerType() {
		return this.ldapServerType;
	}

	/**
	 * The type of LDAP server used.
	 */
	public void setLdapServerType(String value) {
		this.ldapServerType = value;
	}

	/**
	 * A semicolon separated list of virtual member manager properties that can be used for login. To add to the parameter, specify a list. To reset all the values of this parameter, specify an empty list.
	 */
	public String getLoginProperties() {
		return this.loginProperties;
	}

	/**
	 * A semicolon separated list of virtual member manager properties that can be used for login. To add to the parameter, specify a list. To reset all the values of this parameter, specify an empty list.
	 */
	public void setLoginProperties(String value) {
		this.loginProperties = value;
	}

	/**
	 * Polling interval for testing the primary server availability(in minutes)
	 */
	public Integer getPrimaryServerQueryTimeInterval() {
		return this.primaryServerQueryTimeInterval;
	}

	/**
	 * Polling interval for testing the primary server availability(in minutes)
	 */
	public void setPrimaryServerQueryTimeInterval(Integer value) {
		this.primaryServerQueryTimeInterval = value;
	}

	/**
	 * Return to the primary LDAP server when available
	 */
	public Boolean getReturnToPrimaryServer() {
		return this.returnToPrimaryServer;
	}

	/**
	 * Return to the primary LDAP server when available
	 */
	public void setReturnToPrimaryServer(Boolean value) {
		this.returnToPrimaryServer = value;
	}

	/**
	 * The maximum number of results returned from a search.
	 */
	public Integer getSearchCountLimit() {
		return this.searchCountLimit;
	}

	/**
	 * The maximum number of results returned from a search.
	 */
	public void setSearchCountLimit(Integer value) {
		this.searchCountLimit = value;
	}

	/**
	 * The size of a page returned from a search.
	 */
	public Integer getSearchPageSize() {
		return this.searchPageSize;
	}

	/**
	 * The size of a page returned from a search.
	 */
	public void setSearchPageSize(Integer value) {
		this.searchPageSize = value;
	}

	/**
	 * Set how long until a search terminates.
	 */
	public Integer getSearchTimeLimit() {
		return this.searchTimeLimit;
	}

	/**
	 * Set how long until a search terminates.
	 */
	public void setSearchTimeLimit(Integer value) {
		this.searchTimeLimit = value;
	}

	/**
	 * Secure Sockets Layer (SSL) configuration
	 */
	public String getSslConfiguration() {
		return this.sslConfiguration;
	}

	/**
	 * Secure Sockets Layer (SSL) configuration
	 */
	public void setSslConfiguration(String value) {
		this.sslConfiguration = value;
	}

	/**
	 * A boolean representing if the adapter supports asynchronous mode
	 */
	public Boolean getSupportAsyncMode() {
		return this.supportAsyncMode;
	}

	/**
	 * A boolean representing if the adapter supports asynchronous mode
	 */
	public void setSupportAsyncMode(Boolean value) {
		this.supportAsyncMode = value;
	}

	/**
	 * A boolean representing if the repository supports external names
	 */
	public Boolean getSupportExternalName() {
		return this.supportExternalName;
	}

	/**
	 * A boolean representing if the repository supports external names
	 */
	public void setSupportExternalName(Boolean value) {
		this.supportExternalName = value;
	}

	/**
	 * A boolean representing if the repository supports paging
	 */
	public Boolean getSupportPaging() {
		return this.supportPaging;
	}

	/**
	 * A boolean representing if the repository supports paging
	 */
	public void setSupportPaging(Boolean value) {
		this.supportPaging = value;
	}

	/**
	 * A boolean representing if the repository supports sorting
	 */
	public Boolean getSupportSorting() {
		return this.supportSorting;
	}

	/**
	 * A boolean representing if the repository supports sorting
	 */
	public void setSupportSorting(Boolean value) {
		this.supportSorting = value;
	}

	/**
	 * A boolean representing if the repository supports transactions
	 */
	public Boolean getSupportTransactions() {
		return this.supportTransactions;
	}

	/**
	 * A boolean representing if the repository supports transactions
	 */
	public void setSupportTransactions(Boolean value) {
		this.supportTransactions = value;
	}

	/**
	 * Whether or not to translate the RDN when the LDAP distinguished name uses an RDN that is different from the virtual member manager default RDN for an entity.
	 */
	public Boolean getTranslateRDN() {
		return this.translateRDN;
	}

	/**
	 * Whether or not to translate the RDN when the LDAP distinguished name uses an RDN that is different from the virtual member manager default RDN for an entity.
	 */
	public void setTranslateRDN(Boolean value) {
		this.translateRDN = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.adapterClassName != null) {
			ret.put("adapterClassName", this.adapterClassName);
		}
		if (this.certificateFilter != null) {
			ret.put("certificateFilter", this.certificateFilter);
		}
		if (this.certificateMapMode != null) {
			ret.put("certificateMapMode", this.certificateMapMode);
		}
		if (this._default != null) {
			ret.put("default", this._default);
		}
		ret.put("id", this.id);
		if (this.isExtIdUnique != null) {
			ret.put("isExtIdUnique", this.isExtIdUnique);
		}
		ret.put("ldapServerType", this.ldapServerType);
		if (this.loginProperties != null) {
			ret.put("loginProperties", this.loginProperties);
		}
		if (this.primaryServerQueryTimeInterval != null) {
			ret.put("primaryServerQueryTimeInterval", this.primaryServerQueryTimeInterval);
		}
		if (this.returnToPrimaryServer != null) {
			ret.put("returnToPrimaryServer", this.returnToPrimaryServer);
		}
		if (this.searchCountLimit != null) {
			ret.put("searchCountLimit", this.searchCountLimit);
		}
		if (this.searchPageSize != null) {
			ret.put("searchPageSize", this.searchPageSize);
		}
		if (this.searchTimeLimit != null) {
			ret.put("searchTimeLimit", this.searchTimeLimit);
		}
		if (this.sslConfiguration != null) {
			ret.put("sslConfiguration", this.sslConfiguration);
		}
		if (this.supportAsyncMode != null) {
			ret.put("supportAsyncMode", this.supportAsyncMode);
		}
		if (this.supportExternalName != null) {
			ret.put("supportExternalName", this.supportExternalName);
		}
		if (this.supportPaging != null) {
			ret.put("supportPaging", this.supportPaging);
		}
		if (this.supportSorting != null) {
			ret.put("supportSorting", this.supportSorting);
		}
		if (this.supportTransactions != null) {
			ret.put("supportTransactions", this.supportTransactions);
		}
		if (this.translateRDN != null) {
			ret.put("translateRDN", this.translateRDN);
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
