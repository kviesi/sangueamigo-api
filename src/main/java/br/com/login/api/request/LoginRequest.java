package br.com.login.api.request;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequest {

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String password;

	@JsonCreator
	public LoginRequest(@JsonProperty("email") String email,
						@JsonProperty("password") String password) {
		
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}
