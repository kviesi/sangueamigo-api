package br.com.user.api.authentication;

import org.springframework.stereotype.Component;

@Component
public class LoggedUserProvider {

	private LoggedUser loggedUser;

	public boolean hasLoggedUser() {
		return this.loggedUser != null;
	}

	public LoggedUser getLoggedUser() {
		return loggedUser;
	}

}
