package br.com.user.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.user.api.authentication.LoggedUser;
import br.com.user.api.command.UpdatePerfilCommand;
import br.com.user.api.request.UpdatePerfilRequest;

@RestController
public class PerfilController {

	@Autowired
	private UpdatePerfilCommand updatePerfilCommand;
	
	@RequestMapping(
			value = "/v1.0/user-perfil",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	
	public void getPerfil(LoggedUser loggedUser) {

	}

	@RequestMapping(
			value = "/v1.0/user-perfil",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	
	public ResponseEntity<?> update(
			@RequestBody UpdatePerfilRequest updatePerfilRequest,
			LoggedUser loggedUser) {

		updatePerfilCommand.update(loggedUser, updatePerfilRequest);
		
		return ResponseEntity.ok().build();
	}

}
