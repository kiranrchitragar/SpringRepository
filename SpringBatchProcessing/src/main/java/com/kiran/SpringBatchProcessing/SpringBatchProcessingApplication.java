package com.kiran.SpringBatchProcessing;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableBatchProcessing
@SpringBootApplication
@ComponentScan("com.kiran.SpringBatchProcessing.*")
public class SpringBatchProcessingApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBatchProcessingApplication.class, args);
		System.out.println("Main Class");
		BatchController bc = new BatchController();
		bc.handle();
	}

}
