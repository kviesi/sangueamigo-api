package br.com.donation.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.donation.api.request.DonationSolicitationRequest;

@RestController
public class DonationController {

	@RequestMapping(value = "/v1.0/donation")
	public ResponseEntity<?> registerDonation(@RequestBody DonationSolicitationRequest userDonationRequest) {
		return ResponseEntity.ok().build();
	}

	@RequestMapping(value = "/v1.0/donation/{solicitationId}/answer")
	public ResponseEntity<?> answerSolicitation(Long solicitationId) {
		return ResponseEntity.ok().build();
	}

}
