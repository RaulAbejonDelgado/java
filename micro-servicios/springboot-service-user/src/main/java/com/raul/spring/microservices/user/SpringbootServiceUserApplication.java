package com.raul.spring.microservices.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EntityScan("com.raul.spring.microservices.user.commons.models.entity")
@SpringBootApplication
public class SpringbootServiceUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceUserApplication.class, args);
	}

}
