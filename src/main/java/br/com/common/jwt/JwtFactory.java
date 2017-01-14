package br.com.common.jwt;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;

public class JwtFactory {

	private static final String PRIVATE_KEY = "sa_jwt_122saikfhsajfho_989-13924-ISWFj";

	private static final JWTSigner JWT_S = new JWTSigner(PRIVATE_KEY);
	private static final JWTVerifier JWT_V = new JWTVerifier(PRIVATE_KEY);

	public static JWTSigner getSignerInstance() {
		return JWT_S;
	}

	public static JWTVerifier getVerifierInstance() {
		return JWT_V;
	}

	private JwtFactory() {
	}
}
