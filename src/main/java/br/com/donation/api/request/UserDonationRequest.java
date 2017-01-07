package br.com.donation.api.request;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDonationRequest {

	@NotBlank
	private String userId;

	@NotNull
	@Future
	private LocalDate donationDate;

	@NotBlank
	private String location;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public LocalDate getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(LocalDate donationDate) {
		this.donationDate = donationDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
