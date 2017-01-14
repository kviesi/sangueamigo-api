package br.com.hemocentro.api.command;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import br.com.hemocentro.api.model.Hemocentro;
import br.com.hemocentro.api.repository.HemocentroRepository;
import br.com.hemocentro.api.request.ListRequest;

@Component
public class HemocentroList {

	@Autowired
	private HemocentroRepository hemocentroRepository;

	@Transactional(readOnly = true)
	public Iterable<Hemocentro> list(ListRequest listRequest) {
		Assert.notNull(listRequest);

		PageRequest pageRequest = pageRequest(listRequest);

		if (listRequest.isEmptyFilters()) {
			return hemocentroRepository.findAll(pageRequest);
		}

		return hemocentroRepository.findAll(new HemocentroFilterSpecification(listRequest), pageRequest);
	}
	
	private PageRequest pageRequest(ListRequest listRequest) {
		return new PageRequest(listRequest.getActualPage(), listRequest.getPageSize());
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

			return cb.and(name, city, state);
		}

	}

}
