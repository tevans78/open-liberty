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

import javax.management.Attribute;
import javax.management.AttributeList;

import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.Topology;
import com.ibm.websphere.simplicity.log.Log;

public class ConfigObjectMetadata {
	
	private static Class c = ConfigObjectMetadata.class;

	private ArrayList<ConfigObjectMetadata> list = new ArrayList<ConfigObjectMetadata>();	// list of children, both simple & complex
	private ConfigObjectConfigType internalType;
	private Scope scope;
	private String dataType;
	private String baseDataType;
	private String name;
	private String defaultValue;
	private boolean isCollection;
	private boolean isObject;
	private boolean isRequired;
	private boolean isReference;
	private String[] enumValues;
	private String[] subtypes;
	private String originalData;	// just store as string
	private boolean initialized = false;
	
	protected ConfigObjectMetadata(Scope scope, String dataType) throws Exception {
		this(scope, dataType, dataType);
	}
	
	protected ConfigObjectMetadata(Scope scope, String dataType, String baseDataType) throws Exception {
		this(scope, dataType, baseDataType, null);
	}
	
	protected ConfigObjectMetadata(Scope scope, String dataType, String baseDataType, String name) throws Exception {
		Log.entering(c, "<init>", new Object[] { scope, dataType, baseDataType, name });
		this.scope = scope;
		this.name = name;
		this.dataType = dataType;
		this.baseDataType = baseDataType;
		this.internalType = ConfigObjectConfigType.getValueType(dataType);
		
		if (this.internalType.equals(ConfigObjectConfigType.Object)) {
			AttributeList meta = Topology.getOperationsProvider().getConfigurationOperationsProvider().getAttributesMetaInfo(this.scope, this.dataType);
			this.init(meta);
		} else
			throw new Exception("Incorrect constructor for simple type");
		Log.exiting(c, "<init>");
	}
	
	protected ConfigObjectMetadata(Scope scope, Attribute attributes) throws Exception {
		Log.entering(c, "<init>", new Object[] { scope, attributes });
		this.scope = scope;
		this.internalType = ConfigObjectConfigType.Attribute;
		this.init(attributes);

		/*
		 * This constructor can be used to initialize complex types, only because
		 * the caller doesn't know at the time that it's complex.  In theory we'd
		 * grab the attribute list and perform the complex initialization _here_
		 * (see the complex constructor), but if we do it here then we end up
		 * initializing the entire metadata tree all at once.  Not good for perf.
		 * 
		 * So instead what we do is leave this constructor as-is, and allow others
		 * (ConfigObject and this class) to call initComplex only when necessary.
		 * All part of our lazy-initialization campaign.
		 */
		Log.exiting(c, "<init>");
	}
	
	/**
	 * Currently returns null.  Retained for future purposes.
	 * @return null
	 */
	public String getBaseDataType() {
		return this.baseDataType;
	}
	
	/**
	 * @return The WebSphere data type or simple value type, depending on the type of object represented by this instance.
	 * @throws Exception
	 */
	public String getDataType() throws Exception {
		return this.dataType;
	}

	/**
	 * @return TODO 
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return The default value of a simple attribute if one is not explicitly defined.  Null for complex attributes.
	 */
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * @return True if the current object type represents a list of fixed-type attributes.
	 */
	public boolean isCollection() {
		return isCollection;
	}

	/**
	 * @return True if the current object type is complex.
	 */
	public boolean isObject() {
		return isObject || this.internalType.equals(ConfigObjectConfigType.Object);
	}

	/**
	 * @return True if this instance represents a simple value.
	 */
	public boolean isAttribute() {
		return this.internalType.equals(ConfigObjectConfigType.Attribute);
	}
	
	/**
	 * @return True if the current attribute must be populated.
	 */
	public boolean isRequired() {
		return isRequired;
	}

	/**
	 * @return True if the current object type is a pointer to another object type.
	 */
	public boolean isReference() {
		return isReference;
	}

	/**
	 * @return True if the object type has a fixed repertoire of values.
	 */
	public boolean isEnum() {
		return (this.enumValues != null);
	}
	
	/**
	 * @return A list of valid values for the current object type.  May be null.
	 */
	public String[] getEnumValues() {
		return this.enumValues;
	}
	
	/**
	 * @return True if the current object has reference or collection type restrictions.
	 */
	public boolean hasSubtypes() {
		return (this.subtypes != null);
	}
	
	/**
	 * Two types of config objects accept subtypes: reference and collection.
	 * For a reference object, the list of types are those to which the object may point.
	 * For example, the AdminService.connector reference attribute can point to such types
	 * as HTTPConnector, JMSConnector, RMIConnector, SOAPConnector, and so on.
	 * Collection objects also have a subtype list, and those are the types allowed as 
	 * complex attributes to the current object.
	 * @return A list of config object types that are acceptable values.
	 */
	public String[] getSubtypes() {
		return this.subtypes;
	}

	public String toString() {
		return this.originalData;
	}
	
	/**
	 * @return A list of simple attributes (primitive element attributes in XML)
	 */
	public ArrayList<ConfigObjectMetadata> getSimpleAttributes() throws Exception {
		ArrayList<ConfigObjectMetadata> ret = new ArrayList<ConfigObjectMetadata>();
		for (ConfigObjectMetadata item : getAllAttributes())
			if (!item.isObject())
				ret.add(item);
		return ret;
	}
	
	/**
	 * @return A list of complex attributes (nested elements in XML)
	 */
	public ArrayList<ConfigObjectMetadata> getComplexAttributes() throws Exception {
		ArrayList<ConfigObjectMetadata> ret = new ArrayList<ConfigObjectMetadata>();
		for (ConfigObjectMetadata item : getAllAttributes())
			if (item.isObject())
				ret.add(item);
		return ret;
	}
	
	/**
	 * @return All attributes (simple and complex) as a single list
	 */
	public ArrayList<ConfigObjectMetadata> getAllAttributes() throws Exception {
		// Ensure that all complex entries are properly initialized (lazy-init)
		for (ConfigObjectMetadata item : list)
			if (item.isObject())
				item.initComplex();
		return this.list;
	}
	
	/**
	 * @return The count of all attributes, both simple and complex.
	 */
	public int size() {
		return this.list.size();
	}
	
	/**
	 * Works as a stop-gap to prevent thorough recursion of config metadata.
	 * See the simple constructor for more information.
	 * @throws Exception
	 */
	protected void initComplex() throws Exception {
		if (this.initialized)
			return;
		this.initialized = true;
		
		if (this.isObject()) {
			this.internalType = ConfigObjectConfigType.Object;
			AttributeList meta = Topology.getOperationsProvider().getConfigurationOperationsProvider().getAttributesMetaInfo(this.scope, this.dataType);
			init(meta);
		}
	}
	
	private void init(AttributeList meta) throws Exception {
		Log.entering(c, "init", meta);
		this.originalData = meta.toString();
		for (int i=0; i < meta.size(); i++) {
			Attribute attribute = (Attribute)meta.get(i);
			ConfigObjectMetadata coa = new ConfigObjectMetadata(this.scope, attribute);
			list.add(coa);
		}
		Log.exiting(c, "init");
	}
	
	private void init(Attribute meta) {
        final String method = "init";
		Log.entering(c, method, meta);
		
		this.originalData = meta.toString();

		// Meta info is in the form: (_Attribute_MetaInfo_[A-Za-z0-9]* = [A-Za-z0-9]*,)*
		AttributeList attributes = (AttributeList)meta.getValue();
		for (int i=0; i < attributes.size(); i++) {
			Attribute attribute = (Attribute)attributes.get(i);
			String dname = attribute.getName();
			String dvalue = String.valueOf(attribute.getValue()).trim();
			
			Log.finer(c, method, "Extracted metadata pair: "+dname+"="+dvalue);
			
			if (dname.equalsIgnoreCase("DefaultValue"))
				this.defaultValue = dvalue;
			else if (dname.equalsIgnoreCase("IsCollection")) {
                if(dvalue instanceof String && dvalue.trim().equals("1"))
                    dvalue = "true";
				this.isCollection = Boolean.parseBoolean(dvalue);
            }
			else if (dname.equalsIgnoreCase("DataType"))
				this.dataType = dvalue;
			else if (dname.equalsIgnoreCase("IsObject")) {
				if(this.dataType != null && this.dataType.equals("Boolean"))
					dvalue = "false";
                if(dvalue instanceof String && dvalue.trim().equals("1"))
                    dvalue = "true";
				this.isObject = Boolean.parseBoolean(dvalue);
				// DO NOT set internalType to Object
				// DO NOT call initComplex()
				// DO NOT pass go, collect 200, etc...
				Log.finer(c, method, "isObject: "+this.isObject);
			}
			else if (dname.equalsIgnoreCase("IsRequired")) {
                if(dvalue instanceof String && dvalue.trim().equals("1"))
                    dvalue = "true";
                this.isRequired = Boolean.parseBoolean(dvalue);
            }
			else if (dname.equalsIgnoreCase("IsReference")) {
                if(dvalue instanceof String && dvalue.trim().equals("1"))
                    dvalue = "true";
				this.isReference = Boolean.parseBoolean(dvalue);
            }
			else if (dname.equalsIgnoreCase("EnumValues")) {
				dvalue = dvalue.substring(1, dvalue.length()-1);
				enumValues = dvalue.split(",");
				for (int p=0; p < enumValues.length; p++) {
					String[] parts = enumValues[p].split("=");
					enumValues[p] = parts[0];
				}
			} else if (dname.equalsIgnoreCase("Subtypes")) {
				dvalue = dvalue.substring(1, dvalue.length()-1);
				subtypes = dvalue.split(",");
			} else if (dname.equalsIgnoreCase("Name")) {
				if (this.name == null)
					this.name = dvalue;
			}
			else
				Log.finer(c, method, "Unknown metadata attribute: "+attribute.getName());			

		}
		
		if (this.name == null)
			this.name = meta.getName();
		
		Log.exiting(c, method);
	}
	
}
