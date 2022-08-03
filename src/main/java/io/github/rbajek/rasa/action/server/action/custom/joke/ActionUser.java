package io.github.rbajek.rasa.action.server.action.custom.joke;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.rbajek.rasa.action.server.controller.UserService;
import io.github.rbajek.rasa.sdk.CollectingDispatcher;
import io.github.rbajek.rasa.sdk.action.Action;
import io.github.rbajek.rasa.sdk.dto.Domain;
import io.github.rbajek.rasa.sdk.dto.Tracker;
import io.github.rbajek.rasa.sdk.dto.Tracker.Entity;
import io.github.rbajek.rasa.sdk.dto.Tracker.Message;
import io.github.rbajek.rasa.sdk.dto.event.AbstractEvent;

@Component
public class ActionUser implements Action {

	@Autowired
	private UserService userService;

	@Override
	public String name() {
		return "action_user_details";
	}

	@Override
	public List<AbstractEvent> run(CollectingDispatcher dispatcher, Tracker tracker, Domain domain) {
//		Iterable<UserDto> user = userService.findAll();
		List<UserDto> users = null;

		for (Entity entity : tracker.getLatestMessage().getEntities()) {
			entity.getEntity();
			entity.getValue();
			if (entity.getEntity().equals("age_range")) {

				users = userService.findByAge(Integer.valueOf(entity.getValue()));
			}
		}
		dispatcher.utterMessage(users.toString());

		return Collections.emptyList();
	}

}
