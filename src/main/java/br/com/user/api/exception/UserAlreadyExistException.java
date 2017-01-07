package br.com.user.api.exception;

import org.springframework.http.HttpStatus;

import br.com.common.exception.BaseException;

public class UserAlreadyExistException extends BaseException {

	private static final long serialVersionUID = 1L;

	/**
	 * Email duplicado
	 */
	private static final String KEY = "email_duplicated";

	public UserAlreadyExistException() {
		super(HttpStatus.CONFLICT, KEY);
	}

}
