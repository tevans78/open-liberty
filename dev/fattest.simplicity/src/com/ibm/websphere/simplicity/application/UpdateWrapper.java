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

import com.ibm.websphere.simplicity.Cell;
import com.ibm.websphere.simplicity.Machine;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.RemoteFile;
import com.ibm.websphere.simplicity.application.tasks.ApplicationTask;
import com.ibm.websphere.simplicity.application.types.RecycleType;
import com.ibm.websphere.simplicity.application.types.RedeployType;
import com.ibm.websphere.simplicity.application.types.UpdateContentType;
import com.ibm.websphere.simplicity.application.types.UpdateType;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;
import com.ibm.websphere.simplicity.provider.commandline.CommandLineProviderFactory;

public class UpdateWrapper extends ApplicationOptions {
	
	private Application application;
	private ApplicationOptions originalOptions;
	private UpdateType updateType;
	private String contentUri;
    private String contextRoot;
	private RemoteFile contents;
	private UpdateContentType contentType;
	private RecycleType recycleType;
	private List<String> recycleModules = new ArrayList<String>();
	private boolean redeploy;
	private RedeployType redeployType;
	private ArchiveType originalArchiveType;

	protected UpdateWrapper(Application app, List<ApplicationTask> tasks, Cell cell) throws Exception {
		super(tasks, cell);
		this.application = app;
		this.originalOptions = app.getApplicationOptions();
	}
    
    protected UpdateWrapper(Application app, Cell cell) throws Exception {
        super(null, cell);
        this.application = app;
        this.originalOptions = app.getApplicationOptions();
    }
	
	/**
	 * @return The application to be updated.
	 */
	public Application getApplication() {
		return this.application;
	}
	
	/**
	 * @return The name of the application to be updated.
	 */
	public String getName() {
		return this.application.getName();
	}
	
	/**
	 * @return An object that represents the state of the application prior to the update.
	 */
	public ApplicationOptions getOriginalOptions() {
		return this.originalOptions;
	}
	
	/**
	 * Defines the update operation type.  The four operations that can be performed
	 * are 1) simple update; 2) full app update; 3) update and add; 4) delete.  More
	 * documentation is available via the UpdateType enum.
	 * @param updateType The type of operation to perform for this update.
	 */
	public void setUpdateType(UpdateType updateType) {
		this.updateType = updateType;
        retrieveTasks();
	}
	
	/**
	 * @return The type of operation being performed by this update.
	 */
	public UpdateType getUpdateType() {
		return this.updateType;
	}
	
	/**
	 * The content URI is only required when a file is being updated or deleted.
	 * <p>
	 * The content URI represents the relative path within the application of the module or
	 * file being updated or deleted.  For example, if a module is being updated, the value
	 * is simply the full filename of the module (e.g. "Increment.jar").
	 * @param value
	 */
	public void setContentUri(String value) {
		this.contentUri = value;
		retrieveTasks();
	}
	
	/**
	 * @return The relative path within the application of the file being updated or deleted.
	 */
	public String getContentUri() {
		return this.contentUri;
	}
    
    /**
     * The context root is only required when adding a new module
     * @param value The context root for the module update
     */
    public void setContextRoot(String value) {
        this.contextRoot = value;
        retrieveTasks();
    }
    
    /**
     * @return The context root for the module update
     */
    public String getContextRoot() {
        return this.contextRoot;
    }
	
	/**
	 * This is a required parameter for all update operations except delete.
	 * <p>
	 * This API defines either the file to be added or updated, or the location of the
	 * replacement application file.  For single file updates you will also need to
	 * set the content URI via the setContentUri API.
	 * @param contents
	 * @param contentType
	 */
	public void setContents(RemoteFile contents, UpdateContentType contentType) throws Exception {
        if(contents != null)
            this.contents = ensureFileIsLocal(contents);
		this.contentType = contentType;
        retrieveTasks();
	}
    
	/**
	 * Internal use only.
	 */
    public void setContents(RemoteFile contents) {
        this.contents = contents;
    }
	
    /**
     * The update contents' file does not apply to delete operations.
     * @return A reference to the file being deployed as part of the update, if any.
     */
    public RemoteFile getContents() {
		return this.contents;
	}

    /**
     * The update contents' type does not apply to delete operations.
     * @return The type of file (single or compound) being deployed as part of the update, if any.
     */
	public UpdateContentType getContentType() {
		return this.contentType;
	}
	
	/**
	 * When performing an update you can optionally choose to recycle (stop & start)
	 * either the entire application or a subset of modules when the update is complete.
	 * This API also allows you to disable recycling.
	 * @param recycleType The preferred recycling option.
	 */
	public void setRecycleType(RecycleType recycleType) {
		this.recycleType = recycleType;
	}
	
	/**
	 * @return The preferred recycling option specified via setRecycleType.
	 */
	public RecycleType getRecycleType() {
		return this.recycleType;
	}
	
	/**
	 * When the recycle option is set to RecycleType.MODULE, the modules to be
	 * recycled are specified via this API.
	 * @param module A module to recycle when the update operation is complete.
	 */
	public void addModuleToRecycle(String module) {
		this.recycleModules.add(module);
	}
	
	/**
	 * @return A list of modules specified to be recycled after updating.
	 */
	public List<String> getModulesToRecycle() {
		return this.recycleModules;
	}
	
	/**
	 * Instead of simply updating an application, it may be preferred to completely
	 * uninstall and reinstall the entire application.  Setting redeploy to true will
	 * enable this uninstall and reinstall feature for this update.
	 * @param value True if the application should be uninstalled and reinstalled for this update.
	 */
	public void setRedeploy(boolean value) {
		this.redeploy = value;
	}
	
	/**
	 * @return True if the application will be uninstalled and reinstalled for this update.
	 */
	public boolean getRedeploy() {
		return this.redeploy;
	}
	
	/**
	 * When the redeploy option is set to true, this option lets the user define whether
	 * the reinstall process uses default bindings; ignores default bindings; or uses the
	 * existing default value for this option.
	 * @param type The bindings setting for the redeploy process.
	 */
	public void setRedeployType(RedeployType type) {
		this.redeployType = type;
	}

	/**
	 * @return The bindings setting for the redeploy process.
	 */
	public RedeployType getRedeployType() {
		return this.redeployType;
	}

    public ArchiveType getOriginalArchiveType() {
    	return this.originalArchiveType;
    }
    
	private RemoteFile ensureFileIsLocal(RemoteFile file) throws Exception {
		return CommandLineProviderFactory.getProvider().ensureFileIsOnMachine(Machine.getLocalMachine(), file);
	}
	
    @SuppressWarnings("unchecked")
	public boolean validate() throws Exception {
    	OperationResults<Boolean> ret = OperationsProviderFactory.getProvider().getApplicationOperationsProvider().validateApplication(cell, contents, this, cell.getWorkspace().getSession());
    	return ret.getResult();
    }
    
    private void retrieveTasks() {
    	// No reading tasks if we're just deleting
    	if (this.updateType != null && this.updateType.equals(UpdateType.DELETE))
    		return;
    	
    	// Don't do anything until we know both the content type and update type
    	if (this.contentType == null || this.updateType == null)
    		return;
    	
    	// If we have a contentType of FILE or MODULE, we also need a contentUri
    	if ((this.contentType.equals(UpdateContentType.FILE) || 
    			this.contentType.equals(UpdateContentType.MODULE)) &&
    			this.contentUri == null)
    		return;
        
        // If we have a contentType of MODULE and a updateType of ADD, we also need a context root for web modules
        if(this.contentType.equals(UpdateContentType.MODULE) 
                && this.updateType.equals(UpdateType.ADD)
                && (this.contextRoot == null && this.contentUri.endsWith(".war")))
            return;
    	
    	// Finally, we only read from the content file for MODULE update or FULL_APP update
    	if (this.contentType.equals(UpdateContentType.FILE) ||
    			this.contentType.equals(UpdateContentType.PARTIAL_APP))
    		return;

    	// Having satisfied all conditions, we now read...for all other scenarios, no data!
        try {
        	List<ApplicationTask> tasks = null;
            if(this.contentType.equals(UpdateContentType.MODULE))
            	tasks = Application.retrieveDeploymentOptions(this.cell, this.contents, this.getName(), this.contentUri);
            else
            	tasks = Application.retrieveDeploymentOptions(this.cell, this.contents, this.getName());
            this.tasks = tasks;
            super.loadTasks(tasks);
        } catch(Exception e) {
            Log.error(UpdateWrapper.class, "retrieveTasks", e);
        }
    }
    
}
