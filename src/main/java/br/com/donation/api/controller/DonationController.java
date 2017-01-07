package br.com.donation.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.donation.api.command.RegisterDonationCommand;
import br.com.donation.api.request.UserDonationRequest;

@RestController
public class DonationController {
	
	@Autowired
	private RegisterDonationCommand registerDonationCommand;

	@RequestMapping(value = "/v1.0/donation")
	public ResponseEntity<?> registerDonation(@RequestBody @Valid UserDonationRequest userDonationRequest) {

		registerDonationCommand.userDonation(userDonationRequest);
		
		return ResponseEntity.ok().build();
	}

}
