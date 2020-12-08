package com.springbootmicroservices.hruser.resources;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootmicroservices.hruser.entities.User;
import com.springbootmicroservices.hruser.repositories.UserRepository;

@RefreshScope
@RestController
@RequestMapping(value = "/users")
public class UserResource {
	private final UserRepository userRepository;

	public UserResource(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable final Long id) {
		final var user = userRepository.findById(id).orElseThrow();
		return ResponseEntity.ok(user);
	}

	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam final String email) {
		final var user = userRepository.findByEmail(email);
		return ResponseEntity.ok(user);
	}
}
