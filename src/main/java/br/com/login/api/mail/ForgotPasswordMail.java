package br.com.login.api.mail;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

//import mail.Email;
//import provider.MailProvider;

@Component
public class ForgotPasswordMail {

	private static final String EMAIL = "forgot_password";

//	@Autowired
	private MailSender mailSender;

//	@Autowired
//	private MailProvider mailProvider;

	@Async
	public void sendAsync(String userName, String userEmail, String token) {

//		Email email = mailProvider.getEmail(EMAIL);

		Map<String, Object> vars = new HashMap<>(3);
		vars.put("user_email", userEmail);
		vars.put("user_name", userName);
		vars.put("token", token);
//
//		SimpleMailMessage mailMessage = MailHelper.create(email, Languages.EN_GB, vars, userEmail);
//
//		mailSender.send(mailMessage);

	}

}
