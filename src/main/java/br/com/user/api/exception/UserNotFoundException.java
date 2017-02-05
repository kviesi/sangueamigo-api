package br.com.user.api.exception;

import org.springframework.http.HttpStatus;

import br.com.common.exception.BaseException;

public class UserNotFoundException extends BaseException {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		super(HttpStatus.BAD_REQUEST, "user_not_found");
	}

}
