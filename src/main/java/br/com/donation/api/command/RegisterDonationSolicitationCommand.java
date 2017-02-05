package br.com.donation.api.command;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.donation.api.model.DonationSolicitation;
import br.com.donation.api.model.Emergency;
import br.com.donation.api.model.Reason;
import br.com.donation.api.model.RequesterType;
import br.com.donation.api.repository.DonationSolicitationRepository;
import br.com.donation.api.request.DonationSolicitationRequest;
import br.com.user.api.authentication.LoggedUser;

@Component
@Validated
public class RegisterDonationSolicitationCommand {

	@Autowired
	private DonationSolicitationRepository donationSolicitationRepository;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void doSolicitation(
		@Valid DonationSolicitationRequest donationSolicitationRequest, 
		LoggedUser loggedUser) {
		
		DonationSolicitation donationSolicitation = new DonationSolicitation();
		donationSolicitation.setBloodType(donationSolicitationRequest.getBloodType());
		donationSolicitation.setDateLimit(donationSolicitationRequest.getDateLimit());
		donationSolicitation.setEmergency(Emergency.valueOf(donationSolicitationRequest.getEmergency()));
		donationSolicitation.setNumberBags(donationSolicitationRequest.getNumberBags());
		donationSolicitation.setReason(Reason.valueOf(donationSolicitationRequest.getReason()));
		donationSolicitation.setRecipientName(donationSolicitationRequest.getRecipientName());
		donationSolicitation.setRequesterId(loggedUser.getUserId());
		donationSolicitation.setRequesterType(RequesterType.valueOf(donationSolicitationRequest.getRequesterType()));
		
		donationSolicitationRepository.save(donationSolicitation);
	}

}