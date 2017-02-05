package br.com.donation.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.donation.api.model.AnswerDonationSolicitation;

@Repository
public interface AnswerDonationSolicitationRepository
		extends PagingAndSortingRepository<AnswerDonationSolicitation, Long> {

}
