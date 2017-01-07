//package br.com.login.api.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.com.login.api.command.ForgotPasswordCommand;
//import br.com.login.api.command.LoginCommand;
//import br.com.login.api.request.LoginRequest;
//import br.com.user.api.model.UserEntity;
//import br.com.user.api.resources.UserResource;
//
//@CrossOrigin(origins = "*")
//
//@RestController
//public class LoginRestController {
//
//	@Autowired
//	private LoginCommand loginCommand;
//	
//	@Autowired
//	private ForgotPasswordCommand forgotPasswordCommand;
//	
//	@RequestMapping(value = "/v1.0/login",
//					method = RequestMethod.POST,
//					produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
//					consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	
//	public ResponseEntity<?> doLogin_V1(@RequestBody LoginRequest loginRequest) {
//
//		UserEntity userEntity = loginCommand.login(loginRequest);
//
//		return ResponseEntity.ok(UserResource.getInstance_V1(userEntity));
//	}
//	
//	@RequestMapping(value = "/v1.0/login/{email}/forgot-password",
//			method = RequestMethod.POST,
//			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
//			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
//
//	public ResponseEntity<?> doForgotPassword_V1(@PathVariable("email") String userEmail) {
//
//		forgotPasswordCommand.handle(userEmail);
//
//		return ResponseEntity.noContent().build();
//	}
//	
//}
