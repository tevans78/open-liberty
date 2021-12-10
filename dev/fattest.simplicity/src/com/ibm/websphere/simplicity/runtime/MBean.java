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

package com.ibm.websphere.simplicity.runtime;

import java.util.HashMap;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.MBeanInfo;
import javax.management.ObjectName;

import com.ibm.websphere.simplicity.ApplicationServer;
import com.ibm.websphere.simplicity.exception.NullArgumentException;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;
import com.ibm.websphere.simplicity.provider.websphere.MBeanOperationsProvider;

/**
 * 
 * @author SterlingBates
 *
 */
public class MBean {
	
	private static HashMap<String, String> ambiguousDataTypes = new HashMap<String, String>();
	
	static {
		ambiguousDataTypes.put("java.lang.Integer", "int");
		ambiguousDataTypes.put("java.lang.Long", "int");
	}
	
	protected ObjectName objectName;
	protected ApplicationServer scope;
	
	public MBean(ApplicationServer scope, ObjectName objectName) throws Exception {
		this.scope = scope;
		this.objectName = objectName;
		if (this.objectName.isPattern())
			throw new Exception("The ObjectName instance must be a fully resolved object name.");
	}
	
	/**
	 * Constructor used only for descendents who may need to resolve
	 * object name references.
	 * @param scope
	 */
	protected MBean(ApplicationServer scope) {
		this.scope = scope;
		this.objectName = null;
	}
	
	/**
	 * The "object name" is the mbean's unique identifier.  This is passed to the
	 * server when making remote method invocations, or when getting and setting
	 * attributes on the mbean.
	 * @return The ObjectName instance uniquely identifying this instance's mbean.
	 */
	public ObjectName getObjectName() {
		return this.objectName;
	}
	
	/**
	 * @return The WebSphere instance on which this mbean resides.
	 */
	public ApplicationServer getScope() {
		return this.scope;
	}
	
	/**
	 * @return An MBeanInfo object that lists methods, attributes, and other information about the mbean.
	 * @throws Exception
	 */
	public MBeanInfo getMBeanInfo() throws Exception {
		return getOperationsProvider().getMBeanInfo(this.scope, this.objectName);
	}

	/**
	 * Invokes the specified method on the remote mbean instance with no parameters.
	 * The target method must have an empty argument list.  e.g.:
	 *    public Object myMethod()
	 * or
	 *    public void myMethod()
	 * 
	 * @param method The name of the method to invoke.
	 * @return Any result, or null if the target method is void.
	 * @throws Exception
	 */
	public Object invoke(String method) throws Exception {
		return invoke(method, new Object[] { });
	}

	/**
	 * Invokes the specified method on the remote mbean instance with the specified parameters.
	 * The parameter list must be provided in the same order they are specified for the target
	 * mbean.  You must ensure that the parameter types correspond as closely as possible to the
	 * method's signature, particularly in cases of overloaded methods.
	 * 
	 * Null parameters may be passed by providing a string with a value like this:
	 *    null:<canonical type name>
	 * For example:
	 *    null:java.lang.String
	 *    null:javax.management.ObjectName
	 * 
	 * @param method The name of the method to invoke.
	 * @param parameters The expected parameters for the method call, in the order required by the method's signature.
	 * @return Any result, or null if the target method is void.
	 * @throws Exception
	 */
	public Object invoke(String method, Object[] parameters) throws Exception {
		return invoke(this.scope, method, parameters);
	}
	
	/**
	 * Invokes the specified method on the remote mbean instance with the specified parameters,
	 * within the context of the provided AdminClient instance.
	 * The parameter list must be provided in the same order they are specified for the target
	 * mbean.  You must ensure that the parameter types correspond as closely as possible to the
	 * method's signature, particularly in cases of overloaded methods.
	 * 
	 * Null parameters may be passed by providing a string with a value like this:
	 *    null:<canonical type name>
	 * For example:
	 *    null:java.lang.String
	 *    null:javax.management.ObjectName
	 * It's also possible to replace the canonical type name with an instrinsic type name:
	 *    null:int
	 * 
	 * @param method The name of the method to invoke.
	 * @param parameters The expected parameters for the method call, in the order required by the method's signature.
	 * @return Any result, or null if the target method is void.
	 * @throws Exception
	 */
	public Object invoke(ApplicationServer scope, String method, Object[] parameters) throws Exception {
		/*
		 * First convert the array of parameters into two arrays:
		 *   1. A list of values to pass to the method.
		 *   2. A list of strings corresponding to the types of the values being passed.
		 *   
		 * The latter is the reason why the "null:" requirement is necessary.  Even if
		 * a parameter value being passed is null, we must still submit the target type 
		 * so WebSphere can resolve the correct method signature.
		 * 
		 * If the method signature has no parameters at all, then it's OK to pass null
		 * for the values and signature types.
		 */
		String[] types = null;
		Object[] values = null;
		String str = null;
		if (parameters != null)
		{
			types = new String[parameters.length];
			values = new Object[parameters.length];
			int i = 0;
			for (Object o : parameters) {
				if (o == null) {
					throw new NullArgumentException("args["+i+"]", "Use the string \"null:<canonical type name>\" to pass a null parameter.");
				} else if (o instanceof String && (str = (String)o) != null && str.startsWith("null:")) {
					values[i] = null;
					types[i] = str.substring(5);	// skip "null:"
				} else {
					values[i] = o;
					types[i] = getFriendlyType(o.getClass().getCanonicalName());
				}
				i++;
			}
		}
		return getOperationsProvider().invoke(scope, this.objectName, method, values, types);
	}
	
	/**
	 * Returns the value of the specified attribute.  For example, if the 
	 * target mbean has a "name" attribute, the following call will return 
	 * its value:
	 *    mbean.getAttribute("name");
	 * 
	 * @param name The attribute whose value will be returned.
	 * @return The value of the specified attribute name.
	 * @throws Exception
	 */
	public Object getAttribute(String name) throws Exception {
		AttributeList list = getAttributes(new String[] { name });
		for (int i=0; i < list.size(); i++) {
			Attribute attribute = (Attribute)list.get(i);
			if (attribute.getName().equalsIgnoreCase(name))
				return attribute.getValue();
		}
		return null;
	}

	/**
	 * Returns a list of attributes corresponding to the provided attribute
	 * names, including their values.  For example, if the target mbean has
	 * both a "name" and an "address" attribute, the following call will
	 * return values for both of the specified attributes:
	 *    mbean.getAttributes(new String[] { "name", "address" });
	 * 
	 * @param names The attributes whose values will be returned.
	 * @return A list of name/value pairs for the specified attribute names.
	 * @throws Exception
	 */
	public AttributeList getAttributes(String[] names) throws Exception {
		return getOperationsProvider().getMBeanAttributes(this.scope, this.objectName, names);
	}
	
	/**
	 * Sets the specified attribute on the target mbean.  For example, if the
	 * mbean contains this method:
	 *    public void setName(String name) { ... }
	 * then you can pass a value for the "name" attribute in this call.
	 * For example:
	 *    mbean.setAttribute("address", "100 Any St.");
	 * 
	 * @param name The name of the attribute
     * @param value The value of the attribute
	 * @throws Exception
	 */
	public void setAttribute(String name, Object value) throws Exception {
		setAttribute(new Attribute(name, value));
	}
	
	/**
	 * Sets the specified attribute on the target mbean.  For example, if the
	 * mbean contains this method:
	 *    public void setName(String name) { ... }
	 * then you can pass a value for the "name" attribute in this call.
	 * For example:
	 *    mbean.setAttribute(new Attribute("address", "100 Any St."));
	 * 
	 * @param attribute The attribute to set for the target mbean.
	 * @throws Exception
	 */
	public void setAttribute(Attribute attribute) throws Exception {
		AttributeList list = new AttributeList();
		list.add(attribute);
		setAttributes(list);
	}

	/**
	 * Sets the specified attributes on the target mbean.  For example, if the
	 * mbean contains these methods:
	 *    public void setName(String name) { ... }
	 *    public void setAddress(String addr) { ... }
	 * then you can pass values for both the "name" and "address" attributes
	 * in this call.  For example:
	 *    AttributeList list = new AttributeList();
	 *    list.add(new Attribute("name", "J Smith"));
	 *    list.add(new Attribute("address", "100 Any St."));
	 * 
	 * @param attributes The list of attributes to set for the target mbean.
	 * @throws Exception
	 */
	public void setAttributes(AttributeList attributes) throws Exception {
		getOperationsProvider().setMBeanAttributes(this.scope, this.objectName, attributes);
	}
	
	/**
	 * When invoking methods, the signature for each type can be either implicit or
	 * explicit.  For instance, if we say "java.lang.Integer", the invoker will look
	 * for a java.lang.Integer parameter in a target method call.  However, if we
	 * say "int", the invoker will find integer, long, and others.  Since some of the
	 * values we have could be ambiguous, this method returns an ambiguous type for
	 * those values.
	 * 
	 * @param s
	 * @return An friendly type as described
	 */
	private String getFriendlyType(String s) {
		String ret = ambiguousDataTypes.get(s);
		if (ret == null)
			ret = s;
		return ret;
	}
	
	protected MBeans getMBeans() throws Exception {
		return this.scope.getRuntimeServices().getMBeans();
	}
	
	protected MBeanOperationsProvider getOperationsProvider() throws Exception {
		return OperationsProviderFactory.getProvider().getMBeanOperationsProvider();
	}
	
	protected void resolveObjectName(String objectNamePattern) throws Exception {
		ObjectName on = new ObjectName(objectNamePattern);
		on.apply(new ObjectName(scope.getObjectNameFragment()));
		this.objectName = getMBeans().queryName(on);
		if (this.objectName == null)
			throw new Exception("No mbean could be found matching: "+on.toString() +" (originally: "+objectNamePattern+")");
	}

}
