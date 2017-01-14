package br.com.hemocentro.api.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.hemocentro.api.model.Hemocentro;

@Repository
public interface HemocentroRepository extends PagingAndSortingRepository<Hemocentro, Long>, JpaSpecificationExecutor<Hemocentro>  {

}
