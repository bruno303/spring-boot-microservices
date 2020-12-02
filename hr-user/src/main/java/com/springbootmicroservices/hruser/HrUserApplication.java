package com.springbootmicroservices.hruser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableEurekaClient
@SpringBootApplication
public class HrUserApplication {

	private final Logger LOGGER = LoggerFactory.getLogger(HrUserApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HrUserApplication.class, args);
	}

	@Bean
	public CommandLineRunner bcriptPassword(BCryptPasswordEncoder passwordEncoder) {
		return args -> {
			LOGGER.info("BCRYPT = {}", passwordEncoder.encode("123456"));
		};
	}
}
