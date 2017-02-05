package br.com.user.api.exception;

import org.springframework.http.HttpStatus;

import br.com.common.exception.BaseException;

public class DuplicatedEmailException extends BaseException {

	private static final long serialVersionUID = 1L;

	public DuplicatedEmailException() {
		super(HttpStatus.BAD_REQUEST, "user_email_duplicated");
	}

}
