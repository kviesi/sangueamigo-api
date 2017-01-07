package br.com.hemocentro.api.v1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sm_hemocentro")
public class Hemocentro {
	
	/**
	 * Field Mapping
	 */
	public static final String FIELD_NAME = "name";
	public static final String FIELD_STATE = "state";
	public static final String FIELD_CITY = "city";
	public static final String FIELD_ID = "id";
	public static final String FIELD_ADRESS = "adress";
	public static final String FIELD_NUMBER = "number";
	public static final String FIELD_COMPLEMENT = "complement";

	@Id
	private Long id;
	private String name;
	private String city;
	private String state;
	private String adress;
	private String number;
	private String complement;

	private long plat;
	private long plong;

	@OneToMany
	private List<Estoque> estoques = new ArrayList<>();

	@OneToMany
	private List<Note> notes = new ArrayList<>();

	@OneToMany
	private List<Campanha> campanhas = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public List<Estoque> getEstoques() {
		return estoques;
	}

	public void setEstoques(List<Estoque> estoques) {
		this.estoques = estoques;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public List<Campanha> getCampanhas() {
		return campanhas;
	}

	public void setCampanhas(List<Campanha> campanhas) {
		this.campanhas = campanhas;
	}

}
