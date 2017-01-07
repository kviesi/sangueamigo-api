package br.com.login.api.mail;

import java.util.HashMap;
import java.util.Map;

import br.com.common.jwt.JwtFactory;

public class ForgetPasswordToken {

	public static String generate(String email, long durationMilis) {
		HashMap<String, Object> claims = new HashMap<>();
		claims.put("email", email);
		claims.put("expires", System.currentTimeMillis() + durationMilis);
		return JwtFactory.getSignerInstance().sign(claims);
	}

	public static ForgetPasswordTokenContent from(String token) {
		
		try {
			
			Map<String, Object> map = JwtFactory.getVerifierInstance().verify(token);
			
			return new ForgetPasswordTokenContent(
					(String) map.get("email"), 
					(Long) map.get("expires"));
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static class ForgetPasswordTokenContent {

		private final String email;
		private final long expires;

		public ForgetPasswordTokenContent(String email, long expires) {
			this.email = email;
			this.expires = expires;
		}

		public String getEmail() {
			return email;
		}

		public boolean isExpired() {
			return System.currentTimeMillis() < expires;
		}
	}

}
