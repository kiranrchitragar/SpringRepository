package com.kiran.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.client.WebClient;


@ComponentScan({"com.kiran.controller","com.kiran.service"})
@EntityScan("com.kiran.entity")
@EnableJpaRepositories("com.kiran.repository")
@EnableFeignClients("com.kiran.feignClient")

@EnableDiscoveryClient // eureka client
@SpringBootApplication
public class StudentServiceApplication {

	//@Value("${address.service.url}")
	private String addressServiceUrl = "http://localhost:8082/api/address";
	
	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}
	@Bean
	public WebClient webClient() {
		WebClient wc = WebClient.builder().baseUrl(addressServiceUrl).build();
		return wc;
		
	}
}
