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

package com.ibm.websphere.simplicity.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.ibm.websphere.simplicity.ConfigIdentifier;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.Scope;

/**
 * This class represents a generic AdminTask.
 * It can be used to execute any existing WAS AdminTask Object.
 * 
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 */
public class GenericAdminTask extends GenericCommand {
    
    protected Properties parameters = new Properties();
    protected List<Command> steps;
    protected Object target;
    
    /**
     * Constructor
     * @param name The task name
     */
    public GenericAdminTask(String name) {
        super(name);
    }
    
    /**
     * Constructor
     * 
     * @param name The task name
     * @param target The task target. This type of Object depends on the particular task. If an
     *            ObjectName or wsadmin config ID is required, pass in the corresponding
     *            {@link ConfigIdentifier}
     */
    public GenericAdminTask(String name, Object target) {
        super(name);
        this.target = target;
    }
    
    /**
     * Executes the command against the specified scope.
     * @param scope The scope to execute the admin task against
     * @return The results of the task
     */
    public OperationResults<Object> run(Scope scope) throws Exception {
        return super.run(scope);
    }

    /**
     * This class represents a generic AdminTask command step. It can be used to create command
     * steps for {@link GenericAdminTask}s
     */
    public static class GenericCommandStep extends GenericCommand {
        
        /**
         * Constructor
         * @param name The command step name
         */
        public GenericCommandStep(String name) {
            super(name);
        }
        
        /**
         * Constructor
         * 
         * @param name The command step name
         * @param target The command step target. This type of Object depends on the particular task. If an
         *            ObjectName or wsadmin config ID is required, pass in the corresponding
         *            {@link ConfigIdentifier}
         */
        public GenericCommandStep(String name, Object target) {
            super(name);
            this.target = target;
        }
        
    }
    
}

class GenericCommand extends Command {

    protected Properties parameters = new Properties();
    protected List<Command> steps;
    protected Object target;
    
    public GenericCommand(String name) {
        super(name);
    }
    
    public GenericCommand(String name, Object target) {
        super(name);
        this.target = target;
    }
    
    /**
     * Set the command target
     * 
     * @param target The command target. This type of Object depends on the particular task. If an
     *            ObjectName or wsadmin config ID is required, pass in the corresponding
     *            {@link ConfigIdentifier}
     */
    public void setTarget(Object target) {
        this.target = target;
    }
    
    /**
     * Add a parameter for the command
     * 
     * @param key The parameter name
     * @param value The paramter value. The type of the value depends on the parameter. Example
     *            types are String, Boolean, Integer, and Properties
     */
    public void addParameter(String key, Object value) {
        parameters.put(key, value);
    }
    
    /**
     * Add a command step to the AdminTask
     * @param commandStep The command step to execute
     */
    public void addCommandStep(com.ibm.websphere.simplicity.commands.GenericAdminTask.GenericCommandStep commandStep) {
        if(steps == null)
            steps = new ArrayList<Command>();
        steps.add(commandStep);
    }

    @Override
    public Properties __getParameters() {
        return this.parameters;
    }

    @Override
    public List<Command> __getSteps() {
       return this.steps;
    }

    @Override
    public Object __getTarget() {
        return this.target;
    }

}
