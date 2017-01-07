package br.com.hemocentro.api.model;

public enum BloodType {

	A_P("A Positivo"), 
	A_N("A Negativo"),
	AB_P("AB Positivo"),
	AB_N("AB Negativo"),
	O_P("O Positivo"),
	O_N("O Negativo");

	private String displayName;

	private BloodType(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

}
