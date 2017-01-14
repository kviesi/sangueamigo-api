package br.com.user.api.command;

import java.util.Date;
import java.util.HashMap;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.auth0.jwt.JWTSigner;

import br.com.common.jwt.JwtFactory;
import br.com.user.api.model.User;
import br.com.user.api.repository.UserRepository;
import br.com.user.api.request.LoginRequest;

@Component
@Validated
public class UserLoginCommand {

	@Autowired
	private UserRepository userRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	public Optional<String> doLogin(@Valid LoginRequest loginRequest) {
		
		User user = userRepository.findByEmail(loginRequest.getEmail());

		if (user == null || !user.autenticate(loginRequest.getPassword())) {
			return Optional.empty();
		}

		HashMap<String, Object> claims = new HashMap<>();
		claims.put("userId", user.getId());
		claims.put("userEmail", user.getEmail());
		claims.put("userName", user.getName());
		claims.put("loginDate", new Date());

		JWTSigner jwtSigner = JwtFactory.getSignerInstance();
		String token = jwtSigner.sign(claims);

		return Optional.of(token);
	}

}
