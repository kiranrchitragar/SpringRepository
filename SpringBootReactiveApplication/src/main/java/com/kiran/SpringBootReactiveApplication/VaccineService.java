package com.kiran.SpringBootReactiveApplication;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class VaccineService {

	public Flux<Vaccine> getVaccines(){
		return Flux.just(new Vaccine("pfizer"),new Vaccine("J&J"), new Vaccine("Covaxin"));
	}
}
