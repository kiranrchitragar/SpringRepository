package com.kiran.SpringBatchProcessing;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

public class BatchItemWriter implements ItemWriter<String> {

	@Override
	public void write(Chunk<? extends String> chunk) throws Exception {
		System.out.println("chunk from writer :: " + chunk);
		
	}

}
