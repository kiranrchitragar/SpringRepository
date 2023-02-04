package com.kiran.SpringBatchProcessing;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobFactory;

	@Autowired
	private StepBuilderFactory stepFactory;
	
	// Configuring the job
	@Bean
	public Job job() {
		return jobFactory
				.get("job1").
				incrementer(new RunIdIncrementer()) // creates new id for each job
				.listener(jobListner())
				.start(step())
				.build();
	}
	// Configuring the step
	@Bean
	public Step step() {
		return stepFactory.get("Step1").
				<String,String>chunk(1)
				.reader(itemReader())
				.processor(itemProcessor())
				.writer(itemWriter())
				.build();
	}
	
	@Bean
	public BatchItemReader itemReader() {
		return new BatchItemReader();
	}

	@Bean
	public BatchItemWriter itemWriter() {
		return new BatchItemWriter();
	}
	@Bean
	public BatchItemProcessor itemProcessor() {
		return new BatchItemProcessor();
	}
	
	@Bean
	public JobListner jobListner() {
		return new JobListner();
	}}
