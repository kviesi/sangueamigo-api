package br.com.login.api.exception;

import br.com.common.exception.BaseException;

public class ExpiredTokenException extends BaseException {

	private static final long serialVersionUID = 1L;

	public ExpiredTokenException() {
		super(null, null);
	}

}
