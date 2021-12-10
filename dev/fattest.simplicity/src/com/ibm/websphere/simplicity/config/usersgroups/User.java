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

package com.ibm.websphere.simplicity.config.usersgroups;

import java.util.HashSet;
import java.util.Set;

import com.ibm.websphere.simplicity.AbstractSession;
import com.ibm.websphere.simplicity.Cell;
import com.ibm.websphere.simplicity.commands.wim.UpdateUser;
import com.ibm.websphere.simplicity.config.WIMUserAndGroupConfiguration;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;
import com.ibm.websphere.simplicity.provider.websphere.config.usersgroups.UserAttributes;

public class User { // This class should not implement Configurable. Changes are committed by WAS whether or not AdminConfig.save() is called
    
    private final static Class c = User.class;

    private String uniqueName;
    private UserAttributes attributes;
    private WIMUserAndGroupConfiguration parent;
    private Set<Group> groups;
    
    /**
     * Constructor. Meant for internal use only
     * 
     * @param uniqueName The unique name of the user
     */
    public User(String uniqueName, WIMUserAndGroupConfiguration parent) {
        this.uniqueName = uniqueName;
        this.parent = parent;
    }
    
    /**
     * Get the email adress for the user
     * 
     * @return The user's email address
     */
    public String getEmail() throws Exception {
        return getUserAttributes().getEmail();
    }
    
    /**
     * Set the email address for the user
     * 
     * @param email The new email address
     * @throws Exception
     */
    public void setEmail(String email) throws Exception {
        UserAttributes atts = new UserAttributes();
        atts.setEmail(email);
        updateUser(atts);
    }
    
    /**
     * Get the first name of the user
     * 
     * @return The user's first name
     */
    public String getFirstName() throws Exception {
        return getUserAttributes().getFirstName();
    }
    
    /**
     * Set the first name of the user
     * 
     * @param firstName The new first name
     * @throws Exception
     */
    public void setFirstName(String firstName) throws Exception {
        UserAttributes atts = new UserAttributes();
        atts.setFirstName(firstName);
        updateUser(atts);
    }
    
    /**
     * Get the last name of the user
     * 
     * @return The user's last name
     */
    public String getLastName() throws Exception {
        return getUserAttributes().getLastName();
    }
    
    /**
     * Set the last name of the user
     * 
     * @param lastName The new last name
     * @throws Exception
     */
    public void setLastName(String lastName) throws Exception {
        UserAttributes atts = new UserAttributes();
        atts.setLastName(lastName);
        updateUser(atts);
    }
    
    /**
     * Get the user ID of the user
     * 
     * @return The user ID
     */
    public String getUid() throws Exception {
        return getUserAttributes().getUserId();
    }
    
    /**
     * Set the user ID of the user. !!WARNING!! Chaning the user ID causes the unique name to change
     * as well.
     * 
     * @param uid The new user id
     * @throws Exception
     */
    public void setUid(String uid) throws Exception {
        UserAttributes atts = new UserAttributes();
        atts.setUserId(uid);
        updateUser(atts);
    }

    /**
     * Get the unique name for the user
     * 
     * @return The unique name
     */
    public String getUniqueName() {
        return uniqueName;
    }
    
    /**
     * Set the password for the user
     * 
     * @param password The new password for the user
     * @throws Exception
     */
    public void setPassword(String password) throws Exception {
        UserAttributes atts = new UserAttributes();
        atts.setPassword(password);
        updateUser(atts);
    }
    
    /**
     * Get the {@link WIMUserAndGroupConfiguration} parent
     * 
     * @return The parent of this class
     */
    public WIMUserAndGroupConfiguration getWIMManagement() {
        return this.parent;
    }
    
    /**
     * Get the groups to which this user is a member of
     * 
     * @return The groups that this user is a member of
     * @throws Exception
     */
    public Set<Group> getGroups() throws Exception {
        if(this.groups == null) {
            this.groups = new HashSet<Group>();
            Cell cell = this.parent.getSecurityConfiguration().getCell();
            AbstractSession session = cell.getActiveSession();
            HashSet<String> groups = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().getMembershipOfUser(cell, uniqueName, session);
            for(String group : groups)
                this.groups.add(this.parent.getGroupByUniqueName(group));
        }
        return this.groups;
    }

    /**
     * Get the attributes for a user
     * 
     * @return The {@link UserAttributes} containing the attributes for this user
     * @throws Exception
     */
    private UserAttributes getUserAttributes() throws Exception {
        final String method = "getUserAttributes";
        Log.entering(c, method);
        if(this.attributes == null) {
            Cell cell = this.parent.getSecurityConfiguration().getCell();
            AbstractSession session = cell.getActiveSession();
            this.attributes = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().getUserAttributes(cell, uniqueName, session);
        }
        return this.attributes;
    }
    
    /**
     * Update the user attributes
     * 
     * @param atts The attributes to update
     * @throws Exception
     */
    private void updateUser(UserAttributes atts) throws Exception {
        final String method = "updateUser";
        Log.entering(c, method, atts);
        
        UpdateUser task = new UpdateUser(this.uniqueName);
        if(atts.getEmail() != null)
            task.setMail(atts.getEmail());
        if(atts.getFirstName() != null)
            task.setCn(atts.getFirstName());
        if(atts.getLastName() != null)
            task.setSn(atts.getLastName());
        if(atts.getUserId() != null)
            task.setUid(atts.getUserId());
        if(atts.getPassword() != null) {
            task.setPassword(atts.getPassword());
            task.setConfirmPassword(atts.getPassword());
        }
        // results in a new unique name although it can't be set by the user
        Cell cell = this.parent.getSecurityConfiguration().getCell();
        this.uniqueName = (String)task.run(cell).getResult();
        
        this.attributes = null; // force a new load
        Log.exiting(c, method);
    }
}
