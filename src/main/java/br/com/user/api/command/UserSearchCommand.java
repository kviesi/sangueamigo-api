package br.com.user.api.command;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.user.api.model.User;
import br.com.user.api.request.SearchRequest;

@Validated
@Service
public class UserSearchCommand {

	@HystrixCommand(fallbackMethod = "noUserFallback")
	public Iterable<User> search(@Valid SearchRequest searchRequest) {
		return new ArrayList<>();
	}

	public Iterable<User> noUserFallback(SearchRequest searchRequest) {
		return new ArrayList<>();
	}

}
