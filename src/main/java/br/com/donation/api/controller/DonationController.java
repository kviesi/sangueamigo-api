package br.com.donation.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.donation.api.command.RegisterDonationSolicitationCommand;
import br.com.donation.api.request.DonationSolicitationRequest;
import br.com.user.api.authentication.LoggedUser;

@RestController
public class DonationController {
	
	@Autowired
	private RegisterDonationSolicitationCommand donationSolicitationCommand;

	@RequestMapping(value = "/v1.0/donation")
	public ResponseEntity<?> registerDonation(
		@RequestBody DonationSolicitationRequest donationSolicitationRequest, 
		LoggedUser loggedUser) {
		
		donationSolicitationCommand.doSolicitation(donationSolicitationRequest, loggedUser);
		
		return ResponseEntity.ok().build();
	}

	@RequestMapping(value = "/v1.0/donation/{solicitationId}/answer")
	public ResponseEntity<?> answerSolicitation(
			Long solicitationId,
			LoggedUser loggedUser) {
		
		return ResponseEntity.ok().build();
	}

}
