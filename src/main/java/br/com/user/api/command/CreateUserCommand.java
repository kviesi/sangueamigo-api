package br.com.user.api.command;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import br.com.common.util.PasswordUtils;
import br.com.common.validator.ValidationException;
import br.com.user.api.model.User;
import br.com.user.api.repository.UserRepository;
import br.com.user.api.request.UserSimple;
//import mail.Email;
//import provider.MailProvider;

@Component
@Validated
public class CreateUserCommand {

	@Autowired
	private UserRepository userRepository;

//	@Autowired
//	private MailProvider mailProvider;

//	@Autowired
	private MailSender mailSender;

	public User doCreate(@NotNull @Valid UserSimple userSimple) throws ValidationException {
		return create(userSimple);
	}

	private User create(UserSimple userSimple) {

		String randomPassword = PasswordUtils.random(4, 6);

		User userEntity = persistsUserEntity(userSimple, randomPassword);
//		sendEmail(userEntity, randomPassword);
		
		return userEntity;
	}

	private User persistsUserEntity(UserSimple userSimple, String randomPassword) {

//		UserEntity userEntity = new UserEntity(
//				userSimple.getName(),
//				userSimple.getEmail(),
//				randomPassword);
//		

//		userRepository.save(userEntity);
//		userIndex.index(userEntity);
		
//		return userEntity;
		return null;
	}

//	private void sendEmail(UserEntity userEntity, String newPassword) {
//
//		Email email = mailProvider.getEmail("backoffice-user-password");
//
//		Map<String, Object> vars = new HashMap<>();
//		vars.put("email", userEntity.getEmail());
//		vars.put("password", newPassword);
//
//		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//		simpleMailMessage.setTo(userEntity.getEmail());
//		simpleMailMessage.setFrom(email.getFrom());
//		simpleMailMessage.setSubject(email.getSubject("pt-BR"));
//		simpleMailMessage.setSentDate(new Date());
//		simpleMailMessage.setText(email.getTemplate(vars));
//		
//		mailSender.send(simpleMailMessage);
//	}

}
