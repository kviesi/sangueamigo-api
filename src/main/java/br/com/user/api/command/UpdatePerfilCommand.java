package br.com.user.api.command;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.user.api.authentication.LoggedUser;
import br.com.user.api.exception.DuplicatedEmailException;
import br.com.user.api.exception.UserNotFoundException;
import br.com.user.api.model.User;
import br.com.user.api.repository.UserRepository;
import br.com.user.api.request.UpdatePerfilRequest;

@Validated
@Component
public class UpdatePerfilCommand {

	@Autowired
	private UserRepository userRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(
			@NotNull LoggedUser loggedUser,
			@Valid UpdatePerfilRequest updatePerfilRequest) throws DuplicatedEmailException, UserNotFoundException {

		User user = userRepository.findOne(loggedUser.getUserId());

		if (user == null) {
			throw new UserNotFoundException();
		}

		User byEmail = userRepository.findByEmail(updatePerfilRequest.getEmail());

		if (byEmail != null && !byEmail.getEmail().equals(user.getEmail())) {
			throw new DuplicatedEmailException();
		}

		user.setEmail(updatePerfilRequest.getEmail());
		user.setName(updatePerfilRequest.getEmail());
		user.setHomephone(updatePerfilRequest.getHomephone());
		user.setCellphone(updatePerfilRequest.getCellphone());

		userRepository.save(user);
	}

}
