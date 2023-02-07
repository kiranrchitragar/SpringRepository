package com.kiran.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiran.requestResponse.AddressRequest;
import com.kiran.requestResponse.AddressResponse;
import com.kiran.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {

	Logger log = LoggerFactory.getLogger(AddressController.class);
	
	@Autowired
	AddressService addressService;

	@PostMapping("/create")
	public AddressResponse createAddress(@RequestBody AddressRequest req) {
		 return addressService.createAddress(req);
	}
	
	@GetMapping("/getById/{id}")
	public AddressResponse getById(@PathVariable long id) {
		 return addressService.getById(id);
	}
	
	
	
}
