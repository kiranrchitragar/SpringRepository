package com.kiran.apiGateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Configuration
public class CustomFilter implements GlobalFilter{

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		ServerHttpRequest request = exchange.getRequest();
		System.out.println(" Prefilter Authorization :: " + request.getHeaders().getFirst("Authorization"));
		// the above 2 lines are pre auths, where are printing the request header 
		
		
		if(request.getURI().toString().contains("/api/student/")) {
			// specific conditions for particular microservice. 
		}
		
		
		// the return statement is used to return the flow to appropriate Microservice after pre filter finishes.
		// route the request to microservice. 
		//return chain.filter(exchange);
		
		// the below code is for postfilter.
		return chain.filter(exchange).then(Mono.fromRunnable(()->{
			ServerHttpResponse response = exchange.getResponse();
			System.out.println("Post Filter : " + response.getStatusCode());
		}));
	}

}
