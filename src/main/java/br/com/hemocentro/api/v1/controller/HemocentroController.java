package br.com.hemocentro.api.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Iterables;

import br.com.hemocentro.api.v1.command.HemocentroFinder;
import br.com.hemocentro.api.v1.command.HemocentroList;
import br.com.hemocentro.api.v1.command.HemocentroRegister;
import br.com.hemocentro.api.v1.model.Hemocentro;
import br.com.hemocentro.api.v1.request.ListRequest;
import br.com.hemocentro.api.v1.request.RegisterRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class HemocentroController {
	
	@Autowired
	private HemocentroRegister hemocentroRegister;
	
	@Autowired
	private HemocentroList hemocentroList;
	
	@Autowired
	private HemocentroFinder hemocentroFinder;

	@ApiOperation(value = "listHemocentro", nickname = "listHemocentro")
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Success", response = Hemocentro.class),
		@ApiResponse(code = 401, message = "Unauthorized") 
	})
	@RequestMapping(value = "/v1.0/hemocentro", 
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> listAll(@RequestParam ListRequest listRequest) {
		
		Iterable<Hemocentro> hemocentros = hemocentroList.list(listRequest);

		if (Iterables.isEmpty(hemocentros)) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(hemocentros);
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
	public ResponseEntity<?> create(@RequestBody RegisterRequest request) {
		
		hemocentroRegister.register(request);
		
		return ResponseEntity.ok().build();
	}

	@ApiOperation(value = "getHemocentro", nickname = "getHemocentro")
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Success"),
		@ApiResponse(code = 401, message = "Unauthorized") 
	})
	@RequestMapping(value = "/v1.0/hemocentro/{id}", 
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		
		Hemocentro hemocentro = hemocentroFinder.find(id);
		
		if (hemocentro == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(hemocentro);
	}

	@RequestMapping(value = "/v1.0/hemocentro/{id}/faq/{fid}")
	public ResponseEntity<?> findFaqs(@PathVariable("id") Long id) {
		//TODO: impl
		return null;
	}

	@RequestMapping(value = "/v1.0/hemocentro/{id}/estoque/{eid}")
	public ResponseEntity<?> findEstoque(@PathVariable("id") Long id) {
		//TODO: impl
		return null;
	}

	@RequestMapping(value = "/v1.0/hemocentro/{id}/campanha/{cid}")
	public ResponseEntity<?> findCampanha(@PathVariable("id") Long id) {
		//TODO: impl
		return null;
	}

}
