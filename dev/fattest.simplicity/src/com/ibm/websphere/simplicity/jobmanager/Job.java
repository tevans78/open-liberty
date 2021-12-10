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

package com.ibm.websphere.simplicity.jobmanager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import com.ibm.websphere.simplicity.Node;

public abstract class Job {
	
	private String token;
	private JobType jobType;
	private Calendar activationDateTime;
	private Calendar expirationDateTime;
	private String description;
	private String email;
	private List<Node> targetList;
	private String group;
	private Properties jobParams = new Properties();
	private String username;
	private String password;
	private String executionWindow;
	private ExecutionWindowUnitType executionWindowUnit = ExecutionWindowUnitType.CONNECTION;
	
	public Job(JobType jobType) {
		this.jobType = jobType;
	}
	
	public String getToken() {
		return this.token;
	}
	
	public String getJobType() {
		return this.jobType.getJobName();
	}
	
	public Calendar getActivationDateTime() {
		return this.activationDateTime;
	}
	
	public void setActivationDateTime(Calendar value) {
		 this.activationDateTime = value;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public List<Node> getTargetList() {
		return this.targetList;
	}
	
	public void setTargetList(List<Node> value) {
		this.targetList = value;
	}
	
	public void setTarget(Node value) {
		List<Node> list = new ArrayList<Node>();
		list.add(value);
		setTargetList(list);
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Calendar getExpirationDateTime() {
		return expirationDateTime;
	}

	public void setExpirationDateTime(Calendar expirationDateTime) {
		this.expirationDateTime = expirationDateTime;
	}

	public String getExecutionWindow() {
		return executionWindow;
	}

	public void setExecutionWindow(String executionWindow) {
		this.executionWindow = executionWindow;
	}

	public ExecutionWindowUnitType getExecutionWindowUnit() {
		return executionWindowUnit;
	}

	public void setExecutionWindowUnit(ExecutionWindowUnitType executionWindowUnit) {
		this.executionWindowUnit = executionWindowUnit;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Properties getJobParams() {
		return jobParams;
	}
	
	public String toString() {
		return "Job:"+token;
	}
	
	protected void removeJobParam(String key) {
		jobParams.remove(key);
	}
	
	protected void removeSubJobParam(String sub, String key) {
		Properties p = (Properties)jobParams.get(sub);
		if (p != null) {
			p.remove(key);
			if (p.size() == 0)
				removeJobParam(sub);
		}
	}
	
	protected String getJobParam(String key) {
		return jobParams.getProperty(key);
	}
	
	protected String getSubParam(String sub, String key) {
		Properties p = (Properties)jobParams.get(sub);
		if (p != null)
			return p.getProperty(key);
		return null;
	}

	protected void setJobParam(String key, String value) {
		this.jobParams.setProperty(key, value);
	}
	
	protected void setSubJobParam(String sub, String key, String value) {
		Properties p = (Properties)jobParams.get(sub);
		if (p == null) {
			p = new Properties();
			jobParams.put(sub, p);
		}
		p.setProperty(key, value);
	}

	protected void setJobParams(Properties jobParams) {
		this.jobParams.putAll(jobParams);
	}
	
	protected void setProperty(String key, String value) throws Exception {
		if (key.equalsIgnoreCase("activationDateTime"))
			this.setActivationDateTime(stringToCalendar(value));
		else if (key.equalsIgnoreCase("expirationDateTime"))
			this.setExpirationDateTime(stringToCalendar(value));
		else if (key.equalsIgnoreCase("jobToken"))
			this.setToken(value);
		else if (key.equalsIgnoreCase("description"))
			this.setDescription(value);
	}
	
	private Calendar stringToCalendar(String value) throws Exception {
		Date d = Jobs.dateFormatter.parse(value);
		Calendar ret = GregorianCalendar.getInstance();
		ret.setTime(d);
		return ret;
	}

}
