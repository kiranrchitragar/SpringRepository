package com.kiran.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiran.entity.Address;
import com.kiran.repository.AddressRepository;
import com.kiran.requestResponse.AddressRequest;
import com.kiran.requestResponse.AddressResponse;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;
	
	public AddressResponse createAddress(AddressRequest req) {

		Address address = new Address();
		address.setStreet(req.getStreet());
		address.setCity(req.getCity());
		addressRepository.save(address);
		return new AddressResponse(address);
	}

	public AddressResponse getById(long id) {
		Address address = addressRepository.getById(id);
		return new AddressResponse(address);
	}

}
