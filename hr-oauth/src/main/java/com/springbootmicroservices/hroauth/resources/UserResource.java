package com.springbootmicroservices.hroauth.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootmicroservices.hroauth.entities.User;
import com.springbootmicroservices.hroauth.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	private final UserService userService;

	public UserResource(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		try {
			final User user = userService.findByEmail(email);
			return ResponseEntity.ok(user);
		} catch (final IllegalArgumentException ex) {
			return ResponseEntity.notFound().build();
		}
	}

}
