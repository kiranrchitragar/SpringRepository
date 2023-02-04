package com.kiran.SpringBatchProcessing;

import org.springframework.batch.item.ItemProcessor;

public class BatchItemProcessor implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		System.out.println("Processed data " + item.toUpperCase());
		return item.toUpperCase();
	}

}
