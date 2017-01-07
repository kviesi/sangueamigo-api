package br.com.user.api.request;

import org.apache.commons.lang3.StringUtils;

public class FilterRequest {

	private static final int DEFAULT_RESULT_BY_PAGE = 10;

	private String name;
	private String email;
	private String active;
	private int actualPage;
	private int resultsByPage = DEFAULT_RESULT_BY_PAGE;

	public void setActive(String active) {
		this.active = active;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setActualPage(int actualPage) {
		this.actualPage = actualPage;
	}

	public void setResultsByPage(int resultsByPage) {
		this.resultsByPage = resultsByPage;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public int getActualPage() {
		return actualPage;
	}

	public int getResultsByPage() {
		return resultsByPage;
	}

	public boolean isActive() {
		return StringUtils.equals(active, "true");
	}

}
