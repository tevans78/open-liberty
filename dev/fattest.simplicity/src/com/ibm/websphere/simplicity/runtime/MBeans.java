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

import java.util.ArrayList;
import java.util.List;

import javax.management.ObjectName;

import com.ibm.websphere.simplicity.ApplicationServer;
import com.ibm.websphere.simplicity.Topology;
import com.ibm.websphere.simplicity.provider.websphere.MBeanOperationsProvider;

public class MBeans {
	
	private ApplicationServer scope;
	private MBeanOperationsProvider ops;
	
	public MBeans(ApplicationServer scope) throws Exception {
		this.scope = scope;
		this.ops = Topology.getOperationsProvider().getMBeanOperationsProvider();
	}

	/**
	 * @return The number of mbeans in the given scope.
	 * @throws Exception
	 */
	public int getCount() throws Exception {
		return this.ops.getMBeanCount(scope);
	}

	/**
	 * Returns a single MBean instance if the provided objectName is either a
	 * complete mbean reference or a pattern matching one or more mbeans.  If
	 * a pattern matches more than one mbean, the first result is arbitrarily
	 * chosen.
	 * 
	 * If the objectName is a pattern and does not match any mbeans in the given
	 * scope then null is returned.
	 * 
	 * An object name is recognized as a domain followed by zero or more property
	 * specifications, such as: domain:key=property(,key=property)*
	 * Wildcards may also be specified in place of the domain or any property,
	 * such as: *:key=property(,((\*)|(key=property)))*
	 * 
	 * @param objectName An object name instance representing either a pattern or complete mbean reference.
	 * @return An MBean instance corresponding to a valid object name, or null.
	 * @throws Exception
	 */
	public MBean getMBean(ObjectName objectName) throws Exception {
		if (objectName.isPattern()) {
			ObjectName[] list = ops.queryNames(this.scope, objectName);
			if (list.length == 0)
				return null;
			objectName = list[0];
		}
		return new MBean(this.scope, objectName);
	}

	/**
	 * Returns a list of zero or more mbean instances, depending on how many
	 * match the pattern provided in objectName.  If objectName is not a pattern,
	 * then a list containing only the specified objectName is returned.
	 * 
	 * An object name pattern can be identified as one containing one or more
	 * wildcards (asterisks), like the following:
	 * 
	 *   WebSphere:type=Server,cell=myCell,*
	 *   *:type=Server,*
	 *   *:type=Application,*
	 * 
	 * @param objectName An object name instance representing either a pattern or complete mbean reference.
	 * @return A list of zero or more MBean instances.
	 * @throws Exception
	 */
	public List<MBean> getMBeans(ObjectName objectName) throws Exception {
		ArrayList<MBean> ret = new ArrayList<MBean>();
		if (objectName.isPattern()) {
			ObjectName[] list = ops.queryNames(this.scope, objectName);
			for (ObjectName on : list)
				ret.add(new MBean(this.scope, on));
		} else
			ret.add(new MBean(this.scope, objectName));
		return ret;
	}
	
	/**
	 * @param pattern An object name pattern.
	 * @return A list of ObjectName instances that match the specified pattern.
	 * @throws Exception
	 */
	public ObjectName[] queryNames(ObjectName pattern) throws Exception {
		return ops.queryNames(this.scope, pattern);
	}
	
	public ObjectName queryName(ObjectName pattern) throws Exception {
		ObjectName[] results = queryNames(pattern);
		if (results.length > 0)
			return results[0];
		return null;
	}

}
