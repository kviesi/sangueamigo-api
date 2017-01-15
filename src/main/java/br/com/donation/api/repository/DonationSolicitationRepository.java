package br.com.donation.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.donation.api.model.DonationSolicitation;

@Repository
public interface DonationSolicitationRepository extends PagingAndSortingRepository<DonationSolicitation, Long> {

}
