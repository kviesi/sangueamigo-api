package br.com.user.api.exception;

import org.springframework.http.HttpStatus;

import br.com.common.exception.BaseException;

public class UserNotFoundException extends BaseException {
	private static final long serialVersionUID = 1L;

	private static final String ERROR_KEY = "user_not_found";

	public UserNotFoundException() {
		super(HttpStatus.NOT_FOUND, ERROR_KEY);
	}

}
