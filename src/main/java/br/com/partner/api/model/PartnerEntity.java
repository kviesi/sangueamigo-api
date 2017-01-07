package br.com.partner.api.model;

import javax.validation.constraints.NotNull;

public class PartnerEntity {

	@NotNull
	private String id;

	@NotNull
	private String name;

	@NotNull
	private String location;

	@NotNull
	private String zip;

	@NotNull
	private String city;

	@NotNull
	private String state;

	@NotNull
	private String phone;

	@NotNull
	private String atendimento;

}
