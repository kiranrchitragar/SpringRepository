package com.kiran.SpringBatchProcessing;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class JobListner implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution jobExecution) {
		JobExecutionListener.super.beforeJob(jobExecution);
		System.out.println(" :: Job Starting from Batch Listner :: ");
	}
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		JobExecutionListener.super.afterJob(jobExecution);
		System.out.println("jobExecution details :: " + jobExecution.getStatus().toString());
		System.out.println(" :: Job Completed from Batch Listner :: ");
		
		
	}
}
