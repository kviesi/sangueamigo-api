package br.com.hemocentro.api.v1.command;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.hemocentro.api.v1.model.Hemocentro;
import br.com.hemocentro.api.v1.repository.HemocentroRepository;
import br.com.hemocentro.api.v1.request.ListRequest;

@Component
public class HemocentroList {

	@Autowired
	private HemocentroRepository hemocentroRepository;

	@Transactional(readOnly = true)
	public Iterable<Hemocentro> list(ListRequest listRequest) {
		return hemocentroRepository.findAll(new HemocentroFilterSpecification(listRequest));
	}

	private static class HemocentroFilterSpecification implements Specification<Hemocentro> {

		private final ListRequest listRequest;

		public HemocentroFilterSpecification(ListRequest listRequest) {
			this.listRequest = listRequest;
		}

		@Override
		public Predicate toPredicate(Root<Hemocentro> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {

			Predicate name = null;
			Predicate state = null;
			Predicate city = null;

			if (StringUtils.isNotEmpty(listRequest.getName())) {
				name = cb.equal(root.get(Hemocentro.FIELD_NAME), listRequest.getName());
			}

			if (StringUtils.isNotEmpty(listRequest.getState())) {
				state = cb.equal(root.get(Hemocentro.FIELD_STATE), listRequest.getState());
			}

			if (StringUtils.isNotEmpty(listRequest.getCity())) {
				city = cb.equal(root.get(Hemocentro.FIELD_CITY), listRequest.getCity());
			}

			return cb.and(name, state, city);
		}

	}

}
