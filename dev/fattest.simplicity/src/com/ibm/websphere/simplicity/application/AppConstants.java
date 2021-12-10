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

package com.ibm.websphere.simplicity.application;

public abstract class AppConstants {

	public static final String APPDEPL_CLIENT_ARCHIVE_PATH = "original.ear.location";
	public static final String APPDEPL_INSTALL_DIR = "installed.ear.destination";
	public static final String APPDEPL_ARCHIVE_UPLOAD = "archive.upload";
	public static final String APPDEPL_FILETRANSFER_UPLOAD = "upload";
	public static final String APPDEPL_VALIDATE_APP = "validateApp";
	public static final Boolean APPDEPL_VALIDATE_APP_DEFAULT = Boolean.TRUE;
	public static final String APPDEPL_DISTRIBUTE_APP = "distributeApp";
	public static final Boolean APPDEPL_DISTRIBUTE_APP_DEFAULT = Boolean.TRUE;
	public static final String APPDEPL_ZERO_BINARY_COPY = "zeroBinaryCopy";
	public static final String APPDEPL_ZERO_EAR_COPY = "zeroEarCopy";
	public static final String APPDEPL_DELETE_SRC_EAR = "DeleteSourceEar";
	public static final String APPDEPL_SYSTEM_APP_OPTION = "systemApp";
	public static final String APPDEPL_FILEPERMISSION = "filepermission";
	public static final String APPDEPL_FILEPERMISSION_DEFAULT = ".*\\.dll=755#.*\\.so=755#.*\\.a=755#.*\\.sl=755";
	public static final String APPDEPL_ASYNC_REQUEST_DISPATCH = "asyncRequestDispatchType";
	public static final String APPDEPL_ASYNC_REQUEST_DISPATCH_DEFAULT = "DISABLED";
	public static final String APPDEPL_ASYNC_REQUEST_DISPATCH_SERVER = "SERVER_SIDE";
	public static final String APPDEPL_ASYNC_REQUEST_DISPATCH_CLIENT = "CLIENT_SIDE";
	public static final String APPDEPL_VALIDATE_INSTALL = "validateinstall";
	public static final String APPDEPL_VALIDATE_INSTALL_OFF = "off";
	public static final String APPDEPL_VALIDATE_INSTALL_WARN = "warn";
	public static final String APPDEPL_VALIDATE_INSTALL_FAIL = "fail";
	public static final String APPDEPL_VALIDATE_INSTALL_DEFAULT = "off";
	public static final String APPDEPL_PROCESS_EMBEDDEDCFG_INSTALL = "processEmbeddedConfig";
	public static final Boolean APPDEPL_PROCESS_EMBEDDEDCFG_INSTALL_DEFAULT = Boolean.TRUE;
	public static final String APPDEPL_ENHANCED_EAR_CACHED = "EnhancedEarCached";
	public static final String CONFIGSERVICE = "configservice";
	public static final String ADMINCLIENT = "adminclient";
	public static final String CONFIGSESSION = "configsession";
	public static final String APPDEPL_ENHANCED_EAR_DISABLE_VALIDATION = "enhancedEarDisableValidation";
	public static final Boolean APPDEPL_ENHANCED_EAR_DISABLE_VALIDATION_DEFAULT = Boolean.FALSE;
	public static final String APPDEPL_ENHANCED_EAR = "enhancedEar";
	public static final Boolean APPDEPL_ENHANCED_EAR_DEFAULT = Boolean.FALSE;
	public static final String APPDEPL_ENHANCED_EAR_BINARIESURL="com.ibm.websphere.appinstall.enhear.preferBinariesURL";
	public static final Boolean APPDEPL_ENHANCED_EAR_BINARIESURL_DEFAULT = Boolean.TRUE;
    public static final String APPDEPL_DEPLOYWS_CLASSPATH = "deployws.classpath";
    public static final String APPDEPL_DEPLOYWS_JARDIRS = "deployws.jardirs";

	public static final String APPDEPL_PRECOMPILE_JSP = "preCompileJSPs";
	public static final Boolean APPDEPL_PRECOMPILE_JSP_DEFAULT = Boolean.FALSE;
	public static final String APPDEPL_JSP_RELOADENABLED = "jspReloadEnabled";
	public static final String APPDEPL_JSP_RELOADENABLED_NAME = "reloadEnabled";
	public static final Boolean APPDEPL_JSP_RELOADENABLED_DEFAULT = Boolean.FALSE;
	public static final String APPDEPL_JSP_RELOADINTERVAL = "jspReloadInterval";
	public static final String APPDEPL_JSP_RELOADINTERVAL_NAME = "reloadInterval";
	public static final int APPDEPL_JSP_RELOADINTERVAL_DEFAULT = 10;
	public static final String APPDEPL_PRECMPJSP_OPTIONS = "preCompileJSPs.options";
	public static final String APPDEPL_PRECMPJSP_CLASSPATH_OPTION = "jsp.classpath";
	public static final String APPDEPL_PRECMPJSP_USEFULLPACKAGENAMES = "useFullPackageNames";
	public static final Boolean APPDEPL_PRECMPJSP_USEFULLPACKAGENAMES_DEFAULT = Boolean.TRUE;
	public static final String APPDEPL_PRECMPJSP_SOURCELEVEL = "jdkSourceLevel";
	public static final String APPDEPL_PRECMPJSP_SOURCELEVEL_DEFAULT = "13";
	public static final String APPDEPL_PRECMPJSP_DISABLERTCOMPILE = "disableJspRuntimeCompilation";
	public static final Boolean APPDEPL_PRECMPJSP_DISABLERTCOMPILE_DEFAULT = Boolean.FALSE;

	public static final String APPDEPL_DEPLOYEJB_CMDARG = "deployejb";
	public static final Boolean APPDEPL_DEPLOYEJB_CMDARG_DEFAULT = Boolean.FALSE;
	public static final String APPDEPL_DEPLOYEJB_OPTIONS = "deployejb.options";
	public static final String APPDEPL_DEPLOYEJB_CODEGEN_OPTION = "deployejb.codegen";
	public static final String APPDEPL_DEPLOYEJB_CLASSPATH_OPTION = "deployejb.classpath";
	public static final String APPDEPL_DEPLOYEJB_VALIDATE_OPTION = "deployejb.validate";
	public static final String APPDEPL_DEPLOYEJB_RMIC_OPTION = "deployejb.rmic";
	public static final String APPDEPL_DEPLOYEJB_DBTYPE_OPTION = "deployejb.dbtype";
	public static final String APPDEPL_DEPLOYEJB_DBNAME_OPTION = "deployejb.dbname";
	public static final String APPDEPL_DEPLOYEJB_DBSCHEMA_OPTION = "deployejb.dbschema";
	public static final String APPDEPL_DEPLOYEJB_DBACCESSTYPE_OPTION = "deployejb.dbaccesstype";
	public static final String APPDEPL_DEPLOYEJB_SQLJCLASSPATH_OPTION = "deployejb.sqljclasspath";
	public static final String APPDEPL_DEPLOYEJB_COMPLIANCE_LEVEL_OPTION = "deployejb.complianceLevel";
	public static final Boolean APPDEPL_DEPLOYEJB_CODEGEN_OPTION_DEFAULT = Boolean.FALSE;
	public static final String APPDEPL_DEPLOYEJB_CLASSPATH_OPTION_DEFAULT = "";
	public static final Boolean APPDEPL_DEPLOYEJB_VALIDATE_OPTION_DEFAULT = Boolean.TRUE;
	public static final String APPDEPL_DEPLOYEJB_RMIC_OPTION_DEFAULT = "";
	public static final String APPDEPL_DEPLOYEJB_DBTYPE_OPTION_DEFAULT = (System.getProperty("os.name").equals("OS/400")) ? "DB2UDBISERIES_V52" : "DB2UDB_V82";
	public static final String APPDEPL_DEPLOYEJB_DBNAME_OPTION_DEFAULT = "";
	public static final String APPDEPL_DEPLOYEJB_DBSCHEMA_OPTION_DEFAULT = "";
	public static final String APPDEPL_DEPLOYEJB_DBACCESSTYPE_OPTION_DEFAULT = "JDBC";
	public static final String APPDEPL_DEPLOYEJB_SQLJCLASSPATH_OPTION_DEFAULT = "";
	public static final String APPDEPL_DEPLOYEJB_SQLJ_ACCESS_OPTION = "SQLj";
	public static final String APPDEPL_DEPLOYEJB_JDBC_ACCESS_OPTION = "JDBC";
	public static final String APPDEPL_DEPLOYEJB_COMPLIANCE_LEVEL_OPTION_DEFAULT = "";

	public static final String APPDEPL_MODULE_TO_SERVER = "moduleToServer";
	public static final String APPDEPL_MAP_SHAREDLIB = "mapSharedLib";

	public static final String APPDEPL_SESSMGR_CONFIG = "sessionMgr";
	public static final String APPDEPL_SESSMGR_CONFIG_ENABLE_URL_REWRITING = "sessionMgr.enableUrlRewriting";
	public static final Boolean APPDEPL_SESSMGR_CONFIG_ENABLE_URL_REWRITING_DEFAULT = Boolean.FALSE;
	public static final String APPDEPL_SESSMGR_CONFIG_ENABLE_COOKIES = "sessionMgr.enableCookies";
	public static final Boolean APPDEPL_SESSMGR_CONFIG_ENABLE_COOKIES_DEFAULT = Boolean.TRUE;
	public static final String APPDEPL_SESSMGR_CONFIG_ENABLE_SSL_TRACKING = "sessionMgr.enableSslTracking";
	public static final Boolean APPDEPL_SESSMGR_CONFIG_ENABLE_SSL_TRACKING_DEFAULT = Boolean.FALSE;
	public static final String APPDEPL_SESSMGR_CONFIG_ENABLE_PROTOCOL_SWITCH_REWRITING = "sessionMgr.protocolSwitchRewriting";
	public static final Boolean APPDEPL_SESSMGR_CONFIG_ENABLE_PROTOCOL_SWITCH_REWRITING_DEFAULT = Boolean.FALSE;
	public static final String APPDEPL_SESSMGR_CONFIG_ENABLE_SESSION_PERSISTENCE = "sessionMgr.enableSessionPersistence";
	public static final Boolean APPDEPL_SESSMGR_CONFIG_ENABLE_SESSION_PERSISTENCE_DEFAULT = Boolean.FALSE;
	public static final String APPDEPL_SESSMGR_CONFIG_ENABLE_SEC_INTEGRATION = "sessionMgr.enableSecurityIntegration";
	public static final Boolean APPDEPL_SESSMGR_CONFIG_ENABLE_SEC_INTEGRATION_DEFAULT = Boolean.FALSE;
	public static final String APPDEPL_SESSMGR_CONFIG_ALLOW_SERIALIZED_SESSION_ACCESS = "sessionMgr.allowSerializedSessionAccess";
	public static final Boolean APPDEPL_SESSMGR_CONFIG_ALLOW_SERIALIZED_SESSION_ACCESS_DEFAULT = Boolean.FALSE;
	public static final String APPDEPL_SESSMGR_CONFIG_MAX_WAIT_TIME = "sessionMgr.maxWaitTime";
	public static final int APPDEPL_SESSMGR_CONFIG_MAX_WAIT_TIME_DEFAULT = 0;
	public static final String APPDEPL_SESSMGR_CONFIG_ACCESS_SESSION_ON_TIMEOUT = "sessionMgr.accessSessionOnTimeout";
	public static final Boolean APPDEPL_SESSMGR_CONFIG_ACCESS_SESSION_ON_TIMEOUT_DEFAULT = Boolean.TRUE;
	public static final String APPDEPL_SESSMGR_CONFIG_ENABLE_SESSION = "sessionMgr.enableSession";
	public static final Boolean APPDEPL_SESSMGR_CONFIG_ENABLE_SESSION_DEFAULT = Boolean.TRUE;

	public static final String APPDEPL_SESSMGR_COOKIE_CONFIG = "sessionMgr.cookie";
	public static final String APPDEPL_SESSMGR_COOKIE_CONFIG_NAME = "sessionMgr.cookie.name";
	public static final String APPDEPL_SESSMGR_COOKIE_CONFIG_NAME_DEFAULT = "JSESSIONID";
	public static final String APPDEPL_SESSMGR_COOKIE_CONFIG_DOMAIN = "sessionMgr.cookie.domain";
	public static final String APPDEPL_SESSMGR_COOKIE_CONFIG_DOMAIN_DEFAULT = "ibm.com";
	public static final String APPDEPL_SESSMGR_COOKIE_CONFIG_MAX_AGE = "sessionMgr.cookie.maxAge";
	public static final int APPDEPL_SESSMGR_COOKIE_CONFIG_MAX_AGE_DEFAULT = -1;
	public static final String APPDEPL_SESSMGR_COOKIE_CONFIG_PATH = "sessionMgr.cookie.path";
	public static final String APPDEPL_SESSMGR_COOKIE_CONFIG_PATH_DEFAULT = "/";
	public static final String APPDEPL_SESSMGR_COOKIE_CONFIG_SECURE = "sessionMgr.cookie.secure";
	public static final Boolean APPDEPL_SESSMGR_COOKIE_CONFIG_SECURE_DEFAULT = Boolean.FALSE;

	public static final String APPDEPL_SESSMGR_TUNING_CONFIG = "sessionMgr.tuning";
	public static final String APPDEPL_SESSMGR_TUNING_CONFIG_USING_MULTI_ROW_SCHEMA = "sessionMgr.tuning.usingMultiRowSchema";
	public static final Boolean APPDEPL_SESSMGR_TUNING_CONFIG_USING_MULTI_ROW_SCHEMA_DEFAULT = Boolean.FALSE;
	public static final String APPDEPL_SESSMGR_TUNING_CONFIG_MAX_IN_MEMORY_SESSION_COUNT = "sessionMgr.tuning.maxInMemorySessionCount";
	public static final int APPDEPL_SESSMGR_TUNING_CONFIG_MAX_IN_MEMORY_SESSION_COUNT_DEFAULT = 1000;
	public static final String APPDEPL_SESSMGR_TUNING_CONFIG_ALLOW_OVERFLOW = "sessionMgr.tuning.allowOverflow";
	public static final Boolean APPDEPL_SESSMGR_TUNING_CONFIG_ALLOW_OVERFLOW_DEFAULT = Boolean.TRUE;
	public static final String APPDEPL_SESSMGR_TUNING_CONFIG_SCHEDULE_INVALIDATION = "sessionMgr.tuning.scheduleInvalidation";
	public static final Boolean APPDEPL_SESSMGR_TUNING_CONFIG_SCHEDULE_INVALIDATION_DEFAULT = Boolean.FALSE;
	public static final String APPDEPL_SESSMGR_TUNING_CONFIG_WRITE_FREQ = "sessionMgr.tuning.writeFreq";
	public static final String APPDEPL_SESSMGR_TUNING_CONFIG_WRITE_INTERVAL = "sessionMgr.tuning.writeInterval";
	public static final int APPDEPL_SESSMGR_TUNING_CONFIG_WRITE_INTERVAL_DEFAULT = 120;
	public static final String APPDEPL_SESSMGR_TUNING_CONFIG_WRITE_CONTENTS = "sessionMgr.tuning.writeContents";
	public static final String APPDEPL_SESSMGR_TUNING_CONFIG_INVALIDATION_TIMEOUT = "sessionMgr.tuning.invalidationTimeout";
	public static final int APPDEPL_SESSMGR_TUNING_CONFIG_INVALIDATION_TIMEOUT_DEFAULT = 30;

	public static final String APPDEPL_SESSMGR_PERSISTENCE_CONFIG = "sessionMgr.persistence";
	public static final String APPDEPL_SESSMGR_PERSISTENCE_CONFIG_DATASOURCE_JNDI_NAME = "sessionMgr.persistence.datasourceJndiName";
	public static final String APPDEPL_SESSMGR_PERSISTENCE_CONFIG_USER = "sessionMgr.persistence.user";
	public static final String APPDEPL_SESSMGR_PERSISTENCE_CONFIG_PASSWORD = "sessionMgr.persistence.password";
	public static final String APPDEPL_SESSMGR_PERSISTENCE_CONFIG_DB2_ROW_SIZE = "sessionMgr.persistence.db2RowSize";
	public static final String APPDEPL_SESSMGR_PERSISTENCE_CONFIG_TABLE_SPACE_NAME = "sessionMgr.persistence.tableSpaceName";

	public static final String APPDEPL_EJB_CONFIG = "ejbConfig";
	public static final String APPDEPL_EJB_CONFIG_MAX_INSTANCE_POOL = "ejbConfig.maxInstancePool";
	public static final int APPDEPL_EJB_CONFIG_MAX_INSTANCE_POOL_DEFAULT = 100;
	public static final String APPDEPL_EJB_CONFIG_MIN_INSTANCE_POOL = "ejbConfig.minInstancePool";
	public static final int APPDEPL_EJB_CONFIG_MIN_INSTANCE_POOL_DEFAULT = 2;

	public static final String APPDEPL_LOCAL_CONFIG_OPTIONS = "NoMBeanServerOptions";
	public static final String APPDEPL_LOCAL_CONFIG_WAS_INSTALL_ROOT = "was.install.root";
	public static final String APPDEPL_LOCAL_CONFIG_ROOT = "config.root";
	public static final String APPDEPL_LOCAL_CONFIG_ROOT_DEFAULT = "config";
	public static final String APPDEPL_LOCAL_CONFIG_INSTALL_DIR = APPDEPL_INSTALL_DIR;
	public static final String APPDEPL_LOCAL_CONFIG_INSTALL_DIR_DEFAULT = "installedApps";
	public static final String APPDEPL_CELL = "cell.name";
	public static final String APPDEPL_CELL_DEFAULT = "BaseApplicationServerCell";
	public static final String APPDEPL_NODE = "node.name";
	public static final String APPDEPL_NODES = "nodes";
	public static final String APPDEPL_NODE_DEFAULT = "DefaultNode";
	public static final String APPDEPL_SERVER = "server.name";
	public static final String APPDEPL_SERVER_DEFAULT = "server1";
	public static final String APPDEPL_CLUSTER = "cluster.name";
	public static final String APPDEPL_NODESVR_ADDED = "nodesvr.added";
	public static final String APPDEPL_NODESVR_REMOVED = "nodesvr.removed";
	public static final String APPDEPL_EXPORT_TO_LOCAL = "exportToLocal";

	public static final String APPDEPL_JDH = "jdh -- AppConstants.java version 6.1";

	public static final String APPDEPL_SYSTEM_APP_FLAG = "META-INF/ibm-application-sa.props";
	public static final String APPDEPL_SYSTEM_APP2_FLAG = "META-INF/ibm-application-sa2.props";
	public static final String APPDEPL_HIDDEN_APP_FLAG = "META-INF/ibm-application-ha.props";
	public static final String APPDEPL_SYSTEM_APP_DEPLOY_DIR = "com.ibm.deployment.config.location";
	public static final String APPDEPL_SYSTEM_APP_DFLT_DEPLOY_DIR = "systemApp/config";
	public static final String APPDEPL_SYSTEM_APP_PROPS = "system.app.properties";

	public static final String ConfigId = "AppManagement";
	public static final String ConfigType = "AppManagement";
	public static final String J2EEConfigId = "J2EEAppDeployment";
	public static final String J2EEConfigType = "J2EEAppDeployment";
	public static final String CONFIG_CONTACT = "IBM Corp.";

	public static final String YES_KEY = "AppDeploymentOption.Yes";
	public static final String NO_KEY = "AppDeploymentOption.No";
	public static final String NULL_STRING = "null";

	public static final String APPDEPL_EXTENSION_REG_LOC = "depl.extension.reg";

	public static final String APPDEPL_CMPBINDING_RESAUTHTYPE_CONTAINER = "cmpBinding.container";
	public static final String APPDEPL_CMPBINDING_RESAUTHTYPE_PER_CONNECTION_FACTORY = "cmpBinding.perConnectionFactory";

	public static final String APPDEPL_METHOD_PROTECTION_ASSIGN_DENYALL = "methodProtection.denyAllPermission";
	public static final String APPDEPL_METHOD_PROTECTION_UNCHECK = "methodProtection.uncheck";
	public static final String APPDEPL_METHOD_PROTECTION_EXCLUDE = "methodProtection.exclude";

	public static final String APPDEPL_DFLTBNDG = "usedefaultbindings";
	public static final String APPDEPL_DFLTBNDG_DDSJNDI = "defaultbinding.datasource.jndi";
	public static final String APPDEPL_DFLTBNDG_DDSUSER = "defaultbinding.datasource.username";
	public static final String APPDEPL_DFLTBNDG_DDSPASS = "defaultbinding.datasource.password";
	public static final String APPDEPL_DFLTBNDG_CFJNDI = "defaultbinding.cf.jndi";
	public static final String APPDEPL_DFLTBNDG_CFRESAUTH = "defaultbinding.cf.resauth";
	public static final String APPDEPL_DFLTBNDG_EJBJNDIPREFIX = "defaultbinding.ejbjndi.prefix";
	public static final String APPDEPL_DFLTBNDG_VHOST = "defaultbinding.virtual.host";
	public static final String APPDEPL_DFLTBNDG_FORCE = "defaultbinding.force";
	public static final String APPDEPL_DFLTBNDG_STRATEGY = "defaultbinding.strategy.file";

	public static final String APPDEPL_REDEPLOYEJB = "redeployejb.modules";
	public static final String APPDEPL_LOCALE = "app.client.locale";
	public static final String APPDEPL_DEFAULT_BUNDLE_NAME = "com.ibm.ws.management.resources.AppDeploymentMessages";

	public static final String APPDEPL_TRACE_GROUP = "Admin";
	public static final String APPDEPL_USE_BINARY_CONFIG = "useMetaDataFromBinary";
	public static final Boolean APPDEPL_USE_BINARY_CONFIG_DEFAULT = Boolean.FALSE;

	public static final String ListModulesTaskName = "ListModules";

	public static final String APPDEPL_EJB_VERSION_2 = "EJB 2.x";
	public static final String APPDEPL_EJB_VERSION_1 = "EJB 1.x";

	public static final String APPDEPL_CLIENT_VERSION = "ClientVersion";

	public static final String RARDEPL_NAME = "rar.name";
	public static final String RARDEPL_DESCRIPTION = "rar.desc";
	public static final String RARDEPL_ARCHIVEPATH = "rar.archivePath";
	public static final String RARDEPL_CLASSPATH = "rar.classpath";
	public static final String RARDEPL_NATIVEPATH = "rar.nativePath";
	public static final String RARDEPL_THREADPOOLALIAS = "rar.threadPoolAlias";
	public static final String RARDEPL_PROPERTIESSET = "rar.propertiesSet";
	public static final String RARDEPL_DELETESOURCERAR = "rar.DeleteSourceRar";
	public static final String RARDEPL_ISOLATEDCLASSLOADER = "rar.isolatedClassLoader";
	public static final String RARDEPL_ENABLEHASUPPORT = "rar.enableHASupport";
	public static final String RARDEPL_HACAPABILITY = "rar.HACapability";
	public static final String RARDEPL_HACAPABILITY_ENDPOINT = "endpoint";
	public static final String RARDEPL_HACAPABILITY_INSTANCE = "instance";
	public static final String RARDEPL_HACAPABILITY_NO = "no";

	public static final String RARDEPL_PROP_NAME = "name";
	public static final String RARDEPL_PROP_TYPE = "type";
	public static final String RARDEPL_PROP_VALUE = "value";
	public static final String RARDEPL_PROP_DESC = "desc";
	public static final String RARDEPL_PROP_DESCRIPTION = "description";
	public static final String RARDEPL_PROP_REQUIRED = "required";
	public static final String RARDEPL_PROP_TRUE = "true";
	public static final String RARDEPL_PROP_FALSE = "false";
	public static final String RARUNDEPL_FORCE = "force";
	public static final String APPREDEPL = "redeploy";
	public static final String APPREDEPL_IGNORE_OLDBND = "redeploy.ignore.old";
	public static final String APPREDEPL_IGNORE_NEWBND = "redeploy.ignore.new";
	public static final String APPREDEPL_DEFAULT_MERGE = "redeploy.default.merge";

	public static final String APPCTX = "deployments";
	public static final String APPBINCTX = "applications";

	public static final String APPSYNC_EXPERR = "expansionFailue";

	public static final String APPDEPL_EJB_MODULE = "EJBModule";
	public static final String APPDEPL_EJB = "EJB";
	public static final String APPDEPL_URI = "uri";
	public static final String APPDEPL_LISTENER_PORT = "listenerPort";
	public static final String APPDEPL_JNDI = "JNDI";
	public static final String APPDEPL_MODULE = "module";
	public static final String APPDEPL_CLIENT_MODULE = "ClientModule";
	public static final String APPDEPL_REFERENCE_BINDING = "referenceBinding";
	public static final String APPDEPL_ISOLATION_LEVEL = "isolationLevel";
	public static final String APPDEPL_METHOD_SIGNATURE = "method.signature";
	public static final String APPDEPL_ROLE = "role";
	public static final String APPDEPL_USERNAME = "userName";
	public static final String APPDEPL_PASSWORD = "password";
	public static final String APPDEPL_APP_VERSION = "AppVersion";
	public static final String APPDEPL_EJB_VERSION = "EJBVersion";
	public static final String APPDEPL_METHOD_DENYALL_ACCESS_PERMISSION = "method.denyAllAccessPermission";
	public static final String APPDEPL_METHOD_PROTECTION_TYPE = "method.protectionType";
	public static final String APPDEPL_CLASS = "class";
	public static final String APPDEPL_RESENVREF_TYPE = "resEnvRef.type";
	public static final String APPDEPL_MODULE_VERSION = "ModuleVersion";
	public static final String APPDEPL_INJECTION_REQUESTED = "injection.requested";
	public static final String APPDEPL_LOOKUP_NAME = "lookup.name";
	
	public static final String APPDEPL_MODULETYPE = "moduletype";
	public static final String APPDEPL_MODULETYPE_DISPLAY = "moduletypeDisplay";
	public static final String APPDEPL_MODULETYPE_EJB = "moduletype.ejb";
	public static final String APPDEPL_MODULETYPE_WEB = "moduletype.web";
	public static final String APPDEPL_MODULETYPE_CONNECTOR = "moduletype.connector";
	public static final String APPDEPL_MODULETYPE_UNKNOWN = "moduletype.unknown";

	public static final String APPDEPL_CONFIG_FILE_URI = "META-INF/ibm-was-config.props";
	public static final String APPDEPL_VAR_NAME = "variable.name";
	public static final String APPDEPL_VAR_VALUE = "variable.value";

	public static final String APPDEPL_RESREF_TYPE = "resRef.type";
	public static final String APPDEPL_ORACLE_REF = "oracleRef";
	public static final String APPDEPL_WEB_MODULE = "webModule";
	public static final String APPDEPL_VIRTUAL_HOST = "virtualHost";
	public static final String APPDEPL_SERVER_NAME = "server";   
	public static final String APPDEPL_ROLE_EVERYONE = "role.everyone";
	public static final String APPDEPL_ROLE_ALL_AUTH_USER = "role.all.auth.user";
	public static final String APPDEPL_ROLE_ALL_AUTH_REALMS = "role.all.auth.realms";
	public static final String APPDEPL_ROLE_USER = "role.user";
	public static final String APPDEPL_ROLE_GROUP = "role.group";
	public static final String APPDEPL_ROLE_USER_ACCESS_IDS = "role.user.access.ids";
	public static final String APPDEPL_ROLE_GROUP_ACCESS_IDS = "role.group.access.ids";
	public static final String APPDEPL_BACKENDIDS = "BackendIds";
	public static final String APPDEPL_CURRENT_BACKEND_ID = "CurrentBackendId";
	public static final String APPDEPL_RES_AUTH = "resAuth";
	public static final String APPDEPL_MESSAGING_TYPE = "messagingType";

	public static final String APPDEPL_MESSAGE_DESTINATION_REF_NAME = "messageDestinationRefName";
	public static final String APPDEPL_MESSAGE_DESTINATION_OBJECT = "messageDestinationObject";
	public static final String APPDEPL_IS_MD = "isMD";

	public static final String APPDEPL_METHOD_NAME = "method.name";
	public static final String APPDEPL_METHOD_PARAMS = "method.params";
	public static final String APPDEPL_FINDER_QUERY = "finder.query";

	public static final String APPDEPL_WEB_CONTEXTROOT = "web.contextroot";
	public static final String APPDEPL_WEB_SERVLET = "web.servlet";
	public static final String APPDEPL_WEB_INITPARAM = "web.initparam";
	public static final String APPDEPL_WEB_ENV_ENTRY = "web.enventry";
	public static final String APPDEPL_PROP_NAME = "prop.name";
	public static final String APPDEPL_PROP_TYPE = "prop.type";
	public static final String APPDEPL_PROP_VALUE = "prop.value";
	public static final String APPDEPL_PROP_DESC = "prop.description";

	public static final String APPDEPL_SHAREDLIB_NAME = "sharedLibName";
	public static final Boolean APPDEPL_ISSHARED_DEFAULT = Boolean.TRUE;

	public static final String APPDEPL_RARPROPS_NAME = "rar.object.name";
	public static final String APPDEPL_RARPROPS_JNDI = "rar.object.jndiname";
	public static final String APPDEPL_RARPROPS_FILE = "META-INF/ibm-jcajndi.props";

	public static final String APPDEPL_JNDI_DEST = "jndi.dest";
	public static final String APPDEPL_ACT_AUTH = "actspec.auth";
	public static final String APPDEPL_LOGIN_CONFIG = "login.config.name";
	public static final String APPDEPL_AUTH_PROPS = "auth.props";
	public static final String APPDEPL_DEFAULT_PMAP = "DefaultPrincipalMapping";
	public static final String APPDEPL_ACT_DESTINATION = "Destination";
	public static final String APPDEPL_ACT_DEST_TYPE = "javax.jms.Destination";
	public static final String APPDEPL_J2CACTSPEC = "J2CActivationSpec";

	public static final String APPDEPL_RAR_MODULE = "RARModule";
	public static final String APPDEPL_J2C_TYPE = "j2ctype";
	public static final String APPDEPL_J2C_ID = "j2cid";
	public static final String APPDEPL_J2C_JNDINAME = "j2c.jndiName";
	public static final String APPDEPL_J2C_NAME = "j2c.name";

	public static final String APPDEPL_J2C_CF = "J2CConnectionFactory";
	public static final String APPDEPL_J2C_AC = "J2CActivationSpec";
	public static final String APPDEPL_J2C_AO = "J2CAdminObject";
	public static final String APPDEPL_J2C_DEFAULT_JNDI = "eis/";
	public static final String APPDEPL_J2C_DEFAULT_PREFIX = "-";

	public static final String APPDEPL_RAR_JNDI_NAME = "rar.object.jndiname";
	public static final String APPDEPL_RAR_NAME = "rar.object.name";
	public static final String APPDEPL_RAR_DESTJNDI_NAME="rar.destintion.jndiname";

	public static String ObjectNameDelim = "+";

	public static final String APPDPL_EJB3_BINDING_TASK = "EJBBindingFile";
	public static final String APPDPL_MODULE_NAME = "module.name";
	public static final String APPDPL_DEFAULT_DEST_URI = "default.destination.uri";
	public static final String APPDPL_CURR_URI="current.uri";
	public static final String APPDPL_META_CELL_NAME = "CELL_NAME";
	public static final String APPDPL_EJB3_PROD_SHORT_NAME_KEY = "com.ibm.websphere.EJB3FeaturePackProductShortName";
	public static final String APPDPL_EJB3_PROD_SHORT_NAME_VALUE = "EJB 3.0";
	public static final String APPDEPL_AUTOLINK = "useAutoLink";
	public static final Boolean APPDEPL_AUTOLINK_DEFAULT = Boolean.FALSE;

	public static final String APPDEPL_APPNAME = "appname";
	public static final String APPDEPL_APP_ORIG_URI = "app.original.uri";
	public static final String APPDEPL_BINNAME = "appbinary.name";

	public static final String APPDEPL_COPYSESSIONMGR_SNAME = "copy.sessionmgr.servername";

	public static final String CELLMGR_NAME = "dmgr";

	public static final String TEMP_EXTRACT_DIR = "Temp extraction dir for multiserver";
	public static final String CONFIG_ROOT = "Config Root for variable map";

	public static final String APPDEPL_MBEANFORRES = "createMBeansForResources";
	public static final Boolean APPDEPL_MBEANFORRES_DEFAULT = Boolean.TRUE;
	public static final String APPDEPL_RELOADINTERVAL = "reloadInterval";
	public static final int APPDEPL_RELOADINTERVAL_DEFAULT = 10;
	public static final String APPDEPL_RELOADENABLED = "reloadEnabled";
	public static final Boolean APPDEPL_RELOADENABLED_DEFAULT = Boolean.FALSE; 
	public static final String APPDEPL_CLASSLOADINGMODE = "classLoadingMode";
	public static final String APPDEPL_CLASSLOADERPOLICY = "classLoaderPolicy";

	public static final String APPDEPL_HANDBACK = "HandBackForClient";

	public static final String APPDEPL_APPDEPL = "AppDeplObj";

	public static final String APPDEPL_DEPLOYWS_CMDARG = "deployws";
	public static final String APPDEPL_DEPLOYWS_OPTIONS = "deployws.options";
	public static final String APPDEPL_DEPLOYWS_CLASSPATH_OPTION = "deployws.classpath";
	public static final String APPDEPL_DEPLOYWS_JARDIRS_OPTION = "deployws.jardirs";
	public static final Boolean APPDEPL_DEPLOYWS_CMDARG_DEFAULT = Boolean.FALSE;
	public static final String APPDEPL_DEPLOYWS_CLASSPATH_OPTION_DEFAULT = "";
	public static final String APPDEPL_DEPLOYWS_JARDIRS_OPTION_DEFAULT = "";

	public static final String J2EEDEPL_DEFAULT_BUNDLE_NAME = "com.ibm.ws.management.resources.J2eeDeploymentMessages";

	public static final String JSR88DEPL_KEY = "jsr88";
	public static final String JSR88DEPL_NAME = "taskName";
	public static final String JSR88DEPL_DESC= "taskDescription";

	public static final String APPDEPL_STANDALONE_URI = "appdeplStandaloneURI";

	public static final String LOOSE_CONFIG_PROPERTY = "was.loose.config";
	public static final String APPDEPL_INSTALL_DIR_FINAL = "installed.ear.destination.final";
	public static final String WASPROFILE_IMPORT = "was.profile.import";

	public static final String APPHIST_CHANGETYPE = "changetype";
	public static final String APPHIST_INSTALL = "install";
	public static final String APPHIST_EDIT = "edit";
	public static final String APPHIST_FGUPDATE = "fg-update";

	public static final String APPUPDATE_CONTENTURI = "contenturi";
	public static final String APPUPDATE_CONTENTURI_TABLE = "contenturi_table";
	public static final String APPUPDATE_CONTENTTYPE = "contenttype";
	public static final String APPUPDATE_CONTENT_FILE = "file";
	public static final String APPUPDATE_CONTENT_MODULEFILE = "modulefile";
	public static final String APPUPDATE_CONTENT_PARTIALAPP = "partialapp";
	public static final String APPUPDATE_CONTENT_APP = "app";

	public static final String APPUPDATE_OPERATION = "operation";
	public static final String APPUPDATE_ADD = "add";
	public static final String APPUPDATE_ADDUPDATE = "addupdate";
	public static final String APPUPDATE_UPDATE = "update";
	public static final String APPUPDATE_DELETE = "delete";

	public static final String APPUPDATE_MODULETYPE = APPDEPL_MODULETYPE;
	public static final String APPUPDATE_MODULETYPE_EJB = APPDEPL_MODULETYPE_EJB;
	public static final String APPUPDATE_MODULETYPE_WEB = APPDEPL_MODULETYPE_WEB;
	public static final String APPUPDATE_MODULETYPE_CONNECTOR = APPDEPL_MODULETYPE_CONNECTOR;
	public static final String APPUPDATE_MODULETYPE_UNKNOWN = APPDEPL_MODULETYPE_UNKNOWN;

	public static final String APPUPDATE_RECYCLE = "update.recycle";
	public static final String APPUPDATE_RECYCLE_NONE = "update.recycle.none";
	public static final String APPUPDATE_RECYCLE_APP = "update.recycle.app";
	public static final String APPUPDATE_RECYCLE_MODULES = "update.recycle.modules";

	public static final String APPUPDATE_PARTIALEAR_PROPFILE = "META-INF/ibm-partialapp-delete.props";

	public static final String APPDEPL_WEBMODULE_CONTEXTROOT = "contextroot";

	public static final String APPDEPL_EDITION = "edition";
	public static final String APPDEPL_EDITION_DESC = "edition.desc";	

	public static final long INSTALL_MODE = 0x1;
	public static final long EDITAPP_MODE = 0x10;
	public static final long EDITMODULE_MODE = 0x100;
	public static final long EDIT_MODE = EDITAPP_MODE | EDITMODULE_MODE;
	public static final long UPDATEAPP_MODE = 0x1000;
	public static final long UPDATEMODULE_MODE = 0x10000;
	public static final long ADDMODULE_MODE = 0x100000;
	public static final long UPDATE_MODE = UPDATEAPP_MODE | UPDATEMODULE_MODE | ADDMODULE_MODE;
	public static final long UPDATESINGLEFILE_MODE = 0x1000000;
	public static final long UPDATEPARTIAL_MODE = 0x2000000;
	public static final long VIEWAPP_MODE = 0x4000000;
	public static final long UNINSTALL_MODE = 0x8000000;

	public static final String APPUPDATE_DELTAFILE_PREFIX = "delta";
	public static final String APPUPDATE_DELTAFILE_DIRROOT = "deltas";

	public static final String APPDEPL_EARFILE = "earfile";

	public static final String APPDEPL_J2C_RESOURCE_ADAPTER = "J2CResourceAdapter";
	public static final String APPDEPL_J2C_ACTIVATION_SPEC = "J2CActivationSpec";
	public static final String APPDEPL_J2C_ADMIN_OBJECT = "J2CAdminObject";
	public static final String APPDEPL_J2C_CONN_FACTORY = "J2CConnectionFactory";
	public static final String APPDEPL_JDBC_PROVIDER = "JDBCProvider";
	public static final String APPDEPL_WAS40_DATA_SOURCE = "WAS40DataSource";
	public static final String APPDEPL_WAS50_DATA_SOURCE = "WAS50DataSource";
	public static final String APPDEPL_CMP_CONN_FACTORY = "CMPConnectorFactory";
	public static final String APPDEPL_JMS_PROVIDER= "JMSProvider";
	public static final String APPDEPL_MAIL_PROVIDER = "MailProvider";
	public static final String APPDEPL_URL_PROVIDER = "URLProvider";
	public static final String APPDEPL_RES_ENV_PROVIDER = "ResourceEnvironmentProvider";

	public static final String APPDEPL_CLUSTER_RIPPLE_UPDATE = "clusterUpdate";
	public static final Boolean APPDEPL_CLUSTER_RIPPLE_UPDATE_DEFAULT = Boolean.FALSE;
	public static final String APPDEPL_CLUSTER_RIPPLE_UPDATE_APPS = "clusterUpdateApps";

	public static final String APPDEPL_RESOURCE_MAPPER_CONFIG_ARCHIVE_OP = "resource.mapper.config.archive.op";
	public static final String APPDEPL_RESOURCE_MAPPER_APP_VALIDATION_OP = "resource.mapper.app.validation.op";
	public static final String APPDEPL_RESOURCE_MAPPER_APP_RESOURCE_OP = "resource.mapper.app.resource.op";
	public static final String APPDEPL_RESOURCE_MAPPER_QUEUE = "Queue";
	public static final String APPDEPL_RESOURCE_MAPPER_TOPIC = "Topic";
	public static final String APPDEPL_RESOURCE_MAPPER_QUEUE_CONN_FACTORY = "QueueConnectionFactory";
	public static final String APPDEPL_RESOURCE_MAPPER_TOPIC_CONN_FACTORY = "TopicConnectionFactory";
	public static final String APPDEPL_RESOURCE_MAPPER_CONN_FACTORY = "ConnectionFactory";
	public static final String APPDEPL_RESOURCE_MAPPER_XA_QUEUE_CONN_FACTORY = "XAQueueConnectionFactory";
	public static final String APPDEPL_RESOURCE_MAPPER_MAIL_SESSION = "MailSession";
	public static final String APPDEPL_RESOURCE_MAPPER_DATA_SOURCE = "DataSource";
	public static final String APPDEPL_RESOURCE_MAPPER_URL = "URL";
	public static final String APPDEPL_RESOURCE_MAPPER_RES_ENV_ENTRY = "ResourceEnvEntry";
	public static final String APPDEPL_RESOURCE_MAPPER_VIRTUAL_HOST = "VirtualHost";
	public static final String APPDEPL_RESOURCE_MAPPER_CMP_CONNECTOR_REFID = "builtin_rra";
	public static final String APPDEPL_RESOURCE_MAPPER_JNDINAME = "jndiName";
	public static final String APPDEPL_RESOURCE_MAPPER_DEST_JNDINAME = "destinationJndiName";
	public static final String APPDEPL_RESOURCE_MAPPER_NAME = "name";
	public static final String APPDEPL_RESOURCE_VALIDATION_RESOURCE_TYPE = "ResourceType";
	public static final String APPDEPL_RESOURCE_VALIDATION_TARGETS = "Targets";
	public static final String APPDEPL_RESOURCE_VALIDATION_SCOPE = "Scope";
	public static final String APPDEPL_RESOURCE_VALIDATION_MISTYPE = "MisType";
	public static final String APPDEPL_RESOURCE_VALIDATION_RESTYPE = "resource.type";
	public static final String APPDEPL_RESOURCE_VALIDATION_RESOBJECT = "resource.object";
	public static final String APPDEPL_RESOURCE_VALIDATION_OUT_OF_SCOPE = "outOfScope";
	public static final String APPDEPL_RESOURCE_MAPPER_LIBRARY = "Library";
	public static final String APPDEPL_RESOURCE_MAPPER_WORK_MANAGER_INFO = "WorkManagerInfo";
	public static final String APPDEPL_RESOURCE_MAPPER_TIMER_MANAGER_INFO = "TimerManagerInfo";
	public static final String APPDEPL_RESOURCE_MAPPER_OB_CACHE_INST = "ObjectCacheInstance";
	public static final String APPDEPL_RESOURCE_MAPPER_SCHEDULER_CONFIG = "SchedulerConfiguration";
	public static final String APPDEPL_TARGET = "target";

	public static final String ObjectNameDelimAdd = "+";
	public static final String ObjectNameDelimRem = "-";

	public static final String APPDEPL_BUILDVERSION = "buildVersion"; 
	public static final String APPDEPL_BUILDVERSION_DEFAULT = "Unknown";
	public static final String APPDEPL_BUILDVERSION_ATTRKEY = (java.util.jar.Attributes.Name.IMPLEMENTATION_VERSION).toString();
	public static final String APPDEPL_DISPATCH_REMOTEINCLUDE = "allowDispatchRemoteInclude"; 
	public static final Boolean APPDEPL_DISPATCH_REMOTEINCLUDE_DEFAULT = Boolean.FALSE; 
	public static final String APPDEPL_SERVICE_REMOTEINCLUDE = "allowServiceRemoteInclude"; 
	public static final Boolean APPDEPL_SERVICE_REMOTEINCLUDE_DEFAULT = Boolean.FALSE; 
	public static final String APPDEPL_SKIPPREP = "skipPreparation";
	public static final String APPDEPL_PROFILEKEY = "profileKey";

	public static final String APPDEPL_BLANAME = "blaname";
	public static final String BLA_CU_EDITION = "1.0";
	public static final String APPDEPL_ACTIVATION_PLAN_ADD = "activation.plan.add";
	public static final String APPDEPL_ACTIVATION_PLAN_REMOVE = "activation.plan.remove";
	public static final String APPDEPL_ACTIVATION_PLAN_DEFAULT = "activation.plan.default";
	public static final String APPDEPL_ACTIVATION_PLAN_SPEC = "specname";
	public static final String APPDEPL_ACTIVATION_PLAN_SPEC_VER = "specversion";
	public static final String APPDEPL_ACTIVATION_PLAN_PROP_FILE = "META-INF/ibm-application-runtime.props";
	public static final String APPDEPL_ACTIVATION_PLAN_PROP_PREFIX = "com.ibm.ws.runtime.components.";
	public static final String J2EE_FROM_BLA = "J2ee_From_Bla";
	public static final String APPDEPL_RELATIONSHIP = "relationship";
	public static final String APPDEPL_RELATIONSHIP_CU_NAME = "compUnitName";
	public static final String APPDEPL_RELATIONSHIP_MATCH_TARGET = "matchTarget";
	public static final String APPDEPL_RELATIONSHIP_ORIG_REL = "origRelationship";
	public static final String APPDEPL_SHAREDLIB_RELATIONSHIP = "sharedLibRelationship";
	public static final String BLA_NO_SAVE = "bla.no.save";

	public static final String APPDEPL_IMPORT_ARCHIVE = "import.archive";
	public static final String SKIP_BLA_CONFIG = "skip.bla.config";

	public static final Boolean APPDEPL_LOCK_DD_DEFAULT = Boolean.FALSE;

	public static final String APPDEPL_EJB_REF_NAME = "ejbRefName";
	public static final String APPDEPL_EJB_REF_TYPE = "ejbRefType";
	public static final String APPDEPL_EJB_REF_TYPE_LOCAL = "local";
	public static final String APPDEPL_EJB_REF_TYPE_REMOTE = "remote";
	public static final String APPDEPL_EJB_BUSINESS_INTERFACE = "ejbBusinessInterface";
	public static final String APPDEPL_EJB_BUSINESS_INTERFACE_JNDI = "ejbBusinessInterfaceJndi";
	public static final String APPDEPL_LOCK_MODULE_DD = "lockDeploymentDescriptor";
	public static final String APPDEPL_EJB_LOCAL_HOME_INTERFACE_NAME = "localHomeInterfaceName";
	public static final String APPDEPL_EJB_LOCAL_HOME_JNDI = "localHomeJndi";
	public static final String APPDEPL_EJB_REMOTE_HOME_INTERFACE_NAME = "remoteHomeInterfaceName";
	public static final String APPDEPL_EJB_REMOTE_HOME_JNDI = "remoteHomeJndi";
	public static final String METADATA_COMPLETE_PROPERTY = "metadata.complete";
	public static final String APPDEPL_MARK_METADATA_COMPLETE = "true";
	public static final String APPDEPL_MARK_METADATA_NOT_COMPLETE = "false";
	public static final String APPDEPL_DATASOURCE_PROPS = "dataSourceProps";
	
	public static final String APPDEPL_USE_JASPI = "usejaspi";
	public static final String APPDEPL_PROVIDER_NAME = "providername";
	public static final String APPDEPL_MSG_LAYER = "msglayer";
	
	public static final String APPDEPL_VALIDATE_SCHEMA = "validateSchema";
	public static final Boolean APPDEPL_VALIDATE_SCHEMA_DEFAULT = Boolean.FALSE;
	
	public static final String APPDEPL_CLIENT_MODE = "clientMode";
	public static final String APPDEPL_ENABLE_CLIENT_MODULE = "enableClientModule";
	
	/**
	 * Tasks
	 */
	public static final String AppDeploymentOptionsTask = "AppDeploymentOptions";
	public static final String MapModulesToServersTask = "MapModulesToServers";
	public static final String MapRolesToUsersTask = "MapRolesToUsers";
	public static final String EJBDeployOptionsTask = "EJBDeployOptions";
	public static final String BackendIdSelectionTask = "BackendIdSelection";
	public static final String BindJndiForEJBMessageBindingTask = "BindJndiForEJBMessageBinding";
	public static final String BindJndiForEJBNonMessageBindingTask = "BindJndiForEJBNonMessageBinding";
	public static final String CorrectOracleIsolationLevelTask = "CorrectOracleIsolationLevel";
	public static final String CorrectUseSystemIdentityTask = "CorrectUseSystemIdentity";
	public static final String CustomActivationPlanTask = "CustomActivationPlan";
	public static final String DataSourceFor10CMPBeansTask = "DataSourceFor10CMPBeans";
	public static final String DataSourceFor20CMPBeansTask = "DataSourceFor20CMPBeans";
	public static final String DataSourceFor10EJBModulesTask = "DataSourceFor10EJBModules";
	public static final String DataSourceFor20EJBModulesTask = "DataSourceFor20EJBModules";
	public static final String EnsureMethodProtectionFor10EJBTask = "EnsureMethodProtectionFor10EJB";
	public static final String EnsureMethodProtectionFor20EJBTask = "EnsureMethodProtectionFor20EJB";
	public static final String MapEJBRefToEJBTask = "MapEJBRefToEJB";
	public static final String MapEnvEntryForWebModTask = "MapEnvEntryForWebMod";
	public static final String MapEnvEntryForEJBModTask = "MapEnvEntryForEJBMod";
	public static final String MapResRefToEJBTask = "MapResRefToEJB";
	public static final String MapResEnvRefToResTask = "MapResEnvRefToRes";
	public static final String MapRunAsRolesToUsersTask = "MapRunAsRolesToUsers";
	public static final String MapWebModToVHTask = "MapWebModToVH";
	public static final String DefaultBindingTask = "DefaultBinding";
	public static final String MapWebServiceRefToEJBTask = "MapWebServiceRefToEJB";
	public static final String MapMessageDestinationRefToEJBTask = "MapMessageDestinationRefToEJB";
	public static final String BindJndiForMDBTask = "BindJndiForMDB";
	public static final String EmbeddedRarTask = "EmbeddedRar";
	public static final String FinderQueryForCMP1XTask = "FinderQueryForCMP1X";
	public static final String ActSpecJNDITask = "ActSpecJNDI";
	public static final String CtxRootForWebMethodTask = "CtxRootForWebMod";
	public static final String MapInitParamForServletTask = "MapInitParamForServlet";
	public static final String JSPReloadForWebModTask = "JSPReloadForWebMod";
	public static final String JSPCompileOptionsTask = "JSPCompileOptions";
	public static final String MapSharedLibForModTask = "MapSharedLibForMod";
	public static final String SharedLibRelationshipTask = "SharedLibRelationship";
	public static final String PropertyBasedConfigTask = "PropertyBasedConfig";
	public static final String BindJndiForEJBBusinessTask = "BindJndiForEJBBusiness";
	public static final String MetadataCompleteForModulesTask = "MetadataCompleteForModules";
    public static final String WSDeployOptionsTask = "WSDeployOptions";
    public static final String MapJaspiProvider = "MapJaspiProvider";
    public static final String MapEnvEntryForClientModTask = "MapEnvEntryForClientMod";
    public static final String MapEnvEntryForAppTask = "MapEnvEntryForApp";
	
}
