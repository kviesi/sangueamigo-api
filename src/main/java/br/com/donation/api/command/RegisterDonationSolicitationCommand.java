package br.com.donation.api.command;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.donation.api.model.DonationSolicitation;
import br.com.donation.api.repository.DonationSolicitationRepository;
import br.com.donation.api.request.DonationSolicitationRequest;

@Component
@Validated
public class RegisterDonationSolicitationCommand {

	@Autowired
	private DonationSolicitationRepository donationSolicitationRepository;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void doSolicitation(@Valid DonationSolicitationRequest donationSolicitationRequest) {
		
		DonationSolicitation donationSolicitation = new DonationSolicitation();
		
		donationSolicitationRepository.save(donationSolicitation);
	}

}