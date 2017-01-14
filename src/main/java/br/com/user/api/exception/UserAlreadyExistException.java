package br.com.user.api.exception;

import org.springframework.http.HttpStatus;

import br.com.common.exception.BaseException;

public class UserAlreadyExistException extends BaseException {

	private static final long serialVersionUID = 1L;

	private static final String KEY = "user_already_exist";

	public UserAlreadyExistException() {
		super(HttpStatus.CONFLICT, KEY);
	}

}
