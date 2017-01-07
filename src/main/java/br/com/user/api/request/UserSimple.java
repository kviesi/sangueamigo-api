package br.com.user.api.request;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserSimple {

	@NotBlank
	private String name;

	@NotBlank
	private String email;

	@NotBlank
	private String alias;

	@JsonIgnore
	private List<String> roles;

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getAlias() {
		return alias;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public List<String> getRoles() {
		return roles;
	}

}
