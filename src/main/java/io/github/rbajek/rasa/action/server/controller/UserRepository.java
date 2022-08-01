package io.github.rbajek.rasa.action.server.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.github.rbajek.rasa.action.server.action.custom.joke.UserDto;

@Repository
public interface UserRepository extends CrudRepository<UserDto, Long>{

}
