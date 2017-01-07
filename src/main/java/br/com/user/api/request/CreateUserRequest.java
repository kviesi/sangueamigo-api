package br.com.user.api.request;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserRequest {

	@NotBlank
	private String name;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String password;

	@NotBlank
	@Pattern(regexp = "[0-9]{4}.[0-9]{6}.[0-9]{5}")
	private String bincode;

	@JsonCreator
	public CreateUserRequest(
			@JsonProperty("name") String name,
			@JsonProperty("email") String email,
			@JsonProperty("password") String password,
			@JsonProperty("bincode") String bincode) {
		
		this.name = name;
		this.email = email;
		this.password = password;
		this.bincode = bincode;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	public String getBincode() {
		return bincode;
	}

}
