package br.com.common.validator;

import java.util.Collection;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final Collection<Violation> violations;

	public ValidationException(Collection<Violation> violations) {
		this.violations = violations;
	}

	public Collection<Violation> getViolations() {
		return violations;
	}

	@Override
	public String getMessage() {
		return "[Violations] " + violations;
	}

}
