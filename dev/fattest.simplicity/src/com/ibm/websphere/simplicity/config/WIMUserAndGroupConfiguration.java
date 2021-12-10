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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ibm.websphere.simplicity.AbstractSession;
import com.ibm.websphere.simplicity.Cell;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.wim.CreateGroup;
import com.ibm.websphere.simplicity.commands.wim.CreateUser;
import com.ibm.websphere.simplicity.commands.wim.DeleteGroup;
import com.ibm.websphere.simplicity.commands.wim.DeleteUser;
import com.ibm.websphere.simplicity.commands.wim.SearchGroups;
import com.ibm.websphere.simplicity.commands.wim.SearchUsers;
import com.ibm.websphere.simplicity.config.usersgroups.Group;
import com.ibm.websphere.simplicity.config.usersgroups.User;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;

public class WIMUserAndGroupConfiguration { // This class should not implement Configurable. Changes are committed by WAS whether or not AdminConfig.save() is called
    
    private static final Class c = WIMUserAndGroupConfiguration.class;
    
    private SecurityConfiguration parent;
    private Set<Group> groups;
    private Set<User> users;
    
    protected WIMUserAndGroupConfiguration(SecurityConfiguration securityConfig) {
        this.parent = securityConfig;
    }
    
    /**
     * Get a specific group
     * 
     * @param uniqueName The unique name of the group to get
     * @return The group with the uniqeName or null if none exists
     * @throws Exception
     */
    public Group getGroupByUniqueName(String uniqueName) throws Exception {
        final String method = "getGroupByUniqueName";
        Log.entering(c, method, uniqueName);
        Group group = null;
        Set<Group> groups = getGroups();
        for(Group g : groups)
            if(g.getUniqueName().equals(uniqueName)) {
                group = g;
                break;
            }
        Log.exiting(c, method, group);
        return group;
    }
    
    /**
     * Get a specific group
     * 
     * @param cn The common name of the group to get
     * @return The first group with the common name or null of none exists
     * @throws Exception
     */
    public Group getGroupByCommonName(String cn) throws Exception {
        final String method = "getGroupByCommonName";
        Log.entering(c, method, cn);
        Group group = null;
        Set<Group> groups = getGroups();
        for(Group g : groups)
            if(g.getCommonName().equals(cn)) {
                group = g;
                break;
            }
        Log.exiting(c, method, group);
        return group;
    }
    
    /**
     * Get a specific user
     * 
     * @param uniqueName The unique name of the user
     * @return The user with the unique name or null if none exists
     * @throws Exception
     */
    public User getUserByUniqueName(String uniqueName) throws Exception {
        final String method = "getUserByUniqueName";
        Log.entering(c, method, uniqueName);
        User user = null;
        Set<User> users = getUsers();
        for(User u : users)
            if(u.getUniqueName().equals(uniqueName)) {
                user = u;
                break;
            }
        Log.exiting(c, method, user);
        return user;
    }
    
    /**
     * Get a specific user
     * 
     * @param uid The user id
     * @return The user with the user id or null if none exists
     * @throws Exception
     */
    public User getUserByUserID(String uid) throws Exception {
        final String method = "getUserByUserID";
        Log.entering(c, method, uid);
        User user = null;
        Set<User> users = getUsers();
        for(User u : users)
            if(u.getUid().equals(uid)) {
                user = u;
                break;
            }
        Log.exiting(c, method, user);
        return user;
    }
    
    /**
     * Search for users in the configuration by user ID
     * 
     * @param searchValue The user ID search String
     * @param timeLimit The max time to search for in milliseconds
     * @param countLimit The max number of users to return
     * @return
     * @throws Exception
     */
    public Set<User> searchUsersByUserID(String searchValue, Integer timeLimit, Integer countLimit) throws Exception {
        return searchUsers(searchValue, null, null, timeLimit, countLimit);
    }

    /**
     * Search for users in the configuration by user first name
     * 
     * @param searchValue The first name search String
     * @param timeLimit The max time to search for in milliseconds
     * @param countLimit The max number of users to return
     * @return
     * @throws Exception
     */
    public Set<User> searchUsersByFirstName(String searchValue, Integer timeLimit, Integer countLimit) throws Exception {
        return searchUsers(null, searchValue, null, timeLimit, countLimit);
    }

    /**
     * Search for users in the configuration by last name
     * 
     * @param searchValue The last name search String
     * @param timeLimit The max time to search for in milliseconds
     * @param countLimit The max number of users to return
     * @return
     * @throws Exception
     */
    public Set<User> searchUsersByLastName(String searchValue, Integer timeLimit, Integer countLimit) throws Exception {
        return searchUsers(null, null, searchValue, timeLimit, countLimit);
    }

    /**
     * Search for the users in the configuration
     * 
     * @param uid The user ID of the user
     * @param firstName The first name of the user
     * @param searchValue The search String
     * @param timeLimit The max time to search for in milliseconds
     * @param countLimit The max number of users to return
     * @return A Set of users that match the search criteria
     * @throws Exception
     */
    protected Set<User> searchUsers(String uid, String firstName, String lastName, Integer timeLimit, Integer countLimit) throws Exception {
        final String method = "searcUsers";
        Log.entering(c, method, new Object[]{uid, firstName, lastName, timeLimit, countLimit});
        
        Set<User> ret = new HashSet<User>();
        SearchUsers task = new SearchUsers();
        if(uid != null)
            task.setUid(uid);
        else if(firstName != null)
            task.setCn(firstName);
        else if(lastName != null)
            task.setSn(lastName);
        if(timeLimit != null)
            task.setTimeLimit(timeLimit);
        if(countLimit != null)
            task.setCountLimit(countLimit);
        Object result = task.run(this.parent.getCell()).getResult();
        List<String> users = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().getUserUniqueNames(result);
        for(String user : users) {
            Log.finer(c, method, user);
            User u = null;
            if(this.users != null)
                u = getUserByUniqueName(user);
            if(u == null) {
                Log.finer(c, method, "Creating new user.");
                u = new User(user, this);
            }
            ret.add(u);
        }
        
        Log.exiting(c, method, ret);
        return ret;
    }

    /**
     * Search the groups in the configuration
     * 
     * @param searchCommonName true to search based on the common name, false to search by description
     * @param searchValue The value to search for
     * @param timeLimit The max amount of time to search in milliseconds
     * @param countLimit The maximum number of groups to return
     * @return A Set of groups matching the search criteria
     * @throws Exception
     */
    public Set<Group> searchGroups(boolean searchCommonName, String searchValue, Integer timeLimit, Integer countLimit) throws Exception {
        final String method = "getGroups";
        Log.entering(c, method, new Object[]{searchCommonName, searchValue, timeLimit, countLimit});

        /*
         * It would be hard to check our internal cache here since the searchValue is a regular expression
         */
        
        if(searchValue == null || searchValue.length() == 0)
            throw new Exception("searchValue must be specified.");
        
        Log.finer(c, method, "Performing search.");
        SearchGroups searchGroups = new SearchGroups();
        if(searchCommonName)
            searchGroups.setCn(searchValue);
        else
            searchGroups.setDescription(searchValue);
        if(timeLimit != null)
            searchGroups.setTimeLimit(timeLimit);
        if(countLimit != null)
            searchGroups.setCountLimit(countLimit);
        Object result = searchGroups.run(this.parent.getCell()).getResult();
        
        Set<Group> ret = new HashSet<Group>();
        List<String> uniqueNames = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().getGroups(result);
        for(String uniqueName : uniqueNames) {
            Log.finer(c, method, uniqueName);
            Cell cell = this.parent.getCell();
            AbstractSession session = cell.getActiveSession();
            String description = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().getGroupDescription(cell, uniqueName, session);
            Log.finer(c, method, description);
            Group group = null;
            if(this.groups != null) // avoid infinite loop
                group = getGroupByUniqueName(uniqueName);
            if(group == null) {
                Log.finer(c, method, "Creating a new group.");
                if(description == null)
                    description = "";
                group = new Group(uniqueName, description, this);
            }
            ret.add(group);
        }
        
        Log.exiting(c, method, ret);
        return ret;
    }
    
    /**
     * Create a group
     * 
     * @param cn The common name of the group
     * @param description The group description
     * @return An {@link OperationResults} with the Group
     * @throws Exception
     */
    public OperationResults<Group> createGroup(String cn, String description) throws Exception {
        final String method = "createGroup";
        Log.entering(c, method, new Object[]{cn, description});
        
        if(cn == null || cn.length() == 0)
            throw new Exception("cn must be specified.");
        
        CreateGroup createGroup = new CreateGroup(cn);
        if(description != null)
            createGroup.setDescription(description);
        OperationResults<Object> result = createGroup.run(this.parent.getCell());
        
        OperationResults<Group> ret = new OperationResults<Group>();
        OperationResults.setOperationResults(ret, result);
        if(description == null) 
            description = "";
        Group group = new Group((String)result.getResult(), description, this);
        ret.setResult(group);
        this.groups.add(group);
        
        Log.exiting(c, method, ret);
        return ret;
    }
    
    /**
     * Create a user
     * 
     * @param userId The user id
     * @param password The password of the user
     * @param firstName The user's first name
     * @param lastName The user's last name
     * @param emailAddress The user's email address
     * @return An {@link OperationResults} with the new {@link User}
     * @throws Exception
     */
    public OperationResults<User> createUser(String userId, String password, String firstName, String lastName, String emailAddress) throws Exception {
        final String method = "createUser";
        Log.entering(c, method, new Object[]{userId, password, firstName, lastName, emailAddress});
        
        if(userId == null || userId.length() == 0)
            throw new Exception("UserID must be specified.");
        if(password == null || password.length() == 0)
            throw new Exception("Password must be specified.");
        if(firstName == null || firstName.length() == 0)
            throw new Exception("firstName must be specified.");
        if(lastName == null || lastName.length() == 0)
            throw new Exception("lastName must be specified.");
        
        CreateUser task = new CreateUser(firstName, password, lastName, userId);
        if(emailAddress != null)
            task.setMail(emailAddress);
        OperationResults<Object> result = task.run(this.parent.getCell());
        
        OperationResults<User> ret = new OperationResults<User>();
        OperationResults.setOperationResults(ret, result);
        User user = new User((String)result.getResult(), this);
        ret.setResult(user);
        this.users.add(user);
        
        Log.exiting(c, method, ret);
        return ret;
    }
    
    /**
     * Delete a group
     * 
     * @param uniqueName The unique name of the group to delete
     * @throws Exception
     */
    public void deleteGroup(String uniqueName) throws Exception {
        final String method = "deleteGroup";
        Log.entering(c, method, uniqueName);
        
        Group g = getGroupByUniqueName(uniqueName);
        if(g == null)
            throw new Exception("No group with name " + uniqueName + " exists.");
        
        DeleteGroup deleteGroup = new DeleteGroup(uniqueName);
        deleteGroup.run(this.parent.getCell());
        
        this.groups.remove(g);
        Log.exiting(c, method);
    }
    
    public void deleteUser(String uniqueName) throws Exception {
        final String method = "deleteUser";
        Log.entering(c, method, uniqueName);
        
        User u = getUserByUniqueName(uniqueName);
        if(u == null)
            throw new Exception("No user with name " + uniqueName + " exists.");
        
        DeleteUser task = new DeleteUser(uniqueName);
        task.run(this.parent.getCell());
        
        this.users.remove(u);
        Log.exiting(c, method);
    }
    
    /**
     * Get all the group
     * 
     * @return The groups in the config
     * @throws Exception
     */
    protected Set<Group> getGroups() throws Exception {
        if(this.groups == null)
            this.groups = searchGroups(true, "*", 300000, null);
        return this.groups;
    }
    
    /**
     * Get all the users
     * 
     * @return The users in the config
     * @throws Exception
     */
    protected Set<User> getUsers() throws Exception {
        if(this.users == null)
            this.users = searchUsers("*", null, null, 300000, null);
        return this.users;
    }
    
    /**
     * Get the {@link SecurityConfiguration} parent
     * 
     * @return The {@link SecurityConfiguration} parent
     */
    public SecurityConfiguration getSecurityConfiguration() {
        return this.parent;
    }
}
