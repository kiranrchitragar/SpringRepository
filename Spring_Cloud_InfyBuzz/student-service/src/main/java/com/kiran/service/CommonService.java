package com.kiran.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiran.feignClient.GenericFeignClient;
import com.kiran.requestResponse.AddressResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CommonService {

	Logger logger = LoggerFactory.getLogger(CommonService.class);
	
	long count=1;
	
	@Autowired
	GenericFeignClient addressFeignClient;
	
	@CircuitBreaker(name="addressService",
			fallbackMethod="fallBackGetAddressById")
	public AddressResponse getAddressById(long addressId) {
		logger.info("count :: " + count);		
		count++;
		AddressResponse addressResponse = addressFeignClient.getById(addressId);
		
		return addressResponse;
	}
	
	// same method signature as of previous
	public AddressResponse fallBackGetAddressById(long addressId, Throwable th) {
		logger.error("Error :: " + th);
		return new AddressResponse();
	}
}
