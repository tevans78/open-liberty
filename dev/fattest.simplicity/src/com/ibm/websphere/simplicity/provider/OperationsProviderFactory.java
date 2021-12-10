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

package com.ibm.websphere.simplicity.provider;

import java.lang.reflect.Constructor;
import java.util.HashMap;

import com.ibm.websphere.simplicity.OperationsProviderType;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.websphere.WebSphereOperationsProvider;

public class OperationsProviderFactory {
	
	private static Class c = OperationsProviderFactory.class;
	private static HashMap<OperationsProviderType, WebSphereOperationsProvider> instances = new HashMap<OperationsProviderType, WebSphereOperationsProvider>();
	private static OperationsProviderType defaultProviderType = OperationsProviderType.JMX;
	
	public static void setDefaultCommandProvider(OperationsProviderType type) throws Exception {
		if (type == null)
			throw new Exception("Cannot set default command provider to null");
		defaultProviderType = type;
	}
	
	public static WebSphereOperationsProvider getProvider() throws Exception {
		return getProvider(defaultProviderType);
	}
	
	public static WebSphereOperationsProvider getProvider(OperationsProviderType providerType) throws Exception {
		Log.entering(c, "getProvider", providerType.name());
		WebSphereOperationsProvider ret;
		synchronized(instances) {
			ret = instances.get(providerType);
		}
		if (ret != null) {
			Log.finer(c, "getProvider", "Found an instance of a provider of type " + providerType + " in the cache.");
			Log.exiting(c, "getProvider", ret);
			return ret;
		}
		else {
			synchronized(instances) {
				/*
				 * This conditional is required.  One thread will get through, and
				 * at the end will add the provider to the hash table.  Subsequent
				 * callers should immediately return the newly created provider.
				 */
				if (instances.containsKey(providerType)) {
					ret = instances.get(providerType);
					Log.finer(c, "getProvider", "Found an instance of a provider of type " + providerType + " in the cache.");
					Log.exiting(c, "getProvider", ret);
					return ret;
				}
				
				String clsname = providerType.getClassName();
				Class clazz = null;
				try {
	                clazz = Class.forName(clsname);
				}
				catch(ClassNotFoundException e) {
					throw new Exception("Provider not available: "+providerType.name()+"; are all dependencies in the classpath?", e);
				}
				catch(NoClassDefFoundError e2) {
					throw new Exception("Provider not available: "+providerType.name()+"; are all dependencies in the classpath?", e2);
				}
				Constructor[] constructors = clazz.getConstructors();
				Log.finer(c, "getProvider", "Found " + constructors.length + " constructors");
				if (constructors.length == 0)
					throw new Exception("Invalid class constructor list: "+clsname);
				
				Constructor constructor = constructors[0];
				Log.finer(c, "getProvider", "Generating an instance using contructor " + constructor);
				ret = (WebSphereOperationsProvider)constructor.newInstance();
				instances.put(providerType, ret);
			}
		}
		
		Log.exiting(c, "getProvider", ret);
		return ret;
	}
	
}
