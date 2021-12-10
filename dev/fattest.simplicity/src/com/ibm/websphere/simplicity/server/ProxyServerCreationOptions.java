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

package com.ibm.websphere.simplicity.server;

import java.util.List;

import com.ibm.websphere.simplicity.ProxyServer;

/**
 * Options for creating a {@link ProxyServer}
 */
public class ProxyServerCreationOptions extends AppServerCreationOptions {
	
	private ConfigCoreGroup configCoreGroup;
	private SelectProtocols selectProtocols;
	

	public ConfigCoreGroup getConfigCoreGroup() {
		return configCoreGroup;
	}

	public void setConfigCoreGroup(ConfigCoreGroup configCoreGroup) {
		this.configCoreGroup = configCoreGroup;
	}

	public SelectProtocols getSelectProtocols() {
		return selectProtocols;
	}

	public void setSelectProtocols(SelectProtocols selectProtocols) {
		this.selectProtocols = selectProtocols;
	}

	public static class ConfigCoreGroup {
		private String coreGroupName;

		/**
		 * Get the name of the core group to configure
		 * @return the name of the core group to configure
		 */
		public String getCoreGroupName() {
			return coreGroupName;
		}
		/**
		 * Set the name of the core group to configure
		 * @param coreGroupName the name of the core group to configure
		 */
		public void setCoreGroupName(String coreGroupName) {
			this.coreGroupName = coreGroupName;
		}
		
	}
	
	public static class SelectProtocols {
		private List<String> list;

		/**
		 * Get a list of protocols that the proxy server supports
		 * @return a list of protocols that the proxy server supports
		 */
		public List<String> getList() {
			return list;
		}
		/**
		 * Set a list of protocols that the proxy server supports
		 * @param list a list of protocols that the proxy server supports
		 */
		public void setList(List<String> list) {
			this.list = list;
		}
		
	}
}
