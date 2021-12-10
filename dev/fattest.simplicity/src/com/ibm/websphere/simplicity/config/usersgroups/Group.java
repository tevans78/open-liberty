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
import com.ibm.websphere.simplicity.commands.wim.AddMemberToGroup;
import com.ibm.websphere.simplicity.commands.wim.RemoveMemberFromGroup;
import com.ibm.websphere.simplicity.commands.wim.UpdateGroup;
import com.ibm.websphere.simplicity.config.WIMUserAndGroupConfiguration;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;

/**
 * This class represents a group in the federated repositories
 * virtual member manager.
 */
public class Group { // This class should not implement Configurable. Changes are committed by WAS whether or not AdminConfig.save() is called
    
    private static final Class c = Group.class;

    private Set<Group> groups;
    private Set<Group> groupMembers;
    private Set<User> userMembers;
    private String name;
    private String description;
    private String uniqueName;
    private WIMUserAndGroupConfiguration parent;
    
    /**
     * Constructor. Meant for internal use only.
     * 
     * @param name The name of the group
     * @param description The group description
     */
    public Group(String uniqueName, String description, WIMUserAndGroupConfiguration parent) {
        this.uniqueName = uniqueName;
        this.description = description;
        this.parent = parent;
    }
    
    /**
     * Get the groups to which this group is a member of
     * 
     * @return The groups that this group is a member of
     */
    public Set<Group> getGroups() throws Exception {
        if(this.groups == null) {
            this.groups = new HashSet<Group>();
            Cell cell = this.parent.getSecurityConfiguration().getCell();
            AbstractSession session = cell.getActiveSession();
            HashSet<String> groups = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().getMembershipOfGroup(cell, uniqueName, session);
            for(String group : groups)
                this.groups.add(this.parent.getGroupByUniqueName(group));
        }
        return this.groups;
    }
    
    /**
     * Get the unique name of this group
     * 
     * @return The unique name
     */
    public String getUniqueName() {
        return this.uniqueName;
    }
    
    /**
     * Get the common name of this group
     * 
     * @return The common name of the group
     */
    public String getCommonName() {
        if(this.name == null) {
            String temp = null;
            int startIndex = this.uniqueName.indexOf("cn=");
            temp = this.uniqueName.substring(startIndex + 3);
            this.name = temp.substring(0, temp.indexOf(","));
        }
        return this.name;
    }
    
    /**
     * Set the common name of this group
     * 
     * @param cn The common name to set
     * @throws Exception
     */
    public void setCommonName(String cn) throws Exception {
        updateGroup(cn, null);
        this.name = cn;
    }
    
    /**
     * Get the groups that are a member of this group
     * 
     * @return This group's group members
     */
    public Set<Group> getGroupMembers() throws Exception {
        if(this.groupMembers == null) {
            this.groupMembers = new HashSet<Group>();
            Cell cell = this.parent.getSecurityConfiguration().getCell();
            AbstractSession session = cell.getActiveSession();
            HashSet<String> groups = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().getGroupMembers(cell, uniqueName, session);
            for(String group : groups)
                this.groupMembers.add(this.parent.getGroupByUniqueName(group));
        }
        return this.groupMembers;
    }
    
    /**
     * Get the users that are a member of this group
     * 
     * @return This group's user members
     */
    public Set<User> getUserMembers() throws Exception {
        if(this.userMembers == null) {
            this.userMembers = new HashSet<User>();
            Cell cell = this.parent.getSecurityConfiguration().getCell();
            AbstractSession session = cell.getActiveSession();
            HashSet<String> users = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().getUserMembers(cell, uniqueName, session);
            for(String user : users)
                this.userMembers.add(this.parent.getUserByUniqueName(user));
        }
        return this.userMembers;
    }
    
    /**
     * Get the description of the group
     * 
     * @return The description of the group
     */
    public String getDescription() {
        return this.description;
    }
    
    /**
     * Set the description of the group
     * 
     * @param description The description to set
     * @throws Exception
     */
    public void setDescription(String description) throws Exception {
        updateGroup(null, description);
        this.description = description;
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
     * Add a new group member to this group.
     * 
     * @param memberUniqueName The unique name of the group to add 
     * @throws Exception
     */
    public void addNewGroupMember(String memberUniqueName) throws Exception {
        final String method = "addNewGroupMember";
        Log.entering(c, method, memberUniqueName);
        Group g = this.parent.getGroupByUniqueName(memberUniqueName); 
        if(g == null)
            throw new Exception("A group with unique name " + memberUniqueName + " does not exist.");
        if(getGroupMembers().contains(g)) {
            Log.finer(c, method, "Group " + memberUniqueName + " is already a member of this group.");
            Log.exiting(c, method);
            return;
        }
        AddMemberToGroup task = new AddMemberToGroup(this.uniqueName, g.getUniqueName());
        task.run(this.parent.getSecurityConfiguration().getCell());
        getGroupMembers().add(g);
        g.getGroups().add(this);
        Log.exiting(c, method);
    }
    
    /**
     * Add a new user member to this group
     * 
     * @param memberUniqueName The unique name of the user to add
     * @throws Exception
     */
    public void addNewUserMember(String memberUniqueName) throws Exception {
        final String method = "addNewUserMember";
        Log.entering(c, method, memberUniqueName);
        User u = this.parent.getUserByUniqueName(memberUniqueName); 
        if(u == null)
            throw new Exception("A user with unique name " + memberUniqueName + " does not exist.");
        if(getUserMembers().contains(u)) {
            Log.finer(c, method, "User " + memberUniqueName + " is already a member of this group.");
            Log.exiting(c, method);
            return;
        }
        AddMemberToGroup task = new AddMemberToGroup(this.uniqueName, u.getUniqueName());
        task.run(this.parent.getSecurityConfiguration().getCell());
        getUserMembers().add(u);
        u.getGroups().add(this);
        Log.exiting(c, method);
    }

    /**
     * Remove a group from this group
     * 
     * @param memberUniqueName The unique name of the group to remove
     * @throws Exception
     */
    public void removeGroupFromGroup(String memberUniqueName) throws Exception {
        final String method = "removeGroupFromGroup";
        Log.entering(c, method, memberUniqueName);
        Group g = this.parent.getGroupByUniqueName(memberUniqueName);
        if(g == null)
            throw new Exception("A group with unique name " + memberUniqueName + " does not exist.");
        if(!getGroupMembers().contains(g))
            throw new Exception("Group " + memberUniqueName + " is not a member of group " + this.uniqueName + ".");
        RemoveMemberFromGroup task = new RemoveMemberFromGroup(this.uniqueName, memberUniqueName);
        task.run(this.parent.getSecurityConfiguration().getCell());
        getGroupMembers().remove(g);
        g.getGroups().remove(this);
        Log.exiting(c, method);
    }
    
    /**
     * Remove a user from this group
     * 
     * @param memberUniqueName The unique name of the user to remove
     * @throws Exception
     */
    public void removeUserFromGroup(String memberUniqueName) throws Exception {
        final String method = "removeUserFromGroup";
        Log.entering(c, method, memberUniqueName);
        User u = this.parent.getUserByUniqueName(memberUniqueName);
        if(u == null)
            throw new Exception("A user with unique name " + memberUniqueName + " does not exist.");
        if(!getUserMembers().contains(u))
            throw new Exception("User " + memberUniqueName + " is not a member of group " + this.uniqueName + ".");
        RemoveMemberFromGroup task = new RemoveMemberFromGroup(this.uniqueName, memberUniqueName);
        task.run(this.parent.getSecurityConfiguration().getCell());
        getUserMembers().remove(u);
        u.getGroups().remove(this);
        Log.exiting(c, method);
    }
    
    /**
     * Update the group attributes
     * 
     * @param cn The common name to update to
     * @param description The description to update to
     * @throws Exception
     */
    private void updateGroup(String cn, String description) throws Exception {
        final String method = "updateGroup";
        Log.entering(c, method, new Object[]{cn, description});
        
        UpdateGroup task = new UpdateGroup(this.uniqueName);
        if(cn != null)
            task.setCn(cn);
        if(description != null)
            task.setDescription(description);
        this.uniqueName = (String)task.run(this.parent.getSecurityConfiguration().getCell()).getResult();
        
        Log.exiting(c, method);
    }
}
