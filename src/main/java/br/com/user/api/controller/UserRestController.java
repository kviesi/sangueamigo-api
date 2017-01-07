package br.com.user.api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Iterables;

import br.com.user.api.command.CreateUserCommand;
import br.com.user.api.command.FindUserCommand;
import br.com.user.api.command.ListUserCommand;
import br.com.user.api.command.UserSearchCommand;
import br.com.user.api.model.User;
import br.com.user.api.request.FilterRequest;
import br.com.user.api.request.SearchRequest;
import br.com.user.api.request.UserSimple;
import br.com.user.api.resources.UserResource;

@CrossOrigin(origins = "*")

@RestController
public class UserRestController {

	@Autowired
	private FindUserCommand findUserCommand;

	@Autowired
	private ListUserCommand listUserCommand;

	@Autowired
	private UserSearchCommand userSearchCommand;

	@Autowired
	private CreateUserCommand createUserCommand;
	
	@RequestMapping(
			value = "/v1.0/user",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> createUser_V1(@RequestBody UserSimple userSimple) {

		User userEntity = createUserCommand.doCreate(userSimple);

		UserResource userResource = UserResource.getInstance_V1(userEntity);

		return ResponseEntity.ok(userResource);
	}
	
	@RequestMapping(
			value = "/v1.0/user/search",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> searchUser_V1(SearchRequest searchRequest) {
	
		Iterable<User> usersEntitys = userSearchCommand.search(searchRequest);

		ArrayList<UserResource> userResources = new ArrayList<>(Iterables.size(usersEntitys));

		usersEntitys.forEach(u -> {
			userResources.add(UserResource.getInstance_V1(u));
		});

		return ResponseEntity.ok(userResources);
	}

	@RequestMapping(
			value = "/v1.0/user",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> listUser_V1(FilterRequest filterRequest) {
	
		Iterable<User> usersEntitys = listUserCommand.doFind(filterRequest);

		ArrayList<UserResource> userResources = new ArrayList<>(Iterables.size(usersEntitys));

		usersEntitys.forEach(u -> {
			userResources.add(UserResource.getInstance_V1(u));
		});

		return ResponseEntity.ok(userResources);
	}
	
	@RequestMapping(
			value = "/v1.0/user/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> getUser_V1(@PathVariable("id") String userId) {
		
		User userEntity = findUserCommand.findUser(userId);

		if (userEntity == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(UserResource.getInstance_V1(userEntity));
	}
	
}
