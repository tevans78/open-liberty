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

package com.ibm.websphere.simplicity.commands.wsschedule;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Modify a schedule.
 *   'frequency': Amount of time in days between scheduled runs.
 *   'dayOfWeek': Specifies the day of the week when the schedule is to run.  Valid values include 1-7.
 *   'hour': Specifies the hour of the day when the schedule is to run.  Valid values include 0-23.
 *   'minute': Specifies the minute of the hour when then schedule is to run. Valid values include 0-59.
 *   'name': Specifies the schedule name.
 *   'nextStartDate': Specifies the scheduler's next start date.
 * The required parameters are found in the constructor.
 */
public class ModifyWSSchedule extends Command {

	private Integer frequency;
	private Integer dayOfWeek;
	private Integer hour;
	private Integer minute;
	private String name;
	private Long nextStartDate;

	public ModifyWSSchedule(String name) {
		super("modifyWSSchedule");
		this.name = name;
	}

	/**
	 * Amount of time in days between scheduled runs.
	 */
	public Integer getFrequency() {
		return this.frequency;
	}

	/**
	 * Amount of time in days between scheduled runs.
	 */
	public void setFrequency(Integer value) {
		this.frequency = value;
	}

	/**
	 * Specifies the day of the week when the schedule is to run.  Valid values include 1-7.
	 */
	public Integer getDayOfWeek() {
		return this.dayOfWeek;
	}

	/**
	 * Specifies the day of the week when the schedule is to run.  Valid values include 1-7.
	 */
	public void setDayOfWeek(Integer value) {
		this.dayOfWeek = value;
	}

	/**
	 * Specifies the hour of the day when the schedule is to run.  Valid values include 0-23.
	 */
	public Integer getHour() {
		return this.hour;
	}

	/**
	 * Specifies the hour of the day when the schedule is to run.  Valid values include 0-23.
	 */
	public void setHour(Integer value) {
		this.hour = value;
	}

	/**
	 * Specifies the minute of the hour when then schedule is to run. Valid values include 0-59.
	 */
	public Integer getMinute() {
		return this.minute;
	}

	/**
	 * Specifies the minute of the hour when then schedule is to run. Valid values include 0-59.
	 */
	public void setMinute(Integer value) {
		this.minute = value;
	}

	/**
	 * Specifies the schedule name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Specifies the schedule name.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Specifies the scheduler's next start date.
	 */
	public Long getNextStartDate() {
		return this.nextStartDate;
	}

	/**
	 * Specifies the scheduler's next start date.
	 */
	public void setNextStartDate(Long value) {
		this.nextStartDate = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.frequency != null) {
			ret.put("frequency", this.frequency);
		}
		if (this.dayOfWeek != null) {
			ret.put("dayOfWeek", this.dayOfWeek);
		}
		if (this.hour != null) {
			ret.put("hour", this.hour);
		}
		if (this.minute != null) {
			ret.put("minute", this.minute);
		}
		ret.put("name", this.name);
		if (this.nextStartDate != null) {
			ret.put("nextStartDate", this.nextStartDate);
		}
		return ret;
	}

	public Object __getTarget() {
		return null;
	}

	public List<Command> __getSteps() {
		return null;
	}

	/**
	 * Executes the command against the specified scope.
	 */
	public OperationResults<Object> run(Scope scope) throws Exception {
		return super.run(scope);
	}

}
