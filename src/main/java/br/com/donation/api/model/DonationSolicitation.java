package br.com.donation.api.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.hemocentro.api.model.BloodType;

@Entity
@Table(name = "sa_don_solicitation")
public class DonationSolicitation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateLimit;

	@Enumerated(EnumType.STRING)
	private BloodType bloodType;

	private int numberBags;

	private String recipientName;

	private String requesterId;

	@Enumerated(EnumType.STRING)
	private RequesterType requesterType;

	@Enumerated(EnumType.STRING)
	private Reason reason;

	@Enumerated(EnumType.STRING)
	private Emergency emergency;

	public DonationSolicitation() {
		this.date = new Date();
	}

	public Long getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public Date getDateLimit() {
		return dateLimit;
	}

	public void setDateLimit(Date dateLimit) {
		this.dateLimit = dateLimit;
	}

	public BloodType getBloodType() {
		return bloodType;
	}

	public void setBloodType(BloodType bloodType) {
		this.bloodType = bloodType;
	}

	public int getNumberBags() {
		return numberBags;
	}

	public void setNumberBags(int numberBags) {
		this.numberBags = numberBags;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRequesterId() {
		return requesterId;
	}

	public void setRequesterId(String requesterId) {
		this.requesterId = requesterId;
	}

	public RequesterType getRequesterType() {
		return requesterType;
	}

	public void setRequesterType(RequesterType requesterType) {
		this.requesterType = requesterType;
	}

	public Reason getReason() {
		return reason;
	}

	public void setReason(Reason reason) {
		this.reason = reason;
	}

	public Emergency getEmergency() {
		return emergency;
	}

	public void setEmergency(Emergency emergency) {
		this.emergency = emergency;
	}

}
