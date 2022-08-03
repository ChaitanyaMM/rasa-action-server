package io.github.rbajek.rasa.action.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.rbajek.rasa.action.server.action.custom.joke.UserDto;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserDto save(UserDto user) {
		return userRepository.save(user);
	}

	public Iterable<UserDto> findAll() {
		return userRepository.findAll();
	}
	
	public List<UserDto> findByAge(int value){
		return  userRepository.findByAgeGreaterThan(value);
	}

}
