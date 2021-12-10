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

import java.util.ArrayList;
import java.util.List;

import javax.management.Notification;

/**
 * Represents the result of an operation. This might be a WebSphere operation result or a machine
 * command line operation result.
 */
public class OperationResults <T> {
	
	private boolean success;
	private List<Notification> notifications = new ArrayList<Notification>();
	private String systemOut = "";
	private String systemErr = "";
	private long startedAt;
	private long duration;
    private T result;
	
    /**
     * No argument Constructor
     */
	public OperationResults() {
		startedAt = System.currentTimeMillis();
	}
	
    /**
     * Boolean constructor
     * 
     * @param success true for a successful operation
     */
	public OperationResults(boolean success) {
		this.success = success;
	}
	
    /**
     * Set the success value of the operation
     * @param success true if the operation was successful
     */
	public void setSuccess(boolean success) {
		duration = System.currentTimeMillis() - startedAt;
		this.success = success;
	}
	
	/**
	 * Obtains a semi-accurate duration counter for the operation performed.
	 * @return The duration of the operation in milliseconds.
	 */
	public long getDuration() {
		return this.duration;
	}
	
	/**
	 * Set the duration
	 * @param duration The duration of the operation in milliseconds
	 */
	protected void setDuration(long duration) {
		this.duration = duration;
	}
	
    /**
     * Set the value written to system out during the operation
     * 
     * @param systemOut value written to system out
     */
	public void setSystemOut(String systemOut) {
		this.systemOut = systemOut;
	}

    /**
     * Set the value written to system err during the operation
     * 
     * @param systemErr value written to system err
     */
	public void setSystemErr(String systemErr) {
		this.systemErr = systemErr;
	}
	
    /**
     * Add a <code>javax.management.Notification</code> Object received during the operation
     * 
     * @param n The <code>javax.management.Notification</code> Object
     */
	public void addNotification(Notification n) {
		this.notifications.add(n);
	}
	
    /**
     * Add a <code>List</code> of <code>javax.management.Notification</code> Objects received
     * during the operation
     * 
     * @param list The <code>List</code> of <code>javax.management.Notification</code> Objects
     */
	public void addNotifications(List<Notification> list) {
		this.notifications.addAll(list);
	}

	/**
	 * @return True if the operation succeeded.
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @return A list of notifications received during the operation.
	 */
	public List<Notification> getNotifications() {
		return notifications;
	}

	/**
	 * NOTE: Not available for JMX operations.
	 * @return Any System.out output generated during the operation.
	 */
	public String getSystemOut() {
		return systemOut;
	}

	/**
	 * NOTE: Not available for JMX operations.
	 * @return Any System.err output generated during the operation.
	 */
	public String getSystemErr() {
		return systemErr;
	}

    /**
     * Get the reuslt of the operation.
     * 
     * @return The result
     */
    public T getResult() {
        return this.result;
    }
    
    /**
     * Set the operation result
     * 
     * @param result The result to set
     */
    public void setResult(T result) {
        this.result = result;
    }
    
    /**
     * Copy all the data from one {@link OperationResults} instance to another except for the result itself. 
     * 
     * @param target The {@link OperationResults} to copy the data to
     * @param source The {@link OperationResults} to copy the data from
     */
    @SuppressWarnings("unchecked")
    public static void setOperationResults(OperationResults target, OperationResults source) {
        target.setSuccess(source.isSuccess());
        target.setSystemErr(source.getSystemErr());
        target.setSystemOut(source.getSystemOut());
        target.addNotifications(source.getNotifications());
        target.setDuration(source.getDuration());
    }
}
