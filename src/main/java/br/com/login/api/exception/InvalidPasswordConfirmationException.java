package br.com.login.api.exception;

import br.com.common.exception.BaseException;

public class InvalidPasswordConfirmationException extends BaseException {

	private static final long serialVersionUID = 1L;

	public InvalidPasswordConfirmationException() {
		super(null, null);
	}

}
