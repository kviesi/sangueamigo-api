package br.com.campaign.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.hemocentro.api.v1.model.Hemocentro;

@Entity
@Table(name = "sa_campanha")
public class Campaign {

	@Id
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar startDate;

	private int duration;

	private String text;

	@ManyToOne
	@JoinColumn(name = "hemocentro_id")
	private Hemocentro hemocentro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Hemocentro getHemocentro() {
		return hemocentro;
	}

	public void setHemocentro(Hemocentro hemocentro) {
		this.hemocentro = hemocentro;
	}

}
