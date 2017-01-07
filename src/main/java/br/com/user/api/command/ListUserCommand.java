package br.com.user.api.command;

import java.util.ArrayList;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import br.com.user.api.model.User;
import br.com.user.api.repository.UserRepository;
import br.com.user.api.request.FilterRequest;

@Component
@Validated
public class ListUserCommand {

	@Autowired
	private UserRepository userRepository;

	public Iterable<User> doFind(@NotNull FilterRequest filterRequest) {
		// return userRepository.findAll(userSpecificationOf(filterRequest));
		return new ArrayList<>();
	}

	// private Specification userSpecificationOf(FilterRequest filterRequest) {
	// UserSpecification userSpecification = UserSpecification.getInstance();
	// userSpecification.setEmail(filterRequest.getEmail());
	// userSpecification.setName(filterRequest.getName());
	// userSpecification.setActive(filterRequest.isActive() ? true : false);
	// return userSpecification;
	// }
}
