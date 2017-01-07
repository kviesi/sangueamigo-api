//package br.com.login.api.command;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.annotation.Validated;
//
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//
//import br.com.login.api.exception.InvalidAuthenticationException;
//import br.com.login.api.request.LoginRequest;
//import br.com.user.api.model.UserEntity;
//import br.com.user.api.repository.UserRepository;
//
//@Component
//@Validated
//public class LoginCommand {
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@HystrixCommand(threadPoolKey = "LC_Do_Login")
//	public UserEntity login(@Valid LoginRequest loginRequest) throws InvalidAuthenticationException {
//
//		UserEntity userEntity = userRepository.findByEmail(loginRequest.getEmail());
//		
//		if (userEntity == null || 
//			!userEntity.authenticate(loginRequest.getPassword())) {
//			
//			throw new InvalidAuthenticationException();
//		}
//
//		return userEntity;
//	}
//
//}
