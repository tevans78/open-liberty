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

package com.ibm.websphere.simplicity.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.ObjectName;

import com.ibm.websphere.simplicity.AbstractSession;
import com.ibm.websphere.simplicity.ConfigIdentifier;
import com.ibm.websphere.simplicity.OperationsProviderType;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.Topology;
import com.ibm.websphere.simplicity.WebSphereVersion;
import com.ibm.websphere.simplicity.Workspace;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;
import com.ibm.websphere.simplicity.provider.websphere.ConfigurationOperationsProvider;

public class ConfigObject implements Configurable {
	
	private static Class<?> c = ConfigObject.class;
	private static boolean cache = false;
	private static final String CHANGE_KEY_CHILDREN = "children";
	private static final String CHANGE_KEY_VALUE = "value";
	
	/**
	 * In certain controlled environments, administrators are assured that only
	 * one user is modifying configuration values at a time.  In those instances,
	 * this value can be set to true to improve performance.
	 * @param value True to cache data values locally.
	 */
	public static void setLocalCacheEnabled(boolean value) {
		cache = value;
	}

	/**
	 * Different versions of WebSphere support different configuration object types.
	 * Use this API to determine which ones are supported by the specified scope.  Note
	 * that in a mixed cell environment different scopes will likely support more or
	 * fewer configuration object types.
	 * @param scope The scope to query for supported object (data) types.
	 * @return A list of supported object types.
	 * @throws Exception
	 */
	public static String[] getSupportedConfigObjectTypes(Scope scope) throws Exception {
		return Topology.getOperationsProvider().getConfigurationOperationsProvider().getSupportedConfigObjectTypes(scope);
	}
	
	/**
	 * Obtains a single ConfigObject instance, regardless of the multiplicity of the
	 * requested data type.
	 * @param reference The scope from which to base the query for config objects.
	 * @param configObjectType The data type of object to retrieve.
	 * @return The first (or only) instance of a ConfigObject matching the provided criteria.
	 * @throws Exception
	 */
	public static ConfigObject getConfigObject(Scope scope, String configObjectType) throws Exception {
    	Log.entering(c, "getConfigObject", new Object[] { scope, configObjectType });
		AbstractSession s = scope.getWorkspace().getSession();
		ConfigurationOperationsProvider configops = Topology.getOperationsProvider().getConfigurationOperationsProvider();
		ConfigIdentifier[] list = configops.queryConfigObjects(scope, s, scope.getConfigId(), configObjectType);
		if (list.length == 0)
			return null;
		
		ConfigObject nco = new ConfigObject(scope, configObjectType, list[0], null);
        Log.exiting(c, "getConfigObject", nco);
		return nco;
	}
    
	/**
	 * Obtains a single ConfigObject instance, regardless of the multiplicity of the
	 * requested data type, restricted to the provided config object parent.
	 * @param scope The scope from which to base the query for config objects.
	 * @param parent The container -- within the scope -- within which to query for the objects.
	 * @param configObjectType The data type of object to retrieve.
	 * @return The first (or only) instance of a ConfigObject matching the provided criteria.
	 * @throws Exception
	 */
    public static ConfigObject getConfigObject(Scope scope, ConfigIdentifier parent, String configObjectType) throws Exception {
    	Log.entering(c, "getConfigObject", new Object[] { scope, parent, configObjectType });
        AbstractSession s = scope.getWorkspace().getSession();
        ConfigurationOperationsProvider configops = Topology.getOperationsProvider().getConfigurationOperationsProvider();
        ConfigIdentifier[] list = configops.queryConfigObjects(scope, s, parent, configObjectType);
		if (list.length == 0)
			return null;
		
        ConfigObject nco = new ConfigObject(scope, configObjectType, list[0], null);
        Log.exiting(c, "getConfigObject", nco);
        return nco;
    }
	
    /**
	 * Many configuration data types have a multiplicity greater than one.  Use this API to
	 * retrieve all instances of such data types within the provided scope.
	 * @param reference The scope from which to base the query for config objects.
	 * @param configObjectType The data type of object to retrieve.
	 * @return A list of ConfigObject instances matching the provided criteria.
	 * @throws Exception
     */
	public static List<ConfigObject> getConfigObjectList(Scope scope, String configObjectType) throws Exception {
		Log.entering(c, "getConfigObjectList", new Object[] { scope, configObjectType });
		AbstractSession s = scope.getWorkspace().getSession();
		ConfigurationOperationsProvider configops = Topology.getOperationsProvider().getConfigurationOperationsProvider();
		ConfigIdentifier[] list = configops.queryConfigObjects(scope, s, scope.getConfigId(), configObjectType);
		
		List<ConfigObject> retval = new ArrayList<ConfigObject>();
		for (ConfigIdentifier id : list) {
			ConfigObject nco = new ConfigObject(scope, configObjectType, id, null);
			retval.add(nco);
		}
		Log.exiting(c, "getConfigObjectList", retval);
		return retval;
	}

	/**
	 * Many configuration data types have a multiplicity greater than one.  Use this API to
	 * retrieve all instances of such data types, constricting the query to those under the 
	 * provided parent object.
	 * @param reference The scope from which to base the query for config objects.
	 * @param parent The container -- within the scope -- within which to query for the objects.
	 * @param configObjectType The data type of object to retrieve.
	 * @return A list of ConfigObject instances matching the provided criteria.
	 * @throws Exception
	 */
    public static List<ConfigObject> getConfigObjectList(Scope reference, ConfigIdentifier parent, String configObjectType) throws Exception {
    	Log.entering(c, "getConfigObjectList", new Object[] { reference, parent, configObjectType });
        AbstractSession s = reference.getWorkspace().getSession();
        ConfigurationOperationsProvider configops = Topology.getOperationsProvider().getConfigurationOperationsProvider();
        ConfigIdentifier[] list = configops.queryConfigObjects(reference, s, parent, configObjectType);
        
        List<ConfigObject> retval = new ArrayList<ConfigObject>();
        for (ConfigIdentifier id : list) {
            ConfigObject nco = new ConfigObject(reference, configObjectType, id, null);
            retval.add(nco);
        }
        Log.exiting(c, "getConfigObjectList", retval);
        return retval;
    }
    
    /**
     * Creates a local instance of a ConfigObject representing the specified config data type.
     * It's critical to note that the object is not persisted to the temporary session workspace
     * until <b>after</b> all required attribute values have been set.  Prior to this point
     * creating the object would simply generate errors.
     * <p>
     * As soon as the last required value is set, the object is persisted to the temporary
     * workspace, and is committed to the main repository after the cell's workspace is saved.
     * @param scope
     * @param configObjectType
     * @param parent
     * @return
     * @throws Exception
     */
	public static ConfigObject createConfigObject(Scope scope, String configObjectType, ConfigObject parent) throws Exception {
		Log.entering(c, "createConfigObject", new Object[] { scope, configObjectType, parent });
		ConfigObject nco = new ConfigObject(scope, configObjectType, parent);
		parent.addNewChild(nco);
        List<ConfigObject> atts = nco.getAttributes();
        boolean save = true;
        for(ConfigObject att : atts) {
            if(att.getMetadata().isRequired()) {
                save = false;
                break;
            }
        }
        if(save)
            nco.save();
		Log.exiting(c, "createConfigObject", nco);
		return nco;
	}
	
    // need a way to pass in a scope for reference and still make it optional as a parameter
    protected static List<ConfigObject> getConfigObjectList(Scope scope, String configObjectType, boolean useScopeAsParent) throws Exception {
    	Log.entering(c, "getConfigObjectList", new Object[] { scope, configObjectType, useScopeAsParent });
        AbstractSession s = scope.getWorkspace().getSession();
        ConfigurationOperationsProvider configops = Topology.getOperationsProvider().getConfigurationOperationsProvider();
        ConfigIdentifier[] list = null;
        if(useScopeAsParent) {
            list = configops.queryConfigObjects(scope, s, scope.getConfigId(), configObjectType);
        } else {
            list = configops.queryConfigObjects(scope, s, null, configObjectType);
        }
        
        List<ConfigObject> retval = new ArrayList<ConfigObject>();
        for (ConfigIdentifier id : list) {
            ConfigObject nco = new ConfigObject(scope, configObjectType, id, null);
            retval.add(nco);
        }
        Log.exiting(c, "getConfigObjectList", retval);
        return retval;
    }

	// "Security", "AuthMechanism", etc
	private ConfigObjectConfigType internalType;
	private ConfigObjectMetadata metadata;
	private ArrayList<ConfigObject> children;
	private Scope scope;
	private ConfigObject parent;
	private Object value;
	private ConfigIdentifier objectName;
	private boolean valueChanged = false;
	
	/**
	 * Represents a new object type.
	 * @param scope
	 * @param configObjectType
     * @param parent
	 */
	protected ConfigObject(Scope scope, String configObjectType, ConfigObject parent) throws Exception {
		Log.entering(c, "<init>", new Object[] { scope, configObjectType, parent });
		this.internalType = ConfigObjectConfigType.Object;
		this.scope = scope;
		this.parent = parent;

		// Retrieve metadata for objects
		this.metadata = new ConfigObjectMetadata(scope, configObjectType);
		
		// Register this object immediately; if a save is propagated then it gets called.
		// If the object is not yet ready to save, though, it has to be re-registered for
		// the next call.
        scope.getWorkspace().registerConfigChange(this);
        Log.exiting(c, "<init>");
	}
	
	/**
	 * Represents an existing object type
	 * @param scope
	 * @param configObjectType
     * @param objectName
     * @param parent
	 */
	protected ConfigObject(Scope scope, String configObjectType, ConfigIdentifier objectName, ConfigObject parent) throws Exception {
		Log.entering(c, "<init>", new Object[] { scope, configObjectType, objectName, parent });
		this.internalType = ConfigObjectConfigType.Object;
		this.scope = scope;
		this.parent = parent;
		this.objectName = objectName;

		this.metadata = new ConfigObjectMetadata(scope, objectName.getDataType());
        Log.exiting(c, "<init>");
	}
	
    /**
     * Represents an existing object type, reusing an existing metadata object
     * @param scope
     * @param configObjectType
     * @param objectName
     * @param parent
     */
    protected ConfigObject(Scope scope, ConfigObjectMetadata meta, ConfigIdentifier objectName, ConfigObject parent) throws Exception {
		Log.entering(c, "<init>", new Object[] { scope, meta, objectName, parent });
        this.internalType = ConfigObjectConfigType.Object;
        this.scope = scope;
        this.parent = parent;
        this.objectName = objectName;

        Log.finer(c, "<init>", meta.getDataType());
        if (!meta.getDataType().equals(objectName.getDataType()))
        	// Here the current meta.getDataType() is the base (or super) type
        	// The ConfigIdentifier has the most relevant data type
        	// We also have to pass the name; the name is only known from the attribute scope,
        	// not the data type scope (which is requested by this new object)
        	this.metadata = new ConfigObjectMetadata(scope, objectName.getDataType(), meta.getDataType(), meta.getName());
        else
        	this.metadata = meta;
        /*
         * This call is required to avoid full recursion over the metadata 
         * tree within the COMetadata class itself.  By putting the call here, 
         * we ensure metadata queries only when the types themselves are 
         * actually used.  (See also ConfigObjectMetadata.get*Attributes().)
         */
        this.metadata.initComplex();
        Log.exiting(c, "<init>");
    }

	/**
	 * Represents a primitive type
	 * @param scope
	 * @param parent
	 * @param metadata
	 * @param value
	 * @throws Exception
	 */
	protected ConfigObject(Scope scope, ConfigObject parent, ConfigObjectMetadata metadata, Object value) throws Exception {
		Log.entering(c, "<init>", new Object[] { scope, parent, metadata, value });
		this.scope = scope;
		this.internalType = ConfigObjectConfigType.Attribute;
		this.metadata = metadata;
		this.value = value;
		this.parent = parent;
        Log.exiting(c, "<init>");
	}

	/**
	 * @return The scope used to query for this config object.  Note that this may not correspond exactly to the config object's narrowest scope. 
	 */
	public Scope getScope() {
		return this.scope;
	}

	/**
	 * Attributes and complex objects return different values.  Complex objects will return
	 * a fully-qualified object name string that resolves the object in the configuration
	 * repository.  Attributes, on the other hand, will return the "key" portion of a simple
	 * key/value pair for the parent complex object.
	 * @return A name for the object.  The name varies based on the type of data represented by this instance.
	 */
	public String getName() {
		return this.metadata.getName();
	}

	/**
	 * @return Attributes return the simple key portion of a key/value pair; complex objects return the data type name.
	 * @throws Exception
	 */
	public String getSortableName() throws Exception {
		if (this.getMetadata().isAttribute())
			return metadata.getName();
		else
			return metadata.getDataType();
	}

	/**
	 * Intended for internal use only.
	 * @return The {@link ConfigIdentifier} of this ConfigObject
	 */
	public ConfigIdentifier getConfigIdentifier() {
		return this.objectName;
	}

	/**
	 * @return The parent ConfigObject, if known (null if not).
	 */
	public ConfigObject getParent() {
		return this.parent;
	}
	
	/**
	 * This API only applies to attribute-type (isAttribute()==true) ConfigObject instances.
	 * @return The value of the attribute.
	 * @throws Exception
	 */
	public Object getValue() throws Exception {
		ConfigIdentifier cid = this.getParent().getConfigIdentifier();

		// cid == null when the parent is being created
		if (cache || this.valueChanged || cid == null)
			return this.value;
		else {
			Object value = null;
			ConfigurationOperationsProvider configops = Topology.getOperationsProvider().getConfigurationOperationsProvider();
			Workspace t = this.getScope().getWorkspace();
			AbstractSession session = t.getSession();
			Scope key = this.getScope();
			value = configops.getAttribute(key, session, cid, this.getName());
			this.value = value;
			return value;
		}
	}

	/**
	 * @return The value converted to a Boolean.
	 * @throws Exception
	 */
	public boolean getValueAsBoolean() throws Exception {
        Object value = getValue();
        if(value instanceof String) {
            if(value.equals("1"))
                value = "true";
            return Boolean.parseBoolean((String)value);
        }
		return (Boolean)getValue();
	}
	
	/**
	 * @return The value converted to a String.
	 * @throws Exception
	 */
	public String getValueAsString() throws Exception {
		return (String)getValue();
	}
	
	/**
	 * @return The value converted to an int.
	 * @throws Exception
	 */
	public int getValueAsInt() throws Exception {
        Object value = getValue();
        if(value instanceof String) {
            return Integer.parseInt((String)value);
        }
		return (Integer)getValue();
	}

	/**
	 * @return The attributes of the current instance.  Attribute instances always return a zero-length array.
	 * @throws Exception
	 */
	public ArrayList<ConfigObject> getAttributes() throws Exception {
		ArrayList<ConfigObject> ret = new ArrayList<ConfigObject>();
		for (ConfigObject nco : this.getChildren())
			if (!isObject(nco))
				ret.add(nco);
		return ret;
	}
	
	/**
	 * @param name The name of the attribute ConfigObject to retrieve.
	 * @return A ConfigObject instance representing the attribute.
	 * @throws Exception
	 */
	public ConfigObject getAttributeByName(String name) throws Exception {
		ArrayList<ConfigObject> list = getAttributes();
		for (ConfigObject co : list)
			if (co.getName().equalsIgnoreCase(name))
				return co;
		return null;
	}
	
	/**
	 * @return The complex objects nested under the current instance.  Attributes always return a zero-length array.
	 * @throws Exception
	 */
	public ArrayList<ConfigObject> getChildObjects() throws Exception {
		ArrayList<ConfigObject> ret = new ArrayList<ConfigObject>();
		for (ConfigObject nco : this.getChildren()) {
			if (isObject(nco))
				ret.add(nco);
        }
		return ret;
	}

	/**
	 * @param dataType The configuration data type of the child objects to retrieve.
	 * @return A list of complex objects under the current instance of the provided configuration data type.
	 * @throws Exception
	 */
	public ArrayList<ConfigObject> getChildObjectsByDataType(String dataType) throws Exception {
		ArrayList<ConfigObject> ret = new ArrayList<ConfigObject>();
		for (ConfigObject nco : getChildObjects())
			if (dataType.equalsIgnoreCase(nco.getMetadata().getDataType()) || 
					dataType.equalsIgnoreCase(nco.getMetadata().getBaseDataType()))
				ret.add(nco);
		return ret;
	}
	
	/**
	 * Some complex objects have children whose multiplicity is greater than one.  While many
	 * calls to this API may return a single element list, not all will.
	 * @param name The name of the child object whose elements should be retrieved.
	 * @return A list of all child objects whose name matches the supplied name.
	 * @throws Exception
	 */
	public List<ConfigObject> getChildObjectListByName(String name) throws Exception {
		ArrayList<ConfigObject> list = new ArrayList<ConfigObject>();
		for (ConfigObject co : getChildObjects()) {
			if (co.getName() != null && co.getName().equalsIgnoreCase(name))
				list.add(co);
        }
		return list;
	}

	/**
	 * A ConfigObject's metadata will vary depending on the type of object this
	 * instance represents.  For example, simple attributes (called Attributes)
	 * may have default values, enum values, act as a pointer, or other 
	 * characteristics.  Complex attributes (called Child Objects) can have their
	 * own attributes (simple, complex, or both), or may be a list of other
	 * complex attributes.
	 * @return The metadata description for this instance.
	 */
	public ConfigObjectMetadata getMetadata() {
		return this.metadata;
	}
	
	/**
	 * @return True if the data represented by this ConfigObject is in the WebSphere configuration repository.
	 */
	public boolean exists() {
		return (this.internalType.equals(ConfigObjectConfigType.Attribute) || this.objectName != null);
	}

	/**
	 * For internal use only.
	 */
    public void commit(HashMap<String, Object> values) throws Exception {
    	// No code here; new workspace management negates the need
    }

	/**
	 * For internal use only.
	 */
    @SuppressWarnings("unchecked")
    public void rollback(HashMap<String, Object> values) {
        for(Map.Entry<String, Object> entry : values.entrySet()) {
        	String key = entry.getKey();
        	Object value = entry.getValue();
        	
            if(key.equals(CHANGE_KEY_CHILDREN)) {
                this.children = (ArrayList<ConfigObject>)value;
            } else if(key.equals(CHANGE_KEY_VALUE)) {
                this.value = value;
            }
        }
    }

    /**
     * Deletes the config object from the repository.  Note that this is a temporary
     * deletion until the cell's workspace is saved, at which point the object is
     * deleted from the main WebSphere repository.<br/>
     * <br/>
     * Note!! this method does not work on attributes. Use the {{@link #unsetAttribute(String)} method
     * on the parent ConfigObject to remove attributes.
     * @throws Exception
     */
    public void delete() throws Exception {
    	Log.entering(c, "delete");
    	if (!this.exists()) {
    		Log.exiting(c, "delete", "Does not yet exist, can't delete");
    		return;
    	}
        if(this.getMetadata().isAttribute()) {
            throw new Exception("This method does not apply to attributes.");
        }
    	if(this.parent != null) {
    		this.scope.getWorkspace().registerConfigChange(this.parent, CHANGE_KEY_CHILDREN, this.parent.getChildren());
    		this.parent.children.remove(this);
    	}
		ConfigurationOperationsProvider configops = Topology.getOperationsProvider().getConfigurationOperationsProvider();
		AbstractSession session = this.scope.getCell().getActiveSession();
		configops.deleteConfigData(getScope(), session, this.getConfigIdentifier());
		Log.exiting(c, "delete");
    }
    
    private void create() throws Exception {
    	Log.entering(c, "create");
    	if (!this.canCreate()) {
    		Log.exiting(c, "create", "Can't yet create");
    		return;
    	}
    	
    	if(this.parent != null) {
    		this.scope.getWorkspace().registerConfigChange(this.parent, CHANGE_KEY_CHILDREN, this.parent.getChildren());
    	}
		ConfigurationOperationsProvider configops = Topology.getOperationsProvider().getConfigurationOperationsProvider();
		AbstractSession session = this.scope.getCell().getActiveSession();
		ConfigIdentifier cid = configops.createConfigData(getScope(), session, this);
		this.objectName = cid;
		Log.exiting(c, "create", this.objectName);
    }
    
	/**
	 * Performs a non-recursive save of this ConfigObject and any of its attributes.
	 * @throws Exception
	 */
	private void save() throws Exception {
		save(false);
	}
	
	/**
	 * Performs an optionally recursive save of this ConfigObject and any of its attributes.
	 * @param recursive True to save this ConfigObject (including attributes) 
	 * 					and all child ConfigObjects.
	 * @throws Exception
	 */
	private void save(boolean recursive) throws Exception {
		Log.entering(c, "save", new Object[] { this.objectName != null ? this.objectName.toString() : null, recursive });
		if (this.getMetadata().isAttribute() && !this.valueChanged) {
			Log.exiting(c, "save (value unchanged)");
			return;
		}

		ConfigurationOperationsProvider configops = Topology.getOperationsProvider().getConfigurationOperationsProvider();
		if (!isObject(this)) {
			if (this.parent.exists()) {
				if (!this.getMetadata().isReference() || this.getValue() != null) {
					Log.debug(c, "Saving attribute value");
					Scope key = this.getScope();
					AbstractSession session = this.scope.getCell().getActiveSession();
					ConfigIdentifier cid = this.parent.getConfigIdentifier();
					Attribute attribute = new Attribute(this.getName(), this.getValue());
					configops.modifyAttribute(key, session, cid, attribute);
					this.valueChanged = false;
				} else {
					Log.debug(c, "Not saving attribute value -- null reference, which is not permitted");
				}
			} else if (this.parent.canCreate()) {
				this.parent.create();
			}
		} else {
			Log.debug(c, "Saving non-attribute value");
			if (!this.exists() && this.canCreate()) {
				this.create();
			}
			for (ConfigObject co : this.getAttributes())
				co.save();
			if (recursive) {
				for (ConfigObject co : this.getChildObjects())
					co.save(true);
			}
		}
		
		if (this.internalType.equals(ConfigObjectConfigType.Attribute) && !this.parent.exists()) {
			// Register this object immediately; if a save is propagated then it gets called.
			// If the object is not yet ready to save, though, it has to be re-registered for
			// the next call.
	        scope.getWorkspace().registerConfigChange(this.parent);
		}
		
		Log.exiting(c, "commit", "Save succeeded");
	}

	/**
	 * @return True if the ConfigObject's value field can be written.
	 */
	public boolean canWrite() {
		return this.internalType.equals(ConfigObjectConfigType.Attribute);
	}

	/**
	 * Only simple attributes (called Attributes in this class) have
	 * their own values.  Complex attributes (called Child Objects)
	 * ignore this call.
	 * @param value The new value for a simple attribute.
	 * @throws Exception
	 */
	public void setValue(Object value) throws Exception {
		Log.entering(c, "setValue", new Object[] { value, canWrite() });
		if (canWrite()) {
            if(!valueChanged) {
            	Log.debug(c, "Registering new value with workspace");
                scope.getWorkspace().registerConfigChange(this, CHANGE_KEY_VALUE, this.value);
            }
			if (this.metadata.isEnum() && value instanceof Integer)
				this.value = this.metadata.getEnumValues()[(Integer)value];
			else if (value instanceof ConfigObject) {
				if (!this.getMetadata().isReference())
					throw new Exception("Only reference types can point to other config objects");
				
				/*
				 * Unfortunately we have to do a check here.  Wsadmin requires the "abbreviated"
				 * config ID when creating pointers to other objects; JMX requires an ObjectName
				 * instance (a string will not do).  This should be changed to put the burden on
				 * the provider.  Especially since we also have to check for pre-7.0 target, and
				 * 6.1 takes a JMX-style identifier.
				 */
				ConfigObject covalue = (ConfigObject)value;
				OperationsProviderType optype = OperationsProviderFactory.getProvider().getOperationsType();
				WebSphereVersion version = this.scope.getCell().getManager().getNode().getBaseProductVersion();
				boolean isPre70 = (version.compareToPartial(new WebSphereVersion("7.0")) < 0);

				Object newvalue = null;
				if (isPre70 || optype.equals(OperationsProviderType.JMX))
					newvalue = covalue.getConfigIdentifier().getObjectName();
				else
					newvalue = covalue.getConfigIdentifier().getConfigId();
				this.value = newvalue;
			} else if (this.metadata.getDataType().equals("int") && value instanceof String) {
				this.value = Integer.parseInt((String)value);
			} else if (this.metadata.getDataType().equals("long") && value instanceof String) {
				this.value = Long.parseLong((String)value);
			} else if (this.metadata.getDataType().equals("boolean") && value instanceof String) {
				this.value = Boolean.valueOf((String)value);
			} else {
				this.value = value;
			}
			this.valueChanged = true;
			
			// Commit the change to the temporary workspace
			save();
		}
		Log.exiting(c, "setValue");
	}
	
	protected void addChild(ConfigObject child) throws Exception {
		if (!this.getChildren().contains(child))
			this.children.add(child);
	}
	
	/**
	 * Used for user-invoked child creation.  The addChild method is used internally
	 * to create parent/child relationships to existing data.
	 * @param child
	 * @throws Exception
	 */
	protected void addNewChild(ConfigObject child) throws Exception {
    	Log.debug(c, "Registering existing child list with workspace");
        scope.getWorkspace().registerConfigChange(this, CHANGE_KEY_CHILDREN, new ArrayList<ConfigObject>(this.getChildren()));
		if (!this.getChildren().contains(child))
			this.children.add(child);
	}
	
	protected ArrayList<ConfigObject> getChildren() throws Exception {
		if (this.children == null)
			loadChildren();
		return this.children;
	}
	
	@SuppressWarnings("unchecked")
    private void loadChildren() throws Exception {
        final String method = "loadChildren";
		Log.entering(c, method);

		this.children = new ArrayList<ConfigObject>();
		if (this.internalType.equals(ConfigObjectConfigType.Attribute)) {
			Log.exiting(c, "loadChildren", "Is primitive");
			return;
		}

		ArrayList<ConfigObjectMetadata> allAttributes = this.metadata.getAllAttributes();
		String[] list = new String[allAttributes.size()];
		int i = 0;
		for (ConfigObjectMetadata coa : allAttributes)
			list[i++] = coa.getName();
		
		Log.finest(c, method, "Attributes", (Object[])list);
		
		/* If this is a ConfigObject in the middle of the "creating" phase,
		 * there is no configIdentifier instance, so we just work off the 
		 * metadata and return.
		 */
		if (this.getConfigIdentifier() == null) {
			for (ConfigObjectMetadata coa : allAttributes) {
				if (!isObject(coa)) {
					ConfigObject child = new ConfigObject(this.scope, this, coa, null);
					this.addChild(child);
				}
			}
			Log.exiting(c, method, "New config object, no attributes to retrieve");
			return;
		}
		
		AttributeList attributes = Topology.getOperationsProvider().getConfigurationOperationsProvider().getAttributes(scope, this.scope.getActiveSession(), this, list, false);
		for (i=0; i < allAttributes.size(); i++) {
			ConfigObjectMetadata meta = allAttributes.get(i);
			Log.finer(c, method, "Processing attribute: "+meta.getName());
			Attribute attribute = null;
			for (int o=0; o < attributes.size(); o++) {
				attribute = (Attribute)attributes.get(o);
				if (attribute.getName().equalsIgnoreCase(meta.getName()))
					break;
			}
			ConfigObject child;
			Object value = null;

			if (attribute != null)
				value = attribute.getValue();
			if (value != null && value.equals("*****"))
				value = null;
			
			if (meta.isObject() && !meta.isReference()) {
				Log.finer(c, method, "isObject() && !isReference()");
				ArrayList<Object> valuelist = null;
				if (value instanceof ConfigIdentifier || value instanceof ObjectName) {
					valuelist = new ArrayList<Object>();
					valuelist.add(value);
				} else if (value instanceof ArrayList) {
					valuelist = (ArrayList<Object>)value;
				} else if (meta.isCollection()) {
					valuelist = new ArrayList<Object>();
				}

				if (valuelist != null) {
					Log.finer(c, method, "valuelist != null");
					for (Object o : valuelist) {
						ConfigIdentifier cid;
						if (o instanceof ConfigIdentifier)
							cid = (ConfigIdentifier)o;
						else
							cid = new ConfigIdentifier((ObjectName)o);
						cid.setScope(this.scope);
						child = new ConfigObject(this.scope, meta, cid, this);
						this.addChild(child);
					}
				}
			} else {
				child = new ConfigObject(this.scope, this, meta, attribute.getValue());
				this.addChild(child);
			}
		}
		
        // Sort elements -- brute force for now
		// Helps keep output from wsadmin and jmx in order, so config output is identical
        boolean sorted = false;
        while (!sorted) {
        	sorted = true;
        	for (int o=0; o < children.size()-1; o++) {
        		ConfigObject prev = children.get(o);
        		ConfigObject next = children.get(o+1);
        		if (prev.getSortableName().compareTo(next.getSortableName()) > 0) {
        			children.set(o, next);
        			children.set(o+1, prev);
        			sorted = false;
        		}
        	}
        }
        
		Log.exiting(c, method);
	}
	
	/*
	 * When a config object is being created, it should only be saved when all of the
	 * required attributes are ready.  For existing config objects, all is fair.
	 */
	private boolean canCreate() throws Exception {
		Log.entering(c, "canCreate");
		ArrayList<ConfigObjectMetadata> allAttributes = this.metadata.getAllAttributes();
		for (ConfigObjectMetadata coa : allAttributes) {
			Log.debug(c, "Checking attribute: "+coa.getName());
			if (!coa.isRequired()) {
				Log.debug(c, "Not required, skipping");
				continue;
			}
			ConfigObject current = this.getAttributeByName(coa.getName());
			Log.debug(c, "Current value of attribute: "+current.getValue());
			if (current.getValue() == null) {
				Log.exiting(c, "canCreate", false);
				return false;
			}
		}
		Log.exiting(c, "canCreate", true);
		return true;
	}
	
	/**
	 * Here "Object" refers to a complex attribute.  An attribute is complex only if:
	 * 
	 * 1. It is not explicitly an attribute.
	 * 2. It is explicity an object, and
	 * 		a. It is not a reference to another object, or
	 * 		b. It is a collection of objects
	 * 
	 * For example, the "authMechanisms" attribute of the Security object is explicitly
	 * an object, but is also both a reference to other objects (LTPA, SPNEGO, etc) and
	 * a collection of references to those objects.  (A single-reference item like
	 * "activeAuthMechanism" is not a collection, therefore it's a single value and thus
	 * a simple attribute.)
	 * 
	 * @param co The ConfigObject to evaluate as either an object or not.
	 * @return
	 */
	private boolean isObject(ConfigObject co) throws Exception {
		ConfigObjectMetadata com = co.getMetadata();
		return isObject(com);
	}
	
	private boolean isObject(ConfigObjectMetadata com) throws Exception {
		return !com.isAttribute() && (com.isObject() && (!com.isReference() || com.isCollection()));
	}
	
	/**
     * Remove the specified attribute name from this configObject. To re-create
     * the attribute or create a new attribute, use the {{@link #createConfigObject(Scope, String, ConfigObject)}
     * method.
     * 
     * @param name
     *            The Attribute name to be removed
     * @throws Exception
     */
	public void unsetAttribute(String name) throws Exception{
    	List<String> list = new ArrayList<String>();
    	list.add(name);
    	unsetAttribute(list);
    }
	
	/**
	 * Remove the specified list of attribute names from this configObject. To re-create
     * the attributes or create a new attribute, use the {{@link #createConfigObject(Scope, String, ConfigObject)}
     * method.
	 * 
     * @param name The list of Attribute names to be removed
     * @throws Exception
	 */
    public void unsetAttribute(List<String> names) throws Exception{
        Map<String, ConfigObject> attributes = new HashMap<String, ConfigObject>();
        // make sure all the attributes listed are valid
        for(String name : names) {
            for(ConfigObject child : this.getChildren()) {
                if(child.getMetadata().isAttribute() && child.getName().equals(name))
                    attributes.put(name, child);
            }
        }
        for(String name : names) {
            if(attributes.get(name) == null)
                throw new Exception("The attribute " + name + " does not exist for this ConfigObject.");
        }

        this.scope.getWorkspace().registerConfigChange(this, CHANGE_KEY_CHILDREN, new ArrayList<ConfigObject>(this.getChildren()));
        
    	ConfigurationOperationsProvider cop = null;
    	
    	Scope key = this.scope;
    	AbstractSession sessionKey = this.scope.getActiveSession();
    	ConfigIdentifier configObject = this.objectName;
    	
    	AttributeList attributeList = new AttributeList();
    	Attribute attribute = null;
    	for(int index=0; index < names.size(); index++ ){
    		attribute = new Attribute(names.get(index), null);
        	attributeList.add(attribute);
    	}
    	
    	cop = OperationsProviderFactory.getProvider().getConfigurationOperationsProvider();
    	cop.unsetAttributes(key, sessionKey, configObject, attributeList);
        
    	for(String name : attributes.keySet()) {
    	    this.children.remove(attributes.get(name));
        }
    }
	
}
