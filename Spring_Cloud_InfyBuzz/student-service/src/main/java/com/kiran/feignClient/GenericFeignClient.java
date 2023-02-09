package com.kiran.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kiran.requestResponse.AddressResponse;

@FeignClient(name="api-gateway") 
public interface GenericFeignClient {

	@GetMapping("/address-service/api/address/getById/{id}")
	 @ResponseBody public AddressResponse getById(@PathVariable long id);
}
