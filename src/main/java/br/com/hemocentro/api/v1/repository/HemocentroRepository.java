package br.com.hemocentro.api.v1.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.hemocentro.api.v1.model.Hemocentro;

@Repository
public interface HemocentroRepository extends PagingAndSortingRepository<Hemocentro, Long>, JpaSpecificationExecutor<Hemocentro>  {

}
