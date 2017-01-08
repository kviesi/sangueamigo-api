package br.com.donation.api.command;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.donation.api.request.UserDonationRequest;
import br.com.hemocentro.api.v1.model.Hemocentro;
import br.com.hemocentro.api.v1.repository.HemocentroRepository;
import br.com.user.model.User;
import br.com.user.repository.UserRepository;

@Service
@Validated
public class RegisterDonationCommand {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private HemocentroRepository hemocentroRepository;
	
	public void donation(@Valid @NotNull UserDonationRequest userDonationRequest) {

		User user = userRepository.findOne(userDonationRequest.getUserId());
		
		Hemocentro hemocentro = hemocentroRepository.findOne(userDonationRequest.getHemocentroId());
		
		//campaign
		
		//create model 

		//calculate points to user
		
	}

}
