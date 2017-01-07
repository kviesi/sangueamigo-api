package br.com.hemocentro.api.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sa_note")
public class Note {

	@Id
	private Long id;
	private String title;
	private String shortDescription;
	private String text;
	private LocalDate exibitionDate;
	private LocalDate createDate;
	private boolean active;

	@ManyToOne
	@JoinColumn(name = "hemocentro_id")
	private Hemocentro hemocentro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setHemocentro(Hemocentro hemocentro) {
		this.hemocentro = hemocentro;
	}

	public Hemocentro getHemocentro() {
		return hemocentro;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDate getExibitionDate() {
		return exibitionDate;
	}

	public void setExibitionDate(LocalDate exibitionDate) {
		this.exibitionDate = exibitionDate;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
