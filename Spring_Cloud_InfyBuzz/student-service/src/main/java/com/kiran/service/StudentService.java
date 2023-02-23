package com.kiran.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.kiran.entity.Student;
import com.kiran.feignClient.GenericFeignClient;
import com.kiran.repository.StudentRepository;
import com.kiran.requestResponse.StudentRequest;
import com.kiran.requestResponse.StudentResponse;

@Service
public class StudentService {

	Logger logger = LoggerFactory.getLogger(StudentService.class);
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	WebClient webClient;
	
	@Autowired
	GenericFeignClient addressFeignClient;
	
	@Autowired
	CommonService commonService;
	
	public StudentResponse createStudent(StudentRequest req) {
		Student std = new Student();
		std.setFirstName(req.getFirstName());
		std.setLastName(req.getLastName());
		std.setEmail(req.getEmail());
		std.setAddressId(req.getAddressId());
		std = studentRepository.save(std);
		
		StudentResponse stdRes = new StudentResponse(std);
		
		
		// stdRes.setAddressResponse(getAddressById(std.getAddressId())); --  this we use when WebClient is used
		stdRes.setAddressResponse(addressFeignClient.getById(std.getAddressId())); // this we use for feign client
		
		return new StudentResponse(std);
	}

	public StudentResponse getById(long id) {
		logger.info("Inside Student Service");
		Student std = studentRepository.findById(id).get();
		StudentResponse stdRes = new StudentResponse(std);
		
		// stdRes.setAddressResponse(getAddressById(std.getAddressId())); --  this we use when WebClient is used
		stdRes.setAddressResponse(commonService.getAddressById(std.getAddressId())); // this we use for feign client
		return stdRes;
	}
	
	
	// Moved to common service bcoz of AOP and circuit breaker

	// for this method we will apply circuit breaker
	
//	@CircuitBreaker(name="addressService",
//			fallbackMethod="fallBackGetAddressById")
//	public AddressResponse getAddressById(long addressId) {
//		// Mono<AddressResponse> res = webClient.get().
//		// uri("/getById/"+addressId).retrieve().bodyToMono(AddressResponse.class); --  this we use when WebClient is used
//		
//		
//		AddressResponse addressResponse = addressFeignClient.getById(addressId);
//		
//		return addressResponse;
//	}
//	
//	// same method signature as of previous
//	public AddressResponse fallBackGetAddressById(long addressId) {
//		return new AddressResponse();
//	}
}
