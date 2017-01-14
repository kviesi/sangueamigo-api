package br.com.user.api.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "sa_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String email;

	private String password;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar lastModified;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean autenticate(String password) {
		return this.password.equals(password);
	}

	@PrePersist
	public void updateDateCreated() {
		this.dateCreated = Calendar.getInstance();
	}

	public Calendar getDateCreated() {
		return dateCreated;
	}

	@PreUpdate
	public void updateLastModified() {
		this.lastModified = Calendar.getInstance();
	}

	public Calendar getLastModified() {
		return lastModified;
	}

}
