package br.com.hemocentro.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.hemocentro.api.command.HemocentroRegister;
import br.com.hemocentro.api.model.Hemocentro;
import br.com.hemocentro.api.request.HemocentroRegisterRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class HemocentroController {
	
	@Autowired
	private HemocentroRegister hemocentroRegister;

	@ApiOperation(value = "listHemocentro", nickname = "listHemocentro")
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Success", response = Hemocentro.class),
		@ApiResponse(code = 401, message = "Unauthorized") 
	})
	
	@RequestMapping(value = "/v1.0/hemocentro", 
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	
	public ResponseEntity<?> listAll() {
		return ResponseEntity.ok().build();
	}
	
	@ApiOperation(value = "createHemocentro", nickname = "createHemocentro")
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Success"),
		@ApiResponse(code = 401, message = "Unauthorized") 
	})
	
	@RequestMapping(value = "/v1.0/hemocentro", 
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	
	public ResponseEntity<?> create(@RequestBody HemocentroRegisterRequest request) {
		hemocentroRegister.register(request);
		return ResponseEntity.ok().build();
	}

	@RequestMapping(value = "/v1.0/hemocentro/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		return null;
	}

	@RequestMapping(value = "/v1.0/hemocentro/{id}/faq/{fid}")
	public ResponseEntity<?> findFaqs(@PathVariable("id") Long id) {
		return null;
	}

	@RequestMapping(value = "/v1.0/hemocentro/{id}/estoque/{eid}")
	public ResponseEntity<?> findEstoque(@PathVariable("id") Long id) {
		return null;
	}

	@RequestMapping(value = "/v1.0/hemocentro/{id}/campanha/{cid}")
	public ResponseEntity<?> findCampanha(@PathVariable("id") Long id) {
		return null;
	}

}
