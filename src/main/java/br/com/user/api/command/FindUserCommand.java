package br.com.user.api.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.user.api.model.User;
import br.com.user.api.repository.UserRepository;

@Component
public class FindUserCommand {

	@Autowired
	private UserRepository userRepository;

	@HystrixCommand(fallbackMethod = "findInCache")
	public User findUser(String userId) {
		// return userRepository.findOne(userId);
		return null;
	}

	public User findInCache(String userId) {
		return new User();
	}

}
