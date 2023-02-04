package com.kiran.SpringBatchProcessing;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BatchController {

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job job;
	
	public void handle() throws Exception {
		System.out.println("Hello");
		JobParameters jps = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
		// job parameters are actually not required. but for testing we have added it
		jobLauncher.run(job, jps);
	}

}