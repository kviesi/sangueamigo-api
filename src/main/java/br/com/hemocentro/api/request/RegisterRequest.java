package br.com.hemocentro.api.request;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterRequest {

	@NotBlank
	private String name;

	@NotBlank
	private String city;

	@NotBlank
	private String state;

	@NotBlank
	private String adress;

	@NotBlank
	private String number;

	@NotBlank
	private String complement;

	private long plat;
	private long plong;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public long getPlat() {
		return plat;
	}

	public void setPlat(long plat) {
		this.plat = plat;
	}

	public long getPlong() {
		return plong;
	}

	public void setPlong(long plong) {
		this.plong = plong;
	}

}
