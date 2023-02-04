package com.kiran.SpringBatchProcessing;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class BatchItemReader implements ItemReader<String> {

	private String[] coursesArray = {"abc","def","ghi"};
	private int count;
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
System.out.println("REader");
		if(count<coursesArray.length) {
			return coursesArray[count++];
		}else {
			count =0;
		}
		
		return null;
	}

}
