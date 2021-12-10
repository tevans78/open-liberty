/*******************************************************************************
 * Copyright (c) 2011, 2022 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.websphere.simplicity.provider.websphere;

import java.util.HashMap;

import javax.management.Attribute;
import javax.management.AttributeList;

import com.ibm.websphere.simplicity.AbstractSession;
import com.ibm.websphere.simplicity.ConfigIdentifier;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.config.ConfigObject;
import com.ibm.websphere.simplicity.provider.CategorizedOperationsBase;

public abstract class ConfigurationOperationsProvider extends CategorizedOperationsBase {

    /**
     * Stores metadata cache objects by scope. By tracking caches by scope,
     * mixed-cell environments are automatically accommodated.
     */
    protected HashMap<Scope, MetadataCache> metadataCache = new HashMap<Scope, MetadataCache>();

    /**
     * Constructor. For provider use only.
     *
     * @param parent
     */
    public ConfigurationOperationsProvider(WebSphereOperationsProvider parent) {
        super(parent);
    }

    /**
     * Retrieves a list of configuration identifiers of the specified type
     * within the specified scope. Configuration objects are not data in a
     * strict sense, but they do contain data. A config identifier is a
     * unique URI to a specific instance of a configuration object in the
     * WebSphere configuration repository.
     * <p>
     * The configuration scope is different from the WebSphere scope. The
     * WebSphere scope refers to the repository that will be accessed when
     * resolving the configuration objects. The configuration scope simply
     * refers to a parent configuration object, if one exists. Generally,
     * the configuration scope is considered optional unless unrelated results
     * are generated.
     *
     * @param key        The WebSphere scope corresponding to the repository to be queried.
     * @param sessionKey A valid session obtained from a Transaction object.
     * @param scope      The optional configuration scope that contains the objects to be retrieved.
     * @param type       The type of object to be retrieved.
     * @return A list of ConfigIdentifier instances pointing to resulting configuration objects.
     * @throws Exception
     */
    public abstract ConfigIdentifier[] queryConfigObjects(Scope key, AbstractSession sessionKey, ConfigIdentifier scope, String type) throws Exception;

    /**
     * Provides the user with a list of configuration object types supported
     * by the targetted version of WebSphere. Configuration objects of all
     * types are not necessarily in the configuration repository. The strings
     * returned by this method can be passed in to methods expecting object
     * type parameters.
     *
     * @param key The WebSphere scope corresponding to the repository to be queried.
     * @return A list of configuration object types supported by the WebSphere target.
     * @throws Exception
     */
    public abstract String[] getSupportedConfigObjectTypes(Scope key) throws Exception;

    /**
     * Retrieves the value of a configuration object's attribute from the
     * configuration repository. The configObject to be passed in can be
     * obtained by calling the {@link #queryConfigObjects(Scope, AbstractSession, ConfigIdentifier, String)} method.
     * <p>
     * The value returned by this method is an instance of either a Java
     * primitive (int, long, boolean) or complex (String, array) object.
     * The class may need to be checked prior to inspecting the value.
     *
     * @param key           The WebSphere scope corresponding to the repository to be queried.
     * @param sessionKey    A valid session obtained from a Transaction object.
     * @param configObject  A pointer to the configuration object whose attribute value will be retrieved.
     * @param attributeName The name of the attribute to be retrieved.
     * @return The value of the attribute.
     * @throws Exception
     */
    public abstract Object getAttribute(Scope key, AbstractSession sessionKey, ConfigIdentifier configObject, String attributeName) throws Exception;

    /**
     * Retrieves the value of all of the requested attributes, with an
     * option to recursively retrieve all child attributes. The most
     * common use of this method is to retrieve multiple attributes of
     * a given configuration object in a single call, given the overhead
     * required to make multiple such calls.
     * <p>
     * What is not immediately apparent from this method is that WebSphere
     * treats child configuration objects as "attributes," breaking down
     * into simple and complex attributes (similar to simple and complex
     * XML datatypes). The value for simple attributes will be a simple
     * Java type, while complex values will be lists of further attributes.
     * <p>
     * WebSphere has documentation on the AttributeList permutations
     * already. Unless this method must be used by the caller, it is
     * preferred that users refer to the {@link ConfigObject} API.
     *
     * @param key          The WebSphere scope corresponding to the repository to be queried.
     * @param sessionKey   A valid session obtained from a Transaction object.
     * @param configObject A pointer to the configuration object whose attribute values will be retrieved.
     * @param attributes   A list of attribute names to be retrieved.
     * @param recursive    True if WebSphere should inspect child attributes for the specified attribute names.
     * @return An AttributeList containing the values of the requested attributes.
     * @throws Exception
     */
    public abstract AttributeList getAttributes(Scope key, AbstractSession sessionKey, ConfigObject configObject, String[] attributes, boolean recursive) throws Exception;

    /**
     * Retrieves the value of all of the requested attributes, with an
     * option to recursively retrieve all child attributes. The most
     * common use of this method is to retrieve multiple attributes of
     * a given configuration object in a single call, given the overhead
     * required to make multiple such calls.
     * <p>
     * What is not immediately apparent from this method is that WebSphere
     * treats child configuration objects as "attributes," breaking down
     * into simple and complex attributes (similar to simple and complex
     * XML datatypes). The value for simple attributes will be a simple
     * Java type, while complex values will be lists of further attributes.
     * <p>
     * WebSphere has documentation on the AttributeList permutations
     * already. Unless this method must be used by the caller, it is
     * preferred that users refer to the {@link ConfigObject} API.
     *
     * @param key              The WebSphere scope corresponding to the repository to be queried.
     * @param sessionKey       A valid session obtained from a Transaction object.
     * @param configIdentifier A pointer to the configuration identifier whose attribute values will be retrieved.
     * @param attributes       A list of attribute names to be retrieved.
     * @param recursive        True if WebSphere should inspect child attributes for the specified attribute names.
     * @return An AttributeList containing the values of the requested attributes.
     * @throws Exception
     */
    public abstract AttributeList getAttributes(Scope key, AbstractSession sessionKey, ConfigIdentifier configIdentifier, String[] attributes, boolean recursive) throws Exception;

    /**
     * Retrieves the metadata corresponding to the specified configuration
     * object type. The metadata is returned in an AttributeList where
     * each entry corresponds to an attribute of the object type, and the
     * value of each entry is another AttributeList describing the attribute.
     * <p>
     * WebSphere provides such information about each attribute as data type,
     * multiplicity, whether it is mandatory, valid values, and so on.
     *
     * @param key              The WebSphere scope corresponding to the repository to be queried.
     * @param configObjectType The configuration object data type of the object whose metadata will be retrieved.
     * @return Metadata for the specified configuration object type.
     * @throws Exception
     */
    public abstract AttributeList getAttributesMetaInfo(Scope key, String configObjectType) throws Exception;

    /**
     * Removes the specified configuration object from the targetted WebSphere
     * configuration repository. This command also removes all child objects,
     * and all references to both the deleted object and child objects.
     *
     * @param key              The WebSphere scope corresponding to the repository to be queried.
     * @param sessionKey       A valid session obtained from a Transaction object.
     * @param configDataObject A pointer to the object to be deleted.
     * @throws Exception
     */
    public abstract void deleteConfigData(Scope key, AbstractSession sessionKey, ConfigIdentifier configDataObject) throws Exception;

    /**
     * Creates configuration data for the provided object. Currently this
     * will only set direct attributes of the object, and will not create
     * any child objects. Pass only the object corresponding to the config
     * element to be created, not its attributes or parent.
     *
     * @param key        The WebSphere scope corresponding to the repository to be modified.
     * @param sessionKey A valid session obtained from a Transaction object.
     * @param object     The object whose data needs to be created in the repository.
     * @return A ConfigIdentifier instance that points to the newly created data.
     * @throws Exception
     */
    public abstract ConfigIdentifier createConfigData(Scope key, AbstractSession sessionKey, ConfigObject object) throws Exception;

    /**
     * Creates a session for the targetted WebSphere installation. A session
     * corresponds to a temporary workspace in which changes can be made
     * without modifying the primary repository. Any changes within that
     * workspace must be saved through the {@link #save(Scope, AbstractSession)} method, or discarded
     * through the {@link #discard(Scope, AbstractSession)} method.
     * <p>
     * Session objects require a lot of overhead, namely with respect to
     * creating the workspace. For that reason, it's considered good practice
     * to reuse the same session instead of creating new ones.
     * <p>
     * Due to particular provider implementations, this method is not guaranteed
     * to return unique values.
     *
     * @param key The WebSphere scope in which the session will be effective.
     * @return A reference to the server-side session.
     * @throws Exception
     */
    public abstract AbstractSession createSession(Scope key) throws Exception;

    /**
     * Retrieves a list of documents modified in the specified session since
     * any previous {@link #save(Scope, AbstractSession)} or {@link #discard(Scope, AbstractSession)} instructions. This does
     * not returned specific objects that have been modified, merely URIs to
     * the documents that are modified.
     *
     * @param key        The WebSphere scope corresponding to the repository to be queried.
     * @param sessionKey A valid session obtained from a Transaction object.
     * @return A list of document URIs.
     * @throws Exception
     */
    public abstract String[] getUnsavedChanges(Scope key, AbstractSession sessionKey) throws Exception;

    /**
     * Discards any changes to the repository in the specified session. The
     * changes will not be merged back into the primary repository. This is
     * analogous to rolling back a transaction.
     *
     * @param key        The WebSphere scope corresponding to the session to be discarded.
     * @param sessionKey A valid session obtained from a Transaction object.
     * @throws Exception
     */
    public abstract void discard(Scope key, AbstractSession sessionKey) throws Exception;

    /**
     * Reset the workspace and revert back to the primary repository
     *
     * @param key        The WebSphere scope corresponding to the session to be discarded.
     * @param sessionKey A valid session obtained from a Transaction object.
     * @throws Exception
     */
    public abstract void reset(Scope key, AbstractSession sessionKey) throws Exception;

    /**
     * Merges changes made during the specified session back into the primary
     * repository. By default, WebSphere will detect and reject documents
     * that were modified and merged into the primary repository while this
     * session was being used.
     *
     * @param key        The WebSphere scope corresponding to the session to be saved.
     * @param sessionKey A valid session obtained from a Transaction object.
     * @throws Exception
     */
    public abstract void save(Scope key, AbstractSession sessionKey) throws Exception;

    /**
     * Retrieves the configuration data type for the object pointed to by
     * the configuration identifier. The object type can then be used to
     * retrieve metadata, other objects of that data type, and so on.
     *
     * @param identifier A configuration object identifier.
     * @return The configuration data type for the object.
     * @throws Exception
     */
    public abstract String getObjectType(ConfigIdentifier identifier) throws Exception;

    /**
     * Modifies an attribute of the specified configuration object. The
     * attribute may be a simple or complex attribute. For simple attributes,
     * WebSphere will expect the value to correspond to an appropriate Java
     * type, such as boolean, int, long, or String. Enum values should be
     * set to their String representation, not integer.
     * <p>
     * Complex attributes should be represented in a manner similar to their
     * retrieval, with attribute names corresponding to the child object and
     * the value being another AttributeList for the child object.
     *
     * @param key          The WebSphere scope corresponding to the repository to be modified.
     * @param sessionKey   A valid session obtained from a Transaction object.
     * @param configObject A pointer to the object to be modified.
     * @param attribute    The attribute to be set.
     * @throws Exception
     */
    public abstract void modifyAttribute(Scope key, AbstractSession sessionKey, ConfigIdentifier configObject, Attribute attribute) throws Exception;

    /**
     * Modifies one or more attributes of the specified configuration object.
     * The attributes may be simple or complex. For simple attributes,
     * WebSphere will expect the value to correspond to an appropriate Java
     * type, such as boolean, int, long, or String. Enum values should be
     * set to their String representation, not integer.
     * <p>
     * Complex attributes should be represented in a manner similar to their
     * retrieval, with attribute names corresponding to the child object and
     * the value being another AttributeList for the child object.
     *
     * @param key           The WebSphere scope corresponding to the repository to be modified.
     * @param sessionKey    A valid session obtained from a Transaction object.
     * @param configObject  A pointer to the object to be modified.
     * @param attributeList The attributes to be set.
     * @throws Exception
     */
    public abstract void modifyAttributes(Scope key, AbstractSession sessionKey, ConfigIdentifier configObject, AttributeList attributeList) throws Exception;

    /**
     * Translates a WebSphere token in the form ${<i>varname</i>} into a
     * string value. The variable value (and whether it exists) depends
     * on the provided scope. One example is the LOG_ROOT variable. It
     * does not exist at the cell level; at the node level it points to
     * the generic log root folder; for servers it points directly to the
     * server's logging folder under the log root.
     * <p>
     * Variables that do not exist will resolve to an empty string, while
     * all others will return a non-empty string.
     *
     * @param key        The WebSphere scope corresponding to the repository to be queried.
     * @param variable   The name of the variable to expand.
     * @param sessionKey A valid session obtained from a Transaction Object
     * @return The value of the specified variable.
     * @throws Exception
     */
    public abstract String expandVariable(Scope key, String variable, AbstractSession sessionKey) throws Exception;

    /**
     * Stores the metadata for individual configuration object types. The
     * metadataCache object stores instances of this keyed against WebSphere
     * scopes.
     */
    protected class MetadataCache {

        private final HashMap<String, AttributeList> cache = new HashMap<String, AttributeList>();

        public MetadataCache() {
        }

        public AttributeList getMetadataForType(String configDataType) throws Exception {
            return cache.get(configDataType);
        }

        public void setMetadataForType(String configDataType, AttributeList metadata) {
            cache.put(configDataType, metadata);
        }

    }

    /**
     * @param key           The scope to use for refernces
     * @param sessionKey    Session currently in use
     * @param configObject  The object that contains the attributes
     * @param attributeList The List of Attributes to unset
     * @throws Exception
     */
    public abstract void unsetAttributes(Scope key, AbstractSession sessionKey, ConfigIdentifier configObject, AttributeList attributeList) throws Exception;

    /**
     * Uninstall a Java 2 Connector (J2C) resource adapter.
     *
     * @param key        The scope to use for reference
     * @param sessionKey Session currently in use
     * @param target     The target config object to run the command against
     * @param force      true to force the uninstallation of the resource adapter without checking
     *                       whether the resource adapter is being used by an application
     * @return An {@link OperationResults} with the result of the command
     * @throws Exception
     */
    public abstract OperationResults<Object> uninstallResourceAdaptor(Scope key, AbstractSession sessionKey, ConfigIdentifier target, Boolean force) throws Exception;
}
