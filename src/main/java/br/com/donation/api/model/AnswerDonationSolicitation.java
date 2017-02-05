package br.com.donation.api.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.user.api.model.User;

@Entity
@Table(name = "sa_answer_don_solicitation")
public class AnswerDonationSolicitation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "donation_solicitation_id")
	private DonationSolicitation donationSolicitation;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	public AnswerDonationSolicitation() {
		this.date = new Date();
	}

	public Long getId() {
		return id;
	}

	public DonationSolicitation getDonationSolicitation() {
		return donationSolicitation;
	}

	public void setDonationSolicitation(DonationSolicitation donationSolicitation) {
		this.donationSolicitation = donationSolicitation;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

}
