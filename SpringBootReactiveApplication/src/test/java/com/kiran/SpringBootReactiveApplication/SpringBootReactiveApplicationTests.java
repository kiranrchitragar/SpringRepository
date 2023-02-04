package com.kiran.SpringBootReactiveApplication;

import java.time.Duration;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class SpringBootReactiveApplicationTests {

	
	@Autowired
	VaccineProvider vaccineProvider;
	
	@Test
	void testVaccineProvider() {
		vaccineProvider.provideVaccine().subscribe(new VacineConsumer());
	}
	
	@Test
	void testMono() {
		// just() is used to publish the data and it deals with single unit of work
		Mono<String> mono = Mono.just("macbook pro");
		// log() -> logs internal events within mono to std out.
		// map() method is same as java 8

		// subscribe() - alway invoke the subscribe method for reactive to work. once we define subscribe method then the data flow will begin.
		// in spring boot reactive subscribe method is handled by spring framework.
		mono.log().map(data-> data.toUpperCase()).subscribe(data->System.out.println(data));
		
		/*
		 * 
		 * these are printed in logs
		onSubscribe()
		request(unbounded)
		onNext(macbook pro)
		onComplete()

		*/
		
	}

	// subscribe() will take consumer functional interface.
	
	
	@Test
	void testFlux() {
		Flux<String> flux = Flux.just("macbook pro","abc","def","ghi");
		flux.log().map(data-> data.toUpperCase()).subscribe(data->System.out.println(data));
		
		/*
		 * 
		 * these are printed in logs
		onSubscribe()	
		request(unbounded)
		onNext(macbook pro)
		onNext(abc)
		onNext(def)
		onNext(ghi)
		onComplete()

		*/
		
	}
	
	@Test
	void testFluxWithDelayMethod() {
		
		// delayElements(Duration.ofSeconds(3) - this is used in flux where there is delay of 3 seconds between each element processing
		Flux<String> flux = Flux.just("macbook pro","abc","def","ghi").delayElements(Duration.ofSeconds(3));
		
		// FLux of elemnts can be created in the below manner as well
		Flux<String> flux1 = Flux.fromIterable(Arrays.asList("macbook pro","abc","def","ghi"));

		flux.log().map(data-> data.toUpperCase()).subscribe(data->System.out.println(data));
		
	
		
	}
	
	
	@Test
	void testFluxWithSubscriber() {
		
		Flux<String> flux = Flux.just("macbook pro","abc","def","ghi");
		
		// subscribe() will take subscribe and consumer as the parameter, lets see if it take subscriber , we can override its
		// few methods that we saw on the logs
		flux.log().map(data-> data.toUpperCase()).subscribe(new Subscriber<String>() {

			@Override
			public void onSubscribe(Subscription subscription) {
				// tells how many requests this subscriber is ready to accept
				// if this is set to 0 or the below line is absent , the entire functioanlity wont work
				// request method sends the signal to the publisher and tells how much request it acn handle.
				subscription.request(Long.MAX_VALUE);
				
				
			}

			@Override
			public void onNext(String t) {
				// this method is invoked for each element that is present in flux /mono
				System.out.println("t->  " + t);
				
			}

			@Override
			public void onError(Throwable t) {
				//  used for error handling
				t.printStackTrace();
				
			}

			@Override
			public void onComplete() {
				// 
			}
		});;
		
	
		
	}
}
