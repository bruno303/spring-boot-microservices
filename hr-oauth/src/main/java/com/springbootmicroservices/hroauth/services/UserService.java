package com.springbootmicroservices.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.springbootmicroservices.hroauth.entities.User;
import com.springbootmicroservices.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	private final UserFeignClient userFeignClient;

	public UserService(UserFeignClient userFeignClient) {
		this.userFeignClient = userFeignClient;
	}

	public User findByEmail(String email) {
		final User user = userFeignClient.findByEmail(email).getBody();
		if (user == null) {
			LOGGER.error("E-mail not found: {}", email);
			throw new IllegalArgumentException("E-mail not found");
		}
		LOGGER.info("E-mail found: {}", email);
		return user;
	}

}
