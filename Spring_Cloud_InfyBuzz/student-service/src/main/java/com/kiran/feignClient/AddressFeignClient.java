package com.kiran.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kiran.requestResponse.AddressResponse;

//@FeignClient(url="http://localhost:8082/api/address",value="address-feign-client")
@FeignClient(name="address-service", path = "/api/address") //  when we register in eureka, 
// we call the address-service by its name. 
public interface AddressFeignClient {

	@GetMapping("/getById/{id}")
	 @ResponseBody public AddressResponse getById(@PathVariable long id);
}
