package br.com.user.api.command;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.user.api.exception.UserAlreadyExistException;
import br.com.user.api.model.User;
import br.com.user.api.repository.UserRepository;
import br.com.user.api.request.CreateUserRequest;

@Component
@Validated
public class CreateUserCommand {

	@Autowired
	private UserRepository userRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	public void doCreate(@Valid CreateUserRequest createUserRequest) {

		User existentUser = userRepository.findByEmail(createUserRequest.getEmail());

		if (existentUser != null) {
			throw new UserAlreadyExistException();
		}

		User user = new User();
		user.setEmail(createUserRequest.getEmail());
		user.setName(createUserRequest.getName());
		user.setPassword(createUserRequest.getPassword());

		userRepository.save(user);

	}

}
