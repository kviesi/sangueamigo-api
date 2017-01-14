package br.com.user.api.authentication;

public class LoggedUser {

	private final Long userId;
	private final String userEmail;
	private final String userName;

	public LoggedUser(Long userId, String userEmail, String userName) {
		this.userId = userId;
		this.userEmail = userEmail;
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public Long getUserId() {
		return userId;
	}

}
