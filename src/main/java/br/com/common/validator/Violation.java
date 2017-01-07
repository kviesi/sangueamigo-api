package br.com.common.validator;

public class Violation {

	private String key;
	private String message;

	public Violation(String key, String message) {
		this.key = key;
		this.message = message;
	}

	public String getKey() {
		return key;
	}

	public String getMessage() {
		return message;
	}

}
