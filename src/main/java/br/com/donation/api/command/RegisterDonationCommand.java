package br.com.donation.api.command;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.donation.api.request.UserDonationRequest;
import br.com.user.api.repository.UserRepository;

@Service
@Validated
public class RegisterDonationCommand {

	@Autowired
	private UserRepository userRepository;

	@HystrixCommand(threadPoolKey = "REG_DON_C")
	public void userDonation(@Valid @NotNull UserDonationRequest userDonationRequest) {

		// UserSpecification userSpecification = new UserSpecification();
		// userSpecification.setId(userDonationRequest.getUserId());

		// if (!userRepository.exist(userSpecification)) {
		// // user not exist
		// }

	}

}
