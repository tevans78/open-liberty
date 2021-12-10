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

import java.util.ArrayList;
import java.util.List;

import javax.management.ObjectName;

import com.ibm.websphere.simplicity.Cell;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.application.tasks.ApplicationTask;
import com.ibm.websphere.simplicity.application.tasks.MapModulesToServersTask;
import com.ibm.websphere.simplicity.provider.websphere.ApplicationOperationsProvider;

/**
 * 
 * @author SterlingBates
 *
 */
public abstract class AssetModule {
	
	protected static AssetModule getModuleInstance(Application application, String name, String uri) throws Exception {
        int fileNameEnd = uri.indexOf('+');
        if(fileNameEnd == -1) {
            fileNameEnd = uri.indexOf(',');
        }
		String ddURI = uri.substring(fileNameEnd + 1);
		ArchiveType type = ArchiveType.fromExtension(ddURI);
		
		switch(type) {
			case EAR: return new ApplicationModule(application, name, uri);
			case JAR: return new EjbModule(application, name, uri);
			case RAR: return new ResourceModule(application, name, uri);
			case WAR: return new WebModule(application, name, uri);
			case SAR: return new SipModule(application, name, uri);
            default: throw new Exception("Unable to determine module type for module " + name + " " + uri);
		}
	}
	
	private ArchiveType type = ArchiveType.UNKNOWN;
	private String name = "";
	private List<Scope> targets = null;
	private String uri;
	private Application application;
	
	protected AssetModule(Application application, ArchiveType type, String name, String uri) {
		this.application = application;
		this.type = type;
		this.name = name;
		this.uri = uri;
	}
	
    public List<Scope> getTargets() throws Exception {
        if(this.targets == null) {
            this.targets = new ArrayList<Scope>();
            List<ApplicationTask> tasks = this.getModuleInfo();
            if (tasks != null) {
	            for(ApplicationTask task : tasks) {
	                if(task instanceof MapModulesToServersTask) {
	                    MapModulesToServersTask mmts = (MapModulesToServersTask)task;
	                    String targetString = mmts.getTarget(this);
	                    if (targetString != null) {
		                    String[] targets = targetString.split("\\+");
		                    for(int i = 0; i < targets.length; ++i) {
		                        ObjectName objName = new ObjectName(targets[i]);
		                        String node = objName.getKeyProperty("node");
		                        String server = objName.getKeyProperty("server");
		                        String cluster = objName.getKeyProperty("cluster");
		                        Scope scope = this.application.getScope();
		                        while(scope.getParent() != null) {
		                            scope = scope.getParent();
		                        }
		                        // we should have the cell now. should we add Scope.getCell()?
		                        Cell cell = (Cell)scope;
		                        if(cluster != null) {
		                            this.targets.add(cell.getClusterByName(cluster));
		                        } else {
		                            this.targets.add(cell.getNodeByName(node).getServerByName(server));
		                        }
		                    }
		                    break;
	                    }
	                }
	            }
            }
        }
        return this.targets;
    }
    
	public String getName() {
		return this.name;
	}
	
	public ArchiveType getType() {
		return this.type;
	}
	
	public String getURI() {
		return this.uri;
	}

	public List<ApplicationTask> getModuleInfo() throws Exception {
		if (this.application == null)
			throw new Exception("Module is not part of an installed application.");
		ApplicationOperationsProvider ops = this.application.getApplicationProvider();
        
		return ops.getModuleInfo(application.getScope(), this.application.getName(), this.getFileName());
		
	}
	
	public String getFileName() {
        int fileNameEnd = this.uri.indexOf('+');
        if(fileNameEnd == -1) {
            fileNameEnd = this.uri.indexOf(',');
        }
        if(fileNameEnd == -1) {
        	return null;
        }
        return this.uri.substring(0, fileNameEnd);
    }

    public Application getApplication() {
        return this.application;
    }
}
