package br.com.user.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.user.api.command.CreateUserCommand;
import br.com.user.api.request.CreateUserRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class UserController {

	@Autowired
	private CreateUserCommand createUserCommand;

	
	@ApiOperation(value = "createUser", nickname = "createUser")
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Success"),
		@ApiResponse(code = 401, message = "Unauthorized") 
	})
	
	@RequestMapping(value = "/v1.0/user", 
					consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	
	public ResponseEntity<?> create(@RequestBody CreateUserRequest createUserRequest) {

		createUserCommand.doCreate(createUserRequest);

		return ResponseEntity.ok().build();
	}

}
