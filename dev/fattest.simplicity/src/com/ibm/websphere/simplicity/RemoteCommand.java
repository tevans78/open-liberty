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

package com.ibm.websphere.simplicity;

import java.util.Properties;

import com.ibm.websphere.simplicity.log.Log;

/**
 * Represents a command that's running on a remote device. Completion of the
 * remote command is tracked as a Thread on the local JVM, so the current Thread
 * does not need to block until the remote command has completed (unless this
 * behavior is desired). Note that getting the result of a remote command
 * implies that the current Thread must block until the remote command has
 * completed.
 */
public abstract class RemoteCommand extends Thread {

    private static final Class c = RemoteCommand.class;
    
    protected String command;
    protected String[] parameters;
    protected String workDir;
    protected Properties envVars;
    protected Machine machine;
    
    private boolean started = false;
    private Exception thrown = null;
    private ProgramOutput output = null;
    
    /**
     * Constructor
     * 
     * @param command The command to execute
     * @param parameters The parameters to pass to the command
     * @param workDir The directory from which to execute the command
     * @param envVars The environment variables to set prior to executing the command
     * @param machine The {@link Machine} on which to execute the command
     */
    protected RemoteCommand(String command, String[] parameters, String workDir, Properties envVars, Machine machine) {
        this.command = command;
        this.parameters = parameters;
        this.workDir = workDir;
        this.envVars = envVars;
        this.started = false;
        this.machine = machine;
    }
    
    /**
     * Executes the command
     */
    public void run() {
        final String method = "run";
        Log.entering(c, method);
        this.started=true;
        try {
            this.output = this.execute();
        } catch (Exception e) {
            Log.error(c, method, e);
            this.thrown = e;
        }
        Log.finer(c, method, "command result: " + this.output);
        Log.exiting(c, method);
    }
    
    /**
     * Performs the work of actually executing the command. Blocks until
     * completion. Called by run().
     * 
     * @return the output of the command
     * @throws Exception
     */
    protected abstract ProgramOutput execute() throws Exception;

    /**
     * Gets the result of this command. If this command has not been invoked,
     * invoking this method will invoke the remote command. Blocks until the command
     * has completed execution.
     * 
     * @return The {@link ProgramOutput} of the command
     * @throws Exception
     */
    public final ProgramOutput getResult() throws Exception {
        try {
            Thread.sleep(1000);
        } catch(Exception e) {
        }
        if(!this.started) {
            this.start();
        }
        if(this.isAlive()) {
            try {
                this.join();
            } catch (InterruptedException e) {
                throw new Exception("This thread was interrupted while waiting for a remote command to finish", e);
            }
        }
        if(this.thrown!=null) {
            throw this.thrown;
        }
        if(this.output==null) {
            throw new Exception("The remote command output is null");
        } else {
            return this.output;         
        }
    }
    
}
