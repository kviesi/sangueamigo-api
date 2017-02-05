package br.com.user.api.authentication;

import org.hibernate.validator.constraints.NotBlank;

public class LoggedUser {

	@NotBlank
	private final String userId;

	public LoggedUser(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

}
