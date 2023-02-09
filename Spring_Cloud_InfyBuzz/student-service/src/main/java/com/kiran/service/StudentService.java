package com.kiran.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.kiran.entity.Student;
import com.kiran.feignClient.GenericFeignClient;
import com.kiran.repository.StudentRepository;
import com.kiran.requestResponse.AddressResponse;
import com.kiran.requestResponse.StudentRequest;
import com.kiran.requestResponse.StudentResponse;

import reactor.core.publisher.Mono;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	WebClient webClient;
	
	@Autowired
	GenericFeignClient addressFeignClient;
	
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
		Student std = studentRepository.findById(id).get();
		StudentResponse stdRes = new StudentResponse(std);
		
		// stdRes.setAddressResponse(getAddressById(std.getAddressId())); --  this we use when WebClient is used
		stdRes.setAddressResponse(addressFeignClient.getById(std.getAddressId())); // this we use for feign client
		return stdRes;
	}

	public AddressResponse getAddressById(long addressId) {
		Mono<AddressResponse> res = webClient.get().uri("/getById/"+addressId).retrieve().bodyToMono(AddressResponse.class);
		return res.block();
	}
}
