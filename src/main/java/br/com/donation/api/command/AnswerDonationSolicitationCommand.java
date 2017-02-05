package br.com.donation.api.command;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.donation.api.model.AnswerDonationSolicitation;
import br.com.donation.api.model.DonationSolicitation;
import br.com.donation.api.repository.AnswerDonationSolicitationRepository;
import br.com.donation.api.repository.DonationSolicitationRepository;
import br.com.donation.api.request.AnswerDonationSolicitationRequest;
import br.com.user.api.authentication.LoggedUser;
import br.com.user.api.model.User;
import br.com.user.api.repository.UserRepository;

@Component
@Validated
public class AnswerDonationSolicitationCommand {
	
	@Autowired
	private DonationSolicitationRepository donationSolicitationRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AnswerDonationSolicitationRepository answerDonationSolicitationRepository;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void doAnswer(
		@Valid AnswerDonationSolicitationRequest request,
		LoggedUser loggedUser) {

		DonationSolicitation donationSolicitation = donationSolicitationRepository.findOne(request.getSolicitationId());
		User user = userRepository.findOne(loggedUser.getUserId());
		
		AnswerDonationSolicitation answerDonationSolicitation = new AnswerDonationSolicitation();
		answerDonationSolicitation.setDonationSolicitation(donationSolicitation);
		answerDonationSolicitation.setUser(user);
		
		answerDonationSolicitationRepository.save(answerDonationSolicitation);
		
	}
	
}
