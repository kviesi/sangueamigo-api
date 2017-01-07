package br.com.login.api.exception;

import org.springframework.http.HttpStatus;

import br.com.common.exception.BaseException;

public class InvalidAuthenticationException extends BaseException {
	private static final long serialVersionUID = 1L;

	private static final String ERROR_KEY = "invalid_authentication";

	public InvalidAuthenticationException() {
		super(HttpStatus.FORBIDDEN, ERROR_KEY);
	}

}
