package com.raul.spring.microservices.oauth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class SpringbootServiceOauthApplication implements CommandLineRunner {

	Logger log = LoggerFactory.getLogger(SpringBootApplication.class);

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceOauthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String password = "12345";

		for (int i = 0 ; i < 4; i++) {
			String passwordBCrypt = passwordEncoder.encode(password);
			log.info(String.format("The password enconded nº %d is %s ", i+1,passwordBCrypt));
		}
		//passwordEncoder.
	}
}
