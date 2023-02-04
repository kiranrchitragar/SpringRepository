package com.kiran.SpringBootReactiveApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;

@Component
public class VaccineProvider {

	@Autowired
	VaccineService vaccineService;
	
	public Flux<Vaccine> provideVaccine(){
		return vaccineService.getVaccines().map(this::deliver); // refer to the private method of same class
	}
	
	private Vaccine deliver(Vaccine vaccine) {
		vaccine.setDelivered(true);
		return vaccine;
	}
}
