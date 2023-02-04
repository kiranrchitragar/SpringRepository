package com.kiran.SpringBatchProcessing;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBatchProcessingApplicationTests {

	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job job;
	
	
	// this is how we run a batch - we create a joblauncher and pass the job to it.
	@Test
	void testBatchProcessing() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		JobParameters jps = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
		// job parameters are actually not required. but for testing we have added it
		jobLauncher.run(job, jps);
	}

}
