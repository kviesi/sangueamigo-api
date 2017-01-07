//package br.com.login.api.command;
//
//import org.hibernate.validator.constraints.Email;
//import org.hibernate.validator.constraints.NotBlank;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.annotation.Validated;
//
//import br.com.login.api.mail.ForgetPasswordToken;
//import br.com.login.api.mail.ForgotPasswordMail;
//import br.com.user.api.exception.UserNotFoundException;
//import br.com.user.api.model.UserEntity;
//import br.com.user.api.repository.UserRepository;
//
//@Component
//@Validated
//public class ForgotPasswordCommand {
//
//	private static final int TOKEN_TTL = 10 * 60 * 1000;
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@Autowired
//	private ForgotPasswordMail forgotPasswordMail;
//
//	public void handle(@NotBlank @Email String userEmail) {
//
//		UserEntity user = userRepository.findByEmail(userEmail);
//
//		if (user == null) {
//			throw new UserNotFoundException();
//		}
//
//		forgotPasswordMail.sendAsync(
//				user.getName(), 
//				user.getEmail(),
//				ForgetPasswordToken.generate(userEmail, TOKEN_TTL));
//	}
//
//}
