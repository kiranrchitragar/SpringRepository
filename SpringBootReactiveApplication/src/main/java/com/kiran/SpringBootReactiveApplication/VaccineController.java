package com.kiran.SpringBootReactiveApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class VaccineController {

	@Autowired
	VaccineProvider vs;
	
	// INstead of tomcat Netty will handle this.v- Netty started on port 8080
	@GetMapping("/vaccines")
	public Flux<Vaccine> getVacccines(){
		return vs.provideVaccine();
	}
}
