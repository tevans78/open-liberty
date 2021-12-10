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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Map.Entry;

import javax.management.Attribute;
import javax.management.AttributeList;

import com.ibm.websphere.simplicity.JobManager;
import com.ibm.websphere.simplicity.Node;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.administrativejobs.DeleteJob;
import com.ibm.websphere.simplicity.commands.administrativejobs.GetJobTargetHistory;
import com.ibm.websphere.simplicity.commands.administrativejobs.GetJobTargetStatus;
import com.ibm.websphere.simplicity.commands.administrativejobs.GetJobTargets;
import com.ibm.websphere.simplicity.commands.administrativejobs.GetJobTypeMetadata;
import com.ibm.websphere.simplicity.commands.administrativejobs.GetJobTypes;
import com.ibm.websphere.simplicity.commands.administrativejobs.GetOverallJobStatus;
import com.ibm.websphere.simplicity.commands.administrativejobs.QueryJobs;
import com.ibm.websphere.simplicity.commands.administrativejobs.ResumeJob;
import com.ibm.websphere.simplicity.commands.administrativejobs.SubmitJob;
import com.ibm.websphere.simplicity.commands.administrativejobs.SuspendJob;
import com.ibm.websphere.simplicity.commands.jobmanagernode.GetContexts;
import com.ibm.websphere.simplicity.commands.jobmanagernode.GetManagedNodeKeys;
import com.ibm.websphere.simplicity.commands.jobmanagernode.GetManagedNodeProperties;
import com.ibm.websphere.simplicity.commands.jobmanagernode.GetManagedResourceProperties;
import com.ibm.websphere.simplicity.commands.jobmanagernode.GetManagedResourcePropertyKeys;
import com.ibm.websphere.simplicity.commands.jobmanagernode.GetManagedResourceTypes;
import com.ibm.websphere.simplicity.commands.jobmanagernode.ModifyManagedNodeProperties;
import com.ibm.websphere.simplicity.commands.jobmanagernode.QueryManagedNodes;
import com.ibm.websphere.simplicity.commands.jobmanagernode.QueryManagedResources;
import com.ibm.websphere.simplicity.commands.jobmanagerupkeep.BackupJobManager;
import com.ibm.websphere.simplicity.log.Log;

public class Jobs {
	
	private static Class c = Jobs.class;
	// TODO Without a timezone in the datestamp, how does it know what the actual target time is?
	protected static String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";
	protected static SimpleDateFormat dateFormatter = new java.text.SimpleDateFormat(DATE_FORMAT);
	
	private JobManager manager = null;
	
	public Jobs(JobManager manager) {
		this.manager = manager;
	}

	/**
	 * Resumes a previously submitted job.
	 * @param job A previously submitted job instance.
	 * @throws Exception
	 */
	public void resumeJob(Job job) throws Exception {
		Log.entering(c, "resumeJob", job);
		ResumeJob resume = new ResumeJob(job.getToken());
		resume.run(manager);
		Log.exiting(c, "resumeJob");
	}
	
	/**
	 * Submits the specified job to the job manager.
	 * @param job An instance that implements the Job class.
	 * @return The job token.
	 * @throws Exception
	 */
	public void submitJob(Job job) throws Exception {
		Log.entering(c, "submitJob", job);
		SubmitJob submit = new SubmitJob(job.getJobType());
		
		Calendar datetime = job.getActivationDateTime();
		if (datetime != null)
			submit.setActivationDateTime(dateFormatter.format(datetime.getTime()));
		datetime = job.getExpirationDateTime();
		if (datetime != null)
			submit.setExpirationDateTime(dateFormatter.format(datetime.getTime()));
		submit.setDescription(job.getDescription());
		submit.setEmail(job.getEmail());
		submit.setExecutionWindow(job.getExecutionWindow());
		ExecutionWindowUnitType type = job.getExecutionWindowUnit();
		if (type != null)
			submit.setExecutionWindowUnit(type.name());
		submit.setGroup(job.getGroup());
		submit.setJobParams(job.getJobParams());
		submit.setJobType(job.getJobType());
		submit.setPassword(job.getPassword());
		submit.setUsername(job.getUsername());
		
		List<Node> nodes = job.getTargetList();
		if (nodes != null) {
			String[] targets = new String[nodes.size()];
			for (int i=0; i < nodes.size(); i++)
				targets[i] = nodes.get(i).getAlias();
			submit.setTargetList(targets);
		}
		
		OperationResults<Object> result = submit.run(manager);
		String token = (String)result.getResult();
		job.setToken(token);
		Log.exiting(c, "submitJob", token);
	}

	/**
	 * Suspends a previously submitted job.
	 * @param job A previously submitted job.
	 * @throws Exception
	 */
	public void suspendJob(Job job) throws Exception {
		Log.entering(c, "suspendJob", job);
		SuspendJob suspend = new SuspendJob(job.getToken());
		suspend.run(manager);
		Log.exiting(c, "suspendJob");
	}
	
	/**
	 * Deletes a previously submitted job.
	 * @param job A previously submitted job.
	 * @throws Exception
	 */
	public void deleteJob(Job job) throws Exception {
		Log.entering(c, "deleteJob", job);
		DeleteJob delete = new DeleteJob(job.getToken());
		delete.run(manager);
		Log.exiting(c, "deleteJob");
	}
	
	/**
	 * Return submitted job information based on a supplied query.  The query can
	 * contain any combination of the following fields: jobToken, group, description,
	 * activationDataTime, expirationDateTime, state, target.  The fields can be
	 * combined using the boolean operand AND.
	 * <p>
	 * Wildcards ("*") are permitted for all fields except jobToken.  A few examples
	 * of queries:
	 * <p>
	 * jobTarget = *<br>
	 * state = NOT_ATTEMPTED<br>
	 * description != NULL AND state = SUCCESS
	 * @param query String representation of the search query.
	 * @param maxResults Maximum number of matches to return.
	 * @return A list of jobs that match the query.
	 * @throws Exception
	 */
	public List<Job> queryJobs(String query, int maxResults) throws Exception {
		Log.entering(c, "queryJobs", new Object[] { query, maxResults });
		QueryJobs queryjob = new QueryJobs(query, maxResults);
		OperationResults<Object> result = queryjob.run(manager);
		
		AttributeList attribs = (AttributeList)result.getResult();
		List<Job> ret = new ArrayList<Job>();
		// Find the "result" attribute
		Iterator<Object> it = attribs.iterator();
		Attribute resultset = null;
		while (it.hasNext()) {
			Attribute attrib = (Attribute)it.next();
			if (attrib.getName().equalsIgnoreCase("result")) {
				resultset = attrib;
				break;
			}
		}
		// Now iterate through Properties containing results
		ArrayList<HashMap<String, String>> list = (ArrayList<HashMap<String, String>>)resultset.getValue();
		for (HashMap<String, String> p : list) {
			Job job = new GenericJob();
			for (Entry<String, String> entry : p.entrySet()) {
				job.setProperty((String)entry.getKey(), (String)entry.getValue());
			}
			ret.add(job);
		}
		
		Log.exiting(c, "queryJobs", ret);
		return ret;
	}
	
	/**
	 * Backs up the job manager database to a specified location.
	 * @throws Exception
	 */
	public void backup() throws Exception {
		Log.entering(c, "backup");
		BackupJobManager bkup = new BackupJobManager();
		bkup.run(manager);
		Log.exiting(c, "backup");
	}

	/**
	 * Backs up the job manager database to a specified location.
	 * @param fileLocation Target backup location.
	 * @throws Exception
	 */
	public void backup(String fileLocation) throws Exception {
		BackupJobManager bkup = new BackupJobManager();
		bkup.setLocation(fileLocation);
		bkup.run(manager);
	}
	
	/**
	 * Backs up the job manager database to a specified location.
	 * @param fileLocation Target backup location.
	 * @param forceOverwrite If the target file already exists, force the new file to overwrite the existing file.
	 * @throws Exception
	 */
	public void backup(String fileLocation, boolean forceOverwrite) throws Exception {
		BackupJobManager bkup = new BackupJobManager();
		bkup.setLocation(fileLocation);
		bkup.setForce(forceOverwrite);
		bkup.run(manager);
	}
	
	/**
	 * Get all contexts in the management model.  For example: "application", "node/server".
	 * @return A list of contexts in the management model.
	 * @throws Exception
	 */
	public List<String> getContexts() throws Exception {
		GetContexts ctx = new GetContexts();
		OperationResults<Object> result = ctx.run(manager);
		List<String> ret = (List<String>)result.getResult();
		return ret;
	}
	
	/**
	 * Get properties keys associated with a specific managed node.
	 * @return TODO
	 * @throws Exception
	 */
	public List<String> getManagedNodeKeys() throws Exception {
		return getManagedNodeKeys(null);
	}
	
	/**
	 * Get properties keys associated with a specific managed node.
	 * @param managedNodeName Name of the managed node.
	 * @return TODO
	 * @throws Exception
	 */
	public List<String> getManagedNodeKeys(String managedNodeName) throws Exception {
		GetManagedNodeKeys keys = new GetManagedNodeKeys();
		keys.setManagedNodeName(managedNodeName);
		OperationResults<Object> result = keys.run(manager);
		List<String> ret = (List<String>)result.getResult();
		return ret;
	}

	/**
	 * TODO
	 * @return TODO
	 * @throws Exception
	 */
	public List<Properties> getManagedNodeProperties() throws Exception {
		return getManagedNodeProperties(null);
	}

	/**
	 * TODO
	 * @param managedNodeNameList List of managed nodes.
	 * @return TODO
	 * @throws Exception
	 */
	public List<Properties> getManagedNodeProperties(List<Node> managedNodeList) throws Exception {
		String[] managedNodeNameList = nodeListToTargetList(managedNodeList);
		GetManagedNodeProperties props = new GetManagedNodeProperties();
		props.setManagedNodeNameList(managedNodeNameList);
		OperationResults<Object> result = props.run(manager);
		List<Properties> ret = (List<Properties>)result.getResult();
		return ret;
	}
	
	/**
	 * Get properties associated with a specific managed resource.
	 * @param resourceIdList List of identifiers associated with the resource.
	 * @return TODO
	 * @throws Exception
	 */
	public List<Properties> getManagedResourceProperties(String[] resourceIdList) throws Exception {
		GetManagedResourceProperties gmrp = new GetManagedResourceProperties(resourceIdList);
		OperationResults<Object> result = gmrp.run(manager);
		List<Properties> ret = (List<Properties>)result.getResult();
		return ret;
	}
	
	/**
	 * Get property keys associated with an specific managed resource.
	 * @param resourceType Type of resource on which to query.
	 * @return TODO
	 * @throws Exception
	 */
	public List<Object> getManagedResourcePropertyKeys(String resourceType) throws Exception {
		GetManagedResourcePropertyKeys gmrpk = new GetManagedResourcePropertyKeys(resourceType);
		OperationResults<Object> result = gmrpk.run(manager);
		List<Object> ret = (List<Object>)result.getResult();
		return ret;
	}

	/**
	 * Retrieves managed resource types, such as "application", "server", and so on.
	 * @return A list of managed resource types.
	 * @throws Exception
	 */
	public List<String> getManagedResourceTypes() throws Exception {
		GetManagedResourceTypes gmrt = new GetManagedResourceTypes();
		OperationResults<Object> result = gmrt.run(manager);
		List<String> ret = (List<String>)result.getResult();
		return ret;
	}

	/**
	 * Modify properties associated with a specific managed node.
	 * @param managedNodeName Name of the managed node.
	 * @param managedNodeProps Retrieve properties associated with managed resources.
	 * @throws Exception
	 */
	public void setManagedNodeProperties(String managedNodeName, Properties managedNodeProps) throws Exception {
		setManagedNodeProperties(managedNodeName, managedNodeProps, null);
	}
	
	/**
	 * Modify properties associated with a specific managed node.
	 * @param managedNodeName Name of the managed node.
	 * @param managedNodeProps Retrieve properties associated with managed resources.
	 * @param replace Flag to either replace the existing properties or not. The default is false.
	 * @throws Exception
	 */
	public void setManagedNodeProperties(String managedNodeName, Properties managedNodeProps, Boolean replace) throws Exception {
		ModifyManagedNodeProperties mmnp = new ModifyManagedNodeProperties(managedNodeName, managedNodeProps);
		mmnp.setReplace(replace);
		mmnp.run(manager);
	}
	
	/**
	 * Queries for all the managed nodes registered with the job manager.
	 * @param maxReturn Maximum size of data retrieved.
	 * @return TODO
	 * @throws Exception
	 */
	public AttributeList queryManagedNodes(int maxReturn) throws Exception {
		return queryManagedNodes(maxReturn, null);
	}

	/**
	 * Queries for all the managed nodes registered with the job manager.
	 * @param maxReturn Maximum size of data retrieved.
	 * @param query String representation of the search query.
	 * @return TODO
	 * @throws Exception
	 */
	public AttributeList queryManagedNodes(int maxReturn, String query) throws Exception {
		return queryManagedNodes(maxReturn, query, null);
	}

	/**
	 * Queries for all the managed nodes registered with the job manager.
	 * @param maxReturn Maximum size of data retrieved.
	 * @param query String representation of the search query.
	 * @param validate Validate query string.
	 * @return TODO
	 * @throws Exception
	 */
	public AttributeList queryManagedNodes(int maxReturn, String query, Boolean validate) throws Exception {
		QueryManagedNodes qmn = new QueryManagedNodes(maxReturn);
		qmn.setQuery(query);
		qmn.setValidate(validate);
		OperationResults<Object> result = qmn.run(manager);
		AttributeList ret = (AttributeList)result.getResult();
		return ret;
	}
	
	/**
	 * Queries for all managed resources.
	 * @param maxReturn Maximum size of data retrieved.
	 * @return TODO
	 * @throws Exception
	 */
	public List<Object> queryManagedResources(int maxReturn) throws Exception {
		return queryManagedResources(maxReturn, null);
	}

	/**
	 * Queries for all managed resources.
	 * @param maxReturn Maximum size of data retrieved.
	 * @param query String representation of the search query.
	 * @return TODO
	 * @throws Exception
	 */
	public List<Object> queryManagedResources(int maxReturn, String query) throws Exception {
		return queryManagedResources(maxReturn, query, null);
	}
	
	/**
	 * Queries for all managed resources.
	 * @param maxReturn Maximum size of data retrieved.
	 * @param query String representation of the search query.
	 * @param validate Validate query string.
	 * @return TODO
	 * @throws Exception
	 */
	public List<Object> queryManagedResources(int maxReturn, String query, Boolean validate) throws Exception {
		QueryManagedResources qmr = new QueryManagedResources(maxReturn);
		qmr.setQuery(query);
		qmr.setValidate(validate);
		OperationResults<Object> result = qmr.run(manager);
		List<Object> ret = (List<Object>)result.getResult();
		return ret;
	}

	/**
	 * This command is used to get the job target history for a job.
	 * @param job A previously submitted job.
	 * @param managedNodeName Managed node name for the target.
	 * @param maxReturn Maximum number of matches to return.
	 * @return TODO
	 * @throws Exception
	 */
	public List<Object> getJobTargetHistory(Job job, Node managedNode, int maxReturn) throws Exception {
		return getJobTargetHistory(job, managedNode, maxReturn, null, null, null);
	}

	/**
	 * This command is used to get the job target history for a job.
	 * @param job A previously submitted job.
	 * @param managedNodeName Managed node name for the target.
	 * @param maxReturn Maximum number of matches to return.
	 * @param startingTime Include all the time window starting with the specified time.
	 * @return TODO
	 * @throws Exception
	 */
	public List<Object> getJobTargetHistory(Job job, Node managedNode, int maxReturn, Calendar startingTime) throws Exception {
		return getJobTargetHistory(job, managedNode, maxReturn, startingTime, null, null);
	}
	
	/**
	 * This command is used to get the job target history for a job.
	 * @param job A previously submitted job.
	 * @param managedNodeName Managed node name for the target.
	 * @param maxReturn Maximum number of matches to return.
	 * @param startingTime Include all the time window starting with the specified time.
	 * @param endingTime Include all the time window ending with the specified time.
	 * @return TODO
	 * @throws Exception
	 */
	public List<Object> getJobTargetHistory(Job job, Node managedNode, int maxReturn, Calendar startingTime, Calendar endingTime) throws Exception {
		return getJobTargetHistory(job, managedNode, maxReturn, startingTime, endingTime, null);
	}
	
	/**
	 * This command is used to get the job target history for a job.
	 * @param job A previously submitted job.
	 * @param managedNodeName Managed node name for the target.
	 * @param maxReturn Maximum number of matches to return.
	 * @param startingTime Include all the time window starting with the specified time.
	 * @param endingTime Include all the time window ending with the specified time.
	 * @param ascending Returns the results in ascending order if set to true.
	 * @return TODO
	 * @throws Exception
	 */
	public List<Object> getJobTargetHistory(Job job, Node managedNode, int maxReturn, Calendar startingTime, Calendar endingTime, Boolean ascending) throws Exception {
		GetJobTargetHistory gjth = new GetJobTargetHistory(job.getToken(), managedNode.getAlias(), maxReturn);
		if (startingTime != null)
			gjth.setStartingTime(dateFormatter.format(startingTime.getTime()));
		if (endingTime != null)
			gjth.setEndingTime(dateFormatter.format(endingTime.getTime()));
		gjth.setAscending(ascending);
		
		OperationResults<Object> result = gjth.run(manager);
		List<Object> ret = (List<Object>)result.getResult();
		return ret;
	}

	/**
	 * This command is used to get targets for a job.  The targets for the job may have been unregistered, or deleted.
	 * @param job A previously submitted job.
	 * @return TODO
	 * @throws Exception
	 */
	public List<Object> getJobTargets(Job job) throws Exception {
		GetJobTargets gjt = new GetJobTargets(job.getToken());
		OperationResults<Object> result = gjt.run(manager);
		List<Object> ret = (List<Object>)result.getResult();
		return ret;
	}
	
	/**
	 * This command is used to get the latest job target status for a job.
	 * @param job A previously submitted job.
	 * @return TODO
	 * @throws Exception
	 */
	public List<JobTargetStatusEntry> getJobTargetStatus(Job job) throws Exception {
		return getJobTargetStatus(job, null);
	}
	
	/**
	 * This command is used to get the latest job target status for a job.
	 * @param job A previously submitted job.
	 * @param managedNodeNames List of managed nodes as the target(s).
	 * @return TODO
	 * @throws Exception
	 */
	public List<JobTargetStatusEntry> getJobTargetStatus(Job job, List<Node> managedNodeList) throws Exception {
		GetJobTargetStatus gjts = new GetJobTargetStatus(job.getToken());
		if (managedNodeList != null) {
			String[] managedNodeNames = nodeListToTargetList(managedNodeList);
			gjts.setTargetList(managedNodeNames);
		}
		OperationResults<Object> result = gjts.run(manager);
		Properties list = (Properties)result.getResult();
		
		List<JobTargetStatusEntry> ret = new ArrayList<JobTargetStatusEntry>();
		for (Entry<Object, Object> entry : list.entrySet()) {
			JobTargetStatusEntry item = new JobTargetStatusEntry(entry, this.manager);
			ret.add(item);
		}
		return ret;
	}

	/**
	 * This command is used to get the metadata associated with a jobType.
	 * @param jobType The job type whose metadata will be retrieved.
	 * @return TODO
	 * @throws Exception
	 */
	public JobMetadata getJobTypeMetadata(JobType jobType) throws Exception {
		List<JobType> list = new ArrayList<JobType>();
		list.add(jobType);
		List<JobMetadata> ret = getJobTypeMetadata(list);
		if (ret.size() > 0)
			return ret.get(0);
		return null;
	}
	
	/**
	 * This command is used to get the metadata associated with a jobType.
	 * @param jobTypes The job types whose metadata will be retrieved.
	 * @return TODO
	 * @throws Exception
	 */
	public List<JobMetadata> getJobTypeMetadata(List<JobType> jobTypes) throws Exception {
		String[] list = new String[jobTypes.size()];
		int i = 0;
		for (JobType jt : jobTypes)
			list[i++] = jt.getJobName();
		GetJobTypeMetadata gjtm = new GetJobTypeMetadata(list);
		OperationResults<Object> result = gjtm.run(manager);
		List<AttributeList> attriblist = (List<AttributeList>)result.getResult();
		
		List<JobMetadata> ret = new ArrayList<JobMetadata>();
		for (AttributeList attributes : attriblist) {
			ret.add(new JobMetadata(attributes));
		}
		
		return ret;
	}
	
	/**
	 * This command is used to get the supported job types for a managed node.
	 * @return A list of supported job types.
	 * @throws Exception
	 */
	public List<JobType> getJobTypes() throws Exception {
		GetJobTypes gjt = new GetJobTypes();
		OperationResults<Object> result = gjt.run(manager);
		List<JobType> ret = convertToJobTypes((String[])result.getResult());
		return ret;
	}

	/**
	 * This command is used to get the supported job types for a managed node.
	 * @param group The name of the group.
	 * @return A list of supported job types.
	 * @throws Exception
	 */
	public List<JobType> getJobTypes(String group) throws Exception {
		GetJobTypes gjt = new GetJobTypes();
		gjt.setGroup(group);
		OperationResults<Object> result = gjt.run(manager);
		List<JobType> ret = convertToJobTypes((String[])result.getResult());
		return ret;
	}
	
	/**
	 * This command is used to get the supported job types for a managed node.
	 * @param targetList List of managed nodes for the target.
	 * @return A list of supported job types.
	 * @throws Exception
	 */
	public List<JobType> getJobTypes(List<Node> managedNodeList) throws Exception {
		String[] targetList = nodeListToTargetList(managedNodeList);
		GetJobTypes gjt = new GetJobTypes();
		gjt.setTargetList(targetList);
		OperationResults<Object> result = gjt.run(manager);
		List<JobType> ret = convertToJobTypes((String[])result.getResult());
		return ret;
	}
	
	/**
	 * This command is used to get overall status of a job.
	 * @param job A previously submitted job.
	 * @return TODO
	 * @throws Exception
	 */
	public List<Object> getOverallJobStatus(Job job) throws Exception {
		List<Job> list = new ArrayList<Job>();
		list.add(job);
		return getOverallJobStatus(list);
	}

	/**
	 * This command is used to get overall status of a job.
	 * @param jobs A list of previously submitted jobs.
	 * @return TODO
	 * @throws Exception
	 */
	public List<Object> getOverallJobStatus(List<Job> jobs) throws Exception {
		String[] tokenList = new String[jobs.size()];
		int i = 0;
		for (Job job : jobs)
			tokenList[i++] = job.getToken();
		GetOverallJobStatus gojs = new GetOverallJobStatus(tokenList);
		OperationResults<Object> result = gojs.run(manager);
		List<Object> ret = (List<Object>)result.getResult();
		return ret;
	}
	
	private List<JobType> convertToJobTypes(String[] jobTypes) throws Exception {
		List<JobType> ret = new ArrayList<JobType>();
		for (String jt : jobTypes) {
			JobType jobType = JobType.getByJobName(jt);
			if (jobType == null)
				throw new Exception("Unknown job type: "+jt);
			ret.add(jobType);
		}
		return ret;
	}
	
	private String[] nodeListToTargetList(List<Node> nodeList) {
		String[] ret = new String[nodeList.size()];
		int i = 0;
		for (Node node : nodeList)
			ret[i++] = node.getAlias();
		return ret;
	}
	
}
