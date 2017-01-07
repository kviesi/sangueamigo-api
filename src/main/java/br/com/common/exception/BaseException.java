package br.com.common.exception;

import org.springframework.http.HttpStatus;

public abstract class BaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private final HttpStatus httpStatus;
	private final String key;

	public BaseException(HttpStatus httpStatus, String key) {
		this.httpStatus = httpStatus;
		this.key = key;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public String getKey() {
		return key;
	}

}
