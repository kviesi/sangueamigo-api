//package br.com.login.api.command;
//
//import org.hibernate.validator.constraints.NotBlank;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.annotation.Validated;
//
//import br.com.login.api.exception.ExpiredTokenException;
//import br.com.login.api.exception.InvalidPasswordConfirmationException;
//import br.com.login.api.mail.ForgetPasswordToken;
//import br.com.login.api.mail.ForgetPasswordToken.ForgetPasswordTokenContent;
//import br.com.user.api.exception.UserNotFoundException;
//import br.com.user.api.model.UserEntity;
//import br.com.user.api.repository.UserRepository;
//
//@Component
//@Validated
//public class ResetPasswordCommand {
//
//	@Autowired
//	private UserRepository userRepository;
//
//	public void reset(
//			@NotBlank String token, 
//			@NotBlank String newPassword,
//			@NotBlank String newPasswordConfirmation) throws UserNotFoundException, ExpiredTokenException, InvalidPasswordConfirmationException {
//
//		if (!newPassword.equals(newPasswordConfirmation)) {
//			throw new InvalidPasswordConfirmationException();
//		}
//
//		ForgetPasswordTokenContent tokenContent = ForgetPasswordToken.from(token);
//
//		if (tokenContent.isExpired()) {
//			throw new ExpiredTokenException();
//		}
//
//		UserEntity user = userRepository.findByEmail(tokenContent.getEmail());
//
//		if (user == null) {
//			throw new UserNotFoundException();
//		}
//
//		user.changePassword(newPassword);
//
//		userRepository.save(user);
//	}
//
//}
