package br.com.user.api.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.user.api.command.UserLoginCommand;
import br.com.user.api.request.LoginRequest;

@RestController
public class LoginController {

	@Autowired
	private UserLoginCommand userLoginCommand;
	
	@RequestMapping(value = "/v1.0/login", 
					consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
					produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
		
		Optional<String> token = userLoginCommand.doLogin(loginRequest);

		if (!token.isPresent()) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}

		Map<String, Object> loginResponse = new HashMap<>();
		loginResponse.put("token", token.get());
		loginResponse.put("date", new Date());

		return ResponseEntity.ok(loginResponse);
	}
	
	
}
