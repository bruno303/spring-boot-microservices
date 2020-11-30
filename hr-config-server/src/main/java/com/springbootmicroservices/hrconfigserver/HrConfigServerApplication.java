package com.springbootmicroservices.hrconfigserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;

@EnableConfigServer
@SpringBootApplication
public class HrConfigServerApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(HrConfigServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HrConfigServerApplication.class, args);
	}

	@Bean
	public CommandLineRunner gitCredentialsTest(@Value("${GITHUB_USER}") final String gitUsername,
			@Value("${GITHUB_PASS}") final String gitPassword) {
		return args -> {
			LOGGER.info("Git Username: {}", gitUsername);
			LOGGER.info("Git Password: {}", gitPassword);
		};
	}
}
