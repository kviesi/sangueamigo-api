package br.com.donation.api.command;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.donation.api.request.UserDonationRequest;
import br.com.hemocentro.api.model.Hemocentro;
import br.com.hemocentro.api.repository.HemocentroRepository;
import br.com.user.api.authentication.LoggedUser;
import br.com.user.api.authentication.LoggedUserProvider;

@Component
@Validated
public class RegisterUserDonationCommand {

	@Autowired
	private HemocentroRepository hemocentroRepository;

	@Autowired
	private LoggedUserProvider loggedUserProvider;

	@Transactional(propagation = Propagation.REQUIRED)
	public void donation(@Valid @NotNull UserDonationRequest userDonationRequest) {

		LoggedUser loggedUser = loggedUserProvider.getLoggedUser();

		Hemocentro hemocentro = hemocentroRepository.findOne(userDonationRequest.getHemocentroId());

		// campaign
		// create model
	}

}
