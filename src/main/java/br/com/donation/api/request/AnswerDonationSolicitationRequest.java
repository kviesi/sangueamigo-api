package br.com.donation.api.request;

import javax.validation.constraints.Min;

public class AnswerDonationSolicitationRequest {

	@Min(1)
	private Long solicitationId;

	public void setSolicitationId(Long solicitationId) {
		this.solicitationId = solicitationId;
	}

	public Long getSolicitationId() {
		return solicitationId;
	}

}
