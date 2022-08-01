package io.github.rbajek.rasa.action.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.rbajek.rasa.action.server.action.custom.joke.UserDto;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/")
	private ResponseEntity<?> insert(@RequestBody UserDto user) {

		return new ResponseEntity<>(userService.save(user), HttpStatus.OK);

	}

	@GetMapping("/get-all")
	private ResponseEntity<?> fetchAll() {
		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);

	}
}
