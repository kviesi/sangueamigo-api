package br.com.hemocentro.api.v1.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import br.com.campaign.model.Campaign;
import br.com.note.model.Note;
import br.com.stock.model.Stock;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String city;
	private String state;
	private String adress;
	private String number;
	private String complement;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar modifiedDate;

	@Version
	private long version;

	private long plat;
	private long plong;

	@OneToMany
	private List<Stock> stocks = new ArrayList<>();

	@OneToMany
	private List<Note> notes = new ArrayList<>();

	@OneToMany
	private List<Campaign> campaign = new ArrayList<>();

	public Long getId() {
		return id;
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

	public long getPlong() {
		return plong;
	}

	public void setLocation(long plat, long plong) {
		this.plat = plat;
		this.plong = plat;
	}

	public List<Stock> getEstoques() {
		return Collections.unmodifiableList(stocks);
	}

	public void addStock(Stock stock) {
		this.stocks.add(stock);
	}

	public List<Note> getNotes() {
		return Collections.unmodifiableList(notes);
	}

	public void addNotes(Note notes) {
		this.notes.add(notes);
	}

	public List<Campaign> getCampanhas() {
		return Collections.unmodifiableList(campaign);
	}

	public void addCampaign(Campaign campaign) {
		this.campaign.add(campaign);
	}

	@PrePersist
	public void setCreatedDate() {
		this.createDate = Calendar.getInstance();
	}

	@PreUpdate
	public void setModifiedDate() {
		this.modifiedDate = Calendar.getInstance();
	}

}
