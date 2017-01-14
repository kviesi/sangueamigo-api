package br.com.hemocentro.api.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.hemocentro.api.model.Hemocentro;
import br.com.hemocentro.api.repository.HemocentroRepository;

@Component
public class HemocentroFinder {

	@Autowired
	private HemocentroRepository hemocentroRepository;

	@Transactional(readOnly = true)
	public Hemocentro find(Long id) {
		return hemocentroRepository.findOne(id);
	}

}
