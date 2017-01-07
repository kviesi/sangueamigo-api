package br.com.hemocentro.api.v1.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.hemocentro.api.v1.model.Hemocentro;
import br.com.hemocentro.api.v1.repository.HemocentroRepository;

@Component
public class HemocentroFinder {

	@Autowired
	private HemocentroRepository hemocentroRepository;

	@Transactional(readOnly = true)
	public Hemocentro find(Long id) {
		return hemocentroRepository.findOne(id);
	}

}
