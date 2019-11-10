package com.raul.spring.microservices.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class SpringbootServiceItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceItemApplication.class, args);
	}

}
