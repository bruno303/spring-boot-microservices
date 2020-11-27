package com.springbootmicroservices.hreurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class HrEurekaServerApplication {

	public static void main(final String[] args) {
		SpringApplication.run(HrEurekaServerApplication.class, args);
	}

}
