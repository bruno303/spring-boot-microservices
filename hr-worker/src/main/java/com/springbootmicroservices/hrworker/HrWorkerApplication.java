package com.springbootmicroservices.hrworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HrWorkerApplication {

	public static void main(final String[] args) {
		SpringApplication.run(HrWorkerApplication.class, args);
	}

}
