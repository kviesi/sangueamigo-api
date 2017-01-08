package br.com.donation.api.request;

import java.util.Calendar;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDonationRequest {

	@NotBlank
	private String userId;

	@NotNull
	@Future
	private Calendar donationDate;

	@Min(1L)
	@NotNull
	private Long hemocentroId;

	@Min(1L)
	@NotNull
	private Long campaignId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setDonationDate(Calendar donationDate) {
		this.donationDate = donationDate;
	}

	public Calendar getDonationDate() {
		return donationDate;
	}

	public void setHemocentroId(Long hemocentroId) {
		this.hemocentroId = hemocentroId;
	}

	public Long getHemocentroId() {
		return hemocentroId;
	}

}
