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

package com.ibm.websphere.simplicity.provider.websphere;

import java.util.Set;

import javax.management.AttributeList;
import javax.management.MBeanInfo;
import javax.management.ObjectName;
import javax.management.QueryExp;

import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.provider.CategorizedOperationsBase;
import com.ibm.websphere.simplicity.runtime.NodeSyncResult;

public abstract class MBeanOperationsProvider extends CategorizedOperationsBase {

	/**
	 * Constructor.  For provider use only.
	 * @param parent
	 */
    public MBeanOperationsProvider(WebSphereOperationsProvider parent) {
		super(parent);
	}
    
    /**
     * Retrieves a list of MBean identifiers visible from the specified scope
     * matching the specified pattern.  Object names are composed of two
     * major divisions: a domain (typically "WebSphere"), and key/value pairs
     * that identify various attributes of the MBean.  Some attributes may
     * contain version information, scope identifiers, type information, etc.
     * <p>
     * An object name pattern is a partially-constructed object name with
     * wild cards (asterisks) replacing the missing portions.  Valid patterns
     * include the following:
     * <ul>
     * <li>WebSphere:cell=myCell,node=myNode,server=myServer,*
     * <li>WebSphere:name=AppManagement,*
     * <li>*:cell=myCell,name=AppManagement,*
     * </ul>
     * @param key The WebSphere scope from which to run the query.
     * @param pattern The pattern to match for MBean results.
     * @return A list of MBean identifiers matching the pattern.
     * @throws Exception
     */
	public abstract ObjectName[] queryNames(Scope key, ObjectName pattern) throws Exception;
	
	/**
	 * Retrieves the first instance of an MBean matching the specified
	 * pattern.  This is equivalent to queryNames(...)[0].
     * @param key The WebSphere scope from which to run the query.
     * @param pattern The pattern to match for MBean results.
	 * @return The first MBean identifer that matches the pattern.
	 * @throws Exception
	 */
    public abstract ObjectName queryObjectName(Scope key, ObjectName pattern) throws Exception;
    
    /**
     * Obtains an MBeanInfo object that contains information about the MBean,
     * including methods and attributes.
     * @param key The WebSphere scope from which to run the query.
     * @param mbean An MBean identifier.
     * @return An MBeanInfo instance for the specified MBean.
     * @throws Exception
     */
    public abstract MBeanInfo getMBeanInfo(Scope key, ObjectName mbean) throws Exception;
    
    /**
     * Invokes the specified method with the provided arguments on the
     * provided MBean.  WebSphere will resolve the target method based
     * on a combination of the name and specified signature.  Each
     * signature entry is either a Java primitive (for example: "int", 
     * "boolean" or "long") or the canonical name of a class (for
     * example: "java.lang.String").
     * @param key The WebSphere scope from which to invoke the method.
     * @param mbean The identifier representing the target MBean.
     * @param function The method to invoke.
     * @param args The arguments to pass to the method.
     * @param signature The method signature to find.
     * @return The result of the method invocation, if any.
     * @throws Exception
     */
    public abstract Object invoke(Scope key, ObjectName mbean, String function, Object[] args, String[] signature) throws Exception;
    
    /**
     * A wrapper for the {@link #invoke(Scope, ObjectName, String, Object[], String[])} method that attempts to return
     * a Boolean value from the method invocation.
     * @param key The WebSphere scope from which to invoke the method.
     * @param mbean The identifier representing the target MBean.
     * @param function The method to invoke.
     * @param args The arguments to pass to the method.
     * @param signature The method signature to find.
     * @return The result of the method invocation, if any.
     * @throws Exception
     */
    public abstract Boolean invokeBoolean(Scope key, ObjectName mbean, String function, Object[] args, String[] signature) throws Exception;
    
    /**
     * A wrapper for the {@link #invoke(Scope, ObjectName, String, Object[], String[])} method that attempts to return
     * an Integer value from the method invocation.
     * @param key The WebSphere scope from which to invoke the method.
     * @param mbean The identifier representing the target MBean.
     * @param function The method to invoke.
     * @param args The arguments to pass to the method.
     * @param signature The method signature to find.
     * @return The result of the method invocation, if any.
     * @throws Exception
     */
    public abstract Integer invokeInteger(Scope key, ObjectName mbean, String function, Object[] args, String[] signature) throws Exception;
    
    /**
     * A wrapper for the {@link #invoke(Scope, ObjectName, String, Object[], String[])} method that attempts to return
     * a Long value from the method invocation.
     * @param key The WebSphere scope from which to invoke the method.
     * @param mbean The identifier representing the target MBean.
     * @param function The method to invoke.
     * @param args The arguments to pass to the method.
     * @param signature The method signature to find.
     * @return The result of the method invocation, if any.
     * @throws Exception
     */
    public abstract Long invokeLong(Scope key, ObjectName mbean, String function, Object[] args, String[] signature) throws Exception;
    
    /**
     * A wrapper for the {@link #invoke(Scope, ObjectName, String, Object[], String[])} method that attempts to return
     * a String value from the method invocation.
     * @param key The WebSphere scope from which to invoke the method.
     * @param mbean The identifier representing the target MBean.
     * @param function The method to invoke.
     * @param args The arguments to pass to the method.
     * @param signature The method signature to find.
     * @return The result of the method invocation, if any.
     * @throws Exception
     */
    public abstract String invokeString(Scope key, ObjectName mbean, String function, Object[] args, String[] signature) throws Exception;
    
    /**
     * Provides base access to the actual AdminClient.queryNames method.
     * Most third parties will use the other queryNames call.  The query
     * parameter is an optional alternative to the object name pattern.
     * @param key The WebSphere scope from which to query.
     * @param spec An MBean object name pattern.
     * @param query A QueryExp instance.
     * @return A set of object name MBean identifiers.
     * @throws Exception
     */
    public abstract Set<ObjectName> queryNames(Scope key, ObjectName spec, QueryExp query) throws Exception;
    
    /**
     * Obtains a list of ObjectInstance instances that represent MBeans
     * that match the supplied pattern.
     * @param key The WebSphere scope from which to query.
     * @param spec An MBean object name pattern.
     * @param query A QueryExp instance.
     * @return A set of object name MBean identifiers.
     * @throws Exception
     */
    public abstract Set<ObjectName> queryMBeans(Scope key, ObjectName spec, QueryExp query) throws Exception;
    
    /**
     * Retrieves the values of the specified attributes on the specified
     * MBean.  The available attributes can be found in the MBeanInfo
     * class returned by {@link #getMBeanInfo(Scope, ObjectName)}.  The attribute list is
     * simply a list of names.  The resulting AttributeList instance is
     * a flat list of the attribute names and their simple values.
     * @param key The WebSphere scope from which to query.
     * @param mbean The MBean whose attributes will be retrieved.
     * @param attributes The attributes to be retrieved.
     * @return A list of values corresponding to the requested attributes.
     * @throws Exception
     */
    public abstract AttributeList getMBeanAttributes(Scope key, ObjectName mbean, String[] attributes) throws Exception;
    
    /**
     * Modifies the values of the specified attributes on the specified
     * MBean.  The available attributes can be found in the MBeanInfo
     * class returned by {@link #getMBeanInfo(Scope, ObjectName)}.  The supplied AttributeList
     * is simply a list of names and values.
     * @param key The WebSphere scope from which to query.
     * @param mbean The MBean whose attributes will be modified.
     * @param attributes The attributes to be modified, along with their values.
     * @return The new state of attributes in the MBean.
     * @throws Exception
     */
    public abstract AttributeList setMBeanAttributes(Scope key, ObjectName mbean, AttributeList attributes) throws Exception;
    
    /**
     * Returns the number of MBeans that are registered in the MBean server.
     * Unlike other MBean methods, which can query lower scopes for MBeans,
     * this method only returns the number of MBeans <i>at the target scope.</i>
     * To count all of the MBeans for a given cell, you must iterate over
     * the cell, all nodes, and all servers throughout the topology.
     * @param key The WebSphere scope to query.
     * @return The number of MBeans registered at the scope's MBean server.
     * @throws Exception
     */
    public abstract int getMBeanCount(Scope key) throws Exception;
    
    /**
     * Attempts to connect to a running WebSphere instance marked by the
     * provided scope.  If no physical connection exists at that scope,
     * the provider will work up the scope chain until it finds a valid
     * connection.  In other words, this method will not reliably determine
     * if a particular server or node is running.
     * @param key The scope at which to determine whether the provider is connected.
     * @return True if the connection is still valid.
     * @throws Exception
     */
    public abstract boolean isConnected(Scope key) throws Exception;
    
    /**
     * Retrieves the domain name to which the provider is connected at
     * the given scope.  If no physical connection exists at that scope,
     * the provider will work up the scope chain until one is found.
     * This method will not reliabily return a domain name for every
     * scope.
     * 
     * <b>THE ABOVE NEEDS TO BE DOUBLE-CHECKED.</b>
     * 
     * @param key The scope at which to retrieve the target domain name.
     * @return The domain name of the server to which the connection is made.
     * @throws Exception
     */
    public abstract String getDomainName(Scope key) throws Exception;
    
    /**
     * Convert an Object returned by {@link #invoke(Scope, ObjectName, String, Object[], String[])}
     * on the function getResult on the NodeSync MBean to a {@link NodeSyncResult}.
     * 
     * @param syncResult The syncResult Object
     * @return The {@link NodeSyncResult} representation
     */
    public abstract NodeSyncResult convertToNodeSyncResult(Object syncResult);
}
